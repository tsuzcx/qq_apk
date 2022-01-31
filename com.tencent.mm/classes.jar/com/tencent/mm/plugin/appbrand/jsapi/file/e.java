package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

abstract class e<T extends f>
  extends u
{
  private final T hLP;
  
  public e(T paramT)
  {
    this.hLP = paramT;
    this.hLP.hLS = this;
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = this.hLP.c(paramc, paramJSONObject);
    return a(paramc, paramJSONObject.errMsg, paramJSONObject.values);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e
 * JD-Core Version:    0.7.0.1
 */