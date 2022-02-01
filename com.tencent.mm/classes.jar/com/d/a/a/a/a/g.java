package com.d.a.a.a.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
  implements com.tencent.mapsdk.raster.model.Polygon
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polygon SJO;
  
  public g(com.tencent.tencentmap.mapsdk.maps.model.Polygon paramPolygon)
  {
    this.SJO = paramPolygon;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(217382);
    if (this.SJO != null)
    {
      boolean bool = this.SJO.contains(l.c(paramLatLng));
      AppMethodBeat.o(217382);
      return bool;
    }
    AppMethodBeat.o(217382);
    return false;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(217375);
    if (this.SJO != null)
    {
      int i = this.SJO.getFillColor();
      AppMethodBeat.o(217375);
      return i;
    }
    AppMethodBeat.o(217375);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(217367);
    if (this.SJO != null)
    {
      String str = this.SJO.getId();
      AppMethodBeat.o(217367);
      return str;
    }
    AppMethodBeat.o(217367);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(217379);
    if (this.SJO != null)
    {
      int i = this.SJO.getLevel();
      AppMethodBeat.o(217379);
      return i;
    }
    AppMethodBeat.o(217379);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(217369);
    if (this.SJO != null)
    {
      List localList = l.kk(this.SJO.getPoints());
      AppMethodBeat.o(217369);
      return localList;
    }
    AppMethodBeat.o(217369);
    return null;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(217373);
    if (this.SJO != null)
    {
      int i = this.SJO.getStrokeColor();
      AppMethodBeat.o(217373);
      return i;
    }
    AppMethodBeat.o(217373);
    return 0;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(217371);
    if (this.SJO != null)
    {
      float f = this.SJO.getStrokeWidth();
      AppMethodBeat.o(217371);
      return f;
    }
    AppMethodBeat.o(217371);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(217377);
    if (this.SJO != null)
    {
      float f = this.SJO.getZIndex();
      AppMethodBeat.o(217377);
      return f;
    }
    AppMethodBeat.o(217377);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(217381);
    if (this.SJO != null)
    {
      boolean bool = this.SJO.isVisible();
      AppMethodBeat.o(217381);
      return bool;
    }
    AppMethodBeat.o(217381);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(217366);
    if (this.SJO != null) {
      this.SJO.remove();
    }
    AppMethodBeat.o(217366);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(217374);
    if (this.SJO != null) {
      this.SJO.setFillColor(paramInt);
    }
    AppMethodBeat.o(217374);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(217378);
    if (this.SJO != null) {
      this.SJO.setLevel(paramInt);
    }
    AppMethodBeat.o(217378);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(217368);
    if (this.SJO != null) {
      this.SJO.setPoints(l.kl(paramList));
    }
    AppMethodBeat.o(217368);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(217372);
    if (this.SJO != null) {
      this.SJO.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(217372);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(217370);
    if (this.SJO != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polygon localPolygon = this.SJO;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolygon.setStrokeWidth(f);
    }
    AppMethodBeat.o(217370);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(217380);
    if (this.SJO != null) {
      this.SJO.setVisible(paramBoolean);
    }
    AppMethodBeat.o(217380);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(217376);
    if (this.SJO != null) {
      this.SJO.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(217376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */