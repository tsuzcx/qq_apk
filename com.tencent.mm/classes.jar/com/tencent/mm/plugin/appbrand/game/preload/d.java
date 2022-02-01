package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.p.e.b;
import com.tencent.mm.plugin.appbrand.p.e.c;
import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.plugin.appbrand.s.m.1;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static volatile d ltQ;
  public boolean hasInit;
  public com.tencent.mm.plugin.appbrand.q kGW;
  public com.tencent.mm.plugin.appbrand.s.m ltR;
  public com.tencent.mm.plugin.appbrand.s.a ltS;
  public com.tencent.mm.plugin.appbrand.appstorage.q ltT;
  public c ltU;
  public CopyOnWriteArrayList<String> ltV;
  public boolean ltW;
  public boolean ltX;
  public AtomicInteger ltY;
  public AtomicInteger ltZ;
  public AtomicInteger lua;
  public AtomicInteger lub;
  
  private d()
  {
    AppMethodBeat.i(45286);
    this.hasInit = false;
    this.ltV = new CopyOnWriteArrayList();
    this.ltW = false;
    this.ltX = false;
    AppMethodBeat.o(45286);
  }
  
  public static d bDu()
  {
    AppMethodBeat.i(45287);
    if (ltQ == null) {}
    try
    {
      if (ltQ == null) {
        ltQ = new d();
      }
      d locald = ltQ;
      AppMethodBeat.o(45287);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(45287);
    }
  }
  
  public static String bjl()
  {
    AppMethodBeat.i(45289);
    Object localObject = new StringBuilder();
    com.tencent.mm.plugin.appbrand.s.c.bPx();
    localObject = com.tencent.mm.plugin.appbrand.s.c.bPw();
    AppMethodBeat.o(45289);
    return localObject;
  }
  
  public static void hf(boolean paramBoolean)
  {
    AppMethodBeat.i(45291);
    e.bDw().lul = paramBoolean;
    AppMethodBeat.o(45291);
  }
  
  public static void x(com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(226634);
    Iterator localIterator;
    try
    {
      if ((ltQ == null) || (ltQ.kGW != paramq)) {
        break label229;
      }
      if (ltQ.ltR == null) {
        break label222;
      }
      paramq = ltQ.ltR;
      synchronized (paramq.nhU)
      {
        localIterator = paramq.nhU.iterator();
        if (localIterator.hasNext()) {
          ((com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next()).isRunning = false;
        }
      }
      paramq.nhU.clear();
    }
    finally
    {
      AppMethodBeat.o(226634);
    }
    synchronized (paramq.niS)
    {
      localIterator = paramq.niS.iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.appbrand.s.a.b)localIterator.next()).isRunning = false;
      }
    }
    paramq.niS.clear();
    synchronized (paramq.niR)
    {
      paramq.niR.clear();
      ltQ.ltR = null;
      ltQ.ltU = null;
      ltQ.ltS = null;
      ltQ.ltT = null;
      ltQ.kGW = null;
      label222:
      ltQ.hasInit = false;
      label229:
      AppMethodBeat.o(226634);
      return;
    }
  }
  
  public final boolean YQ(String paramString)
  {
    AppMethodBeat.i(226636);
    synchronized (this.ltV)
    {
      if ((this.ltV != null) && (this.ltV.contains(paramString)))
      {
        Log.i("MicroMsg.WAGamePreloadManager", "predownloadingList has url:%s,size:%d", new Object[] { paramString, Integer.valueOf(this.ltV.size()) });
        this.lub.addAndGet(1);
        AppMethodBeat.o(226636);
        return true;
      }
      boolean bool = this.ltR.adi(paramString).booleanValue();
      AppMethodBeat.o(226636);
      return bool;
    }
  }
  
  public final void bDv()
  {
    AppMethodBeat.i(45290);
    if ((this.ltV != null) && (this.ltV.size() == 0))
    {
      if ((this.kGW == null) || (this.kGW.getAppConfig() == null))
      {
        Log.e("MicroMsg.WAGamePreloadManager", "hy: unexpected null app config");
        AppMethodBeat.o(45290);
        return;
      }
      Object localObject1 = this.kGW.getAppConfig().lbU;
      int i;
      if (localObject1 == null)
      {
        i = 0;
        Log.i("MicroMsg.WAGamePreloadManager", "predownload subPackage size:%d", new Object[] { Integer.valueOf(i) });
        if (localObject1 != null) {
          localObject1 = ((ArrayList)localObject1).iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label303;
          }
          final String str1 = (String)((Iterator)localObject1).next();
          Log.i("MicroMsg.WAGamePreloadManager", "predownload subPackage name:%s", new Object[] { str1 });
          Object localObject2 = this.kGW;
          if ((localObject2 == null) || (((com.tencent.mm.plugin.appbrand.q)localObject2).bsB() == null))
          {
            Log.e("MicroMsg.WAGamePreloadManager", "runtime(%s) or sysConfig null", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
            continue;
            i = ((ArrayList)localObject1).size();
            break;
          }
          if ((((AppBrandRuntime)localObject2).SO) || (((com.tencent.mm.plugin.appbrand.q)localObject2).isDestroyed()))
          {
            Log.e("MicroMsg.WAGamePreloadManager", "runtime(%s) finishing", new Object[] { ((AppBrandRuntime)localObject2).mAppId });
          }
          else
          {
            bg.L((AppBrandRuntime)localObject2);
            String str2 = ((com.tencent.mm.plugin.appbrand.q)localObject2).bsB().leE.cv(((AppBrandRuntime)localObject2).mAppId, str1);
            s.bhK(str1);
            if (e.c.ngP == null)
            {
              Log.e("MicroMsg.WAGamePreloadManager", "downloadSubPackage fail!");
            }
            else
            {
              localObject2 = e.c.ngP.j((AppBrandRuntime)localObject2, str2);
              ((com.tencent.mm.plugin.appbrand.p.e)localObject2).a(new e.b()
              {
                public final void YR(String paramAnonymousString)
                {
                  AppMethodBeat.i(45282);
                  Log.i("MicroMsg.WAGamePreloadManager", "onLoad, module(%s) pkgPath(%s)", new Object[] { str1, paramAnonymousString });
                  d.a(d.this).addAndGet(1);
                  AppMethodBeat.o(45282);
                }
                
                public final void a(android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
                {
                  AppMethodBeat.i(226633);
                  Log.i("MicroMsg.WAGamePreloadManager", "onResultCustomAction, module(%s)", new Object[] { str1 });
                  d.a(d.this).addAndGet(1);
                  AppMethodBeat.o(226633);
                }
                
                public final void a(com.tencent.mm.plugin.appbrand.p.c paramAnonymousc)
                {
                  AppMethodBeat.i(45283);
                  Log.i("MicroMsg.WAGamePreloadManager", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                  AppMethodBeat.o(45283);
                }
              });
              ((com.tencent.mm.plugin.appbrand.p.e)localObject2).start();
            }
          }
        }
      }
    }
    label303:
    AppMethodBeat.o(45290);
  }
  
  public final void bu(List<String> paramList)
  {
    AppMethodBeat.i(226635);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(226635);
      return;
    }
    this.ltV.addAll(paramList);
    paramList = paramList.iterator();
    for (;;)
    {
      Object localObject;
      com.tencent.mm.plugin.appbrand.s.m localm;
      String str;
      JSONObject localJSONObject;
      if (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        localm = this.ltR;
        str = bjl();
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
        AppMethodBeat.o(226635);
        return;
      }
      catch (JSONException localJSONException)
      {
        break label113;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.preload.d
 * JD-Core Version:    0.7.0.1
 */