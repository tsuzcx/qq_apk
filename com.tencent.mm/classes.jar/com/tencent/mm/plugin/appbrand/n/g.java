package com.tencent.mm.plugin.appbrand.n;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private final Map<String, Boolean> lvA;
  private final Set<String> lvx;
  final com.tencent.mm.plugin.appbrand.z.h<String, b> lvy;
  final com.tencent.luggage.sdk.d.c lvz;
  
  public g(com.tencent.luggage.sdk.d.c paramc)
  {
    AppMethodBeat.i(147355);
    this.lvx = new HashSet();
    this.lvy = new com.tencent.mm.plugin.appbrand.z.h();
    this.lvA = new HashMap();
    this.lvz = paramc;
    AppMethodBeat.o(147355);
  }
  
  private void a(ModulePkgInfo arg1, final a parama, final a.b paramb, a.a parama1)
  {
    int i = 1;
    AppMethodBeat.i(206165);
    final String str = ???.name;
    final boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.independent) && (!bpd()))
    {
      bool1 = true;
      if (bool1) {
        a(this.lvz.DB().jEg, parama, null, null);
      }
      ac.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b, options:%s", new Object[] { ???.name, Boolean.valueOf(???.independent), Boolean.valueOf(bool1), parama });
      b(str, paramb, parama1);
    }
    for (;;)
    {
      synchronized (this.lvx)
      {
        boolean bool2 = this.lvx.contains(str);
        if (!bool2) {
          this.lvx.add(str);
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
                paramModulePkgInfo.aa(null);
                AppMethodBeat.o(147348);
              }
            }, null);
            paramb = new com.tencent.mm.plugin.appbrand.z.i();
            if ((parama == null) || (!parama.lvL)) {
              break label356;
            }
            if (i != 0)
            {
              parama1 = new d().a(new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(147349);
                  paramAnonymousDialogInterface.dismiss();
                  g.a(g.this, str, a.d.lvp);
                  AppMethodBeat.o(147349);
                }
              });
              parama1.lvt = new android.arch.a.c.a() {};
              parama1.ag(this.lvz);
              paramb.value = parama1;
            }
            parama1 = this.lvz.DB().jEg.ce(this.lvz.mAppId, str);
            parama1 = e.c.lvw.j(this.lvz, parama1);
            parama1.a(new e.b()
            {
              public final void LD(final String paramAnonymousString)
              {
                AppMethodBeat.i(147353);
                ac.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", new Object[] { str, paramAnonymousString });
                paramAnonymousString = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(147352);
                    if (g.this.lvz.isDestroyed())
                    {
                      ac.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad with module(%s) but runtime(%s) destroyed", new Object[] { g.4.this.cex, g.this.lvz.toString() });
                      AppMethodBeat.o(147352);
                      return;
                    }
                    int i;
                    if ((!bs.isNullOrNil(paramAnonymousString)) && ((!g.4.this.lvD) || (g.this.bpd())))
                    {
                      i = 1;
                      if (i != 0)
                      {
                        if (!"__APP__".equals(g.4.this.cex)) {
                          break label311;
                        }
                        g.this.lvz.DB().jEg.pkgPath = paramAnonymousString;
                        label172:
                        break label334;
                      }
                    }
                    for (;;)
                    {
                      Object localObject2;
                      try
                      {
                        g.this.lvz.DB().jEg.md5 = com.tencent.mm.b.g.b(com.tencent.mm.vfs.i.openRead(paramAnonymousString), 4096);
                        be.T(g.this.lvz);
                        if ((g.4.this.lvE != null) && (g.4.this.lvE.lvM)) {
                          g.this.OZ(g.4.this.cex);
                        }
                        ap.f(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(147351);
                            if (g.4.this.lvF.value != null) {
                              ((DialogInterface)g.4.this.lvF.value).dismiss();
                            }
                            AppMethodBeat.o(147351);
                          }
                        });
                        localObject2 = g.this;
                        String str = g.4.this.cex;
                        if (i == 0) {
                          break label381;
                        }
                        a.d locald = a.d.lvn;
                        g.a((g)localObject2, str, locald);
                        AppMethodBeat.o(147352);
                        return;
                        i = 0;
                      }
                      catch (FileNotFoundException localFileNotFoundException)
                      {
                        ac.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", new Object[] { g.this.lvz.mAppId });
                        continue;
                      }
                      label311:
                      Object localObject1 = g.this.lvz.DB().jEg.jpd.iterator();
                      label334:
                      if (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = (ModulePkgInfo)((Iterator)localObject1).next();
                        if (!g.4.this.cex.equals(((ModulePkgInfo)localObject2).name)) {
                          break label172;
                        }
                        ((ModulePkgInfo)localObject2).pkgPath = paramAnonymousString;
                        continue;
                        label381:
                        localObject1 = a.d.lvo;
                      }
                    }
                  }
                };
                paramModulePkgInfo.aa(paramAnonymousString);
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
                    boolean bool2 = g.this.lvz.isDestroyed();
                    if (bool2) {}
                    for (boolean bool1 = false;; bool1 = ((Boolean)paramAnonymousa.apply(g.this.lvz)).booleanValue())
                    {
                      ac.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad onResultCustomAction, runtime(%s), moduleName(%s) destroyed(%b) loaded(%b)", new Object[] { g.this.lvz.toString(), g.4.this.cex, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
                      if (!bool2) {
                        break;
                      }
                      AppMethodBeat.o(182992);
                      return;
                    }
                    if ((bool1) && (g.4.this.lvE != null) && (g.4.this.lvE.lvM)) {
                      g.this.OZ(g.4.this.cex);
                    }
                    g.this.lvz.i(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(182991);
                        if (g.4.this.lvF.value != null) {
                          ((DialogInterface)g.4.this.lvF.value).dismiss();
                        }
                        AppMethodBeat.o(182991);
                      }
                    }, 0L);
                    g localg = g.this;
                    String str = g.4.this.cex;
                    if (bool1) {}
                    for (a.d locald = a.d.lvn;; locald = a.d.lvo)
                    {
                      g.a(localg, str, locald);
                      AppMethodBeat.o(182992);
                      return;
                    }
                  }
                };
                paramModulePkgInfo.aa(paramAnonymousa);
                AppMethodBeat.o(182993);
              }
              
              public final void a(c paramAnonymousc)
              {
                AppMethodBeat.i(147354);
                ac.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", new Object[] { paramAnonymousc });
                Object localObject1 = g.this;
                Object localObject2 = str;
                localObject1 = ((g)localObject1).lvy.cC(localObject2);
                if (localObject1 == null)
                {
                  AppMethodBeat.o(147354);
                  return;
                }
                localObject1 = ((Set)localObject1).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (g.b)((Iterator)localObject1).next();
                  if (((g.b)localObject2).lvO != null) {
                    ((g.b)localObject2).lvO.b(paramAnonymousc);
                  }
                }
                AppMethodBeat.o(147354);
              }
            });
            parama1.start();
          }
        }
        else
        {
          AppMethodBeat.o(206165);
          return;
          bool1 = false;
        }
      }
      ???.aa(null);
      continue;
      label356:
      i = 0;
    }
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(147357);
    if ((!bs.isNullOrNil(paramModulePkgInfo.pkgPath)) && (com.tencent.mm.vfs.i.eA(paramModulePkgInfo.pkgPath))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.independent) {
          OZ("__APP__");
        }
        OZ(paramModulePkgInfo.name);
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
    this.lvy.h(paramString, new b(paramb, parama));
    AppMethodBeat.o(147362);
  }
  
  public final String OY(String paramString)
  {
    AppMethodBeat.i(147363);
    paramString = Pa(paramString).name;
    AppMethodBeat.o(147363);
    return paramString;
  }
  
  final void OZ(String paramString)
  {
    AppMethodBeat.i(147358);
    synchronized (this.lvA)
    {
      if (this.lvA.containsKey(paramString))
      {
        AppMethodBeat.o(147358);
        return;
      }
      ((f)this.lvz.CX()).bY(paramString);
      this.lvA.put(paramString, Boolean.TRUE);
      ac.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "module (%s) injected", new Object[] { paramString });
      AppMethodBeat.o(147358);
      return;
    }
  }
  
  public final ModulePkgInfo Pa(String paramString)
  {
    AppMethodBeat.i(147364);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.lvz.DB().jEg;
    if ((bs.isNullOrNil(paramString)) || ("__APP__".equals(paramString)))
    {
      AppMethodBeat.o(147364);
      return localWxaPkgWrappingInfo;
    }
    String str = m.IY(paramString);
    be.T(this.lvz);
    Iterator localIterator = localWxaPkgWrappingInfo.jpd.iterator();
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
    a locala = new a((byte)0);
    locala.lvL = true;
    locala.lvM = true;
    if (this.lvz.isDestroyed())
    {
      ac.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.lvz.mAppId });
      if (paramb != null) {
        paramb.a(a.d.lvo);
      }
      AppMethodBeat.o(169498);
      return;
    }
    com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    if (bs.isNullOrNil(paramString)) {}
    for (paramString = this.lvz.DB().jEg;; paramString = Pa(paramString))
    {
      locali.value = paramString;
      if ((!a(paramString)) || (paramb == null)) {
        break;
      }
      paramb.a(a.d.lvn);
      AppMethodBeat.o(169498);
      return;
    }
    a((ModulePkgInfo)locali.value, locala, paramb, null);
    AppMethodBeat.o(169498);
  }
  
  public final void a(String paramString, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(206164);
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = this.lvz.DB().jEg;
      if (h.a(localObject, paramString, "findModuleInfoByModuleName")) {
        paramString = (String)localObject;
      }
    }
    while (paramString == null)
    {
      paramb.a(a.d.lvq);
      AppMethodBeat.o(206164);
      return;
      String str = WxaPkgWrappingInfo.It(paramString);
      be.T(this.lvz);
      localObject = ((WxaPkgWrappingInfo)localObject).jpd.iterator();
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
      paramb.a(a.d.lvn);
      AppMethodBeat.o(206164);
      return;
    }
    Object localObject = new a((byte)0);
    ((a)localObject).lvL = false;
    ((a)localObject).lvM = false;
    a(paramString, (a)localObject, paramb, parama);
    AppMethodBeat.o(206164);
  }
  
  public final boolean bpc()
  {
    return true;
  }
  
  final boolean bpd()
  {
    AppMethodBeat.i(147356);
    boolean bool = a(this.lvz.DB().jEg);
    AppMethodBeat.o(147356);
    return bool;
  }
  
  static final class a
  {
    boolean lvL = false;
    boolean lvM = true;
    
    public final String toString()
    {
      AppMethodBeat.i(206163);
      String str = "LoadModuleOptions{showPrompt=" + this.lvL + ", injectModuleJS=" + this.lvM + '}';
      AppMethodBeat.o(206163);
      return str;
    }
  }
  
  static final class b
  {
    final a.b lvN;
    final a.a lvO;
    
    public b(a.b paramb, a.a parama)
    {
      this.lvN = paramb;
      this.lvO = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.g
 * JD-Core Version:    0.7.0.1
 */