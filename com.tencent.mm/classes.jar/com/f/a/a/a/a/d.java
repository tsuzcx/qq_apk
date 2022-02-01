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
  private MapView MWD;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public d(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(212640);
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
      this.MWD = new MapView(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.MWD.getMap());
      this.MWD.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(212640);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(212643);
    if (this.MWD.getMap() != null) {
      this.MWD.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(212643);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212652);
    if (this.MWD == null)
    {
      AppMethodBeat.o(212652);
      return false;
    }
    if ((this.MWD.dispatchTouchEvent(paramMotionEvent)) || (this.MWD.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(212652);
      return true;
    }
    AppMethodBeat.o(212652);
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
    return this.MWD;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(212642);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(212642);
      return localProjection;
    }
    AppMethodBeat.o(212642);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(212641);
    if (this.MWD.getMap() != null)
    {
      m localm = new m(this.MWD.getMap().getUiSettings());
      AppMethodBeat.o(212641);
      return localm;
    }
    AppMethodBeat.o(212641);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212650);
    this.MWD.onDestroy();
    if ((this.mTencentMap instanceof i))
    {
      i locali = (i)this.mTencentMap;
      if (locali.MWN != null) {
        locali.MWN.clear();
      }
      if (locali.MWP != null) {
        locali.MWP.clear();
      }
      if (locali.MWR != null) {
        locali.MWR.clear();
      }
      if (locali.MWT != null) {
        locali.MWT.clear();
      }
      if (locali.MWV != null) {
        locali.MWV.clear();
      }
      if (locali.MWX != null) {
        locali.MWX.clear();
      }
      if (locali.MWZ != null) {
        locali.MWZ.clear();
      }
      if (locali.MXb != null) {
        locali.MXb.clear();
      }
    }
    AppMethodBeat.o(212650);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(212647);
    this.MWD.onPause();
    AppMethodBeat.o(212647);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(212649);
    this.MWD.onRestart();
    AppMethodBeat.o(212649);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212646);
    this.MWD.onResume();
    AppMethodBeat.o(212646);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(212653);
    if (this.MWD != null) {
      this.MWD.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(212653);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(212645);
    this.MWD.onStart();
    AppMethodBeat.o(212645);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(212648);
    this.MWD.onStop();
    AppMethodBeat.o(212648);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(212654);
    if (this.MWD != null) {
      this.MWD.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(212654);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(212651);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(212651);
      return true;
    }
    AppMethodBeat.o(212651);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(212644);
    if (this.MWD != null) {
      this.MWD.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(212644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */