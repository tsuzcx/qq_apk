package com.tencent.filter.art;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.QImage;
import com.tencent.filter.c;
import com.tencent.view.b;

public class OilPaintFilter
  extends c
{
  int type;
  
  public OilPaintFilter(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static native int nativeGetBrushSize(long paramLong);
  
  public static native long nativeInitialize(QImage paramQImage, int paramInt);
  
  public static native QImage nativeProcessOilPaintFilter(long paramLong, QImage paramQImage, int paramInt1, int paramInt2);
  
  public static native void nativeRelease(long paramLong);
  
  public static native void nativeSetBrush(long paramLong, Bitmap[] paramArrayOfBitmap);
  
  public QImage ApplyFilter(QImage paramQImage)
  {
    int i = 0;
    long l = nativeInitialize(paramQImage, this.type);
    int j = nativeGetBrushSize(l);
    Bitmap[] arrayOfBitmap = new Bitmap[4];
    if (this.type == 0)
    {
      arrayOfBitmap[0] = b.a("brush/brush00.png", Bitmap.Config.ARGB_8888, j, j);
      arrayOfBitmap[1] = b.a("brush/brush01.png", Bitmap.Config.ARGB_8888, j, j);
      arrayOfBitmap[2] = b.a("brush/brush02.png", Bitmap.Config.ARGB_8888, j, j);
      arrayOfBitmap[3] = b.a("brush/brush03.png", Bitmap.Config.ARGB_8888, j, j);
    }
    for (;;)
    {
      nativeSetBrush(l, arrayOfBitmap);
      paramQImage = nativeProcessOilPaintFilter(l, paramQImage, this.type, 5);
      nativeRelease(l);
      while (i < 4)
      {
        if (arrayOfBitmap[i] != null) {
          arrayOfBitmap[i].recycle();
        }
        i += 1;
      }
      arrayOfBitmap[0] = b.a("brush/brush10.png", Bitmap.Config.ARGB_8888, j, j);
      arrayOfBitmap[1] = b.a("brush/brush11.png", Bitmap.Config.ARGB_8888, j, j);
      arrayOfBitmap[2] = b.a("brush/brush12.png", Bitmap.Config.ARGB_8888, j, j);
      arrayOfBitmap[3] = b.a("brush/brush13.png", Bitmap.Config.ARGB_8888, j, j);
    }
    return paramQImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.art.OilPaintFilter
 * JD-Core Version:    0.7.0.1
 */