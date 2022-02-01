package com.j.a.a.a.a;

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
  private MapView airs;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public d(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(207010);
    LogHelper.v("vector MapView construct function start");
    com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions1;
    if (paramTencentMapOptions != null)
    {
      com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions2 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      localTencentMapOptions2.setCustomCacheRootPath(MapProvider.getMapSdkPath());
      if (paramTencentMapOptions.getExtSurface() != null) {
        localTencentMapOptions2.setExtSurface(paramTencentMapOptions.getExtSurface());
      }
      localTencentMapOptions2.setHandDrawMapEnable(paramTencentMapOptions.isHandDrawMapEnable());
      localTencentMapOptions2.setSubInfo(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localTencentMapOptions2.setMultipleInfoWindowEnable(paramTencentMapOptions.isMutipleInfowindowEnabled());
      localTencentMapOptions1 = localTencentMapOptions2;
      if (paramTencentMapOptions.getProtocolDataDesc() != null)
      {
        localTencentMapOptions2.setServiceProtocol(paramTencentMapOptions.getProtocolFrom(), paramTencentMapOptions.getProtocolDataDesc());
        localTencentMapOptions1 = localTencentMapOptions2;
      }
    }
    for (;;)
    {
      this.airs = new MapView(paramContext, localTencentMapOptions1);
      this.mTencentMap = new i(this.airs.getMap());
      this.airs.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(207010);
      return;
      localTencentMapOptions1 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      localTencentMapOptions1.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(207047);
    if (this.airs.getMap() != null) {
      this.airs.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.d(paramLayoutParams.point)));
    }
    AppMethodBeat.o(207047);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207171);
    if (this.airs == null)
    {
      AppMethodBeat.o(207171);
      return false;
    }
    if ((this.airs.dispatchTouchEvent(paramMotionEvent)) || (this.airs.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(207171);
      return true;
    }
    AppMethodBeat.o(207171);
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
    return this.airs;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(207032);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(207032);
      return localProjection;
    }
    AppMethodBeat.o(207032);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(207025);
    if (this.airs.getMap() != null)
    {
      m localm = new m(this.airs.getMap().getUiSettings());
      AppMethodBeat.o(207025);
      return localm;
    }
    AppMethodBeat.o(207025);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(207136);
    this.airs.onDestroy();
    if ((this.mTencentMap instanceof i))
    {
      i locali = (i)this.mTencentMap;
      if (locali.airC != null) {
        locali.airC.clear();
      }
      if (locali.airE != null) {
        locali.airE.clear();
      }
      if (locali.airG != null) {
        locali.airG.clear();
      }
      if (locali.airI != null) {
        locali.airI.clear();
      }
      if (locali.airK != null) {
        locali.airK.clear();
      }
      if (locali.airM != null) {
        locali.airM.clear();
      }
      if (locali.airO != null) {
        locali.airO.clear();
      }
      if (locali.airQ != null) {
        locali.airQ.clear();
      }
    }
    AppMethodBeat.o(207136);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(207096);
    this.airs.onPause();
    AppMethodBeat.o(207096);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(207117);
    this.airs.onRestart();
    AppMethodBeat.o(207117);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(207085);
    this.airs.onResume();
    AppMethodBeat.o(207085);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(207183);
    if (this.airs != null) {
      this.airs.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(207183);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(207075);
    this.airs.onStart();
    AppMethodBeat.o(207075);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(207107);
    this.airs.onStop();
    AppMethodBeat.o(207107);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207194);
    if (this.airs != null) {
      this.airs.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(207194);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207160);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(207160);
      return true;
    }
    AppMethodBeat.o(207160);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(207058);
    if (this.airs != null) {
      this.airs.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(207058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */