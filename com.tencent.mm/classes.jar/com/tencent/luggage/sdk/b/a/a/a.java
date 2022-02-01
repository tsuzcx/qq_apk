package com.tencent.luggage.sdk.b.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.v.e.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.u.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public final class a
{
  protected LockStepNative cgk;
  public String cgl;
  public boolean cgm;
  public final a cgn;
  
  public a()
  {
    AppMethodBeat.i(146750);
    this.cgl = null;
    this.cgm = true;
    this.cgn = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146748);
        synchronized (a.this)
        {
          if (a.this.cgk != null)
          {
            ad.i("Luggage.LockStepNativeInstallHelper", "DestroyTask destoryLockStep");
            a.this.cgk.destoryLockStep();
            a.this.cgk = null;
            AppMethodBeat.o(146748);
            return;
          }
          ad.i("Luggage.LockStepNativeInstallHelper", "DestroyTask lockStepNative is null");
        }
      }
    });
    AppMethodBeat.o(146750);
  }
  
  public static int getStatisticsNetType()
  {
    AppMethodBeat.i(146753);
    try
    {
      e.c localc1 = com.tencent.mm.plugin.appbrand.jsapi.v.e.dm(aj.getContext());
      ad.i("Luggage.LockStepNativeInstallHelper", "networkType = %s", new Object[] { localc1.value });
      ad.i("Luggage.LockStepNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(ay.getNetType(aj.getContext())) });
      e.c localc2 = e.c.klz;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return -1;
      }
      localc2 = e.c.klA;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 2;
      }
      localc2 = e.c.klB;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 3;
      }
      localc2 = e.c.klC;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 4;
      }
      localc2 = e.c.klD;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 5;
      }
      localc2 = e.c.klE;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 1;
      }
      AppMethodBeat.o(146753);
      return 0;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("Luggage.LockStepNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(146753);
    }
    return -1;
  }
  
  final class a
    extends c
    implements m.a
  {
    a(Runnable paramRunnable)
    {
      super();
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(146749);
      run();
      AppMethodBeat.o(146749);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */