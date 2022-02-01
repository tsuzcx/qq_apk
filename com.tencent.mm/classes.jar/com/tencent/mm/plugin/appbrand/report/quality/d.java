package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebView;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.m;
import kotlin.x;
import org.xwalk.core.XWalkEnvironment;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt;", "", "()V", "pagecontainerInitReport", "", "pagecontainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "report15815MainContextLibInject", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "name", "", "sourceLength", "", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportAllProcessRuntimeDistribution", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "reportCgiSpeed", "appId", "userName", "weAppQualityCGISpeedStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityCGISpeedStruct;", "servicePreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityAppServiceUSageStruct;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "staticWebViewKernelVersionForQualityReport", "webviewPreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityWebviewUsageStruct;", "webviewTypeForQualityReport", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "DEBUG_ASSERT", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "message", "IPC_getProcessAliveRuntimeCount", "plugin-appbrand-integration_release"})
public class d
{
  public static void a(QualitySessionRuntime paramQualitySessionRuntime, String paramString)
  {
    AppMethodBeat.i(51046);
    if ((paramQualitySessionRuntime == null) && (BuildInfo.IS_FLAVOR_RED))
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
    p.h(paramc, "service");
    Object localObject = paramc.bqZ();
    if (localObject != null)
    {
      localObject = ((ICommLibReader)localObject).bvb();
      if (localObject != null) {}
    }
    else
    {
      localObject = "invalid";
    }
    for (;;)
    {
      p.g(localObject, "service.libReader?.versionName() ?: \"invalid\"");
      if (!(paramObject instanceof m.c)) {
        paramObject = null;
      }
      for (;;)
      {
        paramObject = (m.c)paramObject;
        Log.i("MicroMsg.AppBrandQualitySystemKVProtocol", "Inject MainContextLibScript[" + paramString + "] Succeed wx.version = " + (String)localObject + ", appId = " + paramc.getAppId());
        long l;
        if ((paramc.bsW()) || (paramc.isRunning()))
        {
          paramString = b.bUZ().l((com.tencent.mm.plugin.appbrand.d)paramc).zy(paramString).vZ(paramInt);
          if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.mNV.length)) {
            break label307;
          }
          paramInt = v.mNV[paramObject.codeCacheStatus];
          paramString = paramString.wa(paramInt);
          if (!paramc.Mj()) {
            break label312;
          }
          l = 1L;
          label194:
          paramc = paramString.wb(l);
          if (paramObject == null) {
            break label318;
          }
          l = paramObject.flatJSCompileCost;
          label213:
          paramc = paramc.wc(l);
          if (paramObject == null) {
            break label324;
          }
        }
        label307:
        label312:
        label318:
        label324:
        for (paramInt = paramObject.dqm;; paramInt = 0)
        {
          paramc = paramc.wd(paramInt);
          if (paramObject != null) {
            paramLong1 = paramObject.dqk;
          }
          paramc.vX(paramLong1);
          if (paramObject != null) {
            paramLong2 = paramObject.dql;
          }
          paramc.vY(paramLong2);
          paramc.vW(paramc.aiW() - paramc.aiV());
          paramc.zA(V8.getV8Version());
          paramc.bfK();
          AppMethodBeat.o(175214);
          return;
          paramInt = 4;
          break;
          l = 0L;
          break label194;
          l = 0L;
          break label213;
        }
      }
    }
  }
  
  public static long bVa()
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
        switch (e.haE[localObject.ordinal()])
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
      i = WebView.getInstalledTbsCoreVersion(MMApplicationContext.getContext());
      continue;
      i = XWalkEnvironment.getAvailableVersion();
      continue;
      label113:
      i = 0;
    }
  }
  
  public static long z(ag paramag)
  {
    AppMethodBeat.i(51044);
    int i;
    if (paramag != null)
    {
      paramag = paramag.bRI();
      if (paramag == null) {
        break label68;
      }
      if (!paramag.isSysKernel()) {
        break label44;
      }
      i = 4;
    }
    for (;;)
    {
      long l = i;
      AppMethodBeat.o(51044);
      return l;
      paramag = null;
      break;
      label44:
      if (paramag.getIsX5Kernel()) {
        i = 2;
      } else if (paramag.isXWalkKernel()) {
        i = 3;
      } else {
        label68:
        i = -1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt$IPC_getProcessAliveRuntimeCount;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
  static final class a
    implements k<IPCVoid, IPCInteger>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements a<x>
  {
    public b(int paramInt, QualitySession paramQualitySession, AppBrandInitConfigWC paramAppBrandInitConfigWC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.d
 * JD-Core Version:    0.7.0.1
 */