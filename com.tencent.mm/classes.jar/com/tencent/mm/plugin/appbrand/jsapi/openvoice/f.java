package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends i
{
  public static final int CTRL_INDEX = 521;
  public static final String NAME = "updateVoIPChatMuteConfig";
  private boolean snA;
  boolean sny;
  boolean snz;
  
  public f()
  {
    AppMethodBeat.i(174848);
    this.sny = false;
    this.snz = false;
    this.snA = false;
    com.tencent.mm.plugin.appbrand.permission.c.afo("updateVoIPChatMuteConfig");
    AppMethodBeat.o(174848);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46690);
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("muteConfig");
      final boolean bool1 = localJSONObject.getBoolean("muteMicrophone");
      boolean bool2 = localJSONObject.getBoolean("muteEarphone");
      boolean bool3 = paramJSONObject.optBoolean("handsFree", false);
      Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: muteMicroPhone:%b, muteEarPhone:%b, handsFree:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      q.wVc.a(bool2, new b() {});
      q.wVc.b(bool1, new b() {});
      q.wVc.c(bool3, new b() {});
      AppMethodBeat.o(46690);
      return;
    }
    catch (JSONException paramc)
    {
      Log.printErrStackTrace("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", paramc, "", new Object[0]);
      AppMethodBeat.o(46690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.f
 * JD-Core Version:    0.7.0.1
 */