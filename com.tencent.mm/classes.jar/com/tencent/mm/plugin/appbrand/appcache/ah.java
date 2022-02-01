package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ah
  extends j<ag>
{
  public static final String[] hEf;
  final e db;
  
  static
  {
    AppMethodBeat.i(44317);
    hEf = new String[] { j.getCreateSQLs(ag.jGU, "PkgUsageLRURecord") };
    AppMethodBeat.o(44317);
  }
  
  public ah(e parame)
  {
    super(parame, ag.jGU, "PkgUsageLRURecord", ag.INDEX_CREATE);
    this.db = parame;
  }
  
  public final void aJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(44316);
    ag localag = new ag();
    localag.field_appId = paramString;
    localag.field_type = paramInt;
    super.delete(localag, ag.jFa);
    AppMethodBeat.o(44316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ah
 * JD-Core Version:    0.7.0.1
 */