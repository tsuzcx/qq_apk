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
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class j
  implements IMapView
{
  private TextureMapView MXj;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public j(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(212856);
    LogHelper.v("vector MapView construct function start");
    if (paramTencentMapOptions != null)
    {
      com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      localTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
      if (paramTencentMapOptions.getExtSurface() != null) {
        localTencentMapOptions.setExtSurface(paramTencentMapOptions.getExtSurface());
      }
      localTencentMapOptions.setHandDrawMapEnable(paramTencentMapOptions.isHandDrawMapEnable());
      localTencentMapOptions.setSubInfo(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localTencentMapOptions.setMultipleInfoWindowEnable(paramTencentMapOptions.isMutipleInfowindowEnabled());
      paramTencentMapOptions = localTencentMapOptions;
    }
    for (;;)
    {
      this.MXj = new TextureMapView(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.MXj.getMap());
      this.MXj.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(212856);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(212859);
    if (this.MXj.getMap() != null) {
      this.MXj.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(212859);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212868);
    if (this.MXj == null)
    {
      AppMethodBeat.o(212868);
      return false;
    }
    if ((this.MXj.dispatchTouchEvent(paramMotionEvent)) || (this.MXj.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(212868);
      return true;
    }
    AppMethodBeat.o(212868);
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
    return this.MXj;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(212858);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(212858);
      return localProjection;
    }
    AppMethodBeat.o(212858);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(212857);
    if (this.MXj.getMap() != null)
    {
      m localm = new m(this.MXj.getMap().getUiSettings());
      AppMethodBeat.o(212857);
      return localm;
    }
    AppMethodBeat.o(212857);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212866);
    this.MXj.onDestroy();
    AppMethodBeat.o(212866);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(212863);
    this.MXj.onPause();
    AppMethodBeat.o(212863);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(212865);
    this.MXj.onRestart();
    AppMethodBeat.o(212865);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212862);
    this.MXj.onResume();
    AppMethodBeat.o(212862);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(212869);
    if (this.MXj != null) {
      this.MXj.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(212869);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(212861);
    this.MXj.onStart();
    AppMethodBeat.o(212861);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(212864);
    this.MXj.onStop();
    AppMethodBeat.o(212864);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212870);
    if (this.MXj != null) {
      this.MXj.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(212870);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212867);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(212867);
      return true;
    }
    AppMethodBeat.o(212867);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(212860);
    if (this.MXj != null) {
      this.MXj.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(212860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */