package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class bo
  extends a
{
  public static final int CTRL_INDEX = 65;
  public static final String NAME = "systemLog";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(114331);
    paramJSONObject = paramJSONObject.optString("message");
    ab.i("AppBrandLog." + paramc.getAppId(), paramJSONObject);
    AppMethodBeat.o(114331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bo
 * JD-Core Version:    0.7.0.1
 */