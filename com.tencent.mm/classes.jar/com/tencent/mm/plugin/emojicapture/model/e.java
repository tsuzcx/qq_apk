package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"})
public final class e
{
  private static final String TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
  private static final long pXC = 1012L;
  public static final e pXD;
  
  static
  {
    AppMethodBeat.i(188);
    pXD = new e();
    TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
    pXC = 1012L;
    AppMethodBeat.o(188);
  }
  
  public static void auz()
  {
    AppMethodBeat.i(164);
    ae.i(TAG, "markCameraOpenFailed");
    g.yxI.n(pXC, 3L, 1L);
    AppMethodBeat.o(164);
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(174);
    ae.i(TAG, "markStartEmojiMix, removeBackground:" + paramBoolean1 + ", hasSticker:" + paramBoolean2 + ", speedUp:" + paramBoolean3 + ", videoDuration:" + paramInt);
    g.yxI.n(pXC, 17L, 1L);
    if (paramBoolean1) {
      g.yxI.n(pXC, 18L, 1L);
    }
    if (paramBoolean2) {
      g.yxI.n(pXC, 19L, 1L);
    }
    if (paramBoolean3) {
      g.yxI.n(pXC, 20L, 1L);
    }
    if (paramInt > 0) {
      g.yxI.n(pXC, 36L, paramInt);
    }
    AppMethodBeat.o(174);
  }
  
  public static void ckL()
  {
    AppMethodBeat.i(162);
    ae.i(TAG, "markEmojiCaptureUIOnCreate");
    g.yxI.n(pXC, 0L, 1L);
    AppMethodBeat.o(162);
  }
  
  public static void ckM()
  {
    AppMethodBeat.i(163);
    ae.i(TAG, "markEmojiCaptureUIOnDestroy");
    g.yxI.n(pXC, 1L, 1L);
    AppMethodBeat.o(163);
  }
  
  public static void ckN()
  {
    AppMethodBeat.i(165);
    ae.i(TAG, "markGpuCropPreview");
    g.yxI.n(pXC, 6L, 1L);
    AppMethodBeat.o(165);
  }
  
  public static void ckO()
  {
    AppMethodBeat.i(166);
    ae.i(TAG, "markCpuCropPreview");
    g.yxI.n(pXC, 7L, 1L);
    AppMethodBeat.o(166);
  }
  
  public static void ckP()
  {
    AppMethodBeat.i(167);
    ae.i(TAG, "markGpuCropPreviewFailed");
    g.yxI.n(pXC, 8L, 1L);
    AppMethodBeat.o(167);
  }
  
  public static void ckQ()
  {
    AppMethodBeat.i(168);
    ae.i(TAG, "markCpuCropPreviewFailed");
    g.yxI.n(pXC, 9L, 1L);
    AppMethodBeat.o(168);
  }
  
  public static void ckR()
  {
    AppMethodBeat.i(169);
    ae.i(TAG, "markVideoRecordFailed");
    g.yxI.n(pXC, 10L, 1L);
    AppMethodBeat.o(169);
  }
  
  public static void ckS()
  {
    AppMethodBeat.i(170);
    ae.i(TAG, "markVideoRecordNoThumb");
    g.yxI.n(pXC, 11L, 1L);
    AppMethodBeat.o(170);
  }
  
  public static void ckT()
  {
    AppMethodBeat.i(171);
    ae.i(TAG, "markSdkInitFailed");
    g.yxI.n(pXC, 13L, 1L);
    AppMethodBeat.o(171);
  }
  
  public static void ckU()
  {
    AppMethodBeat.i(172);
    ae.i(TAG, "markSdkDrawFailed");
    g.yxI.n(pXC, 14L, 1L);
    AppMethodBeat.o(172);
  }
  
  public static void ckV()
  {
    AppMethodBeat.i(173);
    ae.i(TAG, "markSdkReleaseFailed");
    g.yxI.n(pXC, 15L, 1L);
    AppMethodBeat.o(173);
  }
  
  public static void ckW()
  {
    AppMethodBeat.i(176);
    ae.i(TAG, "markPixelBufferInitFailed");
    g.yxI.n(pXC, 25L, 1L);
    AppMethodBeat.o(176);
  }
  
  public static void ckX()
  {
    AppMethodBeat.i(177);
    ae.i(TAG, "markVideoDecoderInitFailed");
    g.yxI.n(pXC, 26L, 1L);
    AppMethodBeat.o(177);
  }
  
  public static void ckY()
  {
    AppMethodBeat.i(178);
    ae.i(TAG, "markMixFrameDrawFailed");
    g.yxI.n(pXC, 27L, 1L);
    AppMethodBeat.o(178);
  }
  
  public static void ckZ()
  {
    AppMethodBeat.i(179);
    ae.i(TAG, "markUseWxam");
    g.yxI.n(pXC, 30L, 1L);
    AppMethodBeat.o(179);
  }
  
  public static void cla()
  {
    AppMethodBeat.i(180);
    ae.i(TAG, "markUseGif");
    g.yxI.n(pXC, 31L, 1L);
    AppMethodBeat.o(180);
  }
  
  public static void clb()
  {
    AppMethodBeat.i(181);
    ae.i(TAG, "markWxamInitFailed");
    g.yxI.n(pXC, 32L, 1L);
    AppMethodBeat.o(181);
  }
  
  public static void clc()
  {
    AppMethodBeat.i(182);
    ae.i(TAG, "markGifInitFailed");
    g.yxI.n(pXC, 33L, 1L);
    AppMethodBeat.o(182);
  }
  
  public static void cld()
  {
    AppMethodBeat.i(183);
    ae.i(TAG, "markSdkSegmentInitFailed");
    g.yxI.A(pXC, 45L);
    AppMethodBeat.o(183);
  }
  
  public static void cle()
  {
    AppMethodBeat.i(184);
    ae.i(TAG, "markSdkSegmentDestroyFailed");
    g.yxI.A(pXC, 47L);
    AppMethodBeat.o(184);
  }
  
  public static void clf()
  {
    AppMethodBeat.i(185);
    g.yxI.A(pXC, 56L);
    AppMethodBeat.o(185);
  }
  
  public static void clg()
  {
    AppMethodBeat.i(186);
    g.yxI.A(pXC, 57L);
    AppMethodBeat.o(186);
  }
  
  public static void clh()
  {
    AppMethodBeat.i(187);
    ae.i(TAG, "markProxyCallFailed");
    g.yxI.A(pXC, 59L);
    AppMethodBeat.o(187);
  }
  
  public static void q(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(175);
    ae.i(TAG, "markEmojiMixSucc, costTime:" + paramLong + ", removeBackground:" + paramBoolean);
    g.yxI.n(pXC, 21L, 1L);
    if (paramBoolean) {
      g.yxI.n(pXC, 23L, 1L);
    }
    while (paramBoolean)
    {
      g.yxI.n(pXC, 42L, paramLong);
      AppMethodBeat.o(175);
      return;
      g.yxI.n(pXC, 22L, 1L);
    }
    g.yxI.n(pXC, 39L, paramLong);
    AppMethodBeat.o(175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.e
 * JD-Core Version:    0.7.0.1
 */