package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.m;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class d
  extends m
{
  public static final IAutoDBItem.MAutoDBInfo nVV;
  
  static
  {
    AppMethodBeat.i(146955);
    nVV = m.aJm();
    AppMethodBeat.o(146955);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.d
 * JD-Core Version:    0.7.0.1
 */