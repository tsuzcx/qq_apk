package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class g
{
  private static g elY = null;
  private static Context mContext;
  
  public static void Og()
  {
    y.d("MicroMsg.SLocationManager", "removeUpdate");
    TencentLocationManager.getInstance(mContext).removeUpdates(null);
  }
  
  public static void a(TencentLocationListener paramTencentLocationListener, int paramInt, Looper paramLooper)
  {
    y.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()) });
    h.nFQ.a(584L, 0L, 1L, true);
    TencentLocationManager.getInstance(mContext).setCoordinateType(paramInt);
    TencentLocationRequest localTencentLocationRequest = TencentLocationRequest.create();
    localTencentLocationRequest.setInterval(2000L);
    y.i("MicroMsg.SLocationManager", "requestCode %d", new Object[] { Integer.valueOf(TencentLocationManager.getInstance(mContext).requestLocationUpdates(localTencentLocationRequest, paramTencentLocationListener, paramLooper)) });
  }
  
  public static g by(Context paramContext)
  {
    if (elY == null) {
      elY = new g();
    }
    mContext = paramContext;
    return elY;
  }
  
  public static final class a
    extends Exception
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelgeo.g
 * JD-Core Version:    0.7.0.1
 */