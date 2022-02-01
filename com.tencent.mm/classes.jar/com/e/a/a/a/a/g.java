package com.e.a.a.a.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
  implements com.tencent.mapsdk.raster.model.Polygon
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polygon KIU;
  
  public g(com.tencent.tencentmap.mapsdk.maps.model.Polygon paramPolygon)
  {
    this.KIU = paramPolygon;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(205924);
    if (this.KIU != null)
    {
      boolean bool = this.KIU.contains(l.c(paramLatLng));
      AppMethodBeat.o(205924);
      return bool;
    }
    AppMethodBeat.o(205924);
    return false;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(205917);
    if (this.KIU != null)
    {
      int i = this.KIU.getFillColor();
      AppMethodBeat.o(205917);
      return i;
    }
    AppMethodBeat.o(205917);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(205909);
    if (this.KIU != null)
    {
      String str = this.KIU.getId();
      AppMethodBeat.o(205909);
      return str;
    }
    AppMethodBeat.o(205909);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(205921);
    if (this.KIU != null)
    {
      int i = this.KIU.getLevel();
      AppMethodBeat.o(205921);
      return i;
    }
    AppMethodBeat.o(205921);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(205911);
    if (this.KIU != null)
    {
      List localList = l.iG(this.KIU.getPoints());
      AppMethodBeat.o(205911);
      return localList;
    }
    AppMethodBeat.o(205911);
    return null;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(205915);
    if (this.KIU != null)
    {
      int i = this.KIU.getStrokeColor();
      AppMethodBeat.o(205915);
      return i;
    }
    AppMethodBeat.o(205915);
    return 0;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(205913);
    if (this.KIU != null)
    {
      float f = this.KIU.getStrokeWidth();
      AppMethodBeat.o(205913);
      return f;
    }
    AppMethodBeat.o(205913);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(205919);
    if (this.KIU != null)
    {
      float f = (int)this.KIU.getZIndex();
      AppMethodBeat.o(205919);
      return f;
    }
    AppMethodBeat.o(205919);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(205923);
    if (this.KIU != null)
    {
      boolean bool = this.KIU.isVisible();
      AppMethodBeat.o(205923);
      return bool;
    }
    AppMethodBeat.o(205923);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(205908);
    if (this.KIU != null) {
      this.KIU.remove();
    }
    AppMethodBeat.o(205908);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(205916);
    if (this.KIU != null) {
      this.KIU.setFillColor(paramInt);
    }
    AppMethodBeat.o(205916);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(205920);
    if (this.KIU != null) {
      this.KIU.setLevel(paramInt);
    }
    AppMethodBeat.o(205920);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(205910);
    if (this.KIU != null) {
      this.KIU.setPoints(l.iH(paramList));
    }
    AppMethodBeat.o(205910);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(205914);
    if (this.KIU != null) {
      this.KIU.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(205914);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(205912);
    if (this.KIU != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polygon localPolygon = this.KIU;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolygon.setStrokeWidth(f);
    }
    AppMethodBeat.o(205912);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(205922);
    if (this.KIU != null) {
      this.KIU.setVisible(paramBoolean);
    }
    AppMethodBeat.o(205922);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(205918);
    if (this.KIU != null) {
      this.KIU.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(205918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */