package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.g;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "filePath", "mixType", "", "outputFilePath", "cropRect", "Landroid/graphics/Rect;", "videoWidth", "videoHeight", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputAudioChannelCount", "outputFps", "startTimeMs", "", "endTimeMs", "useSoftEncode", "", "enableHevc", "videoMinQP", "videoMaxQP", "forceLandscape", "iFrame", "progressListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "finishCallback", "path", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Landroid/graphics/Rect;IIIIIIIIIJJZZIIZILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmap", "Landroid/graphics/Bitmap;", "blendBitmapProvider", "blurBgProvider", "codecSurface", "Lcom/tencent/mm/media/remuxer/CodecInputSurface;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "decodeFrameCount", "decoder", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "getEnableHevc", "()Z", "setEnableHevc", "(Z)V", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "getFinishCallback", "()Lkotlin/jvm/functions/Function1;", "setFinishCallback", "(Lkotlin/jvm/functions/Function1;)V", "firstFrameDraw", "getForceLandscape", "setForceLandscape", "frameHandingTime", "frameTimeoutMs", "getIFrame", "()I", "setIFrame", "(I)V", "initFinish", "inputHeight", "getInputHeight", "setInputHeight", "inputWidth", "getInputWidth", "setInputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mediaExtractorWrapper", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "setMixType", "musicExtractorWrapper", "getOutputAudioBitrate", "setOutputAudioBitrate", "getOutputAudioChannelCount", "setOutputAudioChannelCount", "getOutputAudioSampleRate", "setOutputAudioSampleRate", "getOutputBitrate", "setOutputBitrate", "getOutputFilePath", "getOutputFps", "setOutputFps", "getOutputHeight", "setOutputHeight", "getOutputWidth", "setOutputWidth", "getProgressListener", "setProgressListener", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "timeoutInvoke", "com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1;", "useRequestDraw", "getUseSoftEncode", "setUseSoftEncode", "vfrThreshold", "videoDuration", "videoFps", "getVideoHeight", "getVideoMinQP", "setVideoMinQP", "videoMixHandlerThread", "videoRotate", "getVideoWidth", "writeDtsCount", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransImageReaderEncoder;", "checkFinishEncode", "checkFrameDrawTimeout", "copyVideoFile", "source", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "getRenderer", "Lcom/tencent/mm/media/render/MixRenderer;", "onDecoderEncoderFailed", "isDecoder", "isEncoder", "remux", "remuxImpl", "renderer", "resizeToMultipleOfX", "value", "x", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "startRemux", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  extends c
  implements b
{
  public static final e.a nBS;
  private static final long nCI;
  private static final long nCJ;
  private Rect Gl;
  private final String TAG;
  private String filePath;
  private int inputHeight;
  private int inputWidth;
  private com.tencent.mm.media.d.f nBN;
  private final String nBT;
  private int nBU;
  private int nBV;
  private int nBW;
  private int nBX;
  int nBY;
  protected boolean nBZ;
  private kotlin.g.a.b<? super Long, Bitmap> nBp;
  private Bitmap nBq;
  private long nBy;
  private int nCA;
  private long nCB;
  private int nCC;
  private final int nCD;
  private volatile boolean nCE;
  private volatile boolean nCF;
  private final l nCG;
  private final Runnable nCH;
  private int nCa;
  private int nCb;
  private boolean nCc;
  private int nCd;
  kotlin.g.a.b<? super Float, ah> nCe;
  private kotlin.g.a.b<? super String, ah> nCf;
  private int nCg;
  private com.tencent.mm.media.e.b nCh;
  private com.tencent.mm.media.e.h nCi;
  private com.tencent.mm.media.a.a nCj;
  private a nCk;
  private h nCl;
  private com.tencent.mm.media.f.a nCm;
  private com.tencent.mm.media.f.a nCn;
  private HandlerThread nCo;
  private HandlerThread nCp;
  private boolean nCq;
  private boolean nCr;
  private f nCs;
  private kotlin.g.a.b<? super Long, Bitmap> nCt;
  private long nCu;
  private final com.tencent.mm.media.util.a nCv;
  private volatile boolean nCw;
  private boolean nCx;
  private boolean nCy;
  private int nCz;
  private int nxj;
  private volatile boolean nxq;
  private int nxx;
  boolean nyh;
  private final int nys;
  private com.tencent.mm.media.f.a nyw;
  private volatile boolean nzA;
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
    nBS = new e.a((byte)0);
    nCI = 1000L;
    nCJ = 1000L;
    AppMethodBeat.o(93809);
  }
  
  public e(String paramString1, String paramString2, int paramInt1, String paramString3, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt11, int paramInt12, boolean paramBoolean3, int paramInt13, kotlin.g.a.b<? super Float, ah> paramb, kotlin.g.a.b<? super String, ah> paramb1)
  {
    AppMethodBeat.i(237819);
    this.nBT = paramString1;
    this.filePath = paramString2;
    this.nxj = paramInt1;
    this.outputFilePath = paramString3;
    this.Gl = paramRect;
    this.videoWidth = paramInt2;
    this.videoHeight = paramInt3;
    this.outputWidth = paramInt4;
    this.outputHeight = paramInt5;
    this.nBU = paramInt6;
    this.nBV = paramInt7;
    this.nBW = paramInt8;
    this.nBX = paramInt9;
    this.nBY = paramInt10;
    this.nBZ = paramBoolean1;
    this.nyh = paramBoolean2;
    this.nCa = paramInt11;
    this.nCb = paramInt12;
    this.nCc = paramBoolean3;
    this.nCd = paramInt13;
    this.nCe = paramb;
    this.nCf = paramb1;
    this.TAG = "MicroMsg.MediaCodecRemuxer";
    this.videoDuration = -1;
    this.nBy = paramLong1;
    this.remuxEndTime = -1L;
    this.nCv = new com.tencent.mm.media.util.a("remuxCost");
    this.nys = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUX, 10);
    this.nCD = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yUZ, 60000);
    this.nCG = new l(this);
    if ((Util.isNullOrNil(this.filePath)) || (!y.ZC(this.filePath)) || (Util.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
    {
      Log.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.nBY);
      paramString1 = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brH();
      paramString1 = new IllegalArgumentException("create MediaCodecRemuxer error");
      AppMethodBeat.o(237819);
      throw paramString1;
    }
    paramString1 = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.ue(this.nxj);
    if (com.tencent.mm.be.e.Qy(this.filePath))
    {
      Log.i(this.TAG, "remux h265 format");
      paramString1 = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.brG();
    }
    y.bDX(y.bEo(this.outputFilePath));
    this.nCg = SightVideoJNI.getMp4RotateVFS(this.filePath);
    if ((this.nCc) && ((this.nCg == 90) || (this.nCg == 270)))
    {
      paramInt1 = this.outputWidth;
      this.outputWidth = this.outputHeight;
      this.outputHeight = paramInt1;
    }
    if (this.nBZ)
    {
      this.outputWidth = er(this.outputWidth, 16);
      this.outputHeight = er(this.outputHeight, 4);
      Log.i(this.TAG, "resize width to " + this.outputWidth + " height to " + this.outputHeight);
    }
    paramString2 = com.tencent.mm.plugin.sight.base.f.aVX(this.filePath);
    if (paramString2 != null)
    {
      this.inputWidth = paramString2.width;
      this.inputHeight = paramString2.height;
      this.videoFps = paramString2.frameRate;
      this.videoDuration = paramString2.videoDuration;
    }
    if ((this.inputWidth <= 0) || (this.inputHeight <= 0)) {}
    try
    {
      paramString1 = new com.tencent.mm.compatible.i.d();
      paramString1.setDataSource(this.filePath);
      this.inputWidth = Util.getInt(paramString1.extractMetadata(18), 0);
      this.inputHeight = Util.getInt(paramString1.extractMetadata(19), 0);
      paramString1.release();
      label696:
      if (this.videoFps <= 0)
      {
        Log.e(this.TAG, "create MediaCodecRemuxer error, filePath:" + this.filePath + ", get video fps error");
        paramString1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brH();
        paramString1 = new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(237819);
        throw paramString1;
      }
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        Log.i(this.TAG, s.X("MediaCodecRemuxer frameTimeoutMs is:", Integer.valueOf(this.nCD)));
        paramString1 = g.nFH;
        paramString1 = g.GU(this.filePath);
        if (!this.nBZ) {
          break label1381;
        }
        paramString1 = new h(this.nBy, this.remuxEndTime, this.nBU, this.outputWidth, this.outputHeight, this.nBZ, this.nBY, this.nyh, paramString1);
        label859:
        this.nCl = paramString1;
        if (this.nBX <= 0) {
          this.nBX = 1;
        }
        paramString1 = this.TAG;
        paramString3 = new StringBuilder();
        paramString3.append("create MediaCodecRemuxer, filePath: ").append(this.filePath).append(", outputFilePath: ").append(this.outputFilePath).append(", inputWidth: ").append(this.inputWidth).append(", inputHeight: ").append(this.inputHeight).append(", videoRotate: ").append(this.nCg).append(" videoFps: ").append(this.videoFps).append(" ,outputBitrate :").append(this.nBU).append(", outputAudioBitrate:").append(this.nBV).append(", outputAudioChannelCount:").append(this.nBX).append(", outputWidth: ").append(this.outputWidth).append(", outputHeight: ").append(this.outputHeight).append(", startTimeMs: ");
        paramString3.append(paramLong1).append(", endTimeMs: ").append(paramLong2).append(" , outputFps: ").append(this.nBY).append(" , videoDuration: ").append(this.videoDuration).append(" , remuxStartTime: ").append(this.nBy).append(" ,remuxEndTime: ").append(this.remuxEndTime).append(" , input bitrate:").append(paramString2.videoBitrate).append(", enableHevc:").append(this.nyh).append(", forceLandscape:").append(this.nCc);
        Log.printInfoStack(paramString1, paramString3.toString(), new Object[0]);
        this.nyw = new com.tencent.mm.media.f.a(this.filePath);
        if (this.nyw.hasError)
        {
          paramString1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.brI();
        }
        paramInt1 = this.outputWidth - this.inputWidth;
        if (paramInt1 <= 0) {
          break label1416;
        }
        if (paramInt1 >= 16) {
          break label1411;
        }
        paramInt1 = 1;
        label1219:
        if (paramInt1 == 0)
        {
          paramInt1 = this.outputHeight - this.inputHeight;
          if (paramInt1 <= 0) {
            break label1426;
          }
          if (paramInt1 >= 16) {
            break label1421;
          }
          paramInt1 = 1;
          label1245:
          if (paramInt1 == 0) {
            break label1431;
          }
        }
        paramBoolean1 = true;
        label1252:
        Log.i(this.TAG, s.X("needCheckCropRect:", Boolean.valueOf(paramBoolean1)));
        Log.i(this.TAG, "startRemux, useSoftEncode:" + this.nBZ + ", enablHevc:" + this.nyh);
        if (this.nyh)
        {
          if (!this.nBZ) {
            break label1437;
          }
          paramString1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.bsk();
        }
      }
      for (;;)
      {
        if (this.nBZ)
        {
          paramString1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.bsj();
        }
        a(bpH());
        this.nCH = new e..ExternalSyntheticLambda0(this);
        AppMethodBeat.o(237819);
        return;
        this.remuxEndTime = paramLong2;
        break;
        label1381:
        paramString1 = new h(this.nBy, this.remuxEndTime, this.nBU, this.nBZ, paramString1, 16);
        break label859;
        label1411:
        paramInt1 = 0;
        break label1219;
        label1416:
        paramInt1 = 0;
        break label1219;
        label1421:
        paramInt1 = 0;
        break label1245;
        label1426:
        paramInt1 = 0;
        break label1245;
        label1431:
        paramBoolean1 = false;
        break label1252;
        label1437:
        paramString1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bsl();
      }
    }
    catch (Exception paramString1)
    {
      break label696;
    }
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(237861);
    s.u(parame, "this$0");
    Log.i(parame.TAG, s.X("delay check frameDraw: ", Boolean.valueOf(parame.nCE)));
    if (!parame.nCE)
    {
      Log.e(parame.TAG, "after " + nCI + " ms, first frame stil not draw!!!");
      parame = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bsf();
    }
    AppMethodBeat.o(237861);
  }
  
  /* Error */
  private final void a(final com.tencent.mm.media.j.b paramb)
  {
    // Byte code:
    //   0: ldc_w 881
    //   3: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 367	com/tencent/mm/media/i/e:filePath	Ljava/lang/String;
    //   10: astore 9
    //   12: getstatic 887	com/tencent/mm/media/i/i:nDi	Lcom/tencent/mm/media/i/i$a;
    //   15: astore 10
    //   17: aload 9
    //   19: invokestatic 892	com/tencent/mm/media/i/i$a:GQ	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: ifnonnull +681 -> 707
    //   29: aload_0
    //   30: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   33: ldc_w 894
    //   36: invokestatic 499	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 887	com/tencent/mm/media/i/i:nDi	Lcom/tencent/mm/media/i/i$a;
    //   42: astore 9
    //   44: aload_0
    //   45: new 679	com/tencent/mm/media/f/a
    //   48: dup
    //   49: aload_0
    //   50: getfield 367	com/tencent/mm/media/i/e:filePath	Ljava/lang/String;
    //   53: invokestatic 892	com/tencent/mm/media/i/i$a:GQ	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 680	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   59: putfield 752	com/tencent/mm/media/i/e:nCn	Lcom/tencent/mm/media/f/a;
    //   62: aload_0
    //   63: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   66: astore 9
    //   68: new 468	java/lang/StringBuilder
    //   71: dup
    //   72: ldc_w 896
    //   75: invokespecial 471	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: astore 10
    //   80: getstatic 887	com/tencent/mm/media/i/i:nDi	Lcom/tencent/mm/media/i/i$a;
    //   83: astore 11
    //   85: aload 10
    //   87: aload_0
    //   88: getfield 367	com/tencent/mm/media/i/e:filePath	Ljava/lang/String;
    //   91: invokestatic 892	com/tencent/mm/media/i/i$a:GQ	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 898
    //   100: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: astore 10
    //   105: getstatic 887	com/tencent/mm/media/i/i:nDi	Lcom/tencent/mm/media/i/i$a;
    //   108: astore 11
    //   110: aload 9
    //   112: aload 10
    //   114: aload_0
    //   115: getfield 367	com/tencent/mm/media/i/e:filePath	Ljava/lang/String;
    //   118: invokestatic 901	com/tencent/mm/media/i/i$a:GP	(Ljava/lang/String;)Ljava/lang/String;
    //   121: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 752	com/tencent/mm/media/i/e:nCn	Lcom/tencent/mm/media/f/a;
    //   134: astore 9
    //   136: aload 9
    //   138: ifnull +91 -> 229
    //   141: aload_0
    //   142: new 903	com/tencent/mm/media/i/f
    //   145: dup
    //   146: aload_0
    //   147: getfield 621	com/tencent/mm/media/i/e:nCl	Lcom/tencent/mm/media/i/h;
    //   150: aload 9
    //   152: aload_0
    //   153: getfield 371	com/tencent/mm/media/i/e:outputFilePath	Ljava/lang/String;
    //   156: aload_0
    //   157: getfield 369	com/tencent/mm/media/i/e:nxj	I
    //   160: aload_0
    //   161: getfield 387	com/tencent/mm/media/i/e:nBW	I
    //   164: invokespecial 906	com/tencent/mm/media/i/f:<init>	(Lcom/tencent/mm/media/i/h;Lcom/tencent/mm/media/f/a;Ljava/lang/String;II)V
    //   167: putfield 908	com/tencent/mm/media/i/e:nCs	Lcom/tencent/mm/media/i/f;
    //   170: aload_0
    //   171: getfield 365	com/tencent/mm/media/i/e:nBT	Ljava/lang/String;
    //   174: invokestatic 466	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   177: ifeq +52 -> 229
    //   180: aload_0
    //   181: getfield 365	com/tencent/mm/media/i/e:nBT	Ljava/lang/String;
    //   184: astore 9
    //   186: aload 9
    //   188: invokestatic 797	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   191: new 679	com/tencent/mm/media/f/a
    //   194: dup
    //   195: aload 9
    //   197: invokespecial 680	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   200: astore 9
    //   202: aload 9
    //   204: getfield 685	com/tencent/mm/media/f/a:hasError	Z
    //   207: ifeq +11 -> 218
    //   210: getstatic 505	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   213: astore 10
    //   215: invokestatic 911	com/tencent/mm/media/util/f:brK	()V
    //   218: getstatic 917	kotlin/ah:aiuX	Lkotlin/ah;
    //   221: astore 10
    //   223: aload_0
    //   224: aload 9
    //   226: putfield 746	com/tencent/mm/media/i/e:nCm	Lcom/tencent/mm/media/f/a;
    //   229: aload_0
    //   230: getfield 908	com/tencent/mm/media/i/e:nCs	Lcom/tencent/mm/media/i/f;
    //   233: astore 9
    //   235: aload 9
    //   237: ifnull +12 -> 249
    //   240: aload 9
    //   242: aload_0
    //   243: getfield 543	com/tencent/mm/media/i/e:nCg	I
    //   246: putfield 918	com/tencent/mm/media/i/f:nCg	I
    //   249: aload_0
    //   250: invokespecial 922	com/tencent/mm/media/i/e:bpI	()Lcom/tencent/mm/media/b/d;
    //   253: astore 9
    //   255: new 38	com/tencent/mm/media/i/e$h
    //   258: dup
    //   259: aload_0
    //   260: invokespecial 923	com/tencent/mm/media/i/e$h:<init>	(Lcom/tencent/mm/media/i/e;)V
    //   263: checkcast 925	kotlin/g/a/m
    //   266: astore 10
    //   268: new 40	com/tencent/mm/media/i/e$i
    //   271: dup
    //   272: aload_0
    //   273: invokespecial 926	com/tencent/mm/media/i/e$i:<init>	(Lcom/tencent/mm/media/i/e;)V
    //   276: checkcast 819	kotlin/g/a/a
    //   279: astore 11
    //   281: aload_0
    //   282: getfield 393	com/tencent/mm/media/i/e:nBZ	Z
    //   285: ifeq +514 -> 799
    //   288: aload_0
    //   289: new 928	com/tencent/mm/media/e/h
    //   292: dup
    //   293: aload_0
    //   294: getfield 621	com/tencent/mm/media/i/e:nCl	Lcom/tencent/mm/media/i/h;
    //   297: getfield 782	com/tencent/mm/media/i/h:bufId	I
    //   300: aload 9
    //   302: getfield 933	com/tencent/mm/media/b/d:nxO	I
    //   305: aload 9
    //   307: getfield 936	com/tencent/mm/media/b/d:nxP	I
    //   310: invokespecial 939	com/tencent/mm/media/e/h:<init>	(III)V
    //   313: putfield 941	com/tencent/mm/media/i/e:nCi	Lcom/tencent/mm/media/e/h;
    //   316: aload_0
    //   317: new 943	com/tencent/mm/media/i/a
    //   320: dup
    //   321: aload_1
    //   322: checkcast 945	com/tencent/mm/media/j/a
    //   325: invokespecial 948	com/tencent/mm/media/i/a:<init>	(Lcom/tencent/mm/media/j/a;)V
    //   328: putfield 950	com/tencent/mm/media/i/e:nCk	Lcom/tencent/mm/media/i/a;
    //   331: aload_0
    //   332: getfield 950	com/tencent/mm/media/i/e:nCk	Lcom/tencent/mm/media/i/a;
    //   335: astore 9
    //   337: aload 9
    //   339: ifnull +38 -> 377
    //   342: aload 9
    //   344: ldc_w 951
    //   347: aload_0
    //   348: getfield 488	com/tencent/mm/media/i/e:videoFps	I
    //   351: idiv
    //   352: putfield 954	com/tencent/mm/media/i/a:nBw	I
    //   355: aload 9
    //   357: getfield 955	com/tencent/mm/media/i/a:TAG	Ljava/lang/String;
    //   360: ldc_w 957
    //   363: aload 9
    //   365: getfield 954	com/tencent/mm/media/i/a:nBw	I
    //   368: invokestatic 600	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   371: invokestatic 604	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   374: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_0
    //   378: getfield 959	com/tencent/mm/media/i/e:nBp	Lkotlin/g/a/b;
    //   381: ifnull +23 -> 404
    //   384: aload_0
    //   385: getfield 950	com/tencent/mm/media/i/e:nCk	Lcom/tencent/mm/media/i/a;
    //   388: astore 9
    //   390: aload 9
    //   392: ifnull +12 -> 404
    //   395: aload 9
    //   397: aload_0
    //   398: getfield 959	com/tencent/mm/media/i/e:nBp	Lkotlin/g/a/b;
    //   401: invokevirtual 962	com/tencent/mm/media/i/a:C	(Lkotlin/g/a/b;)V
    //   404: aload_0
    //   405: getfield 964	com/tencent/mm/media/i/e:nCt	Lkotlin/g/a/b;
    //   408: ifnull +23 -> 431
    //   411: aload_0
    //   412: getfield 950	com/tencent/mm/media/i/e:nCk	Lcom/tencent/mm/media/i/a;
    //   415: astore 9
    //   417: aload 9
    //   419: ifnull +12 -> 431
    //   422: aload 9
    //   424: aload_0
    //   425: getfield 964	com/tencent/mm/media/i/e:nCt	Lkotlin/g/a/b;
    //   428: invokevirtual 966	com/tencent/mm/media/i/a:D	(Lkotlin/g/a/b;)V
    //   431: aload_0
    //   432: getfield 950	com/tencent/mm/media/i/e:nCk	Lcom/tencent/mm/media/i/a;
    //   435: astore 9
    //   437: aload 9
    //   439: ifnull +19 -> 458
    //   442: aload 9
    //   444: new 18	com/tencent/mm/media/i/e$f
    //   447: dup
    //   448: aload_0
    //   449: invokespecial 967	com/tencent/mm/media/i/e$f:<init>	(Lcom/tencent/mm/media/i/e;)V
    //   452: checkcast 969	kotlin/g/a/b
    //   455: putfield 972	com/tencent/mm/media/i/a:nBl	Lkotlin/g/a/b;
    //   458: iconst_3
    //   459: newarray double
    //   461: astore 9
    //   463: aload 9
    //   465: iconst_0
    //   466: dconst_0
    //   467: dastore
    //   468: aload 9
    //   470: iconst_1
    //   471: dconst_0
    //   472: dastore
    //   473: aload 9
    //   475: iconst_2
    //   476: dconst_0
    //   477: dastore
    //   478: aload_0
    //   479: getfield 367	com/tencent/mm/media/i/e:filePath	Ljava/lang/String;
    //   482: aload 9
    //   484: aload_0
    //   485: getfield 445	com/tencent/mm/media/i/e:nys	I
    //   488: invokestatic 977	com/tencent/mm/media/util/b:a	(Ljava/lang/String;[DI)Ljava/util/List;
    //   491: pop
    //   492: iconst_0
    //   493: istore_2
    //   494: goto +496 -> 990
    //   497: iload_2
    //   498: ifeq +85 -> 583
    //   501: aload 9
    //   503: iconst_1
    //   504: daload
    //   505: aload 9
    //   507: iconst_0
    //   508: daload
    //   509: dsub
    //   510: aload_0
    //   511: getfield 445	com/tencent/mm/media/i/e:nys	I
    //   514: i2d
    //   515: dcmpl
    //   516: iflt +67 -> 583
    //   519: aload_0
    //   520: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   523: new 468	java/lang/StringBuilder
    //   526: dup
    //   527: ldc_w 979
    //   530: invokespecial 471	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   533: aload 9
    //   535: iconst_0
    //   536: daload
    //   537: invokevirtual 982	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   540: ldc_w 984
    //   543: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 9
    //   548: iconst_1
    //   549: daload
    //   550: invokevirtual 982	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   553: ldc_w 986
    //   556: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload_0
    //   560: getfield 445	com/tencent/mm/media/i/e:nys	I
    //   563: invokevirtual 482	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: ldc_w 988
    //   569: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload_0
    //   579: iconst_1
    //   580: putfield 728	com/tencent/mm/media/i/e:nCF	Z
    //   583: aload_0
    //   584: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   587: ldc_w 990
    //   590: aload_0
    //   591: getfield 728	com/tencent/mm/media/i/e:nCF	Z
    //   594: invokestatic 695	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   597: invokestatic 604	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   600: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload_0
    //   604: getfield 992	com/tencent/mm/media/i/e:nCh	Lcom/tencent/mm/media/e/b;
    //   607: ifnull +361 -> 968
    //   610: aload_0
    //   611: getfield 992	com/tencent/mm/media/i/e:nCh	Lcom/tencent/mm/media/e/b;
    //   614: astore 9
    //   616: aload 9
    //   618: ifnull +350 -> 968
    //   621: aload 9
    //   623: invokevirtual 998	com/tencent/mm/media/e/b:bph	()Landroid/view/Surface;
    //   626: astore 9
    //   628: aload_0
    //   629: getfield 950	com/tencent/mm/media/i/e:nCk	Lcom/tencent/mm/media/i/a;
    //   632: astore 10
    //   634: aload 10
    //   636: ifnull +277 -> 913
    //   639: aload_0
    //   640: getfield 728	com/tencent/mm/media/i/e:nCF	Z
    //   643: ifne +331 -> 974
    //   646: iconst_1
    //   647: istore 4
    //   649: aload_0
    //   650: getfield 393	com/tencent/mm/media/i/e:nBZ	Z
    //   653: ifeq +327 -> 980
    //   656: aload_0
    //   657: getfield 379	com/tencent/mm/media/i/e:outputWidth	I
    //   660: istore_2
    //   661: aload_0
    //   662: getfield 393	com/tencent/mm/media/i/e:nBZ	Z
    //   665: ifeq +320 -> 985
    //   668: aload_0
    //   669: getfield 381	com/tencent/mm/media/i/e:outputHeight	I
    //   672: istore_3
    //   673: aload 10
    //   675: aload 9
    //   677: iload 4
    //   679: iload_2
    //   680: iload_3
    //   681: aload_0
    //   682: getfield 415	com/tencent/mm/media/i/e:nBy	J
    //   685: new 20	com/tencent/mm/media/i/e$g
    //   688: dup
    //   689: aload_0
    //   690: aload_1
    //   691: invokespecial 1001	com/tencent/mm/media/i/e$g:<init>	(Lcom/tencent/mm/media/i/e;Lcom/tencent/mm/media/j/b;)V
    //   694: checkcast 969	kotlin/g/a/b
    //   697: invokevirtual 1004	com/tencent/mm/media/i/a:a	(Landroid/view/Surface;ZIIJLkotlin/g/a/b;)V
    //   700: ldc_w 881
    //   703: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   706: return
    //   707: aload 10
    //   709: invokestatic 466	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   712: ifeq +9 -> 721
    //   715: aload 10
    //   717: invokestatic 1007	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   720: pop
    //   721: aload_0
    //   722: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   725: ldc_w 1009
    //   728: iconst_2
    //   729: anewarray 673	java/lang/Object
    //   732: dup
    //   733: iconst_0
    //   734: aload 9
    //   736: aastore
    //   737: dup
    //   738: iconst_1
    //   739: aload 10
    //   741: aastore
    //   742: invokestatic 1011	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: invokestatic 777	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   748: lstore 5
    //   750: aload 9
    //   752: aload 10
    //   754: iconst_0
    //   755: invokestatic 1015	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   758: lstore 7
    //   760: aload_0
    //   761: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   764: ldc_w 1017
    //   767: lload 5
    //   769: invokestatic 1021	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   772: invokestatic 1026	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   775: invokestatic 604	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   778: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   781: lload 7
    //   783: lconst_0
    //   784: lcmp
    //   785: ifgt -746 -> 39
    //   788: getstatic 505	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   791: astore 9
    //   793: invokestatic 1029	com/tencent/mm/media/util/f:brJ	()V
    //   796: goto -757 -> 39
    //   799: bipush 23
    //   801: invokestatic 1035	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   804: ifeq +116 -> 920
    //   807: new 1037	com/tencent/mm/media/e/f
    //   810: dup
    //   811: aload 9
    //   813: new 14	com/tencent/mm/media/i/e$d
    //   816: dup
    //   817: aload 10
    //   819: aload 11
    //   821: invokespecial 1040	com/tencent/mm/media/i/e$d:<init>	(Lkotlin/g/a/m;Lkotlin/g/a/a;)V
    //   824: checkcast 969	kotlin/g/a/b
    //   827: invokespecial 1043	com/tencent/mm/media/e/f:<init>	(Lcom/tencent/mm/media/b/d;Lkotlin/g/a/b;)V
    //   830: checkcast 994	com/tencent/mm/media/e/b
    //   833: astore 9
    //   835: aload_0
    //   836: aload 9
    //   838: putfield 992	com/tencent/mm/media/i/e:nCh	Lcom/tencent/mm/media/e/b;
    //   841: goto -525 -> 316
    //   844: astore_1
    //   845: aload_0
    //   846: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   849: aload_1
    //   850: checkcast 829	java/lang/Throwable
    //   853: ldc_w 1045
    //   856: iconst_0
    //   857: anewarray 673	java/lang/Object
    //   860: invokestatic 838	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   863: getstatic 505	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   866: astore_1
    //   867: invokestatic 1048	com/tencent/mm/media/util/f:brL	()V
    //   870: invokestatic 1054	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleDefault	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   873: ldc_w 1056
    //   876: iconst_1
    //   877: invokevirtual 1060	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putBoolean	(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    //   880: pop
    //   881: aload_0
    //   882: iconst_0
    //   883: iconst_1
    //   884: invokespecial 880	com/tencent/mm/media/i/e:s	(ZZ)V
    //   887: ldc_w 881
    //   890: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   893: return
    //   894: astore_1
    //   895: aload_0
    //   896: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   899: aload_1
    //   900: checkcast 829	java/lang/Throwable
    //   903: ldc_w 1062
    //   906: iconst_0
    //   907: anewarray 673	java/lang/Object
    //   910: invokestatic 838	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   913: ldc_w 881
    //   916: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   919: return
    //   920: new 1064	com/tencent/mm/media/e/e
    //   923: dup
    //   924: aload 9
    //   926: new 16	com/tencent/mm/media/i/e$e
    //   929: dup
    //   930: aload 10
    //   932: aload 11
    //   934: invokespecial 1065	com/tencent/mm/media/i/e$e:<init>	(Lkotlin/g/a/m;Lkotlin/g/a/a;)V
    //   937: checkcast 969	kotlin/g/a/b
    //   940: invokespecial 1066	com/tencent/mm/media/e/e:<init>	(Lcom/tencent/mm/media/b/d;Lkotlin/g/a/b;)V
    //   943: checkcast 994	com/tencent/mm/media/e/b
    //   946: astore 9
    //   948: goto -113 -> 835
    //   951: iconst_0
    //   952: istore_3
    //   953: goto +53 -> 1006
    //   956: iload_2
    //   957: iconst_1
    //   958: iadd
    //   959: istore_2
    //   960: goto +30 -> 990
    //   963: iconst_1
    //   964: istore_2
    //   965: goto -468 -> 497
    //   968: aconst_null
    //   969: astore 9
    //   971: goto -343 -> 628
    //   974: iconst_0
    //   975: istore 4
    //   977: goto -328 -> 649
    //   980: iconst_0
    //   981: istore_2
    //   982: goto -321 -> 661
    //   985: iconst_0
    //   986: istore_3
    //   987: goto -314 -> 673
    //   990: iload_2
    //   991: iconst_3
    //   992: if_icmpge -29 -> 963
    //   995: aload 9
    //   997: iload_2
    //   998: daload
    //   999: dconst_0
    //   1000: dcmpl
    //   1001: ifle -50 -> 951
    //   1004: iconst_1
    //   1005: istore_3
    //   1006: iload_3
    //   1007: ifne -51 -> 956
    //   1010: iconst_0
    //   1011: istore_2
    //   1012: goto -515 -> 497
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1015	0	this	e
    //   0	1015	1	paramb	com.tencent.mm.media.j.b
    //   493	519	2	i	int
    //   672	335	3	j	int
    //   647	329	4	bool	boolean
    //   748	20	5	l1	long
    //   758	24	7	l2	long
    //   10	986	9	localObject1	Object
    //   15	916	10	localObject2	Object
    //   83	850	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   281	316	844	java/lang/Exception
    //   799	835	844	java/lang/Exception
    //   835	841	844	java/lang/Exception
    //   920	948	844	java/lang/Exception
    //   249	281	894	java/lang/Exception
    //   316	337	894	java/lang/Exception
    //   342	377	894	java/lang/Exception
    //   377	390	894	java/lang/Exception
    //   395	404	894	java/lang/Exception
    //   404	417	894	java/lang/Exception
    //   422	431	894	java/lang/Exception
    //   431	437	894	java/lang/Exception
    //   442	458	894	java/lang/Exception
    //   458	463	894	java/lang/Exception
    //   478	492	894	java/lang/Exception
    //   501	583	894	java/lang/Exception
    //   583	616	894	java/lang/Exception
    //   621	628	894	java/lang/Exception
    //   628	634	894	java/lang/Exception
    //   639	646	894	java/lang/Exception
    //   649	661	894	java/lang/Exception
    //   661	673	894	java/lang/Exception
    //   673	700	894	java/lang/Exception
    //   845	893	894	java/lang/Exception
  }
  
  private static final void b(e parame)
  {
    AppMethodBeat.i(237865);
    s.u(parame, "this$0");
    Log.i(parame.TAG, "decode end after " + nCJ + ", isFinishEncode:" + parame.nzA);
    if (!parame.nzA)
    {
      com.tencent.mm.media.util.f localf = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bsi();
      parame.boZ();
    }
    AppMethodBeat.o(237865);
  }
  
  private final void boZ()
  {
    AppMethodBeat.i(93805);
    Log.i(this.TAG, "finishEncode");
    Object localObject;
    if (this.nBZ)
    {
      localObject = this.nCi;
      if (localObject != null) {
        ((com.tencent.mm.media.e.h)localObject).stop();
      }
      go(true);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.nCH);
      this.nzA = true;
      AppMethodBeat.o(93805);
      return;
      localObject = this.nCh;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).boZ();
      }
    }
  }
  
  private final com.tencent.mm.media.b.d bpI()
  {
    AppMethodBeat.i(93800);
    if (this.nBY > 0) {}
    com.tencent.mm.media.b.d locald;
    for (int i = Math.min(this.nBY, this.videoFps);; i = this.videoFps)
    {
      locald = new com.tencent.mm.media.b.d(this.nyh);
      locald.bitrate = this.nBU;
      locald.frameRate = i;
      locald.nxP = this.outputHeight;
      locald.nxO = this.outputWidth;
      locald.nxU = this.nCa;
      locald.nxV = this.nCb;
      if (this.nCd > 0) {
        locald.nxQ = this.nCd;
      }
      while (locald.frameRate * locald.nxQ - 1 <= 1)
      {
        locald.frameRate += 1;
        Log.e(this.TAG, "encodeConfig.frameRate + 1");
      }
    }
    Log.i(this.TAG, "steve: hardcoder qp:" + this.nCa + ", " + this.nCb);
    AppMethodBeat.o(93800);
    return locald;
  }
  
  private static int er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237827);
    if (paramInt1 <= paramInt2)
    {
      AppMethodBeat.o(237827);
      return paramInt2;
    }
    Integer localInteger = Integer.valueOf(paramInt2 - 1 & paramInt1);
    if (((Number)localInteger).intValue() != 0)
    {
      i = 1;
      if (i == 0) {
        break label61;
      }
    }
    for (;;)
    {
      if (localInteger != null) {
        break label66;
      }
      AppMethodBeat.o(237827);
      return paramInt1;
      i = 0;
      break;
      label61:
      localInteger = null;
    }
    label66:
    int i = ((Number)localInteger).intValue();
    if (i * 2 > paramInt2)
    {
      AppMethodBeat.o(237827);
      return paramInt2 + (paramInt1 - i);
    }
    AppMethodBeat.o(237827);
    return paramInt1 - i;
  }
  
  /* Error */
  private final void go(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 1134
    //   5: invokestatic 310	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   12: new 468	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 1136
    //   19: invokespecial 471	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: iload_1
    //   23: invokevirtual 669	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc_w 1138
    //   29: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 1140	com/tencent/mm/media/i/e:nCy	Z
    //   36: invokevirtual 669	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   39: ldc_w 1142
    //   42: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 1144	com/tencent/mm/media/i/e:nCx	Z
    //   49: invokevirtual 669	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   52: ldc_w 1146
    //   55: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 850	com/tencent/mm/media/i/e:nCw	Z
    //   62: invokevirtual 669	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iload_1
    //   72: ifeq +373 -> 445
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 1144	com/tencent/mm/media/i/e:nCx	Z
    //   80: aload_0
    //   81: getfield 1140	com/tencent/mm/media/i/e:nCy	Z
    //   84: ifeq +378 -> 462
    //   87: aload_0
    //   88: getfield 1144	com/tencent/mm/media/i/e:nCx	Z
    //   91: ifeq +371 -> 462
    //   94: aload_0
    //   95: getfield 850	com/tencent/mm/media/i/e:nCw	Z
    //   98: ifne +364 -> 462
    //   101: aload_0
    //   102: getfield 950	com/tencent/mm/media/i/e:nCk	Lcom/tencent/mm/media/i/a;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +8 -> 117
    //   112: aload 4
    //   114: invokevirtual 1147	com/tencent/mm/media/i/a:release	()V
    //   117: aload_0
    //   118: getfield 426	com/tencent/mm/media/i/e:nCv	Lcom/tencent/mm/media/util/a;
    //   121: invokevirtual 1150	com/tencent/mm/media/util/a:bbW	()V
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 850	com/tencent/mm/media/i/e:nCw	Z
    //   129: getstatic 887	com/tencent/mm/media/i/i:nDi	Lcom/tencent/mm/media/i/i$a;
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 367	com/tencent/mm/media/i/e:filePath	Ljava/lang/String;
    //   138: invokestatic 901	com/tencent/mm/media/i/i$a:GP	(Ljava/lang/String;)Ljava/lang/String;
    //   141: invokestatic 1007	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   144: pop
    //   145: getstatic 887	com/tencent/mm/media/i/i:nDi	Lcom/tencent/mm/media/i/i$a;
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 367	com/tencent/mm/media/i/e:filePath	Ljava/lang/String;
    //   154: invokestatic 892	com/tencent/mm/media/i/i$a:GQ	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokestatic 1007	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   160: pop
    //   161: aload_0
    //   162: getfield 455	com/tencent/mm/media/i/e:nCG	Lcom/tencent/mm/media/i/e$l;
    //   165: invokevirtual 1153	com/tencent/mm/media/i/e$l:cancel	()Z
    //   168: pop
    //   169: aload_0
    //   170: getfield 682	com/tencent/mm/media/i/e:nyw	Lcom/tencent/mm/media/f/a;
    //   173: invokevirtual 1154	com/tencent/mm/media/f/a:release	()V
    //   176: aload_0
    //   177: getfield 752	com/tencent/mm/media/i/e:nCn	Lcom/tencent/mm/media/f/a;
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 1154	com/tencent/mm/media/f/a:release	()V
    //   192: aload_0
    //   193: getfield 908	com/tencent/mm/media/i/e:nCs	Lcom/tencent/mm/media/i/f;
    //   196: astore 4
    //   198: aload 4
    //   200: ifnull +27 -> 227
    //   203: aload 4
    //   205: getfield 1157	com/tencent/mm/media/i/f:nCY	Lkotlin/g/a/b;
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull +15 -> 227
    //   215: aload 4
    //   217: aload_0
    //   218: getfield 407	com/tencent/mm/media/i/e:nCf	Lkotlin/g/a/b;
    //   221: invokeinterface 1161 2 0
    //   226: pop
    //   227: aload_0
    //   228: getfield 1163	com/tencent/mm/media/i/e:nCo	Landroid/os/HandlerThread;
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +9 -> 244
    //   238: aload 4
    //   240: invokevirtual 1168	android/os/HandlerThread:quit	()Z
    //   243: pop
    //   244: aload_0
    //   245: getfield 1170	com/tencent/mm/media/i/e:nCp	Landroid/os/HandlerThread;
    //   248: astore 4
    //   250: aload 4
    //   252: ifnull +9 -> 261
    //   255: aload 4
    //   257: invokevirtual 1168	android/os/HandlerThread:quit	()Z
    //   260: pop
    //   261: aload_0
    //   262: getfield 1172	com/tencent/mm/media/i/e:nCu	J
    //   265: invokestatic 1021	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   268: lstore_2
    //   269: aload_0
    //   270: getfield 411	com/tencent/mm/media/i/e:TAG	Ljava/lang/String;
    //   273: new 468	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 1174
    //   280: invokespecial 471	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: lload_2
    //   284: invokevirtual 649	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: ldc_w 1176
    //   290: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 1120	com/tencent/mm/media/i/e:nCz	I
    //   297: invokevirtual 482	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: ldc_w 1178
    //   303: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload_0
    //   307: getfield 867	com/tencent/mm/media/i/e:nxx	I
    //   310: invokevirtual 482	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 1180
    //   316: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload_0
    //   320: getfield 1081	com/tencent/mm/media/i/e:nCA	I
    //   323: invokevirtual 482	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 1182
    //   329: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: getfield 1123	com/tencent/mm/media/i/e:nCC	I
    //   336: invokevirtual 482	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 525	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload_0
    //   346: getfield 371	com/tencent/mm/media/i/e:outputFilePath	Ljava/lang/String;
    //   349: invokestatic 557	com/tencent/mm/plugin/sight/base/f:aVX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/b;
    //   352: astore 4
    //   354: aload 4
    //   356: ifnull +106 -> 462
    //   359: getstatic 505	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   362: astore 5
    //   364: aload_0
    //   365: getfield 369	com/tencent/mm/media/i/e:nxj	I
    //   368: lload_2
    //   369: invokestatic 1185	com/tencent/mm/media/util/f:B	(IJ)V
    //   372: getstatic 505	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   375: astore 5
    //   377: aload 4
    //   379: getfield 664	com/tencent/mm/plugin/sight/base/b:videoBitrate	I
    //   382: i2l
    //   383: aload 4
    //   385: getfield 572	com/tencent/mm/plugin/sight/base/b:frameRate	I
    //   388: i2l
    //   389: aload_0
    //   390: getfield 488	com/tencent/mm/media/i/e:videoFps	I
    //   393: i2l
    //   394: invokestatic 1188	com/tencent/mm/media/util/f:g	(JJJ)V
    //   397: aload_0
    //   398: getfield 1120	com/tencent/mm/media/i/e:nCz	I
    //   401: i2f
    //   402: aload_0
    //   403: getfield 867	com/tencent/mm/media/i/e:nxx	I
    //   406: i2f
    //   407: fdiv
    //   408: f2d
    //   409: ldc2_w 1189
    //   412: dcmpl
    //   413: iflt +11 -> 424
    //   416: getstatic 505	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   419: astore 4
    //   421: invokestatic 1193	com/tencent/mm/media/util/f:brU	()V
    //   424: getstatic 505	com/tencent/mm/media/util/f:nFE	Lcom/tencent/mm/media/util/f;
    //   427: astore 4
    //   429: aload_0
    //   430: getfield 371	com/tencent/mm/media/i/e:outputFilePath	Ljava/lang/String;
    //   433: invokestatic 1196	com/tencent/mm/media/util/f:GT	(Ljava/lang/String;)V
    //   436: ldc_w 1134
    //   439: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: aload_0
    //   443: monitorexit
    //   444: return
    //   445: aload_0
    //   446: iconst_1
    //   447: putfield 1140	com/tencent/mm/media/i/e:nCy	Z
    //   450: goto -370 -> 80
    //   453: astore 4
    //   455: aload_0
    //   456: monitorexit
    //   457: aload 4
    //   459: athrow
    //   460: astore 4
    //   462: ldc_w 1134
    //   465: invokestatic 316	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   468: goto -26 -> 442
    //   471: astore 4
    //   473: goto -312 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	e
    //   0	476	1	paramBoolean	boolean
    //   268	101	2	l	long
    //   105	323	4	localObject1	Object
    //   453	5	4	localObject2	Object
    //   460	1	4	localException1	Exception
    //   471	1	4	localException2	Exception
    //   362	14	5	localf	com.tencent.mm.media.util.f
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
  
  private final void s(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      AppMethodBeat.i(177316);
      Log.i(this.TAG, "onDecoderEncoderFailed, isDecoder:" + paramBoolean1 + " isEncoder:" + paramBoolean2);
      this.nCG.cancel();
      if (paramBoolean1)
      {
        localObject1 = this.nBN;
        if (localObject1 != null) {
          ((com.tencent.mm.media.d.f)localObject1).releaseDecoder();
        }
        this.nBN = null;
      }
      if (paramBoolean2)
      {
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brx();
        localObject1 = this.nCh;
        if (localObject1 != null) {
          ((com.tencent.mm.media.e.b)localObject1).bpa();
        }
        this.nCh = null;
      }
      if (!this.nCw)
      {
        this.nCl.release();
        localObject1 = this.nCk;
        if (localObject1 != null) {
          ((a)localObject1).release();
        }
        this.nCv.bbW();
        this.nCw = true;
      }
      try
      {
        localObject1 = i.nDi;
        y.deleteFile(i.a.GP(this.filePath));
        localObject1 = i.nDi;
        y.deleteFile(i.a.GQ(this.filePath));
        this.nyw.release();
        localObject1 = this.nCn;
        if (localObject1 != null) {
          ((com.tencent.mm.media.f.a)localObject1).release();
        }
        localObject1 = this.nCo;
        if (localObject1 != null) {
          ((HandlerThread)localObject1).quit();
        }
        localObject1 = this.nCp;
        if (localObject1 != null) {
          ((HandlerThread)localObject1).quit();
        }
        y.deleteFile(this.outputFilePath);
        long l = Util.ticksToNow(this.nCu);
        Log.i(this.TAG, s.X("onDecoderEncoderFailed, finish, costTime:", Long.valueOf(l)));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)localException, s.X("onDecoderEncoderFailed error:", localException.getMessage()), new Object[0]);
        }
      }
      Object localObject1 = this.nCf;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(null);
      }
      AppMethodBeat.o(177316);
      return;
    }
    finally {}
  }
  
  public final void E(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93802);
    s.u(paramb, "blendBitmapProvider");
    this.nBp = paramb;
    a locala = this.nCk;
    if (locala != null) {
      locala.C(paramb);
    }
    AppMethodBeat.o(93802);
  }
  
  public final void F(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(93804);
    s.u(paramb, "blurBgProvider");
    this.nCt = paramb;
    a locala = this.nCk;
    if (locala != null) {
      locala.D(paramb);
    }
    AppMethodBeat.o(93804);
  }
  
  public final void I(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93801);
    s.u(paramBitmap, "bitmap");
    this.nBq = paramBitmap;
    a locala = this.nCk;
    String str;
    if (locala != null)
    {
      str = locala.TAG;
      if (paramBitmap == null) {
        break label69;
      }
    }
    label69:
    for (int i = paramBitmap.hashCode();; i = 0)
    {
      Log.i(str, s.X("setDrawBlendBitmap:", Integer.valueOf(i)));
      locala.nBq = paramBitmap;
      AppMethodBeat.o(93801);
      return;
    }
  }
  
  public final int bpE()
  {
    AppMethodBeat.i(93803);
    Log.i(this.TAG, s.X("start remux, initFinish:", Boolean.valueOf(this.nCq)));
    this.nCu = Util.currentTicks();
    if ((this.nBq != null) && (this.nCg > 0)) {
      this.nBq = BitmapUtil.rotate(this.nBq, -this.nCg);
    }
    this.nCv.mHw.lYS = SystemClock.elapsedRealtime();
    if (this.nCq)
    {
      HandlerThread localHandlerThread = this.nCo;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      this.nCo = com.tencent.mm.ae.d.f("MediaCodecRemux_audioMix", (kotlin.g.a.a)new b(this));
      localHandlerThread = this.nCp;
      if (localHandlerThread != null) {
        localHandlerThread.quit();
      }
      if (this.nBN != null) {
        this.nCp = com.tencent.mm.ae.d.f("MediaCodecRemux_videoMix", (kotlin.g.a.a)new c(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(93803);
      return 0;
      this.nCr = true;
    }
  }
  
  protected final int bpF()
  {
    return this.inputWidth;
  }
  
  protected final int bpG()
  {
    return this.inputHeight;
  }
  
  public com.tencent.mm.media.j.b bpH()
  {
    int i = 1;
    AppMethodBeat.i(164113);
    if ((this.nCg == 90) || (this.nCg == 270)) {
      if (this.inputHeight > this.inputWidth) {
        Log.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
    }
    while (this.nBZ)
    {
      localb = new com.tencent.mm.media.j.b(this.inputWidth, this.inputHeight, this.outputWidth, this.outputHeight, 2, i);
      AppMethodBeat.o(164113);
      return localb;
      Log.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
      i = 2;
      continue;
      if (this.inputWidth > this.inputHeight)
      {
        Log.i(this.TAG, "is landscape video -> SCALE_TYPE_NOT_SCALE");
      }
      else
      {
        Log.i(this.TAG, "is portrait video -> SCALE_TYPE_CENTER_CROP");
        i = 2;
      }
    }
    com.tencent.mm.media.j.b localb = new com.tencent.mm.media.j.b(this.inputWidth, this.inputHeight, this.outputWidth, this.outputHeight, i);
    AppMethodBeat.o(164113);
    return localb;
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
  
  public final Rect iD()
  {
    return this.Gl;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    d(m<? super ByteBuffer, ? super MediaCodec.BufferInfo, ah> paramm, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    e(m<? super ByteBuffer, ? super MediaCodec.BufferInfo, ah> paramm, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    g(e parame, com.tencent.mm.media.j.b paramb)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, ah>
    {
      a(e parame)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(e parame)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<ah>
    {
      c(e parame)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<ByteBuffer, MediaCodec.BufferInfo, ah>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, ah>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(e parame, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/remuxer/MediaCodecRemuxer$timeoutInvoke$1", "Lcom/tencent/threadpool/runnable/CancelableRunnable;", "getKey", "", "run", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    extends com.tencent.threadpool.i.b
  {
    l(e parame) {}
    
    public final String getKey()
    {
      return "MediaCodecRemuxer#timeoutInvoke";
    }
    
    public final void run()
    {
      AppMethodBeat.i(177315);
      Log.e(e.c(this.nCK), s.X("remux error! handing one frame time out ,isInvokeEndCallback:", Boolean.valueOf(e.J(this.nCK))));
      e locale;
      if (!e.J(this.nCK))
      {
        locale = this.nCK;
        if (e.e(this.nCK)) {
          break label69;
        }
      }
      label69:
      for (boolean bool = true;; bool = false)
      {
        e.a(locale, bool, true);
        AppMethodBeat.o(177315);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.i.e
 * JD-Core Version:    0.7.0.1
 */