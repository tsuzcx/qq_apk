package com.microrapid.opencv;

import android.graphics.Bitmap;
import com.tencent.filter.QImage;

public class OpencvAlgorithm
{
  public static native void nativeDehazeProcess(QImage paramQImage, float paramFloat);
  
  public static native void nativeDetailEnhanceFilter(QImage paramQImage, float paramFloat);
  
  public static native int nativeGlowFilterDropShadow(QImage paramQImage, int paramInt1, int paramInt2, int paramInt3, float paramFloat);
  
  public static native int nativeGlowFilterGlow(QImage paramQImage, int paramInt1, int paramInt2, float paramFloat);
  
  public static native int nativeGlowFilterPolyFit(QImage paramQImage, Bitmap paramBitmap, int paramInt, float paramFloat);
  
  public static native void nativeImageHdrContrastEnhance(QImage paramQImage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.microrapid.opencv.OpencvAlgorithm
 * JD-Core Version:    0.7.0.1
 */