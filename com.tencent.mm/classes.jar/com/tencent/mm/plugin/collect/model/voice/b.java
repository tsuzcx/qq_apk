package com.tencent.mm.plugin.collect.model.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class b
{
  float Ne;
  @SuppressLint({"HandlerLeak"})
  MMHandler mHandler;
  private boolean mIsInit;
  String mText;
  float mVolume;
  c qxn;
  private a qxo;
  private Thread qxp;
  SynthesizerNative qxq;
  boolean qxr;
  int qxs;
  byte[] qxt;
  
  public b()
  {
    AppMethodBeat.i(63887);
    this.qxo = new a((byte)0);
    this.qxp = null;
    this.qxq = new SynthesizerNative();
    this.mIsInit = false;
    this.qxr = false;
    this.qxs = 256000;
    this.qxt = new byte[this.qxs];
    this.mVolume = 1.0F;
    this.Ne = 1.0F;
    this.mHandler = new MMHandler("InnerSynthesizer")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(63885);
        if (b.this.qxn != null) {
          switch (paramAnonymousMessage.what)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(63885);
          return;
          paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("data");
          b.this.qxn.o(0, paramAnonymousMessage);
          AppMethodBeat.o(63885);
          return;
          b.this.qxn.o(-203, null);
        }
      }
    };
    AppMethodBeat.o(63887);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63890);
    this.qxr = true;
    if (this.qxp != null) {}
    try
    {
      this.qxp.join();
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        for (;;)
        {
          this.qxq.release();
          this.mIsInit = false;
          AppMethodBeat.o(63890);
          return;
          localInterruptedException = localInterruptedException;
          Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "stop() Exception:%s %s", new Object[] { localInterruptedException.getClass().getSimpleName(), localInterruptedException.getMessage() });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        }
      }
    }
  }
  
  public final int fE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63888);
    if (this.mIsInit)
    {
      AppMethodBeat.o(63888);
      return 0;
    }
    paramString1 = paramString1 + paramString2 + ".pos";
    Log.d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", new Object[] { paramString1, null });
    if (!s.YS(paramString1))
    {
      Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_RESOURCE_ERROR ");
      AppMethodBeat.o(63888);
      return -101;
    }
    a.cMr();
    for (;;)
    {
      try
      {
        if (!Util.isNullOrNil(null))
        {
          if (!s.YS(null))
          {
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed: file not exist - ErrorCode.TTS_SO_ERROR ");
            AppMethodBeat.o(63888);
            return -103;
          }
          System.load(null);
        }
      }
      catch (Throwable paramString1)
      {
        int i;
        Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        AppMethodBeat.o(63888);
        return -207;
      }
      try
      {
        Util.isNullOrNil(paramString2);
        i = this.qxq.init(paramString1.getBytes());
        Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init ret：%s", new Object[] { Integer.valueOf(i) });
        if (i >= 0) {
          break label231;
        }
        AppMethodBeat.o(63888);
        return i;
      }
      catch (Exception paramString1)
      {
        Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_INIT_ERROR ");
        AppMethodBeat.o(63888);
        return -201;
      }
      a.aoa("readMoney");
    }
    label231:
    this.mIsInit = true;
    AppMethodBeat.o(63888);
    return 0;
  }
  
  public final int start(String paramString)
  {
    AppMethodBeat.i(63889);
    if (!this.mIsInit)
    {
      Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((this.qxp != null) && (this.qxp.isAlive()))
    {
      Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((paramString == null) || (paramString.length() > 1024))
    {
      Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:TTS_TEXT_ERROR");
      AppMethodBeat.o(63889);
      return -102;
    }
    this.mText = paramString;
    this.qxr = false;
    this.qxp = new Thread(this.qxo);
    this.qxp.start();
    AppMethodBeat.o(63889);
    return 0;
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(63886);
      try
      {
        b.this.mText = b.this.mText.replaceAll("[^0-9a-zA-Z一-龥.?!,;:。？！，、；：@%&/]+", "");
        Log.d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", new Object[] { b.this.mText, Float.valueOf(b.this.mVolume), Float.valueOf(b.this.Ne) });
        int i = b.this.qxq.readmoney(b.this.mText.getBytes("UTF-8"), b.this.qxt, b.this.qxs, b.this.mVolume, b.this.Ne);
        if (i != -1)
        {
          byte[] arrayOfByte = new byte[i];
          System.arraycopy(b.this.qxt, 0, arrayOfByte, 0, i);
          if (!b.this.qxr)
          {
            Message localMessage = b.this.mHandler.obtainMessage(0);
            Bundle localBundle = new Bundle();
            localBundle.putByteArray("data", arrayOfByte);
            localMessage.setData(localBundle);
            b.this.mHandler.sendMessage(localMessage);
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "Synthesizer run success");
          }
          AppMethodBeat.o(63886);
          return;
        }
        Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "Synthesizer run fail");
        b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
        AppMethodBeat.o(63886);
        return;
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "SynthesizerRunnable Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
        AppMethodBeat.o(63886);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.b
 * JD-Core Version:    0.7.0.1
 */