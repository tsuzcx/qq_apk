package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.n.o;
import org.json.JSONObject;

abstract class f<T extends g>
  extends ab
{
  private final T rXh;
  
  public f(T paramT)
  {
    this.rXh = paramT;
    this.rXh.rXl = this;
  }
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    return a(paramf, paramJSONObject, paramf.getJsRuntime());
  }
  
  public String a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, o paramo)
  {
    paramJSONObject = this.rXh.a(paramf, paramo, paramJSONObject);
    return a(paramf, paramJSONObject.errMsg, paramJSONObject.values);
  }
  
  public boolean cpN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.f
 * JD-Core Version:    0.7.0.1
 */