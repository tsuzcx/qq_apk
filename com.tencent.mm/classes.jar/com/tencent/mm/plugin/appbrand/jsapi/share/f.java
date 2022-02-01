package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    locala.kLD = paramJSONObject.optInt("bizType", k.a.hhA.ordinal());
    if (!k.a.isValid(locala.kLD))
    {
      ac.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
      paramc = new JsApiShareAppMessageBase.c("biz is invalid");
      AppMethodBeat.o(174910);
      throw paramc;
    }
    String str2 = paramJSONObject.optString("defaultHintUrl");
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = u.Hx(paramc.getAppId());
    }
    locala.jGj = str1;
    locala.kLE = paramJSONObject.optString("tailLang", "");
    locala.kLu.put("biz", Integer.valueOf(locala.kLD));
    locala.kLu.put("tail_lang", locala.kLE);
    locala.kLu.put("icon_url", locala.kLk.igG);
    locala.kLu.put("nickname", locala.kLk.ddh);
    AppMethodBeat.o(174910);
    return locala;
  }
  
  static final class a
    extends JsApiShareAppMessageBase.d
  {
    public int kLD;
    public String kLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.f
 * JD-Core Version:    0.7.0.1
 */