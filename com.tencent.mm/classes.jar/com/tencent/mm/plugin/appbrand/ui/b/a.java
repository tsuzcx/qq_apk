package com.tencent.mm.plugin.appbrand.ui.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.g;

public final class a
  implements b.h
{
  private final int mJj;
  
  public a(int paramInt)
  {
    this.mJj = paramInt;
  }
  
  public final String BM()
  {
    return "AppBrandProfileLikeImageTransformation";
  }
  
  public final Bitmap F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49043);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(49043);
      return paramBitmap;
    }
    Bitmap localBitmap = g.a(paramBitmap, false, this.mJj, false);
    if (localBitmap != null)
    {
      AppMethodBeat.o(49043);
      return localBitmap;
    }
    AppMethodBeat.o(49043);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.a
 * JD-Core Version:    0.7.0.1
 */