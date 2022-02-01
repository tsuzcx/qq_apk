package com.tencent.mm.plugin.appbrand.page;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.bl.a;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "Factory", "luggage-wechat-full-sdk_release"})
public abstract interface bj
{
  public static final a lfc = a.lfd;
  
  public abstract void au(String paramString, boolean paramBoolean);
  
  public abstract void bkw();
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory;", "", "()V", "createInjector", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "IMPL", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(183070);
      lfd = new a();
      AppMethodBeat.o(183070);
    }
    
    public static bj d(a<?> parama)
    {
      AppMethodBeat.i(183069);
      d.g.b.k.h(parama, "renderer");
      Object localObject = (c)parama.Dj();
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = ((AppBrandSysConfigLU)((c)localObject).ar(AppBrandSysConfigLU.class)).jdS;
      WxaRuntimeModulePluginListMap localWxaRuntimeModulePluginListMap;
      if (localObject != null)
      {
        localWxaRuntimeModulePluginListMap = ((WxaPkgWrappingInfo)localObject).iOV;
        if (localWxaRuntimeModulePluginListMap == null) {}
      }
      for (int i = localWxaRuntimeModulePluginListMap.iPa.size(); i > 0; i = 0)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).iOV;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        d.g.b.k.g(localObject, "wrappingInfo.separatedPlugins!!");
        parama = (bj)new a(parama, (WxaRuntimeModulePluginListMap)localObject);
        AppMethodBeat.o(183069);
        return parama;
      }
      parama = (bj)new b();
      AppMethodBeat.o(183069);
      return parama;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$IMPL;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "separatedPluginsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;)V", "TAG", "", "injectedScriptNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pkgReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "getPkgReader", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "pkgReader$delegate", "Lkotlin/Lazy;", "injectPlugins", "", "moduleName", "useLazyCodeLoading", "", "onReloadURL", "evaluateScriptFile", "fileName", "luggage-wechat-full-sdk_release"})
    static final class a
      implements bj
    {
      private final String TAG;
      private final f lfe;
      private final HashSet<String> lff;
      private final a<?> lfg;
      private final WxaRuntimeModulePluginListMap lfh;
      
      static
      {
        AppMethodBeat.i(183063);
        $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "pkgReader", "getPkgReader()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;")) };
        AppMethodBeat.o(183063);
      }
      
      public a(a<?> parama, WxaRuntimeModulePluginListMap paramWxaRuntimeModulePluginListMap)
      {
        AppMethodBeat.i(183067);
        this.lfg = parama;
        this.lfh = paramWxaRuntimeModulePluginListMap;
        this.TAG = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
        this.lfe = g.E((d.g.a.a)new a(this));
        this.lff = new HashSet();
        AppMethodBeat.o(183067);
      }
      
      private final void a(a<?> parama, String paramString)
      {
        AppMethodBeat.i(183064);
        if (this.lff.contains(paramString))
        {
          AppMethodBeat.o(183064);
          return;
        }
        ad.i(this.TAG, "inner evaluateScriptFile fileName(" + paramString + ") hash(" + hashCode() + ')');
        parama.dL(paramString, parama.biQ().Ky(paramString));
        this.lff.add(paramString);
        AppMethodBeat.o(183064);
      }
      
      public final void au(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183065);
        d.g.b.k.h(paramString, "moduleName");
        ad.i(this.TAG, "injectPlugins moduleName(" + paramString + ") useLazyCodeLoading(" + paramBoolean + ") hash(" + hashCode() + ')');
        Object localObject2 = this.lfh.Et(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = LaunchParcel.EW(paramString);
          if (!d.g.b.k.g(localObject1, paramString)) {
            break label140;
          }
        }
        for (localObject1 = null; (localObject1 == null) || (((List)localObject1).isEmpty()); localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).Et((String)localObject1))
        {
          ad.i(this.TAG, "injectPlugins, try with module(" + paramString + "), get empty pluginList");
          AppMethodBeat.o(183065);
          return;
          label140:
          localObject2 = this.lfh;
          d.g.b.k.g(localObject1, "fixedName");
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
          bl.a locala = bl.iPj;
          localObject2 = bl.a.a(paramString, (WxaPluginPkgInfo)localObject2);
          if ((!paramBoolean) || (!((q)this.lfe.getValue()).DR((String)localObject2 + "/common.app.js")))
          {
            a(this.lfg, (String)localObject2 + "/pageframe.js");
          }
          else
          {
            a(this.lfg, (String)localObject2 + "/common.app.js");
            a(this.lfg, (String)localObject2 + "/webview.app.js");
          }
        }
        AppMethodBeat.o(183065);
      }
      
      public final void bkw()
      {
        AppMethodBeat.i(183066);
        this.lff.clear();
        AppMethodBeat.o(183066);
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<q>
      {
        a(bj.a.a parama)
        {
          super();
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$createInjector$1", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements bj
    {
      public final void au(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183068);
        d.g.b.k.h(paramString, "moduleName");
        AppMethodBeat.o(183068);
      }
      
      public final void bkw() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bj
 * JD-Core Version:    0.7.0.1
 */