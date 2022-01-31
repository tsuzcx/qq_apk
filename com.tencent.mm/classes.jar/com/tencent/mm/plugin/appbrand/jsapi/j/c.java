package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends d
{
  public static final int CTRL_INDEX = 521;
  public static final String NAME = "updateVoIPChatMuteConfig";
  boolean gyU = false;
  boolean gyV = false;
  
  public final void b(o paramo, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("muteConfig");
      boolean bool1 = paramJSONObject.getBoolean("muteMicrophone");
      boolean bool2 = paramJSONObject.getBoolean("muteEarphone");
      com.tencent.luggage.j.c.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", "hy: muteMicroPhone:%b, muteEarPhone:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      j.iFl.a(bool2, new c.1(this, paramo, paramInt));
      j.iFl.b(bool1, new c.2(this, paramo, paramInt));
      return;
    }
    catch (JSONException paramo)
    {
      com.tencent.luggage.j.c.printErrStackTrace("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateVoIPChatMuteConfig", paramo, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.c
 * JD-Core Version:    0.7.0.1
 */