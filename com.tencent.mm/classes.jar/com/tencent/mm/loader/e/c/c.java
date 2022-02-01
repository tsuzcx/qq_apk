package com.tencent.mm.loader.e.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class c
  extends b<Bitmap>
{
  private boolean iaT = true;
  private float iaU;
  
  public c()
  {
    this.iaU = 0.1F;
  }
  
  public c(float paramFloat)
  {
    this.iaU = paramFloat;
  }
  
  public final String Hi(String paramString)
  {
    return String.format("_round_%.2f_", new Object[] { Float.valueOf(this.iaU) });
  }
  
  public final e<? extends Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, e<Bitmap> parame)
  {
    paramg = (Bitmap)parame.value;
    paramf = paramg;
    if (this.iaT)
    {
      paramf = paramg;
      if (this.iaU == 0.0F)
      {
        paramf = paramg;
        if (paramg.getWidth() != paramg.getHeight())
        {
          int j = Math.min(paramg.getWidth(), paramg.getHeight());
          int i = j;
          if (j <= 0) {
            i = Math.max(paramg.getWidth(), paramg.getHeight());
          }
          paramf = BitmapUtil.getCenterCropBitmap(paramg, i, i, true);
        }
      }
      paramf = BitmapUtil.getRoundedCornerBitmap(paramf, false, paramf.getWidth() * this.iaU);
    }
    return new e(paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.c
 * JD-Core Version:    0.7.0.1
 */