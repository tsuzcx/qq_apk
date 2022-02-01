package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import org.json.JSONObject;

public final class ah
  extends d
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
      paramf.i(paramInt, h(paramJSONObject, null));
      AppMethodBeat.o(128891);
      return;
      if (!paramf.getFileSystem().Wb(paramJSONObject)) {
        paramJSONObject = "fail not a store filePath";
      } else if (paramf.getFileSystem().VY(paramJSONObject).delete()) {
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