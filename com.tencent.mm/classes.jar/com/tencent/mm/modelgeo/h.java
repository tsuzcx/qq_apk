package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.f.c.d;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationManagerOptions;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class h
{
  private static h iVO = null;
  private static Context mContext;
  private MMHandler iVP;
  
  private h()
  {
    AppMethodBeat.i(150507);
    HandlerThread localHandlerThread = d.bqq("SLocationManager");
    localHandlerThread.start();
    this.iVP = new MMHandler(localHandlerThread.getLooper());
    TencentExtraKeys.setContext(MMApplicationContext.getContext());
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
            Log.v("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 3: 
            Log.d("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 4: 
            Log.i("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          case 5: 
            Log.w("MicroMsg.SLocationManager", "tag:%s msg:%s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
            AppMethodBeat.o(150504);
            return;
          }
          if (paramAnonymousThrowable != null) {}
          for (paramAnonymousThrowable = paramAnonymousThrowable.getMessage();; paramAnonymousThrowable = "")
          {
            Log.e("MicroMsg.SLocationManager", "tag:%s msg:%s th:%s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousThrowable });
            break;
          }
        }
      });
      AppMethodBeat.o(150507);
      return;
    }
    catch (Exception localException)
    {
      Log.printInfoStack("MicroMsg.SLocationManager", "", new Object[] { localException });
      AppMethodBeat.o(150507);
    }
  }
  
  public static h da(Context paramContext)
  {
    AppMethodBeat.i(150508);
    if (iVO == null) {
      iVO = new h();
    }
    mContext = paramContext;
    paramContext = iVO;
    AppMethodBeat.o(150508);
    return paramContext;
  }
  
  private void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(150509);
    this.iVP.post(paramRunnable);
    AppMethodBeat.o(150509);
  }
  
  public final void a(final TencentLocationListener paramTencentLocationListener, final int paramInt, final Looper paramLooper)
  {
    AppMethodBeat.i(223570);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150506);
        Log.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(584L, 0L, 1L, true);
        TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.aoK())).setCoordinateType(paramInt);
        TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create();
        localTencentLocationRequest.setInterval(2000L);
        Log.i("MicroMsg.SLocationManager", "requestCode %d", new Object[] { Integer.valueOf(TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.aoK())).requestLocationUpdates(localTencentLocationRequest, paramTencentLocationListener, paramLooper)) });
        AppMethodBeat.o(150506);
      }
    });
    AppMethodBeat.o(223570);
  }
  
  public final void bcf()
  {
    AppMethodBeat.i(150510);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150505);
        Log.d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(h.mContext, new Pair("oaId", q.aoK())).removeUpdates(null);
        AppMethodBeat.o(150505);
      }
    });
    AppMethodBeat.o(150510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelgeo.h
 * JD-Core Version:    0.7.0.1
 */