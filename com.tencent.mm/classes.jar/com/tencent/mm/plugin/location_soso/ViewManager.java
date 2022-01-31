package com.tencent.mm.plugin.location_soso;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.plugin.p.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import java.util.HashMap;
import java.util.Map;

public class ViewManager
  implements e
{
  private Map<View, Marker> mMarkerMap;
  private TencentMap mTencentMap;
  
  public ViewManager(TencentMap paramTencentMap)
  {
    this.mTencentMap = paramTencentMap;
    this.mMarkerMap = new HashMap();
  }
  
  public void addPinView(View paramView, double paramDouble1, double paramDouble2)
  {
    if (this.mTencentMap == null) {
      return;
    }
    Marker localMarker = this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(paramDouble1, paramDouble2)).anchor(0.5F, 0.5F).markerView(paramView));
    this.mMarkerMap.put(paramView, localMarker);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2)
  {
    if (this.mTencentMap == null) {
      return;
    }
    Marker localMarker = this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(paramDouble1, paramDouble2)).markerView(paramView));
    this.mMarkerMap.put(paramView, localMarker);
  }
  
  public void destroy()
  {
    if (this.mMarkerMap != null) {
      this.mMarkerMap.clear();
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.mTencentMap == null) {}
    do
    {
      return;
      paramView = (Marker)this.mMarkerMap.get(paramView);
    } while (paramView == null);
    paramView.remove();
  }
  
  public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    this.mTencentMap.setInfoWindowAdapter(paramInfoWindowAdapter);
  }
  
  public void setMarker2Top(View paramView)
  {
    if (this.mTencentMap == null) {
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).set2Top();
  }
  
  public void setMarkerClick(View paramView, View.OnClickListener paramOnClickListener)
  {
    if (this.mTencentMap == null) {
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    this.mTencentMap.setOnInfoWindowClickListener(new ViewManager.1(this, localMarker, paramOnClickListener, paramView));
  }
  
  public void setMarkerTag(View paramView, String paramString)
  {
    if (this.mTencentMap == null) {
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).setTag(paramString);
  }
  
  public void showInfoWindowByView(View paramView)
  {
    if (this.mTencentMap == null) {
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).showInfoWindow();
  }
  
  public void toggleViewVisible(View paramView)
  {
    if (this.mTencentMap == null) {
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    if (paramView.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localMarker.setVisible(bool);
      return;
    }
  }
  
  public void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    if (this.mTencentMap == null) {
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
      localMarker.setAnchor(0.5F, 0.5F);
      return;
    }
  }
  
  public void updateMarkerView(View paramView)
  {
    if (this.mTencentMap == null) {
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).setMarkerView(paramView);
  }
  
  public void updateRotation(View paramView, float paramFloat)
  {
    if (this.mTencentMap == null) {
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).setRotation(paramFloat);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    if (this.mTencentMap == null) {
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
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.ViewManager
 * JD-Core Version:    0.7.0.1
 */