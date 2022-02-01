package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.co;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.page.z;
import org.json.JSONObject;

@Deprecated
public abstract class k<CONTEXT extends c, EXTENSION>
  extends y<CONTEXT>
{
  private final Class<EXTENSION> aWK;
  
  protected k(Class<EXTENSION> paramClass)
  {
    this.aWK = paramClass;
  }
  
  public final String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    z localz = co.i(paramCONTEXT);
    if (localz == null) {
      return e("fail:page don't exist", null);
    }
    if (paramJSONObject == null) {
      return e("fail:invalid data", null);
    }
    Object localObject = localz.Q(this.aWK);
    if (localObject != null) {
      return a(paramCONTEXT, paramJSONObject, localObject);
    }
    if (!localz.isRunning()) {
      return e("fail:interrupted", null);
    }
    if (localz.jAe) {
      throw new IllegalAccessError(String.format("%s Not Found", new Object[] { this.aWK.getName() }));
    }
    return e("fail:not supported", null);
  }
  
  protected abstract String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, EXTENSION paramEXTENSION);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.k
 * JD-Core Version:    0.7.0.1
 */