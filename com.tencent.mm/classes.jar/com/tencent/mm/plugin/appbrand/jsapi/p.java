package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.l.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.n.k;
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.plugin.appbrand.utils.ae.a;
import com.tencent.mm.plugin.appbrand.utils.ae.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.a.a;
import org.json.JSONObject;

public abstract class p
  extends e
{
  protected boolean rww = false;
  private int rwx = -2147483648;
  
  private int cpM()
  {
    if (-2147483648 == this.rwx) {}
    try
    {
      this.rwx = ((Integer)a.cQ(getClass()).bLt("CTRL_INDEX").object).intValue();
      return this.rwx;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandJsApi", "getCtrlIndex exp = %s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
  }
  
  private String i(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (localJSONObject.has("errMsg"))
    {
      paramJSONObject = "api " + getName() + ": Cant put errMsg in res!!!";
      if (this.rww) {
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
  
  private String n(String paramString, Map<String, ? extends Object> paramMap)
  {
    String str = paramString;
    if ("cancel".equals(paramString)) {
      str = "fail cancel";
    }
    if ((!str.startsWith("fail")) && (!str.startsWith("ok")))
    {
      paramString = String.format(Locale.ENGLISH, "api[%s] assert, argument [reason] must start with special prefix", new Object[] { getName() });
      if (this.rww) {
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
      if (this.rww)
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
    d.k(paramString);
    return new JSONObject(paramString).toString();
  }
  
  @Deprecated
  public final String ZP(String paramString)
  {
    if ((this.rww) && (1059 <= cpM())) {
      throw new IllegalArgumentException("makeReturnJson(String) is deprecated");
    }
    return h(paramString, null);
  }
  
  public final String a(f paramf, a.d paramd, Map<String, ? extends Object> paramMap)
  {
    if (ae.a(paramf.getJsRuntime(), paramMap, (ae.a)paramf.aN(ae.a.class)) == ae.b.urs) {
      return a("fail:convert native buffer parameter fail. native buffer exceed size limit.", a.e.rVv, null);
    }
    return a(null, paramd, paramMap);
  }
  
  @Deprecated
  public final String a(f paramf, String paramString, Map<String, ? extends Object> paramMap)
  {
    if ((this.rww) && (1059 <= cpM())) {
      throw new IllegalArgumentException("makeReturnJsonWithNativeBuffer is deprecated");
    }
    if (ae.a(paramf.getJsRuntime(), paramMap, (ae.a)paramf.aN(ae.a.class)) == ae.b.urs) {
      return ZP("fail:convert native buffer parameter fail. native buffer exceed size limit.");
    }
    return m(paramString, paramMap);
  }
  
  public final String a(a.d paramd, Map<String, ? extends Object> paramMap)
  {
    return a(null, paramd, paramMap);
  }
  
  public final String a(String paramString, a.d paramd, Map<String, ? extends Object> paramMap)
  {
    int i = paramd.rVs;
    if (paramString == null) {
      paramString = paramd.errMsg;
    }
    for (;;)
    {
      paramd = paramString;
      if (paramString == null) {
        paramd = "";
      }
      if ((paramMap instanceof HashMap)) {}
      for (paramString = paramMap;; paramString = new HashMap())
      {
        paramString.put("errno", Integer.valueOf(i));
        return n(paramd, paramMap);
      }
    }
  }
  
  public final String a(String paramString, a.d paramd, JSONObject paramJSONObject)
  {
    int i = paramd.rVs;
    if (paramString == null) {
      paramString = paramd.errMsg;
    }
    for (;;)
    {
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        paramd = paramJSONObject;
        if (paramJSONObject == null) {
          paramd = new JSONObject();
        }
        try
        {
          paramd.put("errno", i);
          return i(paramString, paramd);
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrandJsApi", "makeReturnJson with JSONObject, put errno, e=%s", new Object[] { paramJSONObject });
          }
        }
      }
    }
  }
  
  public ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    return paramk.ae(paramInt, false);
  }
  
  public boolean cpN()
  {
    return false;
  }
  
  @Deprecated
  public final String h(String paramString, JSONObject paramJSONObject)
  {
    if ((this.rww) && (1059 <= cpM())) {
      throw new IllegalArgumentException("makeReturnJson(String, JSONObject) is deprecated");
    }
    return i(paramString, paramJSONObject);
  }
  
  @Deprecated
  public final String m(String paramString, Map<String, ? extends Object> paramMap)
  {
    if ((this.rww) && (1059 <= cpM())) {
      throw new IllegalArgumentException("makeReturnJson(String, Map<String, ? extends Object>) is deprecated");
    }
    return n(paramString, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p
 * JD-Core Version:    0.7.0.1
 */