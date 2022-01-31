package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.a.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.p;

public final class b
  extends q
  implements c
{
  private static b grO;
  private d grP;
  private a grQ;
  
  private b()
  {
    super(com.tencent.mm.model.a.g.class);
    AppMethodBeat.i(118188);
    this.grP = new d();
    this.grQ = new a();
    AppMethodBeat.o(118188);
  }
  
  public static b apo()
  {
    try
    {
      AppMethodBeat.i(118189);
      if (grO == null) {
        grO = new b();
      }
      b localb = grO;
      AppMethodBeat.o(118189);
      return localb;
    }
    finally {}
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(118190);
    super.onAccountInitialized(paramc);
    e.d.a(Integer.valueOf(-1879048184), this.grP);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("abtest", this.grQ);
    AppMethodBeat.o(118190);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(118191);
    super.onAccountRelease();
    e.d.a(Integer.valueOf(-1879048184), this.grP);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("abtest", this.grQ);
    AppMethodBeat.o(118191);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.b
 * JD-Core Version:    0.7.0.1
 */