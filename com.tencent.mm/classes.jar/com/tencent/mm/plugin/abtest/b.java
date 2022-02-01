package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.a.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.v;

public final class b
  extends y
  implements c
{
  private static b pNb;
  private d pNc;
  private a pNd;
  
  private b()
  {
    super(g.class);
    AppMethodBeat.i(153136);
    this.pNc = new d();
    this.pNd = new a();
    AppMethodBeat.o(153136);
  }
  
  public static b bVX()
  {
    try
    {
      AppMethodBeat.i(153137);
      if (pNb == null) {
        pNb = new b();
      }
      b localb = pNb;
      AppMethodBeat.o(153137);
      return localb;
    }
    finally {}
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(153138);
    super.onAccountInitialized(paramc);
    g.d.a(Integer.valueOf(-1879048184), this.pNc);
    ((v)h.az(v.class)).getSysCmdMsgExtension().a("abtest", this.pNd);
    AppMethodBeat.o(153138);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(153139);
    super.onAccountRelease();
    g.d.a(Integer.valueOf(-1879048184), this.pNc);
    ((v)h.az(v.class)).getSysCmdMsgExtension().b("abtest", this.pNd);
    AppMethodBeat.o(153139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.b
 * JD-Core Version:    0.7.0.1
 */