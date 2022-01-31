package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.c;

public final class f
  implements b.f
{
  public static final f eaL = new f();
  
  public final String pU()
  {
    return "WxaIcon";
  }
  
  public final Bitmap q(Bitmap paramBitmap)
  {
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0)) {
      return paramBitmap;
    }
    return c.a(paramBitmap, false, paramBitmap.getWidth() / 2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.f
 * JD-Core Version:    0.7.0.1
 */