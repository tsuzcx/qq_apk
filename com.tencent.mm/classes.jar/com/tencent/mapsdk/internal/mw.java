package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

public final class mw
  extends mm<my>
  implements GroundOverlay
{
  mw(mx parammx, my parammy)
  {
    super(parammx, parammy);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(221533);
    if (((my)this.d).a != null) {
      ((my)this.d).a.alpha(paramFloat);
    }
    ((my)this.d).setAlpha(paramFloat);
    a(this.d);
    AppMethodBeat.o(221533);
  }
  
  public final void setAnchor(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221527);
    if (((my)this.d).a != null) {
      ((my)this.d).a.anchor(paramFloat1, paramFloat2);
    }
    ((my)this.d).a();
    a(this.d);
    AppMethodBeat.o(221527);
  }
  
  public final void setBitmap(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(221495);
    if (paramBitmapDescriptor == null)
    {
      AppMethodBeat.o(221495);
      return;
    }
    if (((my)this.d).a != null) {
      ((my)this.d).a.bitmap(paramBitmapDescriptor);
    }
    if (this.c != null) {
      ((my)this.d).setBitmap(paramBitmapDescriptor.getBitmap(this.c.a()));
    }
    a(this.d);
    AppMethodBeat.o(221495);
  }
  
  public final void setLatLongBounds(LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(221500);
    if (((my)this.d).a != null) {
      ((my)this.d).a.latLngBounds(paramLatLngBounds);
    }
    ((my)this.d).setLatLngBounds(paramLatLngBounds);
    a(this.d);
    AppMethodBeat.o(221500);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(221554);
    if (((my)this.d).a != null) {
      ((my)this.d).a.level(paramInt);
    }
    ((my)this.d).setLevel(paramInt);
    a(this.d);
    AppMethodBeat.o(221554);
  }
  
  public final void setPosition(LatLng paramLatLng)
  {
    AppMethodBeat.i(221512);
    if (((my)this.d).a != null) {
      ((my)this.d).a.position(paramLatLng);
    }
    ((my)this.d).a();
    a(this.d);
    AppMethodBeat.o(221512);
  }
  
  public final void setVisibility(boolean paramBoolean)
  {
    AppMethodBeat.i(221542);
    if (((my)this.d).a != null) {
      ((my)this.d).a.visible(paramBoolean);
    }
    ((my)this.d).setVisibility(paramBoolean);
    a(this.d);
    AppMethodBeat.o(221542);
  }
  
  public final void setZindex(int paramInt)
  {
    AppMethodBeat.i(221549);
    if (((my)this.d).a != null) {
      ((my)this.d).a.zIndex(paramInt);
    }
    ((my)this.d).setZIndex(paramInt);
    a(this.d);
    AppMethodBeat.o(221549);
  }
  
  public final void setZoom(float paramFloat)
  {
    AppMethodBeat.i(221522);
    if (((my)this.d).a != null) {
      ((my)this.d).a.zoom(paramFloat);
    }
    ((my)this.d).a();
    a(this.d);
    AppMethodBeat.o(221522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mw
 * JD-Core Version:    0.7.0.1
 */