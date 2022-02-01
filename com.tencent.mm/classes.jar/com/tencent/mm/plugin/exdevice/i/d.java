package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ej;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class d
  extends ej
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(274558);
    info = ej.aJm();
    AppMethodBeat.o(274558);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.d
 * JD-Core Version:    0.7.0.1
 */