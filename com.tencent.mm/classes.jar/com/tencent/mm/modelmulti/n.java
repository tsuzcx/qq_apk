package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.storage.bv;

public final class n
  implements w
{
  private final a iiI;
  private h iiJ;
  
  public n()
  {
    AppMethodBeat.i(116833);
    this.iiI = new a((byte)0);
    AppMethodBeat.o(116833);
  }
  
  public final String Q(bv parambv)
  {
    AppMethodBeat.i(116834);
    if (this.iiJ != null)
    {
      parambv = this.iiJ.Q(parambv);
      AppMethodBeat.o(116834);
      return parambv;
    }
    AppMethodBeat.o(116834);
    return null;
  }
  
  public final void a(o.c paramc)
  {
    AppMethodBeat.i(211747);
    o.a(paramc);
    AppMethodBeat.o(211747);
  }
  
  public final void a(h paramh)
  {
    this.iiJ = paramh;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.o paramo)
  {
    AppMethodBeat.i(116835);
    this.iiI.bu(paramo);
    AppMethodBeat.o(116835);
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.o aJM()
  {
    return this.iiI;
  }
  
  static final class a
    extends a<com.tencent.mm.plugin.messenger.foundation.a.o>
    implements com.tencent.mm.plugin.messenger.foundation.a.o
  {
    public final void a(final bzs parambzs, final bv parambv)
    {
      AppMethodBeat.i(116832);
      a(new a.a() {});
      AppMethodBeat.o(116832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.n
 * JD-Core Version:    0.7.0.1
 */