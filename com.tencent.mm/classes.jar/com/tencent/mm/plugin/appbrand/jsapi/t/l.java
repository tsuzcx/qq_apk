package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.dp;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.page.ad;
import org.json.JSONObject;

@Deprecated
public abstract class l<CONTEXT extends f, EXTENSION>
  extends ab<CONTEXT>
{
  private final Class<EXTENSION> clazz;
  
  protected l(Class<EXTENSION> paramClass)
  {
    this.clazz = paramClass;
  }
  
  public final String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    ad localad = dp.j(paramCONTEXT);
    if (localad == null) {
      return ZP("fail:page don't exist");
    }
    if (paramJSONObject == null) {
      return ZP("fail:invalid data");
    }
    Object localObject = localad.aa(this.clazz);
    if (localObject != null) {
      return a(paramCONTEXT, paramJSONObject, localObject);
    }
    if (!localad.isRunning()) {
      return ZP("fail:interrupted");
    }
    if (localad.qsQ) {
      throw new IllegalAccessError(String.format("%s Not Found", new Object[] { this.clazz.getName() }));
    }
    return ZP("fail:not supported");
  }
  
  protected abstract String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, EXTENSION paramEXTENSION);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.l
 * JD-Core Version:    0.7.0.1
 */