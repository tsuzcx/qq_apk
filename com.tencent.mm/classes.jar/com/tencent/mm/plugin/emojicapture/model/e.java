package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
  private static final long pnx = 1012L;
  public static final e pny;
  
  static
  {
    AppMethodBeat.i(188);
    pny = new e();
    TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
    pnx = 1012L;
    AppMethodBeat.o(188);
  }
  
  public static void arx()
  {
    AppMethodBeat.i(164);
    ac.i(TAG, "markCameraOpenFailed");
    h.wUl.n(pnx, 3L, 1L);
    AppMethodBeat.o(164);
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(174);
    ac.i(TAG, "markStartEmojiMix, removeBackground:" + paramBoolean1 + ", hasSticker:" + paramBoolean2 + ", speedUp:" + paramBoolean3 + ", videoDuration:" + paramInt);
    h.wUl.n(pnx, 17L, 1L);
    if (paramBoolean1) {
      h.wUl.n(pnx, 18L, 1L);
    }
    if (paramBoolean2) {
      h.wUl.n(pnx, 19L, 1L);
    }
    if (paramBoolean3) {
      h.wUl.n(pnx, 20L, 1L);
    }
    if (paramInt > 0) {
      h.wUl.n(pnx, 36L, paramInt);
    }
    AppMethodBeat.o(174);
  }
  
  public static void ceS()
  {
    AppMethodBeat.i(162);
    ac.i(TAG, "markEmojiCaptureUIOnCreate");
    h.wUl.n(pnx, 0L, 1L);
    AppMethodBeat.o(162);
  }
  
  public static void ceT()
  {
    AppMethodBeat.i(163);
    ac.i(TAG, "markEmojiCaptureUIOnDestroy");
    h.wUl.n(pnx, 1L, 1L);
    AppMethodBeat.o(163);
  }
  
  public static void ceU()
  {
    AppMethodBeat.i(165);
    ac.i(TAG, "markGpuCropPreview");
    h.wUl.n(pnx, 6L, 1L);
    AppMethodBeat.o(165);
  }
  
  public static void ceV()
  {
    AppMethodBeat.i(166);
    ac.i(TAG, "markCpuCropPreview");
    h.wUl.n(pnx, 7L, 1L);
    AppMethodBeat.o(166);
  }
  
  public static void ceW()
  {
    AppMethodBeat.i(167);
    ac.i(TAG, "markGpuCropPreviewFailed");
    h.wUl.n(pnx, 8L, 1L);
    AppMethodBeat.o(167);
  }
  
  public static void ceX()
  {
    AppMethodBeat.i(168);
    ac.i(TAG, "markCpuCropPreviewFailed");
    h.wUl.n(pnx, 9L, 1L);
    AppMethodBeat.o(168);
  }
  
  public static void ceY()
  {
    AppMethodBeat.i(169);
    ac.i(TAG, "markVideoRecordFailed");
    h.wUl.n(pnx, 10L, 1L);
    AppMethodBeat.o(169);
  }
  
  public static void ceZ()
  {
    AppMethodBeat.i(170);
    ac.i(TAG, "markVideoRecordNoThumb");
    h.wUl.n(pnx, 11L, 1L);
    AppMethodBeat.o(170);
  }
  
  public static void cfa()
  {
    AppMethodBeat.i(171);
    ac.i(TAG, "markSdkInitFailed");
    h.wUl.n(pnx, 13L, 1L);
    AppMethodBeat.o(171);
  }
  
  public static void cfb()
  {
    AppMethodBeat.i(172);
    ac.i(TAG, "markSdkDrawFailed");
    h.wUl.n(pnx, 14L, 1L);
    AppMethodBeat.o(172);
  }
  
  public static void cfc()
  {
    AppMethodBeat.i(173);
    ac.i(TAG, "markSdkReleaseFailed");
    h.wUl.n(pnx, 15L, 1L);
    AppMethodBeat.o(173);
  }
  
  public static void cfd()
  {
    AppMethodBeat.i(176);
    ac.i(TAG, "markPixelBufferInitFailed");
    h.wUl.n(pnx, 25L, 1L);
    AppMethodBeat.o(176);
  }
  
  public static void cfe()
  {
    AppMethodBeat.i(177);
    ac.i(TAG, "markVideoDecoderInitFailed");
    h.wUl.n(pnx, 26L, 1L);
    AppMethodBeat.o(177);
  }
  
  public static void cff()
  {
    AppMethodBeat.i(178);
    ac.i(TAG, "markMixFrameDrawFailed");
    h.wUl.n(pnx, 27L, 1L);
    AppMethodBeat.o(178);
  }
  
  public static void cfg()
  {
    AppMethodBeat.i(179);
    ac.i(TAG, "markUseWxam");
    h.wUl.n(pnx, 30L, 1L);
    AppMethodBeat.o(179);
  }
  
  public static void cfh()
  {
    AppMethodBeat.i(180);
    ac.i(TAG, "markUseGif");
    h.wUl.n(pnx, 31L, 1L);
    AppMethodBeat.o(180);
  }
  
  public static void cfi()
  {
    AppMethodBeat.i(181);
    ac.i(TAG, "markWxamInitFailed");
    h.wUl.n(pnx, 32L, 1L);
    AppMethodBeat.o(181);
  }
  
  public static void cfj()
  {
    AppMethodBeat.i(182);
    ac.i(TAG, "markGifInitFailed");
    h.wUl.n(pnx, 33L, 1L);
    AppMethodBeat.o(182);
  }
  
  public static void cfk()
  {
    AppMethodBeat.i(183);
    ac.i(TAG, "markSdkSegmentInitFailed");
    h.wUl.A(pnx, 45L);
    AppMethodBeat.o(183);
  }
  
  public static void cfl()
  {
    AppMethodBeat.i(184);
    ac.i(TAG, "markSdkSegmentDestroyFailed");
    h.wUl.A(pnx, 47L);
    AppMethodBeat.o(184);
  }
  
  public static void cfm()
  {
    AppMethodBeat.i(185);
    h.wUl.A(pnx, 56L);
    AppMethodBeat.o(185);
  }
  
  public static void cfn()
  {
    AppMethodBeat.i(186);
    h.wUl.A(pnx, 57L);
    AppMethodBeat.o(186);
  }
  
  public static void cfo()
  {
    AppMethodBeat.i(187);
    ac.i(TAG, "markProxyCallFailed");
    h.wUl.A(pnx, 59L);
    AppMethodBeat.o(187);
  }
  
  public static void q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(175);
    ac.i(TAG, "markEmojiMixSucc, costTime:" + paramLong + ", removeBackground:" + paramBoolean);
    h.wUl.n(pnx, 21L, 1L);
    if (paramBoolean) {
      h.wUl.n(pnx, 23L, 1L);
    }
    while (paramBoolean)
    {
      h.wUl.n(pnx, 42L, paramLong);
      AppMethodBeat.o(175);
      return;
      h.wUl.n(pnx, 22L, 1L);
    }
    h.wUl.n(pnx, 39L, paramLong);
    AppMethodBeat.o(175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.e
 * JD-Core Version:    0.7.0.1
 */