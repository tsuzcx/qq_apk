package com.tencent.mm.br;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.model.t.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
{
  public static l DHj;
  public static k DHk;
  
  public static void aIn(String paramString)
  {
    AppMethodBeat.i(133693);
    if (((h)com.tencent.mm.kernel.g.agO().agp()).ahL()) {
      d.a(paramString, DHj, DHk);
    }
    AppMethodBeat.o(133693);
  }
  
  public static t.a aIo(String paramString)
  {
    AppMethodBeat.i(133695);
    t.a local2 = new t.a()
    {
      public final aw createSubCore()
      {
        AppMethodBeat.i(133692);
        aw localaw = d.aIq(this.DHl);
        AppMethodBeat.o(133692);
        return localaw;
      }
    };
    ac.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new Object[] { local2, paramString });
    AppMethodBeat.o(133695);
    return local2;
  }
  
  public static void b(String paramString, final t paramt)
  {
    AppMethodBeat.i(133694);
    new a()
    {
      public final void execute(com.tencent.mm.kernel.b.g paramAnonymousg)
      {
        AppMethodBeat.i(133691);
        String str = this.DHl;
        t localt = paramt;
        d.a(str, c.DHj, c.DHk);
        paramAnonymousg = localt;
        if (localt == null) {
          paramAnonymousg = new t(c.aIo(str));
        }
        t.a("plugin.".concat(String.valueOf(str)), paramAnonymousg);
        AppMethodBeat.o(133691);
      }
    }.alone();
    AppMethodBeat.o(133694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.br.c
 * JD-Core Version:    0.7.0.1
 */