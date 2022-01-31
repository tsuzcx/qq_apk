package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public abstract class c<CONTEXT extends e>
  extends d<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    e locale = ((f)paramc.i(f.class)).a(paramc);
    if (locale == null)
    {
      paramc.C(paramInt, h("fail:ComponentView is null.", null));
      return;
    }
    ai.d(new c.1(this, locale, paramc, paramInt, paramJSONObject));
  }
  
  public boolean a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, g paramg)
  {
    return true;
  }
  
  public boolean aii()
  {
    return false;
  }
  
  public boolean aik()
  {
    return false;
  }
  
  public boolean c(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c
 * JD-Core Version:    0.7.0.1
 */