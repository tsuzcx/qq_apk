package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ar;
import org.json.JSONObject;

public final class n
  extends a
{
  private static final int CTRL_INDEX = 332;
  public static final String NAME = "operateCamera";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137480);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data is null or nil", null));
      AppMethodBeat.o(137480);
      return;
    }
    ar.f(new n.1(this, paramJSONObject, paramc, paramInt));
    AppMethodBeat.o(137480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.n
 * JD-Core Version:    0.7.0.1
 */