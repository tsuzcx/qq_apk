package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import java.util.Map;
import org.json.JSONObject;

public abstract class o
{
  private int hry;
  private m hrz;
  protected r hxb;
  protected v hxc;
  protected JSONObject hxd;
  
  public o(m paramm, r paramr, v paramv, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramm == null) || (paramr == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.hrz = paramm;
    this.hxb = paramr;
    this.hxc = paramv;
    this.hry = paramInt;
    this.hxd = paramJSONObject;
  }
  
  public final JSONObject aBw()
  {
    return this.hxd;
  }
  
  protected final void k(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.hxb.h(this.hry, this.hrz.j(paramString, paramMap));
  }
  
  protected final void v(Map<String, ? extends Object> paramMap)
  {
    this.hxb.h(this.hry, this.hrz.j("ok", paramMap));
  }
  
  public final r ws()
  {
    return this.hxb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o
 * JD-Core Version:    0.7.0.1
 */