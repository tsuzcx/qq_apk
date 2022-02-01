package com.e.a.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.rastercore.LogHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class d
  implements IMapView
{
  private MapView KIR;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public d(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(205842);
    LogHelper.v("vector MapView construct function start");
    com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions = null;
    if (paramTencentMapOptions != null)
    {
      localTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      if (paramTencentMapOptions.getExtSurface() != null) {
        localTencentMapOptions.setExtSurface(paramTencentMapOptions.getExtSurface());
      }
      localTencentMapOptions.setHandDrawMapEnable(paramTencentMapOptions.isHandDrawMapEnable());
      localTencentMapOptions.setSubInfo(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localTencentMapOptions.setMultipleInfoWindowEnable(paramTencentMapOptions.isMutipleInfowindowEnabled());
    }
    this.KIR = new MapView(paramContext, localTencentMapOptions);
    this.mTencentMap = new i(this.KIR.getMap());
    this.KIR.getMap().getUiSettings().setZoomControlsEnabled(false);
    AppMethodBeat.o(205842);
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(205845);
    if (this.KIR.getMap() != null) {
      this.KIR.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(205845);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205854);
    if (this.KIR == null)
    {
      AppMethodBeat.o(205854);
      return false;
    }
    if ((this.KIR.dispatchTouchEvent(paramMotionEvent)) || (this.KIR.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(205854);
      return true;
    }
    AppMethodBeat.o(205854);
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
    return this.KIR;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(205844);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(205844);
      return localProjection;
    }
    AppMethodBeat.o(205844);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(205843);
    if (this.KIR.getMap() != null)
    {
      m localm = new m(this.KIR.getMap().getUiSettings());
      AppMethodBeat.o(205843);
      return localm;
    }
    AppMethodBeat.o(205843);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205852);
    this.KIR.onDestroy();
    AppMethodBeat.o(205852);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(205849);
    this.KIR.onPause();
    AppMethodBeat.o(205849);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(205851);
    this.KIR.onRestart();
    AppMethodBeat.o(205851);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205848);
    this.KIR.onResume();
    AppMethodBeat.o(205848);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(205855);
    if (this.KIR != null) {
      this.KIR.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(205855);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(205847);
    this.KIR.onStart();
    AppMethodBeat.o(205847);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(205850);
    this.KIR.onStop();
    AppMethodBeat.o(205850);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205856);
    if (this.KIR != null) {
      this.KIR.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(205856);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205853);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(205853);
      return true;
    }
    AppMethodBeat.o(205853);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(205846);
    if (this.KIR != null) {
      this.KIR.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(205846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */