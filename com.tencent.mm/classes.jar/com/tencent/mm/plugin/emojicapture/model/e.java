package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
  private static final long pQX = 1012L;
  public static final e pQY;
  
  static
  {
    AppMethodBeat.i(188);
    pQY = new e();
    TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
    pQX = 1012L;
    AppMethodBeat.o(188);
  }
  
  public static void auk()
  {
    AppMethodBeat.i(164);
    ad.i(TAG, "markCameraOpenFailed");
    g.yhR.n(pQX, 3L, 1L);
    AppMethodBeat.o(164);
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(174);
    ad.i(TAG, "markStartEmojiMix, removeBackground:" + paramBoolean1 + ", hasSticker:" + paramBoolean2 + ", speedUp:" + paramBoolean3 + ", videoDuration:" + paramInt);
    g.yhR.n(pQX, 17L, 1L);
    if (paramBoolean1) {
      g.yhR.n(pQX, 18L, 1L);
    }
    if (paramBoolean2) {
      g.yhR.n(pQX, 19L, 1L);
    }
    if (paramBoolean3) {
      g.yhR.n(pQX, 20L, 1L);
    }
    if (paramInt > 0) {
      g.yhR.n(pQX, 36L, paramInt);
    }
    AppMethodBeat.o(174);
  }
  
  public static void cjA()
  {
    AppMethodBeat.i(168);
    ad.i(TAG, "markCpuCropPreviewFailed");
    g.yhR.n(pQX, 9L, 1L);
    AppMethodBeat.o(168);
  }
  
  public static void cjB()
  {
    AppMethodBeat.i(169);
    ad.i(TAG, "markVideoRecordFailed");
    g.yhR.n(pQX, 10L, 1L);
    AppMethodBeat.o(169);
  }
  
  public static void cjC()
  {
    AppMethodBeat.i(170);
    ad.i(TAG, "markVideoRecordNoThumb");
    g.yhR.n(pQX, 11L, 1L);
    AppMethodBeat.o(170);
  }
  
  public static void cjD()
  {
    AppMethodBeat.i(171);
    ad.i(TAG, "markSdkInitFailed");
    g.yhR.n(pQX, 13L, 1L);
    AppMethodBeat.o(171);
  }
  
  public static void cjE()
  {
    AppMethodBeat.i(172);
    ad.i(TAG, "markSdkDrawFailed");
    g.yhR.n(pQX, 14L, 1L);
    AppMethodBeat.o(172);
  }
  
  public static void cjF()
  {
    AppMethodBeat.i(173);
    ad.i(TAG, "markSdkReleaseFailed");
    g.yhR.n(pQX, 15L, 1L);
    AppMethodBeat.o(173);
  }
  
  public static void cjG()
  {
    AppMethodBeat.i(176);
    ad.i(TAG, "markPixelBufferInitFailed");
    g.yhR.n(pQX, 25L, 1L);
    AppMethodBeat.o(176);
  }
  
  public static void cjH()
  {
    AppMethodBeat.i(177);
    ad.i(TAG, "markVideoDecoderInitFailed");
    g.yhR.n(pQX, 26L, 1L);
    AppMethodBeat.o(177);
  }
  
  public static void cjI()
  {
    AppMethodBeat.i(178);
    ad.i(TAG, "markMixFrameDrawFailed");
    g.yhR.n(pQX, 27L, 1L);
    AppMethodBeat.o(178);
  }
  
  public static void cjJ()
  {
    AppMethodBeat.i(179);
    ad.i(TAG, "markUseWxam");
    g.yhR.n(pQX, 30L, 1L);
    AppMethodBeat.o(179);
  }
  
  public static void cjK()
  {
    AppMethodBeat.i(180);
    ad.i(TAG, "markUseGif");
    g.yhR.n(pQX, 31L, 1L);
    AppMethodBeat.o(180);
  }
  
  public static void cjL()
  {
    AppMethodBeat.i(181);
    ad.i(TAG, "markWxamInitFailed");
    g.yhR.n(pQX, 32L, 1L);
    AppMethodBeat.o(181);
  }
  
  public static void cjM()
  {
    AppMethodBeat.i(182);
    ad.i(TAG, "markGifInitFailed");
    g.yhR.n(pQX, 33L, 1L);
    AppMethodBeat.o(182);
  }
  
  public static void cjN()
  {
    AppMethodBeat.i(183);
    ad.i(TAG, "markSdkSegmentInitFailed");
    g.yhR.A(pQX, 45L);
    AppMethodBeat.o(183);
  }
  
  public static void cjO()
  {
    AppMethodBeat.i(184);
    ad.i(TAG, "markSdkSegmentDestroyFailed");
    g.yhR.A(pQX, 47L);
    AppMethodBeat.o(184);
  }
  
  public static void cjP()
  {
    AppMethodBeat.i(185);
    g.yhR.A(pQX, 56L);
    AppMethodBeat.o(185);
  }
  
  public static void cjQ()
  {
    AppMethodBeat.i(186);
    g.yhR.A(pQX, 57L);
    AppMethodBeat.o(186);
  }
  
  public static void cjR()
  {
    AppMethodBeat.i(187);
    ad.i(TAG, "markProxyCallFailed");
    g.yhR.A(pQX, 59L);
    AppMethodBeat.o(187);
  }
  
  public static void cjv()
  {
    AppMethodBeat.i(162);
    ad.i(TAG, "markEmojiCaptureUIOnCreate");
    g.yhR.n(pQX, 0L, 1L);
    AppMethodBeat.o(162);
  }
  
  public static void cjw()
  {
    AppMethodBeat.i(163);
    ad.i(TAG, "markEmojiCaptureUIOnDestroy");
    g.yhR.n(pQX, 1L, 1L);
    AppMethodBeat.o(163);
  }
  
  public static void cjx()
  {
    AppMethodBeat.i(165);
    ad.i(TAG, "markGpuCropPreview");
    g.yhR.n(pQX, 6L, 1L);
    AppMethodBeat.o(165);
  }
  
  public static void cjy()
  {
    AppMethodBeat.i(166);
    ad.i(TAG, "markCpuCropPreview");
    g.yhR.n(pQX, 7L, 1L);
    AppMethodBeat.o(166);
  }
  
  public static void cjz()
  {
    AppMethodBeat.i(167);
    ad.i(TAG, "markGpuCropPreviewFailed");
    g.yhR.n(pQX, 8L, 1L);
    AppMethodBeat.o(167);
  }
  
  public static void q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(175);
    ad.i(TAG, "markEmojiMixSucc, costTime:" + paramLong + ", removeBackground:" + paramBoolean);
    g.yhR.n(pQX, 21L, 1L);
    if (paramBoolean) {
      g.yhR.n(pQX, 23L, 1L);
    }
    while (paramBoolean)
    {
      g.yhR.n(pQX, 42L, paramLong);
      AppMethodBeat.o(175);
      return;
      g.yhR.n(pQX, 22L, 1L);
    }
    g.yhR.n(pQX, 39L, paramLong);
    AppMethodBeat.o(175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.e
 * JD-Core Version:    0.7.0.1
 */