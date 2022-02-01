package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Map;
import org.json.JSONObject;

public abstract class o
{
  protected q jCl;
  private int kje;
  private m kjf;
  protected aa kqM;
  protected JSONObject kqN;
  
  public o(m paramm, q paramq, aa paramaa, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramm == null) || (paramq == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.kjf = paramm;
    this.jCl = paramq;
    this.kqM = paramaa;
    this.kje = paramInt;
    this.kqN = paramJSONObject;
  }
  
  public final q Ew()
  {
    return this.jCl;
  }
  
  public final JSONObject bik()
  {
    return this.kqN;
  }
  
  protected final void n(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.jCl.h(this.kje, this.kjf.m(paramString, paramMap));
  }
  
  protected final void z(Map<String, ? extends Object> paramMap)
  {
    this.jCl.h(this.kje, this.kjf.m("ok", paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o
 * JD-Core Version:    0.7.0.1
 */