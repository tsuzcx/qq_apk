package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.1;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.LoadParams;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.a;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.u.j;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class f
  implements a
{
  private final Set<String> gQi = new HashSet();
  final j<String, a> gQj = new j();
  private final Map<String, Boolean> gQk = new HashMap();
  final n gaS;
  
  public f(n paramn)
  {
    this.gaS = paramn;
  }
  
  private void a(ModulePkgInfo arg1, boolean paramBoolean, final a.b paramb, final a.a parama)
  {
    final String str = ???.name;
    final boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.bGd) && (!amB()))
    {
      bool1 = true;
      if (bool1) {
        a(this.gaS.aaa().fPS, false, null, null);
      }
      y.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { ???.name, Boolean.valueOf(???.bGd), Boolean.valueOf(bool1) });
      a(str, paramb, parama);
    }
    for (;;)
    {
      synchronized (this.gQi)
      {
        boolean bool2 = this.gQi.contains(str);
        if (!bool2) {
          this.gQi.add(str);
        }
        if (!bool2)
        {
          paramb = new c();
          if (bool1)
          {
            a("__APP__", new f.1(this, paramb), null);
            parama = new k();
            if (paramBoolean)
            {
              ??? = new e();
              ???.Oi = new f.2(this, str);
              if (???.gQg != null) {
                ???.gQg.setOnCancelListener(???.Oi);
              }
              ???.s(this.gaS);
              parama.value = ???;
            }
            ??? = this.gaS.aaa().fPS;
            if (!"__APP__".equals(str)) {
              break label374;
            }
            ??? = str;
            ??? = new RuntimeLoadModuleTask(this.gaS.mAppId, this.gaS.aaa().fPS.fEM, this.gaS.aaa().fPS.fEN, ???)
            {
              public final void a(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
              {
                y.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramAnonymousWxaPkgLoadProgress });
                Object localObject1 = f.this;
                Object localObject2 = str;
                localObject1 = ((f)localObject1).gQj.aV(localObject2);
                if (localObject1 == null) {}
                for (;;)
                {
                  return;
                  localObject1 = ((Set)localObject1).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (f.a)((Iterator)localObject1).next();
                    if (((f.a)localObject2).gQt != null) {
                      ((f.a)localObject2).gQt.a(paramAnonymousWxaPkgLoadProgress);
                    }
                  }
                }
              }
              
              public final void ud(String paramAnonymousString)
              {
                y.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
                paramAnonymousString = new f.3.1(this, paramAnonymousString);
                paramb.C(paramAnonymousString);
              }
            };
            y.i("MicroMsg.AppBrand.RuntimeLoadModuleTask[modularizing]", "startLoad %s", new Object[] { ???.gLE.toString() });
            XIPCInvoker.a("com.tencent.mm", ???.gLE, RuntimeLoadModuleTask.a.class, new RuntimeLoadModuleTask.1(???));
          }
        }
        else
        {
          return;
          bool1 = false;
        }
      }
      paramb.C(null);
      continue;
      label374:
      ??? = (String)???.fER.get(str);
      if (bk.bl(???)) {
        throw new IllegalAccessError("Invalid moduleName for runtime logic, call @smoothieli to fix this");
      }
    }
  }
  
  private void a(String paramString, a.b paramb, a.a parama)
  {
    if ((paramb == null) && (parama == null)) {
      return;
    }
    this.gQj.h(paramString, new a(paramb, parama));
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    if ((!bk.bl(paramModulePkgInfo.fCl)) && (com.tencent.mm.vfs.e.bK(paramModulePkgInfo.fCl))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.bGd) {
          vl("__APP__");
        }
        vl(paramModulePkgInfo.name);
      }
      return bool;
    }
  }
  
  public final void a(String paramString, a.b paramb)
  {
    a(paramString, true, paramb, null);
  }
  
  public final void a(String paramString, boolean paramBoolean, a.b paramb, a.a parama)
  {
    if (this.gaS.mFinished)
    {
      y.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.gaS.mAppId });
      paramb.a(a.d.gQc);
      return;
    }
    k localk = new k();
    if (bk.bl(paramString)) {}
    for (paramString = this.gaS.aaa().fPS;; paramString = vm(paramString))
    {
      localk.value = paramString;
      if ((!a(paramString)) || (paramb == null)) {
        break;
      }
      paramb.a(a.d.gQb);
      return;
    }
    a((ModulePkgInfo)localk.value, paramBoolean, paramb, parama);
  }
  
  public final boolean amA()
  {
    return true;
  }
  
  final boolean amB()
  {
    return a(this.gaS.aaa().fPS);
  }
  
  public final String vk(String paramString)
  {
    return vm(paramString).name;
  }
  
  final void vl(String paramString)
  {
    synchronized (this.gQk)
    {
      if (this.gQk.containsKey(paramString)) {
        return;
      }
      this.gaS.aae().qJ(paramString);
      this.gQk.put(paramString, Boolean.valueOf(true));
      y.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "module (%s) injected", new Object[] { paramString });
      return;
    }
  }
  
  public final ModulePkgInfo vm(String paramString)
  {
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.gaS.aaa().fPS;
    if (bk.bl(paramString)) {
      return localWxaPkgWrappingInfo;
    }
    paramString = com.tencent.mm.plugin.appbrand.appcache.a.qR(paramString);
    Iterator localIterator = localWxaPkgWrappingInfo.fEQ.iterator();
    while (localIterator.hasNext())
    {
      ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
      if (paramString.startsWith(localModulePkgInfo.name)) {
        return localModulePkgInfo;
      }
    }
    return localWxaPkgWrappingInfo;
  }
  
  private static final class a
  {
    final a.b gQs;
    final a.a gQt;
    
    public a(a.b paramb, a.a parama)
    {
      this.gQs = paramb;
      this.gQt = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.f
 * JD-Core Version:    0.7.0.1
 */