package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "videoWidth", "videoHeight", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "blurBgProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getFinishCallback", "()Lkotlin/jvm/functions/Function1;", "setFinishCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstFrameDraw", "getForceLandscape", "setForceLandscape", "frameHandingTime", "frameTimeoutMs", "getIFrame", "()I", "setIFrame", "(I)V", "initFinish", "inputHeight", "getInputHeight", "setInputHeight", "inputWidth", "getInputWidth", "setInputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "setMixType", "musicExtractorWrapper", "getOutputAudioBitrate", "setOutputAudioBitrate", "getOutputAudioChannelCount", "setOutputAudioChannelCount", "getOutputAudioSampleRate", "setOutputAudioSampleRate", "getOutputBitrate", "setOutputBitrate", "getOutputFilePath", "getOutputFps", "setOutputFps", "getOutputHeight", "setOutputHeight", "getOutputWidth", "setOutputWidth", "getProgressListener", "setProgressListener", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "timeoutInvoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1;", "useRequestDraw", "getUseSoftEncode", "setUseSoftEncode", "vfrThreshold", "videoDuration", "videoFps", "getVideoHeight", "getVideoMinQP", "setVideoMinQP", "videoMixHandlerThread", "videoRotate", "getVideoWidth", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "checkFrameDrawTimeout", "checkVideoHasBFrame", "afterCheck", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "onDecoderEncoderFailed", "isDecoder", "isEncoder", "remux", "remuxImpl", "renderer", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "startRemux", "Companion", "plugin-mediaeditor_release"})
public class f
  extends d
  implements c
{
  private static final long hpo = 1000L;
  private static final long hpp = 1000L;
  public static final f.a hpq;
  private final String TAG;
  private String filePath;
  private volatile boolean hkf;
  private int hkm;
  private int hku;
  private final int hlb;
  private com.tencent.mm.media.f.a hll;
  private volatile boolean hmh;
  private d.g.a.b<? super Long, Bitmap> hnM;
  private Bitmap hnN;
  private long hnV;
  private com.tencent.mm.media.e.g hoA;
  private com.tencent.mm.media.a.a hoB;
  private a hoC;
  private i hoD;
  private com.tencent.mm.media.f.a hoE;
  private com.tencent.mm.media.f.a hoF;
  private HandlerThread hoG;
  private HandlerThread hoH;
  private boolean hoI;
  private boolean hoJ;
  private g hoK;
  private d.g.a.b<? super Long, Bitmap> hoL;
  private long hoM;
  private final com.tencent.mm.media.k.a hoN;
  private volatile boolean hoO;
  private boolean hoP;
  private boolean hoQ;
  private int hoR;
  private int hoS;
  private long hoT;
  private final int hoU;
  private volatile boolean hoV;
  private volatile boolean hoW;
  private final n hoX;
  private final Runnable hoY;
  private final String hoZ;
  private com.tencent.mm.media.d.f hom;
  protected int how;
  protected int hox;
  private int hoy;
  private com.tencent.mm.media.e.b hoz;
  protected Rect hpa;
  private int hpb;
  private int hpc;
  private int hpd;
  private int hpe;
  int hpf;
  protected boolean hpg;
  private boolean hph;
  private int hpi;
  private int hpj;
  private boolean hpk;
  private int hpl;
  d.g.a.b<? super Float, z> hpm;
  private d.g.a.b<? super String, z> hpn;
  private final String outputFilePath;
  protected int outputHeight;
  protected int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  protected final int videoHeight;
  protected final int videoWidth;
  
  static
  {
    AppMethodBeat.i(93809);
    hpq = new f.a((byte)0);
    hpo = 1000L;
    hpp = 1000L;
    AppMethodBeat.o(93809);
  }
  
  public f(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt11, int paramInt12, boolean paramBoolean3, int paramInt13, d.g.a.b<? super Float, z> paramb, d.g.a.b<? super String, z> paramb1)
  {
    AppMethodBeat.i(217525);
    this.hoZ = paramString1;
    this.filePath = paramString2;
    this.hku = paramInt1;
    this.outputFilePath = paramString3;
    this.hpa = paramRect;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    this.outputWidth = paramInt4;
    this.outputHeight = paramInt5;
    this.hpb = paramInt6;
    this.hpc = paramInt7;
    this.hpd = paramInt8;
    this.hpe = paramInt9;
    this.hpf = paramInt10;
    this.hpg = paramBoolean1;
    this.hph = paramBoolean2;
    this.hpi = paramInt11;
    this.hpj = paramInt12;
    this.hpk = paramBoolean3;
    this.hpl = paramInt13;
    this.hpm = paramb;
    this.hpn = paramb1;
    this.TAG = "MicroMsg.MediaCodecRemuxer";
    this.videoDuration = -1;
    this.hnV = paramLong1;
    this.remuxEndTime = -1L;
    this.hoN = new com.tencent.mm.media.k.a("remuxCost");
    this.hlb = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFq, 10);
    this.hoU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFr, 10000);
    this.hoX = new n(this);
    if ((bu.isNullOrNil(this.filePath)) || (!o.fB(this.filePath)) || (bu.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
    {
      ae.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.hpf);
      paramString1 = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avI();
      paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
      AppMethodBeat.o(217525);
      throw paramString1;
    }
    paramString1 = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.nR(this.hku);
    if (com.tencent.mm.bk.e.Ik(this.filePath))
    {
      ae.i(this.TAG, "remux h265 format");
      paramString1 = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.avH();
    }
    o.aZI(o.aZU(this.outputFilePath));
    this.hoy = SightVideoJNI.getMp4RotateVFS(this.filePath);
    if ((this.hpk) && ((this.hoy == 90) || (this.hoy == 270)))
    {
      paramInt1 = this.outputWidth;
      this.outputWidth = this.outputHeight;
      this.outputHeight = paramInt1;
    }
    paramString2 = com.tencent.mm.plugin.sight.base.e.ayN(this.filePath);
    if (paramString2 != null)
    {
      this.how = paramString2.width;
      this.hox = paramString2.height;
      this.videoFps = paramString2.frameRate;
      this.videoDuration = paramString2.videoDuration;
    }
    if ((this.how <= 0) || (this.hox <= 0)) {}
    try
    {
      paramString1 = new com.tencent.mm.compatible.h.d();
      paramString1.setDataSource(this.filePath);
      this.how = bu.getInt(paramString1.extractMetadata(18), 0);
      this.hox = bu.getInt(paramString1.extractMetadata(19), 0);
      paramString1.release();
      label627:
      if (this.videoFps <= 0)
      {
        ae.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
        paramString1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avI();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(217525);
        throw paramString1;
      }
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        ae.i(this.TAG, "MediaCodecRemuxer frameTimeoutMs is:" + this.hoU);
        if (!this.hpg) {
          break label1273;
        }
        paramString1 = new i(this.hnV, this.remuxEndTime, this.hpb, this.outputWidth, this.outputHeight, this.hpg, this.hpf, this.hph);
        label787:
        this.hoD = paramString1;
        if (this.hpe <= 0) {
          this.hpe = 1;
        }
        ae.m(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.how + ", inputHeight: " + this.hox + ", videoRotate: " + this.hoy + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.hpb + ", outputAudioBitrate:" + this.hpc + ", outputAudioChannelCount:" + this.hpe + ", outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.hpf + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.hnV + " ,remuxEndTime: " + this.remuxEndTime + " , input bitrate:" + paramString2.videoBitrate + ", enableHevc:" + this.hph, new Object[0]);
        this.hll = new com.tencent.mm.media.f.a(this.filePath);
        if (this.hll.hmS)
        {
          paramString1 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avJ();
        }
        paramInt1 = this.outputWidth - this.how;
        if ((1 <= paramInt1) && (16 > paramInt1)) {
          break label1306;
        }
        paramInt1 = this.outputHeight - this.hox;
        if (1 <= paramInt1) {
          break label1300;
        }
        label1138:
        paramBoolean1 = false;
        label1141:
        ae.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(paramBoolean1)));
        ae.i(this.TAG, "startRemux, useSoftEncode:" + this.hpg + ", enablHevc:" + this.hph);
        if (this.hph)
        {
          if (!this.hpg) {
            break label1312;
          }
          paramString1 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.awl();
        }
      }
      for (;;)
      {
        if (this.hpg)
        {
          paramString1 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.awk();
        }
        a(auf());
        this.hoY = ((Runnable)new c(this));
        AppMethodBeat.o(217525);
        return;
        this.remuxEndTime = paramLong2;
        break;
        label1273:
        paramString1 = new i(this.hnV, this.remuxEndTime, this.hpb, this.hpg);
        break label787;
        label1300:
        if (16 <= paramInt1) {
          break label1138;
        }
        label1306:
        paramBoolean1 = true;
        break label1141;
        label1312:
        paramString1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.awm();
      }
    }
    catch (Exception paramString1)
    {
      break label627;
    }
  }
  
  /* Error */
  private final void a(final com.tencent.mm.media.j.c paramc)
  {
    // Byte code:
    //   0: ldc_w 838
    //   3: invokestatic 312	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   10: astore 9
    //   12: getstatic 844	com/tencent/mm/media/i/j:hpS	Lcom/tencent/mm/media/i/j$a;
    //   15: astore 10
    //   17: aload 9
    //   19: invokestatic 849	com/tencent/mm/media/i/j$a:yQ	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: ifnonnull +723 -> 749
    //   29: aload_0
    //   30: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   33: ldc_w 851
    //   36: invokestatic 489	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 844	com/tencent/mm/media/i/j:hpS	Lcom/tencent/mm/media/i/j$a;
    //   42: astore 9
    //   44: aload_0
    //   45: new 643	com/tencent/mm/media/f/a
    //   48: dup
    //   49: aload_0
    //   50: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   53: invokestatic 849	com/tencent/mm/media/i/j$a:yQ	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 644	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   59: putfield 716	com/tencent/mm/media/i/f:hoF	Lcom/tencent/mm/media/f/a;
    //   62: aload_0
    //   63: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   66: astore 9
    //   68: new 458	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 853
    //   75: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: astore 10
    //   80: getstatic 844	com/tencent/mm/media/i/j:hpS	Lcom/tencent/mm/media/i/j$a;
    //   83: astore 11
    //   85: aload 10
    //   87: aload_0
    //   88: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   91: invokestatic 849	com/tencent/mm/media/i/j$a:yQ	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 855
    //   100: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: astore 10
    //   105: getstatic 844	com/tencent/mm/media/i/j:hpS	Lcom/tencent/mm/media/i/j$a;
    //   108: astore 11
    //   110: aload 9
    //   112: aload 10
    //   114: aload_0
    //   115: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   118: invokestatic 858	com/tencent/mm/media/i/j$a:yP	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 716	com/tencent/mm/media/i/f:hoF	Lcom/tencent/mm/media/f/a;
    //   134: astore 9
    //   136: aload 9
    //   138: ifnull +89 -> 227
    //   141: aload_0
    //   142: new 860	com/tencent/mm/media/i/g
    //   145: dup
    //   146: aload_0
    //   147: getfield 585	com/tencent/mm/media/i/f:hoD	Lcom/tencent/mm/media/i/i;
    //   150: aload 9
    //   152: aload_0
    //   153: getfield 360	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 358	com/tencent/mm/media/i/f:hku	I
    //   160: aload_0
    //   161: getfield 376	com/tencent/mm/media/i/f:hpd	I
    //   164: invokespecial 863	com/tencent/mm/media/i/g:<init>	(Lcom/tencent/mm/media/i/i;Lcom/tencent/mm/media/f/a;Ljava/lang/String;II)V
    //   167: putfield 865	com/tencent/mm/media/i/f:hoK	Lcom/tencent/mm/media/i/g;
    //   170: aload_0
    //   171: getfield 354	com/tencent/mm/media/i/f:hoZ	Ljava/lang/String;
    //   174: invokestatic 456	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   177: ifeq +50 -> 227
    //   180: aload_0
    //   181: getfield 354	com/tencent/mm/media/i/f:hoZ	Ljava/lang/String;
    //   184: astore 9
    //   186: aload 9
    //   188: ifnonnull +6 -> 194
    //   191: invokestatic 769	d/g/b/p:gkB	()V
    //   194: new 643	com/tencent/mm/media/f/a
    //   197: dup
    //   198: aload 9
    //   200: invokespecial 644	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   203: astore 9
    //   205: aload 9
    //   207: getfield 649	com/tencent/mm/media/f/a:hmS	Z
    //   210: ifeq +11 -> 221
    //   213: getstatic 495	com/tencent/mm/media/k/d:hrI	Lcom/tencent/mm/media/k/d;
    //   216: astore 10
    //   218: invokestatic 868	com/tencent/mm/media/k/d:avL	()V
    //   221: aload_0
    //   222: aload 9
    //   224: putfield 710	com/tencent/mm/media/i/f:hoE	Lcom/tencent/mm/media/f/a;
    //   227: aload_0
    //   228: getfield 865	com/tencent/mm/media/i/f:hoK	Lcom/tencent/mm/media/i/g;
    //   231: astore 9
    //   233: aload 9
    //   235: ifnull +12 -> 247
    //   238: aload 9
    //   240: aload_0
    //   241: getfield 535	com/tencent/mm/media/i/f:hoy	I
    //   244: putfield 869	com/tencent/mm/media/i/g:hoy	I
    //   247: aload_0
    //   248: invokespecial 873	com/tencent/mm/media/i/f:aug	()Lcom/tencent/mm/media/b/d;
    //   251: astore 10
    //   253: new 42	com/tencent/mm/media/i/f$j
    //   256: dup
    //   257: aload_0
    //   258: invokespecial 874	com/tencent/mm/media/i/f$j:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   261: checkcast 876	d/g/a/m
    //   264: astore 9
    //   266: new 44	com/tencent/mm/media/i/f$k
    //   269: dup
    //   270: aload_0
    //   271: invokespecial 877	com/tencent/mm/media/i/f$k:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   274: checkcast 791	d/g/a/a
    //   277: astore 11
    //   279: aload_0
    //   280: getfield 382	com/tencent/mm/media/i/f:hpg	Z
    //   283: ifeq +564 -> 847
    //   286: aload_0
    //   287: new 879	com/tencent/mm/media/e/g
    //   290: dup
    //   291: aload_0
    //   292: getfield 585	com/tencent/mm/media/i/f:hoD	Lcom/tencent/mm/media/i/i;
    //   295: getfield 751	com/tencent/mm/media/i/i:bufId	I
    //   298: aload 10
    //   300: getfield 884	com/tencent/mm/media/b/d:targetWidth	I
    //   303: aload 10
    //   305: getfield 887	com/tencent/mm/media/b/d:targetHeight	I
    //   308: invokespecial 890	com/tencent/mm/media/e/g:<init>	(III)V
    //   311: putfield 892	com/tencent/mm/media/i/f:hoA	Lcom/tencent/mm/media/e/g;
    //   314: aload_0
    //   315: getfield 892	com/tencent/mm/media/i/f:hoA	Lcom/tencent/mm/media/e/g;
    //   318: astore 9
    //   320: aload 9
    //   322: ifnull +8 -> 330
    //   325: aload 9
    //   327: invokevirtual 895	com/tencent/mm/media/e/g:start	()V
    //   330: aload_0
    //   331: new 897	com/tencent/mm/media/i/a
    //   334: dup
    //   335: aload_1
    //   336: checkcast 899	com/tencent/mm/media/j/a
    //   339: invokespecial 902	com/tencent/mm/media/i/a:<init>	(Lcom/tencent/mm/media/j/a;)V
    //   342: putfield 904	com/tencent/mm/media/i/f:hoC	Lcom/tencent/mm/media/i/a;
    //   345: aload_0
    //   346: getfield 904	com/tencent/mm/media/i/f:hoC	Lcom/tencent/mm/media/i/a;
    //   349: astore 9
    //   351: aload 9
    //   353: ifnull +45 -> 398
    //   356: aload 9
    //   358: ldc_w 905
    //   361: aload_0
    //   362: getfield 478	com/tencent/mm/media/i/f:videoFps	I
    //   365: idiv
    //   366: putfield 908	com/tencent/mm/media/i/a:hnT	I
    //   369: aload 9
    //   371: getfield 909	com/tencent/mm/media/i/a:TAG	Ljava/lang/String;
    //   374: new 458	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 911
    //   381: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload 9
    //   386: getfield 908	com/tencent/mm/media/i/a:hnT	I
    //   389: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_0
    //   399: getfield 913	com/tencent/mm/media/i/f:hnM	Ld/g/a/b;
    //   402: ifnull +23 -> 425
    //   405: aload_0
    //   406: getfield 904	com/tencent/mm/media/i/f:hoC	Lcom/tencent/mm/media/i/a;
    //   409: astore 9
    //   411: aload 9
    //   413: ifnull +12 -> 425
    //   416: aload 9
    //   418: aload_0
    //   419: getfield 913	com/tencent/mm/media/i/f:hnM	Ld/g/a/b;
    //   422: invokevirtual 916	com/tencent/mm/media/i/a:i	(Ld/g/a/b;)V
    //   425: aload_0
    //   426: getfield 918	com/tencent/mm/media/i/f:hoL	Ld/g/a/b;
    //   429: ifnull +23 -> 452
    //   432: aload_0
    //   433: getfield 904	com/tencent/mm/media/i/f:hoC	Lcom/tencent/mm/media/i/a;
    //   436: astore 9
    //   438: aload 9
    //   440: ifnull +12 -> 452
    //   443: aload 9
    //   445: aload_0
    //   446: getfield 918	com/tencent/mm/media/i/f:hoL	Ld/g/a/b;
    //   449: invokevirtual 921	com/tencent/mm/media/i/a:j	(Ld/g/a/b;)V
    //   452: aload_0
    //   453: getfield 904	com/tencent/mm/media/i/f:hoC	Lcom/tencent/mm/media/i/a;
    //   456: astore 9
    //   458: aload 9
    //   460: ifnull +22 -> 482
    //   463: aload 9
    //   465: new 22	com/tencent/mm/media/i/f$h
    //   468: dup
    //   469: aload_0
    //   470: aload_1
    //   471: aload 10
    //   473: invokespecial 924	com/tencent/mm/media/i/f$h:<init>	(Lcom/tencent/mm/media/i/f;Lcom/tencent/mm/media/j/c;Lcom/tencent/mm/media/b/d;)V
    //   476: checkcast 926	d/g/a/b
    //   479: putfield 929	com/tencent/mm/media/i/a:hnI	Ld/g/a/b;
    //   482: ldc_w 417
    //   485: invokestatic 423	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   488: checkcast 417	com/tencent/mm/plugin/expt/b/b
    //   491: getstatic 932	com/tencent/mm/plugin/expt/b/b$a:qFn	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   494: iconst_0
    //   495: invokeinterface 433 3 0
    //   500: ifne +499 -> 999
    //   503: iconst_1
    //   504: istore 4
    //   506: aload_0
    //   507: iload 4
    //   509: putfield 934	com/tencent/mm/media/i/f:hoW	Z
    //   512: invokestatic 939	com/tencent/mm/sdk/platformtools/bv:fpT	()Z
    //   515: ifeq +18 -> 533
    //   518: aload_0
    //   519: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   522: ldc_w 941
    //   525: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_0
    //   529: iconst_0
    //   530: putfield 934	com/tencent/mm/media/i/f:hoW	Z
    //   533: iconst_3
    //   534: newarray double
    //   536: astore_1
    //   537: aload_1
    //   538: dup
    //   539: iconst_0
    //   540: dconst_0
    //   541: dastore
    //   542: dup
    //   543: iconst_1
    //   544: dconst_0
    //   545: dastore
    //   546: dup
    //   547: iconst_2
    //   548: dconst_0
    //   549: dastore
    //   550: pop
    //   551: aload_0
    //   552: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   555: aload_1
    //   556: aload_0
    //   557: getfield 435	com/tencent/mm/media/i/f:hlb	I
    //   560: invokestatic 946	com/tencent/mm/media/k/b:a	(Ljava/lang/String;[DI)Ljava/util/List;
    //   563: pop
    //   564: iconst_0
    //   565: istore_2
    //   566: goto +484 -> 1050
    //   569: iload_2
    //   570: ifeq +81 -> 651
    //   573: aload_1
    //   574: iconst_1
    //   575: daload
    //   576: aload_1
    //   577: iconst_0
    //   578: daload
    //   579: dsub
    //   580: aload_0
    //   581: getfield 435	com/tencent/mm/media/i/f:hlb	I
    //   584: i2d
    //   585: dcmpl
    //   586: iflt +65 -> 651
    //   589: aload_0
    //   590: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   593: new 458	java/lang/StringBuilder
    //   596: dup
    //   597: ldc_w 948
    //   600: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   603: aload_1
    //   604: iconst_0
    //   605: daload
    //   606: invokevirtual 951	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   609: ldc_w 953
    //   612: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_1
    //   616: iconst_1
    //   617: daload
    //   618: invokevirtual 951	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   621: ldc_w 955
    //   624: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload_0
    //   628: getfield 435	com/tencent/mm/media/i/f:hlb	I
    //   631: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: ldc_w 957
    //   637: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_0
    //   647: iconst_1
    //   648: putfield 934	com/tencent/mm/media/i/f:hoW	Z
    //   651: aload_0
    //   652: getfield 959	com/tencent/mm/media/i/f:hoz	Lcom/tencent/mm/media/e/b;
    //   655: ifnull +367 -> 1022
    //   658: aload_0
    //   659: getfield 959	com/tencent/mm/media/i/f:hoz	Lcom/tencent/mm/media/e/b;
    //   662: astore_1
    //   663: aload_1
    //   664: ifnull +358 -> 1022
    //   667: aload_1
    //   668: invokevirtual 965	com/tencent/mm/media/e/b:getInputSurface	()Landroid/view/Surface;
    //   671: astore_1
    //   672: aload_0
    //   673: getfield 904	com/tencent/mm/media/i/f:hoC	Lcom/tencent/mm/media/i/a;
    //   676: astore 9
    //   678: aload 9
    //   680: ifnull +363 -> 1043
    //   683: aload_0
    //   684: getfield 934	com/tencent/mm/media/i/f:hoW	Z
    //   687: ifne +340 -> 1027
    //   690: iconst_1
    //   691: istore 4
    //   693: aload_0
    //   694: getfield 382	com/tencent/mm/media/i/f:hpg	Z
    //   697: ifeq +336 -> 1033
    //   700: aload_0
    //   701: getfield 368	com/tencent/mm/media/i/f:outputWidth	I
    //   704: istore_2
    //   705: aload_0
    //   706: getfield 382	com/tencent/mm/media/i/f:hpg	Z
    //   709: ifeq +329 -> 1038
    //   712: aload_0
    //   713: getfield 370	com/tencent/mm/media/i/f:outputHeight	I
    //   716: istore_3
    //   717: aload 9
    //   719: aload_1
    //   720: iload 4
    //   722: iload_2
    //   723: iload_3
    //   724: aload_0
    //   725: getfield 404	com/tencent/mm/media/i/f:hnV	J
    //   728: new 24	com/tencent/mm/media/i/f$i
    //   731: dup
    //   732: aload_0
    //   733: invokespecial 966	com/tencent/mm/media/i/f$i:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   736: checkcast 926	d/g/a/b
    //   739: invokevirtual 969	com/tencent/mm/media/i/a:a	(Landroid/view/Surface;ZIIJLd/g/a/b;)V
    //   742: ldc_w 838
    //   745: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   748: return
    //   749: aload 10
    //   751: invokestatic 456	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   754: ifeq +9 -> 763
    //   757: aload 10
    //   759: invokestatic 972	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   762: pop
    //   763: aload_0
    //   764: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   767: ldc_w 974
    //   770: iconst_2
    //   771: anewarray 637	java/lang/Object
    //   774: dup
    //   775: iconst_0
    //   776: aload 9
    //   778: aastore
    //   779: dup
    //   780: iconst_1
    //   781: aload 10
    //   783: aastore
    //   784: invokestatic 976	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   787: invokestatic 746	com/tencent/mm/sdk/platformtools/bu:HQ	()J
    //   790: lstore 5
    //   792: aload 9
    //   794: aload 10
    //   796: invokestatic 980	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   799: lstore 7
    //   801: aload_0
    //   802: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   805: new 458	java/lang/StringBuilder
    //   808: dup
    //   809: ldc_w 982
    //   812: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   815: lload 5
    //   817: invokestatic 986	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   820: invokevirtual 615	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   823: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   829: lload 7
    //   831: lconst_0
    //   832: lcmp
    //   833: ifgt -794 -> 39
    //   836: getstatic 495	com/tencent/mm/media/k/d:hrI	Lcom/tencent/mm/media/k/d;
    //   839: astore 9
    //   841: invokestatic 989	com/tencent/mm/media/k/d:avK	()V
    //   844: goto -805 -> 39
    //   847: bipush 23
    //   849: invokestatic 995	com/tencent/mm/compatible/util/d:lA	(I)Z
    //   852: ifeq +116 -> 968
    //   855: new 997	com/tencent/mm/media/e/f
    //   858: dup
    //   859: aload 10
    //   861: new 18	com/tencent/mm/media/i/f$f
    //   864: dup
    //   865: aload 9
    //   867: aload 11
    //   869: invokespecial 1000	com/tencent/mm/media/i/f$f:<init>	(Ld/g/a/m;Ld/g/a/a;)V
    //   872: checkcast 926	d/g/a/b
    //   875: invokespecial 1003	com/tencent/mm/media/e/f:<init>	(Lcom/tencent/mm/media/b/d;Ld/g/a/b;)V
    //   878: checkcast 961	com/tencent/mm/media/e/b
    //   881: astore 9
    //   883: aload_0
    //   884: aload 9
    //   886: putfield 959	com/tencent/mm/media/i/f:hoz	Lcom/tencent/mm/media/e/b;
    //   889: goto -559 -> 330
    //   892: astore_1
    //   893: aload_0
    //   894: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   897: aload_1
    //   898: checkcast 505	java/lang/Throwable
    //   901: ldc_w 1005
    //   904: iconst_0
    //   905: anewarray 637	java/lang/Object
    //   908: invokestatic 803	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   911: getstatic 495	com/tencent/mm/media/k/d:hrI	Lcom/tencent/mm/media/k/d;
    //   914: astore_1
    //   915: invokestatic 1008	com/tencent/mm/media/k/d:avM	()V
    //   918: invokestatic 1014	com/tencent/mm/sdk/platformtools/ay:fpb	()Lcom/tencent/mm/sdk/platformtools/ay;
    //   921: ldc_w 1016
    //   924: iconst_1
    //   925: invokevirtual 1020	com/tencent/mm/sdk/platformtools/ay:putBoolean	(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   928: pop
    //   929: aload_0
    //   930: iconst_0
    //   931: iconst_1
    //   932: invokespecial 837	com/tencent/mm/media/i/f:l	(ZZ)V
    //   935: ldc_w 838
    //   938: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   941: return
    //   942: astore_1
    //   943: aload_0
    //   944: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   947: aload_1
    //   948: checkcast 505	java/lang/Throwable
    //   951: ldc_w 1022
    //   954: iconst_0
    //   955: anewarray 637	java/lang/Object
    //   958: invokestatic 803	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   961: ldc_w 838
    //   964: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   967: return
    //   968: new 1024	com/tencent/mm/media/e/e
    //   971: dup
    //   972: aload 10
    //   974: new 20	com/tencent/mm/media/i/f$g
    //   977: dup
    //   978: aload 9
    //   980: aload 11
    //   982: invokespecial 1025	com/tencent/mm/media/i/f$g:<init>	(Ld/g/a/m;Ld/g/a/a;)V
    //   985: checkcast 926	d/g/a/b
    //   988: invokespecial 1026	com/tencent/mm/media/e/e:<init>	(Lcom/tencent/mm/media/b/d;Ld/g/a/b;)V
    //   991: checkcast 961	com/tencent/mm/media/e/b
    //   994: astore 9
    //   996: goto -113 -> 883
    //   999: iconst_0
    //   1000: istore 4
    //   1002: goto -496 -> 506
    //   1005: iconst_0
    //   1006: istore_3
    //   1007: goto +58 -> 1065
    //   1010: iload_2
    //   1011: iconst_1
    //   1012: iadd
    //   1013: istore_2
    //   1014: goto +36 -> 1050
    //   1017: iconst_1
    //   1018: istore_2
    //   1019: goto -450 -> 569
    //   1022: aconst_null
    //   1023: astore_1
    //   1024: goto -352 -> 672
    //   1027: iconst_0
    //   1028: istore 4
    //   1030: goto -337 -> 693
    //   1033: iconst_0
    //   1034: istore_2
    //   1035: goto -330 -> 705
    //   1038: iconst_0
    //   1039: istore_3
    //   1040: goto -323 -> 717
    //   1043: ldc_w 838
    //   1046: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1049: return
    //   1050: iload_2
    //   1051: iconst_3
    //   1052: if_icmpge -35 -> 1017
    //   1055: aload_1
    //   1056: iload_2
    //   1057: daload
    //   1058: dconst_0
    //   1059: dcmpl
    //   1060: ifle -55 -> 1005
    //   1063: iconst_1
    //   1064: istore_3
    //   1065: iload_3
    //   1066: ifne -56 -> 1010
    //   1069: iconst_0
    //   1070: istore_2
    //   1071: goto -502 -> 569
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1074	0	this	f
    //   0	1074	1	paramc	com.tencent.mm.media.j.c
    //   565	506	2	i	int
    //   716	350	3	j	int
    //   504	525	4	bool	boolean
    //   790	26	5	l1	long
    //   799	31	7	l2	long
    //   10	985	9	localObject1	Object
    //   15	958	10	localObject2	Object
    //   83	898	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   279	320	892	java/lang/Exception
    //   325	330	892	java/lang/Exception
    //   847	883	892	java/lang/Exception
    //   883	889	892	java/lang/Exception
    //   968	996	892	java/lang/Exception
    //   247	279	942	java/lang/Exception
    //   330	351	942	java/lang/Exception
    //   356	398	942	java/lang/Exception
    //   398	411	942	java/lang/Exception
    //   416	425	942	java/lang/Exception
    //   425	438	942	java/lang/Exception
    //   443	452	942	java/lang/Exception
    //   452	458	942	java/lang/Exception
    //   463	482	942	java/lang/Exception
    //   482	503	942	java/lang/Exception
    //   506	533	942	java/lang/Exception
    //   533	564	942	java/lang/Exception
    //   573	651	942	java/lang/Exception
    //   651	663	942	java/lang/Exception
    //   667	672	942	java/lang/Exception
    //   672	678	942	java/lang/Exception
    //   683	690	942	java/lang/Exception
    //   693	705	942	java/lang/Exception
    //   705	717	942	java/lang/Exception
    //   717	748	942	java/lang/Exception
    //   893	941	942	java/lang/Exception
  }
  
  private final void atH()
  {
    AppMethodBeat.i(93805);
    ae.i(this.TAG, "finishEncode");
    Object localObject;
    if (this.hpg)
    {
      localObject = this.hoA;
      if (localObject != null) {
        com.tencent.mm.media.e.g.a((com.tencent.mm.media.e.g)localObject);
      }
      eg(true);
    }
    for (;;)
    {
      ar.ay(this.hoY);
      this.hmh = true;
      AppMethodBeat.o(93805);
      return;
      localObject = this.hoz;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).atH();
      }
    }
  }
  
  private final com.tencent.mm.media.b.d aug()
  {
    AppMethodBeat.i(93800);
    if (this.hpf > 0) {}
    com.tencent.mm.media.b.d locald;
    for (int i = Math.min(this.hpf, this.videoFps);; i = this.videoFps)
    {
      locald = new com.tencent.mm.media.b.d(this.hph);
      locald.bitrate = this.hpb;
      locald.frameRate = i;
      locald.targetHeight = this.outputHeight;
      locald.targetWidth = this.outputWidth;
      locald.hkJ = this.hpi;
      locald.hkK = this.hpj;
      if (this.hpl > 0) {
        locald.hkF = this.hpl;
      }
      while (locald.frameRate * locald.hkF - 1 <= 1)
      {
        locald.frameRate += 1;
        ae.e(this.TAG, "encodeConfig.frameRate + 1");
      }
    }
    ae.i(this.TAG, "steve: hardcoder qp:" + this.hpi + ", " + this.hpj);
    AppMethodBeat.o(93800);
    return locald;
  }
  
  /* Error */
  private final void eg(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1074
    //   5: invokestatic 312	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   12: new 458	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1076
    //   19: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: iload_1
    //   23: invokevirtual 635	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 1078
    //   29: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 1080	com/tencent/mm/media/i/f:hoQ	Z
    //   36: invokevirtual 635	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 1082
    //   42: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 1084	com/tencent/mm/media/i/f:hoP	Z
    //   49: invokevirtual 635	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1086
    //   55: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 814	com/tencent/mm/media/i/f:hoO	Z
    //   62: invokevirtual 635	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload_1
    //   72: ifeq +348 -> 420
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 1084	com/tencent/mm/media/i/f:hoP	Z
    //   80: aload_0
    //   81: getfield 1080	com/tencent/mm/media/i/f:hoQ	Z
    //   84: ifeq +353 -> 437
    //   87: aload_0
    //   88: getfield 1084	com/tencent/mm/media/i/f:hoP	Z
    //   91: ifeq +346 -> 437
    //   94: aload_0
    //   95: getfield 814	com/tencent/mm/media/i/f:hoO	Z
    //   98: ifne +339 -> 437
    //   101: aload_0
    //   102: getfield 904	com/tencent/mm/media/i/f:hoC	Lcom/tencent/mm/media/i/a;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 1087	com/tencent/mm/media/i/a:release	()V
    //   117: aload_0
    //   118: getfield 415	com/tencent/mm/media/i/f:hoN	Lcom/tencent/mm/media/k/a;
    //   121: invokevirtual 1090	com/tencent/mm/media/k/a:ald	()V
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 814	com/tencent/mm/media/i/f:hoO	Z
    //   129: getstatic 844	com/tencent/mm/media/i/j:hpS	Lcom/tencent/mm/media/i/j$a;
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   138: invokestatic 858	com/tencent/mm/media/i/j$a:yP	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 972	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   144: pop
    //   145: getstatic 844	com/tencent/mm/media/i/j:hpS	Lcom/tencent/mm/media/i/j$a;
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   154: invokestatic 849	com/tencent/mm/media/i/j$a:yQ	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 972	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 445	com/tencent/mm/media/i/f:hoX	Lcom/tencent/mm/media/i/f$n;
    //   165: invokevirtual 1093	com/tencent/mm/media/i/f$n:cancel	()Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 646	com/tencent/mm/media/i/f:hll	Lcom/tencent/mm/media/f/a;
    //   173: invokevirtual 1094	com/tencent/mm/media/f/a:release	()V
    //   176: aload_0
    //   177: getfield 716	com/tencent/mm/media/i/f:hoF	Lcom/tencent/mm/media/f/a;
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 1094	com/tencent/mm/media/f/a:release	()V
    //   192: aload_0
    //   193: getfield 865	com/tencent/mm/media/i/f:hoK	Lcom/tencent/mm/media/i/g;
    //   196: astore 4
    //   198: aload 4
    //   200: ifnull +27 -> 227
    //   203: aload 4
    //   205: getfield 1097	com/tencent/mm/media/i/g:hpJ	Ld/g/a/b;
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull +15 -> 227
    //   215: aload 4
    //   217: aload_0
    //   218: getfield 396	com/tencent/mm/media/i/f:hpn	Ld/g/a/b;
    //   221: invokeinterface 1101 2 0
    //   226: pop
    //   227: aload_0
    //   228: getfield 1103	com/tencent/mm/media/i/f:hoG	Landroid/os/HandlerThread;
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +9 -> 244
    //   238: aload 4
    //   240: invokevirtual 1108	android/os/HandlerThread:quit	()Z
    //   243: pop
    //   244: aload_0
    //   245: getfield 1110	com/tencent/mm/media/i/f:hoH	Landroid/os/HandlerThread;
    //   248: astore 4
    //   250: aload 4
    //   252: ifnull +9 -> 261
    //   255: aload 4
    //   257: invokevirtual 1108	android/os/HandlerThread:quit	()Z
    //   260: pop
    //   261: aload_0
    //   262: getfield 1112	com/tencent/mm/media/i/f:hoM	J
    //   265: invokestatic 986	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   268: lstore_2
    //   269: aload_0
    //   270: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   273: new 458	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1114
    //   280: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: lload_2
    //   284: invokevirtual 615	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: ldc_w 1116
    //   290: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 1070	com/tencent/mm/media/i/f:hoR	I
    //   297: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 1118
    //   303: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: getfield 824	com/tencent/mm/media/i/f:hkm	I
    //   310: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 1120
    //   316: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 1068	com/tencent/mm/media/i/f:hoS	I
    //   323: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 517	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: getfield 360	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   336: invokestatic 541	com/tencent/mm/plugin/sight/base/e:ayN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   339: astore 4
    //   341: aload 4
    //   343: ifnull +94 -> 437
    //   346: getstatic 495	com/tencent/mm/media/k/d:hrI	Lcom/tencent/mm/media/k/d;
    //   349: astore 5
    //   351: aload_0
    //   352: getfield 358	com/tencent/mm/media/i/f:hku	I
    //   355: lload_2
    //   356: invokestatic 1124	com/tencent/mm/media/k/d:w	(IJ)V
    //   359: getstatic 495	com/tencent/mm/media/k/d:hrI	Lcom/tencent/mm/media/k/d;
    //   362: astore 5
    //   364: aload 4
    //   366: getfield 630	com/tencent/mm/plugin/sight/base/a:videoBitrate	I
    //   369: i2l
    //   370: aload 4
    //   372: getfield 556	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   375: i2l
    //   376: aload_0
    //   377: getfield 478	com/tencent/mm/media/i/f:videoFps	I
    //   380: i2l
    //   381: invokestatic 1128	com/tencent/mm/media/k/d:f	(JJJ)V
    //   384: aload_0
    //   385: getfield 1070	com/tencent/mm/media/i/f:hoR	I
    //   388: i2f
    //   389: aload_0
    //   390: getfield 824	com/tencent/mm/media/i/f:hkm	I
    //   393: i2f
    //   394: fdiv
    //   395: f2d
    //   396: ldc2_w 1129
    //   399: dcmpl
    //   400: iflt +37 -> 437
    //   403: getstatic 495	com/tencent/mm/media/k/d:hrI	Lcom/tencent/mm/media/k/d;
    //   406: astore 4
    //   408: invokestatic 1133	com/tencent/mm/media/k/d:avV	()V
    //   411: ldc_w 1074
    //   414: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload_0
    //   418: monitorexit
    //   419: return
    //   420: aload_0
    //   421: iconst_1
    //   422: putfield 1080	com/tencent/mm/media/i/f:hoQ	Z
    //   425: goto -345 -> 80
    //   428: astore 4
    //   430: aload_0
    //   431: monitorexit
    //   432: aload 4
    //   434: athrow
    //   435: astore 4
    //   437: ldc_w 1074
    //   440: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   443: goto -26 -> 417
    //   446: astore 4
    //   448: goto -287 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	f
    //   0	451	1	paramBoolean	boolean
    //   268	88	2	l	long
    //   105	302	4	localObject1	Object
    //   428	5	4	localObject2	Object
    //   435	1	4	localException1	Exception
    //   446	1	4	localException2	Exception
    //   349	14	5	locald	com.tencent.mm.media.k.d
    // Exception table:
    //   from	to	target	type
    //   2	71	428	finally
    //   75	80	428	finally
    //   80	107	428	finally
    //   112	117	428	finally
    //   117	129	428	finally
    //   129	161	428	finally
    //   161	182	428	finally
    //   187	192	428	finally
    //   192	198	428	finally
    //   203	210	428	finally
    //   215	227	428	finally
    //   227	233	428	finally
    //   238	244	428	finally
    //   244	250	428	finally
    //   255	261	428	finally
    //   261	332	428	finally
    //   332	341	428	finally
    //   346	411	428	finally
    //   411	417	428	finally
    //   420	425	428	finally
    //   437	443	428	finally
    //   332	341	435	java/lang/Exception
    //   346	411	435	java/lang/Exception
    //   129	161	446	java/lang/Exception
  }
  
  private final void l(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(177316);
        ae.i(this.TAG, "onDecoderEncoderFailed, isDecoder:" + paramBoolean1 + " isEncoder:" + paramBoolean2);
        this.hoX.cancel();
        Object localObject1;
        if (paramBoolean1)
        {
          localObject1 = this.hom;
          if (localObject1 != null) {
            ((com.tencent.mm.media.d.f)localObject1).releaseDecoder();
          }
          this.hom = null;
        }
        if (paramBoolean2)
        {
          localObject1 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avy();
          localObject1 = this.hoz;
          if (localObject1 != null) {
            ((com.tencent.mm.media.e.b)localObject1).atI();
          }
          this.hoz = null;
        }
        if (!this.hoO)
        {
          localObject1 = this.hoC;
          if (localObject1 != null) {
            ((a)localObject1).release();
          }
          this.hoN.ald();
          this.hoO = true;
          try
          {
            localObject1 = j.hpS;
            o.deleteFile(j.a.yP(this.filePath));
            localObject1 = j.hpS;
            o.deleteFile(j.a.yQ(this.filePath));
            this.hll.release();
            localObject1 = this.hoF;
            if (localObject1 != null) {
              ((com.tencent.mm.media.f.a)localObject1).release();
            }
            localObject1 = this.hoG;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.hoH;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            o.deleteFile(this.outputFilePath);
            long l = bu.aO(this.hoM);
            ae.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.hpn;
          if (localObject1 != null)
          {
            ((d.g.a.b)localObject1).invoke(null);
            AppMethodBeat.o(177316);
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(177316);
    }
  }
  
  public final int aue()
  {
    AppMethodBeat.i(93803);
    ae.i(this.TAG, "start remux, initFinish:" + this.hoI);
    this.hoM = bu.HQ();
    if ((this.hnN != null) && (this.hoy > 0)) {
      this.hnN = h.a(this.hnN, -this.hoy);
    }
    this.hoN.gIr.reset();
    if (this.hoI)
    {
      HandlerThread localHandlerThread = this.hoG;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      this.hoG = com.tencent.mm.ac.c.a("MediaCodecRemux_audioMix", false, (d.g.a.a)new d(this));
      localHandlerThread = this.hoH;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      if (this.hom != null) {
        this.hoH = com.tencent.mm.ac.c.a("MediaCodecRemux_videoMix", false, (d.g.a.a)new e(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(93803);
      return 0;
      this.hoJ = true;
    }
  }
  
  public com.tencent.mm.media.j.c auf()
  {
    int i = 1;
    AppMethodBeat.i(164113);
    if ((this.hoy == 90) || (this.hoy == 270)) {
      if (this.hox > this.how) {
        ae.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
    }
    while (this.hpg)
    {
      localc = new com.tencent.mm.media.j.c(this.how, this.hox, this.outputWidth, this.outputHeight, 3, i);
      AppMethodBeat.o(164113);
      return localc;
      ae.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
      i = 2;
      continue;
      if (this.how > this.hox)
      {
        ae.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
      else
      {
        ae.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
        i = 2;
      }
    }
    com.tencent.mm.media.j.c localc = new com.tencent.mm.media.j.c(this.how, this.hox, this.outputWidth, this.outputHeight, i);
    AppMethodBeat.o(164113);
    return localc;
  }
  
  public final void k(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93802);
    p.h(paramb, "blendBitmapProvider");
    this.hnM = paramb;
    a locala = this.hoC;
    if (locala != null)
    {
      locala.i(paramb);
      AppMethodBeat.o(93802);
      return;
    }
    AppMethodBeat.o(93802);
  }
  
  public final void l(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93804);
    p.h(paramb, "blurBgProvider");
    this.hoL = paramb;
    a locala = this.hoC;
    if (locala != null)
    {
      locala.j(paramb);
      AppMethodBeat.o(93804);
      return;
    }
    AppMethodBeat.o(93804);
  }
  
  public final void z(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93801);
    p.h(paramBitmap, "bitmap");
    this.hnN = paramBitmap;
    a locala = this.hoC;
    if (locala != null)
    {
      String str = locala.TAG;
      StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmap:");
      if (paramBitmap != null) {}
      for (int i = paramBitmap.hashCode();; i = 0)
      {
        ae.i(str, i);
        locala.hnN = paramBitmap;
        AppMethodBeat.o(93801);
        return;
      }
    }
    AppMethodBeat.o(93801);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93779);
      ae.i(f.a(this.hpr), "delay check frameDraw: " + f.m(this.hpr));
      if (!f.m(this.hpr))
      {
        ae.e(f.a(this.hpr), "after " + f.auh() + " ms, first frame stil not draw!!!");
        com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.awg();
      }
      AppMethodBeat.o(93779);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93780);
      ae.i(f.a(this.hpr), "decode end after " + f.aui() + ", isFinishEncode:" + f.I(this.hpr));
      if (!f.I(this.hpr))
      {
        com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.awj();
        f.J(this.hpr);
      }
      AppMethodBeat.o(93780);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    f(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    g(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<Boolean, z>
  {
    h(f paramf, com.tencent.mm.media.j.c paramc, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.b<Boolean, z>
  {
    i(f paramf)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, z>
    {
      a(f.i parami)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      b(f.i parami)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      c(f.i parami)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends d.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, z>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, z>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    m(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "plugin-mediaeditor_release"})
  public static final class n
    extends com.tencent.e.i.b
  {
    public final String getKey()
    {
      return "MediaCodecRemuxer#timeoutInvoke";
    }
    
    public final void run()
    {
      AppMethodBeat.i(177315);
      ae.e(f.a(this.hpr), "remux error! handing one frame time out ,isInvokeEndCallback:" + f.H(this.hpr));
      f localf;
      if (!f.H(this.hpr))
      {
        localf = this.hpr;
        if (f.c(this.hpr)) {
          break label76;
        }
      }
      label76:
      for (boolean bool = true;; bool = false)
      {
        f.a(localf, bool, true);
        AppMethodBeat.o(177315);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.i.f
 * JD-Core Version:    0.7.0.1
 */