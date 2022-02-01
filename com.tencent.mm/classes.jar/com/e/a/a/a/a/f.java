package com.e.a.a.a.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.List;

public final class f
  implements com.tencent.mapsdk.raster.model.Polyline
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polyline aalH;
  
  public f(com.tencent.tencentmap.mapsdk.maps.model.Polyline paramPolyline)
  {
    this.aalH = paramPolyline;
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(186968);
    if (this.aalH == null)
    {
      AppMethodBeat.o(186968);
      return;
    }
    this.aalH.eraseTo(paramInt, l.c(paramLatLng));
    AppMethodBeat.o(186968);
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(186927);
    if (this.aalH != null)
    {
      int i = this.aalH.getColor();
      AppMethodBeat.o(186927);
      return i;
    }
    AppMethodBeat.o(186927);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(186917);
    if (this.aalH != null)
    {
      String str = this.aalH.getId();
      AppMethodBeat.o(186917);
      return str;
    }
    AppMethodBeat.o(186917);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(186943);
    if (this.aalH != null)
    {
      int i = this.aalH.getLevel();
      AppMethodBeat.o(186943);
      return i;
    }
    AppMethodBeat.o(186943);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(186920);
    if (this.aalH != null)
    {
      List localList = l.le(this.aalH.getPoints());
      AppMethodBeat.o(186920);
      return localList;
    }
    AppMethodBeat.o(186920);
    return null;
  }
  
  public final float getWidth()
  {
    AppMethodBeat.i(186925);
    if (this.aalH != null)
    {
      float f = this.aalH.getWidth();
      AppMethodBeat.o(186925);
      return f;
    }
    AppMethodBeat.o(186925);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(186937);
    if (this.aalH != null)
    {
      float f = this.aalH.getZIndex();
      AppMethodBeat.o(186937);
      return f;
    }
    AppMethodBeat.o(186937);
    return 0.0F;
  }
  
  public final boolean isDottedLine()
  {
    AppMethodBeat.i(186963);
    if ((this.aalH == null) || (this.aalH.getPattern() == null))
    {
      AppMethodBeat.o(186963);
      return false;
    }
    AppMethodBeat.o(186963);
    return true;
  }
  
  public final boolean isGeodesic()
  {
    return false;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(186946);
    if (this.aalH != null)
    {
      boolean bool = this.aalH.isVisible();
      AppMethodBeat.o(186946);
      return bool;
    }
    AppMethodBeat.o(186946);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(186915);
    if (this.aalH != null) {
      this.aalH.remove();
    }
    AppMethodBeat.o(186915);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(186926);
    if (this.aalH != null) {
      this.aalH.setColor(paramInt);
    }
    AppMethodBeat.o(186926);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(186966);
    if (this.aalH == null)
    {
      AppMethodBeat.o(186966);
      return;
    }
    this.aalH.setColorTexture(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    AppMethodBeat.o(186966);
  }
  
  public final void setDottedLine(boolean paramBoolean) {}
  
  public final void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(186970);
    if (this.aalH == null)
    {
      AppMethodBeat.o(186970);
      return;
    }
    this.aalH.setEraseable(paramBoolean);
    AppMethodBeat.o(186970);
  }
  
  public final void setGeodesic(boolean paramBoolean) {}
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(186930);
    if (this.aalH != null) {
      this.aalH.setLevel(paramInt);
    }
    AppMethodBeat.o(186930);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(186918);
    if (this.aalH != null) {
      this.aalH.setPoints(l.lf(paramList));
    }
    AppMethodBeat.o(186918);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(186945);
    if (this.aalH != null) {
      this.aalH.setVisible(paramBoolean);
    }
    AppMethodBeat.o(186945);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(186923);
    if (this.aalH != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polyline localPolyline = this.aalH;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolyline.setWidth(f);
    }
    AppMethodBeat.o(186923);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(186929);
    if (this.aalH != null) {
      this.aalH.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(186929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */