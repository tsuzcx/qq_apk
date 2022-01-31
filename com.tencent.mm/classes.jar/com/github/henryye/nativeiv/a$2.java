package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.b;
import com.github.henryye.nativeiv.bitmap.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  implements b<Bitmap>
{
  a$2(a parama) {}
  
  public final boolean a(c paramc)
  {
    return true;
  }
  
  public final void destroy() {}
  
  public final IBitmap<Bitmap> mt()
  {
    AppMethodBeat.i(115740);
    LegacyBitmap localLegacyBitmap = new LegacyBitmap();
    AppMethodBeat.o(115740);
    return localLegacyBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.a.2
 * JD-Core Version:    0.7.0.1
 */