package com.tencent.mm.media.h;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.g.a.q;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.nio.ByteBuffer;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "videoWidth", "videoHeight", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIIIJJZZIIZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "blurBgProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getFinishCallback", "()Lkotlin/jvm/functions/Function1;", "setFinishCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstFrameDraw", "getForceLandscape", "setForceLandscape", "frameHandingTime", "frameTimeoutMs", "initFinish", "inputHeight", "getInputHeight", "()I", "setInputHeight", "(I)V", "inputWidth", "getInputWidth", "setInputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "setMixType", "musicExtractorWrapper", "getOutputAudioBitrate", "setOutputAudioBitrate", "getOutputAudioChannelCount", "setOutputAudioChannelCount", "getOutputAudioSampleRate", "setOutputAudioSampleRate", "getOutputBitrate", "setOutputBitrate", "getOutputFilePath", "getOutputFps", "setOutputFps", "getOutputHeight", "setOutputHeight", "getOutputWidth", "setOutputWidth", "getProgressListener", "setProgressListener", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "timeoutInvoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1;", "useRequestDraw", "getUseSoftEncode", "setUseSoftEncode", "vfrThreshold", "videoDuration", "videoFps", "getVideoHeight", "getVideoMinQP", "setVideoMinQP", "videoMixHandlerThread", "videoRotate", "getVideoWidth", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "checkFrameDrawTimeout", "checkVideoHasBFrame", "afterCheck", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "onDecoderEncoderFailed", "isDecoder", "isEncoder", "remux", "remuxImpl", "renderer", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "startRemux", "Companion", "plugin-mediaeditor_release"})
public class f
  extends d
  implements c
{
  public static final f.a gUA;
  private static final long gUy = 1000L;
  private static final long gUz = 1000L;
  private final String TAG;
  private String filePath;
  private int gNB;
  private int gNK;
  private volatile boolean gNu;
  private final int gOn;
  private com.tencent.mm.media.e.a gOy;
  private volatile boolean gRb;
  private d.g.a.b<? super Long, Bitmap> gSX;
  private Bitmap gSY;
  protected int gTG;
  protected int gTH;
  private int gTI;
  private long gTJ;
  private com.tencent.mm.media.d.b gTK;
  private com.tencent.mm.media.d.g gTL;
  private com.tencent.mm.media.a.a gTM;
  private a gTN;
  private i gTO;
  private com.tencent.mm.media.e.a gTP;
  private com.tencent.mm.media.e.a gTQ;
  private HandlerThread gTR;
  private HandlerThread gTS;
  private boolean gTT;
  private boolean gTU;
  private g gTV;
  private d.g.a.b<? super Long, Bitmap> gTW;
  private long gTX;
  private final com.tencent.mm.media.j.a gTY;
  private volatile boolean gTZ;
  private com.tencent.mm.media.c.f gTw;
  private boolean gUa;
  private boolean gUb;
  private int gUc;
  private int gUd;
  private long gUe;
  private final int gUf;
  private volatile boolean gUg;
  private volatile boolean gUh;
  private final n gUi;
  private final Runnable gUj;
  private final String gUk;
  protected Rect gUl;
  private int gUm;
  private int gUn;
  private int gUo;
  private int gUp;
  int gUq;
  protected boolean gUr;
  private boolean gUs;
  private int gUt;
  private int gUu;
  private boolean gUv;
  d.g.a.b<? super Float, y> gUw;
  private d.g.a.b<? super String, y> gUx;
  protected int grA;
  protected int grB;
  private final String outputFilePath;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  protected final int videoHeight;
  protected final int videoWidth;
  
  static
  {
    AppMethodBeat.i(93809);
    gUA = new f.a((byte)0);
    gUy = 1000L;
    gUz = 1000L;
    AppMethodBeat.o(93809);
  }
  
  public f(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt11, int paramInt12, boolean paramBoolean3, d.g.a.b<? super Float, y> paramb, d.g.a.b<? super String, y> paramb1)
  {
    AppMethodBeat.i(164114);
    this.gUk = paramString1;
    this.filePath = paramString2;
    this.gNK = paramInt1;
    this.outputFilePath = paramString3;
    this.gUl = paramRect;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    this.grA = paramInt4;
    this.grB = paramInt5;
    this.gUm = paramInt6;
    this.gUn = paramInt7;
    this.gUo = paramInt8;
    this.gUp = paramInt9;
    this.gUq = paramInt10;
    this.gUr = paramBoolean1;
    this.gUs = paramBoolean2;
    this.gUt = paramInt11;
    this.gUu = paramInt12;
    this.gUv = paramBoolean3;
    this.gUw = paramb;
    this.gUx = paramb1;
    this.TAG = "MicroMsg.MediaCodecRemuxer";
    this.videoDuration = -1;
    this.gTJ = paramLong1;
    this.remuxEndTime = -1L;
    this.gTY = new com.tencent.mm.media.j.a("remuxCost");
    this.gOn = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTE, 10);
    this.gUf = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pTF, 10000);
    this.gUi = new n(this);
    if ((bs.isNullOrNil(this.filePath)) || (!com.tencent.mm.vfs.i.eA(this.filePath)) || (bs.isNullOrNil(this.outputFilePath)) || (this.grA <= 0) || (this.grB <= 0))
    {
      ac.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.grA + ", outputHeight:" + this.grB + ", videoFps:" + this.videoFps + ", outputFps:" + this.gUq);
      paramString1 = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asG();
      paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
      AppMethodBeat.o(164114);
      throw paramString1;
    }
    paramString1 = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.np(this.gNK);
    if (com.tencent.mm.bk.e.Et(this.filePath))
    {
      ac.i(this.TAG, "remux h265 format");
      paramString1 = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.asF();
    }
    com.tencent.mm.vfs.i.aSh(com.tencent.mm.vfs.i.aSs(this.outputFilePath));
    this.gTI = SightVideoJNI.getMp4RotateVFS(this.filePath);
    if ((this.gUv) && ((this.gTI == 90) || (this.gTI == 270)))
    {
      paramInt1 = this.grA;
      this.grA = this.grB;
      this.grB = paramInt1;
    }
    paramString2 = com.tencent.mm.plugin.sight.base.e.asx(this.filePath);
    if (paramString2 != null)
    {
      this.gTG = paramString2.width;
      this.gTH = paramString2.height;
      this.videoFps = paramString2.frameRate;
      this.videoDuration = paramString2.videoDuration;
    }
    if ((this.gTG <= 0) || (this.gTH <= 0)) {}
    try
    {
      paramString1 = new com.tencent.mm.compatible.h.d();
      paramString1.setDataSource(this.filePath);
      this.gTG = bs.getInt(paramString1.extractMetadata(18), 0);
      this.gTH = bs.getInt(paramString1.extractMetadata(19), 0);
      paramString1.release();
      label621:
      if (this.videoFps <= 0)
      {
        ac.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
        paramString1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asG();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(164114);
        throw paramString1;
      }
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        ac.i(this.TAG, "MediaCodecRemuxer frameTimeoutMs is:" + this.gUf);
        if (!this.gUr) {
          break label1267;
        }
        paramString1 = new i(this.gTJ, this.remuxEndTime, this.gUm, this.grA, this.grB, this.gUr, this.gUq, this.gUs);
        label781:
        this.gTO = paramString1;
        if (this.gUp <= 0) {
          this.gUp = 1;
        }
        ac.m(this.TAG, "create MediaCodecRemuxer, filePath: " + this.filePath + ", outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.gTG + ", inputHeight: " + this.gTH + ", videoRotate: " + this.gTI + " videoFps: " + this.videoFps + " ,outputBitrate :" + this.gUm + ", outputAudioBitrate:" + this.gUn + ", outputAudioChannelCount:" + this.gUp + ", outputWidth: " + this.grA + ", outputHeight: " + this.grB + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.gUq + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.gTJ + " ,remuxEndTime: " + this.remuxEndTime + " , input bitrate:" + paramString2.videoBitrate + ", enableHevc:" + this.gUs, new Object[0]);
        this.gOy = new com.tencent.mm.media.e.a(this.filePath);
        if (this.gOy.gRM)
        {
          paramString1 = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.asH();
        }
        paramInt1 = this.grA - this.gTG;
        if ((1 <= paramInt1) && (16 > paramInt1)) {
          break label1300;
        }
        paramInt1 = this.grB - this.gTH;
        if (1 <= paramInt1) {
          break label1294;
        }
        label1132:
        paramBoolean1 = false;
        label1135:
        ac.i(this.TAG, "needCheckCropRect:".concat(String.valueOf(paramBoolean1)));
        ac.i(this.TAG, "startRemux, useSoftEncode:" + this.gUr + ", enablHevc:" + this.gUs);
        if (this.gUs)
        {
          if (!this.gUr) {
            break label1306;
          }
          paramString1 = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.atj();
        }
      }
      for (;;)
      {
        if (this.gUr)
        {
          paramString1 = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.ati();
        }
        a(ard());
        this.gUj = ((Runnable)new c(this));
        AppMethodBeat.o(164114);
        return;
        this.remuxEndTime = paramLong2;
        break;
        label1267:
        paramString1 = new i(this.gTJ, this.remuxEndTime, this.gUm, this.gUr);
        break label781;
        label1294:
        if (16 <= paramInt1) {
          break label1132;
        }
        label1300:
        paramBoolean1 = true;
        break label1135;
        label1306:
        paramString1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.atk();
      }
    }
    catch (Exception paramString1)
    {
      break label621;
    }
  }
  
  /* Error */
  private final void a(final com.tencent.mm.media.i.c paramc)
  {
    // Byte code:
    //   0: ldc_w 831
    //   3: invokestatic 308	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 351	com/tencent/mm/media/h/f:filePath	Ljava/lang/String;
    //   10: astore 9
    //   12: getstatic 837	com/tencent/mm/media/h/j:gVb	Lcom/tencent/mm/media/h/j$a;
    //   15: astore 10
    //   17: aload 9
    //   19: invokestatic 842	com/tencent/mm/media/h/j$a:vp	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: ifnonnull +719 -> 745
    //   29: aload_0
    //   30: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   33: ldc_w 844
    //   36: invokestatic 482	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 837	com/tencent/mm/media/h/j:gVb	Lcom/tencent/mm/media/h/j$a;
    //   42: astore 9
    //   44: aload_0
    //   45: new 636	com/tencent/mm/media/e/a
    //   48: dup
    //   49: aload_0
    //   50: getfield 351	com/tencent/mm/media/h/f:filePath	Ljava/lang/String;
    //   53: invokestatic 842	com/tencent/mm/media/h/j$a:vp	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 637	com/tencent/mm/media/e/a:<init>	(Ljava/lang/String;)V
    //   59: putfield 707	com/tencent/mm/media/h/f:gTQ	Lcom/tencent/mm/media/e/a;
    //   62: aload_0
    //   63: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   66: astore 9
    //   68: new 451	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 846
    //   75: invokespecial 454	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: astore 10
    //   80: getstatic 837	com/tencent/mm/media/h/j:gVb	Lcom/tencent/mm/media/h/j$a;
    //   83: astore 11
    //   85: aload 10
    //   87: aload_0
    //   88: getfield 351	com/tencent/mm/media/h/f:filePath	Ljava/lang/String;
    //   91: invokestatic 842	com/tencent/mm/media/h/j$a:vp	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 848
    //   100: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: astore 10
    //   105: getstatic 837	com/tencent/mm/media/h/j:gVb	Lcom/tencent/mm/media/h/j$a;
    //   108: astore 11
    //   110: aload 9
    //   112: aload 10
    //   114: aload_0
    //   115: getfield 351	com/tencent/mm/media/h/f:filePath	Ljava/lang/String;
    //   118: invokestatic 851	com/tencent/mm/media/h/j$a:vo	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 510	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 707	com/tencent/mm/media/h/f:gTQ	Lcom/tencent/mm/media/e/a;
    //   134: astore 9
    //   136: aload 9
    //   138: ifnull +89 -> 227
    //   141: aload_0
    //   142: new 853	com/tencent/mm/media/h/g
    //   145: dup
    //   146: aload_0
    //   147: getfield 578	com/tencent/mm/media/h/f:gTO	Lcom/tencent/mm/media/h/i;
    //   150: aload 9
    //   152: aload_0
    //   153: getfield 355	com/tencent/mm/media/h/f:outputFilePath	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 353	com/tencent/mm/media/h/f:gNK	I
    //   160: aload_0
    //   161: getfield 371	com/tencent/mm/media/h/f:gUo	I
    //   164: invokespecial 856	com/tencent/mm/media/h/g:<init>	(Lcom/tencent/mm/media/h/i;Lcom/tencent/mm/media/e/a;Ljava/lang/String;II)V
    //   167: putfield 858	com/tencent/mm/media/h/f:gTV	Lcom/tencent/mm/media/h/g;
    //   170: aload_0
    //   171: getfield 349	com/tencent/mm/media/h/f:gUk	Ljava/lang/String;
    //   174: invokestatic 449	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   177: ifeq +50 -> 227
    //   180: aload_0
    //   181: getfield 349	com/tencent/mm/media/h/f:gUk	Ljava/lang/String;
    //   184: astore 9
    //   186: aload 9
    //   188: ifnonnull +6 -> 194
    //   191: invokestatic 760	d/g/b/k:fOy	()V
    //   194: new 636	com/tencent/mm/media/e/a
    //   197: dup
    //   198: aload 9
    //   200: invokespecial 637	com/tencent/mm/media/e/a:<init>	(Ljava/lang/String;)V
    //   203: astore 9
    //   205: aload 9
    //   207: getfield 642	com/tencent/mm/media/e/a:gRM	Z
    //   210: ifeq +11 -> 221
    //   213: getstatic 488	com/tencent/mm/media/j/d:gWO	Lcom/tencent/mm/media/j/d;
    //   216: astore 10
    //   218: invokestatic 861	com/tencent/mm/media/j/d:asJ	()V
    //   221: aload_0
    //   222: aload 9
    //   224: putfield 701	com/tencent/mm/media/h/f:gTP	Lcom/tencent/mm/media/e/a;
    //   227: aload_0
    //   228: getfield 858	com/tencent/mm/media/h/f:gTV	Lcom/tencent/mm/media/h/g;
    //   231: astore 9
    //   233: aload 9
    //   235: ifnull +12 -> 247
    //   238: aload 9
    //   240: aload_0
    //   241: getfield 528	com/tencent/mm/media/h/f:gTI	I
    //   244: putfield 862	com/tencent/mm/media/h/g:gTI	I
    //   247: aload_0
    //   248: invokespecial 866	com/tencent/mm/media/h/f:are	()Lcom/tencent/mm/media/b/d;
    //   251: astore 10
    //   253: new 40	com/tencent/mm/media/h/f$j
    //   256: dup
    //   257: aload_0
    //   258: invokespecial 867	com/tencent/mm/media/h/f$j:<init>	(Lcom/tencent/mm/media/h/f;)V
    //   261: checkcast 869	d/g/a/m
    //   264: astore 9
    //   266: new 42	com/tencent/mm/media/h/f$k
    //   269: dup
    //   270: aload_0
    //   271: invokespecial 870	com/tencent/mm/media/h/f$k:<init>	(Lcom/tencent/mm/media/h/f;)V
    //   274: checkcast 782	d/g/a/a
    //   277: astore 11
    //   279: aload_0
    //   280: getfield 377	com/tencent/mm/media/h/f:gUr	Z
    //   283: ifeq +560 -> 843
    //   286: aload_0
    //   287: new 872	com/tencent/mm/media/d/g
    //   290: dup
    //   291: aload_0
    //   292: getfield 578	com/tencent/mm/media/h/f:gTO	Lcom/tencent/mm/media/h/i;
    //   295: getfield 742	com/tencent/mm/media/h/i:gNJ	I
    //   298: aload 10
    //   300: getfield 877	com/tencent/mm/media/b/d:gNU	I
    //   303: aload 10
    //   305: getfield 880	com/tencent/mm/media/b/d:gNV	I
    //   308: invokespecial 883	com/tencent/mm/media/d/g:<init>	(III)V
    //   311: putfield 885	com/tencent/mm/media/h/f:gTL	Lcom/tencent/mm/media/d/g;
    //   314: aload_0
    //   315: getfield 885	com/tencent/mm/media/h/f:gTL	Lcom/tencent/mm/media/d/g;
    //   318: astore 9
    //   320: aload 9
    //   322: ifnull +8 -> 330
    //   325: aload 9
    //   327: invokevirtual 888	com/tencent/mm/media/d/g:start	()V
    //   330: aload_0
    //   331: new 890	com/tencent/mm/media/h/a
    //   334: dup
    //   335: aload_1
    //   336: checkcast 892	com/tencent/mm/media/i/a
    //   339: invokespecial 895	com/tencent/mm/media/h/a:<init>	(Lcom/tencent/mm/media/i/a;)V
    //   342: putfield 897	com/tencent/mm/media/h/f:gTN	Lcom/tencent/mm/media/h/a;
    //   345: aload_0
    //   346: getfield 897	com/tencent/mm/media/h/f:gTN	Lcom/tencent/mm/media/h/a;
    //   349: astore 9
    //   351: aload 9
    //   353: ifnull +45 -> 398
    //   356: aload 9
    //   358: ldc_w 898
    //   361: aload_0
    //   362: getfield 471	com/tencent/mm/media/h/f:videoFps	I
    //   365: idiv
    //   366: putfield 901	com/tencent/mm/media/h/a:gTe	I
    //   369: aload 9
    //   371: getfield 902	com/tencent/mm/media/h/a:TAG	Ljava/lang/String;
    //   374: new 451	java/lang/StringBuilder
    //   377: dup
    //   378: ldc_w 904
    //   381: invokespecial 454	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload 9
    //   386: getfield 901	com/tencent/mm/media/h/a:gTe	I
    //   389: invokevirtual 465	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   392: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 510	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_0
    //   399: getfield 906	com/tencent/mm/media/h/f:gSX	Ld/g/a/b;
    //   402: ifnull +23 -> 425
    //   405: aload_0
    //   406: getfield 897	com/tencent/mm/media/h/f:gTN	Lcom/tencent/mm/media/h/a;
    //   409: astore 9
    //   411: aload 9
    //   413: ifnull +12 -> 425
    //   416: aload 9
    //   418: aload_0
    //   419: getfield 906	com/tencent/mm/media/h/f:gSX	Ld/g/a/b;
    //   422: invokevirtual 909	com/tencent/mm/media/h/a:h	(Ld/g/a/b;)V
    //   425: aload_0
    //   426: getfield 911	com/tencent/mm/media/h/f:gTW	Ld/g/a/b;
    //   429: ifnull +23 -> 452
    //   432: aload_0
    //   433: getfield 897	com/tencent/mm/media/h/f:gTN	Lcom/tencent/mm/media/h/a;
    //   436: astore 9
    //   438: aload 9
    //   440: ifnull +12 -> 452
    //   443: aload 9
    //   445: aload_0
    //   446: getfield 911	com/tencent/mm/media/h/f:gTW	Ld/g/a/b;
    //   449: invokevirtual 913	com/tencent/mm/media/h/a:i	(Ld/g/a/b;)V
    //   452: aload_0
    //   453: getfield 897	com/tencent/mm/media/h/f:gTN	Lcom/tencent/mm/media/h/a;
    //   456: astore 9
    //   458: aload 9
    //   460: ifnull +22 -> 482
    //   463: aload 9
    //   465: new 22	com/tencent/mm/media/h/f$h
    //   468: dup
    //   469: aload_0
    //   470: aload_1
    //   471: aload 10
    //   473: invokespecial 916	com/tencent/mm/media/h/f$h:<init>	(Lcom/tencent/mm/media/h/f;Lcom/tencent/mm/media/i/c;Lcom/tencent/mm/media/b/d;)V
    //   476: checkcast 918	d/g/a/b
    //   479: putfield 921	com/tencent/mm/media/h/a:gST	Ld/g/a/b;
    //   482: ldc_w 410
    //   485: invokestatic 416	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   488: checkcast 410	com/tencent/mm/plugin/expt/a/b
    //   491: getstatic 924	com/tencent/mm/plugin/expt/a/b$a:pTB	Lcom/tencent/mm/plugin/expt/a/b$a;
    //   494: iconst_0
    //   495: invokeinterface 426 3 0
    //   500: ifne +495 -> 995
    //   503: iconst_1
    //   504: istore 4
    //   506: aload_0
    //   507: iload 4
    //   509: putfield 926	com/tencent/mm/media/h/f:gUh	Z
    //   512: invokestatic 931	com/tencent/mm/sdk/platformtools/bt:eWo	()Z
    //   515: ifeq +18 -> 533
    //   518: aload_0
    //   519: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   522: ldc_w 933
    //   525: invokestatic 510	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_0
    //   529: iconst_0
    //   530: putfield 926	com/tencent/mm/media/h/f:gUh	Z
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
    //   552: getfield 351	com/tencent/mm/media/h/f:filePath	Ljava/lang/String;
    //   555: aload_1
    //   556: aload_0
    //   557: getfield 428	com/tencent/mm/media/h/f:gOn	I
    //   560: invokestatic 938	com/tencent/mm/media/j/b:a	(Ljava/lang/String;[DI)Ljava/util/List;
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
    //   581: getfield 428	com/tencent/mm/media/h/f:gOn	I
    //   584: i2d
    //   585: dcmpl
    //   586: iflt +65 -> 651
    //   589: aload_0
    //   590: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   593: new 451	java/lang/StringBuilder
    //   596: dup
    //   597: ldc_w 940
    //   600: invokespecial 454	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   603: aload_1
    //   604: iconst_0
    //   605: daload
    //   606: invokevirtual 943	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   609: ldc_w 945
    //   612: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_1
    //   616: iconst_1
    //   617: daload
    //   618: invokevirtual 943	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   621: ldc_w 947
    //   624: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload_0
    //   628: getfield 428	com/tencent/mm/media/h/f:gOn	I
    //   631: invokevirtual 465	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: ldc_w 949
    //   637: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 510	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_0
    //   647: iconst_1
    //   648: putfield 926	com/tencent/mm/media/h/f:gUh	Z
    //   651: aload_0
    //   652: getfield 951	com/tencent/mm/media/h/f:gTK	Lcom/tencent/mm/media/d/b;
    //   655: ifnull +363 -> 1018
    //   658: aload_0
    //   659: getfield 951	com/tencent/mm/media/h/f:gTK	Lcom/tencent/mm/media/d/b;
    //   662: astore_1
    //   663: aload_1
    //   664: ifnull +354 -> 1018
    //   667: aload_1
    //   668: invokevirtual 957	com/tencent/mm/media/d/b:getInputSurface	()Landroid/view/Surface;
    //   671: astore_1
    //   672: aload_0
    //   673: getfield 897	com/tencent/mm/media/h/f:gTN	Lcom/tencent/mm/media/h/a;
    //   676: astore 9
    //   678: aload 9
    //   680: ifnull +359 -> 1039
    //   683: aload_0
    //   684: getfield 926	com/tencent/mm/media/h/f:gUh	Z
    //   687: ifne +336 -> 1023
    //   690: iconst_1
    //   691: istore 4
    //   693: aload_0
    //   694: getfield 377	com/tencent/mm/media/h/f:gUr	Z
    //   697: ifeq +332 -> 1029
    //   700: aload_0
    //   701: getfield 363	com/tencent/mm/media/h/f:grA	I
    //   704: istore_2
    //   705: aload_0
    //   706: getfield 377	com/tencent/mm/media/h/f:gUr	Z
    //   709: ifeq +325 -> 1034
    //   712: aload_0
    //   713: getfield 365	com/tencent/mm/media/h/f:grB	I
    //   716: istore_3
    //   717: aload 9
    //   719: aload_1
    //   720: iload 4
    //   722: iload_2
    //   723: iload_3
    //   724: new 24	com/tencent/mm/media/h/f$i
    //   727: dup
    //   728: aload_0
    //   729: invokespecial 958	com/tencent/mm/media/h/f$i:<init>	(Lcom/tencent/mm/media/h/f;)V
    //   732: checkcast 918	d/g/a/b
    //   735: invokevirtual 961	com/tencent/mm/media/h/a:a	(Landroid/view/Surface;ZIILd/g/a/b;)V
    //   738: ldc_w 831
    //   741: invokestatic 321	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   744: return
    //   745: aload 10
    //   747: invokestatic 449	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   750: ifeq +9 -> 759
    //   753: aload 10
    //   755: invokestatic 964	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   758: pop
    //   759: aload_0
    //   760: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   763: ldc_w 966
    //   766: iconst_2
    //   767: anewarray 630	java/lang/Object
    //   770: dup
    //   771: iconst_0
    //   772: aload 9
    //   774: aastore
    //   775: dup
    //   776: iconst_1
    //   777: aload 10
    //   779: aastore
    //   780: invokestatic 968	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   783: invokestatic 737	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   786: lstore 5
    //   788: aload 9
    //   790: aload 10
    //   792: invokestatic 972	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   795: lstore 7
    //   797: aload_0
    //   798: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   801: new 451	java/lang/StringBuilder
    //   804: dup
    //   805: ldc_w 974
    //   808: invokespecial 454	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   811: lload 5
    //   813: invokestatic 978	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   816: invokevirtual 608	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   819: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokestatic 510	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: lload 7
    //   827: lconst_0
    //   828: lcmp
    //   829: ifgt -790 -> 39
    //   832: getstatic 488	com/tencent/mm/media/j/d:gWO	Lcom/tencent/mm/media/j/d;
    //   835: astore 9
    //   837: invokestatic 981	com/tencent/mm/media/j/d:asI	()V
    //   840: goto -801 -> 39
    //   843: bipush 23
    //   845: invokestatic 987	com/tencent/mm/compatible/util/d:kZ	(I)Z
    //   848: ifeq +116 -> 964
    //   851: new 989	com/tencent/mm/media/d/f
    //   854: dup
    //   855: aload 10
    //   857: new 18	com/tencent/mm/media/h/f$f
    //   860: dup
    //   861: aload 9
    //   863: aload 11
    //   865: invokespecial 992	com/tencent/mm/media/h/f$f:<init>	(Ld/g/a/m;Ld/g/a/a;)V
    //   868: checkcast 918	d/g/a/b
    //   871: invokespecial 995	com/tencent/mm/media/d/f:<init>	(Lcom/tencent/mm/media/b/d;Ld/g/a/b;)V
    //   874: checkcast 953	com/tencent/mm/media/d/b
    //   877: astore 9
    //   879: aload_0
    //   880: aload 9
    //   882: putfield 951	com/tencent/mm/media/h/f:gTK	Lcom/tencent/mm/media/d/b;
    //   885: goto -555 -> 330
    //   888: astore_1
    //   889: aload_0
    //   890: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   893: aload_1
    //   894: checkcast 498	java/lang/Throwable
    //   897: ldc_w 997
    //   900: iconst_0
    //   901: anewarray 630	java/lang/Object
    //   904: invokestatic 795	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   907: getstatic 488	com/tencent/mm/media/j/d:gWO	Lcom/tencent/mm/media/j/d;
    //   910: astore_1
    //   911: invokestatic 1000	com/tencent/mm/media/j/d:asK	()V
    //   914: invokestatic 1006	com/tencent/mm/sdk/platformtools/aw:eVz	()Lcom/tencent/mm/sdk/platformtools/aw;
    //   917: ldc_w 1008
    //   920: iconst_1
    //   921: invokevirtual 1012	com/tencent/mm/sdk/platformtools/aw:putBoolean	(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   924: pop
    //   925: aload_0
    //   926: iconst_0
    //   927: iconst_1
    //   928: invokespecial 830	com/tencent/mm/media/h/f:l	(ZZ)V
    //   931: ldc_w 831
    //   934: invokestatic 321	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   937: return
    //   938: astore_1
    //   939: aload_0
    //   940: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   943: aload_1
    //   944: checkcast 498	java/lang/Throwable
    //   947: ldc_w 1014
    //   950: iconst_0
    //   951: anewarray 630	java/lang/Object
    //   954: invokestatic 795	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   957: ldc_w 831
    //   960: invokestatic 321	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   963: return
    //   964: new 1016	com/tencent/mm/media/d/e
    //   967: dup
    //   968: aload 10
    //   970: new 20	com/tencent/mm/media/h/f$g
    //   973: dup
    //   974: aload 9
    //   976: aload 11
    //   978: invokespecial 1017	com/tencent/mm/media/h/f$g:<init>	(Ld/g/a/m;Ld/g/a/a;)V
    //   981: checkcast 918	d/g/a/b
    //   984: invokespecial 1018	com/tencent/mm/media/d/e:<init>	(Lcom/tencent/mm/media/b/d;Ld/g/a/b;)V
    //   987: checkcast 953	com/tencent/mm/media/d/b
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
    //   1039: ldc_w 831
    //   1042: invokestatic 321	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	1070	1	paramc	com.tencent.mm.media.i.c
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
  
  private final void aqE()
  {
    AppMethodBeat.i(93805);
    ac.i(this.TAG, "finishEncode");
    Object localObject;
    if (this.gUr)
    {
      localObject = this.gTL;
      if (localObject != null) {
        com.tencent.mm.media.d.g.a((com.tencent.mm.media.d.g)localObject);
      }
      ec(true);
    }
    for (;;)
    {
      ap.aB(this.gUj);
      this.gRb = true;
      AppMethodBeat.o(93805);
      return;
      localObject = this.gTK;
      if (localObject != null) {
        ((com.tencent.mm.media.d.b)localObject).aqE();
      }
    }
  }
  
  private final com.tencent.mm.media.b.d are()
  {
    AppMethodBeat.i(93800);
    if (this.gUq > 0) {}
    com.tencent.mm.media.b.d locald;
    for (int i = Math.min(this.gUq, this.videoFps);; i = this.videoFps)
    {
      locald = new com.tencent.mm.media.b.d(this.gUs);
      locald.bitrate = this.gUm;
      locald.frameRate = i;
      locald.gNV = this.grB;
      locald.gNU = this.grA;
      locald.gOb = this.gUt;
      locald.gOc = this.gUu;
      while (locald.frameRate * locald.gNX - 1 <= 1)
      {
        locald.frameRate += 1;
        ac.e(this.TAG, "encodeConfig.frameRate + 1");
      }
    }
    ac.i(this.TAG, "steve: hardcoder qp:" + this.gUt + ", " + this.gUu);
    AppMethodBeat.o(93800);
    return locald;
  }
  
  /* Error */
  private final void ec(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1067
    //   5: invokestatic 308	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   12: new 451	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1069
    //   19: invokespecial 454	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: iload_1
    //   23: invokevirtual 628	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 1071
    //   29: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 1073	com/tencent/mm/media/h/f:gUb	Z
    //   36: invokevirtual 628	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 1075
    //   42: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 1077	com/tencent/mm/media/h/f:gUa	Z
    //   49: invokevirtual 628	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1079
    //   55: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 806	com/tencent/mm/media/h/f:gTZ	Z
    //   62: invokevirtual 628	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 510	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload_1
    //   72: ifeq +348 -> 420
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 1077	com/tencent/mm/media/h/f:gUa	Z
    //   80: aload_0
    //   81: getfield 1073	com/tencent/mm/media/h/f:gUb	Z
    //   84: ifeq +353 -> 437
    //   87: aload_0
    //   88: getfield 1077	com/tencent/mm/media/h/f:gUa	Z
    //   91: ifeq +346 -> 437
    //   94: aload_0
    //   95: getfield 806	com/tencent/mm/media/h/f:gTZ	Z
    //   98: ifne +339 -> 437
    //   101: aload_0
    //   102: getfield 897	com/tencent/mm/media/h/f:gTN	Lcom/tencent/mm/media/h/a;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 1080	com/tencent/mm/media/h/a:release	()V
    //   117: aload_0
    //   118: getfield 408	com/tencent/mm/media/h/f:gTY	Lcom/tencent/mm/media/j/a;
    //   121: invokevirtual 1083	com/tencent/mm/media/j/a:aic	()V
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 806	com/tencent/mm/media/h/f:gTZ	Z
    //   129: getstatic 837	com/tencent/mm/media/h/j:gVb	Lcom/tencent/mm/media/h/j$a;
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 351	com/tencent/mm/media/h/f:filePath	Ljava/lang/String;
    //   138: invokestatic 851	com/tencent/mm/media/h/j$a:vo	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 964	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   144: pop
    //   145: getstatic 837	com/tencent/mm/media/h/j:gVb	Lcom/tencent/mm/media/h/j$a;
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 351	com/tencent/mm/media/h/f:filePath	Ljava/lang/String;
    //   154: invokestatic 842	com/tencent/mm/media/h/j$a:vp	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 964	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 438	com/tencent/mm/media/h/f:gUi	Lcom/tencent/mm/media/h/f$n;
    //   165: invokevirtual 1086	com/tencent/mm/media/h/f$n:cancel	()Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 639	com/tencent/mm/media/h/f:gOy	Lcom/tencent/mm/media/e/a;
    //   173: invokevirtual 1087	com/tencent/mm/media/e/a:release	()V
    //   176: aload_0
    //   177: getfield 707	com/tencent/mm/media/h/f:gTQ	Lcom/tencent/mm/media/e/a;
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 1087	com/tencent/mm/media/e/a:release	()V
    //   192: aload_0
    //   193: getfield 858	com/tencent/mm/media/h/f:gTV	Lcom/tencent/mm/media/h/g;
    //   196: astore 4
    //   198: aload 4
    //   200: ifnull +27 -> 227
    //   203: aload 4
    //   205: getfield 1090	com/tencent/mm/media/h/g:gUS	Ld/g/a/b;
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull +15 -> 227
    //   215: aload 4
    //   217: aload_0
    //   218: getfield 389	com/tencent/mm/media/h/f:gUx	Ld/g/a/b;
    //   221: invokeinterface 1094 2 0
    //   226: pop
    //   227: aload_0
    //   228: getfield 1096	com/tencent/mm/media/h/f:gTR	Landroid/os/HandlerThread;
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +9 -> 244
    //   238: aload 4
    //   240: invokevirtual 1101	android/os/HandlerThread:quit	()Z
    //   243: pop
    //   244: aload_0
    //   245: getfield 1103	com/tencent/mm/media/h/f:gTS	Landroid/os/HandlerThread;
    //   248: astore 4
    //   250: aload 4
    //   252: ifnull +9 -> 261
    //   255: aload 4
    //   257: invokevirtual 1101	android/os/HandlerThread:quit	()Z
    //   260: pop
    //   261: aload_0
    //   262: getfield 1105	com/tencent/mm/media/h/f:gTX	J
    //   265: invokestatic 978	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   268: lstore_2
    //   269: aload_0
    //   270: getfield 393	com/tencent/mm/media/h/f:TAG	Ljava/lang/String;
    //   273: new 451	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1107
    //   280: invokespecial 454	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: lload_2
    //   284: invokevirtual 608	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: ldc_w 1109
    //   290: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 1063	com/tencent/mm/media/h/f:gUc	I
    //   297: invokevirtual 465	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 1111
    //   303: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: getfield 817	com/tencent/mm/media/h/f:gNB	I
    //   310: invokevirtual 465	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 1113
    //   316: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 1061	com/tencent/mm/media/h/f:gUd	I
    //   323: invokevirtual 465	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: invokevirtual 476	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 510	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: aload_0
    //   333: getfield 355	com/tencent/mm/media/h/f:outputFilePath	Ljava/lang/String;
    //   336: invokestatic 534	com/tencent/mm/plugin/sight/base/e:asx	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   339: astore 4
    //   341: aload 4
    //   343: ifnull +94 -> 437
    //   346: getstatic 488	com/tencent/mm/media/j/d:gWO	Lcom/tencent/mm/media/j/d;
    //   349: astore 5
    //   351: aload_0
    //   352: getfield 353	com/tencent/mm/media/h/f:gNK	I
    //   355: lload_2
    //   356: invokestatic 1117	com/tencent/mm/media/j/d:w	(IJ)V
    //   359: getstatic 488	com/tencent/mm/media/j/d:gWO	Lcom/tencent/mm/media/j/d;
    //   362: astore 5
    //   364: aload 4
    //   366: getfield 623	com/tencent/mm/plugin/sight/base/a:videoBitrate	I
    //   369: i2l
    //   370: aload 4
    //   372: getfield 549	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   375: i2l
    //   376: aload_0
    //   377: getfield 471	com/tencent/mm/media/h/f:videoFps	I
    //   380: i2l
    //   381: invokestatic 1121	com/tencent/mm/media/j/d:f	(JJJ)V
    //   384: aload_0
    //   385: getfield 1063	com/tencent/mm/media/h/f:gUc	I
    //   388: i2f
    //   389: aload_0
    //   390: getfield 817	com/tencent/mm/media/h/f:gNB	I
    //   393: i2f
    //   394: fdiv
    //   395: f2d
    //   396: ldc2_w 1122
    //   399: dcmpl
    //   400: iflt +37 -> 437
    //   403: getstatic 488	com/tencent/mm/media/j/d:gWO	Lcom/tencent/mm/media/j/d;
    //   406: astore 4
    //   408: invokestatic 1126	com/tencent/mm/media/j/d:asT	()V
    //   411: ldc_w 1067
    //   414: invokestatic 321	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: aload_0
    //   418: monitorexit
    //   419: return
    //   420: aload_0
    //   421: iconst_1
    //   422: putfield 1073	com/tencent/mm/media/h/f:gUb	Z
    //   425: goto -345 -> 80
    //   428: astore 4
    //   430: aload_0
    //   431: monitorexit
    //   432: aload 4
    //   434: athrow
    //   435: astore 4
    //   437: ldc_w 1067
    //   440: invokestatic 321	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   349	14	5	locald	com.tencent.mm.media.j.d
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
        ac.i(this.TAG, "onDecoderEncoderFailed, isDecoder:" + paramBoolean1 + " isEncoder:" + paramBoolean2);
        this.gUi.cancel();
        Object localObject1;
        if (paramBoolean1)
        {
          localObject1 = this.gTw;
          if (localObject1 != null) {
            ((com.tencent.mm.media.c.f)localObject1).releaseDecoder();
          }
          this.gTw = null;
        }
        if (paramBoolean2)
        {
          localObject1 = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.asw();
          localObject1 = this.gTK;
          if (localObject1 != null) {
            ((com.tencent.mm.media.d.b)localObject1).aqF();
          }
          this.gTK = null;
        }
        if (!this.gTZ)
        {
          localObject1 = this.gTN;
          if (localObject1 != null) {
            ((a)localObject1).release();
          }
          this.gTY.aic();
          this.gTZ = true;
          try
          {
            localObject1 = j.gVb;
            com.tencent.mm.vfs.i.deleteFile(j.a.vo(this.filePath));
            localObject1 = j.gVb;
            com.tencent.mm.vfs.i.deleteFile(j.a.vp(this.filePath));
            this.gOy.release();
            localObject1 = this.gTQ;
            if (localObject1 != null) {
              ((com.tencent.mm.media.e.a)localObject1).release();
            }
            localObject1 = this.gTR;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.gTS;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            com.tencent.mm.vfs.i.deleteFile(this.outputFilePath);
            long l = bs.aO(this.gTX);
            ac.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.gUx;
          if (localObject1 != null)
          {
            ((d.g.a.b)localObject1).ay(null);
            AppMethodBeat.o(177316);
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(177316);
    }
  }
  
  public final int arc()
  {
    AppMethodBeat.i(93803);
    ac.i(this.TAG, "start remux, initFinish:" + this.gTT);
    this.gTX = bs.Gn();
    if ((this.gSY != null) && (this.gTI > 0)) {
      this.gSY = com.tencent.mm.sdk.platformtools.f.a(this.gSY, -this.gTI);
    }
    this.gTY.gma.reset();
    if (this.gTT)
    {
      HandlerThread localHandlerThread = this.gTR;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      this.gTR = com.tencent.mm.ac.c.a("MediaCodecRemux_audioMix", false, (d.g.a.a)new d(this));
      localHandlerThread = this.gTS;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      if (this.gTw != null) {
        this.gTS = com.tencent.mm.ac.c.a("MediaCodecRemux_videoMix", false, (d.g.a.a)new e(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(93803);
      return 0;
      this.gTU = true;
    }
  }
  
  public com.tencent.mm.media.i.c ard()
  {
    int i = 1;
    AppMethodBeat.i(164113);
    if ((this.gTI == 90) || (this.gTI == 270)) {
      if (this.gTH > this.gTG) {
        ac.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
    }
    while (this.gUr)
    {
      localc = new com.tencent.mm.media.i.c(this.gTG, this.gTH, this.grA, this.grB, 3, i);
      AppMethodBeat.o(164113);
      return localc;
      ac.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
      i = 2;
      continue;
      if (this.gTG > this.gTH)
      {
        ac.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
      else
      {
        ac.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
        i = 2;
      }
    }
    com.tencent.mm.media.i.c localc = new com.tencent.mm.media.i.c(this.gTG, this.gTH, this.grA, this.grB, i);
    AppMethodBeat.o(164113);
    return localc;
  }
  
  public final void j(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93802);
    k.h(paramb, "blendBitmapProvider");
    this.gSX = paramb;
    a locala = this.gTN;
    if (locala != null)
    {
      locala.h(paramb);
      AppMethodBeat.o(93802);
      return;
    }
    AppMethodBeat.o(93802);
  }
  
  public final void k(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93804);
    k.h(paramb, "blurBgProvider");
    this.gTW = paramb;
    a locala = this.gTN;
    if (locala != null)
    {
      locala.i(paramb);
      AppMethodBeat.o(93804);
      return;
    }
    AppMethodBeat.o(93804);
  }
  
  public final void y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93801);
    k.h(paramBitmap, "bitmap");
    this.gSY = paramBitmap;
    a locala = this.gTN;
    if (locala != null)
    {
      String str = locala.TAG;
      StringBuilder localStringBuilder = new StringBuilder("setDrawBlendBitmap:");
      if (paramBitmap != null) {}
      for (int i = paramBitmap.hashCode();; i = 0)
      {
        ac.i(str, i);
        locala.gSY = paramBitmap;
        AppMethodBeat.o(93801);
        return;
      }
    }
    AppMethodBeat.o(93801);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93779);
      ac.i(f.a(this.gUB), "delay check frameDraw: " + f.m(this.gUB));
      if (!f.m(this.gUB))
      {
        ac.e(f.a(this.gUB), "after " + f.arf() + " ms, first frame stil not draw!!!");
        com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.ate();
      }
      AppMethodBeat.o(93779);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(93780);
      ac.i(f.a(this.gUB), "decode end after " + f.arg() + ", isFinishEncode:" + f.H(this.gUB));
      if (!f.H(this.gUB))
      {
        com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.ath();
        f.I(this.gUB);
      }
      AppMethodBeat.o(93780);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    f(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    g(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    h(f paramf, com.tencent.mm.media.i.c paramc, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "success", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    i(f paramf)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, y>
    {
      a(f.i parami)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(f.i parami)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends d.g.b.l
    implements m<ByteBuffer, MediaCodec.BufferInfo, y>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends d.g.b.l
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, y>
  {
    l(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(f paramf, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "plugin-mediaeditor_release"})
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
      ac.e(f.a(this.gUB), "remux error! handing one frame time out ,isInvokeEndCallback:" + f.G(this.gUB));
      f localf;
      if (!f.G(this.gUB))
      {
        localf = this.gUB;
        if (f.c(this.gUB)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.h.f
 * JD-Core Version:    0.7.0.1
 */