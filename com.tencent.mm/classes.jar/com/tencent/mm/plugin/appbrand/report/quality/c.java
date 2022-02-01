package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.xweb.WebView;
import d.g.b.k;
import d.l;
import d.m;
import org.xwalk.core.XWalkEnvironment;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt;", "", "()V", "pagecontainerInitReport", "", "pagecontainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "report15815MainContextLibInject", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "name", "", "sourceLength", "", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportAllProcessRuntimeDistribution", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "servicePreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityAppServiceUSageStruct;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "staticWebViewKernelVersionForQualityReport", "webviewPreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityWebviewUsageStruct;", "webviewTypeForQualityReport", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "DEBUG_ASSERT", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "message", "IPC_getProcessAliveRuntimeCount", "plugin-appbrand-integration_release"})
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
    k.h(paramc, "service");
    Object localObject = paramc.aLC();
    if (localObject != null)
    {
      localObject = ((ICommLibReader)localObject).aPa();
      if (localObject != null) {}
    }
    else
    {
      localObject = "invalid";
    }
    for (;;)
    {
      k.g(localObject, "service.libReader?.versionName() ?: \"invalid\"");
      if (!(paramObject instanceof m.c)) {
        paramObject = null;
      }
      for (;;)
      {
        paramObject = (m.c)paramObject;
        ad.i("MicroMsg.AppBrandQualitySystemKVProtocol", "Inject MainContextLibScript[" + paramString + "] Succeed wx.version = " + (String)localObject + ", appId = " + paramc.getAppId());
        long l;
        if ((paramc.aNv()) || (paramc.isRunning()))
        {
          a.bmM();
          paramString = b.g((d)paramc).lp(paramString).iD(paramInt);
          if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.kDv.length)) {
            break label308;
          }
          paramInt = v.kDv[paramObject.codeCacheStatus];
          paramString = paramString.iE(paramInt);
          if (!paramc.BH()) {
            break label313;
          }
          l = 1L;
          label195:
          paramc = paramString.iF(l);
          if (paramObject == null) {
            break label319;
          }
          l = paramObject.flatJSCompileCost;
          label214:
          paramc = paramc.iG(l);
          if (paramObject == null) {
            break label325;
          }
        }
        label308:
        label313:
        label319:
        label325:
        for (paramInt = paramObject.cPZ;; paramInt = 0)
        {
          paramc = paramc.iH(paramInt);
          if (paramObject != null) {
            paramLong1 = paramObject.cPX;
          }
          paramc.iB(paramLong1);
          if (paramObject != null) {
            paramLong2 = paramObject.cPY;
          }
          paramc.iC(paramLong2);
          paramc.iA(paramc.RS() - paramc.RR());
          paramc.lr(V8.getV8Version());
          paramc.aBj();
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
  
  public static long bmN()
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
        switch (d.fPQ[localObject.ordinal()])
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
      i = WebView.getInstalledTbsCoreVersion(aj.getContext());
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
      paramae = paramae.bka();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c
 * JD-Core Version:    0.7.0.1
 */