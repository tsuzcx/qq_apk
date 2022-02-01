package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.aj;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class f
  extends aj
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(124242);
    info = aj.aJm();
    AppMethodBeat.o(124242);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.f
 * JD-Core Version:    0.7.0.1
 */