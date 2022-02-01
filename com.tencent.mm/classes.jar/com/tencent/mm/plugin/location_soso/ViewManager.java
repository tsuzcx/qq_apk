package com.tencent.mm.plugin.location_soso;

import android.graphics.Color;
import android.view.View;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.q.e;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import java.util.HashMap;
import java.util.Map;

public class ViewManager
  implements e
{
  private Map<Marker, TencentMap.OnInfoWindowClickListener> mInfoWindowClickMap;
  private Map<Marker, TencentMap.OnMarkerClickListener> mMarkerClickMap;
  private Map<View, Marker> mMarkerMap;
  private TencentMap mTencentMap;
  
  public ViewManager(TencentMap paramTencentMap)
  {
    AppMethodBeat.i(146603);
    this.mTencentMap = paramTencentMap;
    this.mMarkerMap = new HashMap();
    this.mMarkerClickMap = new HashMap();
    this.mInfoWindowClickMap = new HashMap();
    this.mTencentMap.setOnMarkerClickListener(new TencentMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(146601);
        TencentMap.OnMarkerClickListener localOnMarkerClickListener = (TencentMap.OnMarkerClickListener)ViewManager.this.mMarkerClickMap.get(paramAnonymousMarker);
        if (localOnMarkerClickListener != null)
        {
          boolean bool = localOnMarkerClickListener.onMarkerClick(paramAnonymousMarker);
          AppMethodBeat.o(146601);
          return bool;
        }
        AppMethodBeat.o(146601);
        return false;
      }
    });
    this.mTencentMap.setOnInfoWindowClickListener(new TencentMap.OnInfoWindowClickListener()
    {
      public void onInfoWindowClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(146602);
        TencentMap.OnInfoWindowClickListener localOnInfoWindowClickListener = (TencentMap.OnInfoWindowClickListener)ViewManager.this.mInfoWindowClickMap.get(paramAnonymousMarker);
        if (localOnInfoWindowClickListener != null) {
          localOnInfoWindowClickListener.onInfoWindowClick(paramAnonymousMarker);
        }
        AppMethodBeat.o(146602);
      }
    });
    AppMethodBeat.o(146603);
  }
  
  public void addPinView(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146605);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146605);
      return;
    }
    Marker localMarker = this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(paramDouble1, paramDouble2)).anchor(0.5F, 0.5F).markerView(paramView));
    this.mMarkerMap.put(paramView, localMarker);
    AppMethodBeat.o(146605);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(146604);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146604);
      return;
    }
    Marker localMarker = this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(paramDouble1, paramDouble2)).markerView(paramView));
    this.mMarkerMap.put(paramView, localMarker);
    AppMethodBeat.o(146604);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate)
  {
    AppMethodBeat.i(146620);
    if (this.mTencentMap != null) {
      this.mTencentMap.animateCamera(paramCameraUpdate);
    }
    AppMethodBeat.o(146620);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(146619);
    if (this.mMarkerMap != null)
    {
      this.mMarkerMap.clear();
      this.mMarkerClickMap.clear();
      this.mInfoWindowClickMap.clear();
    }
    AppMethodBeat.o(146619);
  }
  
  public void disableDarkMode()
  {
    AppMethodBeat.i(182826);
    if (this.mTencentMap != null) {
      this.mTencentMap.setMapType(1000);
    }
    AppMethodBeat.o(182826);
  }
  
  public Circle drawAccuracyCircle(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(146618);
    if (this.mTencentMap != null)
    {
      Object localObject = new CircleOptions();
      ((CircleOptions)localObject).center(new LatLng(paramDouble1, paramDouble2));
      ((CircleOptions)localObject).radius(paramDouble3);
      ((CircleOptions)localObject).strokeColor(Color.parseColor("#00FFFFFF"));
      ((CircleOptions)localObject).strokeWidth(0.0F);
      ((CircleOptions)localObject).fillColor(Color.parseColor("#4D1485EE"));
      localObject = this.mTencentMap.addCircle((CircleOptions)localObject);
      AppMethodBeat.o(146618);
      return localObject;
    }
    AppMethodBeat.o(146618);
    return null;
  }
  
  public void enableDarkMode()
  {
    AppMethodBeat.i(182825);
    if (this.mTencentMap != null) {
      this.mTencentMap.setMapType(1008);
    }
    AppMethodBeat.o(182825);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(146606);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146606);
      return;
    }
    paramView = (Marker)this.mMarkerMap.get(paramView);
    if (paramView != null)
    {
      paramView.remove();
      this.mMarkerClickMap.remove(paramView);
      this.mInfoWindowClickMap.remove(paramView);
    }
    AppMethodBeat.o(146606);
  }
  
  public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(146615);
    this.mTencentMap.setInfoWindowAdapter(paramInfoWindowAdapter);
    AppMethodBeat.o(146615);
  }
  
  public void setInfoWindowClick(View paramView, TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    AppMethodBeat.i(146614);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146614);
      return;
    }
    paramView = (Marker)this.mMarkerMap.get(paramView);
    if (paramView != null) {
      this.mInfoWindowClickMap.put(paramView, paramOnInfoWindowClickListener);
    }
    AppMethodBeat.o(146614);
  }
  
  public void setMarker2Top(View paramView)
  {
    AppMethodBeat.i(146612);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146612);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).set2Top();
    AppMethodBeat.o(146612);
  }
  
  public void setMarkerClick(View paramView, TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    AppMethodBeat.i(146613);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146613);
      return;
    }
    paramView = (Marker)this.mMarkerMap.get(paramView);
    if (paramView != null) {
      this.mMarkerClickMap.put(paramView, paramOnMarkerClickListener);
    }
    AppMethodBeat.o(146613);
  }
  
  public void setMarkerTag(View paramView, String paramString)
  {
    AppMethodBeat.i(146617);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146617);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).setTag(paramString);
    AppMethodBeat.o(146617);
  }
  
  public void showInfoWindowByView(View paramView)
  {
    AppMethodBeat.i(146616);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146616);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).showInfoWindow();
    AppMethodBeat.o(146616);
  }
  
  public void toggleViewVisible(View paramView)
  {
    AppMethodBeat.i(146610);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146610);
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    if (paramView.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localMarker.setVisible(bool);
      AppMethodBeat.o(146610);
      return;
    }
  }
  
  public void updateLocationPinLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(146608);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146608);
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    if (localMarker == null)
    {
      AppMethodBeat.o(146608);
      return;
    }
    if (paramView.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localMarker.setVisible(bool);
      localMarker.setPosition(new LatLng(paramDouble1, paramDouble2));
      if (paramBoolean) {
        localMarker.setMarkerView(paramView);
      }
      localMarker.setAnchor(0.5F, 0.5F);
      AppMethodBeat.o(146608);
      return;
    }
  }
  
  public void updateMarkerView(View paramView)
  {
    AppMethodBeat.i(146611);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146611);
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    if (localMarker != null) {
      localMarker.setMarkerView(paramView);
    }
    AppMethodBeat.o(146611);
  }
  
  public void updateRotation(View paramView, float paramFloat)
  {
    AppMethodBeat.i(146609);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146609);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).setRotation(paramFloat);
    AppMethodBeat.o(146609);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(146607);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(146607);
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    if (paramView.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localMarker.setVisible(bool);
      localMarker.setPosition(new LatLng(paramDouble1, paramDouble2));
      if (paramBoolean) {
        localMarker.setMarkerView(paramView);
      }
      localMarker.setAnchor(0.5F, 1.0F);
      AppMethodBeat.o(146607);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.ViewManager
 * JD-Core Version:    0.7.0.1
 */