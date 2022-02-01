package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public final class k
  implements d
{
  private static Object pdN;
  private static int pdO;
  private static int pdP;
  private static int pdW;
  private boolean hqB;
  public int hwD;
  private AudioTrack mAudioTrack;
  private String mFileName;
  public int mSampleRate;
  private volatile int mStatus;
  private a pdF;
  private com.tencent.mm.compatible.util.b pdG;
  private d.a pdH;
  private d.b pdI;
  private int pdJ;
  private volatile boolean pdK;
  private String pdL;
  private String pdM;
  private int pdQ;
  private int pdR;
  private com.tencent.mm.audio.e.b pdS;
  private com.tencent.mm.audio.c.a.a pdT;
  private int pdU;
  private boolean pdV;
  private h pdX;
  private d.c pdY;
  private final Object pdZ;
  private volatile long pea;
  private volatile boolean peb;
  private boolean pec;
  private List<ByteBuffer> ped;
  private MediaPlayer.OnCompletionListener pee;
  private MediaPlayer.OnErrorListener pef;
  private Future<?> peg;
  
  static
  {
    AppMethodBeat.i(130069);
    pdN = new Object();
    pdO = -1;
    pdW = 100;
    AppMethodBeat.o(130069);
  }
  
  public k()
  {
    AppMethodBeat.i(130050);
    this.pdH = null;
    this.pdI = null;
    this.hwD = 2;
    this.mSampleRate = 16000;
    this.mFileName = "";
    this.mStatus = 0;
    this.pdJ = 0;
    this.pdK = false;
    this.pdL = "";
    this.pdM = "";
    this.pdR = 0;
    this.pdS = null;
    this.pdU = 8;
    this.pdV = true;
    this.pdY = null;
    this.pdZ = new Object();
    this.pea = 0L;
    this.peb = false;
    this.pec = false;
    this.ped = new ArrayList();
    this.pee = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130046);
        if ((k.a(k.this) != null) && (k.b(k.this)))
        {
          Log.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
          k.a(k.this).aPS();
        }
        try
        {
          k.a(k.this, 0);
          k.this.bOY();
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
    this.pef = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130047);
        Log.i("MicroMsg.SilkPlayer", "onError");
        if ((k.a(k.this) != null) && (k.b(k.this))) {
          k.a(k.this).aPS();
        }
        if (k.d(k.this) != null) {
          k.d(k.this).atR();
        }
        try
        {
          k.a(k.this, -1);
          k.this.bOY();
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
    this.hqB = false;
    this.peg = null;
    pdO += 1;
    this.pdQ = pdO;
    Log.i("MicroMsg.SilkPlayer", "[%d] new Instance", new Object[] { Integer.valueOf(this.pdQ) });
    AppMethodBeat.o(130050);
  }
  
  public k(Context paramContext)
  {
    this();
    AppMethodBeat.i(130051);
    this.pdG = new com.tencent.mm.compatible.util.b(paramContext);
    AppMethodBeat.o(130051);
  }
  
  private void QC(String paramString)
  {
    AppMethodBeat.i(130057);
    pdP = this.pdQ;
    Log.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", new Object[] { Integer.valueOf(this.pdQ) });
    for (;;)
    {
      try
      {
        paramString = y.Lh(paramString);
        j = paramString.available();
        Log.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", new Object[] { Integer.valueOf(j) });
        k = AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2);
        if ((!com.tencent.mm.plugin.audio.c.a.cTX()) || (j >= k * 2)) {
          continue;
        }
        this.pdU = 1;
        Object localObject = new byte[j];
        paramString.read((byte[])localObject, 0, j);
        int i = localObject[0];
        long l = MediaRecorder.pdg;
        this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[] { i }, l);
        if (this.pdX != null) {
          Log.i("MicroMsg.SilkPlayer", "silkdec uninit success: %d".concat(String.valueOf(MediaRecorder.SilkDecUnInit(this.pdX.decodeHandle))));
        }
        this.pdX = new h(this.mSampleRate, (byte[])localObject, j);
        j = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ziA, -1);
        if ((1 == j) || (j == 0))
        {
          i = (byte)j;
          localObject = this.pdX;
          j = pdW;
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
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(161L, 1L, 1L, false);
        Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
        continue;
        j += 1;
        continue;
        AppMethodBeat.o(130057);
      }
      Log.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", new Object[] { Integer.valueOf(this.pdQ), Integer.valueOf(this.pdR) });
      paramString = new byte[AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2];
      s = (short)(this.mSampleRate * 20 / 1000);
      j = 0;
      if (j >= this.pdR) {
        continue;
      }
      if (this.pdX == null) {
        continue;
      }
      k = this.pdX.a(paramString, s);
      if (k > 0) {
        continue;
      }
      Log.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", new Object[] { Integer.valueOf(this.pdQ), Integer.valueOf(k) });
      AppMethodBeat.o(130057);
      return;
      this.pdU = 8;
    }
  }
  
  private static boolean QD(String paramString)
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
        u localu = new u(paramString);
        if (!localu.jKS())
        {
          if (localu.jKY()) {
            break label153;
          }
          if (localu.isDirectory())
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
  
  /* Error */
  private String a(String paramString, h paramh)
  {
    // Byte code:
    //   0: ldc_w 370
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 151
    //   8: ldc_w 372
    //   11: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 102	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   18: invokestatic 377	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   21: ifne +30 -> 51
    //   24: ldc 151
    //   26: ldc_w 379
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 102	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   39: aastore
    //   40: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: ldc_w 370
    //   46: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: ldc 151
    //   53: ldc_w 381
    //   56: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: bipush 240
    //   61: invokestatic 386	android/os/Process:setThreadPriority	(I)V
    //   64: aload_0
    //   65: getfield 98	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   68: iconst_2
    //   69: iconst_2
    //   70: invokestatic 217	android/media/AudioTrack:getMinBufferSize	(III)I
    //   73: iconst_1
    //   74: ishl
    //   75: newarray byte
    //   77: astore 6
    //   79: aload_0
    //   80: getfield 98	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   83: bipush 20
    //   85: imul
    //   86: sipush 1000
    //   89: idiv
    //   90: i2s
    //   91: istore_3
    //   92: aload_1
    //   93: invokestatic 388	com/tencent/mm/modelvoice/k:QD	(Ljava/lang/String;)Z
    //   96: pop
    //   97: aload_1
    //   98: iconst_0
    //   99: invokestatic 392	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   102: astore 5
    //   104: aload_0
    //   105: getfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   108: iconst_1
    //   109: if_icmpeq +11 -> 120
    //   112: aload_0
    //   113: getfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   116: iconst_2
    //   117: if_icmpne +138 -> 255
    //   120: aload_2
    //   121: aload 6
    //   123: iload_3
    //   124: invokevirtual 293	com/tencent/mm/modelvoice/h:a	([BS)I
    //   127: istore 4
    //   129: iload 4
    //   131: ifge +79 -> 210
    //   134: aload_0
    //   135: iconst_0
    //   136: putfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   139: goto -35 -> 104
    //   142: astore_1
    //   143: ldc 151
    //   145: new 394	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 396
    //   152: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_1
    //   156: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: ldc 151
    //   170: ldc_w 312
    //   173: iconst_1
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_1
    //   180: invokestatic 318	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   183: aastore
    //   184: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: aload_0
    //   188: iconst_0
    //   189: putfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   192: aload 5
    //   194: ifnull +8 -> 202
    //   197: aload 5
    //   199: invokevirtual 409	java/io/OutputStream:close	()V
    //   202: ldc_w 370
    //   205: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aconst_null
    //   209: areturn
    //   210: aload_0
    //   211: getfield 108	com/tencent/mm/modelvoice/k:pdK	Z
    //   214: ifeq +12 -> 226
    //   217: ldc2_w 410
    //   220: invokestatic 417	java/lang/Thread:sleep	(J)V
    //   223: goto -13 -> 210
    //   226: aload 5
    //   228: aload 6
    //   230: iconst_0
    //   231: iload_3
    //   232: iconst_2
    //   233: imul
    //   234: invokevirtual 421	java/io/OutputStream:write	([BII)V
    //   237: aload 5
    //   239: invokevirtual 424	java/io/OutputStream:flush	()V
    //   242: iload 4
    //   244: ifne -140 -> 104
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   252: goto -148 -> 104
    //   255: ldc 151
    //   257: ldc_w 426
    //   260: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 5
    //   265: invokevirtual 409	java/io/OutputStream:close	()V
    //   268: aload_2
    //   269: getfield 245	com/tencent/mm/modelvoice/h:decodeHandle	J
    //   272: invokestatic 249	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	(J)I
    //   275: istore 4
    //   277: ldc 151
    //   279: ldc_w 428
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: aload_0
    //   289: getfield 149	com/tencent/mm/modelvoice/k:pdQ	I
    //   292: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: aastore
    //   296: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: iload 4
    //   301: ifeq +19 -> 320
    //   304: ldc 151
    //   306: ldc_w 430
    //   309: iload 4
    //   311: invokestatic 254	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   314: invokevirtual 258	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   317: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: ldc_w 370
    //   323: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: areturn
    //   328: astore_1
    //   329: ldc 151
    //   331: aload_1
    //   332: ldc 100
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 434	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: goto -139 -> 202
    //   344: astore_1
    //   345: ldc 151
    //   347: new 394	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 436
    //   354: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload_1
    //   358: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   361: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: ldc 151
    //   372: ldc_w 312
    //   375: iconst_1
    //   376: anewarray 4	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: aload_1
    //   382: invokestatic 318	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   385: aastore
    //   386: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: ldc_w 370
    //   392: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: aconst_null
    //   396: areturn
    //   397: astore_1
    //   398: aconst_null
    //   399: astore 5
    //   401: goto -258 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	k
    //   0	404	1	paramString	String
    //   0	404	2	paramh	h
    //   91	143	3	s	short
    //   127	183	4	i	int
    //   102	298	5	localOutputStream	java.io.OutputStream
    //   77	152	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   104	120	142	java/lang/Exception
    //   120	129	142	java/lang/Exception
    //   134	139	142	java/lang/Exception
    //   210	223	142	java/lang/Exception
    //   226	242	142	java/lang/Exception
    //   247	252	142	java/lang/Exception
    //   255	268	142	java/lang/Exception
    //   197	202	328	java/io/IOException
    //   143	192	344	java/lang/Exception
    //   197	202	344	java/lang/Exception
    //   268	299	344	java/lang/Exception
    //   304	320	344	java/lang/Exception
    //   329	341	344	java/lang/Exception
    //   51	104	397	java/lang/Exception
  }
  
  private boolean bOZ()
  {
    AppMethodBeat.i(130059);
    if (this.mAudioTrack != null) {
      try
      {
        Log.i("MicroMsg.SilkPlayer", "play");
        this.mAudioTrack.play();
        this.pdF = new a((byte)0);
        com.tencent.threadpool.h.ahAA.bm(this.pdF);
        AppMethodBeat.o(130059);
        return true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(161L, 3L, 1L, false);
        AppMethodBeat.o(130059);
        return false;
      }
    }
    AppMethodBeat.o(130059);
    return false;
  }
  
  private boolean e(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    AppMethodBeat.i(234451);
    if (this.mStatus != 0)
    {
      Log.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
      AppMethodBeat.o(234451);
      return false;
    }
    if ((this.mStatus == 4) && (this.peg != null) && (!this.peg.isDone()) && (!this.peg.cancel(false)))
    {
      Log.e("MicroMsg.SilkPlayer", "cancel error");
      AppMethodBeat.o(234451);
      return false;
    }
    if (z.pCS) {
      bS(paramString, g.hxf);
    }
    if (paramBoolean2) {
      this.ped.clear();
    }
    Log.i("MicroMsg.SilkPlayer", "startPlay");
    this.mStatus = 1;
    this.mFileName = paramString;
    for (;;)
    {
      int i;
      synchronized (pdN)
      {
        QC(paramString);
        if (z.pCS)
        {
          paramString = g.hxe;
          if (this.hwD == 2)
          {
            i = 1;
            this.pdS = new com.tencent.mm.audio.e.b(paramString, i, this.mSampleRate);
          }
        }
        else
        {
          int k = this.mSampleRate;
          i = j;
          if (this.hwD == 2) {
            i = 1;
          }
          Log.d("MicroMsg.SilkPlayer", "startPlay, sampleRate: %d, channelCnt: %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        }
      }
      try
      {
        paramBoolean1 = hu(paramBoolean1);
        AppMethodBeat.o(234451);
        return paramBoolean1;
        paramString = finally;
        AppMethodBeat.o(234451);
        throw paramString;
        i = 2;
      }
      catch (Exception paramString)
      {
        try
        {
          paramBoolean1 = hu(true);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
          Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
          this.mStatus = -1;
          AppMethodBeat.o(234451);
        }
      }
    }
    return false;
  }
  
  private void ht(boolean paramBoolean)
  {
    AppMethodBeat.i(130053);
    this.hqB = paramBoolean;
    if (this.mAudioTrack != null) {
      Log.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
    }
    try
    {
      bOY();
      this.mAudioTrack = null;
      this.mAudioTrack = com.tencent.mm.audio.c.a.a(paramBoolean, this.mSampleRate, this.hwD, this.pdU);
      this.pdT = new com.tencent.mm.audio.c.a.a();
      if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() == 0))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(161L, 2L, 1L, false);
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
  
  private boolean hu(boolean paramBoolean)
  {
    AppMethodBeat.i(130058);
    if (!y.ZC(this.mFileName))
    {
      AppMethodBeat.o(130058);
      return false;
    }
    try
    {
      ht(paramBoolean);
      if (this.mAudioTrack != null)
      {
        if ((this.pdG != null) && (this.pdV)) {
          this.pdG.requestFocus();
        }
        paramBoolean = bOZ();
        AppMethodBeat.o(130058);
        return paramBoolean;
      }
    }
    catch (Exception localException)
    {
      if ((this.pdG != null) && (this.pdV)) {
        this.pdG.aPS();
      }
      Log.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + localException.getMessage());
      Log.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      AppMethodBeat.o(130058);
    }
    return false;
  }
  
  public final void a(d.a parama)
  {
    this.pdH = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.pdI = paramb;
  }
  
  public final void a(d.c paramc)
  {
    this.pdY = paramc;
  }
  
  public final double aGG()
  {
    return 0.0D;
  }
  
  public final void bOU()
  {
    this.pdV = false;
  }
  
  public final void bOY()
  {
    AppMethodBeat.i(234697);
    if (this.mAudioTrack != null)
    {
      Log.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
    }
    com.tencent.mm.audio.c.a.a locala;
    String str;
    if (this.pdT != null)
    {
      locala = this.pdT;
      str = this.mFileName;
      if (this.mAudioTrack == null) {
        break label110;
      }
    }
    label110:
    for (int i = this.mAudioTrack.getStreamType();; i = 0)
    {
      locala.b(0, str, i);
      this.pdT.oo(0);
      this.pdT.op(0);
      this.pdT.on(0);
      AppMethodBeat.o(234697);
      return;
    }
  }
  
  /* Error */
  public final String bS(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 627
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   10: ifeq +36 -> 46
    //   13: ldc 151
    //   15: new 394	java/lang/StringBuilder
    //   18: dup
    //   19: ldc_w 482
    //   22: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   29: invokevirtual 485	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 627
    //   41: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   51: aload_0
    //   52: aload_1
    //   53: putfield 102	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   56: aload_1
    //   57: invokestatic 200	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 206	java/io/InputStream:available	()I
    //   65: istore 4
    //   67: iload 4
    //   69: newarray byte
    //   71: astore 7
    //   73: aload_1
    //   74: aload 7
    //   76: iconst_0
    //   77: iload 4
    //   79: invokevirtual 227	java/io/InputStream:read	([BII)I
    //   82: pop
    //   83: aload 7
    //   85: iconst_0
    //   86: baload
    //   87: istore_3
    //   88: getstatic 232	com/tencent/mm/modelvoice/MediaRecorder:pdg	J
    //   91: lstore 5
    //   93: aload_0
    //   94: iconst_1
    //   95: newarray byte
    //   97: dup
    //   98: iconst_0
    //   99: iload_3
    //   100: bastore
    //   101: lload 5
    //   103: invokestatic 236	com/tencent/mm/modelvoice/MediaRecorder:SilkGetEncSampleRate	([BJ)I
    //   106: putfield 98	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   109: new 242	com/tencent/mm/modelvoice/h
    //   112: dup
    //   113: aload_0
    //   114: getfield 98	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   117: aload 7
    //   119: iload 4
    //   121: invokespecial 264	com/tencent/mm/modelvoice/h:<init>	(I[BI)V
    //   124: astore 7
    //   126: ldc 151
    //   128: ldc_w 629
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: getfield 149	com/tencent/mm/modelvoice/k:pdQ	I
    //   141: invokestatic 159	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_1
    //   149: invokevirtual 288	java/io/InputStream:close	()V
    //   152: aload_0
    //   153: aload_2
    //   154: aload 7
    //   156: invokespecial 631	com/tencent/mm/modelvoice/k:a	(Ljava/lang/String;Lcom/tencent/mm/modelvoice/h;)Ljava/lang/String;
    //   159: astore_2
    //   160: ldc_w 627
    //   163: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_2
    //   167: areturn
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: ldc 151
    //   173: ldc_w 633
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_0
    //   183: getfield 102	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: aload_2
    //   190: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 151
    //   199: ldc_w 312
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_2
    //   209: invokestatic 318	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_0
    //   217: iconst_m1
    //   218: putfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 288	java/io/InputStream:close	()V
    //   229: ldc_w 627
    //   232: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: ldc 151
    //   240: aload_1
    //   241: ldc 100
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 434	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void c(b.a parama)
  {
    AppMethodBeat.i(130064);
    if ((parama != null) && (this.pdG != null)) {
      this.pdG.a(parama);
    }
    AppMethodBeat.o(130064);
  }
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(130055);
    if ((this.mFileName != null) && (this.mFileName.equals(paramString)))
    {
      paramBoolean = e(paramString, paramBoolean, false);
      AppMethodBeat.o(130055);
      return paramBoolean;
    }
    paramBoolean = e(paramString, paramBoolean, true);
    AppMethodBeat.o(130055);
    return paramBoolean;
  }
  
  public final boolean ea(long paramLong)
  {
    AppMethodBeat.i(234708);
    Log.i("MicroMsg.SilkPlayer", "seek: ".concat(String.valueOf(paramLong)));
    if (this.mStatus == 0)
    {
      if (this.pdY != null) {
        this.pdY.eb(this.pea * 20L);
      }
      Log.i("MicroMsg.SilkPlayer", "now stop, can not seek");
      AppMethodBeat.o(234708);
      return false;
    }
    if (this.mStatus == 4)
    {
      if ((this.peg == null) || (this.peg.isDone()) || (!this.peg.cancel(false))) {
        break label181;
      }
      Log.i("MicroMsg.SilkPlayer", "cancel previous stopping");
      if (this.pdF != null)
      {
        this.mStatus = 1;
        com.tencent.threadpool.h.ahAA.bm(this.pdF);
      }
    }
    else
    {
      if (this.mStatus == 1) {
        break label197;
      }
      Log.i("MicroMsg.SilkPlayer", "not playing, can not seek");
      AppMethodBeat.o(234708);
      return false;
    }
    Log.e("MicroMsg.SilkPlayer", "playing runnable is null");
    AppMethodBeat.o(234708);
    return false;
    label181:
    Log.e("MicroMsg.SilkPlayer", "cancel previous stopping error");
    AppMethodBeat.o(234708);
    return false;
    label197:
    synchronized (this.pdZ)
    {
      this.pea = (paramLong / 20L);
      this.peb = true;
      AppMethodBeat.o(234708);
      return true;
    }
  }
  
  public final void ed(boolean paramBoolean)
  {
    AppMethodBeat.i(130052);
    Log.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pdK = true;
    this.hwD = 2;
    ht(paramBoolean);
    try
    {
      this.mAudioTrack.play();
      this.pdK = false;
      AppMethodBeat.o(130052);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(161L, 3L, 1L, false);
        Log.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final boolean em(boolean paramBoolean)
  {
    AppMethodBeat.i(130061);
    if (this.mStatus != 1)
    {
      AppMethodBeat.o(130061);
      return false;
    }
    this.mStatus = 2;
    synchronized (this.pdM)
    {
      try
      {
        Log.i("MicroMsg.SilkPlayer", "before mOk.wait");
        long l = System.currentTimeMillis();
        this.pdM.wait(1000L);
        Log.i("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - l));
        if ((this.pdG != null) && (paramBoolean)) {
          this.pdG.aPS();
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
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(234752);
    boolean bool1;
    a locala;
    if (this.mStatus == 1)
    {
      bool1 = true;
      locala = this.pdF;
      if ((this.pdF != null) && (!this.pdF.isDone())) {
        break label124;
      }
    }
    label124:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.SilkPlayer", "isPlaying %s and mPlayRunnable is %s && mPlayRunnable is done %s", new Object[] { Boolean.valueOf(bool1), locala, Boolean.valueOf(bool2) });
      if ((this.mStatus != 1) && (this.mStatus != 4) && ((this.mStatus == 1) || (this.pdF == null) || (this.pdF.isDone()))) {
        break label129;
      }
      AppMethodBeat.o(234752);
      return true;
      bool1 = false;
      break;
    }
    label129:
    AppMethodBeat.o(234752);
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
    synchronized (this.pdL)
    {
      try
      {
        Log.i("MicroMsg.SilkPlayer", "before mpause.notify");
        this.pdL.notifyAll();
        Log.i("MicroMsg.SilkPlayer", "after mpause.notify");
        if ((this.pdG != null) && (this.pdV)) {
          this.pdG.requestFocus();
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
  
  /* Error */
  public final boolean stop()
  {
    // Byte code:
    //   0: ldc_w 708
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 151
    //   8: new 394	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 710
    //   15: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   22: invokevirtual 485	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 261	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   35: iconst_1
    //   36: if_icmpeq +44 -> 80
    //   39: aload_0
    //   40: getfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   43: iconst_2
    //   44: if_icmpeq +36 -> 80
    //   47: ldc 151
    //   49: new 394	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 712
    //   56: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   63: invokevirtual 485	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 404	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc_w 708
    //   75: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: iconst_3
    //   82: putfield 104	com/tencent/mm/modelvoice/k:mStatus	I
    //   85: aload_0
    //   86: getfield 110	com/tencent/mm/modelvoice/k:pdL	Ljava/lang/String;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 110	com/tencent/mm/modelvoice/k:pdL	Ljava/lang/String;
    //   96: invokevirtual 705	java/lang/Object:notifyAll	()V
    //   99: aload_0
    //   100: getfield 173	com/tencent/mm/modelvoice/k:pdG	Lcom/tencent/mm/compatible/util/b;
    //   103: ifnull +18 -> 121
    //   106: aload_0
    //   107: getfield 120	com/tencent/mm/modelvoice/k:pdV	Z
    //   110: ifeq +11 -> 121
    //   113: aload_0
    //   114: getfield 173	com/tencent/mm/modelvoice/k:pdG	Lcom/tencent/mm/compatible/util/b;
    //   117: invokevirtual 576	com/tencent/mm/compatible/util/b:aPS	()Z
    //   120: pop
    //   121: aload_1
    //   122: monitorexit
    //   123: ldc_w 708
    //   126: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_2
    //   132: ldc 151
    //   134: ldc_w 312
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_2
    //   144: invokestatic 318	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 173	com/tencent/mm/modelvoice/k:pdG	Lcom/tencent/mm/compatible/util/b;
    //   155: ifnull +18 -> 173
    //   158: aload_0
    //   159: getfield 120	com/tencent/mm/modelvoice/k:pdV	Z
    //   162: ifeq +11 -> 173
    //   165: aload_0
    //   166: getfield 173	com/tencent/mm/modelvoice/k:pdG	Lcom/tencent/mm/compatible/util/b;
    //   169: invokevirtual 576	com/tencent/mm/compatible/util/b:aPS	()Z
    //   172: pop
    //   173: aload_1
    //   174: monitorexit
    //   175: ldc_w 708
    //   178: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_2
    //   184: aload_0
    //   185: getfield 173	com/tencent/mm/modelvoice/k:pdG	Lcom/tencent/mm/compatible/util/b;
    //   188: ifnull +18 -> 206
    //   191: aload_0
    //   192: getfield 120	com/tencent/mm/modelvoice/k:pdV	Z
    //   195: ifeq +11 -> 206
    //   198: aload_0
    //   199: getfield 173	com/tencent/mm/modelvoice/k:pdG	Lcom/tencent/mm/compatible/util/b;
    //   202: invokevirtual 576	com/tencent/mm/compatible/util/b:aPS	()Z
    //   205: pop
    //   206: ldc_w 708
    //   209: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: aload_1
    //   216: monitorexit
    //   217: ldc_w 708
    //   220: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  final class a
    extends com.tencent.threadpool.i.b
  {
    private a() {}
    
    public final String getKey()
    {
      AppMethodBeat.i(234491);
      String str = "SilkPlayer_play_" + k.g(k.this);
      AppMethodBeat.o(234491);
      return str;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 149
      //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: bipush 240
      //   7: invokestatic 154	android/os/Process:setThreadPriority	(I)V
      //   10: aload_0
      //   11: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   14: invokestatic 156	com/tencent/mm/modelvoice/k:e	(Lcom/tencent/mm/modelvoice/k;)I
      //   17: iconst_2
      //   18: iconst_2
      //   19: invokestatic 162	android/media/AudioTrack:getMinBufferSize	(III)I
      //   22: iconst_2
      //   23: imul
      //   24: istore 4
      //   26: iload 4
      //   28: newarray byte
      //   30: astore 5
      //   32: aload_0
      //   33: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   36: invokestatic 156	com/tencent/mm/modelvoice/k:e	(Lcom/tencent/mm/modelvoice/k;)I
      //   39: bipush 20
      //   41: imul
      //   42: sipush 1000
      //   45: idiv
      //   46: i2s
      //   47: istore_1
      //   48: ldc 68
      //   50: ldc 164
      //   52: iconst_2
      //   53: anewarray 72	java/lang/Object
      //   56: dup
      //   57: iconst_0
      //   58: iload_1
      //   59: invokestatic 169	java/lang/Short:valueOf	(S)Ljava/lang/Short;
      //   62: aastore
      //   63: dup
      //   64: iconst_1
      //   65: iload 4
      //   67: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   70: aastore
      //   71: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   74: ldc 68
      //   76: ldc 174
      //   78: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   81: aload_0
      //   82: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   85: invokestatic 92	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   88: iconst_1
      //   89: if_icmpeq +14 -> 103
      //   92: aload_0
      //   93: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   96: invokestatic 92	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   99: iconst_2
      //   100: if_icmpne +201 -> 301
      //   103: invokestatic 42	com/tencent/mm/modelvoice/k:access$700	()Ljava/lang/Object;
      //   106: astore 6
      //   108: aload 6
      //   110: monitorenter
      //   111: invokestatic 46	com/tencent/mm/modelvoice/k:bPa	()I
      //   114: aload_0
      //   115: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   118: invokestatic 50	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   121: if_icmpeq +83 -> 204
      //   124: ldc 68
      //   126: ldc 176
      //   128: iconst_2
      //   129: anewarray 72	java/lang/Object
      //   132: dup
      //   133: iconst_0
      //   134: aload_0
      //   135: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   138: invokestatic 50	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   141: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   144: aastore
      //   145: dup
      //   146: iconst_1
      //   147: invokestatic 46	com/tencent/mm/modelvoice/k:bPa	()I
      //   150: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   153: aastore
      //   154: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   157: aload_0
      //   158: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   161: invokestatic 179	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
      //   164: pop
      //   165: aload_0
      //   166: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   169: invokestatic 181	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   172: iconst_3
      //   173: if_icmple +17 -> 190
      //   176: getstatic 187	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   179: ldc2_w 188
      //   182: ldc2_w 190
      //   185: lconst_1
      //   186: iconst_0
      //   187: invokevirtual 195	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   190: aload_0
      //   191: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   194: aload_0
      //   195: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   198: invokestatic 199	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   201: invokestatic 202	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;Ljava/lang/String;)V
      //   204: aload 6
      //   206: monitorexit
      //   207: aload_0
      //   208: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   211: invokestatic 206	com/tencent/mm/modelvoice/k:j	(Lcom/tencent/mm/modelvoice/k;)Z
      //   214: ifeq +212 -> 426
      //   217: ldc 68
      //   219: ldc 208
      //   221: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   224: ldc2_w 211
      //   227: invokestatic 218	java/lang/Thread:sleep	(J)V
      //   230: goto -23 -> 207
      //   233: astore 5
      //   235: getstatic 187	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   238: ldc2_w 188
      //   241: lconst_0
      //   242: lconst_1
      //   243: iconst_0
      //   244: invokevirtual 195	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   247: ldc 68
      //   249: ldc 220
      //   251: iconst_1
      //   252: anewarray 72	java/lang/Object
      //   255: dup
      //   256: iconst_0
      //   257: aload 5
      //   259: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   262: aastore
      //   263: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   266: aload_0
      //   267: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   270: invokestatic 230	com/tencent/mm/modelvoice/k:B	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnErrorListener;
      //   273: ifnull +19 -> 292
      //   276: aload_0
      //   277: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   280: invokestatic 230	com/tencent/mm/modelvoice/k:B	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnErrorListener;
      //   283: aconst_null
      //   284: iconst_0
      //   285: iconst_0
      //   286: invokeinterface 236 4 0
      //   291: pop
      //   292: aload_0
      //   293: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   296: iconst_0
      //   297: invokestatic 239	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   300: pop
      //   301: new 241	com/tencent/mm/modelvoice/k$a$$ExternalSyntheticLambda0
      //   304: dup
      //   305: aload_0
      //   306: invokespecial 243	com/tencent/mm/modelvoice/k$a$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/modelvoice/k$a;)V
      //   309: astore 5
      //   311: aload_0
      //   312: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   315: invokestatic 92	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   318: iconst_3
      //   319: if_icmpeq +1066 -> 1385
      //   322: aload_0
      //   323: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   326: invokestatic 114	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   329: ifnull +1056 -> 1385
      //   332: aload_0
      //   333: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   336: invokestatic 114	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   339: invokevirtual 246	android/media/AudioTrack:getPlayState	()I
      //   342: iconst_3
      //   343: if_icmpne +1042 -> 1385
      //   346: ldc 68
      //   348: ldc 248
      //   350: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   353: aload_0
      //   354: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   357: invokestatic 252	com/tencent/mm/modelvoice/k:C	(Lcom/tencent/mm/modelvoice/k;)Ljava/util/concurrent/Future;
      //   360: ifnull +26 -> 386
      //   363: aload_0
      //   364: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   367: invokestatic 252	com/tencent/mm/modelvoice/k:C	(Lcom/tencent/mm/modelvoice/k;)Ljava/util/concurrent/Future;
      //   370: invokeinterface 258 1 0
      //   375: ifne +11 -> 386
      //   378: ldc 68
      //   380: ldc_w 260
      //   383: invokestatic 262	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   386: aload_0
      //   387: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   390: getstatic 268	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
      //   393: aload 5
      //   395: ldc2_w 269
      //   398: invokeinterface 276 4 0
      //   403: invokestatic 279	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;Ljava/util/concurrent/Future;)Ljava/util/concurrent/Future;
      //   406: pop
      //   407: ldc 149
      //   409: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   412: return
      //   413: astore 5
      //   415: aload 6
      //   417: monitorexit
      //   418: ldc 149
      //   420: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   423: aload 5
      //   425: athrow
      //   426: iconst_0
      //   427: istore_3
      //   428: aload_0
      //   429: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   432: invokestatic 54	com/tencent/mm/modelvoice/k:k	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   435: ifnull +339 -> 774
      //   438: iload_3
      //   439: istore_2
      //   440: aload_0
      //   441: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   444: invokestatic 283	com/tencent/mm/modelvoice/k:l	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   447: ifnull +18 -> 465
      //   450: aload_0
      //   451: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   454: invokestatic 283	com/tencent/mm/modelvoice/k:l	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   457: iload_1
      //   458: aload 5
      //   460: invokevirtual 288	com/tencent/mm/audio/c/a/a:e	(I[B)V
      //   463: iload_3
      //   464: istore_2
      //   465: aload_0
      //   466: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   469: invokestatic 292	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)J
      //   472: aload_0
      //   473: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   476: invokestatic 295	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)I
      //   479: i2l
      //   480: lcmp
      //   481: iflt +104 -> 585
      //   484: iload_2
      //   485: iflt +100 -> 585
      //   488: aload_0
      //   489: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   492: invokestatic 297	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Z
      //   495: ifne +90 -> 585
      //   498: aload_0
      //   499: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   502: invokestatic 54	com/tencent/mm/modelvoice/k:k	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   505: aload 5
      //   507: iload_1
      //   508: invokevirtual 300	com/tencent/mm/modelvoice/h:a	([BS)I
      //   511: istore_3
      //   512: iload_3
      //   513: ifle +53 -> 566
      //   516: iload 4
      //   518: invokestatic 306	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
      //   521: astore 6
      //   523: aload 6
      //   525: aload 5
      //   527: invokevirtual 310	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
      //   530: pop
      //   531: aload 6
      //   533: iconst_0
      //   534: invokevirtual 314	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   537: pop
      //   538: aload_0
      //   539: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   542: invokestatic 316	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)I
      //   545: pop
      //   546: aload_0
      //   547: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   550: invokestatic 320	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/util/List;
      //   553: aload 6
      //   555: invokeinterface 326 2 0
      //   560: pop
      //   561: iload_3
      //   562: istore_2
      //   563: goto -98 -> 465
      //   566: iload_3
      //   567: istore_2
      //   568: iload_3
      //   569: ifne -104 -> 465
      //   572: aload_0
      //   573: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   576: invokestatic 329	com/tencent/mm/modelvoice/k:r	(Lcom/tencent/mm/modelvoice/k;)Z
      //   579: pop
      //   580: iload_3
      //   581: istore_2
      //   582: goto -117 -> 465
      //   585: aload_0
      //   586: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   589: invokestatic 292	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)J
      //   592: aload_0
      //   593: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   596: invokestatic 295	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)I
      //   599: i2l
      //   600: lcmp
      //   601: ifge +805 -> 1406
      //   604: iload_2
      //   605: iflt +801 -> 1406
      //   608: aload_0
      //   609: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   612: invokestatic 320	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/util/List;
      //   615: invokeinterface 332 1 0
      //   620: i2l
      //   621: aload_0
      //   622: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   625: invokestatic 292	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)J
      //   628: lcmp
      //   629: ifle +777 -> 1406
      //   632: aload_0
      //   633: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   636: invokestatic 320	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/util/List;
      //   639: aload_0
      //   640: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   643: invokestatic 292	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)J
      //   646: l2i
      //   647: invokeinterface 336 2 0
      //   652: checkcast 302	java/nio/ByteBuffer
      //   655: astore 6
      //   657: aload 6
      //   659: iconst_0
      //   660: invokevirtual 314	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   663: pop
      //   664: aload 6
      //   666: aload 5
      //   668: invokevirtual 338	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
      //   671: pop
      //   672: iconst_1
      //   673: istore_2
      //   674: iload_2
      //   675: ifge +162 -> 837
      //   678: aload_0
      //   679: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   682: iconst_0
      //   683: invokestatic 239	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   686: pop
      //   687: getstatic 187	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   690: ldc2_w 188
      //   693: lconst_0
      //   694: lconst_1
      //   695: iconst_0
      //   696: invokevirtual 195	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   699: getstatic 187	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   702: ldc2_w 188
      //   705: ldc2_w 339
      //   708: lconst_1
      //   709: iconst_0
      //   710: invokevirtual 195	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   713: ldc 68
      //   715: ldc_w 342
      //   718: iconst_2
      //   719: anewarray 72	java/lang/Object
      //   722: dup
      //   723: iconst_0
      //   724: aload_0
      //   725: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   728: invokestatic 50	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   731: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   734: aastore
      //   735: dup
      //   736: iconst_1
      //   737: iload_2
      //   738: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   741: aastore
      //   742: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   745: aload_0
      //   746: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   749: invokestatic 346	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   752: ifnull -671 -> 81
      //   755: getstatic 352	com/tencent/mm/platformtools/z:pCS	Z
      //   758: ifeq -677 -> 81
      //   761: aload_0
      //   762: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   765: invokestatic 346	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   768: invokevirtual 357	com/tencent/mm/audio/e/b:closeFile	()V
      //   771: goto -690 -> 81
      //   774: aload_0
      //   775: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   778: iconst_0
      //   779: invokestatic 239	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   782: pop
      //   783: ldc 68
      //   785: ldc_w 359
      //   788: iconst_1
      //   789: anewarray 72	java/lang/Object
      //   792: dup
      //   793: iconst_0
      //   794: aload_0
      //   795: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   798: invokestatic 50	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   801: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   804: aastore
      //   805: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   808: aload_0
      //   809: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   812: invokestatic 346	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   815: ifnull -734 -> 81
      //   818: getstatic 352	com/tencent/mm/platformtools/z:pCS	Z
      //   821: ifeq -740 -> 81
      //   824: aload_0
      //   825: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   828: invokestatic 346	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   831: invokevirtual 357	com/tencent/mm/audio/e/b:closeFile	()V
      //   834: goto -753 -> 81
      //   837: getstatic 352	com/tencent/mm/platformtools/z:pCS	Z
      //   840: ifeq +29 -> 869
      //   843: aload_0
      //   844: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   847: invokestatic 346	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   850: ifnull +19 -> 869
      //   853: aload_0
      //   854: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   857: invokestatic 346	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   860: aload 5
      //   862: iload_1
      //   863: iconst_2
      //   864: imul
      //   865: invokevirtual 363	com/tencent/mm/audio/e/b:y	([BI)Z
      //   868: pop
      //   869: aload_0
      //   870: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   873: invokestatic 366	com/tencent/mm/modelvoice/k:t	(Lcom/tencent/mm/modelvoice/k;)Z
      //   876: ifeq +41 -> 917
      //   879: aload_0
      //   880: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   883: invokestatic 114	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   886: invokevirtual 369	android/media/AudioTrack:pause	()V
      //   889: aload_0
      //   890: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   893: invokestatic 114	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   896: invokevirtual 372	android/media/AudioTrack:flush	()V
      //   899: aload_0
      //   900: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   903: invokestatic 114	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   906: invokevirtual 375	android/media/AudioTrack:play	()V
      //   909: ldc 68
      //   911: ldc_w 377
      //   914: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   917: aload_0
      //   918: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   921: invokestatic 114	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   924: aload 5
      //   926: iconst_0
      //   927: iload_1
      //   928: iconst_2
      //   929: imul
      //   930: invokevirtual 381	android/media/AudioTrack:write	([BII)I
      //   933: pop
      //   934: aload_0
      //   935: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   938: invokestatic 385	com/tencent/mm/modelvoice/k:v	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/d$c;
      //   941: ifnull +36 -> 977
      //   944: aload_0
      //   945: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   948: invokestatic 366	com/tencent/mm/modelvoice/k:t	(Lcom/tencent/mm/modelvoice/k;)Z
      //   951: ifne +26 -> 977
      //   954: aload_0
      //   955: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   958: invokestatic 385	com/tencent/mm/modelvoice/k:v	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/d$c;
      //   961: aload_0
      //   962: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   965: invokestatic 292	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)J
      //   968: ldc2_w 211
      //   971: lmul
      //   972: invokeinterface 390 3 0
      //   977: aload_0
      //   978: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   981: invokestatic 394	com/tencent/mm/modelvoice/k:w	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/Object;
      //   984: astore 6
      //   986: aload 6
      //   988: monitorenter
      //   989: aload_0
      //   990: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   993: invokestatic 397	com/tencent/mm/modelvoice/k:x	(Lcom/tencent/mm/modelvoice/k;)J
      //   996: pop2
      //   997: aload_0
      //   998: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1001: invokestatic 399	com/tencent/mm/modelvoice/k:y	(Lcom/tencent/mm/modelvoice/k;)Z
      //   1004: pop
      //   1005: aload 6
      //   1007: monitorexit
      //   1008: iload_2
      //   1009: ifne +141 -> 1150
      //   1012: aload_0
      //   1013: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1016: iconst_4
      //   1017: invokestatic 239	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   1020: pop
      //   1021: ldc 68
      //   1023: ldc_w 401
      //   1026: iconst_1
      //   1027: anewarray 72	java/lang/Object
      //   1030: dup
      //   1031: iconst_0
      //   1032: aload_0
      //   1033: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1036: invokestatic 50	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   1039: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1042: aastore
      //   1043: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1046: aload_0
      //   1047: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1050: invokestatic 346	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   1053: ifnull -972 -> 81
      //   1056: getstatic 352	com/tencent/mm/platformtools/z:pCS	Z
      //   1059: ifeq -978 -> 81
      //   1062: aload_0
      //   1063: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1066: invokestatic 346	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   1069: invokevirtual 357	com/tencent/mm/audio/e/b:closeFile	()V
      //   1072: new 403	com/tencent/mm/modelvoice/k$a$1
      //   1075: dup
      //   1076: aload_0
      //   1077: invokespecial 404	com/tencent/mm/modelvoice/k$a$1:<init>	(Lcom/tencent/mm/modelvoice/k$a;)V
      //   1080: invokestatic 410	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
      //   1083: goto -1002 -> 81
      //   1086: astore 7
      //   1088: aload 6
      //   1090: monitorexit
      //   1091: ldc 149
      //   1093: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1096: aload 7
      //   1098: athrow
      //   1099: astore 6
      //   1101: ldc 68
      //   1103: ldc_w 412
      //   1106: iconst_1
      //   1107: anewarray 72	java/lang/Object
      //   1110: dup
      //   1111: iconst_0
      //   1112: aload 6
      //   1114: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1117: aastore
      //   1118: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1121: getstatic 187	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   1124: ldc2_w 188
      //   1127: lconst_0
      //   1128: lconst_1
      //   1129: iconst_0
      //   1130: invokevirtual 195	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1133: getstatic 187	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   1136: ldc2_w 188
      //   1139: ldc2_w 413
      //   1142: lconst_1
      //   1143: iconst_0
      //   1144: invokevirtual 195	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   1147: goto -139 -> 1008
      //   1150: aload_0
      //   1151: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1154: invokestatic 92	com/tencent/mm/modelvoice/k:f	(Lcom/tencent/mm/modelvoice/k;)I
      //   1157: iconst_2
      //   1158: if_icmpne +162 -> 1320
      //   1161: aload_0
      //   1162: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1165: invokestatic 417	com/tencent/mm/modelvoice/k:z	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1168: astore 6
      //   1170: aload 6
      //   1172: monitorenter
      //   1173: ldc 68
      //   1175: ldc_w 419
      //   1178: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1181: aload_0
      //   1182: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1185: invokestatic 417	com/tencent/mm/modelvoice/k:z	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1188: invokevirtual 422	java/lang/Object:notifyAll	()V
      //   1191: ldc 68
      //   1193: ldc_w 424
      //   1196: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1199: aload 6
      //   1201: monitorexit
      //   1202: aload_0
      //   1203: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1206: invokestatic 427	com/tencent/mm/modelvoice/k:A	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1209: astore 6
      //   1211: aload 6
      //   1213: monitorenter
      //   1214: ldc 68
      //   1216: ldc_w 429
      //   1219: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1222: aload_0
      //   1223: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1226: invokestatic 427	com/tencent/mm/modelvoice/k:A	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1229: invokevirtual 432	java/lang/Object:wait	()V
      //   1232: ldc 68
      //   1234: ldc_w 434
      //   1237: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1240: aload 6
      //   1242: monitorexit
      //   1243: goto -1162 -> 81
      //   1246: astore 5
      //   1248: aload 6
      //   1250: monitorexit
      //   1251: ldc 149
      //   1253: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1256: aload 5
      //   1258: athrow
      //   1259: astore 7
      //   1261: ldc 68
      //   1263: ldc 220
      //   1265: iconst_1
      //   1266: anewarray 72	java/lang/Object
      //   1269: dup
      //   1270: iconst_0
      //   1271: aload 7
      //   1273: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1276: aastore
      //   1277: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1280: goto -81 -> 1199
      //   1283: astore 5
      //   1285: aload 6
      //   1287: monitorexit
      //   1288: ldc 149
      //   1290: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1293: aload 5
      //   1295: athrow
      //   1296: astore 7
      //   1298: ldc 68
      //   1300: ldc 220
      //   1302: iconst_1
      //   1303: anewarray 72	java/lang/Object
      //   1306: dup
      //   1307: iconst_0
      //   1308: aload 7
      //   1310: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1313: aastore
      //   1314: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1317: goto -77 -> 1240
      //   1320: aload_0
      //   1321: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1324: invokestatic 417	com/tencent/mm/modelvoice/k:z	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1327: astore 6
      //   1329: aload 6
      //   1331: monitorenter
      //   1332: aload_0
      //   1333: getfield 30	com/tencent/mm/modelvoice/k$a:peh	Lcom/tencent/mm/modelvoice/k;
      //   1336: invokestatic 417	com/tencent/mm/modelvoice/k:z	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1339: invokevirtual 422	java/lang/Object:notifyAll	()V
      //   1342: aload 6
      //   1344: monitorexit
      //   1345: goto -1264 -> 81
      //   1348: astore 5
      //   1350: aload 6
      //   1352: monitorexit
      //   1353: ldc 149
      //   1355: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1358: aload 5
      //   1360: athrow
      //   1361: astore 7
      //   1363: ldc 68
      //   1365: ldc 220
      //   1367: iconst_1
      //   1368: anewarray 72	java/lang/Object
      //   1371: dup
      //   1372: iconst_0
      //   1373: aload 7
      //   1375: invokestatic 226	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1378: aastore
      //   1379: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1382: goto -40 -> 1342
      //   1385: ldc 68
      //   1387: ldc_w 436
      //   1390: invokestatic 119	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1393: aload 5
      //   1395: invokeinterface 440 1 0
      //   1400: ldc 149
      //   1402: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1405: return
      //   1406: goto -732 -> 674
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1409	0	this	a
      //   47	883	1	s	short
      //   439	570	2	i	int
      //   427	154	3	j	int
      //   24	493	4	k	int
      //   30	1	5	arrayOfByte1	byte[]
      //   233	25	5	localException1	Exception
      //   309	85	5	localExternalSyntheticLambda0	k.a..ExternalSyntheticLambda0
      //   413	512	5	arrayOfByte2	byte[]
      //   1246	11	5	localObject1	Object
      //   1283	11	5	localObject2	Object
      //   1348	46	5	localObject3	Object
      //   106	983	6	localObject4	Object
      //   1099	14	6	localException2	Exception
      //   1086	11	7	localObject5	Object
      //   1259	13	7	localException3	Exception
      //   1296	13	7	localException4	Exception
      //   1361	13	7	localException5	Exception
      // Exception table:
      //   from	to	target	type
      //   5	81	233	java/lang/Exception
      //   81	103	233	java/lang/Exception
      //   103	111	233	java/lang/Exception
      //   207	230	233	java/lang/Exception
      //   415	426	233	java/lang/Exception
      //   428	438	233	java/lang/Exception
      //   440	463	233	java/lang/Exception
      //   465	484	233	java/lang/Exception
      //   488	512	233	java/lang/Exception
      //   516	561	233	java/lang/Exception
      //   572	580	233	java/lang/Exception
      //   585	604	233	java/lang/Exception
      //   608	672	233	java/lang/Exception
      //   678	771	233	java/lang/Exception
      //   774	834	233	java/lang/Exception
      //   837	869	233	java/lang/Exception
      //   1012	1083	233	java/lang/Exception
      //   1101	1147	233	java/lang/Exception
      //   1150	1173	233	java/lang/Exception
      //   1202	1214	233	java/lang/Exception
      //   1248	1259	233	java/lang/Exception
      //   1285	1296	233	java/lang/Exception
      //   1320	1332	233	java/lang/Exception
      //   1350	1361	233	java/lang/Exception
      //   111	190	413	finally
      //   190	204	413	finally
      //   204	207	413	finally
      //   989	1008	1086	finally
      //   869	917	1099	java/lang/Exception
      //   917	977	1099	java/lang/Exception
      //   977	989	1099	java/lang/Exception
      //   1088	1099	1099	java/lang/Exception
      //   1214	1240	1246	finally
      //   1240	1243	1246	finally
      //   1298	1317	1246	finally
      //   1173	1199	1259	java/lang/Exception
      //   1173	1199	1283	finally
      //   1199	1202	1283	finally
      //   1261	1280	1283	finally
      //   1214	1240	1296	java/lang/Exception
      //   1332	1342	1348	finally
      //   1342	1345	1348	finally
      //   1363	1382	1348	finally
      //   1332	1342	1361	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k
 * JD-Core Version:    0.7.0.1
 */