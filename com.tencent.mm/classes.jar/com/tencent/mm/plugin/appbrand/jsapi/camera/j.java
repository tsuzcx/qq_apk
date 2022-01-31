package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public final class j
  extends a
{
  private static final int CTRL_INDEX = 332;
  public static final String NAME = "operateCamera";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data is null or nil", null));
      return;
    }
    ai.d(new j.1(this, paramJSONObject, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j
 * JD-Core Version:    0.7.0.1
 */