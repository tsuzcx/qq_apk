package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public abstract class k<CONTEXT extends com.tencent.mm.plugin.appbrand.d, Extension>
  extends com.tencent.mm.plugin.appbrand.jsapi.d<CONTEXT>
{
  final Class<Extension> aWC;
  
  protected k(Class<Extension> paramClass)
  {
    this.aWC = paramClass;
  }
  
  protected abstract void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt, Extension paramExtension);
  
  public final boolean bEa()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.k
 * JD-Core Version:    0.7.0.1
 */