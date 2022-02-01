package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class f
  implements b.h
{
  public static final f uoQ;
  public int osT = 0;
  public int uoP = 0;
  
  static
  {
    AppMethodBeat.i(49296);
    uoQ = new f();
    AppMethodBeat.o(49296);
  }
  
  public final Bitmap P(Bitmap paramBitmap)
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
      f2 = this.uoP;
      f1 = f2;
      if (this.osT > 0)
      {
        f1 = f2;
        if (this.uoP > 0) {
          f1 = this.uoP * paramBitmap.getWidth() / this.osT;
        }
      }
    }
    for (paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, f1);; paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, f1))
    {
      AppMethodBeat.o(49295);
      return paramBitmap;
      int j = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
      int i = j;
      if (j <= 0) {
        i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
      }
      paramBitmap = BitmapUtil.getCenterCropBitmap(paramBitmap, i, i, true);
      f2 = this.uoP;
      f1 = f2;
      if (this.osT > 0)
      {
        f1 = f2;
        if (this.uoP > 0) {
          f1 = this.uoP * paramBitmap.getWidth() / this.osT;
        }
      }
    }
  }
  
  public final String key()
  {
    return "WxaRecommendIcon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.f
 * JD-Core Version:    0.7.0.1
 */