package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.a.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.s;

public final class b
  extends u
  implements c
{
  private static b jaZ;
  private d jba;
  private a jbb;
  
  private b()
  {
    super(com.tencent.mm.model.a.g.class);
    AppMethodBeat.i(153136);
    this.jba = new d();
    this.jbb = new a();
    AppMethodBeat.o(153136);
  }
  
  public static b aSm()
  {
    try
    {
      AppMethodBeat.i(153137);
      if (jaZ == null) {
        jaZ = new b();
      }
      b localb = jaZ;
      AppMethodBeat.o(153137);
      return localb;
    }
    finally {}
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(153138);
    super.onAccountInitialized(paramc);
    e.d.a(Integer.valueOf(-1879048184), this.jba);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("abtest", this.jbb);
    AppMethodBeat.o(153138);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(153139);
    super.onAccountRelease();
    e.d.a(Integer.valueOf(-1879048184), this.jba);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("abtest", this.jbb);
    AppMethodBeat.o(153139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.b
 * JD-Core Version:    0.7.0.1
 */