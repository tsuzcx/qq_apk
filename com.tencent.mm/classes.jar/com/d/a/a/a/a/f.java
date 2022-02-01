package com.d.a.a.a.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.List;

public final class f
  implements com.tencent.mapsdk.raster.model.Polyline
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polyline SJN;
  
  public f(com.tencent.tencentmap.mapsdk.maps.model.Polyline paramPolyline)
  {
    this.SJN = paramPolyline;
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(217364);
    if (this.SJN == null)
    {
      AppMethodBeat.o(217364);
      return;
    }
    this.SJN.eraseTo(paramInt, l.c(paramLatLng));
    AppMethodBeat.o(217364);
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(217355);
    if (this.SJN != null)
    {
      int i = this.SJN.getColor();
      AppMethodBeat.o(217355);
      return i;
    }
    AppMethodBeat.o(217355);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(217349);
    if (this.SJN != null)
    {
      String str = this.SJN.getId();
      AppMethodBeat.o(217349);
      return str;
    }
    AppMethodBeat.o(217349);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(217359);
    if (this.SJN != null)
    {
      int i = this.SJN.getLevel();
      AppMethodBeat.o(217359);
      return i;
    }
    AppMethodBeat.o(217359);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(217351);
    if (this.SJN != null)
    {
      List localList = l.kk(this.SJN.getPoints());
      AppMethodBeat.o(217351);
      return localList;
    }
    AppMethodBeat.o(217351);
    return null;
  }
  
  public final float getWidth()
  {
    AppMethodBeat.i(217353);
    if (this.SJN != null)
    {
      float f = this.SJN.getWidth();
      AppMethodBeat.o(217353);
      return f;
    }
    AppMethodBeat.o(217353);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(217358);
    if (this.SJN != null)
    {
      float f = this.SJN.getZIndex();
      AppMethodBeat.o(217358);
      return f;
    }
    AppMethodBeat.o(217358);
    return 0.0F;
  }
  
  public final boolean isDottedLine()
  {
    AppMethodBeat.i(217362);
    if ((this.SJN == null) || (this.SJN.getPattern() == null))
    {
      AppMethodBeat.o(217362);
      return false;
    }
    AppMethodBeat.o(217362);
    return true;
  }
  
  public final boolean isGeodesic()
  {
    return false;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(217361);
    if (this.SJN != null)
    {
      boolean bool = this.SJN.isVisible();
      AppMethodBeat.o(217361);
      return bool;
    }
    AppMethodBeat.o(217361);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(217348);
    if (this.SJN != null) {
      this.SJN.remove();
    }
    AppMethodBeat.o(217348);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(217354);
    if (this.SJN != null) {
      this.SJN.setColor(paramInt);
    }
    AppMethodBeat.o(217354);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(217363);
    if (this.SJN == null)
    {
      AppMethodBeat.o(217363);
      return;
    }
    this.SJN.setColorTexture(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    AppMethodBeat.o(217363);
  }
  
  public final void setDottedLine(boolean paramBoolean) {}
  
  public final void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(217365);
    if (this.SJN == null)
    {
      AppMethodBeat.o(217365);
      return;
    }
    this.SJN.setEraseable(paramBoolean);
    AppMethodBeat.o(217365);
  }
  
  public final void setGeodesic(boolean paramBoolean) {}
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(217357);
    if (this.SJN != null) {
      this.SJN.setLevel(paramInt);
    }
    AppMethodBeat.o(217357);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(217350);
    if (this.SJN != null) {
      this.SJN.setPoints(l.kl(paramList));
    }
    AppMethodBeat.o(217350);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(217360);
    if (this.SJN != null) {
      this.SJN.setVisible(paramBoolean);
    }
    AppMethodBeat.o(217360);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(217352);
    if (this.SJN != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polyline localPolyline = this.SJN;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolyline.setWidth(f);
    }
    AppMethodBeat.o(217352);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(217356);
    if (this.SJN != null) {
      this.SJN.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(217356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */