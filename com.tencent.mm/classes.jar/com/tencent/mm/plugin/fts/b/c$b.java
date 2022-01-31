package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;

final class c$b
  extends a
{
  private long eaY;
  
  public c$b(c paramc, long paramLong)
  {
    this.eaY = paramLong;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136749);
    String str = String.format("{MsgId: %d}", new Object[] { Long.valueOf(this.eaY) });
    AppMethodBeat.o(136749);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136748);
    this.mUU.mUM.c(com.tencent.mm.plugin.fts.a.c.mQA, this.eaY);
    AppMethodBeat.o(136748);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteMessageTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.c.b
 * JD-Core Version:    0.7.0.1
 */