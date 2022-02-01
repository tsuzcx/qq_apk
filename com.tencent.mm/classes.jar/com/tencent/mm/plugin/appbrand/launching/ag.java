package com.tencent.mm.plugin.appbrand.launching;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap.c.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler$ICheckAppHandlerErrorPromptDelegate;", "appId", "", "versionType", "", "isGame", "", "enterPath", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "(Ljava/lang/String;IZLjava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;)V", "canShowErrorPrompt", "isFromRemoteDebug", "()Z", "setFromRemoteDebug", "(Z)V", "preDownloadCalled", "call", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "callPreDownload", "", "onDownloadProgress", "progress", "postDownload", "preDownload", "setCanShowErrorPrompt", "can", "showDevPkgNoRecordPrompt", "toast", "resId", "error", "fillReadyPkgList", "pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Companion", "plugin-appbrand-integration_release"})
public class ag
  implements x, x.b
{
  @Deprecated
  public static final a llV;
  private final String appId;
  private final boolean bYk;
  private final int hxM;
  private final ICommLibReader jEn;
  private WxaAttributes.WxaVersionInfo jFp;
  private final String jjf;
  boolean liH;
  private boolean llS;
  private boolean llT;
  private final QualitySession llU;
  
  static
  {
    AppMethodBeat.i(180616);
    llV = new a((byte)0);
    AppMethodBeat.o(180616);
  }
  
  public ag(String paramString1, int paramInt, boolean paramBoolean, String paramString2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, ICommLibReader paramICommLibReader, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(180615);
    this.appId = paramString1;
    this.hxM = paramInt;
    this.bYk = paramBoolean;
    this.jjf = paramString2;
    this.jFp = paramWxaVersionInfo;
    this.jEn = paramICommLibReader;
    this.llU = paramQualitySession;
    this.llS = true;
    AppMethodBeat.o(180615);
  }
  
  private WxaPkgWrappingInfo bcD()
  {
    Object localObject2 = null;
    AppMethodBeat.i(180613);
    if ((j.a.on(this.hxM)) && (this.jFp.aBM != 0))
    {
      localObject1 = ((t)com.tencent.mm.plugin.appbrand.app.j.T(t.class)).bK(this.appId, this.hxM);
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.plugin.appbrand.config.y.KB((String)localObject1);
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = (WxaPkgWrappingInfo)((a)new b(this)).invoke();
        AppMethodBeat.o(180613);
        return localObject1;
      }
      this.jFp = ((WxaAttributes.WxaVersionInfo)localObject1);
    }
    final WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = this.jFp.aBM;
    localWxaPkgWrappingInfo.jpa = this.hxM;
    localWxaPkgWrappingInfo.md5 = this.jFp.jFN;
    localWxaPkgWrappingInfo.jpf = new WxaRuntimeModulePluginListMap();
    Object localObject1 = ae.llD;
    localObject1 = this.jFp;
    Object localObject3 = this.appId;
    Object localObject4 = ae.llD;
    localObject3 = ae.a((WxaAttributes.WxaVersionInfo)localObject1, (String)localObject3, ae.a(this.appId, this.hxM, this.jFp.aBM, this.bYk, this.jEn));
    localObject4 = ((Map)localObject3).entrySet().iterator();
    Object localObject5;
    label341:
    int i;
    if (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject4).next();
      localObject5 = (String)o.c((Map.Entry)localObject1);
      Object localObject6 = (WxaAttributes.WxaWidgetInfo)o.d((Map.Entry)localObject1);
      Object localObject7;
      Object localObject8;
      Object localObject9;
      if ((d.g.b.k.g("__APP__", localObject5) ^ true))
      {
        localObject7 = localWxaPkgWrappingInfo.jpd;
        localObject8 = new ModulePkgInfo();
        localObject1 = this.jFp.moduleList;
        d.g.b.k.g(localObject1, "versionInfo.moduleList");
        localObject9 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject9).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject9).next();
        } while (!d.g.b.k.g(localObject5, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name));
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)localObject1;
        ((ModulePkgInfo)localObject8).name = ((String)localObject5);
        ((ModulePkgInfo)localObject8).md5 = ((WxaAttributes.WxaWidgetInfo)localObject6).jGe;
        ((ModulePkgInfo)localObject8).independent = ((WxaAttributes.WxaVersionModuleInfo)localObject1).independent;
        ((ModulePkgInfo)localObject8).aliases = ((WxaAttributes.WxaVersionModuleInfo)localObject1).aliases;
        ((ModulePkgInfo)localObject8).pkgVersion = this.jFp.aBM;
        ((LinkedList)localObject7).add(localObject8);
      }
      localObject1 = (Collection)((WxaAttributes.WxaWidgetInfo)localObject6).jGf;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
      {
        i = 1;
        label432:
        if (i != 0) {
          break label542;
        }
        localObject7 = localWxaPkgWrappingInfo.jpf;
        if (localObject7 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = ((WxaAttributes.WxaWidgetInfo)localObject6).jGf;
        localObject6 = (Collection)localObject1;
        if ((localObject6 != null) && (!((Collection)localObject6).isEmpty())) {
          break label544;
        }
        i = 1;
        label480:
        if (i == 0) {
          break label549;
        }
      }
      for (localObject1 = null;; localObject1 = (List)localObject1)
      {
        d.g.b.k.h(localObject5, "moduleName");
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break;
        }
        ((Map)((WxaRuntimeModulePluginListMap)localObject7).jpk).put(new WxaRuntimeModulePluginListMap.c.a((String)localObject5), localObject1);
        break;
        localObject1 = null;
        break label341;
        i = 0;
        break label432;
        label542:
        break;
        label544:
        i = 0;
        break label480;
        label549:
        localObject6 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject8 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject6).next();
          d.g.b.k.h(localObject8, "$this$toPkgInfo");
          localObject9 = new WxaPluginPkgInfo();
          ((WxaPluginPkgInfo)localObject9).provider = ((WxaAttributes.WxaPluginCodeInfo)localObject8).provider;
          ((WxaPluginPkgInfo)localObject9).version = ((WxaAttributes.WxaPluginCodeInfo)localObject8).version;
          ((WxaPluginPkgInfo)localObject9).md5 = ((WxaAttributes.WxaPluginCodeInfo)localObject8).md5;
          ((WxaPluginPkgInfo)localObject9).prefixPath = ((WxaAttributes.WxaPluginCodeInfo)localObject8).prefixPath;
          ((WxaPluginPkgInfo)localObject9).contexts = ((WxaAttributes.WxaPluginCodeInfo)localObject8).contexts;
          ((Collection)localObject1).add(localObject9);
        }
      }
    }
    localObject1 = localWxaPkgWrappingInfo.jpf;
    if (localObject1 != null) {
      ((WxaRuntimeModulePluginListMap)localObject1).aXr();
    }
    if ((this.jFp.jFS) && (!bs.gY(this.jFp.moduleList)))
    {
      localObject4 = new LinkedList();
      localObject1 = com.tencent.luggage.h.k.cp(LaunchParcel.IZ(this.jjf));
      localObject5 = (CharSequence)localObject1;
      if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = (CharSequence)this.jFp.jFT;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          i = 1;
          label801:
          if (i == 0) {
            break label969;
          }
          localObject1 = localObject2;
          label807:
          if (localObject1 != null) {
            ((LinkedList)localObject4).add(((WxaAttributes.WxaVersionModuleInfo)localObject1).name);
          }
          if ((localObject1 == null) || ((!((WxaAttributes.WxaVersionModuleInfo)localObject1).independent) && ((d.g.b.k.g("__APP__", ((WxaAttributes.WxaVersionModuleInfo)localObject1).name) ^ true)))) {
            ((LinkedList)localObject4).add("__APP__");
          }
          localObject1 = (List)localObject4;
          localObject4 = new CountDownLatch(1);
          localObject2 = new AtomicReference();
          c.b("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible[" + this.appId + '|' + this.hxM + ']', (a)new c(this, (List)localObject1, (Map)localObject3, localWxaPkgWrappingInfo, (AtomicReference)localObject2, (CountDownLatch)localObject4));
        }
      }
      try
      {
        ((CountDownLatch)localObject4).await();
        localObject1 = (WxaPkgWrappingInfo)((AtomicReference)localObject2).get();
        AppMethodBeat.o(180613);
        return localObject1;
        i = 0;
        continue;
        i = 0;
        break label801;
        label969:
        localObject5 = this.jFp.moduleList.iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject1 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject5).next();
        } while (!d.g.b.k.g(this.jFp.jFT, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name));
        break label807;
        localObject2 = this.jFp.moduleList;
        d.g.b.k.g(localObject2, "versionInfo.moduleList");
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)h.c((List)localObject2, (String)localObject1, "LaunchCheckPkgHandlerSeparatedPluginsCompatible  appId:" + this.appId + " versionType:" + this.hxM);
        break label807;
        localObject1 = (List)d.a.j.ab(new String[] { "__APP__" });
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ac.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "await semaphore failed with appId(" + this.appId + ") versionType(" + this.hxM + ')');
        }
      }
    }
  }
  
  public final void Oq(String paramString)
  {
    AppMethodBeat.i(180612);
    if (this.llS)
    {
      bc.Oq(paramString);
      AppMethodBeat.o(180612);
      return;
    }
    ac.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "silent toast:error=" + paramString + ", stack=" + Log.getStackTraceString(new Throwable()));
    AppMethodBeat.o(180612);
  }
  
  public void bnc() {}
  
  public final void gS(boolean paramBoolean)
  {
    this.llS = paramBoolean;
  }
  
  public void onDownloadProgress(int paramInt) {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a
  {
    b(ag paramag)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<d.y>
  {
    c(ag paramag, List paramList, Map paramMap, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, AtomicReference paramAtomicReference, CountDownLatch paramCountDownLatch)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ag
 * JD-Core Version:    0.7.0.1
 */