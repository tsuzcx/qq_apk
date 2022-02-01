package com.tencent.mm.loader.d.c;

import android.graphics.Bitmap;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.g.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class c
  extends b<Bitmap>
{
  private boolean nrc = true;
  private float nrd;
  
  public c()
  {
    this.nrd = 0.1F;
  }
  
  public c(float paramFloat)
  {
    this.nrd = paramFloat;
  }
  
  public final String GH(String paramString)
  {
    return "_round_" + this.nrd + "_";
  }
  
  public final e<? extends Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, e<Bitmap> parame)
  {
    paramg = (Bitmap)parame.value;
    paramf = paramg;
    if (this.nrc)
    {
      paramf = paramg;
      if (this.nrd == 0.0F)
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
      paramf = BitmapUtil.getRoundedCornerBitmap(paramf, false, paramf.getWidth() * this.nrd);
    }
    return new e(paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.c.c
 * JD-Core Version:    0.7.0.1
 */