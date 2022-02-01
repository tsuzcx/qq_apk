package com.tencent.mm.media.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markAfterCaptureFinish", "", "filePath", "recorderType", "", "resolutionLimit", "markBaseRecordBitrate", "bitrate", "markBaseRecordFps", "fps", "markBaseRecordSuccessTimes", "markC2cCaptureJumpRemux", "markCameraOpen", "markCameraOpenFailed", "markCameraOpenSuccess", "markCaptureUseHwHevc", "markCaptureUseSwHevc", "markCpuCrop", "markCreateExternalTextureFailed", "markDaemonRecordBitrate", "markDaemonRecordFps", "markDaemonRecordSuccessTimes", "markDoubleRemux", "markDoubleRemuxTimeCost", "time", "markEditErrorPath", "markEditPhoto", "markEditPhotoCost", "cost", "markEditPhotoFail", "markEditPhotoFailNullBitmap", "markEditToRecord", "markEglVersion2", "markEglVersion3", "markEncodeCreateSuccessTimes", "markEncodeCreateTimes", "markFrameHandlingTime", "markGpuCrop", "markGpuCropFailed", "markLayoutError", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markMediaCodecWriteYUVError", "markMediaCodecYUVInitError", "markMp4EncoderCreate", "markMp4EncoderRelease", "markPhotoCapture", "markPhotoCaptureFail", "markPhotoEdit", "markPhotoEdited", "markPhotoTimeCost", "markRecordCancelTimes", "markRecordTimes", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckBFrameCost", "markRemuxCheckBFrameFailed", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCheckHasBFrame", "markRemuxCheckHasBFrameTimeout", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxEncoderCreate", "markRemuxEncoderRelease", "markRemuxEndWithFrameNumberCheckTimeout", "markRemuxEndWithFrameNumberMatch", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxUseHwHevc", "markRemuxUseSwHevc", "markRemuxVideoParaError", "markRemuxX264Encode", "markReserveEncoder", "markSavePhotoFail", "markSnsCaptureJumpRemux", "markStartBaseRecordTimeout", "markStartDaemonRecordSuccessTimes", "markStartDaemonRecordTimeout", "markStartDaemonRecordTimes", "markSyncEncoderCreate", "markSyncEncoderRelease", "markVideoEdited", "markVideoGenerate", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "markaSyncEncoderCreate", "markaSyncEncoderRelease", "plugin-mediaeditor_release"})
public final class d
{
  private static long gWM;
  private static long gWN;
  public static final d gWO;
  
  static
  {
    AppMethodBeat.i(94001);
    gWO = new d();
    gWM = -1L;
    gWN = -1L;
    AppMethodBeat.o(94001);
  }
  
  public static void arA()
  {
    AppMethodBeat.i(93897);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCropFailed");
    h.wUl.n(985L, 10L, 1L);
    AppMethodBeat.o(93897);
  }
  
  public static void arB()
  {
    AppMethodBeat.i(93898);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.wUl.n(985L, 11L, 1L);
    AppMethodBeat.o(93898);
  }
  
  public static void arC()
  {
    AppMethodBeat.i(93899);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.wUl.n(985L, 12L, 1L);
    AppMethodBeat.o(93899);
  }
  
  public static void arD()
  {
    AppMethodBeat.i(93900);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markCreateExternalTextureFailed");
    h.wUl.n(985L, 55L, 1L);
    AppMethodBeat.o(93900);
  }
  
  public static void arE()
  {
    AppMethodBeat.i(93901);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
    gWM = -1L;
    h.wUl.n(985L, 30L, 1L);
    AppMethodBeat.o(93901);
  }
  
  public static void arF()
  {
    AppMethodBeat.i(93902);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
    h.wUl.n(985L, 31L, 1L);
    AppMethodBeat.o(93902);
  }
  
  public static void arG()
  {
    AppMethodBeat.i(93903);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
    h.wUl.n(985L, 32L, 1L);
    AppMethodBeat.o(93903);
  }
  
  public static void arH()
  {
    AppMethodBeat.i(93904);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
    h.wUl.n(985L, 33L, 1L);
    AppMethodBeat.o(93904);
  }
  
  public static void arI()
  {
    AppMethodBeat.i(93905);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
    gWN = bs.Gn();
    AppMethodBeat.o(93905);
  }
  
  public static void arJ()
  {
    AppMethodBeat.i(93906);
    if (gWN > 0L)
    {
      long l = bs.aO(gWN);
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264WaitStop, waitTime:".concat(String.valueOf(l)));
      h.wUl.n(985L, 34L, l);
      h.wUl.n(985L, 35L, 1L);
      gWN = -1L;
    }
    AppMethodBeat.o(93906);
  }
  
  public static void arK()
  {
    AppMethodBeat.i(93907);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
    h.wUl.n(985L, 37L, 1L);
    AppMethodBeat.o(93907);
  }
  
  public static void arL()
  {
    AppMethodBeat.i(93908);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
    h.wUl.n(985L, 39L, 1L);
    AppMethodBeat.o(93908);
  }
  
  public static void arM()
  {
    AppMethodBeat.i(93910);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
    gWN = -1L;
    h.wUl.n(985L, 13L, 1L);
    AppMethodBeat.o(93910);
  }
  
  public static void arN()
  {
    AppMethodBeat.i(93911);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
    h.wUl.n(985L, 14L, 1L);
    AppMethodBeat.o(93911);
  }
  
  public static void arO()
  {
    AppMethodBeat.i(93912);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
    h.wUl.n(985L, 15L, 1L);
    AppMethodBeat.o(93912);
  }
  
  public static void arP()
  {
    AppMethodBeat.i(93913);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
    h.wUl.n(985L, 16L, 1L);
    AppMethodBeat.o(93913);
  }
  
  public static void arQ()
  {
    AppMethodBeat.i(93914);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
    gWN = bs.Gn();
    AppMethodBeat.o(93914);
  }
  
  public static void arR()
  {
    AppMethodBeat.i(93915);
    if (gWN > 0L)
    {
      long l = bs.aO(gWN);
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWaitStop, waitTime:".concat(String.valueOf(l)));
      h.wUl.n(985L, 17L, l);
      h.wUl.n(985L, 18L, 1L);
      gWN = -1L;
    }
    AppMethodBeat.o(93915);
  }
  
  public static void arS()
  {
    AppMethodBeat.i(93916);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
    h.wUl.n(985L, 20L, 1L);
    AppMethodBeat.o(93916);
  }
  
  public static void arT()
  {
    AppMethodBeat.i(93917);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
    h.wUl.n(985L, 22L, 1L);
    AppMethodBeat.o(93917);
  }
  
  public static void arU()
  {
    AppMethodBeat.i(93919);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecYUVInitError");
    h.wUl.n(985L, 26L, 1L);
    AppMethodBeat.o(93919);
  }
  
  public static void arV()
  {
    AppMethodBeat.i(93920);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWriteYUVError");
    h.wUl.n(985L, 27L, 1L);
    AppMethodBeat.o(93920);
  }
  
  public static void arW()
  {
    AppMethodBeat.i(93922);
    h.wUl.idkeyStat(985L, 118L, 1L, false);
    AppMethodBeat.o(93922);
  }
  
  public static void arX()
  {
    AppMethodBeat.i(93923);
    h.wUl.idkeyStat(985L, 119L, 1L, false);
    AppMethodBeat.o(93923);
  }
  
  public static void arY()
  {
    AppMethodBeat.i(93924);
    h.wUl.idkeyStat(985L, 120L, 1L, false);
    AppMethodBeat.o(93924);
  }
  
  public static void arZ()
  {
    AppMethodBeat.i(93925);
    h.wUl.idkeyStat(985L, 121L, 1L, false);
    AppMethodBeat.o(93925);
  }
  
  public static void arv()
  {
    AppMethodBeat.i(93892);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
    h.wUl.n(985L, 3L, 1L);
    AppMethodBeat.o(93892);
  }
  
  public static void arw()
  {
    AppMethodBeat.i(93893);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
    h.wUl.n(985L, 4L, 1L);
    AppMethodBeat.o(93893);
  }
  
  public static void arx()
  {
    AppMethodBeat.i(93894);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
    h.wUl.n(985L, 5L, 1L);
    AppMethodBeat.o(93894);
  }
  
  public static void ary()
  {
    AppMethodBeat.i(93895);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCrop");
    h.wUl.n(985L, 7L, 1L);
    AppMethodBeat.o(93895);
  }
  
  public static void arz()
  {
    AppMethodBeat.i(93896);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markCpuCrop");
    h.wUl.n(985L, 8L, 1L);
    AppMethodBeat.o(93896);
  }
  
  public static void asA()
  {
    AppMethodBeat.i(93953);
    h.wUl.idkeyStat(985L, 166L, 1L, false);
    AppMethodBeat.o(93953);
  }
  
  public static void asB()
  {
    AppMethodBeat.i(93955);
    h.wUl.idkeyStat(985L, 169L, 1L, false);
    AppMethodBeat.o(93955);
  }
  
  public static void asC()
  {
    AppMethodBeat.i(93958);
    h.wUl.idkeyStat(985L, 174L, 1L, false);
    AppMethodBeat.o(93958);
  }
  
  public static void asD()
  {
    AppMethodBeat.i(93960);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseHwHevc");
    h.wUl.idkeyStat(985L, 181L, 1L, false);
    AppMethodBeat.o(93960);
  }
  
  public static void asE()
  {
    AppMethodBeat.i(93961);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseSwHevc");
    h.wUl.idkeyStat(985L, 182L, 1L, false);
    AppMethodBeat.o(93961);
  }
  
  public static void asF()
  {
    AppMethodBeat.i(93963);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
    h.wUl.n(986L, 7L, 1L);
    AppMethodBeat.o(93963);
  }
  
  public static void asG()
  {
    AppMethodBeat.i(93964);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
    h.wUl.n(986L, 10L, 1L);
    AppMethodBeat.o(93964);
  }
  
  public static void asH()
  {
    AppMethodBeat.i(93965);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
    h.wUl.n(986L, 11L, 1L);
    AppMethodBeat.o(93965);
  }
  
  public static void asI()
  {
    AppMethodBeat.i(93968);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
    h.wUl.n(986L, 14L, 1L);
    AppMethodBeat.o(93968);
  }
  
  public static void asJ()
  {
    AppMethodBeat.i(93969);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
    h.wUl.n(986L, 15L, 1L);
    AppMethodBeat.o(93969);
  }
  
  public static void asK()
  {
    AppMethodBeat.i(93970);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
    h.wUl.n(986L, 16L, 1L);
    AppMethodBeat.o(93970);
  }
  
  public static void asL()
  {
    AppMethodBeat.i(93971);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
    h.wUl.n(986L, 17L, 1L);
    AppMethodBeat.o(93971);
  }
  
  public static void asM()
  {
    AppMethodBeat.i(93972);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
    h.wUl.n(986L, 18L, 1L);
    AppMethodBeat.o(93972);
  }
  
  public static void asN()
  {
    AppMethodBeat.i(93973);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
    h.wUl.n(986L, 19L, 1L);
    AppMethodBeat.o(93973);
  }
  
  public static void asO()
  {
    AppMethodBeat.i(93974);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
    h.wUl.n(986L, 22L, 1L);
    AppMethodBeat.o(93974);
  }
  
  public static void asP()
  {
    AppMethodBeat.i(93975);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
    h.wUl.n(986L, 23L, 1L);
    AppMethodBeat.o(93975);
  }
  
  public static void asQ()
  {
    AppMethodBeat.i(93976);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
    h.wUl.n(986L, 24L, 1L);
    AppMethodBeat.o(93976);
  }
  
  public static void asR()
  {
    AppMethodBeat.i(93977);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
    h.wUl.n(986L, 26L, 1L);
    AppMethodBeat.o(93977);
  }
  
  public static void asS()
  {
    AppMethodBeat.i(93979);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
    h.wUl.n(986L, 30L, 1L);
    AppMethodBeat.o(93979);
  }
  
  public static void asT()
  {
    AppMethodBeat.i(93983);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
    h.wUl.n(986L, 53L, 1L);
    AppMethodBeat.o(93983);
  }
  
  public static void asU()
  {
    AppMethodBeat.i(93984);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
    h.wUl.n(986L, 25L, 1L);
    AppMethodBeat.o(93984);
  }
  
  public static void asV()
  {
    AppMethodBeat.i(93985);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
    h.wUl.n(986L, 76L, 1L);
    AppMethodBeat.o(93985);
  }
  
  public static void asW()
  {
    AppMethodBeat.i(93986);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
    h.wUl.n(986L, 80L, 1L);
    AppMethodBeat.o(93986);
  }
  
  public static void asX()
  {
    AppMethodBeat.i(93987);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
    h.wUl.n(986L, 80L, 1L);
    AppMethodBeat.o(93987);
  }
  
  public static void asY()
  {
    AppMethodBeat.i(93988);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
    h.wUl.n(986L, 77L, 1L);
    AppMethodBeat.o(93988);
  }
  
  public static void asZ()
  {
    AppMethodBeat.i(93989);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
    h.wUl.n(986L, 81L, 1L);
    AppMethodBeat.o(93989);
  }
  
  public static void asa()
  {
    AppMethodBeat.i(93927);
    h.wUl.idkeyStat(985L, 124L, 1L, false);
    AppMethodBeat.o(93927);
  }
  
  public static void asb()
  {
    AppMethodBeat.i(93928);
    h.wUl.idkeyStat(985L, 125L, 1L, false);
    AppMethodBeat.o(93928);
  }
  
  public static void asc()
  {
    AppMethodBeat.i(93929);
    h.wUl.idkeyStat(985L, 126L, 1L, false);
    AppMethodBeat.o(93929);
  }
  
  public static void asd()
  {
    AppMethodBeat.i(93930);
    h.wUl.idkeyStat(985L, 127L, 1L, false);
    AppMethodBeat.o(93930);
  }
  
  public static void ase()
  {
    AppMethodBeat.i(93932);
    h.wUl.idkeyStat(985L, 130L, 1L, false);
    AppMethodBeat.o(93932);
  }
  
  public static void asf()
  {
    AppMethodBeat.i(93933);
    h.wUl.idkeyStat(985L, 135L, 1L, false);
    AppMethodBeat.o(93933);
  }
  
  public static void asg()
  {
    AppMethodBeat.i(93934);
    h.wUl.idkeyStat(985L, 136L, 1L, false);
    AppMethodBeat.o(93934);
  }
  
  public static void ash()
  {
    AppMethodBeat.i(93935);
    h.wUl.idkeyStat(985L, 138L, 1L, false);
    AppMethodBeat.o(93935);
  }
  
  public static void asi()
  {
    AppMethodBeat.i(93936);
    h.wUl.idkeyStat(985L, 139L, 1L, false);
    AppMethodBeat.o(93936);
  }
  
  public static void asj()
  {
    AppMethodBeat.i(93937);
    h.wUl.idkeyStat(985L, 143L, 1L, false);
    AppMethodBeat.o(93937);
  }
  
  public static void ask()
  {
    AppMethodBeat.i(93938);
    h.wUl.idkeyStat(985L, 144L, 1L, false);
    AppMethodBeat.o(93938);
  }
  
  public static void asl()
  {
    AppMethodBeat.i(93939);
    h.wUl.idkeyStat(985L, 146L, 1L, false);
    AppMethodBeat.o(93939);
  }
  
  public static void asm()
  {
    AppMethodBeat.i(177318);
    h.wUl.idkeyStat(985L, 147L, 1L, false);
    AppMethodBeat.o(177318);
  }
  
  public static void asn()
  {
    AppMethodBeat.i(177319);
    h.wUl.idkeyStat(985L, 148L, 1L, false);
    AppMethodBeat.o(177319);
  }
  
  public static void aso()
  {
    AppMethodBeat.i(93940);
    h.wUl.idkeyStat(985L, 149L, 1L, false);
    AppMethodBeat.o(93940);
  }
  
  public static void asp()
  {
    AppMethodBeat.i(93941);
    h.wUl.idkeyStat(985L, 150L, 1L, false);
    AppMethodBeat.o(93941);
  }
  
  public static void asq()
  {
    AppMethodBeat.i(93942);
    h.wUl.idkeyStat(985L, 151L, 1L, false);
    AppMethodBeat.o(93942);
  }
  
  public static void asr()
  {
    AppMethodBeat.i(93943);
    h.wUl.idkeyStat(985L, 152L, 1L, false);
    AppMethodBeat.o(93943);
  }
  
  public static void ass()
  {
    AppMethodBeat.i(93944);
    h.wUl.idkeyStat(985L, 154L, 1L, false);
    AppMethodBeat.o(93944);
  }
  
  public static void ast()
  {
    AppMethodBeat.i(93946);
    h.wUl.idkeyStat(985L, 159L, 1L, false);
    AppMethodBeat.o(93946);
  }
  
  public static void asu()
  {
    AppMethodBeat.i(93947);
    h.wUl.idkeyStat(985L, 160L, 1L, false);
    AppMethodBeat.o(93947);
  }
  
  public static void asv()
  {
    AppMethodBeat.i(93948);
    h.wUl.idkeyStat(985L, 161L, 1L, false);
    AppMethodBeat.o(93948);
  }
  
  public static void asw()
  {
    AppMethodBeat.i(93949);
    h.wUl.idkeyStat(985L, 162L, 1L, false);
    AppMethodBeat.o(93949);
  }
  
  public static void asx()
  {
    AppMethodBeat.i(93950);
    h.wUl.idkeyStat(985L, 163L, 1L, false);
    AppMethodBeat.o(93950);
  }
  
  public static void asy()
  {
    AppMethodBeat.i(93951);
    h.wUl.idkeyStat(985L, 164L, 1L, false);
    AppMethodBeat.o(93951);
  }
  
  public static void asz()
  {
    AppMethodBeat.i(93952);
    h.wUl.idkeyStat(985L, 165L, 1L, false);
    AppMethodBeat.o(93952);
  }
  
  public static void ata()
  {
    AppMethodBeat.i(93990);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
    h.wUl.n(986L, 78L, 1L);
    AppMethodBeat.o(93990);
  }
  
  public static void atb()
  {
    AppMethodBeat.i(93991);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
    h.wUl.n(986L, 82L, 1L);
    AppMethodBeat.o(93991);
  }
  
  public static void atc()
  {
    AppMethodBeat.i(93992);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
    h.wUl.n(986L, 83L, 1L);
    AppMethodBeat.o(93992);
  }
  
  public static void atd()
  {
    AppMethodBeat.i(93993);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
    h.wUl.n(986L, 84L, 1L);
    AppMethodBeat.o(93993);
  }
  
  public static void ate()
  {
    AppMethodBeat.i(93994);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
    h.wUl.n(986L, 54L, 1L);
    AppMethodBeat.o(93994);
  }
  
  public static void atf()
  {
    AppMethodBeat.i(93995);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
    h.wUl.n(986L, 86L, 1L);
    AppMethodBeat.o(93995);
  }
  
  public static void atg()
  {
    AppMethodBeat.i(93996);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberMatch");
    h.wUl.n(986L, 90L, 1L);
    AppMethodBeat.o(93996);
  }
  
  public static void ath()
  {
    AppMethodBeat.i(93997);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberCheckTimeout");
    h.wUl.n(986L, 91L, 1L);
    AppMethodBeat.o(93997);
  }
  
  public static void ati()
  {
    AppMethodBeat.i(93998);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxX264Encode");
    h.wUl.n(986L, 100L, 1L);
    AppMethodBeat.o(93998);
  }
  
  public static void atj()
  {
    AppMethodBeat.i(93999);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseSwHevc");
    h.wUl.n(986L, 123L, 1L);
    AppMethodBeat.o(93999);
  }
  
  public static void atk()
  {
    AppMethodBeat.i(94000);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseHwHevc");
    h.wUl.n(986L, 124L, 1L);
    AppMethodBeat.o(94000);
  }
  
  public static void cV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93909);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.wUl.n(985L, 38L, paramInt1);
    h.wUl.n(985L, 41L, paramInt2);
    AppMethodBeat.o(93909);
  }
  
  public static void cW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93918);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.wUl.n(985L, 21L, paramInt1);
    h.wUl.n(985L, 24L, paramInt2);
    AppMethodBeat.o(93918);
  }
  
  public static void f(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(93982);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + paramLong1 + ", fps:" + paramLong2 + ", originVideoFps:" + paramLong3);
    h.wUl.n(986L, 43L, paramLong3);
    h.wUl.n(986L, 45L, paramLong2);
    h.wUl.n(986L, 48L, paramLong1);
    AppMethodBeat.o(93982);
  }
  
  public static void l(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93921);
    d.g.b.k.h(paramString, "filePath");
    for (;;)
    {
      Object localObject;
      int i1;
      int j;
      int i;
      int k;
      try
      {
        if ((bs.isNullOrNil(paramString)) || (!i.eA(paramString)))
        {
          AppMethodBeat.o(93921);
          return;
        }
        h.wUl.idkeyStat(985L, 69L, 1L, false);
        localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString));
        i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
        ac.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(((JSONObject)localObject).optInt("videoBitrate")), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        j = 89;
        m = 104;
        if (paramInt1 != 1) {
          break label324;
        }
        h.wUl.idkeyStat(985L, 71L, 1L, false);
        h.wUl.idkeyStat(985L, 73L, i1, false);
        i = 74;
        j = 95;
        paramInt1 = 98;
        k = 108;
        m = 107;
      }
      catch (Exception paramString)
      {
        int m;
        ac.e("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(93921);
        return;
      }
      h.wUl.idkeyStat(985L, paramInt2, 1L, false);
      h.wUl.idkeyStat(985L, paramInt1, i1, false);
      h.wUl.idkeyStat(985L, m, 1L, false);
      h.wUl.idkeyStat(985L, k, i1, false);
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { paramString, Integer.valueOf(i) });
      if ((i1 >= 0) && (i1 <= 10))
      {
        h.wUl.idkeyStat(985L, i, 1L, false);
        AppMethodBeat.o(93921);
        return;
        label324:
        h.wUl.idkeyStat(985L, 70L, 1L, false);
        h.wUl.idkeyStat(985L, 72L, i1, false);
        k = 105;
        int n = 86;
        i = 57;
        paramInt1 = j;
        j = n;
      }
      while (paramInt2 != 720)
      {
        localObject = com.tencent.mm.plugin.mmsight.model.k.uLk;
        d.g.b.k.g(localObject, "MMSightRecorderConfig.parameter");
        if (((p)localObject).ddI()) {
          break label543;
        }
        if (paramInt2 == 1080)
        {
          break label543;
          if ((i1 > 10) && (i1 <= 15))
          {
            h.wUl.idkeyStat(985L, i + 1, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 15) && (i1 <= 20))
          {
            h.wUl.idkeyStat(985L, i + 2, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 20) && (i1 <= 30)) {
            h.wUl.idkeyStat(985L, i + 3, 1L, false);
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
  
  public static void np(int paramInt)
  {
    AppMethodBeat.i(93962);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, mixType:".concat(String.valueOf(paramInt)));
    h.wUl.n(986L, 0L, 1L);
    if (paramInt == 1)
    {
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
      h.wUl.n(986L, 1L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 3)
    {
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
      h.wUl.n(986L, 2L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 2)
    {
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
      h.wUl.n(986L, 3L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 0)
    {
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
      h.wUl.n(986L, 4L, 1L);
    }
    AppMethodBeat.o(93962);
  }
  
  public static void pA(long paramLong)
  {
    AppMethodBeat.i(93980);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMixTime: ".concat(String.valueOf(paramLong)));
    h.wUl.n(986L, 31L, paramLong);
    AppMethodBeat.o(93980);
  }
  
  public static void pB(long paramLong)
  {
    AppMethodBeat.i(177320);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markFrameHandlingTime time:".concat(String.valueOf(paramLong)));
    if (paramLong < 1000L)
    {
      h.wUl.n(986L, 130L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 2000L)
    {
      h.wUl.n(986L, 131L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 3000L)
    {
      h.wUl.n(986L, 132L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 4000L)
    {
      h.wUl.n(986L, 133L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 5000L)
    {
      h.wUl.n(986L, 134L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 6000L)
    {
      h.wUl.n(986L, 135L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 7000L)
    {
      h.wUl.n(986L, 136L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 8000L)
    {
      h.wUl.n(986L, 137L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 9000L)
    {
      h.wUl.n(986L, 138L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 10000L)
    {
      h.wUl.n(986L, 139L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 15000L)
    {
      h.wUl.n(986L, 140L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 20000L)
    {
      h.wUl.n(986L, 141L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    h.wUl.n(986L, 142L, 1L);
    AppMethodBeat.o(177320);
  }
  
  public static void ps(long paramLong)
  {
    AppMethodBeat.i(93926);
    h.wUl.idkeyStat(985L, 122L, paramLong, false);
    AppMethodBeat.o(93926);
  }
  
  public static void pt(long paramLong)
  {
    AppMethodBeat.i(93931);
    h.wUl.idkeyStat(985L, 128L, paramLong, false);
    AppMethodBeat.o(93931);
  }
  
  public static void pu(long paramLong)
  {
    AppMethodBeat.i(93945);
    h.wUl.idkeyStat(985L, 155L, paramLong, false);
    AppMethodBeat.o(93945);
  }
  
  public static void pv(long paramLong)
  {
    AppMethodBeat.i(93954);
    h.wUl.idkeyStat(985L, 168L, paramLong, false);
    AppMethodBeat.o(93954);
  }
  
  public static void pw(long paramLong)
  {
    AppMethodBeat.i(93956);
    h.wUl.idkeyStat(985L, 170L, paramLong, false);
    AppMethodBeat.o(93956);
  }
  
  public static void px(long paramLong)
  {
    AppMethodBeat.i(93957);
    h.wUl.idkeyStat(985L, 173L, paramLong, false);
    AppMethodBeat.o(93957);
  }
  
  public static void py(long paramLong)
  {
    AppMethodBeat.i(93959);
    h.wUl.idkeyStat(985L, 175L, paramLong, false);
    AppMethodBeat.o(93959);
  }
  
  public static void pz(long paramLong)
  {
    AppMethodBeat.i(93978);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMixTime: ".concat(String.valueOf(paramLong)));
    h.wUl.n(986L, 27L, paramLong);
    AppMethodBeat.o(93978);
  }
  
  public static void w(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93981);
    ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + paramInt + ", time:" + paramLong);
    h.wUl.n(986L, 34L, 1L);
    if (paramInt == 1)
    {
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeNoMusic, time:".concat(String.valueOf(paramLong)));
      h.wUl.n(986L, 35L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 3)
    {
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeAll, time:".concat(String.valueOf(paramLong)));
      h.wUl.n(986L, 41L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 2)
    {
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeMusicOnly, time:".concat(String.valueOf(paramLong)));
      h.wUl.n(986L, 37L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 0)
    {
      ac.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeSlient, time:".concat(String.valueOf(paramLong)));
      h.wUl.n(986L, 39L, paramLong);
    }
    AppMethodBeat.o(93981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.j.d
 * JD-Core Version:    0.7.0.1
 */