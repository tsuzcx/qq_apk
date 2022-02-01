package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fk;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class f
  extends fk
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(151162);
    info = fk.aJm();
    AppMethodBeat.o(151162);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bc.f
 * JD-Core Version:    0.7.0.1
 */