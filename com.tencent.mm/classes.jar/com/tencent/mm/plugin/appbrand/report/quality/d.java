package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.mmv8.V8;
import com.tencent.luggage.sdk.b.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.autogen.mmdata.rpt.ta;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ao;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt;", "", "()V", "pagecontainerInitReport", "", "pagecontainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "report15815MainContextLibInject", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "name", "", "sourceLength", "", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportAllProcessRuntimeDistribution", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "reportCgiSpeed", "appId", "userName", "weAppQualityCGISpeedStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityCGISpeedStruct;", "servicePreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityAppServiceUSageStruct;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "staticWebViewKernelVersionForQualityReport", "webviewPreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityWebviewUsageStruct;", "webviewTypeForQualityReport", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "DEBUG_ASSERT", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "message", "IPC_getProcessAliveRuntimeCount", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
{
  public static void a(QualitySessionRuntime paramQualitySessionRuntime, String paramString)
  {
    AppMethodBeat.i(51046);
    if ((paramQualitySessionRuntime == null) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)))
    {
      paramQualitySessionRuntime = new IllegalArgumentException(paramString);
      AppMethodBeat.o(51046);
      throw paramQualitySessionRuntime;
    }
    AppMethodBeat.o(51046);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    long l2 = 0L;
    AppMethodBeat.i(175214);
    s.u(paramc, "service");
    Object localObject = paramc.cbl();
    label44:
    long l1;
    if (localObject == null)
    {
      localObject = "invalid";
      if (!(paramObject instanceof m.c)) {
        break label291;
      }
      paramObject = (m.c)paramObject;
      Log.i("MicroMsg.AppBrandQualitySystemKVProtocol", "Inject MainContextLibScript[" + paramString + "] Succeed wx.version = " + (String)localObject + ", appId = " + paramc.getAppId());
      if ((paramc.cdi()) || (paramc.isRunning()))
      {
        paramString = b.cJb().k((g)paramc).zt(paramString);
        paramString.jAh = paramInt;
        if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.sTm.length)) {
          break label297;
        }
        paramInt = v.sTm[paramObject.codeCacheStatus];
        label157:
        paramString.jAk = paramInt;
        if (!paramc.esM.apj()) {
          break label302;
        }
        l1 = 1L;
        label176:
        paramString.jAl = l1;
        if (paramObject != null) {
          break label308;
        }
        l1 = l2;
        label191:
        paramString.jAm = l1;
        if (paramObject != null) {
          break label318;
        }
        paramInt = 0;
        label204:
        paramString.jAF = paramInt;
        if (paramObject != null) {
          break label327;
        }
        label215:
        paramString.fZ(paramLong1);
        if (paramObject != null) {
          break label336;
        }
      }
    }
    for (;;)
    {
      paramString.ga(paramLong2);
      paramString.fY(paramString.jyJ - paramString.jyI);
      paramString.zv(V8.getV8Version());
      paramString.bMH();
      AppMethodBeat.o(175214);
      return;
      String str = ((ICommLibReader)localObject).cfD();
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "invalid";
      break;
      label291:
      paramObject = null;
      break label44;
      label297:
      paramInt = 4;
      break label157;
      label302:
      l1 = 0L;
      break label176;
      label308:
      l1 = paramObject.flatJSCompileCost;
      break label191;
      label318:
      paramInt = paramObject.hng;
      break label204;
      label327:
      paramLong1 = paramObject.hne;
      break label215;
      label336:
      paramLong2 = paramObject.hnf;
    }
  }
  
  public static long cJc()
  {
    AppMethodBeat.i(51045);
    try
    {
      localObject1 = WebView.getCurWebType();
      if (localObject1 != null) {
        break label43;
      }
      i = -1;
    }
    finally
    {
      Object localObject1;
      AppMethodBeat.o(51045);
      return -1L;
    }
    localObject1 = new p();
    AppMethodBeat.o(51045);
    throw ((Throwable)localObject1);
    label43:
    int i = b.avl[localObject2.ordinal()];
    for (;;)
    {
      long l = i;
      AppMethodBeat.o(51045);
      return l;
      i = ao.kgg();
      continue;
      i = ao.getInstalledTbsCoreVersion(MMApplicationContext.getContext());
      continue;
      i = ao.getAvailableVersion();
      continue;
      i = ao.getAvailableVersion();
      continue;
      switch (i)
      {
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      default: 
        break;
      case -1: 
      case 1: 
        i = 0;
      }
    }
  }
  
  public static long z(com.tencent.mm.plugin.appbrand.page.ah paramah)
  {
    AppMethodBeat.i(51044);
    int i;
    if (paramah == null)
    {
      paramah = null;
      if (paramah == null) {
        break label75;
      }
      if ((!paramah.isSysKernel()) && (!paramah.isX5WrappedSysKernel())) {
        break label51;
      }
      i = 4;
    }
    for (;;)
    {
      long l = i;
      AppMethodBeat.o(51044);
      return l;
      paramah = paramah.cFc();
      break;
      label51:
      if (paramah.isX5WrappedKernel()) {
        i = 2;
      } else if (paramah.isXWalkKernel()) {
        i = 3;
      } else {
        label75:
        i = -1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements a<kotlin.ah>
  {
    public c(int paramInt, QualitySession paramQualitySession, AppBrandInitConfigWC paramAppBrandInitConfigWC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.d
 * JD-Core Version:    0.7.0.1
 */