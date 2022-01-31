package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class l
  extends a
{
  private static final int CTRL_INDEX = 332;
  public static final String NAME = "operateCamera";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126252);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data is null or nil", null));
      AppMethodBeat.o(126252);
      return;
    }
    al.d(new l.1(this, paramJSONObject, paramc, paramInt));
    AppMethodBeat.o(126252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.l
 * JD-Core Version:    0.7.0.1
 */