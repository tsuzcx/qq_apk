package com.tencent.mm.media.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markAfterCaptureFinish", "", "filePath", "recorderType", "", "resolutionLimit", "markBaseRecordBitrate", "bitrate", "markBaseRecordFps", "fps", "markBaseRecordSuccessTimes", "markC2cCaptureJumpRemux", "markCameraOpen", "markCameraOpenFailed", "markCameraOpenSuccess", "markCaptureUseHwHevc", "markCaptureUseSwHevc", "markCheckRemuxResult", "path", "markCpuCrop", "markCreateExternalTextureFailed", "markDaemonRecordBitrate", "markDaemonRecordFps", "markDaemonRecordSuccessTimes", "markDoubleRemux", "markDoubleRemuxTimeCost", "time", "markEditErrorPath", "markEditPhoto", "markEditPhotoCost", "cost", "markEditPhotoFail", "markEditPhotoFailNullBitmap", "markEditToRecord", "markEglVersion2", "markEglVersion3", "markEncodeCreateSuccessTimes", "markEncodeCreateTimes", "markFrameHandlingTime", "markGpuCrop", "markGpuCropFailed", "markLayoutError", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markMediaCodecWriteYUVError", "markMediaCodecYUVInitError", "markMp4EncoderCreate", "markMp4EncoderRelease", "markPhotoCapture", "markPhotoCaptureFail", "markPhotoEdit", "markPhotoEdited", "markPhotoTimeCost", "markRecordCancelTimes", "markRecordTimes", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckBFrameCost", "markRemuxCheckBFrameFailed", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCheckHasBFrame", "markRemuxCheckHasBFrameTimeout", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxEncoderCreate", "markRemuxEncoderRelease", "markRemuxEndWithFrameNumberCheckTimeout", "markRemuxEndWithFrameNumberMatch", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxUseHwHevc", "markRemuxUseSwHevc", "markRemuxVideoParaError", "markRemuxX264Encode", "markReserveEncoder", "markSavePhotoFail", "markSnsCaptureJumpRemux", "markStartBaseRecordTimeout", "markStartDaemonRecordSuccessTimes", "markStartDaemonRecordTimeout", "markStartDaemonRecordTimes", "markSyncEncoderCreate", "markSyncEncoderRelease", "markVideoEdited", "markVideoGenerate", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "markaSyncEncoderCreate", "markaSyncEncoderRelease", "plugin-mediaeditor_release"})
public final class f
{
  private static long laA;
  public static final f laB;
  private static long laz;
  
  static
  {
    AppMethodBeat.i(94001);
    laB = new f();
    laz = -1L;
    laA = -1L;
    AppMethodBeat.o(94001);
  }
  
  public static void FR(long paramLong)
  {
    AppMethodBeat.i(93926);
    h.IzE.idkeyStat(985L, 122L, paramLong, false);
    AppMethodBeat.o(93926);
  }
  
  public static void FS(long paramLong)
  {
    AppMethodBeat.i(93931);
    h.IzE.idkeyStat(985L, 128L, paramLong, false);
    AppMethodBeat.o(93931);
  }
  
  public static void FT(long paramLong)
  {
    AppMethodBeat.i(93945);
    h.IzE.idkeyStat(985L, 155L, paramLong, false);
    AppMethodBeat.o(93945);
  }
  
  public static void FU(long paramLong)
  {
    AppMethodBeat.i(93954);
    h.IzE.idkeyStat(985L, 168L, paramLong, false);
    AppMethodBeat.o(93954);
  }
  
  public static void FV(long paramLong)
  {
    AppMethodBeat.i(93956);
    h.IzE.idkeyStat(985L, 170L, paramLong, false);
    AppMethodBeat.o(93956);
  }
  
  public static void FW(long paramLong)
  {
    AppMethodBeat.i(93957);
    h.IzE.idkeyStat(985L, 173L, paramLong, false);
    AppMethodBeat.o(93957);
  }
  
  public static void FX(long paramLong)
  {
    AppMethodBeat.i(93959);
    h.IzE.idkeyStat(985L, 175L, paramLong, false);
    AppMethodBeat.o(93959);
  }
  
  public static void FY(long paramLong)
  {
    AppMethodBeat.i(93978);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMixTime: ".concat(String.valueOf(paramLong)));
    h.IzE.p(986L, 27L, paramLong);
    AppMethodBeat.o(93978);
  }
  
  public static void FZ(long paramLong)
  {
    AppMethodBeat.i(93980);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMixTime: ".concat(String.valueOf(paramLong)));
    h.IzE.p(986L, 31L, paramLong);
    AppMethodBeat.o(93980);
  }
  
  public static void Ga(long paramLong)
  {
    AppMethodBeat.i(177320);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markFrameHandlingTime time:".concat(String.valueOf(paramLong)));
    if (paramLong < 1000L)
    {
      h.IzE.p(986L, 130L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 2000L)
    {
      h.IzE.p(986L, 131L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 3000L)
    {
      h.IzE.p(986L, 132L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 4000L)
    {
      h.IzE.p(986L, 133L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 5000L)
    {
      h.IzE.p(986L, 134L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 6000L)
    {
      h.IzE.p(986L, 135L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 7000L)
    {
      h.IzE.p(986L, 136L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 8000L)
    {
      h.IzE.p(986L, 137L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 9000L)
    {
      h.IzE.p(986L, 138L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 10000L)
    {
      h.IzE.p(986L, 139L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 15000L)
    {
      h.IzE.p(986L, 140L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 20000L)
    {
      h.IzE.p(986L, 141L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    h.IzE.p(986L, 142L, 1L);
    AppMethodBeat.o(177320);
  }
  
  /* Error */
  public static void OD(String paramString)
  {
    // Byte code:
    //   0: ldc_w 321
    //   3: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 322
    //   10: invokestatic 328	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokestatic 334	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   17: ifne +10 -> 27
    //   20: ldc_w 321
    //   23: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: return
    //   27: aconst_null
    //   28: astore 6
    //   30: new 336	com/tencent/mm/media/f/a
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 338	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   38: astore 5
    //   40: aload 5
    //   42: getfield 342	com/tencent/mm/media/f/a:kUW	Landroid/media/MediaFormat;
    //   45: astore_0
    //   46: aload 5
    //   48: getfield 345	com/tencent/mm/media/f/a:kUV	Landroid/media/MediaFormat;
    //   51: astore 6
    //   53: aload_0
    //   54: ifnull +148 -> 202
    //   57: aload_0
    //   58: ldc_w 347
    //   61: invokevirtual 352	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   64: iconst_1
    //   65: if_icmpne +137 -> 202
    //   68: aload_0
    //   69: ldc_w 347
    //   72: invokevirtual 356	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   75: lstore_1
    //   76: aload 6
    //   78: ifnull +131 -> 209
    //   81: aload 6
    //   83: ldc_w 347
    //   86: invokevirtual 352	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   89: iconst_1
    //   90: if_icmpne +119 -> 209
    //   93: aload 6
    //   95: ldc_w 347
    //   98: invokevirtual 356	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   101: lstore_3
    //   102: ldc 231
    //   104: new 358	java/lang/StringBuilder
    //   107: dup
    //   108: ldc_w 360
    //   111: invokespecial 361	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: lload_3
    //   115: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   118: ldc_w 367
    //   121: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: lload_1
    //   125: invokevirtual 365	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   128: invokevirtual 374	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: lload_1
    //   135: lconst_0
    //   136: lcmp
    //   137: ifle +53 -> 190
    //   140: lload_3
    //   141: lconst_0
    //   142: lcmp
    //   143: ifle +47 -> 190
    //   146: fconst_1
    //   147: lload_1
    //   148: lload_3
    //   149: invokestatic 380	java/lang/Math:max	(JJ)J
    //   152: l2f
    //   153: fmul
    //   154: lload_1
    //   155: lload_3
    //   156: invokestatic 383	java/lang/Math:min	(JJ)J
    //   159: l2f
    //   160: fdiv
    //   161: f2d
    //   162: ldc2_w 384
    //   165: dcmpl
    //   166: iflt +24 -> 190
    //   169: ldc 231
    //   171: ldc_w 387
    //   174: invokestatic 248	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: getstatic 195	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   180: ldc2_w 249
    //   183: ldc2_w 388
    //   186: lconst_1
    //   187: invokevirtual 256	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   190: aload 5
    //   192: invokevirtual 392	com/tencent/mm/media/f/a:release	()V
    //   195: ldc_w 321
    //   198: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: return
    //   202: ldc2_w 176
    //   205: lstore_1
    //   206: goto -130 -> 76
    //   209: ldc2_w 176
    //   212: lstore_3
    //   213: goto -111 -> 102
    //   216: astore 5
    //   218: aload 6
    //   220: astore_0
    //   221: ldc 231
    //   223: aload 5
    //   225: checkcast 394	java/lang/Throwable
    //   228: ldc_w 395
    //   231: iconst_0
    //   232: anewarray 4	java/lang/Object
    //   235: invokestatic 399	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: aload_0
    //   239: ifnull +14 -> 253
    //   242: aload_0
    //   243: invokevirtual 392	com/tencent/mm/media/f/a:release	()V
    //   246: ldc_w 321
    //   249: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: return
    //   253: ldc_w 321
    //   256: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: return
    //   260: astore_0
    //   261: aconst_null
    //   262: astore 5
    //   264: aload 5
    //   266: ifnull +8 -> 274
    //   269: aload 5
    //   271: invokevirtual 392	com/tencent/mm/media/f/a:release	()V
    //   274: ldc_w 321
    //   277: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_0
    //   281: athrow
    //   282: astore_0
    //   283: goto -19 -> 264
    //   286: astore 6
    //   288: aload_0
    //   289: astore 5
    //   291: aload 6
    //   293: astore_0
    //   294: goto -30 -> 264
    //   297: astore 6
    //   299: aload 5
    //   301: astore_0
    //   302: aload 6
    //   304: astore 5
    //   306: goto -85 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString	String
    //   75	131	1	l1	long
    //   101	112	3	l2	long
    //   38	153	5	locala	com.tencent.mm.media.f.a
    //   216	8	5	localException1	Exception
    //   262	43	5	localObject1	Object
    //   28	191	6	localMediaFormat	android.media.MediaFormat
    //   286	6	6	localObject2	Object
    //   297	6	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   30	40	216	java/lang/Exception
    //   30	40	260	finally
    //   40	53	282	finally
    //   57	76	282	finally
    //   81	102	282	finally
    //   102	134	282	finally
    //   146	190	282	finally
    //   221	238	286	finally
    //   40	53	297	java/lang/Exception
    //   57	76	297	java/lang/Exception
    //   81	102	297	java/lang/Exception
    //   102	134	297	java/lang/Exception
    //   146	190	297	java/lang/Exception
  }
  
  public static void aVO()
  {
    AppMethodBeat.i(93892);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
    h.IzE.p(985L, 3L, 1L);
    AppMethodBeat.o(93892);
  }
  
  public static void aVP()
  {
    AppMethodBeat.i(93893);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
    h.IzE.p(985L, 4L, 1L);
    AppMethodBeat.o(93893);
  }
  
  public static void aVQ()
  {
    AppMethodBeat.i(93894);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
    h.IzE.p(985L, 5L, 1L);
    AppMethodBeat.o(93894);
  }
  
  public static void aVR()
  {
    AppMethodBeat.i(93895);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCrop");
    h.IzE.p(985L, 7L, 1L);
    AppMethodBeat.o(93895);
  }
  
  public static void aVS()
  {
    AppMethodBeat.i(93896);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCpuCrop");
    h.IzE.p(985L, 8L, 1L);
    AppMethodBeat.o(93896);
  }
  
  public static void aVT()
  {
    AppMethodBeat.i(93897);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCropFailed");
    h.IzE.p(985L, 10L, 1L);
    AppMethodBeat.o(93897);
  }
  
  public static void aVU()
  {
    AppMethodBeat.i(93898);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.IzE.p(985L, 11L, 1L);
    AppMethodBeat.o(93898);
  }
  
  public static void aVV()
  {
    AppMethodBeat.i(93899);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.IzE.p(985L, 12L, 1L);
    AppMethodBeat.o(93899);
  }
  
  public static void aVW()
  {
    AppMethodBeat.i(93900);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCreateExternalTextureFailed");
    h.IzE.p(985L, 55L, 1L);
    AppMethodBeat.o(93900);
  }
  
  public static void aVX()
  {
    AppMethodBeat.i(93901);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
    laz = -1L;
    h.IzE.p(985L, 30L, 1L);
    AppMethodBeat.o(93901);
  }
  
  public static void aVY()
  {
    AppMethodBeat.i(93902);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
    h.IzE.p(985L, 31L, 1L);
    AppMethodBeat.o(93902);
  }
  
  public static void aVZ()
  {
    AppMethodBeat.i(93903);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
    h.IzE.p(985L, 32L, 1L);
    AppMethodBeat.o(93903);
  }
  
  public static void aWA()
  {
    AppMethodBeat.i(93935);
    h.IzE.idkeyStat(985L, 138L, 1L, false);
    AppMethodBeat.o(93935);
  }
  
  public static void aWB()
  {
    AppMethodBeat.i(93936);
    h.IzE.idkeyStat(985L, 139L, 1L, false);
    AppMethodBeat.o(93936);
  }
  
  public static void aWC()
  {
    AppMethodBeat.i(93937);
    h.IzE.idkeyStat(985L, 143L, 1L, false);
    AppMethodBeat.o(93937);
  }
  
  public static void aWD()
  {
    AppMethodBeat.i(93938);
    h.IzE.idkeyStat(985L, 144L, 1L, false);
    AppMethodBeat.o(93938);
  }
  
  public static void aWE()
  {
    AppMethodBeat.i(93939);
    h.IzE.idkeyStat(985L, 146L, 1L, false);
    AppMethodBeat.o(93939);
  }
  
  public static void aWF()
  {
    AppMethodBeat.i(177318);
    h.IzE.idkeyStat(985L, 147L, 1L, false);
    AppMethodBeat.o(177318);
  }
  
  public static void aWG()
  {
    AppMethodBeat.i(177319);
    h.IzE.idkeyStat(985L, 148L, 1L, false);
    AppMethodBeat.o(177319);
  }
  
  public static void aWH()
  {
    AppMethodBeat.i(93940);
    h.IzE.idkeyStat(985L, 149L, 1L, false);
    AppMethodBeat.o(93940);
  }
  
  public static void aWI()
  {
    AppMethodBeat.i(93941);
    h.IzE.idkeyStat(985L, 150L, 1L, false);
    AppMethodBeat.o(93941);
  }
  
  public static void aWJ()
  {
    AppMethodBeat.i(93942);
    h.IzE.idkeyStat(985L, 151L, 1L, false);
    AppMethodBeat.o(93942);
  }
  
  public static void aWK()
  {
    AppMethodBeat.i(93943);
    h.IzE.idkeyStat(985L, 152L, 1L, false);
    AppMethodBeat.o(93943);
  }
  
  public static void aWL()
  {
    AppMethodBeat.i(93944);
    h.IzE.idkeyStat(985L, 154L, 1L, false);
    AppMethodBeat.o(93944);
  }
  
  public static void aWM()
  {
    AppMethodBeat.i(93946);
    h.IzE.idkeyStat(985L, 159L, 1L, false);
    AppMethodBeat.o(93946);
  }
  
  public static void aWN()
  {
    AppMethodBeat.i(93947);
    h.IzE.idkeyStat(985L, 160L, 1L, false);
    AppMethodBeat.o(93947);
  }
  
  public static void aWO()
  {
    AppMethodBeat.i(93948);
    h.IzE.idkeyStat(985L, 161L, 1L, false);
    AppMethodBeat.o(93948);
  }
  
  public static void aWP()
  {
    AppMethodBeat.i(93949);
    h.IzE.idkeyStat(985L, 162L, 1L, false);
    AppMethodBeat.o(93949);
  }
  
  public static void aWQ()
  {
    AppMethodBeat.i(93950);
    h.IzE.idkeyStat(985L, 163L, 1L, false);
    AppMethodBeat.o(93950);
  }
  
  public static void aWR()
  {
    AppMethodBeat.i(93951);
    h.IzE.idkeyStat(985L, 164L, 1L, false);
    AppMethodBeat.o(93951);
  }
  
  public static void aWS()
  {
    AppMethodBeat.i(93952);
    h.IzE.idkeyStat(985L, 165L, 1L, false);
    AppMethodBeat.o(93952);
  }
  
  public static void aWT()
  {
    AppMethodBeat.i(93953);
    h.IzE.idkeyStat(985L, 166L, 1L, false);
    AppMethodBeat.o(93953);
  }
  
  public static void aWU()
  {
    AppMethodBeat.i(93955);
    h.IzE.idkeyStat(985L, 169L, 1L, false);
    AppMethodBeat.o(93955);
  }
  
  public static void aWV()
  {
    AppMethodBeat.i(93958);
    h.IzE.idkeyStat(985L, 174L, 1L, false);
    AppMethodBeat.o(93958);
  }
  
  public static void aWW()
  {
    AppMethodBeat.i(93960);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseHwHevc");
    h.IzE.idkeyStat(985L, 181L, 1L, false);
    AppMethodBeat.o(93960);
  }
  
  public static void aWX()
  {
    AppMethodBeat.i(93961);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseSwHevc");
    h.IzE.idkeyStat(985L, 182L, 1L, false);
    AppMethodBeat.o(93961);
  }
  
  public static void aWY()
  {
    AppMethodBeat.i(93963);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
    h.IzE.p(986L, 7L, 1L);
    AppMethodBeat.o(93963);
  }
  
  public static void aWZ()
  {
    AppMethodBeat.i(93964);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
    h.IzE.p(986L, 10L, 1L);
    AppMethodBeat.o(93964);
  }
  
  public static void aWa()
  {
    AppMethodBeat.i(93904);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
    h.IzE.p(985L, 33L, 1L);
    AppMethodBeat.o(93904);
  }
  
  public static void aWb()
  {
    AppMethodBeat.i(93905);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
    laA = Util.currentTicks();
    AppMethodBeat.o(93905);
  }
  
  public static void aWc()
  {
    AppMethodBeat.i(93906);
    if (laA > 0L)
    {
      long l = Util.ticksToNow(laA);
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264WaitStop, waitTime:".concat(String.valueOf(l)));
      h.IzE.p(985L, 34L, l);
      h.IzE.p(985L, 35L, 1L);
      laA = -1L;
    }
    AppMethodBeat.o(93906);
  }
  
  public static void aWd()
  {
    AppMethodBeat.i(93907);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
    h.IzE.p(985L, 37L, 1L);
    AppMethodBeat.o(93907);
  }
  
  public static void aWe()
  {
    AppMethodBeat.i(93908);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
    h.IzE.p(985L, 39L, 1L);
    AppMethodBeat.o(93908);
  }
  
  public static void aWf()
  {
    AppMethodBeat.i(93910);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
    laA = -1L;
    h.IzE.p(985L, 13L, 1L);
    AppMethodBeat.o(93910);
  }
  
  public static void aWg()
  {
    AppMethodBeat.i(93911);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
    h.IzE.p(985L, 14L, 1L);
    AppMethodBeat.o(93911);
  }
  
  public static void aWh()
  {
    AppMethodBeat.i(93912);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
    h.IzE.p(985L, 15L, 1L);
    AppMethodBeat.o(93912);
  }
  
  public static void aWi()
  {
    AppMethodBeat.i(93913);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
    h.IzE.p(985L, 16L, 1L);
    AppMethodBeat.o(93913);
  }
  
  public static void aWj()
  {
    AppMethodBeat.i(93914);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
    laA = Util.currentTicks();
    AppMethodBeat.o(93914);
  }
  
  public static void aWk()
  {
    AppMethodBeat.i(93915);
    if (laA > 0L)
    {
      long l = Util.ticksToNow(laA);
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWaitStop, waitTime:".concat(String.valueOf(l)));
      h.IzE.p(985L, 17L, l);
      h.IzE.p(985L, 18L, 1L);
      laA = -1L;
    }
    AppMethodBeat.o(93915);
  }
  
  public static void aWl()
  {
    AppMethodBeat.i(93916);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
    h.IzE.p(985L, 20L, 1L);
    AppMethodBeat.o(93916);
  }
  
  public static void aWm()
  {
    AppMethodBeat.i(93917);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
    h.IzE.p(985L, 22L, 1L);
    AppMethodBeat.o(93917);
  }
  
  public static void aWn()
  {
    AppMethodBeat.i(93919);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecYUVInitError");
    h.IzE.p(985L, 26L, 1L);
    AppMethodBeat.o(93919);
  }
  
  public static void aWo()
  {
    AppMethodBeat.i(93920);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWriteYUVError");
    h.IzE.p(985L, 27L, 1L);
    AppMethodBeat.o(93920);
  }
  
  public static void aWp()
  {
    AppMethodBeat.i(93922);
    h.IzE.idkeyStat(985L, 118L, 1L, false);
    AppMethodBeat.o(93922);
  }
  
  public static void aWq()
  {
    AppMethodBeat.i(93923);
    h.IzE.idkeyStat(985L, 119L, 1L, false);
    AppMethodBeat.o(93923);
  }
  
  public static void aWr()
  {
    AppMethodBeat.i(93924);
    h.IzE.idkeyStat(985L, 120L, 1L, false);
    AppMethodBeat.o(93924);
  }
  
  public static void aWs()
  {
    AppMethodBeat.i(93925);
    h.IzE.idkeyStat(985L, 121L, 1L, false);
    AppMethodBeat.o(93925);
  }
  
  public static void aWt()
  {
    AppMethodBeat.i(93927);
    h.IzE.idkeyStat(985L, 124L, 1L, false);
    AppMethodBeat.o(93927);
  }
  
  public static void aWu()
  {
    AppMethodBeat.i(93928);
    h.IzE.idkeyStat(985L, 125L, 1L, false);
    AppMethodBeat.o(93928);
  }
  
  public static void aWv()
  {
    AppMethodBeat.i(93929);
    h.IzE.idkeyStat(985L, 126L, 1L, false);
    AppMethodBeat.o(93929);
  }
  
  public static void aWw()
  {
    AppMethodBeat.i(93930);
    h.IzE.idkeyStat(985L, 127L, 1L, false);
    AppMethodBeat.o(93930);
  }
  
  public static void aWx()
  {
    AppMethodBeat.i(93932);
    h.IzE.idkeyStat(985L, 130L, 1L, false);
    AppMethodBeat.o(93932);
  }
  
  public static void aWy()
  {
    AppMethodBeat.i(93933);
    h.IzE.idkeyStat(985L, 135L, 1L, false);
    AppMethodBeat.o(93933);
  }
  
  public static void aWz()
  {
    AppMethodBeat.i(93934);
    h.IzE.idkeyStat(985L, 136L, 1L, false);
    AppMethodBeat.o(93934);
  }
  
  public static void aXA()
  {
    AppMethodBeat.i(93997);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberCheckTimeout");
    h.IzE.p(986L, 91L, 1L);
    AppMethodBeat.o(93997);
  }
  
  public static void aXB()
  {
    AppMethodBeat.i(93998);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxX264Encode");
    h.IzE.p(986L, 100L, 1L);
    AppMethodBeat.o(93998);
  }
  
  public static void aXC()
  {
    AppMethodBeat.i(93999);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseSwHevc");
    h.IzE.p(986L, 123L, 1L);
    AppMethodBeat.o(93999);
  }
  
  public static void aXD()
  {
    AppMethodBeat.i(94000);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseHwHevc");
    h.IzE.p(986L, 124L, 1L);
    AppMethodBeat.o(94000);
  }
  
  public static void aXa()
  {
    AppMethodBeat.i(93965);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
    h.IzE.p(986L, 11L, 1L);
    AppMethodBeat.o(93965);
  }
  
  public static void aXb()
  {
    AppMethodBeat.i(93968);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
    h.IzE.p(986L, 14L, 1L);
    AppMethodBeat.o(93968);
  }
  
  public static void aXc()
  {
    AppMethodBeat.i(93969);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
    h.IzE.p(986L, 15L, 1L);
    AppMethodBeat.o(93969);
  }
  
  public static void aXd()
  {
    AppMethodBeat.i(93970);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
    h.IzE.p(986L, 16L, 1L);
    AppMethodBeat.o(93970);
  }
  
  public static void aXe()
  {
    AppMethodBeat.i(93971);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
    h.IzE.p(986L, 17L, 1L);
    AppMethodBeat.o(93971);
  }
  
  public static void aXf()
  {
    AppMethodBeat.i(93972);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
    h.IzE.p(986L, 18L, 1L);
    AppMethodBeat.o(93972);
  }
  
  public static void aXg()
  {
    AppMethodBeat.i(93973);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
    h.IzE.p(986L, 19L, 1L);
    AppMethodBeat.o(93973);
  }
  
  public static void aXh()
  {
    AppMethodBeat.i(93974);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
    h.IzE.p(986L, 22L, 1L);
    AppMethodBeat.o(93974);
  }
  
  public static void aXi()
  {
    AppMethodBeat.i(93975);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
    h.IzE.p(986L, 23L, 1L);
    AppMethodBeat.o(93975);
  }
  
  public static void aXj()
  {
    AppMethodBeat.i(93976);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
    h.IzE.p(986L, 24L, 1L);
    AppMethodBeat.o(93976);
  }
  
  public static void aXk()
  {
    AppMethodBeat.i(93977);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
    h.IzE.p(986L, 26L, 1L);
    AppMethodBeat.o(93977);
  }
  
  public static void aXl()
  {
    AppMethodBeat.i(93979);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
    h.IzE.p(986L, 30L, 1L);
    AppMethodBeat.o(93979);
  }
  
  public static void aXm()
  {
    AppMethodBeat.i(93983);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
    h.IzE.p(986L, 53L, 1L);
    AppMethodBeat.o(93983);
  }
  
  public static void aXn()
  {
    AppMethodBeat.i(93984);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
    h.IzE.p(986L, 25L, 1L);
    AppMethodBeat.o(93984);
  }
  
  public static void aXo()
  {
    AppMethodBeat.i(93985);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
    h.IzE.p(986L, 76L, 1L);
    AppMethodBeat.o(93985);
  }
  
  public static void aXp()
  {
    AppMethodBeat.i(93986);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
    h.IzE.p(986L, 80L, 1L);
    AppMethodBeat.o(93986);
  }
  
  public static void aXq()
  {
    AppMethodBeat.i(93987);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
    h.IzE.p(986L, 80L, 1L);
    AppMethodBeat.o(93987);
  }
  
  public static void aXr()
  {
    AppMethodBeat.i(93988);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
    h.IzE.p(986L, 77L, 1L);
    AppMethodBeat.o(93988);
  }
  
  public static void aXs()
  {
    AppMethodBeat.i(93989);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
    h.IzE.p(986L, 81L, 1L);
    AppMethodBeat.o(93989);
  }
  
  public static void aXt()
  {
    AppMethodBeat.i(93990);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
    h.IzE.p(986L, 78L, 1L);
    AppMethodBeat.o(93990);
  }
  
  public static void aXu()
  {
    AppMethodBeat.i(93991);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
    h.IzE.p(986L, 82L, 1L);
    AppMethodBeat.o(93991);
  }
  
  public static void aXv()
  {
    AppMethodBeat.i(93992);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
    h.IzE.p(986L, 83L, 1L);
    AppMethodBeat.o(93992);
  }
  
  public static void aXw()
  {
    AppMethodBeat.i(93993);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
    h.IzE.p(986L, 84L, 1L);
    AppMethodBeat.o(93993);
  }
  
  public static void aXx()
  {
    AppMethodBeat.i(93994);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
    h.IzE.p(986L, 54L, 1L);
    AppMethodBeat.o(93994);
  }
  
  public static void aXy()
  {
    AppMethodBeat.i(93995);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
    h.IzE.p(986L, 86L, 1L);
    AppMethodBeat.o(93995);
  }
  
  public static void aXz()
  {
    AppMethodBeat.i(93996);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberMatch");
    h.IzE.p(986L, 90L, 1L);
    AppMethodBeat.o(93996);
  }
  
  public static void dA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93918);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.IzE.p(985L, 21L, paramInt1);
    h.IzE.p(985L, 24L, paramInt2);
    AppMethodBeat.o(93918);
  }
  
  public static void dz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93909);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.IzE.p(985L, 38L, paramInt1);
    h.IzE.p(985L, 41L, paramInt2);
    AppMethodBeat.o(93909);
  }
  
  public static void g(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(93982);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + paramLong1 + ", fps:" + paramLong2 + ", originVideoFps:" + paramLong3);
    h.IzE.p(986L, 43L, paramLong3);
    h.IzE.p(986L, 45L, paramLong2);
    h.IzE.p(986L, 48L, paramLong1);
    AppMethodBeat.o(93982);
  }
  
  public static void o(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93921);
    p.k(paramString, "filePath");
    for (;;)
    {
      Object localObject;
      int i1;
      int j;
      int i;
      int k;
      try
      {
        if ((Util.isNullOrNil(paramString)) || (!u.agG(paramString)))
        {
          AppMethodBeat.o(93921);
          return;
        }
        h.IzE.idkeyStat(985L, 69L, 1L, false);
        localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString));
        i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(((JSONObject)localObject).optInt("videoBitrate")), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        j = 89;
        m = 104;
        if (paramInt1 != 1) {
          break label324;
        }
        h.IzE.idkeyStat(985L, 71L, 1L, false);
        h.IzE.idkeyStat(985L, 73L, i1, false);
        i = 74;
        j = 95;
        paramInt1 = 98;
        k = 108;
        m = 107;
      }
      catch (Exception paramString)
      {
        int m;
        Log.e("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(93921);
        return;
      }
      h.IzE.idkeyStat(985L, paramInt2, 1L, false);
      h.IzE.idkeyStat(985L, paramInt1, i1, false);
      h.IzE.idkeyStat(985L, m, 1L, false);
      h.IzE.idkeyStat(985L, k, i1, false);
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { paramString, Integer.valueOf(i) });
      if ((i1 >= 0) && (i1 <= 10))
      {
        h.IzE.idkeyStat(985L, i, 1L, false);
        AppMethodBeat.o(93921);
        return;
        label324:
        h.IzE.idkeyStat(985L, 70L, 1L, false);
        h.IzE.idkeyStat(985L, 72L, i1, false);
        k = 105;
        int n = 86;
        i = 57;
        paramInt1 = j;
        j = n;
      }
      while (paramInt2 != 720)
      {
        localObject = j.EZX;
        p.j(localObject, "MMSightRecorderConfig.parameter");
        if (((o)localObject).eTz()) {
          break label543;
        }
        if (paramInt2 == 1080)
        {
          break label543;
          if ((i1 > 10) && (i1 <= 15))
          {
            h.IzE.idkeyStat(985L, i + 1, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 15) && (i1 <= 20))
          {
            h.IzE.idkeyStat(985L, i + 2, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 20) && (i1 <= 30)) {
            h.IzE.idkeyStat(985L, i + 3, 1L, false);
          }
          AppMethodBeat.o(93921);
          return;
        }
        paramInt2 = j;
        break;
      }
      paramInt1 += 1;
      paramInt2 = j + 1;
      i += 4;
      continue;
      label543:
      paramInt1 += 2;
      paramInt2 = j + 2;
      i += 8;
    }
  }
  
  public static void uf(int paramInt)
  {
    AppMethodBeat.i(93962);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, mixType:".concat(String.valueOf(paramInt)));
    h.IzE.p(986L, 0L, 1L);
    if (paramInt == 1)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
      h.IzE.p(986L, 1L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 3)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
      h.IzE.p(986L, 2L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 2)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
      h.IzE.p(986L, 3L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
      h.IzE.p(986L, 4L, 1L);
    }
    AppMethodBeat.o(93962);
  }
  
  public static void y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93981);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + paramInt + ", time:" + paramLong);
    h.IzE.p(986L, 34L, 1L);
    if (paramInt == 1)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeNoMusic, time:".concat(String.valueOf(paramLong)));
      h.IzE.p(986L, 35L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 3)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeAll, time:".concat(String.valueOf(paramLong)));
      h.IzE.p(986L, 41L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 2)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeMusicOnly, time:".concat(String.valueOf(paramLong)));
      h.IzE.p(986L, 37L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeSlient, time:".concat(String.valueOf(paramLong)));
      h.IzE.p(986L, 39L, paramLong);
    }
    AppMethodBeat.o(93981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.k.f
 * JD-Core Version:    0.7.0.1
 */