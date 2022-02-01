package com.tencent.mm.plugin.appbrand.jsapi.nfc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import d.a.ae;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.u;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.c>
{
  public static final int CTRL_INDEX = 793;
  public static final String NAME = "writeNdefMessage";
  public static final a kZu;
  
  static
  {
    AppMethodBeat.i(183668);
    kZu = new a((byte)0);
    AppMethodBeat.o(183668);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183667);
    if (paramc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
      AppMethodBeat.o(183667);
      return;
    }
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
      paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183667);
      return;
    }
    Object localObject1 = (com.tencent.mm.plugin.appbrand.jsapi.ad)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.ad.class);
    if ((localObject1 != null) && (!((com.tencent.mm.plugin.appbrand.jsapi.ad)localObject1).bin()))
    {
      paramc.h(paramInt, m("fail:user is not authorized", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183667);
      return;
    }
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kZM;
    com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c localc = c.a.w(paramc);
    if (localc == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
      paramc.h(paramInt, m("fail:unknown", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183667);
      return;
    }
    b localb = (b)new b(this, paramc, paramInt);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, appId: " + paramc.getAppId() + ", data: " + paramJSONObject);
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
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse uris failed since ".concat(String.valueOf(paramJSONObject)));
        paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13011)) })));
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
        p.g(localObject2, "get(index)");
        ((Collection)localObject1).add(localObject2.toString());
        i += 1;
      }
      paramJSONObject = (List)localObject1;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.las;
      paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.br(paramJSONObject);
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, m("fail:parse NdefMessage failed", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13012)) })));
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
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since ".concat(String.valueOf(paramJSONObject)));
        paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13011)) })));
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
        p.g(localObject1, "get(index)");
        paramJSONObject = (JSONObject)localObject1;
        if (!(localObject1 instanceof JSONObject)) {
          paramJSONObject = null;
        }
        paramJSONObject = (JSONObject)paramJSONObject;
        if (paramJSONObject == null)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since convert jsonObject failed");
          paramc.h(paramInt, m("fail:invalid parameter", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13011)) })));
          AppMethodBeat.o(183667);
          return;
        }
        localObject1 = new HashMap();
        Iterator localIterator = paramJSONObject.keys();
        p.g(localIterator, "keys()");
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Map localMap = (Map)localObject1;
          p.g(str, "it");
          Object localObject3 = paramJSONObject.get(str);
          p.g(localObject3, "get(it)");
          localMap.put(str, localObject3.toString());
        }
        localCollection.add((Map)localObject1);
        i += 1;
      }
      paramJSONObject = (List)localCollection;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.las;
      paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.bs(paramJSONObject);
      if (paramJSONObject == null)
      {
        paramc.h(paramInt, m("fail:parse NdefMessage failed", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13012)) })));
        AppMethodBeat.o(183667);
        return;
      }
      localc.a(paramJSONObject, localb);
      AppMethodBeat.o(183667);
      return;
    }
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.c.a.a(paramJSONObject, (b)o.c.kZw);
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.las;
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.b.c.G(paramJSONObject);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, m("fail:parse NdefMessage failed", (Map)ae.c(new d.o[] { u.S("errCode", Integer.valueOf(13012)) })));
      AppMethodBeat.o(183667);
      return;
    }
    localc.a(paramJSONObject, localb);
    AppMethodBeat.o(183667);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TEXTS", "PARAM_URIS", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.e<z>, z>
  {
    b(o paramo, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a.o
 * JD-Core Version:    0.7.0.1
 */