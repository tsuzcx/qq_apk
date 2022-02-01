package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.i;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements q, u<Bitmap>
{
  private final e aAt;
  private final Bitmap bitmap;
  
  public d(Bitmap paramBitmap, e parame)
  {
    AppMethodBeat.i(77357);
    this.bitmap = ((Bitmap)i.checkNotNull(paramBitmap, "Bitmap must not be null"));
    this.aAt = ((e)i.checkNotNull(parame, "BitmapPool must not be null"));
    AppMethodBeat.o(77357);
  }
  
  public static d a(Bitmap paramBitmap, e parame)
  {
    AppMethodBeat.i(77356);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(77356);
      return null;
    }
    paramBitmap = new d(paramBitmap, parame);
    AppMethodBeat.o(77356);
    return paramBitmap;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(77358);
    int i = j.k(this.bitmap);
    AppMethodBeat.o(77358);
    return i;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(77360);
    this.bitmap.prepareToDraw();
    AppMethodBeat.o(77360);
  }
  
  public final Class<Bitmap> oy()
  {
    return Bitmap.class;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77359);
    this.aAt.g(this.bitmap);
    AppMethodBeat.o(77359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.d
 * JD-Core Version:    0.7.0.1
 */