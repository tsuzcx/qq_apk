package com.tencent.mm.message.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.jk;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class d
  extends jk
{
  public static IAutoDBItem.MAutoDBInfo nVV;
  
  static
  {
    AppMethodBeat.i(2616);
    nVV = aJm();
    AppMethodBeat.o(2616);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.message.c.d
 * JD-Core Version:    0.7.0.1
 */