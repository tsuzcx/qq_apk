package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bz;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class e
  extends bz
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(103368);
    info = bz.aJm();
    AppMethodBeat.o(103368);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.e
 * JD-Core Version:    0.7.0.1
 */