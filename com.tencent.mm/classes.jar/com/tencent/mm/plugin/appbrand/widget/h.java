package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bi;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class h
  extends bi
{
  public static IAutoDBItem.MAutoDBInfo nVV;
  
  static
  {
    AppMethodBeat.i(76398);
    nVV = bi.aJm();
    AppMethodBeat.o(76398);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h
 * JD-Core Version:    0.7.0.1
 */