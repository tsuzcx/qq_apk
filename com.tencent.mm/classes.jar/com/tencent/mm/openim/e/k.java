package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fz;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class k
  extends fz
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(151334);
    info = fz.aJm();
    AppMethodBeat.o(151334);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.e.k
 * JD-Core Version:    0.7.0.1
 */