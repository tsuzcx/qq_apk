package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import java.util.Map;
import org.json.JSONObject;

public abstract class r
{
  protected s kGT;
  private int lqe;
  private p lqf;
  protected ac lxR;
  protected JSONObject lxS;
  
  public r(p paramp, s params, ac paramac, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramp == null) || (params == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.lqf = paramp;
    this.kGT = params;
    this.lxR = paramac;
    this.lqe = paramInt;
    this.lxS = paramJSONObject;
  }
  
  protected final void J(Map<String, ? extends Object> paramMap)
  {
    this.kGT.i(this.lqe, this.lqf.n("ok", paramMap));
  }
  
  public final s NY()
  {
    return this.kGT;
  }
  
  public final JSONObject bEj()
  {
    return this.lxS;
  }
  
  protected final void o(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.kGT.i(this.lqe, this.lqf.n(paramString, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r
 * JD-Core Version:    0.7.0.1
 */