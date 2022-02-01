package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.a;
import com.tencent.mm.cw.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.storage.ca;

public final class n
  implements aa
{
  private final a lUc;
  private j lUd;
  
  public n()
  {
    AppMethodBeat.i(116833);
    this.lUc = new a((byte)0);
    AppMethodBeat.o(116833);
  }
  
  public final void a(o.c paramc)
  {
    AppMethodBeat.i(188346);
    o.a(paramc);
    AppMethodBeat.o(188346);
  }
  
  public final void a(j paramj)
  {
    this.lUd = paramj;
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(116835);
    this.lUc.add(paramq);
    AppMethodBeat.o(116835);
  }
  
  public final String af(ca paramca)
  {
    AppMethodBeat.i(116834);
    if (this.lUd != null)
    {
      paramca = this.lUd.af(paramca);
      AppMethodBeat.o(116834);
      return paramca;
    }
    AppMethodBeat.o(116834);
    return null;
  }
  
  public final q bnj()
  {
    return this.lUc;
  }
  
  static final class a
    extends a<q>
    implements q
  {
    public final void a(final cxi paramcxi, final ca paramca)
    {
      AppMethodBeat.i(116832);
      a(new a.a() {});
      AppMethodBeat.o(116832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.n
 * JD-Core Version:    0.7.0.1
 */