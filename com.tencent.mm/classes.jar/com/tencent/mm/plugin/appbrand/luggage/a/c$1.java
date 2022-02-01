package com.tencent.mm.plugin.appbrand.luggage.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.f.a.b;

final class c$1
  implements a.b
{
  c$1(c paramc, e.a parama, d paramd, String paramString) {}
  
  public final void M(Bitmap paramBitmap)
  {
    AppMethodBeat.i(47472);
    if ((this.kfQ == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(47472);
      return;
    }
    this.kfQ.a(this.kfR);
    AppMethodBeat.o(47472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.a.c.1
 * JD-Core Version:    0.7.0.1
 */