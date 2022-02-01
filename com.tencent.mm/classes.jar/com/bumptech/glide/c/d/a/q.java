package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
  implements k<Bitmap, Bitmap>
{
  static final class a
    implements u<Bitmap>
  {
    private final Bitmap bitmap;
    
    a(Bitmap paramBitmap)
    {
      this.bitmap = paramBitmap;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(77437);
      int i = j.k(this.bitmap);
      AppMethodBeat.o(77437);
      return i;
    }
    
    public final Class<Bitmap> oy()
    {
      return Bitmap.class;
    }
    
    public final void recycle() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.q
 * JD-Core Version:    0.7.0.1
 */