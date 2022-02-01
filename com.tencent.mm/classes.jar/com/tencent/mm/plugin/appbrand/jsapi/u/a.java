package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "Lcom/tencent/luggage/base/ICustomize;", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "luggage-commons_release"})
public abstract interface a
  extends b
{
  public abstract c a(JSONObject paramJSONObject, f paramf);
  
  public abstract c aaF(String paramString);
  
  public abstract String af(JSONObject paramJSONObject);
  
  public abstract c bIw();
  
  public abstract c x(f paramf);
  
  public abstract String y(f paramf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.a
 * JD-Core Version:    0.7.0.1
 */