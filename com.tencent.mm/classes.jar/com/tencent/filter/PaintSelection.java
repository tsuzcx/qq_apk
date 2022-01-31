package com.tencent.filter;

import android.graphics.Bitmap;

public class PaintSelection
{
  private final long aVf;
  private boolean aVg;
  private QImage bfS;
  
  public static native void FormatAlphaBitmap(Bitmap paramBitmap);
  
  public static native boolean HasAlphaBitmap(Bitmap paramBitmap);
  
  public static native void ProcessBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  private native void nativeAddRound(long paramLong, int paramInt1, int paramInt2, double paramDouble);
  
  private native void nativeDispose(long paramLong);
  
  private native byte[] nativeGetResult(long paramLong, int paramInt);
  
  private native int[] nativeGetSelectRect(long paramLong);
  
  private native int nativeGetcurrentUndoMark(long paramLong);
  
  private native void nativeInpaint(long paramLong);
  
  private native long nativePaintSection(QImage paramQImage);
  
  private native void nativeRedo(long paramLong);
  
  private native void nativeReverseSelected(long paramLong);
  
  private native void nativeRmRound(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble);
  
  private native void nativeSetSelectionMode(long paramLong, int paramInt);
  
  private native void nativeTouchBegin(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeTouchMove(long paramLong, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2);
  
  private native void nativeUndo(long paramLong);
  
  private native void nativeUpdateUndoMark(long paramLong);
  
  public static native void reverseBitmapAlpha(Bitmap paramBitmap);
  
  private native void touchBegin1(int paramInt1, int paramInt2);
  
  protected void finalize()
  {
    if (this.aVg)
    {
      nativeDispose(this.aVf);
      this.bfS.Dispose();
      this.bfS = null;
      this.aVg = false;
    }
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.filter.PaintSelection
 * JD-Core Version:    0.7.0.1
 */