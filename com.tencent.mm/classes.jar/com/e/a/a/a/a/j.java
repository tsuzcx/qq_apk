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
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class j
  implements IMapView
{
  private TextureMapView aaml;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public j(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(186703);
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
      this.aaml = new TextureMapView(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.aaml.getMap());
      this.aaml.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(186703);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186711);
    if (this.aaml.getMap() != null) {
      this.aaml.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(186711);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186746);
    if (this.aaml == null)
    {
      AppMethodBeat.o(186746);
      return false;
    }
    if ((this.aaml.dispatchTouchEvent(paramMotionEvent)) || (this.aaml.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(186746);
      return true;
    }
    AppMethodBeat.o(186746);
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
    return this.aaml;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(186707);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(186707);
      return localProjection;
    }
    AppMethodBeat.o(186707);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(186706);
    if (this.aaml.getMap() != null)
    {
      m localm = new m(this.aaml.getMap().getUiSettings());
      AppMethodBeat.o(186706);
      return localm;
    }
    AppMethodBeat.o(186706);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186741);
    this.aaml.onDestroy();
    AppMethodBeat.o(186741);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(186726);
    this.aaml.onPause();
    AppMethodBeat.o(186726);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(186738);
    this.aaml.onRestart();
    AppMethodBeat.o(186738);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(186724);
    this.aaml.onResume();
    AppMethodBeat.o(186724);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186748);
    if (this.aaml != null) {
      this.aaml.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(186748);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(186722);
    this.aaml.onStart();
    AppMethodBeat.o(186722);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(186728);
    this.aaml.onStop();
    AppMethodBeat.o(186728);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186749);
    if (this.aaml != null) {
      this.aaml.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(186749);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186744);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(186744);
      return true;
    }
    AppMethodBeat.o(186744);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186715);
    if (this.aaml != null) {
      this.aaml.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(186715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */