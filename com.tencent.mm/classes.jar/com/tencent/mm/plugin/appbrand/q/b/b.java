package com.tencent.mm.plugin.appbrand.q.b;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.p.a;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static a lyq = null;
  
  public static void a(a parama)
  {
    lyq = parama;
  }
  
  public static JSONObject ah(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147390);
    localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appId", paramAppBrandRuntime.mAppId);
      if (paramAppBrandRuntime.DI() != null) {
        break label369;
      }
      i = 0;
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        localJSONObject2.put("maxWebsocketConcurrent", ((a)localObject).lwd);
        localJSONObject2.put("socketDomains", d.D(((a)localObject).ccF));
        localJSONObject2.put("websocketSkipPortCheck", ((a)localObject).ccA);
        localJSONObject2.put("websocketTimeoutMS", ((a)localObject).lwa);
        localJSONObject2.put("headerFilterMode", ((a)localObject).mode);
        localJSONObject2.put("blacklistHeaders", d.D(((a)localObject).lwe));
        localJSONObject2.put("whitelistHeaders", d.D(((a)localObject).lwf));
        localJSONObject2.put("referer", ((a)localObject).referer);
        localJSONObject2.put("canSkipCheckDomainsByArg", ((a)localObject).lvX);
        localJSONObject2.put("shouldCheckDomains", ((a)localObject).lvY);
        localJSONObject2.put("userAgentString", ((a)localObject).lwh);
        localJSONObject1.put("networkConfig", localJSONObject2);
        localObject = (v.a)paramAppBrandRuntime.ar(v.a.class);
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
            localJSONObject2.put("nativeBufferSizeLimitByte", ((v.a)localObject).jCN);
            localJSONObject2.put("itemBase64", ((v.a)localObject).moF);
            localJSONObject2.put("itemID", ((v.a)localObject).moE);
            localJSONObject2.put("itemKey", ((v.a)localObject).moD);
            localJSONObject2.put("outKey", ((v.a)localObject).moC);
            localJSONObject1.put("nativeBufferConfig", localJSONObject2);
            b(paramAppBrandRuntime, localJSONObject1);
            if (lyq != null) {
              lyq.a(paramAppBrandRuntime, localJSONObject1);
            }
            ac.v("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", new Object[] { localJSONObject1.toString() });
            AppMethodBeat.o(147390);
            return localJSONObject1;
            int i = paramAppBrandRuntime.DI().jEg.pkgVersion;
            continue;
            i = paramAppBrandRuntime.DI().jEg.jpa;
            i += 1;
            continue;
            localJSONException1 = localJSONException1;
            ac.e("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", new Object[] { localJSONException1 });
          }
          localJSONException2 = localJSONException2;
          ac.e("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", new Object[] { localJSONException2 });
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            ac.e("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", new Object[] { localJSONException3 });
          }
        }
      }
    }
    localJSONObject1.put("appversion", i);
    if (paramAppBrandRuntime.DI() == null)
    {
      i = 0;
      localJSONObject1.put("appstate", i);
      localObject = (a)paramAppBrandRuntime.ar(a.class);
      if (localObject != null) {
        localJSONObject2 = new JSONObject();
      }
    }
  }
  
  private static void b(AppBrandRuntime paramAppBrandRuntime, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147391);
    if (!(paramAppBrandRuntime.DH() instanceof t))
    {
      paramAppBrandRuntime = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
      AppMethodBeat.o(147391);
      throw paramAppBrandRuntime;
    }
    JSONObject localJSONObject = new JSONObject();
    paramAppBrandRuntime = ((t)paramAppBrandRuntime.DH()).jti;
    int i = 0;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      if (i < paramAppBrandRuntime.size())
      {
        Object localObject1 = (p)paramAppBrandRuntime.get(i);
        long l;
        if ((localObject1 instanceof x))
        {
          localObject4 = (x)localObject1;
          localObject1 = ((x)localObject4).jsT;
          localObject3 = ((x)localObject4).jto;
          l = ((x)localObject4).jtp;
          ac.i("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", new Object[] { localObject1, localObject3, Long.valueOf(l) });
        }
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("type", 1);
          ((JSONObject)localObject4).put("rootPath", localObject1);
          ((JSONObject)localObject4).put("quota", l);
          localJSONObject.put((String)localObject3, localObject4);
          i += 1;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            ac.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException1 });
          }
        }
      }
    }
    paramAppBrandRuntime = paramAppBrandRuntime.iterator();
    while (paramAppBrandRuntime.hasNext())
    {
      Object localObject2 = (p)paramAppBrandRuntime.next();
      if ((localObject2 instanceof n))
      {
        localObject3 = (n)localObject2;
        localObject2 = ((n)localObject3).jsT;
        localObject3 = ((n)localObject3).jsV;
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("type", 0);
          ((JSONObject)localObject4).put("rootPath", localObject2);
          localJSONObject.put((String)localObject3, localObject4);
        }
        catch (JSONException localJSONException2)
        {
          ac.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException2 });
        }
      }
    }
    try
    {
      paramJSONObject.put("fsData", localJSONObject);
      AppMethodBeat.o(147391);
      return;
    }
    catch (JSONException paramAppBrandRuntime)
    {
      ac.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { paramAppBrandRuntime });
      AppMethodBeat.o(147391);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AppBrandRuntime paramAppBrandRuntime, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.b.b
 * JD-Core Version:    0.7.0.1
 */