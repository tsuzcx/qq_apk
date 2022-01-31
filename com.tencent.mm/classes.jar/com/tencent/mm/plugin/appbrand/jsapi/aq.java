package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.czl;
import org.json.JSONObject;

public final class aq
  extends a
{
  public static final int CTRL_INDEX = 236;
  public static final String NAME = "getSetting";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(101946);
    paramJSONObject = new czk();
    paramJSONObject.appId = paramc.getAppId();
    ((com.tencent.mm.plugin.appbrand.networking.a)paramc.q(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", paramJSONObject, czl.class).c(new aq.1(this, paramc, paramInt));
    AppMethodBeat.o(101946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aq
 * JD-Core Version:    0.7.0.1
 */