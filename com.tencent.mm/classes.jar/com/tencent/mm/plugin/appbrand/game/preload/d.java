package com.tencent.mm.plugin.appbrand.game.preload;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.p.d.c;
import com.tencent.mm.plugin.appbrand.p.g;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.appbrand.s.m.1;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
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
  private static volatile d ooQ;
  public boolean hasInit;
  public t nAH;
  public m ooR;
  public a ooS;
  public r ooT;
  public c ooU;
  public CopyOnWriteArrayList<String> ooV;
  public boolean ooW;
  public AtomicInteger ooX;
  public AtomicInteger ooY;
  public AtomicInteger ooZ;
  public AtomicInteger opa;
  
  private d()
  {
    AppMethodBeat.i(45286);
    this.hasInit = false;
    this.ooV = new CopyOnWriteArrayList();
    this.ooW = false;
    AppMethodBeat.o(45286);
  }
  
  public static d bOS()
  {
    AppMethodBeat.i(45287);
    if (ooQ == null) {}
    try
    {
      if (ooQ == null) {
        ooQ = new d();
      }
      d locald = ooQ;
      AppMethodBeat.o(45287);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(45287);
    }
  }
  
  public static String bsL()
  {
    AppMethodBeat.i(45289);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.s.c.cbO();
    localObject = com.tencent.mm.plugin.appbrand.s.c.cbN();
    AppMethodBeat.o(45289);
    return localObject;
  }
  
  public static void hW(boolean paramBoolean)
  {
    AppMethodBeat.i(45291);
    e.bOU().opk = paramBoolean;
    AppMethodBeat.o(45291);
  }
  
  public static void y(t paramt)
  {
    AppMethodBeat.i(282133);
    Iterator localIterator;
    try
    {
      if ((ooQ == null) || (ooQ.nAH != paramt)) {
        break label229;
      }
      if (ooQ.ooR == null) {
        break label222;
      }
      paramt = ooQ.ooR;
      synchronized (paramt.qiD)
      {
        localIterator = paramt.qiD.iterator();
        if (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next()).isRunning = false;
        }
      }
      paramt.qiD.clear();
    }
    finally
    {
      AppMethodBeat.o(282133);
    }
    synchronized (paramt.qjD)
    {
      localIterator = paramt.qjD.iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next()).isRunning = false;
      }
    }
    paramt.qjD.clear();
    synchronized (paramt.qjC)
    {
      paramt.qjC.clear();
      ooQ.ooR = null;
      ooQ.ooU = null;
      ooQ.ooS = null;
      ooQ.ooT = null;
      ooQ.nAH = null;
      label222:
      ooQ.hasInit = false;
      label229:
      AppMethodBeat.o(282133);
      return;
    }
  }
  
  public final boolean agE(String paramString)
  {
    AppMethodBeat.i(282136);
    synchronized (this.ooV)
    {
      if ((this.ooV != null) && (this.ooV.contains(paramString)))
      {
        Log.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", new Object[] { paramString, Integer.valueOf(this.ooV.size()) });
        this.opa.addAndGet(1);
        AppMethodBeat.o(282136);
        return true;
      }
      ??? = this.ooR;
      if ((??? != null) && (((m)???).alb(paramString).booleanValue()))
      {
        AppMethodBeat.o(282136);
        return true;
      }
    }
    AppMethodBeat.o(282136);
    return false;
  }
  
  public final void bOT()
  {
    AppMethodBeat.i(45290);
    if ((this.ooV != null) && (this.ooV.size() == 0))
    {
      if ((this.nAH == null) || (this.nAH.getAppConfig() == null))
      {
        Log.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
        AppMethodBeat.o(45290);
        return;
      }
      Object localObject1 = this.nAH.getAppConfig();
      Object localObject2 = this.nAH.mAppId;
      localObject1 = ((com.tencent.mm.plugin.appbrand.config.b)localObject1).nWd;
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
            break label392;
          }
          localObject1 = (String)((Iterator)localObject2).next();
          Log.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", new Object[] { localObject1 });
          Object localObject3 = this.nAH;
          if ((localObject3 == null) || (((t)localObject3).bDx() == null))
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
          if ((((AppBrandRuntime)localObject3).aol) || (((AppBrandRuntime)localObject3).ntU.get()))
          {
            Log.e("MicroMsg.WAGamePreloadManager", "runtime(%s) finishing", new Object[] { ((AppBrandRuntime)localObject3).mAppId });
          }
          else
          {
            bl.M((AppBrandRuntime)localObject3);
            Object localObject4 = (ModulePkgInfo)g.g(((t)localObject3).bDx().nYR.nIb, (String)localObject1);
            if ((localObject4 == null) || (TextUtils.isEmpty(((ModulePkgInfo)localObject4).md5)))
            {
              Log.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage with appId:%s, moduleName:%s, get invalid module obj", new Object[] { ((AppBrandRuntime)localObject3).mAppId, localObject1 });
            }
            else if (d.c.qhz == null)
            {
              Log.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
            }
            else
            {
              localObject4 = ((t)localObject3).bDx().nYR.cA(((AppBrandRuntime)localObject3).mAppId, ((ModulePkgInfo)localObject4).name);
              localObject3 = d.c.qhz.k((AppBrandRuntime)localObject3, (String)localObject4);
              ((com.tencent.mm.plugin.appbrand.p.d)localObject3).a(new d.1(this, (String)localObject1));
              ((com.tencent.mm.plugin.appbrand.p.d)localObject3).start();
            }
          }
        }
      }
    }
    label392:
    AppMethodBeat.o(45290);
  }
  
  public final void bs(List<String> paramList)
  {
    AppMethodBeat.i(282134);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(282134);
      return;
    }
    this.ooV.addAll(paramList);
    paramList = paramList.iterator();
    for (;;)
    {
      Object localObject;
      m localm;
      String str;
      JSONObject localJSONObject;
      if (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        localm = this.ooR;
        str = bsL();
        localJSONObject = new JSONObject();
        Log.i("MicroMsg.AppBrandPreloadNetworkDownload", "doDownloadFileNoCheck taskId:%s url:%s", new Object[] { str, localObject });
      }
      try
      {
        localJSONObject.put("url", localObject);
        label113:
        localObject = new m.1(localm, (String)localObject);
        localm.a(localJSONObject, 60000, new HashMap(), null, 50, (b.a)localObject, str, "test");
        continue;
        AppMethodBeat.o(282134);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label113;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d
 * JD-Core Version:    0.7.0.1
 */