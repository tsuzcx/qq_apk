package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m.o;
import org.json.JSONObject;

abstract class f<T extends g>
  extends aa
{
  private final T oRH;
  
  public f(T paramT)
  {
    this.oRH = paramT;
    this.oRH.oRL = this;
  }
  
  public final String a(e parame, JSONObject paramJSONObject)
  {
    return a(parame, paramJSONObject, parame.getJsRuntime());
  }
  
  public String a(e parame, JSONObject paramJSONObject, o paramo)
  {
    paramJSONObject = this.oRH.a(parame, paramo, paramJSONObject);
    return a(parame, paramJSONObject.errMsg, paramJSONObject.values);
  }
  
  public boolean bPG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.f
 * JD-Core Version:    0.7.0.1
 */