package com.tencent.mm.plugin.collect.model.voice;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class b
{
  float dU;
  MMHandler mHandler;
  private boolean mIsInit;
  String mText;
  float mVolume;
  c wZH;
  private a wZI;
  private Thread wZJ;
  SynthesizerNative wZK;
  boolean wZL;
  int wZM;
  byte[] wZN;
  
  public b()
  {
    AppMethodBeat.i(63887);
    this.wZI = new a((byte)0);
    this.wZJ = null;
    this.wZK = new SynthesizerNative();
    this.mIsInit = false;
    this.wZL = false;
    this.wZM = 256000;
    this.wZN = new byte[this.wZM];
    this.mVolume = 1.0F;
    this.dU = 1.0F;
    this.mHandler = new MMHandler("InnerSynthesizer")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(63885);
        if (b.this.wZH != null) {
          switch (paramAnonymousMessage.what)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(63885);
          return;
          paramAnonymousMessage = paramAnonymousMessage.getData().getByteArray("data");
          b.this.wZH.p(0, paramAnonymousMessage);
          AppMethodBeat.o(63885);
          return;
          b.this.wZH.p(-203, null);
        }
      }
    };
    AppMethodBeat.o(63887);
  }
  
  public final int ami(String paramString)
  {
    AppMethodBeat.i(63889);
    if (!this.mIsInit)
    {
      Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
      AppMethodBeat.o(63889);
      return -202;
    }
    if ((this.wZJ != null) && (this.wZJ.isAlive()))
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
    if (!e.isInstalled())
    {
      Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:TTS_EXPANSIONS_ERROR");
      AppMethodBeat.o(63889);
      return -102;
    }
    this.mText = paramString;
    this.wZL = false;
    this.wZJ = new Thread(this.wZI);
    this.wZJ.start();
    AppMethodBeat.o(63889);
    return 0;
  }
  
  /* Error */
  public final void destroy()
  {
    // Byte code:
    //   0: ldc 123
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_1
    //   7: putfield 58	com/tencent/mm/plugin/collect/model/voice/b:wZL	Z
    //   10: aload_0
    //   11: getfield 49	com/tencent/mm/plugin/collect/model/voice/b:wZJ	Ljava/lang/Thread;
    //   14: ifnull +10 -> 24
    //   17: aload_0
    //   18: getfield 49	com/tencent/mm/plugin/collect/model/voice/b:wZJ	Ljava/lang/Thread;
    //   21: invokevirtual 126	java/lang/Thread:join	()V
    //   24: invokestatic 109	com/tencent/mm/plugin/expansions/e:isInstalled	()Z
    //   27: ifeq +10 -> 37
    //   30: aload_0
    //   31: getfield 54	com/tencent/mm/plugin/collect/model/voice/b:wZK	Lcom/tencent/mm/plugin/collect/model/voice/SynthesizerNative;
    //   34: invokevirtual 129	com/tencent/mm/plugin/collect/model/voice/SynthesizerNative:release	()V
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 56	com/tencent/mm/plugin/collect/model/voice/b:mIsInit	Z
    //   42: ldc 123
    //   44: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: astore_1
    //   49: ldc 83
    //   51: ldc 131
    //   53: iconst_2
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: invokevirtual 135	java/lang/Object:getClass	()Ljava/lang/Class;
    //   63: invokevirtual 141	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_1
    //   70: invokevirtual 144	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: goto -53 -> 24
    //   80: astore_1
    //   81: ldc 83
    //   83: ldc 149
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: aload_1
    //   92: invokevirtual 135	java/lang/Object:getClass	()Ljava/lang/Class;
    //   95: invokevirtual 141	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: aload_1
    //   102: invokevirtual 152	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   105: aastore
    //   106: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -72 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	b
    //   48	22	1	localInterruptedException	java.lang.InterruptedException
    //   80	22	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	48	java/lang/InterruptedException
    //   24	37	80	finally
  }
  
  public final int gr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63888);
    if (this.mIsInit)
    {
      AppMethodBeat.o(63888);
      return 0;
    }
    paramString1 = paramString1 + paramString2 + ".pos";
    Log.d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", new Object[] { paramString1, null });
    if (!y.ZC(paramString1))
    {
      Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_RESOURCE_ERROR ");
      AppMethodBeat.o(63888);
      return -101;
    }
    if (!e.isInstalled())
    {
      Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_SO_ERROR ");
      AppMethodBeat.o(63888);
      return -103;
    }
    for (;;)
    {
      try
      {
        if (!Util.isNullOrNil(null))
        {
          if (!y.ZC(null))
          {
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed: file not exist - ErrorCode.TTS_SO_ERROR ");
            AppMethodBeat.o(63888);
            return -103;
          }
          System.load(null);
        }
      }
      finally
      {
        int i;
        Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", new Object[] { paramString1.getClass().getSimpleName(), paramString1.getMessage() });
        AppMethodBeat.o(63888);
        return -207;
      }
      try
      {
        Util.isNullOrNil(paramString2);
        i = this.wZK.init(paramString1.getBytes());
        Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init ret：%s", new Object[] { Integer.valueOf(i) });
        if (i >= 0) {
          break label248;
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
      e.tryLoadLibrary("readMoney");
    }
    label248:
    this.mIsInit = true;
    AppMethodBeat.o(63888);
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
        Log.d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", new Object[] { b.this.mText, Float.valueOf(b.this.mVolume), Float.valueOf(b.this.dU) });
        int i = b.this.wZK.readmoney(b.this.mText.getBytes("UTF-8"), b.this.wZN, b.this.wZM, b.this.mVolume, b.this.dU);
        if (i != -1)
        {
          byte[] arrayOfByte = new byte[i];
          System.arraycopy(b.this.wZN, 0, arrayOfByte, 0, i);
          if (!b.this.wZL)
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