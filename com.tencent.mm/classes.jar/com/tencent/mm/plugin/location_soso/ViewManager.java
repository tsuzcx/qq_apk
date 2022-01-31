package com.tencent.mm.plugin.location_soso;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.e;
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
    AppMethodBeat.i(51279);
    this.mTencentMap = paramTencentMap;
    this.mMarkerMap = new HashMap();
    AppMethodBeat.o(51279);
  }
  
  public void addPinView(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51281);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51281);
      return;
    }
    Marker localMarker = this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(paramDouble1, paramDouble2)).anchor(0.5F, 0.5F).markerView(paramView));
    this.mMarkerMap.put(paramView, localMarker);
    AppMethodBeat.o(51281);
  }
  
  public void addView(View paramView, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51280);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51280);
      return;
    }
    Marker localMarker = this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(paramDouble1, paramDouble2)).markerView(paramView));
    this.mMarkerMap.put(paramView, localMarker);
    AppMethodBeat.o(51280);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(51293);
    if (this.mMarkerMap != null) {
      this.mMarkerMap.clear();
    }
    AppMethodBeat.o(51293);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(51282);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51282);
      return;
    }
    paramView = (Marker)this.mMarkerMap.get(paramView);
    if (paramView != null) {
      paramView.remove();
    }
    AppMethodBeat.o(51282);
  }
  
  public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    AppMethodBeat.i(51290);
    this.mTencentMap.setInfoWindowAdapter(paramInfoWindowAdapter);
    AppMethodBeat.o(51290);
  }
  
  public void setMarker2Top(View paramView)
  {
    AppMethodBeat.i(51288);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51288);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).set2Top();
    AppMethodBeat.o(51288);
  }
  
  public void setMarkerClick(View paramView, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(51289);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51289);
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    this.mTencentMap.setOnInfoWindowClickListener(new ViewManager.1(this, localMarker, paramOnClickListener, paramView));
    AppMethodBeat.o(51289);
  }
  
  public void setMarkerTag(View paramView, String paramString)
  {
    AppMethodBeat.i(51292);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51292);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).setTag(paramString);
    AppMethodBeat.o(51292);
  }
  
  public void showInfoWindowByView(View paramView)
  {
    AppMethodBeat.i(51291);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51291);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).showInfoWindow();
    AppMethodBeat.o(51291);
  }
  
  public void toggleViewVisible(View paramView)
  {
    AppMethodBeat.i(51286);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51286);
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    if (paramView.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localMarker.setVisible(bool);
      AppMethodBeat.o(51286);
      return;
    }
  }
  
  public void updateLocaitonPinLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(51284);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51284);
      return;
    }
    Marker localMarker = (Marker)this.mMarkerMap.get(paramView);
    if (localMarker == null)
    {
      AppMethodBeat.o(51284);
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
      AppMethodBeat.o(51284);
      return;
    }
  }
  
  public void updateMarkerView(View paramView)
  {
    AppMethodBeat.i(51287);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51287);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).setMarkerView(paramView);
    AppMethodBeat.o(51287);
  }
  
  public void updateRotation(View paramView, float paramFloat)
  {
    AppMethodBeat.i(51285);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51285);
      return;
    }
    ((Marker)this.mMarkerMap.get(paramView)).setRotation(paramFloat);
    AppMethodBeat.o(51285);
  }
  
  public void updateViewLayout(View paramView, double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    AppMethodBeat.i(51283);
    if (this.mTencentMap == null)
    {
      AppMethodBeat.o(51283);
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
      AppMethodBeat.o(51283);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location_soso.ViewManager
 * JD-Core Version:    0.7.0.1
 */