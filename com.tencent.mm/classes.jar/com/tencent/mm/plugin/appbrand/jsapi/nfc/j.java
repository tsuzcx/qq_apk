package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "makeReturnJson", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "errCode", "", "errMsg", "errInfoMap", "", "", "luggage-commons-jsapi-nfc-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final String a(p paramp, int paramInt, String paramString, Map<String, ? extends Object> paramMap)
  {
    AppMethodBeat.i(328027);
    s.u(paramp, "<this>");
    s.u(paramString, "errMsg");
    Object localObject = i.skJ;
    localObject = i.AT(paramInt);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrand.NFCErrnoMigrationLogic", "makeReturnJson, errCode: " + paramInt + ", errInfo is null");
      paramp = paramp.m(paramString, paramMap);
      s.s(paramp, "makeReturnJson(errMsg, errInfoMap)");
      AppMethodBeat.o(328027);
      return paramp;
    }
    paramp = paramp.a(paramString, (a.d)localObject, paramMap);
    s.s(paramp, "makeReturnJson(errMsg, errInfo, errInfoMap)");
    AppMethodBeat.o(328027);
    return paramp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.j
 * JD-Core Version:    0.7.0.1
 */