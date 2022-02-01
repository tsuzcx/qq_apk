package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.au;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class k
  extends au
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(112784);
    info = au.aJm();
    AppMethodBeat.o(112784);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.k
 * JD-Core Version:    0.7.0.1
 */