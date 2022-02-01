package com.d.a.a.a.a;

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
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.List;

public final class d
  implements IMapView
{
  private MapView SJL;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public d(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(217299);
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
      this.SJL = new MapView(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.SJL.getMap());
      this.SJL.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(217299);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(217302);
    if (this.SJL.getMap() != null) {
      this.SJL.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(217302);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217311);
    if (this.SJL == null)
    {
      AppMethodBeat.o(217311);
      return false;
    }
    if ((this.SJL.dispatchTouchEvent(paramMotionEvent)) || (this.SJL.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(217311);
      return true;
    }
    AppMethodBeat.o(217311);
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
    return this.SJL;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(217301);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(217301);
      return localProjection;
    }
    AppMethodBeat.o(217301);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(217300);
    if (this.SJL.getMap() != null)
    {
      m localm = new m(this.SJL.getMap().getUiSettings());
      AppMethodBeat.o(217300);
      return localm;
    }
    AppMethodBeat.o(217300);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(217309);
    this.SJL.onDestroy();
    if ((this.mTencentMap instanceof i))
    {
      i locali = (i)this.mTencentMap;
      if (locali.SJV != null) {
        locali.SJV.clear();
      }
      if (locali.SJX != null) {
        locali.SJX.clear();
      }
      if (locali.SJZ != null) {
        locali.SJZ.clear();
      }
      if (locali.SKb != null) {
        locali.SKb.clear();
      }
      if (locali.SKd != null) {
        locali.SKd.clear();
      }
      if (locali.SKf != null) {
        locali.SKf.clear();
      }
      if (locali.SKh != null) {
        locali.SKh.clear();
      }
      if (locali.SKj != null) {
        locali.SKj.clear();
      }
    }
    AppMethodBeat.o(217309);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(217306);
    this.SJL.onPause();
    AppMethodBeat.o(217306);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(217308);
    this.SJL.onRestart();
    AppMethodBeat.o(217308);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(217305);
    this.SJL.onResume();
    AppMethodBeat.o(217305);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(217312);
    if (this.SJL != null) {
      this.SJL.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(217312);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(217304);
    this.SJL.onStart();
    AppMethodBeat.o(217304);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(217307);
    this.SJL.onStop();
    AppMethodBeat.o(217307);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217313);
    if (this.SJL != null) {
      this.SJL.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(217313);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217310);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(217310);
      return true;
    }
    AppMethodBeat.o(217310);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(217303);
    if (this.SJL != null) {
      this.SJL.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(217303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */