package com.tencent.mm.loader.k;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class a
{
  public static long dl(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bitmap)))
    {
      paramObject = (Bitmap)paramObject;
      if (Build.VERSION.SDK_INT >= 12) {
        return paramObject.getByteCount();
      }
      return paramObject.getRowBytes() * paramObject.getHeight();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.k.a
 * JD-Core Version:    0.7.0.1
 */