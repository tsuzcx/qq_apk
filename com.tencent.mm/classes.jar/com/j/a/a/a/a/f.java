package com.j.a.a.a.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.List;

public final class f
  implements com.tencent.mapsdk.raster.model.Polyline
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polyline airu;
  
  public f(com.tencent.tencentmap.mapsdk.maps.model.Polyline paramPolyline)
  {
    this.airu = paramPolyline;
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(207218);
    if (this.airu == null)
    {
      AppMethodBeat.o(207218);
      return;
    }
    this.airu.eraseTo(paramInt, l.d(paramLatLng));
    AppMethodBeat.o(207218);
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(207097);
    if (this.airu != null)
    {
      int i = this.airu.getColor();
      AppMethodBeat.o(207097);
      return i;
    }
    AppMethodBeat.o(207097);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(207034);
    if (this.airu != null)
    {
      String str = this.airu.getId();
      AppMethodBeat.o(207034);
      return str;
    }
    AppMethodBeat.o(207034);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(207140);
    if (this.airu != null)
    {
      int i = this.airu.getLevel();
      AppMethodBeat.o(207140);
      return i;
    }
    AppMethodBeat.o(207140);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(207053);
    if (this.airu != null)
    {
      List localList = l.oC(this.airu.getPoints());
      AppMethodBeat.o(207053);
      return localList;
    }
    AppMethodBeat.o(207053);
    return null;
  }
  
  public final float getWidth()
  {
    AppMethodBeat.i(207076);
    if (this.airu != null)
    {
      float f = this.airu.getWidth();
      AppMethodBeat.o(207076);
      return f;
    }
    AppMethodBeat.o(207076);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(207132);
    if (this.airu != null)
    {
      float f = this.airu.getZIndex();
      AppMethodBeat.o(207132);
      return f;
    }
    AppMethodBeat.o(207132);
    return 0.0F;
  }
  
  public final boolean isDottedLine()
  {
    AppMethodBeat.i(207201);
    if ((this.airu == null) || (this.airu.getPattern() == null))
    {
      AppMethodBeat.o(207201);
      return false;
    }
    AppMethodBeat.o(207201);
    return true;
  }
  
  public final boolean isGeodesic()
  {
    return false;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(207162);
    if (this.airu != null)
    {
      boolean bool = this.airu.isVisible();
      AppMethodBeat.o(207162);
      return bool;
    }
    AppMethodBeat.o(207162);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(207027);
    if (this.airu != null) {
      this.airu.remove();
    }
    AppMethodBeat.o(207027);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(207083);
    if (this.airu != null) {
      this.airu.setColor(paramInt);
    }
    AppMethodBeat.o(207083);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(207207);
    if (this.airu == null)
    {
      AppMethodBeat.o(207207);
      return;
    }
    this.airu.setColorTexture(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    AppMethodBeat.o(207207);
  }
  
  public final void setDottedLine(boolean paramBoolean) {}
  
  public final void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(207224);
    if (this.airu == null)
    {
      AppMethodBeat.o(207224);
      return;
    }
    this.airu.setEraseable(paramBoolean);
    AppMethodBeat.o(207224);
  }
  
  public final void setGeodesic(boolean paramBoolean) {}
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(207118);
    if (this.airu != null) {
      this.airu.setLevel(paramInt);
    }
    AppMethodBeat.o(207118);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(207043);
    if (this.airu != null) {
      this.airu.setPoints(l.oD(paramList));
    }
    AppMethodBeat.o(207043);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(207151);
    if (this.airu != null) {
      this.airu.setVisible(paramBoolean);
    }
    AppMethodBeat.o(207151);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(207066);
    if (this.airu != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polyline localPolyline = this.airu;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolyline.setWidth(f);
    }
    AppMethodBeat.o(207066);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(207108);
    if (this.airu != null) {
      this.airu.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(207108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.j.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */