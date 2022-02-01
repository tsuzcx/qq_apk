package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.a;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.service.c;
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
    locala.biz = paramJSONObject.optInt("bizType", k.a.nQY.ordinal());
    if (!k.a.uB(locala.biz))
    {
      Log.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
      paramc = new JsApiShareAppMessageBase.c("biz is invalid");
      AppMethodBeat.o(174910);
      throw paramc;
    }
    String str2 = paramJSONObject.optString("defaultHintUrl");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = ac.UC(paramc.getAppId());
    }
    locala.rcN = str1;
    locala.suD = paramJSONObject.optString("tailLang", "");
    locala.suE = paramJSONObject.optString("bizSourceName", "");
    locala.suF = paramJSONObject.optString("bizSourceIconUrl", "");
    locala.sus.put("biz", Integer.valueOf(locala.biz));
    locala.sus.put("tail_lang", locala.suD);
    locala.sus.put("icon_url", locala.suf.phA);
    locala.sus.put("nickname", locala.suf.hEy);
    AppMethodBeat.o(174910);
    return locala;
  }
  
  static final class a
    extends JsApiShareAppMessageBase.d
  {
    public int biz;
    public String suD;
    public String suE;
    public String suF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.f
 * JD-Core Version:    0.7.0.1
 */