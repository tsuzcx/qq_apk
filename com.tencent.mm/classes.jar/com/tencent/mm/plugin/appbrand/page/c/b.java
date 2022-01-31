package com.tencent.mm.plugin.appbrand.page.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.ui.o;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final v bCg;
  protected final AtomicReference<c.b> iAz;
  
  b(v paramv)
  {
    AppMethodBeat.i(87370);
    this.iAz = new AtomicReference();
    this.iAz.set(c.b.iAA);
    this.bCg = paramv;
    AppMethodBeat.o(87370);
  }
  
  public void vJ() {}
  
  public void vK() {}
  
  public final c.b vL()
  {
    AppMethodBeat.i(87371);
    c.b localb = (c.b)this.iAz.get();
    AppMethodBeat.o(87371);
    return localb;
  }
  
  public void vu()
  {
    AppMethodBeat.i(87372);
    if ((this.bCg.getContext() instanceof Activity)) {
      o.c(((Activity)this.bCg.getContext()).getWindow(), false);
    }
    AppMethodBeat.o(87372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.b
 * JD-Core Version:    0.7.0.1
 */