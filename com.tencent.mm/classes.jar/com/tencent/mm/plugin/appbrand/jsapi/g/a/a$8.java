package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.a.c;

final class a$8
  implements a.c
{
  a$8(a parama, float paramFloat1, float paramFloat2, ImageView paramImageView) {}
  
  public final void C(Bitmap paramBitmap)
  {
    AppMethodBeat.i(138418);
    if (paramBitmap != null) {
      a.b(this.hOS, this.hOT, paramBitmap, this.hOU);
    }
    AppMethodBeat.o(138418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.8
 * JD-Core Version:    0.7.0.1
 */