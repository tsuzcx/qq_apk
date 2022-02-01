package com.tencent.mm.plugin.appbrand.report.quality;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.xweb.WebView;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.m;
import d.z;
import org.xwalk.core.XWalkEnvironment;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/quality/AppBrandQualitySystemKVProtocolKt;", "", "()V", "pagecontainerInitReport", "", "pagecontainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "report15815MainContextLibInject", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "name", "", "sourceLength", "", "succeed", "", "startTimeMs", "", "endTimeMs", "extraParams", "reportAllProcessRuntimeDistribution", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "reportCgiSpeed", "appId", "userName", "weAppQualityCGISpeedStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityCGISpeedStruct;", "servicePreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityAppServiceUSageStruct;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "staticWebViewKernelVersionForQualityReport", "webviewPreload", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppQualityWebviewUsageStruct;", "webviewTypeForQualityReport", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "DEBUG_ASSERT", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySessionRuntime;", "message", "IPC_getProcessAliveRuntimeCount", "plugin-appbrand-integration_release"})
public class c
{
  public static void a(QualitySessionRuntime paramQualitySessionRuntime, String paramString)
  {
    AppMethodBeat.i(51046);
    if ((paramQualitySessionRuntime == null) && (i.IS_FLAVOR_RED))
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
    Object localObject = paramc.aVF();
    if (localObject != null)
    {
      localObject = ((ICommLibReader)localObject).aZn();
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
        ad.i("MicroMsg.AppBrandQualitySystemKVProtocol", "Inject MainContextLibScript[" + paramString + "] Succeed wx.version = " + (String)localObject + ", appId = " + paramc.getAppId());
        long l;
        if ((paramc.aXu()) || (paramc.isRunning()))
        {
          a.bxN();
          paramString = b.j((d)paramc).qY(paramString).od(paramInt);
          if ((paramObject == null) || (paramObject.codeCacheStatus < 0) || (paramObject.codeCacheStatus >= v.lBM.length)) {
            break label308;
          }
          paramInt = v.lBM[paramObject.codeCacheStatus];
          paramString = paramString.oe(paramInt);
          if (!paramc.CK()) {
            break label313;
          }
          l = 1L;
          label195:
          paramc = paramString.of(l);
          if (paramObject == null) {
            break label319;
          }
          l = paramObject.flatJSCompileCost;
          label214:
          paramc = paramc.og(l);
          if (paramObject == null) {
            break label325;
          }
        }
        label308:
        label313:
        label319:
        label325:
        for (paramInt = paramObject.cYK;; paramInt = 0)
        {
          paramc = paramc.oh(paramInt);
          if (paramObject != null) {
            paramLong1 = paramObject.cYI;
          }
          paramc.ob(paramLong1);
          if (paramObject != null) {
            paramLong2 = paramObject.cYJ;
          }
          paramc.oc(paramLong2);
          paramc.oa(paramc.UZ() - paramc.UY());
          paramc.ra(V8.getV8Version());
          paramc.aLk();
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
  
  public static long bxO()
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
        switch (d.gnp[localObject.ordinal()])
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
  
  public static long y(ae paramae)
  {
    AppMethodBeat.i(51044);
    int i;
    if (paramae != null)
    {
      paramae = paramae.buR();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements d.g.a.a<z>
  {
    public b(int paramInt, QualitySession paramQualitySession, AppBrandInitConfigWC paramAppBrandInitConfigWC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c
 * JD-Core Version:    0.7.0.1
 */