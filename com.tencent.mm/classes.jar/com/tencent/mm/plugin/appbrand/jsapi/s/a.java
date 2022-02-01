package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.luggage.a.b;
import d.l;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "Lcom/tencent/luggage/base/ICustomize;", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "luggage-commons_release"})
public abstract interface a
  extends b
{
  public abstract c Qu(String paramString);
  
  public abstract String W(JSONObject paramJSONObject);
  
  public abstract c a(JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.c paramc);
  
  public abstract c bmo();
  
  public abstract c x(com.tencent.mm.plugin.appbrand.jsapi.c paramc);
  
  public abstract String y(com.tencent.mm.plugin.appbrand.jsapi.c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.a
 * JD-Core Version:    0.7.0.1
 */