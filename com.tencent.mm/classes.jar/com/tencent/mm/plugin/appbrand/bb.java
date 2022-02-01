package com.tencent.mm.plugin.appbrand;

import com.tencent.f.i;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiClearStorageTask;
import com.tencent.mm.sdk.platformtools.Log;

public final class bb
{
  static void Uv(String paramString)
  {
    AppMethodBeat.i(180182);
    ((com.tencent.luggage.sdk.customize.a)e.M(com.tencent.luggage.sdk.customize.a.class)).dD(paramString).Y(2, paramString);
    AppMethodBeat.o(180182);
  }
  
  public static boolean r(q paramq)
  {
    AppMethodBeat.i(180181);
    if (paramq.bsC().launchMode == 1)
    {
      AppMethodBeat.o(180181);
      return true;
    }
    AppMethodBeat.o(180181);
    return false;
  }
  
  public static final class a
    extends s
  {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onBottomBannerButtonClicked";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bb
 * JD-Core Version:    0.7.0.1
 */