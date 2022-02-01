package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    locala.lif = paramJSONObject.optInt("bizType", k.a.hzJ.ordinal());
    if (!k.a.isValid(locala.lif))
    {
      ad.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
      paramc = new JsApiShareAppMessageBase.c("biz is invalid");
      AppMethodBeat.o(174910);
      throw paramc;
    }
    String str2 = paramJSONObject.optString("defaultHintUrl");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = u.KJ(paramc.getAppId());
    }
    locala.kas = str1;
    locala.lig = paramJSONObject.optString("tailLang", "");
    locala.lhW.put("biz", Integer.valueOf(locala.lif));
    locala.lhW.put("tail_lang", locala.lig);
    locala.lhW.put("icon_url", locala.lhK.iAa);
    locala.lhW.put("nickname", locala.lhK.doD);
    AppMethodBeat.o(174910);
    return locala;
  }
  
  static final class a
    extends JsApiShareAppMessageBase.d
  {
    public int lif;
    public String lig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.f
 * JD-Core Version:    0.7.0.1
 */