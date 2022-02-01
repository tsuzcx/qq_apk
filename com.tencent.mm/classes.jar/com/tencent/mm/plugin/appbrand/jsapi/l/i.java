package com.tencent.mm.plugin.appbrand.jsapi.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.cl;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import org.json.JSONObject;

public abstract class i<CONTEXT extends com.tencent.mm.plugin.appbrand.d, Extension>
  extends a<CONTEXT>
{
  final Class<Extension> aLD;
  
  protected i(Class<Extension> paramClass)
  {
    this.aLD = paramClass;
  }
  
  protected abstract void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt, Extension paramExtension);
  
  public final boolean aXA()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.i
 * JD-Core Version:    0.7.0.1
 */