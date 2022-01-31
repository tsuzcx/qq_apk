package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ab
  extends j<aa>
{
  public static final String[] fkl;
  
  static
  {
    AppMethodBeat.i(129408);
    fkl = new String[] { j.getCreateSQLs(aa.gUb, "PkgUpdateStats") };
    AppMethodBeat.o(129408);
  }
  
  public ab(e parame)
  {
    super(parame, aa.gUb, "PkgUpdateStats", aa.INDEX_CREATE);
  }
  
  final boolean ap(String paramString, int paramInt)
  {
    AppMethodBeat.i(129407);
    aa localaa = new aa();
    localaa.field_key = paramString;
    localaa.field_version = paramInt;
    boolean bool = super.delete(localaa, aa.gUa);
    AppMethodBeat.o(129407);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab
 * JD-Core Version:    0.7.0.1
 */