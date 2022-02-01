package com.tencent.mm.plugin.appbrand.page;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appcache.bn.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ae;
import d.f;
import d.g;
import d.g.b.p;
import d.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "Factory", "luggage-wechat-full-sdk_release"})
public abstract interface bd
{
  public static final a miQ = a.miR;
  
  public abstract void ax(String paramString, boolean paramBoolean);
  
  public abstract void bvX();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory;", "", "()V", "createInjector", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "IMPL", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(183070);
      miR = new a();
      AppMethodBeat.o(183070);
    }
    
    public static bd d(a<?> parama)
    {
      AppMethodBeat.i(183069);
      p.h(parama, "renderer");
      Object localObject = (c)parama.Eo();
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((AppBrandSysConfigLU)((c)localObject).ar(AppBrandSysConfigLU.class)).kbw;
      WxaRuntimeModulePluginListMap localWxaRuntimeModulePluginListMap;
      if (localObject != null)
      {
        localWxaRuntimeModulePluginListMap = ((WxaPkgWrappingInfo)localObject).jMa;
        if (localWxaRuntimeModulePluginListMap == null) {}
      }
      for (int i = localWxaRuntimeModulePluginListMap.jMg.size(); i > 0; i = 0)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).jMa;
        if (localObject == null) {
          p.gkB();
        }
        p.g(localObject, "wrappingInfo.separatedPlugins!!");
        parama = (bd)new a(parama, (WxaRuntimeModulePluginListMap)localObject);
        AppMethodBeat.o(183069);
        return parama;
      }
      parama = (bd)new b();
      AppMethodBeat.o(183069);
      return parama;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$IMPL;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "separatedPluginsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;)V", "TAG", "", "injectedScriptNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pkgReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "getPkgReader", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "pkgReader$delegate", "Lkotlin/Lazy;", "injectPlugins", "", "moduleName", "useLazyCodeLoading", "", "onReloadURL", "evaluateScriptFile", "fileName", "luggage-wechat-full-sdk_release"})
    static final class a
      implements bd
    {
      private final String TAG;
      private final f miS;
      private final HashSet<String> miT;
      private final a<?> miU;
      private final WxaRuntimeModulePluginListMap miV;
      
      public a(a<?> parama, WxaRuntimeModulePluginListMap paramWxaRuntimeModulePluginListMap)
      {
        AppMethodBeat.i(183067);
        this.miU = parama;
        this.miV = paramWxaRuntimeModulePluginListMap;
        this.TAG = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
        this.miS = g.O((d.g.a.a)new a(this));
        this.miT = new HashSet();
        AppMethodBeat.o(183067);
      }
      
      private final void a(a<?> parama, String paramString)
      {
        AppMethodBeat.i(183064);
        if (this.miT.contains(paramString))
        {
          AppMethodBeat.o(183064);
          return;
        }
        ae.i(this.TAG, "inner evaluateScriptFile fileName(" + paramString + ") hash(" + hashCode() + ')');
        parama.ek(paramString, parama.buu().SR(paramString));
        this.miT.add(paramString);
        AppMethodBeat.o(183064);
      }
      
      public final void ax(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183065);
        p.h(paramString, "moduleName");
        ae.i(this.TAG, "injectPlugins moduleName(" + paramString + ") useLazyCodeLoading(" + paramBoolean + ") hash(" + hashCode() + ')');
        Object localObject2 = this.miV.Mq(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = LaunchParcel.MW(paramString);
          if (!p.i(localObject1, paramString)) {
            break label140;
          }
        }
        for (localObject1 = null; (localObject1 == null) || (((List)localObject1).isEmpty()); localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).Mq((String)localObject1))
        {
          ae.i(this.TAG, "injectPlugins, try with module(" + paramString + "), get empty pluginList");
          AppMethodBeat.o(183065);
          return;
          label140:
          localObject2 = this.miV;
          p.g(localObject1, "fixedName");
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
          bn.a locala = bn.jMp;
          localObject2 = bn.a.a(paramString, (WxaPluginPkgInfo)localObject2);
          if ((!paramBoolean) || (!((com.tencent.mm.plugin.appbrand.appcache.q)this.miS.getValue()).LN((String)localObject2 + "/common.app.js")))
          {
            a(this.miU, (String)localObject2 + "/pageframe.js");
          }
          else
          {
            a(this.miU, (String)localObject2 + "/common.app.js");
            a(this.miU, (String)localObject2 + "/webview.app.js");
          }
        }
        AppMethodBeat.o(183065);
      }
      
      public final void bvX()
      {
        AppMethodBeat.i(183066);
        this.miT.clear();
        AppMethodBeat.o(183066);
      }
      
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "invoke"})
      static final class a
        extends d.g.b.q
        implements d.g.a.a<com.tencent.mm.plugin.appbrand.appcache.q>
      {
        a(bd.a.a parama)
        {
          super();
        }
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$createInjector$1", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements bd
    {
      public final void ax(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183068);
        p.h(paramString, "moduleName");
        AppMethodBeat.o(183068);
      }
      
      public final void bvX() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bd
 * JD-Core Version:    0.7.0.1
 */