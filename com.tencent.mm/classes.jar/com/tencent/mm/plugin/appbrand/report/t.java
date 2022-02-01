package com.tencent.mm.plugin.appbrand.report;

import android.os.PersistableBundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ax;
import d.a.e;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.y.f;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/report/WeAppLaunchOpenSdkAdTracer;", "", "()V", "SNS_TIMELINE_AD_SCENES", "", "", "[Ljava/lang/Integer;", "TAG", "", "mMapInstanceId2TraceKey", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMapInstanceId2TraceKey", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mMapInstanceId2TraceKey$delegate", "Lkotlin/Lazy;", "onColdLaunchExecuted", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "onInstanceIdGenerated", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "onWarmLaunchExecuted", "reportKV", "value", "getAndRemove", "key", "plugin-appbrand-integration_release"})
public final class t
{
  private static final f mrW;
  private static final Integer[] mrX;
  public static final t mrY;
  
  static
  {
    AppMethodBeat.i(51033);
    mrY = new t();
    mrW = d.g.O((a)t.a.mrZ);
    mrX = new Integer[] { Integer.valueOf(1084), Integer.valueOf(1046), Integer.valueOf(1045) };
    AppMethodBeat.o(51033);
  }
  
  public static void b(LaunchParcel paramLaunchParcel, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(51034);
    p.h(paramLaunchParcel, "parcel");
    p.h(paramString, "instanceId");
    Object localObject3;
    Object localObject1;
    if (paramLaunchParcel.cmv == null)
    {
      localObject3 = mrX;
      localObject1 = paramLaunchParcel.lMZ;
      if (localObject1 == null) {
        break label206;
      }
      localObject1 = Integer.valueOf(((AppBrandStatObject)localObject1).scene);
      if (!e.contains((Object[])localObject3, localObject1)) {}
    }
    else
    {
      localObject3 = new y.f();
      localObject1 = paramLaunchParcel.lNe;
      if (localObject1 == null) {
        break label211;
      }
      localObject1 = ((PersistableBundle)localObject1).getString("KEY_OPENSDK_AD_TRACE_KEY");
      label83:
      ((y.f)localObject3).MLV = localObject1;
      localObject1 = (CharSequence)((y.f)localObject3).MLV;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label216;
      }
      i = 1;
      label116:
      if (i != 0)
      {
        localObject1 = paramLaunchParcel.jXx;
        paramLaunchParcel = localObject2;
        if (localObject1 != null) {
          paramLaunchParcel = ((PersistableBundle)localObject1).getString("adUxInfo");
        }
        ((y.f)localObject3).MLV = paramLaunchParcel;
      }
      paramLaunchParcel = (CharSequence)((y.f)localObject3).MLV;
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
        h.LTJ.f((Runnable)new c(paramString, (y.f)localObject3), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
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
    p.h(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.jXD;
    if (localObject != null)
    {
      localObject = ((QualitySession)localObject).lEv;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.LTJ.f((Runnable)new d((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
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
    p.h(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.jXD;
    if (localObject != null)
    {
      localObject = ((QualitySession)localObject).lEv;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.LTJ.f((Runnable)new b((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51036);
      return;
      localObject = null;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    
    public final void run()
    {
      AppMethodBeat.i(51030);
      Object localObject1 = t.mrY;
      localObject1 = t.a(t.bxq(), this.msa);
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramAppBrandInitConfigWC.Ec();
          t localt = t.mrY;
          localObject1 = org.apache.commons.b.g.a(new String[] { localObject1, localObject2, this.msa, "2" }, ",");
          p.g(localObject1, "StringUtils.join(arrayOf…                  ), \",\")");
          t.Um((String)localObject1);
        }
        AppMethodBeat.o(51030);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString, y.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(51031);
      Object localObject = t.mrY;
      t.bxq().encode(this.msa, (String)this.msc.MLV);
      localObject = t.mrY;
      localObject = org.apache.commons.b.g.a(new String[] { (String)this.msc.MLV, "", this.msa, "1" }, ",");
      p.g(localObject, "StringUtils.join(arrayOf…                  ), \",\")");
      t.Um((String)localObject);
      AppMethodBeat.o(51031);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    
    public final void run()
    {
      AppMethodBeat.i(51032);
      Object localObject1 = t.mrY;
      localObject1 = t.a(t.bxq(), this.msa);
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramAppBrandInitConfigWC.Ec();
          t localt = t.mrY;
          localObject1 = org.apache.commons.b.g.a(new String[] { localObject1, localObject2, this.msa, "3" }, ",");
          p.g(localObject1, "StringUtils.join(arrayOf…                  ), \",\")");
          t.Um((String)localObject1);
        }
        AppMethodBeat.o(51032);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.t
 * JD-Core Version:    0.7.0.1
 */