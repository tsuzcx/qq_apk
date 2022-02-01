package com.tencent.mm.plugin.appbrand.crash_report;

import android.text.TextUtils;
import com.tencent.luggage.h.c;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.AppBrands;
import com.tencent.mm.sdk.platformtools.AppBrands.AppBrandAppInfo;
import com.tencent.xweb.ao;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory;", "Lcom/tencent/mm/sdk/crash/ICrashReporter$ICrashReportExtraMessageGetter;", "()V", "mRunningAppInfos", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "getCrashReportExtraMessage", "", "getCurrentAppIdList", "getTopAppId", "getTopAppName", "getTopAppServiceType", "", "getTopRenderMode", "onRuntimeDestroyed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onRuntimeResumed", "ReportWeAppInfo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements ICrashReporter.ICrashReportExtraMessageGetter
{
  public static final a rcS;
  private static final LinkedHashMap<a, Boolean> rcT;
  
  static
  {
    AppMethodBeat.i(50345);
    rcS = new a();
    rcT = new LinkedHashMap(5, 0.7F, true);
    AppBrands.setAppBrandInfoGetterSupplier(a..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(50345);
  }
  
  public static final void V(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50342);
    s.u(paramAppBrandRuntime, "runtime");
    synchronized (rcT)
    {
      LinkedHashMap localLinkedHashMap2 = rcT;
      a.a.a locala = a.rcU;
      localLinkedHashMap2.put(a.a.a.X(paramAppBrandRuntime), Boolean.TRUE);
      ao.bHM(paramAppBrandRuntime.mAppId);
      AppMethodBeat.o(50342);
      return;
    }
  }
  
  public static final void W(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50343);
    s.u(paramAppBrandRuntime, "runtime");
    synchronized (rcT)
    {
      LinkedHashMap localLinkedHashMap2 = rcT;
      a.a.a locala = a.rcU;
      localLinkedHashMap2.remove(a.a.a.X(paramAppBrandRuntime));
      AppMethodBeat.o(50343);
      return;
    }
  }
  
  public static String clm()
  {
    AppMethodBeat.i(319265);
    synchronized (rcT)
    {
      if (rcT.size() > 0)
      {
        Object localObject1 = rcT.keySet();
        s.s(localObject1, "mRunningAppInfos.keys");
        localObject1 = ((a)p.g((Iterable)localObject1)).appId;
        AppMethodBeat.o(319265);
        return localObject1;
      }
      AppMethodBeat.o(319265);
      return "";
    }
  }
  
  public static int cln()
  {
    AppMethodBeat.i(319266);
    synchronized (rcT)
    {
      if (rcT.size() > 0)
      {
        localObject1 = rcT.keySet();
        s.s(localObject1, "mRunningAppInfos.keys");
        int i = ((a)p.g((Iterable)localObject1)).appServiceType;
        AppMethodBeat.o(319266);
        return i;
      }
      Object localObject1 = ah.aiuX;
      AppMethodBeat.o(319266);
      return -1;
    }
  }
  
  public static String clo()
  {
    AppMethodBeat.i(319268);
    synchronized (rcT)
    {
      if (rcT.size() > 0)
      {
        Object localObject1 = rcT.keySet();
        s.s(localObject1, "mRunningAppInfos.keys");
        localObject1 = ((a)p.g((Iterable)localObject1)).appName;
        AppMethodBeat.o(319268);
        return localObject1;
      }
      AppMethodBeat.o(319268);
      return "";
    }
  }
  
  public static int clp()
  {
    AppMethodBeat.i(319271);
    synchronized (rcT)
    {
      if (rcT.size() > 0)
      {
        Set localSet = rcT.keySet();
        s.s(localSet, "mRunningAppInfos.keys");
        int i = ((a)p.g((Iterable)localSet)).renderBackend;
        AppMethodBeat.o(319271);
        return i;
      }
      AppMethodBeat.o(319271);
      return 0;
    }
  }
  
  public static String clq()
  {
    AppMethodBeat.i(319274);
    synchronized (rcT)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (rcT.size() > 0)
      {
        Iterator localIterator = rcT.keySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          s.s(localObject2, "it.next()");
          localStringBuilder.append(((a)localObject2).appId).append(';');
        }
      }
    }
    String str = localObject1.toString();
    s.s(str, "appIdList.toString()");
    AppMethodBeat.o(319274);
    return str;
  }
  
  private static final AppBrands.AppBrandAppInfo clr()
  {
    AppMethodBeat.i(319276);
    if (rcT.isEmpty())
    {
      AppMethodBeat.o(319276);
      return null;
    }
    Object localObject = rcT.keySet();
    s.s(localObject, "mRunningAppInfos.keys");
    localObject = (a)p.g((Iterable)localObject);
    AppBrands.AppBrandAppInfo localAppBrandAppInfo = new AppBrands.AppBrandAppInfo();
    localAppBrandAppInfo.appId = ((a)localObject).appId;
    localAppBrandAppInfo.appName = ((a)localObject).appName;
    localAppBrandAppInfo.appType = ((a)localObject).appType;
    localAppBrandAppInfo.appVersion = ((a)localObject).appVersion;
    localAppBrandAppInfo.appServiceType = ((a)localObject).appServiceType;
    localAppBrandAppInfo.renderBackend = ((a)localObject).renderBackend;
    AppMethodBeat.o(319276);
    return localAppBrandAppInfo;
  }
  
  public final String getCrashReportExtraMessage()
  {
    AppMethodBeat.i(50344);
    Object localObject4 = new LinkedList();
    ??? = WxaCommLibRuntimeReader.cgz();
    int i;
    if (??? == null) {
      i = -1;
    }
    for (;;)
    {
      ((LinkedList)localObject4).add(new r("weapp_lib_version_int", Integer.valueOf(i)));
      if (??? == null)
      {
        ??? = "unknown";
        label51:
        ((LinkedList)localObject4).add(new r("weapp_lib_version_str", ???));
      }
      synchronized (rcT)
      {
        Object localObject5;
        Object localObject6;
        if (rcT.size() > 0)
        {
          localObject2 = rcT.keySet().iterator();
          localObject5 = new StringBuilder();
          localObject6 = ((Iterator)localObject2).next();
          s.s(localObject6, "it.next()");
          localObject6 = (a)localObject6;
          if (((Iterator)localObject2).hasNext()) {
            break label426;
          }
          ((LinkedList)localObject4).add(new r("weapp_id", ((a)localObject6).appId));
          ((LinkedList)localObject4).add(new r("weapp_name", ((a)localObject6).appName));
          ((LinkedList)localObject4).add(new r("weapp_version", Integer.valueOf(((a)localObject6).appVersion)));
          ((LinkedList)localObject4).add(v.Y("weapp_service_type", Integer.valueOf(((a)localObject6).appServiceType)));
          ((LinkedList)localObject4).add(new r("weapp_render_backend", Integer.valueOf(((a)localObject6).renderBackend)));
          localObject2 = ((StringBuilder)localObject5).toString();
          s.s(localObject2, "this");
          localObject2 = ((String)localObject2).substring(0, Math.max(n.b((CharSequence)localObject2, ','), 0));
          s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((LinkedList)localObject4).add(new r("weapp_other_ids", localObject2));
          }
        }
        Object localObject2 = ah.aiuX;
        ??? = new StringBuilder();
        localObject2 = ((LinkedList)localObject4).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (r)((Iterator)localObject2).next();
          localObject4 = (String)((r)localObject5).bsC;
          localObject5 = ((r)localObject5).bsD;
          ((StringBuilder)???).append((String)localObject4).append(':').append(localObject5.toString()).append(';');
        }
        i = ((ICommLibReader)???).cfG();
        continue;
        localObject2 = ((ICommLibReader)???).cfD();
        ??? = localObject2;
        if (localObject2 != null) {
          break label51;
        }
        ??? = "unknown";
        break label51;
        label426:
        ((StringBuilder)localObject5).append(((a)localObject6).appId).append(',');
      }
    }
    ??? = ((StringBuilder)???).toString();
    AppMethodBeat.o(50344);
    return ???;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "appId", "", "appName", "appType", "", "appVersion", "appServiceType", "renderBackend", "(Ljava/lang/String;Ljava/lang/String;IIII)V", "getAppId", "()Ljava/lang/String;", "getAppName", "getAppServiceType", "()I", "getAppType", "getAppVersion", "getRenderBackend", "compareTo", "other", "equals", "", "", "hashCode", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements Comparable<a>
  {
    public static final a rcU;
    final String appId;
    final String appName;
    final int appServiceType;
    final int appType;
    final int appVersion;
    final int renderBackend;
    
    static
    {
      AppMethodBeat.i(50341);
      rcU = new a((byte)0);
      AppMethodBeat.o(50341);
    }
    
    public a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(319253);
      this.appId = paramString1;
      this.appName = paramString2;
      this.appType = paramInt1;
      this.appVersion = paramInt2;
      this.appServiceType = paramInt3;
      this.renderBackend = paramInt4;
      AppMethodBeat.o(319253);
    }
    
    private int a(a parama)
    {
      AppMethodBeat.i(50336);
      s.u(parama, "other");
      int j = this.appId.compareTo(parama.appId);
      int i = j;
      if (j == 0) {
        i = this.appType - parama.appType;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (k.a.zn(this.appType)) {
          j = this.appVersion - parama.appVersion;
        }
      }
      AppMethodBeat.o(50336);
      return j;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(50339);
      if (((paramObject instanceof a)) && (a((a)paramObject) == 0))
      {
        AppMethodBeat.o(50339);
        return true;
      }
      AppMethodBeat.o(50339);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(50338);
      int i = ("[" + this.appId + "::" + this.appType + "::" + this.appVersion + ']').hashCode();
      AppMethodBeat.o(50338);
      return i;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "renderBackend", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static a.a X(AppBrandRuntime paramAppBrandRuntime)
      {
        AppMethodBeat.i(50335);
        s.u(paramAppBrandRuntime, "runtime");
        String str = paramAppBrandRuntime.mAppId;
        s.s(str, "runtime.appId");
        Object localObject1 = paramAppBrandRuntime.asH();
        Object localObject2;
        label60:
        int i;
        label67:
        label88:
        int j;
        if (localObject1 == null)
        {
          localObject1 = "unknown";
          localObject2 = paramAppBrandRuntime.asH();
          if (!(localObject2 instanceof AppBrandInitConfigLU)) {
            break label172;
          }
          localObject2 = (AppBrandInitConfigLU)localObject2;
          if (localObject2 != null) {
            break label178;
          }
          i = -1;
          localObject2 = paramAppBrandRuntime.asH();
          if (!(localObject2 instanceof AppBrandInitConfigLU)) {
            break label187;
          }
          localObject2 = (AppBrandInitConfigLU)localObject2;
          if (localObject2 != null) {
            break label193;
          }
          j = -1;
          label95:
          localObject2 = paramAppBrandRuntime.asH();
          if (!(localObject2 instanceof AppBrandInitConfigLU)) {
            break label202;
          }
          localObject2 = (AppBrandInitConfigLU)localObject2;
          label116:
          if (localObject2 != null) {
            break label208;
          }
        }
        label172:
        label178:
        label187:
        label193:
        label202:
        label208:
        for (int k = -1;; k = ((AppBrandInitConfigLU)localObject2).appServiceType)
        {
          paramAppBrandRuntime = new a.a(str, (String)localObject1, i, j, k, Y(paramAppBrandRuntime));
          AppMethodBeat.o(50335);
          return paramAppBrandRuntime;
          localObject2 = ((AppBrandInitConfig)localObject1).hEy;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = "unknown";
          break;
          localObject2 = null;
          break label60;
          i = ((AppBrandInitConfigLU)localObject2).eul;
          break label67;
          localObject2 = null;
          break label88;
          j = ((AppBrandInitConfigLU)localObject2).appVersion;
          break label95;
          localObject2 = null;
          break label116;
        }
      }
      
      private static int Y(AppBrandRuntime paramAppBrandRuntime)
      {
        AppMethodBeat.i(319255);
        paramAppBrandRuntime = paramAppBrandRuntime.asH();
        if ((paramAppBrandRuntime instanceof AppBrandInitConfigWC))
        {
          paramAppBrandRuntime = (AppBrandInitConfigWC)paramAppBrandRuntime;
          if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.aqD() != true)) {
            break label56;
          }
        }
        label56:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label61;
          }
          i = c.asS();
          AppMethodBeat.o(319255);
          return i;
          paramAppBrandRuntime = null;
          break;
        }
        label61:
        AppMethodBeat.o(319255);
        return 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.crash_report.a
 * JD-Core Version:    0.7.0.1
 */