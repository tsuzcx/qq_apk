package com.tencent.mm.plugin.finder.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public final void aXv()
  {
    AppMethodBeat.i(330985);
    if (aXw()) {
      aG(-400L, 6L);
    }
    AppMethodBeat.o(330985);
  }
  
  public final boolean aXw()
  {
    AppMethodBeat.i(331008);
    if (!iV(-400, 6))
    {
      AppMethodBeat.o(331008);
      return true;
    }
    AppMethodBeat.o(331008);
    return false;
  }
  
  public final String getName()
  {
    return "FTS5FinderFollowerStorage";
  }
  
  public final int getPriority()
  {
    return 1792;
  }
  
  public final String getTableName()
  {
    return "FinderFollow";
  }
  
  public final int getType()
  {
    return 1792;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.fts.a
 * JD-Core Version:    0.7.0.1
 */