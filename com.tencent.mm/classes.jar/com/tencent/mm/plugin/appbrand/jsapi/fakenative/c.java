package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class c
  extends g
{
  public final void a(k paramk, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46283);
    String str1 = p.Um(paramk.getRuntime().mAppId).kCY;
    Log.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back miniprogram, businessType:%s", new Object[] { str1 });
    if (!Util.isNullOrNil(str1))
    {
      String str2 = paramJSONObject.optString("extraData");
      Log.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back MiniProgram, businessType:%s", new Object[] { str1 });
      OpenBusinessViewUtil.x(str1, f.lUw.errCode, str2);
      p.Un(paramk.getAppId()).kDb = true;
    }
    OpenBusinessViewUtil.A((q)paramk.getRuntime());
    super.a(paramk, paramJSONObject, paramInt);
    AppMethodBeat.o(46283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.c
 * JD-Core Version:    0.7.0.1
 */