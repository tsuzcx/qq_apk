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
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class j
  implements IMapView
{
  private TextureMapView KJp;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public j(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(206039);
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
    this.KJp = new TextureMapView(paramContext, localTencentMapOptions);
    this.mTencentMap = new i(this.KJp.getMap());
    this.KJp.getMap().getUiSettings().setZoomControlsEnabled(false);
    AppMethodBeat.o(206039);
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(206042);
    if (this.KJp.getMap() != null) {
      this.KJp.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(206042);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206051);
    if (this.KJp == null)
    {
      AppMethodBeat.o(206051);
      return false;
    }
    if ((this.KJp.dispatchTouchEvent(paramMotionEvent)) || (this.KJp.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(206051);
      return true;
    }
    AppMethodBeat.o(206051);
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
    return this.KJp;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(206041);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(206041);
      return localProjection;
    }
    AppMethodBeat.o(206041);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(206040);
    if (this.KJp.getMap() != null)
    {
      m localm = new m(this.KJp.getMap().getUiSettings());
      AppMethodBeat.o(206040);
      return localm;
    }
    AppMethodBeat.o(206040);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206049);
    this.KJp.onDestroy();
    AppMethodBeat.o(206049);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(206046);
    this.KJp.onPause();
    AppMethodBeat.o(206046);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(206048);
    this.KJp.onRestart();
    AppMethodBeat.o(206048);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206045);
    this.KJp.onResume();
    AppMethodBeat.o(206045);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(206052);
    if (this.KJp != null) {
      this.KJp.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(206052);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(206044);
    this.KJp.onStart();
    AppMethodBeat.o(206044);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(206047);
    this.KJp.onStop();
    AppMethodBeat.o(206047);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206053);
    if (this.KJp != null) {
      this.KJp.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(206053);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206050);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(206050);
      return true;
    }
    AppMethodBeat.o(206050);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(206043);
    if (this.KJp != null) {
      this.KJp.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(206043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */