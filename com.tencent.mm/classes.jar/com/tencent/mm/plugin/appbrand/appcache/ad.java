package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ad
  extends j<ac>
{
  public static final String[] fkl;
  final e db;
  
  static
  {
    AppMethodBeat.i(129411);
    fkl = new String[] { j.getCreateSQLs(ac.gUb, "PkgUsageLRURecord") };
    AppMethodBeat.o(129411);
  }
  
  public ad(e parame)
  {
    super(parame, ac.gUb, "PkgUsageLRURecord", ac.INDEX_CREATE);
    this.db = parame;
  }
  
  public final void an(String paramString, int paramInt)
  {
    AppMethodBeat.i(129410);
    ac localac = new ac();
    localac.field_appId = paramString;
    localac.field_type = paramInt;
    super.delete(localac, ac.gUa);
    AppMethodBeat.o(129410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad
 * JD-Core Version:    0.7.0.1
 */