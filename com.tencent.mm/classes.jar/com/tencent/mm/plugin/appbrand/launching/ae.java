package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.app.n;
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
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.Util;
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
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler$ICheckAppHandlerErrorPromptDelegate;", "Lcom/tencent/mm/plugin/appbrand/launching/ILaunchStep;", "appId", "", "versionType", "", "isGame", "", "enterPath", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "(Ljava/lang/String;IZLjava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;Lcom/tencent/mm/protocal/protobuf/CommRequestSource;)V", "canShowErrorPrompt", "isFromRemoteDebug", "()Z", "setFromRemoteDebug", "(Z)V", "preDownloadCalled", "call", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "callPreDownload", "", "onDownloadProgress", "progress", "postDownload", "preDownload", "setCanShowErrorPrompt", "can", "showDevPkgNoRecordPrompt", "toast", "resId", "error", "fillReadyPkgList", "pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Companion", "plugin-appbrand-integration_release"})
public class ae
  implements aa, w, w.a
{
  @Deprecated
  public static final a mUZ;
  private final String appId;
  private final boolean cuy;
  private final int iOo;
  private final String kHw;
  private final ICommLibReader leM;
  private WxaAttributes.WxaVersionInfo lgq;
  private final acc mSK;
  boolean mSa;
  private boolean mUW;
  private boolean mUX;
  private final QualitySession mUY;
  
  static
  {
    AppMethodBeat.i(180616);
    mUZ = new a((byte)0);
    AppMethodBeat.o(180616);
  }
  
  public ae(String paramString1, int paramInt, boolean paramBoolean, String paramString2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, acc paramacc)
  {
    AppMethodBeat.i(228691);
    this.appId = paramString1;
    this.iOo = paramInt;
    this.cuy = paramBoolean;
    this.kHw = paramString2;
    this.lgq = paramWxaVersionInfo;
    this.leM = paramICommLibReader;
    this.mUY = paramQualitySession;
    this.mSK = paramacc;
    this.mUW = true;
    AppMethodBeat.o(228691);
  }
  
  private WxaPkgWrappingInfo bCi()
  {
    Object localObject2 = null;
    AppMethodBeat.i(180613);
    if ((j.a.sE(this.iOo)) && (this.lgq.appVersion != 0))
    {
      localObject1 = ((t)n.W(t.class)).bU(this.appId, this.iOo);
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.plugin.appbrand.config.ac.XM((String)localObject1);
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = (WxaPkgWrappingInfo)((a)new b(this)).invoke();
        AppMethodBeat.o(180613);
        return localObject1;
      }
      this.lgq = ((WxaAttributes.WxaVersionInfo)localObject1);
    }
    final WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = this.lgq.appVersion;
    localWxaPkgWrappingInfo.kNW = this.iOo;
    localWxaPkgWrappingInfo.md5 = this.lgq.lgS;
    localWxaPkgWrappingInfo.kOb = new WxaRuntimeModulePluginListMap();
    Object localObject1 = ac.mUH;
    localObject1 = this.lgq;
    Object localObject3 = this.appId;
    Object localObject4 = ac.mUH;
    localObject3 = ac.a((WxaAttributes.WxaVersionInfo)localObject1, (String)localObject3, ac.a(this.appId, this.iOo, this.lgq.appVersion, this.cuy, this.leM));
    localObject4 = ((Map)localObject3).entrySet().iterator();
    Object localObject5;
    label341:
    int i;
    if (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject4).next();
      localObject5 = (String)o.e((Map.Entry)localObject1);
      Object localObject6 = (WxaAttributes.WxaWidgetInfo)o.f((Map.Entry)localObject1);
      Object localObject7;
      Object localObject8;
      Object localObject9;
      if ((p.j("__APP__", localObject5) ^ true))
      {
        localObject7 = localWxaPkgWrappingInfo.kNZ;
        localObject8 = new ModulePkgInfo();
        localObject1 = this.lgq.moduleList;
        p.g(localObject1, "versionInfo.moduleList");
        localObject9 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject9).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject9).next();
        } while (!p.j(localObject5, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name));
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)localObject1;
        ((ModulePkgInfo)localObject8).name = ((String)localObject5);
        ((ModulePkgInfo)localObject8).md5 = ((WxaAttributes.WxaWidgetInfo)localObject6).lhj;
        ((ModulePkgInfo)localObject8).independent = ((WxaAttributes.WxaVersionModuleInfo)localObject1).independent;
        ((ModulePkgInfo)localObject8).aliases = ((WxaAttributes.WxaVersionModuleInfo)localObject1).aliases;
        ((ModulePkgInfo)localObject8).pkgVersion = this.lgq.appVersion;
        ((LinkedList)localObject7).add(localObject8);
      }
      localObject1 = (Collection)((WxaAttributes.WxaWidgetInfo)localObject6).lhk;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
      {
        i = 1;
        label432:
        if (i != 0) {
          break label542;
        }
        localObject7 = localWxaPkgWrappingInfo.kOb;
        if (localObject7 == null) {
          p.hyc();
        }
        localObject1 = ((WxaAttributes.WxaWidgetInfo)localObject6).lhk;
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
        p.h(localObject5, "moduleName");
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break;
        }
        ((Map)((WxaRuntimeModulePluginListMap)localObject7).kOk).put(new WxaRuntimeModulePluginListMap.c.a((String)localObject5), localObject1);
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
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject8 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject6).next();
          p.h(localObject8, "$this$toPkgInfo");
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
    localObject1 = localWxaPkgWrappingInfo.kOb;
    if (localObject1 != null) {
      ((WxaRuntimeModulePluginListMap)localObject1).bwB();
    }
    if ((this.cuy) && (af.Ut(this.kHw)))
    {
      AppMethodBeat.o(180613);
      return localWxaPkgWrappingInfo;
    }
    if ((this.lgq.lgX) && (!Util.isNullOrNil(this.lgq.moduleList)))
    {
      localObject4 = new LinkedList();
      localObject1 = com.tencent.luggage.h.l.dM(LaunchParcel.Wf(this.kHw));
      localObject5 = (CharSequence)localObject1;
      if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = (CharSequence)this.lgq.lgY;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          i = 1;
          label826:
          if (i == 0) {
            break label994;
          }
          localObject1 = localObject2;
          label832:
          if (localObject1 != null) {
            ((LinkedList)localObject4).add(((WxaAttributes.WxaVersionModuleInfo)localObject1).name);
          }
          if ((localObject1 == null) || ((!((WxaAttributes.WxaVersionModuleInfo)localObject1).independent) && ((p.j("__APP__", ((WxaAttributes.WxaVersionModuleInfo)localObject1).name) ^ true)))) {
            ((LinkedList)localObject4).add("__APP__");
          }
          localObject1 = (List)localObject4;
          localObject4 = new CountDownLatch(1);
          localObject2 = new AtomicReference();
          d.b("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible[" + this.appId + '|' + this.iOo + ']', (a)new c(this, (List)localObject1, (Map)localObject3, localWxaPkgWrappingInfo, (AtomicReference)localObject2, (CountDownLatch)localObject4));
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
        break label826;
        label994:
        localObject5 = this.lgq.moduleList.iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject1 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject5).next();
        } while (!p.j(this.lgq.lgY, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name));
        break label832;
        localObject2 = this.lgq.moduleList;
        p.g(localObject2, "versionInfo.moduleList");
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)h.d((List)localObject2, (String)localObject1, "LaunchCheckPkgHandlerSeparatedPluginsCompatible  appId:" + this.appId + " versionType:" + this.iOo);
        break label832;
        localObject1 = (List)j.ac(new String[] { "__APP__" });
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "await semaphore failed with appId(" + this.appId + ") versionType(" + this.iOo + ')');
        }
      }
    }
  }
  
  public final void acb(String paramString)
  {
    AppMethodBeat.i(180612);
    if (this.mUW)
    {
      ax.a(paramString, (aa)this);
      AppMethodBeat.o(180612);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "silent toast:error=" + paramString + ", stack=" + android.util.Log.getStackTraceString(new Throwable()));
    AppMethodBeat.o(180612);
  }
  
  public final boolean bNh()
  {
    return this.mUW;
  }
  
  public void bNi() {}
  
  public final void hX(boolean paramBoolean)
  {
    this.mUW = paramBoolean;
  }
  
  public void onDownloadProgress(int paramInt) {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a
  {
    b(ae paramae)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(ae paramae, List paramList, Map paramMap, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, AtomicReference paramAtomicReference, CountDownLatch paramCountDownLatch)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ae
 * JD-Core Version:    0.7.0.1
 */