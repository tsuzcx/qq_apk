package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.u.f;
import com.tencent.mm.plugin.appbrand.jsapi.u.f.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public final class a
{
  protected LockStepNative cdg;
  public String cdh;
  public boolean cdi;
  public final a cdj;
  
  public a()
  {
    AppMethodBeat.i(146750);
    this.cdh = null;
    this.cdi = true;
    this.cdj = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146748);
        synchronized (a.this)
        {
          if (a.this.cdg != null)
          {
            ac.i("Luggage.LockStepNativeInstallHelper", "DestroyTask destoryLockStep");
            a.this.cdg.destoryLockStep();
            a.this.cdg = null;
            AppMethodBeat.o(146748);
            return;
          }
          ac.i("Luggage.LockStepNativeInstallHelper", "DestroyTask lockStepNative is null");
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
      f.c localc1 = f.dv(ai.getContext());
      ac.i("Luggage.LockStepNativeInstallHelper", "networkType = %s", new Object[] { localc1.value });
      ac.i("Luggage.LockStepNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(ax.getNetType(ai.getContext())) });
      f.c localc2 = f.c.kMR;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return -1;
      }
      localc2 = f.c.kMS;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 2;
      }
      localc2 = f.c.kMT;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 3;
      }
      localc2 = f.c.kMU;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 4;
      }
      localc2 = f.c.kMV;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 5;
      }
      localc2 = f.c.kMW;
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
      ac.printErrStackTrace("Luggage.LockStepNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */