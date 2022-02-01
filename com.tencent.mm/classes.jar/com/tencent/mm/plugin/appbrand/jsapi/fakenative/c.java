package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class c
  extends f
{
  public final void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46283);
    String str1 = n.KE(paramh.getRuntime().mAppId).jzc;
    ad.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back miniprogram, businessType:%s", new Object[] { str1 });
    if (!bt.isNullOrNil(str1))
    {
      String str2 = paramJSONObject.optString("extraData");
      ad.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back MiniProgram, businessType:%s", new Object[] { str1 });
      OpenBusinessViewUtil.q(str1, g.kMi.errCode, str2);
      n.KF(paramh.getAppId()).jzf = true;
    }
    OpenBusinessViewUtil.v((o)paramh.getRuntime());
    super.a(paramh, paramJSONObject, paramInt);
    AppMethodBeat.o(46283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.c
 * JD-Core Version:    0.7.0.1
 */