package com.tencent.mm.plugin.appbrand.task.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.jf;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class b
  extends jf
{
  static final IAutoDBItem.MAutoDBInfo DB_INFO;
  
  static
  {
    AppMethodBeat.i(318616);
    DB_INFO = jf.aJm();
    AppMethodBeat.o(318616);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a.b
 * JD-Core Version:    0.7.0.1
 */