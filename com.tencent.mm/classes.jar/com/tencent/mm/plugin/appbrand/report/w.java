package com.tencent.mm.plugin.appbrand.report;

import android.os.PersistableBundle;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.a.e;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/WeAppLaunchOpenSdkAdTracer;", "", "()V", "SNS_TIMELINE_AD_SCENES", "", "", "[Ljava/lang/Integer;", "TAG", "", "mMapInstanceId2TraceKey", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMMapInstanceId2TraceKey", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mMapInstanceId2TraceKey$delegate", "Lkotlin/Lazy;", "onColdLaunchExecuted", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "onInstanceIdGenerated", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "instanceId", "onWarmLaunchExecuted", "reportKV", "value", "getAndRemove", "key", "plugin-appbrand-integration_release"})
public final class w
{
  private static final f nHX;
  private static final Integer[] nHY;
  public static final w nHZ;
  
  static
  {
    AppMethodBeat.i(51033);
    nHZ = new w();
    nHX = kotlin.g.ah((a)w.a.nIa);
    nHY = new Integer[] { Integer.valueOf(1084), Integer.valueOf(1046), Integer.valueOf(1045) };
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
    if (paramLaunchParcel.cys == null)
    {
      localObject3 = nHY;
      localObject1 = paramLaunchParcel.mYK;
      if (localObject1 == null) {
        break label206;
      }
      localObject1 = Integer.valueOf(((AppBrandStatObject)localObject1).scene);
      if (!e.contains((Object[])localObject3, localObject1)) {}
    }
    else
    {
      localObject3 = new z.f();
      localObject1 = paramLaunchParcel.mYP;
      if (localObject1 == null) {
        break label211;
      }
      localObject1 = ((PersistableBundle)localObject1).getString("KEY_OPENSDK_AD_TRACE_KEY");
      label83:
      ((z.f)localObject3).SYG = localObject1;
      localObject1 = (CharSequence)((z.f)localObject3).SYG;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label216;
      }
      i = 1;
      label116:
      if (i != 0)
      {
        localObject1 = paramLaunchParcel.ldQ;
        paramLaunchParcel = localObject2;
        if (localObject1 != null) {
          paramLaunchParcel = ((PersistableBundle)localObject1).getString("adUxInfo");
        }
        ((z.f)localObject3).SYG = paramLaunchParcel;
      }
      paramLaunchParcel = (CharSequence)((z.f)localObject3).SYG;
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
        h.RTc.b((Runnable)new c(paramString, (z.f)localObject3), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
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
  
  public static void h(final AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(51035);
    p.h(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.ldW;
    if (localObject != null)
    {
      localObject = ((QualitySession)localObject).kEY;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.RTc.b((Runnable)new d((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51035);
      return;
      localObject = null;
      break;
    }
  }
  
  public static void i(final AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(51036);
    p.h(paramAppBrandInitConfigWC, "initConfig");
    Object localObject = paramAppBrandInitConfigWC.ldW;
    if (localObject != null)
    {
      localObject = ((QualitySession)localObject).kEY;
      CharSequence localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        h.RTc.b((Runnable)new b((String)localObject, paramAppBrandInitConfigWC), "MicroMsg.WeAppLaunchOpenSdkAdTracer");
      }
      AppMethodBeat.o(51036);
      return;
      localObject = null;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    
    public final void run()
    {
      AppMethodBeat.i(51030);
      Object localObject1 = w.nHZ;
      localObject1 = w.a(w.bUA(), this.nIb);
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramAppBrandInitConfigWC.NB();
          w localw = w.nHZ;
          localObject1 = org.apache.commons.b.g.a(new String[] { localObject1, localObject2, this.nIb, "2" }, ",");
          p.g(localObject1, "StringUtils.join(arrayOf…                  ), \",\")");
          w.aeM((String)localObject1);
        }
        AppMethodBeat.o(51030);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(String paramString, z.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(51031);
      Object localObject = w.nHZ;
      w.bUA().encode(this.nIb, (String)this.nId.SYG);
      localObject = w.nHZ;
      localObject = org.apache.commons.b.g.a(new String[] { (String)this.nId.SYG, "", this.nIb, "1" }, ",");
      p.g(localObject, "StringUtils.join(arrayOf…                  ), \",\")");
      w.aeM((String)localObject);
      AppMethodBeat.o(51031);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    
    public final void run()
    {
      AppMethodBeat.i(51032);
      Object localObject1 = w.nHZ;
      localObject1 = w.a(w.bUA(), this.nIb);
      Object localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          localObject2 = paramAppBrandInitConfigWC.NB();
          w localw = w.nHZ;
          localObject1 = org.apache.commons.b.g.a(new String[] { localObject1, localObject2, this.nIb, "3" }, ",");
          p.g(localObject1, "StringUtils.join(arrayOf…                  ), \",\")");
          w.aeM((String)localObject1);
        }
        AppMethodBeat.o(51032);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.w
 * JD-Core Version:    0.7.0.1
 */