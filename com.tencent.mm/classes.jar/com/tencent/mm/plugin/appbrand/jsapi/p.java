package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.plugin.appbrand.utils.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public abstract class p
  extends e
{
  protected boolean lxO = false;
  
  public final String Zf(String paramString)
  {
    return h(paramString, null);
  }
  
  public final String a(f paramf, String paramString, Map<String, ? extends Object> paramMap)
  {
    if (x.a(paramf.getJsRuntime(), paramMap, (x.a)paramf.av(x.a.class)) == x.b.ohp) {
      return h("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
    }
    return n(paramString, paramMap);
  }
  
  public ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    return paramk.N(paramInt, false);
  }
  
  public boolean bEi()
  {
    return false;
  }
  
  public final String h(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (localJSONObject.has("errMsg"))
    {
      paramJSONObject = "api " + getName() + ": Cant put errMsg in res!!!";
      if (this.lxO) {
        throw new IllegalArgumentException(paramJSONObject);
      }
      Log.e("MicroMsg.AppBrandJsApi", paramJSONObject);
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
        Log.e("MicroMsg.AppBrandJsApi", "makeReturnJson with JSONObject, put errMsg, e=%s", new Object[] { paramString });
      }
    }
  }
  
  public final String n(String paramString, Map<String, ? extends Object> paramMap)
  {
    String str = paramString;
    if ("cancel".equals(paramString)) {
      str = "fail cancel";
    }
    if ((!str.startsWith("fail")) && (!str.startsWith("ok")))
    {
      paramString = String.format(Locale.ENGLISH, "api[%s] assert, argument [reason] must start with special prefix", new Object[] { getName() });
      if (this.lxO) {
        throw new IllegalArgumentException(paramString);
      }
      Log.e("MicroMsg.AppBrandJsApi", paramString);
    }
    if ((paramMap instanceof HashMap)) {
      paramString = paramMap;
    }
    while ((paramMap != null) && (paramMap.containsKey("errMsg")))
    {
      paramMap = "api " + getName() + ": Cant put errMsg in res!!!";
      if (this.lxO)
      {
        throw new IllegalArgumentException(paramMap);
        paramString = new HashMap();
      }
      else
      {
        Log.e("MicroMsg.AppBrandJsApi", paramMap);
      }
    }
    paramString.put("errMsg", getName() + ":" + str);
    com.tencent.luggage.h.e.m(paramString);
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
    
    public a I(Map<String, Object> paramMap)
    {
      AppMethodBeat.i(140642);
      if (paramMap != null) {
        this.values.putAll(paramMap);
      }
      AppMethodBeat.o(140642);
      return this;
    }
    
    public a o(String paramString, Object paramObject)
    {
      AppMethodBeat.i(140641);
      this.values.put(paramString, paramObject);
      AppMethodBeat.o(140641);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p
 * JD-Core Version:    0.7.0.1
 */