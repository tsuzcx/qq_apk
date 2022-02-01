package com.bumptech.glide.c.d.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.a.d;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements e<Drawable, byte[]>
{
  private final e<Bitmap, byte[]> aJH;
  private final e<com.bumptech.glide.c.d.e.c, byte[]> aJI;
  private final com.bumptech.glide.c.b.a.e azz;
  
  public c(com.bumptech.glide.c.b.a.e parame, e<Bitmap, byte[]> parame1, e<com.bumptech.glide.c.d.e.c, byte[]> parame2)
  {
    this.azz = parame;
    this.aJH = parame1;
    this.aJI = parame2;
  }
  
  public final u<byte[]> a(u<Drawable> paramu, j paramj)
  {
    AppMethodBeat.i(77532);
    Drawable localDrawable = (Drawable)paramu.get();
    if ((localDrawable instanceof BitmapDrawable))
    {
      paramu = this.aJH.a(d.a(((BitmapDrawable)localDrawable).getBitmap(), this.azz), paramj);
      AppMethodBeat.o(77532);
      return paramu;
    }
    if ((localDrawable instanceof com.bumptech.glide.c.d.e.c))
    {
      paramu = this.aJI.a(paramu, paramj);
      AppMethodBeat.o(77532);
      return paramu;
    }
    AppMethodBeat.o(77532);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.f.c
 * JD-Core Version:    0.7.0.1
 */