package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class ao
  extends c<an>
{
  public static final String[] hEf;
  
  static
  {
    AppMethodBeat.i(90566);
    hEf = new String[] { j.getCreateSQLs(an.hEe, "PushWxaPkgDecryptKeyTable") };
    AppMethodBeat.o(90566);
  }
  
  public ao(e parame)
  {
    super(parame, an.hEe, "PushWxaPkgDecryptKeyTable", an.INDEX_CREATE);
  }
  
  public final an aK(String paramString, int paramInt)
  {
    AppMethodBeat.i(90565);
    an localan = new an();
    localan.field_appId = paramString;
    localan.field_appVersion = paramInt;
    if (get(localan, new String[0]))
    {
      AppMethodBeat.o(90565);
      return localan;
    }
    AppMethodBeat.o(90565);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ao
 * JD-Core Version:    0.7.0.1
 */