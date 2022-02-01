package com.f.a.a.a.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.List;

public final class f
  implements com.tencent.mapsdk.raster.model.Polyline
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polyline MWF;
  
  public f(com.tencent.tencentmap.mapsdk.maps.model.Polyline paramPolyline)
  {
    this.MWF = paramPolyline;
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(212704);
    if (this.MWF == null)
    {
      AppMethodBeat.o(212704);
      return;
    }
    this.MWF.eraseTo(paramInt, l.c(paramLatLng));
    AppMethodBeat.o(212704);
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(212695);
    if (this.MWF != null)
    {
      int i = this.MWF.getColor();
      AppMethodBeat.o(212695);
      return i;
    }
    AppMethodBeat.o(212695);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(212689);
    if (this.MWF != null)
    {
      String str = this.MWF.getId();
      AppMethodBeat.o(212689);
      return str;
    }
    AppMethodBeat.o(212689);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(212699);
    if (this.MWF != null)
    {
      int i = this.MWF.getLevel();
      AppMethodBeat.o(212699);
      return i;
    }
    AppMethodBeat.o(212699);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(212691);
    if (this.MWF != null)
    {
      List localList = l.jd(this.MWF.getPoints());
      AppMethodBeat.o(212691);
      return localList;
    }
    AppMethodBeat.o(212691);
    return null;
  }
  
  public final float getWidth()
  {
    AppMethodBeat.i(212693);
    if (this.MWF != null)
    {
      float f = this.MWF.getWidth();
      AppMethodBeat.o(212693);
      return f;
    }
    AppMethodBeat.o(212693);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(212698);
    if (this.MWF != null)
    {
      float f = this.MWF.getZIndex();
      AppMethodBeat.o(212698);
      return f;
    }
    AppMethodBeat.o(212698);
    return 0.0F;
  }
  
  public final boolean isDottedLine()
  {
    AppMethodBeat.i(212702);
    if ((this.MWF == null) || (this.MWF.getPattern() == null))
    {
      AppMethodBeat.o(212702);
      return false;
    }
    AppMethodBeat.o(212702);
    return true;
  }
  
  public final boolean isGeodesic()
  {
    return false;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(212701);
    if (this.MWF != null)
    {
      boolean bool = this.MWF.isVisible();
      AppMethodBeat.o(212701);
      return bool;
    }
    AppMethodBeat.o(212701);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(212688);
    if (this.MWF != null) {
      this.MWF.remove();
    }
    AppMethodBeat.o(212688);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(212694);
    if (this.MWF != null) {
      this.MWF.setColor(paramInt);
    }
    AppMethodBeat.o(212694);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(212703);
    if (this.MWF == null)
    {
      AppMethodBeat.o(212703);
      return;
    }
    this.MWF.setColorTexture(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    AppMethodBeat.o(212703);
  }
  
  public final void setDottedLine(boolean paramBoolean) {}
  
  public final void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(212705);
    if (this.MWF == null)
    {
      AppMethodBeat.o(212705);
      return;
    }
    this.MWF.setEraseable(paramBoolean);
    AppMethodBeat.o(212705);
  }
  
  public final void setGeodesic(boolean paramBoolean) {}
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(212697);
    if (this.MWF != null) {
      this.MWF.setLevel(paramInt);
    }
    AppMethodBeat.o(212697);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(212690);
    if (this.MWF != null) {
      this.MWF.setPoints(l.je(paramList));
    }
    AppMethodBeat.o(212690);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(212700);
    if (this.MWF != null) {
      this.MWF.setVisible(paramBoolean);
    }
    AppMethodBeat.o(212700);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(212692);
    if (this.MWF != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polyline localPolyline = this.MWF;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolyline.setWidth(f);
    }
    AppMethodBeat.o(212692);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(212696);
    if (this.MWF != null) {
      this.MWF.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(212696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */