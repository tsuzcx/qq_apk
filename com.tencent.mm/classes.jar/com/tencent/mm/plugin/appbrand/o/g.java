package com.tencent.mm.plugin.appbrand.o;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.h;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
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
  private final Set<String> kTS;
  final h<String, a> kTT;
  final com.tencent.luggage.sdk.d.c kTU;
  private final Map<String, Boolean> kTV;
  
  public g(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147355);
    this.kTS = new HashSet();
    this.kTT = new h();
    this.kTV = new HashMap();
    this.kTU = paramc;
    AppMethodBeat.o(147355);
  }
  
  private void a(ModulePkgInfo arg1, boolean paramBoolean, final a.b paramb, a.a parama)
  {
    AppMethodBeat.i(147361);
    final String str = ???.name;
    final boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.independent) && (!bij()))
    {
      bool1 = true;
      if (bool1) {
        a(this.kTU.DY().jdS, false, null, null);
      }
      ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { ???.name, Boolean.valueOf(???.independent), Boolean.valueOf(bool1) });
      b(str, paramb, parama);
    }
    for (;;)
    {
      synchronized (this.kTS)
      {
        boolean bool2 = this.kTS.contains(str);
        if (!bool2) {
          this.kTS.add(str);
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
                AppMethodBeat.i(147348);
                paramModulePkgInfo.Y(null);
                AppMethodBeat.o(147348);
              }
            }, null);
            paramb = new com.tencent.mm.plugin.appbrand.aa.i();
            if (paramBoolean)
            {
              parama = new d().a(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(147349);
                  paramAnonymousDialogInterface.dismiss();
                  g.a(g.this, str, a.d.kTK);
                  AppMethodBeat.o(147349);
                }
              });
              parama.kTO = new android.arch.a.c.a() {};
              parama.ag(this.kTU);
              paramb.value = parama;
            }
            parama = this.kTU.DY().jdS.bV(this.kTU.mAppId, str);
            parama = e.c.kTR.j(this.kTU, parama);
            parama.a(new e.b()
            {
              public final void Hz(final String paramAnonymousString)
              {
                AppMethodBeat.i(147353);
                ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
                paramAnonymousString = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(147352);
                    if (g.this.kTU.isDestroyed())
                    {
                      ad.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) destroyed", new Object[] { g.4.this.chC, g.this.kTU.toString() });
                      AppMethodBeat.o(147352);
                      return;
                    }
                    int i;
                    if ((!bt.isNullOrNil(paramAnonymousString)) && ((!g.4.this.kTY) || (g.this.bij())))
                    {
                      i = 1;
                      if (i != 0)
                      {
                        if (!"__APP__".equals(g.4.this.chC)) {
                          break label288;
                        }
                        g.this.kTU.DY().jdS.pkgPath = paramAnonymousString;
                        label172:
                        break label311;
                      }
                    }
                    for (;;)
                    {
                      Object localObject2;
                      try
                      {
                        g.this.kTU.DY().jdS.md5 = com.tencent.mm.b.g.b(com.tencent.mm.vfs.i.openRead(paramAnonymousString), 4096);
                        be.T(g.this.kTU);
                        g.this.KS(g.4.this.chC);
                        aq.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(147351);
                            if (g.4.this.kTZ.value != null) {
                              ((DialogInterface)g.4.this.kTZ.value).dismiss();
                            }
                            AppMethodBeat.o(147351);
                          }
                        });
                        localObject2 = g.this;
                        String str = g.4.this.chC;
                        if (i == 0) {
                          break label358;
                        }
                        a.d locald = a.d.kTI;
                        g.a((g)localObject2, str, locald);
                        AppMethodBeat.o(147352);
                        return;
                        i = 0;
                      }
                      catch (FileNotFoundException localFileNotFoundException)
                      {
                        ad.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", new Object[] { g.this.kTU.mAppId });
                        continue;
                      }
                      label288:
                      Object localObject1 = g.this.kTU.DY().jdS.iOT.iterator();
                      label311:
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
                        if (!g.4.this.chC.equals(((ModulePkgInfo)localObject2).name)) {
                          break label172;
                        }
                        ((ModulePkgInfo)localObject2).pkgPath = paramAnonymousString;
                        continue;
                        label358:
                        localObject1 = a.d.kTJ;
                      }
                    }
                  }
                };
                paramModulePkgInfo.Y(paramAnonymousString);
                AppMethodBeat.o(147353);
              }
              
              public final void a(final android.arch.a.c.a<AppBrandRuntime, Boolean> paramAnonymousa)
              {
                AppMethodBeat.i(182993);
                paramAnonymousa = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(182992);
                    boolean bool = g.this.kTU.isDestroyed();
                    ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%s)", new Object[] { g.this.kTU.toString(), g.4.this.chC, Boolean.valueOf(bool) });
                    if (bool)
                    {
                      AppMethodBeat.o(182992);
                      return;
                    }
                    bool = ((Boolean)paramAnonymousa.apply(g.this.kTU)).booleanValue();
                    if (bool) {
                      g.this.KS(g.4.this.chC);
                    }
                    g.this.kTU.i(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(182991);
                        if (g.4.this.kTZ.value != null) {
                          ((DialogInterface)g.4.this.kTZ.value).dismiss();
                        }
                        AppMethodBeat.o(182991);
                      }
                    }, 0L);
                    g localg = g.this;
                    String str = g.4.this.chC;
                    if (bool) {}
                    for (a.d locald = a.d.kTI;; locald = a.d.kTJ)
                    {
                      g.a(localg, str, locald);
                      AppMethodBeat.o(182992);
                      return;
                    }
                  }
                };
                paramModulePkgInfo.Y(paramAnonymousa);
                AppMethodBeat.o(182993);
              }
              
              public final void a(c paramAnonymousc)
              {
                AppMethodBeat.i(147354);
                ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                Object localObject1 = g.this;
                Object localObject2 = str;
                localObject1 = ((g)localObject1).kTT.cD(localObject2);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(147354);
                  return;
                }
                localObject1 = ((Set)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (g.a)((Iterator)localObject1).next();
                  if (((g.a)localObject2).kUg != null) {
                    ((g.a)localObject2).kUg.b(paramAnonymousc);
                  }
                }
                AppMethodBeat.o(147354);
              }
            });
            parama.start();
          }
        }
        else
        {
          AppMethodBeat.o(147361);
          return;
          bool1 = false;
        }
      }
      ???.Y(null);
    }
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(147357);
    if ((!bt.isNullOrNil(paramModulePkgInfo.pkgPath)) && (com.tencent.mm.vfs.i.eK(paramModulePkgInfo.pkgPath))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.independent) {
          KS("__APP__");
        }
        KS(paramModulePkgInfo.name);
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
    this.kTT.h(paramString, new a(paramb, parama));
    AppMethodBeat.o(147362);
  }
  
  public final String KR(String paramString)
  {
    AppMethodBeat.i(147363);
    paramString = KT(paramString).name;
    AppMethodBeat.o(147363);
    return paramString;
  }
  
  final void KS(String paramString)
  {
    AppMethodBeat.i(147358);
    synchronized (this.kTV)
    {
      if (this.kTV.containsKey(paramString))
      {
        AppMethodBeat.o(147358);
        return;
      }
      ((f)this.kTU.Du()).ci(paramString);
      this.kTV.put(paramString, Boolean.TRUE);
      ad.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "module (%s) injected", new Object[] { paramString });
      AppMethodBeat.o(147358);
      return;
    }
  }
  
  public final ModulePkgInfo KT(String paramString)
  {
    AppMethodBeat.i(147364);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.kTU.DY().jdS;
    if ((bt.isNullOrNil(paramString)) || ("__APP__".equals(paramString)))
    {
      AppMethodBeat.o(147364);
      return localWxaPkgWrappingInfo;
    }
    String str = m.EV(paramString);
    be.T(this.kTU);
    Iterator localIterator = localWxaPkgWrappingInfo.iOT.iterator();
    while (localIterator.hasNext())
    {
      ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
      if (str.startsWith(localModulePkgInfo.name))
      {
        AppMethodBeat.o(147364);
        return localModulePkgInfo;
      }
      if ((localModulePkgInfo.aliases != null) && (localModulePkgInfo.aliases.length > 0))
      {
        String[] arrayOfString = localModulePkgInfo.aliases;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.startsWith(arrayOfString[i]))
          {
            AppMethodBeat.o(147364);
            return localModulePkgInfo;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(147364);
    return localWxaPkgWrappingInfo;
  }
  
  public final void a(String paramString, a.b paramb)
  {
    AppMethodBeat.i(169498);
    if (this.kTU.isDestroyed())
    {
      ad.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.kTU.mAppId });
      paramb.a(a.d.kTJ);
      AppMethodBeat.o(169498);
      return;
    }
    com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
    if (bt.isNullOrNil(paramString)) {}
    for (paramString = this.kTU.DY().jdS;; paramString = KT(paramString))
    {
      locali.value = paramString;
      if ((!a(paramString)) || (paramb == null)) {
        break;
      }
      paramb.a(a.d.kTI);
      AppMethodBeat.o(169498);
      return;
    }
    a((ModulePkgInfo)locali.value, true, paramb, null);
    AppMethodBeat.o(169498);
  }
  
  public final void a(String paramString, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(169497);
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.kTU.DY().jdS;
      if ("__APP__".equals(paramString)) {
        paramString = (String)localObject;
      }
    }
    while (paramString == null)
    {
      paramb.a(a.d.kTL);
      AppMethodBeat.o(169497);
      return;
      String str = WxaPkgWrappingInfo.Eq(paramString);
      be.T(this.kTU);
      localObject = ((WxaPkgWrappingInfo)localObject).iOT.iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          paramString = (ModulePkgInfo)((Iterator)localObject).next();
          if (paramString.name.equals(str)) {
            break;
          }
        }
      }
      paramString = null;
    }
    if (a(paramString))
    {
      paramb.a(a.d.kTI);
      AppMethodBeat.o(169497);
      return;
    }
    a(paramString, false, paramb, parama);
    AppMethodBeat.o(169497);
  }
  
  public final boolean bii()
  {
    return true;
  }
  
  final boolean bij()
  {
    AppMethodBeat.i(147356);
    boolean bool = a(this.kTU.DY().jdS);
    AppMethodBeat.o(147356);
    return bool;
  }
  
  static final class a
  {
    final a.b kUf;
    final a.a kUg;
    
    public a(a.b paramb, a.a parama)
    {
      this.kUf = paramb;
      this.kUg = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.g
 * JD-Core Version:    0.7.0.1
 */