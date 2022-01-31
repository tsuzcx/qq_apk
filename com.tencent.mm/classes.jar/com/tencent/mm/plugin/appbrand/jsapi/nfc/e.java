package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class e
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 353;
  public static final String NAME = "stopHCE";
  
  static void a(c paramc, int paramInt, String paramString)
  {
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", new Object[] { paramString });
    if (paramc != null) {
      paramc.C(paramInt, paramString);
    }
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a(new e.1(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e
 * JD-Core Version:    0.7.0.1
 */