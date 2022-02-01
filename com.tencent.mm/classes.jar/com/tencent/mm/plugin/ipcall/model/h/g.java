package com.tencent.mm.plugin.ipcall.model.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.en;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class g
  extends en
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(25548);
    info = en.aJm();
    AppMethodBeat.o(25548);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.g
 * JD-Core Version:    0.7.0.1
 */