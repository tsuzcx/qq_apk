package com.f.a.a.a.a;

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
  private MapRenderLayer MWA;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public a(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(212603);
    LogHelper.v("VecotrMapRenderLayer construct function start");
    if (paramTencentMapOptions != null)
    {
      com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      localTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
      if (paramTencentMapOptions.getExtSurface() != null)
      {
        localTencentMapOptions.setExtSurface(paramTencentMapOptions.getExtSurface());
        localTencentMapOptions.setExtSurfaceDimension(paramTencentMapOptions.getExtSurfaceWidth(), paramTencentMapOptions.getExtSurfaceHeight());
      }
      localTencentMapOptions.setHandDrawMapEnable(paramTencentMapOptions.isHandDrawMapEnable());
      localTencentMapOptions.setSubInfo(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localTencentMapOptions.setMultipleInfoWindowEnable(paramTencentMapOptions.isMutipleInfowindowEnabled());
      paramTencentMapOptions = localTencentMapOptions;
    }
    for (;;)
    {
      this.MWA = new MapRenderLayer(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.MWA.getMap());
      this.MWA.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(212603);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(212606);
    if (this.MWA.getMap() != null) {
      this.MWA.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(212606);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
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
    return this.MWA;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(212605);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(212605);
      return localProjection;
    }
    AppMethodBeat.o(212605);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(212604);
    if (this.MWA.getMap() != null)
    {
      m localm = new m(this.MWA.getMap().getUiSettings());
      AppMethodBeat.o(212604);
      return localm;
    }
    AppMethodBeat.o(212604);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212613);
    this.MWA.onDestroy();
    AppMethodBeat.o(212613);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(212610);
    this.MWA.onPause();
    AppMethodBeat.o(212610);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(212612);
    this.MWA.onRestart();
    AppMethodBeat.o(212612);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212609);
    this.MWA.onResume();
    AppMethodBeat.o(212609);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(212615);
    if (this.MWA != null) {
      this.MWA.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(212615);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(212608);
    this.MWA.onStart();
    AppMethodBeat.o(212608);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(212611);
    this.MWA.onStop();
    AppMethodBeat.o(212611);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212616);
    if (this.MWA != null) {
      this.MWA.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(212616);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212614);
    boolean bool = this.MWA.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(212614);
    return bool;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(212607);
    if (this.MWA != null) {
      this.MWA.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(212607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */