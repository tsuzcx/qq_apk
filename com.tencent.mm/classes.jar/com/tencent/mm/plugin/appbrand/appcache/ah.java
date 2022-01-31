package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public class ah
  extends c<ag>
{
  public static final String[] fkl;
  
  static
  {
    AppMethodBeat.i(59453);
    fkl = new String[] { j.getCreateSQLs(ag.fkk, "PushWxaPkgDecryptKeyTable") };
    AppMethodBeat.o(59453);
  }
  
  public ah(e parame)
  {
    super(parame, ag.fkk, "PushWxaPkgDecryptKeyTable", ag.INDEX_CREATE);
  }
  
  public final ag aq(String paramString, int paramInt)
  {
    AppMethodBeat.i(59452);
    ag localag = new ag();
    localag.field_appId = paramString;
    localag.field_appVersion = paramInt;
    if (get(localag, new String[0]))
    {
      AppMethodBeat.o(59452);
      return localag;
    }
    AppMethodBeat.o(59452);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ah
 * JD-Core Version:    0.7.0.1
 */