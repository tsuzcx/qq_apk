package com.tencent.mm.plugin.ai.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.iv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class j
  extends iv
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(267377);
    info = iv.aJm();
    AppMethodBeat.o(267377);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.j
 * JD-Core Version:    0.7.0.1
 */