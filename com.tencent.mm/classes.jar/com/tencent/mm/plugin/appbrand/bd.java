package com.tencent.mm.plugin.appbrand;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class bd
{
  public static void a(t paramt, String paramString)
  {
    AppMethodBeat.i(282887);
    a locala = new a();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("currentPath", paramString);
    locala.D(localHashMap).i(paramt.bDA()).bPO();
    AppMethodBeat.o(282887);
  }
  
  static void acf(String paramString)
  {
    AppMethodBeat.i(180182);
    ((com.tencent.luggage.sdk.customize.a)e.K(com.tencent.luggage.sdk.customize.a.class)).dX(paramString).aa(2, paramString);
    AppMethodBeat.o(180182);
  }
  
  public static boolean s(t paramt)
  {
    AppMethodBeat.i(180181);
    if (paramt.bDy().launchMode == 1)
    {
      AppMethodBeat.o(180181);
      return true;
    }
    AppMethodBeat.o(180181);
    return false;
  }
  
  public static final class a
    extends r
  {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onBottomBannerButtonClicked";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bd
 * JD-Core Version:    0.7.0.1
 */