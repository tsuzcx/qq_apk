package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.plugin.lite.storage.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(198843);
    f.ecC();
    Object localObject2 = f.aCT(paramString);
    if (localObject2 == null)
    {
      Log.w("LiteAppJsApiSession", "get LiteAppInfo fail");
      this.yEn.aCS("can not find liteApp from local storage");
      AppMethodBeat.o(198843);
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
        paramJSONObject = LiteAppCenter.getAuthUrl(((WxaLiteAppInfo)localObject2).path, ((WxaLiteAppInfo)localObject2).appId, ((WxaLiteAppInfo)localObject2).crh);
      }
      if ((paramJSONObject == null) || (paramJSONObject.isEmpty()))
      {
        Log.w("LiteAppJsApiSession", "get authurl fail");
        this.yEn.aCS("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(198843);
        return;
      }
      f.ecC();
      paramJSONObject = f.aCU(paramJSONObject);
      if (paramJSONObject == null)
      {
        this.yEn.aCS("auth info is not existed");
        AppMethodBeat.o(198843);
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
      this.yEn.aCS("exception");
      AppMethodBeat.o(198843);
      return;
    }
    Iterator localIterator = ((JSONObject)localObject2).keys();
    Object localObject3 = new HashMap();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Map)localObject3).put(str, ((JSONObject)localObject2).getString(str));
    }
    LiteAppCenter.setAuthInfo(paramString, paramJSONObject.field_param, (Map)localObject1, (Map)localObject3);
    ((JSONObject)localObject2).put("updateTime", paramJSONObject.field_updateTime);
    this.yEn.aW((JSONObject)localObject2);
    AppMethodBeat.o(198843);
  }
  
  public final int dTw()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.d
 * JD-Core Version:    0.7.0.1
 */