package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MagicPenHandle
{
  private final long blO;
  private boolean blP;
  
  public MagicPenHandle()
  {
    AppMethodBeat.i(86267);
    this.blP = false;
    this.blO = nativeMagicPen();
    this.blP = true;
    AppMethodBeat.o(86267);
  }
  
  private native void nativeAddCenterToList(long paramLong, float paramFloat1, float paramFloat2);
  
  private native boolean nativeCanRedo(long paramLong);
  
  private native boolean nativeCanUndo(long paramLong);
  
  private native void nativeCleanCenterList(long paramLong);
  
  private native void nativeDispose(long paramLong);
  
  private native void nativeEnablePatternColor(long paramLong, boolean paramBoolean);
  
  private native int[] nativeGetSelectRect(long paramLong);
  
  private native void nativeIsFollowDirection(long paramLong, boolean paramBoolean);
  
  private native long nativeMagicPen();
  
  private native void nativeProcessImage(long paramLong);
  
  private native void nativeRSSColor(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeRedo(long paramLong);
  
  private native void nativeResetPoints(long paramLong);
  
  private native void nativeSetOptMode(long paramLong, int paramInt);
  
  private native void nativeSetPaintAlpha(long paramLong, float paramFloat);
  
  private native void nativeSetPaintMode(long paramLong, int paramInt);
  
  private native void nativeSetPaintSubMode(long paramLong, int paramInt);
  
  private native void nativeSetPatternImageList(long paramLong, Bitmap[] paramArrayOfBitmap);
  
  private native void nativeSetRadius(long paramLong, float paramFloat);
  
  private native void nativeSetTileRatio(long paramLong, float paramFloat);
  
  private native void nativeTouchBegin(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeTouchCancel(long paramLong);
  
  private native void nativeTouchEnd(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeTouchMove(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeUndo(long paramLong);
  
  private native long nativeUpdateAlphaBitmap(long paramLong, Bitmap paramBitmap);
  
  private native void nativeUpdateMosaicAlignType(long paramLong, int paramInt);
  
  private native void nativeUpdateMosaicHorizontalSpace(long paramLong, float paramFloat);
  
  private native void nativeUpdateMosaicVerticalSpace(long paramLong, float paramFloat);
  
  private native void nativeUpdatePatternIntervalRatioWidth(long paramLong, float paramFloat);
  
  private native long nativeUpdateSrcImage(long paramLong, QImage paramQImage);
  
  protected void finalize()
  {
    AppMethodBeat.i(86266);
    if (this.blP)
    {
      nativeDispose(this.blO);
      this.blP = false;
    }
    super.finalize();
    AppMethodBeat.o(86266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.microrapid.opencv.MagicPenHandle
 * JD-Core Version:    0.7.0.1
 */