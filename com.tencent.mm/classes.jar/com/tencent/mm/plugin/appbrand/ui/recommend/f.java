package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;

public final class f
  implements b.f
{
  public static final f iWr;
  public int fsr = 0;
  public int iWq = 0;
  
  static
  {
    AppMethodBeat.i(133565);
    iWr = new f();
    AppMethodBeat.o(133565);
  }
  
  public final String tX()
  {
    return "WxaRecommendIcon";
  }
  
  public final Bitmap x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(133564);
    if ((paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      AppMethodBeat.o(133564);
      return paramBitmap;
    }
    float f2;
    float f1;
    if (paramBitmap.getWidth() == paramBitmap.getHeight())
    {
      f2 = this.iWq;
      f1 = f2;
      if (this.fsr > 0)
      {
        f1 = f2;
        if (this.iWq > 0) {
          f1 = this.iWq * paramBitmap.getWidth() / this.fsr;
        }
      }
    }
    for (paramBitmap = d.a(paramBitmap, false, f1);; paramBitmap = d.a(paramBitmap, false, f1))
    {
      AppMethodBeat.o(133564);
      return paramBitmap;
      int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = j;
      if (j <= 0) {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramBitmap = d.b(paramBitmap, i, i, true);
      f2 = this.iWq;
      f1 = f2;
      if (this.fsr > 0)
      {
        f1 = f2;
        if (this.iWq > 0) {
          f1 = this.iWq * paramBitmap.getWidth() / this.fsr;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.f
 * JD-Core Version:    0.7.0.1
 */