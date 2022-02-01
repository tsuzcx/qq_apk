package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.e.c.d;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationManagerOptions;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;

public final class h
{
  private static h iaQ = null;
  private static Context mContext;
  private aq iaR;
  
  private h()
  {
    AppMethodBeat.i(150507);
    HandlerThread localHandlerThread = d.bbf("SLocationManager");
    localHandlerThread.start();
    this.iaR = new aq(localHandlerThread.getLooper());
    TencentExtraKeys.setContext(ak.getContext());
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
            ae.v("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 3: 
            ae.d("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 4: 
            ae.i("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 5: 
            ae.w("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          }
          if (paramAnonymousThrowable != null) {}
          for (paramAnonymousThrowable = paramAnonymousThrowable.getMessage();; paramAnonymousThrowable = "")
          {
            ae.e("MicroMsg.SLocationManager", "tag:%s msg:%s th:%s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousThrowable });
            break;
          }
        }
      });
      AppMethodBeat.o(150507);
      return;
    }
    catch (Exception localException)
    {
      ae.m("MicroMsg.SLocationManager", "", new Object[] { localException });
      AppMethodBeat.o(150507);
    }
  }
  
  public static h cE(Context paramContext)
  {
    AppMethodBeat.i(150508);
    if (iaQ == null) {
      iaQ = new h();
    }
    mContext = paramContext;
    paramContext = iaQ;
    AppMethodBeat.o(150508);
    return paramContext;
  }
  
  private void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(150509);
    this.iaR.post(paramRunnable);
    AppMethodBeat.o(150509);
  }
  
  public final void a(final TencentLocationListener paramTencentLocationListener, final int paramInt, final Looper paramLooper)
  {
    AppMethodBeat.i(218688);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150506);
        ae.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()) });
        g.yxI.idkeyStat(584L, 0L, 1L, true);
        TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.aaL())).setCoordinateType(paramInt);
        TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create();
        localTencentLocationRequest.setInterval(2000L);
        ae.i("MicroMsg.SLocationManager", "requestCode %d", new Object[] { Integer.valueOf(TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.aaL())).requestLocationUpdates(localTencentLocationRequest, paramTencentLocationListener, paramLooper)) });
        AppMethodBeat.o(150506);
      }
    });
    AppMethodBeat.o(218688);
  }
  
  public final void aIl()
  {
    AppMethodBeat.i(150510);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150505);
        ae.d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.aaL())).removeUpdates(null);
        AppMethodBeat.o(150505);
      }
    });
    AppMethodBeat.o(150510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelgeo.h
 * JD-Core Version:    0.7.0.1
 */