package com.tencent.mm.plugin.lite.a.c;

import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class j
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(271595);
    com.tencent.mm.plugin.lite.logic.d.fUi();
    Object localObject2 = com.tencent.mm.plugin.lite.logic.d.et(paramString);
    if (localObject2 == null)
    {
      Log.w("LiteAppJsApiSession", "get LiteAppInfo fail");
      h.OAn.p(1293L, 125L, 1L);
      this.JZj.aJV("can not find liteApp from local storage");
      AppMethodBeat.o(271595);
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
        paramJSONObject = LiteAppCenter.getAuthUrl(((WxaLiteAppInfo)localObject2).path, ((WxaLiteAppInfo)localObject2).appId, ((WxaLiteAppInfo)localObject2).egI);
      }
      if ((paramJSONObject == null) || (paramJSONObject.isEmpty()))
      {
        Log.w("LiteAppJsApiSession", "get authurl fail");
        this.JZj.aJV("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(271595);
        return;
      }
      com.tencent.mm.plugin.lite.logic.d.fUi();
      paramJSONObject = com.tencent.mm.plugin.lite.logic.d.aJY(paramJSONObject);
      if (paramJSONObject == null)
      {
        this.JZj.aJV("auth info is not existed");
        AppMethodBeat.o(271595);
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
      this.JZj.aJV("exception");
      AppMethodBeat.o(271595);
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
    this.JZj.bq((JSONObject)localObject2);
    AppMethodBeat.o(271595);
  }
  
  public final int fEx()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.j
 * JD-Core Version:    0.7.0.1
 */