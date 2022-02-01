package com.tencent.mm.plugin.appbrand.p;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
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
  private final Map<String, Boolean> cAY;
  private final Set<String> ngQ;
  final com.tencent.mm.plugin.appbrand.ac.h<String, b> ngR;
  final com.tencent.luggage.sdk.d.d ngS;
  
  public g(com.tencent.luggage.sdk.d.d paramd)
  {
    AppMethodBeat.i(147355);
    this.ngQ = new HashSet();
    this.ngR = new com.tencent.mm.plugin.appbrand.ac.h();
    this.cAY = new HashMap();
    this.ngS = paramd;
    AppMethodBeat.o(147355);
  }
  
  private void a(ModulePkgInfo arg1, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(229940);
    final String str = ???.name;
    final boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.independent) && (!bPo()))
    {
      bool1 = true;
      if (bool1) {
        a(this.ngS.OM().leE, null, null);
      }
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { ???.name, Boolean.valueOf(???.independent), Boolean.valueOf(bool1) });
      b(str, paramb, parama);
    }
    for (;;)
    {
      synchronized (this.ngQ)
      {
        boolean bool2 = this.ngQ.contains(str);
        if (!bool2) {
          this.ngQ.add(str);
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
                AppMethodBeat.i(229931);
                paramModulePkgInfo.ad(null);
                AppMethodBeat.o(229931);
              }
            }, null);
            paramb = this.ngS.OM().leE.cv(this.ngS.mAppId, str);
            paramb = e.c.ngP.j(this.ngS, paramb);
            paramb.a(new e.b()
            {
              public final void YR(final String paramAnonymousString)
              {
                AppMethodBeat.i(229934);
                Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
                paramAnonymousString = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(229932);
                    if (g.this.ngS.isDestroyed())
                    {
                      Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) destroyed", new Object[] { g.6.this.cBd, g.this.ngS.toString() });
                      AppMethodBeat.o(229932);
                      return;
                    }
                    int i;
                    if ((!Util.isNullOrNil(paramAnonymousString)) && ((!g.6.this.nhf) || (g.this.bPo())))
                    {
                      i = 1;
                      if (i != 0)
                      {
                        if (!"__APP__".equals(g.6.this.cBd)) {
                          break label260;
                        }
                        g.this.ngS.OM().leE.pkgPath = paramAnonymousString;
                        label172:
                        break label283;
                      }
                    }
                    for (;;)
                    {
                      Object localObject2;
                      try
                      {
                        g.this.ngS.OM().leE.md5 = com.tencent.mm.b.g.b(s.openRead(paramAnonymousString), 4096);
                        bg.L(g.this.ngS);
                        localObject2 = g.this;
                        String str = g.6.this.cBd;
                        if (i == 0) {
                          break label330;
                        }
                        a.d locald = a.d.ngF;
                        g.a((g)localObject2, str, locald);
                        AppMethodBeat.o(229932);
                        return;
                        i = 0;
                      }
                      catch (FileNotFoundException localFileNotFoundException)
                      {
                        Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", new Object[] { g.this.ngS.mAppId });
                        continue;
                      }
                      label260:
                      Object localObject1 = g.this.ngS.OM().leE.kNZ.iterator();
                      label283:
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
                        if (!g.6.this.cBd.equals(((ModulePkgInfo)localObject2).name)) {
                          break label172;
                        }
                        ((ModulePkgInfo)localObject2).pkgPath = paramAnonymousString;
                        continue;
                        label330:
                        localObject1 = a.d.ngG;
                      }
                    }
                  }
                };
                paramModulePkgInfo.ad(paramAnonymousString);
                AppMethodBeat.o(229934);
              }
              
              public final void a(final android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
              {
                AppMethodBeat.i(229936);
                paramAnonymousa = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(229933);
                    boolean bool2 = g.this.ngS.isDestroyed();
                    if (bool2) {}
                    for (boolean bool1 = false;; bool1 = ((Boolean)paramAnonymousa.apply(g.this.ngS)).booleanValue())
                    {
                      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%b) loaded(%b)", new Object[] { g.this.ngS.toString(), g.6.this.cBd, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
                      if (!bool2) {
                        break;
                      }
                      AppMethodBeat.o(229933);
                      return;
                    }
                    if ((bool1) && (!g.this.ngS.getAppConfig().lbR.booleanValue())) {
                      g.this.ngS.brk();
                    }
                    g localg = g.this;
                    String str = g.6.this.cBd;
                    if (bool1) {}
                    for (a.d locald = a.d.ngF;; locald = a.d.ngG)
                    {
                      g.a(localg, str, locald);
                      AppMethodBeat.o(229933);
                      return;
                    }
                  }
                };
                paramModulePkgInfo.ad(paramAnonymousa);
                AppMethodBeat.o(229936);
              }
              
              public final void a(c paramAnonymousc)
              {
                AppMethodBeat.i(229935);
                Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                Object localObject1 = g.this;
                Object localObject2 = str;
                localObject1 = ((g)localObject1).ngR.cM(localObject2);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(229935);
                  return;
                }
                localObject1 = ((Set)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (g.b)((Iterator)localObject1).next();
                  if (((g.b)localObject2).nhm != null) {
                    ((g.b)localObject2).nhm.b(paramAnonymousc);
                  }
                }
                AppMethodBeat.o(229935);
              }
            });
            paramb.start();
          }
        }
        else
        {
          AppMethodBeat.o(229940);
          return;
          bool1 = false;
        }
      }
      ???.ad(null);
    }
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(147357);
    if ((!Util.isNullOrNil(paramModulePkgInfo.pkgPath)) && (s.YS(paramModulePkgInfo.pkgPath))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.independent) {
          ex("__APP__", "checkModuleLoaded");
        }
        ex(paramModulePkgInfo.name, "checkModuleLoaded");
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
    this.ngR.r(paramString, new b(paramb, parama));
    AppMethodBeat.o(147362);
  }
  
  public final void a(String paramString, final a.b paramb)
  {
    AppMethodBeat.i(169498);
    final g.a locala = new g.a((byte)0);
    locala.nhj = true;
    locala.nhk = true;
    if (this.ngS.isDestroyed())
    {
      Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.ngS.mAppId });
      if (paramb != null) {
        paramb.a(a.d.ngG);
      }
      AppMethodBeat.o(169498);
      return;
    }
    final i locali = new i();
    if (Util.isNullOrNil(paramString)) {}
    for (Object localObject = this.ngS.OM().leE;; localObject = acO(paramString))
    {
      locali.value = localObject;
      if (!a((ModulePkgInfo)localObject)) {
        break;
      }
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule appId:%s path:%s, module:%s, options:%b, [loaded]", new Object[] { this.ngS.mAppId, paramString, ((ModulePkgInfo)locali.value).name, locala });
      if (paramb == null) {
        break;
      }
      if (locala.nhk) {
        ex(((ModulePkgInfo)locali.value).name, "options.injectModuleJS");
      }
      paramb.a(a.d.ngF);
      AppMethodBeat.o(169498);
      return;
    }
    localObject = new i();
    final PBool localPBool = new PBool();
    if (locala.nhj) {
      this.ngS.i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(229926);
          if (!localPBool.value)
          {
            d locald = new d().a(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(229924);
                paramAnonymous2DialogInterface.dismiss();
                g.a(g.this, ((ModulePkgInfo)g.1.this.ngU.value).name, a.d.ngH);
                AppMethodBeat.o(229924);
              }
            });
            locald.ngL = new android.arch.a.c.a() {};
            locald.ab(g.this.ngS);
            this.ngV.value = locald;
          }
          AppMethodBeat.o(229926);
        }
      }, 0L);
    }
    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, appId:%s path:%s, module:%s, options:%b [do loadOrAddPendingCallback]", new Object[] { this.ngS.mAppId, paramString, ((ModulePkgInfo)locali.value).name, locala });
    a((ModulePkgInfo)locali.value, new a.b()new a.a
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(229928);
        localPBool.value = true;
        if ((a.d.ngF == paramAnonymousd) && (locala != null) && (locala.nhk))
        {
          if (!((ModulePkgInfo)locali.value).independent) {
            g.this.ex("__APP__", "options.injectModuleJS");
          }
          g.this.ex(((ModulePkgInfo)locali.value).name, "options.injectModuleJS");
        }
        g.this.ngS.i(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(229927);
            if (g.2.this.ngV.value != null) {
              ((d)g.2.this.ngV.value).dismiss();
            }
            AppMethodBeat.o(229927);
          }
        }, 0L);
        if (paramb != null) {
          paramb.a(paramAnonymousd);
        }
        AppMethodBeat.o(229928);
      }
    }, new a.a()
    {
      public final void b(c paramAnonymousc)
      {
        AppMethodBeat.i(229929);
        if (Log.getLogLevel() <= 1) {
          Log.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoadProgress, appId:%s, module:%s, progress:%s", new Object[] { g.this.ngS.mAppId, ((ModulePkgInfo)locali.value).name, paramAnonymousc });
        }
        if (this.nhb != null) {
          this.nhb.b(paramAnonymousc);
        }
        d locald = (d)this.ngV.value;
        if (locald != null)
        {
          int i = Math.max(Math.min(paramAnonymousc.getProgress(), 100), 0);
          locald.ngN = i;
          if ((locald.ngM instanceof com.tencent.mm.plugin.appbrand.widget.dialog.g)) {
            ((com.tencent.mm.plugin.appbrand.widget.dialog.g)locald.ngM).setProgress(i);
          }
        }
        AppMethodBeat.o(229929);
      }
    });
    AppMethodBeat.o(169498);
  }
  
  public final void a(String paramString, final a.b paramb, a.a parama)
  {
    AppMethodBeat.i(229939);
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.ngS.OM().leE;
      if (!h.a(localObject, paramString, "findModuleInfoByModuleName")) {}
    }
    while (localObject == null)
    {
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [not found]", new Object[] { this.ngS.mAppId, paramString, Boolean.FALSE });
      paramb.a(a.d.ngI);
      AppMethodBeat.o(229939);
      return;
      String str = WxaPkgWrappingInfo.Vw(paramString);
      bg.L(this.ngS);
      Iterator localIterator = ((WxaPkgWrappingInfo)localObject).kNZ.iterator();
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
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [loaded]", new Object[] { this.ngS.mAppId, paramString, Boolean.FALSE });
      paramb.a(a.d.ngF);
      AppMethodBeat.o(229939);
      return;
    }
    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [do loadOrAddPendingCallback]", new Object[] { this.ngS.mAppId, paramString, Boolean.FALSE });
    a((ModulePkgInfo)localObject, new a.b()
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(229930);
        if ((a.d.ngF == paramAnonymousd) && (this.nhc))
        {
          if (!this.nhd.independent) {
            g.this.ex("__APP__", "options.injectModuleJS");
          }
          g.this.ex(this.nhd.name, "options.injectModuleJS");
        }
        if (paramb != null) {
          paramb.a(paramAnonymousd);
        }
        AppMethodBeat.o(229930);
      }
    }, parama);
    AppMethodBeat.o(229939);
  }
  
  public final String acN(String paramString)
  {
    AppMethodBeat.i(147363);
    paramString = acO(paramString).name;
    AppMethodBeat.o(147363);
    return paramString;
  }
  
  public final ModulePkgInfo acO(String paramString)
  {
    AppMethodBeat.i(147364);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.ngS.OM().leE;
    if ((Util.isNullOrNil(paramString)) || ("__APP__".equals(paramString)))
    {
      AppMethodBeat.o(147364);
      return localWxaPkgWrappingInfo;
    }
    bg.L(this.ngS);
    paramString = (ModulePkgInfo)h.e(localWxaPkgWrappingInfo.kNZ, paramString, "findModuleInfoByResourcePath");
    if (paramString != null)
    {
      AppMethodBeat.o(147364);
      return paramString;
    }
    AppMethodBeat.o(147364);
    return localWxaPkgWrappingInfo;
  }
  
  public final boolean bPn()
  {
    return true;
  }
  
  final boolean bPo()
  {
    AppMethodBeat.i(147356);
    boolean bool = a(this.ngS.OM().leE);
    AppMethodBeat.o(147356);
    return bool;
  }
  
  final void ex(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229938);
    boolean bool = ((f)this.ngS.NY()).dt(paramString1);
    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "injectServiceScriptSafe appId:%s, module:%s, reason:%s ret:%b", new Object[] { this.ngS.mAppId, paramString1, paramString2, Boolean.valueOf(bool) });
    AppMethodBeat.o(229938);
  }
  
  static final class b
  {
    final a.b nhl;
    final a.a nhm;
    
    public b(a.b paramb, a.a parama)
    {
      this.nhl = paramb;
      this.nhm = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.g
 * JD-Core Version:    0.7.0.1
 */