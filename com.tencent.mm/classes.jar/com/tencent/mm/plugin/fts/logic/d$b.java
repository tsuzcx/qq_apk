package com.tencent.mm.plugin.fts.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$b
  extends com.tencent.mm.plugin.fts.a.a.c
{
  private long lul;
  
  public d$b(d paramd, long paramLong)
  {
    this.lul = paramLong;
  }
  
  public final boolean aXz()
  {
    AppMethodBeat.i(52722);
    d.b(this.HvO).c(com.tencent.mm.plugin.fts.a.c.Hra, this.lul);
    AppMethodBeat.o(52722);
    return true;
  }
  
  public final String coz()
  {
    AppMethodBeat.i(52723);
    String str = String.format("{MsgId: %d}", new Object[] { Long.valueOf(this.lul) });
    AppMethodBeat.o(52723);
    return str;
  }
  
  public final String getName()
  {
    return "DeleteMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.logic.d.b
 * JD-Core Version:    0.7.0.1
 */