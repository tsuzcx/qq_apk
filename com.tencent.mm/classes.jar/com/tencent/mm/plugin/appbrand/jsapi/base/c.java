package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public abstract class c<CONTEXT extends e>
  extends d<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    e locale = ((f)paramc.q(f.class)).d(paramc);
    if (locale == null)
    {
      paramc.h(paramInt, j("fail:ComponentView is null.", null));
      return;
    }
    al.d(new c.1(this, locale, paramc, paramInt, paramJSONObject));
  }
  
  protected boolean aCb()
  {
    return false;
  }
  
  protected boolean aCc()
  {
    return false;
  }
  
  protected boolean b(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, g paramg)
  {
    return true;
  }
  
  protected boolean c(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.c
 * JD-Core Version:    0.7.0.1
 */