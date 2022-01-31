package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.fts.a.a
{
  public final void Pn()
  {
    AppMethodBeat.i(130063);
    if (Po()) {
      M(-108L, 1L);
    }
    AppMethodBeat.o(130063);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(130064);
    if (!er(-108, 1))
    {
      AppMethodBeat.o(130064);
      return true;
    }
    AppMethodBeat.o(130064);
    return false;
  }
  
  public final String getName()
  {
    return "FTS5MiniGameStorage";
  }
  
  public final int getPriority()
  {
    return 8;
  }
  
  public final String getTableName()
  {
    return "MiniGame";
  }
  
  public final int getType()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a
 * JD-Core Version:    0.7.0.1
 */