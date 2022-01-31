package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class b
  extends e
{
  public final void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(143401);
    String str1 = n.yc(paramh.getRuntime().mAppId).gRe;
    ab.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back miniprogram, businessType:%s", new Object[] { str1 });
    if (!bo.isNullOrNil(str1))
    {
      String str2 = paramJSONObject.optString("extraData");
      ab.i("MicroMsg.JsApiNavigateBackMiniProgramWC", "navigate back MiniProgram, businessType:%s", new Object[] { str1 });
      OpenBusinessViewUtil.k(str1, d.hLF.errCode, str2);
      n.yd(paramh.getAppId()).gRh = true;
    }
    OpenBusinessViewUtil.z(paramh.getRuntime());
    super.a(paramh, paramJSONObject, paramInt);
    AppMethodBeat.o(143401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.b
 * JD-Core Version:    0.7.0.1
 */