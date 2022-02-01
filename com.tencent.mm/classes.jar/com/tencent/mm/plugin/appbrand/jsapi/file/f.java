package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import org.json.JSONObject;

abstract class f<T extends g>
  extends y
{
  private final T kPK;
  
  public f(T paramT)
  {
    this.kPK = paramT;
    this.kPK.kPO = this;
  }
  
  public final String a(c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = this.kPK.e(paramc, paramJSONObject);
    return a(paramc, paramJSONObject.errMsg, paramJSONObject.values);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.f
 * JD-Core Version:    0.7.0.1
 */