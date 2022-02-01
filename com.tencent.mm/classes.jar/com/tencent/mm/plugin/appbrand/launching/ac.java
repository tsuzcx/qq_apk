package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.ai;
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
import com.tencent.mm.plugin.appbrand.p.g;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ack;
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
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler$ICheckAppHandlerErrorPromptDelegate;", "Lcom/tencent/mm/plugin/appbrand/launching/ILaunchStep;", "appId", "", "versionType", "", "isGame", "", "enterPath", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "cgiCommRequestSource", "Lcom/tencent/mm/protocal/protobuf/CommRequestSource;", "(Ljava/lang/String;IZLjava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;Lcom/tencent/mm/protocal/protobuf/CommRequestSource;)V", "canShowErrorPrompt", "isFromRemoteDebug", "()Z", "setFromRemoteDebug", "(Z)V", "preDownloadCalled", "call", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "callPreDownload", "", "onDownloadProgress", "progress", "postDownload", "preDownload", "setCanShowErrorPrompt", "can", "showDevPkgNoRecordPrompt", "toast", "resId", "error", "fillReadyPkgList", "pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Companion", "plugin-appbrand-integration_release"})
public class ac
  implements v, v.a, y
{
  @Deprecated
  public static final a pVX;
  private final String appId;
  private final int cBU;
  private final boolean csz;
  private final String nBq;
  private final ICommLibReader nYZ;
  private WxaAttributes.WxaVersionInfo oaQ;
  boolean pSU;
  private final ack pTH;
  private boolean pVU;
  private boolean pVV;
  private final QualitySession pVW;
  
  static
  {
    AppMethodBeat.i(180616);
    pVX = new a((byte)0);
    AppMethodBeat.o(180616);
  }
  
  public ac(String paramString1, int paramInt, boolean paramBoolean, String paramString2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, ack paramack)
  {
    AppMethodBeat.i(265222);
    this.appId = paramString1;
    this.cBU = paramInt;
    this.csz = paramBoolean;
    this.nBq = paramString2;
    this.oaQ = paramWxaVersionInfo;
    this.nYZ = paramICommLibReader;
    this.pVW = paramQualitySession;
    this.pTH = paramack;
    this.pVU = true;
    AppMethodBeat.o(265222);
  }
  
  private WxaPkgWrappingInfo bNE()
  {
    Object localObject2 = null;
    AppMethodBeat.i(180613);
    if ((j.a.vB(this.cBU)) && (this.oaQ.appVersion != 0))
    {
      localObject1 = ((s)com.tencent.mm.plugin.appbrand.app.m.W(s.class)).cs(this.appId, this.cBU);
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.plugin.appbrand.config.ac.afy((String)localObject1);
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = (WxaPkgWrappingInfo)((a)new b(this)).invoke();
        AppMethodBeat.o(180613);
        return localObject1;
      }
      this.oaQ = ((WxaAttributes.WxaVersionInfo)localObject1);
    }
    final WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = this.oaQ.appVersion;
    localWxaPkgWrappingInfo.nHY = this.cBU;
    localWxaPkgWrappingInfo.md5 = this.oaQ.oby;
    localWxaPkgWrappingInfo.nId = new WxaRuntimeModulePluginListMap();
    Object localObject1 = aa.pVF;
    localObject1 = this.oaQ;
    Object localObject3 = this.appId;
    Object localObject4 = aa.pVF;
    localObject3 = aa.a((WxaAttributes.WxaVersionInfo)localObject1, (String)localObject3, aa.S(this.appId, this.cBU, this.oaQ.appVersion));
    localObject4 = ((Map)localObject3).entrySet().iterator();
    Object localObject5;
    label333:
    int i;
    if (((Iterator)localObject4).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject4).next();
      localObject5 = (String)n.f((Map.Entry)localObject1);
      Object localObject6 = (WxaAttributes.WxaWidgetInfo)n.g((Map.Entry)localObject1);
      Object localObject7;
      Object localObject8;
      Object localObject9;
      if ((p.h("__APP__", localObject5) ^ true))
      {
        localObject7 = localWxaPkgWrappingInfo.nIb;
        localObject8 = new ModulePkgInfo();
        localObject1 = this.oaQ.moduleList;
        p.j(localObject1, "versionInfo.moduleList");
        localObject9 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject9).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject9).next();
        } while (!p.h(localObject5, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name));
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)localObject1;
        ((ModulePkgInfo)localObject8).name = ((String)localObject5);
        ((ModulePkgInfo)localObject8).md5 = ((WxaAttributes.WxaWidgetInfo)localObject6).obR;
        ((ModulePkgInfo)localObject8).independent = ((WxaAttributes.WxaVersionModuleInfo)localObject1).independent;
        ((ModulePkgInfo)localObject8).aliases = ((WxaAttributes.WxaVersionModuleInfo)localObject1).aliases;
        ((ModulePkgInfo)localObject8).pkgVersion = this.oaQ.appVersion;
        ((LinkedList)localObject7).add(localObject8);
      }
      localObject1 = (Collection)((WxaAttributes.WxaWidgetInfo)localObject6).obS;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
      {
        i = 1;
        label424:
        if (i != 0) {
          break label534;
        }
        localObject7 = localWxaPkgWrappingInfo.nId;
        if (localObject7 == null) {
          p.iCn();
        }
        localObject1 = ((WxaAttributes.WxaWidgetInfo)localObject6).obS;
        localObject6 = (Collection)localObject1;
        if ((localObject6 != null) && (!((Collection)localObject6).isEmpty())) {
          break label536;
        }
        i = 1;
        label472:
        if (i == 0) {
          break label541;
        }
      }
      for (localObject1 = null;; localObject1 = (List)localObject1)
      {
        p.k(localObject5, "moduleName");
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break;
        }
        ((Map)((WxaRuntimeModulePluginListMap)localObject7).nIl).put(new WxaRuntimeModulePluginListMap.c.a((String)localObject5), localObject1);
        break;
        localObject1 = null;
        break label333;
        i = 0;
        break label424;
        label534:
        break;
        label536:
        i = 0;
        break label472;
        label541:
        localObject6 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
        localObject6 = ((Iterable)localObject6).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject8 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject6).next();
          p.k(localObject8, "$this$toPkgInfo");
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
    localObject1 = localWxaPkgWrappingInfo.nId;
    if (localObject1 != null) {
      ((WxaRuntimeModulePluginListMap)localObject1).bHI();
    }
    if ((this.csz) && (ai.acd(this.nBq)))
    {
      AppMethodBeat.o(180613);
      return localWxaPkgWrappingInfo;
    }
    if ((this.oaQ.obD) && (!Util.isNullOrNil(this.oaQ.moduleList)))
    {
      localObject4 = new LinkedList();
      localObject1 = com.tencent.luggage.k.l.eo(LaunchParcel.adT(this.nBq));
      localObject5 = (CharSequence)localObject1;
      if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = (CharSequence)this.oaQ.obE;
        if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
        {
          i = 1;
          label818:
          if (i == 0) {
            break label986;
          }
          localObject1 = localObject2;
          label824:
          if (localObject1 != null) {
            ((LinkedList)localObject4).add(((WxaAttributes.WxaVersionModuleInfo)localObject1).name);
          }
          if ((localObject1 == null) || ((!((WxaAttributes.WxaVersionModuleInfo)localObject1).independent) && ((p.h("__APP__", ((WxaAttributes.WxaVersionModuleInfo)localObject1).name) ^ true)))) {
            ((LinkedList)localObject4).add("__APP__");
          }
          localObject1 = (List)localObject4;
          localObject4 = new CountDownLatch(1);
          localObject2 = new AtomicReference();
          d.b("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible[" + this.appId + '|' + this.cBU + ']', (a)new c(this, (List)localObject1, (Map)localObject3, localWxaPkgWrappingInfo, (AtomicReference)localObject2, (CountDownLatch)localObject4));
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
        break label818;
        label986:
        localObject5 = this.oaQ.moduleList.iterator();
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject1 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject5).next();
        } while (!p.h(this.oaQ.obE, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name));
        break label824;
        localObject2 = this.oaQ.moduleList;
        p.j(localObject2, "versionInfo.moduleList");
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)g.a((List)localObject2, (String)localObject1, "LaunchCheckPkgHandlerSeparatedPluginsCompatible  appId:" + this.appId + " versionType:" + this.cBU, 4);
        break label824;
        localObject1 = (List)j.ag(new String[] { "__APP__" });
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "await semaphore failed with appId(" + this.appId + ") versionType(" + this.cBU + ')');
        }
      }
    }
  }
  
  public final void ajY(String paramString)
  {
    AppMethodBeat.i(180612);
    if (this.pVU)
    {
      av.a(paramString, (y)this);
      AppMethodBeat.o(180612);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.LaunchCheckPkgHandlerSeparatedPluginsCompatible", "silent toast:error=" + paramString + ", stack=" + android.util.Log.getStackTraceString(new Throwable()));
    AppMethodBeat.o(180612);
  }
  
  public final boolean bZy()
  {
    return this.pVU;
  }
  
  public void bZz() {}
  
  public final void iR(boolean paramBoolean)
  {
    this.pVU = paramBoolean;
  }
  
  public void onDownloadProgress(int paramInt) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a
  {
    b(ac paramac)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(ac paramac, List paramList, Map paramMap, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, AtomicReference paramAtomicReference, CountDownLatch paramCountDownLatch)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ac
 * JD-Core Version:    0.7.0.1
 */