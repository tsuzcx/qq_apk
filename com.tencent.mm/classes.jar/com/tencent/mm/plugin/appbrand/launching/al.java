package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ev;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class al
  extends ev
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO;
  
  static
  {
    AppMethodBeat.i(146070);
    DB_INFO = ev.aJm();
    AppMethodBeat.o(146070);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.al
 * JD-Core Version:    0.7.0.1
 */