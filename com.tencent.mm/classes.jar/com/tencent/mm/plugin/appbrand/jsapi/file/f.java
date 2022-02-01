package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import org.json.JSONObject;

abstract class f<T extends g>
  extends y
{
  private final T kMu;
  
  public f(T paramT)
  {
    this.kMu = paramT;
    this.kMu.kMy = this;
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = this.kMu.e(paramc, paramJSONObject);
    return a(paramc, paramJSONObject.errMsg, paramJSONObject.values);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.f
 * JD-Core Version:    0.7.0.1
 */