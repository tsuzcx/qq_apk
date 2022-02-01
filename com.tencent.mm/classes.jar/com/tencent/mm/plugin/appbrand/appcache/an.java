package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class an
  extends c<am>
{
  public static final String[] gLs;
  
  static
  {
    AppMethodBeat.i(90566);
    gLs = new String[] { j.getCreateSQLs(am.gLr, "PushWxaPkgDecryptKeyTable") };
    AppMethodBeat.o(90566);
  }
  
  public an(e parame)
  {
    super(parame, am.gLr, "PushWxaPkgDecryptKeyTable", am.INDEX_CREATE);
  }
  
  public final am aE(String paramString, int paramInt)
  {
    AppMethodBeat.i(90565);
    am localam = new am();
    localam.field_appId = paramString;
    localam.field_appVersion = paramInt;
    if (get(localam, new String[0]))
    {
      AppMethodBeat.o(90565);
      return localam;
    }
    AppMethodBeat.o(90565);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.an
 * JD-Core Version:    0.7.0.1
 */