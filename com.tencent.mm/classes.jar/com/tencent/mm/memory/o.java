package com.tencent.mm.memory;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends e<Bitmap, o.b>
{
  public static o fdX;
  
  static
  {
    AppMethodBeat.i(115417);
    fdX = new o();
    AppMethodBeat.o(115417);
  }
  
  private static Bitmap b(o.b paramb)
  {
    AppMethodBeat.i(115410);
    paramb = Bitmap.createBitmap(paramb.width, paramb.height, k.fdK);
    AppMethodBeat.o(115410);
    return paramb;
  }
  
  protected final long XH()
  {
    return 1228800L;
  }
  
  protected final long XI()
  {
    return 307200L;
  }
  
  public final Bitmap a(o.b paramb)
  {
    try
    {
      AppMethodBeat.i(115408);
      Bitmap localBitmap2 = (Bitmap)super.d(paramb);
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
      AppMethodBeat.o(115408);
      return localBitmap1;
    }
    finally {}
  }
  
  public final void t(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(115409);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        super.aG(paramBitmap);
      }
      AppMethodBeat.o(115409);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.o
 * JD-Core Version:    0.7.0.1
 */