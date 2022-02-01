package com.tencent.mm.plugin.lite.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.LiteAppCenter;
import com.tencent.mm.plugin.lite.d.e;
import com.tencent.mm.plugin.lite.jsapi.a;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class d
  extends a
{
  public final int cZP()
  {
    return 0;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(217786);
    com.tencent.mm.plugin.lite.logic.c.diz();
    Object localObject2 = com.tencent.mm.plugin.lite.logic.c.apC(paramString);
    if (localObject2 == null)
    {
      ae.w("LiteAppJsApiSession", "get LiteAppInfo fail");
      this.vko.ZC("can not find liteApp from local storage");
      AppMethodBeat.o(217786);
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
        paramJSONObject = LiteAppCenter.getAuthUrl(((e)localObject2).field_pkgPath, ((e)localObject2).field_appId, ((e)localObject2).field_signatureKey);
      }
      if ((paramJSONObject == null) || (paramJSONObject.isEmpty()))
      {
        ae.w("LiteAppJsApiSession", "get authurl fail");
        this.vko.ZC("get authUrl fail, please make sure config authUrl in config file");
        AppMethodBeat.o(217786);
        return;
      }
      com.tencent.mm.plugin.lite.logic.c.diz();
      paramJSONObject = com.tencent.mm.plugin.lite.logic.c.apD(paramJSONObject);
      if (paramJSONObject == null)
      {
        this.vko.ZC("auth info is not existed");
        AppMethodBeat.o(217786);
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
      this.vko.ZC("exception");
      AppMethodBeat.o(217786);
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
    this.vko.aA((JSONObject)localObject2);
    AppMethodBeat.o(217786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.d
 * JD-Core Version:    0.7.0.1
 */