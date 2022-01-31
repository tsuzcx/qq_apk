package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class r$b
  implements bz.a
{
  private static final b hbU;
  
  static
  {
    AppMethodBeat.i(129625);
    hbU = new b();
    AppMethodBeat.o(129625);
  }
  
  public static void uD()
  {
    AppMethodBeat.i(129621);
    q.axe();
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("wxareddot", hbU, true);
    AppMethodBeat.o(129621);
  }
  
  public static void unregister()
  {
    AppMethodBeat.i(129622);
    q.axe();
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("wxareddot", hbU, true);
    AppMethodBeat.o(129622);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(129623);
    parama = aa.a(parama.eyJ.woR);
    if (bo.isNullOrNil(parama))
    {
      AppMethodBeat.o(129623);
      return;
    }
    e.aNS().ac(new r.b.1(this, parama));
    AppMethodBeat.o(129623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r.b
 * JD-Core Version:    0.7.0.1
 */