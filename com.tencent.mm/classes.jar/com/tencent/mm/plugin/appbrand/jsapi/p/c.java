package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
  implements h
{
  private a pek = new a();
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    if (BuildInfo.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    a(parame, paramJSONObject, paramInt, parame.getJsRuntime());
  }
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    String str = bsL();
    HashMap localHashMap = new HashMap();
    localHashMap.put(aBF(), str);
    this.pek.b(str, paramo);
    parame.j(paramInt, m("ok", localHashMap));
    a(parame, paramJSONObject, str);
  }
  
  public final boolean bPG()
  {
    return true;
  }
  
  protected final a bTl()
  {
    return this.pek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.c
 * JD-Core Version:    0.7.0.1
 */