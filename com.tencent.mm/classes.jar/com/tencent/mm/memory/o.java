package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends e<Bitmap, o.b>
{
  public static o hzF;
  
  static
  {
    AppMethodBeat.i(156463);
    hzF = new o();
    AppMethodBeat.o(156463);
  }
  
  private static Bitmap b(o.b paramb)
  {
    AppMethodBeat.i(156456);
    paramb = Bitmap.createBitmap(paramb.width, paramb.height, k.hzs);
    AppMethodBeat.o(156456);
    return paramb;
  }
  
  public final Bitmap a(o.b paramb)
  {
    try
    {
      AppMethodBeat.i(156454);
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
      AppMethodBeat.o(156454);
      return localBitmap1;
    }
    finally {}
  }
  
  protected final long ayJ()
  {
    return 1228800L;
  }
  
  protected final long ayK()
  {
    return 307200L;
  }
  
  public final void f(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(156455);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        super.bL(paramBitmap);
      }
      AppMethodBeat.o(156455);
      return;
    }
    finally {}
  }
  
  static final class a
    extends d<Bitmap, o.b>
  {
    public a(o.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.o
 * JD-Core Version:    0.7.0.1
 */