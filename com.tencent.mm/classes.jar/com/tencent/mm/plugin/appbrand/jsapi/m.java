package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.d;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public abstract class m
  extends b
{
  protected boolean jWs = false;
  
  public final String LM(String paramString)
  {
    return e(paramString, null);
  }
  
  public final String a(c paramc, String paramString, Map<String, ? extends Object> paramMap)
  {
    if (v.a(paramc.aUV(), paramMap, (v.a)paramc.ar(v.a.class)) == v.b.moH) {
      return e("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
    }
    return k(paramString, paramMap);
  }
  
  public boolean beF()
  {
    return false;
  }
  
  public final String e(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (localJSONObject.has("errMsg"))
    {
      paramJSONObject = "api " + getName() + ": Cant put errMsg in res!!!";
      if (this.jWs) {
        throw new IllegalArgumentException(paramJSONObject);
      }
      ac.e("MicroMsg.AppBrandJsApi", paramJSONObject);
    }
    try
    {
      localJSONObject.put("errMsg", getName() + ":" + paramString);
      return localJSONObject.toString();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.AppBrandJsApi", "makeReturnJson with JSONObject, put errMsg, e=%s", new Object[] { paramString });
      }
    }
  }
  
  public final String k(String paramString, Map<String, ? extends Object> paramMap)
  {
    String str = paramString;
    if ("cancel".equals(paramString)) {
      str = "fail cancel";
    }
    if ((!str.startsWith("fail")) && (!str.startsWith("ok")))
    {
      paramString = String.format(Locale.ENGLISH, "api[%s] assert, argument [reason] must start with special prefix", new Object[] { getName() });
      if (this.jWs) {
        throw new IllegalArgumentException(paramString);
      }
      ac.e("MicroMsg.AppBrandJsApi", paramString);
    }
    if ((paramMap instanceof HashMap)) {
      paramString = paramMap;
    }
    while ((paramMap != null) && (paramMap.containsKey("errMsg")))
    {
      paramMap = "api " + getName() + ": Cant put errMsg in res!!!";
      if (this.jWs)
      {
        throw new IllegalArgumentException(paramMap);
        paramString = new HashMap();
      }
      else
      {
        ac.e("MicroMsg.AppBrandJsApi", paramMap);
      }
    }
    paramString.put("errMsg", getName() + ":" + str);
    d.d(paramString);
    return new JSONObject(paramString).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m
 * JD-Core Version:    0.7.0.1
 */