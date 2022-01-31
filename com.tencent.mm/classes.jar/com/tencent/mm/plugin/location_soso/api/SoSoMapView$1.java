package com.tencent.mm.plugin.location_soso.api;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

class SoSoMapView$1
  implements b
{
  SoSoMapView$1(SoSoMapView paramSoSoMapView) {}
  
  public void animateTo(double paramDouble1, double paramDouble2)
  {
    y.d("MicroMsg.SoSoMapView", "animteTo slat:" + paramDouble1 + " slong:" + paramDouble2);
    if (SoSoMapView.access$000(this.this$0)) {
      this.this$0.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(paramDouble1, paramDouble2)));
    }
    for (;;)
    {
      SoSoMapView.access$002(this.this$0, false);
      return;
      this.this$0.getMap().animateCamera(CameraUpdateFactory.newLatLng(new LatLng(paramDouble1, paramDouble2)));
    }
  }
  
  public void animateTo(double paramDouble1, double paramDouble2, int paramInt)
  {
    y.d("MicroMsg.SoSoMapView", "animteTo slat:" + paramDouble1 + " slong:" + paramDouble2 + " zoom:" + paramInt);
    if (SoSoMapView.access$000(this.this$0)) {
      this.this$0.getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(paramDouble1, paramDouble2), paramInt));
    }
    for (;;)
    {
      SoSoMapView.access$002(this.this$0, false);
      return;
      this.this$0.getMap().animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(paramDouble1, paramDouble2), paramInt));
    }
  }
  
  public void offsetCenter(double paramDouble1, double paramDouble2)
  {
    setCenter(this.this$0.getMapCenterX() / 1000000.0D + paramDouble1, this.this$0.getMapCenterY() / 1000000.0D + paramDouble2);
  }
  
  public void setCenter(double paramDouble1, double paramDouble2)
  {
    this.this$0.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(paramDouble1, paramDouble2)));
  }
  
  public void setZoom(int paramInt)
  {
    y.d("MicroMsg.SoSoMapView", "set Zoom %d", new Object[] { Integer.valueOf(paramInt) });
    this.this$0.getMap().moveCamera(CameraUpdateFactory.zoomTo(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.api.SoSoMapView.1
 * JD-Core Version:    0.7.0.1
 */