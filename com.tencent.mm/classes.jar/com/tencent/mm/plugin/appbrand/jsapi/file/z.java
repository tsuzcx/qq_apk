package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import org.json.JSONObject;

public final class z
  extends a
{
  private static final int CTRL_INDEX = 117;
  private static final String NAME = "removeSavedFile";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (bk.bl(paramJSONObject)) {
      paramJSONObject = "fail:invalid data";
    }
    for (;;)
    {
      paramc.C(paramInt, h(paramJSONObject, null));
      return;
      paramJSONObject = paramc.Zl().rw(paramJSONObject);
      switch (z.1.gqS[paramJSONObject.ordinal()])
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.z
 * JD-Core Version:    0.7.0.1
 */