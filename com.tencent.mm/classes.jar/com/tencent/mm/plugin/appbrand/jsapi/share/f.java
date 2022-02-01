package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
    locala.llR = paramJSONObject.optInt("bizType", k.a.hCx.ordinal());
    if (!k.a.isValid(locala.llR))
    {
      ae.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
      paramc = new JsApiShareAppMessageBase.c("biz is invalid");
      AppMethodBeat.o(174910);
      throw paramc;
    }
    String str2 = paramJSONObject.optString("defaultHintUrl");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = v.Lj(paramc.getAppId());
    }
    locala.kdJ = str1;
    locala.llS = paramJSONObject.optString("tailLang", "");
    locala.llI.put("biz", Integer.valueOf(locala.llR));
    locala.llI.put("tail_lang", locala.llS);
    locala.llI.put("icon_url", locala.llw.iCT);
    locala.llI.put("nickname", locala.llw.dpI);
    AppMethodBeat.o(174910);
    return locala;
  }
  
  static final class a
    extends JsApiShareAppMessageBase.d
  {
    public int llR;
    public String llS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.f
 * JD-Core Version:    0.7.0.1
 */