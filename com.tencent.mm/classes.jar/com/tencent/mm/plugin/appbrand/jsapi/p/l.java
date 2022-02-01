package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

@Deprecated
public abstract class l<CONTEXT extends f, EXTENSION>
  extends ab<CONTEXT>
{
  private final Class<EXTENSION> aWC;
  
  protected l(Class<EXTENSION> paramClass)
  {
    this.aWC = paramClass;
  }
  
  public final String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    ac localac = df.i(paramCONTEXT);
    if (localac == null) {
      return h("fail:page don't exist", null);
    }
    if (paramJSONObject == null) {
      return h("fail:invalid data", null);
    }
    Object localObject = localac.S(this.aWC);
    if (localObject != null) {
      return a(paramCONTEXT, paramJSONObject, localObject);
    }
    if (!localac.isRunning()) {
      return h("fail:interrupted", null);
    }
    if (localac.kAU) {
      throw new IllegalAccessError(String.format("%s Not Found", new Object[] { this.aWC.getName() }));
    }
    return h("fail:not supported", null);
  }
  
  protected abstract String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, EXTENSION paramEXTENSION);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.l
 * JD-Core Version:    0.7.0.1
 */