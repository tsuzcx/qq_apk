package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"})
public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.e>
{
  public static final int CTRL_INDEX = 793;
  public static final String NAME = "writeNdefMessage";
  public static final a pgx;
  
  static
  {
    AppMethodBeat.i(183668);
    pgx = new a((byte)0);
    AppMethodBeat.o(183668);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183667);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
      AppMethodBeat.o(183667);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
      parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183667);
      return;
    }
    Object localObject1 = (ai)com.tencent.luggage.a.e.K(ai.class);
    if ((localObject1 != null) && (!((ai)localObject1).bPK()))
    {
      parame.j(paramInt, m("fail:user is not authorized", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183667);
      return;
    }
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c localc = c.a.z(parame);
    if (localc == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
      parame.j(paramInt, m("fail:unknown", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183667);
      return;
    }
    b localb = (b)new b(this, parame, paramInt);
    Log.d("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, appId: " + parame.getAppId() + ", data: " + paramJSONObject);
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
          paramJSONObject = new t("null cannot be cast to non-null type org.json.JSONArray");
          AppMethodBeat.o(183667);
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse uris failed since ".concat(String.valueOf(paramJSONObject)));
        parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13011)) })));
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
        p.j(localObject2, "get(index)");
        ((Collection)localObject1).add(localObject2.toString());
        i += 1;
      }
      paramJSONObject = (List)localObject1;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.phw;
      paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.bE(paramJSONObject);
      if (paramJSONObject == null)
      {
        parame.j(paramInt, m("fail:parse NdefMessage failed", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13012)) })));
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
          paramJSONObject = new t("null cannot be cast to non-null type org.json.JSONArray");
          AppMethodBeat.o(183667);
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since ".concat(String.valueOf(paramJSONObject)));
        parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13011)) })));
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
        p.j(localObject1, "get(index)");
        paramJSONObject = (JSONObject)localObject1;
        if (!(localObject1 instanceof JSONObject)) {
          paramJSONObject = null;
        }
        paramJSONObject = (JSONObject)paramJSONObject;
        if (paramJSONObject == null)
        {
          Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since convert jsonObject failed");
          parame.j(paramInt, m("fail:invalid parameter", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13011)) })));
          AppMethodBeat.o(183667);
          return;
        }
        localObject1 = new HashMap();
        Iterator localIterator = paramJSONObject.keys();
        p.j(localIterator, "keys()");
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Map localMap = (Map)localObject1;
          p.j(str, "it");
          Object localObject3 = paramJSONObject.get(str);
          p.j(localObject3, "get(it)");
          localMap.put(str, localObject3.toString());
        }
        localCollection.add((Map)localObject1);
        i += 1;
      }
      paramJSONObject = (List)localCollection;
      localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.phw;
      paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.bF(paramJSONObject);
      if (paramJSONObject == null)
      {
        parame.j(paramInt, m("fail:parse NdefMessage failed", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13012)) })));
        AppMethodBeat.o(183667);
        return;
      }
      localc.a(paramJSONObject, localb);
      AppMethodBeat.o(183667);
      return;
    }
    paramJSONObject = a.a(paramJSONObject, (b)c.pgz);
    localObject1 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.phw;
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.J(paramJSONObject);
    if (paramJSONObject == null)
    {
      parame.j(paramInt, m("fail:parse NdefMessage failed", (Map)ae.g(new kotlin.o[] { s.M("errCode", Integer.valueOf(13012)) })));
      AppMethodBeat.o(183667);
      return;
    }
    localc.a(paramJSONObject, localb);
    AppMethodBeat.o(183667);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_TEXTS", "PARAM_URIS", "TAG", "luggage-commons-jsapi-nfc-ext_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.e<x>, x>
  {
    b(o paramo, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "invoke"})
  static final class c
    extends q
    implements b<Object, Object>
  {
    public static final c pgz;
    
    static
    {
      AppMethodBeat.i(241874);
      pgz = new c();
      AppMethodBeat.o(241874);
    }
    
    c()
    {
      super();
    }
    
    public final Object invoke(Object paramObject)
    {
      AppMethodBeat.i(241873);
      p.k(paramObject, "it");
      AppMethodBeat.o(241873);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.o
 * JD-Core Version:    0.7.0.1
 */