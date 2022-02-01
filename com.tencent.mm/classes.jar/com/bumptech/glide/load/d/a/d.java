package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.j;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements r, v<Bitmap>
{
  private final e aCj;
  private final Bitmap bitmap;
  
  public d(Bitmap paramBitmap, e parame)
  {
    AppMethodBeat.i(77357);
    this.bitmap = ((Bitmap)j.checkNotNull(paramBitmap, "Bitmap must not be null"));
    this.aCj = ((e)j.checkNotNull(parame, "BitmapPool must not be null"));
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
    int i = k.k(this.bitmap);
    AppMethodBeat.o(77358);
    return i;
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(77360);
    this.bitmap.prepareToDraw();
    AppMethodBeat.o(77360);
  }
  
  public final Class<Bitmap> oV()
  {
    return Bitmap.class;
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(77359);
    this.aCj.g(this.bitmap);
    AppMethodBeat.o(77359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.d
 * JD-Core Version:    0.7.0.1
 */