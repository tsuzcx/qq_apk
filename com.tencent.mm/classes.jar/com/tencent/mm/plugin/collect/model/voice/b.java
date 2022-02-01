package com.tencent.mm.plugin.collect.model.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class b
{
  float Lc;
  @SuppressLint({"HandlerLeak"})
  ao mHandler;
  private boolean mIsInit;
  String mText;
  float mVolume;
  c oyb;
  private a oyc;
  private Thread oyd;
  SynthesizerNative oye;
  boolean oyf;
  int oyg;
  byte[] oyh;
  
  public b()
  {
    AppMethodBeat.i(63887);
    this.oyc = new a((byte)0);
    this.oyd = null;
    this.oye = new SynthesizerNative();
    this.mIsInit = false;
    this.oyf = false;
    this.oyg = 256000;
    this.oyh = new byte[this.oyg];
    this.mVolume = 1.0F;
    this.Lc = 1.0F;
    this.mHandler = new ao("InnerSynthesizer")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(63885);
        if (b.this.oyb != null) {
          switch (paramAnonymousMessage.what)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(63885);
          return;
          paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("data");
          b.this.oyb.o(0, paramAnonymousMessage);
          AppMethodBeat.o(63885);
          return;
          b.this.oyb.o(-203, null);
        }
      }
    };
    AppMethodBeat.o(63887);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(63890);
    this.oyf = true;
    if (this.oyd != null) {}
    try
    {
      this.oyd.join();
    }
    catch (InterruptedException localInterruptedException)
    {
      try
      {
        for (;;)
        {
          this.oye.release();
          this.mIsInit = false;
          AppMethodBeat.o(63890);
          return;
          localInterruptedException = localInterruptedException;
          ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "stop() Exception:%s %s", new Object[] { localInterruptedException.getClass().getSimpleName(), localInterruptedException.getMessage() });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "destroy() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        }
      }
    }
  }
  
  public final int eZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63888);
    if (this.mIsInit)
    {
      AppMethodBeat.o(63888);
      return 0;
    }
    paramString1 = paramString1 + paramString2 + ".pos";
    ac.d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", new Object[] { paramString1, null });
    if (!i.eA(paramString1))
    {
      ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_RESOURCE_ERROR ");
      AppMethodBeat.o(63888);
      return -101;
    }
    a.cil();
    for (;;)
    {
      try
      {
        if (!bs.isNullOrNil(null))
        {
          if (!i.eA(null))
          {
            ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed: file not exist - ErrorCode.TTS_SO_ERROR ");
            AppMethodBeat.o(63888);
            return -103;
          }
          System.load(null);
        }
      }
      catch (Throwable paramString1)
      {
        int i;
        ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        AppMethodBeat.o(63888);
        return -207;
      }
      try
      {
        bs.isNullOrNil(paramString2);
        i = this.oye.init(paramString1.getBytes());
        ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init ret：%s", new Object[] { Integer.valueOf(i) });
        if (i >= 0) {
          break label231;
        }
        AppMethodBeat.o(63888);
        return i;
      }
      catch (Exception paramString1)
      {
        ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_INIT_ERROR ");
        AppMethodBeat.o(63888);
        return -201;
      }
      a.Zu("readMoney");
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
      ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((this.oyd != null) && (this.oyd.isAlive()))
    {
      ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((paramString == null) || (paramString.length() > 1024))
    {
      ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:TTS_TEXT_ERROR");
      AppMethodBeat.o(63889);
      return -102;
    }
    this.mText = paramString;
    this.oyf = false;
    this.oyd = new Thread(this.oyc);
    this.oyd.start();
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
        ac.d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", new Object[] { b.this.mText, Float.valueOf(b.this.mVolume), Float.valueOf(b.this.Lc) });
        int i = b.this.oye.readmoney(b.this.mText.getBytes("UTF-8"), b.this.oyh, b.this.oyg, b.this.mVolume, b.this.Lc);
        if (i != -1)
        {
          byte[] arrayOfByte = new byte[i];
          System.arraycopy(b.this.oyh, 0, arrayOfByte, 0, i);
          if (!b.this.oyf)
          {
            Message localMessage = b.this.mHandler.obtainMessage(0);
            Bundle localBundle = new Bundle();
            localBundle.putByteArray("data", arrayOfByte);
            localMessage.setData(localBundle);
            b.this.mHandler.sendMessage(localMessage);
          }
          AppMethodBeat.o(63886);
          return;
        }
        b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
        AppMethodBeat.o(63886);
        return;
      }
      catch (Exception localException)
      {
        ac.i("MicroMsg.OfflineVoice.InnerSynthesizer", "SynthesizerRunnable Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
        AppMethodBeat.o(63886);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.voice.b
 * JD-Core Version:    0.7.0.1
 */