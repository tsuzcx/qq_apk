package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends g
{
  public static final int CTRL_INDEX = 521;
  public static final String NAME = "updateVoIPChatMuteConfig";
  boolean kea;
  boolean keb;
  
  public f()
  {
    AppMethodBeat.i(174848);
    this.kea = false;
    this.keb = false;
    com.tencent.mm.plugin.appbrand.permission.c.Me("updateVoIPChatMuteConfig");
    AppMethodBeat.o(174848);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46690);
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("muteConfig");
      final boolean bool1 = paramJSONObject.getBoolean("muteMicrophone");
      boolean bool2 = paramJSONObject.getBoolean("muteEarphone");
      ad.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: muteMicroPhone:%b, muteEarPhone:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      o.nQO.a(bool2, new b() {});
      o.nQO.b(bool1, new b() {});
      AppMethodBeat.o(46690);
      return;
    }
    catch (JSONException paramc)
    {
      ad.printErrStackTrace("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", paramc, "", new Object[0]);
      AppMethodBeat.o(46690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.f
 * JD-Core Version:    0.7.0.1
 */