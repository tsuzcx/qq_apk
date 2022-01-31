package com.tencent.mm.media.i;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/util/MediaEditorIDKeyStat;", "", "()V", "CaptureID", "", "RemuxID", "TAG", "", "mediaCodecWaitTick", "x264WaitTick", "markAfterCaptureFinish", "", "filePath", "recorderType", "", "resolutionLimit", "markC2cCaptureJumpRemux", "markCameraOpen", "markCameraOpenFailed", "markCameraOpenSuccess", "markCpuCrop", "markCreateExternalTextureFailed", "markEditErrorPath", "markEditPhoto", "markEditPhotoCost", "cost", "markEditPhotoFail", "markEditPhotoFailNullBitmap", "markEditToRecord", "markEncodeCreateSuccessTimes", "markEncodeCreateTimes", "markGpuCrop", "markGpuCropFailed", "markLayoutError", "markMediaCodecAACRecorderInitFailed", "markMediaCodecCapture", "markMediaCodecCaptureFailed", "markMediaCodecCaptureResult", "bitrate", "fps", "markMediaCodecCaptureSuccess", "markMediaCodecGLInitFailed", "markMediaCodecInitFailed", "markMediaCodecStartWait", "markMediaCodecWaitStop", "markMediaCodecWriteYUVError", "markMediaCodecYUVInitError", "markPhotoCapture", "markPhotoCaptureFail", "markPhotoEdit", "markPhotoEdited", "markPhotoTimeCost", "markRemux", "mixType", "markRemuxAACAsyncMix", "markRemuxAACAsyncMixTime", "time", "markRemuxAACDecoderInitFailed", "markRemuxAACEncoderInitFailed", "markRemuxAACSyncMix", "markRemuxAACSyncMixTime", "markRemuxBackgroundNoAudioTrack", "markRemuxCheckBFrameCost", "markRemuxCheckBFrameFailed", "markRemuxCheckCropHit", "markRemuxCheckCropRect", "markRemuxCheckCropRectFailed", "markRemuxCheckHasBFrame", "markRemuxCheckHasBFrameTimeout", "markRemuxCopyFileFailed", "markRemuxDecodeFrameFailed", "markRemuxDecodeFrameFailedAsyncOnError", "markRemuxDecodeFrameFailedAsyncOnErrorStop", "markRemuxEncodeFrameFailed", "markRemuxEncodeFrameFailedAsyncOnError", "markRemuxEndWithFrameNumberCheckTimeout", "markRemuxEndWithFrameNumberMatch", "markRemuxFrameCountDiffError", "markRemuxFrameDrawFailed", "markRemuxFrameDrawTimeout", "markRemuxFrameDropBiggerThanOne", "markRemuxGLInitFailed", "markRemuxH264DecoderInitFailed", "markRemuxH264EncoderInitFailed", "markRemuxH265Video", "markRemuxMediaExtractorCreateFailed", "markRemuxMusicBackground", "markRemuxMusicMediaExtractorCreateFailed", "markRemuxMusicOnly", "markRemuxMuxVideoError", "markRemuxNoMusic", "markRemuxOnFrameAvailableDrawFailed", "markRemuxPcmFrameMixFailed", "markRemuxResultVideoFrameCountError", "markRemuxSlient", "markRemuxSuccess", "markRemuxSuccessResult", "originVideoFps", "markRemuxTimeAll", "markRemuxTimeMusicOnly", "markRemuxTimeNoMusic", "markRemuxTimeSlient", "markRemuxVideoParaError", "markRemuxX264Encode", "markSavePhotoFail", "markSnsCaptureJumpRemux", "markVideoEdited", "markVideoGenerate", "markX264AACRecorderInitFailed", "markX264Capture", "markX264CaptureFailed", "markX264CaptureResult", "markX264CaptureSuccess", "markX264GLInitFailed", "markX264InitFailed", "markX264StartWait", "markX264WaitStop", "plugin-mediaeditor_release"})
public final class c
{
  private static long eZA;
  private static long eZB;
  public static final c eZC;
  
  static
  {
    AppMethodBeat.i(13180);
    eZC = new c();
    eZA = -1L;
    eZB = -1L;
    AppMethodBeat.o(13180);
  }
  
  public static void VA()
  {
    AppMethodBeat.i(13133);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264AACRecorderInitFailed");
    h.qsU.j(985L, 33L, 1L);
    AppMethodBeat.o(13133);
  }
  
  public static void VB()
  {
    AppMethodBeat.i(13134);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264StartWait");
    eZB = bo.yB();
    AppMethodBeat.o(13134);
  }
  
  public static void VC()
  {
    AppMethodBeat.i(13135);
    if (eZB > 0L)
    {
      long l = bo.av(eZB);
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264WaitStop, waitTime:".concat(String.valueOf(l)));
      h.qsU.j(985L, 34L, l);
      h.qsU.j(985L, 35L, 1L);
      eZB = -1L;
    }
    AppMethodBeat.o(13135);
  }
  
  public static void VD()
  {
    AppMethodBeat.i(13136);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureFailed");
    h.qsU.j(985L, 37L, 1L);
    AppMethodBeat.o(13136);
  }
  
  public static void VE()
  {
    AppMethodBeat.i(13137);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureSuccess");
    h.qsU.j(985L, 39L, 1L);
    AppMethodBeat.o(13137);
  }
  
  public static void VF()
  {
    AppMethodBeat.i(13139);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCapture");
    eZB = -1L;
    h.qsU.j(985L, 13L, 1L);
    AppMethodBeat.o(13139);
  }
  
  public static void VG()
  {
    AppMethodBeat.i(13140);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecInitFailed");
    h.qsU.j(985L, 14L, 1L);
    AppMethodBeat.o(13140);
  }
  
  public static void VH()
  {
    AppMethodBeat.i(13141);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecGLInitFailed");
    h.qsU.j(985L, 15L, 1L);
    AppMethodBeat.o(13141);
  }
  
  public static void VI()
  {
    AppMethodBeat.i(13142);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecAACRecorderInitFailed");
    h.qsU.j(985L, 16L, 1L);
    AppMethodBeat.o(13142);
  }
  
  public static void VJ()
  {
    AppMethodBeat.i(13143);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecStartWait");
    eZB = bo.yB();
    AppMethodBeat.o(13143);
  }
  
  public static void VK()
  {
    AppMethodBeat.i(13144);
    if (eZB > 0L)
    {
      long l = bo.av(eZB);
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWaitStop, waitTime:".concat(String.valueOf(l)));
      h.qsU.j(985L, 17L, l);
      h.qsU.j(985L, 18L, 1L);
      eZB = -1L;
    }
    AppMethodBeat.o(13144);
  }
  
  public static void VL()
  {
    AppMethodBeat.i(13145);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureFailed");
    h.qsU.j(985L, 20L, 1L);
    AppMethodBeat.o(13145);
  }
  
  public static void VM()
  {
    AppMethodBeat.i(13146);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureSuccess");
    h.qsU.j(985L, 22L, 1L);
    AppMethodBeat.o(13146);
  }
  
  public static void VN()
  {
    AppMethodBeat.i(152107);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecYUVInitError");
    h.qsU.j(985L, 26L, 1L);
    AppMethodBeat.o(152107);
  }
  
  public static void VO()
  {
    AppMethodBeat.i(152108);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecWriteYUVError");
    h.qsU.j(985L, 27L, 1L);
    AppMethodBeat.o(152108);
  }
  
  public static void VP()
  {
    AppMethodBeat.i(156455);
    h.qsU.idkeyStat(985L, 118L, 1L, false);
    AppMethodBeat.o(156455);
  }
  
  public static void VQ()
  {
    AppMethodBeat.i(155540);
    h.qsU.idkeyStat(985L, 119L, 1L, false);
    AppMethodBeat.o(155540);
  }
  
  public static void VR()
  {
    AppMethodBeat.i(152110);
    h.qsU.idkeyStat(985L, 120L, 1L, false);
    AppMethodBeat.o(152110);
  }
  
  public static void VS()
  {
    AppMethodBeat.i(152111);
    h.qsU.idkeyStat(985L, 121L, 1L, false);
    AppMethodBeat.o(152111);
  }
  
  public static void VT()
  {
    AppMethodBeat.i(152113);
    h.qsU.idkeyStat(985L, 124L, 1L, false);
    AppMethodBeat.o(152113);
  }
  
  public static void VU()
  {
    AppMethodBeat.i(152114);
    h.qsU.idkeyStat(985L, 125L, 1L, false);
    AppMethodBeat.o(152114);
  }
  
  public static void VV()
  {
    AppMethodBeat.i(152115);
    h.qsU.idkeyStat(985L, 126L, 1L, false);
    AppMethodBeat.o(152115);
  }
  
  public static void VW()
  {
    AppMethodBeat.i(152116);
    h.qsU.idkeyStat(985L, 127L, 1L, false);
    AppMethodBeat.o(152116);
  }
  
  public static void VX()
  {
    AppMethodBeat.i(154822);
    h.qsU.idkeyStat(985L, 130L, 1L, false);
    AppMethodBeat.o(154822);
  }
  
  public static void VY()
  {
    AppMethodBeat.i(154823);
    h.qsU.idkeyStat(985L, 132L, 1L, false);
    AppMethodBeat.o(154823);
  }
  
  public static void VZ()
  {
    AppMethodBeat.i(155541);
    h.qsU.idkeyStat(985L, 135L, 1L, false);
    AppMethodBeat.o(155541);
  }
  
  public static void Vp()
  {
    AppMethodBeat.i(154821);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markLayoutError");
    h.qsU.j(985L, 2L, 1L);
    AppMethodBeat.o(154821);
  }
  
  public static void Vq()
  {
    AppMethodBeat.i(13127);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpen");
    h.qsU.j(985L, 3L, 1L);
    AppMethodBeat.o(13127);
  }
  
  public static void Vr()
  {
    AppMethodBeat.i(13128);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenSuccess");
    h.qsU.j(985L, 4L, 1L);
    AppMethodBeat.o(13128);
  }
  
  public static void Vs()
  {
    AppMethodBeat.i(13129);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markCameraOpenFailed");
    h.qsU.j(985L, 5L, 1L);
    AppMethodBeat.o(13129);
  }
  
  public static void Vt()
  {
    AppMethodBeat.i(152103);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCrop");
    h.qsU.j(985L, 7L, 1L);
    AppMethodBeat.o(152103);
  }
  
  public static void Vu()
  {
    AppMethodBeat.i(152104);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markCpuCrop");
    h.qsU.j(985L, 8L, 1L);
    AppMethodBeat.o(152104);
  }
  
  public static void Vv()
  {
    AppMethodBeat.i(152105);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markGpuCropFailed");
    h.qsU.j(985L, 10L, 1L);
    AppMethodBeat.o(152105);
  }
  
  public static void Vw()
  {
    AppMethodBeat.i(152106);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markCreateExternalTextureFailed");
    h.qsU.j(985L, 55L, 1L);
    AppMethodBeat.o(152106);
  }
  
  public static void Vx()
  {
    AppMethodBeat.i(13130);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264Capture");
    eZA = -1L;
    h.qsU.j(985L, 30L, 1L);
    AppMethodBeat.o(13130);
  }
  
  public static void Vy()
  {
    AppMethodBeat.i(13131);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264InitFailed");
    h.qsU.j(985L, 31L, 1L);
    AppMethodBeat.o(13131);
  }
  
  public static void Vz()
  {
    AppMethodBeat.i(13132);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264GLInitFailed");
    h.qsU.j(985L, 32L, 1L);
    AppMethodBeat.o(13132);
  }
  
  public static void WA()
  {
    AppMethodBeat.i(13175);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRectFailed");
    h.qsU.j(986L, 78L, 1L);
    AppMethodBeat.o(13175);
  }
  
  public static void WB()
  {
    AppMethodBeat.i(13176);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDropBiggerThanOne");
    h.qsU.j(986L, 82L, 1L);
    AppMethodBeat.o(13176);
  }
  
  public static void WC()
  {
    AppMethodBeat.i(13177);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxResultVideoFrameCountError");
    h.qsU.j(986L, 83L, 1L);
    AppMethodBeat.o(13177);
  }
  
  public static void WD()
  {
    AppMethodBeat.i(13178);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMuxVideoError");
    h.qsU.j(986L, 84L, 1L);
    AppMethodBeat.o(13178);
  }
  
  public static void WE()
  {
    AppMethodBeat.i(13179);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawTimeout");
    h.qsU.j(986L, 54L, 1L);
    AppMethodBeat.o(13179);
  }
  
  public static void WF()
  {
    AppMethodBeat.i(138369);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxOnFrameAvailableDrawFailed");
    h.qsU.j(986L, 86L, 1L);
    AppMethodBeat.o(138369);
  }
  
  public static void WG()
  {
    AppMethodBeat.i(152119);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberMatch");
    h.qsU.j(986L, 90L, 1L);
    AppMethodBeat.o(152119);
  }
  
  public static void WH()
  {
    AppMethodBeat.i(152120);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEndWithFrameNumberCheckTimeout");
    h.qsU.j(986L, 91L, 1L);
    AppMethodBeat.o(152120);
  }
  
  public static void WI()
  {
    AppMethodBeat.i(156458);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckHasBFrameTimeout");
    h.qsU.j(986L, 93L, 1L);
    AppMethodBeat.o(156458);
  }
  
  public static void WJ()
  {
    AppMethodBeat.i(154824);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckHasBFrame");
    h.qsU.j(986L, 94L, 1L);
    AppMethodBeat.o(154824);
  }
  
  public static void WK()
  {
    AppMethodBeat.i(154825);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckBFrameFailed");
    h.qsU.j(986L, 95L, 1L);
    AppMethodBeat.o(154825);
  }
  
  public static void WL()
  {
    AppMethodBeat.i(155543);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxX264Encode");
    h.qsU.j(986L, 100L, 1L);
    AppMethodBeat.o(155543);
  }
  
  public static void Wa()
  {
    AppMethodBeat.i(155542);
    h.qsU.idkeyStat(985L, 136L, 1L, false);
    AppMethodBeat.o(155542);
  }
  
  public static void Wb()
  {
    AppMethodBeat.i(156456);
    h.qsU.idkeyStat(985L, 138L, 1L, false);
    AppMethodBeat.o(156456);
  }
  
  public static void Wc()
  {
    AppMethodBeat.i(156457);
    h.qsU.idkeyStat(985L, 139L, 1L, false);
    AppMethodBeat.o(156457);
  }
  
  public static void Wd()
  {
    AppMethodBeat.i(13149);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH265Video");
    h.qsU.j(986L, 7L, 1L);
    AppMethodBeat.o(13149);
  }
  
  public static void We()
  {
    AppMethodBeat.i(13150);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxVideoParaError");
    h.qsU.j(986L, 10L, 1L);
    AppMethodBeat.o(13150);
  }
  
  public static void Wf()
  {
    AppMethodBeat.i(13151);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMediaExtractorCreateFailed");
    h.qsU.j(986L, 11L, 1L);
    AppMethodBeat.o(13151);
  }
  
  public static void Wg()
  {
    AppMethodBeat.i(13152);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropRect");
    h.qsU.j(986L, 12L, 1L);
    AppMethodBeat.o(13152);
  }
  
  public static void Wh()
  {
    AppMethodBeat.i(13153);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckCropHit");
    h.qsU.j(986L, 13L, 1L);
    AppMethodBeat.o(13153);
  }
  
  public static void Wi()
  {
    AppMethodBeat.i(13154);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCopyFileFailed");
    h.qsU.j(986L, 14L, 1L);
    AppMethodBeat.o(13154);
  }
  
  public static void Wj()
  {
    AppMethodBeat.i(13155);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicMediaExtractorCreateFailed");
    h.qsU.j(986L, 15L, 1L);
    AppMethodBeat.o(13155);
  }
  
  public static void Wk()
  {
    AppMethodBeat.i(13156);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264EncoderInitFailed");
    h.qsU.j(986L, 16L, 1L);
    AppMethodBeat.o(13156);
  }
  
  public static void Wl()
  {
    AppMethodBeat.i(13157);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxH264DecoderInitFailed");
    h.qsU.j(986L, 17L, 1L);
    AppMethodBeat.o(13157);
  }
  
  public static void Wm()
  {
    AppMethodBeat.i(13158);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxGLInitFailed");
    h.qsU.j(986L, 18L, 1L);
    AppMethodBeat.o(13158);
  }
  
  public static void Wn()
  {
    AppMethodBeat.i(13159);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameDrawFailed");
    h.qsU.j(986L, 19L, 1L);
    AppMethodBeat.o(13159);
  }
  
  public static void Wo()
  {
    AppMethodBeat.i(13160);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACDecoderInitFailed");
    h.qsU.j(986L, 22L, 1L);
    AppMethodBeat.o(13160);
  }
  
  public static void Wp()
  {
    AppMethodBeat.i(13161);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACEncoderInitFailed");
    h.qsU.j(986L, 23L, 1L);
    AppMethodBeat.o(13161);
  }
  
  public static void Wq()
  {
    AppMethodBeat.i(13162);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxPcmFrameMixFailed");
    h.qsU.j(986L, 24L, 1L);
    AppMethodBeat.o(13162);
  }
  
  public static void Wr()
  {
    AppMethodBeat.i(13163);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMix");
    h.qsU.j(986L, 26L, 1L);
    AppMethodBeat.o(13163);
  }
  
  public static void Ws()
  {
    AppMethodBeat.i(13165);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMix");
    h.qsU.j(986L, 30L, 1L);
    AppMethodBeat.o(13165);
  }
  
  public static void Wt()
  {
    AppMethodBeat.i(13169);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxFrameCountDiffError");
    h.qsU.j(986L, 53L, 1L);
    AppMethodBeat.o(13169);
  }
  
  public static void Wu()
  {
    AppMethodBeat.i(13170);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxBackgroundNoAudioTrack");
    h.qsU.j(986L, 25L, 1L);
    AppMethodBeat.o(13170);
  }
  
  public static void Wv()
  {
    AppMethodBeat.i(13171);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailed");
    h.qsU.j(986L, 76L, 1L);
    AppMethodBeat.o(13171);
  }
  
  public static void Ww()
  {
    AppMethodBeat.i(13172);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnError");
    h.qsU.j(986L, 80L, 1L);
    AppMethodBeat.o(13172);
  }
  
  public static void Wx()
  {
    AppMethodBeat.i(152118);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxDecodeFrameFailedAsyncOnErrorStop");
    h.qsU.j(986L, 80L, 1L);
    AppMethodBeat.o(152118);
  }
  
  public static void Wy()
  {
    AppMethodBeat.i(13173);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailed");
    h.qsU.j(986L, 77L, 1L);
    AppMethodBeat.o(13173);
  }
  
  public static void Wz()
  {
    AppMethodBeat.i(13174);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxEncodeFrameFailedAsyncOnError");
    h.qsU.j(986L, 81L, 1L);
    AppMethodBeat.o(13174);
  }
  
  public static void asj()
  {
    AppMethodBeat.i(156852);
    h.qsU.idkeyStat(985L, 143L, 1L, false);
    AppMethodBeat.o(156852);
  }
  
  public static void ask()
  {
    AppMethodBeat.i(156853);
    h.qsU.idkeyStat(985L, 144L, 1L, false);
    AppMethodBeat.o(156853);
  }
  
  public static void co(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13138);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markX264CaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.qsU.j(985L, 38L, paramInt1);
    h.qsU.j(985L, 41L, paramInt2);
    AppMethodBeat.o(13138);
  }
  
  public static void cp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13147);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, bitrate:" + paramInt1 + ", fps:" + paramInt2);
    h.qsU.j(985L, 21L, paramInt1);
    h.qsU.j(985L, 24L, paramInt2);
    AppMethodBeat.o(13147);
  }
  
  public static void d(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(13168);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccessResult, bitrate:" + paramLong1 + ", fps:" + paramLong2 + ", originVideoFps:" + paramLong3);
    h.qsU.j(986L, 43L, paramLong3);
    h.qsU.j(986L, 45L, paramLong2);
    h.qsU.j(986L, 48L, paramLong1);
    AppMethodBeat.o(13168);
  }
  
  public static void gl(long paramLong)
  {
    AppMethodBeat.i(152112);
    h.qsU.idkeyStat(985L, 122L, paramLong, false);
    AppMethodBeat.o(152112);
  }
  
  public static void gm(long paramLong)
  {
    AppMethodBeat.i(152117);
    h.qsU.idkeyStat(985L, 128L, paramLong, false);
    AppMethodBeat.o(152117);
  }
  
  public static void gn(long paramLong)
  {
    AppMethodBeat.i(13164);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACAsyncMixTime: ".concat(String.valueOf(paramLong)));
    h.qsU.j(986L, 27L, paramLong);
    AppMethodBeat.o(13164);
  }
  
  public static void go(long paramLong)
  {
    AppMethodBeat.i(13166);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxAACSyncMixTime: ".concat(String.valueOf(paramLong)));
    h.qsU.j(986L, 31L, paramLong);
    AppMethodBeat.o(13166);
  }
  
  public static void gp(long paramLong)
  {
    AppMethodBeat.i(154826);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxCheckBFrameCost");
    h.qsU.j(986L, 96L, 1L);
    h.qsU.j(986L, 97L, paramLong);
    AppMethodBeat.o(154826);
  }
  
  public static void jZ(int paramInt)
  {
    AppMethodBeat.i(13148);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markMediaCodecCaptureResult, mixType:".concat(String.valueOf(paramInt)));
    h.qsU.j(986L, 0L, 1L);
    if (paramInt == 1)
    {
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxNoMusic");
      h.qsU.j(986L, 1L, 1L);
      AppMethodBeat.o(13148);
      return;
    }
    if (paramInt == 3)
    {
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicBackground");
      h.qsU.j(986L, 2L, 1L);
      AppMethodBeat.o(13148);
      return;
    }
    if (paramInt == 2)
    {
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxMusicOnly");
      h.qsU.j(986L, 3L, 1L);
      AppMethodBeat.o(13148);
      return;
    }
    if (paramInt == 0)
    {
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSlient");
      h.qsU.j(986L, 4L, 1L);
    }
    AppMethodBeat.o(13148);
  }
  
  public static void p(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152109);
    a.f.b.j.q(paramString, "filePath");
    for (;;)
    {
      Object localObject;
      int i1;
      int j;
      int i;
      int k;
      try
      {
        if ((bo.isNullOrNil(paramString)) || (!e.cN(paramString)))
        {
          AppMethodBeat.o(152109);
          return;
        }
        h.qsU.idkeyStat(985L, 69L, 1L, false);
        localObject = new JSONObject(SightVideoJNI.getSimpleMp4Info(paramString));
        i1 = (int)((JSONObject)localObject).getDouble("videoFPS");
        ab.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, videoFPS: %s, videoBitrate: %s, recorderType: %s, resolutionLimit: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(((JSONObject)localObject).optInt("videoBitrate")), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        j = 89;
        m = 104;
        if (paramInt1 != 1) {
          break label324;
        }
        h.qsU.idkeyStat(985L, 71L, 1L, false);
        h.qsU.idkeyStat(985L, 73L, i1, false);
        i = 74;
        j = 95;
        paramInt1 = 98;
        k = 108;
        m = 107;
      }
      catch (Exception paramString)
      {
        int m;
        ab.e("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish error: %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(152109);
        return;
      }
      h.qsU.idkeyStat(985L, paramInt2, 1L, false);
      h.qsU.idkeyStat(985L, paramInt1, i1, false);
      h.qsU.idkeyStat(985L, m, 1L, false);
      h.qsU.idkeyStat(985L, k, i1, false);
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markAfterCaptureFinish, filePath: %s base %d", new Object[] { paramString, Integer.valueOf(i) });
      if ((i1 >= 0) && (i1 <= 10))
      {
        h.qsU.idkeyStat(985L, i, 1L, false);
        AppMethodBeat.o(152109);
        return;
        label324:
        h.qsU.idkeyStat(985L, 70L, 1L, false);
        h.qsU.idkeyStat(985L, 72L, i1, false);
        k = 105;
        int n = 86;
        i = 57;
        paramInt1 = j;
        j = n;
      }
      while (paramInt2 != 720)
      {
        localObject = com.tencent.mm.plugin.mmsight.model.j.oHG;
        a.f.b.j.p(localObject, "MMSightRecorderConfig.parameter");
        if (((o)localObject).bRg()) {
          break label543;
        }
        if (paramInt2 == 1080)
        {
          break label543;
          if ((i1 > 10) && (i1 <= 15))
          {
            h.qsU.idkeyStat(985L, i + 1, 1L, false);
            AppMethodBeat.o(152109);
            return;
          }
          if ((i1 > 15) && (i1 <= 20))
          {
            h.qsU.idkeyStat(985L, i + 2, 1L, false);
            AppMethodBeat.o(152109);
            return;
          }
          if ((i1 > 20) && (i1 <= 30)) {
            h.qsU.idkeyStat(985L, i + 3, 1L, false);
          }
          AppMethodBeat.o(152109);
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
  
  public static void v(int paramInt, long paramLong)
  {
    AppMethodBeat.i(13167);
    ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxSuccess, mixType:" + paramInt + ", time:" + paramLong);
    h.qsU.j(986L, 34L, 1L);
    if (paramInt == 1)
    {
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeNoMusic, time:".concat(String.valueOf(paramLong)));
      h.qsU.j(986L, 35L, paramLong);
      AppMethodBeat.o(13167);
      return;
    }
    if (paramInt == 3)
    {
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeAll, time:".concat(String.valueOf(paramLong)));
      h.qsU.j(986L, 41L, paramLong);
      AppMethodBeat.o(13167);
      return;
    }
    if (paramInt == 2)
    {
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeMusicOnly, time:".concat(String.valueOf(paramLong)));
      h.qsU.j(986L, 37L, paramLong);
      AppMethodBeat.o(13167);
      return;
    }
    if (paramInt == 0)
    {
      ab.i("MicroMsg.MediaEditorIDKeyStat", "markRemuxTimeSlient, time:".concat(String.valueOf(paramLong)));
      h.qsU.j(986L, 39L, paramLong);
    }
    AppMethodBeat.o(13167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.i.c
 * JD-Core Version:    0.7.0.1
 */