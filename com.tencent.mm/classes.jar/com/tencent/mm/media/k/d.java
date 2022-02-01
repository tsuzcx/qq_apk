package com.tencent.mm.media.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markAfterCaptureFinish", "", "filePath", "recorderType", "", "resolutionLimit", "markBaseRecordBitrate", "bitrate", "markBaseRecordFps", "fps", "markBaseRecordSuccessTimes", "markC2cCaptureJumpRemux", "markCameraOpen", "markCameraOpenFailed", "markCameraOpenSuccess", "markCaptureUseHwHevc", "markCaptureUseSwHevc", "markCpuCrop", "markCreateExternalTextureFailed", "markDaemonRecordBitrate", "markDaemonRecordFps", "markDaemonRecordSuccessTimes", "markDoubleRemux", "markDoubleRemuxTimeCost", "time", "markEditErrorPath", "markEditPhoto", "markEditPhotoCost", "cost", "markEditPhotoFail", "markEditPhotoFailNullBitmap", "markEditToRecord", "markEglVersion2", "markEglVersion3", "markEncodeCreateSuccessTimes", "markEncodeCreateTimes", "markFrameHandlingTime", "markGpuCrop", "markGpuCropFailed", "markLayoutError", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markMediaCodecWriteYUVError", "markMediaCodecYUVInitError", "markMp4EncoderCreate", "markMp4EncoderRelease", "markPhotoCapture", "markPhotoCaptureFail", "markPhotoEdit", "markPhotoEdited", "markPhotoTimeCost", "markRecordCancelTimes", "markRecordTimes", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckBFrameCost", "markRemuxCheckBFrameFailed", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCheckHasBFrame", "markRemuxCheckHasBFrameTimeout", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxEncoderCreate", "markRemuxEncoderRelease", "markRemuxEndWithFrameNumberCheckTimeout", "markRemuxEndWithFrameNumberMatch", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxUseHwHevc", "markRemuxUseSwHevc", "markRemuxVideoParaError", "markRemuxX264Encode", "markReserveEncoder", "markSavePhotoFail", "markSnsCaptureJumpRemux", "markStartBaseRecordTimeout", "markStartDaemonRecordSuccessTimes", "markStartDaemonRecordTimeout", "markStartDaemonRecordTimes", "markSyncEncoderCreate", "markSyncEncoderRelease", "markVideoEdited", "markVideoGenerate", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "markaSyncEncoderCreate", "markaSyncEncoderRelease", "plugin-mediaeditor_release"})
public final class d
{
  private static long hoS;
  private static long hoT;
  public static final d hoU;
  
  static
  {
    AppMethodBeat.i(94001);
    hoU = new d();
    hoS = -1L;
    hoT = -1L;
    AppMethodBeat.o(94001);
  }
  
  public static void auA()
  {
    AppMethodBeat.i(93911);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
    g.yhR.n(985L, 14L, 1L);
    AppMethodBeat.o(93911);
  }
  
  public static void auB()
  {
    AppMethodBeat.i(93912);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
    g.yhR.n(985L, 15L, 1L);
    AppMethodBeat.o(93912);
  }
  
  public static void auC()
  {
    AppMethodBeat.i(93913);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
    g.yhR.n(985L, 16L, 1L);
    AppMethodBeat.o(93913);
  }
  
  public static void auD()
  {
    AppMethodBeat.i(93914);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
    hoT = bt.HI();
    AppMethodBeat.o(93914);
  }
  
  public static void auE()
  {
    AppMethodBeat.i(93915);
    if (hoT > 0L)
    {
      long l = bt.aO(hoT);
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWaitStop, waitTime:".concat(String.valueOf(l)));
      g.yhR.n(985L, 17L, l);
      g.yhR.n(985L, 18L, 1L);
      hoT = -1L;
    }
    AppMethodBeat.o(93915);
  }
  
  public static void auF()
  {
    AppMethodBeat.i(93916);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
    g.yhR.n(985L, 20L, 1L);
    AppMethodBeat.o(93916);
  }
  
  public static void auG()
  {
    AppMethodBeat.i(93917);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
    g.yhR.n(985L, 22L, 1L);
    AppMethodBeat.o(93917);
  }
  
  public static void auH()
  {
    AppMethodBeat.i(93919);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecYUVInitError");
    g.yhR.n(985L, 26L, 1L);
    AppMethodBeat.o(93919);
  }
  
  public static void auI()
  {
    AppMethodBeat.i(93920);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWriteYUVError");
    g.yhR.n(985L, 27L, 1L);
    AppMethodBeat.o(93920);
  }
  
  public static void auJ()
  {
    AppMethodBeat.i(93922);
    g.yhR.idkeyStat(985L, 118L, 1L, false);
    AppMethodBeat.o(93922);
  }
  
  public static void auK()
  {
    AppMethodBeat.i(93923);
    g.yhR.idkeyStat(985L, 119L, 1L, false);
    AppMethodBeat.o(93923);
  }
  
  public static void auL()
  {
    AppMethodBeat.i(93924);
    g.yhR.idkeyStat(985L, 120L, 1L, false);
    AppMethodBeat.o(93924);
  }
  
  public static void auM()
  {
    AppMethodBeat.i(93925);
    g.yhR.idkeyStat(985L, 121L, 1L, false);
    AppMethodBeat.o(93925);
  }
  
  public static void auN()
  {
    AppMethodBeat.i(93927);
    g.yhR.idkeyStat(985L, 124L, 1L, false);
    AppMethodBeat.o(93927);
  }
  
  public static void auO()
  {
    AppMethodBeat.i(93928);
    g.yhR.idkeyStat(985L, 125L, 1L, false);
    AppMethodBeat.o(93928);
  }
  
  public static void auP()
  {
    AppMethodBeat.i(93929);
    g.yhR.idkeyStat(985L, 126L, 1L, false);
    AppMethodBeat.o(93929);
  }
  
  public static void auQ()
  {
    AppMethodBeat.i(93930);
    g.yhR.idkeyStat(985L, 127L, 1L, false);
    AppMethodBeat.o(93930);
  }
  
  public static void auR()
  {
    AppMethodBeat.i(93932);
    g.yhR.idkeyStat(985L, 130L, 1L, false);
    AppMethodBeat.o(93932);
  }
  
  public static void auS()
  {
    AppMethodBeat.i(93933);
    g.yhR.idkeyStat(985L, 135L, 1L, false);
    AppMethodBeat.o(93933);
  }
  
  public static void auT()
  {
    AppMethodBeat.i(93934);
    g.yhR.idkeyStat(985L, 136L, 1L, false);
    AppMethodBeat.o(93934);
  }
  
  public static void auU()
  {
    AppMethodBeat.i(93935);
    g.yhR.idkeyStat(985L, 138L, 1L, false);
    AppMethodBeat.o(93935);
  }
  
  public static void auV()
  {
    AppMethodBeat.i(93936);
    g.yhR.idkeyStat(985L, 139L, 1L, false);
    AppMethodBeat.o(93936);
  }
  
  public static void auW()
  {
    AppMethodBeat.i(93937);
    g.yhR.idkeyStat(985L, 143L, 1L, false);
    AppMethodBeat.o(93937);
  }
  
  public static void auX()
  {
    AppMethodBeat.i(93938);
    g.yhR.idkeyStat(985L, 144L, 1L, false);
    AppMethodBeat.o(93938);
  }
  
  public static void auY()
  {
    AppMethodBeat.i(93939);
    g.yhR.idkeyStat(985L, 146L, 1L, false);
    AppMethodBeat.o(93939);
  }
  
  public static void auZ()
  {
    AppMethodBeat.i(177318);
    g.yhR.idkeyStat(985L, 147L, 1L, false);
    AppMethodBeat.o(177318);
  }
  
  public static void aui()
  {
    AppMethodBeat.i(93892);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
    g.yhR.n(985L, 3L, 1L);
    AppMethodBeat.o(93892);
  }
  
  public static void auj()
  {
    AppMethodBeat.i(93893);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
    g.yhR.n(985L, 4L, 1L);
    AppMethodBeat.o(93893);
  }
  
  public static void auk()
  {
    AppMethodBeat.i(93894);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
    g.yhR.n(985L, 5L, 1L);
    AppMethodBeat.o(93894);
  }
  
  public static void aul()
  {
    AppMethodBeat.i(93895);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCrop");
    g.yhR.n(985L, 7L, 1L);
    AppMethodBeat.o(93895);
  }
  
  public static void aum()
  {
    AppMethodBeat.i(93896);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCpuCrop");
    g.yhR.n(985L, 8L, 1L);
    AppMethodBeat.o(93896);
  }
  
  public static void aun()
  {
    AppMethodBeat.i(93897);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCropFailed");
    g.yhR.n(985L, 10L, 1L);
    AppMethodBeat.o(93897);
  }
  
  public static void auo()
  {
    AppMethodBeat.i(93898);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    g.yhR.n(985L, 11L, 1L);
    AppMethodBeat.o(93898);
  }
  
  public static void aup()
  {
    AppMethodBeat.i(93899);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    g.yhR.n(985L, 12L, 1L);
    AppMethodBeat.o(93899);
  }
  
  public static void auq()
  {
    AppMethodBeat.i(93900);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCreateExternalTextureFailed");
    g.yhR.n(985L, 55L, 1L);
    AppMethodBeat.o(93900);
  }
  
  public static void aur()
  {
    AppMethodBeat.i(93901);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
    hoS = -1L;
    g.yhR.n(985L, 30L, 1L);
    AppMethodBeat.o(93901);
  }
  
  public static void aus()
  {
    AppMethodBeat.i(93902);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
    g.yhR.n(985L, 31L, 1L);
    AppMethodBeat.o(93902);
  }
  
  public static void aut()
  {
    AppMethodBeat.i(93903);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
    g.yhR.n(985L, 32L, 1L);
    AppMethodBeat.o(93903);
  }
  
  public static void auu()
  {
    AppMethodBeat.i(93904);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
    g.yhR.n(985L, 33L, 1L);
    AppMethodBeat.o(93904);
  }
  
  public static void auv()
  {
    AppMethodBeat.i(93905);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
    hoT = bt.HI();
    AppMethodBeat.o(93905);
  }
  
  public static void auw()
  {
    AppMethodBeat.i(93906);
    if (hoT > 0L)
    {
      long l = bt.aO(hoT);
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264WaitStop, waitTime:".concat(String.valueOf(l)));
      g.yhR.n(985L, 34L, l);
      g.yhR.n(985L, 35L, 1L);
      hoT = -1L;
    }
    AppMethodBeat.o(93906);
  }
  
  public static void aux()
  {
    AppMethodBeat.i(93907);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
    g.yhR.n(985L, 37L, 1L);
    AppMethodBeat.o(93907);
  }
  
  public static void auy()
  {
    AppMethodBeat.i(93908);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
    g.yhR.n(985L, 39L, 1L);
    AppMethodBeat.o(93908);
  }
  
  public static void auz()
  {
    AppMethodBeat.i(93910);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
    hoT = -1L;
    g.yhR.n(985L, 13L, 1L);
    AppMethodBeat.o(93910);
  }
  
  public static void avA()
  {
    AppMethodBeat.i(93973);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
    g.yhR.n(986L, 19L, 1L);
    AppMethodBeat.o(93973);
  }
  
  public static void avB()
  {
    AppMethodBeat.i(93974);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
    g.yhR.n(986L, 22L, 1L);
    AppMethodBeat.o(93974);
  }
  
  public static void avC()
  {
    AppMethodBeat.i(93975);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
    g.yhR.n(986L, 23L, 1L);
    AppMethodBeat.o(93975);
  }
  
  public static void avD()
  {
    AppMethodBeat.i(93976);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
    g.yhR.n(986L, 24L, 1L);
    AppMethodBeat.o(93976);
  }
  
  public static void avE()
  {
    AppMethodBeat.i(93977);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
    g.yhR.n(986L, 26L, 1L);
    AppMethodBeat.o(93977);
  }
  
  public static void avF()
  {
    AppMethodBeat.i(93979);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
    g.yhR.n(986L, 30L, 1L);
    AppMethodBeat.o(93979);
  }
  
  public static void avG()
  {
    AppMethodBeat.i(93983);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
    g.yhR.n(986L, 53L, 1L);
    AppMethodBeat.o(93983);
  }
  
  public static void avH()
  {
    AppMethodBeat.i(93984);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
    g.yhR.n(986L, 25L, 1L);
    AppMethodBeat.o(93984);
  }
  
  public static void avI()
  {
    AppMethodBeat.i(93985);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
    g.yhR.n(986L, 76L, 1L);
    AppMethodBeat.o(93985);
  }
  
  public static void avJ()
  {
    AppMethodBeat.i(93986);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
    g.yhR.n(986L, 80L, 1L);
    AppMethodBeat.o(93986);
  }
  
  public static void avK()
  {
    AppMethodBeat.i(93987);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
    g.yhR.n(986L, 80L, 1L);
    AppMethodBeat.o(93987);
  }
  
  public static void avL()
  {
    AppMethodBeat.i(93988);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
    g.yhR.n(986L, 77L, 1L);
    AppMethodBeat.o(93988);
  }
  
  public static void avM()
  {
    AppMethodBeat.i(93989);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
    g.yhR.n(986L, 81L, 1L);
    AppMethodBeat.o(93989);
  }
  
  public static void avN()
  {
    AppMethodBeat.i(93990);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
    g.yhR.n(986L, 78L, 1L);
    AppMethodBeat.o(93990);
  }
  
  public static void avO()
  {
    AppMethodBeat.i(93991);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
    g.yhR.n(986L, 82L, 1L);
    AppMethodBeat.o(93991);
  }
  
  public static void avP()
  {
    AppMethodBeat.i(93992);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
    g.yhR.n(986L, 83L, 1L);
    AppMethodBeat.o(93992);
  }
  
  public static void avQ()
  {
    AppMethodBeat.i(93993);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
    g.yhR.n(986L, 84L, 1L);
    AppMethodBeat.o(93993);
  }
  
  public static void avR()
  {
    AppMethodBeat.i(93994);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
    g.yhR.n(986L, 54L, 1L);
    AppMethodBeat.o(93994);
  }
  
  public static void avS()
  {
    AppMethodBeat.i(93995);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
    g.yhR.n(986L, 86L, 1L);
    AppMethodBeat.o(93995);
  }
  
  public static void avT()
  {
    AppMethodBeat.i(93996);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberMatch");
    g.yhR.n(986L, 90L, 1L);
    AppMethodBeat.o(93996);
  }
  
  public static void avU()
  {
    AppMethodBeat.i(93997);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberCheckTimeout");
    g.yhR.n(986L, 91L, 1L);
    AppMethodBeat.o(93997);
  }
  
  public static void avV()
  {
    AppMethodBeat.i(93998);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxX264Encode");
    g.yhR.n(986L, 100L, 1L);
    AppMethodBeat.o(93998);
  }
  
  public static void avW()
  {
    AppMethodBeat.i(93999);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseSwHevc");
    g.yhR.n(986L, 123L, 1L);
    AppMethodBeat.o(93999);
  }
  
  public static void avX()
  {
    AppMethodBeat.i(94000);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseHwHevc");
    g.yhR.n(986L, 124L, 1L);
    AppMethodBeat.o(94000);
  }
  
  public static void ava()
  {
    AppMethodBeat.i(177319);
    g.yhR.idkeyStat(985L, 148L, 1L, false);
    AppMethodBeat.o(177319);
  }
  
  public static void avb()
  {
    AppMethodBeat.i(93940);
    g.yhR.idkeyStat(985L, 149L, 1L, false);
    AppMethodBeat.o(93940);
  }
  
  public static void avc()
  {
    AppMethodBeat.i(93941);
    g.yhR.idkeyStat(985L, 150L, 1L, false);
    AppMethodBeat.o(93941);
  }
  
  public static void avd()
  {
    AppMethodBeat.i(93942);
    g.yhR.idkeyStat(985L, 151L, 1L, false);
    AppMethodBeat.o(93942);
  }
  
  public static void ave()
  {
    AppMethodBeat.i(93943);
    g.yhR.idkeyStat(985L, 152L, 1L, false);
    AppMethodBeat.o(93943);
  }
  
  public static void avf()
  {
    AppMethodBeat.i(93944);
    g.yhR.idkeyStat(985L, 154L, 1L, false);
    AppMethodBeat.o(93944);
  }
  
  public static void avg()
  {
    AppMethodBeat.i(93946);
    g.yhR.idkeyStat(985L, 159L, 1L, false);
    AppMethodBeat.o(93946);
  }
  
  public static void avh()
  {
    AppMethodBeat.i(93947);
    g.yhR.idkeyStat(985L, 160L, 1L, false);
    AppMethodBeat.o(93947);
  }
  
  public static void avi()
  {
    AppMethodBeat.i(93948);
    g.yhR.idkeyStat(985L, 161L, 1L, false);
    AppMethodBeat.o(93948);
  }
  
  public static void avj()
  {
    AppMethodBeat.i(93949);
    g.yhR.idkeyStat(985L, 162L, 1L, false);
    AppMethodBeat.o(93949);
  }
  
  public static void avk()
  {
    AppMethodBeat.i(93950);
    g.yhR.idkeyStat(985L, 163L, 1L, false);
    AppMethodBeat.o(93950);
  }
  
  public static void avl()
  {
    AppMethodBeat.i(93951);
    g.yhR.idkeyStat(985L, 164L, 1L, false);
    AppMethodBeat.o(93951);
  }
  
  public static void avm()
  {
    AppMethodBeat.i(93952);
    g.yhR.idkeyStat(985L, 165L, 1L, false);
    AppMethodBeat.o(93952);
  }
  
  public static void avn()
  {
    AppMethodBeat.i(93953);
    g.yhR.idkeyStat(985L, 166L, 1L, false);
    AppMethodBeat.o(93953);
  }
  
  public static void avo()
  {
    AppMethodBeat.i(93955);
    g.yhR.idkeyStat(985L, 169L, 1L, false);
    AppMethodBeat.o(93955);
  }
  
  public static void avp()
  {
    AppMethodBeat.i(93958);
    g.yhR.idkeyStat(985L, 174L, 1L, false);
    AppMethodBeat.o(93958);
  }
  
  public static void avq()
  {
    AppMethodBeat.i(93960);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseHwHevc");
    g.yhR.idkeyStat(985L, 181L, 1L, false);
    AppMethodBeat.o(93960);
  }
  
  public static void avr()
  {
    AppMethodBeat.i(93961);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseSwHevc");
    g.yhR.idkeyStat(985L, 182L, 1L, false);
    AppMethodBeat.o(93961);
  }
  
  public static void avs()
  {
    AppMethodBeat.i(93963);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
    g.yhR.n(986L, 7L, 1L);
    AppMethodBeat.o(93963);
  }
  
  public static void avt()
  {
    AppMethodBeat.i(93964);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
    g.yhR.n(986L, 10L, 1L);
    AppMethodBeat.o(93964);
  }
  
  public static void avu()
  {
    AppMethodBeat.i(93965);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
    g.yhR.n(986L, 11L, 1L);
    AppMethodBeat.o(93965);
  }
  
  public static void avv()
  {
    AppMethodBeat.i(93968);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
    g.yhR.n(986L, 14L, 1L);
    AppMethodBeat.o(93968);
  }
  
  public static void avw()
  {
    AppMethodBeat.i(93969);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
    g.yhR.n(986L, 15L, 1L);
    AppMethodBeat.o(93969);
  }
  
  public static void avx()
  {
    AppMethodBeat.i(93970);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
    g.yhR.n(986L, 16L, 1L);
    AppMethodBeat.o(93970);
  }
  
  public static void avy()
  {
    AppMethodBeat.i(93971);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
    g.yhR.n(986L, 17L, 1L);
    AppMethodBeat.o(93971);
  }
  
  public static void avz()
  {
    AppMethodBeat.i(93972);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
    g.yhR.n(986L, 18L, 1L);
    AppMethodBeat.o(93972);
  }
  
  public static void cX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93909);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    g.yhR.n(985L, 38L, paramInt1);
    g.yhR.n(985L, 41L, paramInt2);
    AppMethodBeat.o(93909);
  }
  
  public static void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93918);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    g.yhR.n(985L, 21L, paramInt1);
    g.yhR.n(985L, 24L, paramInt2);
    AppMethodBeat.o(93918);
  }
  
  public static void f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(93982);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + paramLong1 + ", fps:" + paramLong2 + ", originVideoFps:" + paramLong3);
    g.yhR.n(986L, 43L, paramLong3);
    g.yhR.n(986L, 45L, paramLong2);
    g.yhR.n(986L, 48L, paramLong1);
    AppMethodBeat.o(93982);
  }
  
  public static void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93921);
    d.g.b.p.h(paramString, "filePath");
    for (;;)
    {
      Object localObject;
      int i1;
      int j;
      int i;
      int k;
      try
      {
        if ((bt.isNullOrNil(paramString)) || (!i.fv(paramString)))
        {
          AppMethodBeat.o(93921);
          return;
        }
        g.yhR.idkeyStat(985L, 69L, 1L, false);
        localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString));
        i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
        ad.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(((JSONObject)localObject).optInt("videoBitrate")), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        j = 89;
        m = 104;
        if (paramInt1 != 1) {
          break label324;
        }
        g.yhR.idkeyStat(985L, 71L, 1L, false);
        g.yhR.idkeyStat(985L, 73L, i1, false);
        i = 74;
        j = 95;
        paramInt1 = 98;
        k = 108;
        m = 107;
      }
      catch (Exception paramString)
      {
        int m;
        ad.e("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(93921);
        return;
      }
      g.yhR.idkeyStat(985L, paramInt2, 1L, false);
      g.yhR.idkeyStat(985L, paramInt1, i1, false);
      g.yhR.idkeyStat(985L, m, 1L, false);
      g.yhR.idkeyStat(985L, k, i1, false);
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { paramString, Integer.valueOf(i) });
      if ((i1 >= 0) && (i1 <= 10))
      {
        g.yhR.idkeyStat(985L, i, 1L, false);
        AppMethodBeat.o(93921);
        return;
        label324:
        g.yhR.idkeyStat(985L, 70L, 1L, false);
        g.yhR.idkeyStat(985L, 72L, i1, false);
        k = 105;
        int n = 86;
        i = 57;
        paramInt1 = j;
        j = n;
      }
      while (paramInt2 != 720)
      {
        localObject = k.vOq;
        d.g.b.p.g(localObject, "MMSightRecorderConfig.parameter");
        if (((com.tencent.mm.plugin.mmsight.model.p)localObject).dne()) {
          break label543;
        }
        if (paramInt2 == 1080)
        {
          break label543;
          if ((i1 > 10) && (i1 <= 15))
          {
            g.yhR.idkeyStat(985L, i + 1, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 15) && (i1 <= 20))
          {
            g.yhR.idkeyStat(985L, i + 2, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 20) && (i1 <= 30)) {
            g.yhR.idkeyStat(985L, i + 3, 1L, false);
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
  
  public static void nO(int paramInt)
  {
    AppMethodBeat.i(93962);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, mixType:".concat(String.valueOf(paramInt)));
    g.yhR.n(986L, 0L, 1L);
    if (paramInt == 1)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
      g.yhR.n(986L, 1L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 3)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
      g.yhR.n(986L, 2L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 2)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
      g.yhR.n(986L, 3L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 0)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
      g.yhR.n(986L, 4L, 1L);
    }
    AppMethodBeat.o(93962);
  }
  
  public static void rA(long paramLong)
  {
    AppMethodBeat.i(177320);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markFrameHandlingTime time:".concat(String.valueOf(paramLong)));
    if (paramLong < 1000L)
    {
      g.yhR.n(986L, 130L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 2000L)
    {
      g.yhR.n(986L, 131L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 3000L)
    {
      g.yhR.n(986L, 132L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 4000L)
    {
      g.yhR.n(986L, 133L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 5000L)
    {
      g.yhR.n(986L, 134L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 6000L)
    {
      g.yhR.n(986L, 135L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 7000L)
    {
      g.yhR.n(986L, 136L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 8000L)
    {
      g.yhR.n(986L, 137L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 9000L)
    {
      g.yhR.n(986L, 138L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 10000L)
    {
      g.yhR.n(986L, 139L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 15000L)
    {
      g.yhR.n(986L, 140L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 20000L)
    {
      g.yhR.n(986L, 141L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    g.yhR.n(986L, 142L, 1L);
    AppMethodBeat.o(177320);
  }
  
  public static void rr(long paramLong)
  {
    AppMethodBeat.i(93926);
    g.yhR.idkeyStat(985L, 122L, paramLong, false);
    AppMethodBeat.o(93926);
  }
  
  public static void rs(long paramLong)
  {
    AppMethodBeat.i(93931);
    g.yhR.idkeyStat(985L, 128L, paramLong, false);
    AppMethodBeat.o(93931);
  }
  
  public static void rt(long paramLong)
  {
    AppMethodBeat.i(93945);
    g.yhR.idkeyStat(985L, 155L, paramLong, false);
    AppMethodBeat.o(93945);
  }
  
  public static void ru(long paramLong)
  {
    AppMethodBeat.i(93954);
    g.yhR.idkeyStat(985L, 168L, paramLong, false);
    AppMethodBeat.o(93954);
  }
  
  public static void rv(long paramLong)
  {
    AppMethodBeat.i(93956);
    g.yhR.idkeyStat(985L, 170L, paramLong, false);
    AppMethodBeat.o(93956);
  }
  
  public static void rw(long paramLong)
  {
    AppMethodBeat.i(93957);
    g.yhR.idkeyStat(985L, 173L, paramLong, false);
    AppMethodBeat.o(93957);
  }
  
  public static void rx(long paramLong)
  {
    AppMethodBeat.i(93959);
    g.yhR.idkeyStat(985L, 175L, paramLong, false);
    AppMethodBeat.o(93959);
  }
  
  public static void ry(long paramLong)
  {
    AppMethodBeat.i(93978);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMixTime: ".concat(String.valueOf(paramLong)));
    g.yhR.n(986L, 27L, paramLong);
    AppMethodBeat.o(93978);
  }
  
  public static void rz(long paramLong)
  {
    AppMethodBeat.i(93980);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMixTime: ".concat(String.valueOf(paramLong)));
    g.yhR.n(986L, 31L, paramLong);
    AppMethodBeat.o(93980);
  }
  
  public static void w(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93981);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + paramInt + ", time:" + paramLong);
    g.yhR.n(986L, 34L, 1L);
    if (paramInt == 1)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeNoMusic, time:".concat(String.valueOf(paramLong)));
      g.yhR.n(986L, 35L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 3)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeAll, time:".concat(String.valueOf(paramLong)));
      g.yhR.n(986L, 41L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 2)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeMusicOnly, time:".concat(String.valueOf(paramLong)));
      g.yhR.n(986L, 37L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 0)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeSlient, time:".concat(String.valueOf(paramLong)));
      g.yhR.n(986L, 39L, paramLong);
    }
    AppMethodBeat.o(93981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.k.d
 * JD-Core Version:    0.7.0.1
 */