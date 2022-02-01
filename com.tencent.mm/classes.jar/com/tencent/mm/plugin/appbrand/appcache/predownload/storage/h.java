package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gf;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class h
  extends gf
{
  static final IAutoDBItem.MAutoDBInfo DB_INFO;
  
  static
  {
    AppMethodBeat.i(320428);
    DB_INFO = gf.aJm();
    AppMethodBeat.o(320428);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.storage.h
 * JD-Core Version:    0.7.0.1
 */