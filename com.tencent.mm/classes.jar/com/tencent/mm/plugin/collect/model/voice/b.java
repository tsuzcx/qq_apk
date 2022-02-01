package com.tencent.mm.plugin.collect.model.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class b
{
  float MU;
  @SuppressLint({"HandlerLeak"})
  aq mHandler;
  private boolean mIsInit;
  String mText;
  float mVolume;
  c pia;
  private a pib;
  private Thread pic;
  SynthesizerNative pie;
  boolean pif;
  int pig;
  byte[] pih;
  
  public b()
  {
    AppMethodBeat.i(63887);
    this.pib = new a((byte)0);
    this.pic = null;
    this.pie = new SynthesizerNative();
    this.mIsInit = false;
    this.pif = false;
    this.pig = 256000;
    this.pih = new byte[this.pig];
    this.mVolume = 1.0F;
    this.MU = 1.0F;
    this.mHandler = new aq("InnerSynthesizer")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(63885);
        if (b.this.pia != null) {
          switch (paramAnonymousMessage.what)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(63885);
          return;
          paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("data");
          b.this.pia.o(0, paramAnonymousMessage);
          AppMethodBeat.o(63885);
          return;
          b.this.pia.o(-203, null);
        }
      }
    };
    AppMethodBeat.o(63887);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63890);
    this.pif = true;
    if (this.pic != null) {}
    try
    {
      this.pic.join();
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        for (;;)
        {
          this.pie.release();
          this.mIsInit = false;
          AppMethodBeat.o(63890);
          return;
          localInterruptedException = localInterruptedException;
          ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "stop() Exception:%s %s", new Object[] { localInterruptedException.getClass().getSimpleName(), localInterruptedException.getMessage() });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        }
      }
    }
  }
  
  public final int fn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63888);
    if (this.mIsInit)
    {
      AppMethodBeat.o(63888);
      return 0;
    }
    paramString1 = paramString1 + paramString2 + ".pos";
    ae.d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", new Object[] { paramString1, null });
    if (!o.fB(paramString1))
    {
      ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_RESOURCE_ERROR ");
      AppMethodBeat.o(63888);
      return -101;
    }
    a.cof();
    for (;;)
    {
      try
      {
        if (!bu.isNullOrNil(null))
        {
          if (!o.fB(null))
          {
            ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed: file not exist - ErrorCode.TTS_SO_ERROR ");
            AppMethodBeat.o(63888);
            return -103;
          }
          System.load(null);
        }
      }
      catch (Throwable paramString1)
      {
        int i;
        ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        AppMethodBeat.o(63888);
        return -207;
      }
      try
      {
        bu.isNullOrNil(paramString2);
        i = this.pie.init(paramString1.getBytes());
        ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init ret：%s", new Object[] { Integer.valueOf(i) });
        if (i >= 0) {
          break label231;
        }
        AppMethodBeat.o(63888);
        return i;
      }
      catch (Exception paramString1)
      {
        ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_INIT_ERROR ");
        AppMethodBeat.o(63888);
        return -201;
      }
      a.adR("readMoney");
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
      ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((this.pic != null) && (this.pic.isAlive()))
    {
      ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((paramString == null) || (paramString.length() > 1024))
    {
      ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:TTS_TEXT_ERROR");
      AppMethodBeat.o(63889);
      return -102;
    }
    this.mText = paramString;
    this.pif = false;
    this.pic = new Thread(this.pib);
    this.pic.start();
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
        ae.d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", new Object[] { b.this.mText, Float.valueOf(b.this.mVolume), Float.valueOf(b.this.MU) });
        int i = b.this.pie.readmoney(b.this.mText.getBytes("UTF-8"), b.this.pih, b.this.pig, b.this.mVolume, b.this.MU);
        if (i != -1)
        {
          byte[] arrayOfByte = new byte[i];
          System.arraycopy(b.this.pih, 0, arrayOfByte, 0, i);
          if (!b.this.pif)
          {
            Message localMessage = b.this.mHandler.obtainMessage(0);
            Bundle localBundle = new Bundle();
            localBundle.putByteArray("data", arrayOfByte);
            localMessage.setData(localBundle);
            b.this.mHandler.sendMessage(localMessage);
            ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "Synthesizer run success");
          }
          AppMethodBeat.o(63886);
          return;
        }
        ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "Synthesizer run fail");
        b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
        AppMethodBeat.o(63886);
        return;
      }
      catch (Exception localException)
      {
        ae.i("MicroMsg.OfflineVoice.InnerSynthesizer", "SynthesizerRunnable Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
        AppMethodBeat.o(63886);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.b
 * JD-Core Version:    0.7.0.1
 */