package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  implements j<Bitmap, Bitmap>
{
  static final class a
    implements v<Bitmap>
  {
    private final Bitmap bitmap;
    
    a(Bitmap paramBitmap)
    {
      this.bitmap = paramBitmap;
    }
    
    public final int getSize()
    {
      AppMethodBeat.i(77437);
      int i = k.k(this.bitmap);
      AppMethodBeat.o(77437);
      return i;
    }
    
    public final Class<Bitmap> oV()
    {
      return Bitmap.class;
    }
    
    public final void recycle() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.r
 * JD-Core Version:    0.7.0.1
 */