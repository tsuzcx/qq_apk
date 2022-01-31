package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

public final class f
  implements b.f
{
  public static final f fqU;
  
  static
  {
    AppMethodBeat.i(77384);
    fqU = new f();
    AppMethodBeat.o(77384);
  }
  
  public final String tX()
  {
    return "WxaIcon";
  }
  
  public final Bitmap x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77383);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(77383);
      return paramBitmap;
    }
    paramBitmap = d.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
    AppMethodBeat.o(77383);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.f
 * JD-Core Version:    0.7.0.1
 */