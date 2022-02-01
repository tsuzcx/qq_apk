package com.tencent.mm.plugin.appbrand.q.b;

import com.tencent.luggage.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.o.a;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static a mcv = null;
  
  public static void a(a parama)
  {
    mcv = parama;
  }
  
  public static JSONObject ab(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147390);
    localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appId", paramAppBrandRuntime.mAppId);
      if (paramAppBrandRuntime.Fm() != null) {
        break label369;
      }
      i = 0;
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        localJSONObject2.put("maxWebsocketConcurrent", ((a)localObject).lZT);
        localJSONObject2.put("socketDomains", d.D(((a)localObject).cmY));
        localJSONObject2.put("websocketSkipPortCheck", ((a)localObject).cmT);
        localJSONObject2.put("websocketTimeoutMS", ((a)localObject).lZQ);
        localJSONObject2.put("headerFilterMode", ((a)localObject).mode);
        localJSONObject2.put("blacklistHeaders", d.D(((a)localObject).lZU));
        localJSONObject2.put("whitelistHeaders", d.D(((a)localObject).lZV));
        localJSONObject2.put("referer", ((a)localObject).referer);
        localJSONObject2.put("canSkipCheckDomainsByArg", ((a)localObject).lZN);
        localJSONObject2.put("shouldCheckDomains", ((a)localObject).lZO);
        localJSONObject2.put("userAgentString", ((a)localObject).lZX);
        localJSONObject1.put("networkConfig", localJSONObject2);
        localObject = (x.a)paramAppBrandRuntime.ar(x.a.class);
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
            localJSONObject2.put("nativeBufferSizeLimitByte", ((x.a)localObject).jZY);
            localJSONObject2.put("itemBase64", ((x.a)localObject).mUm);
            localJSONObject2.put("itemID", ((x.a)localObject).mUl);
            localJSONObject2.put("itemKey", ((x.a)localObject).mUk);
            localJSONObject2.put("outKey", ((x.a)localObject).mUj);
            localJSONObject1.put("nativeBufferConfig", localJSONObject2);
            b(paramAppBrandRuntime, localJSONObject1);
            if (mcv != null) {
              mcv.a(paramAppBrandRuntime, localJSONObject1);
            }
            ae.v("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", new Object[] { localJSONObject1.toString() });
            AppMethodBeat.o(147390);
            return localJSONObject1;
            int i = paramAppBrandRuntime.Fm().kbw.pkgVersion;
            continue;
            i = paramAppBrandRuntime.Fm().kbw.jLV;
            i += 1;
            continue;
            localJSONException1 = localJSONException1;
            ae.e("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", new Object[] { localJSONException1 });
          }
          localJSONException2 = localJSONException2;
          ae.e("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", new Object[] { localJSONException2 });
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            ae.e("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", new Object[] { localJSONException3 });
          }
        }
      }
    }
    localJSONObject1.put("appversion", i);
    if (paramAppBrandRuntime.Fm() == null)
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
    if (!(paramAppBrandRuntime.Fl() instanceof v))
    {
      paramAppBrandRuntime = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
      AppMethodBeat.o(147391);
      throw paramAppBrandRuntime;
    }
    JSONObject localJSONObject = new JSONObject();
    paramAppBrandRuntime = ((v)paramAppBrandRuntime.Fl()).jQv;
    int i = 0;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      if (i < paramAppBrandRuntime.size())
      {
        Object localObject1 = (q)paramAppBrandRuntime.get(i);
        long l;
        if ((localObject1 instanceof z))
        {
          localObject4 = (z)localObject1;
          localObject1 = ((z)localObject4).jPJ;
          localObject3 = ((z)localObject4).jQz;
          l = ((z)localObject4).jQA;
          ae.i("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", new Object[] { localObject1, localObject3, Long.valueOf(l) });
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
            ae.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException1 });
          }
        }
      }
    }
    paramAppBrandRuntime = paramAppBrandRuntime.iterator();
    while (paramAppBrandRuntime.hasNext())
    {
      Object localObject2 = (q)paramAppBrandRuntime.next();
      if ((localObject2 instanceof o))
      {
        localObject3 = (o)localObject2;
        localObject2 = ((o)localObject3).jPJ;
        localObject3 = ((o)localObject3).jPI;
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("type", 0);
          ((JSONObject)localObject4).put("rootPath", localObject2);
          localJSONObject.put((String)localObject3, localObject4);
        }
        catch (JSONException localJSONException2)
        {
          ae.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException2 });
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
      ae.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { paramAppBrandRuntime });
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