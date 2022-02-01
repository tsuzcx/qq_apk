package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import org.json.JSONObject;

public final class ah
  extends a
{
  private static final int CTRL_INDEX = 117;
  private static final String NAME = "removeSavedFile";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(128891);
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (bu.isNullOrNil(paramJSONObject)) {
      paramJSONObject = "fail:invalid data";
    }
    for (;;)
    {
      paramc.h(paramInt, e(paramJSONObject, null));
      AppMethodBeat.o(128891);
      return;
      if (!paramc.Fl().MS(paramJSONObject)) {
        paramJSONObject = "fail not a store filePath";
      } else if (paramc.Fl().MP(paramJSONObject).delete()) {
        paramJSONObject = "ok";
      } else {
        paramJSONObject = "fail";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ah
 * JD-Core Version:    0.7.0.1
 */