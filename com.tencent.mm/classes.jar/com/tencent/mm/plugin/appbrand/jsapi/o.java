package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Map;
import org.json.JSONObject;

public abstract class o
{
  private int jOT;
  private m jOU;
  protected aa jWv;
  protected JSONObject jWw;
  protected q jiP;
  
  public o(m paramm, q paramq, aa paramaa, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramm == null) || (paramq == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.jOU = paramm;
    this.jiP = paramq;
    this.jWv = paramaa;
    this.jOT = paramInt;
    this.jWw = paramJSONObject;
  }
  
  public final q CX()
  {
    return this.jiP;
  }
  
  public final JSONObject beG()
  {
    return this.jWw;
  }
  
  protected final void l(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.jiP.h(this.jOT, this.jOU.k(paramString, paramMap));
  }
  
  protected final void z(Map<String, ? extends Object> paramMap)
  {
    this.jiP.h(this.jOT, this.jOU.k("ok", paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o
 * JD-Core Version:    0.7.0.1
 */