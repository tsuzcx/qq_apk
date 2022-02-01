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
  private TextureMapView MAc;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public j(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(200162);
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
      this.MAc = new TextureMapView(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.MAc.getMap());
      this.MAc.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(200162);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200165);
    if (this.MAc.getMap() != null) {
      this.MAc.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(200165);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200174);
    if (this.MAc == null)
    {
      AppMethodBeat.o(200174);
      return false;
    }
    if ((this.MAc.dispatchTouchEvent(paramMotionEvent)) || (this.MAc.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(200174);
      return true;
    }
    AppMethodBeat.o(200174);
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
    return this.MAc;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(200164);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(200164);
      return localProjection;
    }
    AppMethodBeat.o(200164);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(200163);
    if (this.MAc.getMap() != null)
    {
      m localm = new m(this.MAc.getMap().getUiSettings());
      AppMethodBeat.o(200163);
      return localm;
    }
    AppMethodBeat.o(200163);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200172);
    this.MAc.onDestroy();
    AppMethodBeat.o(200172);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(200169);
    this.MAc.onPause();
    AppMethodBeat.o(200169);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(200171);
    this.MAc.onRestart();
    AppMethodBeat.o(200171);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200168);
    this.MAc.onResume();
    AppMethodBeat.o(200168);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200175);
    if (this.MAc != null) {
      this.MAc.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(200175);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(200167);
    this.MAc.onStart();
    AppMethodBeat.o(200167);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(200170);
    this.MAc.onStop();
    AppMethodBeat.o(200170);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200176);
    if (this.MAc != null) {
      this.MAc.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(200176);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200173);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(200173);
      return true;
    }
    AppMethodBeat.o(200173);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200166);
    if (this.MAc != null) {
      this.MAc.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(200166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */