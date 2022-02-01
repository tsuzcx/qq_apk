package com.tencent.mm.plugin.emojicapture.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureDetailIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markCameraOpenFailed", "", "markCpuCropPreview", "markCpuCropPreviewFailed", "markEmojiCaptureUIOnCreate", "markEmojiCaptureUIOnDestroy", "markEmojiMixSucc", "costTime", "removeBackground", "", "markFestivalEnable", "markGifInitFailed", "markGpuCropPreview", "markGpuCropPreviewFailed", "markHighPerformance", "markLowPerformance", "markMixFrameDrawFailed", "markPixelBufferInitFailed", "markProxyCallFailed", "markRecorderInitFailed", "markSdkDrawFailed", "markSdkGestureSoFailed", "markSdkInitFailed", "markSdkReleaseFailed", "markSdkSegmentDestroyFailed", "markSdkSegmentDetectFailed", "markSdkSegmentInitFailed", "markSdkSoFailed", "markSegmentCpuSoFailed", "markSegmentGpuSoFailed", "markSegmentNotAutoInit", "markSegmentNotManualInit", "markSegmentSoInitFailed", "markStartEmojiMix", "hasSticker", "speedUp", "videoDuration", "", "markUseGif", "markUseWxam", "markVideoDecoderInitFailed", "markVideoRecordFailed", "markVideoRecordNoThumb", "markWxamInitFailed", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final long ID;
  private static final String TAG;
  public static final e ygT;
  
  static
  {
    AppMethodBeat.i(188);
    ygT = new e();
    TAG = "MicroMsg.EmojiCaptureDetailIDKeyStat";
    ID = 1012L;
    AppMethodBeat.o(188);
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(174);
    Log.i(TAG, "markStartEmojiMix, removeBackground:" + paramBoolean1 + ", hasSticker:" + paramBoolean2 + ", speedUp:" + paramBoolean3 + ", videoDuration:" + paramInt);
    h.OAn.p(ID, 17L, 1L);
    if (paramBoolean1) {
      h.OAn.p(ID, 18L, 1L);
    }
    if (paramBoolean2) {
      h.OAn.p(ID, 19L, 1L);
    }
    if (paramBoolean3) {
      h.OAn.p(ID, 20L, 1L);
    }
    if (paramInt > 0) {
      h.OAn.p(ID, 36L, paramInt);
    }
    AppMethodBeat.o(174);
  }
  
  public static void bqx()
  {
    AppMethodBeat.i(164);
    Log.i(TAG, "markCameraOpenFailed");
    h.OAn.p(ID, 3L, 1L);
    AppMethodBeat.o(164);
  }
  
  public static void dDM()
  {
    AppMethodBeat.i(162);
    Log.i(TAG, "markEmojiCaptureUIOnCreate");
    h.OAn.p(ID, 0L, 1L);
    AppMethodBeat.o(162);
  }
  
  public static void dDN()
  {
    AppMethodBeat.i(163);
    Log.i(TAG, "markEmojiCaptureUIOnDestroy");
    h.OAn.p(ID, 1L, 1L);
    AppMethodBeat.o(163);
  }
  
  public static void dDO()
  {
    AppMethodBeat.i(165);
    Log.i(TAG, "markGpuCropPreview");
    h.OAn.p(ID, 6L, 1L);
    AppMethodBeat.o(165);
  }
  
  public static void dDP()
  {
    AppMethodBeat.i(166);
    Log.i(TAG, "markCpuCropPreview");
    h.OAn.p(ID, 7L, 1L);
    AppMethodBeat.o(166);
  }
  
  public static void dDQ()
  {
    AppMethodBeat.i(167);
    Log.i(TAG, "markGpuCropPreviewFailed");
    h.OAn.p(ID, 8L, 1L);
    AppMethodBeat.o(167);
  }
  
  public static void dDR()
  {
    AppMethodBeat.i(168);
    Log.i(TAG, "markCpuCropPreviewFailed");
    h.OAn.p(ID, 9L, 1L);
    AppMethodBeat.o(168);
  }
  
  public static void dDS()
  {
    AppMethodBeat.i(169);
    Log.i(TAG, "markVideoRecordFailed");
    h.OAn.p(ID, 10L, 1L);
    AppMethodBeat.o(169);
  }
  
  public static void dDT()
  {
    AppMethodBeat.i(170);
    Log.i(TAG, "markVideoRecordNoThumb");
    h.OAn.p(ID, 11L, 1L);
    AppMethodBeat.o(170);
  }
  
  public static void dDU()
  {
    AppMethodBeat.i(171);
    Log.i(TAG, "markSdkInitFailed");
    h.OAn.p(ID, 13L, 1L);
    AppMethodBeat.o(171);
  }
  
  public static void dDV()
  {
    AppMethodBeat.i(172);
    Log.i(TAG, "markSdkDrawFailed");
    h.OAn.p(ID, 14L, 1L);
    AppMethodBeat.o(172);
  }
  
  public static void dDW()
  {
    AppMethodBeat.i(173);
    Log.i(TAG, "markSdkReleaseFailed");
    h.OAn.p(ID, 15L, 1L);
    AppMethodBeat.o(173);
  }
  
  public static void dDX()
  {
    AppMethodBeat.i(176);
    Log.i(TAG, "markPixelBufferInitFailed");
    h.OAn.p(ID, 25L, 1L);
    AppMethodBeat.o(176);
  }
  
  public static void dDY()
  {
    AppMethodBeat.i(177);
    Log.i(TAG, "markVideoDecoderInitFailed");
    h.OAn.p(ID, 26L, 1L);
    AppMethodBeat.o(177);
  }
  
  public static void dDZ()
  {
    AppMethodBeat.i(178);
    Log.i(TAG, "markMixFrameDrawFailed");
    h.OAn.p(ID, 27L, 1L);
    AppMethodBeat.o(178);
  }
  
  public static void dEa()
  {
    AppMethodBeat.i(179);
    Log.i(TAG, "markUseWxam");
    h.OAn.p(ID, 30L, 1L);
    AppMethodBeat.o(179);
  }
  
  public static void dEb()
  {
    AppMethodBeat.i(180);
    Log.i(TAG, "markUseGif");
    h.OAn.p(ID, 31L, 1L);
    AppMethodBeat.o(180);
  }
  
  public static void dEc()
  {
    AppMethodBeat.i(181);
    Log.i(TAG, "markWxamInitFailed");
    h.OAn.p(ID, 32L, 1L);
    AppMethodBeat.o(181);
  }
  
  public static void dEd()
  {
    AppMethodBeat.i(182);
    Log.i(TAG, "markGifInitFailed");
    h.OAn.p(ID, 33L, 1L);
    AppMethodBeat.o(182);
  }
  
  public static void dEe()
  {
    AppMethodBeat.i(183);
    Log.i(TAG, "markSdkSegmentInitFailed");
    h.OAn.p(ID, 45L, 1L);
    AppMethodBeat.o(183);
  }
  
  public static void dEf()
  {
    AppMethodBeat.i(184);
    Log.i(TAG, "markSdkSegmentDestroyFailed");
    h.OAn.p(ID, 47L, 1L);
    AppMethodBeat.o(184);
  }
  
  public static void dEg()
  {
    AppMethodBeat.i(185);
    h.OAn.p(ID, 56L, 1L);
    AppMethodBeat.o(185);
  }
  
  public static void dEh()
  {
    AppMethodBeat.i(186);
    h.OAn.p(ID, 57L, 1L);
    AppMethodBeat.o(186);
  }
  
  public static void dEi()
  {
    AppMethodBeat.i(187);
    Log.i(TAG, "markProxyCallFailed");
    h.OAn.p(ID, 59L, 1L);
    AppMethodBeat.o(187);
  }
  
  public static void w(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(175);
    Log.i(TAG, "markEmojiMixSucc, costTime:" + paramLong + ", removeBackground:" + paramBoolean);
    h.OAn.p(ID, 21L, 1L);
    if (paramBoolean) {
      h.OAn.p(ID, 23L, 1L);
    }
    while (paramBoolean)
    {
      h.OAn.p(ID, 42L, paramLong);
      AppMethodBeat.o(175);
      return;
      h.OAn.p(ID, 22L, 1L);
    }
    h.OAn.p(ID, 39L, paramLong);
    AppMethodBeat.o(175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.e
 * JD-Core Version:    0.7.0.1
 */