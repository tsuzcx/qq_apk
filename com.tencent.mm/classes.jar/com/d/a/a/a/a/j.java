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
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class j
  implements IMapView
{
  private TextureMapView SKr;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public j(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(217516);
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
      this.SKr = new TextureMapView(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.SKr.getMap());
      this.SKr.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(217516);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(217519);
    if (this.SKr.getMap() != null) {
      this.SKr.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(217519);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217528);
    if (this.SKr == null)
    {
      AppMethodBeat.o(217528);
      return false;
    }
    if ((this.SKr.dispatchTouchEvent(paramMotionEvent)) || (this.SKr.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(217528);
      return true;
    }
    AppMethodBeat.o(217528);
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
    return this.SKr;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(217518);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(217518);
      return localProjection;
    }
    AppMethodBeat.o(217518);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(217517);
    if (this.SKr.getMap() != null)
    {
      m localm = new m(this.SKr.getMap().getUiSettings());
      AppMethodBeat.o(217517);
      return localm;
    }
    AppMethodBeat.o(217517);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(217526);
    this.SKr.onDestroy();
    AppMethodBeat.o(217526);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(217523);
    this.SKr.onPause();
    AppMethodBeat.o(217523);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(217525);
    this.SKr.onRestart();
    AppMethodBeat.o(217525);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(217522);
    this.SKr.onResume();
    AppMethodBeat.o(217522);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(217529);
    if (this.SKr != null) {
      this.SKr.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(217529);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(217521);
    this.SKr.onStart();
    AppMethodBeat.o(217521);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(217524);
    this.SKr.onStop();
    AppMethodBeat.o(217524);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217530);
    if (this.SKr != null) {
      this.SKr.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(217530);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217527);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(217527);
      return true;
    }
    AppMethodBeat.o(217527);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(217520);
    if (this.SKr != null) {
      this.SKr.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(217520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */