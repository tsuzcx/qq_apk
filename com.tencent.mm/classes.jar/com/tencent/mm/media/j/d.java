package com.tencent.mm.media.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.l;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markAfterCaptureFinish", "", "filePath", "recorderType", "", "resolutionLimit", "markBaseRecordBitrate", "bitrate", "markBaseRecordFps", "fps", "markBaseRecordSuccessTimes", "markC2cCaptureJumpRemux", "markCameraOpen", "markCameraOpenFailed", "markCameraOpenSuccess", "markCaptureUseHwHevc", "markCaptureUseSwHevc", "markCpuCrop", "markCreateExternalTextureFailed", "markDaemonRecordBitrate", "markDaemonRecordFps", "markDaemonRecordSuccessTimes", "markDoubleRemux", "markDoubleRemuxTimeCost", "time", "markEditErrorPath", "markEditPhoto", "markEditPhotoCost", "cost", "markEditPhotoFail", "markEditPhotoFailNullBitmap", "markEditToRecord", "markEglVersion2", "markEglVersion3", "markEncodeCreateSuccessTimes", "markEncodeCreateTimes", "markFrameHandlingTime", "markGpuCrop", "markGpuCropFailed", "markLayoutError", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markMediaCodecWriteYUVError", "markMediaCodecYUVInitError", "markMp4EncoderCreate", "markMp4EncoderRelease", "markPhotoCapture", "markPhotoCaptureFail", "markPhotoEdit", "markPhotoEdited", "markPhotoTimeCost", "markRecordCancelTimes", "markRecordTimes", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckBFrameCost", "markRemuxCheckBFrameFailed", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCheckHasBFrame", "markRemuxCheckHasBFrameTimeout", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxEncoderCreate", "markRemuxEncoderRelease", "markRemuxEndWithFrameNumberCheckTimeout", "markRemuxEndWithFrameNumberMatch", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxUseHwHevc", "markRemuxUseSwHevc", "markRemuxVideoParaError", "markRemuxX264Encode", "markReserveEncoder", "markSavePhotoFail", "markSnsCaptureJumpRemux", "markStartBaseRecordTimeout", "markStartDaemonRecordSuccessTimes", "markStartDaemonRecordTimeout", "markStartDaemonRecordTimes", "markSyncEncoderCreate", "markSyncEncoderRelease", "markVideoEdited", "markVideoGenerate", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "markaSyncEncoderCreate", "markaSyncEncoderRelease", "plugin-mediaeditor_release"})
public final class d
{
  private static long gwp;
  private static long gwq;
  public static final d gwr;
  
  static
  {
    AppMethodBeat.i(94001);
    gwr = new d();
    gwp = -1L;
    gwq = -1L;
    AppMethodBeat.o(94001);
  }
  
  public static void akB()
  {
    AppMethodBeat.i(93892);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
    h.vKh.m(985L, 3L, 1L);
    AppMethodBeat.o(93892);
  }
  
  public static void akC()
  {
    AppMethodBeat.i(93893);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
    h.vKh.m(985L, 4L, 1L);
    AppMethodBeat.o(93893);
  }
  
  public static void akD()
  {
    AppMethodBeat.i(93894);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
    h.vKh.m(985L, 5L, 1L);
    AppMethodBeat.o(93894);
  }
  
  public static void akE()
  {
    AppMethodBeat.i(93895);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCrop");
    h.vKh.m(985L, 7L, 1L);
    AppMethodBeat.o(93895);
  }
  
  public static void akF()
  {
    AppMethodBeat.i(93896);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCpuCrop");
    h.vKh.m(985L, 8L, 1L);
    AppMethodBeat.o(93896);
  }
  
  public static void akG()
  {
    AppMethodBeat.i(93897);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCropFailed");
    h.vKh.m(985L, 10L, 1L);
    AppMethodBeat.o(93897);
  }
  
  public static void akH()
  {
    AppMethodBeat.i(93898);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.vKh.m(985L, 11L, 1L);
    AppMethodBeat.o(93898);
  }
  
  public static void akI()
  {
    AppMethodBeat.i(93899);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markEglVersion2");
    h.vKh.m(985L, 12L, 1L);
    AppMethodBeat.o(93899);
  }
  
  public static void akJ()
  {
    AppMethodBeat.i(93900);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCreateExternalTextureFailed");
    h.vKh.m(985L, 55L, 1L);
    AppMethodBeat.o(93900);
  }
  
  public static void akK()
  {
    AppMethodBeat.i(93901);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
    gwp = -1L;
    h.vKh.m(985L, 30L, 1L);
    AppMethodBeat.o(93901);
  }
  
  public static void akL()
  {
    AppMethodBeat.i(93902);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
    h.vKh.m(985L, 31L, 1L);
    AppMethodBeat.o(93902);
  }
  
  public static void akM()
  {
    AppMethodBeat.i(93903);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
    h.vKh.m(985L, 32L, 1L);
    AppMethodBeat.o(93903);
  }
  
  public static void akN()
  {
    AppMethodBeat.i(93904);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
    h.vKh.m(985L, 33L, 1L);
    AppMethodBeat.o(93904);
  }
  
  public static void akO()
  {
    AppMethodBeat.i(93905);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
    gwq = bt.GC();
    AppMethodBeat.o(93905);
  }
  
  public static void akP()
  {
    AppMethodBeat.i(93906);
    if (gwq > 0L)
    {
      long l = bt.aS(gwq);
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264WaitStop, waitTime:".concat(String.valueOf(l)));
      h.vKh.m(985L, 34L, l);
      h.vKh.m(985L, 35L, 1L);
      gwq = -1L;
    }
    AppMethodBeat.o(93906);
  }
  
  public static void akQ()
  {
    AppMethodBeat.i(93907);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
    h.vKh.m(985L, 37L, 1L);
    AppMethodBeat.o(93907);
  }
  
  public static void akR()
  {
    AppMethodBeat.i(93908);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
    h.vKh.m(985L, 39L, 1L);
    AppMethodBeat.o(93908);
  }
  
  public static void akS()
  {
    AppMethodBeat.i(93910);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
    gwq = -1L;
    h.vKh.m(985L, 13L, 1L);
    AppMethodBeat.o(93910);
  }
  
  public static void akT()
  {
    AppMethodBeat.i(93911);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
    h.vKh.m(985L, 14L, 1L);
    AppMethodBeat.o(93911);
  }
  
  public static void akU()
  {
    AppMethodBeat.i(93912);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
    h.vKh.m(985L, 15L, 1L);
    AppMethodBeat.o(93912);
  }
  
  public static void akV()
  {
    AppMethodBeat.i(93913);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
    h.vKh.m(985L, 16L, 1L);
    AppMethodBeat.o(93913);
  }
  
  public static void akW()
  {
    AppMethodBeat.i(93914);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
    gwq = bt.GC();
    AppMethodBeat.o(93914);
  }
  
  public static void akX()
  {
    AppMethodBeat.i(93915);
    if (gwq > 0L)
    {
      long l = bt.aS(gwq);
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWaitStop, waitTime:".concat(String.valueOf(l)));
      h.vKh.m(985L, 17L, l);
      h.vKh.m(985L, 18L, 1L);
      gwq = -1L;
    }
    AppMethodBeat.o(93915);
  }
  
  public static void akY()
  {
    AppMethodBeat.i(93916);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
    h.vKh.m(985L, 20L, 1L);
    AppMethodBeat.o(93916);
  }
  
  public static void akZ()
  {
    AppMethodBeat.i(93917);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
    h.vKh.m(985L, 22L, 1L);
    AppMethodBeat.o(93917);
  }
  
  public static void alA()
  {
    AppMethodBeat.i(93947);
    h.vKh.idkeyStat(985L, 160L, 1L, false);
    AppMethodBeat.o(93947);
  }
  
  public static void alB()
  {
    AppMethodBeat.i(93948);
    h.vKh.idkeyStat(985L, 161L, 1L, false);
    AppMethodBeat.o(93948);
  }
  
  public static void alC()
  {
    AppMethodBeat.i(93949);
    h.vKh.idkeyStat(985L, 162L, 1L, false);
    AppMethodBeat.o(93949);
  }
  
  public static void alD()
  {
    AppMethodBeat.i(93950);
    h.vKh.idkeyStat(985L, 163L, 1L, false);
    AppMethodBeat.o(93950);
  }
  
  public static void alE()
  {
    AppMethodBeat.i(93951);
    h.vKh.idkeyStat(985L, 164L, 1L, false);
    AppMethodBeat.o(93951);
  }
  
  public static void alF()
  {
    AppMethodBeat.i(93952);
    h.vKh.idkeyStat(985L, 165L, 1L, false);
    AppMethodBeat.o(93952);
  }
  
  public static void alG()
  {
    AppMethodBeat.i(93953);
    h.vKh.idkeyStat(985L, 166L, 1L, false);
    AppMethodBeat.o(93953);
  }
  
  public static void alH()
  {
    AppMethodBeat.i(93955);
    h.vKh.idkeyStat(985L, 169L, 1L, false);
    AppMethodBeat.o(93955);
  }
  
  public static void alI()
  {
    AppMethodBeat.i(93958);
    h.vKh.idkeyStat(985L, 174L, 1L, false);
    AppMethodBeat.o(93958);
  }
  
  public static void alJ()
  {
    AppMethodBeat.i(93960);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseHwHevc");
    h.vKh.idkeyStat(985L, 181L, 1L, false);
    AppMethodBeat.o(93960);
  }
  
  public static void alK()
  {
    AppMethodBeat.i(93961);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markCaptureUseSwHevc");
    h.vKh.idkeyStat(985L, 182L, 1L, false);
    AppMethodBeat.o(93961);
  }
  
  public static void alL()
  {
    AppMethodBeat.i(93963);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
    h.vKh.m(986L, 7L, 1L);
    AppMethodBeat.o(93963);
  }
  
  public static void alM()
  {
    AppMethodBeat.i(93964);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
    h.vKh.m(986L, 10L, 1L);
    AppMethodBeat.o(93964);
  }
  
  public static void alN()
  {
    AppMethodBeat.i(93965);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
    h.vKh.m(986L, 11L, 1L);
    AppMethodBeat.o(93965);
  }
  
  public static void alO()
  {
    AppMethodBeat.i(93966);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRect");
    h.vKh.m(986L, 12L, 1L);
    AppMethodBeat.o(93966);
  }
  
  public static void alP()
  {
    AppMethodBeat.i(93967);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropHit");
    h.vKh.m(986L, 13L, 1L);
    AppMethodBeat.o(93967);
  }
  
  public static void alQ()
  {
    AppMethodBeat.i(93968);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
    h.vKh.m(986L, 14L, 1L);
    AppMethodBeat.o(93968);
  }
  
  public static void alR()
  {
    AppMethodBeat.i(93969);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
    h.vKh.m(986L, 15L, 1L);
    AppMethodBeat.o(93969);
  }
  
  public static void alS()
  {
    AppMethodBeat.i(93970);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
    h.vKh.m(986L, 16L, 1L);
    AppMethodBeat.o(93970);
  }
  
  public static void alT()
  {
    AppMethodBeat.i(93971);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
    h.vKh.m(986L, 17L, 1L);
    AppMethodBeat.o(93971);
  }
  
  public static void alU()
  {
    AppMethodBeat.i(93972);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
    h.vKh.m(986L, 18L, 1L);
    AppMethodBeat.o(93972);
  }
  
  public static void alV()
  {
    AppMethodBeat.i(93973);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
    h.vKh.m(986L, 19L, 1L);
    AppMethodBeat.o(93973);
  }
  
  public static void alW()
  {
    AppMethodBeat.i(93974);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
    h.vKh.m(986L, 22L, 1L);
    AppMethodBeat.o(93974);
  }
  
  public static void alX()
  {
    AppMethodBeat.i(93975);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
    h.vKh.m(986L, 23L, 1L);
    AppMethodBeat.o(93975);
  }
  
  public static void alY()
  {
    AppMethodBeat.i(93976);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
    h.vKh.m(986L, 24L, 1L);
    AppMethodBeat.o(93976);
  }
  
  public static void alZ()
  {
    AppMethodBeat.i(93977);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
    h.vKh.m(986L, 26L, 1L);
    AppMethodBeat.o(93977);
  }
  
  public static void ala()
  {
    AppMethodBeat.i(93919);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecYUVInitError");
    h.vKh.m(985L, 26L, 1L);
    AppMethodBeat.o(93919);
  }
  
  public static void alb()
  {
    AppMethodBeat.i(93920);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWriteYUVError");
    h.vKh.m(985L, 27L, 1L);
    AppMethodBeat.o(93920);
  }
  
  public static void alc()
  {
    AppMethodBeat.i(93922);
    h.vKh.idkeyStat(985L, 118L, 1L, false);
    AppMethodBeat.o(93922);
  }
  
  public static void ald()
  {
    AppMethodBeat.i(93923);
    h.vKh.idkeyStat(985L, 119L, 1L, false);
    AppMethodBeat.o(93923);
  }
  
  public static void ale()
  {
    AppMethodBeat.i(93924);
    h.vKh.idkeyStat(985L, 120L, 1L, false);
    AppMethodBeat.o(93924);
  }
  
  public static void alf()
  {
    AppMethodBeat.i(93925);
    h.vKh.idkeyStat(985L, 121L, 1L, false);
    AppMethodBeat.o(93925);
  }
  
  public static void alg()
  {
    AppMethodBeat.i(93927);
    h.vKh.idkeyStat(985L, 124L, 1L, false);
    AppMethodBeat.o(93927);
  }
  
  public static void alh()
  {
    AppMethodBeat.i(93928);
    h.vKh.idkeyStat(985L, 125L, 1L, false);
    AppMethodBeat.o(93928);
  }
  
  public static void ali()
  {
    AppMethodBeat.i(93929);
    h.vKh.idkeyStat(985L, 126L, 1L, false);
    AppMethodBeat.o(93929);
  }
  
  public static void alj()
  {
    AppMethodBeat.i(93930);
    h.vKh.idkeyStat(985L, 127L, 1L, false);
    AppMethodBeat.o(93930);
  }
  
  public static void alk()
  {
    AppMethodBeat.i(93932);
    h.vKh.idkeyStat(985L, 130L, 1L, false);
    AppMethodBeat.o(93932);
  }
  
  public static void all()
  {
    AppMethodBeat.i(93933);
    h.vKh.idkeyStat(985L, 135L, 1L, false);
    AppMethodBeat.o(93933);
  }
  
  public static void alm()
  {
    AppMethodBeat.i(93934);
    h.vKh.idkeyStat(985L, 136L, 1L, false);
    AppMethodBeat.o(93934);
  }
  
  public static void aln()
  {
    AppMethodBeat.i(93935);
    h.vKh.idkeyStat(985L, 138L, 1L, false);
    AppMethodBeat.o(93935);
  }
  
  public static void alo()
  {
    AppMethodBeat.i(93936);
    h.vKh.idkeyStat(985L, 139L, 1L, false);
    AppMethodBeat.o(93936);
  }
  
  public static void alp()
  {
    AppMethodBeat.i(93937);
    h.vKh.idkeyStat(985L, 143L, 1L, false);
    AppMethodBeat.o(93937);
  }
  
  public static void alq()
  {
    AppMethodBeat.i(93938);
    h.vKh.idkeyStat(985L, 144L, 1L, false);
    AppMethodBeat.o(93938);
  }
  
  public static void alr()
  {
    AppMethodBeat.i(93939);
    h.vKh.idkeyStat(985L, 146L, 1L, false);
    AppMethodBeat.o(93939);
  }
  
  public static void als()
  {
    AppMethodBeat.i(177318);
    h.vKh.idkeyStat(985L, 147L, 1L, false);
    AppMethodBeat.o(177318);
  }
  
  public static void alt()
  {
    AppMethodBeat.i(177319);
    h.vKh.idkeyStat(985L, 148L, 1L, false);
    AppMethodBeat.o(177319);
  }
  
  public static void alu()
  {
    AppMethodBeat.i(93940);
    h.vKh.idkeyStat(985L, 149L, 1L, false);
    AppMethodBeat.o(93940);
  }
  
  public static void alv()
  {
    AppMethodBeat.i(93941);
    h.vKh.idkeyStat(985L, 150L, 1L, false);
    AppMethodBeat.o(93941);
  }
  
  public static void alw()
  {
    AppMethodBeat.i(93942);
    h.vKh.idkeyStat(985L, 151L, 1L, false);
    AppMethodBeat.o(93942);
  }
  
  public static void alx()
  {
    AppMethodBeat.i(93943);
    h.vKh.idkeyStat(985L, 152L, 1L, false);
    AppMethodBeat.o(93943);
  }
  
  public static void aly()
  {
    AppMethodBeat.i(93944);
    h.vKh.idkeyStat(985L, 154L, 1L, false);
    AppMethodBeat.o(93944);
  }
  
  public static void alz()
  {
    AppMethodBeat.i(93946);
    h.vKh.idkeyStat(985L, 159L, 1L, false);
    AppMethodBeat.o(93946);
  }
  
  public static void ama()
  {
    AppMethodBeat.i(93979);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
    h.vKh.m(986L, 30L, 1L);
    AppMethodBeat.o(93979);
  }
  
  public static void amb()
  {
    AppMethodBeat.i(93983);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
    h.vKh.m(986L, 53L, 1L);
    AppMethodBeat.o(93983);
  }
  
  public static void amc()
  {
    AppMethodBeat.i(93984);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
    h.vKh.m(986L, 25L, 1L);
    AppMethodBeat.o(93984);
  }
  
  public static void amd()
  {
    AppMethodBeat.i(93985);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
    h.vKh.m(986L, 76L, 1L);
    AppMethodBeat.o(93985);
  }
  
  public static void ame()
  {
    AppMethodBeat.i(93986);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
    h.vKh.m(986L, 80L, 1L);
    AppMethodBeat.o(93986);
  }
  
  public static void amf()
  {
    AppMethodBeat.i(93987);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
    h.vKh.m(986L, 80L, 1L);
    AppMethodBeat.o(93987);
  }
  
  public static void amg()
  {
    AppMethodBeat.i(93988);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
    h.vKh.m(986L, 77L, 1L);
    AppMethodBeat.o(93988);
  }
  
  public static void amh()
  {
    AppMethodBeat.i(93989);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
    h.vKh.m(986L, 81L, 1L);
    AppMethodBeat.o(93989);
  }
  
  public static void ami()
  {
    AppMethodBeat.i(93990);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
    h.vKh.m(986L, 78L, 1L);
    AppMethodBeat.o(93990);
  }
  
  public static void amj()
  {
    AppMethodBeat.i(93991);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
    h.vKh.m(986L, 82L, 1L);
    AppMethodBeat.o(93991);
  }
  
  public static void amk()
  {
    AppMethodBeat.i(93992);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
    h.vKh.m(986L, 83L, 1L);
    AppMethodBeat.o(93992);
  }
  
  public static void aml()
  {
    AppMethodBeat.i(93993);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
    h.vKh.m(986L, 84L, 1L);
    AppMethodBeat.o(93993);
  }
  
  public static void amm()
  {
    AppMethodBeat.i(93994);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
    h.vKh.m(986L, 54L, 1L);
    AppMethodBeat.o(93994);
  }
  
  public static void amn()
  {
    AppMethodBeat.i(93995);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
    h.vKh.m(986L, 86L, 1L);
    AppMethodBeat.o(93995);
  }
  
  public static void amo()
  {
    AppMethodBeat.i(93996);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberMatch");
    h.vKh.m(986L, 90L, 1L);
    AppMethodBeat.o(93996);
  }
  
  public static void amp()
  {
    AppMethodBeat.i(93997);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberCheckTimeout");
    h.vKh.m(986L, 91L, 1L);
    AppMethodBeat.o(93997);
  }
  
  public static void amq()
  {
    AppMethodBeat.i(93998);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxX264Encode");
    h.vKh.m(986L, 100L, 1L);
    AppMethodBeat.o(93998);
  }
  
  public static void amr()
  {
    AppMethodBeat.i(93999);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseSwHevc");
    h.vKh.m(986L, 123L, 1L);
    AppMethodBeat.o(93999);
  }
  
  public static void ams()
  {
    AppMethodBeat.i(94000);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxUseHwHevc");
    h.vKh.m(986L, 124L, 1L);
    AppMethodBeat.o(94000);
  }
  
  public static void cV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93909);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.vKh.m(985L, 38L, paramInt1);
    h.vKh.m(985L, 41L, paramInt2);
    AppMethodBeat.o(93909);
  }
  
  public static void cW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(93918);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.vKh.m(985L, 21L, paramInt1);
    h.vKh.m(985L, 24L, paramInt2);
    AppMethodBeat.o(93918);
  }
  
  public static void e(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(93982);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + paramLong1 + ", fps:" + paramLong2 + ", originVideoFps:" + paramLong3);
    h.vKh.m(986L, 43L, paramLong3);
    h.vKh.m(986L, 45L, paramLong2);
    h.vKh.m(986L, 48L, paramLong1);
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
        if ((bt.isNullOrNil(paramString)) || (!i.eK(paramString)))
        {
          AppMethodBeat.o(93921);
          return;
        }
        h.vKh.idkeyStat(985L, 69L, 1L, false);
        localObject = new JSONObject(SightVideoJNI.getSimpleMp4InfoVFS(paramString));
        i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
        ad.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(((JSONObject)localObject).optInt("videoBitrate")), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        j = 89;
        m = 104;
        if (paramInt1 != 1) {
          break label324;
        }
        h.vKh.idkeyStat(985L, 71L, 1L, false);
        h.vKh.idkeyStat(985L, 73L, i1, false);
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
      h.vKh.idkeyStat(985L, paramInt2, 1L, false);
      h.vKh.idkeyStat(985L, paramInt1, i1, false);
      h.vKh.idkeyStat(985L, m, 1L, false);
      h.vKh.idkeyStat(985L, k, i1, false);
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { paramString, Integer.valueOf(i) });
      if ((i1 >= 0) && (i1 <= 10))
      {
        h.vKh.idkeyStat(985L, i, 1L, false);
        AppMethodBeat.o(93921);
        return;
        label324:
        h.vKh.idkeyStat(985L, 70L, 1L, false);
        h.vKh.idkeyStat(985L, 72L, i1, false);
        k = 105;
        int n = 86;
        i = 57;
        paramInt1 = j;
        j = n;
      }
      while (paramInt2 != 720)
      {
        localObject = com.tencent.mm.plugin.mmsight.model.k.tCN;
        d.g.b.k.g(localObject, "MMSightRecorderConfig.parameter");
        if (((p)localObject).cQa()) {
          break label543;
        }
        if (paramInt2 == 1080)
        {
          break label543;
          if ((i1 > 10) && (i1 <= 15))
          {
            h.vKh.idkeyStat(985L, i + 1, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 15) && (i1 <= 20))
          {
            h.vKh.idkeyStat(985L, i + 2, 1L, false);
            AppMethodBeat.o(93921);
            return;
          }
          if ((i1 > 20) && (i1 <= 30)) {
            h.vKh.idkeyStat(985L, i + 3, 1L, false);
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
  
  public static void lE(long paramLong)
  {
    AppMethodBeat.i(93926);
    h.vKh.idkeyStat(985L, 122L, paramLong, false);
    AppMethodBeat.o(93926);
  }
  
  public static void lF(long paramLong)
  {
    AppMethodBeat.i(93931);
    h.vKh.idkeyStat(985L, 128L, paramLong, false);
    AppMethodBeat.o(93931);
  }
  
  public static void lG(long paramLong)
  {
    AppMethodBeat.i(93945);
    h.vKh.idkeyStat(985L, 155L, paramLong, false);
    AppMethodBeat.o(93945);
  }
  
  public static void lH(long paramLong)
  {
    AppMethodBeat.i(93954);
    h.vKh.idkeyStat(985L, 168L, paramLong, false);
    AppMethodBeat.o(93954);
  }
  
  public static void lI(long paramLong)
  {
    AppMethodBeat.i(93956);
    h.vKh.idkeyStat(985L, 170L, paramLong, false);
    AppMethodBeat.o(93956);
  }
  
  public static void lJ(long paramLong)
  {
    AppMethodBeat.i(93957);
    h.vKh.idkeyStat(985L, 173L, paramLong, false);
    AppMethodBeat.o(93957);
  }
  
  public static void lK(long paramLong)
  {
    AppMethodBeat.i(93959);
    h.vKh.idkeyStat(985L, 175L, paramLong, false);
    AppMethodBeat.o(93959);
  }
  
  public static void lL(long paramLong)
  {
    AppMethodBeat.i(93978);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMixTime: ".concat(String.valueOf(paramLong)));
    h.vKh.m(986L, 27L, paramLong);
    AppMethodBeat.o(93978);
  }
  
  public static void lM(long paramLong)
  {
    AppMethodBeat.i(93980);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMixTime: ".concat(String.valueOf(paramLong)));
    h.vKh.m(986L, 31L, paramLong);
    AppMethodBeat.o(93980);
  }
  
  public static void lN(long paramLong)
  {
    AppMethodBeat.i(177320);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markFrameHandlingTime time:".concat(String.valueOf(paramLong)));
    if (paramLong < 1000L)
    {
      h.vKh.m(986L, 130L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 2000L)
    {
      h.vKh.m(986L, 131L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 3000L)
    {
      h.vKh.m(986L, 132L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 4000L)
    {
      h.vKh.m(986L, 133L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 5000L)
    {
      h.vKh.m(986L, 134L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 6000L)
    {
      h.vKh.m(986L, 135L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 7000L)
    {
      h.vKh.m(986L, 136L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 8000L)
    {
      h.vKh.m(986L, 137L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 9000L)
    {
      h.vKh.m(986L, 138L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 10000L)
    {
      h.vKh.m(986L, 139L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 15000L)
    {
      h.vKh.m(986L, 140L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    if (paramLong < 20000L)
    {
      h.vKh.m(986L, 141L, 1L);
      AppMethodBeat.o(177320);
      return;
    }
    h.vKh.m(986L, 142L, 1L);
    AppMethodBeat.o(177320);
  }
  
  public static void mB(int paramInt)
  {
    AppMethodBeat.i(93962);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, mixType:".concat(String.valueOf(paramInt)));
    h.vKh.m(986L, 0L, 1L);
    if (paramInt == 1)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
      h.vKh.m(986L, 1L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 3)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
      h.vKh.m(986L, 2L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 2)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
      h.vKh.m(986L, 3L, 1L);
      AppMethodBeat.o(93962);
      return;
    }
    if (paramInt == 0)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
      h.vKh.m(986L, 4L, 1L);
    }
    AppMethodBeat.o(93962);
  }
  
  public static void x(int paramInt, long paramLong)
  {
    AppMethodBeat.i(93981);
    ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + paramInt + ", time:" + paramLong);
    h.vKh.m(986L, 34L, 1L);
    if (paramInt == 1)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeNoMusic, time:".concat(String.valueOf(paramLong)));
      h.vKh.m(986L, 35L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 3)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeAll, time:".concat(String.valueOf(paramLong)));
      h.vKh.m(986L, 41L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 2)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeMusicOnly, time:".concat(String.valueOf(paramLong)));
      h.vKh.m(986L, 37L, paramLong);
      AppMethodBeat.o(93981);
      return;
    }
    if (paramInt == 0)
    {
      ad.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeSlient, time:".concat(String.valueOf(paramLong)));
      h.vKh.m(986L, 39L, paramLong);
    }
    AppMethodBeat.o(93981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.j.d
 * JD-Core Version:    0.7.0.1
 */