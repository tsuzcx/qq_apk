package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import java.util.Map;
import org.json.JSONObject;

public abstract class k
{
  protected o gfd;
  protected q gfe;
  protected JSONObject gff;
  private int gfg;
  private i gfh;
  
  public k(i parami, o paramo, q paramq, JSONObject paramJSONObject, int paramInt)
  {
    if ((parami == null) || (paramo == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.gfh = parami;
    this.gfd = paramo;
    this.gfe = paramq;
    this.gfg = paramInt;
    this.gff = paramJSONObject;
  }
  
  public final o Zy()
  {
    return this.gfd;
  }
  
  public final JSONObject ahN()
  {
    return this.gff;
  }
  
  public final void i(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.gfd.C(this.gfg, this.gfh.h(paramString, paramMap));
  }
  
  public final void r(Map<String, ? extends Object> paramMap)
  {
    this.gfd.C(this.gfg, this.gfh.h("ok", paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k
 * JD-Core Version:    0.7.0.1
 */