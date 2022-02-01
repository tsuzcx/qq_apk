package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.storage.bo;

public final class n
  implements t
{
  private final a hMV;
  private g hMW;
  
  public n()
  {
    AppMethodBeat.i(116833);
    this.hMV = new a((byte)0);
    AppMethodBeat.o(116833);
  }
  
  public final String N(bo parambo)
  {
    AppMethodBeat.i(116834);
    if (this.hMW != null)
    {
      parambo = this.hMW.N(parambo);
      AppMethodBeat.o(116834);
      return parambo;
    }
    AppMethodBeat.o(116834);
    return null;
  }
  
  public final void a(g paramg)
  {
    this.hMW = paramg;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.n paramn)
  {
    AppMethodBeat.i(116835);
    this.hMV.bs(paramn);
    AppMethodBeat.o(116835);
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.n aGk()
  {
    return this.hMV;
  }
  
  static final class a
    extends a<com.tencent.mm.plugin.messenger.foundation.a.n>
    implements com.tencent.mm.plugin.messenger.foundation.a.n
  {
    public final void a(final buj parambuj, final bo parambo)
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