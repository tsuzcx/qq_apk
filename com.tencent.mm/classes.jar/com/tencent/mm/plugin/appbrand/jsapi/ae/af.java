package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/system/PartOfGetSystemInfo_TypeSpecificInfo;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/IPartOfGetSystemInfo;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "infoProviders", "", "", "Lkotlin/Function2;", "Landroid/content/Context;", "", "", "", "getInfoProviders", "()Ljava/util/Map;", "get", "type", "component", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class af
  implements g<com.tencent.mm.plugin.appbrand.g>
{
  public final Map<String, Object> b(String paramString, com.tencent.mm.plugin.appbrand.g paramg)
  {
    s.u(paramString, "type");
    s.u(paramg, "component");
    Log.i("MicroMsg.AppBrand.GetSystemInfoNewLU", s.X("get#PartOfGetSystemInfo_TypeSpecificInfo, type: ", paramString));
    paramString = (m)cuT().get(paramString);
    if (paramString == null) {
      return null;
    }
    paramg = paramg.getContext();
    HashMap localHashMap = new HashMap();
    paramString.invoke(paramg, localHashMap);
    return (Map)localHashMap;
  }
  
  public abstract Map<String, m<Context, Map<String, Object>, ah>> cuT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.af
 * JD-Core Version:    0.7.0.1
 */