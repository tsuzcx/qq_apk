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

public final class v$a
  implements bz.a
{
  private static final a hcm;
  
  static
  {
    AppMethodBeat.i(129671);
    hcm = new a();
    AppMethodBeat.o(129671);
  }
  
  public static void uD()
  {
    AppMethodBeat.i(129667);
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", hcm, true);
    AppMethodBeat.o(129667);
  }
  
  public static void unregister()
  {
    AppMethodBeat.i(129668);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", hcm, true);
    AppMethodBeat.o(129668);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(129669);
    parama = aa.a(parama.eyJ.woR);
    if (bo.isNullOrNil(parama))
    {
      AppMethodBeat.o(129669);
      return;
    }
    e.aNS().ac(new v.a.1(this, parama));
    AppMethodBeat.o(129669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.v.a
 * JD-Core Version:    0.7.0.1
 */