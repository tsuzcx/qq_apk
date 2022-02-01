package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import java.util.Map;
import org.json.JSONObject;

public abstract class o
{
  protected r jFj;
  private int kmu;
  private m kmv;
  protected z kub;
  protected JSONObject kuc;
  
  public o(m paramm, r paramr, z paramz, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramm == null) || (paramr == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.kmv = paramm;
    this.jFj = paramr;
    this.kub = paramz;
    this.kmu = paramInt;
    this.kuc = paramJSONObject;
  }
  
  public final r Ey()
  {
    return this.jFj;
  }
  
  protected final void G(Map<String, ? extends Object> paramMap)
  {
    this.jFj.h(this.kmu, this.kmv.n("ok", paramMap));
  }
  
  public final JSONObject biT()
  {
    return this.kuc;
  }
  
  protected final void o(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.jFj.h(this.kmu, this.kmv.n(paramString, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o
 * JD-Core Version:    0.7.0.1
 */