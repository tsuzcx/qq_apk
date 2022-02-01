package com.tencent.mm.message.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fq;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends fq
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(233928);
    info = fq.aJm();
    AppMethodBeat.o(233928);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.message.b.c
 * JD-Core Version:    0.7.0.1
 */