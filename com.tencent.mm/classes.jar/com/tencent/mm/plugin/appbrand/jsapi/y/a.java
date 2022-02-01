package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "Lcom/tencent/luggage/base/ICustomize;", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends b
{
  public abstract c C(f paramf);
  
  public abstract String D(f paramf);
  
  public abstract c a(JSONObject paramJSONObject, f paramf);
  
  public abstract c abv(String paramString);
  
  public abstract String at(JSONObject paramJSONObject);
  
  public abstract c cuq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a
 * JD-Core Version:    0.7.0.1
 */