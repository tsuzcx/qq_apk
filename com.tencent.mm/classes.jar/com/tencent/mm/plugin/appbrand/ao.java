package com.tencent.mm.plugin.appbrand;

import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask;
import com.tencent.mm.sdk.platformtools.ac;

public final class ao
{
  static void Hz(String paramString)
  {
    AppMethodBeat.i(180182);
    ((com.tencent.luggage.sdk.customize.a)e.K(com.tencent.luggage.sdk.customize.a.class)).ch(paramString).S(2, paramString);
    AppMethodBeat.o(180182);
  }
  
  public static boolean w(o paramo)
  {
    AppMethodBeat.i(180181);
    if (paramo.aTS().launchMode == 1)
    {
      AppMethodBeat.o(180181);
      return true;
    }
    AppMethodBeat.o(180181);
    return false;
  }
  
  public static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.p
  {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onBottomBannerButtonClicked";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ao
 * JD-Core Version:    0.7.0.1
 */