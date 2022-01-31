package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.j.h;
import com.tencent.mm.plugin.appbrand.v.n;
import com.tencent.mm.plugin.appbrand.v.n.a;
import com.tencent.mm.plugin.appbrand.v.n.b;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class i
  extends b
{
  public final String a(c paramc, String paramString, Map<String, ? extends Object> paramMap)
  {
    if (n.a(paramc.ahK(), paramMap, (n.a)paramc.D(n.a.class)) == n.b.hlG) {
      return h("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
    }
    return h(paramString, paramMap);
  }
  
  public final String h(String paramString, Map<String, ? extends Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errMsg", getName() + ":" + paramString);
    if (paramMap != null)
    {
      if ((com.tencent.mm.sdk.a.b.cqk()) && (paramMap.containsKey("errMsg"))) {
        Assert.assertTrue("api " + getName() + ": Cant put errMsg in res!!!", false);
      }
      localHashMap.putAll(paramMap);
    }
    h.c(localHashMap);
    return new JSONObject(localHashMap).toString();
  }
  
  public final String tK(String paramString)
  {
    return h(paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i
 * JD-Core Version:    0.7.0.1
 */