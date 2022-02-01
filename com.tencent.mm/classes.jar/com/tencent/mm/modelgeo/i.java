package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationManagerOptions;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.threadpool.c.d;

public final class i
{
  private static Context mContext;
  private static i oEP = null;
  private static Boolean oER;
  private MMHandler oEQ;
  
  private i()
  {
    AppMethodBeat.i(150507);
    HandlerThread localHandlerThread = d.bFS("SLocationManager");
    localHandlerThread.start();
    this.oEQ = new MMHandler(localHandlerThread.getLooper());
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
  
  public static i dQ(Context paramContext)
  {
    AppMethodBeat.i(150508);
    if (oEP == null) {
      oEP = new i();
    }
    mContext = paramContext;
    paramContext = oEP;
    AppMethodBeat.o(150508);
    return paramContext;
  }
  
  private void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(150509);
    this.oEQ.post(paramRunnable);
    AppMethodBeat.o(150509);
  }
  
  public static boolean isOverseasUser()
  {
    AppMethodBeat.i(231725);
    if (oER != null)
    {
      bool = oER.booleanValue();
      AppMethodBeat.o(231725);
      return bool;
    }
    if (!"CN".equalsIgnoreCase(Util.nullAs((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null), "CN"))) {}
    for (boolean bool = true;; bool = false)
    {
      oER = Boolean.valueOf(bool);
      Log.i("MicroMsg.SLocationManager", "isOverseasUser: %b", new Object[] { oER });
      bool = oER.booleanValue();
      AppMethodBeat.o(231725);
      return bool;
    }
  }
  
  public final void a(final TencentLocationListener paramTencentLocationListener, final Context paramContext, final int paramInt, final Looper paramLooper)
  {
    AppMethodBeat.i(231736);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231739);
        if (!b.g(paramContext, new String[] { "android.permission.ACCESS_FINE_LOCATION" }))
        {
          Log.w("MicroMsg.SLocationManager", "no location permission, just return.");
          paramTencentLocationListener.onLocationChanged(null, -1, null);
          AppMethodBeat.o(231739);
          return;
        }
        Log.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(584L, 0L, 1L, true);
        TencentLocationManager.getInstance(i.mContext, new Pair("oaId", q.aPk())).setCoordinateType(paramInt);
        TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create();
        localTencentLocationRequest.setForeginRequest(i.isOverseasUser());
        localTencentLocationRequest.setInterval(2000L);
        localTencentLocationRequest.setAndroidId(q.getAndroidId());
        Log.i("MicroMsg.SLocationManager", "requestCode %d", new Object[] { Integer.valueOf(TencentLocationManager.getInstance(i.mContext, new Pair("oaId", q.aPk())).requestLocationUpdates(localTencentLocationRequest, paramTencentLocationListener, paramLooper)) });
        AppMethodBeat.o(231739);
      }
    });
    AppMethodBeat.o(231736);
  }
  
  public final void bJp()
  {
    AppMethodBeat.i(150510);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150505);
        Log.d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(i.mContext, new Pair("oaId", q.aPk())).removeUpdates(null);
        AppMethodBeat.o(150505);
      }
    });
    AppMethodBeat.o(150510);
  }
  
  public static final class a
    extends Exception
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelgeo.i
 * JD-Core Version:    0.7.0.1
 */