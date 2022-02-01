package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ah
  extends j<aj>
{
  public static final String[] hlS;
  final e db;
  
  static
  {
    AppMethodBeat.i(44319);
    hlS = new String[] { j.getCreateSQLs(aj.jmW, "PluginCodeUsageLRURecord") };
    AppMethodBeat.o(44319);
  }
  
  public ah(e parame)
  {
    super(parame, aj.jmW, "PluginCodeUsageLRURecord", aj.INDEX_CREATE);
    this.db = parame;
  }
  
  public final void aH(String paramString, int paramInt)
  {
    AppMethodBeat.i(44318);
    aj localaj = new aj();
    localaj.field_appId = paramString;
    localaj.field_version = paramInt;
    super.delete(localaj, aj.jlk);
    AppMethodBeat.o(44318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ah
 * JD-Core Version:    0.7.0.1
 */