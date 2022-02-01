package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.ab;
import org.json.JSONObject;

abstract class f<T extends g>
  extends ab
{
  private final T lUI;
  
  public f(T paramT)
  {
    this.lUI = paramT;
    this.lUI.lUM = this;
  }
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject)
  {
    paramJSONObject = this.lUI.e(paramf, paramJSONObject);
    return a(paramf, paramJSONObject.errMsg, paramJSONObject.values);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.f
 * JD-Core Version:    0.7.0.1
 */