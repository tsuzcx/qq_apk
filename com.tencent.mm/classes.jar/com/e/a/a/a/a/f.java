package com.e.a.a.a.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.List;

public final class f
  implements com.tencent.mapsdk.raster.model.Polyline
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polyline KIT;
  
  public f(com.tencent.tencentmap.mapsdk.maps.model.Polyline paramPolyline)
  {
    this.KIT = paramPolyline;
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(205906);
    if (this.KIT == null)
    {
      AppMethodBeat.o(205906);
      return;
    }
    this.KIT.eraseTo(paramInt, l.c(paramLatLng));
    AppMethodBeat.o(205906);
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(205897);
    if (this.KIT != null)
    {
      int i = this.KIT.getColor();
      AppMethodBeat.o(205897);
      return i;
    }
    AppMethodBeat.o(205897);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(205891);
    if (this.KIT != null)
    {
      String str = this.KIT.getId();
      AppMethodBeat.o(205891);
      return str;
    }
    AppMethodBeat.o(205891);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(205901);
    if (this.KIT != null)
    {
      int i = this.KIT.getLevel();
      AppMethodBeat.o(205901);
      return i;
    }
    AppMethodBeat.o(205901);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(205893);
    if (this.KIT != null)
    {
      List localList = l.iG(this.KIT.getPoints());
      AppMethodBeat.o(205893);
      return localList;
    }
    AppMethodBeat.o(205893);
    return null;
  }
  
  public final float getWidth()
  {
    AppMethodBeat.i(205895);
    if (this.KIT != null)
    {
      float f = this.KIT.getWidth();
      AppMethodBeat.o(205895);
      return f;
    }
    AppMethodBeat.o(205895);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(205900);
    if (this.KIT != null)
    {
      float f = this.KIT.getZIndex();
      AppMethodBeat.o(205900);
      return f;
    }
    AppMethodBeat.o(205900);
    return 0.0F;
  }
  
  public final boolean isDottedLine()
  {
    AppMethodBeat.i(205904);
    if ((this.KIT == null) || (this.KIT.getPattern() == null))
    {
      AppMethodBeat.o(205904);
      return false;
    }
    AppMethodBeat.o(205904);
    return true;
  }
  
  public final boolean isGeodesic()
  {
    return false;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(205903);
    if (this.KIT != null)
    {
      boolean bool = this.KIT.isVisible();
      AppMethodBeat.o(205903);
      return bool;
    }
    AppMethodBeat.o(205903);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(205890);
    if (this.KIT != null) {
      this.KIT.remove();
    }
    AppMethodBeat.o(205890);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(205896);
    if (this.KIT != null) {
      this.KIT.setColor(paramInt);
    }
    AppMethodBeat.o(205896);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(205905);
    if (this.KIT == null)
    {
      AppMethodBeat.o(205905);
      return;
    }
    this.KIT.setColorTexture(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    AppMethodBeat.o(205905);
  }
  
  public final void setDottedLine(boolean paramBoolean) {}
  
  public final void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(205907);
    if (this.KIT == null)
    {
      AppMethodBeat.o(205907);
      return;
    }
    this.KIT.setEraseable(paramBoolean);
    AppMethodBeat.o(205907);
  }
  
  public final void setGeodesic(boolean paramBoolean) {}
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(205899);
    if (this.KIT != null) {
      this.KIT.setLevel(paramInt);
    }
    AppMethodBeat.o(205899);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(205892);
    if (this.KIT != null) {
      this.KIT.setPoints(l.iH(paramList));
    }
    AppMethodBeat.o(205892);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(205902);
    if (this.KIT != null) {
      this.KIT.setVisible(paramBoolean);
    }
    AppMethodBeat.o(205902);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(205894);
    if (this.KIT != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polyline localPolyline = this.KIT;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolyline.setWidth(f);
    }
    AppMethodBeat.o(205894);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(205898);
    if (this.KIT != null) {
      this.KIT.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(205898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */