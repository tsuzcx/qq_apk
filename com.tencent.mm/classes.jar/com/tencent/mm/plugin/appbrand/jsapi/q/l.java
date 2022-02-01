package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import org.json.JSONObject;

@Deprecated
public abstract class l<CONTEXT extends e, EXTENSION>
  extends aa<CONTEXT>
{
  private final Class<EXTENSION> aFS;
  
  protected l(Class<EXTENSION> paramClass)
  {
    this.aFS = paramClass;
  }
  
  public final String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    ad localad = dh.k(paramCONTEXT);
    if (localad == null) {
      return h("fail:page don't exist", null);
    }
    if (paramJSONObject == null) {
      return h("fail:invalid data", null);
    }
    Object localObject = localad.R(this.aFS);
    if (localObject != null) {
      return a(paramCONTEXT, paramJSONObject, localObject);
    }
    if (!localad.isRunning()) {
      return h("fail:interrupted", null);
    }
    if (localad.nug) {
      throw new IllegalAccessError(String.format("%s Not Found", new Object[] { this.aFS.getName() }));
    }
    return h("fail:not supported", null);
  }
  
  protected abstract String a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, EXTENSION paramEXTENSION);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.l
 * JD-Core Version:    0.7.0.1
 */