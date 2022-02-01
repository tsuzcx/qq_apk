package com.tencent.mm.plugin.appbrand.report;

import android.os.PersistableBundle;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/WeAppLaunchOpenSdkAdTracer;", "", "()V", "SNS_TIMELINE_AD_SCENES", "", "", "[Ljava/lang/Integer;", "TAG", "", "mMapInstanceId2TraceKey", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMapInstanceId2TraceKey", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mMapInstanceId2TraceKey$delegate", "Lkotlin/Lazy;", "onColdLaunchExecuted", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "onInstanceIdGenerated", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "onWarmLaunchExecuted", "reportKV", "value", "getAndRemove", "key", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  public static final y tOP;
  private static final j tOQ;
  private static final Integer[] tOR;
  
  static
  {
    AppMethodBeat.i(51033);
    tOP = new y();
    tOQ = kotlin.k.cm((a)a.tOS);
    tOR = new Integer[] { Integer.valueOf(1084), Integer.valueOf(1046), Integer.valueOf(1045) };
    AppMethodBeat.o(51033);
  }
  
  private static String a(MultiProcessMMKV paramMultiProcessMMKV, String paramString)
  {
    AppMethodBeat.i(321476);
    String str = paramMultiProcessMMKV.decodeString(paramString, null);
    if (str == null)
    {
      AppMethodBeat.o(321476);
      return null;
    }
    paramMultiProcessMMKV.removeValueForKey(paramString);
    AppMethodBeat.o(321476);
    return str;
  }
  
  private static final void a(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(321480);
    s.u(paramAppBrandInitConfigWC, "$initConfig");
    String str = a(cIF(), paramString);
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramString = org.apache.commons.c.i.b(new String[] { str, paramAppBrandInitConfigWC.eoP, paramString, "3" }, ",");
        s.s(paramString, "join(arrayOf(\n          …                  ), \",\")");
        reportKV(paramString);
      }
      AppMethodBeat.o(321480);
      return;
    }
  }
  
  private static final void a(String paramString, ah.f paramf)
  {
    AppMethodBeat.i(321478);
    s.u(paramString, "$instanceId");
    s.u(paramf, "$traceKey");
    cIF().encode(paramString, (String)paramf.aqH);
    paramString = org.apache.commons.c.i.b(new String[] { (String)paramf.aqH, "", paramString, "1" }, ",");
    s.s(paramString, "join(arrayOf(\n          …                  ), \",\")");
    reportKV(paramString);
    AppMethodBeat.o(321478);
  }
  
  public static void b(LaunchParcel paramLaunchParcel, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(51034);
    s.u(paramLaunchParcel, "parcel");
    s.u(paramString, "instanceId");
    Object localObject3;
    Object localObject1;
    if (paramLaunchParcel.eoV == null)
    {
      localObject3 = tOR;
      localObject1 = paramLaunchParcel.siB;
      if (localObject1 != null) {
        break label179;
      }
      localObject1 = null;
      if (!kotlin.a.k.contains((Object[])localObject3, localObject1)) {}
    }
    else
    {
      localObject3 = new ah.f();
      localObject1 = paramLaunchParcel.teb;
      if (localObject1 != null) {
        break label190;
      }
      localObject1 = null;
      label72:
      ((ah.f)localObject3).aqH = localObject1;
      localObject1 = (CharSequence)((ah.f)localObject3).aqH;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label200;
      }
      i = 1;
      label102:
      if (i != 0)
      {
        paramLaunchParcel = paramLaunchParcel.qYg;
        if (paramLaunchParcel != null) {
          break label205;
        }
        paramLaunchParcel = localObject2;
        label118:
        ((ah.f)localObject3).aqH = paramLaunchParcel;
      }
      paramLaunchParcel = (CharSequence)((ah.f)localObject3).aqH;
      if ((paramLaunchParcel != null) && (paramLaunchParcel.length() != 0)) {
        break label215;
      }
    }
    label179:
    label190:
    label200:
    label205:
    label215:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.threadpool.h.ahAA.g(new y..ExternalSyntheticLambda2(paramString, (ah.f)localObject3), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51034);
      return;
      localObject1 = Integer.valueOf(((AppBrandStatObject)localObject1).scene);
      break;
      localObject1 = ((PersistableBundle)localObject1).getString("KEY_OPENSDK_AD_TRACE_KEY");
      break label72;
      i = 0;
      break label102;
      paramLaunchParcel = paramLaunchParcel.getString("adUxInfo");
      break label118;
    }
  }
  
  private static final void b(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(321484);
    s.u(paramAppBrandInitConfigWC, "$initConfig");
    String str = a(cIF(), paramString);
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramString = org.apache.commons.c.i.b(new String[] { str, paramAppBrandInitConfigWC.eoP, paramString, "2" }, ",");
        s.s(paramString, "join(arrayOf(\n          …                  ), \",\")");
        reportKV(paramString);
      }
      AppMethodBeat.o(321484);
      return;
    }
  }
  
  private static MultiProcessMMKV cIF()
  {
    AppMethodBeat.i(321466);
    Object localObject = tOQ.getValue();
    s.s(localObject, "<get-mMapInstanceId2TraceKey>(...)");
    localObject = (MultiProcessMMKV)localObject;
    AppMethodBeat.o(321466);
    return localObject;
  }
  
  public static void i(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(51035);
    s.u(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.qYm;
    if (localObject == null)
    {
      localObject = null;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label80;
      }
    }
    label80:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.threadpool.h.ahAA.g(new y..ExternalSyntheticLambda1((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51035);
      return;
      localObject = ((QualitySession)localObject).eup;
      break;
    }
  }
  
  public static void j(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(51036);
    s.u(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.qYm;
    if (localObject == null)
    {
      localObject = null;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        com.tencent.threadpool.h.ahAA.g(new y..ExternalSyntheticLambda0((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51036);
      return;
      localObject = ((QualitySession)localObject).eup;
      break;
    }
  }
  
  private static void reportKV(String paramString)
  {
    AppMethodBeat.i(321474);
    Log.i("MicroMsg.WeAppLaunchOpenSdkAdTracer", "reportKV key[18460] value[" + paramString + ']');
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(18460, paramString);
    AppMethodBeat.o(321474);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<MultiProcessMMKV>
  {
    public static final a tOS;
    
    static
    {
      AppMethodBeat.i(51029);
      tOS = new a();
      AppMethodBeat.o(51029);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.y
 * JD-Core Version:    0.7.0.1
 */