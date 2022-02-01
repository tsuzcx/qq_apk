package com.d.a.a.a.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements com.tencent.mapsdk.raster.model.Circle
{
  private com.tencent.tencentmap.mapsdk.maps.model.Circle SJJ;
  
  public b(com.tencent.tencentmap.mapsdk.maps.model.Circle paramCircle)
  {
    this.SJJ = paramCircle;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(217294);
    if (this.SJJ != null)
    {
      boolean bool = this.SJJ.contains(l.c(paramLatLng));
      AppMethodBeat.o(217294);
      return bool;
    }
    AppMethodBeat.o(217294);
    return false;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(217279);
    if (this.SJJ != null)
    {
      LatLng localLatLng = l.a(this.SJJ.getCenter());
      AppMethodBeat.o(217279);
      return localLatLng;
    }
    AppMethodBeat.o(217279);
    return null;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(217287);
    if (this.SJJ != null)
    {
      int i = this.SJJ.getFillColor();
      AppMethodBeat.o(217287);
      return i;
    }
    AppMethodBeat.o(217287);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(217277);
    if (this.SJJ != null)
    {
      String str = this.SJJ.getId();
      AppMethodBeat.o(217277);
      return str;
    }
    AppMethodBeat.o(217277);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(217291);
    if (this.SJJ != null)
    {
      int i = this.SJJ.getLevel();
      AppMethodBeat.o(217291);
      return i;
    }
    AppMethodBeat.o(217291);
    return 0;
  }
  
  public final double getRadius()
  {
    AppMethodBeat.i(217281);
    if (this.SJJ != null)
    {
      double d = this.SJJ.getRadius();
      AppMethodBeat.o(217281);
      return d;
    }
    AppMethodBeat.o(217281);
    return 0.0D;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(217285);
    if (this.SJJ != null)
    {
      int i = this.SJJ.getStrokeColor();
      AppMethodBeat.o(217285);
      return i;
    }
    AppMethodBeat.o(217285);
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
    AppMethodBeat.i(217283);
    if (this.SJJ != null)
    {
      float f = this.SJJ.getStrokeWidth();
      AppMethodBeat.o(217283);
      return f;
    }
    AppMethodBeat.o(217283);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(217289);
    if (this.SJJ != null)
    {
      float f = this.SJJ.getZIndex();
      AppMethodBeat.o(217289);
      return f;
    }
    AppMethodBeat.o(217289);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(217293);
    if (this.SJJ != null)
    {
      boolean bool = this.SJJ.isVisible();
      AppMethodBeat.o(217293);
      return bool;
    }
    AppMethodBeat.o(217293);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(217276);
    if (this.SJJ != null) {
      this.SJJ.remove();
    }
    AppMethodBeat.o(217276);
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(217278);
    if (this.SJJ != null) {
      this.SJJ.setCenter(l.c(paramLatLng));
    }
    AppMethodBeat.o(217278);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(217286);
    if (this.SJJ != null) {
      this.SJJ.setFillColor(paramInt);
    }
    AppMethodBeat.o(217286);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(217290);
    if (this.SJJ != null) {
      this.SJJ.setLevel(paramInt);
    }
    AppMethodBeat.o(217290);
  }
  
  public final void setRadius(double paramDouble)
  {
    AppMethodBeat.i(217280);
    if (this.SJJ != null) {
      this.SJJ.setRadius(paramDouble);
    }
    AppMethodBeat.o(217280);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(217284);
    if (this.SJJ != null) {
      this.SJJ.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(217284);
  }
  
  public final void setStrokeDash(boolean paramBoolean) {}
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(217282);
    if (this.SJJ != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Circle localCircle = this.SJJ;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localCircle.setStrokeWidth(f);
    }
    AppMethodBeat.o(217282);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(217292);
    if (this.SJJ != null) {
      this.SJJ.setVisible(paramBoolean);
    }
    AppMethodBeat.o(217292);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(217288);
    if (this.SJJ != null) {
      this.SJJ.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(217288);
  }
  
  public final void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */