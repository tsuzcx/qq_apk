package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
  private static final long rJY = 1012L;
  public static final e uUh;
  
  static
  {
    AppMethodBeat.i(188);
    uUh = new e();
    TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
    rJY = 1012L;
    AppMethodBeat.o(188);
  }
  
  public static void aVQ()
  {
    AppMethodBeat.i(164);
    Log.i(TAG, "markCameraOpenFailed");
    h.IzE.p(rJY, 3L, 1L);
    AppMethodBeat.o(164);
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(174);
    Log.i(TAG, "markStartEmojiMix, removeBackground:" + paramBoolean1 + ", hasSticker:" + paramBoolean2 + ", speedUp:" + paramBoolean3 + ", videoDuration:" + paramInt);
    h.IzE.p(rJY, 17L, 1L);
    if (paramBoolean1) {
      h.IzE.p(rJY, 18L, 1L);
    }
    if (paramBoolean2) {
      h.IzE.p(rJY, 19L, 1L);
    }
    if (paramBoolean3) {
      h.IzE.p(rJY, 20L, 1L);
    }
    if (paramInt > 0) {
      h.IzE.p(rJY, 36L, paramInt);
    }
    AppMethodBeat.o(174);
  }
  
  public static void cXA()
  {
    AppMethodBeat.i(167);
    Log.i(TAG, "markGpuCropPreviewFailed");
    h.IzE.p(rJY, 8L, 1L);
    AppMethodBeat.o(167);
  }
  
  public static void cXB()
  {
    AppMethodBeat.i(168);
    Log.i(TAG, "markCpuCropPreviewFailed");
    h.IzE.p(rJY, 9L, 1L);
    AppMethodBeat.o(168);
  }
  
  public static void cXC()
  {
    AppMethodBeat.i(169);
    Log.i(TAG, "markVideoRecordFailed");
    h.IzE.p(rJY, 10L, 1L);
    AppMethodBeat.o(169);
  }
  
  public static void cXD()
  {
    AppMethodBeat.i(170);
    Log.i(TAG, "markVideoRecordNoThumb");
    h.IzE.p(rJY, 11L, 1L);
    AppMethodBeat.o(170);
  }
  
  public static void cXE()
  {
    AppMethodBeat.i(171);
    Log.i(TAG, "markSdkInitFailed");
    h.IzE.p(rJY, 13L, 1L);
    AppMethodBeat.o(171);
  }
  
  public static void cXF()
  {
    AppMethodBeat.i(172);
    Log.i(TAG, "markSdkDrawFailed");
    h.IzE.p(rJY, 14L, 1L);
    AppMethodBeat.o(172);
  }
  
  public static void cXG()
  {
    AppMethodBeat.i(173);
    Log.i(TAG, "markSdkReleaseFailed");
    h.IzE.p(rJY, 15L, 1L);
    AppMethodBeat.o(173);
  }
  
  public static void cXH()
  {
    AppMethodBeat.i(176);
    Log.i(TAG, "markPixelBufferInitFailed");
    h.IzE.p(rJY, 25L, 1L);
    AppMethodBeat.o(176);
  }
  
  public static void cXI()
  {
    AppMethodBeat.i(177);
    Log.i(TAG, "markVideoDecoderInitFailed");
    h.IzE.p(rJY, 26L, 1L);
    AppMethodBeat.o(177);
  }
  
  public static void cXJ()
  {
    AppMethodBeat.i(178);
    Log.i(TAG, "markMixFrameDrawFailed");
    h.IzE.p(rJY, 27L, 1L);
    AppMethodBeat.o(178);
  }
  
  public static void cXK()
  {
    AppMethodBeat.i(179);
    Log.i(TAG, "markUseWxam");
    h.IzE.p(rJY, 30L, 1L);
    AppMethodBeat.o(179);
  }
  
  public static void cXL()
  {
    AppMethodBeat.i(180);
    Log.i(TAG, "markUseGif");
    h.IzE.p(rJY, 31L, 1L);
    AppMethodBeat.o(180);
  }
  
  public static void cXM()
  {
    AppMethodBeat.i(181);
    Log.i(TAG, "markWxamInitFailed");
    h.IzE.p(rJY, 32L, 1L);
    AppMethodBeat.o(181);
  }
  
  public static void cXN()
  {
    AppMethodBeat.i(182);
    Log.i(TAG, "markGifInitFailed");
    h.IzE.p(rJY, 33L, 1L);
    AppMethodBeat.o(182);
  }
  
  public static void cXO()
  {
    AppMethodBeat.i(183);
    Log.i(TAG, "markSdkSegmentInitFailed");
    h.IzE.F(rJY, 45L);
    AppMethodBeat.o(183);
  }
  
  public static void cXP()
  {
    AppMethodBeat.i(184);
    Log.i(TAG, "markSdkSegmentDestroyFailed");
    h.IzE.F(rJY, 47L);
    AppMethodBeat.o(184);
  }
  
  public static void cXQ()
  {
    AppMethodBeat.i(185);
    h.IzE.F(rJY, 56L);
    AppMethodBeat.o(185);
  }
  
  public static void cXR()
  {
    AppMethodBeat.i(186);
    h.IzE.F(rJY, 57L);
    AppMethodBeat.o(186);
  }
  
  public static void cXS()
  {
    AppMethodBeat.i(187);
    Log.i(TAG, "markProxyCallFailed");
    h.IzE.F(rJY, 59L);
    AppMethodBeat.o(187);
  }
  
  public static void cXw()
  {
    AppMethodBeat.i(162);
    Log.i(TAG, "markEmojiCaptureUIOnCreate");
    h.IzE.p(rJY, 0L, 1L);
    AppMethodBeat.o(162);
  }
  
  public static void cXx()
  {
    AppMethodBeat.i(163);
    Log.i(TAG, "markEmojiCaptureUIOnDestroy");
    h.IzE.p(rJY, 1L, 1L);
    AppMethodBeat.o(163);
  }
  
  public static void cXy()
  {
    AppMethodBeat.i(165);
    Log.i(TAG, "markGpuCropPreview");
    h.IzE.p(rJY, 6L, 1L);
    AppMethodBeat.o(165);
  }
  
  public static void cXz()
  {
    AppMethodBeat.i(166);
    Log.i(TAG, "markCpuCropPreview");
    h.IzE.p(rJY, 7L, 1L);
    AppMethodBeat.o(166);
  }
  
  public static void q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(175);
    Log.i(TAG, "markEmojiMixSucc, costTime:" + paramLong + ", removeBackground:" + paramBoolean);
    h.IzE.p(rJY, 21L, 1L);
    if (paramBoolean) {
      h.IzE.p(rJY, 23L, 1L);
    }
    while (paramBoolean)
    {
      h.IzE.p(rJY, 42L, paramLong);
      AppMethodBeat.o(175);
      return;
      h.IzE.p(rJY, 22L, 1L);
    }
    h.IzE.p(rJY, 39L, paramLong);
    AppMethodBeat.o(175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.e
 * JD-Core Version:    0.7.0.1
 */