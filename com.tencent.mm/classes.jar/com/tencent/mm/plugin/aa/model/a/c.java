package com.tencent.mm.plugin.aa.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends b
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(63423);
    info = aJm();
    AppMethodBeat.o(63423);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.a.c
 * JD-Core Version:    0.7.0.1
 */