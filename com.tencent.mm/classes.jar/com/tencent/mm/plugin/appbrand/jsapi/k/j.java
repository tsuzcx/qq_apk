package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.cl;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.appbrand.page.aa;
import org.json.JSONObject;

@Deprecated
public abstract class j<CONTEXT extends c, EXTENSION>
  extends y<CONTEXT>
{
  private final Class<EXTENSION> aMt;
  
  protected j(Class<EXTENSION> paramClass)
  {
    this.aMt = paramClass;
  }
  
  public final String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    aa localaa = cl.i(paramCONTEXT);
    if (localaa == null) {
      return e("fail:page don't exist", null);
    }
    if (paramJSONObject == null) {
      return e("fail:invalid data", null);
    }
    Object localObject = localaa.Q(this.aMt);
    if (localObject != null) {
      return a(paramCONTEXT, paramJSONObject, localObject);
    }
    if (!localaa.isRunning()) {
      return e("fail:interrupted", null);
    }
    if (localaa.jdX) {
      throw new IllegalAccessError(String.format("%s Not Found", new Object[] { this.aMt.getName() }));
    }
    return e("fail:not supported", null);
  }
  
  protected abstract String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, EXTENSION paramEXTENSION);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.j
 * JD-Core Version:    0.7.0.1
 */