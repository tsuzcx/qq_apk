package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.s;
import org.json.JSONObject;

abstract class c<T extends d>
  extends s
{
  private final T gqD;
  
  public c(T paramT)
  {
    this.gqD = paramT;
    this.gqD.gqG = this;
  }
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = this.gqD.b(paramc, paramJSONObject);
    return a(paramc, paramJSONObject.aox, paramJSONObject.values);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.c
 * JD-Core Version:    0.7.0.1
 */