package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.BaseRecordJsApi", "%s invalid data", new Object[] { getName() });
      paramc.h(paramInt, j("fail:invalid data", null));
      return;
    }
    c localc = (c)paramc.q(c.class);
    if (localc == null)
    {
      ab.e("MicroMsg.BaseRecordJsApi", "%s voicePlayer is null, err", new Object[] { getName() });
      paramc.h(paramInt, String.format("fail:internal error %s", new Object[] { "player is null" }));
      return;
    }
    a(localc, paramc, paramJSONObject, paramInt);
  }
  
  protected abstract void a(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a
 * JD-Core Version:    0.7.0.1
 */