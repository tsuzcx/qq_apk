package com.microrapid.face;

import android.graphics.Bitmap;
import com.tencent.filter.MRect;
import com.tencent.filter.QImage;

public class Algorithm
{
  static boolean prepared = false;
  
  public static native void BlendBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native long nativeAutoFaceHandle();
  
  public static native void nativeCleanUp(long paramLong);
  
  public static native void nativeClear();
  
  public static native void nativeClearAutoPramChanged(long paramLong, int paramInt);
  
  public static native void nativeDispose(long paramLong);
  
  public static native double nativeGetAutoParam(long paramLong, int paramInt);
  
  public static native QImage nativeGetBeginImage(long paramLong);
  
  public static native void nativeGetEyeMaskPoints(long paramLong, int[] paramArrayOfInt);
  
  public static native void nativeGetFaceMaskPoints(long paramLong, int[] paramArrayOfInt);
  
  public static native void nativeGetPouchMaskPoints(long paramLong, int[] paramArrayOfInt);
  
  public static native boolean nativeIsAutoPramChanged(long paramLong, int paramInt);
  
  public static native boolean nativeIsInitMak(long paramLong);
  
  public static native void nativePreProcessImage(long paramLong);
  
  public static native void nativeProcessBitmap(long paramLong, Bitmap paramBitmap);
  
  public static native void nativeSetAutoParam(long paramLong, int paramInt, double paramDouble);
  
  public static native void nativeSetBitmap(long paramLong, Bitmap paramBitmap);
  
  public static native boolean nativeSetContrastON(long paramLong, boolean paramBoolean);
  
  public static native boolean nativeSetCpuSmoothenOn(long paramLong, boolean paramBoolean);
  
  public static native void nativeSetEyeMak(long paramLong, Bitmap paramBitmap);
  
  public static native void nativeSetFaceFeatures(long paramLong, int[][] paramArrayOfInt);
  
  public static native void nativeSetFaceInfo(long paramLong, MRect paramMRect1, MRect paramMRect2, MRect paramMRect3, MRect paramMRect4);
  
  public static native void nativeSetFaceMak(long paramLong, Bitmap paramBitmap);
  
  public static native void nativeSetLipsMak(long paramLong, Bitmap paramBitmap, MRect paramMRect);
  
  public static native void nativeSetMask(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native void nativeSetPouchMak(long paramLong, Bitmap paramBitmap);
  
  public static native void nativeSetSkinMask(Bitmap paramBitmap, int paramInt);
  
  public static native void nativeSmoothFace14(QImage paramQImage, float paramFloat);
  
  public static native void nativeSmoothImage(long paramLong, QImage paramQImage);
  
  public static native void nativeSurfaceBlurAndSmoothmage(QImage paramQImage, int paramInt);
  
  public static native void nativesetGlossyImage(long paramLong, QImage paramQImage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.microrapid.face.Algorithm
 * JD-Core Version:    0.7.0.1
 */