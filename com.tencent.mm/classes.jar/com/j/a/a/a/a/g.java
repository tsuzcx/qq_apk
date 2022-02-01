package com.j.a.a.a.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
  implements com.tencent.mapsdk.raster.model.Polygon
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polygon airv;
  
  public g(com.tencent.tencentmap.mapsdk.maps.model.Polygon paramPolygon)
  {
    this.airv = paramPolygon;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(207193);
    if (this.airv != null)
    {
      boolean bool = this.airv.contains(l.d(paramLatLng));
      AppMethodBeat.o(207193);
      return bool;
    }
    AppMethodBeat.o(207193);
    return false;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(207122);
    if (this.airv != null)
    {
      int i = this.airv.getFillColor();
      AppMethodBeat.o(207122);
      return i;
    }
    AppMethodBeat.o(207122);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(207038);
    if (this.airv != null)
    {
      String str = this.airv.getId();
      AppMethodBeat.o(207038);
      return str;
    }
    AppMethodBeat.o(207038);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(207157);
    if (this.airv != null)
    {
      int i = this.airv.getLevel();
      AppMethodBeat.o(207157);
      return i;
    }
    AppMethodBeat.o(207157);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(207055);
    if (this.airv != null)
    {
      List localList = l.oC(this.airv.getPoints());
      AppMethodBeat.o(207055);
      return localList;
    }
    AppMethodBeat.o(207055);
    return null;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(207098);
    if (this.airv != null)
    {
      int i = this.airv.getStrokeColor();
      AppMethodBeat.o(207098);
      return i;
    }
    AppMethodBeat.o(207098);
    return 0;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(207077);
    if (this.airv != null)
    {
      float f = this.airv.getStrokeWidth();
      AppMethodBeat.o(207077);
      return f;
    }
    AppMethodBeat.o(207077);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(207138);
    if (this.airv != null)
    {
      float f = this.airv.getZIndex();
      AppMethodBeat.o(207138);
      return f;
    }
    AppMethodBeat.o(207138);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(207181);
    if (this.airv != null)
    {
      boolean bool = this.airv.isVisible();
      AppMethodBeat.o(207181);
      return bool;
    }
    AppMethodBeat.o(207181);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(207031);
    if (this.airv != null) {
      this.airv.remove();
    }
    AppMethodBeat.o(207031);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(207110);
    if (this.airv != null) {
      this.airv.setFillColor(paramInt);
    }
    AppMethodBeat.o(207110);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(207149);
    if (this.airv != null) {
      this.airv.setLevel(paramInt);
    }
    AppMethodBeat.o(207149);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(207044);
    if (this.airv != null) {
      this.airv.setPoints(l.oD(paramList));
    }
    AppMethodBeat.o(207044);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(207087);
    if (this.airv != null) {
      this.airv.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(207087);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(207067);
    if (this.airv != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polygon localPolygon = this.airv;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolygon.setStrokeWidth(f);
    }
    AppMethodBeat.o(207067);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(207170);
    if (this.airv != null) {
      this.airv.setVisible(paramBoolean);
    }
    AppMethodBeat.o(207170);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(207130);
    if (this.airv != null) {
      this.airv.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(207130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */