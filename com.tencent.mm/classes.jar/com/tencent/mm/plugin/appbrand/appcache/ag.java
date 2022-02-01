package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ag
  extends j<af>
{
  public static final String[] gLs;
  final e db;
  
  static
  {
    AppMethodBeat.i(44317);
    gLs = new String[] { j.getCreateSQLs(af.iMP, "PkgUsageLRURecord") };
    AppMethodBeat.o(44317);
  }
  
  public ag(e parame)
  {
    super(parame, af.iMP, "PkgUsageLRURecord", af.INDEX_CREATE);
    this.db = parame;
  }
  
  public final void aD(String paramString, int paramInt)
  {
    AppMethodBeat.i(44316);
    af localaf = new af();
    localaf.field_appId = paramString;
    localaf.field_type = paramInt;
    super.delete(localaf, af.iLd);
    AppMethodBeat.o(44316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ag
 * JD-Core Version:    0.7.0.1
 */