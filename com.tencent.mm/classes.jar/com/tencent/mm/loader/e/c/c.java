package com.tencent.mm.loader.e.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.h.e;

public final class c
  extends b<Bitmap>
{
  private boolean gkG = true;
  private float gkH;
  
  public c()
  {
    this.gkH = 0.1F;
  }
  
  public c(float paramFloat)
  {
    this.gkH = paramFloat;
  }
  
  public final e<? extends Bitmap> a(g<?> paramg, com.tencent.mm.loader.f<?, Bitmap> paramf, e<Bitmap> parame)
  {
    paramg = (Bitmap)parame.value;
    paramf = paramg;
    if (this.gkG)
    {
      paramf = paramg;
      if (this.gkH == 0.0F)
      {
        paramf = paramg;
        if (paramg.getWidth() != paramg.getHeight())
        {
          int j = Math.min(paramg.getWidth(), paramg.getHeight());
          int i = j;
          if (j <= 0) {
            i = Math.max(paramg.getWidth(), paramg.getHeight());
          }
          paramf = com.tencent.mm.sdk.platformtools.f.b(paramg, i, i, true);
        }
      }
      paramf = com.tencent.mm.sdk.platformtools.f.a(paramf, false, paramf.getWidth() * this.gkH);
    }
    return new e(paramf);
  }
  
  public final String rg(String paramString)
  {
    return String.format("_round_%s_", new Object[] { Integer.valueOf((int)this.gkH) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.c
 * JD-Core Version:    0.7.0.1
 */