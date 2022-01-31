package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class p
  extends a
{
  private static final int CTRL_INDEX = 116;
  private static final String NAME = "getSavedFileInfo";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = paramJSONObject.optString("filePath", "");
    if (bk.bl((String)localObject))
    {
      paramc.C(paramInt, h("fail:invalid data", null));
      return;
    }
    paramJSONObject = paramc.Zl().rx((String)localObject);
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h(String.format(Locale.US, "fail no such file \"%s\"", new Object[] { localObject }), null));
      return;
    }
    localObject = new HashMap(3);
    ((Map)localObject).put("size", Long.valueOf(paramJSONObject.length()));
    ((Map)localObject).put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(paramJSONObject.lastModified())));
    paramc.C(paramInt, h("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.p
 * JD-Core Version:    0.7.0.1
 */