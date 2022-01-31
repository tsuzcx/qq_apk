package com.tencent.mm.plugin.appbrand.k;

import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.b.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class g
  implements a
{
  private final Set<String> irW;
  final com.tencent.mm.plugin.appbrand.s.i<String, a> irX;
  final com.tencent.luggage.sdk.d.b irY;
  private final Map<String, Boolean> irZ;
  
  public g(com.tencent.luggage.sdk.d.b paramb)
  {
    AppMethodBeat.i(102157);
    this.irW = new HashSet();
    this.irX = new com.tencent.mm.plugin.appbrand.s.i();
    this.irZ = new HashMap();
    this.irY = paramb;
    AppMethodBeat.o(102157);
  }
  
  private void a(ModulePkgInfo arg1, boolean paramBoolean, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(102163);
    String str = ???.name;
    boolean bool1;
    if ((!"__APP__".equals(str)) && (!???.cnm) && (!aIf()))
    {
      bool1 = true;
      if (bool1) {
        a(this.irY.wR().hiX, false, null, null);
      }
      ab.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { ???.name, Boolean.valueOf(???.cnm), Boolean.valueOf(bool1) });
      a(str, paramb, parama);
    }
    for (;;)
    {
      synchronized (this.irW)
      {
        boolean bool2 = this.irW.contains(str);
        if (!bool2) {
          this.irW.add(str);
        }
        if (!bool2)
        {
          ??? = new b();
          if (bool1)
          {
            a("__APP__", new g.1(this, ???), null);
            paramb = new j();
            if (paramBoolean)
            {
              parama = new d().a(new g.2(this, str));
              parama.irS = new android.arch.a.c.a() {};
              parama.C(this.irY);
              paramb.value = parama;
            }
            parama = this.irY.wR().hiX.yK(str);
            parama = e.b.irV.i(this.irY, parama);
            parama.a(new g.4(this, str, bool1, paramb, ???));
            parama.start();
          }
        }
        else
        {
          AppMethodBeat.o(102163);
          return;
          bool1 = false;
        }
      }
      ???.I(null);
    }
  }
  
  private void a(String paramString, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(102164);
    if ((paramb == null) && (parama == null))
    {
      AppMethodBeat.o(102164);
      return;
    }
    this.irX.s(paramString, new a(paramb, parama));
    AppMethodBeat.o(102164);
  }
  
  private boolean a(ModulePkgInfo paramModulePkgInfo)
  {
    AppMethodBeat.i(102159);
    if ((!bo.isNullOrNil(paramModulePkgInfo.gUy)) && (com.tencent.mm.vfs.e.cN(paramModulePkgInfo.gUy))) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramModulePkgInfo.cnm) {
          DJ("__APP__");
        }
        DJ(paramModulePkgInfo.name);
      }
      AppMethodBeat.o(102159);
      return bool;
    }
  }
  
  public final String DI(String paramString)
  {
    AppMethodBeat.i(102165);
    paramString = DK(paramString).name;
    AppMethodBeat.o(102165);
    return paramString;
  }
  
  final void DJ(String paramString)
  {
    AppMethodBeat.i(102160);
    synchronized (this.irZ)
    {
      if (this.irZ.containsKey(paramString))
      {
        AppMethodBeat.o(102160);
        return;
      }
      ((f)this.irY.ws()).bT(paramString);
      this.irZ.put(paramString, Boolean.TRUE);
      ab.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "module (%s) injected", new Object[] { paramString });
      AppMethodBeat.o(102160);
      return;
    }
  }
  
  public final ModulePkgInfo DK(String paramString)
  {
    AppMethodBeat.i(102166);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = this.irY.wR().hiX;
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102166);
      return localWxaPkgWrappingInfo;
    }
    String str = k.zl(paramString);
    Iterator localIterator = localWxaPkgWrappingInfo.gXi.iterator();
    while (localIterator.hasNext())
    {
      ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)localIterator.next();
      if (str.startsWith(localModulePkgInfo.name))
      {
        AppMethodBeat.o(102166);
        return localModulePkgInfo;
      }
      if ((localModulePkgInfo.gUz != null) && (localModulePkgInfo.gUz.length > 0))
      {
        String[] arrayOfString = localModulePkgInfo.gUz;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.startsWith(arrayOfString[i]))
          {
            AppMethodBeat.o(102166);
            return localModulePkgInfo;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(102166);
    return localWxaPkgWrappingInfo;
  }
  
  public final void a(String paramString, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(102162);
    a(paramString, paramBoolean, paramb, null);
    AppMethodBeat.o(102162);
  }
  
  public final void a(String paramString, boolean paramBoolean, a.b paramb, a.a parama)
  {
    AppMethodBeat.i(102161);
    if (this.irY.mFinished)
    {
      ab.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.irY.mAppId });
      paramb.a(a.d.irO);
      AppMethodBeat.o(102161);
      return;
    }
    j localj = new j();
    if (bo.isNullOrNil(paramString)) {}
    for (paramString = this.irY.wR().hiX;; paramString = DK(paramString))
    {
      localj.value = paramString;
      if ((!a(paramString)) || (paramb == null)) {
        break;
      }
      paramb.a(a.d.irN);
      AppMethodBeat.o(102161);
      return;
    }
    a((ModulePkgInfo)localj.value, paramBoolean, paramb, parama);
    AppMethodBeat.o(102161);
  }
  
  public final boolean aIe()
  {
    return true;
  }
  
  final boolean aIf()
  {
    AppMethodBeat.i(102158);
    boolean bool = a(this.irY.wR().hiX);
    AppMethodBeat.o(102158);
    return bool;
  }
  
  static final class a
  {
    final a.b ish;
    final a.a isi;
    
    public a(a.b paramb, a.a parama)
    {
      this.ish = paramb;
      this.isi = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.g
 * JD-Core Version:    0.7.0.1
 */