package com.tencent.mm.plugin.appbrand.page;

import android.util.ArrayMap;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bu;
import com.tencent.mm.plugin.appbrand.appcache.bu.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "", "injectPlugins", "", "moduleName", "", "useLazyCodeLoading", "", "onReloadURL", "Factory", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bj
{
  public static final a tzS = a.tzT;
  
  public abstract void ate();
  
  public abstract void l(String paramString, boolean paramBoolean);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory;", "", "()V", "createInjector", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "IMPL", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(183070);
      tzT = new a();
      AppMethodBeat.o(183070);
    }
    
    public static bj d(a<?> parama)
    {
      AppMethodBeat.i(183069);
      kotlin.g.b.s.u(parama, "renderer");
      Object localObject = parama.aqX();
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((AppBrandSysConfigLU)((c)localObject).aN(AppBrandSysConfigLU.class)).qYY;
      int i;
      if (localObject == null) {
        i = 0;
      }
      while (i > 0)
      {
        localObject = ((WxaPkgWrappingInfo)localObject).qHT;
        kotlin.g.b.s.checkNotNull(localObject);
        kotlin.g.b.s.s(localObject, "wrappingInfo.separatedPlugins!!");
        parama = (bj)new a(parama, (WxaRuntimeModulePluginListMap)localObject);
        AppMethodBeat.o(183069);
        return parama;
        WxaRuntimeModulePluginListMap localWxaRuntimeModulePluginListMap = ((WxaPkgWrappingInfo)localObject).qHT;
        if (localWxaRuntimeModulePluginListMap == null) {
          i = 0;
        } else {
          i = localWxaRuntimeModulePluginListMap.qIc.size();
        }
      }
      parama = (bj)new bj.a.b();
      AppMethodBeat.o(183069);
      return parama;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory$IMPL;", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "separatedPluginsMap", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;", "(Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimeModulePluginListMap;)V", "TAG", "", "injectedScriptNames", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pkgReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "getPkgReader", "()Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "pkgReader$delegate", "Lkotlin/Lazy;", "injectPlugins", "", "moduleName", "useLazyCodeLoading", "", "onReloadURL", "evaluateScriptFile", "fileName", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    static final class a
      implements bj
    {
      private final String TAG;
      private final a<?> tzU;
      private final WxaRuntimeModulePluginListMap tzV;
      private final j tzW;
      private final HashSet<String> tzX;
      
      public a(a<?> parama, WxaRuntimeModulePluginListMap paramWxaRuntimeModulePluginListMap)
      {
        AppMethodBeat.i(183067);
        this.tzU = parama;
        this.tzV = paramWxaRuntimeModulePluginListMap;
        this.TAG = "Luggage.FULL.IWxaPageSeparatedPluginsInjectHelper.IMPL";
        this.tzW = k.cm((kotlin.g.a.a)new a(this));
        this.tzX = new HashSet();
        AppMethodBeat.o(183067);
      }
      
      private final void a(a<?> parama, String paramString)
      {
        AppMethodBeat.i(183064);
        if (this.tzX.contains(paramString))
        {
          AppMethodBeat.o(183064);
          return;
        }
        Log.i(this.TAG, "inner evaluateScriptFile fileName(" + paramString + ") hash(" + hashCode() + ')');
        parama.fi(paramString, parama.cDH().aeU(paramString));
        this.tzX.add(paramString);
        AppMethodBeat.o(183064);
      }
      
      public final void ate()
      {
        AppMethodBeat.i(183066);
        this.tzX.clear();
        AppMethodBeat.o(183066);
      }
      
      public final void l(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(183065);
        kotlin.g.b.s.u(paramString, "moduleName");
        Log.i(this.TAG, "injectPlugins moduleName(" + paramString + ") useLazyCodeLoading(" + paramBoolean + ") hash(" + hashCode() + ')');
        Object localObject2 = this.tzV.VE(paramString);
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = LaunchParcel.Wu(paramString);
          if (!kotlin.g.b.s.p(localObject1, paramString)) {
            break label140;
          }
        }
        for (localObject1 = null; (localObject1 == null) || (((List)localObject1).isEmpty()); localObject1 = ((WxaRuntimeModulePluginListMap)localObject2).VE((String)localObject1))
        {
          Log.i(this.TAG, "injectPlugins, try with module(" + paramString + "), get empty pluginList");
          AppMethodBeat.o(183065);
          return;
          label140:
          localObject2 = this.tzV;
          kotlin.g.b.s.s(localObject1, "fixedName");
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WxaPluginPkgInfo)((Iterator)localObject1).next();
          bu.a locala = bu.qIe;
          localObject2 = bu.a.a(paramString, (WxaPluginPkgInfo)localObject2);
          if ((!paramBoolean) || (!((com.tencent.mm.plugin.appbrand.appcache.s)this.tzW.getValue()).Vf(kotlin.g.b.s.X((String)localObject2, "/common.app.js"))))
          {
            a(this.tzU, kotlin.g.b.s.X((String)localObject2, "/pageframe.js"));
          }
          else
          {
            a(this.tzU, kotlin.g.b.s.X((String)localObject2, "/common.app.js"));
            a(this.tzU, kotlin.g.b.s.X((String)localObject2, "/webview.app.js"));
          }
        }
        AppMethodBeat.o(183065);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;"}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.appcache.s>
      {
        a(bj.a.a parama)
        {
          super();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bj
 * JD-Core Version:    0.7.0.1
 */