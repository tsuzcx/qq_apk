package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
  implements h
{
  private a sjA = new a();
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    if (BuildInfo.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    String str = bQs();
    HashMap localHashMap = new HashMap();
    localHashMap.put(aUD(), str);
    this.sjA.b(str, paramo);
    paramf.callback(paramInt, a(a.e.rVt, localHashMap));
    a(paramf, paramJSONObject, str);
  }
  
  public final boolean cpN()
  {
    return true;
  }
  
  protected final a ctq()
  {
    return this.sjA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.c
 * JD-Core Version:    0.7.0.1
 */