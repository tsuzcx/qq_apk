package com.e.a.a.a.a;

import android.graphics.DashPathEffect;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements com.tencent.mapsdk.raster.model.Circle
{
  private com.tencent.tencentmap.mapsdk.maps.model.Circle KIP;
  
  public b(com.tencent.tencentmap.mapsdk.maps.model.Circle paramCircle)
  {
    this.KIP = paramCircle;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(205837);
    if (this.KIP != null)
    {
      boolean bool = this.KIP.contains(l.c(paramLatLng));
      AppMethodBeat.o(205837);
      return bool;
    }
    AppMethodBeat.o(205837);
    return false;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(205822);
    if (this.KIP != null)
    {
      LatLng localLatLng = l.a(this.KIP.getCenter());
      AppMethodBeat.o(205822);
      return localLatLng;
    }
    AppMethodBeat.o(205822);
    return null;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(205830);
    if (this.KIP != null)
    {
      int i = this.KIP.getFillColor();
      AppMethodBeat.o(205830);
      return i;
    }
    AppMethodBeat.o(205830);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(205820);
    if (this.KIP != null)
    {
      String str = this.KIP.getId();
      AppMethodBeat.o(205820);
      return str;
    }
    AppMethodBeat.o(205820);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(205834);
    if (this.KIP != null)
    {
      int i = this.KIP.getLevel();
      AppMethodBeat.o(205834);
      return i;
    }
    AppMethodBeat.o(205834);
    return 0;
  }
  
  public final double getRadius()
  {
    AppMethodBeat.i(205824);
    if (this.KIP != null)
    {
      double d = this.KIP.getRadius();
      AppMethodBeat.o(205824);
      return d;
    }
    AppMethodBeat.o(205824);
    return 0.0D;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(205828);
    if (this.KIP != null)
    {
      int i = this.KIP.getStrokeColor();
      AppMethodBeat.o(205828);
      return i;
    }
    AppMethodBeat.o(205828);
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
    AppMethodBeat.i(205826);
    if (this.KIP != null)
    {
      float f = this.KIP.getStrokeWidth();
      AppMethodBeat.o(205826);
      return f;
    }
    AppMethodBeat.o(205826);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(205832);
    if (this.KIP != null)
    {
      float f = (int)this.KIP.getZIndex();
      AppMethodBeat.o(205832);
      return f;
    }
    AppMethodBeat.o(205832);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(205836);
    if (this.KIP != null)
    {
      boolean bool = this.KIP.isVisible();
      AppMethodBeat.o(205836);
      return bool;
    }
    AppMethodBeat.o(205836);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(205819);
    if (this.KIP != null) {
      this.KIP.remove();
    }
    AppMethodBeat.o(205819);
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(205821);
    if (this.KIP != null) {
      this.KIP.setCenter(l.c(paramLatLng));
    }
    AppMethodBeat.o(205821);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(205829);
    if (this.KIP != null) {
      this.KIP.setFillColor(paramInt);
    }
    AppMethodBeat.o(205829);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(205833);
    if (this.KIP != null) {
      this.KIP.setLevel(paramInt);
    }
    AppMethodBeat.o(205833);
  }
  
  public final void setRadius(double paramDouble)
  {
    AppMethodBeat.i(205823);
    if (this.KIP != null) {
      this.KIP.setRadius(paramDouble);
    }
    AppMethodBeat.o(205823);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(205827);
    if (this.KIP != null) {
      this.KIP.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(205827);
  }
  
  public final void setStrokeDash(boolean paramBoolean) {}
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(205825);
    if (this.KIP != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Circle localCircle = this.KIP;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localCircle.setStrokeWidth(f);
    }
    AppMethodBeat.o(205825);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(205835);
    if (this.KIP != null) {
      this.KIP.setVisible(paramBoolean);
    }
    AppMethodBeat.o(205835);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(205831);
    if (this.KIP != null) {
      this.KIP.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(205831);
  }
  
  public final void strokeDashPathEffect(DashPathEffect paramDashPathEffect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */