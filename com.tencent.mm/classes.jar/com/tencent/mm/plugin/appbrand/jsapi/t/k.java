package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.dp;
import com.tencent.mm.plugin.appbrand.page.ad;
import org.json.JSONObject;

public abstract class k<CONTEXT extends com.tencent.mm.plugin.appbrand.g, Extension>
  extends c<CONTEXT>
{
  final Class<Extension> clazz;
  
  protected k(Class<Extension> paramClass)
  {
    this.clazz = paramClass;
  }
  
  protected abstract void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt, Extension paramExtension);
  
  public final boolean cpE()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.k
 * JD-Core Version:    0.7.0.1
 */