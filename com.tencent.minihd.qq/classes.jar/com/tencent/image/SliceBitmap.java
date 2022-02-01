package com.tencent.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;

public class SliceBitmap
{
  public static final int DENSITY_NONE = 0;
  private static final int SLICE_SIZE = 2048;
  boolean hasAlpha;
  Bitmap[] mBitmaps;
  int mChangingConfigurations;
  int mColumnCount;
  int mDensity;
  int mHeight;
  int mRowCount;
  int mWidth;
  
  public SliceBitmap(Bitmap paramBitmap)
  {
    if (needSlice(paramBitmap))
    {
      this.mWidth = paramBitmap.getWidth();
      this.mHeight = paramBitmap.getHeight();
      this.mDensity = paramBitmap.getDensity();
      this.hasAlpha = paramBitmap.hasAlpha();
      this.mRowCount = ((this.mWidth + 2048 - 1) / 2048);
      this.mColumnCount = ((this.mHeight + 2048 - 1) / 2048);
      Bitmap[] arrayOfBitmap = new Bitmap[this.mRowCount * this.mColumnCount];
      int j = 0;
      int i = 0;
      int k;
      for (;;)
      {
        if (i >= this.mRowCount)
        {
          this.mBitmaps = arrayOfBitmap;
          return;
        }
        k = 0;
        if (k < this.mColumnCount) {
          break;
        }
        i += 1;
      }
      int i1 = i * 2048;
      int i2 = k * 2048;
      int m;
      if (i1 + 2048 > this.mWidth)
      {
        m = this.mWidth - i1;
        label168:
        if (i2 + 2048 <= this.mHeight) {
          break label227;
        }
      }
      label227:
      for (int n = this.mHeight - i2;; n = 2048)
      {
        arrayOfBitmap[j] = Bitmap.createBitmap(paramBitmap, i1, i2, m, n);
        j += 1;
        k += 1;
        break;
        m = 2048;
        break label168;
      }
    }
    throw new IllegalArgumentException("the bitmap no need to Slice");
  }
  
  public static boolean needSlice(Bitmap paramBitmap)
  {
    return (paramBitmap.getWidth() > 2048) || (paramBitmap.getHeight() > 2048);
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    int m = paramCanvas.save();
    boolean bool = paramCanvas.isHardwareAccelerated();
    int n = paramCanvas.getDensity();
    paramCanvas.translate(paramRect.left, paramRect.top);
    if ((paramRect.width() != this.mWidth) || (paramRect.height() != this.mHeight)) {
      paramCanvas.scale(paramRect.width() / this.mWidth, paramRect.height() / this.mHeight);
    }
    int j = 0;
    if (!bool) {
      paramCanvas.setDensity(this.mDensity);
    }
    int i = 0;
    if (i >= this.mRowCount)
    {
      if (!bool) {
        paramCanvas.setDensity(n);
      }
      paramCanvas.restoreToCount(m);
      return;
    }
    int k = 0;
    for (;;)
    {
      if (k >= this.mColumnCount)
      {
        i += 1;
        break;
      }
      paramRect = this.mBitmaps[j];
      if (paramRect != null) {
        paramCanvas.drawBitmap(paramRect, i * 2048, k * 2048, paramPaint);
      }
      j += 1;
      k += 1;
    }
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    if ((this.mBitmaps != null) && (this.mBitmaps.length > paramInt)) {
      return this.mBitmaps[paramInt];
    }
    return null;
  }
  
  public final int getByteCount()
  {
    int j = 0;
    Bitmap[] arrayOfBitmap = this.mBitmaps;
    int k = arrayOfBitmap.length;
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        return j;
      }
      j += Utils.getBitmapSize(arrayOfBitmap[i]);
      i += 1;
    }
  }
  
  public int getColumnCount()
  {
    return this.mColumnCount;
  }
  
  public final int getHeight()
  {
    return this.mHeight;
  }
  
  public int getRowCount()
  {
    return this.mRowCount;
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramInt);
  }
  
  public int getScaledHeight(Canvas paramCanvas)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramCanvas.getDensity());
  }
  
  public int getScaledHeight(DisplayMetrics paramDisplayMetrics)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramDisplayMetrics.densityDpi);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramInt);
  }
  
  public int getScaledWidth(Canvas paramCanvas)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramCanvas.getDensity());
  }
  
  public int getScaledWidth(DisplayMetrics paramDisplayMetrics)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramDisplayMetrics.densityDpi);
  }
  
  public final int getWidth()
  {
    return this.mWidth;
  }
  
  public final boolean hasAlpha()
  {
    return this.hasAlpha;
  }
  
  public void recyle()
  {
    Bitmap[] arrayOfBitmap = this.mBitmaps;
    int j = arrayOfBitmap.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      Bitmap localBitmap = arrayOfBitmap[i];
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.image.SliceBitmap
 * JD-Core Version:    0.7.0.1
 */