package com.f.a.a.a.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g
  implements com.tencent.mapsdk.raster.model.Polygon
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polygon MWG;
  
  public g(com.tencent.tencentmap.mapsdk.maps.model.Polygon paramPolygon)
  {
    this.MWG = paramPolygon;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(212722);
    if (this.MWG != null)
    {
      boolean bool = this.MWG.contains(l.c(paramLatLng));
      AppMethodBeat.o(212722);
      return bool;
    }
    AppMethodBeat.o(212722);
    return false;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(212715);
    if (this.MWG != null)
    {
      int i = this.MWG.getFillColor();
      AppMethodBeat.o(212715);
      return i;
    }
    AppMethodBeat.o(212715);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(212707);
    if (this.MWG != null)
    {
      String str = this.MWG.getId();
      AppMethodBeat.o(212707);
      return str;
    }
    AppMethodBeat.o(212707);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(212719);
    if (this.MWG != null)
    {
      int i = this.MWG.getLevel();
      AppMethodBeat.o(212719);
      return i;
    }
    AppMethodBeat.o(212719);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(212709);
    if (this.MWG != null)
    {
      List localList = l.jd(this.MWG.getPoints());
      AppMethodBeat.o(212709);
      return localList;
    }
    AppMethodBeat.o(212709);
    return null;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(212713);
    if (this.MWG != null)
    {
      int i = this.MWG.getStrokeColor();
      AppMethodBeat.o(212713);
      return i;
    }
    AppMethodBeat.o(212713);
    return 0;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(212711);
    if (this.MWG != null)
    {
      float f = this.MWG.getStrokeWidth();
      AppMethodBeat.o(212711);
      return f;
    }
    AppMethodBeat.o(212711);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(212717);
    if (this.MWG != null)
    {
      float f = (int)this.MWG.getZIndex();
      AppMethodBeat.o(212717);
      return f;
    }
    AppMethodBeat.o(212717);
    return 0.0F;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(212721);
    if (this.MWG != null)
    {
      boolean bool = this.MWG.isVisible();
      AppMethodBeat.o(212721);
      return bool;
    }
    AppMethodBeat.o(212721);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(212706);
    if (this.MWG != null) {
      this.MWG.remove();
    }
    AppMethodBeat.o(212706);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(212714);
    if (this.MWG != null) {
      this.MWG.setFillColor(paramInt);
    }
    AppMethodBeat.o(212714);
  }
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(212718);
    if (this.MWG != null) {
      this.MWG.setLevel(paramInt);
    }
    AppMethodBeat.o(212718);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(212708);
    if (this.MWG != null) {
      this.MWG.setPoints(l.je(paramList));
    }
    AppMethodBeat.o(212708);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(212712);
    if (this.MWG != null) {
      this.MWG.setStrokeColor(paramInt);
    }
    AppMethodBeat.o(212712);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(212710);
    if (this.MWG != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polygon localPolygon = this.MWG;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolygon.setStrokeWidth(f);
    }
    AppMethodBeat.o(212710);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(212720);
    if (this.MWG != null) {
      this.MWG.setVisible(paramBoolean);
    }
    AppMethodBeat.o(212720);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(212716);
    if (this.MWG != null) {
      this.MWG.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(212716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */