package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.c;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.util.Map;

public final class k
  implements d
{
  private static Object ide;
  private static int idf;
  private static int idg;
  private static int idn;
  public int cVV;
  private a icW;
  private com.tencent.mm.compatible.util.b icX;
  private d.a icY;
  private d.b icZ;
  private int ida;
  private volatile boolean idb;
  private String idc;
  private String idd;
  private int idh;
  private int idi;
  private com.tencent.mm.audio.e.b idj;
  private com.tencent.mm.audio.c.a.a idk;
  private int idl;
  private boolean idm;
  private h ido;
  private MediaPlayer.OnCompletionListener idp;
  private MediaPlayer.OnErrorListener idq;
  private AudioTrack mAudioTrack;
  private String mFileName;
  public int mSampleRate;
  private volatile int mStatus;
  
  static
  {
    AppMethodBeat.i(130069);
    ide = new Object();
    idf = -1;
    idn = 100;
    AppMethodBeat.o(130069);
  }
  
  public k()
  {
    AppMethodBeat.i(130050);
    this.icY = null;
    this.icZ = null;
    this.cVV = 2;
    this.mSampleRate = 16000;
    this.mFileName = "";
    this.mStatus = 0;
    this.ida = 0;
    this.idb = false;
    this.idc = "";
    this.idd = "";
    this.idi = 0;
    this.idj = null;
    this.idl = 8;
    this.idm = true;
    this.idp = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(130046);
        if ((k.a(k.this) != null) && (k.b(k.this)))
        {
          ac.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
          k.a(k.this).YC();
        }
        try
        {
          k.a(k.this, 0);
          if (k.c(k.this) != null)
          {
            ac.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            k.c(k.this).stop();
            k.c(k.this).release();
            k.d(k.this);
          }
          AppMethodBeat.o(130046);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          ac.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bs.m(paramAnonymousMediaPlayer) });
          ac.e("MicroMsg.SilkPlayer", "setCompletion File[" + k.e(k.this) + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          AppMethodBeat.o(130046);
        }
      }
    };
    this.idq = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(130047);
        ac.i("MicroMsg.SilkPlayer", "onError");
        if ((k.a(k.this) != null) && (k.b(k.this))) {
          k.a(k.this).YC();
        }
        if (k.f(k.this) != null) {
          k.f(k.this).onError();
        }
        try
        {
          k.a(k.this, -1);
          if (k.c(k.this) != null)
          {
            ac.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            k.c(k.this).stop();
            k.c(k.this).release();
            k.d(k.this);
          }
          AppMethodBeat.o(130047);
          return false;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            ac.e("MicroMsg.SilkPlayer", "setErrorListener File[" + k.e(k.this) + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          }
        }
      }
    };
    idf += 1;
    this.idh = idf;
    ac.i("MicroMsg.SilkPlayer", "[%d] new Instance", new Object[] { Integer.valueOf(this.idh) });
    AppMethodBeat.o(130050);
  }
  
  public k(Context paramContext)
  {
    this();
    AppMethodBeat.i(130051);
    this.icX = new com.tencent.mm.compatible.util.b(paramContext);
    AppMethodBeat.o(130051);
  }
  
  private void Ex(String paramString)
  {
    AppMethodBeat.i(130057);
    idg = this.idh;
    ac.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", new Object[] { Integer.valueOf(this.idh) });
    for (;;)
    {
      try
      {
        paramString = com.tencent.mm.vfs.i.openRead(paramString);
        j = paramString.available();
        ac.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", new Object[] { Integer.valueOf(j) });
        k = AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2);
        if ((!com.tencent.mm.plugin.audio.c.a.bCy()) || (j >= k * 2)) {
          continue;
        }
        this.idl = 1;
        localObject = new byte[j];
        paramString.read((byte[])localObject, 0, j);
        i = localObject[0];
        l = MediaRecorder.icC;
        this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[] { i }, l);
        if (this.ido != null) {
          ac.i("MicroMsg.SilkPlayer", "silkdec uninit success: %d".concat(String.valueOf(MediaRecorder.SilkDecUnInit(this.ido.decodeHandle))));
        }
        this.ido = new h(this.mSampleRate, (byte[])localObject, j);
        j = -1;
        localObject = com.tencent.mm.model.c.d.aAp().tJ("100268");
        if (!((c)localObject).isValid()) {
          break label473;
        }
        j = bs.getInt((String)((c)localObject).eYV().get("SilkAudioPlayerAgcOn"), 0);
      }
      catch (Exception paramString)
      {
        int k;
        Object localObject;
        int i;
        long l;
        short s;
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(161L, 1L, 1L, false);
        ac.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bs.m(paramString) });
        continue;
        j += 1;
        continue;
        AppMethodBeat.o(130057);
        return;
      }
      i = (byte)j;
      localObject = this.ido;
      int j = idn;
      l = ((h)localObject).decodeHandle;
      MediaRecorder.SetVoiceSilkDecControl(j, new byte[] { i }, 1, l);
      paramString.close();
      ac.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", new Object[] { Integer.valueOf(this.idh), Integer.valueOf(this.idi) });
      paramString = new byte[AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2];
      s = (short)(this.mSampleRate * 20 / 1000);
      j = 0;
      if (j < this.idi) {
        if (this.ido != null)
        {
          k = this.ido.a(paramString, s);
          if (k <= 0)
          {
            ac.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", new Object[] { Integer.valueOf(this.idh), Integer.valueOf(k) });
            AppMethodBeat.o(130057);
            return;
            this.idl = 8;
            continue;
          }
        }
      }
      label473:
      if (1 != j) {
        if (j != 0) {}
      }
    }
  }
  
  private static boolean Ey(String paramString)
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
          ac.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
          AppMethodBeat.o(130067);
          return false;
        }
        paramString = paramString.substring(0, i + 1);
        e locale = new e(paramString);
        if (!locale.exists())
        {
          if (locale.mkdirs()) {
            break label153;
          }
          if (locale.isDirectory())
          {
            break label153;
            ac.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", new Object[] { paramString, Boolean.valueOf(bool) });
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
        ac.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(130067);
        return false;
      }
    }
  }
  
  private boolean X(String paramString, boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(130056);
    if (this.mStatus != 0)
    {
      ac.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
      AppMethodBeat.o(130056);
      return false;
    }
    if (ab.iwm) {
      by(paramString, g.cWx);
    }
    ac.i("MicroMsg.SilkPlayer", "startPlay");
    this.mStatus = 1;
    this.mFileName = paramString;
    for (;;)
    {
      int i;
      synchronized (ide)
      {
        Ex(paramString);
        if (ab.iwm)
        {
          paramString = g.cWw;
          if (this.cVV == 2)
          {
            i = 1;
            this.idj = new com.tencent.mm.audio.e.b(paramString, i, this.mSampleRate);
          }
        }
        else
        {
          int k = this.mSampleRate;
          i = j;
          if (this.cVV == 2) {
            i = 1;
          }
          ac.d("MicroMsg.SilkPlayer", "startPlay, sampleRate: %d, channelCnt: %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        }
      }
      try
      {
        paramBoolean = eZ(paramBoolean);
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
          paramBoolean = eZ(true);
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
          ac.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bs.m(paramString) });
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
    //   0: ldc_w 402
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 120
    //   8: ldc_w 404
    //   11: invokestatic 406	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 90	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   18: invokestatic 409	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   21: ifne +30 -> 51
    //   24: ldc 120
    //   26: ldc_w 411
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 90	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   39: aastore
    //   40: invokestatic 276	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: ldc_w 402
    //   46: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: ldc 120
    //   53: ldc_w 413
    //   56: invokestatic 406	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: bipush 240
    //   61: invokestatic 418	android/os/Process:setThreadPriority	(I)V
    //   64: aload_0
    //   65: getfield 86	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   68: iconst_2
    //   69: iconst_2
    //   70: invokestatic 174	android/media/AudioTrack:getMinBufferSize	(III)I
    //   73: iconst_1
    //   74: ishl
    //   75: newarray byte
    //   77: astore 6
    //   79: aload_0
    //   80: getfield 86	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   83: bipush 20
    //   85: imul
    //   86: sipush 1000
    //   89: idiv
    //   90: i2s
    //   91: istore_3
    //   92: aload_1
    //   93: invokestatic 420	com/tencent/mm/modelvoice/k:Ey	(Ljava/lang/String;)Z
    //   96: pop
    //   97: aload_1
    //   98: iconst_0
    //   99: invokestatic 424	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   102: astore 5
    //   104: aload_0
    //   105: getfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   108: iconst_1
    //   109: if_icmpeq +11 -> 120
    //   112: aload_0
    //   113: getfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   116: iconst_2
    //   117: if_icmpne +138 -> 255
    //   120: aload_2
    //   121: aload 6
    //   123: iload_3
    //   124: invokevirtual 271	com/tencent/mm/modelvoice/h:a	([BS)I
    //   127: istore 4
    //   129: iload 4
    //   131: ifge +79 -> 210
    //   134: aload_0
    //   135: iconst_0
    //   136: putfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   139: goto -35 -> 104
    //   142: astore_1
    //   143: ldc 120
    //   145: new 345	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 426
    //   152: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_1
    //   156: invokevirtual 338	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 357	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: ldc 120
    //   170: ldc_w 290
    //   173: iconst_1
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_1
    //   180: invokestatic 294	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   183: aastore
    //   184: invokestatic 276	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: aload_0
    //   188: iconst_0
    //   189: putfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   192: aload 5
    //   194: ifnull +8 -> 202
    //   197: aload 5
    //   199: invokevirtual 429	java/io/OutputStream:close	()V
    //   202: ldc_w 402
    //   205: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aconst_null
    //   209: areturn
    //   210: aload_0
    //   211: getfield 96	com/tencent/mm/modelvoice/k:idb	Z
    //   214: ifeq +12 -> 226
    //   217: ldc2_w 430
    //   220: invokestatic 437	java/lang/Thread:sleep	(J)V
    //   223: goto -13 -> 210
    //   226: aload 5
    //   228: aload 6
    //   230: iconst_0
    //   231: iload_3
    //   232: iconst_2
    //   233: imul
    //   234: invokevirtual 441	java/io/OutputStream:write	([BII)V
    //   237: aload 5
    //   239: invokevirtual 444	java/io/OutputStream:flush	()V
    //   242: iload 4
    //   244: ifne -140 -> 104
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   252: goto -148 -> 104
    //   255: ldc 120
    //   257: ldc_w 446
    //   260: invokestatic 406	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload 5
    //   265: invokevirtual 429	java/io/OutputStream:close	()V
    //   268: aload_2
    //   269: getfield 203	com/tencent/mm/modelvoice/h:decodeHandle	J
    //   272: invokestatic 207	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	(J)I
    //   275: istore 4
    //   277: ldc 120
    //   279: ldc_w 448
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: aload_0
    //   289: getfield 118	com/tencent/mm/modelvoice/k:idh	I
    //   292: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: aastore
    //   296: invokestatic 133	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: iload 4
    //   301: ifeq +19 -> 320
    //   304: ldc 120
    //   306: ldc_w 450
    //   309: iload 4
    //   311: invokestatic 212	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   314: invokevirtual 216	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   317: invokestatic 357	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: ldc_w 402
    //   323: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: areturn
    //   328: astore_1
    //   329: ldc 120
    //   331: aload_1
    //   332: ldc 88
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 454	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: goto -139 -> 202
    //   344: astore_1
    //   345: ldc 120
    //   347: new 345	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 456
    //   354: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload_1
    //   358: invokevirtual 338	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   361: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 357	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: ldc 120
    //   372: ldc_w 290
    //   375: iconst_1
    //   376: anewarray 4	java/lang/Object
    //   379: dup
    //   380: iconst_0
    //   381: aload_1
    //   382: invokestatic 294	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   385: aastore
    //   386: invokestatic 276	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: ldc_w 402
    //   392: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private boolean aKi()
  {
    AppMethodBeat.i(130059);
    if (this.mAudioTrack != null) {
      try
      {
        ac.i("MicroMsg.SilkPlayer", "play");
        this.mAudioTrack.play();
        this.icW = new a((byte)0);
        com.tencent.e.h.JZN.aS(this.icW);
        AppMethodBeat.o(130059);
        return true;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(161L, 3L, 1L, false);
        AppMethodBeat.o(130059);
        return false;
      }
    }
    AppMethodBeat.o(130059);
    return false;
  }
  
  private void eY(boolean paramBoolean)
  {
    AppMethodBeat.i(130053);
    if (this.mAudioTrack != null) {
      ac.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
    }
    try
    {
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
      this.mAudioTrack = com.tencent.mm.audio.c.a.a(paramBoolean, this.mSampleRate, this.cVV, this.idl);
      if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() == 0))
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(161L, 2L, 1L, false);
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
        ac.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", new Object[] { localException1.getMessage() });
      }
      AppMethodBeat.o(130053);
    }
  }
  
  private boolean eZ(boolean paramBoolean)
  {
    AppMethodBeat.i(130058);
    if (!com.tencent.mm.vfs.i.eA(this.mFileName))
    {
      AppMethodBeat.o(130058);
      return false;
    }
    try
    {
      eY(paramBoolean);
      this.idk = new com.tencent.mm.audio.c.a.a();
      if (this.mAudioTrack != null)
      {
        if ((this.icX != null) && (this.idm)) {
          this.icX.requestFocus();
        }
        paramBoolean = aKi();
        AppMethodBeat.o(130058);
        return paramBoolean;
      }
    }
    catch (Exception localException)
    {
      if ((this.icX != null) && (this.idm)) {
        this.icX.YC();
      }
      ac.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + localException.getMessage());
      ac.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bs.m(localException) });
      AppMethodBeat.o(130058);
    }
    return false;
  }
  
  /* Error */
  public final boolean Fb()
  {
    // Byte code:
    //   0: ldc_w 561
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 120
    //   8: new 345	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 563
    //   15: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   22: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 219	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   35: iconst_1
    //   36: if_icmpeq +44 -> 80
    //   39: aload_0
    //   40: getfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   43: iconst_2
    //   44: if_icmpeq +36 -> 80
    //   47: ldc 120
    //   49: new 345	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 565
    //   56: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   63: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 357	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc_w 561
    //   75: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: iconst_3
    //   82: putfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   85: aload_0
    //   86: getfield 98	com/tencent/mm/modelvoice/k:idc	Ljava/lang/String;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 98	com/tencent/mm/modelvoice/k:idc	Ljava/lang/String;
    //   96: invokevirtual 568	java/lang/Object:notify	()V
    //   99: aload_0
    //   100: getfield 142	com/tencent/mm/modelvoice/k:icX	Lcom/tencent/mm/compatible/util/b;
    //   103: ifnull +18 -> 121
    //   106: aload_0
    //   107: getfield 108	com/tencent/mm/modelvoice/k:idm	Z
    //   110: ifeq +11 -> 121
    //   113: aload_0
    //   114: getfield 142	com/tencent/mm/modelvoice/k:icX	Lcom/tencent/mm/compatible/util/b;
    //   117: invokevirtual 535	com/tencent/mm/compatible/util/b:YC	()Z
    //   120: pop
    //   121: aload_1
    //   122: monitorexit
    //   123: ldc_w 561
    //   126: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_2
    //   132: ldc 120
    //   134: ldc_w 290
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_2
    //   144: invokestatic 294	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 276	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 142	com/tencent/mm/modelvoice/k:icX	Lcom/tencent/mm/compatible/util/b;
    //   155: ifnull +18 -> 173
    //   158: aload_0
    //   159: getfield 108	com/tencent/mm/modelvoice/k:idm	Z
    //   162: ifeq +11 -> 173
    //   165: aload_0
    //   166: getfield 142	com/tencent/mm/modelvoice/k:icX	Lcom/tencent/mm/compatible/util/b;
    //   169: invokevirtual 535	com/tencent/mm/compatible/util/b:YC	()Z
    //   172: pop
    //   173: aload_1
    //   174: monitorexit
    //   175: ldc_w 561
    //   178: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_2
    //   184: aload_0
    //   185: getfield 142	com/tencent/mm/modelvoice/k:icX	Lcom/tencent/mm/compatible/util/b;
    //   188: ifnull +18 -> 206
    //   191: aload_0
    //   192: getfield 108	com/tencent/mm/modelvoice/k:idm	Z
    //   195: ifeq +11 -> 206
    //   198: aload_0
    //   199: getfield 142	com/tencent/mm/modelvoice/k:icX	Lcom/tencent/mm/compatible/util/b;
    //   202: invokevirtual 535	com/tencent/mm/compatible/util/b:YC	()Z
    //   205: pop
    //   206: ldc_w 561
    //   209: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: aload_1
    //   216: monitorexit
    //   217: ldc_w 561
    //   220: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   215	217	214	finally
  }
  
  public final double NW()
  {
    return 0.0D;
  }
  
  public final void a(d.a parama)
  {
    this.icY = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.icZ = paramb;
  }
  
  public final void aKe()
  {
    this.idm = false;
  }
  
  public final int aKj()
  {
    AppMethodBeat.i(130060);
    if (this.mAudioTrack != null)
    {
      int i = this.mAudioTrack.getStreamType();
      AppMethodBeat.o(130060);
      return i;
    }
    AppMethodBeat.o(130060);
    return 0;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(130064);
    if ((parama != null) && (this.icX != null)) {
      this.icX.a(parama);
    }
    AppMethodBeat.o(130064);
  }
  
  public final boolean bF(boolean paramBoolean)
  {
    AppMethodBeat.i(130061);
    if (this.mStatus != 1)
    {
      AppMethodBeat.o(130061);
      return false;
    }
    this.mStatus = 2;
    synchronized (this.idd)
    {
      try
      {
        ac.v("MicroMsg.SilkPlayer", "before mOk.wait");
        long l = System.currentTimeMillis();
        this.idd.wait();
        ac.v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - l));
        if ((this.icX != null) && (paramBoolean)) {
          this.icX.YC();
        }
        AppMethodBeat.o(130061);
        return true;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bs.m(localException) });
        AppMethodBeat.o(130061);
        return false;
      }
    }
  }
  
  /* Error */
  public final String by(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 603
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   10: ifeq +36 -> 46
    //   13: ldc 120
    //   15: new 345	java/lang/StringBuilder
    //   18: dup
    //   19: ldc_w 347
    //   22: invokespecial 348	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   29: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 357	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 603
    //   41: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   51: aload_0
    //   52: aload_1
    //   53: putfield 90	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   56: aload_1
    //   57: invokestatic 157	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 163	java/io/InputStream:available	()I
    //   65: istore 4
    //   67: iload 4
    //   69: newarray byte
    //   71: astore 7
    //   73: aload_1
    //   74: aload 7
    //   76: iconst_0
    //   77: iload 4
    //   79: invokevirtual 184	java/io/InputStream:read	([BII)I
    //   82: pop
    //   83: aload 7
    //   85: iconst_0
    //   86: baload
    //   87: istore_3
    //   88: getstatic 190	com/tencent/mm/modelvoice/MediaRecorder:icC	J
    //   91: lstore 5
    //   93: aload_0
    //   94: iconst_1
    //   95: newarray byte
    //   97: dup
    //   98: iconst_0
    //   99: iload_3
    //   100: bastore
    //   101: lload 5
    //   103: invokestatic 194	com/tencent/mm/modelvoice/MediaRecorder:SilkGetEncSampleRate	([BJ)I
    //   106: putfield 86	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   109: new 200	com/tencent/mm/modelvoice/h
    //   112: dup
    //   113: aload_0
    //   114: getfield 86	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   117: aload 7
    //   119: iload 4
    //   121: invokespecial 222	com/tencent/mm/modelvoice/h:<init>	(I[BI)V
    //   124: astore 7
    //   126: ldc 120
    //   128: ldc_w 605
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: getfield 118	com/tencent/mm/modelvoice/k:idh	I
    //   141: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: invokestatic 133	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_1
    //   149: invokevirtual 266	java/io/InputStream:close	()V
    //   152: aload_0
    //   153: aload_2
    //   154: aload 7
    //   156: invokespecial 607	com/tencent/mm/modelvoice/k:a	(Ljava/lang/String;Lcom/tencent/mm/modelvoice/h;)Ljava/lang/String;
    //   159: astore_2
    //   160: ldc_w 603
    //   163: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_2
    //   167: areturn
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_1
    //   171: ldc 120
    //   173: ldc_w 609
    //   176: iconst_2
    //   177: anewarray 4	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: aload_0
    //   183: getfield 90	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: aload_2
    //   190: invokevirtual 338	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 276	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 120
    //   199: ldc_w 290
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_2
    //   209: invokestatic 294	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 276	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_0
    //   217: iconst_m1
    //   218: putfield 92	com/tencent/mm/modelvoice/k:mStatus	I
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 266	java/io/InputStream:close	()V
    //   229: ldc_w 603
    //   232: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_1
    //   238: ldc 120
    //   240: aload_1
    //   241: ldc 88
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 454	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final boolean c(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(130055);
    paramBoolean = X(paramString, paramBoolean);
    AppMethodBeat.o(130055);
    return paramBoolean;
  }
  
  public final void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(130052);
    ac.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.idb = true;
    this.cVV = 2;
    eY(paramBoolean);
    try
    {
      this.mAudioTrack.play();
      this.idb = false;
      AppMethodBeat.o(130052);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(161L, 3L, 1L, false);
        ac.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(209887);
    boolean bool1;
    a locala;
    if (this.mStatus == 1)
    {
      bool1 = true;
      locala = this.icW;
      if ((this.icW != null) && (!this.icW.isDone())) {
        break label116;
      }
    }
    label116:
    for (boolean bool2 = true;; bool2 = false)
    {
      ac.i("MicroMsg.SilkPlayer", "isPlaying %s and mPlayRunnable is %s && mPlayRunnable is done %s", new Object[] { Boolean.valueOf(bool1), locala, Boolean.valueOf(bool2) });
      if ((this.mStatus != 1) && ((this.mStatus == 1) || (this.icW == null) || (this.icW.isDone()))) {
        break label121;
      }
      AppMethodBeat.o(209887);
      return true;
      bool1 = false;
      break;
    }
    label121:
    AppMethodBeat.o(209887);
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
    synchronized (this.idc)
    {
      try
      {
        ac.v("MicroMsg.SilkPlayer", "before mpause.notify");
        this.idc.notify();
        ac.v("MicroMsg.SilkPlayer", "after mpause.notify");
        if ((this.icX != null) && (this.idm)) {
          this.icX.requestFocus();
        }
        AppMethodBeat.o(130062);
        return true;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bs.m(localException) });
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
      AppMethodBeat.i(209886);
      String str = "SilkPlayer_play_" + k.i(k.this);
      AppMethodBeat.o(209886);
      return str;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 55
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: bipush 240
      //   7: invokestatic 60	android/os/Process:setThreadPriority	(I)V
      //   10: aload_0
      //   11: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   14: invokestatic 63	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   17: iconst_2
      //   18: iconst_2
      //   19: invokestatic 69	android/media/AudioTrack:getMinBufferSize	(III)I
      //   22: iconst_2
      //   23: imul
      //   24: istore_2
      //   25: iload_2
      //   26: newarray byte
      //   28: astore_3
      //   29: aload_0
      //   30: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   33: invokestatic 63	com/tencent/mm/modelvoice/k:g	(Lcom/tencent/mm/modelvoice/k;)I
      //   36: bipush 20
      //   38: imul
      //   39: sipush 1000
      //   42: idiv
      //   43: i2s
      //   44: istore_1
      //   45: ldc 71
      //   47: ldc 73
      //   49: iconst_2
      //   50: anewarray 75	java/lang/Object
      //   53: dup
      //   54: iconst_0
      //   55: iload_1
      //   56: invokestatic 81	java/lang/Short:valueOf	(S)Ljava/lang/Short;
      //   59: aastore
      //   60: dup
      //   61: iconst_1
      //   62: iload_2
      //   63: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   66: aastore
      //   67: invokestatic 92	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   70: ldc 71
      //   72: ldc 94
      //   74: invokestatic 97	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   77: aload_0
      //   78: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   81: invokestatic 100	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
      //   84: iconst_1
      //   85: if_icmpeq +14 -> 99
      //   88: aload_0
      //   89: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   92: invokestatic 100	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
      //   95: iconst_2
      //   96: if_icmpne +1089 -> 1185
      //   99: invokestatic 104	com/tencent/mm/modelvoice/k:access$800	()Ljava/lang/Object;
      //   102: astore 4
      //   104: aload 4
      //   106: monitorenter
      //   107: invokestatic 108	com/tencent/mm/modelvoice/k:aKk	()I
      //   110: aload_0
      //   111: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   114: invokestatic 41	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   117: if_icmpeq +83 -> 200
      //   120: ldc 71
      //   122: ldc 110
      //   124: iconst_2
      //   125: anewarray 75	java/lang/Object
      //   128: dup
      //   129: iconst_0
      //   130: aload_0
      //   131: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   134: invokestatic 41	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   137: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   140: aastore
      //   141: dup
      //   142: iconst_1
      //   143: invokestatic 108	com/tencent/mm/modelvoice/k:aKk	()I
      //   146: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   149: aastore
      //   150: invokestatic 112	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   153: aload_0
      //   154: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   157: invokestatic 115	com/tencent/mm/modelvoice/k:j	(Lcom/tencent/mm/modelvoice/k;)I
      //   160: pop
      //   161: aload_0
      //   162: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   165: invokestatic 118	com/tencent/mm/modelvoice/k:k	(Lcom/tencent/mm/modelvoice/k;)I
      //   168: iconst_3
      //   169: if_icmple +17 -> 186
      //   172: getstatic 124	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
      //   175: ldc2_w 125
      //   178: ldc2_w 127
      //   181: lconst_1
      //   182: iconst_0
      //   183: invokevirtual 132	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   186: aload_0
      //   187: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   190: aload_0
      //   191: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   194: invokestatic 136	com/tencent/mm/modelvoice/k:e	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   197: invokestatic 139	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;Ljava/lang/String;)V
      //   200: aload 4
      //   202: monitorexit
      //   203: aload_0
      //   204: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   207: invokestatic 143	com/tencent/mm/modelvoice/k:l	(Lcom/tencent/mm/modelvoice/k;)Z
      //   210: ifeq +307 -> 517
      //   213: ldc 71
      //   215: ldc 145
      //   217: invokestatic 147	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   220: ldc2_w 148
      //   223: invokestatic 155	java/lang/Thread:sleep	(J)V
      //   226: goto -23 -> 203
      //   229: astore_3
      //   230: getstatic 124	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
      //   233: ldc2_w 125
      //   236: lconst_0
      //   237: lconst_1
      //   238: iconst_0
      //   239: invokevirtual 132	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   242: ldc 71
      //   244: ldc 157
      //   246: iconst_1
      //   247: anewarray 75	java/lang/Object
      //   250: dup
      //   251: iconst_0
      //   252: aload_3
      //   253: invokestatic 163	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   256: aastore
      //   257: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   260: aload_0
      //   261: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   264: invokestatic 169	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnErrorListener;
      //   267: ifnull +19 -> 286
      //   270: aload_0
      //   271: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   274: invokestatic 169	com/tencent/mm/modelvoice/k:s	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnErrorListener;
      //   277: aconst_null
      //   278: iconst_0
      //   279: iconst_0
      //   280: invokeinterface 175 4 0
      //   285: pop
      //   286: aload_0
      //   287: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   290: iconst_0
      //   291: invokestatic 178	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   294: pop
      //   295: invokestatic 104	com/tencent/mm/modelvoice/k:access$800	()Ljava/lang/Object;
      //   298: astore_3
      //   299: aload_3
      //   300: monitorenter
      //   301: invokestatic 108	com/tencent/mm/modelvoice/k:aKk	()I
      //   304: aload_0
      //   305: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   308: invokestatic 41	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   311: if_icmpne +63 -> 374
      //   314: aload_0
      //   315: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   318: invokestatic 181	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   321: ifnull +53 -> 374
      //   324: aload_0
      //   325: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   328: invokestatic 181	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   331: getfield 187	com/tencent/mm/modelvoice/h:decodeHandle	J
      //   334: invokestatic 193	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	(J)I
      //   337: pop
      //   338: ldc 71
      //   340: ldc 195
      //   342: iconst_1
      //   343: anewarray 75	java/lang/Object
      //   346: dup
      //   347: iconst_0
      //   348: aload_0
      //   349: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   352: invokestatic 41	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   355: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   358: aastore
      //   359: invokestatic 112	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   362: invokestatic 198	com/tencent/mm/modelvoice/k:aKl	()I
      //   365: pop
      //   366: aload_0
      //   367: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   370: invokestatic 201	com/tencent/mm/modelvoice/k:t	(Lcom/tencent/mm/modelvoice/k;)I
      //   373: pop
      //   374: aload_3
      //   375: monitorexit
      //   376: aload_0
      //   377: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   380: invokestatic 100	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
      //   383: iconst_3
      //   384: if_icmpeq +847 -> 1231
      //   387: aload_0
      //   388: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   391: invokestatic 205	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/d$a;
      //   394: ifnull +15 -> 409
      //   397: aload_0
      //   398: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   401: invokestatic 205	com/tencent/mm/modelvoice/k:u	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/d$a;
      //   404: invokeinterface 210 1 0
      //   409: aload_0
      //   410: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   413: invokestatic 214	com/tencent/mm/modelvoice/k:v	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnCompletionListener;
      //   416: ifnull +16 -> 432
      //   419: aload_0
      //   420: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   423: invokestatic 214	com/tencent/mm/modelvoice/k:v	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/MediaPlayer$OnCompletionListener;
      //   426: aconst_null
      //   427: invokeinterface 219 2 0
      //   432: aload_0
      //   433: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   436: invokestatic 223	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   439: ifnull +61 -> 500
      //   442: aload_0
      //   443: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   446: invokestatic 223	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   449: iconst_0
      //   450: aload_0
      //   451: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   454: invokestatic 136	com/tencent/mm/modelvoice/k:e	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   457: aload_0
      //   458: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   461: invokevirtual 226	com/tencent/mm/modelvoice/k:aKj	()I
      //   464: invokevirtual 232	com/tencent/mm/audio/c/a/a:b	(ILjava/lang/String;I)V
      //   467: aload_0
      //   468: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   471: invokestatic 223	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   474: iconst_0
      //   475: invokevirtual 235	com/tencent/mm/audio/c/a/a:hJ	(I)V
      //   478: aload_0
      //   479: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   482: invokestatic 223	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   485: iconst_0
      //   486: invokevirtual 238	com/tencent/mm/audio/c/a/a:hK	(I)V
      //   489: aload_0
      //   490: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   493: invokestatic 223	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   496: iconst_0
      //   497: invokevirtual 241	com/tencent/mm/audio/c/a/a:hL	(I)V
      //   500: ldc 55
      //   502: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   505: return
      //   506: astore_3
      //   507: aload 4
      //   509: monitorexit
      //   510: ldc 55
      //   512: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   515: aload_3
      //   516: athrow
      //   517: aload_0
      //   518: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   521: invokestatic 181	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   524: ifnull +185 -> 709
      //   527: aload_0
      //   528: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   531: invokestatic 223	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   534: ifnull +62 -> 596
      //   537: aload_0
      //   538: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   541: invokestatic 223	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   544: iload_1
      //   545: aload_3
      //   546: invokevirtual 244	com/tencent/mm/audio/c/a/a:e	(I[B)V
      //   549: aload_0
      //   550: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   553: invokestatic 223	com/tencent/mm/modelvoice/k:n	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/c/a/a;
      //   556: iconst_0
      //   557: invokestatic 250	com/tencent/mm/plugin/audio/c/a:bCx	()Lcom/tencent/mm/plugin/audio/b/a;
      //   560: getfield 256	com/tencent/mm/plugin/audio/b/a:audioManager	Landroid/media/AudioManager;
      //   563: aload_0
      //   564: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   567: invokevirtual 226	com/tencent/mm/modelvoice/k:aKj	()I
      //   570: invokevirtual 262	android/media/AudioManager:getStreamVolume	(I)I
      //   573: bipush 100
      //   575: imul
      //   576: invokestatic 250	com/tencent/mm/plugin/audio/c/a:bCx	()Lcom/tencent/mm/plugin/audio/b/a;
      //   579: getfield 256	com/tencent/mm/plugin/audio/b/a:audioManager	Landroid/media/AudioManager;
      //   582: aload_0
      //   583: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   586: invokevirtual 226	com/tencent/mm/modelvoice/k:aKj	()I
      //   589: invokevirtual 265	android/media/AudioManager:getStreamMaxVolume	(I)I
      //   592: idiv
      //   593: invokevirtual 269	com/tencent/mm/audio/c/a/a:cg	(II)V
      //   596: aload_0
      //   597: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   600: invokestatic 181	com/tencent/mm/modelvoice/k:m	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/modelvoice/h;
      //   603: aload_3
      //   604: iload_1
      //   605: invokevirtual 272	com/tencent/mm/modelvoice/h:a	([BS)I
      //   608: istore_2
      //   609: iload_2
      //   610: ifge +162 -> 772
      //   613: aload_0
      //   614: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   617: iconst_0
      //   618: invokestatic 178	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   621: pop
      //   622: getstatic 124	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
      //   625: ldc2_w 125
      //   628: lconst_0
      //   629: lconst_1
      //   630: iconst_0
      //   631: invokevirtual 132	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   634: getstatic 124	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
      //   637: ldc2_w 125
      //   640: ldc2_w 273
      //   643: lconst_1
      //   644: iconst_0
      //   645: invokevirtual 132	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   648: ldc 71
      //   650: ldc_w 276
      //   653: iconst_2
      //   654: anewarray 75	java/lang/Object
      //   657: dup
      //   658: iconst_0
      //   659: aload_0
      //   660: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   663: invokestatic 41	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   666: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   669: aastore
      //   670: dup
      //   671: iconst_1
      //   672: iload_2
      //   673: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   676: aastore
      //   677: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   680: aload_0
      //   681: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   684: invokestatic 279	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   687: ifnull -610 -> 77
      //   690: getstatic 285	com/tencent/mm/platformtools/ab:iwm	Z
      //   693: ifeq -616 -> 77
      //   696: aload_0
      //   697: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   700: invokestatic 279	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   703: invokevirtual 290	com/tencent/mm/audio/e/b:closeFile	()V
      //   706: goto -629 -> 77
      //   709: aload_0
      //   710: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   713: iconst_0
      //   714: invokestatic 178	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   717: pop
      //   718: ldc 71
      //   720: ldc_w 292
      //   723: iconst_1
      //   724: anewarray 75	java/lang/Object
      //   727: dup
      //   728: iconst_0
      //   729: aload_0
      //   730: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   733: invokestatic 41	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   736: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   739: aastore
      //   740: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   743: aload_0
      //   744: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   747: invokestatic 279	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   750: ifnull -673 -> 77
      //   753: getstatic 285	com/tencent/mm/platformtools/ab:iwm	Z
      //   756: ifeq -679 -> 77
      //   759: aload_0
      //   760: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   763: invokestatic 279	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   766: invokevirtual 290	com/tencent/mm/audio/e/b:closeFile	()V
      //   769: goto -692 -> 77
      //   772: getstatic 285	com/tencent/mm/platformtools/ab:iwm	Z
      //   775: ifeq +28 -> 803
      //   778: aload_0
      //   779: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   782: invokestatic 279	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   785: ifnull +18 -> 803
      //   788: aload_0
      //   789: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   792: invokestatic 279	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   795: aload_3
      //   796: iload_1
      //   797: iconst_2
      //   798: imul
      //   799: invokevirtual 296	com/tencent/mm/audio/e/b:y	([BI)Z
      //   802: pop
      //   803: aload_0
      //   804: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   807: invokestatic 300	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   810: aload_3
      //   811: iconst_0
      //   812: iload_1
      //   813: iconst_2
      //   814: imul
      //   815: invokevirtual 304	android/media/AudioTrack:write	([BII)I
      //   818: pop
      //   819: aload_0
      //   820: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   823: invokestatic 307	com/tencent/mm/modelvoice/k:p	(Lcom/tencent/mm/modelvoice/k;)I
      //   826: pop
      //   827: iload_2
      //   828: ifne +128 -> 956
      //   831: aload_0
      //   832: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   835: iconst_0
      //   836: invokestatic 178	com/tencent/mm/modelvoice/k:a	(Lcom/tencent/mm/modelvoice/k;I)I
      //   839: pop
      //   840: ldc 71
      //   842: ldc_w 309
      //   845: iconst_1
      //   846: anewarray 75	java/lang/Object
      //   849: dup
      //   850: iconst_0
      //   851: aload_0
      //   852: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   855: invokestatic 41	com/tencent/mm/modelvoice/k:i	(Lcom/tencent/mm/modelvoice/k;)I
      //   858: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   861: aastore
      //   862: invokestatic 112	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   865: aload_0
      //   866: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   869: invokestatic 279	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   872: ifnull -795 -> 77
      //   875: getstatic 285	com/tencent/mm/platformtools/ab:iwm	Z
      //   878: ifeq -801 -> 77
      //   881: aload_0
      //   882: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   885: invokestatic 279	com/tencent/mm/modelvoice/k:o	(Lcom/tencent/mm/modelvoice/k;)Lcom/tencent/mm/audio/e/b;
      //   888: invokevirtual 290	com/tencent/mm/audio/e/b:closeFile	()V
      //   891: new 9	com/tencent/mm/modelvoice/k$a$1
      //   894: dup
      //   895: aload_0
      //   896: invokespecial 312	com/tencent/mm/modelvoice/k$a$1:<init>	(Lcom/tencent/mm/modelvoice/k$a;)V
      //   899: invokestatic 318	com/tencent/mm/sdk/platformtools/ap:f	(Ljava/lang/Runnable;)V
      //   902: goto -825 -> 77
      //   905: astore 4
      //   907: ldc 71
      //   909: ldc_w 320
      //   912: iconst_1
      //   913: anewarray 75	java/lang/Object
      //   916: dup
      //   917: iconst_0
      //   918: aload 4
      //   920: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   923: aastore
      //   924: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   927: getstatic 124	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
      //   930: ldc2_w 125
      //   933: lconst_0
      //   934: lconst_1
      //   935: iconst_0
      //   936: invokevirtual 132	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   939: getstatic 124	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
      //   942: ldc2_w 125
      //   945: ldc2_w 324
      //   948: lconst_1
      //   949: iconst_0
      //   950: invokevirtual 132	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
      //   953: goto -134 -> 819
      //   956: aload_0
      //   957: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   960: invokestatic 100	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
      //   963: iconst_2
      //   964: if_icmpne +158 -> 1122
      //   967: aload_0
      //   968: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   971: invokestatic 328	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   974: astore 4
      //   976: aload 4
      //   978: monitorenter
      //   979: ldc 71
      //   981: ldc_w 330
      //   984: invokestatic 332	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   987: aload_0
      //   988: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   991: invokestatic 328	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   994: invokevirtual 335	java/lang/Object:notify	()V
      //   997: ldc 71
      //   999: ldc_w 337
      //   1002: invokestatic 332	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1005: aload 4
      //   1007: monitorexit
      //   1008: aload_0
      //   1009: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1012: invokestatic 340	com/tencent/mm/modelvoice/k:r	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1015: astore 4
      //   1017: aload 4
      //   1019: monitorenter
      //   1020: ldc 71
      //   1022: ldc_w 342
      //   1025: invokestatic 332	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1028: aload_0
      //   1029: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1032: invokestatic 340	com/tencent/mm/modelvoice/k:r	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1035: invokevirtual 345	java/lang/Object:wait	()V
      //   1038: ldc 71
      //   1040: ldc_w 347
      //   1043: invokestatic 332	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;)V
      //   1046: aload 4
      //   1048: monitorexit
      //   1049: goto -972 -> 77
      //   1052: astore_3
      //   1053: aload 4
      //   1055: monitorexit
      //   1056: ldc 55
      //   1058: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1061: aload_3
      //   1062: athrow
      //   1063: astore 5
      //   1065: ldc 71
      //   1067: ldc 157
      //   1069: iconst_1
      //   1070: anewarray 75	java/lang/Object
      //   1073: dup
      //   1074: iconst_0
      //   1075: aload 5
      //   1077: invokestatic 163	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1080: aastore
      //   1081: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1084: goto -79 -> 1005
      //   1087: astore_3
      //   1088: aload 4
      //   1090: monitorexit
      //   1091: ldc 55
      //   1093: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1096: aload_3
      //   1097: athrow
      //   1098: astore 5
      //   1100: ldc 71
      //   1102: ldc 157
      //   1104: iconst_1
      //   1105: anewarray 75	java/lang/Object
      //   1108: dup
      //   1109: iconst_0
      //   1110: aload 5
      //   1112: invokestatic 163	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1115: aastore
      //   1116: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1119: goto -73 -> 1046
      //   1122: aload_0
      //   1123: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1126: invokestatic 328	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1129: astore 4
      //   1131: aload 4
      //   1133: monitorenter
      //   1134: aload_0
      //   1135: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1138: invokestatic 328	com/tencent/mm/modelvoice/k:q	(Lcom/tencent/mm/modelvoice/k;)Ljava/lang/String;
      //   1141: invokevirtual 335	java/lang/Object:notify	()V
      //   1144: aload 4
      //   1146: monitorexit
      //   1147: goto -1070 -> 77
      //   1150: astore_3
      //   1151: aload 4
      //   1153: monitorexit
      //   1154: ldc 55
      //   1156: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1159: aload_3
      //   1160: athrow
      //   1161: astore 5
      //   1163: ldc 71
      //   1165: ldc 157
      //   1167: iconst_1
      //   1168: anewarray 75	java/lang/Object
      //   1171: dup
      //   1172: iconst_0
      //   1173: aload 5
      //   1175: invokestatic 163	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1178: aastore
      //   1179: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1182: goto -38 -> 1144
      //   1185: aload_0
      //   1186: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1189: invokestatic 100	com/tencent/mm/modelvoice/k:h	(Lcom/tencent/mm/modelvoice/k;)I
      //   1192: iconst_3
      //   1193: if_icmpeq -898 -> 295
      //   1196: aload_0
      //   1197: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1200: invokestatic 300	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   1203: invokevirtual 350	android/media/AudioTrack:getPlayState	()I
      //   1206: iconst_3
      //   1207: if_icmpne -912 -> 295
      //   1210: ldc2_w 351
      //   1213: invokestatic 155	java/lang/Thread:sleep	(J)V
      //   1216: goto -921 -> 295
      //   1219: astore 4
      //   1221: aload_3
      //   1222: monitorexit
      //   1223: ldc 55
      //   1225: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1228: aload 4
      //   1230: athrow
      //   1231: aload_0
      //   1232: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1235: invokestatic 300	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   1238: ifnull -806 -> 432
      //   1241: ldc 71
      //   1243: ldc_w 354
      //   1246: invokestatic 97	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1249: aload_0
      //   1250: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1253: invokestatic 300	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   1256: invokevirtual 357	android/media/AudioTrack:stop	()V
      //   1259: aload_0
      //   1260: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1263: invokestatic 300	com/tencent/mm/modelvoice/k:c	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   1266: invokevirtual 360	android/media/AudioTrack:release	()V
      //   1269: aload_0
      //   1270: getfield 15	com/tencent/mm/modelvoice/k$a:idr	Lcom/tencent/mm/modelvoice/k;
      //   1273: invokestatic 362	com/tencent/mm/modelvoice/k:d	(Lcom/tencent/mm/modelvoice/k;)Landroid/media/AudioTrack;
      //   1276: pop
      //   1277: goto -845 -> 432
      //   1280: astore_3
      //   1281: ldc 71
      //   1283: ldc_w 364
      //   1286: iconst_1
      //   1287: anewarray 75	java/lang/Object
      //   1290: dup
      //   1291: iconst_0
      //   1292: aload_3
      //   1293: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1296: aastore
      //   1297: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1300: goto -868 -> 432
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1303	0	this	a
      //   44	771	1	s	short
      //   24	804	2	i	int
      //   28	1	3	arrayOfByte1	byte[]
      //   229	24	3	localException1	Exception
      //   298	77	3	localObject1	Object
      //   506	305	3	arrayOfByte2	byte[]
      //   1052	10	3	localObject2	Object
      //   1087	10	3	localObject3	Object
      //   1150	72	3	localObject4	Object
      //   1280	13	3	localException2	Exception
      //   102	406	4	localObject5	Object
      //   905	14	4	localException3	Exception
      //   1219	10	4	localObject6	Object
      //   1063	13	5	localException4	Exception
      //   1098	13	5	localException5	Exception
      //   1161	13	5	localException6	Exception
      // Exception table:
      //   from	to	target	type
      //   5	77	229	java/lang/Exception
      //   77	99	229	java/lang/Exception
      //   99	107	229	java/lang/Exception
      //   203	226	229	java/lang/Exception
      //   510	517	229	java/lang/Exception
      //   517	596	229	java/lang/Exception
      //   596	609	229	java/lang/Exception
      //   613	706	229	java/lang/Exception
      //   709	769	229	java/lang/Exception
      //   772	803	229	java/lang/Exception
      //   819	827	229	java/lang/Exception
      //   831	902	229	java/lang/Exception
      //   907	953	229	java/lang/Exception
      //   956	979	229	java/lang/Exception
      //   1008	1020	229	java/lang/Exception
      //   1056	1063	229	java/lang/Exception
      //   1091	1098	229	java/lang/Exception
      //   1122	1134	229	java/lang/Exception
      //   1154	1161	229	java/lang/Exception
      //   1185	1216	229	java/lang/Exception
      //   107	186	506	finally
      //   186	200	506	finally
      //   200	203	506	finally
      //   507	510	506	finally
      //   803	819	905	java/lang/Exception
      //   1020	1046	1052	finally
      //   1046	1049	1052	finally
      //   1053	1056	1052	finally
      //   1100	1119	1052	finally
      //   979	1005	1063	java/lang/Exception
      //   979	1005	1087	finally
      //   1005	1008	1087	finally
      //   1065	1084	1087	finally
      //   1088	1091	1087	finally
      //   1020	1046	1098	java/lang/Exception
      //   1134	1144	1150	finally
      //   1144	1147	1150	finally
      //   1151	1154	1150	finally
      //   1163	1182	1150	finally
      //   1134	1144	1161	java/lang/Exception
      //   301	374	1219	finally
      //   374	376	1219	finally
      //   1221	1223	1219	finally
      //   1249	1277	1280	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k
 * JD-Core Version:    0.7.0.1
 */