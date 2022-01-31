package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class f
  extends j<h>
{
  public static final String[] fkl;
  final e db;
  
  static
  {
    AppMethodBeat.i(129326);
    fkl = new String[] { j.getCreateSQLs(h.gUb, "CodeLibUsageLRURecord") };
    AppMethodBeat.o(129326);
  }
  
  public f(e parame)
  {
    super(parame, h.gUb, "CodeLibUsageLRURecord", h.INDEX_CREATE);
    this.db = parame;
  }
  
  public final void an(String paramString, int paramInt)
  {
    AppMethodBeat.i(129325);
    h localh = new h();
    localh.field_appId = paramString;
    localh.field_version = paramInt;
    super.delete(localh, h.gUa);
    AppMethodBeat.o(129325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.f
 * JD-Core Version:    0.7.0.1
 */