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
import com.tencent.tencentmap.mapsdk.maps.MapRenderLayer;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class a
  implements IMapView
{
  private MapRenderLayer aalC;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public a(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(186874);
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
      this.aalC = new MapRenderLayer(paramContext, paramTencentMapOptions);
      this.mTencentMap = new i(this.aalC.getMap());
      this.aalC.getMap().getUiSettings().setZoomControlsEnabled(false);
      AppMethodBeat.o(186874);
      return;
      paramTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      paramTencentMapOptions.setCustomCacheRootPath(MapProvider.getMapSdkPath());
    }
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186884);
    if (this.aalC.getMap() != null) {
      this.aalC.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(186884);
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
    return this.aalC;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(186879);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(186879);
      return localProjection;
    }
    AppMethodBeat.o(186879);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(186878);
    if (this.aalC.getMap() != null)
    {
      m localm = new m(this.aalC.getMap().getUiSettings());
      AppMethodBeat.o(186878);
      return localm;
    }
    AppMethodBeat.o(186878);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(186899);
    this.aalC.onDestroy();
    AppMethodBeat.o(186899);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(186891);
    this.aalC.onPause();
    AppMethodBeat.o(186891);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(186895);
    this.aalC.onRestart();
    AppMethodBeat.o(186895);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(186889);
    this.aalC.onResume();
    AppMethodBeat.o(186889);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186907);
    if (this.aalC != null) {
      this.aalC.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(186907);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(186887);
    this.aalC.onStart();
    AppMethodBeat.o(186887);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(186894);
    this.aalC.onStop();
    AppMethodBeat.o(186894);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186910);
    if (this.aalC != null) {
      this.aalC.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(186910);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186901);
    boolean bool = this.aalC.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(186901);
    return bool;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(186885);
    if (this.aalC != null) {
      this.aalC.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(186885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */