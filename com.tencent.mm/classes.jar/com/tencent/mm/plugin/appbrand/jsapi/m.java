package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.utils.v.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public abstract class m
  extends b
{
  protected boolean kqJ = false;
  
  public final String Pg(String paramString)
  {
    return e(paramString, null);
  }
  
  public final String a(c paramc, String paramString, Map<String, ? extends Object> paramMap)
  {
    if (v.a(paramc.aYh(), paramMap, (v.a)paramc.ar(v.a.class)) == v.b.mPj) {
      return e("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
    }
    return m(paramString, paramMap);
  }
  
  public ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    return paramk.ak(paramInt, false);
  }
  
  public boolean bij()
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
      if (this.kqJ) {
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
  
  public final String m(String paramString, Map<String, ? extends Object> paramMap)
  {
    String str = paramString;
    if ("cancel".equals(paramString)) {
      str = "fail cancel";
    }
    if ((!str.startsWith("fail")) && (!str.startsWith("ok")))
    {
      paramString = String.format(Locale.ENGLISH, "api[%s] assert, argument [reason] must start with special prefix", new Object[] { getName() });
      if (this.kqJ) {
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
      if (this.kqJ)
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
    d.d(paramString);
    return new JSONObject(paramString).toString();
  }
  
  public static class a
  {
    public final String errMsg;
    public final Map<String, Object> values;
    
    public a(String paramString, Object... paramVarArgs)
    {
      AppMethodBeat.i(140640);
      this.values = new HashMap();
      if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
      {
        this.errMsg = paramString;
        AppMethodBeat.o(140640);
        return;
      }
      this.errMsg = String.format(paramString, paramVarArgs);
      AppMethodBeat.o(140640);
    }
    
    public a o(String paramString, Object paramObject)
    {
      AppMethodBeat.i(140641);
      this.values.put(paramString, paramObject);
      AppMethodBeat.o(140641);
      return this;
    }
    
    public a y(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(140642);
      if (paramMap != null) {
        this.values.putAll(paramMap);
      }
      AppMethodBeat.o(140642);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m
 * JD-Core Version:    0.7.0.1
 */