package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import java.util.Map;
import org.json.JSONObject;

public abstract class q
{
  protected v nAz;
  private int okO;
  private o okP;
  protected ad osE;
  protected JSONObject osF;
  
  public q(o paramo, v paramv, ad paramad, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramo == null) || (paramv == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.okP = paramo;
    this.nAz = paramv;
    this.osE = paramad;
    this.okO = paramInt;
    this.osF = paramJSONObject;
  }
  
  protected final void C(Map<String, ? extends Object> paramMap)
  {
    this.nAz.j(this.okO, this.okP.m("ok", paramMap));
  }
  
  public final v QW()
  {
    return this.nAz;
  }
  
  public final JSONObject bPH()
  {
    return this.osF;
  }
  
  protected final void n(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.nAz.j(this.okO, this.okP.m(paramString, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q
 * JD-Core Version:    0.7.0.1
 */