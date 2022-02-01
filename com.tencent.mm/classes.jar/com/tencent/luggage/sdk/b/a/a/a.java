package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.x.f;
import com.tencent.mm.plugin.appbrand.jsapi.x.f.c;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.y.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public final class a
{
  public String cnA;
  public boolean cnB;
  public final a cnC;
  protected LockStepNative cnz;
  
  public a()
  {
    AppMethodBeat.i(146750);
    this.cnA = null;
    this.cnB = true;
    this.cnC = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146748);
        synchronized (a.this)
        {
          if (a.this.cnz != null)
          {
            ae.i("Luggage.LockStepNativeInstallHelper", "DestroyTask destoryLockStep");
            a.this.cnz.destoryLockStep();
            a.this.cnz = null;
            AppMethodBeat.o(146748);
            return;
          }
          ae.i("Luggage.LockStepNativeInstallHelper", "DestroyTask lockStepNative is null");
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
      f.c localc1 = f.dx(ak.getContext());
      ae.i("Luggage.LockStepNativeInstallHelper", "networkType = %s", new Object[] { localc1.value });
      ae.i("Luggage.LockStepNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(az.getNetType(ak.getContext())) });
      f.c localc2 = f.c.lnh;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return -1;
      }
      localc2 = f.c.lni;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 2;
      }
      localc2 = f.c.lnj;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 3;
      }
      localc2 = f.c.lnk;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 4;
      }
      localc2 = f.c.lnl;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 5;
      }
      localc2 = f.c.lnm;
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
      ae.printErrStackTrace("Luggage.LockStepNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(146753);
    }
    return -1;
  }
  
  final class a
    extends l
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