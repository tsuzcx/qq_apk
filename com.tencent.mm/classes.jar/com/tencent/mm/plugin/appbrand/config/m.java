package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bu;
import com.tencent.mm.plugin.appbrand.appcache.bu.a;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import org.apache.commons.b.c;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandSeparatedPluginAppConfigFileList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "()V", "mAccessPrefixSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "mAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "mPkgFileReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "add", "", "pluginAccessPrefix", "attachAppConfig", "", "config", "reader", "mergeSeparatedPluginConfigImpl", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements com.tencent.mm.plugin.appbrand.jsapi.m
{
  private final HashSet<String> qYN;
  private b qYO;
  private com.tencent.mm.plugin.appbrand.appcache.s qYP;
  
  public m()
  {
    AppMethodBeat.i(323376);
    this.qYN = new HashSet();
    AppMethodBeat.o(323376);
  }
  
  private static void a(b paramb, com.tencent.mm.plugin.appbrand.appcache.s params, String paramString)
  {
    AppMethodBeat.i(323378);
    Object localObject = bu.qIe;
    localObject = bu.a.M(params.Vd(c.rH(paramString, "plugin.json")));
    bu.a locala = bu.qIe;
    paramb.H(paramString, (String)localObject, bu.a.M(params.Vd(c.rH(paramString, "plugin-darkmode.json"))));
    AppMethodBeat.o(323378);
  }
  
  public final boolean Xq(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(323385);
    kotlin.g.b.s.u(paramString, "pluginAccessPrefix");
    synchronized (this.qYN)
    {
      boolean bool = this.qYN.add(paramString);
      b localb = this.qYO;
      if (localb == null)
      {
        AppMethodBeat.o(323385);
        return bool;
      }
      localb = this.qYO;
      if (localb == null)
      {
        kotlin.g.b.s.bIx("mAppConfig");
        localb = null;
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = this.qYP;
        if (localObject2 != null) {
          break;
        }
        kotlin.g.b.s.bIx("mPkgFileReader");
        localObject2 = ah.aiuX;
        a(localb, (com.tencent.mm.plugin.appbrand.appcache.s)localObject1, paramString);
        AppMethodBeat.o(323385);
        return bool;
      }
      localObject1 = localObject2;
    }
  }
  
  public final void a(b paramb, com.tencent.mm.plugin.appbrand.appcache.s params)
  {
    AppMethodBeat.i(323382);
    kotlin.g.b.s.u(paramb, "config");
    kotlin.g.b.s.u(params, "reader");
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.qYN)
    {
      this.qYO = paramb;
      this.qYP = params;
      localLinkedList.addAll((Collection)this.qYN);
      ??? = ((Iterable)localLinkedList).iterator();
      if (((Iterator)???).hasNext()) {
        a(paramb, params, (String)((Iterator)???).next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m
 * JD-Core Version:    0.7.0.1
 */