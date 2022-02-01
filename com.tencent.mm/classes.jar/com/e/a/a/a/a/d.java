package com.e.a.a.a.a;

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
  private MapView aalF;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public d(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(187280);
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
      this.aalF = new MapView(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.aalF.getMap());
      this.aalF.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(187280);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(187284);
    if (this.aalF.getMap() != null) {
      this.aalF.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(187284);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187294);
    if (this.aalF == null)
    {
      AppMethodBeat.o(187294);
      return false;
    }
    if ((this.aalF.dispatchTouchEvent(paramMotionEvent)) || (this.aalF.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(187294);
      return true;
    }
    AppMethodBeat.o(187294);
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
    return this.aalF;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(187283);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(187283);
      return localProjection;
    }
    AppMethodBeat.o(187283);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(187282);
    if (this.aalF.getMap() != null)
    {
      m localm = new m(this.aalF.getMap().getUiSettings());
      AppMethodBeat.o(187282);
      return localm;
    }
    AppMethodBeat.o(187282);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(187292);
    this.aalF.onDestroy();
    if ((this.mTencentMap instanceof i))
    {
      i locali = (i)this.mTencentMap;
      if (locali.aalP != null) {
        locali.aalP.clear();
      }
      if (locali.aalR != null) {
        locali.aalR.clear();
      }
      if (locali.aalT != null) {
        locali.aalT.clear();
      }
      if (locali.aalV != null) {
        locali.aalV.clear();
      }
      if (locali.aalX != null) {
        locali.aalX.clear();
      }
      if (locali.aalZ != null) {
        locali.aalZ.clear();
      }
      if (locali.aamb != null) {
        locali.aamb.clear();
      }
      if (locali.aamd != null) {
        locali.aamd.clear();
      }
    }
    AppMethodBeat.o(187292);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(187289);
    this.aalF.onPause();
    AppMethodBeat.o(187289);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(187291);
    this.aalF.onRestart();
    AppMethodBeat.o(187291);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(187288);
    this.aalF.onResume();
    AppMethodBeat.o(187288);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(187295);
    if (this.aalF != null) {
      this.aalF.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(187295);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(187287);
    this.aalF.onStart();
    AppMethodBeat.o(187287);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(187290);
    this.aalF.onStop();
    AppMethodBeat.o(187290);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187305);
    if (this.aalF != null) {
      this.aalF.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(187305);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187293);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(187293);
      return true;
    }
    AppMethodBeat.o(187293);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(187285);
    if (this.aalF != null) {
      this.aalF.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(187285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */