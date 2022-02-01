package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ep;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class k
  extends ep
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(25557);
    info = ep.aJm();
    AppMethodBeat.o(25557);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.k
 * JD-Core Version:    0.7.0.1
 */