package com.tencent.mm.plugin.appbrand.q;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.widget.dialog.n.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class f
  implements a
{
  final com.tencent.luggage.sdk.e.d ewn;
  private final Set<String> tml;
  final com.tencent.mm.plugin.appbrand.af.j<String, b> tmm;
  
  public f(com.tencent.luggage.sdk.e.d paramd)
  {
    AppMethodBeat.i(147355);
    this.tml = new HashSet();
    this.tmm = new com.tencent.mm.plugin.appbrand.af.j();
    this.ewn = paramd;
    AppMethodBeat.o(147355);
  }
  
  private void a(ModulePkgInfo arg1, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(321594);
    final String str = ???.name;
    final boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.independent) && (!cBY()))
    {
      bool1 = true;
      if (bool1) {
        a(this.ewn.asz().qYY, null, null);
      }
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { ???.name, Boolean.valueOf(???.independent), Boolean.valueOf(bool1) });
      a(str, paramb, parama);
    }
    for (;;)
    {
      synchronized (this.tml)
      {
        boolean bool2 = this.tml.contains(str);
        if (!bool2) {
          this.tml.add(str);
        }
        if (!bool2)
        {
          ??? = new b();
          if (bool1)
          {
            a("__APP__", new a.b()
            {
              public final void onLoadResult(a.d paramAnonymousd)
              {
                AppMethodBeat.i(321572);
                paramModulePkgInfo.am(null);
                AppMethodBeat.o(321572);
              }
            }, null);
            paramb = this.ewn.asz().qYY.cR(this.ewn.mAppId, str);
            paramb = d.c.tmk.k(this.ewn, paramb);
            paramb.a(new d.b()
            {
              public final void a(final androidx.a.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
              {
                AppMethodBeat.i(321584);
                paramAnonymousa = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(321574);
                    boolean bool2 = f.this.ewn.qsE.get();
                    boolean bool3 = f.this.ewn.ccV;
                    if ((bool2) || (bool3)) {}
                    for (boolean bool1 = false;; bool1 = ((Boolean)paramAnonymousa.apply(f.this.ewn)).booleanValue())
                    {
                      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%b) isFinishing(%b) loaded(%b)", new Object[] { f.this.ewn.toString(), f.6.this.val$moduleName, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
                      if ((!bool2) && (!bool3)) {
                        break;
                      }
                      AppMethodBeat.o(321574);
                      return;
                    }
                    if ((bool1) && (!f.this.ewn.getAppConfig().qVK.booleanValue())) {
                      f.this.ewn.cbt();
                    }
                    f localf = f.this;
                    String str = f.6.this.val$moduleName;
                    if (bool1) {}
                    for (a.d locald = a.d.tma;; locald = a.d.tmb)
                    {
                      f.a(localf, str, locald);
                      AppMethodBeat.o(321574);
                      return;
                    }
                  }
                };
                paramModulePkgInfo.am(paramAnonymousa);
                AppMethodBeat.o(321584);
              }
              
              public final void a(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
              {
                AppMethodBeat.i(321581);
                Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramAnonymousWxaPkgLoadProgress });
                Object localObject1 = f.this;
                Object localObject2 = str;
                localObject1 = ((f)localObject1).tmm.ej(localObject2);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(321581);
                  return;
                }
                localObject1 = ((Set)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (f.b)((Iterator)localObject1).next();
                  if (((f.b)localObject2).tmF != null) {
                    ((f.b)localObject2).tmF.b(paramAnonymousWxaPkgLoadProgress);
                  }
                }
                AppMethodBeat.o(321581);
              }
            });
            paramb.start();
          }
        }
        else
        {
          AppMethodBeat.o(321594);
          return;
          bool1 = false;
        }
      }
      ???.am(null);
    }
  }
  
  private void a(String paramString, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(147362);
    if ((paramb == null) && (parama == null))
    {
      AppMethodBeat.o(147362);
      return;
    }
    this.tmm.v(paramString, new b(paramb, parama));
    AppMethodBeat.o(147362);
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(147357);
    if ((!Util.isNullOrNil(paramModulePkgInfo.pkgPath)) && (y.ZC(paramModulePkgInfo.pkgPath))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.independent) {
          fc("__APP__", "checkModuleLoaded");
        }
        fc(paramModulePkgInfo.name, "checkModuleLoaded");
      }
      AppMethodBeat.o(147357);
      return bool;
    }
  }
  
  private boolean cBY()
  {
    AppMethodBeat.i(147356);
    boolean bool = a(this.ewn.asz().qYY);
    AppMethodBeat.o(147356);
    return bool;
  }
  
  public final void a(String paramString, final a.b paramb)
  {
    AppMethodBeat.i(169498);
    final f.a locala = new f.a((byte)0);
    locala.tmC = true;
    locala.tmD = true;
    if (this.ewn.qsE.get())
    {
      Log.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.ewn.mAppId });
      if (paramb != null) {
        paramb.onLoadResult(a.d.tmb);
      }
      AppMethodBeat.o(169498);
      return;
    }
    final k localk = new k();
    if (Util.isNullOrNil(paramString)) {}
    for (Object localObject = this.ewn.asz().qYY;; localObject = adO(paramString))
    {
      localk.value = localObject;
      if (!a((ModulePkgInfo)localObject)) {
        break;
      }
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule appId:%s path:%s, module:%s, options:%b, [loaded]", new Object[] { this.ewn.mAppId, paramString, ((ModulePkgInfo)localk.value).name, locala });
      if (paramb == null) {
        break;
      }
      if (locala.tmD) {
        fc(((ModulePkgInfo)localk.value).name, "options.injectModuleJS");
      }
      paramb.onLoadResult(a.d.tma);
      AppMethodBeat.o(169498);
      return;
    }
    localObject = new k();
    final PBool localPBool = new PBool();
    if (locala.tmC) {
      this.ewn.i(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(321582);
          if (!localPBool.value)
          {
            c localc = new c().a(new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(321592);
                paramAnonymous2DialogInterface.dismiss();
                f.a(f.this, ((ModulePkgInfo)f.1.this.tmo.value).name, a.d.tmc);
                AppMethodBeat.o(321592);
              }
            });
            localc.tmg = new androidx.a.a.c.a() {};
            localc.ap(f.this.ewn);
            this.tmp.value = localc;
          }
          AppMethodBeat.o(321582);
        }
      }, 0L);
    }
    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, appId:%s path:%s, module:%s, options:%b [do loadOrAddPendingCallback]", new Object[] { this.ewn.mAppId, paramString, ((ModulePkgInfo)localk.value).name, locala });
    a((ModulePkgInfo)localk.value, new a.b()new a.a
    {
      public final void onLoadResult(a.d paramAnonymousd)
      {
        AppMethodBeat.i(321578);
        localPBool.value = true;
        if ((a.d.tma == paramAnonymousd) && (locala != null) && (locala.tmD))
        {
          if (!((ModulePkgInfo)localk.value).independent) {
            f.this.fc("__APP__", "options.injectModuleJS");
          }
          f.this.fc(((ModulePkgInfo)localk.value).name, "options.injectModuleJS");
        }
        f.this.ewn.i(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(321577);
            if (f.2.this.tmp.value != null) {
              ((c)f.2.this.tmp.value).dismiss();
            }
            AppMethodBeat.o(321577);
          }
        }, 0L);
        if (paramb != null) {
          paramb.onLoadResult(paramAnonymousd);
        }
        AppMethodBeat.o(321578);
      }
    }, new a.a()
    {
      public final void b(WxaPkgLoadProgress paramAnonymousWxaPkgLoadProgress)
      {
        AppMethodBeat.i(321579);
        if (Log.getLogLevel() <= 1) {
          Log.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoadProgress, appId:%s, module:%s, progress:%s", new Object[] { f.this.ewn.mAppId, ((ModulePkgInfo)localk.value).name, paramAnonymousWxaPkgLoadProgress });
        }
        if (this.tmv != null) {
          this.tmv.b(paramAnonymousWxaPkgLoadProgress);
        }
        c localc = (c)this.tmp.value;
        if (localc != null)
        {
          int i = Math.max(Math.min(paramAnonymousWxaPkgLoadProgress.progress, 100), 0);
          localc.tmi = i;
          if ((localc.tmh instanceof com.tencent.mm.plugin.appbrand.widget.dialog.j)) {
            ((com.tencent.mm.plugin.appbrand.widget.dialog.j)localc.tmh).setProgress(i);
          }
        }
        AppMethodBeat.o(321579);
      }
    });
    AppMethodBeat.o(169498);
  }
  
  public final void a(String paramString, final a.b paramb, a.a parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(321621);
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    while (localObject == null)
    {
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [not found]", new Object[] { this.ewn.mAppId, paramString, Boolean.valueOf(paramBoolean) });
      if (paramb == null) {
        break label271;
      }
      paramb.onLoadResult(a.d.tmd);
      AppMethodBeat.o(321621);
      return;
      WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.ewn.asz().qYY;
      localObject = localWxaPkgWrappingInfo;
      if (!g.a(localWxaPkgWrappingInfo, paramString, "findModuleInfoByModuleName"))
      {
        localObject = WxaPkgWrappingInfo.VC(paramString);
        bl.Q(this.ewn);
        localObject = (ModulePkgInfo)g.c(localWxaPkgWrappingInfo.qHR, (String)localObject, "findModuleInfoByModuleName");
      }
    }
    if (a((ModulePkgInfo)localObject))
    {
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [loaded]", new Object[] { this.ewn.mAppId, paramString, Boolean.valueOf(paramBoolean) });
      if (paramBoolean) {
        fc(((ModulePkgInfo)localObject).name, "options.injectModuleJS");
      }
      if (paramb != null)
      {
        paramb.onLoadResult(a.d.tma);
        AppMethodBeat.o(321621);
      }
    }
    else
    {
      Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [do loadOrAddPendingCallback]", new Object[] { this.ewn.mAppId, paramString, Boolean.valueOf(paramBoolean) });
      a((ModulePkgInfo)localObject, new a.b()
      {
        public final void onLoadResult(a.d paramAnonymousd)
        {
          AppMethodBeat.i(321571);
          if ((a.d.tma == paramAnonymousd) && (paramBoolean))
          {
            if (!this.tmx.independent) {
              f.this.fc("__APP__", "options.injectModuleJS");
            }
            f.this.fc(this.tmx.name, "options.injectModuleJS");
          }
          if (paramb != null) {
            paramb.onLoadResult(paramAnonymousd);
          }
          AppMethodBeat.o(321571);
        }
      }, parama);
    }
    label271:
    AppMethodBeat.o(321621);
  }
  
  public final String adN(String paramString)
  {
    AppMethodBeat.i(147363);
    paramString = adO(paramString).name;
    AppMethodBeat.o(147363);
    return paramString;
  }
  
  public final ModulePkgInfo adO(String paramString)
  {
    AppMethodBeat.i(147364);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.ewn.asz().qYY;
    if ((Util.isNullOrNil(paramString)) || ("__APP__".equals(paramString)))
    {
      AppMethodBeat.o(147364);
      return localWxaPkgWrappingInfo;
    }
    bl.Q(this.ewn);
    paramString = (ModulePkgInfo)g.c(localWxaPkgWrappingInfo.qHR, paramString, "findModuleInfoByResourcePath");
    if (paramString != null)
    {
      AppMethodBeat.o(147364);
      return paramString;
    }
    AppMethodBeat.o(147364);
    return localWxaPkgWrappingInfo;
  }
  
  public final boolean cBX()
  {
    return true;
  }
  
  final void fc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(321614);
    boolean bool = ((e)this.ewn.ari()).eV(paramString1);
    Log.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "injectServiceScriptSafe appId:%s, module:%s, reason:%s ret:%b", new Object[] { this.ewn.mAppId, paramString1, paramString2, Boolean.valueOf(bool) });
    AppMethodBeat.o(321614);
  }
  
  static final class b
  {
    final a.b tmE;
    final a.a tmF;
    
    public b(a.b paramb, a.a parama)
    {
      this.tmE = paramb;
      this.tmF = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.f
 * JD-Core Version:    0.7.0.1
 */