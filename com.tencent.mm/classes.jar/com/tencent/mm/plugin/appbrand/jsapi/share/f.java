package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public class f
  extends JsApiShareAppMessageBase<a>
{
  public static final int CTRL_INDEX = 589;
  public static final String NAME = "shareAppMessageForFakeNative";
  
  protected a b(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(174910);
    a locala = (a)super.a(paramc, paramJSONObject);
    locala.mrG = paramJSONObject.optInt("bizType", k.a.iwD.ordinal());
    if (!k.a.isValid(locala.mrG))
    {
      Log.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
      paramc = new JsApiShareAppMessageBase.c("biz is invalid");
      AppMethodBeat.o(174910);
      throw paramc;
    }
    String str2 = paramJSONObject.optString("defaultHintUrl");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = w.Ur(paramc.getAppId());
    }
    locala.lho = str1;
    locala.mrH = paramJSONObject.optString("tailLang", "");
    locala.mrI = paramJSONObject.optString("bizSourceName", "");
    locala.mrJ = paramJSONObject.optString("bizSourceIconUrl", "");
    locala.mrv.put("biz", Integer.valueOf(locala.mrG));
    locala.mrv.put("tail_lang", locala.mrH);
    locala.mrv.put("icon_url", locala.mrj.jyi);
    locala.mrv.put("nickname", locala.mrj.brandName);
    AppMethodBeat.o(174910);
    return locala;
  }
  
  static final class a
    extends JsApiShareAppMessageBase.d
  {
    public int mrG;
    public String mrH;
    public String mrI;
    public String mrJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.f
 * JD-Core Version:    0.7.0.1
 */