package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class c
  extends d<f>
  implements h
{
  protected a mgd = new a();
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    if (BuildInfo.DEBUG) {
      throw new RuntimeException("Should call 3 params version!");
    }
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt, o paramo)
  {
    String str = bjl();
    HashMap localHashMap = new HashMap();
    localHashMap.put(auJ(), str);
    this.mgd.a(str, paramo);
    paramf.i(paramInt, n("ok", localHashMap));
    a(paramf, paramJSONObject, str);
  }
  
  public final boolean bEi()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c
 * JD-Core Version:    0.7.0.1
 */