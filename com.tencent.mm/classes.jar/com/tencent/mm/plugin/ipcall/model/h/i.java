package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.eo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class i
  extends eo
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(25551);
    info = eo.aJm();
    AppMethodBeat.o(25551);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.i
 * JD-Core Version:    0.7.0.1
 */