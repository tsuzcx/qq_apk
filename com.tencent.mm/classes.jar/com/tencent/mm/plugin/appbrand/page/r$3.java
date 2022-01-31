package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class r$3
  implements Runnable
{
  private boolean ivT = false;
  
  r$3(r paramr, bf parambf, boolean paramBoolean, o paramo) {}
  
  public final void run()
  {
    boolean bool1 = true;
    AppMethodBeat.i(141664);
    if (this.ivT)
    {
      AppMethodBeat.o(141664);
      return;
    }
    this.ivT = true;
    if (this.iwq.getPageCount() == 0)
    {
      AppMethodBeat.o(141664);
      return;
    }
    o localo;
    if (r.c(this.iwq).isEmpty())
    {
      localo = null;
      if (r.d(this.iwr)) {
        r.a(this.iwq, localo);
      }
      if ((this.iws) || (!r.e(this.iwr))) {
        break label160;
      }
    }
    for (;;)
    {
      boolean bool2 = r.f(this.iwr);
      r.a(this.iwq, localo, bool1, bool2);
      r.a(this.iwq, this.iwt, bool1);
      this.iwq.a(localo, this.iwt, this.iwr);
      AppMethodBeat.o(141664);
      return;
      localo = (o)r.c(this.iwq).getFirst();
      break;
      label160:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r.3
 * JD-Core Version:    0.7.0.1
 */