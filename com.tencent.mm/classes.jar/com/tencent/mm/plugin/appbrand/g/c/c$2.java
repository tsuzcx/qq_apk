package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c.a.a;
import com.tencent.mm.plugin.appbrand.g.c.b.b;
import com.tencent.mm.plugin.appbrand.g.c.b.e;
import java.util.Map;

public final class c$2
  implements a
{
  public c$2(c paramc, com.tencent.mm.plugin.appbrand.g.b.c paramc1, com.tencent.mm.plugin.appbrand.g.c.a.c paramc2) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(158958);
    if (this.kgZ != null) {
      this.kgZ.a(parame);
    }
    AppMethodBeat.o(158958);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(158957);
    String str = parame.khG.get("SID");
    com.tencent.mm.plugin.appbrand.g.c.b.c localc = new com.tencent.mm.plugin.appbrand.g.c.b.c();
    parame = parame.khG;
    localc.khD = parame.get("SID");
    localc.timeout = parame.get("TIMEOUT");
    localc.khE = this.kgY;
    this.kha.kgW.put(str, localc);
    if (this.kgZ != null) {
      this.kgZ.a(localc);
    }
    AppMethodBeat.o(158957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.c.2
 * JD-Core Version:    0.7.0.1
 */