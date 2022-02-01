package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.c;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements l<BitmapDrawable>
{
  private final e aAt;
  private final l<Bitmap> aEW;
  
  public b(e parame, l<Bitmap> paraml)
  {
    this.aAt = parame;
    this.aEW = paraml;
  }
  
  public final c b(j paramj)
  {
    AppMethodBeat.i(77351);
    paramj = this.aEW.b(paramj);
    AppMethodBeat.o(77351);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.b
 * JD-Core Version:    0.7.0.1
 */