package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f
{
  public final void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46283);
    String str1 = o.Ld(paramh.getRuntime().mAppId).jCc;
    ae.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back miniprogram, businessType:%s", new Object[] { str1 });
    if (!bu.isNullOrNil(str1))
    {
      String str2 = paramJSONObject.optString("extraData");
      ae.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back MiniProgram, businessType:%s", new Object[] { str1 });
      OpenBusinessViewUtil.s(str1, f.kPy.errCode, str2);
      o.Le(paramh.getAppId()).jCf = true;
    }
    OpenBusinessViewUtil.w((p)paramh.getRuntime());
    super.a(paramh, paramJSONObject, paramInt);
    AppMethodBeat.o(46283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.c
 * JD-Core Version:    0.7.0.1
 */