package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.e.c.d;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.LocationLogCallback;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

public final class h
{
  private static h heQ = null;
  private static Context mContext;
  private ap heR;
  
  private h()
  {
    AppMethodBeat.i(150507);
    HandlerThread localHandlerThread = d.aNZ("SLocationManager");
    localHandlerThread.start();
    this.heR = new ap(localHandlerThread.getLooper());
    TencentExtraKeys.setContext(aj.getContext());
    try
    {
      TencentExtraKeys.setTencentLogCallback(new LocationLogCallback()
      {
        public final void onLog(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(150504);
          switch (paramAnonymousInt)
          {
          default: 
            AppMethodBeat.o(150504);
            return;
          case 2: 
            ad.v("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 3: 
            ad.d("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 4: 
            ad.i("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 5: 
            ad.w("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          }
          if (paramAnonymousThrowable != null) {}
          for (paramAnonymousThrowable = paramAnonymousThrowable.getMessage();; paramAnonymousThrowable = "")
          {
            ad.e("MicroMsg.SLocationManager", "tag:%s msg:%s th:%s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousThrowable });
            break;
          }
        }
      });
      AppMethodBeat.o(150507);
      return;
    }
    catch (Exception localException)
    {
      ad.m("MicroMsg.SLocationManager", "", new Object[] { localException });
      AppMethodBeat.o(150507);
    }
  }
  
  public static h cw(Context paramContext)
  {
    AppMethodBeat.i(150508);
    if (heQ == null) {
      heQ = new h();
    }
    mContext = paramContext;
    paramContext = heQ;
    AppMethodBeat.o(150508);
    return paramContext;
  }
  
  private void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(150509);
    this.heR.post(paramRunnable);
    AppMethodBeat.o(150509);
  }
  
  public final void a(final TencentLocationListener paramTencentLocationListener, final int paramInt, final Looper paramLooper)
  {
    AppMethodBeat.i(150511);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150506);
        ad.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()) });
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(584L, 0L, 1L, true);
        TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.getOAID())).setCoordinateType(paramInt);
        TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create();
        localTencentLocationRequest.setInterval(2000L);
        ad.i("MicroMsg.SLocationManager", "requestCode %d", new Object[] { Integer.valueOf(TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.getOAID())).requestLocationUpdates(localTencentLocationRequest, paramTencentLocationListener, paramLooper)) });
        AppMethodBeat.o(150506);
      }
    });
    AppMethodBeat.o(150511);
  }
  
  public final void axX()
  {
    AppMethodBeat.i(150510);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150505);
        ad.d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.getOAID())).removeUpdates(null);
        AppMethodBeat.o(150505);
      }
    });
    AppMethodBeat.o(150510);
  }
  
  public static final class a
    extends Exception
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelgeo.h
 * JD-Core Version:    0.7.0.1
 */