package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.e.a.c;

final class g$1
  implements b.i
{
  g$1(g paramg, a.c paramc) {}
  
  public final void acG() {}
  
  public final void acH()
  {
    AppMethodBeat.i(86983);
    if (this.ion == null)
    {
      AppMethodBeat.o(86983);
      return;
    }
    this.ion.C(null);
    AppMethodBeat.o(86983);
  }
  
  public final String tX()
  {
    return "WxaIcon";
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(86982);
    if (this.ion == null)
    {
      AppMethodBeat.o(86982);
      return;
    }
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      this.ion.C(null);
      AppMethodBeat.o(86982);
      return;
    }
    this.ion.C(paramBitmap);
    AppMethodBeat.o(86982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.g.1
 * JD-Core Version:    0.7.0.1
 */