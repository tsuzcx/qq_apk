package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g
  extends e
{
  public static final int CTRL_INDEX = 552;
  public static final String NAME = "shareAppMessageToSpecificContactDirectly";
  
  protected final JsApiShareAppMessageBase.d a(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(174916);
    paramc = super.a(paramc, paramJSONObject);
    if ((Util.isNullOrNil(paramc.sup)) && (Util.isNullOrNil(paramc.suq)))
    {
      Log.i("MicroMsg.JsApiShareAppMessageToSpecificContactDirectly", "openid and chatroom is null");
      paramc = new JsApiShareAppMessageBase.c("openid and chatroom is null");
      AppMethodBeat.o(174916);
      throw paramc;
    }
    AppMethodBeat.o(174916);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.g
 * JD-Core Version:    0.7.0.1
 */