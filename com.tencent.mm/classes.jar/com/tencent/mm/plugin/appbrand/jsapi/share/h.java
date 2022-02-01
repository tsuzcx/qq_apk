package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class h
  extends f
{
  public static final int CTRL_INDEX = 773;
  public static final String NAME = "shareAppMessageToSpecificContactForFakeNativeDirectly";
  
  protected final f.a b(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(174917);
    paramc = super.b(paramc, paramJSONObject);
    if ((bt.isNullOrNil(paramc.lhT)) && (bt.isNullOrNil(paramc.lhU)))
    {
      ad.i("MicroMsg.JsApiShareAppMessageToSpecificContactForFakeNativeDirectly", "openid and chatroom is null");
      paramc = new JsApiShareAppMessageBase.c("openid and chatroom is null");
      AppMethodBeat.o(174917);
      throw paramc;
    }
    AppMethodBeat.o(174917);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.h
 * JD-Core Version:    0.7.0.1
 */