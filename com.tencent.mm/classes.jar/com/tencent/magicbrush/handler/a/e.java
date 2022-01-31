package com.tencent.magicbrush.handler.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

final class e
{
  Bitmap bkL;
  d bkM = new l();
  Rect bkN = new Rect();
  int[] bkO = new int[4];
  
  e(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 512;
    }
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 512;
    }
    this.bkL = Bitmap.createBitmap(i, paramInt1, Bitmap.Config.ARGB_8888);
    this.bkM.init(i, paramInt1);
    this.bkN.setEmpty();
  }
  
  final boolean b(int paramInt1, int paramInt2, Rect paramRect)
  {
    if (paramRect == null) {}
    do
    {
      return false;
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        paramRect.setEmpty();
        return false;
      }
      this.bkM.a(paramInt1, paramInt2, paramRect);
    } while ((paramRect.left < 0) || (paramRect.right < 0) || (paramRect.width() <= 0) || (paramRect.height() <= 0));
    this.bkN.union(paramRect);
    return true;
  }
  
  final int height()
  {
    if (this.bkL != null) {
      return this.bkL.getHeight();
    }
    return 0;
  }
  
  final int width()
  {
    if (this.bkL != null) {
      return this.bkL.getWidth();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.e
 * JD-Core Version:    0.7.0.1
 */