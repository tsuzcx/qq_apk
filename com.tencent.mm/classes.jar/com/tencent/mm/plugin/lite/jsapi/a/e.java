package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.plugin.lite.storage.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class e
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(233983);
    f.eLH();
    Object localObject2 = f.cY(paramString);
    if (localObject2 == null)
    {
      Log.w("LiteAppJsApiSession", "get LiteAppInfo fail");
      h.IzE.p(1293L, 125L, 1L);
      this.Ega.aNa("can not find liteApp from local storage");
      AppMethodBeat.o(233983);
      return;
    }
    Object localObject1 = null;
    try
    {
      if (paramJSONObject.has("url")) {
        localObject1 = paramJSONObject.getString("url");
      }
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = LiteAppCenter.getAuthUrl(((WxaLiteAppInfo)localObject2).path, ((WxaLiteAppInfo)localObject2).appId, ((WxaLiteAppInfo)localObject2).coX);
      }
      if ((paramJSONObject == null) || (paramJSONObject.isEmpty()))
      {
        Log.w("LiteAppJsApiSession", "get authurl fail");
        this.Ega.aNa("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(233983);
        return;
      }
      f.eLH();
      paramJSONObject = f.aNb(paramJSONObject);
      if (paramJSONObject == null)
      {
        this.Ega.aNa("auth info is not existed");
        AppMethodBeat.o(233983);
        return;
      }
      localObject2 = new JSONObject(paramJSONObject.field_headerMap);
      localIterator = ((JSONObject)localObject2).keys();
      localObject1 = new HashMap();
      while (localIterator.hasNext())
      {
        localObject3 = (String)localIterator.next();
        ((Map)localObject1).put(localObject3, ((JSONObject)localObject2).getString((String)localObject3));
      }
      localObject2 = new JSONObject(paramJSONObject.field_paramMap);
    }
    catch (Exception paramString)
    {
      this.Ega.aNa("exception");
      AppMethodBeat.o(233983);
      return;
    }
    Iterator localIterator = ((JSONObject)localObject2).keys();
    Object localObject3 = new HashMap();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Map)localObject3).put(str, ((JSONObject)localObject2).getString(str));
    }
    LiteAppCenter.setAuthInfo(paramString, paramJSONObject.field_param, (Map)localObject1, (Map)localObject3, paramBoolean);
    ((JSONObject)localObject2).put("updateTime", paramJSONObject.field_updateTime);
    this.Ega.bd((JSONObject)localObject2);
    AppMethodBeat.o(233983);
  }
  
  public final int ewF()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.e
 * JD-Core Version:    0.7.0.1
 */