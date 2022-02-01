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
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private final Map<String, Boolean> coJ;
  private final Set<String> lUG;
  final com.tencent.mm.plugin.appbrand.z.h<String, b> lUH;
  final com.tencent.luggage.sdk.d.c lUI;
  
  public g(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147355);
    this.lUG = new HashSet();
    this.lUH = new com.tencent.mm.plugin.appbrand.z.h();
    this.coJ = new HashMap();
    this.lUI = paramc;
    AppMethodBeat.o(147355);
  }
  
  private void a(ModulePkgInfo arg1, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(192255);
    final String str = ???.name;
    final boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.independent) && (!btc()))
    {
      bool1 = true;
      if (bool1) {
        a(this.lUI.Fa().jYh, null, null);
      }
      ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { ???.name, Boolean.valueOf(???.independent), Boolean.valueOf(bool1) });
      b(str, paramb, parama);
    }
    for (;;)
    {
      synchronized (this.lUG)
      {
        boolean bool2 = this.lUG.contains(str);
        if (!bool2) {
          this.lUG.add(str);
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
                AppMethodBeat.i(192246);
                paramModulePkgInfo.Z(null);
                AppMethodBeat.o(192246);
              }
            }, null);
            paramb = this.lUI.Fa().jYh.cg(this.lUI.mAppId, str);
            paramb = e.c.lUF.j(this.lUI, paramb);
            paramb.a(new e.b()
            {
              public final void OX(final String paramAnonymousString)
              {
                AppMethodBeat.i(192249);
                ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
                paramAnonymousString = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(192247);
                    if (g.this.lUI.isDestroyed())
                    {
                      ad.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) destroyed", new Object[] { g.5.this.coO, g.this.lUI.toString() });
                      AppMethodBeat.o(192247);
                      return;
                    }
                    int i;
                    if ((!bt.isNullOrNil(paramAnonymousString)) && ((!g.5.this.lUU) || (g.this.btc())))
                    {
                      i = 1;
                      if (i != 0)
                      {
                        if (!"__APP__".equals(g.5.this.coO)) {
                          break label260;
                        }
                        g.this.lUI.Fa().jYh.pkgPath = paramAnonymousString;
                        label172:
                        break label283;
                      }
                    }
                    for (;;)
                    {
                      Object localObject2;
                      try
                      {
                        g.this.lUI.Fa().jYh.md5 = com.tencent.mm.b.g.b(com.tencent.mm.vfs.i.openRead(paramAnonymousString), 4096);
                        bf.N(g.this.lUI);
                        localObject2 = g.this;
                        String str = g.5.this.coO;
                        if (i == 0) {
                          break label330;
                        }
                        a.d locald = a.d.lUw;
                        g.a((g)localObject2, str, locald);
                        AppMethodBeat.o(192247);
                        return;
                        i = 0;
                      }
                      catch (FileNotFoundException localFileNotFoundException)
                      {
                        ad.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", new Object[] { g.this.lUI.mAppId });
                        continue;
                      }
                      label260:
                      Object localObject1 = g.this.lUI.Fa().jYh.jIX.iterator();
                      label283:
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
                        if (!g.5.this.coO.equals(((ModulePkgInfo)localObject2).name)) {
                          break label172;
                        }
                        ((ModulePkgInfo)localObject2).pkgPath = paramAnonymousString;
                        continue;
                        label330:
                        localObject1 = a.d.lUx;
                      }
                    }
                  }
                };
                paramModulePkgInfo.Z(paramAnonymousString);
                AppMethodBeat.o(192249);
              }
              
              public final void a(final android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
              {
                AppMethodBeat.i(192251);
                paramAnonymousa = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(192248);
                    boolean bool2 = g.this.lUI.isDestroyed();
                    if (bool2) {}
                    for (boolean bool1 = false;; bool1 = ((Boolean)paramAnonymousa.apply(g.this.lUI)).booleanValue())
                    {
                      ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%b) loaded(%b)", new Object[] { g.this.lUI.toString(), g.5.this.coO, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
                      if (!bool2) {
                        break;
                      }
                      AppMethodBeat.o(192248);
                      return;
                    }
                    if ((bool1) && (!g.this.lUI.getAppConfig().jVy.booleanValue())) {
                      g.this.lUI.aVP();
                    }
                    g localg = g.this;
                    String str = g.5.this.coO;
                    if (bool1) {}
                    for (a.d locald = a.d.lUw;; locald = a.d.lUx)
                    {
                      g.a(localg, str, locald);
                      AppMethodBeat.o(192248);
                      return;
                    }
                  }
                };
                paramModulePkgInfo.Z(paramAnonymousa);
                AppMethodBeat.o(192251);
              }
              
              public final void a(c paramAnonymousc)
              {
                AppMethodBeat.i(192250);
                ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                Object localObject1 = g.this;
                Object localObject2 = str;
                localObject1 = ((g)localObject1).lUH.cE(localObject2);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(192250);
                  return;
                }
                localObject1 = ((Set)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (g.b)((Iterator)localObject1).next();
                  if (((g.b)localObject2).lVb != null) {
                    ((g.b)localObject2).lVb.b(paramAnonymousc);
                  }
                }
                AppMethodBeat.o(192250);
              }
            });
            paramb.start();
          }
        }
        else
        {
          AppMethodBeat.o(192255);
          return;
          bool1 = false;
        }
      }
      ???.Z(null);
    }
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(147357);
    if ((!bt.isNullOrNil(paramModulePkgInfo.pkgPath)) && (com.tencent.mm.vfs.i.fv(paramModulePkgInfo.pkgPath))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.independent) {
          ee("__APP__", "checkModuleLoaded");
        }
        ee(paramModulePkgInfo.name, "checkModuleLoaded");
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
    this.lUH.j(paramString, new b(paramb, parama));
    AppMethodBeat.o(147362);
  }
  
  public final String SB(String paramString)
  {
    AppMethodBeat.i(147363);
    paramString = SC(paramString).name;
    AppMethodBeat.o(147363);
    return paramString;
  }
  
  public final ModulePkgInfo SC(String paramString)
  {
    AppMethodBeat.i(147364);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.lUI.Fa().jYh;
    if ((bt.isNullOrNil(paramString)) || ("__APP__".equals(paramString)))
    {
      AppMethodBeat.o(147364);
      return localWxaPkgWrappingInfo;
    }
    bf.N(this.lUI);
    paramString = (ModulePkgInfo)h.e(localWxaPkgWrappingInfo.jIX, paramString, "findModuleInfoByResourcePath");
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
    locala.lUY = true;
    locala.lUZ = true;
    if (this.lUI.isDestroyed())
    {
      ad.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.lUI.mAppId });
      if (paramb != null) {
        paramb.a(a.d.lUx);
      }
      AppMethodBeat.o(169498);
      return;
    }
    final com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    if (bt.isNullOrNil(paramString)) {}
    for (Object localObject = this.lUI.Fa().jYh;; localObject = SC(paramString))
    {
      locali.value = localObject;
      if (!a((ModulePkgInfo)localObject)) {
        break;
      }
      ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule appId:%s path:%s, module:%s, options:%b, [loaded]", new Object[] { this.lUI.mAppId, paramString, ((ModulePkgInfo)locali.value).name, locala });
      if (paramb == null) {
        break;
      }
      if (locala.lUZ) {
        ee(((ModulePkgInfo)locali.value).name, "options.injectModuleJS");
      }
      paramb.a(a.d.lUw);
      AppMethodBeat.o(169498);
      return;
    }
    localObject = new com.tencent.mm.plugin.appbrand.z.i();
    final PBool localPBool = new PBool();
    if (locala.lUY) {
      this.lUI.j(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192242);
          if (!localPBool.value)
          {
            d locald = new d().a(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(192240);
                paramAnonymous2DialogInterface.dismiss();
                g.a(g.this, ((ModulePkgInfo)g.1.this.lUK.value).name, a.d.lUy);
                AppMethodBeat.o(192240);
              }
            });
            locald.lUC = new android.arch.a.c.a() {};
            locald.aa(g.this.lUI);
            this.lUL.value = locald;
          }
          AppMethodBeat.o(192242);
        }
      }, 0L);
    }
    ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, appId:%s path:%s, module:%s, options:%b [do loadOrAddPendingCallback]", new Object[] { this.lUI.mAppId, paramString, ((ModulePkgInfo)locali.value).name, locala });
    a((ModulePkgInfo)locali.value, new a.b()
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(192244);
        localPBool.value = true;
        if ((a.d.lUw == paramAnonymousd) && (locala != null) && (locala.lUZ))
        {
          if (!((ModulePkgInfo)locali.value).independent) {
            g.this.ee("__APP__", "options.injectModuleJS");
          }
          g.this.ee(((ModulePkgInfo)locali.value).name, "options.injectModuleJS");
        }
        g.this.lUI.j(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192243);
            if (g.2.this.lUL.value != null) {
              ((DialogInterface)g.2.this.lUL.value).dismiss();
            }
            AppMethodBeat.o(192243);
          }
        }, 0L);
        if (paramb != null) {
          paramb.a(paramAnonymousd);
        }
        AppMethodBeat.o(192244);
      }
    }, null);
    AppMethodBeat.o(169498);
  }
  
  public final void a(String paramString, final a.b paramb, a.a parama)
  {
    AppMethodBeat.i(192254);
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.lUI.Fa().jYh;
      if (!h.a(localObject, paramString, "findModuleInfoByModuleName")) {}
    }
    while (localObject == null)
    {
      ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [not found]", new Object[] { this.lUI.mAppId, paramString, Boolean.FALSE });
      paramb.a(a.d.lUz);
      AppMethodBeat.o(192254);
      return;
      String str = WxaPkgWrappingInfo.LK(paramString);
      bf.N(this.lUI);
      Iterator localIterator = ((WxaPkgWrappingInfo)localObject).jIX.iterator();
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
      ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [loaded]", new Object[] { this.lUI.mAppId, paramString, Boolean.FALSE });
      paramb.a(a.d.lUw);
      AppMethodBeat.o(192254);
      return;
    }
    ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [do loadOrAddPendingCallback]", new Object[] { this.lUI.mAppId, paramString, Boolean.FALSE });
    a((ModulePkgInfo)localObject, new a.b()
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(192245);
        if ((a.d.lUw == paramAnonymousd) && (this.lUR))
        {
          if (!this.lUS.independent) {
            g.this.ee("__APP__", "options.injectModuleJS");
          }
          g.this.ee(this.lUS.name, "options.injectModuleJS");
        }
        if (paramb != null) {
          paramb.a(paramAnonymousd);
        }
        AppMethodBeat.o(192245);
      }
    }, parama);
    AppMethodBeat.o(192254);
  }
  
  public final boolean btb()
  {
    return true;
  }
  
  final boolean btc()
  {
    AppMethodBeat.i(147356);
    boolean bool = a(this.lUI.Fa().jYh);
    AppMethodBeat.o(147356);
    return bool;
  }
  
  final void ee(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192253);
    boolean bool = ((f)this.lUI.Ew()).cS(paramString1);
    ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "injectServiceScriptSafe appId:%s, module:%s, reason:%s ret:%b", new Object[] { this.lUI.mAppId, paramString1, paramString2, Boolean.valueOf(bool) });
    AppMethodBeat.o(192253);
  }
  
  static final class b
  {
    final a.b lVa;
    final a.a lVb;
    
    public b(a.b paramb, a.a parama)
    {
      this.lVa = paramb;
      this.lVb = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.g
 * JD-Core Version:    0.7.0.1
 */