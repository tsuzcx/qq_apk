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
  private MapRenderLayer Mzt;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public a(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(199911);
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
      this.Mzt = new MapRenderLayer(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.Mzt.getMap());
      this.Mzt.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(199911);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(199914);
    if (this.Mzt.getMap() != null) {
      this.Mzt.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(199914);
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
    return this.Mzt;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(199913);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(199913);
      return localProjection;
    }
    AppMethodBeat.o(199913);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(199912);
    if (this.Mzt.getMap() != null)
    {
      m localm = new m(this.Mzt.getMap().getUiSettings());
      AppMethodBeat.o(199912);
      return localm;
    }
    AppMethodBeat.o(199912);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199921);
    this.Mzt.onDestroy();
    AppMethodBeat.o(199921);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(199918);
    this.Mzt.onPause();
    AppMethodBeat.o(199918);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(199920);
    this.Mzt.onRestart();
    AppMethodBeat.o(199920);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(199917);
    this.Mzt.onResume();
    AppMethodBeat.o(199917);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199923);
    if (this.Mzt != null) {
      this.Mzt.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(199923);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(199916);
    this.Mzt.onStart();
    AppMethodBeat.o(199916);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(199919);
    this.Mzt.onStop();
    AppMethodBeat.o(199919);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199924);
    if (this.Mzt != null) {
      this.Mzt.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(199924);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199922);
    boolean bool = this.Mzt.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(199922);
    return bool;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(199915);
    if (this.Mzt != null) {
      this.Mzt.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(199915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */