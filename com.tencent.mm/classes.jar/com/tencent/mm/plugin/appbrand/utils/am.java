package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.au;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/SafeScreenShotRecordSwitcher;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "myTag", "", "runtimeSwitch", "", "disableSafeScreenShotRecord", "disableSafeScreenShotRecordInner", "enableSafeScreenShotRecord", "enableSafeScreenShotRecordInner", "resetSafeScreenShotRecordSwitch", "", "setHiddenInBackgroundSwitch", "pageSwitch", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
{
  public static final a urK;
  public final String djQ;
  private final AppBrandRuntime qzz;
  public volatile boolean urL;
  
  static
  {
    AppMethodBeat.i(317381);
    urK = new a((byte)0);
    AppMethodBeat.o(317381);
  }
  
  public am(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(317355);
    this.qzz = paramAppBrandRuntime;
    this.djQ = s.X("MicroMsg.AppBrand.SafeScreenShotRecordSwitcher#", Integer.valueOf(hashCode()));
    paramAppBrandRuntime = this.qzz.mAppId;
    Log.i(this.djQ, s.X("<init>, appId: ", paramAppBrandRuntime));
    this.qzz.a((au)new au()
    {
      private boolean urM;
      
      public final void b(ap paramAnonymousap)
      {
        AppMethodBeat.i(317417);
        s.u(paramAnonymousap, "container");
        if (!this.urM)
        {
          Log.i(am.d(this.urN), "onAttachedToRuntimeContainer, first blood");
          am.e(this.urN);
          this.urM = true;
        }
        AppMethodBeat.o(317417);
      }
      
      public final void cdx() {}
    });
    k.a(paramAppBrandRuntime, (k.c)new k.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(317424);
        super.onDestroy();
        Log.i(am.d(this.urN), "onDestroy");
        am.e(this.urN);
        AppMethodBeat.o(317424);
      }
    });
    AppMethodBeat.o(317355);
  }
  
  public static final am l(g paramg)
  {
    AppMethodBeat.i(317360);
    paramg = a.l(paramg);
    AppMethodBeat.o(317360);
    return paramg;
  }
  
  public final boolean cNG()
  {
    AppMethodBeat.i(317384);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.qzz.mContext);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Activity)localObject).getWindow())
    {
      Log.i(this.djQ, s.X("enableSafeScreenShotRecordInner, window: ", localObject));
      if (localObject == null) {
        break;
      }
      ((Window)localObject).addFlags(8192);
      AppMethodBeat.o(317384);
      return true;
    }
    AppMethodBeat.o(317384);
    return false;
  }
  
  public final boolean cNH()
  {
    AppMethodBeat.i(317389);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.qzz.mContext);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Activity)localObject).getWindow())
    {
      Log.i(this.djQ, s.X("disableSafeScreenShotRecordInner, window: ", localObject));
      if (localObject == null) {
        break;
      }
      ((Window)localObject).clearFlags(8192);
      AppMethodBeat.o(317389);
      return true;
    }
    AppMethodBeat.o(317389);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/SafeScreenShotRecordSwitcher$Companion;", "", "()V", "TAG", "", "get", "Lcom/tencent/mm/plugin/appbrand/utils/SafeScreenShotRecordSwitcher;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static am l(g paramg)
    {
      AppMethodBeat.i(317405);
      s.u(paramg, "component");
      paramg = paramg.getRuntime();
      if (paramg == null)
      {
        Log.w("MicroMsg.AppBrand.SafeScreenShotRecordSwitcher", "get, runtime is null");
        AppMethodBeat.o(317405);
        return null;
      }
      paramg = paramg.qsY;
      AppMethodBeat.o(317405);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.am
 * JD-Core Version:    0.7.0.1
 */