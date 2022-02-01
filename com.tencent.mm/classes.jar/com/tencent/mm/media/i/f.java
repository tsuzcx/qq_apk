package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bm.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "videoWidth", "videoHeight", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "blurBgProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getFinishCallback", "()Lkotlin/jvm/functions/Function1;", "setFinishCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstFrameDraw", "getForceLandscape", "setForceLandscape", "frameHandingTime", "frameTimeoutMs", "getIFrame", "()I", "setIFrame", "(I)V", "initFinish", "inputHeight", "getInputHeight", "setInputHeight", "inputWidth", "getInputWidth", "setInputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "setMixType", "musicExtractorWrapper", "getOutputAudioBitrate", "setOutputAudioBitrate", "getOutputAudioChannelCount", "setOutputAudioChannelCount", "getOutputAudioSampleRate", "setOutputAudioSampleRate", "getOutputBitrate", "setOutputBitrate", "getOutputFilePath", "getOutputFps", "setOutputFps", "getOutputHeight", "setOutputHeight", "getOutputWidth", "setOutputWidth", "getProgressListener", "setProgressListener", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "timeoutInvoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1;", "useRequestDraw", "getUseSoftEncode", "setUseSoftEncode", "vfrThreshold", "videoDuration", "videoFps", "getVideoHeight", "getVideoMinQP", "setVideoMinQP", "videoMixHandlerThread", "videoRotate", "getVideoWidth", "writeDtsCount", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder;", "checkFinishEncode", "checkFrameDrawTimeout", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "onDecoderEncoderFailed", "isDecoder", "isEncoder", "remux", "remuxImpl", "renderer", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "startRemux", "Companion", "plugin-mediaeditor_release"})
public class f
  extends d
  implements c
{
  private static final long kXw = 1000L;
  private static final long kXx = 1000L;
  public static final f.a kXy;
  private final String TAG;
  private String filePath;
  private volatile boolean kRI;
  private int kRP;
  private int kRX;
  private final int kSH;
  boolean kSJ;
  private com.tencent.mm.media.f.a kSW;
  private volatile boolean kTR;
  private kotlin.g.a.b<? super Long, Bitmap> kVT;
  private Bitmap kVU;
  private int kWE;
  private int kWF;
  private int kWG;
  private com.tencent.mm.media.e.b kWH;
  private com.tencent.mm.media.e.i kWI;
  private com.tencent.mm.media.a.a kWJ;
  private a kWK;
  private i kWL;
  private com.tencent.mm.media.f.a kWM;
  private com.tencent.mm.media.f.a kWN;
  private HandlerThread kWO;
  private HandlerThread kWP;
  private boolean kWQ;
  private boolean kWR;
  private g kWS;
  private kotlin.g.a.b<? super Long, Bitmap> kWT;
  private long kWU;
  private final com.tencent.mm.media.k.a kWV;
  private volatile boolean kWW;
  private boolean kWX;
  private boolean kWY;
  private int kWZ;
  private long kWc;
  private com.tencent.mm.media.d.f kWu;
  private int kXa;
  private long kXb;
  private int kXc;
  private final int kXd;
  private volatile boolean kXe;
  private volatile boolean kXf;
  private final n kXg;
  private final Runnable kXh;
  private final String kXi;
  private Rect kXj;
  private int kXk;
  private int kXl;
  private int kXm;
  private int kXn;
  int kXo;
  protected boolean kXp;
  private int kXq;
  private int kXr;
  private boolean kXs;
  private int kXt;
  kotlin.g.a.b<? super Float, x> kXu;
  private kotlin.g.a.b<? super String, x> kXv;
  private final String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  private final int videoHeight;
  private final int videoWidth;
  
  static
  {
    AppMethodBeat.i(93809);
    kXy = new f.a((byte)0);
    kXw = 1000L;
    kXx = 1000L;
    AppMethodBeat.o(93809);
  }
  
  public f(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt11, int paramInt12, boolean paramBoolean3, int paramInt13, kotlin.g.a.b<? super Float, x> paramb, kotlin.g.a.b<? super String, x> paramb1)
  {
    AppMethodBeat.i(259045);
    this.kXi = paramString1;
    this.filePath = paramString2;
    this.kRX = paramInt1;
    this.outputFilePath = paramString3;
    this.kXj = paramRect;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    this.outputWidth = paramInt4;
    this.outputHeight = paramInt5;
    this.kXk = paramInt6;
    this.kXl = paramInt7;
    this.kXm = paramInt8;
    this.kXn = paramInt9;
    this.kXo = paramInt10;
    this.kXp = paramBoolean1;
    this.kSJ = paramBoolean2;
    this.kXq = paramInt11;
    this.kXr = paramInt12;
    this.kXs = paramBoolean3;
    this.kXt = paramInt13;
    this.kXu = paramb;
    this.kXv = paramb1;
    this.TAG = "MicroMsg.MediaCodecRemuxer";
    this.videoDuration = -1;
    this.kWc = paramLong1;
    this.remuxEndTime = -1L;
    this.kWV = new com.tencent.mm.media.k.a("remuxCost");
    this.kSH = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFy, 10);
    this.kXd = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFA, 10000);
    this.kXg = new n(this);
    if ((Util.isNullOrNil(this.filePath)) || (!u.agG(this.filePath)) || (Util.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
    {
      Log.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.kXo);
      paramString1 = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWZ();
      paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
      AppMethodBeat.o(259045);
      throw paramString1;
    }
    paramString1 = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.uf(this.kRX);
    if (e.Yt(this.filePath))
    {
      Log.i(this.TAG, "remux h265 format");
      paramString1 = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWY();
    }
    u.bBD(u.bBT(this.outputFilePath));
    this.kWG = SightVideoJNI.getMp4RotateVFS(this.filePath);
    if ((this.kXs) && ((this.kWG == 90) || (this.kWG == 270)))
    {
      paramInt1 = this.outputWidth;
      this.outputWidth = this.outputHeight;
      this.outputHeight = paramInt1;
    }
    paramString2 = com.tencent.mm.plugin.sight.base.f.aYg(this.filePath);
    if (paramString2 != null)
    {
      this.kWE = paramString2.width;
      this.kWF = paramString2.height;
      this.videoFps = paramString2.frameRate;
      this.videoDuration = paramString2.videoDuration;
    }
    if ((this.kWE <= 0) || (this.kWF <= 0)) {}
    try
    {
      paramString1 = new com.tencent.mm.compatible.i.d();
      paramString1.setDataSource(this.filePath);
      this.kWE = Util.getInt(paramString1.extractMetadata(18), 0);
      this.kWF = Util.getInt(paramString1.extractMetadata(19), 0);
      paramString1.release();
      label627:
      if (this.videoFps <= 0)
      {
        Log.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
        paramString1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWZ();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(259045);
        throw paramString1;
      }
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        Log.i(this.TAG, "MediaCodecRemuxer frameTimeoutMs is:" + this.kXd);
        paramString1 = com.tencent.mm.media.k.g.laC;
        paramString1 = com.tencent.mm.media.k.g.OE(this.filePath);
        if (!this.kXp) {
          break label1286;
        }
        paramString1 = new i(this.kWc, this.remuxEndTime, this.kXk, this.outputWidth, this.outputHeight, this.kXp, this.kXo, this.kSJ, paramString1);
        label800:
        this.kWL = paramString1;
        if (this.kXn <= 0) {
          this.kXn = 1;
        }
        Log.printInfoStack(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.kWE + ", inputHeight: " + this.kWF + ", videoRotate: " + this.kWG + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.kXk + ", outputAudioBitrate:" + this.kXl + ", outputAudioChannelCount:" + this.kXn + ", outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.kXo + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.kWc + " ,remuxEndTime: " + this.remuxEndTime + " , input bitrate:" + paramString2.videoBitrate + ", enableHevc:" + this.kSJ, new Object[0]);
        this.kSW = new com.tencent.mm.media.f.a(this.filePath);
        if (this.kSW.kUZ)
        {
          paramString1 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aXa();
        }
        paramInt1 = this.outputWidth - this.kWE;
        if ((1 <= paramInt1) && (16 > paramInt1)) {
          break label1322;
        }
        paramInt1 = this.outputHeight - this.kWF;
        if (1 <= paramInt1) {
          break label1316;
        }
        label1151:
        paramBoolean1 = false;
        label1154:
        Log.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(paramBoolean1)));
        Log.i(this.TAG, "startRemux, useSoftEncode:" + this.kXp + ", enablHevc:" + this.kSJ);
        if (this.kSJ)
        {
          if (!this.kXp) {
            break label1328;
          }
          paramString1 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aXC();
        }
      }
      for (;;)
      {
        if (this.kXp)
        {
          paramString1 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aXB();
        }
        a(aUZ());
        this.kXh = ((Runnable)new c(this));
        AppMethodBeat.o(259045);
        return;
        this.remuxEndTime = paramLong2;
        break;
        label1286:
        paramString1 = new i(this.kWc, this.remuxEndTime, this.kXk, this.kXp, paramString1, 16);
        break label800;
        label1316:
        if (16 <= paramInt1) {
          break label1151;
        }
        label1322:
        paramBoolean1 = true;
        break label1154;
        label1328:
        paramString1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXD();
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
    //   0: ldc_w 850
    //   3: invokestatic 312	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   10: astore 9
    //   12: getstatic 856	com/tencent/mm/media/i/j:kYa	Lcom/tencent/mm/media/i/j$a;
    //   15: astore 10
    //   17: aload 9
    //   19: invokestatic 861	com/tencent/mm/media/i/j$a:OA	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: ifnonnull +693 -> 719
    //   29: aload_0
    //   30: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   33: ldc_w 863
    //   36: invokestatic 489	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 856	com/tencent/mm/media/i/j:kYa	Lcom/tencent/mm/media/i/j$a;
    //   42: astore 9
    //   44: aload_0
    //   45: new 653	com/tencent/mm/media/f/a
    //   48: dup
    //   49: aload_0
    //   50: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   53: invokestatic 861	com/tencent/mm/media/i/j$a:OA	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 654	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   59: putfield 727	com/tencent/mm/media/i/f:kWN	Lcom/tencent/mm/media/f/a;
    //   62: aload_0
    //   63: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   66: astore 9
    //   68: new 458	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 865
    //   75: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: astore 10
    //   80: getstatic 856	com/tencent/mm/media/i/j:kYa	Lcom/tencent/mm/media/i/j$a;
    //   83: astore 11
    //   85: aload 10
    //   87: aload_0
    //   88: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   91: invokestatic 861	com/tencent/mm/media/i/j$a:OA	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 867
    //   100: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: astore 10
    //   105: getstatic 856	com/tencent/mm/media/i/j:kYa	Lcom/tencent/mm/media/i/j$a;
    //   108: astore 11
    //   110: aload 9
    //   112: aload 10
    //   114: aload_0
    //   115: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   118: invokestatic 870	com/tencent/mm/media/i/j$a:Oz	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 727	com/tencent/mm/media/i/f:kWN	Lcom/tencent/mm/media/f/a;
    //   134: astore 9
    //   136: aload 9
    //   138: ifnull +89 -> 227
    //   141: aload_0
    //   142: new 872	com/tencent/mm/media/i/g
    //   145: dup
    //   146: aload_0
    //   147: getfield 595	com/tencent/mm/media/i/f:kWL	Lcom/tencent/mm/media/i/i;
    //   150: aload 9
    //   152: aload_0
    //   153: getfield 360	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 358	com/tencent/mm/media/i/f:kRX	I
    //   160: aload_0
    //   161: getfield 376	com/tencent/mm/media/i/f:kXm	I
    //   164: invokespecial 875	com/tencent/mm/media/i/g:<init>	(Lcom/tencent/mm/media/i/i;Lcom/tencent/mm/media/f/a;Ljava/lang/String;II)V
    //   167: putfield 877	com/tencent/mm/media/i/f:kWS	Lcom/tencent/mm/media/i/g;
    //   170: aload_0
    //   171: getfield 354	com/tencent/mm/media/i/f:kXi	Ljava/lang/String;
    //   174: invokestatic 456	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   177: ifeq +50 -> 227
    //   180: aload_0
    //   181: getfield 354	com/tencent/mm/media/i/f:kXi	Ljava/lang/String;
    //   184: astore 9
    //   186: aload 9
    //   188: ifnonnull +6 -> 194
    //   191: invokestatic 780	kotlin/g/b/p:iCn	()V
    //   194: new 653	com/tencent/mm/media/f/a
    //   197: dup
    //   198: aload 9
    //   200: invokespecial 654	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   203: astore 9
    //   205: aload 9
    //   207: getfield 659	com/tencent/mm/media/f/a:kUZ	Z
    //   210: ifeq +11 -> 221
    //   213: getstatic 495	com/tencent/mm/media/k/f:laB	Lcom/tencent/mm/media/k/f;
    //   216: astore 10
    //   218: invokestatic 880	com/tencent/mm/media/k/f:aXc	()V
    //   221: aload_0
    //   222: aload 9
    //   224: putfield 721	com/tencent/mm/media/i/f:kWM	Lcom/tencent/mm/media/f/a;
    //   227: aload_0
    //   228: getfield 877	com/tencent/mm/media/i/f:kWS	Lcom/tencent/mm/media/i/g;
    //   231: astore 9
    //   233: aload 9
    //   235: ifnull +12 -> 247
    //   238: aload 9
    //   240: aload_0
    //   241: getfield 535	com/tencent/mm/media/i/f:kWG	I
    //   244: putfield 881	com/tencent/mm/media/i/g:kWG	I
    //   247: aload_0
    //   248: invokespecial 885	com/tencent/mm/media/i/f:aVa	()Lcom/tencent/mm/media/b/d;
    //   251: astore 9
    //   253: new 42	com/tencent/mm/media/i/f$j
    //   256: dup
    //   257: aload_0
    //   258: invokespecial 886	com/tencent/mm/media/i/f$j:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   261: checkcast 888	kotlin/g/a/m
    //   264: astore 10
    //   266: new 44	com/tencent/mm/media/i/f$k
    //   269: dup
    //   270: aload_0
    //   271: invokespecial 889	com/tencent/mm/media/i/f$k:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   274: checkcast 802	kotlin/g/a/a
    //   277: astore 11
    //   279: aload_0
    //   280: getfield 382	com/tencent/mm/media/i/f:kXp	Z
    //   283: ifeq +534 -> 817
    //   286: aload_0
    //   287: new 891	com/tencent/mm/media/e/i
    //   290: dup
    //   291: aload_0
    //   292: getfield 595	com/tencent/mm/media/i/f:kWL	Lcom/tencent/mm/media/i/i;
    //   295: getfield 762	com/tencent/mm/media/i/i:bufId	I
    //   298: aload 9
    //   300: getfield 896	com/tencent/mm/media/b/d:targetWidth	I
    //   303: aload 9
    //   305: getfield 899	com/tencent/mm/media/b/d:targetHeight	I
    //   308: invokespecial 902	com/tencent/mm/media/e/i:<init>	(III)V
    //   311: putfield 904	com/tencent/mm/media/i/f:kWI	Lcom/tencent/mm/media/e/i;
    //   314: aload_0
    //   315: new 906	com/tencent/mm/media/i/a
    //   318: dup
    //   319: aload_1
    //   320: checkcast 908	com/tencent/mm/media/j/a
    //   323: invokespecial 911	com/tencent/mm/media/i/a:<init>	(Lcom/tencent/mm/media/j/a;)V
    //   326: putfield 913	com/tencent/mm/media/i/f:kWK	Lcom/tencent/mm/media/i/a;
    //   329: aload_0
    //   330: getfield 913	com/tencent/mm/media/i/f:kWK	Lcom/tencent/mm/media/i/a;
    //   333: astore 9
    //   335: aload 9
    //   337: ifnull +45 -> 382
    //   340: aload 9
    //   342: ldc_w 914
    //   345: aload_0
    //   346: getfield 478	com/tencent/mm/media/i/f:videoFps	I
    //   349: idiv
    //   350: putfield 917	com/tencent/mm/media/i/a:kWa	I
    //   353: aload 9
    //   355: getfield 918	com/tencent/mm/media/i/a:TAG	Ljava/lang/String;
    //   358: new 458	java/lang/StringBuilder
    //   361: dup
    //   362: ldc_w 920
    //   365: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: aload 9
    //   370: getfield 917	com/tencent/mm/media/i/a:kWa	I
    //   373: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: aload_0
    //   383: getfield 922	com/tencent/mm/media/i/f:kVT	Lkotlin/g/a/b;
    //   386: ifnull +23 -> 409
    //   389: aload_0
    //   390: getfield 913	com/tencent/mm/media/i/f:kWK	Lcom/tencent/mm/media/i/a;
    //   393: astore 9
    //   395: aload 9
    //   397: ifnull +12 -> 409
    //   400: aload 9
    //   402: aload_0
    //   403: getfield 922	com/tencent/mm/media/i/f:kVT	Lkotlin/g/a/b;
    //   406: invokevirtual 925	com/tencent/mm/media/i/a:i	(Lkotlin/g/a/b;)V
    //   409: aload_0
    //   410: getfield 927	com/tencent/mm/media/i/f:kWT	Lkotlin/g/a/b;
    //   413: ifnull +23 -> 436
    //   416: aload_0
    //   417: getfield 913	com/tencent/mm/media/i/f:kWK	Lcom/tencent/mm/media/i/a;
    //   420: astore 9
    //   422: aload 9
    //   424: ifnull +12 -> 436
    //   427: aload 9
    //   429: aload_0
    //   430: getfield 927	com/tencent/mm/media/i/f:kWT	Lkotlin/g/a/b;
    //   433: invokevirtual 930	com/tencent/mm/media/i/a:j	(Lkotlin/g/a/b;)V
    //   436: aload_0
    //   437: getfield 913	com/tencent/mm/media/i/f:kWK	Lcom/tencent/mm/media/i/a;
    //   440: astore 9
    //   442: aload 9
    //   444: ifnull +19 -> 463
    //   447: aload 9
    //   449: new 22	com/tencent/mm/media/i/f$h
    //   452: dup
    //   453: aload_0
    //   454: invokespecial 931	com/tencent/mm/media/i/f$h:<init>	(Lcom/tencent/mm/media/i/f;)V
    //   457: checkcast 933	kotlin/g/a/b
    //   460: putfield 936	com/tencent/mm/media/i/a:kVP	Lkotlin/g/a/b;
    //   463: iconst_3
    //   464: newarray double
    //   466: astore 9
    //   468: aload 9
    //   470: dup
    //   471: iconst_0
    //   472: dconst_0
    //   473: dastore
    //   474: dup
    //   475: iconst_1
    //   476: dconst_0
    //   477: dastore
    //   478: dup
    //   479: iconst_2
    //   480: dconst_0
    //   481: dastore
    //   482: pop
    //   483: aload_0
    //   484: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   487: aload 9
    //   489: aload_0
    //   490: getfield 435	com/tencent/mm/media/i/f:kSH	I
    //   493: invokestatic 941	com/tencent/mm/media/k/b:a	(Ljava/lang/String;[DI)Ljava/util/List;
    //   496: pop
    //   497: iconst_0
    //   498: istore_2
    //   499: goto +516 -> 1015
    //   502: iload_2
    //   503: ifeq +85 -> 588
    //   506: aload 9
    //   508: iconst_1
    //   509: daload
    //   510: aload 9
    //   512: iconst_0
    //   513: daload
    //   514: dsub
    //   515: aload_0
    //   516: getfield 435	com/tencent/mm/media/i/f:kSH	I
    //   519: i2d
    //   520: dcmpl
    //   521: iflt +67 -> 588
    //   524: aload_0
    //   525: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   528: new 458	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 943
    //   535: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: aload 9
    //   540: iconst_0
    //   541: daload
    //   542: invokevirtual 946	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   545: ldc_w 948
    //   548: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 9
    //   553: iconst_1
    //   554: daload
    //   555: invokevirtual 946	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   558: ldc_w 950
    //   561: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_0
    //   565: getfield 435	com/tencent/mm/media/i/f:kSH	I
    //   568: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: ldc_w 952
    //   574: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: aload_0
    //   584: iconst_1
    //   585: putfield 954	com/tencent/mm/media/i/f:kXf	Z
    //   588: aload_0
    //   589: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   592: new 458	java/lang/StringBuilder
    //   595: dup
    //   596: ldc_w 956
    //   599: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   602: aload_0
    //   603: getfield 954	com/tencent/mm/media/i/f:kXf	Z
    //   606: invokevirtual 645	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   609: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload_0
    //   616: getfield 958	com/tencent/mm/media/i/f:kWH	Lcom/tencent/mm/media/e/b;
    //   619: ifnull +367 -> 986
    //   622: aload_0
    //   623: getfield 958	com/tencent/mm/media/i/f:kWH	Lcom/tencent/mm/media/e/b;
    //   626: astore 9
    //   628: aload 9
    //   630: ifnull +356 -> 986
    //   633: aload 9
    //   635: invokevirtual 964	com/tencent/mm/media/e/b:aUA	()Landroid/view/Surface;
    //   638: astore 9
    //   640: aload_0
    //   641: getfield 913	com/tencent/mm/media/i/f:kWK	Lcom/tencent/mm/media/i/a;
    //   644: astore 10
    //   646: aload 10
    //   648: ifnull +360 -> 1008
    //   651: aload_0
    //   652: getfield 954	com/tencent/mm/media/i/f:kXf	Z
    //   655: ifne +337 -> 992
    //   658: iconst_1
    //   659: istore 4
    //   661: aload_0
    //   662: getfield 382	com/tencent/mm/media/i/f:kXp	Z
    //   665: ifeq +333 -> 998
    //   668: aload_0
    //   669: getfield 368	com/tencent/mm/media/i/f:outputWidth	I
    //   672: istore_2
    //   673: aload_0
    //   674: getfield 382	com/tencent/mm/media/i/f:kXp	Z
    //   677: ifeq +326 -> 1003
    //   680: aload_0
    //   681: getfield 370	com/tencent/mm/media/i/f:outputHeight	I
    //   684: istore_3
    //   685: aload 10
    //   687: aload 9
    //   689: iload 4
    //   691: iload_2
    //   692: iload_3
    //   693: aload_0
    //   694: getfield 404	com/tencent/mm/media/i/f:kWc	J
    //   697: new 24	com/tencent/mm/media/i/f$i
    //   700: dup
    //   701: aload_0
    //   702: aload_1
    //   703: invokespecial 967	com/tencent/mm/media/i/f$i:<init>	(Lcom/tencent/mm/media/i/f;Lcom/tencent/mm/media/j/c;)V
    //   706: checkcast 933	kotlin/g/a/b
    //   709: invokevirtual 970	com/tencent/mm/media/i/a:a	(Landroid/view/Surface;ZIIJLkotlin/g/a/b;)V
    //   712: ldc_w 850
    //   715: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   718: return
    //   719: aload 10
    //   721: invokestatic 456	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   724: ifeq +9 -> 733
    //   727: aload 10
    //   729: invokestatic 973	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   732: pop
    //   733: aload_0
    //   734: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   737: ldc_w 975
    //   740: iconst_2
    //   741: anewarray 647	java/lang/Object
    //   744: dup
    //   745: iconst_0
    //   746: aload 9
    //   748: aastore
    //   749: dup
    //   750: iconst_1
    //   751: aload 10
    //   753: aastore
    //   754: invokestatic 977	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   757: invokestatic 757	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   760: lstore 5
    //   762: aload 9
    //   764: aload 10
    //   766: invokestatic 981	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   769: lstore 7
    //   771: aload_0
    //   772: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   775: new 458	java/lang/StringBuilder
    //   778: dup
    //   779: ldc_w 983
    //   782: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   785: lload 5
    //   787: invokestatic 987	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   790: invokevirtual 625	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   793: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   799: lload 7
    //   801: lconst_0
    //   802: lcmp
    //   803: ifgt -764 -> 39
    //   806: getstatic 495	com/tencent/mm/media/k/f:laB	Lcom/tencent/mm/media/k/f;
    //   809: astore 9
    //   811: invokestatic 990	com/tencent/mm/media/k/f:aXb	()V
    //   814: goto -775 -> 39
    //   817: bipush 23
    //   819: invokestatic 996	com/tencent/mm/compatible/util/d:qV	(I)Z
    //   822: ifeq +116 -> 938
    //   825: new 998	com/tencent/mm/media/e/g
    //   828: dup
    //   829: aload 9
    //   831: new 18	com/tencent/mm/media/i/f$f
    //   834: dup
    //   835: aload 10
    //   837: aload 11
    //   839: invokespecial 1001	com/tencent/mm/media/i/f$f:<init>	(Lkotlin/g/a/m;Lkotlin/g/a/a;)V
    //   842: checkcast 933	kotlin/g/a/b
    //   845: invokespecial 1004	com/tencent/mm/media/e/g:<init>	(Lcom/tencent/mm/media/b/d;Lkotlin/g/a/b;)V
    //   848: checkcast 960	com/tencent/mm/media/e/b
    //   851: astore 9
    //   853: aload_0
    //   854: aload 9
    //   856: putfield 958	com/tencent/mm/media/i/f:kWH	Lcom/tencent/mm/media/e/b;
    //   859: goto -545 -> 314
    //   862: astore_1
    //   863: aload_0
    //   864: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   867: aload_1
    //   868: checkcast 505	java/lang/Throwable
    //   871: ldc_w 1006
    //   874: iconst_0
    //   875: anewarray 647	java/lang/Object
    //   878: invokestatic 814	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   881: getstatic 495	com/tencent/mm/media/k/f:laB	Lcom/tencent/mm/media/k/f;
    //   884: astore_1
    //   885: invokestatic 1009	com/tencent/mm/media/k/f:aXd	()V
    //   888: invokestatic 1015	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   891: ldc_w 1017
    //   894: iconst_1
    //   895: invokevirtual 1021	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putBoolean	(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   898: pop
    //   899: aload_0
    //   900: iconst_0
    //   901: iconst_1
    //   902: invokespecial 849	com/tencent/mm/media/i/f:p	(ZZ)V
    //   905: ldc_w 850
    //   908: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   911: return
    //   912: astore_1
    //   913: aload_0
    //   914: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   917: aload_1
    //   918: checkcast 505	java/lang/Throwable
    //   921: ldc_w 1023
    //   924: iconst_0
    //   925: anewarray 647	java/lang/Object
    //   928: invokestatic 814	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   931: ldc_w 850
    //   934: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   937: return
    //   938: new 1025	com/tencent/mm/media/e/f
    //   941: dup
    //   942: aload 9
    //   944: new 20	com/tencent/mm/media/i/f$g
    //   947: dup
    //   948: aload 10
    //   950: aload 11
    //   952: invokespecial 1026	com/tencent/mm/media/i/f$g:<init>	(Lkotlin/g/a/m;Lkotlin/g/a/a;)V
    //   955: checkcast 933	kotlin/g/a/b
    //   958: invokespecial 1027	com/tencent/mm/media/e/f:<init>	(Lcom/tencent/mm/media/b/d;Lkotlin/g/a/b;)V
    //   961: checkcast 960	com/tencent/mm/media/e/b
    //   964: astore 9
    //   966: goto -113 -> 853
    //   969: iconst_0
    //   970: istore_3
    //   971: goto +60 -> 1031
    //   974: iload_2
    //   975: iconst_1
    //   976: iadd
    //   977: istore_2
    //   978: goto +37 -> 1015
    //   981: iconst_1
    //   982: istore_2
    //   983: goto -481 -> 502
    //   986: aconst_null
    //   987: astore 9
    //   989: goto -349 -> 640
    //   992: iconst_0
    //   993: istore 4
    //   995: goto -334 -> 661
    //   998: iconst_0
    //   999: istore_2
    //   1000: goto -327 -> 673
    //   1003: iconst_0
    //   1004: istore_3
    //   1005: goto -320 -> 685
    //   1008: ldc_w 850
    //   1011: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1014: return
    //   1015: iload_2
    //   1016: iconst_3
    //   1017: if_icmpge -36 -> 981
    //   1020: aload 9
    //   1022: iload_2
    //   1023: daload
    //   1024: dconst_0
    //   1025: dcmpl
    //   1026: ifle -57 -> 969
    //   1029: iconst_1
    //   1030: istore_3
    //   1031: iload_3
    //   1032: ifne -58 -> 974
    //   1035: iconst_0
    //   1036: istore_2
    //   1037: goto -535 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1040	0	this	f
    //   0	1040	1	paramc	com.tencent.mm.media.j.c
    //   498	539	2	i	int
    //   684	348	3	j	int
    //   659	335	4	bool	boolean
    //   760	26	5	l1	long
    //   769	31	7	l2	long
    //   10	1011	9	localObject1	Object
    //   15	934	10	localObject2	Object
    //   83	868	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   279	314	862	java/lang/Exception
    //   817	853	862	java/lang/Exception
    //   853	859	862	java/lang/Exception
    //   938	966	862	java/lang/Exception
    //   247	279	912	java/lang/Exception
    //   314	335	912	java/lang/Exception
    //   340	382	912	java/lang/Exception
    //   382	395	912	java/lang/Exception
    //   400	409	912	java/lang/Exception
    //   409	422	912	java/lang/Exception
    //   427	436	912	java/lang/Exception
    //   436	442	912	java/lang/Exception
    //   447	463	912	java/lang/Exception
    //   463	497	912	java/lang/Exception
    //   506	588	912	java/lang/Exception
    //   588	628	912	java/lang/Exception
    //   633	640	912	java/lang/Exception
    //   640	646	912	java/lang/Exception
    //   651	658	912	java/lang/Exception
    //   661	673	912	java/lang/Exception
    //   673	685	912	java/lang/Exception
    //   685	718	912	java/lang/Exception
    //   863	911	912	java/lang/Exception
  }
  
  private final void aUx()
  {
    AppMethodBeat.i(93805);
    Log.i(this.TAG, "finishEncode");
    Object localObject;
    if (this.kXp)
    {
      localObject = this.kWI;
      if (localObject != null) {
        ((com.tencent.mm.media.e.i)localObject).stop();
      }
      fE(true);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.kXh);
      this.kTR = true;
      AppMethodBeat.o(93805);
      return;
      localObject = this.kWH;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).aUx();
      }
    }
  }
  
  private final com.tencent.mm.media.b.d aVa()
  {
    AppMethodBeat.i(93800);
    if (this.kXo > 0) {}
    com.tencent.mm.media.b.d locald;
    for (int i = Math.min(this.kXo, this.videoFps);; i = this.videoFps)
    {
      locald = new com.tencent.mm.media.b.d(this.kSJ);
      locald.bitrate = this.kXk;
      locald.frameRate = i;
      locald.targetHeight = this.outputHeight;
      locald.targetWidth = this.outputWidth;
      locald.kSl = this.kXq;
      locald.kSm = this.kXr;
      if (this.kXt > 0) {
        locald.kSh = this.kXt;
      }
      while (locald.frameRate * locald.kSh - 1 <= 1)
      {
        locald.frameRate += 1;
        Log.e(this.TAG, "encodeConfig.frameRate + 1");
      }
    }
    Log.i(this.TAG, "steve: hardcoder qp:" + this.kXq + ", " + this.kXr);
    AppMethodBeat.o(93800);
    return locald;
  }
  
  /* Error */
  private final void fE(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1078
    //   5: invokestatic 312	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   12: new 458	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1080
    //   19: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: iload_1
    //   23: invokevirtual 645	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 1082
    //   29: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 1084	com/tencent/mm/media/i/f:kWY	Z
    //   36: invokevirtual 645	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 1086
    //   42: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 1088	com/tencent/mm/media/i/f:kWX	Z
    //   49: invokevirtual 645	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1090
    //   55: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 825	com/tencent/mm/media/i/f:kWW	Z
    //   62: invokevirtual 645	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload_1
    //   72: ifeq +373 -> 445
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 1088	com/tencent/mm/media/i/f:kWX	Z
    //   80: aload_0
    //   81: getfield 1084	com/tencent/mm/media/i/f:kWY	Z
    //   84: ifeq +378 -> 462
    //   87: aload_0
    //   88: getfield 1088	com/tencent/mm/media/i/f:kWX	Z
    //   91: ifeq +371 -> 462
    //   94: aload_0
    //   95: getfield 825	com/tencent/mm/media/i/f:kWW	Z
    //   98: ifne +364 -> 462
    //   101: aload_0
    //   102: getfield 913	com/tencent/mm/media/i/f:kWK	Lcom/tencent/mm/media/i/a;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 1091	com/tencent/mm/media/i/a:release	()V
    //   117: aload_0
    //   118: getfield 415	com/tencent/mm/media/i/f:kWV	Lcom/tencent/mm/media/k/a;
    //   121: invokevirtual 1094	com/tencent/mm/media/k/a:aIZ	()V
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 825	com/tencent/mm/media/i/f:kWW	Z
    //   129: getstatic 856	com/tencent/mm/media/i/j:kYa	Lcom/tencent/mm/media/i/j$a;
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   138: invokestatic 870	com/tencent/mm/media/i/j$a:Oz	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 973	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   144: pop
    //   145: getstatic 856	com/tencent/mm/media/i/j:kYa	Lcom/tencent/mm/media/i/j$a;
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 356	com/tencent/mm/media/i/f:filePath	Ljava/lang/String;
    //   154: invokestatic 861	com/tencent/mm/media/i/j$a:OA	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 973	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 445	com/tencent/mm/media/i/f:kXg	Lcom/tencent/mm/media/i/f$n;
    //   165: invokevirtual 1097	com/tencent/mm/media/i/f$n:cancel	()Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 656	com/tencent/mm/media/i/f:kSW	Lcom/tencent/mm/media/f/a;
    //   173: invokevirtual 1098	com/tencent/mm/media/f/a:release	()V
    //   176: aload_0
    //   177: getfield 727	com/tencent/mm/media/i/f:kWN	Lcom/tencent/mm/media/f/a;
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 1098	com/tencent/mm/media/f/a:release	()V
    //   192: aload_0
    //   193: getfield 877	com/tencent/mm/media/i/f:kWS	Lcom/tencent/mm/media/i/g;
    //   196: astore 4
    //   198: aload 4
    //   200: ifnull +27 -> 227
    //   203: aload 4
    //   205: getfield 1101	com/tencent/mm/media/i/g:kXQ	Lkotlin/g/a/b;
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull +15 -> 227
    //   215: aload 4
    //   217: aload_0
    //   218: getfield 396	com/tencent/mm/media/i/f:kXv	Lkotlin/g/a/b;
    //   221: invokeinterface 1105 2 0
    //   226: pop
    //   227: aload_0
    //   228: getfield 1107	com/tencent/mm/media/i/f:kWO	Landroid/os/HandlerThread;
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +9 -> 244
    //   238: aload 4
    //   240: invokevirtual 1112	android/os/HandlerThread:quit	()Z
    //   243: pop
    //   244: aload_0
    //   245: getfield 1114	com/tencent/mm/media/i/f:kWP	Landroid/os/HandlerThread;
    //   248: astore 4
    //   250: aload 4
    //   252: ifnull +9 -> 261
    //   255: aload 4
    //   257: invokevirtual 1112	android/os/HandlerThread:quit	()Z
    //   260: pop
    //   261: aload_0
    //   262: getfield 1116	com/tencent/mm/media/i/f:kWU	J
    //   265: invokestatic 987	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   268: lstore_2
    //   269: aload_0
    //   270: getfield 400	com/tencent/mm/media/i/f:TAG	Ljava/lang/String;
    //   273: new 458	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1118
    //   280: invokespecial 461	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: lload_2
    //   284: invokevirtual 625	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: ldc_w 1120
    //   290: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 1071	com/tencent/mm/media/i/f:kWZ	I
    //   297: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 1122
    //   303: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: getfield 836	com/tencent/mm/media/i/f:kRP	I
    //   310: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 1124
    //   316: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 1069	com/tencent/mm/media/i/f:kXa	I
    //   323: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 1126
    //   329: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: getfield 1076	com/tencent/mm/media/i/f:kXc	I
    //   336: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 483	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 517	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: getfield 360	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   349: invokestatic 541	com/tencent/mm/plugin/sight/base/f:aYg	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/b;
    //   352: astore 4
    //   354: aload 4
    //   356: ifnull +106 -> 462
    //   359: getstatic 495	com/tencent/mm/media/k/f:laB	Lcom/tencent/mm/media/k/f;
    //   362: astore 5
    //   364: aload_0
    //   365: getfield 358	com/tencent/mm/media/i/f:kRX	I
    //   368: lload_2
    //   369: invokestatic 1130	com/tencent/mm/media/k/f:y	(IJ)V
    //   372: getstatic 495	com/tencent/mm/media/k/f:laB	Lcom/tencent/mm/media/k/f;
    //   375: astore 5
    //   377: aload 4
    //   379: getfield 640	com/tencent/mm/plugin/sight/base/b:videoBitrate	I
    //   382: i2l
    //   383: aload 4
    //   385: getfield 556	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   388: i2l
    //   389: aload_0
    //   390: getfield 478	com/tencent/mm/media/i/f:videoFps	I
    //   393: i2l
    //   394: invokestatic 1134	com/tencent/mm/media/k/f:g	(JJJ)V
    //   397: aload_0
    //   398: getfield 1071	com/tencent/mm/media/i/f:kWZ	I
    //   401: i2f
    //   402: aload_0
    //   403: getfield 836	com/tencent/mm/media/i/f:kRP	I
    //   406: i2f
    //   407: fdiv
    //   408: f2d
    //   409: ldc2_w 1135
    //   412: dcmpl
    //   413: iflt +11 -> 424
    //   416: getstatic 495	com/tencent/mm/media/k/f:laB	Lcom/tencent/mm/media/k/f;
    //   419: astore 4
    //   421: invokestatic 1139	com/tencent/mm/media/k/f:aXm	()V
    //   424: getstatic 495	com/tencent/mm/media/k/f:laB	Lcom/tencent/mm/media/k/f;
    //   427: astore 4
    //   429: aload_0
    //   430: getfield 360	com/tencent/mm/media/i/f:outputFilePath	Ljava/lang/String;
    //   433: invokestatic 1142	com/tencent/mm/media/k/f:OD	(Ljava/lang/String;)V
    //   436: ldc_w 1078
    //   439: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: aload_0
    //   443: monitorexit
    //   444: return
    //   445: aload_0
    //   446: iconst_1
    //   447: putfield 1084	com/tencent/mm/media/i/f:kWY	Z
    //   450: goto -370 -> 80
    //   453: astore 4
    //   455: aload_0
    //   456: monitorexit
    //   457: aload 4
    //   459: athrow
    //   460: astore 4
    //   462: ldc_w 1078
    //   465: invokestatic 325	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   362	14	5	localf	com.tencent.mm.media.k.f
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
  
  private final void p(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(177316);
        Log.i(this.TAG, "onDecoderEncoderFailed, isDecoder:" + paramBoolean1 + " isEncoder:" + paramBoolean2);
        this.kXg.cancel();
        Object localObject1;
        if (paramBoolean1)
        {
          localObject1 = this.kWu;
          if (localObject1 != null) {
            ((com.tencent.mm.media.d.f)localObject1).releaseDecoder();
          }
          this.kWu = null;
        }
        if (paramBoolean2)
        {
          localObject1 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aWP();
          localObject1 = this.kWH;
          if (localObject1 != null) {
            ((com.tencent.mm.media.e.b)localObject1).aUy();
          }
          this.kWH = null;
        }
        if (!this.kWW)
        {
          this.kWL.release();
          localObject1 = this.kWK;
          if (localObject1 != null) {
            ((a)localObject1).release();
          }
          this.kWV.aIZ();
          this.kWW = true;
          try
          {
            localObject1 = j.kYa;
            u.deleteFile(j.a.Oz(this.filePath));
            localObject1 = j.kYa;
            u.deleteFile(j.a.OA(this.filePath));
            this.kSW.release();
            localObject1 = this.kWN;
            if (localObject1 != null) {
              ((com.tencent.mm.media.f.a)localObject1).release();
            }
            localObject1 = this.kWO;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.kWP;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            u.deleteFile(this.outputFilePath);
            long l = Util.ticksToNow(this.kWU);
            Log.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.kXv;
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
  
  public final void A(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93801);
    p.k(paramBitmap, "bitmap");
    this.kVU = paramBitmap;
    a locala = this.kWK;
    if (locala != null)
    {
      String str = locala.TAG;
      StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmap:");
      if (paramBitmap != null) {}
      for (int i = paramBitmap.hashCode();; i = 0)
      {
        Log.i(str, i);
        locala.kVU = paramBitmap;
        AppMethodBeat.o(93801);
        return;
      }
    }
    AppMethodBeat.o(93801);
  }
  
  public final int aUW()
  {
    AppMethodBeat.i(93803);
    Log.i(this.TAG, "start remux, initFinish:" + this.kWQ);
    this.kWU = Util.currentTicks();
    if ((this.kVU != null) && (this.kWG > 0)) {
      this.kVU = BitmapUtil.rotate(this.kVU, -this.kWG);
    }
    this.kWV.khd.reset();
    if (this.kWQ)
    {
      HandlerThread localHandlerThread = this.kWO;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      this.kWO = com.tencent.mm.ae.d.a("MediaCodecRemux_audioMix", false, (kotlin.g.a.a)new d(this));
      localHandlerThread = this.kWP;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      if (this.kWu != null) {
        this.kWP = com.tencent.mm.ae.d.a("MediaCodecRemux_videoMix", false, (kotlin.g.a.a)new e(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(93803);
      return 0;
      this.kWR = true;
    }
  }
  
  protected final int aUX()
  {
    return this.kWE;
  }
  
  protected final int aUY()
  {
    return this.kWF;
  }
  
  public com.tencent.mm.media.j.c aUZ()
  {
    int i = 1;
    AppMethodBeat.i(164113);
    if ((this.kWG == 90) || (this.kWG == 270)) {
      if (this.kWF > this.kWE) {
        Log.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
    }
    while (this.kXp)
    {
      localc = new com.tencent.mm.media.j.c(this.kWE, this.kWF, this.outputWidth, this.outputHeight, 2, i);
      AppMethodBeat.o(164113);
      return localc;
      Log.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
      i = 2;
      continue;
      if (this.kWE > this.kWF)
      {
        Log.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
      else
      {
        Log.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
        i = 2;
      }
    }
    com.tencent.mm.media.j.c localc = new com.tencent.mm.media.j.c(this.kWE, this.kWF, this.outputWidth, this.outputHeight, i);
    AppMethodBeat.o(164113);
    return localc;
  }
  
  public final Rect aVb()
  {
    return this.kXj;
  }
  
  public final int getOutputHeight()
  {
    return this.outputHeight;
  }
  
  public final int getOutputWidth()
  {
    return this.outputWidth;
  }
  
  public final int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  public final int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public final void k(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93802);
    p.k(paramb, "blendBitmapProvider");
    this.kVT = paramb;
    a locala = this.kWK;
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
    p.k(paramb, "blurBgProvider");
    this.kWT = paramb;
    a locala = this.kWK;
    if (locala != null)
    {
      locala.j(paramb);
      AppMethodBeat.o(93804);
      return;
    }
    AppMethodBeat.o(93804);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93779);
      Log.i(f.a(this.kXz), "delay check frameDraw: " + f.m(this.kXz));
      if (!f.m(this.kXz))
      {
        Log.e(f.a(this.kXz), "after " + f.aVc() + " ms, first frame stil not draw!!!");
        com.tencent.mm.media.k.f localf = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXx();
      }
      AppMethodBeat.o(93779);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93780);
      Log.i(f.a(this.kXz), "decode end after " + f.aVd() + ", isFinishEncode:" + f.J(this.kXz));
      if (!f.J(this.kXz))
      {
        com.tencent.mm.media.k.f localf = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXA();
        f.K(this.kXz);
      }
      AppMethodBeat.o(93780);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    f(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    g(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    i(f paramf, com.tencent.mm.media.j.c paramc)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x>
    {
      a(f.i parami)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(f.i parami)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, x>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "plugin-mediaeditor_release"})
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
      Log.e(f.a(this.kXz), "remux error! handing one frame time out ,isInvokeEndCallback:" + f.I(this.kXz));
      f localf;
      if (!f.I(this.kXz))
      {
        localf = this.kXz;
        if (f.c(this.kXz)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.f
 * JD-Core Version:    0.7.0.1
 */