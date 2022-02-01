package com.tencent.luggage.sdk.b.a.a;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.jsapi.z.f.c;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public final class a
{
  protected LockStepNative czB;
  public String czC;
  public boolean czD;
  public final a czE;
  
  public a()
  {
    AppMethodBeat.i(146750);
    this.czC = null;
    this.czD = true;
    this.czE = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146748);
        synchronized (a.this)
        {
          if (a.this.czB != null)
          {
            Log.i("Luggage.LockStepNativeInstallHelper", "DestroyTask destoryLockStep");
            a.this.czB.destoryLockStep();
            a.this.czB = null;
            AppMethodBeat.o(146748);
            return;
          }
          Log.i("Luggage.LockStepNativeInstallHelper", "DestroyTask lockStepNative is null");
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
      f.c localc1 = com.tencent.mm.plugin.appbrand.jsapi.z.f.dS(MMApplicationContext.getContext());
      Log.i("Luggage.LockStepNativeInstallHelper", "networkType = %s", new Object[] { localc1.value });
      Log.i("Luggage.LockStepNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())) });
      f.c localc2 = f.c.mtL;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return -1;
      }
      localc2 = f.c.mtM;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 2;
      }
      localc2 = f.c.mtN;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 3;
      }
      localc2 = f.c.mtO;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 4;
      }
      localc2 = f.c.mtP;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 5;
      }
      localc2 = f.c.mtQ;
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
      Log.printErrStackTrace("Luggage.LockStepNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
      AppMethodBeat.o(146753);
    }
    return -1;
  }
  
  final class a
    extends com.tencent.mm.plugin.appbrand.ac.l
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */