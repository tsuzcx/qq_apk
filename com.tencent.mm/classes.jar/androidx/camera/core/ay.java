package androidx.camera.core;

import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.-CC;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.as;
import androidx.camera.core.impl.at;
import androidx.camera.core.impl.av;
import androidx.camera.core.impl.bb;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bb.c;
import androidx.camera.core.impl.bb.e;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.bk.a;
import androidx.camera.core.impl.bl;
import androidx.camera.core.impl.bl.a;
import androidx.camera.core.impl.bm;
import androidx.camera.core.impl.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ay
  extends ax
{
  public static final c JQ;
  private static final int[] JR;
  private ad Dm;
  private final Object JS;
  private final AtomicBoolean JT;
  private final AtomicBoolean JU;
  private HandlerThread JV;
  private HandlerThread JW;
  private Handler JX;
  MediaCodec JY;
  private com.google.b.b.a.f<Void> JZ;
  private int Ka;
  private int Kb;
  Surface Kc;
  private volatile AudioRecord Kd;
  private volatile int Ke;
  private volatile boolean Kf;
  private int Kg;
  private int Kh;
  private int Ki;
  private final AtomicBoolean Kj;
  private d Kk;
  private Throwable Kl;
  private MediaCodec mAudioEncoder;
  private Handler mVideoHandler;
  private bb.b zY;
  
  static
  {
    AppMethodBeat.i(198453);
    JQ = new c();
    JR = new int[] { 8, 6, 5, 4 };
    AppMethodBeat.o(198453);
  }
  
  private AudioRecord a(bm parambm)
  {
    AppMethodBeat.i(198430);
    int i;
    if (this.Kg == 1) {
      i = 16;
    }
    label141:
    for (;;)
    {
      try
      {
        int j = AudioRecord.getMinBufferSize(this.Kh, i, 2);
        if (j > 0) {
          break label141;
        }
        j = ((Integer)parambm.b(bm.NX)).intValue();
        parambm = new AudioRecord(5, this.Kh, i, 2, j * 2);
        if (parambm.getState() != 1) {
          continue;
        }
        this.Ke = j;
        new StringBuilder("source: 5 audioSampleRate: ").append(this.Kh).append(" channelConfig: ").append(i).append(" audioFormat: 2 bufferSize: ").append(j);
        al.Q("VideoCapture");
        AppMethodBeat.o(198430);
        return parambm;
      }
      catch (Exception parambm)
      {
        al.U("VideoCapture");
        AppMethodBeat.o(198430);
        return null;
      }
      i = 12;
    }
  }
  
  private static MediaFormat a(bm parambm, Size paramSize)
  {
    AppMethodBeat.i(198372);
    paramSize = MediaFormat.createVideoFormat("video/avc", paramSize.getWidth(), paramSize.getHeight());
    paramSize.setInteger("color-format", 2130708361);
    paramSize.setInteger("bitrate", ((Integer)parambm.b(bm.NS)).intValue());
    paramSize.setInteger("frame-rate", ((Integer)parambm.b(bm.NR)).intValue());
    paramSize.setInteger("i-frame-interval", ((Integer)parambm.b(bm.NT)).intValue());
    AppMethodBeat.o(198372);
    return paramSize;
  }
  
  private void a(Size paramSize, String paramString)
  {
    k = 0;
    AppMethodBeat.i(198438);
    for (;;)
    {
      try
      {
        int[] arrayOfInt = JR;
        int m = arrayOfInt.length;
        i = 0;
        j = k;
        if (i < m)
        {
          j = arrayOfInt[i];
          if (!CamcorderProfile.hasProfile(Integer.parseInt(paramString), j)) {
            continue;
          }
          CamcorderProfile localCamcorderProfile = CamcorderProfile.get(Integer.parseInt(paramString), j);
          if ((paramSize.getWidth() != localCamcorderProfile.videoFrameWidth) || (paramSize.getHeight() != localCamcorderProfile.videoFrameHeight)) {
            continue;
          }
          this.Kg = localCamcorderProfile.audioChannels;
          this.Kh = localCamcorderProfile.audioSampleRate;
          this.Ki = localCamcorderProfile.audioBitRate;
          j = 1;
        }
      }
      catch (NumberFormatException paramSize)
      {
        int i;
        al.Q("VideoCapture");
        int j = k;
        continue;
      }
      if (j == 0)
      {
        paramSize = (bm)this.JI;
        this.Kg = ((Integer)paramSize.b(bm.NW)).intValue();
        this.Kh = ((Integer)paramSize.b(bm.NV)).intValue();
        this.Ki = ((Integer)paramSize.b(bm.NU)).intValue();
      }
      AppMethodBeat.o(198438);
      return;
      i += 1;
    }
  }
  
  private void ae(boolean paramBoolean)
  {
    AppMethodBeat.i(198413);
    if (this.Dm == null)
    {
      AppMethodBeat.o(198413);
      return;
    }
    MediaCodec localMediaCodec = this.JY;
    this.Dm.close();
    e.d(this.Dm.Mj).a(new ay..ExternalSyntheticLambda3(paramBoolean, localMediaCodec), androidx.camera.core.impl.a.a.f.kR());
    if (paramBoolean) {
      this.JY = null;
    }
    this.Kc = null;
    this.Dm = null;
    AppMethodBeat.o(198413);
  }
  
  private void jD()
  {
    AppMethodBeat.i(198388);
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      androidx.camera.core.impl.a.a.f.kR().execute(new ay..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(198388);
      return;
    }
    al.Q("VideoCapture");
    bb.b localb = this.zY;
    localb.LY.clear();
    localb.Nf.kb();
    this.zY.c(this.Dm);
    d(this.zY.ky());
    jx();
    if (this.Kf)
    {
      if (this.Kj.get())
      {
        this.JU.set(true);
        AppMethodBeat.o(198388);
        return;
      }
      this.JT.set(true);
    }
    AppMethodBeat.o(198388);
  }
  
  private void jE()
  {
    AppMethodBeat.i(198405);
    this.JW.quitSafely();
    if (this.mAudioEncoder != null)
    {
      this.mAudioEncoder.release();
      this.mAudioEncoder = null;
    }
    if (this.Kd != null)
    {
      this.Kd.release();
      this.Kd = null;
    }
    AppMethodBeat.o(198405);
  }
  
  private MediaFormat jF()
  {
    AppMethodBeat.i(198421);
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.Kh, this.Kg);
    localMediaFormat.setInteger("aac-profile", 2);
    localMediaFormat.setInteger("bitrate", this.Ki);
    AppMethodBeat.o(198421);
    return localMediaFormat;
  }
  
  private void releaseResources()
  {
    AppMethodBeat.i(198399);
    this.JV.quitSafely();
    jE();
    if (this.Kc != null) {
      ae(true);
    }
    AppMethodBeat.o(198399);
  }
  
  public final bk<?> a(boolean paramBoolean, bl parambl)
  {
    AppMethodBeat.i(198466);
    ac localac = parambl.a(bl.a.NP);
    parambl = localac;
    if (paramBoolean) {
      parambl = ac.-CC.a(localac, c.jJ());
    }
    if (parambl == null)
    {
      AppMethodBeat.o(198466);
      return null;
    }
    parambl = b.h(parambl).iT();
    AppMethodBeat.o(198466);
    return parambl;
  }
  
  /* Error */
  final void a(String arg1, final Size paramSize)
  {
    // Byte code:
    //   0: ldc_w 445
    //   3: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 241	androidx/camera/core/ax:JI	Landroidx/camera/core/impl/bk;
    //   10: checkcast 113	androidx/camera/core/impl/bm
    //   13: astore 4
    //   15: aload_0
    //   16: getfield 263	androidx/camera/core/ay:JY	Landroid/media/MediaCodec;
    //   19: invokevirtual 448	android/media/MediaCodec:reset	()V
    //   22: aload_0
    //   23: getstatic 451	androidx/camera/core/ay$d:Kr	Landroidx/camera/core/ay$d;
    //   26: putfield 453	androidx/camera/core/ay:Kk	Landroidx/camera/core/ay$d;
    //   29: aload_0
    //   30: getfield 263	androidx/camera/core/ay:JY	Landroid/media/MediaCodec;
    //   33: aload 4
    //   35: aload_2
    //   36: invokestatic 455	androidx/camera/core/ay:a	(Landroidx/camera/core/impl/bm;Landroid/util/Size;)Landroid/media/MediaFormat;
    //   39: aconst_null
    //   40: aconst_null
    //   41: iconst_1
    //   42: invokevirtual 459	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   45: aload_0
    //   46: getfield 293	androidx/camera/core/ay:Kc	Landroid/view/Surface;
    //   49: ifnull +8 -> 57
    //   52: aload_0
    //   53: iconst_0
    //   54: invokespecial 403	androidx/camera/core/ay:ae	(Z)V
    //   57: aload_0
    //   58: getfield 263	androidx/camera/core/ay:JY	Landroid/media/MediaCodec;
    //   61: invokevirtual 463	android/media/MediaCodec:createInputSurface	()Landroid/view/Surface;
    //   64: astore 5
    //   66: aload_0
    //   67: aload 5
    //   69: putfield 293	androidx/camera/core/ay:Kc	Landroid/view/Surface;
    //   72: aload_0
    //   73: aload 4
    //   75: invokestatic 466	androidx/camera/core/impl/bb$b:b	(Landroidx/camera/core/impl/bk;)Landroidx/camera/core/impl/bb$b;
    //   78: putfield 316	androidx/camera/core/ay:zY	Landroidx/camera/core/impl/bb$b;
    //   81: aload_0
    //   82: getfield 261	androidx/camera/core/ay:Dm	Landroidx/camera/core/impl/ad;
    //   85: ifnull +10 -> 95
    //   88: aload_0
    //   89: getfield 261	androidx/camera/core/ay:Dm	Landroidx/camera/core/impl/ad;
    //   92: invokevirtual 268	androidx/camera/core/impl/ad:close	()V
    //   95: aload_0
    //   96: new 468	androidx/camera/core/impl/ao
    //   99: dup
    //   100: aload_0
    //   101: getfield 293	androidx/camera/core/ay:Kc	Landroid/view/Surface;
    //   104: aload_2
    //   105: aload_0
    //   106: invokevirtual 471	androidx/camera/core/ay:iw	()I
    //   109: invokespecial 474	androidx/camera/core/impl/ao:<init>	(Landroid/view/Surface;Landroid/util/Size;I)V
    //   112: putfield 261	androidx/camera/core/ay:Dm	Landroidx/camera/core/impl/ad;
    //   115: aload_0
    //   116: getfield 261	androidx/camera/core/ay:Dm	Landroidx/camera/core/impl/ad;
    //   119: getfield 271	androidx/camera/core/impl/ad:Mj	Lcom/google/b/b/a/f;
    //   122: invokestatic 276	androidx/camera/core/impl/a/b/e:d	(Lcom/google/b/b/a/f;)Lcom/google/b/b/a/f;
    //   125: astore 6
    //   127: aload 5
    //   129: invokestatic 480	java/util/Objects:requireNonNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload 6
    //   135: new 482	androidx/camera/core/ay$$ExternalSyntheticLambda0
    //   138: dup
    //   139: aload 5
    //   141: invokespecial 485	androidx/camera/core/ay$$ExternalSyntheticLambda0:<init>	(Landroid/view/Surface;)V
    //   144: invokestatic 286	androidx/camera/core/impl/a/a/f:kR	()Ljava/util/concurrent/ScheduledExecutorService;
    //   147: invokeinterface 291 3 0
    //   152: aload_0
    //   153: getfield 316	androidx/camera/core/ay:zY	Landroidx/camera/core/impl/bb$b;
    //   156: aload_0
    //   157: getfield 261	androidx/camera/core/ay:Dm	Landroidx/camera/core/impl/ad;
    //   160: invokevirtual 339	androidx/camera/core/impl/bb$b:c	(Landroidx/camera/core/impl/ad;)V
    //   163: aload_0
    //   164: getfield 316	androidx/camera/core/ay:zY	Landroidx/camera/core/impl/bb$b;
    //   167: new 6	androidx/camera/core/ay$1
    //   170: dup
    //   171: aload_0
    //   172: aload_1
    //   173: aload_2
    //   174: invokespecial 488	androidx/camera/core/ay$1:<init>	(Landroidx/camera/core/ay;Ljava/lang/String;Landroid/util/Size;)V
    //   177: invokevirtual 491	androidx/camera/core/impl/bb$b:a	(Landroidx/camera/core/impl/bb$c;)V
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 316	androidx/camera/core/ay:zY	Landroidx/camera/core/impl/bb$b;
    //   185: invokevirtual 343	androidx/camera/core/impl/bb$b:ky	()Landroidx/camera/core/impl/bb;
    //   188: invokevirtual 346	androidx/camera/core/ay:d	(Landroidx/camera/core/impl/bb;)V
    //   191: aload_0
    //   192: getfield 353	androidx/camera/core/ay:Kj	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   195: iconst_1
    //   196: invokevirtual 363	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   199: aload_0
    //   200: aload_2
    //   201: aload_1
    //   202: invokespecial 493	androidx/camera/core/ay:a	(Landroid/util/Size;Ljava/lang/String;)V
    //   205: aload_0
    //   206: getfield 376	androidx/camera/core/ay:mAudioEncoder	Landroid/media/MediaCodec;
    //   209: invokevirtual 448	android/media/MediaCodec:reset	()V
    //   212: aload_0
    //   213: getfield 376	androidx/camera/core/ay:mAudioEncoder	Landroid/media/MediaCodec;
    //   216: aload_0
    //   217: invokespecial 495	androidx/camera/core/ay:jF	()Landroid/media/MediaFormat;
    //   220: aconst_null
    //   221: aconst_null
    //   222: iconst_1
    //   223: invokevirtual 459	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   226: aload_0
    //   227: getfield 378	androidx/camera/core/ay:Kd	Landroid/media/AudioRecord;
    //   230: ifnull +10 -> 240
    //   233: aload_0
    //   234: getfield 378	androidx/camera/core/ay:Kd	Landroid/media/AudioRecord;
    //   237: invokevirtual 379	android/media/AudioRecord:release	()V
    //   240: aload_0
    //   241: aload_0
    //   242: aload 4
    //   244: invokespecial 497	androidx/camera/core/ay:a	(Landroidx/camera/core/impl/bm;)Landroid/media/AudioRecord;
    //   247: putfield 378	androidx/camera/core/ay:Kd	Landroid/media/AudioRecord;
    //   250: aload_0
    //   251: getfield 378	androidx/camera/core/ay:Kd	Landroid/media/AudioRecord;
    //   254: ifnonnull +16 -> 270
    //   257: ldc 154
    //   259: invokestatic 500	androidx/camera/core/al:T	(Ljava/lang/String;)V
    //   262: aload_0
    //   263: getfield 353	androidx/camera/core/ay:Kj	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   266: iconst_0
    //   267: invokevirtual 363	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   270: aload_0
    //   271: getfield 502	androidx/camera/core/ay:JS	Ljava/lang/Object;
    //   274: astore_1
    //   275: aload_1
    //   276: monitorenter
    //   277: aload_0
    //   278: iconst_m1
    //   279: putfield 504	androidx/camera/core/ay:Ka	I
    //   282: aload_0
    //   283: iconst_m1
    //   284: putfield 506	androidx/camera/core/ay:Kb	I
    //   287: aload_1
    //   288: monitorexit
    //   289: aload_0
    //   290: iconst_0
    //   291: putfield 351	androidx/camera/core/ay:Kf	Z
    //   294: ldc_w 445
    //   297: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: return
    //   301: astore_1
    //   302: getstatic 511	android/os/Build$VERSION:SDK_INT	I
    //   305: bipush 23
    //   307: if_icmplt +116 -> 423
    //   310: aload_1
    //   311: invokestatic 514	androidx/camera/core/ay$a:a	(Landroid/media/MediaCodec$CodecException;)I
    //   314: istore_3
    //   315: aload_1
    //   316: invokevirtual 518	android/media/MediaCodec$CodecException:getDiagnosticInfo	()Ljava/lang/String;
    //   319: astore_2
    //   320: iload_3
    //   321: sipush 1100
    //   324: if_icmpne +52 -> 376
    //   327: new 136	java/lang/StringBuilder
    //   330: dup
    //   331: ldc_w 520
    //   334: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: iload_3
    //   338: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc_w 522
    //   344: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_2
    //   348: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: ldc 154
    //   354: invokestatic 159	androidx/camera/core/al:Q	(Ljava/lang/String;)V
    //   357: aload_0
    //   358: getstatic 525	androidx/camera/core/ay$d:Kt	Landroidx/camera/core/ay$d;
    //   361: putfield 453	androidx/camera/core/ay:Kk	Landroidx/camera/core/ay$d;
    //   364: aload_0
    //   365: aload_1
    //   366: putfield 527	androidx/camera/core/ay:Kl	Ljava/lang/Throwable;
    //   369: ldc_w 445
    //   372: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: return
    //   376: iload_3
    //   377: sipush 1101
    //   380: if_icmpne -16 -> 364
    //   383: new 136	java/lang/StringBuilder
    //   386: dup
    //   387: ldc_w 520
    //   390: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   393: iload_3
    //   394: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: ldc_w 522
    //   400: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_2
    //   404: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: ldc 154
    //   410: invokestatic 159	androidx/camera/core/al:Q	(Ljava/lang/String;)V
    //   413: aload_0
    //   414: getstatic 530	androidx/camera/core/ay$d:Ku	Landroidx/camera/core/ay$d;
    //   417: putfield 453	androidx/camera/core/ay:Kk	Landroidx/camera/core/ay$d;
    //   420: goto -56 -> 364
    //   423: aload_0
    //   424: getstatic 533	androidx/camera/core/ay$d:Ks	Landroidx/camera/core/ay$d;
    //   427: putfield 453	androidx/camera/core/ay:Kk	Landroidx/camera/core/ay$d;
    //   430: goto -66 -> 364
    //   433: astore_1
    //   434: aload_0
    //   435: getstatic 533	androidx/camera/core/ay$d:Ks	Landroidx/camera/core/ay$d;
    //   438: putfield 453	androidx/camera/core/ay:Kk	Landroidx/camera/core/ay$d;
    //   441: aload_0
    //   442: aload_1
    //   443: putfield 527	androidx/camera/core/ay:Kl	Ljava/lang/Throwable;
    //   446: ldc_w 445
    //   449: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: return
    //   453: astore_2
    //   454: aload_1
    //   455: monitorexit
    //   456: ldc_w 445
    //   459: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   462: aload_2
    //   463: athrow
    //   464: astore_1
    //   465: goto -31 -> 434
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	ay
    //   0	468	2	paramSize	Size
    //   314	80	3	i	int
    //   13	230	4	localbm	bm
    //   64	76	5	localSurface	Surface
    //   125	9	6	localf	com.google.b.b.a.f
    // Exception table:
    //   from	to	target	type
    //   29	45	301	android/media/MediaCodec$CodecException
    //   29	45	433	java/lang/IllegalStateException
    //   277	289	453	finally
    //   29	45	464	java/lang/IllegalArgumentException
  }
  
  protected final Size d(Size paramSize)
  {
    AppMethodBeat.i(198479);
    if (this.Kc != null)
    {
      this.JY.stop();
      this.JY.release();
      this.mAudioEncoder.stop();
      this.mAudioEncoder.release();
      ae(false);
    }
    try
    {
      this.JY = MediaCodec.createEncoderByType("video/avc");
      this.mAudioEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
      a(gV(), paramSize);
      jv();
      AppMethodBeat.o(198479);
      return paramSize;
    }
    catch (IOException paramSize)
    {
      paramSize = new IllegalStateException("Unable to create MediaCodec due to: " + paramSize.getCause());
      AppMethodBeat.o(198479);
      throw paramSize;
    }
  }
  
  public final bk.a<?, ?, ?> d(ac paramac)
  {
    AppMethodBeat.i(369507);
    paramac = b.h(paramac);
    AppMethodBeat.o(369507);
    return paramac;
  }
  
  public final void iQ()
  {
    AppMethodBeat.i(198483);
    jD();
    if (this.JZ != null)
    {
      this.JZ.a(new ay..ExternalSyntheticLambda1(this), androidx.camera.core.impl.a.a.f.kR());
      AppMethodBeat.o(198483);
      return;
    }
    releaseResources();
    AppMethodBeat.o(198483);
  }
  
  public final void iR()
  {
    AppMethodBeat.i(198474);
    this.JV = new HandlerThread("CameraX-video encoding thread");
    this.JW = new HandlerThread("CameraX-audio encoding thread");
    this.JV.start();
    this.mVideoHandler = new Handler(this.JV.getLooper());
    this.JW.start();
    this.JX = new Handler(this.JW.getLooper());
    AppMethodBeat.o(198474);
  }
  
  public final void iW()
  {
    AppMethodBeat.i(198494);
    jD();
    AppMethodBeat.o(198494);
  }
  
  static final class a
  {
    static int a(MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(198338);
      int i = paramCodecException.getErrorCode();
      AppMethodBeat.o(198338);
      return i;
    }
  }
  
  public static final class b
    implements bk.a<ay, bm, b>
  {
    final at He;
    
    public b()
    {
      this(at.ku());
      AppMethodBeat.i(198358);
      AppMethodBeat.o(198358);
    }
    
    private b(at paramat)
    {
      AppMethodBeat.i(198377);
      this.He = paramat;
      paramat = (Class)paramat.b(androidx.camera.core.a.f.Qo, null);
      if ((paramat != null) && (!paramat.equals(ay.class)))
      {
        paramat = new IllegalArgumentException("Invalid target class configuration for " + this + ": " + paramat);
        AppMethodBeat.o(198377);
        throw paramat;
      }
      this.He.c(androidx.camera.core.a.f.Qo, ay.class);
      if (this.He.b(androidx.camera.core.a.f.Qn, null) == null)
      {
        paramat = ay.class.getCanonicalName() + "-" + UUID.randomUUID();
        this.He.c(androidx.camera.core.a.f.Qn, paramat);
      }
      AppMethodBeat.o(198377);
    }
    
    static b h(ac paramac)
    {
      AppMethodBeat.i(198391);
      paramac = new b(at.k(paramac));
      AppMethodBeat.o(198391);
      return paramac;
    }
    
    public final as fU()
    {
      return this.He;
    }
    
    public final bm jI()
    {
      AppMethodBeat.i(198410);
      bm localbm = new bm(av.l(this.He));
      AppMethodBeat.o(198410);
      return localbm;
    }
  }
  
  public static final class c
  {
    private static final Size Kp;
    private static final bm Kq;
    
    static
    {
      AppMethodBeat.i(198383);
      Kp = new Size(1920, 1080);
      ay.b localb = new ay.b();
      localb.He.c(bm.NR, Integer.valueOf(30));
      localb.He.c(bm.NS, Integer.valueOf(8388608));
      localb.He.c(bm.NT, Integer.valueOf(1));
      localb.He.c(bm.NU, Integer.valueOf(64000));
      localb.He.c(bm.NV, Integer.valueOf(8000));
      localb.He.c(bm.NW, Integer.valueOf(1));
      localb.He.c(bm.NX, Integer.valueOf(1024));
      Size localSize = Kp;
      localb.He.c(androidx.camera.core.impl.al.MM, localSize);
      localb.He.c(bk.NJ, Integer.valueOf(3));
      localb.He.c(androidx.camera.core.impl.al.MI, Integer.valueOf(1));
      Kq = localb.jI();
      AppMethodBeat.o(198383);
    }
    
    public static bm jJ()
    {
      return Kq;
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(198394);
      Kr = new d("VIDEO_ENCODER_INIT_STATUS_UNINITIALIZED", 0);
      Ks = new d("VIDEO_ENCODER_INIT_STATUS_INITIALIZED_FAILED", 1);
      Kt = new d("VIDEO_ENCODER_INIT_STATUS_INSUFFICIENT_RESOURCE", 2);
      Ku = new d("VIDEO_ENCODER_INIT_STATUS_RESOURCE_RECLAIMED", 3);
      Kv = new d[] { Kr, Ks, Kt, Ku };
      AppMethodBeat.o(198394);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.ay
 * JD-Core Version:    0.7.0.1
 */