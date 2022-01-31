package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class r
  extends a
{
  private static final int CTRL_INDEX = 116;
  private static final String NAME = "getSavedFileInfo";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(102788);
    Object localObject = paramJSONObject.optString("filePath", "");
    if (bo.isNullOrNil((String)localObject))
    {
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(102788);
      return;
    }
    paramJSONObject = paramc.wX().zg((String)localObject);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j(String.format(Locale.US, "fail no such file \"%s\"", new Object[] { localObject }), null));
      AppMethodBeat.o(102788);
      return;
    }
    localObject = new HashMap(3);
    ((Map)localObject).put("size", Long.valueOf(paramJSONObject.length()));
    ((Map)localObject).put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(paramJSONObject.lastModified())));
    paramc.h(paramInt, j("ok", (Map)localObject));
    AppMethodBeat.o(102788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.r
 * JD-Core Version:    0.7.0.1
 */