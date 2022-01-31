package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.e.a.c;

final class c$1
  implements a.c
{
  c$1(c paramc, e.a parama, d paramd, String paramString) {}
  
  public final void C(Bitmap paramBitmap)
  {
    AppMethodBeat.i(132091);
    if ((this.hok == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(132091);
      return;
    }
    this.hok.a(this.hol);
    AppMethodBeat.o(132091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.a.c.1
 * JD-Core Version:    0.7.0.1
 */