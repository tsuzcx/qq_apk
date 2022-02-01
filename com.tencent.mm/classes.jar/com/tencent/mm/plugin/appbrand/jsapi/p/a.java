package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.luggage.a.b;
import d.l;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "Lcom/tencent/luggage/base/ICustomize;", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "luggage-commons_release"})
public abstract interface a
  extends b
{
  public abstract c MX(String paramString);
  
  public abstract String U(JSONObject paramJSONObject);
  
  public abstract c a(JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.c paramc);
  
  public abstract c biC();
  
  public abstract c x(com.tencent.mm.plugin.appbrand.jsapi.c paramc);
  
  public abstract String y(com.tencent.mm.plugin.appbrand.jsapi.c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a
 * JD-Core Version:    0.7.0.1
 */