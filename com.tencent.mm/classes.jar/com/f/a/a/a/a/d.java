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
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.List;

public final class d
  implements IMapView
{
  private MapView Mzw;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public d(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(199948);
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
      this.Mzw = new MapView(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.Mzw.getMap());
      this.Mzw.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(199948);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(199951);
    if (this.Mzw.getMap() != null) {
      this.Mzw.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(199951);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199960);
    if (this.Mzw == null)
    {
      AppMethodBeat.o(199960);
      return false;
    }
    if ((this.Mzw.dispatchTouchEvent(paramMotionEvent)) || (this.Mzw.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(199960);
      return true;
    }
    AppMethodBeat.o(199960);
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
    return this.Mzw;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(199950);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(199950);
      return localProjection;
    }
    AppMethodBeat.o(199950);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(199949);
    if (this.Mzw.getMap() != null)
    {
      m localm = new m(this.Mzw.getMap().getUiSettings());
      AppMethodBeat.o(199949);
      return localm;
    }
    AppMethodBeat.o(199949);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199958);
    this.Mzw.onDestroy();
    if ((this.mTencentMap instanceof i))
    {
      i locali = (i)this.mTencentMap;
      if (locali.MzG != null) {
        locali.MzG.clear();
      }
      if (locali.MzI != null) {
        locali.MzI.clear();
      }
      if (locali.MzK != null) {
        locali.MzK.clear();
      }
      if (locali.MzM != null) {
        locali.MzM.clear();
      }
      if (locali.MzO != null) {
        locali.MzO.clear();
      }
      if (locali.MzQ != null) {
        locali.MzQ.clear();
      }
      if (locali.MzS != null) {
        locali.MzS.clear();
      }
      if (locali.MzU != null) {
        locali.MzU.clear();
      }
    }
    AppMethodBeat.o(199958);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(199955);
    this.Mzw.onPause();
    AppMethodBeat.o(199955);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(199957);
    this.Mzw.onRestart();
    AppMethodBeat.o(199957);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(199954);
    this.Mzw.onResume();
    AppMethodBeat.o(199954);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199961);
    if (this.Mzw != null) {
      this.Mzw.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(199961);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(199953);
    this.Mzw.onStart();
    AppMethodBeat.o(199953);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(199956);
    this.Mzw.onStop();
    AppMethodBeat.o(199956);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199962);
    if (this.Mzw != null) {
      this.Mzw.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(199962);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(199959);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(199959);
      return true;
    }
    AppMethodBeat.o(199959);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(199952);
    if (this.Mzw != null) {
      this.Mzw.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(199952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */