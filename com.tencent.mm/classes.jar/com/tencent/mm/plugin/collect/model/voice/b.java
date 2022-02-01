package com.tencent.mm.plugin.collect.model.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class b
{
  float MU;
  @SuppressLint({"HandlerLeak"})
  ap mHandler;
  private boolean mIsInit;
  String mText;
  float mVolume;
  boolean pbA;
  int pbB;
  byte[] pbC;
  c pbw;
  private a pbx;
  private Thread pby;
  SynthesizerNative pbz;
  
  public b()
  {
    AppMethodBeat.i(63887);
    this.pbx = new a((byte)0);
    this.pby = null;
    this.pbz = new SynthesizerNative();
    this.mIsInit = false;
    this.pbA = false;
    this.pbB = 256000;
    this.pbC = new byte[this.pbB];
    this.mVolume = 1.0F;
    this.MU = 1.0F;
    this.mHandler = new ap("InnerSynthesizer")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(63885);
        if (b.this.pbw != null) {
          switch (paramAnonymousMessage.what)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(63885);
          return;
          paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("data");
          b.this.pbw.o(0, paramAnonymousMessage);
          AppMethodBeat.o(63885);
          return;
          b.this.pbw.o(-203, null);
        }
      }
    };
    AppMethodBeat.o(63887);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63890);
    this.pbA = true;
    if (this.pby != null) {}
    try
    {
      this.pby.join();
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        for (;;)
        {
          this.pbz.release();
          this.mIsInit = false;
          AppMethodBeat.o(63890);
          return;
          localInterruptedException = localInterruptedException;
          ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "stop() Exception:%s %s", new Object[] { localInterruptedException.getClass().getSimpleName(), localInterruptedException.getMessage() });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        }
      }
    }
  }
  
  public final int fj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63888);
    if (this.mIsInit)
    {
      AppMethodBeat.o(63888);
      return 0;
    }
    paramString1 = paramString1 + paramString2 + ".pos";
    ad.d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", new Object[] { paramString1, null });
    if (!i.fv(paramString1))
    {
      ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_RESOURCE_ERROR ");
      AppMethodBeat.o(63888);
      return -101;
    }
    a.cmP();
    for (;;)
    {
      try
      {
        if (!bt.isNullOrNil(null))
        {
          if (!i.fv(null))
          {
            ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed: file not exist - ErrorCode.TTS_SO_ERROR ");
            AppMethodBeat.o(63888);
            return -103;
          }
          System.load(null);
        }
      }
      catch (Throwable paramString1)
      {
        int i;
        ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        AppMethodBeat.o(63888);
        return -207;
      }
      try
      {
        bt.isNullOrNil(paramString2);
        i = this.pbz.init(paramString1.getBytes());
        ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init ret：%s", new Object[] { Integer.valueOf(i) });
        if (i >= 0) {
          break label231;
        }
        AppMethodBeat.o(63888);
        return i;
      }
      catch (Exception paramString1)
      {
        ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_INIT_ERROR ");
        AppMethodBeat.o(63888);
        return -201;
      }
      a.ada("readMoney");
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
      ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((this.pby != null) && (this.pby.isAlive()))
    {
      ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((paramString == null) || (paramString.length() > 1024))
    {
      ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:TTS_TEXT_ERROR");
      AppMethodBeat.o(63889);
      return -102;
    }
    this.mText = paramString;
    this.pbA = false;
    this.pby = new Thread(this.pbx);
    this.pby.start();
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
        ad.d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", new Object[] { b.this.mText, Float.valueOf(b.this.mVolume), Float.valueOf(b.this.MU) });
        int i = b.this.pbz.readmoney(b.this.mText.getBytes("UTF-8"), b.this.pbC, b.this.pbB, b.this.mVolume, b.this.MU);
        if (i != -1)
        {
          byte[] arrayOfByte = new byte[i];
          System.arraycopy(b.this.pbC, 0, arrayOfByte, 0, i);
          if (!b.this.pbA)
          {
            Message localMessage = b.this.mHandler.obtainMessage(0);
            Bundle localBundle = new Bundle();
            localBundle.putByteArray("data", arrayOfByte);
            localMessage.setData(localBundle);
            b.this.mHandler.sendMessage(localMessage);
            ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "Synthesizer run success");
          }
          AppMethodBeat.o(63886);
          return;
        }
        ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "Synthesizer run fail");
        b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
        AppMethodBeat.o(63886);
        return;
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.OfflineVoice.InnerSynthesizer", "SynthesizerRunnable Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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