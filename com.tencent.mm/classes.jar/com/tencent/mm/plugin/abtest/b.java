package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.a.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.q;

public final class b
  extends t
  implements c
{
  private static b ieO;
  private d ieP;
  private a ieQ;
  
  private b()
  {
    super(com.tencent.mm.model.a.g.class);
    AppMethodBeat.i(153136);
    this.ieP = new d();
    this.ieQ = new a();
    AppMethodBeat.o(153136);
  }
  
  public static b aHK()
  {
    try
    {
      AppMethodBeat.i(153137);
      if (ieO == null) {
        ieO = new b();
      }
      b localb = ieO;
      AppMethodBeat.o(153137);
      return localb;
    }
    finally {}
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(153138);
    super.onAccountInitialized(paramc);
    f.d.a(Integer.valueOf(-1879048184), this.ieP);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("abtest", this.ieQ);
    AppMethodBeat.o(153138);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(153139);
    super.onAccountRelease();
    f.d.a(Integer.valueOf(-1879048184), this.ieP);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("abtest", this.ieQ);
    AppMethodBeat.o(153139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.b
 * JD-Core Version:    0.7.0.1
 */