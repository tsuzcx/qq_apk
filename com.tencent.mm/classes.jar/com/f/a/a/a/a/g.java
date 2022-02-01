package com.f.a.a.a.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
  implements com.tencent.mapsdk.raster.model.Polygon
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polygon Mzz;
  
  public g(com.tencent.tencentmap.mapsdk.maps.model.Polygon paramPolygon)
  {
    this.Mzz = paramPolygon;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(200030);
    if (this.Mzz != null)
    {
      boolean bool = this.Mzz.contains(l.c(paramLatLng));
      AppMethodBeat.o(200030);
      return bool;
    }
    AppMethodBeat.o(200030);
    return false;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(200023);
    if (this.Mzz != null)
    {
      int i = this.Mzz.getFillColor();
      AppMethodBeat.o(200023);
      return i;
    }
    AppMethodBeat.o(200023);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(200015);
    if (this.Mzz != null)
    {
      String str = this.Mzz.getId();
      AppMethodBeat.o(200015);
      return str;
    }
    AppMethodBeat.o(200015);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(200027);
    if (this.Mzz != null)
    {
      int i = this.Mzz.getLevel();
      AppMethodBeat.o(200027);
      return i;
    }
    AppMethodBeat.o(200027);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(200017);
    if (this.Mzz != null)
    {
      List localList = l.iU(this.Mzz.getPoints());
      AppMethodBeat.o(200017);
      return localList;
    }
    AppMethodBeat.o(200017);
    return null;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(200021);
    if (this.Mzz != null)
    {
      int i = this.Mzz.getStrokeColor();
      AppMethodBeat.o(200021);
      return i;
    }
    AppMethodBeat.o(200021);
    return 0;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(200019);
    if (this.Mzz != null)
    {
      float f = this.Mzz.getStrokeWidth();
      AppMethodBeat.o(200019);
      return f;
    }
    AppMethodBeat.o(200019);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(200025);
    if (this.Mzz != null)
    {
      float f = (int)this.Mzz.getZIndex();
      AppMethodBeat.o(200025);
      return f;
    }
    AppMethodBeat.o(200025);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(200029);
    if (this.Mzz != null)
    {
      boolean bool = this.Mzz.isVisible();
      AppMethodBeat.o(200029);
      return bool;
    }
    AppMethodBeat.o(200029);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(200014);
    if (this.Mzz != null) {
      this.Mzz.remove();
    }
    AppMethodBeat.o(200014);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(200022);
    if (this.Mzz != null) {
      this.Mzz.setFillColor(paramInt);
    }
    AppMethodBeat.o(200022);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(200026);
    if (this.Mzz != null) {
      this.Mzz.setLevel(paramInt);
    }
    AppMethodBeat.o(200026);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(200016);
    if (this.Mzz != null) {
      this.Mzz.setPoints(l.iV(paramList));
    }
    AppMethodBeat.o(200016);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(200020);
    if (this.Mzz != null) {
      this.Mzz.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(200020);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(200018);
    if (this.Mzz != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polygon localPolygon = this.Mzz;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolygon.setStrokeWidth(f);
    }
    AppMethodBeat.o(200018);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(200028);
    if (this.Mzz != null) {
      this.Mzz.setVisible(paramBoolean);
    }
    AppMethodBeat.o(200028);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(200024);
    if (this.Mzz != null) {
      this.Mzz.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(200024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */