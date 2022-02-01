package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
  private static final long oIi = 1012L;
  public static final e roB;
  
  static
  {
    AppMethodBeat.i(188);
    roB = new e();
    TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
    oIi = 1012L;
    AppMethodBeat.o(188);
  }
  
  public static void aNm()
  {
    AppMethodBeat.i(164);
    Log.i(TAG, "markCameraOpenFailed");
    h.CyF.n(oIi, 3L, 1L);
    AppMethodBeat.o(164);
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(174);
    Log.i(TAG, "markStartEmojiMix, removeBackground:" + paramBoolean1 + ", hasSticker:" + paramBoolean2 + ", speedUp:" + paramBoolean3 + ", videoDuration:" + paramInt);
    h.CyF.n(oIi, 17L, 1L);
    if (paramBoolean1) {
      h.CyF.n(oIi, 18L, 1L);
    }
    if (paramBoolean2) {
      h.CyF.n(oIi, 19L, 1L);
    }
    if (paramBoolean3) {
      h.CyF.n(oIi, 20L, 1L);
    }
    if (paramInt > 0) {
      h.CyF.n(oIi, 36L, paramInt);
    }
    AppMethodBeat.o(174);
  }
  
  public static void cIN()
  {
    AppMethodBeat.i(162);
    Log.i(TAG, "markEmojiCaptureUIOnCreate");
    h.CyF.n(oIi, 0L, 1L);
    AppMethodBeat.o(162);
  }
  
  public static void cIO()
  {
    AppMethodBeat.i(163);
    Log.i(TAG, "markEmojiCaptureUIOnDestroy");
    h.CyF.n(oIi, 1L, 1L);
    AppMethodBeat.o(163);
  }
  
  public static void cIP()
  {
    AppMethodBeat.i(165);
    Log.i(TAG, "markGpuCropPreview");
    h.CyF.n(oIi, 6L, 1L);
    AppMethodBeat.o(165);
  }
  
  public static void cIQ()
  {
    AppMethodBeat.i(166);
    Log.i(TAG, "markCpuCropPreview");
    h.CyF.n(oIi, 7L, 1L);
    AppMethodBeat.o(166);
  }
  
  public static void cIR()
  {
    AppMethodBeat.i(167);
    Log.i(TAG, "markGpuCropPreviewFailed");
    h.CyF.n(oIi, 8L, 1L);
    AppMethodBeat.o(167);
  }
  
  public static void cIS()
  {
    AppMethodBeat.i(168);
    Log.i(TAG, "markCpuCropPreviewFailed");
    h.CyF.n(oIi, 9L, 1L);
    AppMethodBeat.o(168);
  }
  
  public static void cIT()
  {
    AppMethodBeat.i(169);
    Log.i(TAG, "markVideoRecordFailed");
    h.CyF.n(oIi, 10L, 1L);
    AppMethodBeat.o(169);
  }
  
  public static void cIU()
  {
    AppMethodBeat.i(170);
    Log.i(TAG, "markVideoRecordNoThumb");
    h.CyF.n(oIi, 11L, 1L);
    AppMethodBeat.o(170);
  }
  
  public static void cIV()
  {
    AppMethodBeat.i(171);
    Log.i(TAG, "markSdkInitFailed");
    h.CyF.n(oIi, 13L, 1L);
    AppMethodBeat.o(171);
  }
  
  public static void cIW()
  {
    AppMethodBeat.i(172);
    Log.i(TAG, "markSdkDrawFailed");
    h.CyF.n(oIi, 14L, 1L);
    AppMethodBeat.o(172);
  }
  
  public static void cIX()
  {
    AppMethodBeat.i(173);
    Log.i(TAG, "markSdkReleaseFailed");
    h.CyF.n(oIi, 15L, 1L);
    AppMethodBeat.o(173);
  }
  
  public static void cIY()
  {
    AppMethodBeat.i(176);
    Log.i(TAG, "markPixelBufferInitFailed");
    h.CyF.n(oIi, 25L, 1L);
    AppMethodBeat.o(176);
  }
  
  public static void cIZ()
  {
    AppMethodBeat.i(177);
    Log.i(TAG, "markVideoDecoderInitFailed");
    h.CyF.n(oIi, 26L, 1L);
    AppMethodBeat.o(177);
  }
  
  public static void cJa()
  {
    AppMethodBeat.i(178);
    Log.i(TAG, "markMixFrameDrawFailed");
    h.CyF.n(oIi, 27L, 1L);
    AppMethodBeat.o(178);
  }
  
  public static void cJb()
  {
    AppMethodBeat.i(179);
    Log.i(TAG, "markUseWxam");
    h.CyF.n(oIi, 30L, 1L);
    AppMethodBeat.o(179);
  }
  
  public static void cJc()
  {
    AppMethodBeat.i(180);
    Log.i(TAG, "markUseGif");
    h.CyF.n(oIi, 31L, 1L);
    AppMethodBeat.o(180);
  }
  
  public static void cJd()
  {
    AppMethodBeat.i(181);
    Log.i(TAG, "markWxamInitFailed");
    h.CyF.n(oIi, 32L, 1L);
    AppMethodBeat.o(181);
  }
  
  public static void cJe()
  {
    AppMethodBeat.i(182);
    Log.i(TAG, "markGifInitFailed");
    h.CyF.n(oIi, 33L, 1L);
    AppMethodBeat.o(182);
  }
  
  public static void cJf()
  {
    AppMethodBeat.i(183);
    Log.i(TAG, "markSdkSegmentInitFailed");
    h.CyF.F(oIi, 45L);
    AppMethodBeat.o(183);
  }
  
  public static void cJg()
  {
    AppMethodBeat.i(184);
    Log.i(TAG, "markSdkSegmentDestroyFailed");
    h.CyF.F(oIi, 47L);
    AppMethodBeat.o(184);
  }
  
  public static void cJh()
  {
    AppMethodBeat.i(185);
    h.CyF.F(oIi, 56L);
    AppMethodBeat.o(185);
  }
  
  public static void cJi()
  {
    AppMethodBeat.i(186);
    h.CyF.F(oIi, 57L);
    AppMethodBeat.o(186);
  }
  
  public static void cJj()
  {
    AppMethodBeat.i(187);
    Log.i(TAG, "markProxyCallFailed");
    h.CyF.F(oIi, 59L);
    AppMethodBeat.o(187);
  }
  
  public static void q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(175);
    Log.i(TAG, "markEmojiMixSucc, costTime:" + paramLong + ", removeBackground:" + paramBoolean);
    h.CyF.n(oIi, 21L, 1L);
    if (paramBoolean) {
      h.CyF.n(oIi, 23L, 1L);
    }
    while (paramBoolean)
    {
      h.CyF.n(oIi, 42L, paramLong);
      AppMethodBeat.o(175);
      return;
      h.CyF.n(oIi, 22L, 1L);
    }
    h.CyF.n(oIi, 39L, paramLong);
    AppMethodBeat.o(175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.e
 * JD-Core Version:    0.7.0.1
 */