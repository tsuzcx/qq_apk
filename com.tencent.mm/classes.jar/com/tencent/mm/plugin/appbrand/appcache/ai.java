package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ai
  extends j<ah>
{
  public static final String[] hGX;
  final e db;
  
  static
  {
    AppMethodBeat.i(44317);
    hGX = new String[] { j.getCreateSQLs(ah.jJU, "PkgUsageLRURecord") };
    AppMethodBeat.o(44317);
  }
  
  public ai(e parame)
  {
    super(parame, ah.jJU, "PkgUsageLRURecord", ah.INDEX_CREATE);
    this.db = parame;
  }
  
  public final void aM(String paramString, int paramInt)
  {
    AppMethodBeat.i(44316);
    ah localah = new ah();
    localah.field_appId = paramString;
    localah.field_type = paramInt;
    super.delete(localah, ah.jHZ);
    AppMethodBeat.o(44316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ai
 * JD-Core Version:    0.7.0.1
 */