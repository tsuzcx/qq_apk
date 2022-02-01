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
import com.tencent.tencentmap.mapsdk.maps.MapRenderLayer;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class a
  implements IMapView
{
  private MapRenderLayer KIO;
  private com.tencent.tencentmap.mapsdk.map.TencentMap mTencentMap;
  
  public a(Context paramContext, com.tencent.tencentmap.mapsdk.map.TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(205805);
    LogHelper.v("VecotrMapRenderLayer construct function start");
    com.tencent.tencentmap.mapsdk.maps.TencentMapOptions localTencentMapOptions = null;
    if (paramTencentMapOptions != null)
    {
      localTencentMapOptions = new com.tencent.tencentmap.mapsdk.maps.TencentMapOptions();
      if (paramTencentMapOptions.getExtSurface() != null)
      {
        localTencentMapOptions.setExtSurface(paramTencentMapOptions.getExtSurface());
        localTencentMapOptions.setExtSurfaceDimension(paramTencentMapOptions.getExtSurfaceWidth(), paramTencentMapOptions.getExtSurfaceHeight());
      }
      localTencentMapOptions.setHandDrawMapEnable(paramTencentMapOptions.isHandDrawMapEnable());
      localTencentMapOptions.setSubInfo(paramTencentMapOptions.getSubKey(), paramTencentMapOptions.getSubId());
      localTencentMapOptions.setMultipleInfoWindowEnable(paramTencentMapOptions.isMutipleInfowindowEnabled());
    }
    this.KIO = new MapRenderLayer(paramContext, localTencentMapOptions);
    this.mTencentMap = new i(this.KIO.getMap());
    this.KIO.getMap().getUiSettings().setZoomControlsEnabled(false);
    AppMethodBeat.o(205805);
  }
  
  public final void addView(View paramView, MapView.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(205808);
    if (this.KIO.getMap() != null) {
      this.KIO.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(paramView)).position(l.c(paramLayoutParams.point)));
    }
    AppMethodBeat.o(205808);
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
    return this.KIO;
  }
  
  public final Projection getProjection()
  {
    AppMethodBeat.i(205807);
    if (getMap() != null)
    {
      Projection localProjection = getMap().getProjection();
      AppMethodBeat.o(205807);
      return localProjection;
    }
    AppMethodBeat.o(205807);
    return null;
  }
  
  public final com.tencent.tencentmap.mapsdk.map.UiSettings getUiSettings()
  {
    AppMethodBeat.i(205806);
    if (this.KIO.getMap() != null)
    {
      m localm = new m(this.KIO.getMap().getUiSettings());
      AppMethodBeat.o(205806);
      return localm;
    }
    AppMethodBeat.o(205806);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205815);
    this.KIO.onDestroy();
    AppMethodBeat.o(205815);
  }
  
  public final void onDestroyView() {}
  
  public final void onLowMemory() {}
  
  public final void onPause()
  {
    AppMethodBeat.i(205812);
    this.KIO.onPause();
    AppMethodBeat.o(205812);
  }
  
  public final void onRestart()
  {
    AppMethodBeat.i(205814);
    this.KIO.onRestart();
    AppMethodBeat.o(205814);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205811);
    this.KIO.onResume();
    AppMethodBeat.o(205811);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(205817);
    if (this.KIO != null) {
      this.KIO.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(205817);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(205810);
    this.KIO.onStart();
    AppMethodBeat.o(205810);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(205813);
    this.KIO.onStop();
    AppMethodBeat.o(205813);
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205818);
    if (this.KIO != null) {
      this.KIO.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(205818);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205816);
    boolean bool = this.KIO.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(205816);
    return bool;
  }
  
  public final void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(205809);
    if (this.KIO != null) {
      this.KIO.updateViewLayout(paramView, paramLayoutParams);
    }
    AppMethodBeat.o(205809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */