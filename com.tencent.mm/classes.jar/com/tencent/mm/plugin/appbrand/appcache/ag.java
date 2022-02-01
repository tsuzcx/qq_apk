package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class ag
  extends j<af>
{
  public static final String[] hGX;
  
  static
  {
    AppMethodBeat.i(44314);
    hGX = new String[] { j.getCreateSQLs(af.jJU, "PkgUpdateStats") };
    AppMethodBeat.o(44314);
  }
  
  public ag(e parame)
  {
    super(parame, af.jJU, "PkgUpdateStats", af.INDEX_CREATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ag
 * JD-Core Version:    0.7.0.1
 */