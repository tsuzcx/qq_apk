package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.storage.bi;

public final class m
  implements q
{
  private final m.a fJp;
  private g fJq;
  
  public m()
  {
    AppMethodBeat.i(980);
    this.fJp = new m.a((byte)0);
    AppMethodBeat.o(980);
  }
  
  public final String B(bi parambi)
  {
    AppMethodBeat.i(981);
    if (this.fJq != null)
    {
      parambi = this.fJq.B(parambi);
      AppMethodBeat.o(981);
      return parambi;
    }
    AppMethodBeat.o(981);
    return null;
  }
  
  public final void a(g paramg)
  {
    this.fJq = paramg;
  }
  
  public final void a(com.tencent.mm.plugin.messenger.foundation.a.m paramm)
  {
    AppMethodBeat.i(982);
    this.fJp.at(paramm);
    AppMethodBeat.o(982);
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.m aim()
  {
    return this.fJp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.m
 * JD-Core Version:    0.7.0.1
 */