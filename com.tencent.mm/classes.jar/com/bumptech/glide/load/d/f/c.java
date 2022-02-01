package com.bumptech.glide.load.d.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.d;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements e<Drawable, byte[]>
{
  private final com.bumptech.glide.load.b.a.e aCj;
  private final e<Bitmap, byte[]> aMg;
  private final e<com.bumptech.glide.load.d.e.c, byte[]> aMh;
  
  public c(com.bumptech.glide.load.b.a.e parame, e<Bitmap, byte[]> parame1, e<com.bumptech.glide.load.d.e.c, byte[]> parame2)
  {
    this.aCj = parame;
    this.aMg = parame1;
    this.aMh = parame2;
  }
  
  public final v<byte[]> a(v<Drawable> paramv, i parami)
  {
    AppMethodBeat.i(77532);
    Drawable localDrawable = (Drawable)paramv.get();
    if ((localDrawable instanceof BitmapDrawable))
    {
      paramv = this.aMg.a(d.a(((BitmapDrawable)localDrawable).getBitmap(), this.aCj), parami);
      AppMethodBeat.o(77532);
      return paramv;
    }
    if ((localDrawable instanceof com.bumptech.glide.load.d.e.c))
    {
      paramv = this.aMh.a(paramv, parami);
      AppMethodBeat.o(77532);
      return paramv;
    }
    AppMethodBeat.o(77532);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.f.c
 * JD-Core Version:    0.7.0.1
 */