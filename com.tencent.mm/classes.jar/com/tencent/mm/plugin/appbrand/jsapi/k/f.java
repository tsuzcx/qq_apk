package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends g
{
  public static final int CTRL_INDEX = 521;
  public static final String NAME = "updateVoIPChatMuteConfig";
  boolean hVF = false;
  boolean hVG = false;
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143430);
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("muteConfig");
      boolean bool1 = paramJSONObject.getBoolean("muteMicrophone");
      boolean bool2 = paramJSONObject.getBoolean("muteEarphone");
      d.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: muteMicroPhone:%b, muteEarPhone:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      o.kKN.a(bool2, new b() {});
      o.kKN.b(bool1, new f.2(this, bool1, paramc, paramInt));
      AppMethodBeat.o(143430);
      return;
    }
    catch (JSONException paramc)
    {
      d.printErrStackTrace("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", paramc, "", new Object[0]);
      AppMethodBeat.o(143430);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.f
 * JD-Core Version:    0.7.0.1
 */