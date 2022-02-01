package com.tencent.mm.plugin.appbrand.game.preload;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.q.d.b;
import com.tencent.mm.plugin.appbrand.q.d.c;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.plugin.appbrand.t.l;
import com.tencent.mm.plugin.appbrand.t.l.1;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static volatile d rsy;
  public boolean hasInit;
  public com.tencent.mm.plugin.appbrand.w qxC;
  public com.tencent.mm.plugin.appbrand.t.a rsA;
  public com.tencent.mm.plugin.appbrand.appstorage.w rsB;
  public c rsC;
  public CopyOnWriteArrayList<String> rsD;
  public boolean rsE;
  public AtomicInteger rsF;
  public AtomicInteger rsG;
  public AtomicInteger rsH;
  public AtomicInteger rsI;
  public l rsz;
  
  private d()
  {
    AppMethodBeat.i(45286);
    this.hasInit = false;
    this.rsD = new CopyOnWriteArrayList();
    this.rsE = false;
    AppMethodBeat.o(45286);
  }
  
  public static void E(com.tencent.mm.plugin.appbrand.w paramw)
  {
    AppMethodBeat.i(318480);
    Iterator localIterator;
    try
    {
      if ((rsy == null) || (rsy.qxC != paramw)) {
        break label229;
      }
      if (rsy.rsz == null) {
        break label222;
      }
      paramw = rsy.rsz;
      synchronized (paramw.tnp)
      {
        localIterator = paramw.tnp.iterator();
        if (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.appbrand.t.a.b)localIterator.next()).Uz = false;
        }
      }
      paramw.tnp.clear();
    }
    finally
    {
      AppMethodBeat.o(318480);
    }
    synchronized (paramw.tot)
    {
      localIterator = paramw.tot.iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.t.a.b)localIterator.next()).Uz = false;
      }
    }
    paramw.tot.clear();
    synchronized (paramw.tos)
    {
      paramw.tos.clear();
      rsy.rsz = null;
      rsy.rsC = null;
      rsy.rsA = null;
      rsy.rsB = null;
      rsy.qxC = null;
      label222:
      rsy.hasInit = false;
      label229:
      AppMethodBeat.o(318480);
      return;
    }
  }
  
  public static String bQs()
  {
    AppMethodBeat.i(45289);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.t.c.cCh();
    localObject = com.tencent.mm.plugin.appbrand.t.c.cCg();
    AppMethodBeat.o(45289);
    return localObject;
  }
  
  public static d cpg()
  {
    AppMethodBeat.i(45287);
    if (rsy == null) {}
    try
    {
      if (rsy == null) {
        rsy = new d();
      }
      d locald = rsy;
      AppMethodBeat.o(45287);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(45287);
    }
  }
  
  public static void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(45291);
    e.cpi().rsS = paramBoolean;
    AppMethodBeat.o(45291);
  }
  
  public final boolean ZA(String paramString)
  {
    AppMethodBeat.i(318511);
    synchronized (this.rsD)
    {
      if ((this.rsD != null) && (this.rsD.contains(paramString)))
      {
        Log.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", new Object[] { paramString, Integer.valueOf(this.rsD.size()) });
        this.rsI.addAndGet(1);
        AppMethodBeat.o(318511);
        return true;
      }
      ??? = this.rsz;
      if ((??? != null) && (((l)???).aei(paramString).booleanValue()))
      {
        AppMethodBeat.o(318511);
        return true;
      }
    }
    AppMethodBeat.o(318511);
    return false;
  }
  
  public final void cph()
  {
    AppMethodBeat.i(45290);
    if ((this.rsD != null) && (this.rsD.size() == 0))
    {
      if ((this.qxC == null) || (this.qxC.getAppConfig() == null))
      {
        Log.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
        AppMethodBeat.o(45290);
        return;
      }
      Object localObject1 = this.qxC.getAppConfig();
      Object localObject2 = this.qxC.mAppId;
      localObject1 = ((com.tencent.mm.plugin.appbrand.config.b)localObject1).qVN;
      int i;
      if (localObject1 == null)
      {
        i = 0;
        Log.i("MicroMsg.WAGamePreloadManager", "predownload subPackage size:%d", new Object[] { Integer.valueOf(i) });
        if (localObject1 != null) {
          localObject2 = ((ArrayList)localObject1).iterator();
        }
      }
      else
      {
        for (;;)
        {
          label106:
          if (!((Iterator)localObject2).hasNext()) {
            break label398;
          }
          localObject1 = (String)((Iterator)localObject2).next();
          Log.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", new Object[] { localObject1 });
          Object localObject3 = this.qxC;
          if ((localObject3 == null) || (((com.tencent.mm.plugin.appbrand.w)localObject3).ccM() == null))
          {
            if (localObject3 == null) {}
            for (localObject1 = "";; localObject1 = ((AppBrandRuntime)localObject3).mAppId)
            {
              Log.e("MicroMsg.WAGamePreloadManager", "runtime(%s) or sysConfig null", new Object[] { localObject1 });
              break label106;
              i = ((ArrayList)localObject1).size();
              break;
            }
          }
          if ((((AppBrandRuntime)localObject3).ccV) || (((AppBrandRuntime)localObject3).qsE.get()))
          {
            Log.e("MicroMsg.WAGamePreloadManager", "runtime(%s) finishing", new Object[] { ((AppBrandRuntime)localObject3).mAppId });
          }
          else
          {
            bl.Q((AppBrandRuntime)localObject3);
            Object localObject4 = (ModulePkgInfo)g.i(((com.tencent.mm.plugin.appbrand.w)localObject3).ccM().qYY.qHR, (String)localObject1);
            if ((localObject4 == null) || (TextUtils.isEmpty(((ModulePkgInfo)localObject4).md5)))
            {
              Log.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage with appId:%s, moduleName:%s, get invalid module obj", new Object[] { ((AppBrandRuntime)localObject3).mAppId, localObject1 });
            }
            else if (d.c.tmk == null)
            {
              Log.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
            }
            else
            {
              localObject4 = ((com.tencent.mm.plugin.appbrand.w)localObject3).ccM().qYY.cR(((AppBrandRuntime)localObject3).mAppId, ((ModulePkgInfo)localObject4).name);
              localObject3 = d.c.tmk.k((AppBrandRuntime)localObject3, (String)localObject4);
              if (localObject3 != null)
              {
                ((com.tencent.mm.plugin.appbrand.q.d)localObject3).a(new d.b()
                {
                  public final void a(androidx.a.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
                  {
                    AppMethodBeat.i(318478);
                    Log.i("MicroMsg.WAGamePreloadManager", "onResultCustomAction, module(%s)", new Object[] { this.rsJ });
                    d.a(d.this).addAndGet(1);
                    AppMethodBeat.o(318478);
                  }
                  
                  public final void a(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
                  {
                    AppMethodBeat.i(318472);
                    Log.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", new Object[] { paramAnonymousWxaPkgLoadProgress });
                    AppMethodBeat.o(318472);
                  }
                });
                ((com.tencent.mm.plugin.appbrand.q.d)localObject3).start();
              }
            }
          }
        }
      }
    }
    label398:
    AppMethodBeat.o(45290);
  }
  
  public final void dd(List<String> paramList)
  {
    AppMethodBeat.i(318508);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(318508);
      return;
    }
    this.rsD.addAll(paramList);
    paramList = paramList.iterator();
    for (;;)
    {
      Object localObject;
      l locall;
      String str;
      JSONObject localJSONObject;
      if (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        locall = this.rsz;
        str = bQs();
        localJSONObject = new JSONObject();
        Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "doDownloadFileNoCheck taskId:%s url:%s", new Object[] { str, localObject });
      }
      try
      {
        localJSONObject.put("url", localObject);
        label113:
        localObject = new l.1(locall, (String)localObject);
        locall.a(localJSONObject, 60000, new HashMap(), null, 50, (b.a)localObject, str, "test");
        continue;
        AppMethodBeat.o(318508);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label113;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d
 * JD-Core Version:    0.7.0.1
 */