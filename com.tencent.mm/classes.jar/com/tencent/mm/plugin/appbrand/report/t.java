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
import d.g.b.u;
import d.g.b.v.e;
import d.g.b.w;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/WeAppLaunchOpenSdkAdTracer;", "", "()V", "SNS_TIMELINE_AD_SCENES", "", "", "[Ljava/lang/Integer;", "TAG", "", "mMapInstanceId2TraceKey", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMapInstanceId2TraceKey", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mMapInstanceId2TraceKey$delegate", "Lkotlin/Lazy;", "onColdLaunchExecuted", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "onInstanceIdGenerated", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "onWarmLaunchExecuted", "reportKV", "value", "getAndRemove", "key", "plugin-appbrand-integration_release"})
public final class t
{
  private static final f lql;
  private static final Integer[] lqm;
  public static final t lqn;
  
  static
  {
    AppMethodBeat.i(51033);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(t.class), "mMapInstanceId2TraceKey", "getMMapInstanceId2TraceKey()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    lqn = new t();
    lql = d.g.E((a)t.a.lqo);
    lqm = new Integer[] { Integer.valueOf(1084), Integer.valueOf(1046), Integer.valueOf(1045) };
    AppMethodBeat.o(51033);
  }
  
  public static void b(LaunchParcel paramLaunchParcel, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(51034);
    d.g.b.k.h(paramLaunchParcel, "parcel");
    d.g.b.k.h(paramString, "instanceId");
    Object localObject3;
    Object localObject1;
    if (paramLaunchParcel.cfi == null)
    {
      localObject3 = lqm;
      localObject1 = paramLaunchParcel.kOh;
      if (localObject1 == null) {
        break label206;
      }
      localObject1 = Integer.valueOf(((AppBrandStatObject)localObject1).scene);
      if (!e.contains((Object[])localObject3, localObject1)) {}
    }
    else
    {
      localObject3 = new v.e();
      localObject1 = paramLaunchParcel.kOm;
      if (localObject1 == null) {
        break label211;
      }
      localObject1 = ((PersistableBundle)localObject1).getString("KEY_OPENSDK_AD_TRACE_KEY");
      label83:
      ((v.e)localObject3).Jhw = localObject1;
      localObject1 = (CharSequence)((v.e)localObject3).Jhw;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label216;
      }
      i = 1;
      label116:
      if (i != 0)
      {
        localObject1 = paramLaunchParcel.jdo;
        paramLaunchParcel = localObject2;
        if (localObject1 != null) {
          paramLaunchParcel = ((PersistableBundle)localObject1).getString("adUxInfo");
        }
        ((v.e)localObject3).Jhw = paramLaunchParcel;
      }
      paramLaunchParcel = (CharSequence)((v.e)localObject3).Jhw;
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
        h.Iye.f((Runnable)new c(paramString, (v.e)localObject3), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
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
  
  public static void g(final AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(51035);
    d.g.b.k.h(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.jdu;
    if (localObject != null)
    {
      localObject = ((QualitySession)localObject).kGa;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label84;
      }
    }
    label84:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.Iye.f((Runnable)new d((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51035);
      return;
      localObject = null;
      break;
    }
  }
  
  public static void h(final AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(51036);
    d.g.b.k.h(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.jdu;
    if (localObject != null)
    {
      localObject = ((QualitySession)localObject).kGa;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.Iye.f((Runnable)new b((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51036);
      return;
      localObject = null;
      break;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    
    public final void run()
    {
      AppMethodBeat.i(51030);
      Object localObject1 = t.lqn;
      localObject1 = t.a(t.bmp(), this.lqp);
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramAppBrandInitConfigWC.Da();
          t localt = t.lqn;
          localObject1 = org.apache.commons.b.g.a(new String[] { localObject1, localObject2, this.lqp, "2" }, ",");
          d.g.b.k.g(localObject1, "StringUtils.join(arrayOf…                  ), \",\")");
          t.Mx((String)localObject1);
        }
        AppMethodBeat.o(51030);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString, v.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(51031);
      Object localObject = t.lqn;
      t.bmp().encode(this.lqp, (String)this.lqr.Jhw);
      localObject = t.lqn;
      localObject = org.apache.commons.b.g.a(new String[] { (String)this.lqr.Jhw, "", this.lqp, "1" }, ",");
      d.g.b.k.g(localObject, "StringUtils.join(arrayOf…                  ), \",\")");
      t.Mx((String)localObject);
      AppMethodBeat.o(51031);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    
    public final void run()
    {
      AppMethodBeat.i(51032);
      Object localObject1 = t.lqn;
      localObject1 = t.a(t.bmp(), this.lqp);
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramAppBrandInitConfigWC.Da();
          t localt = t.lqn;
          localObject1 = org.apache.commons.b.g.a(new String[] { localObject1, localObject2, this.lqp, "3" }, ",");
          d.g.b.k.g(localObject1, "StringUtils.join(arrayOf…                  ), \",\")");
          t.Mx((String)localObject1);
        }
        AppMethodBeat.o(51032);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.t
 * JD-Core Version:    0.7.0.1
 */