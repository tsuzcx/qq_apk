package com.tencent.mm.plugin.appbrand.jsapi.nfc.rw;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.j;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.h;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/JsApiWriteNdefMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.c<f>
{
  public static final int CTRL_INDEX = 793;
  public static final String NAME = "writeNdefMessage";
  public static final o.a slR;
  
  static
  {
    AppMethodBeat.i(183668);
    slR = new o.a((byte)0);
    AppMethodBeat.o(183668);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(183667);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, env is null");
      AppMethodBeat.o(183667);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, data is null");
      paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
      AppMethodBeat.o(183667);
      return;
    }
    Object localObject1 = (al)e.T(al.class);
    if ((localObject1 != null) && (!((al)localObject1).cpS()))
    {
      paramf.callback(paramInt, j.a((p)this, 13019, "fail:user is not authorized", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13019)) })));
      AppMethodBeat.o(183667);
      return;
    }
    localObject1 = g.smq;
    localObject1 = g.a.B(paramf);
    if (localObject1 == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, can not get activity");
      paramf.callback(paramInt, j.a((p)this, 13010, "fail:unknown", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13010)) })));
      AppMethodBeat.o(183667);
      return;
    }
    b localb = (b)new b(paramf, paramInt, this);
    Log.d("MicroMsg.AppBrand.JsApiWriteNdefMessage", "invoke, appId: " + paramf.getAppId() + ", data: " + paramJSONObject);
    Object localObject2;
    int i;
    int k;
    int j;
    Object localObject3;
    if (paramJSONObject.has("uris"))
    {
      try
      {
        paramJSONObject = paramJSONObject.get("uris");
        if (paramJSONObject == null)
        {
          paramJSONObject = new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
          AppMethodBeat.o(183667);
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", s.X("parse uris failed since ", paramJSONObject));
        paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183667);
        return;
      }
      paramJSONObject = (JSONArray)paramJSONObject;
      localObject2 = (Collection)new ArrayList(paramJSONObject.length());
      i = 0;
      k = paramJSONObject.length();
      if (k > 0)
      {
        j = i + 1;
        localObject3 = paramJSONObject.get(i);
        s.s(localObject3, "get(index)");
        ((Collection)localObject2).add(localObject3.toString());
        if (j < k) {}
      }
      else
      {
        paramJSONObject = (List)localObject2;
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.smP;
        paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.dp(paramJSONObject);
        if (paramJSONObject == null)
        {
          paramf.callback(paramInt, j.a((p)this, 13012, "fail:parse NdefMessage failed", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13012)) })));
          AppMethodBeat.o(183667);
          return;
        }
        ((g)localObject1).a(paramJSONObject, localb);
        AppMethodBeat.o(183667);
      }
    }
    else if (paramJSONObject.has("texts"))
    {
      try
      {
        paramJSONObject = paramJSONObject.get("texts");
        if (paramJSONObject == null)
        {
          paramJSONObject = new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
          AppMethodBeat.o(183667);
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", s.X("parse texts failed since ", paramJSONObject));
        paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183667);
        return;
      }
      localObject2 = (JSONArray)paramJSONObject;
      localObject3 = (Collection)new ArrayList(((JSONArray)localObject2).length());
      i = 0;
      k = ((JSONArray)localObject2).length();
      if (k > 0)
      {
        label671:
        j = i + 1;
        paramJSONObject = ((JSONArray)localObject2).get(i);
        s.s(paramJSONObject, "get(index)");
        if (!(paramJSONObject instanceof JSONObject)) {
          break label1062;
        }
      }
    }
    label1062:
    for (paramJSONObject = (JSONObject)paramJSONObject;; paramJSONObject = null)
    {
      if (paramJSONObject == null)
      {
        Log.w("MicroMsg.AppBrand.JsApiWriteNdefMessage", "parse texts failed since convert jsonObject failed");
        paramf.callback(paramInt, j.a((p)this, 13011, "fail:invalid parameter", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13011)) })));
        AppMethodBeat.o(183667);
        return;
      }
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramJSONObject.keys();
      s.s(localIterator, "keys()");
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Map localMap = (Map)localHashMap;
        s.s(str, "it");
        Object localObject4 = paramJSONObject.get(str);
        s.s(localObject4, "get(it)");
        localMap.put(str, localObject4.toString());
      }
      ((Collection)localObject3).add((Map)localHashMap);
      if (j >= k)
      {
        paramJSONObject = (List)localObject3;
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.smP;
        paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.dq(paramJSONObject);
        if (paramJSONObject == null)
        {
          paramf.callback(paramInt, j.a((p)this, 13012, "fail:parse NdefMessage failed", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13012)) })));
          AppMethodBeat.o(183667);
          return;
        }
        ((g)localObject1).a(paramJSONObject, localb);
        AppMethodBeat.o(183667);
        return;
        paramJSONObject = a.a(paramJSONObject, (b)o.c.slT);
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.smP;
        paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.a.c.Q(paramJSONObject);
        if (paramJSONObject == null)
        {
          paramf.callback(paramInt, j.a((p)this, 13012, "fail:parse NdefMessage failed", (Map)ak.g(new r[] { v.Y("errCode", Integer.valueOf(13012)) })));
          AppMethodBeat.o(183667);
          return;
        }
        ((g)localObject1).a(paramJSONObject, localb);
        AppMethodBeat.o(183667);
        return;
      }
      i = j;
      break label671;
      i = j;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<h<ah>, ah>
  {
    b(f paramf, int paramInt, o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.o
 * JD-Core Version:    0.7.0.1
 */