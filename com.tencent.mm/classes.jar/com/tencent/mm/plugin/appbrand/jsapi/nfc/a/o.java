package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.ae;
import d.g.a.b;
import d.g.b.k;
import d.u;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 793;
  public static final String NAME = "writeNdefMessage";
  public static final a kDn;
  
  static
  {
    AppMethodBeat.i(183668);
    kDn = new a((byte)0);
    AppMethodBeat.o(183668);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183667);
    if (paramc == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
      AppMethodBeat.o(183667);
      return;
    }
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
      paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183667);
      return;
    }
    Object localObject1 = (ad)com.tencent.luggage.a.e.K(ad.class);
    if ((localObject1 != null) && (!((ad)localObject1).beJ()))
    {
      paramc.h(paramInt, k("fail:user is not authorized", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183667);
      return;
    }
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kDD;
    com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c localc = c.a.w(paramc);
    if (localc == null)
    {
      ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
      paramc.h(paramInt, k("fail:unknown", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183667);
      return;
    }
    b localb = (b)new b(this, paramc, paramInt);
    ac.d("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
    int i;
    int j;
    Object localObject2;
    if (paramJSONObject.has("uris"))
    {
      try
      {
        paramJSONObject = paramJSONObject.get("uris");
        if (paramJSONObject == null)
        {
          paramJSONObject = new v("null cannot be cast to non-null type org.json.JSONArray");
          AppMethodBeat.o(183667);
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse uris failed since ".concat(String.valueOf(paramJSONObject)));
        paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183667);
        return;
      }
      paramJSONObject = (JSONArray)paramJSONObject;
      localObject1 = (Collection)new ArrayList(paramJSONObject.length());
      i = 0;
      j = paramJSONObject.length();
      while (i < j)
      {
        localObject2 = paramJSONObject.get(i);
        k.g(localObject2, "get(index)");
        ((Collection)localObject1).add(localObject2.toString());
        i += 1;
      }
      paramJSONObject = (List)localObject1;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.kEj;
      paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.bp(paramJSONObject);
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, k("fail:parse NdefMessage failed", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13012)) })));
        AppMethodBeat.o(183667);
        return;
      }
      localc.a(paramJSONObject, localb);
      AppMethodBeat.o(183667);
      return;
    }
    if (paramJSONObject.has("texts"))
    {
      try
      {
        paramJSONObject = paramJSONObject.get("texts");
        if (paramJSONObject == null)
        {
          paramJSONObject = new v("null cannot be cast to non-null type org.json.JSONArray");
          AppMethodBeat.o(183667);
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since ".concat(String.valueOf(paramJSONObject)));
        paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183667);
        return;
      }
      localObject2 = (JSONArray)paramJSONObject;
      Collection localCollection = (Collection)new ArrayList(((JSONArray)localObject2).length());
      j = ((JSONArray)localObject2).length();
      i = 0;
      while (i < j)
      {
        localObject1 = ((JSONArray)localObject2).get(i);
        k.g(localObject1, "get(index)");
        paramJSONObject = (JSONObject)localObject1;
        if (!(localObject1 instanceof JSONObject)) {
          paramJSONObject = null;
        }
        paramJSONObject = (JSONObject)paramJSONObject;
        if (paramJSONObject == null)
        {
          ac.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since convert jsonObject failed");
          paramc.h(paramInt, k("fail:invalid parameter", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13011)) })));
          AppMethodBeat.o(183667);
          return;
        }
        localObject1 = new HashMap();
        Iterator localIterator = paramJSONObject.keys();
        k.g(localIterator, "keys()");
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Map localMap = (Map)localObject1;
          k.g(str, "it");
          Object localObject3 = paramJSONObject.get(str);
          k.g(localObject3, "get(it)");
          localMap.put(str, localObject3.toString());
        }
        localCollection.add((Map)localObject1);
        i += 1;
      }
      paramJSONObject = (List)localCollection;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.kEj;
      paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.bq(paramJSONObject);
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, k("fail:parse NdefMessage failed", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13012)) })));
        AppMethodBeat.o(183667);
        return;
      }
      localc.a(paramJSONObject, localb);
      AppMethodBeat.o(183667);
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.c.a.a(paramJSONObject, (b)c.kDp);
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.kEj;
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.G(paramJSONObject);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, k("fail:parse NdefMessage failed", (Map)ae.c(new d.o[] { u.Q("errCode", Integer.valueOf(13012)) })));
      AppMethodBeat.o(183667);
      return;
    }
    localc.a(paramJSONObject, localb);
    AppMethodBeat.o(183667);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TEXTS", "PARAM_URIS", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<y>, y>
  {
    b(o paramo, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<Object, Object>
  {
    public static final c kDp;
    
    static
    {
      AppMethodBeat.i(200898);
      kDp = new c();
      AppMethodBeat.o(200898);
    }
    
    c()
    {
      super();
    }
    
    public final Object ay(Object paramObject)
    {
      AppMethodBeat.i(200897);
      k.h(paramObject, "it");
      AppMethodBeat.o(200897);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.o
 * JD-Core Version:    0.7.0.1
 */