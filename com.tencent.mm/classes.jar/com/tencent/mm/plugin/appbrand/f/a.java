package com.tencent.mm.plugin.appbrand.f;

import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.sdk.a.c.a;
import com.tencent.xweb.af;
import d.g.b.k;
import d.l;
import d.n.n;
import d.o;
import d.v;
import d.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory;", "Lcom/tencent/mm/sdk/crash/ICrashReporter$ICrashReportExtraMessageGetter;", "()V", "mRunningAppInfos", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "getCrashReportExtraMessage", "", "onRuntimeDestroyed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onRuntimeResumed", "ReportWeAppInfo", "plugin-appbrand-integration_release"})
public final class a
  implements c.a
{
  private static final LinkedHashMap<a, Boolean> jgb;
  public static final a jgc;
  
  static
  {
    AppMethodBeat.i(50345);
    jgc = new a();
    jgb = new LinkedHashMap(5, 0.7F, true);
    AppMethodBeat.o(50345);
  }
  
  public static final void X(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50342);
    k.h(paramAppBrandRuntime, "runtime");
    synchronized (jgb)
    {
      LinkedHashMap localLinkedHashMap2 = jgb;
      a.a.a locala = a.jgd;
      localLinkedHashMap2.put(a.a.a.Z(paramAppBrandRuntime), Boolean.TRUE);
      af.l(90001, new String[] { paramAppBrandRuntime.getAppId() });
      AppMethodBeat.o(50342);
      return;
    }
  }
  
  public static final void Y(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(50343);
    k.h(paramAppBrandRuntime, "runtime");
    synchronized (jgb)
    {
      LinkedHashMap localLinkedHashMap2 = jgb;
      a.a.a locala = a.jgd;
      localLinkedHashMap2.remove(a.a.a.Z(paramAppBrandRuntime));
      AppMethodBeat.o(50343);
      return;
    }
  }
  
  public final String aTX()
  {
    AppMethodBeat.i(50344);
    Object localObject5 = new LinkedList();
    ??? = WxaCommLibRuntimeReader.aPT();
    int i;
    Object localObject2;
    if (??? != null)
    {
      i = ((ICommLibReader)???).aPc();
      ((LinkedList)localObject5).add(new o("weapp_lib_version_int", Integer.valueOf(i)));
      if (??? != null)
      {
        localObject2 = ((ICommLibReader)???).aPa();
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
      synchronized (jgb)
      {
        if (jgb.size() <= 0) {
          break label334;
        }
        localObject2 = jgb.keySet().iterator();
        localObject6 = new StringBuilder();
        localObject7 = ((Iterator)localObject2).next();
        k.g(localObject7, "it.next()");
        localObject7 = (a)localObject7;
        if (((Iterator)localObject2).hasNext()) {
          break label276;
        }
        ((LinkedList)localObject5).add(new o("weapp_id", ((a)localObject7).appId));
        ((LinkedList)localObject5).add(new o("weapp_name", ((a)localObject7).appName));
        ((LinkedList)localObject5).add(new o("weapp_version", Integer.valueOf(((a)localObject7).aAS)));
        localObject2 = ((StringBuilder)localObject6).toString();
        k.g(localObject2, "this");
        i = Math.max(n.b((CharSequence)localObject2, ','), 0);
        if (localObject2 != null) {
          break label295;
        }
        localObject2 = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(50344);
        throw ((Throwable)localObject2);
      }
      i = -1;
      break;
      label276:
      ((StringBuilder)localObject6).append(((a)localObject7).appId).append(',');
    }
    label295:
    Object localObject4 = localObject3.substring(0, i);
    k.g(localObject4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((LinkedList)localObject5).add(new o("weapp_other_ids", localObject4));
    }
    label334:
    localObject4 = y.JfV;
    ??? = new StringBuilder();
    localObject4 = ((LinkedList)localObject5).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject6 = (o)((Iterator)localObject4).next();
      localObject5 = (String)((o)localObject6).first;
      localObject6 = ((o)localObject6).second;
      ((StringBuilder)???).append((String)localObject5).append(':').append(localObject6.toString()).append(';');
    }
    ??? = ((StringBuilder)???).toString();
    AppMethodBeat.o(50344);
    return ???;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "appId", "", "appName", "appType", "", "appVersion", "(Ljava/lang/String;Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getAppName", "getAppType", "()I", "getAppVersion", "compareTo", "other", "equals", "", "", "hashCode", "Companion", "plugin-appbrand-integration_release"})
  static final class a
    implements Comparable<a>
  {
    public static final a jgd;
    final int aAS;
    final String appId;
    final String appName;
    private final int appType;
    
    static
    {
      AppMethodBeat.i(50341);
      jgd = new a((byte)0);
      AppMethodBeat.o(50341);
    }
    
    public a(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50340);
      this.appId = paramString1;
      this.appName = paramString2;
      this.appType = paramInt1;
      this.aAS = paramInt2;
      AppMethodBeat.o(50340);
    }
    
    private int a(a parama)
    {
      AppMethodBeat.i(50336);
      k.h(parama, "other");
      int j = this.appId.compareTo(parama.appId);
      int i = j;
      if (j == 0) {
        i = this.appType - parama.appType;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (j.a.qD(this.appType)) {
          j = this.aAS - parama.aAS;
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
      int i = ("[" + this.appId + "::" + this.appType + "::" + this.aAS + ']').hashCode();
      AppMethodBeat.o(50338);
      return i;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "plugin-appbrand-integration_release"})
    public static final class a
    {
      public static a.a Z(AppBrandRuntime paramAppBrandRuntime)
      {
        int j = -1;
        AppMethodBeat.i(50335);
        k.h(paramAppBrandRuntime, "runtime");
        String str = paramAppBrandRuntime.getAppId();
        k.g(str, "runtime.appId");
        Object localObject1 = paramAppBrandRuntime.Eg();
        if (localObject1 != null)
        {
          localObject1 = ((AppBrandInitConfig)localObject1).dfM;
          if (localObject1 != null) {}
        }
        else
        {
          localObject1 = "unknown";
        }
        for (;;)
        {
          AppBrandInitConfig localAppBrandInitConfig = paramAppBrandRuntime.Eg();
          Object localObject2 = localAppBrandInitConfig;
          if (!(localAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
            localObject2 = null;
          }
          localObject2 = (AppBrandInitConfigLU)localObject2;
          if (localObject2 != null) {}
          for (int i = ((AppBrandInitConfigLU)localObject2).iOP;; i = -1)
          {
            localObject2 = paramAppBrandRuntime.Eg();
            paramAppBrandRuntime = (AppBrandRuntime)localObject2;
            if (!(localObject2 instanceof AppBrandInitConfigLU)) {
              paramAppBrandRuntime = null;
            }
            paramAppBrandRuntime = (AppBrandInitConfigLU)paramAppBrandRuntime;
            if (paramAppBrandRuntime != null) {
              j = paramAppBrandRuntime.aAS;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.a
 * JD-Core Version:    0.7.0.1
 */