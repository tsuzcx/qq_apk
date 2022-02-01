package com.tencent.mm.plugin.appbrand.p;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.widget.dialog.j.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f
  implements a
{
  private final Set<String> qhA;
  final h<String, b> qhB;
  final com.tencent.luggage.sdk.e.d qhC;
  
  public f(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(147355);
    this.qhA = new HashSet();
    this.qhB = new h();
    this.qhC = paramd;
    AppMethodBeat.o(147355);
  }
  
  private void a(ModulePkgInfo arg1, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(234712);
    final String str = ???.name;
    final boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.independent) && (!cbF()))
    {
      bool1 = true;
      if (bool1) {
        a(this.qhC.Sj().nYR, null, null);
      }
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { ???.name, Boolean.valueOf(???.independent), Boolean.valueOf(bool1) });
      b(str, paramb, parama);
    }
    for (;;)
    {
      synchronized (this.qhA)
      {
        boolean bool2 = this.qhA.contains(str);
        if (!bool2) {
          this.qhA.add(str);
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
                AppMethodBeat.i(248856);
                paramModulePkgInfo.ag(null);
                AppMethodBeat.o(248856);
              }
            }, null);
            paramb = this.qhC.Sj().nYR.cA(this.qhC.mAppId, str);
            paramb = d.c.qhz.k(this.qhC, paramb);
            paramb.a(new d.b()
            {
              public final void a(final androidx.a.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
              {
                AppMethodBeat.i(247790);
                paramAnonymousa = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(250986);
                    boolean bool2 = f.this.qhC.ntU.get();
                    boolean bool3 = f.this.qhC.aol;
                    if ((bool2) || (bool3)) {}
                    for (boolean bool1 = false;; bool1 = ((Boolean)paramAnonymousa.apply(f.this.qhC)).booleanValue())
                    {
                      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%b) isFinishing(%b) loaded(%b)", new Object[] { f.this.qhC.toString(), f.6.this.cAl, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
                      if ((!bool2) && (!bool3)) {
                        break;
                      }
                      AppMethodBeat.o(250986);
                      return;
                    }
                    if ((bool1) && (!f.this.qhC.getAppConfig().nWa.booleanValue())) {
                      f.this.qhC.bCa();
                    }
                    f localf = f.this;
                    String str = f.6.this.cAl;
                    if (bool1) {}
                    for (a.d locald = a.d.qhp;; locald = a.d.qhq)
                    {
                      f.a(localf, str, locald);
                      AppMethodBeat.o(250986);
                      return;
                    }
                  }
                };
                paramModulePkgInfo.ag(paramAnonymousa);
                AppMethodBeat.o(247790);
              }
              
              public final void a(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
              {
                AppMethodBeat.i(247789);
                Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramAnonymousWxaPkgLoadProgress });
                Object localObject1 = f.this;
                Object localObject2 = str;
                localObject1 = ((f)localObject1).qhB.cN(localObject2);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(247789);
                  return;
                }
                localObject1 = ((Set)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (f.b)((Iterator)localObject1).next();
                  if (((f.b)localObject2).qhV != null) {
                    ((f.b)localObject2).qhV.b(paramAnonymousWxaPkgLoadProgress);
                  }
                }
                AppMethodBeat.o(247789);
              }
            });
            paramb.start();
          }
        }
        else
        {
          AppMethodBeat.o(234712);
          return;
          bool1 = false;
        }
      }
      ???.ag(null);
    }
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(147357);
    if ((!Util.isNullOrNil(paramModulePkgInfo.pkgPath)) && (u.agG(paramModulePkgInfo.pkgPath))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.independent) {
          eL("__APP__", "checkModuleLoaded");
        }
        eL(paramModulePkgInfo.name, "checkModuleLoaded");
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
    this.qhB.k(paramString, new b(paramb, parama));
    AppMethodBeat.o(147362);
  }
  
  private boolean cbF()
  {
    AppMethodBeat.i(147356);
    boolean bool = a(this.qhC.Sj().nYR);
    AppMethodBeat.o(147356);
    return bool;
  }
  
  public final void a(String paramString, final a.b paramb)
  {
    AppMethodBeat.i(169498);
    final f.a locala = new f.a((byte)0);
    locala.qhS = true;
    locala.qhT = true;
    if (this.qhC.ntU.get())
    {
      Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.qhC.mAppId });
      if (paramb != null) {
        paramb.a(a.d.qhq);
      }
      AppMethodBeat.o(169498);
      return;
    }
    final i locali = new i();
    if (Util.isNullOrNil(paramString)) {}
    for (Object localObject = this.qhC.Sj().nYR;; localObject = akI(paramString))
    {
      locali.value = localObject;
      if (!a((ModulePkgInfo)localObject)) {
        break;
      }
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule appId:%s path:%s, module:%s, options:%b, [loaded]", new Object[] { this.qhC.mAppId, paramString, ((ModulePkgInfo)locali.value).name, locala });
      if (paramb == null) {
        break;
      }
      if (locala.qhT) {
        eL(((ModulePkgInfo)locali.value).name, "options.injectModuleJS");
      }
      paramb.a(a.d.qhp);
      AppMethodBeat.o(169498);
      return;
    }
    localObject = new i();
    final PBool localPBool = new PBool();
    if (locala.qhS) {
      this.qhC.h(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(247498);
          if (!localPBool.value)
          {
            c localc = new c().a(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(244604);
                paramAnonymous2DialogInterface.dismiss();
                f.a(f.this, ((ModulePkgInfo)f.1.this.qhE.value).name, a.d.qhr);
                AppMethodBeat.o(244604);
              }
            });
            localc.qhv = new androidx.a.a.c.a() {};
            localc.ab(f.this.qhC);
            this.qhF.value = localc;
          }
          AppMethodBeat.o(247498);
        }
      }, 0L);
    }
    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, appId:%s path:%s, module:%s, options:%b [do loadOrAddPendingCallback]", new Object[] { this.qhC.mAppId, paramString, ((ModulePkgInfo)locali.value).name, locala });
    a((ModulePkgInfo)locali.value, new a.b()new a.a
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(233970);
        localPBool.value = true;
        if ((a.d.qhp == paramAnonymousd) && (locala != null) && (locala.qhT))
        {
          if (!((ModulePkgInfo)locali.value).independent) {
            f.this.eL("__APP__", "options.injectModuleJS");
          }
          f.this.eL(((ModulePkgInfo)locali.value).name, "options.injectModuleJS");
        }
        f.this.qhC.h(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(239142);
            if (f.2.this.qhF.value != null) {
              ((c)f.2.this.qhF.value).dismiss();
            }
            AppMethodBeat.o(239142);
          }
        }, 0L);
        if (paramb != null) {
          paramb.a(paramAnonymousd);
        }
        AppMethodBeat.o(233970);
      }
    }, new a.a()
    {
      public final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(247797);
        if (Log.getLogLevel() <= 1) {
          Log.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoadProgress, appId:%s, module:%s, progress:%s", new Object[] { f.this.qhC.mAppId, ((ModulePkgInfo)locali.value).name, paramAnonymousWxaPkgLoadProgress });
        }
        if (this.qhL != null) {
          this.qhL.b(paramAnonymousWxaPkgLoadProgress);
        }
        c localc = (c)this.qhF.value;
        if (localc != null)
        {
          int i = Math.max(Math.min(paramAnonymousWxaPkgLoadProgress.progress, 100), 0);
          localc.qhx = i;
          if ((localc.qhw instanceof com.tencent.mm.plugin.appbrand.widget.dialog.f)) {
            ((com.tencent.mm.plugin.appbrand.widget.dialog.f)localc.qhw).setProgress(i);
          }
        }
        AppMethodBeat.o(247797);
      }
    });
    AppMethodBeat.o(169498);
  }
  
  public final void a(String paramString, final a.b paramb, a.a parama)
  {
    AppMethodBeat.i(234710);
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.qhC.Sj().nYR;
      if (!g.a(localObject, paramString, "findModuleInfoByModuleName")) {}
    }
    while (localObject == null)
    {
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [not found]", new Object[] { this.qhC.mAppId, paramString, Boolean.FALSE });
      paramb.a(a.d.qhs);
      AppMethodBeat.o(234710);
      return;
      String str = WxaPkgWrappingInfo.adg(paramString);
      bl.M(this.qhC);
      Iterator localIterator = ((WxaPkgWrappingInfo)localObject).nIb.iterator();
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
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [loaded]", new Object[] { this.qhC.mAppId, paramString, Boolean.FALSE });
      paramb.a(a.d.qhp);
      AppMethodBeat.o(234710);
      return;
    }
    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [do loadOrAddPendingCallback]", new Object[] { this.qhC.mAppId, paramString, Boolean.FALSE });
    a((ModulePkgInfo)localObject, new a.b()
    {
      public final void a(a.d paramAnonymousd)
      {
        AppMethodBeat.i(245138);
        if ((a.d.qhp == paramAnonymousd) && (this.qhM))
        {
          if (!this.qhN.independent) {
            f.this.eL("__APP__", "options.injectModuleJS");
          }
          f.this.eL(this.qhN.name, "options.injectModuleJS");
        }
        if (paramb != null) {
          paramb.a(paramAnonymousd);
        }
        AppMethodBeat.o(245138);
      }
    }, parama);
    AppMethodBeat.o(234710);
  }
  
  public final String akH(String paramString)
  {
    AppMethodBeat.i(147363);
    paramString = akI(paramString).name;
    AppMethodBeat.o(147363);
    return paramString;
  }
  
  public final ModulePkgInfo akI(String paramString)
  {
    AppMethodBeat.i(147364);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.qhC.Sj().nYR;
    if ((Util.isNullOrNil(paramString)) || ("__APP__".equals(paramString)))
    {
      AppMethodBeat.o(147364);
      return localWxaPkgWrappingInfo;
    }
    bl.M(this.qhC);
    paramString = (ModulePkgInfo)g.d(localWxaPkgWrappingInfo.nIb, paramString, "findModuleInfoByResourcePath");
    if (paramString != null)
    {
      AppMethodBeat.o(147364);
      return paramString;
    }
    AppMethodBeat.o(147364);
    return localWxaPkgWrappingInfo;
  }
  
  public final boolean cbE()
  {
    return true;
  }
  
  final void eL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234709);
    boolean bool = ((e)this.qhC.QW()).dK(paramString1);
    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "injectServiceScriptSafe appId:%s, module:%s, reason:%s ret:%b", new Object[] { this.qhC.mAppId, paramString1, paramString2, Boolean.valueOf(bool) });
    AppMethodBeat.o(234709);
  }
  
  static final class b
  {
    final a.b qhU;
    final a.a qhV;
    
    public b(a.b paramb, a.a parama)
    {
      this.qhU = paramb;
      this.qhV = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.f
 * JD-Core Version:    0.7.0.1
 */