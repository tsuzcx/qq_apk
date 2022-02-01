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
  private final l<Bitmap> aEf;
  private final e azz;
  
  public b(e parame, l<Bitmap> paraml)
  {
    this.azz = parame;
    this.aEf = paraml;
  }
  
  public final c b(j paramj)
  {
    AppMethodBeat.i(77351);
    paramj = this.aEf.b(paramj);
    AppMethodBeat.o(77351);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.b
 * JD-Core Version:    0.7.0.1
 */