package com.tencent.mm.plugin.appbrand.d;

import a.f.b.j;
import a.l;
import a.l.m;
import a.o;
import a.v;
import a.y;
import android.text.TextUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.a.c.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory;", "Lcom/tencent/mm/sdk/crash/ICrashReporter$ICrashReportExtraMessageGetter;", "()V", "mRunningAppInfos", "Ljava/util/LinkedHashMap;", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "", "getCrashReportExtraMessage", "", "onRuntimeDestroyed", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "onRuntimeResumed", "ReportWeAppInfo", "plugin-appbrand-integration_release"})
public final class a
  implements c.a
{
  private static final LinkedHashMap<a.a, Boolean> hkU;
  public static final a hkV;
  
  static
  {
    AppMethodBeat.i(154893);
    hkV = new a();
    hkU = new LinkedHashMap(5, 0.7F, true);
    AppMethodBeat.o(154893);
  }
  
  public static final void u(i parami)
  {
    AppMethodBeat.i(154890);
    j.q(parami, "runtime");
    synchronized (hkU)
    {
      LinkedHashMap localLinkedHashMap2 = hkU;
      a.a locala = a.a.hkW;
      localLinkedHashMap2.put(a.a.w(parami), Boolean.TRUE);
      AppMethodBeat.o(154890);
      return;
    }
  }
  
  public static final void v(i parami)
  {
    AppMethodBeat.i(154891);
    j.q(parami, "runtime");
    synchronized (hkU)
    {
      LinkedHashMap localLinkedHashMap2 = hkU;
      a.a locala = a.a.hkW;
      localLinkedHashMap2.remove(a.a.w(parami));
      AppMethodBeat.o(154891);
      return;
    }
  }
  
  public final String ayP()
  {
    AppMethodBeat.i(154892);
    Object localObject2 = new LinkedList();
    ((LinkedList)localObject2).add(new o("weapp_lib_version_int", Integer.valueOf(WxaCommLibRuntimeReader.avI().gXf)));
    ((LinkedList)localObject2).add(new o("weapp_lib_version_str", WxaCommLibRuntimeReader.getVersionName()));
    Object localObject5;
    int i;
    for (;;)
    {
      Object localObject6;
      synchronized (hkU)
      {
        if (hkU.size() <= 0) {
          break label306;
        }
        localObject4 = hkU.keySet().iterator();
        localObject5 = new StringBuilder();
        localObject6 = ((Iterator)localObject4).next();
        j.p(localObject6, "it.next()");
        localObject6 = (a.a)localObject6;
        if (!((Iterator)localObject4).hasNext())
        {
          ((LinkedList)localObject2).add(new o("weapp_id", ((a.a)localObject6).appId));
          ((LinkedList)localObject2).add(new o("weapp_name", ((a.a)localObject6).appName));
          ((LinkedList)localObject2).add(new o("weapp_version", Integer.valueOf(((a.a)localObject6).bDc)));
          localObject4 = ((StringBuilder)localObject5).toString();
          j.p(localObject4, "this");
          i = Math.max(m.a((CharSequence)localObject4, ','), 0);
          if (localObject4 != null) {
            break;
          }
          localObject2 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(154892);
          throw ((Throwable)localObject2);
        }
      }
      ((StringBuilder)localObject5).append(((a.a)localObject6).appId).append(',');
    }
    Object localObject4 = ((String)localObject4).substring(0, i);
    j.p(localObject4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      localObject3.add(new o("weapp_other_ids", localObject4));
    }
    label306:
    localObject4 = y.BMg;
    ??? = new StringBuilder();
    Iterator localIterator = localObject3.iterator();
    while (localIterator.hasNext())
    {
      localObject5 = (o)localIterator.next();
      localObject4 = (String)((o)localObject5).first;
      localObject5 = ((o)localObject5).second;
      ((StringBuilder)???).append((String)localObject4).append(':').append(localObject5.toString()).append(';');
    }
    ??? = ((StringBuilder)???).toString();
    AppMethodBeat.o(154892);
    return ???;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo$Companion;", "", "()V", "from", "Lcom/tencent/mm/plugin/appbrand/crash_report/AppBrandCrashReportExtraMessageFactory$ReportWeAppInfo;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "plugin-appbrand-integration_release"})
  public static final class a$a
  {
    public static a.a w(i parami)
    {
      int j = -1;
      AppMethodBeat.i(154883);
      j.q(parami, "runtime");
      String str = parami.getAppId();
      j.p(str, "runtime.appId");
      Object localObject1 = parami.wZ();
      if (localObject1 != null)
      {
        localObject1 = ((AppBrandInitConfig)localObject1).cqQ;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = "unknown";
      }
      for (;;)
      {
        AppBrandInitConfig localAppBrandInitConfig = parami.wZ();
        Object localObject2 = localAppBrandInitConfig;
        if (!(localAppBrandInitConfig instanceof AppBrandInitConfigLU)) {
          localObject2 = null;
        }
        localObject2 = (AppBrandInitConfigLU)localObject2;
        if (localObject2 != null) {}
        for (int i = ((AppBrandInitConfigLU)localObject2).gXd;; i = -1)
        {
          localObject2 = parami.wZ();
          parami = (i)localObject2;
          if (!(localObject2 instanceof AppBrandInitConfigLU)) {
            parami = null;
          }
          parami = (AppBrandInitConfigLU)parami;
          if (parami != null) {
            j = parami.bDc;
          }
          parami = new a.a(str, (String)localObject1, i, j);
          AppMethodBeat.o(154883);
          return parami;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.d.a
 * JD-Core Version:    0.7.0.1
 */