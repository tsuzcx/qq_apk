package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;

final class i$d
  implements i.b, a
{
  volatile boolean gQl;
  
  private i$d(i parami)
  {
    AppMethodBeat.i(86666);
    this.gPY.keep(this);
    this.gQl = false;
    AppMethodBeat.o(86666);
  }
  
  public final void dead()
  {
    this.gQl = true;
  }
  
  public final void done()
  {
    AppMethodBeat.i(86667);
    if (!this.gQl)
    {
      i.d.1 local1 = new i.d.1(this);
      this.gPY.k(local1, 0L);
    }
    AppMethodBeat.o(86667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.d
 * JD-Core Version:    0.7.0.1
 */