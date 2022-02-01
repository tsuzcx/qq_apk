package com.tencent.mm.plugin.exdevice.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.eg;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class b
  extends eg
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(23552);
    info = eg.aJm();
    AppMethodBeat.o(23552);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.b.a.b
 * JD-Core Version:    0.7.0.1
 */