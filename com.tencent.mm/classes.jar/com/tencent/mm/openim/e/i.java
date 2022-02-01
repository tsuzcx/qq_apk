package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fy;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class i
  extends fy
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(235743);
    info = fy.aJm();
    AppMethodBeat.o(235743);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.e.i
 * JD-Core Version:    0.7.0.1
 */