package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import org.json.JSONObject;

public abstract class i<CONTEXT extends c, Extension>
  extends a<CONTEXT>
{
  private final Class<Extension> aqP;
  
  protected i(Class<Extension> paramClass)
  {
    this.aqP = paramClass;
  }
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    v localv = bw.l(paramCONTEXT);
    if (localv == null)
    {
      paramCONTEXT.h(paramInt, j("fail:page don't exist", null));
      return;
    }
    Object localObject = localv.x(this.aqP);
    if (localObject != null)
    {
      a(paramCONTEXT, paramJSONObject, paramInt, localObject);
      return;
    }
    if (!localv.isRunning())
    {
      paramCONTEXT.h(paramInt, j("fail:interrupted", null));
      return;
    }
    if (localv.gPS) {
      throw new IllegalAccessError(String.format("%s Not Found", new Object[] { this.aqP.getName() }));
    }
    paramCONTEXT.h(paramInt, j("fail:not supported", null));
  }
  
  protected abstract void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt, Extension paramExtension);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.i
 * JD-Core Version:    0.7.0.1
 */