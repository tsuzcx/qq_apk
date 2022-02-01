package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public final class c
  extends f
{
  public final void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46283);
    String str1 = n.Hr(paramh.getRuntime().mAppId).jfW;
    ac.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back miniprogram, businessType:%s", new Object[] { str1 });
    if (!bs.isNullOrNil(str1))
    {
      String str2 = paramJSONObject.optString("extraData");
      ac.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back MiniProgram, businessType:%s", new Object[] { str1 });
      OpenBusinessViewUtil.p(str1, g.kqM.errCode, str2);
      n.Hs(paramh.getAppId()).jfZ = true;
    }
    OpenBusinessViewUtil.E((o)paramh.getRuntime());
    super.a(paramh, paramJSONObject, paramInt);
    AppMethodBeat.o(46283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.c
 * JD-Core Version:    0.7.0.1
 */