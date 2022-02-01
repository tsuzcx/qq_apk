package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.co;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.z;
import org.json.JSONObject;

public abstract class j<CONTEXT extends com.tencent.mm.plugin.appbrand.d, Extension>
  extends a<CONTEXT>
{
  final Class<Extension> aWK;
  
  protected j(Class<Extension> paramClass)
  {
    this.aWK = paramClass;
  }
  
  protected abstract void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt, Extension paramExtension);
  
  public final boolean biK()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.j
 * JD-Core Version:    0.7.0.1
 */