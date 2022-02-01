package com.tencent.mm.media.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markAfterCaptureFinish", "", "filePath", "recorderType", "", "resolutionLimit", "markBaseRecordBitrate", "bitrate", "markBaseRecordFps", "fps", "markBaseRecordSuccessTimes", "markC2cCaptureJumpRemux", "markCameraOpen", "markCameraOpenFailed", "markCameraOpenSuccess", "markCaptureUseHwHevc", "markCaptureUseSwHevc", "markCheckRemuxResult", "path", "markCpuCrop", "markCreateExternalTextureFailed", "markDaemonRecordBitrate", "markDaemonRecordFps", "markDaemonRecordSuccessTimes", "markDoubleRemux", "markDoubleRemuxTimeCost", "time", "markEditErrorPath", "markEditPhoto", "markEditPhotoCost", "cost", "markEditPhotoFail", "markEditPhotoFailNullBitmap", "markEditToRecord", "markEglVersion2", "markEglVersion3", "markEncodeCreateSuccessTimes", "markEncodeCreateTimes", "markFallbackCreateEgl2", "markFrameHandlingTime", "markGpuCrop", "markGpuCropFailed", "markLayoutError", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markMediaCodecWriteYUVError", "markMediaCodecYUVInitError", "markMp4EncoderCreate", "markMp4EncoderRelease", "markPhotoCapture", "markPhotoCaptureFail", "markPhotoEdit", "markPhotoEdited", "markPhotoTimeCost", "markRecordCancelTimes", "markRecordTimes", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckBFrameCost", "markRemuxCheckBFrameFailed", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCheckHasBFrame", "markRemuxCheckHasBFrameTimeout", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxEncoderCreate", "markRemuxEncoderRelease", "markRemuxEndWithFrameNumberCheckTimeout", "markRemuxEndWithFrameNumberMatch", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxUseHwHevc", "markRemuxUseSwHevc", "markRemuxVideoParaError", "markRemuxX264Encode", "markReserveEncoder", "markSavePhotoFail", "markSnsCaptureJumpRemux", "markStartBaseRecordTimeout", "markStartDaemonRecordSuccessTimes", "markStartDaemonRecordTimeout", "markStartDaemonRecordTimes", "markSyncEncoderCreate", "markSyncEncoderRelease", "markVideoEdited", "markVideoGenerate", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "markaSyncEncoderCreate", "markaSyncEncoderRelease", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f nFE;
  private static long nFF;
  private static long nFG;
  
  static
  {
    AppMethodBeat.i(94001);
    nFE = new f();
    nFF = -1L;
    nFG = -1L;
    AppMethodBeat.o(94001);
  }
  
  public static void B(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93981);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + paramInt + ", time:" + paramLong);
    h.OAn.p(986L, 34L, 1L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(93981);
      return;
      Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markRemuxTimeNoMusic, time:", Long.valueOf(paramLong)));
      h.OAn.p(986L, 35L, paramLong);
      AppMethodBeat.o(93981);
      return;
      Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markRemuxTimeAll, time:", Long.valueOf(paramLong)));
      h.OAn.p(986L, 41L, paramLong);
      AppMethodBeat.o(93981);
      return;
      Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markRemuxTimeMusicOnly, time:", Long.valueOf(paramLong)));
      h.OAn.p(986L, 37L, paramLong);
      AppMethodBeat.o(93981);
      return;
      Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markRemuxTimeSlient, time:", Long.valueOf(paramLong)));
      h.OAn.p(986L, 39L, paramLong);
    }
  }
  
  /* Error */
  public static void GT(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc_w 269
    //   5: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc_w 270
    //   12: invokestatic 274	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokestatic 280	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   19: ifne +10 -> 29
    //   22: ldc_w 269
    //   25: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: return
    //   29: aconst_null
    //   30: astore 8
    //   32: new 282	com/tencent/mm/media/f/a
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 283	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   40: astore 7
    //   42: aload 7
    //   44: getfield 287	com/tencent/mm/media/f/a:nAt	Landroid/media/MediaFormat;
    //   47: astore_0
    //   48: aload 7
    //   50: getfield 290	com/tencent/mm/media/f/a:nAs	Landroid/media/MediaFormat;
    //   53: astore 8
    //   55: aload_0
    //   56: ifnull +165 -> 221
    //   59: aload_0
    //   60: ldc_w 292
    //   63: invokevirtual 297	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   66: iconst_1
    //   67: if_icmpne +154 -> 221
    //   70: iconst_1
    //   71: istore_1
    //   72: iload_1
    //   73: ifeq +153 -> 226
    //   76: aload_0
    //   77: ldc_w 292
    //   80: invokevirtual 301	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   83: lstore_3
    //   84: aload 8
    //   86: ifnull +147 -> 233
    //   89: aload 8
    //   91: ldc_w 292
    //   94: invokevirtual 297	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   97: iconst_1
    //   98: if_icmpne +135 -> 233
    //   101: iload_2
    //   102: istore_1
    //   103: iload_1
    //   104: ifeq +134 -> 238
    //   107: aload 8
    //   109: ldc_w 292
    //   112: invokevirtual 301	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   115: lstore 5
    //   117: ldc 195
    //   119: new 197	java/lang/StringBuilder
    //   122: dup
    //   123: ldc_w 303
    //   126: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: lload 5
    //   131: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: ldc_w 305
    //   137: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: lload_3
    //   141: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: lload_3
    //   151: lconst_0
    //   152: lcmp
    //   153: ifle +56 -> 209
    //   156: lload 5
    //   158: lconst_0
    //   159: lcmp
    //   160: ifle +49 -> 209
    //   163: fconst_1
    //   164: lload_3
    //   165: lload 5
    //   167: invokestatic 311	java/lang/Math:max	(JJ)J
    //   170: l2f
    //   171: fmul
    //   172: lload_3
    //   173: lload 5
    //   175: invokestatic 314	java/lang/Math:min	(JJ)J
    //   178: l2f
    //   179: fdiv
    //   180: f2d
    //   181: ldc2_w 315
    //   184: dcmpl
    //   185: iflt +24 -> 209
    //   188: ldc 195
    //   190: ldc_w 318
    //   193: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: getstatic 229	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   199: ldc2_w 230
    //   202: ldc2_w 319
    //   205: lconst_1
    //   206: invokevirtual 237	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   209: aload 7
    //   211: invokevirtual 323	com/tencent/mm/media/f/a:release	()V
    //   214: ldc_w 269
    //   217: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: return
    //   221: iconst_0
    //   222: istore_1
    //   223: goto -151 -> 72
    //   226: ldc2_w 180
    //   229: lstore_3
    //   230: goto -146 -> 84
    //   233: iconst_0
    //   234: istore_1
    //   235: goto -132 -> 103
    //   238: ldc2_w 180
    //   241: lstore 5
    //   243: goto -126 -> 117
    //   246: astore 7
    //   248: aload 8
    //   250: astore_0
    //   251: ldc 195
    //   253: aload 7
    //   255: checkcast 325	java/lang/Throwable
    //   258: ldc_w 326
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload_0
    //   269: ifnull +7 -> 276
    //   272: aload_0
    //   273: invokevirtual 323	com/tencent/mm/media/f/a:release	()V
    //   276: ldc_w 269
    //   279: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: return
    //   283: astore_0
    //   284: aconst_null
    //   285: astore 7
    //   287: aload 7
    //   289: ifnull +8 -> 297
    //   292: aload 7
    //   294: invokevirtual 323	com/tencent/mm/media/f/a:release	()V
    //   297: ldc_w 269
    //   300: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: aload_0
    //   304: athrow
    //   305: astore_0
    //   306: goto -19 -> 287
    //   309: astore 8
    //   311: aload_0
    //   312: astore 7
    //   314: aload 8
    //   316: astore_0
    //   317: goto -30 -> 287
    //   320: astore 8
    //   322: aload 7
    //   324: astore_0
    //   325: aload 8
    //   327: astore 7
    //   329: goto -78 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramString	String
    //   71	164	1	i	int
    //   1	101	2	j	int
    //   83	147	3	l1	long
    //   115	127	5	l2	long
    //   40	170	7	locala	com.tencent.mm.media.f.a
    //   246	8	7	localException1	Exception
    //   285	43	7	localObject1	Object
    //   30	219	8	localMediaFormat	android.media.MediaFormat
    //   309	6	8	localObject2	Object
    //   320	6	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   32	42	246	java/lang/Exception
    //   32	42	283	finally
    //   42	55	305	finally
    //   59	70	305	finally
    //   76	84	305	finally
    //   89	101	305	finally
    //   107	117	305	finally
    //   117	150	305	finally
    //   163	209	305	finally
    //   251	268	309	finally
    //   42	55	320	java/lang/Exception
    //   59	70	320	java/lang/Exception
    //   76	84	320	java/lang/Exception
    //   89	101	320	java/lang/Exception
    //   107	117	320	java/lang/Exception
    //   117	150	320	java/lang/Exception
    //   163	209	320	java/lang/Exception
  }
  
  public static void bqA()
  {
    AppMethodBeat.i(93897);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCropFailed");
    h.OAn.p(985L, 10L, 1L);
    AppMethodBeat.o(93897);
  }
  
  public static void bqB()
  {
    AppMethodBeat.i(93898);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.OAn.p(985L, 11L, 1L);
    AppMethodBeat.o(93898);
  }
  
  public static void bqC()
  {
    AppMethodBeat.i(93899);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.OAn.p(985L, 12L, 1L);
    AppMethodBeat.o(93899);
  }
  
  public static void bqD()
  {
    AppMethodBeat.i(236973);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markFallbackCreateEgl2");
    h.OAn.p(985L, 189L, 1L);
    AppMethodBeat.o(236973);
  }
  
  public static void bqE()
  {
    AppMethodBeat.i(93900);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCreateExternalTextureFailed");
    h.OAn.p(985L, 55L, 1L);
    AppMethodBeat.o(93900);
  }
  
  public static void bqF()
  {
    AppMethodBeat.i(93901);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
    nFF = -1L;
    h.OAn.p(985L, 30L, 1L);
    AppMethodBeat.o(93901);
  }
  
  public static void bqG()
  {
    AppMethodBeat.i(93902);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
    h.OAn.p(985L, 31L, 1L);
    AppMethodBeat.o(93902);
  }
  
  public static void bqH()
  {
    AppMethodBeat.i(93903);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
    h.OAn.p(985L, 32L, 1L);
    AppMethodBeat.o(93903);
  }
  
  public static void bqI()
  {
    AppMethodBeat.i(93904);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
    h.OAn.p(985L, 33L, 1L);
    AppMethodBeat.o(93904);
  }
  
  public static void bqJ()
  {
    AppMethodBeat.i(93905);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
    nFG = Util.currentTicks();
    AppMethodBeat.o(93905);
  }
  
  public static void bqK()
  {
    AppMethodBeat.i(93906);
    if (nFG > 0L)
    {
      long l = Util.ticksToNow(nFG);
      Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markX264WaitStop, waitTime:", Long.valueOf(l)));
      h.OAn.p(985L, 34L, l);
      h.OAn.p(985L, 35L, 1L);
      nFG = -1L;
    }
    AppMethodBeat.o(93906);
  }
  
  public static void bqL()
  {
    AppMethodBeat.i(93907);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
    h.OAn.p(985L, 37L, 1L);
    AppMethodBeat.o(93907);
  }
  
  public static void bqM()
  {
    AppMethodBeat.i(93908);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
    h.OAn.p(985L, 39L, 1L);
    AppMethodBeat.o(93908);
  }
  
  public static void bqN()
  {
    AppMethodBeat.i(93910);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
    nFG = -1L;
    h.OAn.p(985L, 13L, 1L);
    AppMethodBeat.o(93910);
  }
  
  public static void bqO()
  {
    AppMethodBeat.i(93911);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
    h.OAn.p(985L, 14L, 1L);
    AppMethodBeat.o(93911);
  }
  
  public static void bqP()
  {
    AppMethodBeat.i(93912);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
    h.OAn.p(985L, 15L, 1L);
    AppMethodBeat.o(93912);
  }
  
  public static void bqQ()
  {
    AppMethodBeat.i(93913);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
    h.OAn.p(985L, 16L, 1L);
    AppMethodBeat.o(93913);
  }
  
  public static void bqR()
  {
    AppMethodBeat.i(93914);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
    nFG = Util.currentTicks();
    AppMethodBeat.o(93914);
  }
  
  public static void bqS()
  {
    AppMethodBeat.i(93915);
    if (nFG > 0L)
    {
      long l = Util.ticksToNow(nFG);
      Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markMediaCodecWaitStop, waitTime:", Long.valueOf(l)));
      h.OAn.p(985L, 17L, l);
      h.OAn.p(985L, 18L, 1L);
      nFG = -1L;
    }
    AppMethodBeat.o(93915);
  }
  
  public static void bqT()
  {
    AppMethodBeat.i(93916);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
    h.OAn.p(985L, 20L, 1L);
    AppMethodBeat.o(93916);
  }
  
  public static void bqU()
  {
    AppMethodBeat.i(93917);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
    h.OAn.p(985L, 22L, 1L);
    AppMethodBeat.o(93917);
  }
  
  public static void bqV()
  {
    AppMethodBeat.i(93919);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecYUVInitError");
    h.OAn.p(985L, 26L, 1L);
    AppMethodBeat.o(93919);
  }
  
  public static void bqW()
  {
    AppMethodBeat.i(93920);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWriteYUVError");
    h.OAn.p(985L, 27L, 1L);
    AppMethodBeat.o(93920);
  }
  
  public static void bqX()
  {
    AppMethodBeat.i(93922);
    h.OAn.idkeyStat(985L, 118L, 1L, false);
    AppMethodBeat.o(93922);
  }
  
  public static void bqY()
  {
    AppMethodBeat.i(93923);
    h.OAn.idkeyStat(985L, 119L, 1L, false);
    AppMethodBeat.o(93923);
  }
  
  public static void bqZ()
  {
    AppMethodBeat.i(93924);
    h.OAn.idkeyStat(985L, 120L, 1L, false);
    AppMethodBeat.o(93924);
  }
  
  public static void bqv()
  {
    AppMethodBeat.i(93892);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
    h.OAn.p(985L, 3L, 1L);
    AppMethodBeat.o(93892);
  }
  
  public static void bqw()
  {
    AppMethodBeat.i(93893);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
    h.OAn.p(985L, 4L, 1L);
    AppMethodBeat.o(93893);
  }
  
  public static void bqx()
  {
    AppMethodBeat.i(93894);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
    h.OAn.p(985L, 5L, 1L);
    AppMethodBeat.o(93894);
  }
  
  public static void bqy()
  {
    AppMethodBeat.i(93895);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCrop");
    h.OAn.p(985L, 7L, 1L);
    AppMethodBeat.o(93895);
  }
  
  public static void bqz()
  {
    AppMethodBeat.i(93896);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCpuCrop");
    h.OAn.p(985L, 8L, 1L);
    AppMethodBeat.o(93896);
  }
  
  public static void brA()
  {
    AppMethodBeat.i(93952);
    h.OAn.idkeyStat(985L, 165L, 1L, false);
    AppMethodBeat.o(93952);
  }
  
  public static void brB()
  {
    AppMethodBeat.i(93953);
    h.OAn.idkeyStat(985L, 166L, 1L, false);
    AppMethodBeat.o(93953);
  }
  
  public static void brC()
  {
    AppMethodBeat.i(93955);
    h.OAn.idkeyStat(985L, 169L, 1L, false);
    AppMethodBeat.o(93955);
  }
  
  public static void brD()
  {
    AppMethodBeat.i(93958);
    h.OAn.idkeyStat(985L, 174L, 1L, false);
    AppMethodBeat.o(93958);
  }
  
  public static void brE()
  {
    AppMethodBeat.i(93960);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseHwHevc");
    h.OAn.idkeyStat(985L, 181L, 1L, false);
    AppMethodBeat.o(93960);
  }
  
  public static void brF()
  {
    AppMethodBeat.i(93961);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseSwHevc");
    h.OAn.idkeyStat(985L, 182L, 1L, false);
    AppMethodBeat.o(93961);
  }
  
  public static void brG()
  {
    AppMethodBeat.i(93963);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
    h.OAn.p(986L, 7L, 1L);
    AppMethodBeat.o(93963);
  }
  
  public static void brH()
  {
    AppMethodBeat.i(93964);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
    h.OAn.p(986L, 10L, 1L);
    AppMethodBeat.o(93964);
  }
  
  public static void brI()
  {
    AppMethodBeat.i(93965);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
    h.OAn.p(986L, 11L, 1L);
    AppMethodBeat.o(93965);
  }
  
  public static void brJ()
  {
    AppMethodBeat.i(93968);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
    h.OAn.p(986L, 14L, 1L);
    AppMethodBeat.o(93968);
  }
  
  public static void brK()
  {
    AppMethodBeat.i(93969);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
    h.OAn.p(986L, 15L, 1L);
    AppMethodBeat.o(93969);
  }
  
  public static void brL()
  {
    AppMethodBeat.i(93970);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
    h.OAn.p(986L, 16L, 1L);
    AppMethodBeat.o(93970);
  }
  
  public static void brM()
  {
    AppMethodBeat.i(93971);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
    h.OAn.p(986L, 17L, 1L);
    AppMethodBeat.o(93971);
  }
  
  public static void brN()
  {
    AppMethodBeat.i(93972);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
    h.OAn.p(986L, 18L, 1L);
    AppMethodBeat.o(93972);
  }
  
  public static void brO()
  {
    AppMethodBeat.i(93973);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
    h.OAn.p(986L, 19L, 1L);
    AppMethodBeat.o(93973);
  }
  
  public static void brP()
  {
    AppMethodBeat.i(93974);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
    h.OAn.p(986L, 22L, 1L);
    AppMethodBeat.o(93974);
  }
  
  public static void brQ()
  {
    AppMethodBeat.i(93975);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
    h.OAn.p(986L, 23L, 1L);
    AppMethodBeat.o(93975);
  }
  
  public static void brR()
  {
    AppMethodBeat.i(93976);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
    h.OAn.p(986L, 24L, 1L);
    AppMethodBeat.o(93976);
  }
  
  public static void brS()
  {
    AppMethodBeat.i(93977);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
    h.OAn.p(986L, 26L, 1L);
    AppMethodBeat.o(93977);
  }
  
  public static void brT()
  {
    AppMethodBeat.i(93979);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
    h.OAn.p(986L, 30L, 1L);
    AppMethodBeat.o(93979);
  }
  
  public static void brU()
  {
    AppMethodBeat.i(93983);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
    h.OAn.p(986L, 53L, 1L);
    AppMethodBeat.o(93983);
  }
  
  public static void brV()
  {
    AppMethodBeat.i(93984);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
    h.OAn.p(986L, 25L, 1L);
    AppMethodBeat.o(93984);
  }
  
  public static void brW()
  {
    AppMethodBeat.i(93985);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
    h.OAn.p(986L, 76L, 1L);
    AppMethodBeat.o(93985);
  }
  
  public static void brX()
  {
    AppMethodBeat.i(93986);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
    h.OAn.p(986L, 80L, 1L);
    AppMethodBeat.o(93986);
  }
  
  public static void brY()
  {
    AppMethodBeat.i(93987);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
    h.OAn.p(986L, 80L, 1L);
    AppMethodBeat.o(93987);
  }
  
  public static void brZ()
  {
    AppMethodBeat.i(93988);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
    h.OAn.p(986L, 77L, 1L);
    AppMethodBeat.o(93988);
  }
  
  public static void bra()
  {
    AppMethodBeat.i(93925);
    h.OAn.idkeyStat(985L, 121L, 1L, false);
    AppMethodBeat.o(93925);
  }
  
  public static void brb()
  {
    AppMethodBeat.i(93927);
    h.OAn.idkeyStat(985L, 124L, 1L, false);
    AppMethodBeat.o(93927);
  }
  
  public static void brc()
  {
    AppMethodBeat.i(93928);
    h.OAn.idkeyStat(985L, 125L, 1L, false);
    AppMethodBeat.o(93928);
  }
  
  public static void brd()
  {
    AppMethodBeat.i(93929);
    h.OAn.idkeyStat(985L, 126L, 1L, false);
    AppMethodBeat.o(93929);
  }
  
  public static void bre()
  {
    AppMethodBeat.i(93930);
    h.OAn.idkeyStat(985L, 127L, 1L, false);
    AppMethodBeat.o(93930);
  }
  
  public static void brf()
  {
    AppMethodBeat.i(93932);
    h.OAn.idkeyStat(985L, 130L, 1L, false);
    AppMethodBeat.o(93932);
  }
  
  public static void brg()
  {
    AppMethodBeat.i(93933);
    h.OAn.idkeyStat(985L, 135L, 1L, false);
    AppMethodBeat.o(93933);
  }
  
  public static void brh()
  {
    AppMethodBeat.i(93934);
    h.OAn.idkeyStat(985L, 136L, 1L, false);
    AppMethodBeat.o(93934);
  }
  
  public static void bri()
  {
    AppMethodBeat.i(93935);
    h.OAn.idkeyStat(985L, 138L, 1L, false);
    AppMethodBeat.o(93935);
  }
  
  public static void brj()
  {
    AppMethodBeat.i(93936);
    h.OAn.idkeyStat(985L, 139L, 1L, false);
    AppMethodBeat.o(93936);
  }
  
  public static void brk()
  {
    AppMethodBeat.i(93937);
    h.OAn.idkeyStat(985L, 143L, 1L, false);
    AppMethodBeat.o(93937);
  }
  
  public static void brl()
  {
    AppMethodBeat.i(93938);
    h.OAn.idkeyStat(985L, 144L, 1L, false);
    AppMethodBeat.o(93938);
  }
  
  public static void brm()
  {
    AppMethodBeat.i(93939);
    h.OAn.idkeyStat(985L, 146L, 1L, false);
    AppMethodBeat.o(93939);
  }
  
  public static void brn()
  {
    AppMethodBeat.i(177318);
    h.OAn.idkeyStat(985L, 147L, 1L, false);
    AppMethodBeat.o(177318);
  }
  
  public static void bro()
  {
    AppMethodBeat.i(177319);
    h.OAn.idkeyStat(985L, 148L, 1L, false);
    AppMethodBeat.o(177319);
  }
  
  public static void brp()
  {
    AppMethodBeat.i(93940);
    h.OAn.idkeyStat(985L, 149L, 1L, false);
    AppMethodBeat.o(93940);
  }
  
  public static void brq()
  {
    AppMethodBeat.i(93941);
    h.OAn.idkeyStat(985L, 150L, 1L, false);
    AppMethodBeat.o(93941);
  }
  
  public static void brr()
  {
    AppMethodBeat.i(93942);
    h.OAn.idkeyStat(985L, 151L, 1L, false);
    AppMethodBeat.o(93942);
  }
  
  public static void brs()
  {
    AppMethodBeat.i(93943);
    h.OAn.idkeyStat(985L, 152L, 1L, false);
    AppMethodBeat.o(93943);
  }
  
  public static void brt()
  {
    AppMethodBeat.i(93944);
    h.OAn.idkeyStat(985L, 154L, 1L, false);
    AppMethodBeat.o(93944);
  }
  
  public static void bru()
  {
    AppMethodBeat.i(93946);
    h.OAn.idkeyStat(985L, 159L, 1L, false);
    AppMethodBeat.o(93946);
  }
  
  public static void brv()
  {
    AppMethodBeat.i(93947);
    h.OAn.idkeyStat(985L, 160L, 1L, false);
    AppMethodBeat.o(93947);
  }
  
  public static void brw()
  {
    AppMethodBeat.i(93948);
    h.OAn.idkeyStat(985L, 161L, 1L, false);
    AppMethodBeat.o(93948);
  }
  
  public static void brx()
  {
    AppMethodBeat.i(93949);
    h.OAn.idkeyStat(985L, 162L, 1L, false);
    AppMethodBeat.o(93949);
  }
  
  public static void bry()
  {
    AppMethodBeat.i(93950);
    h.OAn.idkeyStat(985L, 163L, 1L, false);
    AppMethodBeat.o(93950);
  }
  
  public static void brz()
  {
    AppMethodBeat.i(93951);
    h.OAn.idkeyStat(985L, 164L, 1L, false);
    AppMethodBeat.o(93951);
  }
  
  public static void bsa()
  {
    AppMethodBeat.i(93989);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
    h.OAn.p(986L, 81L, 1L);
    AppMethodBeat.o(93989);
  }
  
  public static void bsb()
  {
    AppMethodBeat.i(93990);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
    h.OAn.p(986L, 78L, 1L);
    AppMethodBeat.o(93990);
  }
  
  public static void bsc()
  {
    AppMethodBeat.i(93991);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
    h.OAn.p(986L, 82L, 1L);
    AppMethodBeat.o(93991);
  }
  
  public static void bsd()
  {
    AppMethodBeat.i(93992);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
    h.OAn.p(986L, 83L, 1L);
    AppMethodBeat.o(93992);
  }
  
  public static void bse()
  {
    AppMethodBeat.i(93993);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
    h.OAn.p(986L, 84L, 1L);
    AppMethodBeat.o(93993);
  }
  
  public static void bsf()
  {
    AppMethodBeat.i(93994);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
    h.OAn.p(986L, 54L, 1L);
    AppMethodBeat.o(93994);
  }
  
  public static void bsg()
  {
    AppMethodBeat.i(93995);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
    h.OAn.p(986L, 86L, 1L);
    AppMethodBeat.o(93995);
  }
  
  public static void bsh()
  {
    AppMethodBeat.i(93996);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberMatch");
    h.OAn.p(986L, 90L, 1L);
    AppMethodBeat.o(93996);
  }
  
  public static void bsi()
  {
    AppMethodBeat.i(93997);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberCheckTimeout");
    h.OAn.p(986L, 91L, 1L);
    AppMethodBeat.o(93997);
  }
  
  public static void bsj()
  {
    AppMethodBeat.i(93998);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxX264Encode");
    h.OAn.p(986L, 100L, 1L);
    AppMethodBeat.o(93998);
  }
  
  public static void bsk()
  {
    AppMethodBeat.i(93999);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseSwHevc");
    h.OAn.p(986L, 123L, 1L);
    AppMethodBeat.o(93999);
  }
  
  public static void bsl()
  {
    AppMethodBeat.i(94000);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseHwHevc");
    h.OAn.p(986L, 124L, 1L);
    AppMethodBeat.o(94000);
  }
  
  public static void et(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93909);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.OAn.p(985L, 38L, paramInt1);
    h.OAn.p(985L, 41L, paramInt2);
    AppMethodBeat.o(93909);
  }
  
  public static void eu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93918);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.OAn.p(985L, 21L, paramInt1);
    h.OAn.p(985L, 24L, paramInt2);
    AppMethodBeat.o(93918);
  }
  
  public static void g(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(93982);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + paramLong1 + ", fps:" + paramLong2 + ", originVideoFps:" + paramLong3);
    h.OAn.p(986L, 43L, paramLong3);
    h.OAn.p(986L, 45L, paramLong2);
    h.OAn.p(986L, 48L, paramLong1);
    AppMethodBeat.o(93982);
  }
  
  public static void hZ(long paramLong)
  {
    AppMethodBeat.i(93926);
    h.OAn.idkeyStat(985L, 122L, paramLong, false);
    AppMethodBeat.o(93926);
  }
  
  public static void ia(long paramLong)
  {
    AppMethodBeat.i(93931);
    h.OAn.idkeyStat(985L, 128L, paramLong, false);
    AppMethodBeat.o(93931);
  }
  
  public static void ib(long paramLong)
  {
    AppMethodBeat.i(93945);
    h.OAn.idkeyStat(985L, 155L, paramLong, false);
    AppMethodBeat.o(93945);
  }
  
  public static void ic(long paramLong)
  {
    AppMethodBeat.i(93954);
    h.OAn.idkeyStat(985L, 168L, paramLong, false);
    AppMethodBeat.o(93954);
  }
  
  public static void id(long paramLong)
  {
    AppMethodBeat.i(93956);
    h.OAn.idkeyStat(985L, 170L, paramLong, false);
    AppMethodBeat.o(93956);
  }
  
  public static void ie(long paramLong)
  {
    AppMethodBeat.i(93957);
    h.OAn.idkeyStat(985L, 173L, paramLong, false);
    AppMethodBeat.o(93957);
  }
  
  public static void jdMethod_if(long paramLong)
  {
    AppMethodBeat.i(93959);
    h.OAn.idkeyStat(985L, 175L, paramLong, false);
    AppMethodBeat.o(93959);
  }
  
  public static void ig(long paramLong)
  {
    AppMethodBeat.i(93978);
    Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markRemuxAACAsyncMixTime: ", Long.valueOf(paramLong)));
    h.OAn.p(986L, 27L, paramLong);
    AppMethodBeat.o(93978);
  }
  
  public static void ih(long paramLong)
  {
    AppMethodBeat.i(93980);
    Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markRemuxAACSyncMixTime: ", Long.valueOf(paramLong)));
    h.OAn.p(986L, 31L, paramLong);
    AppMethodBeat.o(93980);
  }
  
  public static void ii(long paramLong)
  {
    AppMethodBeat.i(177320);
    Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markFrameHandlingTime time:", Long.valueOf(paramLong)));
    if (paramLong < 1000L)
    {
      h.OAn.p(986L, 130L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 2000L)
    {
      h.OAn.p(986L, 131L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 3000L)
    {
      h.OAn.p(986L, 132L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 4000L)
    {
      h.OAn.p(986L, 133L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 5000L)
    {
      h.OAn.p(986L, 134L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 6000L)
    {
      h.OAn.p(986L, 135L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 7000L)
    {
      h.OAn.p(986L, 136L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 8000L)
    {
      h.OAn.p(986L, 137L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 9000L)
    {
      h.OAn.p(986L, 138L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 10000L)
    {
      h.OAn.p(986L, 139L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 15000L)
    {
      h.OAn.p(986L, 140L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 20000L)
    {
      h.OAn.p(986L, 141L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    h.OAn.p(986L, 142L, 1L);
    AppMethodBeat.o(177320);
  }
  
  public static void r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93921);
    s.u(paramString, "filePath");
    for (;;)
    {
      int i1;
      int j;
      int k;
      try
      {
        if ((Util.isNullOrNil(paramString)) || (!y.ZC(paramString)))
        {
          AppMethodBeat.o(93921);
          return;
        }
        h.OAn.idkeyStat(985L, 69L, 1L, false);
        JSONObject localJSONObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString));
        i1 = (int)localJSONObject.getDouble("videoFPS");
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(localJSONObject.optInt("videoBitrate")), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        j = 89;
        m = 104;
        if (paramInt1 != 1) {
          break label324;
        }
        h.OAn.idkeyStat(985L, 71L, 1L, false);
        h.OAn.idkeyStat(985L, 73L, i1, false);
        j = 74;
        i = 95;
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
      h.OAn.idkeyStat(985L, paramInt2, 1L, false);
      h.OAn.idkeyStat(985L, paramInt1, i1, false);
      h.OAn.idkeyStat(985L, m, 1L, false);
      h.OAn.idkeyStat(985L, k, i1, false);
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { paramString, Integer.valueOf(i) });
      if ((i1 >= 0) && (i1 <= 10))
      {
        h.OAn.idkeyStat(985L, i, 1L, false);
        AppMethodBeat.o(93921);
        return;
        label317:
        label324:
        h.OAn.idkeyStat(985L, 70L, 1L, false);
        h.OAn.idkeyStat(985L, 72L, i1, false);
        k = 105;
        int n = 57;
        i = 86;
        paramInt1 = j;
        j = n;
      }
      for (;;)
      {
        if (!j.KVJ.gcs())
        {
          if (paramInt2 == 1080)
          {
            break label537;
            if ((i1 > 10) && (i1 <= 15))
            {
              h.OAn.idkeyStat(985L, i + 1, 1L, false);
              AppMethodBeat.o(93921);
              return;
            }
            if ((i1 > 15) && (i1 <= 20))
            {
              h.OAn.idkeyStat(985L, i + 2, 1L, false);
              AppMethodBeat.o(93921);
              return;
            }
            if ((i1 <= 20) || (i1 > 30)) {
              break label317;
            }
            h.OAn.idkeyStat(985L, i + 3, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          paramInt2 = i;
          i = j;
          break;
          if (paramInt2 == 720)
          {
            paramInt1 += 1;
            j += 4;
            paramInt2 = i + 1;
            i = j;
            break;
          }
        }
      }
      label537:
      paramInt1 += 2;
      j += 8;
      paramInt2 = i + 2;
      int i = j;
    }
  }
  
  public static void ue(int paramInt)
  {
    AppMethodBeat.i(93962);
    Log.i("MicroMsg.MediaEditorIDKeyStat", s.X("markMediaCodecCaptureResult, mixType:", Integer.valueOf(paramInt)));
    h.OAn.p(986L, 0L, 1L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(93962);
      return;
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
      h.OAn.p(986L, 1L, 1L);
      AppMethodBeat.o(93962);
      return;
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
      h.OAn.p(986L, 2L, 1L);
      AppMethodBeat.o(93962);
      return;
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
      h.OAn.p(986L, 3L, 1L);
      AppMethodBeat.o(93962);
      return;
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
      h.OAn.p(986L, 4L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.util.f
 * JD-Core Version:    0.7.0.1
 */