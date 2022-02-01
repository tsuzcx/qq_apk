package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ek;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class f
  extends ek
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(274559);
    info = ek.aJm();
    AppMethodBeat.o(274559);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.f
 * JD-Core Version:    0.7.0.1
 */