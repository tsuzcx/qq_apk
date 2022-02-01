package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class al
  extends c
{
  private static final int CTRL_INDEX = 117;
  private static final String NAME = "removeSavedFile";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(128891);
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (Util.isNullOrNil(paramJSONObject)) {
      paramJSONObject = "fail:invalid data";
    }
    for (;;)
    {
      paramf.callback(paramInt, ZP(paramJSONObject));
      AppMethodBeat.o(128891);
      return;
      if (!paramf.getFileSystem().Wp(paramJSONObject)) {
        paramJSONObject = "fail not a store filePath";
      } else if (paramf.getFileSystem().Wq(paramJSONObject)) {
        paramJSONObject = "ok";
      } else {
        paramJSONObject = "fail";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.al
 * JD-Core Version:    0.7.0.1
 */