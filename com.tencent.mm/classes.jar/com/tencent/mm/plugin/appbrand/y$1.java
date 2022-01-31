package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.c;
import com.tencent.mm.kernel.c.d.a;
import java.util.Set;

final class y$1
  implements d.a
{
  y$1(y paramy) {}
  
  public final void a(Class<? extends a> paramClass, a parama)
  {
    AppMethodBeat.i(141642);
    d.a locala = y.b(this.gSa);
    if (locala != null) {
      locala.a(paramClass, parama);
    }
    AppMethodBeat.o(141642);
  }
  
  public final void a(Class<? extends a> paramClass, c paramc)
  {
    AppMethodBeat.i(141640);
    y.a(this.gSa).add(paramClass);
    d.a locala = y.b(this.gSa);
    if (locala != null) {
      locala.a(paramClass, paramc);
    }
    AppMethodBeat.o(141640);
  }
  
  public final void b(Class<? extends a> paramClass, c paramc)
  {
    AppMethodBeat.i(141641);
    d.a locala = y.b(this.gSa);
    if (locala != null) {
      locala.b(paramClass, paramc);
    }
    AppMethodBeat.o(141641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.1
 * JD-Core Version:    0.7.0.1
 */