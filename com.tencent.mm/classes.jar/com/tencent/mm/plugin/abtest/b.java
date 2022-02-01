package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.a.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.s;

public final class b
  extends y
  implements c
{
  private static b jZc;
  private d jZd;
  private a jZe;
  
  private b()
  {
    super(com.tencent.mm.model.a.g.class);
    AppMethodBeat.i(153136);
    this.jZd = new d();
    this.jZe = new a();
    AppMethodBeat.o(153136);
  }
  
  public static b bmZ()
  {
    try
    {
      AppMethodBeat.i(153137);
      if (jZc == null) {
        jZc = new b();
      }
      b localb = jZc;
      AppMethodBeat.o(153137);
      return localb;
    }
    finally {}
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(153138);
    super.onAccountInitialized(paramc);
    h.d.a(Integer.valueOf(-1879048184), this.jZd);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("abtest", this.jZe);
    AppMethodBeat.o(153138);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(153139);
    super.onAccountRelease();
    h.d.a(Integer.valueOf(-1879048184), this.jZd);
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("abtest", this.jZe);
    AppMethodBeat.o(153139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.b
 * JD-Core Version:    0.7.0.1
 */