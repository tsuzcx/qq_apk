package com.tencent.mm.plugin.appbrand.ui.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class a
  implements b.h
{
  private final int rcR;
  
  public a(int paramInt)
  {
    this.rcR = paramInt;
  }
  
  public final Bitmap H(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49043);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(49043);
      return paramBitmap;
    }
    Bitmap localBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, this.rcR, false);
    if (localBitmap != null)
    {
      AppMethodBeat.o(49043);
      return localBitmap;
    }
    AppMethodBeat.o(49043);
    return paramBitmap;
  }
  
  public final String key()
  {
    return "AppBrandProfileLikeImageTransformation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.a
 * JD-Core Version:    0.7.0.1
 */