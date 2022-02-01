package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.d;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public abstract class m
  extends b
{
  protected boolean jvW = false;
  
  public final String HI(String paramString)
  {
    return e(paramString, null);
  }
  
  public final String a(c paramc, String paramString, Map<String, ? extends Object> paramMap)
  {
    if (v.a(paramc.aOf(), paramMap, (v.a)paramc.ar(v.a.class)) == v.b.lMK) {
      return e("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
    }
    return k(paramString, paramMap);
  }
  
  public boolean aXI()
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
      if (this.jvW) {
        throw new IllegalArgumentException(paramJSONObject);
      }
      ad.e("MicroMsg.AppBrandJsApi", paramJSONObject);
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
        ad.e("MicroMsg.AppBrandJsApi", "makeReturnJson with JSONObject, put errMsg, e=%s", new Object[] { paramString });
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
      if (this.jvW) {
        throw new IllegalArgumentException(paramString);
      }
      ad.e("MicroMsg.AppBrandJsApi", paramString);
    }
    if ((paramMap instanceof HashMap)) {
      paramString = paramMap;
    }
    while ((paramMap != null) && (paramMap.containsKey("errMsg")))
    {
      paramMap = "api " + getName() + ": Cant put errMsg in res!!!";
      if (this.jvW)
      {
        throw new IllegalArgumentException(paramMap);
        paramString = new HashMap();
      }
      else
      {
        ad.e("MicroMsg.AppBrandJsApi", paramMap);
      }
    }
    paramString.put("errMsg", getName() + ":" + str);
    d.e(paramString);
    return new JSONObject(paramString).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m
 * JD-Core Version:    0.7.0.1
 */