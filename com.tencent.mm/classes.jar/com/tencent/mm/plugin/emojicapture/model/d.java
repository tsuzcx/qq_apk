package com.tencent.mm.plugin.emojicapture.model;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class d
{
  private static final String TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
  private static final long ltw = 1012L;
  public static final d ltx;
  
  static
  {
    AppMethodBeat.i(2614);
    ltx = new d();
    TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
    ltw = 1012L;
    AppMethodBeat.o(2614);
  }
  
  public static void Vs()
  {
    AppMethodBeat.i(2584);
    ab.i(TAG, "markCameraOpenFailed");
    h.qsU.j(ltw, 3L, 1L);
    AppMethodBeat.o(2584);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(2594);
    ab.i(TAG, "markStartEmojiMix, removeBackground:" + paramBoolean1 + ", hasSticker:" + paramBoolean2 + ", speedUp:" + paramBoolean3 + ", videoDuration:" + paramInt);
    h.qsU.j(ltw, 17L, 1L);
    if (paramBoolean1) {
      h.qsU.j(ltw, 18L, 1L);
    }
    if (paramBoolean2) {
      h.qsU.j(ltw, 19L, 1L);
    }
    if (paramBoolean3) {
      h.qsU.j(ltw, 20L, 1L);
    }
    if (paramInt > 0) {
      h.qsU.j(ltw, 36L, paramInt);
    }
    AppMethodBeat.o(2594);
  }
  
  public static void bnS()
  {
    AppMethodBeat.i(2582);
    ab.i(TAG, "markEmojiCaptureUIOnCreate");
    h.qsU.j(ltw, 0L, 1L);
    AppMethodBeat.o(2582);
  }
  
  public static void bnT()
  {
    AppMethodBeat.i(2583);
    ab.i(TAG, "markEmojiCaptureUIOnDestroy");
    h.qsU.j(ltw, 1L, 1L);
    AppMethodBeat.o(2583);
  }
  
  public static void bnU()
  {
    AppMethodBeat.i(2585);
    ab.i(TAG, "markGpuCropPreview");
    h.qsU.j(ltw, 6L, 1L);
    AppMethodBeat.o(2585);
  }
  
  public static void bnV()
  {
    AppMethodBeat.i(2586);
    ab.i(TAG, "markCpuCropPreview");
    h.qsU.j(ltw, 7L, 1L);
    AppMethodBeat.o(2586);
  }
  
  public static void bnW()
  {
    AppMethodBeat.i(2587);
    ab.i(TAG, "markGpuCropPreviewFailed");
    h.qsU.j(ltw, 8L, 1L);
    AppMethodBeat.o(2587);
  }
  
  public static void bnX()
  {
    AppMethodBeat.i(2588);
    ab.i(TAG, "markCpuCropPreviewFailed");
    h.qsU.j(ltw, 9L, 1L);
    AppMethodBeat.o(2588);
  }
  
  public static void bnY()
  {
    AppMethodBeat.i(2589);
    ab.i(TAG, "markVideoRecordFailed");
    h.qsU.j(ltw, 10L, 1L);
    AppMethodBeat.o(2589);
  }
  
  public static void bnZ()
  {
    AppMethodBeat.i(2590);
    ab.i(TAG, "markVideoRecordNoThumb");
    h.qsU.j(ltw, 11L, 1L);
    AppMethodBeat.o(2590);
  }
  
  public static void boa()
  {
    AppMethodBeat.i(2591);
    ab.i(TAG, "markSdkInitFailed");
    h.qsU.j(ltw, 13L, 1L);
    AppMethodBeat.o(2591);
  }
  
  public static void bob()
  {
    AppMethodBeat.i(2592);
    ab.i(TAG, "markSdkDrawFailed");
    h.qsU.j(ltw, 14L, 1L);
    AppMethodBeat.o(2592);
  }
  
  public static void boc()
  {
    AppMethodBeat.i(2593);
    ab.i(TAG, "markSdkReleaseFailed");
    h.qsU.j(ltw, 15L, 1L);
    AppMethodBeat.o(2593);
  }
  
  public static void bod()
  {
    AppMethodBeat.i(2596);
    ab.i(TAG, "markPixelBufferInitFailed");
    h.qsU.j(ltw, 25L, 1L);
    AppMethodBeat.o(2596);
  }
  
  public static void boe()
  {
    AppMethodBeat.i(2597);
    ab.i(TAG, "markVideoDecoderInitFailed");
    h.qsU.j(ltw, 26L, 1L);
    AppMethodBeat.o(2597);
  }
  
  public static void bof()
  {
    AppMethodBeat.i(2598);
    ab.i(TAG, "markMixFrameDrawFailed");
    h.qsU.j(ltw, 27L, 1L);
    AppMethodBeat.o(2598);
  }
  
  public static void bog()
  {
    AppMethodBeat.i(2599);
    ab.i(TAG, "markUseWxam");
    h.qsU.j(ltw, 30L, 1L);
    AppMethodBeat.o(2599);
  }
  
  public static void boh()
  {
    AppMethodBeat.i(2600);
    ab.i(TAG, "markUseGif");
    h.qsU.j(ltw, 31L, 1L);
    AppMethodBeat.o(2600);
  }
  
  public static void boi()
  {
    AppMethodBeat.i(2601);
    ab.i(TAG, "markWxamInitFailed");
    h.qsU.j(ltw, 32L, 1L);
    AppMethodBeat.o(2601);
  }
  
  public static void boj()
  {
    AppMethodBeat.i(2602);
    ab.i(TAG, "markGifInitFailed");
    h.qsU.j(ltw, 33L, 1L);
    AppMethodBeat.o(2602);
  }
  
  public static void bok()
  {
    AppMethodBeat.i(2603);
    ab.i(TAG, "markSdkSegmentInitFailed");
    h.qsU.B(ltw, 45L);
    AppMethodBeat.o(2603);
  }
  
  public static void bol()
  {
    AppMethodBeat.i(2604);
    ab.i(TAG, "markSdkSegmentDetectFailed");
    h.qsU.B(ltw, 46L);
    AppMethodBeat.o(2604);
  }
  
  public static void bom()
  {
    AppMethodBeat.i(2605);
    ab.i(TAG, "markSdkSegmentDestroyFailed");
    h.qsU.B(ltw, 47L);
    AppMethodBeat.o(2605);
  }
  
  public static void bon()
  {
    AppMethodBeat.i(2606);
    ab.i(TAG, "markSdkSoFailed");
    h.qsU.B(ltw, 54L);
    AppMethodBeat.o(2606);
  }
  
  public static void boo()
  {
    AppMethodBeat.i(2607);
    h.qsU.B(ltw, 56L);
    AppMethodBeat.o(2607);
  }
  
  public static void bop()
  {
    AppMethodBeat.i(2608);
    h.qsU.B(ltw, 57L);
    AppMethodBeat.o(2608);
  }
  
  public static void boq()
  {
    AppMethodBeat.i(2609);
    ab.i(TAG, "markProxyCallFailed");
    h.qsU.B(ltw, 59L);
    AppMethodBeat.o(2609);
  }
  
  public static void bor()
  {
    AppMethodBeat.i(2610);
    ab.i(TAG, "markSegmentSoFailed");
    h.qsU.B(ltw, 63L);
    AppMethodBeat.o(2610);
  }
  
  public static void bos()
  {
    AppMethodBeat.i(2611);
    ab.i(TAG, "markSegmentCpuSoFailed");
    h.qsU.B(ltw, 64L);
    AppMethodBeat.o(2611);
  }
  
  public static void bot()
  {
    AppMethodBeat.i(2612);
    ab.i(TAG, "markSegmentNotManualInit");
    h.qsU.B(ltw, 66L);
    AppMethodBeat.o(2612);
  }
  
  public static void bou()
  {
    AppMethodBeat.i(2613);
    ab.i(TAG, "markSegmentSoInitFailed");
    h.qsU.B(ltw, 67L);
    AppMethodBeat.o(2613);
  }
  
  public static void q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(2595);
    ab.i(TAG, "markEmojiMixSucc, costTime:" + paramLong + ", removeBackground:" + paramBoolean);
    h.qsU.j(ltw, 21L, 1L);
    if (paramBoolean) {
      h.qsU.j(ltw, 23L, 1L);
    }
    while (paramBoolean)
    {
      h.qsU.j(ltw, 42L, paramLong);
      AppMethodBeat.o(2595);
      return;
      h.qsU.j(ltw, 22L, 1L);
    }
    h.qsU.j(ltw, 39L, paramLong);
    AppMethodBeat.o(2595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.d
 * JD-Core Version:    0.7.0.1
 */