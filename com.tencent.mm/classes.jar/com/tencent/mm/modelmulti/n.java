package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.co.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.storage.ca;

public final class n
  implements w
{
  private final a jdD;
  private h jdE;
  
  public n()
  {
    AppMethodBeat.i(116833);
    this.jdD = new a((byte)0);
    AppMethodBeat.o(116833);
  }
  
  public final String Z(ca paramca)
  {
    AppMethodBeat.i(116834);
    if (this.jdE != null)
    {
      paramca = this.jdE.Z(paramca);
      AppMethodBeat.o(116834);
      return paramca;
    }
    AppMethodBeat.o(116834);
    return null;
  }
  
  public final void a(o.c paramc)
  {
    AppMethodBeat.i(187477);
    o.a(paramc);
    AppMethodBeat.o(187477);
  }
  
  public final void a(h paramh)
  {
    this.jdE = paramh;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.o paramo)
  {
    AppMethodBeat.i(116835);
    this.jdD.add(paramo);
    AppMethodBeat.o(116835);
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.o bdO()
  {
    return this.jdD;
  }
  
  static final class a
    extends a<com.tencent.mm.plugin.messenger.foundation.a.o>
    implements com.tencent.mm.plugin.messenger.foundation.a.o
  {
    public final void a(final cot paramcot, final ca paramca)
    {
      AppMethodBeat.i(116832);
      a(new a.a() {});
      AppMethodBeat.o(116832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.n
 * JD-Core Version:    0.7.0.1
 */