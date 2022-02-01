package com.tencent.mm.plugin.appbrand.u.b;

import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.utils.x.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static a nkg = null;
  
  public static void a(a parama)
  {
    nkg = parama;
  }
  
  public static JSONObject ac(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147390);
    localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("appId", paramAppBrandRuntime.mAppId);
      if (paramAppBrandRuntime.OT() != null) {
        break label369;
      }
      i = 0;
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        localJSONObject2.put("maxWebsocketConcurrent", ((a)localObject).nhI);
        localJSONObject2.put("socketDomains", e.H(((a)localObject).cyU));
        localJSONObject2.put("websocketSkipPortCheck", ((a)localObject).cyP);
        localJSONObject2.put("websocketTimeoutMS", ((a)localObject).nhF);
        localJSONObject2.put("headerFilterMode", ((a)localObject).mode);
        localJSONObject2.put("blacklistHeaders", e.H(((a)localObject).nhJ));
        localJSONObject2.put("whitelistHeaders", e.H(((a)localObject).nhK));
        localJSONObject2.put("referer", ((a)localObject).referer);
        localJSONObject2.put("canSkipCheckDomainsByArg", ((a)localObject).nhC);
        localJSONObject2.put("shouldCheckDomains", ((a)localObject).nhD);
        localJSONObject2.put("userAgentString", ((a)localObject).nhM);
        localJSONObject1.put("networkConfig", localJSONObject2);
        localObject = (x.a)paramAppBrandRuntime.av(x.a.class);
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
            localJSONObject2.put("nativeBufferSizeLimitByte", ((x.a)localObject).ldb);
            localJSONObject2.put("itemBase64", ((x.a)localObject).ohn);
            localJSONObject2.put("itemID", ((x.a)localObject).ohm);
            localJSONObject2.put("itemKey", ((x.a)localObject).ohl);
            localJSONObject2.put("outKey", ((x.a)localObject).ohk);
            localJSONObject1.put("nativeBufferConfig", localJSONObject2);
            b(paramAppBrandRuntime, localJSONObject1);
            if (nkg != null) {
              nkg.a(paramAppBrandRuntime, localJSONObject1);
            }
            Log.v("MicroMsg.PrepareDataForNodeHelper", "prepareDataForNode :%s", new Object[] { localJSONObject1.toString() });
            AppMethodBeat.o(147390);
            return localJSONObject1;
            int i = paramAppBrandRuntime.OT().leE.pkgVersion;
            continue;
            i = paramAppBrandRuntime.OT().leE.kNW;
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
    if (paramAppBrandRuntime.OT() == null)
    {
      i = 0;
      localJSONObject1.put("appstate", i);
      localObject = (a)paramAppBrandRuntime.av(a.class);
      if (localObject != null) {
        localJSONObject2 = new JSONObject();
      }
    }
  }
  
  private static void b(AppBrandRuntime paramAppBrandRuntime, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147391);
    if (!(paramAppBrandRuntime.getFileSystem() instanceof v))
    {
      paramAppBrandRuntime = new IllegalStateException("getFileSystem not LuggageFileSystemRegistry");
      AppMethodBeat.o(147391);
      throw paramAppBrandRuntime;
    }
    JSONObject localJSONObject = new JSONObject();
    paramAppBrandRuntime = ((v)paramAppBrandRuntime.getFileSystem()).kTe;
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
          localObject1 = ((z)localObject4).kSr;
          localObject3 = ((z)localObject4).kTj;
          l = ((z)localObject4).kTk;
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
      Object localObject2 = (q)paramAppBrandRuntime.next();
      if ((localObject2 instanceof o))
      {
        localObject3 = (o)localObject2;
        localObject2 = ((o)localObject3).kSr;
        localObject3 = ((o)localObject3).kSq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b.b
 * JD-Core Version:    0.7.0.1
 */