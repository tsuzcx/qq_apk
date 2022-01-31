package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CosmeticsHandle
{
  private final long blO;
  private boolean blP;
  private QImage blS;
  
  public CosmeticsHandle()
  {
    AppMethodBeat.i(86257);
    this.blP = false;
    this.blS = null;
    this.blO = nativeCosmeticsProcess();
    this.blP = true;
    AppMethodBeat.o(86257);
  }
  
  public static void a(byte[] paramArrayOfByte, int[][] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(86258);
    nativeSegmentLipsFast(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2);
    AppMethodBeat.o(86258);
  }
  
  private static native boolean nativeCanManualRedo(long paramLong, int paramInt);
  
  private static native boolean nativeCanManualUndo(long paramLong, int paramInt);
  
  private static native boolean nativeCheckIsAllDisable(long paramLong);
  
  private static native void nativeClearComseticCache(long paramLong, int paramInt);
  
  private static native void nativeClearCosmeticMask(long paramLong, int paramInt);
  
  private static native void nativeCosmetic(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private static native long nativeCosmeticsProcess();
  
  private static native void nativeDisableAllCosmetic(long paramLong);
  
  private static native void nativeDisableCosmetic(long paramLong, int paramInt);
  
  private static native void nativeDispose(long paramLong);
  
  private static native void nativeFineTuneFeatures(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private static native double nativeGetCosAlpha(long paramLong, int paramInt);
  
  private static native int nativeGetCosParamWithIndex(long paramLong, int paramInt1, int paramInt2);
  
  private static native int[][] nativeGetFaceFeatures(long paramLong);
  
  private static native int nativeGetHairType(long paramLong);
  
  private static native double nativeGetLastSmoothMag(long paramLong);
  
  private static native void nativeGetSkinMaskBitmap(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeInitCosModel(long paramLong, int paramInt, Bitmap[] paramArrayOfBitmap);
  
  private static native int nativeIsNeedRestModel(long paramLong);
  
  private static native void nativeLanderBitmap(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeLocateIrisFast(byte[] paramArrayOfByte, int[][] paramArrayOfInt, int paramInt1, int paramInt2, int[] paramArrayOfInt1);
  
  private static native void nativeManualAcceptAdjust(long paramLong, int paramInt);
  
  private static native void nativeManualCancelAdjust(long paramLong, int paramInt);
  
  private static native void nativeManualRedo(long paramLong, int paramInt);
  
  private static native void nativeManualUndo(long paramLong, int paramInt);
  
  private static native boolean nativePreProcessImage(long paramLong, int paramInt);
  
  private static native void nativeRSSColor(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nativeResetALLCosAlpha(long paramLong);
  
  private static native void nativeSegmentLipsFast(byte[] paramArrayOfByte, int[][] paramArrayOfInt, int paramInt1, int paramInt2);
  
  private static native void nativeSetAutoBodyMask(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeSetAutoHairMask(long paramLong, Bitmap paramBitmap);
  
  private static native void nativeSetBitmap(long paramLong, QImage paramQImage);
  
  private static native void nativeSetCosAlpha(long paramLong, double paramDouble, int paramInt);
  
  private static native int nativeSetCosParamWithIndex(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeSetFaceCount(long paramLong, int paramInt);
  
  private static native void nativeSetFaceFeatures(long paramLong, int[][] paramArrayOfInt);
  
  private static native void nativeSetHairMask(long paramLong, Bitmap paramBitmap, int paramInt);
  
  private static native void nativeSetHairRecolorType(long paramLong, int paramInt);
  
  private static native void nativeSetLastSmoothMag(long paramLong, double paramDouble);
  
  private static native void nativeSetMaxBasicMag(long paramLong, double paramDouble);
  
  private static native void nativeSetMaxSmoothMag(long paramLong, double paramDouble);
  
  private static native void nativeSetRss(long paramLong, Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  private static native void nativeSetUseGpuSmooth(long paramLong, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.microrapid.opencv.CosmeticsHandle
 * JD-Core Version:    0.7.0.1
 */