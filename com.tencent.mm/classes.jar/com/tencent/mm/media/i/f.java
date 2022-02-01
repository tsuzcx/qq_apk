package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "videoWidth", "videoHeight", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "blurBgProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getFinishCallback", "()Lkotlin/jvm/functions/Function1;", "setFinishCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstFrameDraw", "getForceLandscape", "setForceLandscape", "frameHandingTime", "frameTimeoutMs", "getIFrame", "()I", "setIFrame", "(I)V", "initFinish", "inputHeight", "getInputHeight", "setInputHeight", "inputWidth", "getInputWidth", "setInputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "lastFrameDts", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "setMixType", "musicExtractorWrapper", "getOutputAudioBitrate", "setOutputAudioBitrate", "getOutputAudioChannelCount", "setOutputAudioChannelCount", "getOutputAudioSampleRate", "setOutputAudioSampleRate", "getOutputBitrate", "setOutputBitrate", "getOutputFilePath", "getOutputFps", "setOutputFps", "getOutputHeight", "setOutputHeight", "getOutputWidth", "setOutputWidth", "getProgressListener", "setProgressListener", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "timeoutInvoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1;", "useRequestDraw", "getUseSoftEncode", "setUseSoftEncode", "vfrThreshold", "videoDuration", "videoFps", "getVideoHeight", "getVideoMinQP", "setVideoMinQP", "videoMixHandlerThread", "videoRotate", "getVideoWidth", "writeDtsCount", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder;", "checkFinishEncode", "checkFrameDrawTimeout", "checkVideoHasBFrame", "afterCheck", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "onDecoderEncoderFailed", "isDecoder", "isEncoder", "remux", "remuxImpl", "renderer", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "startRemux", "Companion", "plugin-mediaeditor_release"})
public class f
  extends d
  implements c
{
  private static final long iiK = 1000L;
  private static final long iiL = 1000L;
  public static final f.a iiM;
  private final String TAG;
  private String filePath;
  private final int idY;
  private volatile boolean idb;
  private int idi;
  private int idq;
  private com.tencent.mm.media.f.a iei;
  private volatile boolean ifd;
  private com.tencent.mm.media.d.f ihG;
  protected int ihQ;
  protected int ihR;
  private int ihS;
  private com.tencent.mm.media.e.b ihT;
  private h ihU;
  private com.tencent.mm.media.a.a ihV;
  private a ihW;
  private i ihX;
  private com.tencent.mm.media.f.a ihY;
  private com.tencent.mm.media.f.a ihZ;
  private kotlin.g.a.b<? super Long, Bitmap> ihf;
  private Bitmap ihg;
  private long iho;
  private int iiA;
  int iiB;
  protected boolean iiC;
  boolean iiD;
  private int iiE;
  private int iiF;
  private boolean iiG;
  private int iiH;
  kotlin.g.a.b<? super Float, x> iiI;
  private kotlin.g.a.b<? super String, x> iiJ;
  private HandlerThread iia;
  private HandlerThread iib;
  private boolean iic;
  private boolean iid;
  private g iie;
  private kotlin.g.a.b<? super Long, Bitmap> iif;
  private long iig;
  private final com.tencent.mm.media.k.a iih;
  private volatile boolean iii;
  private boolean iij;
  private boolean iik;
  private int iil;
  private int iim;
  private long iin;
  private int iio;
  private final int iip;
  private volatile boolean iiq;
  private volatile boolean iir;
  private long iis;
  private final n iit;
  private final Runnable iiu;
  private final String iiv;
  protected Rect iiw;
  private int iix;
  private int iiy;
  private int iiz;
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
    iiM = new f.a((byte)0);
    iiK = 1000L;
    iiL = 1000L;
    AppMethodBeat.o(93809);
  }
  
  public f(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt11, int paramInt12, boolean paramBoolean3, int paramInt13, kotlin.g.a.b<? super Float, x> paramb, kotlin.g.a.b<? super String, x> paramb1)
  {
    AppMethodBeat.i(218755);
    this.iiv = paramString1;
    this.filePath = paramString2;
    this.idq = paramInt1;
    this.outputFilePath = paramString3;
    this.iiw = paramRect;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    this.outputWidth = paramInt4;
    this.outputHeight = paramInt5;
    this.iix = paramInt6;
    this.iiy = paramInt7;
    this.iiz = paramInt8;
    this.iiA = paramInt9;
    this.iiB = paramInt10;
    this.iiC = paramBoolean1;
    this.iiD = paramBoolean2;
    this.iiE = paramInt11;
    this.iiF = paramInt12;
    this.iiG = paramBoolean3;
    this.iiH = paramInt13;
    this.iiI = paramb;
    this.iiJ = paramb1;
    this.TAG = "MicroMsg.MediaCodecRemuxer";
    this.videoDuration = -1;
    this.iho = paramLong1;
    this.remuxEndTime = -1L;
    this.iih = new com.tencent.mm.media.k.a("remuxCost");
    this.idY = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYC, 10);
    this.iip = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rYD, 10000);
    this.iis = -9223372036854775808L;
    this.iit = new n(this);
    if ((Util.isNullOrNil(this.filePath)) || (!s.YS(this.filePath)) || (Util.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
    {
      Log.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.iiB);
      paramString1 = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aOv();
      paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
      AppMethodBeat.o(218755);
      throw paramString1;
    }
    paramString1 = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.rn(this.idq);
    if (com.tencent.mm.bk.e.QW(this.filePath))
    {
      Log.i(this.TAG, "remux h265 format");
      paramString1 = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aOu();
    }
    s.boN(s.boZ(this.outputFilePath));
    this.ihS = SightVideoJNI.getMp4RotateVFS(this.filePath);
    if ((this.iiG) && ((this.ihS == 90) || (this.ihS == 270)))
    {
      paramInt1 = this.outputWidth;
      this.outputWidth = this.outputHeight;
      this.outputHeight = paramInt1;
    }
    paramString2 = com.tencent.mm.plugin.sight.base.e.aNx(this.filePath);
    if (paramString2 != null)
    {
      this.ihQ = paramString2.width;
      this.ihR = paramString2.height;
      this.videoFps = paramString2.frameRate;
      this.videoDuration = paramString2.videoDuration;
    }
    if ((this.ihQ <= 0) || (this.ihR <= 0)) {}
    try
    {
      paramString1 = new com.tencent.mm.compatible.i.d();
      paramString1.setDataSource(this.filePath);
      this.ihQ = Util.getInt(paramString1.extractMetadata(18), 0);
      this.ihR = Util.getInt(paramString1.extractMetadata(19), 0);
      paramString1.release();
      label634:
      if (this.videoFps <= 0)
      {
        Log.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
        paramString1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOv();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(218755);
        throw paramString1;
      }
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        Log.i(this.TAG, "MediaCodecRemuxer frameTimeoutMs is:" + this.iip);
        if (!this.iiC) {
          break label1280;
        }
        paramString1 = new i(this.iho, this.remuxEndTime, this.iix, this.outputWidth, this.outputHeight, this.iiC, this.iiB, this.iiD);
        label794:
        this.ihX = paramString1;
        if (this.iiA <= 0) {
          this.iiA = 1;
        }
        Log.printInfoStack(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.ihQ + ", inputHeight: " + this.ihR + ", videoRotate: " + this.ihS + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.iix + ", outputAudioBitrate:" + this.iiy + ", outputAudioChannelCount:" + this.iiA + ", outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.iiB + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.iho + " ,remuxEndTime: " + this.remuxEndTime + " , input bitrate:" + paramString2.videoBitrate + ", enableHevc:" + this.iiD, new Object[0]);
        this.iei = new com.tencent.mm.media.f.a(this.filePath);
        if (this.iei.igl)
        {
          paramString1 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aOw();
        }
        paramInt1 = this.outputWidth - this.ihQ;
        if ((1 <= paramInt1) && (16 > paramInt1)) {
          break label1313;
        }
        paramInt1 = this.outputHeight - this.ihR;
        if (1 <= paramInt1) {
          break label1307;
        }
        label1145:
        paramBoolean1 = false;
        label1148:
        Log.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(paramBoolean1)));
        Log.i(this.TAG, "startRemux, useSoftEncode:" + this.iiC + ", enablHevc:" + this.iiD);
        if (this.iiD)
        {
          if (!this.iiC) {
            break label1319;
          }
          paramString1 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aOY();
        }
      }
      for (;;)
      {
        if (this.iiC)
        {
          paramString1 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aOX();
        }
        a(aMH());
        this.iiu = ((Runnable)new c(this));
        AppMethodBeat.o(218755);
        return;
        this.remuxEndTime = paramLong2;
        break;
        label1280:
        paramString1 = new i(this.iho, this.remuxEndTime, this.iix, this.iiC);
        break label794;
        label1307:
        if (16 <= paramInt1) {
          break label1145;
        }
        label1313:
        paramBoolean1 = true;
        break label1148;
        label1319:
        paramString1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOZ();
      }
    }
    catch (Exception paramString1)
    {
      break label634;
    }
  }
  
  /* Error */
  private final void a(final com.tencent.mm.media.j.c paramc)
  {
    // Byte code:
    //   0: ldc_w 853
    //   3: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 360	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   10: astore 9
    //   12: getstatic 859	com/tencent/mm/media/i/j:ijn	Lcom/tencent/mm/media/i/j$a;
    //   15: astore 10
    //   17: aload 9
    //   19: invokestatic 864	com/tencent/mm/media/i/j$a:Hp	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: ifnonnull +717 -> 743
    //   29: aload_0
    //   30: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   33: ldc_w 866
    //   36: invokestatic 497	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 859	com/tencent/mm/media/i/j:ijn	Lcom/tencent/mm/media/i/j$a;
    //   42: astore 9
    //   44: aload_0
    //   45: new 651	com/tencent/mm/media/f/a
    //   48: dup
    //   49: aload_0
    //   50: getfield 360	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   53: invokestatic 864	com/tencent/mm/media/i/j$a:Hp	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 652	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   59: putfield 729	com/tencent/mm/media/i/f:ihZ	Lcom/tencent/mm/media/f/a;
    //   62: aload_0
    //   63: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   66: astore 9
    //   68: new 466	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 868
    //   75: invokespecial 469	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: astore 10
    //   80: getstatic 859	com/tencent/mm/media/i/j:ijn	Lcom/tencent/mm/media/i/j$a;
    //   83: astore 11
    //   85: aload 10
    //   87: aload_0
    //   88: getfield 360	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   91: invokestatic 864	com/tencent/mm/media/i/j$a:Hp	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 870
    //   100: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: astore 10
    //   105: getstatic 859	com/tencent/mm/media/i/j:ijn	Lcom/tencent/mm/media/i/j$a;
    //   108: astore 11
    //   110: aload 9
    //   112: aload 10
    //   114: aload_0
    //   115: getfield 360	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   118: invokestatic 873	com/tencent/mm/media/i/j$a:Ho	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 729	com/tencent/mm/media/i/f:ihZ	Lcom/tencent/mm/media/f/a;
    //   134: astore 9
    //   136: aload 9
    //   138: ifnull +89 -> 227
    //   141: aload_0
    //   142: new 875	com/tencent/mm/media/i/g
    //   145: dup
    //   146: aload_0
    //   147: getfield 593	com/tencent/mm/media/i/f:ihX	Lcom/tencent/mm/media/i/i;
    //   150: aload 9
    //   152: aload_0
    //   153: getfield 364	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 362	com/tencent/mm/media/i/f:idq	I
    //   160: aload_0
    //   161: getfield 380	com/tencent/mm/media/i/f:iiz	I
    //   164: invokespecial 878	com/tencent/mm/media/i/g:<init>	(Lcom/tencent/mm/media/i/i;Lcom/tencent/mm/media/f/a;Ljava/lang/String;II)V
    //   167: putfield 880	com/tencent/mm/media/i/f:iie	Lcom/tencent/mm/media/i/g;
    //   170: aload_0
    //   171: getfield 358	com/tencent/mm/media/i/f:iiv	Ljava/lang/String;
    //   174: invokestatic 464	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   177: ifeq +50 -> 227
    //   180: aload_0
    //   181: getfield 358	com/tencent/mm/media/i/f:iiv	Ljava/lang/String;
    //   184: astore 9
    //   186: aload 9
    //   188: ifnonnull +6 -> 194
    //   191: invokestatic 782	kotlin/g/b/p:hyc	()V
    //   194: new 651	com/tencent/mm/media/f/a
    //   197: dup
    //   198: aload 9
    //   200: invokespecial 652	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   203: astore 9
    //   205: aload 9
    //   207: getfield 657	com/tencent/mm/media/f/a:igl	Z
    //   210: ifeq +11 -> 221
    //   213: getstatic 503	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
    //   216: astore 10
    //   218: invokestatic 883	com/tencent/mm/media/k/e:aOy	()V
    //   221: aload_0
    //   222: aload 9
    //   224: putfield 723	com/tencent/mm/media/i/f:ihY	Lcom/tencent/mm/media/f/a;
    //   227: aload_0
    //   228: getfield 880	com/tencent/mm/media/i/f:iie	Lcom/tencent/mm/media/i/g;
    //   231: astore 9
    //   233: aload 9
    //   235: ifnull +12 -> 247
    //   238: aload 9
    //   240: aload_0
    //   241: getfield 543	com/tencent/mm/media/i/f:ihS	I
    //   244: putfield 884	com/tencent/mm/media/i/g:ihS	I
    //   247: aload_0
    //   248: invokespecial 888	com/tencent/mm/media/i/f:aMI	()Lcom/tencent/mm/media/b/d;
    //   251: astore 9
    //   253: new 42	com/tencent/mm/media/i/f$j
    //   256: dup
    //   257: aload_0
    //   258: invokespecial 889	com/tencent/mm/media/i/f$j:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   261: checkcast 891	kotlin/g/a/m
    //   264: astore 10
    //   266: new 44	com/tencent/mm/media/i/f$k
    //   269: dup
    //   270: aload_0
    //   271: invokespecial 892	com/tencent/mm/media/i/f$k:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   274: checkcast 804	kotlin/g/a/a
    //   277: astore 11
    //   279: aload_0
    //   280: getfield 386	com/tencent/mm/media/i/f:iiC	Z
    //   283: ifeq +558 -> 841
    //   286: aload_0
    //   287: new 894	com/tencent/mm/media/e/h
    //   290: dup
    //   291: aload_0
    //   292: getfield 593	com/tencent/mm/media/i/f:ihX	Lcom/tencent/mm/media/i/i;
    //   295: getfield 764	com/tencent/mm/media/i/i:bufId	I
    //   298: aload 9
    //   300: getfield 899	com/tencent/mm/media/b/d:targetWidth	I
    //   303: aload 9
    //   305: getfield 902	com/tencent/mm/media/b/d:targetHeight	I
    //   308: invokespecial 905	com/tencent/mm/media/e/h:<init>	(III)V
    //   311: putfield 907	com/tencent/mm/media/i/f:ihU	Lcom/tencent/mm/media/e/h;
    //   314: aload_0
    //   315: new 909	com/tencent/mm/media/i/a
    //   318: dup
    //   319: aload_1
    //   320: checkcast 911	com/tencent/mm/media/j/a
    //   323: invokespecial 914	com/tencent/mm/media/i/a:<init>	(Lcom/tencent/mm/media/j/a;)V
    //   326: putfield 916	com/tencent/mm/media/i/f:ihW	Lcom/tencent/mm/media/i/a;
    //   329: aload_0
    //   330: getfield 916	com/tencent/mm/media/i/f:ihW	Lcom/tencent/mm/media/i/a;
    //   333: astore 9
    //   335: aload 9
    //   337: ifnull +45 -> 382
    //   340: aload 9
    //   342: ldc_w 917
    //   345: aload_0
    //   346: getfield 486	com/tencent/mm/media/i/f:videoFps	I
    //   349: idiv
    //   350: putfield 920	com/tencent/mm/media/i/a:ihm	I
    //   353: aload 9
    //   355: getfield 921	com/tencent/mm/media/i/a:TAG	Ljava/lang/String;
    //   358: new 466	java/lang/StringBuilder
    //   361: dup
    //   362: ldc_w 923
    //   365: invokespecial 469	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: aload 9
    //   370: getfield 920	com/tencent/mm/media/i/a:ihm	I
    //   373: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload_0
    //   383: getfield 925	com/tencent/mm/media/i/f:ihf	Lkotlin/g/a/b;
    //   386: ifnull +23 -> 409
    //   389: aload_0
    //   390: getfield 916	com/tencent/mm/media/i/f:ihW	Lcom/tencent/mm/media/i/a;
    //   393: astore 9
    //   395: aload 9
    //   397: ifnull +12 -> 409
    //   400: aload 9
    //   402: aload_0
    //   403: getfield 925	com/tencent/mm/media/i/f:ihf	Lkotlin/g/a/b;
    //   406: invokevirtual 928	com/tencent/mm/media/i/a:i	(Lkotlin/g/a/b;)V
    //   409: aload_0
    //   410: getfield 705	com/tencent/mm/media/i/f:iif	Lkotlin/g/a/b;
    //   413: ifnull +23 -> 436
    //   416: aload_0
    //   417: getfield 916	com/tencent/mm/media/i/f:ihW	Lcom/tencent/mm/media/i/a;
    //   420: astore 9
    //   422: aload 9
    //   424: ifnull +12 -> 436
    //   427: aload 9
    //   429: aload_0
    //   430: getfield 705	com/tencent/mm/media/i/f:iif	Lkotlin/g/a/b;
    //   433: invokevirtual 931	com/tencent/mm/media/i/a:j	(Lkotlin/g/a/b;)V
    //   436: aload_0
    //   437: getfield 916	com/tencent/mm/media/i/f:ihW	Lcom/tencent/mm/media/i/a;
    //   440: astore 9
    //   442: aload 9
    //   444: ifnull +19 -> 463
    //   447: aload 9
    //   449: new 22	com/tencent/mm/media/i/f$h
    //   452: dup
    //   453: aload_0
    //   454: invokespecial 932	com/tencent/mm/media/i/f$h:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   457: checkcast 934	kotlin/g/a/b
    //   460: putfield 937	com/tencent/mm/media/i/a:ihb	Lkotlin/g/a/b;
    //   463: ldc_w 421
    //   466: invokestatic 427	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   469: checkcast 421	com/tencent/mm/plugin/expt/b/b
    //   472: getstatic 940	com/tencent/mm/plugin/expt/b/b$a:rYz	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   475: iconst_0
    //   476: invokeinterface 437 3 0
    //   481: ifne +512 -> 993
    //   484: iconst_1
    //   485: istore 4
    //   487: aload_0
    //   488: iload 4
    //   490: putfield 942	com/tencent/mm/media/i/f:iir	Z
    //   493: invokestatic 947	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   496: ifeq +18 -> 514
    //   499: aload_0
    //   500: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   503: ldc_w 949
    //   506: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload_0
    //   510: iconst_0
    //   511: putfield 942	com/tencent/mm/media/i/f:iir	Z
    //   514: iconst_3
    //   515: newarray double
    //   517: astore 9
    //   519: aload 9
    //   521: dup
    //   522: iconst_0
    //   523: dconst_0
    //   524: dastore
    //   525: dup
    //   526: iconst_1
    //   527: dconst_0
    //   528: dastore
    //   529: dup
    //   530: iconst_2
    //   531: dconst_0
    //   532: dastore
    //   533: pop
    //   534: aload_0
    //   535: getfield 360	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   538: aload 9
    //   540: aload_0
    //   541: getfield 439	com/tencent/mm/media/i/f:idY	I
    //   544: invokestatic 954	com/tencent/mm/media/k/b:a	(Ljava/lang/String;[DI)Ljava/util/List;
    //   547: pop
    //   548: iconst_0
    //   549: istore_2
    //   550: goto +495 -> 1045
    //   553: iload_2
    //   554: ifeq +85 -> 639
    //   557: aload 9
    //   559: iconst_1
    //   560: daload
    //   561: aload 9
    //   563: iconst_0
    //   564: daload
    //   565: dsub
    //   566: aload_0
    //   567: getfield 439	com/tencent/mm/media/i/f:idY	I
    //   570: i2d
    //   571: dcmpl
    //   572: iflt +67 -> 639
    //   575: aload_0
    //   576: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   579: new 466	java/lang/StringBuilder
    //   582: dup
    //   583: ldc_w 956
    //   586: invokespecial 469	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   589: aload 9
    //   591: iconst_0
    //   592: daload
    //   593: invokevirtual 959	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   596: ldc_w 961
    //   599: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 9
    //   604: iconst_1
    //   605: daload
    //   606: invokevirtual 959	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   609: ldc_w 963
    //   612: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_0
    //   616: getfield 439	com/tencent/mm/media/i/f:idY	I
    //   619: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: ldc_w 965
    //   625: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload_0
    //   635: iconst_1
    //   636: putfield 942	com/tencent/mm/media/i/f:iir	Z
    //   639: aload_0
    //   640: getfield 967	com/tencent/mm/media/i/f:ihT	Lcom/tencent/mm/media/e/b;
    //   643: ifnull +373 -> 1016
    //   646: aload_0
    //   647: getfield 967	com/tencent/mm/media/i/f:ihT	Lcom/tencent/mm/media/e/b;
    //   650: astore 9
    //   652: aload 9
    //   654: ifnull +362 -> 1016
    //   657: aload 9
    //   659: invokevirtual 973	com/tencent/mm/media/e/b:getInputSurface	()Landroid/view/Surface;
    //   662: astore 9
    //   664: aload_0
    //   665: getfield 916	com/tencent/mm/media/i/f:ihW	Lcom/tencent/mm/media/i/a;
    //   668: astore 10
    //   670: aload 10
    //   672: ifnull +366 -> 1038
    //   675: aload_0
    //   676: getfield 942	com/tencent/mm/media/i/f:iir	Z
    //   679: ifne +343 -> 1022
    //   682: iconst_1
    //   683: istore 4
    //   685: aload_0
    //   686: getfield 386	com/tencent/mm/media/i/f:iiC	Z
    //   689: ifeq +339 -> 1028
    //   692: aload_0
    //   693: getfield 372	com/tencent/mm/media/i/f:outputWidth	I
    //   696: istore_2
    //   697: aload_0
    //   698: getfield 386	com/tencent/mm/media/i/f:iiC	Z
    //   701: ifeq +332 -> 1033
    //   704: aload_0
    //   705: getfield 374	com/tencent/mm/media/i/f:outputHeight	I
    //   708: istore_3
    //   709: aload 10
    //   711: aload 9
    //   713: iload 4
    //   715: iload_2
    //   716: iload_3
    //   717: aload_0
    //   718: getfield 408	com/tencent/mm/media/i/f:iho	J
    //   721: new 24	com/tencent/mm/media/i/f$i
    //   724: dup
    //   725: aload_0
    //   726: aload_1
    //   727: invokespecial 976	com/tencent/mm/media/i/f$i:<init>	(Lcom/tencent/mm/media/i/f;Lcom/tencent/mm/media/j/c;)V
    //   730: checkcast 934	kotlin/g/a/b
    //   733: invokevirtual 979	com/tencent/mm/media/i/a:a	(Landroid/view/Surface;ZIIJLkotlin/g/a/b;)V
    //   736: ldc_w 853
    //   739: invokestatic 329	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   742: return
    //   743: aload 10
    //   745: invokestatic 464	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   748: ifeq +9 -> 757
    //   751: aload 10
    //   753: invokestatic 982	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   756: pop
    //   757: aload_0
    //   758: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   761: ldc_w 984
    //   764: iconst_2
    //   765: anewarray 645	java/lang/Object
    //   768: dup
    //   769: iconst_0
    //   770: aload 9
    //   772: aastore
    //   773: dup
    //   774: iconst_1
    //   775: aload 10
    //   777: aastore
    //   778: invokestatic 986	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   781: invokestatic 759	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   784: lstore 5
    //   786: aload 9
    //   788: aload 10
    //   790: invokestatic 990	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   793: lstore 7
    //   795: aload_0
    //   796: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   799: new 466	java/lang/StringBuilder
    //   802: dup
    //   803: ldc_w 992
    //   806: invokespecial 469	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   809: lload 5
    //   811: invokestatic 996	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   814: invokevirtual 623	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   817: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   823: lload 7
    //   825: lconst_0
    //   826: lcmp
    //   827: ifgt -788 -> 39
    //   830: getstatic 503	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
    //   833: astore 9
    //   835: invokestatic 999	com/tencent/mm/media/k/e:aOx	()V
    //   838: goto -799 -> 39
    //   841: bipush 23
    //   843: invokestatic 1005	com/tencent/mm/compatible/util/d:oD	(I)Z
    //   846: ifeq +116 -> 962
    //   849: new 1007	com/tencent/mm/media/e/f
    //   852: dup
    //   853: aload 9
    //   855: new 18	com/tencent/mm/media/i/f$f
    //   858: dup
    //   859: aload 10
    //   861: aload 11
    //   863: invokespecial 1010	com/tencent/mm/media/i/f$f:<init>	(Lkotlin/g/a/m;Lkotlin/g/a/a;)V
    //   866: checkcast 934	kotlin/g/a/b
    //   869: invokespecial 1013	com/tencent/mm/media/e/f:<init>	(Lcom/tencent/mm/media/b/d;Lkotlin/g/a/b;)V
    //   872: checkcast 969	com/tencent/mm/media/e/b
    //   875: astore 9
    //   877: aload_0
    //   878: aload 9
    //   880: putfield 967	com/tencent/mm/media/i/f:ihT	Lcom/tencent/mm/media/e/b;
    //   883: goto -569 -> 314
    //   886: astore_1
    //   887: aload_0
    //   888: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   891: aload_1
    //   892: checkcast 513	java/lang/Throwable
    //   895: ldc_w 1015
    //   898: iconst_0
    //   899: anewarray 645	java/lang/Object
    //   902: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   905: getstatic 503	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
    //   908: astore_1
    //   909: invokestatic 1018	com/tencent/mm/media/k/e:aOz	()V
    //   912: invokestatic 1024	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   915: ldc_w 1026
    //   918: iconst_1
    //   919: invokevirtual 1030	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putBoolean	(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   922: pop
    //   923: aload_0
    //   924: iconst_0
    //   925: iconst_1
    //   926: invokespecial 852	com/tencent/mm/media/i/f:l	(ZZ)V
    //   929: ldc_w 853
    //   932: invokestatic 329	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   935: return
    //   936: astore_1
    //   937: aload_0
    //   938: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   941: aload_1
    //   942: checkcast 513	java/lang/Throwable
    //   945: ldc_w 1032
    //   948: iconst_0
    //   949: anewarray 645	java/lang/Object
    //   952: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   955: ldc_w 853
    //   958: invokestatic 329	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   961: return
    //   962: new 1034	com/tencent/mm/media/e/e
    //   965: dup
    //   966: aload 9
    //   968: new 20	com/tencent/mm/media/i/f$g
    //   971: dup
    //   972: aload 10
    //   974: aload 11
    //   976: invokespecial 1035	com/tencent/mm/media/i/f$g:<init>	(Lkotlin/g/a/m;Lkotlin/g/a/a;)V
    //   979: checkcast 934	kotlin/g/a/b
    //   982: invokespecial 1036	com/tencent/mm/media/e/e:<init>	(Lcom/tencent/mm/media/b/d;Lkotlin/g/a/b;)V
    //   985: checkcast 969	com/tencent/mm/media/e/b
    //   988: astore 9
    //   990: goto -113 -> 877
    //   993: iconst_0
    //   994: istore 4
    //   996: goto -509 -> 487
    //   999: iconst_0
    //   1000: istore_3
    //   1001: goto +60 -> 1061
    //   1004: iload_2
    //   1005: iconst_1
    //   1006: iadd
    //   1007: istore_2
    //   1008: goto +37 -> 1045
    //   1011: iconst_1
    //   1012: istore_2
    //   1013: goto -460 -> 553
    //   1016: aconst_null
    //   1017: astore 9
    //   1019: goto -355 -> 664
    //   1022: iconst_0
    //   1023: istore 4
    //   1025: goto -340 -> 685
    //   1028: iconst_0
    //   1029: istore_2
    //   1030: goto -333 -> 697
    //   1033: iconst_0
    //   1034: istore_3
    //   1035: goto -326 -> 709
    //   1038: ldc_w 853
    //   1041: invokestatic 329	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1044: return
    //   1045: iload_2
    //   1046: iconst_3
    //   1047: if_icmpge -36 -> 1011
    //   1050: aload 9
    //   1052: iload_2
    //   1053: daload
    //   1054: dconst_0
    //   1055: dcmpl
    //   1056: ifle -57 -> 999
    //   1059: iconst_1
    //   1060: istore_3
    //   1061: iload_3
    //   1062: ifne -58 -> 1004
    //   1065: iconst_0
    //   1066: istore_2
    //   1067: goto -514 -> 553
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1070	0	this	f
    //   0	1070	1	paramc	com.tencent.mm.media.j.c
    //   549	518	2	i	int
    //   708	354	3	j	int
    //   485	539	4	bool	boolean
    //   784	26	5	l1	long
    //   793	31	7	l2	long
    //   10	1041	9	localObject1	Object
    //   15	958	10	localObject2	Object
    //   83	892	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   279	314	886	java/lang/Exception
    //   841	877	886	java/lang/Exception
    //   877	883	886	java/lang/Exception
    //   962	990	886	java/lang/Exception
    //   247	279	936	java/lang/Exception
    //   314	335	936	java/lang/Exception
    //   340	382	936	java/lang/Exception
    //   382	395	936	java/lang/Exception
    //   400	409	936	java/lang/Exception
    //   409	422	936	java/lang/Exception
    //   427	436	936	java/lang/Exception
    //   436	442	936	java/lang/Exception
    //   447	463	936	java/lang/Exception
    //   463	484	936	java/lang/Exception
    //   487	514	936	java/lang/Exception
    //   514	548	936	java/lang/Exception
    //   557	639	936	java/lang/Exception
    //   639	652	936	java/lang/Exception
    //   657	664	936	java/lang/Exception
    //   664	670	936	java/lang/Exception
    //   675	682	936	java/lang/Exception
    //   685	697	936	java/lang/Exception
    //   697	709	936	java/lang/Exception
    //   709	742	936	java/lang/Exception
    //   887	935	936	java/lang/Exception
  }
  
  private final com.tencent.mm.media.b.d aMI()
  {
    AppMethodBeat.i(93800);
    if (this.iiB > 0) {}
    com.tencent.mm.media.b.d locald;
    for (int i = Math.min(this.iiB, this.videoFps);; i = this.videoFps)
    {
      locald = new com.tencent.mm.media.b.d(this.iiD);
      locald.bitrate = this.iix;
      locald.frameRate = i;
      locald.targetHeight = this.outputHeight;
      locald.targetWidth = this.outputWidth;
      locald.idF = this.iiE;
      locald.idG = this.iiF;
      if (this.iiH > 0) {
        locald.idB = this.iiH;
      }
      while (locald.frameRate * locald.idB - 1 <= 1)
      {
        locald.frameRate += 1;
        Log.e(this.TAG, "encodeConfig.frameRate + 1");
      }
    }
    Log.i(this.TAG, "steve: hardcoder qp:" + this.iiE + ", " + this.iiF);
    AppMethodBeat.o(93800);
    return locald;
  }
  
  private final void aMi()
  {
    AppMethodBeat.i(93805);
    Log.i(this.TAG, "finishEncode");
    Object localObject;
    if (this.iiC)
    {
      localObject = this.ihU;
      if (localObject != null) {
        ((h)localObject).stop();
      }
      eX(true);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.iiu);
      this.ifd = true;
      AppMethodBeat.o(93805);
      return;
      localObject = this.ihT;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).aMi();
      }
    }
  }
  
  /* Error */
  private final void eX(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1086
    //   5: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   12: new 466	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1088
    //   19: invokespecial 469	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: iload_1
    //   23: invokevirtual 643	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 1090
    //   29: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 1092	com/tencent/mm/media/i/f:iik	Z
    //   36: invokevirtual 643	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 1094
    //   42: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 1096	com/tencent/mm/media/i/f:iij	Z
    //   49: invokevirtual 643	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1098
    //   55: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 827	com/tencent/mm/media/i/f:iii	Z
    //   62: invokevirtual 643	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload_1
    //   72: ifeq +373 -> 445
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 1096	com/tencent/mm/media/i/f:iij	Z
    //   80: aload_0
    //   81: getfield 1092	com/tencent/mm/media/i/f:iik	Z
    //   84: ifeq +378 -> 462
    //   87: aload_0
    //   88: getfield 1096	com/tencent/mm/media/i/f:iij	Z
    //   91: ifeq +371 -> 462
    //   94: aload_0
    //   95: getfield 827	com/tencent/mm/media/i/f:iii	Z
    //   98: ifne +364 -> 462
    //   101: aload_0
    //   102: getfield 916	com/tencent/mm/media/i/f:ihW	Lcom/tencent/mm/media/i/a;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 1099	com/tencent/mm/media/i/a:release	()V
    //   117: aload_0
    //   118: getfield 419	com/tencent/mm/media/i/f:iih	Lcom/tencent/mm/media/k/a;
    //   121: invokevirtual 1102	com/tencent/mm/media/k/a:aBw	()V
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 827	com/tencent/mm/media/i/f:iii	Z
    //   129: getstatic 859	com/tencent/mm/media/i/j:ijn	Lcom/tencent/mm/media/i/j$a;
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 360	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   138: invokestatic 873	com/tencent/mm/media/i/j$a:Ho	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 982	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   144: pop
    //   145: getstatic 859	com/tencent/mm/media/i/j:ijn	Lcom/tencent/mm/media/i/j$a;
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 360	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   154: invokestatic 864	com/tencent/mm/media/i/j$a:Hp	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 982	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 453	com/tencent/mm/media/i/f:iit	Lcom/tencent/mm/media/i/f$n;
    //   165: invokevirtual 1105	com/tencent/mm/media/i/f$n:cancel	()Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 654	com/tencent/mm/media/i/f:iei	Lcom/tencent/mm/media/f/a;
    //   173: invokevirtual 1106	com/tencent/mm/media/f/a:release	()V
    //   176: aload_0
    //   177: getfield 729	com/tencent/mm/media/i/f:ihZ	Lcom/tencent/mm/media/f/a;
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 1106	com/tencent/mm/media/f/a:release	()V
    //   192: aload_0
    //   193: getfield 880	com/tencent/mm/media/i/f:iie	Lcom/tencent/mm/media/i/g;
    //   196: astore 4
    //   198: aload 4
    //   200: ifnull +27 -> 227
    //   203: aload 4
    //   205: getfield 1109	com/tencent/mm/media/i/g:ije	Lkotlin/g/a/b;
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull +15 -> 227
    //   215: aload 4
    //   217: aload_0
    //   218: getfield 400	com/tencent/mm/media/i/f:iiJ	Lkotlin/g/a/b;
    //   221: invokeinterface 1113 2 0
    //   226: pop
    //   227: aload_0
    //   228: getfield 1115	com/tencent/mm/media/i/f:iia	Landroid/os/HandlerThread;
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +9 -> 244
    //   238: aload 4
    //   240: invokevirtual 1120	android/os/HandlerThread:quit	()Z
    //   243: pop
    //   244: aload_0
    //   245: getfield 1122	com/tencent/mm/media/i/f:iib	Landroid/os/HandlerThread;
    //   248: astore 4
    //   250: aload 4
    //   252: ifnull +9 -> 261
    //   255: aload 4
    //   257: invokevirtual 1120	android/os/HandlerThread:quit	()Z
    //   260: pop
    //   261: aload_0
    //   262: getfield 1124	com/tencent/mm/media/i/f:iig	J
    //   265: invokestatic 996	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   268: lstore_2
    //   269: aload_0
    //   270: getfield 404	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   273: new 466	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1126
    //   280: invokespecial 469	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: lload_2
    //   284: invokevirtual 623	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: ldc_w 1128
    //   290: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 1080	com/tencent/mm/media/i/f:iil	I
    //   297: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 1130
    //   303: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: getfield 839	com/tencent/mm/media/i/f:idi	I
    //   310: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 1132
    //   316: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 1078	com/tencent/mm/media/i/f:iim	I
    //   323: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 1134
    //   329: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: getfield 1085	com/tencent/mm/media/i/f:iio	I
    //   336: invokevirtual 480	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 491	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: getfield 364	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   349: invokestatic 549	com/tencent/mm/plugin/sight/base/e:aNx	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   352: astore 4
    //   354: aload 4
    //   356: ifnull +106 -> 462
    //   359: getstatic 503	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
    //   362: astore 5
    //   364: aload_0
    //   365: getfield 362	com/tencent/mm/media/i/f:idq	I
    //   368: lload_2
    //   369: invokestatic 1138	com/tencent/mm/media/k/e:y	(IJ)V
    //   372: getstatic 503	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
    //   375: astore 5
    //   377: aload 4
    //   379: getfield 638	com/tencent/mm/plugin/sight/base/a:videoBitrate	I
    //   382: i2l
    //   383: aload 4
    //   385: getfield 564	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   388: i2l
    //   389: aload_0
    //   390: getfield 486	com/tencent/mm/media/i/f:videoFps	I
    //   393: i2l
    //   394: invokestatic 1142	com/tencent/mm/media/k/e:f	(JJJ)V
    //   397: aload_0
    //   398: getfield 1080	com/tencent/mm/media/i/f:iil	I
    //   401: i2f
    //   402: aload_0
    //   403: getfield 839	com/tencent/mm/media/i/f:idi	I
    //   406: i2f
    //   407: fdiv
    //   408: f2d
    //   409: ldc2_w 1143
    //   412: dcmpl
    //   413: iflt +11 -> 424
    //   416: getstatic 503	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
    //   419: astore 4
    //   421: invokestatic 1147	com/tencent/mm/media/k/e:aOI	()V
    //   424: getstatic 503	com/tencent/mm/media/k/e:ilC	Lcom/tencent/mm/media/k/e;
    //   427: astore 4
    //   429: aload_0
    //   430: getfield 364	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   433: invokestatic 1150	com/tencent/mm/media/k/e:Hs	(Ljava/lang/String;)V
    //   436: ldc_w 1086
    //   439: invokestatic 329	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: aload_0
    //   443: monitorexit
    //   444: return
    //   445: aload_0
    //   446: iconst_1
    //   447: putfield 1092	com/tencent/mm/media/i/f:iik	Z
    //   450: goto -370 -> 80
    //   453: astore 4
    //   455: aload_0
    //   456: monitorexit
    //   457: aload 4
    //   459: athrow
    //   460: astore 4
    //   462: ldc_w 1086
    //   465: invokestatic 329	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   468: goto -26 -> 442
    //   471: astore 4
    //   473: goto -312 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	f
    //   0	476	1	paramBoolean	boolean
    //   268	101	2	l	long
    //   105	323	4	localObject1	Object
    //   453	5	4	localObject2	Object
    //   460	1	4	localException1	Exception
    //   471	1	4	localException2	Exception
    //   362	14	5	locale	com.tencent.mm.media.k.e
    // Exception table:
    //   from	to	target	type
    //   2	71	453	finally
    //   75	80	453	finally
    //   80	107	453	finally
    //   112	117	453	finally
    //   117	129	453	finally
    //   129	161	453	finally
    //   161	182	453	finally
    //   187	192	453	finally
    //   192	198	453	finally
    //   203	210	453	finally
    //   215	227	453	finally
    //   227	233	453	finally
    //   238	244	453	finally
    //   244	250	453	finally
    //   255	261	453	finally
    //   261	345	453	finally
    //   345	354	453	finally
    //   359	424	453	finally
    //   424	436	453	finally
    //   436	442	453	finally
    //   445	450	453	finally
    //   462	468	453	finally
    //   345	354	460	java/lang/Exception
    //   359	424	460	java/lang/Exception
    //   424	436	460	java/lang/Exception
    //   129	161	471	java/lang/Exception
  }
  
  private final void l(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(177316);
        Log.i(this.TAG, "onDecoderEncoderFailed, isDecoder:" + paramBoolean1 + " isEncoder:" + paramBoolean2);
        this.iit.cancel();
        Object localObject1;
        if (paramBoolean1)
        {
          localObject1 = this.ihG;
          if (localObject1 != null) {
            ((com.tencent.mm.media.d.f)localObject1).releaseDecoder();
          }
          this.ihG = null;
        }
        if (paramBoolean2)
        {
          localObject1 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aOl();
          localObject1 = this.ihT;
          if (localObject1 != null) {
            ((com.tencent.mm.media.e.b)localObject1).aMj();
          }
          this.ihT = null;
        }
        if (!this.iii)
        {
          localObject1 = this.ihW;
          if (localObject1 != null) {
            ((a)localObject1).release();
          }
          this.iih.aBw();
          this.iii = true;
          try
          {
            localObject1 = j.ijn;
            s.deleteFile(j.a.Ho(this.filePath));
            localObject1 = j.ijn;
            s.deleteFile(j.a.Hp(this.filePath));
            this.iei.release();
            localObject1 = this.ihZ;
            if (localObject1 != null) {
              ((com.tencent.mm.media.f.a)localObject1).release();
            }
            localObject1 = this.iia;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.iib;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            s.deleteFile(this.outputFilePath);
            long l = Util.ticksToNow(this.iig);
            Log.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.iiJ;
          if (localObject1 != null)
          {
            ((kotlin.g.a.b)localObject1).invoke(null);
            AppMethodBeat.o(177316);
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(177316);
    }
  }
  
  public final void D(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93801);
    p.h(paramBitmap, "bitmap");
    this.ihg = paramBitmap;
    a locala = this.ihW;
    if (locala != null)
    {
      String str = locala.TAG;
      StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmap:");
      if (paramBitmap != null) {}
      for (int i = paramBitmap.hashCode();; i = 0)
      {
        Log.i(str, i);
        locala.ihg = paramBitmap;
        AppMethodBeat.o(93801);
        return;
      }
    }
    AppMethodBeat.o(93801);
  }
  
  public final int aMG()
  {
    AppMethodBeat.i(93803);
    Log.i(this.TAG, "start remux, initFinish:" + this.iic);
    this.iig = Util.currentTicks();
    if ((this.ihg != null) && (this.ihS > 0)) {
      this.ihg = BitmapUtil.rotate(this.ihg, -this.ihS);
    }
    this.iih.hvh.reset();
    if (this.iic)
    {
      HandlerThread localHandlerThread = this.iia;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      this.iia = com.tencent.mm.ac.d.a("MediaCodecRemux_audioMix", false, (kotlin.g.a.a)new d(this));
      localHandlerThread = this.iib;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      if (this.ihG != null) {
        this.iib = com.tencent.mm.ac.d.a("MediaCodecRemux_videoMix", false, (kotlin.g.a.a)new e(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(93803);
      return 0;
      this.iid = true;
    }
  }
  
  public com.tencent.mm.media.j.c aMH()
  {
    int i = 1;
    AppMethodBeat.i(164113);
    if ((this.ihS == 90) || (this.ihS == 270)) {
      if (this.ihR > this.ihQ) {
        Log.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
    }
    while (this.iiC)
    {
      localc = new com.tencent.mm.media.j.c(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, 2, i);
      AppMethodBeat.o(164113);
      return localc;
      Log.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
      i = 2;
      continue;
      if (this.ihQ > this.ihR)
      {
        Log.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
      else
      {
        Log.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
        i = 2;
      }
    }
    com.tencent.mm.media.j.c localc = new com.tencent.mm.media.j.c(this.ihQ, this.ihR, this.outputWidth, this.outputHeight, i);
    AppMethodBeat.o(164113);
    return localc;
  }
  
  public final void k(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93802);
    p.h(paramb, "blendBitmapProvider");
    this.ihf = paramb;
    a locala = this.ihW;
    if (locala != null)
    {
      locala.i(paramb);
      AppMethodBeat.o(93802);
      return;
    }
    AppMethodBeat.o(93802);
  }
  
  public final void l(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93804);
    p.h(paramb, "blurBgProvider");
    this.iif = paramb;
    a locala = this.ihW;
    if (locala != null)
    {
      locala.j(paramb);
      AppMethodBeat.o(93804);
      return;
    }
    AppMethodBeat.o(93804);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93779);
      Log.i(f.a(this.iiN), "delay check frameDraw: " + f.m(this.iiN));
      if (!f.m(this.iiN))
      {
        Log.e(f.a(this.iiN), "after " + f.aMJ() + " ms, first frame stil not draw!!!");
        com.tencent.mm.media.k.e locale = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOT();
      }
      AppMethodBeat.o(93779);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93780);
      Log.i(f.a(this.iiN), "decode end after " + f.aMK() + ", isFinishEncode:" + f.K(this.iiN));
      if (!f.K(this.iiN))
      {
        com.tencent.mm.media.k.e locale = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOW();
        f.L(this.iiN);
      }
      AppMethodBeat.o(93780);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    f(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    g(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    i(f paramf, com.tencent.mm.media.j.c paramc)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x>
    {
      a(f.i parami)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(f.i parami)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      c(f.i parami)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, x>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "plugin-mediaeditor_release"})
  public static final class n
    extends com.tencent.f.i.b
  {
    public final String getKey()
    {
      return "MediaCodecRemuxer#timeoutInvoke";
    }
    
    public final void run()
    {
      AppMethodBeat.i(177315);
      Log.e(f.a(this.iiN), "remux error! handing one frame time out ,isInvokeEndCallback:" + f.J(this.iiN));
      f localf;
      if (!f.J(this.iiN))
      {
        localf = this.iiN;
        if (f.c(this.iiN)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.i.f
 * JD-Core Version:    0.7.0.1
 */