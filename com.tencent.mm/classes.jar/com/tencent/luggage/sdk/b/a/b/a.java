package com.tencent.luggage.sdk.b.a.b;

import com.tencent.luggage.a.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener;
import com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.ae.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.m.a;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public final class a
{
  protected LockStepNative eqX;
  public String eqY;
  public boolean eqZ;
  public final a era;
  
  public a()
  {
    AppMethodBeat.i(146750);
    this.eqY = null;
    this.eqZ = true;
    this.era = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146748);
        synchronized (a.this)
        {
          if (a.this.eqX != null)
          {
            Log.i("Luggage.LockStepNativeInstallHelper", "DestroyTask destoryLockStep");
            a.this.eqX.destoryLockStep();
            a.this.eqX = null;
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
      MMApplicationContext.getContext();
      k.c localc1 = k.cuM();
      Log.i("Luggage.LockStepNativeInstallHelper", "networkType = %s", new Object[] { localc1.value });
      Log.i("Luggage.LockStepNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(NetStatusUtil.getNetType(MMApplicationContext.getContext())) });
      k.c localc2 = k.c.swK;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return -1;
      }
      localc2 = k.c.swL;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 2;
      }
      localc2 = k.c.swM;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 3;
      }
      localc2 = k.c.swN;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 4;
      }
      localc2 = k.c.swO;
      if (localc1 == localc2)
      {
        AppMethodBeat.o(146753);
        return 5;
      }
      localc2 = k.c.swP;
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
    extends com.tencent.mm.plugin.appbrand.af.n
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */