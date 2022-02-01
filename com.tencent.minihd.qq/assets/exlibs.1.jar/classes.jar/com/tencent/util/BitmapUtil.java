package com.tencent.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class BitmapUtil
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int m = paramInt1 / j;
    int n = paramInt2 / k;
    if (n > m)
    {
      paramInt1 = (paramInt2 - k * paramInt1 / j) / 2;
      paramInt2 = paramInt1 / k;
      paramInt2 = i;
    }
    for (;;)
    {
      if (paramInt1 > 0) {}
      while (paramInt2 <= 0)
      {
        return null;
        if (n >= m) {
          break label93;
        }
        paramInt2 = (paramInt1 - j * paramInt2 / k) / 2;
        paramInt1 = paramInt2 / j;
        paramInt1 = 0;
        break;
      }
      return null;
      label93:
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    paramDrawable = a(paramDrawable);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(paramInt1 / i, paramInt2 / j);
    return new BitmapDrawable(Bitmap.createBitmap(paramDrawable, 0, 0, i, j, localMatrix, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */