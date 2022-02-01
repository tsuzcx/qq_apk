package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "videoWidth", "videoHeight", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "blurBgProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getFinishCallback", "()Lkotlin/jvm/functions/Function1;", "setFinishCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstFrameDraw", "getForceLandscape", "setForceLandscape", "frameHandingTime", "frameTimeoutMs", "getIFrame", "()I", "setIFrame", "(I)V", "initFinish", "inputHeight", "getInputHeight", "setInputHeight", "inputWidth", "getInputWidth", "setInputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "setMixType", "musicExtractorWrapper", "getOutputAudioBitrate", "setOutputAudioBitrate", "getOutputAudioChannelCount", "setOutputAudioChannelCount", "getOutputAudioSampleRate", "setOutputAudioSampleRate", "getOutputBitrate", "setOutputBitrate", "getOutputFilePath", "getOutputFps", "setOutputFps", "getOutputHeight", "setOutputHeight", "getOutputWidth", "setOutputWidth", "getProgressListener", "setProgressListener", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "timeoutInvoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1;", "useRequestDraw", "getUseSoftEncode", "setUseSoftEncode", "vfrThreshold", "videoDuration", "videoFps", "getVideoHeight", "getVideoMinQP", "setVideoMinQP", "videoMixHandlerThread", "videoRotate", "getVideoWidth", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "checkFrameDrawTimeout", "checkVideoHasBFrame", "afterCheck", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "onDecoderEncoderFailed", "isDecoder", "isEncoder", "remux", "remuxImpl", "renderer", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "startRemux", "Companion", "plugin-mediaeditor_release"})
public class f
  extends d
  implements c
{
  private static final long hmA = 1000L;
  private static final long hmB = 1000L;
  public static final f.a hmC;
  private final String TAG;
  private String filePath;
  private int hhG;
  private volatile boolean hhr;
  private int hhy;
  private final int hin;
  private com.tencent.mm.media.f.a hix;
  private volatile boolean hjt;
  private d.g.a.b<? super Long, Bitmap> hkY;
  private Bitmap hkZ;
  protected int hlH;
  protected int hlI;
  private int hlJ;
  private long hlK;
  private com.tencent.mm.media.e.b hlL;
  private com.tencent.mm.media.e.g hlM;
  private com.tencent.mm.media.a.a hlN;
  private a hlO;
  private i hlP;
  private com.tencent.mm.media.f.a hlQ;
  private com.tencent.mm.media.f.a hlR;
  private HandlerThread hlS;
  private HandlerThread hlT;
  private boolean hlU;
  private boolean hlV;
  private g hlW;
  private d.g.a.b<? super Long, Bitmap> hlX;
  private long hlY;
  private final com.tencent.mm.media.k.a hlZ;
  private com.tencent.mm.media.d.f hlx;
  private volatile boolean hma;
  private boolean hmb;
  private boolean hmc;
  private int hmd;
  private int hme;
  private long hmf;
  private final int hmg;
  private volatile boolean hmh;
  private volatile boolean hmi;
  private final n hmj;
  private final Runnable hmk;
  private final String hml;
  protected Rect hmm;
  private int hmn;
  private int hmo;
  private int hmp;
  private int hmq;
  int hmr;
  protected boolean hms;
  private boolean hmt;
  private int hmu;
  private int hmv;
  private boolean hmw;
  private int hmx;
  d.g.a.b<? super Float, z> hmy;
  private d.g.a.b<? super String, z> hmz;
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
    hmC = new f.a((byte)0);
    hmA = 1000L;
    hmB = 1000L;
    AppMethodBeat.o(93809);
  }
  
  public f(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt11, int paramInt12, boolean paramBoolean3, int paramInt13, d.g.a.b<? super Float, z> paramb, d.g.a.b<? super String, z> paramb1)
  {
    AppMethodBeat.i(219299);
    this.hml = paramString1;
    this.filePath = paramString2;
    this.hhG = paramInt1;
    this.outputFilePath = paramString3;
    this.hmm = paramRect;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    this.outputWidth = paramInt4;
    this.outputHeight = paramInt5;
    this.hmn = paramInt6;
    this.hmo = paramInt7;
    this.hmp = paramInt8;
    this.hmq = paramInt9;
    this.hmr = paramInt10;
    this.hms = paramBoolean1;
    this.hmt = paramBoolean2;
    this.hmu = paramInt11;
    this.hmv = paramInt12;
    this.hmw = paramBoolean3;
    this.hmx = paramInt13;
    this.hmy = paramb;
    this.hmz = paramb1;
    this.TAG = "MicroMsg.MediaCodecRemuxer";
    this.videoDuration = -1;
    this.hlK = paramLong1;
    this.remuxEndTime = -1L;
    this.hlZ = new com.tencent.mm.media.k.a("remuxCost");
    this.hin = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyk, 10);
    this.hmg = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyl, 10000);
    this.hmj = new n(this);
    if ((bt.isNullOrNil(this.filePath)) || (!com.tencent.mm.vfs.i.fv(this.filePath)) || (bt.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
    {
      ad.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.hmr);
      paramString1 = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.avt();
      paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
      AppMethodBeat.o(219299);
      throw paramString1;
    }
    paramString1 = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.nO(this.hhG);
    if (com.tencent.mm.bl.e.HI(this.filePath))
    {
      ad.i(this.TAG, "remux h265 format");
      paramString1 = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.avs();
    }
    com.tencent.mm.vfs.i.aYg(com.tencent.mm.vfs.i.aYr(this.outputFilePath));
    this.hlJ = SightVideoJNI.getMp4RotateVFS(this.filePath);
    if ((this.hmw) && ((this.hlJ == 90) || (this.hlJ == 270)))
    {
      paramInt1 = this.outputWidth;
      this.outputWidth = this.outputHeight;
      this.outputHeight = paramInt1;
    }
    paramString2 = com.tencent.mm.plugin.sight.base.e.axx(this.filePath);
    if (paramString2 != null)
    {
      this.hlH = paramString2.width;
      this.hlI = paramString2.height;
      this.videoFps = paramString2.frameRate;
      this.videoDuration = paramString2.videoDuration;
    }
    if ((this.hlH <= 0) || (this.hlI <= 0)) {}
    try
    {
      paramString1 = new com.tencent.mm.compatible.h.d();
      paramString1.setDataSource(this.filePath);
      this.hlH = bt.getInt(paramString1.extractMetadata(18), 0);
      this.hlI = bt.getInt(paramString1.extractMetadata(19), 0);
      paramString1.release();
      label627:
      if (this.videoFps <= 0)
      {
        ad.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
        paramString1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avt();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(219299);
        throw paramString1;
      }
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        ad.i(this.TAG, "MediaCodecRemuxer frameTimeoutMs is:" + this.hmg);
        if (!this.hms) {
          break label1273;
        }
        paramString1 = new i(this.hlK, this.remuxEndTime, this.hmn, this.outputWidth, this.outputHeight, this.hms, this.hmr, this.hmt);
        label787:
        this.hlP = paramString1;
        if (this.hmq <= 0) {
          this.hmq = 1;
        }
        ad.m(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.hlH + ", inputHeight: " + this.hlI + ", videoRotate: " + this.hlJ + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.hmn + ", outputAudioBitrate:" + this.hmo + ", outputAudioChannelCount:" + this.hmq + ", outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.hmr + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.hlK + " ,remuxEndTime: " + this.remuxEndTime + " , input bitrate:" + paramString2.videoBitrate + ", enableHevc:" + this.hmt, new Object[0]);
        this.hix = new com.tencent.mm.media.f.a(this.filePath);
        if (this.hix.hke)
        {
          paramString1 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.avu();
        }
        paramInt1 = this.outputWidth - this.hlH;
        if ((1 <= paramInt1) && (16 > paramInt1)) {
          break label1306;
        }
        paramInt1 = this.outputHeight - this.hlI;
        if (1 <= paramInt1) {
          break label1300;
        }
        label1138:
        paramBoolean1 = false;
        label1141:
        ad.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(paramBoolean1)));
        ad.i(this.TAG, "startRemux, useSoftEncode:" + this.hms + ", enablHevc:" + this.hmt);
        if (this.hmt)
        {
          if (!this.hms) {
            break label1312;
          }
          paramString1 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.avW();
        }
      }
      for (;;)
      {
        if (this.hms)
        {
          paramString1 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.avV();
        }
        a(atQ());
        this.hmk = ((Runnable)new c(this));
        AppMethodBeat.o(219299);
        return;
        this.remuxEndTime = paramLong2;
        break;
        label1273:
        paramString1 = new i(this.hlK, this.remuxEndTime, this.hmn, this.hms);
        break label787;
        label1300:
        if (16 <= paramInt1) {
          break label1138;
        }
        label1306:
        paramBoolean1 = true;
        break label1141;
        label1312:
        paramString1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avX();
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
    //   0: ldc_w 837
    //   3: invokestatic 312	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   10: astore 9
    //   12: getstatic 843	com/tencent/mm/media/i/j:hne	Lcom/tencent/mm/media/i/j$a;
    //   15: astore 10
    //   17: aload 9
    //   19: invokestatic 848	com/tencent/mm/media/i/j$a:yg	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: ifnonnull +719 -> 745
    //   29: aload_0
    //   30: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   33: ldc_w 850
    //   36: invokestatic 489	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 843	com/tencent/mm/media/i/j:hne	Lcom/tencent/mm/media/i/j$a;
    //   42: astore 9
    //   44: aload_0
    //   45: new 643	com/tencent/mm/media/f/a
    //   48: dup
    //   49: aload_0
    //   50: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   53: invokestatic 848	com/tencent/mm/media/i/j$a:yg	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 644	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   59: putfield 714	com/tencent/mm/media/i/f:hlR	Lcom/tencent/mm/media/f/a;
    //   62: aload_0
    //   63: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   66: astore 9
    //   68: new 458	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 852
    //   75: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: astore 10
    //   80: getstatic 843	com/tencent/mm/media/i/j:hne	Lcom/tencent/mm/media/i/j$a;
    //   83: astore 11
    //   85: aload 10
    //   87: aload_0
    //   88: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   91: invokestatic 848	com/tencent/mm/media/i/j$a:yg	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 854
    //   100: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: astore 10
    //   105: getstatic 843	com/tencent/mm/media/i/j:hne	Lcom/tencent/mm/media/i/j$a;
    //   108: astore 11
    //   110: aload 9
    //   112: aload 10
    //   114: aload_0
    //   115: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   118: invokestatic 857	com/tencent/mm/media/i/j$a:yf	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 517	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 714	com/tencent/mm/media/i/f:hlR	Lcom/tencent/mm/media/f/a;
    //   134: astore 9
    //   136: aload 9
    //   138: ifnull +89 -> 227
    //   141: aload_0
    //   142: new 859	com/tencent/mm/media/i/g
    //   145: dup
    //   146: aload_0
    //   147: getfield 585	com/tencent/mm/media/i/f:hlP	Lcom/tencent/mm/media/i/i;
    //   150: aload 9
    //   152: aload_0
    //   153: getfield 360	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 358	com/tencent/mm/media/i/f:hhG	I
    //   160: aload_0
    //   161: getfield 376	com/tencent/mm/media/i/f:hmp	I
    //   164: invokespecial 862	com/tencent/mm/media/i/g:<init>	(Lcom/tencent/mm/media/i/i;Lcom/tencent/mm/media/f/a;Ljava/lang/String;II)V
    //   167: putfield 864	com/tencent/mm/media/i/f:hlW	Lcom/tencent/mm/media/i/g;
    //   170: aload_0
    //   171: getfield 354	com/tencent/mm/media/i/f:hml	Ljava/lang/String;
    //   174: invokestatic 456	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   177: ifeq +50 -> 227
    //   180: aload_0
    //   181: getfield 354	com/tencent/mm/media/i/f:hml	Ljava/lang/String;
    //   184: astore 9
    //   186: aload 9
    //   188: ifnonnull +6 -> 194
    //   191: invokestatic 766	d/g/b/p:gfZ	()V
    //   194: new 643	com/tencent/mm/media/f/a
    //   197: dup
    //   198: aload 9
    //   200: invokespecial 644	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   203: astore 9
    //   205: aload 9
    //   207: getfield 649	com/tencent/mm/media/f/a:hke	Z
    //   210: ifeq +11 -> 221
    //   213: getstatic 495	com/tencent/mm/media/k/d:hoU	Lcom/tencent/mm/media/k/d;
    //   216: astore 10
    //   218: invokestatic 867	com/tencent/mm/media/k/d:avw	()V
    //   221: aload_0
    //   222: aload 9
    //   224: putfield 708	com/tencent/mm/media/i/f:hlQ	Lcom/tencent/mm/media/f/a;
    //   227: aload_0
    //   228: getfield 864	com/tencent/mm/media/i/f:hlW	Lcom/tencent/mm/media/i/g;
    //   231: astore 9
    //   233: aload 9
    //   235: ifnull +12 -> 247
    //   238: aload 9
    //   240: aload_0
    //   241: getfield 535	com/tencent/mm/media/i/f:hlJ	I
    //   244: putfield 868	com/tencent/mm/media/i/g:hlJ	I
    //   247: aload_0
    //   248: invokespecial 872	com/tencent/mm/media/i/f:atR	()Lcom/tencent/mm/media/b/d;
    //   251: astore 10
    //   253: new 42	com/tencent/mm/media/i/f$j
    //   256: dup
    //   257: aload_0
    //   258: invokespecial 873	com/tencent/mm/media/i/f$j:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   261: checkcast 875	d/g/a/m
    //   264: astore 9
    //   266: new 44	com/tencent/mm/media/i/f$k
    //   269: dup
    //   270: aload_0
    //   271: invokespecial 876	com/tencent/mm/media/i/f$k:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   274: checkcast 788	d/g/a/a
    //   277: astore 11
    //   279: aload_0
    //   280: getfield 382	com/tencent/mm/media/i/f:hms	Z
    //   283: ifeq +560 -> 843
    //   286: aload_0
    //   287: new 878	com/tencent/mm/media/e/g
    //   290: dup
    //   291: aload_0
    //   292: getfield 585	com/tencent/mm/media/i/f:hlP	Lcom/tencent/mm/media/i/i;
    //   295: getfield 748	com/tencent/mm/media/i/i:bufId	I
    //   298: aload 10
    //   300: getfield 883	com/tencent/mm/media/b/d:targetWidth	I
    //   303: aload 10
    //   305: getfield 886	com/tencent/mm/media/b/d:targetHeight	I
    //   308: invokespecial 889	com/tencent/mm/media/e/g:<init>	(III)V
    //   311: putfield 891	com/tencent/mm/media/i/f:hlM	Lcom/tencent/mm/media/e/g;
    //   314: aload_0
    //   315: getfield 891	com/tencent/mm/media/i/f:hlM	Lcom/tencent/mm/media/e/g;
    //   318: astore 9
    //   320: aload 9
    //   322: ifnull +8 -> 330
    //   325: aload 9
    //   327: invokevirtual 894	com/tencent/mm/media/e/g:start	()V
    //   330: aload_0
    //   331: new 896	com/tencent/mm/media/i/a
    //   334: dup
    //   335: aload_1
    //   336: checkcast 898	com/tencent/mm/media/j/a
    //   339: invokespecial 901	com/tencent/mm/media/i/a:<init>	(Lcom/tencent/mm/media/j/a;)V
    //   342: putfield 903	com/tencent/mm/media/i/f:hlO	Lcom/tencent/mm/media/i/a;
    //   345: aload_0
    //   346: getfield 903	com/tencent/mm/media/i/f:hlO	Lcom/tencent/mm/media/i/a;
    //   349: astore 9
    //   351: aload 9
    //   353: ifnull +45 -> 398
    //   356: aload 9
    //   358: ldc_w 904
    //   361: aload_0
    //   362: getfield 478	com/tencent/mm/media/i/f:videoFps	I
    //   365: idiv
    //   366: putfield 907	com/tencent/mm/media/i/a:hlf	I
    //   369: aload 9
    //   371: getfield 908	com/tencent/mm/media/i/a:TAG	Ljava/lang/String;
    //   374: new 458	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 910
    //   381: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload 9
    //   386: getfield 907	com/tencent/mm/media/i/a:hlf	I
    //   389: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 517	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_0
    //   399: getfield 912	com/tencent/mm/media/i/f:hkY	Ld/g/a/b;
    //   402: ifnull +23 -> 425
    //   405: aload_0
    //   406: getfield 903	com/tencent/mm/media/i/f:hlO	Lcom/tencent/mm/media/i/a;
    //   409: astore 9
    //   411: aload 9
    //   413: ifnull +12 -> 425
    //   416: aload 9
    //   418: aload_0
    //   419: getfield 912	com/tencent/mm/media/i/f:hkY	Ld/g/a/b;
    //   422: invokevirtual 915	com/tencent/mm/media/i/a:i	(Ld/g/a/b;)V
    //   425: aload_0
    //   426: getfield 917	com/tencent/mm/media/i/f:hlX	Ld/g/a/b;
    //   429: ifnull +23 -> 452
    //   432: aload_0
    //   433: getfield 903	com/tencent/mm/media/i/f:hlO	Lcom/tencent/mm/media/i/a;
    //   436: astore 9
    //   438: aload 9
    //   440: ifnull +12 -> 452
    //   443: aload 9
    //   445: aload_0
    //   446: getfield 917	com/tencent/mm/media/i/f:hlX	Ld/g/a/b;
    //   449: invokevirtual 920	com/tencent/mm/media/i/a:j	(Ld/g/a/b;)V
    //   452: aload_0
    //   453: getfield 903	com/tencent/mm/media/i/f:hlO	Lcom/tencent/mm/media/i/a;
    //   456: astore 9
    //   458: aload 9
    //   460: ifnull +22 -> 482
    //   463: aload 9
    //   465: new 22	com/tencent/mm/media/i/f$h
    //   468: dup
    //   469: aload_0
    //   470: aload_1
    //   471: aload 10
    //   473: invokespecial 923	com/tencent/mm/media/i/f$h:<init>	(Lcom/tencent/mm/media/i/f;Lcom/tencent/mm/media/j/c;Lcom/tencent/mm/media/b/d;)V
    //   476: checkcast 925	d/g/a/b
    //   479: putfield 928	com/tencent/mm/media/i/a:hkU	Ld/g/a/b;
    //   482: ldc_w 417
    //   485: invokestatic 423	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   488: checkcast 417	com/tencent/mm/plugin/expt/b/b
    //   491: getstatic 931	com/tencent/mm/plugin/expt/b/b$a:qyh	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   494: iconst_0
    //   495: invokeinterface 433 3 0
    //   500: ifne +495 -> 995
    //   503: iconst_1
    //   504: istore 4
    //   506: aload_0
    //   507: iload 4
    //   509: putfield 933	com/tencent/mm/media/i/f:hmi	Z
    //   512: invokestatic 938	com/tencent/mm/sdk/platformtools/bu:flY	()Z
    //   515: ifeq +18 -> 533
    //   518: aload_0
    //   519: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   522: ldc_w 940
    //   525: invokestatic 517	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_0
    //   529: iconst_0
    //   530: putfield 933	com/tencent/mm/media/i/f:hmi	Z
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
    //   557: getfield 435	com/tencent/mm/media/i/f:hin	I
    //   560: invokestatic 945	com/tencent/mm/media/k/b:a	(Ljava/lang/String;[DI)Ljava/util/List;
    //   563: pop
    //   564: iconst_0
    //   565: istore_2
    //   566: goto +480 -> 1046
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
    //   581: getfield 435	com/tencent/mm/media/i/f:hin	I
    //   584: i2d
    //   585: dcmpl
    //   586: iflt +65 -> 651
    //   589: aload_0
    //   590: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   593: new 458	java/lang/StringBuilder
    //   596: dup
    //   597: ldc_w 947
    //   600: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   603: aload_1
    //   604: iconst_0
    //   605: daload
    //   606: invokevirtual 950	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   609: ldc_w 952
    //   612: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_1
    //   616: iconst_1
    //   617: daload
    //   618: invokevirtual 950	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   621: ldc_w 954
    //   624: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload_0
    //   628: getfield 435	com/tencent/mm/media/i/f:hin	I
    //   631: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: ldc_w 956
    //   637: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 517	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_0
    //   647: iconst_1
    //   648: putfield 933	com/tencent/mm/media/i/f:hmi	Z
    //   651: aload_0
    //   652: getfield 958	com/tencent/mm/media/i/f:hlL	Lcom/tencent/mm/media/e/b;
    //   655: ifnull +363 -> 1018
    //   658: aload_0
    //   659: getfield 958	com/tencent/mm/media/i/f:hlL	Lcom/tencent/mm/media/e/b;
    //   662: astore_1
    //   663: aload_1
    //   664: ifnull +354 -> 1018
    //   667: aload_1
    //   668: invokevirtual 964	com/tencent/mm/media/e/b:getInputSurface	()Landroid/view/Surface;
    //   671: astore_1
    //   672: aload_0
    //   673: getfield 903	com/tencent/mm/media/i/f:hlO	Lcom/tencent/mm/media/i/a;
    //   676: astore 9
    //   678: aload 9
    //   680: ifnull +359 -> 1039
    //   683: aload_0
    //   684: getfield 933	com/tencent/mm/media/i/f:hmi	Z
    //   687: ifne +336 -> 1023
    //   690: iconst_1
    //   691: istore 4
    //   693: aload_0
    //   694: getfield 382	com/tencent/mm/media/i/f:hms	Z
    //   697: ifeq +332 -> 1029
    //   700: aload_0
    //   701: getfield 368	com/tencent/mm/media/i/f:outputWidth	I
    //   704: istore_2
    //   705: aload_0
    //   706: getfield 382	com/tencent/mm/media/i/f:hms	Z
    //   709: ifeq +325 -> 1034
    //   712: aload_0
    //   713: getfield 370	com/tencent/mm/media/i/f:outputHeight	I
    //   716: istore_3
    //   717: aload 9
    //   719: aload_1
    //   720: iload 4
    //   722: iload_2
    //   723: iload_3
    //   724: new 24	com/tencent/mm/media/i/f$i
    //   727: dup
    //   728: aload_0
    //   729: invokespecial 965	com/tencent/mm/media/i/f$i:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   732: checkcast 925	d/g/a/b
    //   735: invokevirtual 968	com/tencent/mm/media/i/a:a	(Landroid/view/Surface;ZIILd/g/a/b;)V
    //   738: ldc_w 837
    //   741: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   744: return
    //   745: aload 10
    //   747: invokestatic 456	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   750: ifeq +9 -> 759
    //   753: aload 10
    //   755: invokestatic 971	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   758: pop
    //   759: aload_0
    //   760: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   763: ldc_w 973
    //   766: iconst_2
    //   767: anewarray 637	java/lang/Object
    //   770: dup
    //   771: iconst_0
    //   772: aload 9
    //   774: aastore
    //   775: dup
    //   776: iconst_1
    //   777: aload 10
    //   779: aastore
    //   780: invokestatic 975	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   783: invokestatic 743	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   786: lstore 5
    //   788: aload 9
    //   790: aload 10
    //   792: invokestatic 979	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   795: lstore 7
    //   797: aload_0
    //   798: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   801: new 458	java/lang/StringBuilder
    //   804: dup
    //   805: ldc_w 981
    //   808: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   811: lload 5
    //   813: invokestatic 985	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   816: invokevirtual 615	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   819: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokestatic 517	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: lload 7
    //   827: lconst_0
    //   828: lcmp
    //   829: ifgt -790 -> 39
    //   832: getstatic 495	com/tencent/mm/media/k/d:hoU	Lcom/tencent/mm/media/k/d;
    //   835: astore 9
    //   837: invokestatic 988	com/tencent/mm/media/k/d:avv	()V
    //   840: goto -801 -> 39
    //   843: bipush 23
    //   845: invokestatic 994	com/tencent/mm/compatible/util/d:ly	(I)Z
    //   848: ifeq +116 -> 964
    //   851: new 996	com/tencent/mm/media/e/f
    //   854: dup
    //   855: aload 10
    //   857: new 18	com/tencent/mm/media/i/f$f
    //   860: dup
    //   861: aload 9
    //   863: aload 11
    //   865: invokespecial 999	com/tencent/mm/media/i/f$f:<init>	(Ld/g/a/m;Ld/g/a/a;)V
    //   868: checkcast 925	d/g/a/b
    //   871: invokespecial 1002	com/tencent/mm/media/e/f:<init>	(Lcom/tencent/mm/media/b/d;Ld/g/a/b;)V
    //   874: checkcast 960	com/tencent/mm/media/e/b
    //   877: astore 9
    //   879: aload_0
    //   880: aload 9
    //   882: putfield 958	com/tencent/mm/media/i/f:hlL	Lcom/tencent/mm/media/e/b;
    //   885: goto -555 -> 330
    //   888: astore_1
    //   889: aload_0
    //   890: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   893: aload_1
    //   894: checkcast 505	java/lang/Throwable
    //   897: ldc_w 1004
    //   900: iconst_0
    //   901: anewarray 637	java/lang/Object
    //   904: invokestatic 801	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   907: getstatic 495	com/tencent/mm/media/k/d:hoU	Lcom/tencent/mm/media/k/d;
    //   910: astore_1
    //   911: invokestatic 1007	com/tencent/mm/media/k/d:avx	()V
    //   914: invokestatic 1013	com/tencent/mm/sdk/platformtools/ax:flg	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   917: ldc_w 1015
    //   920: iconst_1
    //   921: invokevirtual 1019	com/tencent/mm/sdk/platformtools/ax:putBoolean	(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   924: pop
    //   925: aload_0
    //   926: iconst_0
    //   927: iconst_1
    //   928: invokespecial 836	com/tencent/mm/media/i/f:l	(ZZ)V
    //   931: ldc_w 837
    //   934: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   937: return
    //   938: astore_1
    //   939: aload_0
    //   940: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   943: aload_1
    //   944: checkcast 505	java/lang/Throwable
    //   947: ldc_w 1021
    //   950: iconst_0
    //   951: anewarray 637	java/lang/Object
    //   954: invokestatic 801	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   957: ldc_w 837
    //   960: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   963: return
    //   964: new 1023	com/tencent/mm/media/e/e
    //   967: dup
    //   968: aload 10
    //   970: new 20	com/tencent/mm/media/i/f$g
    //   973: dup
    //   974: aload 9
    //   976: aload 11
    //   978: invokespecial 1024	com/tencent/mm/media/i/f$g:<init>	(Ld/g/a/m;Ld/g/a/a;)V
    //   981: checkcast 925	d/g/a/b
    //   984: invokespecial 1025	com/tencent/mm/media/e/e:<init>	(Lcom/tencent/mm/media/b/d;Ld/g/a/b;)V
    //   987: checkcast 960	com/tencent/mm/media/e/b
    //   990: astore 9
    //   992: goto -113 -> 879
    //   995: iconst_0
    //   996: istore 4
    //   998: goto -492 -> 506
    //   1001: iconst_0
    //   1002: istore_3
    //   1003: goto +58 -> 1061
    //   1006: iload_2
    //   1007: iconst_1
    //   1008: iadd
    //   1009: istore_2
    //   1010: goto +36 -> 1046
    //   1013: iconst_1
    //   1014: istore_2
    //   1015: goto -446 -> 569
    //   1018: aconst_null
    //   1019: astore_1
    //   1020: goto -348 -> 672
    //   1023: iconst_0
    //   1024: istore 4
    //   1026: goto -333 -> 693
    //   1029: iconst_0
    //   1030: istore_2
    //   1031: goto -326 -> 705
    //   1034: iconst_0
    //   1035: istore_3
    //   1036: goto -319 -> 717
    //   1039: ldc_w 837
    //   1042: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1045: return
    //   1046: iload_2
    //   1047: iconst_3
    //   1048: if_icmpge -35 -> 1013
    //   1051: aload_1
    //   1052: iload_2
    //   1053: daload
    //   1054: dconst_0
    //   1055: dcmpl
    //   1056: ifle -55 -> 1001
    //   1059: iconst_1
    //   1060: istore_3
    //   1061: iload_3
    //   1062: ifne -56 -> 1006
    //   1065: iconst_0
    //   1066: istore_2
    //   1067: goto -498 -> 569
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1070	0	this	f
    //   0	1070	1	paramc	com.tencent.mm.media.j.c
    //   565	502	2	i	int
    //   716	346	3	j	int
    //   504	521	4	bool	boolean
    //   786	26	5	l1	long
    //   795	31	7	l2	long
    //   10	981	9	localObject1	Object
    //   15	954	10	localObject2	Object
    //   83	894	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   279	320	888	java/lang/Exception
    //   325	330	888	java/lang/Exception
    //   843	879	888	java/lang/Exception
    //   879	885	888	java/lang/Exception
    //   964	992	888	java/lang/Exception
    //   247	279	938	java/lang/Exception
    //   330	351	938	java/lang/Exception
    //   356	398	938	java/lang/Exception
    //   398	411	938	java/lang/Exception
    //   416	425	938	java/lang/Exception
    //   425	438	938	java/lang/Exception
    //   443	452	938	java/lang/Exception
    //   452	458	938	java/lang/Exception
    //   463	482	938	java/lang/Exception
    //   482	503	938	java/lang/Exception
    //   506	533	938	java/lang/Exception
    //   533	564	938	java/lang/Exception
    //   573	651	938	java/lang/Exception
    //   651	663	938	java/lang/Exception
    //   667	672	938	java/lang/Exception
    //   672	678	938	java/lang/Exception
    //   683	690	938	java/lang/Exception
    //   693	705	938	java/lang/Exception
    //   705	717	938	java/lang/Exception
    //   717	744	938	java/lang/Exception
    //   889	937	938	java/lang/Exception
  }
  
  private final com.tencent.mm.media.b.d atR()
  {
    AppMethodBeat.i(93800);
    if (this.hmr > 0) {}
    com.tencent.mm.media.b.d locald;
    for (int i = Math.min(this.hmr, this.videoFps);; i = this.videoFps)
    {
      locald = new com.tencent.mm.media.b.d(this.hmt);
      locald.bitrate = this.hmn;
      locald.frameRate = i;
      locald.targetHeight = this.outputHeight;
      locald.targetWidth = this.outputWidth;
      locald.hhV = this.hmu;
      locald.hhW = this.hmv;
      if (this.hmx > 0) {
        locald.hhR = this.hmx;
      }
      while (locald.frameRate * locald.hhR - 1 <= 1)
      {
        locald.frameRate += 1;
        ad.e(this.TAG, "encodeConfig.frameRate + 1");
      }
    }
    ad.i(this.TAG, "steve: hardcoder qp:" + this.hmu + ", " + this.hmv);
    AppMethodBeat.o(93800);
    return locald;
  }
  
  private final void ats()
  {
    AppMethodBeat.i(93805);
    ad.i(this.TAG, "finishEncode");
    Object localObject;
    if (this.hms)
    {
      localObject = this.hlM;
      if (localObject != null) {
        com.tencent.mm.media.e.g.a((com.tencent.mm.media.e.g)localObject);
      }
      ee(true);
    }
    for (;;)
    {
      aq.aA(this.hmk);
      this.hjt = true;
      AppMethodBeat.o(93805);
      return;
      localObject = this.hlL;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).ats();
      }
    }
  }
  
  /* Error */
  private final void ee(boolean paramBoolean)
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
    //   33: getfield 1080	com/tencent/mm/media/i/f:hmc	Z
    //   36: invokevirtual 635	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 1082
    //   42: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 1084	com/tencent/mm/media/i/f:hmb	Z
    //   49: invokevirtual 635	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1086
    //   55: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 812	com/tencent/mm/media/i/f:hma	Z
    //   62: invokevirtual 635	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 517	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload_1
    //   72: ifeq +348 -> 420
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 1084	com/tencent/mm/media/i/f:hmb	Z
    //   80: aload_0
    //   81: getfield 1080	com/tencent/mm/media/i/f:hmc	Z
    //   84: ifeq +353 -> 437
    //   87: aload_0
    //   88: getfield 1084	com/tencent/mm/media/i/f:hmb	Z
    //   91: ifeq +346 -> 437
    //   94: aload_0
    //   95: getfield 812	com/tencent/mm/media/i/f:hma	Z
    //   98: ifne +339 -> 437
    //   101: aload_0
    //   102: getfield 903	com/tencent/mm/media/i/f:hlO	Lcom/tencent/mm/media/i/a;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 1087	com/tencent/mm/media/i/a:release	()V
    //   117: aload_0
    //   118: getfield 415	com/tencent/mm/media/i/f:hlZ	Lcom/tencent/mm/media/k/a;
    //   121: invokevirtual 1090	com/tencent/mm/media/k/a:akO	()V
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 812	com/tencent/mm/media/i/f:hma	Z
    //   129: getstatic 843	com/tencent/mm/media/i/j:hne	Lcom/tencent/mm/media/i/j$a;
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   138: invokestatic 857	com/tencent/mm/media/i/j$a:yf	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 971	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   144: pop
    //   145: getstatic 843	com/tencent/mm/media/i/j:hne	Lcom/tencent/mm/media/i/j$a;
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   154: invokestatic 848	com/tencent/mm/media/i/j$a:yg	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 971	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 445	com/tencent/mm/media/i/f:hmj	Lcom/tencent/mm/media/i/f$n;
    //   165: invokevirtual 1093	com/tencent/mm/media/i/f$n:cancel	()Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 646	com/tencent/mm/media/i/f:hix	Lcom/tencent/mm/media/f/a;
    //   173: invokevirtual 1094	com/tencent/mm/media/f/a:release	()V
    //   176: aload_0
    //   177: getfield 714	com/tencent/mm/media/i/f:hlR	Lcom/tencent/mm/media/f/a;
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 1094	com/tencent/mm/media/f/a:release	()V
    //   192: aload_0
    //   193: getfield 864	com/tencent/mm/media/i/f:hlW	Lcom/tencent/mm/media/i/g;
    //   196: astore 4
    //   198: aload 4
    //   200: ifnull +27 -> 227
    //   203: aload 4
    //   205: getfield 1097	com/tencent/mm/media/i/g:hmV	Ld/g/a/b;
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull +15 -> 227
    //   215: aload 4
    //   217: aload_0
    //   218: getfield 396	com/tencent/mm/media/i/f:hmz	Ld/g/a/b;
    //   221: invokeinterface 1101 2 0
    //   226: pop
    //   227: aload_0
    //   228: getfield 1103	com/tencent/mm/media/i/f:hlS	Landroid/os/HandlerThread;
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +9 -> 244
    //   238: aload 4
    //   240: invokevirtual 1108	android/os/HandlerThread:quit	()Z
    //   243: pop
    //   244: aload_0
    //   245: getfield 1110	com/tencent/mm/media/i/f:hlT	Landroid/os/HandlerThread;
    //   248: astore 4
    //   250: aload 4
    //   252: ifnull +9 -> 261
    //   255: aload 4
    //   257: invokevirtual 1108	android/os/HandlerThread:quit	()Z
    //   260: pop
    //   261: aload_0
    //   262: getfield 1112	com/tencent/mm/media/i/f:hlY	J
    //   265: invokestatic 985	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
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
    //   294: getfield 1070	com/tencent/mm/media/i/f:hmd	I
    //   297: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 1118
    //   303: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: getfield 823	com/tencent/mm/media/i/f:hhy	I
    //   310: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 1120
    //   316: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 1068	com/tencent/mm/media/i/f:hme	I
    //   323: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 517	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: getfield 360	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   336: invokestatic 541	com/tencent/mm/plugin/sight/base/e:axx	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   339: astore 4
    //   341: aload 4
    //   343: ifnull +94 -> 437
    //   346: getstatic 495	com/tencent/mm/media/k/d:hoU	Lcom/tencent/mm/media/k/d;
    //   349: astore 5
    //   351: aload_0
    //   352: getfield 358	com/tencent/mm/media/i/f:hhG	I
    //   355: lload_2
    //   356: invokestatic 1124	com/tencent/mm/media/k/d:w	(IJ)V
    //   359: getstatic 495	com/tencent/mm/media/k/d:hoU	Lcom/tencent/mm/media/k/d;
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
    //   385: getfield 1070	com/tencent/mm/media/i/f:hmd	I
    //   388: i2f
    //   389: aload_0
    //   390: getfield 823	com/tencent/mm/media/i/f:hhy	I
    //   393: i2f
    //   394: fdiv
    //   395: f2d
    //   396: ldc2_w 1129
    //   399: dcmpl
    //   400: iflt +37 -> 437
    //   403: getstatic 495	com/tencent/mm/media/k/d:hoU	Lcom/tencent/mm/media/k/d;
    //   406: astore 4
    //   408: invokestatic 1133	com/tencent/mm/media/k/d:avG	()V
    //   411: ldc_w 1074
    //   414: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload_0
    //   418: monitorexit
    //   419: return
    //   420: aload_0
    //   421: iconst_1
    //   422: putfield 1080	com/tencent/mm/media/i/f:hmc	Z
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
        ad.i(this.TAG, "onDecoderEncoderFailed, isDecoder:" + paramBoolean1 + " isEncoder:" + paramBoolean2);
        this.hmj.cancel();
        Object localObject1;
        if (paramBoolean1)
        {
          localObject1 = this.hlx;
          if (localObject1 != null) {
            ((com.tencent.mm.media.d.f)localObject1).releaseDecoder();
          }
          this.hlx = null;
        }
        if (paramBoolean2)
        {
          localObject1 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.avj();
          localObject1 = this.hlL;
          if (localObject1 != null) {
            ((com.tencent.mm.media.e.b)localObject1).att();
          }
          this.hlL = null;
        }
        if (!this.hma)
        {
          localObject1 = this.hlO;
          if (localObject1 != null) {
            ((a)localObject1).release();
          }
          this.hlZ.akO();
          this.hma = true;
          try
          {
            localObject1 = j.hne;
            com.tencent.mm.vfs.i.deleteFile(j.a.yf(this.filePath));
            localObject1 = j.hne;
            com.tencent.mm.vfs.i.deleteFile(j.a.yg(this.filePath));
            this.hix.release();
            localObject1 = this.hlR;
            if (localObject1 != null) {
              ((com.tencent.mm.media.f.a)localObject1).release();
            }
            localObject1 = this.hlS;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.hlT;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            com.tencent.mm.vfs.i.deleteFile(this.outputFilePath);
            long l = bt.aO(this.hlY);
            ad.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.hmz;
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
  
  public final int atP()
  {
    AppMethodBeat.i(93803);
    ad.i(this.TAG, "start remux, initFinish:" + this.hlU);
    this.hlY = bt.HI();
    if ((this.hkZ != null) && (this.hlJ > 0)) {
      this.hkZ = com.tencent.mm.sdk.platformtools.g.a(this.hkZ, -this.hlJ);
    }
    this.hlZ.gFK.reset();
    if (this.hlU)
    {
      HandlerThread localHandlerThread = this.hlS;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      this.hlS = com.tencent.mm.ad.c.a("MediaCodecRemux_audioMix", false, (d.g.a.a)new d(this));
      localHandlerThread = this.hlT;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      if (this.hlx != null) {
        this.hlT = com.tencent.mm.ad.c.a("MediaCodecRemux_videoMix", false, (d.g.a.a)new e(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(93803);
      return 0;
      this.hlV = true;
    }
  }
  
  public com.tencent.mm.media.j.c atQ()
  {
    int i = 1;
    AppMethodBeat.i(164113);
    if ((this.hlJ == 90) || (this.hlJ == 270)) {
      if (this.hlI > this.hlH) {
        ad.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
    }
    while (this.hms)
    {
      localc = new com.tencent.mm.media.j.c(this.hlH, this.hlI, this.outputWidth, this.outputHeight, 3, i);
      AppMethodBeat.o(164113);
      return localc;
      ad.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
      i = 2;
      continue;
      if (this.hlH > this.hlI)
      {
        ad.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
      else
      {
        ad.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
        i = 2;
      }
    }
    com.tencent.mm.media.j.c localc = new com.tencent.mm.media.j.c(this.hlH, this.hlI, this.outputWidth, this.outputHeight, i);
    AppMethodBeat.o(164113);
    return localc;
  }
  
  public final void k(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93802);
    p.h(paramb, "blendBitmapProvider");
    this.hkY = paramb;
    a locala = this.hlO;
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
    this.hlX = paramb;
    a locala = this.hlO;
    if (locala != null)
    {
      locala.j(paramb);
      AppMethodBeat.o(93804);
      return;
    }
    AppMethodBeat.o(93804);
  }
  
  public final void y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93801);
    p.h(paramBitmap, "bitmap");
    this.hkZ = paramBitmap;
    a locala = this.hlO;
    if (locala != null)
    {
      String str = locala.TAG;
      StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmap:");
      if (paramBitmap != null) {}
      for (int i = paramBitmap.hashCode();; i = 0)
      {
        ad.i(str, i);
        locala.hkZ = paramBitmap;
        AppMethodBeat.o(93801);
        return;
      }
    }
    AppMethodBeat.o(93801);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93779);
      ad.i(f.a(this.hmD), "delay check frameDraw: " + f.m(this.hmD));
      if (!f.m(this.hmD))
      {
        ad.e(f.a(this.hmD), "after " + f.atS() + " ms, first frame stil not draw!!!");
        com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avR();
      }
      AppMethodBeat.o(93779);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93780);
      ad.i(f.a(this.hmD), "decode end after " + f.atT() + ", isFinishEncode:" + f.H(this.hmD));
      if (!f.H(this.hmD))
      {
        com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avU();
        f.I(this.hmD);
      }
      AppMethodBeat.o(93780);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    f(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    g(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<Boolean, z>
  {
    h(f paramf, com.tencent.mm.media.j.c paramc, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.b<Boolean, z>
  {
    i(f paramf)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, z>
    {
      a(f.i parami)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      b(f.i parami)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends d.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, z>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, z>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    m(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "plugin-mediaeditor_release"})
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
      ad.e(f.a(this.hmD), "remux error! handing one frame time out ,isInvokeEndCallback:" + f.G(this.hmD));
      f localf;
      if (!f.G(this.hmD))
      {
        localf = this.hmD;
        if (f.c(this.hmD)) {
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