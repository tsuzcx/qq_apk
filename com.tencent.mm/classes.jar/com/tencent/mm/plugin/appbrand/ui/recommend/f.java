package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;

public final class f
  implements b.h
{
  public static final f mmA;
  public int huL = 0;
  public int mmz = 0;
  
  static
  {
    AppMethodBeat.i(49296);
    mmA = new f();
    AppMethodBeat.o(49296);
  }
  
  public final String Ap()
  {
    return "WxaRecommendIcon";
  }
  
  public final Bitmap F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(49295);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(49295);
      return paramBitmap;
    }
    float f2;
    float f1;
    if (paramBitmap.getWidth() == paramBitmap.getHeight())
    {
      f2 = this.mmz;
      f1 = f2;
      if (this.huL > 0)
      {
        f1 = f2;
        if (this.mmz > 0) {
          f1 = this.mmz * paramBitmap.getWidth() / this.huL;
        }
      }
    }
    for (paramBitmap = com.tencent.mm.sdk.platformtools.f.a(paramBitmap, false, f1);; paramBitmap = com.tencent.mm.sdk.platformtools.f.a(paramBitmap, false, f1))
    {
      AppMethodBeat.o(49295);
      return paramBitmap;
      int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = j;
      if (j <= 0) {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramBitmap = com.tencent.mm.sdk.platformtools.f.b(paramBitmap, i, i, true);
      f2 = this.mmz;
      f1 = f2;
      if (this.huL > 0)
      {
        f1 = f2;
        if (this.mmz > 0) {
          f1 = this.mmz * paramBitmap.getWidth() / this.huL;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.f
 * JD-Core Version:    0.7.0.1
 */