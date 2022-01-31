package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.c.a;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.util.Map;

public final class k
  implements d
{
  private static Object fZR;
  private static int fZS;
  private static int fZT;
  private static int fZZ;
  public int cjH;
  private k.a fZJ;
  private com.tencent.mm.compatible.util.b fZK;
  private d.a fZL;
  private d.b fZM;
  private int fZN;
  private volatile boolean fZO;
  private String fZP;
  private String fZQ;
  private int fZU;
  private int fZV;
  private com.tencent.mm.audio.e.b fZW;
  private int fZX;
  private boolean fZY;
  private h gaa;
  private MediaPlayer.OnCompletionListener gab;
  private MediaPlayer.OnErrorListener gac;
  private AudioTrack mAudioTrack;
  private String mFileName;
  public int mSampleRate;
  private volatile int mStatus;
  
  static
  {
    AppMethodBeat.i(55815);
    fZR = new Object();
    fZS = -1;
    fZZ = 100;
    AppMethodBeat.o(55815);
  }
  
  public k()
  {
    AppMethodBeat.i(55797);
    this.fZL = null;
    this.fZM = null;
    this.cjH = 2;
    this.mSampleRate = 16000;
    this.mFileName = "";
    this.mStatus = 0;
    this.fZN = 0;
    this.fZO = false;
    this.fZP = "";
    this.fZQ = "";
    this.fZV = 0;
    this.fZW = null;
    this.fZX = 8;
    this.fZY = true;
    this.gab = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(55793);
        if ((k.a(k.this) != null) && (k.b(k.this)))
        {
          ab.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
          k.a(k.this).Mh();
        }
        try
        {
          k.a(k.this, 0);
          if (k.c(k.this) != null)
          {
            ab.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            k.c(k.this).stop();
            k.c(k.this).release();
            k.d(k.this);
          }
          AppMethodBeat.o(55793);
          return;
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          ab.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bo.l(paramAnonymousMediaPlayer) });
          ab.e("MicroMsg.SilkPlayer", "setCompletion File[" + k.e(k.this) + "] ErrMsg[" + paramAnonymousMediaPlayer.getStackTrace() + "]");
          AppMethodBeat.o(55793);
        }
      }
    };
    this.gac = new k.2(this);
    fZS += 1;
    this.fZU = fZS;
    ab.i("MicroMsg.SilkPlayer", "[%d] new Instance", new Object[] { Integer.valueOf(this.fZU) });
    AppMethodBeat.o(55797);
  }
  
  public k(Context paramContext)
  {
    this();
    AppMethodBeat.i(55798);
    this.fZK = new com.tencent.mm.compatible.util.b(paramContext);
    AppMethodBeat.o(55798);
  }
  
  private boolean U(String paramString, boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(55803);
    if (this.mStatus != 0)
    {
      ab.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
      AppMethodBeat.o(55803);
      return false;
    }
    if (ae.glo) {
      ba(paramString, com.tencent.mm.audio.b.g.cki);
    }
    ab.i("MicroMsg.SilkPlayer", "startPlay");
    this.mStatus = 1;
    this.mFileName = paramString;
    for (;;)
    {
      int i;
      synchronized (fZR)
      {
        vF(paramString);
        if (ae.glo)
        {
          paramString = com.tencent.mm.audio.b.g.ckh;
          if (this.cjH == 2)
          {
            i = 1;
            this.fZW = new com.tencent.mm.audio.e.b(paramString, i, this.mSampleRate);
          }
        }
        else
        {
          int k = this.mSampleRate;
          i = j;
          if (this.cjH == 2) {
            i = 1;
          }
          ab.d("MicroMsg.SilkPlayer", "startPlay, sampleRate: %d, channelCnt: %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
        }
      }
      try
      {
        paramBoolean = dm(paramBoolean);
        AppMethodBeat.o(55803);
        return paramBoolean;
        paramString = finally;
        AppMethodBeat.o(55803);
        throw paramString;
        i = 2;
      }
      catch (Exception paramString)
      {
        try
        {
          paramBoolean = dm(true);
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
          ab.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bo.l(paramString) });
          this.mStatus = -1;
          AppMethodBeat.o(55803);
        }
      }
    }
    return false;
  }
  
  /* Error */
  private String a(String paramString, h paramh)
  {
    // Byte code:
    //   0: ldc 223
    //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 115
    //   7: ldc 225
    //   9: invokestatic 227	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 83	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   16: invokestatic 233	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   19: ifne +28 -> 47
    //   22: ldc 115
    //   24: ldc 235
    //   26: iconst_1
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 83	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   36: aastore
    //   37: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: ldc 223
    //   42: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aconst_null
    //   46: areturn
    //   47: ldc 115
    //   49: ldc 237
    //   51: invokestatic 227	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: bipush 240
    //   56: invokestatic 242	android/os/Process:setThreadPriority	(I)V
    //   59: aload_0
    //   60: getfield 79	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   63: iconst_2
    //   64: iconst_2
    //   65: invokestatic 248	android/media/AudioTrack:getMinBufferSize	(III)I
    //   68: iconst_1
    //   69: ishl
    //   70: newarray byte
    //   72: astore 6
    //   74: aload_0
    //   75: getfield 79	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   78: bipush 20
    //   80: imul
    //   81: sipush 1000
    //   84: idiv
    //   85: i2s
    //   86: istore_3
    //   87: aload_1
    //   88: invokestatic 251	com/tencent/mm/modelvoice/k:vG	(Ljava/lang/String;)Z
    //   91: pop
    //   92: aload_1
    //   93: iconst_0
    //   94: invokestatic 255	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   97: astore 5
    //   99: aload_0
    //   100: getfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   103: iconst_1
    //   104: if_icmpeq +11 -> 115
    //   107: aload_0
    //   108: getfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   111: iconst_2
    //   112: if_icmpne +136 -> 248
    //   115: aload_2
    //   116: aload 6
    //   118: iload_3
    //   119: invokevirtual 260	com/tencent/mm/modelvoice/h:a	([BS)I
    //   122: istore 4
    //   124: iload 4
    //   126: ifge +77 -> 203
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   134: goto -35 -> 99
    //   137: astore_1
    //   138: ldc 115
    //   140: new 144	java/lang/StringBuilder
    //   143: dup
    //   144: ldc_w 262
    //   147: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload_1
    //   151: invokevirtual 265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 161	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: ldc 115
    //   165: ldc 208
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_1
    //   174: invokestatic 214	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   177: aastore
    //   178: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   186: aload 5
    //   188: ifnull +8 -> 196
    //   191: aload 5
    //   193: invokevirtual 270	java/io/OutputStream:close	()V
    //   196: ldc 223
    //   198: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aconst_null
    //   202: areturn
    //   203: aload_0
    //   204: getfield 89	com/tencent/mm/modelvoice/k:fZO	Z
    //   207: ifeq +12 -> 219
    //   210: ldc2_w 271
    //   213: invokestatic 278	java/lang/Thread:sleep	(J)V
    //   216: goto -13 -> 203
    //   219: aload 5
    //   221: aload 6
    //   223: iconst_0
    //   224: iload_3
    //   225: iconst_2
    //   226: imul
    //   227: invokevirtual 282	java/io/OutputStream:write	([BII)V
    //   230: aload 5
    //   232: invokevirtual 285	java/io/OutputStream:flush	()V
    //   235: iload 4
    //   237: ifne -138 -> 99
    //   240: aload_0
    //   241: iconst_0
    //   242: putfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   245: goto -146 -> 99
    //   248: ldc 115
    //   250: ldc_w 287
    //   253: invokestatic 227	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload 5
    //   258: invokevirtual 270	java/io/OutputStream:close	()V
    //   261: aload_2
    //   262: getfield 291	com/tencent/mm/modelvoice/h:fZH	J
    //   265: invokestatic 297	com/tencent/mm/modelvoice/MediaRecorder:SilkDecUnInit	(J)I
    //   268: istore 4
    //   270: ldc 115
    //   272: ldc_w 299
    //   275: iconst_1
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: aload_0
    //   282: getfield 113	com/tencent/mm/modelvoice/k:fZU	I
    //   285: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: aastore
    //   289: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: iload 4
    //   294: ifeq +19 -> 313
    //   297: ldc 115
    //   299: ldc_w 301
    //   302: iload 4
    //   304: invokestatic 306	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   307: invokevirtual 310	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokestatic 161	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: ldc 223
    //   315: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aload_1
    //   319: areturn
    //   320: astore_1
    //   321: ldc 115
    //   323: aload_1
    //   324: ldc 81
    //   326: iconst_0
    //   327: anewarray 4	java/lang/Object
    //   330: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   333: goto -137 -> 196
    //   336: astore_1
    //   337: ldc 115
    //   339: new 144	java/lang/StringBuilder
    //   342: dup
    //   343: ldc_w 316
    //   346: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: aload_1
    //   350: invokevirtual 265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   353: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 161	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: ldc 115
    //   364: ldc 208
    //   366: iconst_1
    //   367: anewarray 4	java/lang/Object
    //   370: dup
    //   371: iconst_0
    //   372: aload_1
    //   373: invokestatic 214	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   376: aastore
    //   377: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: ldc 223
    //   382: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   385: aconst_null
    //   386: areturn
    //   387: astore_1
    //   388: aconst_null
    //   389: astore 5
    //   391: goto -253 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	k
    //   0	394	1	paramString	String
    //   0	394	2	paramh	h
    //   86	141	3	s	short
    //   122	181	4	i	int
    //   97	293	5	localOutputStream	java.io.OutputStream
    //   72	150	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   99	115	137	java/lang/Exception
    //   115	124	137	java/lang/Exception
    //   129	134	137	java/lang/Exception
    //   203	216	137	java/lang/Exception
    //   219	235	137	java/lang/Exception
    //   240	245	137	java/lang/Exception
    //   248	261	137	java/lang/Exception
    //   191	196	320	java/io/IOException
    //   138	186	336	java/lang/Exception
    //   191	196	336	java/lang/Exception
    //   261	292	336	java/lang/Exception
    //   297	313	336	java/lang/Exception
    //   321	333	336	java/lang/Exception
    //   47	99	387	java/lang/Exception
  }
  
  private boolean amm()
  {
    AppMethodBeat.i(55806);
    if (this.mAudioTrack != null) {
      try
      {
        ab.i("MicroMsg.SilkPlayer", "play");
        this.mAudioTrack.play();
        this.fZJ = new k.a(this, (byte)0);
        com.tencent.mm.sdk.g.d.f(this.fZJ, "SilkPlayer_play_" + this.fZU);
        AppMethodBeat.o(55806);
        return true;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(161L, 3L, 1L, false);
        AppMethodBeat.o(55806);
        return false;
      }
    }
    AppMethodBeat.o(55806);
    return false;
  }
  
  private void dl(boolean paramBoolean)
  {
    AppMethodBeat.i(55800);
    if (this.mAudioTrack != null) {
      ab.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
    }
    try
    {
      this.mAudioTrack.stop();
      this.mAudioTrack.release();
      this.mAudioTrack = null;
      this.mAudioTrack = a.a(paramBoolean, this.mSampleRate, this.cjH, this.fZX);
      if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() == 0))
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(161L, 2L, 1L, false);
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
          AppMethodBeat.o(55800);
          return;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        ab.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", new Object[] { localException1.getMessage() });
      }
      AppMethodBeat.o(55800);
    }
  }
  
  private boolean dm(boolean paramBoolean)
  {
    AppMethodBeat.i(55805);
    if (!e.cN(this.mFileName))
    {
      AppMethodBeat.o(55805);
      return false;
    }
    try
    {
      dl(paramBoolean);
      if (this.mAudioTrack != null)
      {
        if ((this.fZK != null) && (this.fZY)) {
          this.fZK.requestFocus();
        }
        paramBoolean = amm();
        AppMethodBeat.o(55805);
        return paramBoolean;
      }
    }
    catch (Exception localException)
    {
      if ((this.fZK != null) && (this.fZY)) {
        this.fZK.Mh();
      }
      ab.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + localException.getMessage());
      ab.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bo.l(localException) });
      AppMethodBeat.o(55805);
    }
    return false;
  }
  
  private void vF(String paramString)
  {
    AppMethodBeat.i(55804);
    fZT = this.fZU;
    ab.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", new Object[] { Integer.valueOf(this.fZU) });
    for (;;)
    {
      try
      {
        paramString = e.openRead(paramString);
        j = paramString.available();
        ab.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", new Object[] { Integer.valueOf(j) });
        k = AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2);
        if ((!com.tencent.mm.compatible.b.g.KC().KH()) || (j >= k * 2)) {
          continue;
        }
        this.fZX = 1;
        localObject = new byte[j];
        paramString.read((byte[])localObject, 0, j);
        i = localObject[0];
        l = MediaRecorder.fZo;
        this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[] { i }, l);
        if (this.gaa != null) {
          ab.i("MicroMsg.SilkPlayer", "silkdec uninit success: %d".concat(String.valueOf(MediaRecorder.SilkDecUnInit(this.gaa.fZH))));
        }
        this.gaa = new h(this.mSampleRate, (byte[])localObject, j);
        j = -1;
        localObject = com.tencent.mm.model.c.c.abU().me("100268");
        if (!((com.tencent.mm.storage.c)localObject).isValid()) {
          break label483;
        }
        j = bo.getInt((String)((com.tencent.mm.storage.c)localObject).dvN().get("SilkAudioPlayerAgcOn"), 0);
      }
      catch (Exception paramString)
      {
        int k;
        Object localObject;
        int i;
        long l;
        short s;
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(161L, 1L, 1L, false);
        ab.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bo.l(paramString) });
        continue;
        j += 1;
        continue;
        AppMethodBeat.o(55804);
        return;
      }
      i = (byte)j;
      localObject = this.gaa;
      int j = fZZ;
      l = ((h)localObject).fZH;
      MediaRecorder.SetVoiceSilkDecControl(j, new byte[] { i }, 1, l);
      paramString.close();
      ab.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", new Object[] { Integer.valueOf(this.fZU), Integer.valueOf(this.fZV) });
      paramString = new byte[AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2];
      s = (short)(this.mSampleRate * 20 / 1000);
      j = 0;
      if (j < this.fZV) {
        if (this.gaa != null)
        {
          k = this.gaa.a(paramString, s);
          if (k <= 0)
          {
            ab.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", new Object[] { Integer.valueOf(this.fZU), Integer.valueOf(k) });
            AppMethodBeat.o(55804);
            return;
            this.fZX = 8;
            continue;
          }
        }
      }
      label483:
      if (1 != j) {
        if (j != 0) {}
      }
    }
  }
  
  private static boolean vG(String paramString)
  {
    AppMethodBeat.i(55813);
    if (paramString == null)
    {
      AppMethodBeat.o(55813);
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
          ab.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
          AppMethodBeat.o(55813);
          return false;
        }
        paramString = paramString.substring(0, i + 1);
        com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(paramString);
        if (!localb.exists())
        {
          if (localb.mkdirs()) {
            break label153;
          }
          if (localb.isDirectory())
          {
            break label153;
            ab.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", new Object[] { paramString, Boolean.valueOf(bool) });
          }
        }
        else
        {
          AppMethodBeat.o(55813);
          return true;
        }
        boolean bool = false;
        continue;
        bool = true;
      }
      catch (Exception paramString)
      {
        ab.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(55813);
        return false;
      }
    }
  }
  
  public final boolean Eo()
  {
    AppMethodBeat.i(55808);
    if (this.mStatus != 2)
    {
      AppMethodBeat.o(55808);
      return false;
    }
    this.mStatus = 1;
    synchronized (this.fZP)
    {
      try
      {
        ab.v("MicroMsg.SilkPlayer", "before mpause.notify");
        this.fZP.notify();
        ab.v("MicroMsg.SilkPlayer", "after mpause.notify");
        if ((this.fZK != null) && (this.fZY)) {
          this.fZK.requestFocus();
        }
        AppMethodBeat.o(55808);
        return true;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bo.l(localException) });
        AppMethodBeat.o(55808);
        return false;
      }
    }
  }
  
  public final double Er()
  {
    return 0.0D;
  }
  
  /* Error */
  public final boolean Ez()
  {
    // Byte code:
    //   0: ldc_w 563
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 115
    //   8: new 144	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 565
    //   15: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   22: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 179	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   35: iconst_1
    //   36: if_icmpeq +44 -> 80
    //   39: aload_0
    //   40: getfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   43: iconst_2
    //   44: if_icmpeq +36 -> 80
    //   47: ldc 115
    //   49: new 144	java/lang/StringBuilder
    //   52: dup
    //   53: ldc_w 567
    //   56: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   63: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 161	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc_w 563
    //   75: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload_0
    //   81: iconst_3
    //   82: putfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   85: aload_0
    //   86: getfield 91	com/tencent/mm/modelvoice/k:fZP	Ljava/lang/String;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 91	com/tencent/mm/modelvoice/k:fZP	Ljava/lang/String;
    //   96: invokevirtual 557	java/lang/Object:notify	()V
    //   99: aload_0
    //   100: getfield 137	com/tencent/mm/modelvoice/k:fZK	Lcom/tencent/mm/compatible/util/b;
    //   103: ifnull +18 -> 121
    //   106: aload_0
    //   107: getfield 101	com/tencent/mm/modelvoice/k:fZY	Z
    //   110: ifeq +11 -> 121
    //   113: aload_0
    //   114: getfield 137	com/tencent/mm/modelvoice/k:fZK	Lcom/tencent/mm/compatible/util/b;
    //   117: invokevirtual 401	com/tencent/mm/compatible/util/b:Mh	()Z
    //   120: pop
    //   121: aload_1
    //   122: monitorexit
    //   123: ldc_w 563
    //   126: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_1
    //   130: ireturn
    //   131: astore_2
    //   132: ldc 115
    //   134: ldc 208
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_2
    //   143: invokestatic 214	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   146: aastore
    //   147: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: aload_0
    //   151: getfield 137	com/tencent/mm/modelvoice/k:fZK	Lcom/tencent/mm/compatible/util/b;
    //   154: ifnull +18 -> 172
    //   157: aload_0
    //   158: getfield 101	com/tencent/mm/modelvoice/k:fZY	Z
    //   161: ifeq +11 -> 172
    //   164: aload_0
    //   165: getfield 137	com/tencent/mm/modelvoice/k:fZK	Lcom/tencent/mm/compatible/util/b;
    //   168: invokevirtual 401	com/tencent/mm/compatible/util/b:Mh	()Z
    //   171: pop
    //   172: aload_1
    //   173: monitorexit
    //   174: ldc_w 563
    //   177: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_2
    //   183: aload_0
    //   184: getfield 137	com/tencent/mm/modelvoice/k:fZK	Lcom/tencent/mm/compatible/util/b;
    //   187: ifnull +18 -> 205
    //   190: aload_0
    //   191: getfield 101	com/tencent/mm/modelvoice/k:fZY	Z
    //   194: ifeq +11 -> 205
    //   197: aload_0
    //   198: getfield 137	com/tencent/mm/modelvoice/k:fZK	Lcom/tencent/mm/compatible/util/b;
    //   201: invokevirtual 401	com/tencent/mm/compatible/util/b:Mh	()Z
    //   204: pop
    //   205: ldc_w 563
    //   208: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_2
    //   212: athrow
    //   213: astore_2
    //   214: aload_1
    //   215: monitorexit
    //   216: ldc_w 563
    //   219: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_2
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	k
    //   89	126	1	str	String
    //   131	12	2	localException	Exception
    //   182	30	2	localObject1	Object
    //   213	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   92	99	131	java/lang/Exception
    //   92	99	182	finally
    //   132	150	182	finally
    //   99	121	213	finally
    //   121	123	213	finally
    //   150	172	213	finally
    //   172	174	213	finally
    //   183	205	213	finally
    //   205	213	213	finally
    //   214	216	213	finally
  }
  
  public final boolean T(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(55801);
    paramBoolean = U(paramString, paramBoolean);
    AppMethodBeat.o(55801);
    return paramBoolean;
  }
  
  public final void a(d.a parama)
  {
    this.fZL = parama;
  }
  
  public final void a(d.b paramb)
  {
    this.fZM = paramb;
  }
  
  public final void ami()
  {
    this.fZY = false;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(55810);
    if ((parama != null) && (this.fZK != null)) {
      this.fZK.a(parama);
    }
    AppMethodBeat.o(55810);
  }
  
  /* Error */
  public final String ba(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 579
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   10: ifeq +35 -> 45
    //   13: ldc 115
    //   15: new 144	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 146
    //   21: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: getfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   28: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 161	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc_w 579
    //   40: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aconst_null
    //   44: areturn
    //   45: aload_0
    //   46: iconst_1
    //   47: putfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   50: aload_0
    //   51: aload_1
    //   52: putfield 83	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   55: aload_1
    //   56: invokestatic 432	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 437	java/io/InputStream:available	()I
    //   64: istore 4
    //   66: iload 4
    //   68: newarray byte
    //   70: astore 7
    //   72: aload_1
    //   73: aload 7
    //   75: iconst_0
    //   76: iload 4
    //   78: invokevirtual 452	java/io/InputStream:read	([BII)I
    //   81: pop
    //   82: aload 7
    //   84: iconst_0
    //   85: baload
    //   86: istore_3
    //   87: getstatic 455	com/tencent/mm/modelvoice/MediaRecorder:fZo	J
    //   90: lstore 5
    //   92: aload_0
    //   93: iconst_1
    //   94: newarray byte
    //   96: dup
    //   97: iconst_0
    //   98: iload_3
    //   99: bastore
    //   100: lload 5
    //   102: invokestatic 459	com/tencent/mm/modelvoice/MediaRecorder:SilkGetEncSampleRate	([BJ)I
    //   105: putfield 79	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   108: new 257	com/tencent/mm/modelvoice/h
    //   111: dup
    //   112: aload_0
    //   113: getfield 79	com/tencent/mm/modelvoice/k:mSampleRate	I
    //   116: aload 7
    //   118: iload 4
    //   120: invokespecial 464	com/tencent/mm/modelvoice/h:<init>	(I[BI)V
    //   123: astore 7
    //   125: ldc 115
    //   127: ldc_w 581
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_0
    //   137: getfield 113	com/tencent/mm/modelvoice/k:fZU	I
    //   140: invokestatic 123	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aastore
    //   144: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload_1
    //   148: invokevirtual 504	java/io/InputStream:close	()V
    //   151: aload_0
    //   152: aload_2
    //   153: aload 7
    //   155: invokespecial 583	com/tencent/mm/modelvoice/k:a	(Ljava/lang/String;Lcom/tencent/mm/modelvoice/h;)Ljava/lang/String;
    //   158: astore_2
    //   159: ldc_w 579
    //   162: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_2
    //   166: areturn
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_1
    //   170: ldc 115
    //   172: ldc_w 585
    //   175: iconst_2
    //   176: anewarray 4	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload_0
    //   182: getfield 83	com/tencent/mm/modelvoice/k:mFileName	Ljava/lang/String;
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: aload_2
    //   189: invokevirtual 265	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: ldc 115
    //   198: ldc 208
    //   200: iconst_1
    //   201: anewarray 4	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_2
    //   207: invokestatic 214	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   210: aastore
    //   211: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: aload_0
    //   215: iconst_m1
    //   216: putfield 85	com/tencent/mm/modelvoice/k:mStatus	I
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 504	java/io/InputStream:close	()V
    //   227: ldc_w 579
    //   230: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_1
    //   236: ldc 115
    //   238: aload_1
    //   239: ldc 81
    //   241: iconst_0
    //   242: anewarray 4	java/lang/Object
    //   245: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: goto -21 -> 227
    //   251: astore_2
    //   252: goto -82 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	k
    //   0	255	1	paramString1	String
    //   0	255	2	paramString2	String
    //   86	13	3	i	int
    //   64	55	4	j	int
    //   90	11	5	l	long
    //   70	84	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   55	60	167	java/lang/Exception
    //   223	227	235	java/io/IOException
    //   60	82	251	java/lang/Exception
    //   87	159	251	java/lang/Exception
  }
  
  public final boolean bw(boolean paramBoolean)
  {
    AppMethodBeat.i(55807);
    if (this.mStatus != 1)
    {
      AppMethodBeat.o(55807);
      return false;
    }
    this.mStatus = 2;
    synchronized (this.fZQ)
    {
      try
      {
        ab.v("MicroMsg.SilkPlayer", "before mOk.wait");
        long l = System.currentTimeMillis();
        this.fZQ.wait();
        ab.v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - l));
        if ((this.fZK != null) && (paramBoolean)) {
          this.fZK.Mh();
        }
        AppMethodBeat.o(55807);
        return true;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.SilkPlayer", "exception:%s", new Object[] { bo.l(localException) });
        AppMethodBeat.o(55807);
        return false;
      }
    }
  }
  
  public final void bx(boolean paramBoolean)
  {
    AppMethodBeat.i(55799);
    ab.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fZO = true;
    this.cjH = 2;
    dl(paramBoolean);
    try
    {
      this.mAudioTrack.play();
      this.fZO = false;
      AppMethodBeat.o(55799);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(161L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(161L, 3L, 1L, false);
        ab.e("MicroMsg.SilkPlayer", "audioTrack error:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final boolean d(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(55802);
    paramBoolean = U(paramString, paramBoolean);
    AppMethodBeat.o(55802);
    return paramBoolean;
  }
  
  public final int getStatus()
  {
    return this.mStatus;
  }
  
  public final boolean isPlaying()
  {
    return this.mStatus == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.k
 * JD-Core Version:    0.7.0.1
 */