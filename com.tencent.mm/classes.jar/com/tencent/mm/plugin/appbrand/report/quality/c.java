package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.hh;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.xweb.WebView;
import d.m;
import d.y;
import org.xwalk.core.XWalkEnvironment;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt;", "", "()V", "pagecontainerInitReport", "", "pagecontainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "report15815MainContextLibInject", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "name", "", "sourceLength", "", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportAllProcessRuntimeDistribution", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "servicePreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityAppServiceUSageStruct;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "staticWebViewKernelVersionForQualityReport", "webviewPreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityWebviewUsageStruct;", "webviewTypeForQualityReport", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "DEBUG_ASSERT", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "message", "IPC_getProcessAliveRuntimeCount", "plugin-appbrand-integration_release"})
public class c
{
  public static void a(QualitySessionRuntime paramQualitySessionRuntime, String paramString)
  {
    AppMethodBeat.i(51046);
    if ((paramQualitySessionRuntime == null) && (h.IS_FLAVOR_RED))
    {
      paramQualitySessionRuntime = (Throwable)new IllegalArgumentException(paramString);
      AppMethodBeat.o(51046);
      throw paramQualitySessionRuntime;
    }
    AppMethodBeat.o(51046);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    AppMethodBeat.i(175214);
    d.g.b.k.h(paramc, "service");
    Object localObject = paramc.aSt();
    if (localObject != null)
    {
      localObject = ((ICommLibReader)localObject).aVS();
      if (localObject != null) {}
    }
    else
    {
      localObject = "invalid";
    }
    for (;;)
    {
      d.g.b.k.g(localObject, "service.libReader?.versionName() ?: \"invalid\"");
      if (!(paramObject instanceof m.c)) {
        paramObject = null;
      }
      for (;;)
      {
        paramObject = (m.c)paramObject;
        ac.i("MicroMsg.AppBrandQualitySystemKVProtocol", "Inject MainContextLibScript[" + paramString + "] Succeed wx.version = " + (String)localObject + ", appId = " + paramc.getAppId());
        long l;
        if ((paramc.aUl()) || (paramc.isRunning()))
        {
          a.btI();
          paramString = b.g((d)paramc).ou(paramString).mf(paramInt);
          if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.leN.length)) {
            break label308;
          }
          paramInt = v.leN[paramObject.codeCacheStatus];
          paramString = paramString.mg(paramInt);
          if (!paramc.Bl()) {
            break label313;
          }
          l = 1L;
          label195:
          paramc = paramString.mh(l);
          if (paramObject == null) {
            break label319;
          }
          l = paramObject.flatJSCompileCost;
          label214:
          paramc = paramc.mi(l);
          if (paramObject == null) {
            break label325;
          }
        }
        label308:
        label313:
        label319:
        label325:
        for (paramInt = paramObject.cNu;; paramInt = 0)
        {
          paramc = paramc.mj(paramInt);
          if (paramObject != null) {
            paramLong1 = paramObject.cNs;
          }
          paramc.md(paramLong1);
          if (paramObject != null) {
            paramLong2 = paramObject.cNt;
          }
          paramc.me(paramLong2);
          paramc.mc(paramc.SL() - paramc.SK());
          paramc.ow(V8.getV8Version());
          paramc.aHZ();
          AppMethodBeat.o(175214);
          return;
          paramInt = 4;
          break;
          l = 0L;
          break label195;
          l = 0L;
          break label214;
        }
      }
    }
  }
  
  public static long btJ()
  {
    AppMethodBeat.i(51045);
    for (;;)
    {
      try
      {
        Object localObject = WebView.getCurWebType();
        if (localObject == null)
        {
          break label113;
          long l = i;
          AppMethodBeat.o(51045);
          return l;
        }
        switch (d.fTL[localObject.ordinal()])
        {
        case 2: 
          localObject = new m();
          AppMethodBeat.o(51045);
          throw ((Throwable)localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(51045);
        return -1L;
      }
      int i = XWalkEnvironment.safeGetChromiunVersion();
      continue;
      i = WebView.getInstalledTbsCoreVersion(ai.getContext());
      continue;
      i = XWalkEnvironment.getAvailableVersion();
      continue;
      label113:
      i = 0;
    }
  }
  
  public static long x(ae paramae)
  {
    AppMethodBeat.i(51044);
    int i;
    if (paramae != null)
    {
      paramae = paramae.bqR();
      if (paramae == null) {
        break label68;
      }
      if (!paramae.isSysKernel()) {
        break label44;
      }
      i = 4;
    }
    for (;;)
    {
      long l = i;
      AppMethodBeat.o(51044);
      return l;
      paramae = null;
      break;
      label44:
      if (paramae.getIsX5Kernel()) {
        i = 2;
      } else if (paramae.isXWalkKernel()) {
        i = 3;
      } else {
        label68:
        i = -1;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt$IPC_getProcessAliveRuntimeCount;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
  static final class a
    implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCInteger>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public b(int paramInt, QualitySession paramQualitySession, AppBrandInitConfigWC paramAppBrandInitConfigWC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c
 * JD-Core Version:    0.7.0.1
 */