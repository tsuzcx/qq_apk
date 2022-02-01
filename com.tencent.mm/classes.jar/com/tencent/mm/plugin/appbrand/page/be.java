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
import com.tencent.mm.sdk.platformtools.ac;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "Factory", "luggage-wechat-full-sdk_release"})
public abstract interface be
{
  public static final a lES = a.lET;
  
  public abstract void av(String paramString, boolean paramBoolean);
  
  public abstract void brl();
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory;", "", "()V", "createInjector", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "IMPL", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(183070);
      lET = new a();
      AppMethodBeat.o(183070);
    }
    
    public static be d(a<?> parama)
    {
      AppMethodBeat.i(183069);
      d.g.b.k.h(parama, "renderer");
      Object localObject = (c)parama.CM();
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = ((AppBrandSysConfigLU)((c)localObject).ar(AppBrandSysConfigLU.class)).jEg;
      WxaRuntimeModulePluginListMap localWxaRuntimeModulePluginListMap;
      if (localObject != null)
      {
        localWxaRuntimeModulePluginListMap = ((WxaPkgWrappingInfo)localObject).jpf;
        if (localWxaRuntimeModulePluginListMap == null) {}
      }
      for (int i = localWxaRuntimeModulePluginListMap.jpk.size(); i > 0; i = 0)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).jpf;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        d.g.b.k.g(localObject, "wrappingInfo.separatedPlugins!!");
        parama = (be)new a(parama, (WxaRuntimeModulePluginListMap)localObject);
        AppMethodBeat.o(183069);
        return parama;
      }
      parama = (be)new b();
      AppMethodBeat.o(183069);
      return parama;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$IMPL;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "separatedPluginsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;)V", "TAG", "", "injectedScriptNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pkgReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "getPkgReader", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "pkgReader$delegate", "Lkotlin/Lazy;", "injectPlugins", "", "moduleName", "useLazyCodeLoading", "", "onReloadURL", "evaluateScriptFile", "fileName", "luggage-wechat-full-sdk_release"})
    static final class a
      implements be
    {
      private final String TAG;
      private final f lEU;
      private final HashSet<String> lEV;
      private final a<?> lEW;
      private final WxaRuntimeModulePluginListMap lEX;
      
      static
      {
        AppMethodBeat.i(183063);
        $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "pkgReader", "getPkgReader()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;")) };
        AppMethodBeat.o(183063);
      }
      
      public a(a<?> parama, WxaRuntimeModulePluginListMap paramWxaRuntimeModulePluginListMap)
      {
        AppMethodBeat.i(183067);
        this.lEW = parama;
        this.lEX = paramWxaRuntimeModulePluginListMap;
        this.TAG = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
        this.lEU = g.K((d.g.a.a)new a(this));
        this.lEV = new HashSet();
        AppMethodBeat.o(183067);
      }
      
      private final void a(a<?> parama, String paramString)
      {
        AppMethodBeat.i(183064);
        if (this.lEV.contains(paramString))
        {
          AppMethodBeat.o(183064);
          return;
        }
        ac.i(this.TAG, "inner evaluateScriptFile fileName(" + paramString + ") hash(" + hashCode() + ')');
        parama.dX(paramString, parama.bpJ().OF(paramString));
        this.lEV.add(paramString);
        AppMethodBeat.o(183064);
      }
      
      public final void av(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183065);
        d.g.b.k.h(paramString, "moduleName");
        ac.i(this.TAG, "injectPlugins moduleName(" + paramString + ") useLazyCodeLoading(" + paramBoolean + ") hash(" + hashCode() + ')');
        Object localObject2 = this.lEX.Iw(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = LaunchParcel.IZ(paramString);
          if (!d.g.b.k.g(localObject1, paramString)) {
            break label140;
          }
        }
        for (localObject1 = null; (localObject1 == null) || (((List)localObject1).isEmpty()); localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).Iw((String)localObject1))
        {
          ac.i(this.TAG, "injectPlugins, try with module(" + paramString + "), get empty pluginList");
          AppMethodBeat.o(183065);
          return;
          label140:
          localObject2 = this.lEX;
          d.g.b.k.g(localObject1, "fixedName");
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
          bl.a locala = bl.jpt;
          localObject2 = bl.a.a(paramString, (WxaPluginPkgInfo)localObject2);
          if ((!paramBoolean) || (!((q)this.lEU.getValue()).HU((String)localObject2 + "/common.app.js")))
          {
            a(this.lEW, (String)localObject2 + "/pageframe.js");
          }
          else
          {
            a(this.lEW, (String)localObject2 + "/common.app.js");
            a(this.lEW, (String)localObject2 + "/webview.app.js");
          }
        }
        AppMethodBeat.o(183065);
      }
      
      public final void brl()
      {
        AppMethodBeat.i(183066);
        this.lEV.clear();
        AppMethodBeat.o(183066);
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.a<q>
      {
        a(be.a.a parama)
        {
          super();
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$createInjector$1", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements be
    {
      public final void av(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183068);
        d.g.b.k.h(paramString, "moduleName");
        AppMethodBeat.o(183068);
      }
      
      public final void brl() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.be
 * JD-Core Version:    0.7.0.1
 */