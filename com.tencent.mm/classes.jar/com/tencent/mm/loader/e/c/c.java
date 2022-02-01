package com.tencent.mm.loader.e.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.sdk.platformtools.h;

public final class c
  extends b<Bitmap>
{
  private boolean hhW = true;
  private float hhX;
  
  public c()
  {
    this.hhX = 0.1F;
  }
  
  public c(float paramFloat)
  {
    this.hhX = paramFloat;
  }
  
  public final e<? extends Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, e<Bitmap> parame)
  {
    paramg = (Bitmap)parame.value;
    paramf = paramg;
    if (this.hhW)
    {
      paramf = paramg;
      if (this.hhX == 0.0F)
      {
        paramf = paramg;
        if (paramg.getWidth() != paramg.getHeight())
        {
          int j = Math.min(paramg.getWidth(), paramg.getHeight());
          int i = j;
          if (j <= 0) {
            i = Math.max(paramg.getWidth(), paramg.getHeight());
          }
          paramf = h.b(paramg, i, i, true);
        }
      }
      paramf = h.a(paramf, false, paramf.getWidth() * this.hhX);
    }
    return new e(paramf);
  }
  
  public final String yJ(String paramString)
  {
    return String.format("_round_%.2f_", new Object[] { Float.valueOf(this.hhX) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.e.c.c
 * JD-Core Version:    0.7.0.1
 */