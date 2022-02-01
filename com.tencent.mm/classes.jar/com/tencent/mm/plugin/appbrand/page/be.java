package com.tencent.mm.plugin.appbrand.page;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bm.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ad;
import d.f;
import d.g;
import d.g.b.p;
import d.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "Factory", "luggage-wechat-full-sdk_release"})
public abstract interface be
{
  public static final a mew = a.mex;
  
  public abstract void ax(String paramString, boolean paramBoolean);
  
  public abstract void bvm();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory;", "", "()V", "createInjector", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "IMPL", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(183070);
      mex = new a();
      AppMethodBeat.o(183070);
    }
    
    public static be d(a<?> parama)
    {
      AppMethodBeat.i(183069);
      p.h(parama, "renderer");
      Object localObject = (c)parama.El();
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((AppBrandSysConfigLU)((c)localObject).ar(AppBrandSysConfigLU.class)).jYh;
      WxaRuntimeModulePluginListMap localWxaRuntimeModulePluginListMap;
      if (localObject != null)
      {
        localWxaRuntimeModulePluginListMap = ((WxaPkgWrappingInfo)localObject).jIZ;
        if (localWxaRuntimeModulePluginListMap == null) {}
      }
      for (int i = localWxaRuntimeModulePluginListMap.jJf.size(); i > 0; i = 0)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).jIZ;
        if (localObject == null) {
          p.gfZ();
        }
        p.g(localObject, "wrappingInfo.separatedPlugins!!");
        parama = (be)new a(parama, (WxaRuntimeModulePluginListMap)localObject);
        AppMethodBeat.o(183069);
        return parama;
      }
      parama = (be)new b();
      AppMethodBeat.o(183069);
      return parama;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$IMPL;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "separatedPluginsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;)V", "TAG", "", "injectedScriptNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pkgReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "getPkgReader", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "pkgReader$delegate", "Lkotlin/Lazy;", "injectPlugins", "", "moduleName", "useLazyCodeLoading", "", "onReloadURL", "evaluateScriptFile", "fileName", "luggage-wechat-full-sdk_release"})
    static final class a
      implements be
    {
      private final String TAG;
      private final a<?> meA;
      private final WxaRuntimeModulePluginListMap meB;
      private final f mey;
      private final HashSet<String> mez;
      
      public a(a<?> parama, WxaRuntimeModulePluginListMap paramWxaRuntimeModulePluginListMap)
      {
        AppMethodBeat.i(183067);
        this.meA = parama;
        this.meB = paramWxaRuntimeModulePluginListMap;
        this.TAG = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
        this.mey = g.O((d.g.a.a)new a(this));
        this.mez = new HashSet();
        AppMethodBeat.o(183067);
      }
      
      private final void a(a<?> parama, String paramString)
      {
        AppMethodBeat.i(183064);
        if (this.mez.contains(paramString))
        {
          AppMethodBeat.o(183064);
          return;
        }
        ad.i(this.TAG, "inner evaluateScriptFile fileName(" + paramString + ") hash(" + hashCode() + ')');
        parama.eh(paramString, parama.btJ().Si(paramString));
        this.mez.add(paramString);
        AppMethodBeat.o(183064);
      }
      
      public final void ax(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183065);
        p.h(paramString, "moduleName");
        ad.i(this.TAG, "injectPlugins moduleName(" + paramString + ") useLazyCodeLoading(" + paramBoolean + ") hash(" + hashCode() + ')');
        Object localObject2 = this.meB.LN(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = LaunchParcel.Mq(paramString);
          if (!p.i(localObject1, paramString)) {
            break label140;
          }
        }
        for (localObject1 = null; (localObject1 == null) || (((List)localObject1).isEmpty()); localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).LN((String)localObject1))
        {
          ad.i(this.TAG, "injectPlugins, try with module(" + paramString + "), get empty pluginList");
          AppMethodBeat.o(183065);
          return;
          label140:
          localObject2 = this.meB;
          p.g(localObject1, "fixedName");
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
          bm.a locala = bm.jJo;
          localObject2 = bm.a.a(paramString, (WxaPluginPkgInfo)localObject2);
          if ((!paramBoolean) || (!((com.tencent.mm.plugin.appbrand.appcache.q)this.mey.getValue()).Lm((String)localObject2 + "/common.app.js")))
          {
            a(this.meA, (String)localObject2 + "/pageframe.js");
          }
          else
          {
            a(this.meA, (String)localObject2 + "/common.app.js");
            a(this.meA, (String)localObject2 + "/webview.app.js");
          }
        }
        AppMethodBeat.o(183065);
      }
      
      public final void bvm()
      {
        AppMethodBeat.i(183066);
        this.mez.clear();
        AppMethodBeat.o(183066);
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "invoke"})
      static final class a
        extends d.g.b.q
        implements d.g.a.a<com.tencent.mm.plugin.appbrand.appcache.q>
      {
        a(be.a.a parama)
        {
          super();
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$createInjector$1", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements be
    {
      public final void ax(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183068);
        p.h(paramString, "moduleName");
        AppMethodBeat.o(183068);
      }
      
      public final void bvm() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.be
 * JD-Core Version:    0.7.0.1
 */