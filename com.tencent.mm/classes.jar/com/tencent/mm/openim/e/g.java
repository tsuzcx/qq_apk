package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fw;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class g
  extends fw
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(235755);
    info = fw.aJm();
    AppMethodBeat.o(235755);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.e.g
 * JD-Core Version:    0.7.0.1
 */