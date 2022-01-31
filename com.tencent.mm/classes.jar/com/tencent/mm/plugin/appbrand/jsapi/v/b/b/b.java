package com.tencent.mm.plugin.appbrand.jsapi.v.b.b;

import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.luggage.xweb_ext.extendplugin.component.a.b.a.b
{
  private com.tencent.mm.plugin.appbrand.f.b iiC;
  
  private void a(ai paramai, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140060);
    if ((!paramai.getName().equalsIgnoreCase("onXWebLivePusherEvent")) && (!paramai.getName().equalsIgnoreCase("onXWebLivePusherNetStatus"))) {
      ab.i("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "dispatch event:%s, data:%s", new Object[] { paramai.getName(), paramJSONObject.toString() });
    }
    paramai = paramai.BN(paramJSONObject.toString());
    if (this.iiC != null)
    {
      paramJSONObject = this.iiC.hrA;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof r))
        {
          ((r)paramJSONObject).b(paramai);
          AppMethodBeat.o(140060);
          return;
        }
        if ((paramJSONObject instanceof v))
        {
          ((v)paramJSONObject).b(paramai);
          AppMethodBeat.o(140060);
          return;
        }
        paramJSONObject.b(paramai);
      }
    }
    AppMethodBeat.o(140060);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(140059);
    b.d locald = new b.d((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      localJSONObject.put("errMsg", bo.nullAsNil(paramString));
      if (!paramHashMap.isEmpty()) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
      a(locald, localJSONObject);
      AppMethodBeat.o(140059);
      return;
    }
    catch (JSONException paramString)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherError fail", new Object[] { paramString });
      AppMethodBeat.o(140059);
    }
  }
  
  public final void b(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(140054);
    b.e locale = new b.e((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      if (paramBundle == null) {}
      for (paramBundle = "";; paramBundle = paramBundle.getString("EVT_MSG"))
      {
        localJSONObject.put("errMsg", paramBundle);
        a(locale, localJSONObject);
        AppMethodBeat.o(140054);
        return;
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherEvent fail", new Object[] { paramBundle });
      AppMethodBeat.o(140054);
    }
  }
  
  public final void bH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140058);
    b.a locala = new b.a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      a(locala, localJSONObject);
      AppMethodBeat.o(140058);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(140058);
    }
  }
  
  public final void d(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(140055);
    b.f localf = new b.f((byte)0);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("viewId", paramInt);
      JSONObject localJSONObject2 = new JSONObject();
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramBundle.get(str));
        }
      }
      localJSONObject1.put("info", localJSONObject2);
    }
    catch (JSONException paramBundle)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherNetStatus fail", new Object[] { paramBundle });
      AppMethodBeat.o(140055);
      return;
    }
    a(localf, localJSONObject1);
    AppMethodBeat.o(140055);
  }
  
  public final void d(a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.f.b)) {
      this.iiC = ((com.tencent.mm.plugin.appbrand.f.b)parama);
    }
  }
  
  public final void f(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(140057);
    b.b localb = new b.b((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      a(localb, localJSONObject);
      AppMethodBeat.o(140057);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(140057);
    }
  }
  
  public final void fB(int paramInt)
  {
    AppMethodBeat.i(140056);
    b.c localc = new b.c((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt);
      a(localc, localJSONObject);
      AppMethodBeat.o(140056);
      return;
    }
    catch (JSONException localJSONException)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMStart fail", new Object[] { localJSONException });
      AppMethodBeat.o(140056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b.b.b
 * JD-Core Version:    0.7.0.1
 */