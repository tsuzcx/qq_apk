package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
  private static final long oJZ = 1012L;
  public static final e oKa;
  
  static
  {
    AppMethodBeat.i(188);
    oKa = new e();
    TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
    oJZ = 1012L;
    AppMethodBeat.o(188);
  }
  
  public static void akD()
  {
    AppMethodBeat.i(164);
    ad.i(TAG, "markCameraOpenFailed");
    h.vKh.m(oJZ, 3L, 1L);
    AppMethodBeat.o(164);
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(174);
    ad.i(TAG, "markStartEmojiMix, removeBackground:" + paramBoolean1 + ", hasSticker:" + paramBoolean2 + ", speedUp:" + paramBoolean3 + ", videoDuration:" + paramInt);
    h.vKh.m(oJZ, 17L, 1L);
    if (paramBoolean1) {
      h.vKh.m(oJZ, 18L, 1L);
    }
    if (paramBoolean2) {
      h.vKh.m(oJZ, 19L, 1L);
    }
    if (paramBoolean3) {
      h.vKh.m(oJZ, 20L, 1L);
    }
    if (paramInt > 0) {
      h.vKh.m(oJZ, 36L, paramInt);
    }
    AppMethodBeat.o(174);
  }
  
  public static void bXF()
  {
    AppMethodBeat.i(162);
    ad.i(TAG, "markEmojiCaptureUIOnCreate");
    h.vKh.m(oJZ, 0L, 1L);
    AppMethodBeat.o(162);
  }
  
  public static void bXG()
  {
    AppMethodBeat.i(163);
    ad.i(TAG, "markEmojiCaptureUIOnDestroy");
    h.vKh.m(oJZ, 1L, 1L);
    AppMethodBeat.o(163);
  }
  
  public static void bXH()
  {
    AppMethodBeat.i(165);
    ad.i(TAG, "markGpuCropPreview");
    h.vKh.m(oJZ, 6L, 1L);
    AppMethodBeat.o(165);
  }
  
  public static void bXI()
  {
    AppMethodBeat.i(166);
    ad.i(TAG, "markCpuCropPreview");
    h.vKh.m(oJZ, 7L, 1L);
    AppMethodBeat.o(166);
  }
  
  public static void bXJ()
  {
    AppMethodBeat.i(167);
    ad.i(TAG, "markGpuCropPreviewFailed");
    h.vKh.m(oJZ, 8L, 1L);
    AppMethodBeat.o(167);
  }
  
  public static void bXK()
  {
    AppMethodBeat.i(168);
    ad.i(TAG, "markCpuCropPreviewFailed");
    h.vKh.m(oJZ, 9L, 1L);
    AppMethodBeat.o(168);
  }
  
  public static void bXL()
  {
    AppMethodBeat.i(169);
    ad.i(TAG, "markVideoRecordFailed");
    h.vKh.m(oJZ, 10L, 1L);
    AppMethodBeat.o(169);
  }
  
  public static void bXM()
  {
    AppMethodBeat.i(170);
    ad.i(TAG, "markVideoRecordNoThumb");
    h.vKh.m(oJZ, 11L, 1L);
    AppMethodBeat.o(170);
  }
  
  public static void bXN()
  {
    AppMethodBeat.i(171);
    ad.i(TAG, "markSdkInitFailed");
    h.vKh.m(oJZ, 13L, 1L);
    AppMethodBeat.o(171);
  }
  
  public static void bXO()
  {
    AppMethodBeat.i(172);
    ad.i(TAG, "markSdkDrawFailed");
    h.vKh.m(oJZ, 14L, 1L);
    AppMethodBeat.o(172);
  }
  
  public static void bXP()
  {
    AppMethodBeat.i(173);
    ad.i(TAG, "markSdkReleaseFailed");
    h.vKh.m(oJZ, 15L, 1L);
    AppMethodBeat.o(173);
  }
  
  public static void bXQ()
  {
    AppMethodBeat.i(176);
    ad.i(TAG, "markPixelBufferInitFailed");
    h.vKh.m(oJZ, 25L, 1L);
    AppMethodBeat.o(176);
  }
  
  public static void bXR()
  {
    AppMethodBeat.i(177);
    ad.i(TAG, "markVideoDecoderInitFailed");
    h.vKh.m(oJZ, 26L, 1L);
    AppMethodBeat.o(177);
  }
  
  public static void bXS()
  {
    AppMethodBeat.i(178);
    ad.i(TAG, "markMixFrameDrawFailed");
    h.vKh.m(oJZ, 27L, 1L);
    AppMethodBeat.o(178);
  }
  
  public static void bXT()
  {
    AppMethodBeat.i(179);
    ad.i(TAG, "markUseWxam");
    h.vKh.m(oJZ, 30L, 1L);
    AppMethodBeat.o(179);
  }
  
  public static void bXU()
  {
    AppMethodBeat.i(180);
    ad.i(TAG, "markUseGif");
    h.vKh.m(oJZ, 31L, 1L);
    AppMethodBeat.o(180);
  }
  
  public static void bXV()
  {
    AppMethodBeat.i(181);
    ad.i(TAG, "markWxamInitFailed");
    h.vKh.m(oJZ, 32L, 1L);
    AppMethodBeat.o(181);
  }
  
  public static void bXW()
  {
    AppMethodBeat.i(182);
    ad.i(TAG, "markGifInitFailed");
    h.vKh.m(oJZ, 33L, 1L);
    AppMethodBeat.o(182);
  }
  
  public static void bXX()
  {
    AppMethodBeat.i(183);
    ad.i(TAG, "markSdkSegmentInitFailed");
    h.vKh.D(oJZ, 45L);
    AppMethodBeat.o(183);
  }
  
  public static void bXY()
  {
    AppMethodBeat.i(184);
    ad.i(TAG, "markSdkSegmentDestroyFailed");
    h.vKh.D(oJZ, 47L);
    AppMethodBeat.o(184);
  }
  
  public static void bXZ()
  {
    AppMethodBeat.i(185);
    h.vKh.D(oJZ, 56L);
    AppMethodBeat.o(185);
  }
  
  public static void bYa()
  {
    AppMethodBeat.i(186);
    h.vKh.D(oJZ, 57L);
    AppMethodBeat.o(186);
  }
  
  public static void bYb()
  {
    AppMethodBeat.i(187);
    ad.i(TAG, "markProxyCallFailed");
    h.vKh.D(oJZ, 59L);
    AppMethodBeat.o(187);
  }
  
  public static void p(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(175);
    ad.i(TAG, "markEmojiMixSucc, costTime:" + paramLong + ", removeBackground:" + paramBoolean);
    h.vKh.m(oJZ, 21L, 1L);
    if (paramBoolean) {
      h.vKh.m(oJZ, 23L, 1L);
    }
    while (paramBoolean)
    {
      h.vKh.m(oJZ, 42L, paramLong);
      AppMethodBeat.o(175);
      return;
      h.vKh.m(oJZ, 22L, 1L);
    }
    h.vKh.m(oJZ, 39L, paramLong);
    AppMethodBeat.o(175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.e
 * JD-Core Version:    0.7.0.1
 */