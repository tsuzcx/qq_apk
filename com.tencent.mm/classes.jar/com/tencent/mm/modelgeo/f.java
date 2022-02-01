package com.tencent.mm.modelgeo;

import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public abstract class f
  implements TencentLocationListener
{
  private final Map<String, Integer> hXX = new HashMap();
  
  public f()
  {
    this.hXX.put("gps", Integer.valueOf(0));
    this.hXX.put("network", Integer.valueOf(1));
  }
  
  public void a(boolean paramBoolean, double paramDouble1, double paramDouble2, int paramInt1, double paramDouble3, double paramDouble4, double paramDouble5, String paramString1, String paramString2, int paramInt2) {}
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    ad.i("MicroMsg.SLocationListener", "lat=%f, lng=%f, accuracy=%f errcode=%d, areastat=%d, speed=%f, bearing=%f, reason=%s, provider=%s", new Object[] { Double.valueOf(paramTencentLocation.getLatitude()), Double.valueOf(paramTencentLocation.getLongitude()), Float.valueOf(paramTencentLocation.getAccuracy()), Integer.valueOf(paramInt), paramTencentLocation.getAreaStat(), Float.valueOf(paramTencentLocation.getSpeed()), Float.valueOf(paramTencentLocation.getBearing()), paramString, paramTencentLocation.getProvider() });
    if (paramInt == 0)
    {
      g.yhR.idkeyStat(584L, 1L, 1L, true);
      a(true, paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude(), ((Integer)this.hXX.get(paramTencentLocation.getProvider())).intValue(), paramTencentLocation.getSpeed(), paramTencentLocation.getAccuracy(), paramTencentLocation.getAltitude(), paramTencentLocation.getIndoorBuildingId(), paramTencentLocation.getIndoorBuildingFloor(), paramTencentLocation.getIndoorLocationType());
      return;
    }
    g.yhR.idkeyStat(584L, 2L, 1L, true);
    if (paramInt == 1) {
      g.yhR.idkeyStat(584L, 3L, 1L, true);
    }
    for (;;)
    {
      a(false, paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude(), ((Integer)this.hXX.get(paramTencentLocation.getProvider())).intValue(), paramTencentLocation.getSpeed(), paramTencentLocation.getAccuracy(), paramTencentLocation.getAltitude(), paramTencentLocation.getIndoorBuildingId(), paramTencentLocation.getIndoorBuildingFloor(), paramTencentLocation.getIndoorLocationType());
      return;
      if (paramInt == 4) {
        g.yhR.idkeyStat(584L, 4L, 1L, true);
      }
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    ad.d("MicroMsg.SLocationListener", "onStatusUpdate, name=%s, status=%d, desc=%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelgeo.f
 * JD-Core Version:    0.7.0.1
 */