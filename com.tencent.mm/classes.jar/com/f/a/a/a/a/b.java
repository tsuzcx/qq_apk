package com.f.a.a.a.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements com.tencent.mapsdk.raster.model.Circle
{
  private com.tencent.tencentmap.mapsdk.maps.model.Circle MWB;
  
  public b(com.tencent.tencentmap.mapsdk.maps.model.Circle paramCircle)
  {
    this.MWB = paramCircle;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(212635);
    if (this.MWB != null)
    {
      boolean bool = this.MWB.contains(l.c(paramLatLng));
      AppMethodBeat.o(212635);
      return bool;
    }
    AppMethodBeat.o(212635);
    return false;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(212620);
    if (this.MWB != null)
    {
      LatLng localLatLng = l.a(this.MWB.getCenter());
      AppMethodBeat.o(212620);
      return localLatLng;
    }
    AppMethodBeat.o(212620);
    return null;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(212628);
    if (this.MWB != null)
    {
      int i = this.MWB.getFillColor();
      AppMethodBeat.o(212628);
      return i;
    }
    AppMethodBeat.o(212628);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(212618);
    if (this.MWB != null)
    {
      String str = this.MWB.getId();
      AppMethodBeat.o(212618);
      return str;
    }
    AppMethodBeat.o(212618);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(212632);
    if (this.MWB != null)
    {
      int i = this.MWB.getLevel();
      AppMethodBeat.o(212632);
      return i;
    }
    AppMethodBeat.o(212632);
    return 0;
  }
  
  public final double getRadius()
  {
    AppMethodBeat.i(212622);
    if (this.MWB != null)
    {
      double d = this.MWB.getRadius();
      AppMethodBeat.o(212622);
      return d;
    }
    AppMethodBeat.o(212622);
    return 0.0D;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(212626);
    if (this.MWB != null)
    {
      int i = this.MWB.getStrokeColor();
      AppMethodBeat.o(212626);
      return i;
    }
    AppMethodBeat.o(212626);
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
    AppMethodBeat.i(212624);
    if (this.MWB != null)
    {
      float f = this.MWB.getStrokeWidth();
      AppMethodBeat.o(212624);
      return f;
    }
    AppMethodBeat.o(212624);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(212630);
    if (this.MWB != null)
    {
      float f = (int)this.MWB.getZIndex();
      AppMethodBeat.o(212630);
      return f;
    }
    AppMethodBeat.o(212630);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(212634);
    if (this.MWB != null)
    {
      boolean bool = this.MWB.isVisible();
      AppMethodBeat.o(212634);
      return bool;
    }
    AppMethodBeat.o(212634);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(212617);
    if (this.MWB != null) {
      this.MWB.remove();
    }
    AppMethodBeat.o(212617);
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(212619);
    if (this.MWB != null) {
      this.MWB.setCenter(l.c(paramLatLng));
    }
    AppMethodBeat.o(212619);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(212627);
    if (this.MWB != null) {
      this.MWB.setFillColor(paramInt);
    }
    AppMethodBeat.o(212627);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(212631);
    if (this.MWB != null) {
      this.MWB.setLevel(paramInt);
    }
    AppMethodBeat.o(212631);
  }
  
  public final void setRadius(double paramDouble)
  {
    AppMethodBeat.i(212621);
    if (this.MWB != null) {
      this.MWB.setRadius(paramDouble);
    }
    AppMethodBeat.o(212621);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(212625);
    if (this.MWB != null) {
      this.MWB.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(212625);
  }
  
  public final void setStrokeDash(boolean paramBoolean) {}
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(212623);
    if (this.MWB != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Circle localCircle = this.MWB;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localCircle.setStrokeWidth(f);
    }
    AppMethodBeat.o(212623);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(212633);
    if (this.MWB != null) {
      this.MWB.setVisible(paramBoolean);
    }
    AppMethodBeat.o(212633);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(212629);
    if (this.MWB != null) {
      this.MWB.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(212629);
  }
  
  public final void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */