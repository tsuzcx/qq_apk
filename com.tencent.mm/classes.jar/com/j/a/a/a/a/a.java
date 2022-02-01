package com.j.a.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.rastercore.LogHelper;
import com.tencent.mapsdk.rastercore.MapProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.maps.MapRenderLayer;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class a
  implements IMapView
{
  private MapRenderLayer airp;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public a(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(207012);
    LogHelper.v("VecotrMapRenderLayer construct function start");
    com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions1;
    if (paramTencentMapOptions != null)
    {
      com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions2 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      localTencentMapOptions2.setCustomCacheRootPath(MapProvider.getMapSdkPath());
      if (paramTencentMapOptions.getExtSurface() != null)
      {
        localTencentMapOptions2.setExtSurface(paramTencentMapOptions.getExtSurface());
        localTencentMapOptions2.setExtSurfaceDimension(paramTencentMapOptions.getExtSurfaceWidth(), paramTencentMapOptions.getExtSurfaceHeight());
      }
      localTencentMapOptions2.setHandDrawMapEnable(paramTencentMapOptions.isHandDrawMapEnable());
      localTencentMapOptions2.setSubInfo(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localTencentMapOptions2.setMultipleInfoWindowEnable(paramTencentMapOptions.isMutipleInfowindowEnabled());
      localTencentMapOptions1 = localTencentMapOptions2;
      if (paramTencentMapOptions.getProtocolDataDesc() != null)
      {
        localTencentMapOptions2.setServiceProtocol(paramTencentMapOptions.getProtocolFrom(), paramTencentMapOptions.getProtocolDataDesc());
        localTencentMapOptions1 = localTencentMapOptions2;
      }
    }
    for (;;)
    {
      this.airp = new MapRenderLayer(paramContext, localTencentMapOptions1);
      this.mTencentMap = new i(this.airp.getMap());
      this.airp.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(207012);
      return;
      localTencentMapOptions1 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      localTencentMapOptions1.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(207095);
    if (this.airp.getMap() != null) {
      this.airp.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.d(paramLayoutParams.point)));
    }
    AppMethodBeat.o(207095);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207274);
    if (this.airp == null)
    {
      AppMethodBeat.o(207274);
      return false;
    }
    if ((this.airp.dispatchTouchEvent(paramMotionEvent)) || (this.airp.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(207274);
      return true;
    }
    AppMethodBeat.o(207274);
    return false;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.TencentMap getMap()
  {
    return this.mTencentMap;
  }
  
  public final MapController getMapController()
  {
    return this.mTencentMap;
  }
  
  public final View getMapView()
  {
    return this.airp;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(207060);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(207060);
      return localProjection;
    }
    AppMethodBeat.o(207060);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(207046);
    if (this.airp.getMap() != null)
    {
      m localm = new m(this.airp.getMap().getUiSettings());
      AppMethodBeat.o(207046);
      return localm;
    }
    AppMethodBeat.o(207046);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(207231);
    this.airp.onDestroy();
    AppMethodBeat.o(207231);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(207177);
    this.airp.onPause();
    AppMethodBeat.o(207177);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(207211);
    this.airp.onRestart();
    AppMethodBeat.o(207211);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(207161);
    this.airp.onResume();
    AppMethodBeat.o(207161);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(207285);
    if (this.airp != null) {
      this.airp.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(207285);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(207147);
    this.airp.onStart();
    AppMethodBeat.o(207147);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(207198);
    this.airp.onStop();
    AppMethodBeat.o(207198);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207294);
    if (this.airp != null) {
      this.airp.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(207294);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207262);
    boolean bool = this.airp.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(207262);
    return bool;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(207112);
    if (this.airp != null) {
      this.airp.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(207112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */