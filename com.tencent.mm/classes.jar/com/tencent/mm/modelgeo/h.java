package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class h
{
  private static h fCq = null;
  private static Context mContext;
  
  private h()
  {
    AppMethodBeat.i(151559);
    TencentExtraKeys.setContext(ah.getContext());
    try
    {
      TencentExtraKeys.setTencentLogCallback(new h.1(this));
      AppMethodBeat.o(151559);
      return;
    }
    catch (Exception localException)
    {
      ab.b("MicroMsg.SLocationManager", "", new Object[] { localException });
      AppMethodBeat.o(151559);
    }
  }
  
  public static h cd(Context paramContext)
  {
    AppMethodBeat.i(78148);
    if (fCq == null) {
      fCq = new h();
    }
    mContext = paramContext;
    paramContext = fCq;
    AppMethodBeat.o(78148);
    return paramContext;
  }
  
  private static void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(151560);
    d.ysm.b(paramRunnable, "SLocationManager");
    AppMethodBeat.o(151560);
  }
  
  public final void a(final TencentLocationListener paramTencentLocationListener, final int paramInt, final Looper paramLooper)
  {
    AppMethodBeat.i(78150);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151558);
        ab.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()) });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(584L, 0L, 1L, true);
        TencentLocationManager.getInstance(h.mContext).setCoordinateType(paramInt);
        TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create();
        localTencentLocationRequest.setInterval(2000L);
        ab.i("MicroMsg.SLocationManager", "requestCode %d", new Object[] { Integer.valueOf(TencentLocationManager.getInstance(h.mContext).requestLocationUpdates(localTencentLocationRequest, paramTencentLocationListener, paramLooper)) });
        AppMethodBeat.o(151558);
      }
    });
    AppMethodBeat.o(78150);
  }
  
  public final void agV()
  {
    AppMethodBeat.i(78149);
    execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151557);
        ab.d("MicroMsg.SLocationManager", "removeUpdate");
        TencentLocationManager.getInstance(h.mContext).removeUpdates(null);
        AppMethodBeat.o(151557);
      }
    });
    AppMethodBeat.o(78149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelgeo.h
 * JD-Core Version:    0.7.0.1
 */