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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "Factory", "luggage-wechat-full-sdk_release"})
public abstract interface bh
{
  public static final a ntk = a.ntl;
  
  public abstract void ay(String paramString, boolean paramBoolean);
  
  public abstract void bSc();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory;", "", "()V", "createInjector", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "IMPL", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(183070);
      ntl = new a();
      AppMethodBeat.o(183070);
    }
    
    public static bh d(a<?> parama)
    {
      AppMethodBeat.i(183069);
      p.h(parama, "renderer");
      Object localObject = (c)parama.NN();
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((AppBrandSysConfigLU)((c)localObject).av(AppBrandSysConfigLU.class)).leE;
      WxaRuntimeModulePluginListMap localWxaRuntimeModulePluginListMap;
      if (localObject != null)
      {
        localWxaRuntimeModulePluginListMap = ((WxaPkgWrappingInfo)localObject).kOb;
        if (localWxaRuntimeModulePluginListMap == null) {}
      }
      for (int i = localWxaRuntimeModulePluginListMap.kOk.size(); i > 0; i = 0)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).kOb;
        if (localObject == null) {
          p.hyc();
        }
        p.g(localObject, "wrappingInfo.separatedPlugins!!");
        parama = (bh)new a(parama, (WxaRuntimeModulePluginListMap)localObject);
        AppMethodBeat.o(183069);
        return parama;
      }
      parama = (bh)new b();
      AppMethodBeat.o(183069);
      return parama;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$IMPL;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "separatedPluginsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;)V", "TAG", "", "injectedScriptNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pkgReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "getPkgReader", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "pkgReader$delegate", "Lkotlin/Lazy;", "injectPlugins", "", "moduleName", "useLazyCodeLoading", "", "onReloadURL", "evaluateScriptFile", "fileName", "luggage-wechat-full-sdk_release"})
    static final class a
      implements bh
    {
      private final String TAG;
      private final f ntm;
      private final HashSet<String> ntn;
      private final a<?> nto;
      private final WxaRuntimeModulePluginListMap ntp;
      
      public a(a<?> parama, WxaRuntimeModulePluginListMap paramWxaRuntimeModulePluginListMap)
      {
        AppMethodBeat.i(183067);
        this.nto = parama;
        this.ntp = paramWxaRuntimeModulePluginListMap;
        this.TAG = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
        this.ntm = g.ah((kotlin.g.a.a)new a(this));
        this.ntn = new HashSet();
        AppMethodBeat.o(183067);
      }
      
      private final void a(a<?> parama, String paramString)
      {
        AppMethodBeat.i(183064);
        if (this.ntn.contains(paramString))
        {
          AppMethodBeat.o(183064);
          return;
        }
        Log.i(this.TAG, "inner evaluateScriptFile fileName(" + paramString + ") hash(" + hashCode() + ')');
        parama.eD(paramString, parama.bQt().adT(paramString));
        this.ntn.add(paramString);
        AppMethodBeat.o(183064);
      }
      
      public final void ay(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183065);
        p.h(paramString, "moduleName");
        Log.i(this.TAG, "injectPlugins moduleName(" + paramString + ") useLazyCodeLoading(" + paramBoolean + ") hash(" + hashCode() + ')');
        Object localObject2 = this.ntp.Vz(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = LaunchParcel.Wf(paramString);
          if (!p.j(localObject1, paramString)) {
            break label140;
          }
        }
        for (localObject1 = null; (localObject1 == null) || (((List)localObject1).isEmpty()); localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).Vz((String)localObject1))
        {
          Log.i(this.TAG, "injectPlugins, try with module(" + paramString + "), get empty pluginList");
          AppMethodBeat.o(183065);
          return;
          label140:
          localObject2 = this.ntp;
          p.g(localObject1, "fixedName");
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
          bn.a locala = bn.kOt;
          localObject2 = bn.a.a(paramString, (WxaPluginPkgInfo)localObject2);
          if ((!paramBoolean) || (!((com.tencent.mm.plugin.appbrand.appcache.q)this.ntm.getValue()).UW((String)localObject2 + "/common.app.js")))
          {
            a(this.nto, (String)localObject2 + "/pageframe.js");
          }
          else
          {
            a(this.nto, (String)localObject2 + "/common.app.js");
            a(this.nto, (String)localObject2 + "/webview.app.js");
          }
        }
        AppMethodBeat.o(183065);
      }
      
      public final void bSc()
      {
        AppMethodBeat.i(183066);
        this.ntn.clear();
        AppMethodBeat.o(183066);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "invoke"})
      static final class a
        extends kotlin.g.b.q
        implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.q>
      {
        a(bh.a.a parama)
        {
          super();
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$createInjector$1", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "luggage-wechat-full-sdk_release"})
    public static final class b
      implements bh
    {
      public final void ay(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183068);
        p.h(paramString, "moduleName");
        AppMethodBeat.o(183068);
      }
      
      public final void bSc() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bh
 * JD-Core Version:    0.7.0.1
 */