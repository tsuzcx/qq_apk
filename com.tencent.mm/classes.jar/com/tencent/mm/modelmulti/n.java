package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.co.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.storage.bl;

public final class n
  implements t
{
  private final a hms;
  private g hmt;
  
  public n()
  {
    AppMethodBeat.i(116833);
    this.hms = new a((byte)0);
    AppMethodBeat.o(116833);
  }
  
  public final String N(bl parambl)
  {
    AppMethodBeat.i(116834);
    if (this.hmt != null)
    {
      parambl = this.hmt.N(parambl);
      AppMethodBeat.o(116834);
      return parambl;
    }
    AppMethodBeat.o(116834);
    return null;
  }
  
  public final void a(g paramg)
  {
    this.hmt = paramg;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.n paramn)
  {
    AppMethodBeat.i(116835);
    this.hms.bv(paramn);
    AppMethodBeat.o(116835);
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.n azt()
  {
    return this.hms;
  }
  
  static final class a
    extends a<com.tencent.mm.plugin.messenger.foundation.a.n>
    implements com.tencent.mm.plugin.messenger.foundation.a.n
  {
    public final void a(final bps parambps, final bl parambl)
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