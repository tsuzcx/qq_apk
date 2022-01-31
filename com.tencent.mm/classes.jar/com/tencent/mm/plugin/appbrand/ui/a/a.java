package com.tencent.mm.plugin.appbrand.ui.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;

public final class a
  implements b.f
{
  private final int iSk;
  
  public a(int paramInt)
  {
    this.iSk = paramInt;
  }
  
  public final String tX()
  {
    return "AppBrandProfileLikeImageTransformation";
  }
  
  public final Bitmap x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(133324);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(133324);
      return paramBitmap;
    }
    Bitmap localBitmap = d.a(paramBitmap, false, this.iSk, false);
    if (localBitmap != null)
    {
      AppMethodBeat.o(133324);
      return localBitmap;
    }
    AppMethodBeat.o(133324);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.a.a
 * JD-Core Version:    0.7.0.1
 */