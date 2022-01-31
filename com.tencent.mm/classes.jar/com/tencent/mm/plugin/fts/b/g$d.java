package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fts.a.a.a;

final class g$d
  extends a
{
  private g$d(g paramg) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(136801);
    com.tencent.mm.kernel.g.RL().eHS.execSQL(null, "UPDATE rconversation SET unReadCount = 0;");
    AppMethodBeat.o(136801);
    return true;
  }
  
  public final String getName()
  {
    return "FTSClearUnReadCountTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.g.d
 * JD-Core Version:    0.7.0.1
 */