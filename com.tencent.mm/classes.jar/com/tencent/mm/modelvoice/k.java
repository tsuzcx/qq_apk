package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.InputStream;

public final class k
  implements d
{
  private static Object mkj;
  private static int mkk;
  private static int mkl;
  private static int mks;
  public int fso;
  private AudioTrack mAudioTrack;
  private String mFileName;
  public int mSampleRate;
  private volatile int mStatus;
  private a mkb;
  private com.tencent.mm.compatible.util.b mkc;
  private d.a mkd;
  private d.b mke;
  private int mkf;
  private volatile boolean mkg;
  private String mkh;
  private String mki;
  private int mkm;
  private int mkn;
  private com.tencent.mm.audio.e.b mko;
  private com.tencent.mm.audio.c.a.a mkp;
  private int mkq;
  private boolean mkr;
  private h mkt;
  private MediaPlayer.OnCompletionListener mku;
  private MediaPlayer.OnErrorListener mkv;
  
  static
  {
    AppMethodBeat.i(130069);
    mkj = new Object();
    mkk = -1;
    mks = 100;
    AppMethodBeat.o(130069);
  }
  
  public k()
  {
    AppMethodBeat.i(130050);
    this.mkd = null;
    this.mke = null;
    this.fso = 2;
    this.mSampleRate = 16000;
    this.mFileName = "";
    this.mStatus = 0;
    this.mkf = 0;
    this.mkg = false;
    this.mkh = "";
    this.mki = "";
    this.mkn = 0;
    this.mko = null;
    this.mkq = 8;
    this.mkr = true;
    this.mku = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130046);
        if ((k.a(k.this) != null) && (k.b(k.this)))
        {
          Log.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
          k.a(k.this).avz();
        }
        try
        {
          k.a(k.this, 0);
          k.this.brs();
          AppMethodBeat.o(130046);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(paramAnonymousMediaPlayer) });
          Log.e("MicroMsg.SilkPlayer", "setCompletion File[" + k.c(k.this) + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          AppMethodBeat.o(130046);
        }
      }
    };
    this.mkv = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130047);
        Log.i("MicroMsg.SilkPlayer", "onError");
        if ((k.a(k.this) != null) && (k.b(k.this))) {
          k.a(k.this).avz();
        }
        if (k.d(k.this) != null) {
          k.d(k.this).onError();
        }
        try
        {
          k.a(k.this, -1);
          k.this.brs();
          AppMethodBeat.o(130047);
          return false;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            Log.e("MicroMsg.SilkPlayer", "setErrorListener File[" + k.c(k.this) + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          }
        }
      }
    };
    mkk += 1;
    this.mkm = mkk;
    Log.i("MicroMsg.SilkPlayer", "[%d] new Instance", new Object[] { Integer.valueOf(this.mkm) });
    AppMethodBeat.o(130050);
  }
  
  public k(Context paramContext)
  {
    this();
    AppMethodBeat.i(130051);
    this.mkc = new com.tencent.mm.compatible.util.b(paramContext);
    AppMethodBeat.o(130051);
  }
  
  private void Yx(String paramString)
  {
    AppMethodBeat.i(130057);
    mkl = this.mkm;
    Log.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", new Object[] { Integer.valueOf(this.mkm) });
    for (;;)
    {
      try
      {
        paramString = u.Tf(paramString);
        j = paramString.available();
        Log.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", new Object[] { Integer.valueOf(j) });
        k = AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2);
        if ((!com.tencent.mm.plugin.audio.c.a.cro()) || (j >= k * 2)) {
          continue;
        }
        this.mkq = 1;
        Object localObject = new byte[j];
        paramString.read((byte[])localObject, 0, j);
        int i = localObject[0];
        long l = MediaRecorder.mjJ;
        this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[] { i }, l);
        if (this.mkt != null) {
          Log.i("MicroMsg.SilkPlayer", "silkdec uninit success: %d".concat(String.valueOf(MediaRecorder.SilkDecUnInit(this.mkt.decodeHandle))));
        }
        this.mkt = new h(this.mSampleRate, (byte[])localObject, j);
        j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vPU, -1);
        if ((1 == j) || (j == 0))
        {
          i = (byte)j;
          localObject = this.mkt;
          j = mks;
          l = ((h)localObject).decodeHandle;
          MediaRecorder.SetVoiceSilkDecControl(j, new byte[] { i }, 1, l);
        }
        paramString.close();
      }
      catch (Exception paramString)
      {
        int j;
        int k;
        short s;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(161L, 1L, 1L, false);
        Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        continue;
        j += 1;
        continue;
        AppMethodBeat.o(130057);
      }
      Log.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", new Object[] { Integer.valueOf(this.mkm), Integer.valueOf(this.mkn) });
      paramString = new byte[AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2];
      s = (short)(this.mSampleRate * 20 / 1000);
      j = 0;
      if (j >= this.mkn) {
        continue;
      }
      if (this.mkt == null) {
        continue;
      }
      k = this.mkt.a(paramString, s);
      if (k > 0) {
        continue;
      }
      Log.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", new Object[] { Integer.valueOf(this.mkm), Integer.valueOf(k) });
      AppMethodBeat.o(130057);
      return;
      this.mkq = 8;
    }
  }
  
  private static boolean Yy(String paramString)
  {
    AppMethodBeat.i(130067);
    if (paramString == null)
    {
      AppMethodBeat.o(130067);
      return false;
    }
    label153:
    for (;;)
    {
      try
      {
        int i = paramString.lastIndexOf("/");
        if (i == -1)
        {
          Log.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
          AppMethodBeat.o(130067);
          return false;
        }
        paramString = paramString.substring(0, i + 1);
        q localq = new q(paramString);
        if (!localq.ifE())
        {
          if (localq.ifL()) {
            break label153;
          }
          if (localq.isDirectory())
          {
            break label153;
            Log.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", new Object[] { paramString, Boolean.valueOf(bool) });
          }
        }
        else
        {
          AppMethodBeat.o(130067);
          return true;
        }
        boolean bool = false;
        continue;
        bool = true;
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(130067);
        return false;
      }
    }
  }
  
  private boolean Z(String paramString, boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(130056);
    if (this.mStatus != 0)
    {
      Log.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
      AppMethodBeat.o(130056);
      return false;
    }
    if (ac.mGs) {
      bG(paramString, g.fsQ);
    }
    Log.i("MicroMsg.SilkPlayer", "startPlay");
    this.mStatus = 1;
    this.mFileName = paramString;
    for (;;)
    {
      int i;
      synchronized (mkj)
      {
        Yx(paramString);
        if (ac.mGs)
        {
          paramString = g.fsP;
          if (this.fso == 2)
          {
            i = 1;
            this.mko = new com.tencent.mm.audio.e.b(paramString, i, this.mSampleRate);
          }
        }
        else
        {
          int k = this.mSampleRate;
          i = j;
          if (this.fso == 2) {
            i = 1;
          }
          Log.d("MicroMsg.SilkPlayer", "startPlay, sampleRate: %d, channelCnt: %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        }
      }
      try
      {
        paramBoolean = gG(paramBoolean);
        AppMethodBeat.o(130056);
        return paramBoolean;
        paramString = finally;
        AppMethodBeat.o(130056);
        throw paramString;
        i = 2;
      }
      catch (Exception paramString)
      {
        try
        {
          paramBoolean = gG(true);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
          Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          this.mStatus = -1;
          AppMethodBeat.o(130056);
        }
      }
    }
    return false;
  }
  
  /* Error */
  private String a(String paramString, h paramh)
  {
    // Byte code:
    //   0: ldc_w 381
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 118
    //   8: ldc_w 383
    //   11: invokestatic 385	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 88	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   18: invokestatic 388	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   21: ifne +30 -> 51
    //   24: ldc 118
    //   26: ldc_w 390
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 88	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   39: aastore
    //   40: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: ldc_w 381
    //   46: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: ldc 118
    //   53: ldc_w 392
    //   56: invokestatic 385	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: bipush 240
    //   61: invokestatic 397	android/os/Process:setThreadPriority	(I)V
    //   64: aload_0
    //   65: getfield 84	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   68: iconst_2
    //   69: iconst_2
    //   70: invokestatic 172	android/media/AudioTrack:getMinBufferSize	(III)I
    //   73: iconst_1
    //   74: ishl
    //   75: newarray byte
    //   77: astore 6
    //   79: aload_0
    //   80: getfield 84	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   83: bipush 20
    //   85: imul
    //   86: sipush 1000
    //   89: idiv
    //   90: i2s
    //   91: istore_3
    //   92: aload_1
    //   93: invokestatic 399	com/tencent/mm/modelvoice/k:Yy	(Ljava/lang/String;)Z
    //   96: pop
    //   97: aload_1
    //   98: invokestatic 403	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   101: astore 5
    //   103: aload_0
    //   104: getfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   107: iconst_1
    //   108: if_icmpeq +11 -> 119
    //   111: aload_0
    //   112: getfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   115: iconst_2
    //   116: if_icmpne +138 -> 254
    //   119: aload_2
    //   120: aload 6
    //   122: iload_3
    //   123: invokevirtual 249	com/tencent/mm/modelvoice/h:a	([BS)I
    //   126: istore 4
    //   128: iload 4
    //   130: ifge +79 -> 209
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   138: goto -35 -> 103
    //   141: astore_1
    //   142: ldc 118
    //   144: new 324	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 405
    //   151: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload_1
    //   155: invokevirtual 318	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 336	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: ldc 118
    //   169: ldc_w 268
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_1
    //   179: invokestatic 274	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload_0
    //   187: iconst_0
    //   188: putfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   191: aload 5
    //   193: ifnull +8 -> 201
    //   196: aload 5
    //   198: invokevirtual 408	java/io/OutputStream:close	()V
    //   201: ldc_w 381
    //   204: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aconst_null
    //   208: areturn
    //   209: aload_0
    //   210: getfield 94	com/tencent/mm/modelvoice/k:mkg	Z
    //   213: ifeq +12 -> 225
    //   216: ldc2_w 409
    //   219: invokestatic 416	java/lang/Thread:sleep	(J)V
    //   222: goto -13 -> 209
    //   225: aload 5
    //   227: aload 6
    //   229: iconst_0
    //   230: iload_3
    //   231: iconst_2
    //   232: imul
    //   233: invokevirtual 420	java/io/OutputStream:write	([BII)V
    //   236: aload 5
    //   238: invokevirtual 423	java/io/OutputStream:flush	()V
    //   241: iload 4
    //   243: ifne -140 -> 103
    //   246: aload_0
    //   247: iconst_0
    //   248: putfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   251: goto -148 -> 103
    //   254: ldc 118
    //   256: ldc_w 425
    //   259: invokestatic 385	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 5
    //   264: invokevirtual 408	java/io/OutputStream:close	()V
    //   267: aload_2
    //   268: getfield 201	com/tencent/mm/modelvoice/h:decodeHandle	J
    //   271: invokestatic 205	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	(J)I
    //   274: istore 4
    //   276: ldc 118
    //   278: ldc_w 427
    //   281: iconst_1
    //   282: anewarray 4	java/lang/Object
    //   285: dup
    //   286: iconst_0
    //   287: aload_0
    //   288: getfield 116	com/tencent/mm/modelvoice/k:mkm	I
    //   291: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   294: aastore
    //   295: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: iload 4
    //   300: ifeq +19 -> 319
    //   303: ldc 118
    //   305: ldc_w 429
    //   308: iload 4
    //   310: invokestatic 210	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   313: invokevirtual 214	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   316: invokestatic 336	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: ldc_w 381
    //   322: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   325: aload_1
    //   326: areturn
    //   327: astore_1
    //   328: ldc 118
    //   330: aload_1
    //   331: ldc 86
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: goto -139 -> 201
    //   343: astore_1
    //   344: ldc 118
    //   346: new 324	java/lang/StringBuilder
    //   349: dup
    //   350: ldc_w 435
    //   353: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   356: aload_1
    //   357: invokevirtual 318	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   360: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 336	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: ldc 118
    //   371: ldc_w 268
    //   374: iconst_1
    //   375: anewarray 4	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_1
    //   381: invokestatic 274	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   384: aastore
    //   385: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: ldc_w 381
    //   391: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aconst_null
    //   395: areturn
    //   396: astore_1
    //   397: aconst_null
    //   398: astore 5
    //   400: goto -258 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	k
    //   0	403	1	paramString	String
    //   0	403	2	paramh	h
    //   91	142	3	s	short
    //   126	183	4	i	int
    //   101	298	5	localOutputStream	java.io.OutputStream
    //   77	151	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   103	119	141	java/lang/Exception
    //   119	128	141	java/lang/Exception
    //   133	138	141	java/lang/Exception
    //   209	222	141	java/lang/Exception
    //   225	241	141	java/lang/Exception
    //   246	251	141	java/lang/Exception
    //   254	267	141	java/lang/Exception
    //   196	201	327	java/io/IOException
    //   142	191	343	java/lang/Exception
    //   196	201	343	java/lang/Exception
    //   267	298	343	java/lang/Exception
    //   303	319	343	java/lang/Exception
    //   328	340	343	java/lang/Exception
    //   51	103	396	java/lang/Exception
  }
  
  private boolean brt()
  {
    AppMethodBeat.i(130059);
    if (this.mAudioTrack != null) {
      try
      {
        Log.i("MicroMsg.SilkPlayer", "play");
        this.mAudioTrack.play();
        this.mkb = new a((byte)0);
        com.tencent.e.h.ZvG.be(this.mkb);
        AppMethodBeat.o(130059);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(161L, 3L, 1L, false);
        AppMethodBeat.o(130059);
        return false;
      }
    }
    AppMethodBeat.o(130059);
    return false;
  }
  
  private void gF(boolean paramBoolean)
  {
    AppMethodBeat.i(130053);
    if (this.mAudioTrack != null) {
      Log.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
    }
    try
    {
      brs();
      this.mAudioTrack = null;
      this.mAudioTrack = com.tencent.mm.audio.c.a.a(paramBoolean, this.mSampleRate, this.fso, this.mkq);
      this.mkp = new com.tencent.mm.audio.c.a.a();
      if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() == 0))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(161L, 2L, 1L, false);
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (this.mAudioTrack != null)
          {
            this.mAudioTrack.release();
            this.mAudioTrack = null;
          }
          AppMethodBeat.o(130053);
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        Log.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", new Object[] { localException1.getMessage() });
      }
      AppMethodBeat.o(130053);
    }
  }
  
  private boolean gG(boolean paramBoolean)
  {
    AppMethodBeat.i(130058);
    if (!u.agG(this.mFileName))
    {
      AppMethodBeat.o(130058);
      return false;
    }
    try
    {
      gF(paramBoolean);
      if (this.mAudioTrack != null)
      {
        if ((this.mkc != null) && (this.mkr)) {
          this.mkc.avy();
        }
        paramBoolean = brt();
        AppMethodBeat.o(130058);
        return paramBoolean;
      }
    }
    catch (Exception localException)
    {
      if ((this.mkc != null) && (this.mkr)) {
        this.mkc.avz();
      }
      Log.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + localException.getMessage());
      Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(130058);
    }
    return false;
  }
  
  /* Error */
  public final boolean TV()
  {
    // Byte code:
    //   0: ldc_w 540
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 118
    //   8: new 324	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 542
    //   15: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   22: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 217	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   35: iconst_1
    //   36: if_icmpeq +44 -> 80
    //   39: aload_0
    //   40: getfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   43: iconst_2
    //   44: if_icmpeq +36 -> 80
    //   47: ldc 118
    //   49: new 324	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 544
    //   56: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   63: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 336	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc_w 540
    //   75: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: iconst_3
    //   82: putfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   85: aload_0
    //   86: getfield 96	com/tencent/mm/modelvoice/k:mkh	Ljava/lang/String;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 96	com/tencent/mm/modelvoice/k:mkh	Ljava/lang/String;
    //   96: invokevirtual 547	java/lang/Object:notifyAll	()V
    //   99: aload_0
    //   100: getfield 140	com/tencent/mm/modelvoice/k:mkc	Lcom/tencent/mm/compatible/util/b;
    //   103: ifnull +18 -> 121
    //   106: aload_0
    //   107: getfield 106	com/tencent/mm/modelvoice/k:mkr	Z
    //   110: ifeq +11 -> 121
    //   113: aload_0
    //   114: getfield 140	com/tencent/mm/modelvoice/k:mkc	Lcom/tencent/mm/compatible/util/b;
    //   117: invokevirtual 517	com/tencent/mm/compatible/util/b:avz	()Z
    //   120: pop
    //   121: aload_1
    //   122: monitorexit
    //   123: ldc_w 540
    //   126: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_2
    //   132: ldc 118
    //   134: ldc_w 268
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_2
    //   144: invokestatic 274	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 140	com/tencent/mm/modelvoice/k:mkc	Lcom/tencent/mm/compatible/util/b;
    //   155: ifnull +18 -> 173
    //   158: aload_0
    //   159: getfield 106	com/tencent/mm/modelvoice/k:mkr	Z
    //   162: ifeq +11 -> 173
    //   165: aload_0
    //   166: getfield 140	com/tencent/mm/modelvoice/k:mkc	Lcom/tencent/mm/compatible/util/b;
    //   169: invokevirtual 517	com/tencent/mm/compatible/util/b:avz	()Z
    //   172: pop
    //   173: aload_1
    //   174: monitorexit
    //   175: ldc_w 540
    //   178: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_2
    //   184: aload_0
    //   185: getfield 140	com/tencent/mm/modelvoice/k:mkc	Lcom/tencent/mm/compatible/util/b;
    //   188: ifnull +18 -> 206
    //   191: aload_0
    //   192: getfield 106	com/tencent/mm/modelvoice/k:mkr	Z
    //   195: ifeq +11 -> 206
    //   198: aload_0
    //   199: getfield 140	com/tencent/mm/modelvoice/k:mkc	Lcom/tencent/mm/compatible/util/b;
    //   202: invokevirtual 517	com/tencent/mm/compatible/util/b:avz	()Z
    //   205: pop
    //   206: ldc_w 540
    //   209: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: aload_1
    //   216: monitorexit
    //   217: ldc_w 540
    //   220: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_2
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	k
    //   89	127	1	str	String
    //   131	13	2	localException	Exception
    //   183	30	2	localObject1	Object
    //   214	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   92	99	131	java/lang/Exception
    //   92	99	183	finally
    //   132	151	183	finally
    //   99	121	214	finally
    //   121	123	214	finally
    //   151	173	214	finally
    //   173	175	214	finally
    //   184	206	214	finally
    //   206	214	214	finally
  }
  
  public final void a(d.a parama)
  {
    this.mkd = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.mke = paramb;
  }
  
  public final double aeI()
  {
    return 0.0D;
  }
  
  /* Error */
  public final String bG(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 552
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   10: ifeq +36 -> 46
    //   13: ldc 118
    //   15: new 324	java/lang/StringBuilder
    //   18: dup
    //   19: ldc_w 326
    //   22: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   29: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: invokevirtual 334	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 336	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 552
    //   41: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   51: aload_0
    //   52: aload_1
    //   53: putfield 88	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   56: aload_1
    //   57: invokestatic 155	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 161	java/io/InputStream:available	()I
    //   65: istore 4
    //   67: iload 4
    //   69: newarray byte
    //   71: astore 7
    //   73: aload_1
    //   74: aload 7
    //   76: iconst_0
    //   77: iload 4
    //   79: invokevirtual 182	java/io/InputStream:read	([BII)I
    //   82: pop
    //   83: aload 7
    //   85: iconst_0
    //   86: baload
    //   87: istore_3
    //   88: getstatic 188	com/tencent/mm/modelvoice/MediaRecorder:mjJ	J
    //   91: lstore 5
    //   93: aload_0
    //   94: iconst_1
    //   95: newarray byte
    //   97: dup
    //   98: iconst_0
    //   99: iload_3
    //   100: bastore
    //   101: lload 5
    //   103: invokestatic 192	com/tencent/mm/modelvoice/MediaRecorder:SilkGetEncSampleRate	([BJ)I
    //   106: putfield 84	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   109: new 198	com/tencent/mm/modelvoice/h
    //   112: dup
    //   113: aload_0
    //   114: getfield 84	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   117: aload 7
    //   119: iload 4
    //   121: invokespecial 220	com/tencent/mm/modelvoice/h:<init>	(I[BI)V
    //   124: astore 7
    //   126: ldc 118
    //   128: ldc_w 554
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: getfield 116	com/tencent/mm/modelvoice/k:mkm	I
    //   141: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_1
    //   149: invokevirtual 244	java/io/InputStream:close	()V
    //   152: aload_0
    //   153: aload_2
    //   154: aload 7
    //   156: invokespecial 556	com/tencent/mm/modelvoice/k:a	(Ljava/lang/String;Lcom/tencent/mm/modelvoice/h;)Ljava/lang/String;
    //   159: astore_2
    //   160: ldc_w 552
    //   163: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_2
    //   167: areturn
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: ldc 118
    //   173: ldc_w 558
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_0
    //   183: getfield 88	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: aload_2
    //   190: invokevirtual 318	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 118
    //   199: ldc_w 268
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_2
    //   209: invokestatic 274	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_0
    //   217: iconst_m1
    //   218: putfield 90	com/tencent/mm/modelvoice/k:mStatus	I
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 244	java/io/InputStream:close	()V
    //   229: ldc_w 552
    //   232: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: ldc 118
    //   240: aload_1
    //   241: ldc 86
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: goto -21 -> 229
    //   253: astore_2
    //   254: goto -83 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	k
    //   0	257	1	paramString1	String
    //   0	257	2	paramString2	String
    //   87	13	3	i	int
    //   65	55	4	j	int
    //   91	11	5	l	long
    //   71	84	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	61	168	java/lang/Exception
    //   225	229	237	java/io/IOException
    //   61	83	253	java/lang/Exception
    //   88	160	253	java/lang/Exception
  }
  
  public final void bro()
  {
    this.mkr = false;
  }
  
  public final void brs()
  {
    AppMethodBeat.i(195654);
    if (this.mAudioTrack != null)
    {
      Log.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
    com.tencent.mm.audio.c.a.a locala;
    String str;
    if (this.mkp != null)
    {
      locala = this.mkp;
      str = this.mFileName;
      if (this.mAudioTrack == null) {
        break label110;
      }
    }
    label110:
    for (int i = this.mAudioTrack.getStreamType();; i = 0)
    {
      locala.b(0, str, i);
      this.mkp.kH(0);
      this.mkp.kI(0);
      this.mkp.kG(0);
      AppMethodBeat.o(195654);
      return;
    }
  }
  
  public final void c(com.tencent.mm.compatible.util.b.a parama)
  {
    AppMethodBeat.i(130064);
    if ((parama != null) && (this.mkc != null)) {
      this.mkc.a(parama);
    }
    AppMethodBeat.o(130064);
  }
  
  public final boolean d(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(130055);
    paramBoolean = Z(paramString, paramBoolean);
    AppMethodBeat.o(130055);
    return paramBoolean;
  }
  
  public final boolean dA(boolean paramBoolean)
  {
    AppMethodBeat.i(130061);
    if (this.mStatus != 1)
    {
      AppMethodBeat.o(130061);
      return false;
    }
    this.mStatus = 2;
    synchronized (this.mki)
    {
      try
      {
        Log.i("MicroMsg.SilkPlayer", "before mOk.wait");
        long l = System.currentTimeMillis();
        this.mki.wait(1000L);
        Log.i("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - l));
        if ((this.mkc != null) && (paramBoolean)) {
          this.mkc.avz();
        }
        AppMethodBeat.o(130061);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(130061);
        return false;
      }
    }
  }
  
  public final void dr(boolean paramBoolean)
  {
    AppMethodBeat.i(130052);
    Log.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mkg = true;
    this.fso = 2;
    gF(paramBoolean);
    try
    {
      this.mAudioTrack.play();
      this.mkg = false;
      AppMethodBeat.o(130052);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(161L, 3L, 1L, false);
        Log.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(195713);
    boolean bool1;
    a locala;
    if (this.mStatus == 1)
    {
      bool1 = true;
      locala = this.mkb;
      if ((this.mkb != null) && (!this.mkb.isDone())) {
        break label116;
      }
    }
    label116:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.SilkPlayer", "isPlaying %s and mPlayRunnable is %s && mPlayRunnable is done %s", new Object[] { Boolean.valueOf(bool1), locala, Boolean.valueOf(bool2) });
      if ((this.mStatus != 1) && ((this.mStatus == 1) || (this.mkb == null) || (this.mkb.isDone()))) {
        break label121;
      }
      AppMethodBeat.o(195713);
      return true;
      bool1 = false;
      break;
    }
    label121:
    AppMethodBeat.o(195713);
    return false;
  }
  
  public final boolean resume()
  {
    AppMethodBeat.i(130062);
    if (this.mStatus != 2)
    {
      AppMethodBeat.o(130062);
      return false;
    }
    this.mStatus = 1;
    synchronized (this.mkh)
    {
      try
      {
        Log.i("MicroMsg.SilkPlayer", "before mpause.notify");
        this.mkh.notifyAll();
        Log.i("MicroMsg.SilkPlayer", "after mpause.notify");
        if ((this.mkc != null) && (this.mkr)) {
          this.mkc.avy();
        }
        AppMethodBeat.o(130062);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        AppMethodBeat.o(130062);
        return false;
      }
    }
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    private a() {}
    
    public final String getKey()
    {
      AppMethodBeat.i(196628);
      String str = "SilkPlayer_play_" + k.g(k.this);
      AppMethodBeat.o(196628);
      return str;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 54
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: bipush 240
      //   7: invokestatic 59	android/os/Process:setThreadPriority	(I)V
      //   10: aload_0
      //   11: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   14: invokestatic 62	com/tencent/mm/modelvoice/k:e	(Lcom/tencent/mm/modelvoice/k;)I
      //   17: iconst_2
      //   18: iconst_2
      //   19: invokestatic 68	android/media/AudioTrack:getMinBufferSize	(III)I
      //   22: iconst_2
      //   23: imul
      //   24: istore_2
      //   25: iload_2
      //   26: newarray byte
      //   28: astore_3
      //   29: aload_0
      //   30: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   33: invokestatic 62	com/tencent/mm/modelvoice/k:e	(Lcom/tencent/mm/modelvoice/k;)I
      //   36: bipush 20
      //   38: imul
      //   39: sipush 1000
      //   42: idiv
      //   43: i2s
      //   44: istore_1
      //   45: ldc 70
      //   47: ldc 72
      //   49: iconst_2
      //   50: anewarray 74	java/lang/Object
      //   53: dup
      //   54: iconst_0
      //   55: iload_1
      //   56: invokestatic 80	java/lang/Short:valueOf	(S)Ljava/lang/Short;
      //   59: aastore
      //   60: dup
      //   61: iconst_1
      //   62: iload_2
      //   63: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   66: aastore
      //   67: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   70: ldc 70
      //   72: ldc 93
      //   74: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   77: aload_0
      //   78: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   81: invokestatic 99	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   84: iconst_1
      //   85: if_icmpeq +14 -> 99
      //   88: aload_0
      //   89: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   92: invokestatic 99	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   95: iconst_2
      //   96: if_icmpne +972 -> 1068
      //   99: invokestatic 103	com/tencent/mm/modelvoice/k:access$700	()Ljava/lang/Object;
      //   102: astore 4
      //   104: aload 4
      //   106: monitorenter
      //   107: invokestatic 107	com/tencent/mm/modelvoice/k:bru	()I
      //   110: aload_0
      //   111: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   114: invokestatic 40	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   117: if_icmpeq +83 -> 200
      //   120: ldc 70
      //   122: ldc 109
      //   124: iconst_2
      //   125: anewarray 74	java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: aload_0
      //   131: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   134: invokestatic 40	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   137: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   140: aastore
      //   141: dup
      //   142: iconst_1
      //   143: invokestatic 107	com/tencent/mm/modelvoice/k:bru	()I
      //   146: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   149: aastore
      //   150: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   153: aload_0
      //   154: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   157: invokestatic 114	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
      //   160: pop
      //   161: aload_0
      //   162: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   165: invokestatic 116	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   168: iconst_3
      //   169: if_icmple +17 -> 186
      //   172: getstatic 122	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   175: ldc2_w 123
      //   178: ldc2_w 125
      //   181: lconst_1
      //   182: iconst_0
      //   183: invokevirtual 130	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   186: aload_0
      //   187: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   190: aload_0
      //   191: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   194: invokestatic 134	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   197: invokestatic 137	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;Ljava/lang/String;)V
      //   200: aload 4
      //   202: monitorexit
      //   203: aload_0
      //   204: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   207: invokestatic 141	com/tencent/mm/modelvoice/k:j	(Lcom/tencent/mm/modelvoice/k;)Z
      //   210: ifeq +239 -> 449
      //   213: ldc 70
      //   215: ldc 143
      //   217: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   220: ldc2_w 146
      //   223: invokestatic 153	java/lang/Thread:sleep	(J)V
      //   226: goto -23 -> 203
      //   229: astore_3
      //   230: getstatic 122	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   233: ldc2_w 123
      //   236: lconst_0
      //   237: lconst_1
      //   238: iconst_0
      //   239: invokevirtual 130	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   242: ldc 70
      //   244: ldc 155
      //   246: iconst_1
      //   247: anewarray 74	java/lang/Object
      //   250: dup
      //   251: iconst_0
      //   252: aload_3
      //   253: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   256: aastore
      //   257: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   260: aload_0
      //   261: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   264: invokestatic 167	com/tencent/mm/modelvoice/k:r	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnErrorListener;
      //   267: ifnull +19 -> 286
      //   270: aload_0
      //   271: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   274: invokestatic 167	com/tencent/mm/modelvoice/k:r	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnErrorListener;
      //   277: aconst_null
      //   278: iconst_0
      //   279: iconst_0
      //   280: invokeinterface 173 4 0
      //   285: pop
      //   286: aload_0
      //   287: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   290: iconst_0
      //   291: invokestatic 176	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   294: pop
      //   295: invokestatic 103	com/tencent/mm/modelvoice/k:access$700	()Ljava/lang/Object;
      //   298: astore_3
      //   299: aload_3
      //   300: monitorenter
      //   301: invokestatic 107	com/tencent/mm/modelvoice/k:bru	()I
      //   304: aload_0
      //   305: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   308: invokestatic 40	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   311: if_icmpne +63 -> 374
      //   314: aload_0
      //   315: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   318: invokestatic 180	com/tencent/mm/modelvoice/k:k	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   321: ifnull +53 -> 374
      //   324: aload_0
      //   325: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   328: invokestatic 180	com/tencent/mm/modelvoice/k:k	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   331: getfield 186	com/tencent/mm/modelvoice/h:decodeHandle	J
      //   334: invokestatic 192	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	(J)I
      //   337: pop
      //   338: ldc 70
      //   340: ldc 194
      //   342: iconst_1
      //   343: anewarray 74	java/lang/Object
      //   346: dup
      //   347: iconst_0
      //   348: aload_0
      //   349: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   352: invokestatic 40	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   355: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   358: aastore
      //   359: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   362: invokestatic 197	com/tencent/mm/modelvoice/k:brv	()I
      //   365: pop
      //   366: aload_0
      //   367: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   370: invokestatic 200	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)I
      //   373: pop
      //   374: aload_3
      //   375: monitorexit
      //   376: aload_0
      //   377: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   380: invokestatic 99	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   383: iconst_3
      //   384: if_icmpeq +730 -> 1114
      //   387: aload_0
      //   388: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   391: invokestatic 204	com/tencent/mm/modelvoice/k:t	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/d$a;
      //   394: ifnull +15 -> 409
      //   397: aload_0
      //   398: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   401: invokestatic 204	com/tencent/mm/modelvoice/k:t	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/d$a;
      //   404: invokeinterface 209 1 0
      //   409: aload_0
      //   410: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   413: invokestatic 213	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnCompletionListener;
      //   416: ifnull +749 -> 1165
      //   419: aload_0
      //   420: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   423: invokestatic 213	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnCompletionListener;
      //   426: aconst_null
      //   427: invokeinterface 218 2 0
      //   432: ldc 54
      //   434: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   437: return
      //   438: astore_3
      //   439: aload 4
      //   441: monitorexit
      //   442: ldc 54
      //   444: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   447: aload_3
      //   448: athrow
      //   449: aload_0
      //   450: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   453: invokestatic 180	com/tencent/mm/modelvoice/k:k	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   456: ifnull +137 -> 593
      //   459: aload_0
      //   460: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   463: invokestatic 222	com/tencent/mm/modelvoice/k:l	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   466: ifnull +15 -> 481
      //   469: aload_0
      //   470: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   473: invokestatic 222	com/tencent/mm/modelvoice/k:l	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   476: iload_1
      //   477: aload_3
      //   478: invokevirtual 227	com/tencent/mm/audio/c/a/a:e	(I[B)V
      //   481: aload_0
      //   482: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   485: invokestatic 180	com/tencent/mm/modelvoice/k:k	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   488: aload_3
      //   489: iload_1
      //   490: invokevirtual 230	com/tencent/mm/modelvoice/h:a	([BS)I
      //   493: istore_2
      //   494: iload_2
      //   495: ifge +160 -> 655
      //   498: aload_0
      //   499: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   502: iconst_0
      //   503: invokestatic 176	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   506: pop
      //   507: getstatic 122	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   510: ldc2_w 123
      //   513: lconst_0
      //   514: lconst_1
      //   515: iconst_0
      //   516: invokevirtual 130	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   519: getstatic 122	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   522: ldc2_w 123
      //   525: ldc2_w 231
      //   528: lconst_1
      //   529: iconst_0
      //   530: invokevirtual 130	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   533: ldc 70
      //   535: ldc 234
      //   537: iconst_2
      //   538: anewarray 74	java/lang/Object
      //   541: dup
      //   542: iconst_0
      //   543: aload_0
      //   544: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   547: invokestatic 40	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   550: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   553: aastore
      //   554: dup
      //   555: iconst_1
      //   556: iload_2
      //   557: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   560: aastore
      //   561: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   564: aload_0
      //   565: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   568: invokestatic 238	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   571: ifnull -494 -> 77
      //   574: getstatic 244	com/tencent/mm/platformtools/ac:mGs	Z
      //   577: ifeq -500 -> 77
      //   580: aload_0
      //   581: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   584: invokestatic 238	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   587: invokevirtual 249	com/tencent/mm/audio/e/b:closeFile	()V
      //   590: goto -513 -> 77
      //   593: aload_0
      //   594: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   597: iconst_0
      //   598: invokestatic 176	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   601: pop
      //   602: ldc 70
      //   604: ldc 251
      //   606: iconst_1
      //   607: anewarray 74	java/lang/Object
      //   610: dup
      //   611: iconst_0
      //   612: aload_0
      //   613: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   616: invokestatic 40	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   619: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   622: aastore
      //   623: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   626: aload_0
      //   627: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   630: invokestatic 238	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   633: ifnull -556 -> 77
      //   636: getstatic 244	com/tencent/mm/platformtools/ac:mGs	Z
      //   639: ifeq -562 -> 77
      //   642: aload_0
      //   643: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   646: invokestatic 238	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   649: invokevirtual 249	com/tencent/mm/audio/e/b:closeFile	()V
      //   652: goto -575 -> 77
      //   655: getstatic 244	com/tencent/mm/platformtools/ac:mGs	Z
      //   658: ifeq +28 -> 686
      //   661: aload_0
      //   662: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   665: invokestatic 238	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   668: ifnull +18 -> 686
      //   671: aload_0
      //   672: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   675: invokestatic 238	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   678: aload_3
      //   679: iload_1
      //   680: iconst_2
      //   681: imul
      //   682: invokevirtual 255	com/tencent/mm/audio/e/b:A	([BI)Z
      //   685: pop
      //   686: aload_0
      //   687: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   690: invokestatic 259	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   693: aload_3
      //   694: iconst_0
      //   695: iload_1
      //   696: iconst_2
      //   697: imul
      //   698: invokevirtual 263	android/media/AudioTrack:write	([BII)I
      //   701: pop
      //   702: aload_0
      //   703: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   706: invokestatic 265	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)I
      //   709: pop
      //   710: iload_2
      //   711: ifne +128 -> 839
      //   714: aload_0
      //   715: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   718: iconst_0
      //   719: invokestatic 176	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   722: pop
      //   723: ldc 70
      //   725: ldc_w 267
      //   728: iconst_1
      //   729: anewarray 74	java/lang/Object
      //   732: dup
      //   733: iconst_0
      //   734: aload_0
      //   735: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   738: invokestatic 40	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   741: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   744: aastore
      //   745: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   748: aload_0
      //   749: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   752: invokestatic 238	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   755: ifnull -678 -> 77
      //   758: getstatic 244	com/tencent/mm/platformtools/ac:mGs	Z
      //   761: ifeq -684 -> 77
      //   764: aload_0
      //   765: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   768: invokestatic 238	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   771: invokevirtual 249	com/tencent/mm/audio/e/b:closeFile	()V
      //   774: new 269	com/tencent/mm/modelvoice/k$a$1
      //   777: dup
      //   778: aload_0
      //   779: invokespecial 272	com/tencent/mm/modelvoice/k$a$1:<init>	(Lcom/tencent/mm/modelvoice/k$a;)V
      //   782: invokestatic 278	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
      //   785: goto -708 -> 77
      //   788: astore 4
      //   790: ldc 70
      //   792: ldc_w 280
      //   795: iconst_1
      //   796: anewarray 74	java/lang/Object
      //   799: dup
      //   800: iconst_0
      //   801: aload 4
      //   803: invokevirtual 283	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   806: aastore
      //   807: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   810: getstatic 122	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   813: ldc2_w 123
      //   816: lconst_0
      //   817: lconst_1
      //   818: iconst_0
      //   819: invokevirtual 130	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   822: getstatic 122	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
      //   825: ldc2_w 123
      //   828: ldc2_w 284
      //   831: lconst_1
      //   832: iconst_0
      //   833: invokevirtual 130	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   836: goto -134 -> 702
      //   839: aload_0
      //   840: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   843: invokestatic 99	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   846: iconst_2
      //   847: if_icmpne +158 -> 1005
      //   850: aload_0
      //   851: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   854: invokestatic 288	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   857: astore 4
      //   859: aload 4
      //   861: monitorenter
      //   862: ldc 70
      //   864: ldc_w 290
      //   867: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   870: aload_0
      //   871: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   874: invokestatic 288	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   877: invokevirtual 293	java/lang/Object:notifyAll	()V
      //   880: ldc 70
      //   882: ldc_w 295
      //   885: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   888: aload 4
      //   890: monitorexit
      //   891: aload_0
      //   892: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   895: invokestatic 298	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   898: astore 4
      //   900: aload 4
      //   902: monitorenter
      //   903: ldc 70
      //   905: ldc_w 300
      //   908: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   911: aload_0
      //   912: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   915: invokestatic 298	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   918: invokevirtual 303	java/lang/Object:wait	()V
      //   921: ldc 70
      //   923: ldc_w 305
      //   926: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   929: aload 4
      //   931: monitorexit
      //   932: goto -855 -> 77
      //   935: astore_3
      //   936: aload 4
      //   938: monitorexit
      //   939: ldc 54
      //   941: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   944: aload_3
      //   945: athrow
      //   946: astore 5
      //   948: ldc 70
      //   950: ldc 155
      //   952: iconst_1
      //   953: anewarray 74	java/lang/Object
      //   956: dup
      //   957: iconst_0
      //   958: aload 5
      //   960: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   963: aastore
      //   964: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   967: goto -79 -> 888
      //   970: astore_3
      //   971: aload 4
      //   973: monitorexit
      //   974: ldc 54
      //   976: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   979: aload_3
      //   980: athrow
      //   981: astore 5
      //   983: ldc 70
      //   985: ldc 155
      //   987: iconst_1
      //   988: anewarray 74	java/lang/Object
      //   991: dup
      //   992: iconst_0
      //   993: aload 5
      //   995: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   998: aastore
      //   999: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1002: goto -73 -> 929
      //   1005: aload_0
      //   1006: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   1009: invokestatic 288	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1012: astore 4
      //   1014: aload 4
      //   1016: monitorenter
      //   1017: aload_0
      //   1018: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   1021: invokestatic 288	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1024: invokevirtual 293	java/lang/Object:notifyAll	()V
      //   1027: aload 4
      //   1029: monitorexit
      //   1030: goto -953 -> 77
      //   1033: astore_3
      //   1034: aload 4
      //   1036: monitorexit
      //   1037: ldc 54
      //   1039: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1042: aload_3
      //   1043: athrow
      //   1044: astore 5
      //   1046: ldc 70
      //   1048: ldc 155
      //   1050: iconst_1
      //   1051: anewarray 74	java/lang/Object
      //   1054: dup
      //   1055: iconst_0
      //   1056: aload 5
      //   1058: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1061: aastore
      //   1062: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1065: goto -38 -> 1027
      //   1068: aload_0
      //   1069: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   1072: invokestatic 99	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   1075: iconst_3
      //   1076: if_icmpeq -781 -> 295
      //   1079: aload_0
      //   1080: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   1083: invokestatic 259	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   1086: invokevirtual 308	android/media/AudioTrack:getPlayState	()I
      //   1089: iconst_3
      //   1090: if_icmpne -795 -> 295
      //   1093: ldc2_w 309
      //   1096: invokestatic 153	java/lang/Thread:sleep	(J)V
      //   1099: goto -804 -> 295
      //   1102: astore 4
      //   1104: aload_3
      //   1105: monitorexit
      //   1106: ldc 54
      //   1108: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1111: aload 4
      //   1113: athrow
      //   1114: aload_0
      //   1115: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   1118: invokestatic 259	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   1121: ifnull +44 -> 1165
      //   1124: ldc 70
      //   1126: ldc_w 312
      //   1129: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1132: aload_0
      //   1133: getfield 13	com/tencent/mm/modelvoice/k$a:mkw	Lcom/tencent/mm/modelvoice/k;
      //   1136: invokevirtual 315	com/tencent/mm/modelvoice/k:brs	()V
      //   1139: ldc 54
      //   1141: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1144: return
      //   1145: astore_3
      //   1146: ldc 70
      //   1148: ldc_w 317
      //   1151: iconst_1
      //   1152: anewarray 74	java/lang/Object
      //   1155: dup
      //   1156: iconst_0
      //   1157: aload_3
      //   1158: invokevirtual 283	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1161: aastore
      //   1162: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1165: ldc 54
      //   1167: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1170: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1171	0	this	a
      //   44	654	1	s	short
      //   24	687	2	i	int
      //   28	1	3	arrayOfByte1	byte[]
      //   229	24	3	localException1	Exception
      //   298	77	3	localObject1	Object
      //   438	256	3	arrayOfByte2	byte[]
      //   935	10	3	localObject2	Object
      //   970	10	3	localObject3	Object
      //   1033	72	3	localObject4	Object
      //   1145	13	3	localException2	Exception
      //   102	338	4	localObject5	Object
      //   788	14	4	localException3	Exception
      //   1102	10	4	localObject6	Object
      //   946	13	5	localException4	Exception
      //   981	13	5	localException5	Exception
      //   1044	13	5	localException6	Exception
      // Exception table:
      //   from	to	target	type
      //   5	77	229	java/lang/Exception
      //   77	99	229	java/lang/Exception
      //   99	107	229	java/lang/Exception
      //   203	226	229	java/lang/Exception
      //   439	449	229	java/lang/Exception
      //   449	481	229	java/lang/Exception
      //   481	494	229	java/lang/Exception
      //   498	590	229	java/lang/Exception
      //   593	652	229	java/lang/Exception
      //   655	686	229	java/lang/Exception
      //   702	710	229	java/lang/Exception
      //   714	785	229	java/lang/Exception
      //   790	836	229	java/lang/Exception
      //   839	862	229	java/lang/Exception
      //   891	903	229	java/lang/Exception
      //   936	946	229	java/lang/Exception
      //   971	981	229	java/lang/Exception
      //   1005	1017	229	java/lang/Exception
      //   1034	1044	229	java/lang/Exception
      //   1068	1099	229	java/lang/Exception
      //   107	186	438	finally
      //   186	200	438	finally
      //   200	203	438	finally
      //   686	702	788	java/lang/Exception
      //   903	929	935	finally
      //   929	932	935	finally
      //   983	1002	935	finally
      //   862	888	946	java/lang/Exception
      //   862	888	970	finally
      //   888	891	970	finally
      //   948	967	970	finally
      //   903	929	981	java/lang/Exception
      //   1017	1027	1033	finally
      //   1027	1030	1033	finally
      //   1046	1065	1033	finally
      //   1017	1027	1044	java/lang/Exception
      //   301	374	1102	finally
      //   374	376	1102	finally
      //   1132	1139	1145	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k
 * JD-Core Version:    0.7.0.1
 */