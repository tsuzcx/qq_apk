package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.x.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class ap
  extends c<ao>
{
  public static final String[] hGX;
  
  static
  {
    AppMethodBeat.i(90566);
    hGX = new String[] { j.getCreateSQLs(ao.hGW, "PushWxaPkgDecryptKeyTable") };
    AppMethodBeat.o(90566);
  }
  
  public ap(e parame)
  {
    super(parame, ao.hGW, "PushWxaPkgDecryptKeyTable", ao.INDEX_CREATE);
  }
  
  public final ao aN(String paramString, int paramInt)
  {
    AppMethodBeat.i(90565);
    ao localao = new ao();
    localao.field_appId = paramString;
    localao.field_appVersion = paramInt;
    if (get(localao, new String[0]))
    {
      AppMethodBeat.o(90565);
      return localao;
    }
    AppMethodBeat.o(90565);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ap
 * JD-Core Version:    0.7.0.1
 */