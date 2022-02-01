package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.z;
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
    locala.ppO = paramJSONObject.optInt("bizType", k.a.llS.ordinal());
    if (!k.a.uB(locala.ppO))
    {
      Log.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
      paramc = new JsApiShareAppMessageBase.c("biz is invalid");
      AppMethodBeat.o(174910);
      throw paramc;
    }
    String str2 = paramJSONObject.optString("defaultHintUrl");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = z.aca(paramc.getAppId());
    }
    locala.obX = str1;
    locala.ppP = paramJSONObject.optString("tailLang", "");
    locala.ppQ = paramJSONObject.optString("bizSourceName", "");
    locala.ppR = paramJSONObject.optString("bizSourceIconUrl", "");
    locala.ppD.put("biz", Integer.valueOf(locala.ppO));
    locala.ppD.put("tail_lang", locala.ppP);
    locala.ppD.put("icon_url", locala.ppr.mnM);
    locala.ppD.put("nickname", locala.ppr.fzM);
    AppMethodBeat.o(174910);
    return locala;
  }
  
  static final class a
    extends JsApiShareAppMessageBase.d
  {
    public int ppO;
    public String ppP;
    public String ppQ;
    public String ppR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.f
 * JD-Core Version:    0.7.0.1
 */