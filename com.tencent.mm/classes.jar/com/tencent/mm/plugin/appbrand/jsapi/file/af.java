package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import org.json.JSONObject;

public final class af
  extends a
{
  private static final int CTRL_INDEX = 117;
  private static final String NAME = "removeSavedFile";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(128891);
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (bt.isNullOrNil(paramJSONObject)) {
      paramJSONObject = "fail:invalid data";
    }
    for (;;)
    {
      paramc.h(paramInt, e(paramJSONObject, null));
      AppMethodBeat.o(128891);
      return;
      if (!paramc.Ee().ES(paramJSONObject)) {
        paramJSONObject = "fail not a store filePath";
      } else if (paramc.Ee().EP(paramJSONObject).delete()) {
        paramJSONObject = "ok";
      } else {
        paramJSONObject = "fail";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.af
 * JD-Core Version:    0.7.0.1
 */