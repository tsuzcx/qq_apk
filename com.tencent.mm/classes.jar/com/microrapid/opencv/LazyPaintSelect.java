package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;

public class LazyPaintSelect
{
  private final long aVf;
  private boolean aVg;
  
  public static native void FormatAlphaBitmap(Bitmap paramBitmap);
  
  public static native void ProcessBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native void SmoothBitmapForManga(Bitmap paramBitmap);
  
  public static native byte[] getSrcAlphaBytes(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public static native void maskBitmapAlpha(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  private native void nativeAddEraser(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
  
  private native void nativeAddPoints(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
  
  private native boolean nativeCanRedo(long paramLong);
  
  private native boolean nativeCanUndo(long paramLong);
  
  private native boolean nativeCheckRedBack(long paramLong);
  
  private native void nativeDispose(long paramLong);
  
  private native int nativeGetLabelMode(long paramLong);
  
  private native int[] nativeGetSelectRect(long paramLong);
  
  private native void nativeInitForegroundMask(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  private native long nativeLazySnap(Bitmap paramBitmap);
  
  private native void nativeRedo(long paramLong);
  
  private native void nativeResetForegroundMask(long paramLong, QImage paramQImage);
  
  private native void nativeResetPoints(long paramLong);
  
  private native void nativeSetLabelMode(long paramLong, int paramInt);
  
  private native void nativeUndo(long paramLong);
  
  private native void nativeUpdateBitmap(long paramLong, Bitmap paramBitmap);
  
  private native void nativeUpdateEraser(long paramLong);
  
  private native void nativeUpdateForeBitmap(long paramLong, Bitmap paramBitmap);
  
  private native void nativeUpdateLazy(long paramLong);
  
  public static native void reverseBitmapAlpha(Bitmap paramBitmap);
  
  protected void finalize()
  {
    if (this.aVg)
    {
      nativeDispose(this.aVf);
      this.aVg = false;
    }
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.microrapid.opencv.LazyPaintSelect
 * JD-Core Version:    0.7.0.1
 */