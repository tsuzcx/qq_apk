package com.j.a.a.a.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements com.tencent.mapsdk.raster.model.Circle
{
  private com.tencent.tencentmap.mapsdk.maps.model.Circle airq;
  
  public b(com.tencent.tencentmap.mapsdk.maps.model.Circle paramCircle)
  {
    this.airq = paramCircle;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(207174);
    if (this.airq != null)
    {
      boolean bool = this.airq.contains(l.d(paramLatLng));
      AppMethodBeat.o(207174);
      return bool;
    }
    AppMethodBeat.o(207174);
    return false;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(207028);
    if (this.airq != null)
    {
      LatLng localLatLng = l.d(this.airq.getCenter());
      AppMethodBeat.o(207028);
      return localLatLng;
    }
    AppMethodBeat.o(207028);
    return null;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(207104);
    if (this.airq != null)
    {
      int i = this.airq.getFillColor();
      AppMethodBeat.o(207104);
      return i;
    }
    AppMethodBeat.o(207104);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(207017);
    if (this.airq != null)
    {
      String str = this.airq.getId();
      AppMethodBeat.o(207017);
      return str;
    }
    AppMethodBeat.o(207017);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(207141);
    if (this.airq != null)
    {
      int i = this.airq.getLevel();
      AppMethodBeat.o(207141);
      return i;
    }
    AppMethodBeat.o(207141);
    return 0;
  }
  
  public final double getRadius()
  {
    AppMethodBeat.i(207041);
    if (this.airq != null)
    {
      double d = this.airq.getRadius();
      AppMethodBeat.o(207041);
      return d;
    }
    AppMethodBeat.o(207041);
    return 0.0D;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(207079);
    if (this.airq != null)
    {
      int i = this.airq.getStrokeColor();
      AppMethodBeat.o(207079);
      return i;
    }
    AppMethodBeat.o(207079);
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
    AppMethodBeat.i(207063);
    if (this.airq != null)
    {
      float f = this.airq.getStrokeWidth();
      AppMethodBeat.o(207063);
      return f;
    }
    AppMethodBeat.o(207063);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(207125);
    if (this.airq != null)
    {
      float f = this.airq.getZIndex();
      AppMethodBeat.o(207125);
      return f;
    }
    AppMethodBeat.o(207125);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(207164);
    if (this.airq != null)
    {
      boolean bool = this.airq.isVisible();
      AppMethodBeat.o(207164);
      return bool;
    }
    AppMethodBeat.o(207164);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(207008);
    if (this.airq != null) {
      this.airq.remove();
    }
    AppMethodBeat.o(207008);
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(207022);
    if (this.airq != null) {
      this.airq.setCenter(l.d(paramLatLng));
    }
    AppMethodBeat.o(207022);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(207090);
    if (this.airq != null) {
      this.airq.setFillColor(paramInt);
    }
    AppMethodBeat.o(207090);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(207134);
    if (this.airq != null) {
      this.airq.setLevel(paramInt);
    }
    AppMethodBeat.o(207134);
  }
  
  public final void setRadius(double paramDouble)
  {
    AppMethodBeat.i(207035);
    if (this.airq != null) {
      this.airq.setRadius(paramDouble);
    }
    AppMethodBeat.o(207035);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(207069);
    if (this.airq != null) {
      this.airq.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(207069);
  }
  
  public final void setStrokeDash(boolean paramBoolean) {}
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(207052);
    if (this.airq != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Circle localCircle = this.airq;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localCircle.setStrokeWidth(f);
    }
    AppMethodBeat.o(207052);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(207152);
    if (this.airq != null) {
      this.airq.setVisible(paramBoolean);
    }
    AppMethodBeat.o(207152);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(207113);
    if (this.airq != null) {
      this.airq.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(207113);
  }
  
  public final void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */