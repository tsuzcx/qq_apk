package com.tencent.mm.plugin.appbrand.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.jn;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends jn
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(45095);
    info = jn.aJm();
    AppMethodBeat.o(45095);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */