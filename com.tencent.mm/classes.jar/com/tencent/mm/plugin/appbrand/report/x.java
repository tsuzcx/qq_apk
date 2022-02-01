package com.tencent.mm.plugin.appbrand.report;

import android.os.PersistableBundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.a.e;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/WeAppLaunchOpenSdkAdTracer;", "", "()V", "SNS_TIMELINE_AD_SCENES", "", "", "[Ljava/lang/Integer;", "TAG", "", "mMapInstanceId2TraceKey", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMapInstanceId2TraceKey", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mMapInstanceId2TraceKey$delegate", "Lkotlin/Lazy;", "onColdLaunchExecuted", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "onInstanceIdGenerated", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "onWarmLaunchExecuted", "reportKV", "value", "getAndRemove", "key", "plugin-appbrand-integration_release"})
public final class x
{
  private static final f qKj;
  private static final Integer[] qKk;
  public static final x qKl;
  
  static
  {
    AppMethodBeat.i(51033);
    qKl = new x();
    qKj = kotlin.g.ar((a)x.a.qKm);
    qKk = new Integer[] { Integer.valueOf(1084), Integer.valueOf(1046), Integer.valueOf(1045) };
    AppMethodBeat.o(51033);
  }
  
  public static void b(LaunchParcel paramLaunchParcel, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(51034);
    p.k(paramLaunchParcel, "parcel");
    p.k(paramString, "instanceId");
    Object localObject3;
    Object localObject1;
    if (paramLaunchParcel.cwV == null)
    {
      localObject3 = qKk;
      localObject1 = paramLaunchParcel.pdk;
      if (localObject1 == null) {
        break label206;
      }
      localObject1 = Integer.valueOf(((AppBrandStatObject)localObject1).scene);
      if (!e.contains((Object[])localObject3, localObject1)) {}
    }
    else
    {
      localObject3 = new aa.f();
      localObject1 = paramLaunchParcel.pZn;
      if (localObject1 == null) {
        break label211;
      }
      localObject1 = ((PersistableBundle)localObject1).getString("KEY_OPENSDK_AD_TRACE_KEY");
      label83:
      ((aa.f)localObject3).aaBC = localObject1;
      localObject1 = (CharSequence)((aa.f)localObject3).aaBC;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label216;
      }
      i = 1;
      label116:
      if (i != 0)
      {
        localObject1 = paramLaunchParcel.nYe;
        paramLaunchParcel = localObject2;
        if (localObject1 != null) {
          paramLaunchParcel = ((PersistableBundle)localObject1).getString("adUxInfo");
        }
        ((aa.f)localObject3).aaBC = paramLaunchParcel;
      }
      paramLaunchParcel = (CharSequence)((aa.f)localObject3).aaBC;
      if ((paramLaunchParcel != null) && (paramLaunchParcel.length() != 0)) {
        break label221;
      }
    }
    label206:
    label211:
    label216:
    label221:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.ZvG.d((Runnable)new c(paramString, (aa.f)localObject3), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51034);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label83;
      i = 0;
      break label116;
    }
  }
  
  public static void f(final AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(51035);
    p.k(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.nYk;
    if (localObject != null)
    {
      localObject = ((QualitySession)localObject).cBH;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.ZvG.d((Runnable)new d((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51035);
      return;
      localObject = null;
      break;
    }
  }
  
  public static void g(final AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(51036);
    p.k(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.nYk;
    if (localObject != null)
    {
      localObject = ((QualitySession)localObject).cBH;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.ZvG.d((Runnable)new b((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51036);
      return;
      localObject = null;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    
    public final void run()
    {
      AppMethodBeat.i(51030);
      Object localObject1 = x.qKl;
      localObject1 = x.a(x.chK(), this.qKn);
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramAppBrandInitConfigWC.Qw();
          x localx = x.qKl;
          localObject1 = org.apache.commons.b.g.a(new String[] { localObject1, localObject2, this.qKn, "2" }, ",");
          p.j(localObject1, "StringUtils.join(arrayOf…                  ), \",\")");
          x.amG((String)localObject1);
        }
        AppMethodBeat.o(51030);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString, aa.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(51031);
      Object localObject = x.qKl;
      x.chK().encode(this.qKn, (String)this.qKp.aaBC);
      localObject = x.qKl;
      localObject = org.apache.commons.b.g.a(new String[] { (String)this.qKp.aaBC, "", this.qKn, "1" }, ",");
      p.j(localObject, "StringUtils.join(arrayOf…                  ), \",\")");
      x.amG((String)localObject);
      AppMethodBeat.o(51031);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    
    public final void run()
    {
      AppMethodBeat.i(51032);
      Object localObject1 = x.qKl;
      localObject1 = x.a(x.chK(), this.qKn);
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramAppBrandInitConfigWC.Qw();
          x localx = x.qKl;
          localObject1 = org.apache.commons.b.g.a(new String[] { localObject1, localObject2, this.qKn, "3" }, ",");
          p.j(localObject1, "StringUtils.join(arrayOf…                  ), \",\")");
          x.amG((String)localObject1);
        }
        AppMethodBeat.o(51032);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.x
 * JD-Core Version:    0.7.0.1
 */