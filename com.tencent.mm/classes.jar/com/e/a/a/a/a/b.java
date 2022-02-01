package com.e.a.a.a.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements com.tencent.mapsdk.raster.model.Circle
{
  private com.tencent.tencentmap.mapsdk.maps.model.Circle aalD;
  
  public b(com.tencent.tencentmap.mapsdk.maps.model.Circle paramCircle)
  {
    this.aalD = paramCircle;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(189508);
    if (this.aalD != null)
    {
      boolean bool = this.aalD.contains(l.c(paramLatLng));
      AppMethodBeat.o(189508);
      return bool;
    }
    AppMethodBeat.o(189508);
    return false;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(189471);
    if (this.aalD != null)
    {
      LatLng localLatLng = l.a(this.aalD.getCenter());
      AppMethodBeat.o(189471);
      return localLatLng;
    }
    AppMethodBeat.o(189471);
    return null;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(189492);
    if (this.aalD != null)
    {
      int i = this.aalD.getFillColor();
      AppMethodBeat.o(189492);
      return i;
    }
    AppMethodBeat.o(189492);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(189466);
    if (this.aalD != null)
    {
      String str = this.aalD.getId();
      AppMethodBeat.o(189466);
      return str;
    }
    AppMethodBeat.o(189466);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(189501);
    if (this.aalD != null)
    {
      int i = this.aalD.getLevel();
      AppMethodBeat.o(189501);
      return i;
    }
    AppMethodBeat.o(189501);
    return 0;
  }
  
  public final double getRadius()
  {
    AppMethodBeat.i(189478);
    if (this.aalD != null)
    {
      double d = this.aalD.getRadius();
      AppMethodBeat.o(189478);
      return d;
    }
    AppMethodBeat.o(189478);
    return 0.0D;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(189488);
    if (this.aalD != null)
    {
      int i = this.aalD.getStrokeColor();
      AppMethodBeat.o(189488);
      return i;
    }
    AppMethodBeat.o(189488);
    return 0;
  }
  
  public final boolean getStrokeDash()
  {
    return false;
  }
  
  public final DashPathEffect getStrokeDashPathEffect()
  {
    return null;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(189483);
    if (this.aalD != null)
    {
      float f = this.aalD.getStrokeWidth();
      AppMethodBeat.o(189483);
      return f;
    }
    AppMethodBeat.o(189483);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(189497);
    if (this.aalD != null)
    {
      float f = this.aalD.getZIndex();
      AppMethodBeat.o(189497);
      return f;
    }
    AppMethodBeat.o(189497);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(189504);
    if (this.aalD != null)
    {
      boolean bool = this.aalD.isVisible();
      AppMethodBeat.o(189504);
      return bool;
    }
    AppMethodBeat.o(189504);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(189463);
    if (this.aalD != null) {
      this.aalD.remove();
    }
    AppMethodBeat.o(189463);
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(189468);
    if (this.aalD != null) {
      this.aalD.setCenter(l.c(paramLatLng));
    }
    AppMethodBeat.o(189468);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(189490);
    if (this.aalD != null) {
      this.aalD.setFillColor(paramInt);
    }
    AppMethodBeat.o(189490);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(189499);
    if (this.aalD != null) {
      this.aalD.setLevel(paramInt);
    }
    AppMethodBeat.o(189499);
  }
  
  public final void setRadius(double paramDouble)
  {
    AppMethodBeat.i(189474);
    if (this.aalD != null) {
      this.aalD.setRadius(paramDouble);
    }
    AppMethodBeat.o(189474);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(189486);
    if (this.aalD != null) {
      this.aalD.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(189486);
  }
  
  public final void setStrokeDash(boolean paramBoolean) {}
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(189481);
    if (this.aalD != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Circle localCircle = this.aalD;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localCircle.setStrokeWidth(f);
    }
    AppMethodBeat.o(189481);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(189503);
    if (this.aalD != null) {
      this.aalD.setVisible(paramBoolean);
    }
    AppMethodBeat.o(189503);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(189495);
    if (this.aalD != null) {
      this.aalD.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(189495);
  }
  
  public final void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */