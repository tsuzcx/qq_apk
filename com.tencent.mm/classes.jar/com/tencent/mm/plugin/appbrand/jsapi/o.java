package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import java.util.Map;
import org.json.JSONObject;

public abstract class o
{
  protected q iIL;
  private int joH;
  private m joI;
  protected aa jvZ;
  protected JSONObject jwa;
  
  public o(m paramm, q paramq, aa paramaa, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramm == null) || (paramq == null) || (paramJSONObject == null)) {
      throw new IllegalArgumentException("JsApiAsyncRequest");
    }
    this.joI = paramm;
    this.iIL = paramq;
    this.jvZ = paramaa;
    this.joH = paramInt;
    this.jwa = paramJSONObject;
  }
  
  protected final void A(Map<String, ? extends Object> paramMap)
  {
    this.iIL.h(this.joH, this.joI.k("ok", paramMap));
  }
  
  public final q Du()
  {
    return this.iIL;
  }
  
  public final JSONObject aXJ()
  {
    return this.jwa;
  }
  
  protected final void l(String paramString, Map<String, ? extends Object> paramMap)
  {
    this.iIL.h(this.joH, this.joI.k(paramString, paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o
 * JD-Core Version:    0.7.0.1
 */