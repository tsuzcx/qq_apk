package com.tencent.mm.media.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markAfterCaptureFinish", "", "filePath", "recorderType", "", "resolutionLimit", "markBaseRecordBitrate", "bitrate", "markBaseRecordFps", "fps", "markBaseRecordSuccessTimes", "markC2cCaptureJumpRemux", "markCameraOpen", "markCameraOpenFailed", "markCameraOpenSuccess", "markCaptureUseHwHevc", "markCaptureUseSwHevc", "markCheckRemuxResult", "path", "markCpuCrop", "markCreateExternalTextureFailed", "markDaemonRecordBitrate", "markDaemonRecordFps", "markDaemonRecordSuccessTimes", "markDoubleRemux", "markDoubleRemuxTimeCost", "time", "markEditErrorPath", "markEditPhoto", "markEditPhotoCost", "cost", "markEditPhotoFail", "markEditPhotoFailNullBitmap", "markEditToRecord", "markEglVersion2", "markEglVersion3", "markEncodeCreateSuccessTimes", "markEncodeCreateTimes", "markFrameHandlingTime", "markGpuCrop", "markGpuCropFailed", "markLayoutError", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markMediaCodecWriteYUVError", "markMediaCodecYUVInitError", "markMp4EncoderCreate", "markMp4EncoderRelease", "markPhotoCapture", "markPhotoCaptureFail", "markPhotoEdit", "markPhotoEdited", "markPhotoTimeCost", "markRecordCancelTimes", "markRecordTimes", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckBFrameCost", "markRemuxCheckBFrameFailed", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCheckHasBFrame", "markRemuxCheckHasBFrameTimeout", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxEncoderCreate", "markRemuxEncoderRelease", "markRemuxEndWithFrameNumberCheckTimeout", "markRemuxEndWithFrameNumberMatch", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxUseHwHevc", "markRemuxUseSwHevc", "markRemuxVideoParaError", "markRemuxX264Encode", "markReserveEncoder", "markSavePhotoFail", "markSnsCaptureJumpRemux", "markStartBaseRecordTimeout", "markStartDaemonRecordSuccessTimes", "markStartDaemonRecordTimeout", "markStartDaemonRecordTimes", "markSyncEncoderCreate", "markSyncEncoderRelease", "markVideoEdited", "markVideoGenerate", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "markaSyncEncoderCreate", "markaSyncEncoderRelease", "plugin-mediaeditor_release"})
public final class e
{
  private static long ilA;
  private static long ilB;
  public static final e ilC;
  
  static
  {
    AppMethodBeat.i(94001);
    ilC = new e();
    ilA = -1L;
    ilB = -1L;
    AppMethodBeat.o(94001);
  }
  
  /* Error */
  public static void Hs(String paramString)
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 192
    //   8: invokestatic 198	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokestatic 204	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   15: ifne +9 -> 24
    //   18: ldc 191
    //   20: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: return
    //   24: aconst_null
    //   25: astore 6
    //   27: new 206	com/tencent/mm/media/f/a
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 208	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 5
    //   39: getfield 212	com/tencent/mm/media/f/a:igi	Landroid/media/MediaFormat;
    //   42: astore_0
    //   43: aload 5
    //   45: getfield 215	com/tencent/mm/media/f/a:igh	Landroid/media/MediaFormat;
    //   48: astore 6
    //   50: aload_0
    //   51: ifnull +141 -> 192
    //   54: aload_0
    //   55: ldc 217
    //   57: invokevirtual 222	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   60: iconst_1
    //   61: if_icmpne +131 -> 192
    //   64: aload_0
    //   65: ldc 217
    //   67: invokevirtual 226	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   70: lstore_1
    //   71: aload 6
    //   73: ifnull +126 -> 199
    //   76: aload 6
    //   78: ldc 217
    //   80: invokevirtual 222	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   83: iconst_1
    //   84: if_icmpne +115 -> 199
    //   87: aload 6
    //   89: ldc 217
    //   91: invokevirtual 226	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   94: lstore_3
    //   95: ldc 228
    //   97: new 230	java/lang/StringBuilder
    //   100: dup
    //   101: ldc 232
    //   103: invokespecial 233	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: lload_3
    //   107: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: ldc 239
    //   112: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: lload_1
    //   116: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   119: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: lload_1
    //   126: lconst_0
    //   127: lcmp
    //   128: ifle +53 -> 181
    //   131: lload_3
    //   132: lconst_0
    //   133: lcmp
    //   134: ifle +47 -> 181
    //   137: fconst_1
    //   138: lload_1
    //   139: lload_3
    //   140: invokestatic 257	java/lang/Math:max	(JJ)J
    //   143: l2f
    //   144: fmul
    //   145: lload_1
    //   146: lload_3
    //   147: invokestatic 260	java/lang/Math:min	(JJ)J
    //   150: l2f
    //   151: fdiv
    //   152: f2d
    //   153: ldc2_w 261
    //   156: dcmpl
    //   157: iflt +24 -> 181
    //   160: ldc 228
    //   162: ldc_w 264
    //   165: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: getstatic 270	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   171: ldc2_w 271
    //   174: ldc2_w 273
    //   177: lconst_1
    //   178: invokevirtual 278	com/tencent/mm/plugin/report/service/h:n	(JJJ)V
    //   181: aload 5
    //   183: invokevirtual 281	com/tencent/mm/media/f/a:release	()V
    //   186: ldc 191
    //   188: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: ldc2_w 176
    //   195: lstore_1
    //   196: goto -125 -> 71
    //   199: ldc2_w 176
    //   202: lstore_3
    //   203: goto -108 -> 95
    //   206: astore 5
    //   208: aload 6
    //   210: astore_0
    //   211: ldc 228
    //   213: aload 5
    //   215: checkcast 283	java/lang/Throwable
    //   218: ldc_w 284
    //   221: iconst_0
    //   222: anewarray 4	java/lang/Object
    //   225: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: aload_0
    //   229: ifnull +13 -> 242
    //   232: aload_0
    //   233: invokevirtual 281	com/tencent/mm/media/f/a:release	()V
    //   236: ldc 191
    //   238: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: return
    //   242: ldc 191
    //   244: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: return
    //   248: astore_0
    //   249: aconst_null
    //   250: astore 5
    //   252: aload 5
    //   254: ifnull +8 -> 262
    //   257: aload 5
    //   259: invokevirtual 281	com/tencent/mm/media/f/a:release	()V
    //   262: ldc 191
    //   264: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: aload_0
    //   268: athrow
    //   269: astore_0
    //   270: goto -18 -> 252
    //   273: astore 6
    //   275: aload_0
    //   276: astore 5
    //   278: aload 6
    //   280: astore_0
    //   281: goto -29 -> 252
    //   284: astore 6
    //   286: aload 5
    //   288: astore_0
    //   289: aload 6
    //   291: astore 5
    //   293: goto -82 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramString	String
    //   70	126	1	l1	long
    //   94	109	3	l2	long
    //   35	147	5	locala	com.tencent.mm.media.f.a
    //   206	8	5	localException1	Exception
    //   250	42	5	localObject1	Object
    //   25	184	6	localMediaFormat	android.media.MediaFormat
    //   273	6	6	localObject2	Object
    //   284	6	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   27	37	206	java/lang/Exception
    //   27	37	248	finally
    //   37	50	269	finally
    //   54	71	269	finally
    //   76	95	269	finally
    //   95	125	269	finally
    //   137	181	269	finally
    //   211	228	273	finally
    //   37	50	284	java/lang/Exception
    //   54	71	284	java/lang/Exception
    //   76	95	284	java/lang/Exception
    //   95	125	284	java/lang/Exception
    //   137	181	284	java/lang/Exception
  }
  
  public static void aNA()
  {
    AppMethodBeat.i(93908);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
    h.CyF.n(985L, 39L, 1L);
    AppMethodBeat.o(93908);
  }
  
  public static void aNB()
  {
    AppMethodBeat.i(93910);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
    ilB = -1L;
    h.CyF.n(985L, 13L, 1L);
    AppMethodBeat.o(93910);
  }
  
  public static void aNC()
  {
    AppMethodBeat.i(93911);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
    h.CyF.n(985L, 14L, 1L);
    AppMethodBeat.o(93911);
  }
  
  public static void aND()
  {
    AppMethodBeat.i(93912);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
    h.CyF.n(985L, 15L, 1L);
    AppMethodBeat.o(93912);
  }
  
  public static void aNE()
  {
    AppMethodBeat.i(93913);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
    h.CyF.n(985L, 16L, 1L);
    AppMethodBeat.o(93913);
  }
  
  public static void aNF()
  {
    AppMethodBeat.i(93914);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
    ilB = Util.currentTicks();
    AppMethodBeat.o(93914);
  }
  
  public static void aNG()
  {
    AppMethodBeat.i(93915);
    if (ilB > 0L)
    {
      long l = Util.ticksToNow(ilB);
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWaitStop, waitTime:".concat(String.valueOf(l)));
      h.CyF.n(985L, 17L, l);
      h.CyF.n(985L, 18L, 1L);
      ilB = -1L;
    }
    AppMethodBeat.o(93915);
  }
  
  public static void aNH()
  {
    AppMethodBeat.i(93916);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
    h.CyF.n(985L, 20L, 1L);
    AppMethodBeat.o(93916);
  }
  
  public static void aNI()
  {
    AppMethodBeat.i(93917);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
    h.CyF.n(985L, 22L, 1L);
    AppMethodBeat.o(93917);
  }
  
  public static void aNJ()
  {
    AppMethodBeat.i(93919);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecYUVInitError");
    h.CyF.n(985L, 26L, 1L);
    AppMethodBeat.o(93919);
  }
  
  public static void aNK()
  {
    AppMethodBeat.i(93920);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWriteYUVError");
    h.CyF.n(985L, 27L, 1L);
    AppMethodBeat.o(93920);
  }
  
  public static void aNL()
  {
    AppMethodBeat.i(93922);
    h.CyF.idkeyStat(985L, 118L, 1L, false);
    AppMethodBeat.o(93922);
  }
  
  public static void aNM()
  {
    AppMethodBeat.i(93923);
    h.CyF.idkeyStat(985L, 119L, 1L, false);
    AppMethodBeat.o(93923);
  }
  
  public static void aNN()
  {
    AppMethodBeat.i(93924);
    h.CyF.idkeyStat(985L, 120L, 1L, false);
    AppMethodBeat.o(93924);
  }
  
  public static void aNO()
  {
    AppMethodBeat.i(93925);
    h.CyF.idkeyStat(985L, 121L, 1L, false);
    AppMethodBeat.o(93925);
  }
  
  public static void aNP()
  {
    AppMethodBeat.i(93927);
    h.CyF.idkeyStat(985L, 124L, 1L, false);
    AppMethodBeat.o(93927);
  }
  
  public static void aNQ()
  {
    AppMethodBeat.i(93928);
    h.CyF.idkeyStat(985L, 125L, 1L, false);
    AppMethodBeat.o(93928);
  }
  
  public static void aNR()
  {
    AppMethodBeat.i(93929);
    h.CyF.idkeyStat(985L, 126L, 1L, false);
    AppMethodBeat.o(93929);
  }
  
  public static void aNS()
  {
    AppMethodBeat.i(93930);
    h.CyF.idkeyStat(985L, 127L, 1L, false);
    AppMethodBeat.o(93930);
  }
  
  public static void aNT()
  {
    AppMethodBeat.i(93932);
    h.CyF.idkeyStat(985L, 130L, 1L, false);
    AppMethodBeat.o(93932);
  }
  
  public static void aNU()
  {
    AppMethodBeat.i(93933);
    h.CyF.idkeyStat(985L, 135L, 1L, false);
    AppMethodBeat.o(93933);
  }
  
  public static void aNV()
  {
    AppMethodBeat.i(93934);
    h.CyF.idkeyStat(985L, 136L, 1L, false);
    AppMethodBeat.o(93934);
  }
  
  public static void aNW()
  {
    AppMethodBeat.i(93935);
    h.CyF.idkeyStat(985L, 138L, 1L, false);
    AppMethodBeat.o(93935);
  }
  
  public static void aNX()
  {
    AppMethodBeat.i(93936);
    h.CyF.idkeyStat(985L, 139L, 1L, false);
    AppMethodBeat.o(93936);
  }
  
  public static void aNY()
  {
    AppMethodBeat.i(93937);
    h.CyF.idkeyStat(985L, 143L, 1L, false);
    AppMethodBeat.o(93937);
  }
  
  public static void aNZ()
  {
    AppMethodBeat.i(93938);
    h.CyF.idkeyStat(985L, 144L, 1L, false);
    AppMethodBeat.o(93938);
  }
  
  public static void aNk()
  {
    AppMethodBeat.i(93892);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
    h.CyF.n(985L, 3L, 1L);
    AppMethodBeat.o(93892);
  }
  
  public static void aNl()
  {
    AppMethodBeat.i(93893);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
    h.CyF.n(985L, 4L, 1L);
    AppMethodBeat.o(93893);
  }
  
  public static void aNm()
  {
    AppMethodBeat.i(93894);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
    h.CyF.n(985L, 5L, 1L);
    AppMethodBeat.o(93894);
  }
  
  public static void aNn()
  {
    AppMethodBeat.i(93895);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCrop");
    h.CyF.n(985L, 7L, 1L);
    AppMethodBeat.o(93895);
  }
  
  public static void aNo()
  {
    AppMethodBeat.i(93896);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCpuCrop");
    h.CyF.n(985L, 8L, 1L);
    AppMethodBeat.o(93896);
  }
  
  public static void aNp()
  {
    AppMethodBeat.i(93897);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCropFailed");
    h.CyF.n(985L, 10L, 1L);
    AppMethodBeat.o(93897);
  }
  
  public static void aNq()
  {
    AppMethodBeat.i(93898);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.CyF.n(985L, 11L, 1L);
    AppMethodBeat.o(93898);
  }
  
  public static void aNr()
  {
    AppMethodBeat.i(93899);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.CyF.n(985L, 12L, 1L);
    AppMethodBeat.o(93899);
  }
  
  public static void aNs()
  {
    AppMethodBeat.i(93900);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCreateExternalTextureFailed");
    h.CyF.n(985L, 55L, 1L);
    AppMethodBeat.o(93900);
  }
  
  public static void aNt()
  {
    AppMethodBeat.i(93901);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
    ilA = -1L;
    h.CyF.n(985L, 30L, 1L);
    AppMethodBeat.o(93901);
  }
  
  public static void aNu()
  {
    AppMethodBeat.i(93902);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
    h.CyF.n(985L, 31L, 1L);
    AppMethodBeat.o(93902);
  }
  
  public static void aNv()
  {
    AppMethodBeat.i(93903);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
    h.CyF.n(985L, 32L, 1L);
    AppMethodBeat.o(93903);
  }
  
  public static void aNw()
  {
    AppMethodBeat.i(93904);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
    h.CyF.n(985L, 33L, 1L);
    AppMethodBeat.o(93904);
  }
  
  public static void aNx()
  {
    AppMethodBeat.i(93905);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
    ilB = Util.currentTicks();
    AppMethodBeat.o(93905);
  }
  
  public static void aNy()
  {
    AppMethodBeat.i(93906);
    if (ilB > 0L)
    {
      long l = Util.ticksToNow(ilB);
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264WaitStop, waitTime:".concat(String.valueOf(l)));
      h.CyF.n(985L, 34L, l);
      h.CyF.n(985L, 35L, 1L);
      ilB = -1L;
    }
    AppMethodBeat.o(93906);
  }
  
  public static void aNz()
  {
    AppMethodBeat.i(93907);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
    h.CyF.n(985L, 37L, 1L);
    AppMethodBeat.o(93907);
  }
  
  public static void aOA()
  {
    AppMethodBeat.i(93971);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
    h.CyF.n(986L, 17L, 1L);
    AppMethodBeat.o(93971);
  }
  
  public static void aOB()
  {
    AppMethodBeat.i(93972);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
    h.CyF.n(986L, 18L, 1L);
    AppMethodBeat.o(93972);
  }
  
  public static void aOC()
  {
    AppMethodBeat.i(93973);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
    h.CyF.n(986L, 19L, 1L);
    AppMethodBeat.o(93973);
  }
  
  public static void aOD()
  {
    AppMethodBeat.i(93974);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
    h.CyF.n(986L, 22L, 1L);
    AppMethodBeat.o(93974);
  }
  
  public static void aOE()
  {
    AppMethodBeat.i(93975);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
    h.CyF.n(986L, 23L, 1L);
    AppMethodBeat.o(93975);
  }
  
  public static void aOF()
  {
    AppMethodBeat.i(93976);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
    h.CyF.n(986L, 24L, 1L);
    AppMethodBeat.o(93976);
  }
  
  public static void aOG()
  {
    AppMethodBeat.i(93977);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
    h.CyF.n(986L, 26L, 1L);
    AppMethodBeat.o(93977);
  }
  
  public static void aOH()
  {
    AppMethodBeat.i(93979);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
    h.CyF.n(986L, 30L, 1L);
    AppMethodBeat.o(93979);
  }
  
  public static void aOI()
  {
    AppMethodBeat.i(93983);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
    h.CyF.n(986L, 53L, 1L);
    AppMethodBeat.o(93983);
  }
  
  public static void aOJ()
  {
    AppMethodBeat.i(93984);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
    h.CyF.n(986L, 25L, 1L);
    AppMethodBeat.o(93984);
  }
  
  public static void aOK()
  {
    AppMethodBeat.i(93985);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
    h.CyF.n(986L, 76L, 1L);
    AppMethodBeat.o(93985);
  }
  
  public static void aOL()
  {
    AppMethodBeat.i(93986);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
    h.CyF.n(986L, 80L, 1L);
    AppMethodBeat.o(93986);
  }
  
  public static void aOM()
  {
    AppMethodBeat.i(93987);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
    h.CyF.n(986L, 80L, 1L);
    AppMethodBeat.o(93987);
  }
  
  public static void aON()
  {
    AppMethodBeat.i(93988);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
    h.CyF.n(986L, 77L, 1L);
    AppMethodBeat.o(93988);
  }
  
  public static void aOO()
  {
    AppMethodBeat.i(93989);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
    h.CyF.n(986L, 81L, 1L);
    AppMethodBeat.o(93989);
  }
  
  public static void aOP()
  {
    AppMethodBeat.i(93990);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
    h.CyF.n(986L, 78L, 1L);
    AppMethodBeat.o(93990);
  }
  
  public static void aOQ()
  {
    AppMethodBeat.i(93991);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
    h.CyF.n(986L, 82L, 1L);
    AppMethodBeat.o(93991);
  }
  
  public static void aOR()
  {
    AppMethodBeat.i(93992);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
    h.CyF.n(986L, 83L, 1L);
    AppMethodBeat.o(93992);
  }
  
  public static void aOS()
  {
    AppMethodBeat.i(93993);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
    h.CyF.n(986L, 84L, 1L);
    AppMethodBeat.o(93993);
  }
  
  public static void aOT()
  {
    AppMethodBeat.i(93994);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
    h.CyF.n(986L, 54L, 1L);
    AppMethodBeat.o(93994);
  }
  
  public static void aOU()
  {
    AppMethodBeat.i(93995);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
    h.CyF.n(986L, 86L, 1L);
    AppMethodBeat.o(93995);
  }
  
  public static void aOV()
  {
    AppMethodBeat.i(93996);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberMatch");
    h.CyF.n(986L, 90L, 1L);
    AppMethodBeat.o(93996);
  }
  
  public static void aOW()
  {
    AppMethodBeat.i(93997);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberCheckTimeout");
    h.CyF.n(986L, 91L, 1L);
    AppMethodBeat.o(93997);
  }
  
  public static void aOX()
  {
    AppMethodBeat.i(93998);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxX264Encode");
    h.CyF.n(986L, 100L, 1L);
    AppMethodBeat.o(93998);
  }
  
  public static void aOY()
  {
    AppMethodBeat.i(93999);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseSwHevc");
    h.CyF.n(986L, 123L, 1L);
    AppMethodBeat.o(93999);
  }
  
  public static void aOZ()
  {
    AppMethodBeat.i(94000);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseHwHevc");
    h.CyF.n(986L, 124L, 1L);
    AppMethodBeat.o(94000);
  }
  
  public static void aOa()
  {
    AppMethodBeat.i(93939);
    h.CyF.idkeyStat(985L, 146L, 1L, false);
    AppMethodBeat.o(93939);
  }
  
  public static void aOb()
  {
    AppMethodBeat.i(177318);
    h.CyF.idkeyStat(985L, 147L, 1L, false);
    AppMethodBeat.o(177318);
  }
  
  public static void aOc()
  {
    AppMethodBeat.i(177319);
    h.CyF.idkeyStat(985L, 148L, 1L, false);
    AppMethodBeat.o(177319);
  }
  
  public static void aOd()
  {
    AppMethodBeat.i(93940);
    h.CyF.idkeyStat(985L, 149L, 1L, false);
    AppMethodBeat.o(93940);
  }
  
  public static void aOe()
  {
    AppMethodBeat.i(93941);
    h.CyF.idkeyStat(985L, 150L, 1L, false);
    AppMethodBeat.o(93941);
  }
  
  public static void aOf()
  {
    AppMethodBeat.i(93942);
    h.CyF.idkeyStat(985L, 151L, 1L, false);
    AppMethodBeat.o(93942);
  }
  
  public static void aOg()
  {
    AppMethodBeat.i(93943);
    h.CyF.idkeyStat(985L, 152L, 1L, false);
    AppMethodBeat.o(93943);
  }
  
  public static void aOh()
  {
    AppMethodBeat.i(93944);
    h.CyF.idkeyStat(985L, 154L, 1L, false);
    AppMethodBeat.o(93944);
  }
  
  public static void aOi()
  {
    AppMethodBeat.i(93946);
    h.CyF.idkeyStat(985L, 159L, 1L, false);
    AppMethodBeat.o(93946);
  }
  
  public static void aOj()
  {
    AppMethodBeat.i(93947);
    h.CyF.idkeyStat(985L, 160L, 1L, false);
    AppMethodBeat.o(93947);
  }
  
  public static void aOk()
  {
    AppMethodBeat.i(93948);
    h.CyF.idkeyStat(985L, 161L, 1L, false);
    AppMethodBeat.o(93948);
  }
  
  public static void aOl()
  {
    AppMethodBeat.i(93949);
    h.CyF.idkeyStat(985L, 162L, 1L, false);
    AppMethodBeat.o(93949);
  }
  
  public static void aOm()
  {
    AppMethodBeat.i(93950);
    h.CyF.idkeyStat(985L, 163L, 1L, false);
    AppMethodBeat.o(93950);
  }
  
  public static void aOn()
  {
    AppMethodBeat.i(93951);
    h.CyF.idkeyStat(985L, 164L, 1L, false);
    AppMethodBeat.o(93951);
  }
  
  public static void aOo()
  {
    AppMethodBeat.i(93952);
    h.CyF.idkeyStat(985L, 165L, 1L, false);
    AppMethodBeat.o(93952);
  }
  
  public static void aOp()
  {
    AppMethodBeat.i(93953);
    h.CyF.idkeyStat(985L, 166L, 1L, false);
    AppMethodBeat.o(93953);
  }
  
  public static void aOq()
  {
    AppMethodBeat.i(93955);
    h.CyF.idkeyStat(985L, 169L, 1L, false);
    AppMethodBeat.o(93955);
  }
  
  public static void aOr()
  {
    AppMethodBeat.i(93958);
    h.CyF.idkeyStat(985L, 174L, 1L, false);
    AppMethodBeat.o(93958);
  }
  
  public static void aOs()
  {
    AppMethodBeat.i(93960);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseHwHevc");
    h.CyF.idkeyStat(985L, 181L, 1L, false);
    AppMethodBeat.o(93960);
  }
  
  public static void aOt()
  {
    AppMethodBeat.i(93961);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseSwHevc");
    h.CyF.idkeyStat(985L, 182L, 1L, false);
    AppMethodBeat.o(93961);
  }
  
  public static void aOu()
  {
    AppMethodBeat.i(93963);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
    h.CyF.n(986L, 7L, 1L);
    AppMethodBeat.o(93963);
  }
  
  public static void aOv()
  {
    AppMethodBeat.i(93964);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
    h.CyF.n(986L, 10L, 1L);
    AppMethodBeat.o(93964);
  }
  
  public static void aOw()
  {
    AppMethodBeat.i(93965);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
    h.CyF.n(986L, 11L, 1L);
    AppMethodBeat.o(93965);
  }
  
  public static void aOx()
  {
    AppMethodBeat.i(93968);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
    h.CyF.n(986L, 14L, 1L);
    AppMethodBeat.o(93968);
  }
  
  public static void aOy()
  {
    AppMethodBeat.i(93969);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
    h.CyF.n(986L, 15L, 1L);
    AppMethodBeat.o(93969);
  }
  
  public static void aOz()
  {
    AppMethodBeat.i(93970);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
    h.CyF.n(986L, 16L, 1L);
    AppMethodBeat.o(93970);
  }
  
  public static void dd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93909);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.CyF.n(985L, 38L, paramInt1);
    h.CyF.n(985L, 41L, paramInt2);
    AppMethodBeat.o(93909);
  }
  
  public static void de(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93918);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.CyF.n(985L, 21L, paramInt1);
    h.CyF.n(985L, 24L, paramInt2);
    AppMethodBeat.o(93918);
  }
  
  public static void f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(93982);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + paramLong1 + ", fps:" + paramLong2 + ", originVideoFps:" + paramLong3);
    h.CyF.n(986L, 43L, paramLong3);
    h.CyF.n(986L, 45L, paramLong2);
    h.CyF.n(986L, 48L, paramLong1);
    AppMethodBeat.o(93982);
  }
  
  public static void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93921);
    kotlin.g.b.p.h(paramString, "filePath");
    for (;;)
    {
      Object localObject;
      int i1;
      int j;
      int i;
      int k;
      try
      {
        if ((Util.isNullOrNil(paramString)) || (!s.YS(paramString)))
        {
          AppMethodBeat.o(93921);
          return;
        }
        h.CyF.idkeyStat(985L, 69L, 1L, false);
        localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString));
        i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
        Log.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(((JSONObject)localObject).optInt("videoBitrate")), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        j = 89;
        m = 104;
        if (paramInt1 != 1) {
          break label324;
        }
        h.CyF.idkeyStat(985L, 71L, 1L, false);
        h.CyF.idkeyStat(985L, 73L, i1, false);
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
      h.CyF.idkeyStat(985L, paramInt2, 1L, false);
      h.CyF.idkeyStat(985L, paramInt1, i1, false);
      h.CyF.idkeyStat(985L, m, 1L, false);
      h.CyF.idkeyStat(985L, k, i1, false);
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { paramString, Integer.valueOf(i) });
      if ((i1 >= 0) && (i1 <= 10))
      {
        h.CyF.idkeyStat(985L, i, 1L, false);
        AppMethodBeat.o(93921);
        return;
        label324:
        h.CyF.idkeyStat(985L, 70L, 1L, false);
        h.CyF.idkeyStat(985L, 72L, i1, false);
        k = 105;
        int n = 86;
        i = 57;
        paramInt1 = j;
        j = n;
      }
      while (paramInt2 != 720)
      {
        localObject = k.zuy;
        kotlin.g.b.p.g(localObject, "MMSightRecorderConfig.parameter");
        if (((com.tencent.mm.plugin.mmsight.model.p)localObject).ejS()) {
          break label543;
        }
        if (paramInt2 == 1080)
        {
          break label543;
          if ((i1 > 10) && (i1 <= 15))
          {
            h.CyF.idkeyStat(985L, i + 1, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 15) && (i1 <= 20))
          {
            h.CyF.idkeyStat(985L, i + 2, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 20) && (i1 <= 30)) {
            h.CyF.idkeyStat(985L, i + 3, 1L, false);
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
  
  public static void rn(int paramInt)
  {
    AppMethodBeat.i(93962);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, mixType:".concat(String.valueOf(paramInt)));
    h.CyF.n(986L, 0L, 1L);
    if (paramInt == 1)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
      h.CyF.n(986L, 1L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 3)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
      h.CyF.n(986L, 2L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 2)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
      h.CyF.n(986L, 3L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
      h.CyF.n(986L, 4L, 1L);
    }
    AppMethodBeat.o(93962);
  }
  
  public static void y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93981);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + paramInt + ", time:" + paramLong);
    h.CyF.n(986L, 34L, 1L);
    if (paramInt == 1)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeNoMusic, time:".concat(String.valueOf(paramLong)));
      h.CyF.n(986L, 35L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 3)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeAll, time:".concat(String.valueOf(paramLong)));
      h.CyF.n(986L, 41L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 2)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeMusicOnly, time:".concat(String.valueOf(paramLong)));
      h.CyF.n(986L, 37L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 0)
    {
      Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeSlient, time:".concat(String.valueOf(paramLong)));
      h.CyF.n(986L, 39L, paramLong);
    }
    AppMethodBeat.o(93981);
  }
  
  public static void zK(long paramLong)
  {
    AppMethodBeat.i(93926);
    h.CyF.idkeyStat(985L, 122L, paramLong, false);
    AppMethodBeat.o(93926);
  }
  
  public static void zL(long paramLong)
  {
    AppMethodBeat.i(93931);
    h.CyF.idkeyStat(985L, 128L, paramLong, false);
    AppMethodBeat.o(93931);
  }
  
  public static void zM(long paramLong)
  {
    AppMethodBeat.i(93945);
    h.CyF.idkeyStat(985L, 155L, paramLong, false);
    AppMethodBeat.o(93945);
  }
  
  public static void zN(long paramLong)
  {
    AppMethodBeat.i(93954);
    h.CyF.idkeyStat(985L, 168L, paramLong, false);
    AppMethodBeat.o(93954);
  }
  
  public static void zO(long paramLong)
  {
    AppMethodBeat.i(93956);
    h.CyF.idkeyStat(985L, 170L, paramLong, false);
    AppMethodBeat.o(93956);
  }
  
  public static void zP(long paramLong)
  {
    AppMethodBeat.i(93957);
    h.CyF.idkeyStat(985L, 173L, paramLong, false);
    AppMethodBeat.o(93957);
  }
  
  public static void zQ(long paramLong)
  {
    AppMethodBeat.i(93959);
    h.CyF.idkeyStat(985L, 175L, paramLong, false);
    AppMethodBeat.o(93959);
  }
  
  public static void zR(long paramLong)
  {
    AppMethodBeat.i(93978);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMixTime: ".concat(String.valueOf(paramLong)));
    h.CyF.n(986L, 27L, paramLong);
    AppMethodBeat.o(93978);
  }
  
  public static void zS(long paramLong)
  {
    AppMethodBeat.i(93980);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMixTime: ".concat(String.valueOf(paramLong)));
    h.CyF.n(986L, 31L, paramLong);
    AppMethodBeat.o(93980);
  }
  
  public static void zT(long paramLong)
  {
    AppMethodBeat.i(177320);
    Log.i("MicroMsg.MediaEditorIDKeyStat", "markFrameHandlingTime time:".concat(String.valueOf(paramLong)));
    if (paramLong < 1000L)
    {
      h.CyF.n(986L, 130L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 2000L)
    {
      h.CyF.n(986L, 131L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 3000L)
    {
      h.CyF.n(986L, 132L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 4000L)
    {
      h.CyF.n(986L, 133L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 5000L)
    {
      h.CyF.n(986L, 134L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 6000L)
    {
      h.CyF.n(986L, 135L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 7000L)
    {
      h.CyF.n(986L, 136L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 8000L)
    {
      h.CyF.n(986L, 137L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 9000L)
    {
      h.CyF.n(986L, 138L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 10000L)
    {
      h.CyF.n(986L, 139L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 15000L)
    {
      h.CyF.n(986L, 140L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 20000L)
    {
      h.CyF.n(986L, 141L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    h.CyF.n(986L, 142L, 1L);
    AppMethodBeat.o(177320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.k.e
 * JD-Core Version:    0.7.0.1
 */