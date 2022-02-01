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
import com.tencent.tencentmap.mapsdk.maps.MapRenderLayer;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class a
  implements IMapView
{
  private MapRenderLayer SJI;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public a(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(217262);
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
      this.SJI = new MapRenderLayer(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.SJI.getMap());
      this.SJI.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(217262);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(217265);
    if (this.SJI.getMap() != null) {
      this.SJI.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(217265);
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
    return this.SJI;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(217264);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(217264);
      return localProjection;
    }
    AppMethodBeat.o(217264);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(217263);
    if (this.SJI.getMap() != null)
    {
      m localm = new m(this.SJI.getMap().getUiSettings());
      AppMethodBeat.o(217263);
      return localm;
    }
    AppMethodBeat.o(217263);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(217272);
    this.SJI.onDestroy();
    AppMethodBeat.o(217272);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(217269);
    this.SJI.onPause();
    AppMethodBeat.o(217269);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(217271);
    this.SJI.onRestart();
    AppMethodBeat.o(217271);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(217268);
    this.SJI.onResume();
    AppMethodBeat.o(217268);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(217274);
    if (this.SJI != null) {
      this.SJI.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(217274);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(217267);
    this.SJI.onStart();
    AppMethodBeat.o(217267);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(217270);
    this.SJI.onStop();
    AppMethodBeat.o(217270);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217275);
    if (this.SJI != null) {
      this.SJI.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(217275);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217273);
    boolean bool = this.SJI.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(217273);
    return bool;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(217266);
    if (this.SJI != null) {
      this.SJI.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(217266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */