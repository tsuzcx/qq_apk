package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.page.v;
import org.json.JSONObject;

public abstract class j<CONTEXT extends c, EXTENSION>
  extends u<CONTEXT>
{
  private final Class<EXTENSION> aqP;
  
  protected j(Class<EXTENSION> paramClass)
  {
    this.aqP = paramClass;
  }
  
  public final String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    v localv = bw.l(paramCONTEXT);
    if (localv == null) {
      return j("fail:page don't exist", null);
    }
    if (paramJSONObject == null) {
      return j("fail:invalid data", null);
    }
    Object localObject = localv.x(this.aqP);
    if (localObject != null) {
      return a(paramCONTEXT, paramJSONObject, localObject);
    }
    if (!localv.isRunning()) {
      return j("fail:interrupted", null);
    }
    if (localv.gPS) {
      throw new IllegalAccessError(String.format("%s Not Found", new Object[] { this.aqP.getName() }));
    }
    return j("fail:not supported", null);
  }
  
  protected abstract String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, EXTENSION paramEXTENSION);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.j
 * JD-Core Version:    0.7.0.1
 */