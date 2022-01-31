package com.tencent.mm.plugin.appbrand.n.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.m.a;
import com.tencent.mm.plugin.appbrand.t.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static a iul = null;
  
  public static JSONObject D(com.tencent.mm.plugin.appbrand.i parami)
  {
    AppMethodBeat.i(102190);
    localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appId", parami.mAppId);
      if (parami.wY() != null) {
        break label369;
      }
      i = 0;
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        localJSONObject2.put("maxWebsocketConcurrent", ((a)localObject).isr);
        localJSONObject2.put("socketDomains", com.tencent.luggage.g.i.B(((a)localObject).bDA));
        localJSONObject2.put("websocketSkipPortCheck", ((a)localObject).bDv);
        localJSONObject2.put("websocketTimeoutMS", ((a)localObject).iso);
        localJSONObject2.put("headerFilterMode", ((a)localObject).mode);
        localJSONObject2.put("blacklistHeaders", com.tencent.luggage.g.i.B(((a)localObject).iss));
        localJSONObject2.put("whitelistHeaders", com.tencent.luggage.g.i.B(((a)localObject).ist));
        localJSONObject2.put("referer", ((a)localObject).referer);
        localJSONObject2.put("canSkipCheckDomainsByArg", ((a)localObject).isl);
        localJSONObject2.put("shouldCheckDomains", ((a)localObject).ism);
        localJSONObject2.put("userAgentString", ((a)localObject).isv);
        localJSONObject1.put("networkConfig", localJSONObject2);
        localObject = (q.a)parami.U(q.a.class);
        if (localObject == null) {
          break label323;
        }
        localJSONObject2 = new JSONObject();
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          for (;;)
          {
            Object localObject;
            JSONObject localJSONObject2;
            localJSONObject2.put("nativeBufferSizeLimitByte", ((q.a)localObject).hhQ);
            localJSONObject2.put("itemBase64", ((q.a)localObject).iXX);
            localJSONObject2.put("itemID", ((q.a)localObject).iXW);
            localJSONObject2.put("itemKey", ((q.a)localObject).iXV);
            localJSONObject2.put("outKey", ((q.a)localObject).iXU);
            localJSONObject1.put("nativeBufferConfig", localJSONObject2);
            b(parami, localJSONObject1);
            if (iul != null) {
              iul.a(parami, localJSONObject1);
            }
            ab.v("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", new Object[] { localJSONObject1.toString() });
            AppMethodBeat.o(102190);
            return localJSONObject1;
            int i = parami.wY().hiX.gXf;
            continue;
            i = parami.wY().hiX.gXe;
            i += 1;
            continue;
            localJSONException1 = localJSONException1;
            ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", new Object[] { localJSONException1 });
          }
          localJSONException2 = localJSONException2;
          ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", new Object[] { localJSONException2 });
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", new Object[] { localJSONException3 });
          }
        }
      }
    }
    localJSONObject1.put("appversion", i);
    if (parami.wY() == null)
    {
      i = 0;
      localJSONObject1.put("appstate", i);
      localObject = (a)parami.U(a.class);
      if (localObject != null) {
        localJSONObject2 = new JSONObject();
      }
    }
  }
  
  public static void a(a parama)
  {
    iul = parama;
  }
  
  private static void b(com.tencent.mm.plugin.appbrand.i parami, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102191);
    if (!(parami.wX() instanceof s))
    {
      parami = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
      AppMethodBeat.o(102191);
      throw parami;
    }
    JSONObject localJSONObject = new JSONObject();
    parami = ((s)parami.wX()).had;
    int i = 0;
    for (;;)
    {
      if (i < parami.size())
      {
        Object localObject1 = (o)parami.get(i);
        Object localObject2;
        String str;
        long l;
        if ((localObject1 instanceof w))
        {
          localObject2 = (w)localObject1;
          localObject1 = ((w)localObject2).gZQ;
          str = ((w)localObject2).haj;
          l = ((w)localObject2).hak;
          ab.i("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", new Object[] { localObject1, str, Long.valueOf(l) });
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("rootPath", localObject1);
          ((JSONObject)localObject2).put("quota", l);
          localJSONObject.put(str, localObject2);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException });
          }
        }
      }
    }
    try
    {
      paramJSONObject.put("fsData", localJSONObject);
      AppMethodBeat.o(102191);
      return;
    }
    catch (JSONException parami)
    {
      ab.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { parami });
      AppMethodBeat.o(102191);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.i parami, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.b.b
 * JD-Core Version:    0.7.0.1
 */