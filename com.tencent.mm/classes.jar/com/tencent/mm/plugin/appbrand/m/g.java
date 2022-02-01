package com.tencent.mm.plugin.appbrand.m;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class g
  implements a
{
  private final Map<String, Boolean> coL;
  private final Set<String> lZj;
  final com.tencent.mm.plugin.appbrand.y.h<String, b> lZk;
  final com.tencent.luggage.sdk.d.d lZl;
  
  public g(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(147355);
    this.lZj = new HashSet();
    this.lZk = new com.tencent.mm.plugin.appbrand.y.h();
    this.coL = new HashMap();
    this.lZl = paramd;
    AppMethodBeat.o(147355);
  }
  
  private void a(ModulePkgInfo arg1, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(220828);
    final String str = ???.name;
    final boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.independent) && (!btN()))
    {
      bool1 = true;
      if (bool1) {
        a(this.lZl.Ff().kbw, null, null);
      }
      ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { ???.name, Boolean.valueOf(???.independent), Boolean.valueOf(bool1) });
      b(str, paramb, parama);
    }
    for (;;)
    {
      synchronized (this.lZj)
      {
        boolean bool2 = this.lZj.contains(str);
        if (!bool2) {
          this.lZj.add(str);
        }
        if (!bool2)
        {
          ??? = new b();
          if (bool1)
          {
            b("__APP__", new a.b()
            {
              public final void a(a.d paramAnonymousd)
              {
                AppMethodBeat.i(220819);
                paramModulePkgInfo.X(null);
                AppMethodBeat.o(220819);
              }
            }, null);
            paramb = this.lZl.Ff().kbw.ch(this.lZl.mAppId, str);
            paramb = e.c.lZi.j(this.lZl, paramb);
            paramb.a(new e.b()
            {
              public final void PF(final String paramAnonymousString)
              {
                AppMethodBeat.i(220822);
                ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
                paramAnonymousString = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(220820);
                    if (g.this.lZl.isDestroyed())
                    {
                      ae.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) destroyed", new Object[] { g.5.this.coQ, g.this.lZl.toString() });
                      AppMethodBeat.o(220820);
                      return;
                    }
                    int i;
                    if ((!bu.isNullOrNil(paramAnonymousString)) && ((!g.5.this.lZx) || (g.this.btN())))
                    {
                      i = 1;
                      if (i != 0)
                      {
                        if (!"__APP__".equals(g.5.this.coQ)) {
                          break label260;
                        }
                        g.this.lZl.Ff().kbw.pkgPath = paramAnonymousString;
                        label172:
                        break label283;
                      }
                    }
                    for (;;)
                    {
                      Object localObject2;
                      try
                      {
                        g.this.lZl.Ff().kbw.md5 = com.tencent.mm.b.g.b(o.openRead(paramAnonymousString), 4096);
                        bg.L(g.this.lZl);
                        localObject2 = g.this;
                        String str = g.5.this.coQ;
                        if (i == 0) {
                          break label330;
                        }
                        a.d locald = a.d.lYZ;
                        g.a((g)localObject2, str, locald);
                        AppMethodBeat.o(220820);
                        return;
                        i = 0;
                      }
                      catch (FileNotFoundException localFileNotFoundException)
                      {
                        ae.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", new Object[] { g.this.lZl.mAppId });
                        continue;
                      }
                      label260:
                      Object localObject1 = g.this.lZl.Ff().kbw.jLY.iterator();
                      label283:
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
                        if (!g.5.this.coQ.equals(((ModulePkgInfo)localObject2).name)) {
                          break label172;
                        }
                        ((ModulePkgInfo)localObject2).pkgPath = paramAnonymousString;
                        continue;
                        label330:
                        localObject1 = a.d.lZa;
                      }
                    }
                  }
                };
                paramModulePkgInfo.X(paramAnonymousString);
                AppMethodBeat.o(220822);
              }
              
              public final void a(final android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
              {
                AppMethodBeat.i(220824);
                paramAnonymousa = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(220821);
                    boolean bool2 = g.this.lZl.isDestroyed();
                    if (bool2) {}
                    for (boolean bool1 = false;; bool1 = ((Boolean)paramAnonymousa.apply(g.this.lZl)).booleanValue())
                    {
                      ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%b) loaded(%b)", new Object[] { g.this.lZl.toString(), g.5.this.coQ, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
                      if (!bool2) {
                        break;
                      }
                      AppMethodBeat.o(220821);
                      return;
                    }
                    if ((bool1) && (!g.this.lZl.getAppConfig().jYP.booleanValue())) {
                      g.this.lZl.aWp();
                    }
                    g localg = g.this;
                    String str = g.5.this.coQ;
                    if (bool1) {}
                    for (a.d locald = a.d.lYZ;; locald = a.d.lZa)
                    {
                      g.a(localg, str, locald);
                      AppMethodBeat.o(220821);
                      return;
                    }
                  }
                };
                paramModulePkgInfo.X(paramAnonymousa);
                AppMethodBeat.o(220824);
              }
              
              public final void a(c paramAnonymousc)
              {
                AppMethodBeat.i(220823);
                ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                Object localObject1 = g.this;
                Object localObject2 = str;
                localObject1 = ((g)localObject1).lZk.cF(localObject2);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(220823);
                  return;
                }
                localObject1 = ((Set)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (g.b)((Iterator)localObject1).next();
                  if (((g.b)localObject2).lZE != null) {
                    ((g.b)localObject2).lZE.b(paramAnonymousc);
                  }
                }
                AppMethodBeat.o(220823);
              }
            });
            paramb.start();
          }
        }
        else
        {
          AppMethodBeat.o(220828);
          return;
          bool1 = false;
        }
      }
      ???.X(null);
    }
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(147357);
    if ((!bu.isNullOrNil(paramModulePkgInfo.pkgPath)) && (o.fB(paramModulePkgInfo.pkgPath))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.independent) {
          eg("__APP__", "checkModuleLoaded");
        }
        eg(paramModulePkgInfo.name, "checkModuleLoaded");
      }
      AppMethodBeat.o(147357);
      return bool;
    }
  }
  
  private void b(String paramString, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(147362);
    if ((paramb == null) && (parama == null))
    {
      AppMethodBeat.o(147362);
      return;
    }
    this.lZk.j(paramString, new b(paramb, parama));
    AppMethodBeat.o(147362);
  }
  
  public final String Tk(String paramString)
  {
    AppMethodBeat.i(147363);
    paramString = Tl(paramString).name;
    AppMethodBeat.o(147363);
    return paramString;
  }
  
  public final ModulePkgInfo Tl(String paramString)
  {
    AppMethodBeat.i(147364);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.lZl.Ff().kbw;
    if ((bu.isNullOrNil(paramString)) || ("__APP__".equals(paramString)))
    {
      AppMethodBeat.o(147364);
      return localWxaPkgWrappingInfo;
    }
    bg.L(this.lZl);
    paramString = (ModulePkgInfo)h.e(localWxaPkgWrappingInfo.jLY, paramString, "findModuleInfoByResourcePath");
    if (paramString != null)
    {
      AppMethodBeat.o(147364);
      return paramString;
    }
    AppMethodBeat.o(147364);
    return localWxaPkgWrappingInfo;
  }
  
  public final void a(String paramString, final a.b paramb)
  {
    AppMethodBeat.i(169498);
    final g.a locala = new g.a((byte)0);
    locala.lZB = true;
    locala.lZC = true;
    if (this.lZl.isDestroyed())
    {
      ae.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.lZl.mAppId });
      if (paramb != null) {
        paramb.a(a.d.lZa);
      }
      AppMethodBeat.o(169498);
      return;
    }
    final i locali = new i();
    if (bu.isNullOrNil(paramString)) {}
    for (Object localObject = this.lZl.Ff().kbw;; localObject = Tl(paramString))
    {
      locali.value = localObject;
      if (!a((ModulePkgInfo)localObject)) {
        break;
      }
      ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule appId:%s path:%s, module:%s, options:%b, [loaded]", new Object[] { this.lZl.mAppId, paramString, ((ModulePkgInfo)locali.value).name, locala });
      if (paramb == null) {
        break;
      }
      if (locala.lZC) {
        eg(((ModulePkgInfo)locali.value).name, "options.injectModuleJS");
      }
      paramb.a(a.d.lYZ);
      AppMethodBeat.o(169498);
      return;
    }
    localObject = new i();
    final PBool localPBool = new PBool();
    if (locala.lZB) {
      this.lZl.j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220815);
          if (!localPBool.value)
          {
            d locald = new d().a(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(220813);
                paramAnonymous2DialogInterface.dismiss();
                g.a(g.this, ((ModulePkgInfo)g.1.this.lZn.value).name, a.d.lZb);
                AppMethodBeat.o(220813);
              }
            });
            locald.lZf = new android.arch.a.c.a() {};
            locald.aa(g.this.lZl);
            this.lZo.value = locald;
          }
          AppMethodBeat.o(220815);
        }
      }, 0L);
    }
    ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, appId:%s path:%s, module:%s, options:%b [do loadOrAddPendingCallback]", new Object[] { this.lZl.mAppId, paramString, ((ModulePkgInfo)locali.value).name, locala });
    a((ModulePkgInfo)locali.value, new a.b()
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(220817);
        localPBool.value = true;
        if ((a.d.lYZ == paramAnonymousd) && (locala != null) && (locala.lZC))
        {
          if (!((ModulePkgInfo)locali.value).independent) {
            g.this.eg("__APP__", "options.injectModuleJS");
          }
          g.this.eg(((ModulePkgInfo)locali.value).name, "options.injectModuleJS");
        }
        g.this.lZl.j(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220816);
            if (g.2.this.lZo.value != null) {
              ((DialogInterface)g.2.this.lZo.value).dismiss();
            }
            AppMethodBeat.o(220816);
          }
        }, 0L);
        if (paramb != null) {
          paramb.a(paramAnonymousd);
        }
        AppMethodBeat.o(220817);
      }
    }, null);
    AppMethodBeat.o(169498);
  }
  
  public final void a(String paramString, final a.b paramb, a.a parama)
  {
    AppMethodBeat.i(220827);
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.lZl.Ff().kbw;
      if (!h.a(localObject, paramString, "findModuleInfoByModuleName")) {}
    }
    while (localObject == null)
    {
      ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [not found]", new Object[] { this.lZl.mAppId, paramString, Boolean.FALSE });
      paramb.a(a.d.lZc);
      AppMethodBeat.o(220827);
      return;
      String str = WxaPkgWrappingInfo.Mn(paramString);
      bg.L(this.lZl);
      Iterator localIterator = ((WxaPkgWrappingInfo)localObject).jLY.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (ModulePkgInfo)localIterator.next();
          if (((ModulePkgInfo)localObject).name.equals(str)) {
            break;
          }
        }
      }
      localObject = null;
    }
    if (a((ModulePkgInfo)localObject))
    {
      ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [loaded]", new Object[] { this.lZl.mAppId, paramString, Boolean.FALSE });
      paramb.a(a.d.lYZ);
      AppMethodBeat.o(220827);
      return;
    }
    ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [do loadOrAddPendingCallback]", new Object[] { this.lZl.mAppId, paramString, Boolean.FALSE });
    a((ModulePkgInfo)localObject, new a.b()
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(220818);
        if ((a.d.lYZ == paramAnonymousd) && (this.lZu))
        {
          if (!this.lZv.independent) {
            g.this.eg("__APP__", "options.injectModuleJS");
          }
          g.this.eg(this.lZv.name, "options.injectModuleJS");
        }
        if (paramb != null) {
          paramb.a(paramAnonymousd);
        }
        AppMethodBeat.o(220818);
      }
    }, parama);
    AppMethodBeat.o(220827);
  }
  
  public final boolean btM()
  {
    return true;
  }
  
  final boolean btN()
  {
    AppMethodBeat.i(147356);
    boolean bool = a(this.lZl.Ff().kbw);
    AppMethodBeat.o(147356);
    return bool;
  }
  
  final void eg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220826);
    boolean bool = ((f)this.lZl.Ey()).cU(paramString1);
    ae.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "injectServiceScriptSafe appId:%s, module:%s, reason:%s ret:%b", new Object[] { this.lZl.mAppId, paramString1, paramString2, Boolean.valueOf(bool) });
    AppMethodBeat.o(220826);
  }
  
  static final class b
  {
    final a.b lZD;
    final a.a lZE;
    
    public b(a.b paramb, a.a parama)
    {
      this.lZD = paramb;
      this.lZE = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.g
 * JD-Core Version:    0.7.0.1
 */