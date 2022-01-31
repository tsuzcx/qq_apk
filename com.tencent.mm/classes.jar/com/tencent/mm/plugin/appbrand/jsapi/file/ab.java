package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class ab
  extends a
{
  private static final int CTRL_INDEX = 117;
  private static final String NAME = "removeSavedFile";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(102799);
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (bo.isNullOrNil(paramJSONObject)) {
      paramJSONObject = "fail:invalid data";
    }
    for (;;)
    {
      paramc.h(paramInt, j(paramJSONObject, null));
      AppMethodBeat.o(102799);
      return;
      if (!paramc.wX().zi(paramJSONObject))
      {
        paramJSONObject = "fail not a store filePath";
      }
      else
      {
        paramJSONObject = paramc.wX().zf(paramJSONObject);
        switch (ab.1.hMg[paramJSONObject.ordinal()])
        {
        default: 
          paramJSONObject = "fail " + paramJSONObject.name();
          break;
        case 1: 
          paramJSONObject = "ok";
          break;
        case 2: 
          paramJSONObject = "fail:invalid data";
          break;
        case 3: 
          paramJSONObject = "fail";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ab
 * JD-Core Version:    0.7.0.1
 */