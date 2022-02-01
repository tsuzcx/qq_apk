package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import java.util.Map;
import org.json.JSONObject;

public abstract class r
{
  protected y qqV;
  private int ror;
  private p ros;
  protected ad rwA;
  protected JSONObject rwB;
  
  public r(p paramp, y paramy, ad paramad, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramp == null) || (paramy == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.ros = paramp;
    this.qqV = paramy;
    this.rwA = paramad;
    this.ror = paramInt;
    this.rwB = paramJSONObject;
  }
  
  protected final void J(Map<String, ? extends Object> paramMap)
  {
    this.qqV.callback(this.ror, this.ros.m("ok", paramMap));
  }
  
  public final y ari()
  {
    return this.qqV;
  }
  
  public final JSONObject cpO()
  {
    return this.rwB;
  }
  
  protected final void o(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.qqV.callback(this.ror, this.ros.m(paramString, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r
 * JD-Core Version:    0.7.0.1
 */