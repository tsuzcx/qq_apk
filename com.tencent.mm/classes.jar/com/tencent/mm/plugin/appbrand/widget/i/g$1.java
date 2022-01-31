package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.i;

final class g$1
  implements b.i
{
  g$1(g paramg) {}
  
  public final void acG() {}
  
  public final void acH()
  {
    AppMethodBeat.i(87566);
    this.jxi.jxd.a("Failed to load icon via network", this.jxi);
    AppMethodBeat.o(87566);
  }
  
  public final String tX()
  {
    return this.jxi.jxc;
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(87565);
    this.jxi.G(paramBitmap);
    AppMethodBeat.o(87565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.g.1
 * JD-Core Version:    0.7.0.1
 */