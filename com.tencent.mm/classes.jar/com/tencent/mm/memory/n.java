package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends BucketPool<Bitmap, n.b>
{
  public static n nNG;
  
  static
  {
    AppMethodBeat.i(156463);
    nNG = new n();
    AppMethodBeat.o(156463);
  }
  
  private static Bitmap b(n.b paramb)
  {
    AppMethodBeat.i(156456);
    paramb = Bitmap.createBitmap(paramb.width, paramb.height, j.nNu);
    AppMethodBeat.o(156456);
    return paramb;
  }
  
  public final void M(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(156455);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        super.dn(paramBitmap);
      }
      AppMethodBeat.o(156455);
      return;
    }
    finally {}
  }
  
  public final Bitmap a(n.b paramb)
  {
    try
    {
      AppMethodBeat.i(156454);
      Bitmap localBitmap2 = (Bitmap)super.b(paramb);
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
  
  protected final long bvE()
  {
    return 1228800L;
  }
  
  protected final long bvF()
  {
    return 307200L;
  }
  
  static final class a
    extends d<Bitmap, n.b>
  {
    public a(n.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.n
 * JD-Core Version:    0.7.0.1
 */