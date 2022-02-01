package com.tencent.mm.plugin.appbrand.launching;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
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
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.n.n;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler;", "Lcom/tencent/mm/plugin/appbrand/launching/ICheckAppHandler$ICheckAppHandlerErrorPromptDelegate;", "appId", "", "versionType", "", "isGame", "", "enterPath", "versionInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;", "acceptedLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "reportQualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "(Ljava/lang/String;IZLjava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;)V", "canShowErrorPrompt", "isFromRemoteDebug", "()Z", "setFromRemoteDebug", "(Z)V", "preDownloadCalled", "call", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "callPreDownload", "", "onDownloadProgress", "progress", "postDownload", "preDownload", "setCanShowErrorPrompt", "can", "showDevPkgNoRecordPrompt", "toast", "resId", "error", "fillReadyPkgList", "pkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "Companion", "plugin-appbrand-integration_release"})
public class ag
  implements x, x.b
{
  @Deprecated
  public static final a kKz;
  private final String appId;
  private final boolean cbn;
  private final int gXn;
  private final String iJb;
  private final ICommLibReader jdZ;
  private WxaAttributes.WxaVersionInfo jfa;
  boolean kHn;
  private boolean kKw;
  private boolean kKx;
  private final QualitySession kKy;
  
  static
  {
    AppMethodBeat.i(180616);
    kKz = new a((byte)0);
    AppMethodBeat.o(180616);
  }
  
  public ag(String paramString1, int paramInt, boolean paramBoolean, String paramString2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, ICommLibReader paramICommLibReader, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(180615);
    this.appId = paramString1;
    this.gXn = paramInt;
    this.cbn = paramBoolean;
    this.iJb = paramString2;
    this.jfa = paramWxaVersionInfo;
    this.jdZ = paramICommLibReader;
    this.kKy = paramQualitySession;
    this.kKw = true;
    AppMethodBeat.o(180615);
  }
  
  private WxaPkgWrappingInfo aVF()
  {
    int j = 0;
    AppMethodBeat.i(180613);
    if ((j.a.nz(this.gXn)) && (this.jfa.aAS != 0))
    {
      localObject1 = ((t)com.tencent.mm.plugin.appbrand.app.j.T(t.class)).bG(this.appId, this.gXn);
      if (localObject1 != null)
      {
        localObject1 = com.tencent.mm.plugin.appbrand.config.y.Gx((String)localObject1);
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = (WxaPkgWrappingInfo)((a)new b(this)).invoke();
        AppMethodBeat.o(180613);
        return localObject1;
      }
      this.jfa = ((WxaAttributes.WxaVersionInfo)localObject1);
    }
    final WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = this.jfa.aAS;
    localWxaPkgWrappingInfo.iOQ = this.gXn;
    localWxaPkgWrappingInfo.md5 = this.jfa.jfy;
    localWxaPkgWrappingInfo.iOV = new WxaRuntimeModulePluginListMap();
    Object localObject1 = ae.kKh;
    localObject1 = this.jfa;
    Object localObject2 = this.appId;
    Object localObject3 = ae.kKh;
    localObject3 = ae.a((WxaAttributes.WxaVersionInfo)localObject1, (String)localObject2, ae.a(this.appId, this.gXn, this.jfa.aAS, this.cbn, this.jdZ));
    localObject2 = ((Map)localObject3).entrySet().iterator();
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    label341:
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = (String)o.c((Map.Entry)localObject1);
      localObject5 = (WxaAttributes.WxaWidgetInfo)o.d((Map.Entry)localObject1);
      if ((d.g.b.k.g("__APP__", localObject4) ^ true))
      {
        localObject6 = localWxaPkgWrappingInfo.iOT;
        localObject7 = new ModulePkgInfo();
        localObject1 = this.jfa.moduleList;
        d.g.b.k.g(localObject1, "versionInfo.moduleList");
        localObject8 = ((Iterable)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject8).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject8).next();
        } while (!d.g.b.k.g(localObject4, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name));
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = (WxaAttributes.WxaVersionModuleInfo)localObject1;
        ((ModulePkgInfo)localObject7).name = ((String)localObject4);
        ((ModulePkgInfo)localObject7).md5 = ((WxaAttributes.WxaWidgetInfo)localObject5).jfP;
        ((ModulePkgInfo)localObject7).independent = ((WxaAttributes.WxaVersionModuleInfo)localObject1).independent;
        ((ModulePkgInfo)localObject7).aliases = ((WxaAttributes.WxaVersionModuleInfo)localObject1).aliases;
        ((ModulePkgInfo)localObject7).pkgVersion = this.jfa.aAS;
        ((LinkedList)localObject6).add(localObject7);
      }
      localObject1 = (Collection)((WxaAttributes.WxaWidgetInfo)localObject5).jfQ;
      if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
      {
        i = 1;
        label432:
        if (i != 0) {
          break label542;
        }
        localObject6 = localWxaPkgWrappingInfo.iOV;
        if (localObject6 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = ((WxaAttributes.WxaWidgetInfo)localObject5).jfQ;
        localObject5 = (Collection)localObject1;
        if ((localObject5 != null) && (!((Collection)localObject5).isEmpty())) {
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
        d.g.b.k.h(localObject4, "moduleName");
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break;
        }
        ((Map)((WxaRuntimeModulePluginListMap)localObject6).iPa).put(new WxaRuntimeModulePluginListMap.c.a((String)localObject4), localObject1);
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
        localObject5 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject5, 10));
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject7 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject5).next();
          d.g.b.k.h(localObject7, "$this$toPkgInfo");
          localObject8 = new WxaPluginPkgInfo();
          ((WxaPluginPkgInfo)localObject8).provider = ((WxaAttributes.WxaPluginCodeInfo)localObject7).provider;
          ((WxaPluginPkgInfo)localObject8).version = ((WxaAttributes.WxaPluginCodeInfo)localObject7).version;
          ((WxaPluginPkgInfo)localObject8).md5 = ((WxaAttributes.WxaPluginCodeInfo)localObject7).md5;
          ((WxaPluginPkgInfo)localObject8).prefixPath = ((WxaAttributes.WxaPluginCodeInfo)localObject7).prefixPath;
          ((WxaPluginPkgInfo)localObject8).contexts = ((WxaAttributes.WxaPluginCodeInfo)localObject7).contexts;
          ((Collection)localObject1).add(localObject8);
        }
      }
    }
    localObject1 = localWxaPkgWrappingInfo.iOV;
    if (localObject1 != null) {
      ((WxaRuntimeModulePluginListMap)localObject1).aQz();
    }
    if ((this.jfa.jfD) && (!bt.gL(this.jfa.moduleList)))
    {
      localObject4 = new LinkedList();
      localObject5 = com.tencent.luggage.h.k.cA(LaunchParcel.EW(this.iJb));
      localObject1 = (CharSequence)localObject5;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = (CharSequence)this.jfa.jfE;
        if (localObject1 != null)
        {
          i = j;
          if (((CharSequence)localObject1).length() != 0) {}
        }
        else
        {
          i = 1;
        }
        if (i != 0) {
          break label1150;
        }
        localObject2 = this.jfa.moduleList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject2).next();
          if (d.g.b.k.g(this.jfa.jfE, ((WxaAttributes.WxaVersionModuleInfo)localObject1).name))
          {
            label858:
            if (localObject1 != null) {
              ((LinkedList)localObject4).add(((WxaAttributes.WxaVersionModuleInfo)localObject1).name);
            }
            if ((localObject1 == null) || ((!((WxaAttributes.WxaVersionModuleInfo)localObject1).independent) && ((d.g.b.k.g("__APP__", ((WxaAttributes.WxaVersionModuleInfo)localObject1).name) ^ true)))) {
              ((LinkedList)localObject4).add("__APP__");
            }
            localObject1 = (List)localObject4;
            localObject4 = new CountDownLatch(1);
            localObject2 = new AtomicReference();
            c.b("MicroMsg.LaunchCheckPkgForMiniProgramPluginCodeSplitHandler[" + this.appId + '|' + this.gXn + ']', (a)new c(this, (List)localObject1, (Map)localObject3, localWxaPkgWrappingInfo, (AtomicReference)localObject2, (CountDownLatch)localObject4));
          }
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
        localObject1 = null;
        break label858;
        localObject6 = this.jfa.moduleList.iterator();
        label1148:
        for (;;)
        {
          if (!((Iterator)localObject6).hasNext()) {
            break label1150;
          }
          localObject2 = (WxaAttributes.WxaVersionModuleInfo)((Iterator)localObject6).next();
          localObject7 = LaunchParcel.EW(((WxaAttributes.WxaVersionModuleInfo)localObject2).name);
          d.g.b.k.g(localObject7, "LaunchParcel.removeLeadi…SlashForEnterPath(m.name)");
          localObject1 = localObject2;
          if (n.mA((String)localObject5, (String)localObject7)) {
            break;
          }
          if (((WxaAttributes.WxaVersionModuleInfo)localObject2).aliases != null)
          {
            localObject7 = ((WxaAttributes.WxaVersionModuleInfo)localObject2).aliases;
            j = localObject7.length;
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label1148;
              }
              localObject8 = localObject7[i];
              d.g.b.k.g(localObject8, "alias");
              localObject1 = localObject2;
              if (n.mA((String)localObject5, (String)localObject8)) {
                break;
              }
              i += 1;
            }
          }
        }
        label1150:
        localObject1 = null;
        break label858;
        localObject1 = (List)d.a.j.Z(new String[] { "__APP__" });
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ad.e("MicroMsg.LaunchCheckPkgForMiniProgramPluginCodeSplitHandler", "await semaphore failed with appId(" + this.appId + ") versionType(" + this.gXn + ')');
        }
      }
    }
  }
  
  public final void Kj(String paramString)
  {
    AppMethodBeat.i(180612);
    if (this.kKw)
    {
      bc.Kj(paramString);
      AppMethodBeat.o(180612);
      return;
    }
    ad.e("MicroMsg.LaunchCheckPkgForMiniProgramPluginCodeSplitHandler", "silent toast:error=" + paramString + ", stack=" + Log.getStackTraceString(new Throwable()));
    AppMethodBeat.o(180612);
  }
  
  public void bgi() {}
  
  public final void gv(boolean paramBoolean)
  {
    this.kKw = paramBoolean;
  }
  
  public void onDownloadProgress(int paramInt) {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchCheckPkgHandlerSeparatedPluginsCompatible$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a
  {
    b(ag paramag)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ag
 * JD-Core Version:    0.7.0.1
 */