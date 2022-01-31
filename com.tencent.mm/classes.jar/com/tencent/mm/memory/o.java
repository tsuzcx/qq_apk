package com.tencent.mm.memory;

import android.graphics.Bitmap;

public final class o
  extends e<Bitmap, o.b>
{
  public static o dPr = new o();
  
  private static Bitmap b(o.b paramb)
  {
    return Bitmap.createBitmap(paramb.width, paramb.height, k.dPd);
  }
  
  protected final long ER()
  {
    return 1228800L;
  }
  
  protected final long ES()
  {
    return 307200L;
  }
  
  public final Bitmap a(o.b paramb)
  {
    try
    {
      Bitmap localBitmap2 = (Bitmap)super.a(paramb);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = b(paramb);
      }
      return localBitmap1;
    }
    finally {}
  }
  
  public final void m(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled()) {
        super.ar(paramBitmap);
      }
      return;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.o
 * JD-Core Version:    0.7.0.1
 */