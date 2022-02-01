package com.tencent.mm.plugin.appbrand.e;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.crash.ICrashReporter.ICrashReportExtraMessageGetter;
import com.tencent.mm.sdk.platformtools.AppBrands;
import com.tencent.mm.sdk.platformtools.AppBrands.AppBrandAppInfo;
import com.tencent.xweb.aj;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory;", "Lcom/tencent/mm/sdk/crash/ICrashReporter$ICrashReportExtraMessageGetter;", "()V", "mRunningAppInfos", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "getCrashReportExtraMessage", "", "getCurrentAppIdList", "getTopAppId", "getTopAppName", "onRuntimeDestroyed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onRuntimeResumed", "ReportWeAppInfo", "plugin-appbrand-integration_release"})
public final class a
  implements ICrashReporter.ICrashReportExtraMessageGetter
{
  private static final LinkedHashMap<a, Boolean> ocd;
  public static final a oce;
  
  static
  {
    AppMethodBeat.i(50345);
    oce = new a();
    ocd = new LinkedHashMap(5, 0.7F, true);
    AppBrands.setAppBrandInfoGetterSupplier((Callable)1.ocf);
    AppMethodBeat.o(50345);
  }
  
  public static final void R(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50342);
    p.k(paramAppBrandRuntime, "runtime");
    synchronized (ocd)
    {
      LinkedHashMap localLinkedHashMap2 = ocd;
      a.a.a locala = a.ocg;
      localLinkedHashMap2.put(a.a.a.T(paramAppBrandRuntime), Boolean.TRUE);
      aj.l(90001, new String[] { paramAppBrandRuntime.getAppId() });
      AppMethodBeat.o(50342);
      return;
    }
  }
  
  public static final void S(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50343);
    p.k(paramAppBrandRuntime, "runtime");
    synchronized (ocd)
    {
      LinkedHashMap localLinkedHashMap2 = ocd;
      a.a.a locala = a.ocg;
      localLinkedHashMap2.remove(a.a.a.T(paramAppBrandRuntime));
      AppMethodBeat.o(50343);
      return;
    }
  }
  
  public static String bLO()
  {
    AppMethodBeat.i(282924);
    synchronized (ocd)
    {
      if (ocd.size() > 0)
      {
        Object localObject1 = ocd.keySet();
        p.j(localObject1, "mRunningAppInfos.keys");
        localObject1 = ((a)j.g((Iterable)localObject1)).appId;
        AppMethodBeat.o(282924);
        return localObject1;
      }
      AppMethodBeat.o(282924);
      return "";
    }
  }
  
  public static String bLP()
  {
    AppMethodBeat.i(282925);
    synchronized (ocd)
    {
      if (ocd.size() > 0)
      {
        Object localObject1 = ocd.keySet();
        p.j(localObject1, "mRunningAppInfos.keys");
        localObject1 = ((a)j.g((Iterable)localObject1)).appName;
        AppMethodBeat.o(282925);
        return localObject1;
      }
      AppMethodBeat.o(282925);
      return "";
    }
  }
  
  public static String bLQ()
  {
    AppMethodBeat.i(282927);
    synchronized (ocd)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (ocd.size() > 0)
      {
        Iterator localIterator = ocd.keySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          p.j(localObject2, "it.next()");
          localStringBuilder.append(((a)localObject2).appId).append(';');
        }
      }
    }
    String str = localObject1.toString();
    p.j(str, "appIdList.toString()");
    AppMethodBeat.o(282927);
    return str;
  }
  
  public final String getCrashReportExtraMessage()
  {
    AppMethodBeat.i(50344);
    Object localObject5 = new LinkedList();
    ??? = WxaCommLibRuntimeReader.bHd();
    int i;
    Object localObject2;
    if (??? != null)
    {
      i = ((ICommLibReader)???).bGi();
      ((LinkedList)localObject5).add(new o("weapp_lib_version_int", Integer.valueOf(i)));
      if (??? != null)
      {
        localObject2 = ((ICommLibReader)???).bGg();
        ??? = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        ??? = "unknown";
      }
      ((LinkedList)localObject5).add(new o("weapp_lib_version_str", ???));
    }
    Object localObject6;
    for (;;)
    {
      Object localObject7;
      synchronized (ocd)
      {
        if (ocd.size() <= 0) {
          break label337;
        }
        localObject2 = ocd.keySet().iterator();
        localObject6 = new StringBuilder();
        localObject7 = ((Iterator)localObject2).next();
        p.j(localObject7, "it.next()");
        localObject7 = (a)localObject7;
        if (((Iterator)localObject2).hasNext()) {
          break label277;
        }
        ((LinkedList)localObject5).add(new o("weapp_id", ((a)localObject7).appId));
        ((LinkedList)localObject5).add(new o("weapp_name", ((a)localObject7).appName));
        ((LinkedList)localObject5).add(new o("weapp_version", Integer.valueOf(((a)localObject7).appVersion)));
        localObject2 = ((StringBuilder)localObject6).toString();
        p.j(localObject2, "this");
        i = Math.max(n.b((CharSequence)localObject2, ','), 0);
        if (localObject2 != null) {
          break label296;
        }
        localObject2 = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(50344);
        throw ((Throwable)localObject2);
      }
      i = -1;
      break;
      label277:
      ((StringBuilder)localObject6).append(((a)localObject7).appId).append(',');
    }
    label296:
    Object localObject4 = localObject3.substring(0, i);
    p.j(localObject4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((LinkedList)localObject5).add(new o("weapp_other_ids", localObject4));
    }
    label337:
    localObject4 = x.aazN;
    ??? = new StringBuilder();
    localObject4 = ((LinkedList)localObject5).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject6 = (o)((Iterator)localObject4).next();
      localObject5 = (String)((o)localObject6).Mx;
      localObject6 = ((o)localObject6).My;
      ((StringBuilder)???).append((String)localObject5).append(':').append(localObject6.toString()).append(';');
    }
    ??? = ((StringBuilder)???).toString();
    AppMethodBeat.o(50344);
    return ???;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "appId", "", "appName", "appType", "", "appVersion", "(Ljava/lang/String;Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getAppName", "getAppType", "()I", "getAppVersion", "compareTo", "other", "equals", "", "", "hashCode", "Companion", "plugin-appbrand-integration_release"})
  static final class a
    implements Comparable<a>
  {
    public static final a ocg;
    final String appId;
    final String appName;
    final int appType;
    final int appVersion;
    
    static
    {
      AppMethodBeat.i(50341);
      ocg = new a((byte)0);
      AppMethodBeat.o(50341);
    }
    
    public a(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50340);
      this.appId = paramString1;
      this.appName = paramString2;
      this.appType = paramInt1;
      this.appVersion = paramInt2;
      AppMethodBeat.o(50340);
    }
    
    private int a(a parama)
    {
      AppMethodBeat.i(50336);
      p.k(parama, "other");
      int j = this.appId.compareTo(parama.appId);
      int i = j;
      if (j == 0) {
        i = this.appType - parama.appType;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (j.a.za(this.appType)) {
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "plugin-appbrand-integration_release"})
    public static final class a
    {
      public static a.a T(AppBrandRuntime paramAppBrandRuntime)
      {
        int j = -1;
        AppMethodBeat.i(50335);
        p.k(paramAppBrandRuntime, "runtime");
        String str = paramAppBrandRuntime.getAppId();
        p.j(str, "runtime.appId");
        Object localObject1 = paramAppBrandRuntime.Sq();
        if (localObject1 != null)
        {
          localObject1 = ((AppBrandInitConfig)localObject1).fzM;
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = "unknown";
        }
        for (;;)
        {
          AppBrandInitConfig localAppBrandInitConfig = paramAppBrandRuntime.Sq();
          Object localObject2 = localAppBrandInitConfig;
          if (!(localAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            localObject2 = null;
          }
          localObject2 = (AppBrandInitConfigLU)localObject2;
          if (localObject2 != null) {}
          for (int i = ((AppBrandInitConfigLU)localObject2).cBI;; i = -1)
          {
            localObject2 = paramAppBrandRuntime.Sq();
            paramAppBrandRuntime = (AppBrandRuntime)localObject2;
            if (!(localObject2 instanceof AppBrandInitConfigLU)) {
              paramAppBrandRuntime = null;
            }
            paramAppBrandRuntime = (AppBrandInitConfigLU)paramAppBrandRuntime;
            if (paramAppBrandRuntime != null) {
              j = paramAppBrandRuntime.appVersion;
            }
            paramAppBrandRuntime = new a.a(str, (String)localObject1, i, j);
            AppMethodBeat.o(50335);
            return paramAppBrandRuntime;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.a
 * JD-Core Version:    0.7.0.1
 */