package com.tencent.mm.loader.e.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;

public final class c
  extends b<Bitmap>
{
  private boolean hfi = true;
  private float hfj;
  
  public c()
  {
    this.hfj = 0.1F;
  }
  
  public c(float paramFloat)
  {
    this.hfj = paramFloat;
  }
  
  public final e<? extends Bitmap> a(com.tencent.mm.loader.e.b.g<?> paramg, f<?, Bitmap> paramf, e<Bitmap> parame)
  {
    paramg = (Bitmap)parame.value;
    paramf = paramg;
    if (this.hfi)
    {
      paramf = paramg;
      if (this.hfj == 0.0F)
      {
        paramf = paramg;
        if (paramg.getWidth() != paramg.getHeight())
        {
          int j = Math.min(paramg.getWidth(), paramg.getHeight());
          int i = j;
          if (j <= 0) {
            i = Math.max(paramg.getWidth(), paramg.getHeight());
          }
          paramf = com.tencent.mm.sdk.platformtools.g.b(paramg, i, i, true);
        }
      }
      paramf = com.tencent.mm.sdk.platformtools.g.a(paramf, false, paramf.getWidth() * this.hfj);
    }
    return new e(paramf);
  }
  
  public final String xZ(String paramString)
  {
    return String.format("_round_%s_", new Object[] { Integer.valueOf((int)this.hfj) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.c
 * JD-Core Version:    0.7.0.1
 */