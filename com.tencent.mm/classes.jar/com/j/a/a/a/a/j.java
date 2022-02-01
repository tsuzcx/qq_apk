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
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class j
  implements IMapView
{
  private TextureMapView airY;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public j(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(207057);
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
      this.airY = new TextureMapView(paramContext, localTencentMapOptions1);
      this.mTencentMap = new i(this.airY.getMap());
      this.airY.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(207057);
      return;
      localTencentMapOptions1 = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      localTencentMapOptions1.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(207124);
    if (this.airY.getMap() != null) {
      this.airY.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.d(paramLayoutParams.point)));
    }
    AppMethodBeat.o(207124);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207236);
    if (this.airY == null)
    {
      AppMethodBeat.o(207236);
      return false;
    }
    if ((this.airY.dispatchTouchEvent(paramMotionEvent)) || (this.airY.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(207236);
      return true;
    }
    AppMethodBeat.o(207236);
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
    return this.airY;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(207100);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(207100);
      return localProjection;
    }
    AppMethodBeat.o(207100);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(207088);
    if (this.airY.getMap() != null)
    {
      m localm = new m(this.airY.getMap().getUiSettings());
      AppMethodBeat.o(207088);
      return localm;
    }
    AppMethodBeat.o(207088);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(207208);
    this.airY.onDestroy();
    AppMethodBeat.o(207208);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(207173);
    this.airY.onPause();
    AppMethodBeat.o(207173);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(207192);
    this.airY.onRestart();
    AppMethodBeat.o(207192);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(207163);
    this.airY.onResume();
    AppMethodBeat.o(207163);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(207240);
    if (this.airY != null) {
      this.airY.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(207240);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(207153);
    this.airY.onStart();
    AppMethodBeat.o(207153);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(207185);
    this.airY.onStop();
    AppMethodBeat.o(207185);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207247);
    if (this.airY != null) {
      this.airY.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(207247);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(207230);
    if (paramMotionEvent.getAction() == 0)
    {
      AppMethodBeat.o(207230);
      return true;
    }
    AppMethodBeat.o(207230);
    return false;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(207135);
    if (this.airY != null) {
      this.airY.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(207135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */