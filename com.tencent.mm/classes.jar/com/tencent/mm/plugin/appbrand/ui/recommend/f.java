package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.g;

public final class f
  implements b.h
{
  public static final f mNc;
  public int hNd = 0;
  public int mNb = 0;
  
  static
  {
    AppMethodBeat.i(49296);
    mNc = new f();
    AppMethodBeat.o(49296);
  }
  
  public final String BM()
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
      f2 = this.mNb;
      f1 = f2;
      if (this.hNd > 0)
      {
        f1 = f2;
        if (this.mNb > 0) {
          f1 = this.mNb * paramBitmap.getWidth() / this.hNd;
        }
      }
    }
    for (paramBitmap = g.a(paramBitmap, false, f1);; paramBitmap = g.a(paramBitmap, false, f1))
    {
      AppMethodBeat.o(49295);
      return paramBitmap;
      int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = j;
      if (j <= 0) {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramBitmap = g.b(paramBitmap, i, i, true);
      f2 = this.mNb;
      f1 = f2;
      if (this.hNd > 0)
      {
        f1 = f2;
        if (this.mNb > 0) {
          f1 = this.mNb * paramBitmap.getWidth() / this.hNd;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.f
 * JD-Core Version:    0.7.0.1
 */