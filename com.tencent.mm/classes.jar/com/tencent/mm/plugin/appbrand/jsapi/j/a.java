package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.luggage.j.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.a;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class a
  extends d
{
  public static final int CTRL_INDEX = 517;
  public static final String NAME = "exitVoIPChat";
  
  public final void b(o paramo, JSONObject paramJSONObject, int paramInt)
  {
    c.i("MicroMsg.OpenVoice.JsApiCloudVoiceExitVoIPChat", "hy: invoke JsApiCloudVoiceExitVoIPChat");
    paramJSONObject = paramo.mAppId;
    long l = bk.UZ();
    j.iFl.a(new a.1(this, l, paramJSONObject, paramo, paramInt), j.a.iGm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a
 * JD-Core Version:    0.7.0.1
 */