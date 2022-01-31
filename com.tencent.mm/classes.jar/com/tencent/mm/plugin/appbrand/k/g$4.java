package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Set;

final class g$4
  implements e.a
{
  g$4(g paramg, String paramString, boolean paramBoolean, j paramj, b paramb) {}
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(140856);
    ab.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramc });
    Object localObject1 = this.isb;
    Object localObject2 = this.bEK;
    localObject1 = ((g)localObject1).irX.br(localObject2);
    if (localObject1 == null)
    {
      AppMethodBeat.o(140856);
      return;
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (g.a)((Iterator)localObject1).next();
      if (((g.a)localObject2).isi != null) {
        ((g.a)localObject2).isi.b(paramc);
      }
    }
    AppMethodBeat.o(140856);
  }
  
  public final void dO(String paramString)
  {
    AppMethodBeat.i(140855);
    ab.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", new Object[] { this.bEK, paramString });
    paramString = new g.4.1(this, paramString);
    this.isa.I(paramString);
    AppMethodBeat.o(140855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.g.4
 * JD-Core Version:    0.7.0.1
 */