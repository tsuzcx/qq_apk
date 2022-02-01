package com.f.a.a.a.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements com.tencent.mapsdk.raster.model.Circle
{
  private com.tencent.tencentmap.mapsdk.maps.model.Circle Mzu;
  
  public b(com.tencent.tencentmap.mapsdk.maps.model.Circle paramCircle)
  {
    this.Mzu = paramCircle;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(199943);
    if (this.Mzu != null)
    {
      boolean bool = this.Mzu.contains(l.c(paramLatLng));
      AppMethodBeat.o(199943);
      return bool;
    }
    AppMethodBeat.o(199943);
    return false;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(199928);
    if (this.Mzu != null)
    {
      LatLng localLatLng = l.a(this.Mzu.getCenter());
      AppMethodBeat.o(199928);
      return localLatLng;
    }
    AppMethodBeat.o(199928);
    return null;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(199936);
    if (this.Mzu != null)
    {
      int i = this.Mzu.getFillColor();
      AppMethodBeat.o(199936);
      return i;
    }
    AppMethodBeat.o(199936);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(199926);
    if (this.Mzu != null)
    {
      String str = this.Mzu.getId();
      AppMethodBeat.o(199926);
      return str;
    }
    AppMethodBeat.o(199926);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(199940);
    if (this.Mzu != null)
    {
      int i = this.Mzu.getLevel();
      AppMethodBeat.o(199940);
      return i;
    }
    AppMethodBeat.o(199940);
    return 0;
  }
  
  public final double getRadius()
  {
    AppMethodBeat.i(199930);
    if (this.Mzu != null)
    {
      double d = this.Mzu.getRadius();
      AppMethodBeat.o(199930);
      return d;
    }
    AppMethodBeat.o(199930);
    return 0.0D;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(199934);
    if (this.Mzu != null)
    {
      int i = this.Mzu.getStrokeColor();
      AppMethodBeat.o(199934);
      return i;
    }
    AppMethodBeat.o(199934);
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
    AppMethodBeat.i(199932);
    if (this.Mzu != null)
    {
      float f = this.Mzu.getStrokeWidth();
      AppMethodBeat.o(199932);
      return f;
    }
    AppMethodBeat.o(199932);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(199938);
    if (this.Mzu != null)
    {
      float f = (int)this.Mzu.getZIndex();
      AppMethodBeat.o(199938);
      return f;
    }
    AppMethodBeat.o(199938);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(199942);
    if (this.Mzu != null)
    {
      boolean bool = this.Mzu.isVisible();
      AppMethodBeat.o(199942);
      return bool;
    }
    AppMethodBeat.o(199942);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(199925);
    if (this.Mzu != null) {
      this.Mzu.remove();
    }
    AppMethodBeat.o(199925);
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(199927);
    if (this.Mzu != null) {
      this.Mzu.setCenter(l.c(paramLatLng));
    }
    AppMethodBeat.o(199927);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(199935);
    if (this.Mzu != null) {
      this.Mzu.setFillColor(paramInt);
    }
    AppMethodBeat.o(199935);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(199939);
    if (this.Mzu != null) {
      this.Mzu.setLevel(paramInt);
    }
    AppMethodBeat.o(199939);
  }
  
  public final void setRadius(double paramDouble)
  {
    AppMethodBeat.i(199929);
    if (this.Mzu != null) {
      this.Mzu.setRadius(paramDouble);
    }
    AppMethodBeat.o(199929);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(199933);
    if (this.Mzu != null) {
      this.Mzu.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(199933);
  }
  
  public final void setStrokeDash(boolean paramBoolean) {}
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(199931);
    if (this.Mzu != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Circle localCircle = this.Mzu;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localCircle.setStrokeWidth(f);
    }
    AppMethodBeat.o(199931);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(199941);
    if (this.Mzu != null) {
      this.Mzu.setVisible(paramBoolean);
    }
    AppMethodBeat.o(199941);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(199937);
    if (this.Mzu != null) {
      this.Mzu.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(199937);
  }
  
  public final void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */