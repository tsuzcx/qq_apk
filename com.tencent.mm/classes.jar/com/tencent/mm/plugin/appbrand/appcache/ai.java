package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ai
  extends j<ak>
{
  public static final String[] hEf;
  final e db;
  
  static
  {
    AppMethodBeat.i(44319);
    hEf = new String[] { j.getCreateSQLs(ak.jGU, "PluginCodeUsageLRURecord") };
    AppMethodBeat.o(44319);
  }
  
  public ai(e parame)
  {
    super(parame, ak.jGU, "PluginCodeUsageLRURecord", ak.INDEX_CREATE);
    this.db = parame;
  }
  
  public final void aJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(44318);
    ak localak = new ak();
    localak.field_appId = paramString;
    localak.field_version = paramInt;
    super.delete(localak, ak.jFa);
    AppMethodBeat.o(44318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai
 * JD-Core Version:    0.7.0.1
 */