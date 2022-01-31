package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.j.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ac
  extends b
{
  private c fLx;
  private String gfR;
  private Map<String, Object> gfS;
  int gfT;
  
  public ac b(c paramc, int paramInt)
  {
    e(paramc);
    this.gfT = paramInt;
    return this;
  }
  
  public final void dispatch()
  {
    if (this.fLx == null) {
      return;
    }
    this.fLx.a(this);
  }
  
  public ac e(c paramc)
  {
    if (paramc == null) {
      return this;
    }
    this.fLx = paramc;
    this.gfT = 0;
    return this;
  }
  
  final String getData()
  {
    if (this.gfR != null) {
      return this.gfR;
    }
    if (this.gfS != null)
    {
      h.c(this.gfS);
      return new JSONObject(this.gfS).toString();
    }
    return null;
  }
  
  public final ac l(String paramString, Object paramObject)
  {
    if (this.gfS == null) {
      this.gfS = new HashMap();
    }
    this.gfS.put(paramString, paramObject);
    return this;
  }
  
  public ac p(Map<String, Object> paramMap)
  {
    if (paramMap == null) {
      return this;
    }
    h.c(paramMap);
    this.gfS = paramMap;
    return this;
  }
  
  public ac tM(String paramString)
  {
    this.gfR = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac
 * JD-Core Version:    0.7.0.1
 */