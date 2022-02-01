package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ae
  extends j<ad>
{
  public static final String[] gLs;
  
  static
  {
    AppMethodBeat.i(44314);
    gLs = new String[] { j.getCreateSQLs(ad.iMP, "PkgUpdateStats") };
    AppMethodBeat.o(44314);
  }
  
  public ae(e parame)
  {
    super(parame, ad.iMP, "PkgUpdateStats", ad.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ae
 * JD-Core Version:    0.7.0.1
 */