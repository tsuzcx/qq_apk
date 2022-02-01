package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class aj
  extends j<al>
{
  public static final String[] hGX;
  final e db;
  
  static
  {
    AppMethodBeat.i(44319);
    hGX = new String[] { j.getCreateSQLs(al.jJU, "PluginCodeUsageLRURecord") };
    AppMethodBeat.o(44319);
  }
  
  public aj(e parame)
  {
    super(parame, al.jJU, "PluginCodeUsageLRURecord", al.INDEX_CREATE);
    this.db = parame;
  }
  
  public final void aM(String paramString, int paramInt)
  {
    AppMethodBeat.i(44318);
    al localal = new al();
    localal.field_appId = paramString;
    localal.field_version = paramInt;
    super.delete(localal, al.jHZ);
    AppMethodBeat.o(44318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj
 * JD-Core Version:    0.7.0.1
 */