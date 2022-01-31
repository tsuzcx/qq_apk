package com.tencent.mm.plugin.collect.model.voice;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class b
{
  float Dq;
  c kOs;
  private b.a kOt;
  private Thread kOu;
  SynthesizerNative kOv;
  boolean kOw;
  int kOx;
  byte[] kOy;
  @SuppressLint({"HandlerLeak"})
  Handler mHandler;
  private boolean mIsInit;
  String mText;
  float mVolume;
  
  public b()
  {
    AppMethodBeat.i(41027);
    this.kOt = new b.a(this, (byte)0);
    this.kOu = null;
    this.kOv = new SynthesizerNative();
    this.mIsInit = false;
    this.kOw = false;
    this.kOx = 256000;
    this.kOy = new byte[this.kOx];
    this.mVolume = 1.0F;
    this.Dq = 1.0F;
    this.mHandler = new b.1(this);
    AppMethodBeat.o(41027);
  }
  
  public final int dC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141989);
    if (this.mIsInit)
    {
      AppMethodBeat.o(141989);
      return 0;
    }
    String str = paramString1 + paramString2 + ".pos";
    ab.d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", new Object[] { str, null });
    if (!e.cN(str))
    {
      AppMethodBeat.o(141989);
      return -101;
    }
    for (;;)
    {
      try
      {
        if (!bo.isNullOrNil(null))
        {
          boolean bool = e.cN(null);
          if (!bool)
          {
            AppMethodBeat.o(141989);
            return -103;
          }
          System.load(null);
          str = paramString2;
        }
      }
      catch (Throwable paramString1)
      {
        int i;
        ab.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        AppMethodBeat.o(141989);
        return -207;
      }
      try
      {
        if (bo.isNullOrNil(paramString2)) {
          str = "woman_putonghua";
        }
        i = this.kOv.init(paramString1.getBytes(), str.getBytes());
        if (i >= 0) {
          break label208;
        }
        AppMethodBeat.o(141989);
        return i;
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(141989);
        return -201;
      }
      System.loadLibrary("readMoney");
    }
    label208:
    this.mIsInit = true;
    AppMethodBeat.o(141989);
    return 0;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(41030);
    this.kOw = true;
    if (this.kOu != null) {}
    try
    {
      this.kOu.join();
      this.kOv.release();
      this.mIsInit = false;
      AppMethodBeat.o(41030);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ab.i("MicroMsg.OfflineVoice.InnerSynthesizer", "stop() Exception:%s %s", new Object[] { localInterruptedException.getClass().getSimpleName(), localInterruptedException.getMessage() });
      }
    }
  }
  
  public final int start(String paramString)
  {
    AppMethodBeat.i(41029);
    if (!this.mIsInit)
    {
      AppMethodBeat.o(41029);
      return -202;
    }
    if ((this.kOu != null) && (this.kOu.isAlive()))
    {
      AppMethodBeat.o(41029);
      return -202;
    }
    if ((paramString == null) || (paramString.length() > 1024))
    {
      AppMethodBeat.o(41029);
      return -102;
    }
    this.mText = paramString;
    this.kOw = false;
    this.kOu = new Thread(this.kOt);
    this.kOu.start();
    AppMethodBeat.o(41029);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.b
 * JD-Core Version:    0.7.0.1
 */