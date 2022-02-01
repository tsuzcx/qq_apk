package com.tencent.mm.br;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
{
  public static m FEO;
  public static l FEP;
  
  public static void aPn(String paramString)
  {
    AppMethodBeat.i(133693);
    if (((h)com.tencent.mm.kernel.g.ajO().ajq()).akL()) {
      d.a(paramString, FEO, FEP);
    }
    AppMethodBeat.o(133693);
  }
  
  public static u.a aPo(String paramString)
  {
    AppMethodBeat.i(133695);
    u.a local2 = new u.a()
    {
      public final az createSubCore()
      {
        AppMethodBeat.i(133692);
        az localaz = d.aPq(this.FEQ);
        AppMethodBeat.o(133692);
        return localaz;
      }
    };
    ae.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new Object[] { local2, paramString });
    AppMethodBeat.o(133695);
    return local2;
  }
  
  public static void b(String paramString, final u paramu)
  {
    AppMethodBeat.i(133694);
    new a()
    {
      public final void execute(com.tencent.mm.kernel.b.g paramAnonymousg)
      {
        AppMethodBeat.i(133691);
        String str = this.FEQ;
        u localu = paramu;
        d.a(str, c.FEO, c.FEP);
        paramAnonymousg = localu;
        if (localu == null) {
          paramAnonymousg = new u(c.aPo(str));
        }
        u.a("plugin.".concat(String.valueOf(str)), paramAnonymousg);
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