package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.g.i;
import com.tencent.mm.plugin.appbrand.t.q;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.plugin.appbrand.t.q.b;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class m
  extends b
{
  public final String BL(String paramString)
  {
    return j(paramString, null);
  }
  
  public final String a(c paramc, String paramString, Map<String, ? extends Object> paramMap)
  {
    if (q.a(paramc.aAO(), paramMap, (q.a)paramc.U(q.a.class)) == q.b.iXZ) {
      return j("fail:convert native buffer parameter fail. native buffer exceed size limit.", null);
    }
    return j(paramString, paramMap);
  }
  
  protected void g(c paramc) {}
  
  protected void h(c paramc) {}
  
  public final String j(String paramString, Map<String, ? extends Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errMsg", getName() + ":" + paramString);
    if (paramMap != null)
    {
      if ((com.tencent.mm.sdk.a.b.dsf()) && (paramMap.containsKey("errMsg"))) {
        Assert.assertTrue("api " + getName() + ": Cant put errMsg in res!!!", false);
      }
      localHashMap.putAll(paramMap);
    }
    i.d(localHashMap);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m
 * JD-Core Version:    0.7.0.1
 */