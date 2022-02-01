package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;

final class c$b
  extends a
{
  private long fIR;
  
  public c$b(c paramc, long paramLong)
  {
    this.fIR = paramLong;
  }
  
  public final String bhC()
  {
    AppMethodBeat.i(52723);
    String str = String.format("{MsgId: %d}", new Object[] { Long.valueOf(this.fIR) });
    AppMethodBeat.o(52723);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(52722);
    this.tHX.tHR.c(com.tencent.mm.plugin.fts.a.c.tDD, this.fIR);
    AppMethodBeat.o(52722);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.b
 * JD-Core Version:    0.7.0.1
 */