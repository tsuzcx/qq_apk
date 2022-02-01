package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ex;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class p
  extends ex
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO;
  
  static
  {
    AppMethodBeat.i(76410);
    DB_INFO = ex.aJm();
    AppMethodBeat.o(76410);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.p
 * JD-Core Version:    0.7.0.1
 */