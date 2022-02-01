package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.storage.bu;

public final class n
  implements v
{
  private final a ifP;
  private h ifQ;
  
  public n()
  {
    AppMethodBeat.i(116833);
    this.ifP = new a((byte)0);
    AppMethodBeat.o(116833);
  }
  
  public final String Q(bu parambu)
  {
    AppMethodBeat.i(116834);
    if (this.ifQ != null)
    {
      parambu = this.ifQ.Q(parambu);
      AppMethodBeat.o(116834);
      return parambu;
    }
    AppMethodBeat.o(116834);
    return null;
  }
  
  public final void a(o.c paramc)
  {
    AppMethodBeat.i(217578);
    o.a(paramc);
    AppMethodBeat.o(217578);
  }
  
  public final void a(h paramh)
  {
    this.ifQ = paramh;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.o paramo)
  {
    AppMethodBeat.i(116835);
    this.ifP.bu(paramo);
    AppMethodBeat.o(116835);
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.o aJt()
  {
    return this.ifP;
  }
  
  static final class a
    extends a<com.tencent.mm.plugin.messenger.foundation.a.o>
    implements com.tencent.mm.plugin.messenger.foundation.a.o
  {
    public final void a(final byy parambyy, final bu parambu)
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