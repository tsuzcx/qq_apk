package com.tencent.mm.plugin.appbrand.v.b;

import com.tencent.luggage.l.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ac;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.appstorage.u;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.t.a;
import com.tencent.mm.plugin.appbrand.utils.ae.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static a tqC = null;
  
  public static void a(a parama)
  {
    tqC = parama;
  }
  
  public static JSONObject aq(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147390);
    localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appId", paramAppBrandRuntime.mAppId);
      if (paramAppBrandRuntime.asG() != null) {
        break label369;
      }
      i = 0;
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        localJSONObject2.put("maxWebsocketConcurrent", ((a)localObject).tnd);
        localJSONObject2.put("socketDomains", d.bc(((a)localObject).epV));
        localJSONObject2.put("websocketSkipPortCheck", ((a)localObject).epM);
        localJSONObject2.put("websocketTimeoutMS", ((a)localObject).tna);
        localJSONObject2.put("headerFilterMode", ((a)localObject).mode);
        localJSONObject2.put("blacklistHeaders", d.bc(((a)localObject).tne));
        localJSONObject2.put("whitelistHeaders", d.bc(((a)localObject).tnf));
        localJSONObject2.put("referer", ((a)localObject).referer);
        localJSONObject2.put("canSkipCheckDomainsByArg", ((a)localObject).tmX);
        localJSONObject2.put("shouldCheckDomains", ((a)localObject).tmY);
        localJSONObject2.put("userAgentString", ((a)localObject).tnh);
        localJSONObject1.put("networkConfig", localJSONObject2);
        localObject = (ae.a)paramAppBrandRuntime.aN(ae.a.class);
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
            localJSONObject2.put("nativeBufferSizeLimitByte", ((ae.a)localObject).qXa);
            localJSONObject2.put("itemBase64", ((ae.a)localObject).urq);
            localJSONObject2.put("itemID", ((ae.a)localObject).urp);
            localJSONObject2.put("itemKey", ((ae.a)localObject).uro);
            localJSONObject2.put("outKey", ((ae.a)localObject).urn);
            localJSONObject1.put("nativeBufferConfig", localJSONObject2);
            b(paramAppBrandRuntime, localJSONObject1);
            if (tqC != null) {
              tqC.a(paramAppBrandRuntime, localJSONObject1);
            }
            Log.v("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", new Object[] { localJSONObject1.toString() });
            AppMethodBeat.o(147390);
            return localJSONObject1;
            int i = paramAppBrandRuntime.asG().qYY.pkgVersion;
            continue;
            i = paramAppBrandRuntime.asG().qYY.qHO;
            i += 1;
            continue;
            localJSONException1 = localJSONException1;
            Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareCommonData e:%s", new Object[] { localJSONException1 });
          }
          localJSONException2 = localJSONException2;
          Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareNetworkConfigData e:%s", new Object[] { localJSONException2 });
        }
        catch (JSONException localJSONException3)
        {
          for (;;)
          {
            Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareNativeBufferConfigData e:%s", new Object[] { localJSONException3 });
          }
        }
      }
    }
    localJSONObject1.put("appversion", i);
    if (paramAppBrandRuntime.asG() == null)
    {
      i = 0;
      localJSONObject1.put("appstate", i);
      localObject = (a)paramAppBrandRuntime.aN(a.class);
      if (localObject != null) {
        localJSONObject2 = new JSONObject();
      }
    }
  }
  
  private static void b(AppBrandRuntime paramAppBrandRuntime, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147391);
    if (!(paramAppBrandRuntime.getFileSystem() instanceof ac))
    {
      paramAppBrandRuntime = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
      AppMethodBeat.o(147391);
      throw paramAppBrandRuntime;
    }
    JSONObject localJSONObject = new JSONObject();
    paramAppBrandRuntime = ((ac)paramAppBrandRuntime.getFileSystem()).qNv;
    int i = 0;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      if (i < paramAppBrandRuntime.size())
      {
        Object localObject1 = (w)paramAppBrandRuntime.get(i);
        long l;
        if ((localObject1 instanceof af))
        {
          localObject4 = (af)localObject1;
          localObject1 = ((af)localObject4).qMI;
          localObject3 = ((af)localObject4).qNA;
          l = ((af)localObject4).qNB;
          Log.i("MicroMsg.PrepareDataForNodeHelper", "prepareFSData rootPath:%s pathPrefix:%s quota:%d", new Object[] { localObject1, localObject3, Long.valueOf(l) });
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
            Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException1 });
          }
        }
      }
    }
    paramAppBrandRuntime = paramAppBrandRuntime.iterator();
    while (paramAppBrandRuntime.hasNext())
    {
      Object localObject2 = (w)paramAppBrandRuntime.next();
      if ((localObject2 instanceof u))
      {
        localObject3 = (u)localObject2;
        localObject2 = ((u)localObject3).qMI;
        localObject3 = ((u)localObject3).qMH;
        try
        {
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("type", 0);
          ((JSONObject)localObject4).put("rootPath", localObject2);
          localJSONObject.put((String)localObject3, localObject4);
        }
        catch (JSONException localJSONException2)
        {
          Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { localJSONException2 });
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
      Log.e("MicroMsg.PrepareDataForNodeHelper", "prepareFSData e:%s", new Object[] { paramAppBrandRuntime });
      AppMethodBeat.o(147391);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(AppBrandRuntime paramAppBrandRuntime, JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.b.b
 * JD-Core Version:    0.7.0.1
 */