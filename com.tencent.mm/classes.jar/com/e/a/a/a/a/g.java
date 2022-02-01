package com.e.a.a.a.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
  implements com.tencent.mapsdk.raster.model.Polygon
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polygon aalI;
  
  public g(com.tencent.tencentmap.mapsdk.maps.model.Polygon paramPolygon)
  {
    this.aalI = paramPolygon;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(187411);
    if (this.aalI != null)
    {
      boolean bool = this.aalI.contains(l.c(paramLatLng));
      AppMethodBeat.o(187411);
      return bool;
    }
    AppMethodBeat.o(187411);
    return false;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(187394);
    if (this.aalI != null)
    {
      int i = this.aalI.getFillColor();
      AppMethodBeat.o(187394);
      return i;
    }
    AppMethodBeat.o(187394);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(187370);
    if (this.aalI != null)
    {
      String str = this.aalI.getId();
      AppMethodBeat.o(187370);
      return str;
    }
    AppMethodBeat.o(187370);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(187403);
    if (this.aalI != null)
    {
      int i = this.aalI.getLevel();
      AppMethodBeat.o(187403);
      return i;
    }
    AppMethodBeat.o(187403);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(187374);
    if (this.aalI != null)
    {
      List localList = l.le(this.aalI.getPoints());
      AppMethodBeat.o(187374);
      return localList;
    }
    AppMethodBeat.o(187374);
    return null;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(187383);
    if (this.aalI != null)
    {
      int i = this.aalI.getStrokeColor();
      AppMethodBeat.o(187383);
      return i;
    }
    AppMethodBeat.o(187383);
    return 0;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(187378);
    if (this.aalI != null)
    {
      float f = this.aalI.getStrokeWidth();
      AppMethodBeat.o(187378);
      return f;
    }
    AppMethodBeat.o(187378);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(187399);
    if (this.aalI != null)
    {
      float f = this.aalI.getZIndex();
      AppMethodBeat.o(187399);
      return f;
    }
    AppMethodBeat.o(187399);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(187406);
    if (this.aalI != null)
    {
      boolean bool = this.aalI.isVisible();
      AppMethodBeat.o(187406);
      return bool;
    }
    AppMethodBeat.o(187406);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(187368);
    if (this.aalI != null) {
      this.aalI.remove();
    }
    AppMethodBeat.o(187368);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(187385);
    if (this.aalI != null) {
      this.aalI.setFillColor(paramInt);
    }
    AppMethodBeat.o(187385);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(187400);
    if (this.aalI != null) {
      this.aalI.setLevel(paramInt);
    }
    AppMethodBeat.o(187400);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(187373);
    if (this.aalI != null) {
      this.aalI.setPoints(l.lf(paramList));
    }
    AppMethodBeat.o(187373);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(187382);
    if (this.aalI != null) {
      this.aalI.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(187382);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(187376);
    if (this.aalI != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polygon localPolygon = this.aalI;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolygon.setStrokeWidth(f);
    }
    AppMethodBeat.o(187376);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(187405);
    if (this.aalI != null) {
      this.aalI.setVisible(paramBoolean);
    }
    AppMethodBeat.o(187405);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(187398);
    if (this.aalI != null) {
      this.aalI.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(187398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */