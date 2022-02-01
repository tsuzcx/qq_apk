package com.f.a.a.a.a;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.util.List;

public final class f
  implements com.tencent.mapsdk.raster.model.Polyline
{
  private com.tencent.tencentmap.mapsdk.maps.model.Polyline Mzy;
  
  public f(com.tencent.tencentmap.mapsdk.maps.model.Polyline paramPolyline)
  {
    this.Mzy = paramPolyline;
  }
  
  public final void eraseTo(int paramInt, LatLng paramLatLng)
  {
    AppMethodBeat.i(200012);
    if (this.Mzy == null)
    {
      AppMethodBeat.o(200012);
      return;
    }
    this.Mzy.eraseTo(paramInt, l.c(paramLatLng));
    AppMethodBeat.o(200012);
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(200003);
    if (this.Mzy != null)
    {
      int i = this.Mzy.getColor();
      AppMethodBeat.o(200003);
      return i;
    }
    AppMethodBeat.o(200003);
    return 0;
  }
  
  public final String getId()
  {
    AppMethodBeat.i(199997);
    if (this.Mzy != null)
    {
      String str = this.Mzy.getId();
      AppMethodBeat.o(199997);
      return str;
    }
    AppMethodBeat.o(199997);
    return null;
  }
  
  public final int getLevel()
  {
    AppMethodBeat.i(200007);
    if (this.Mzy != null)
    {
      int i = this.Mzy.getLevel();
      AppMethodBeat.o(200007);
      return i;
    }
    AppMethodBeat.o(200007);
    return 0;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(199999);
    if (this.Mzy != null)
    {
      List localList = l.iU(this.Mzy.getPoints());
      AppMethodBeat.o(199999);
      return localList;
    }
    AppMethodBeat.o(199999);
    return null;
  }
  
  public final float getWidth()
  {
    AppMethodBeat.i(200001);
    if (this.Mzy != null)
    {
      float f = this.Mzy.getWidth();
      AppMethodBeat.o(200001);
      return f;
    }
    AppMethodBeat.o(200001);
    return 0.0F;
  }
  
  public final float getZIndex()
  {
    AppMethodBeat.i(200006);
    if (this.Mzy != null)
    {
      float f = this.Mzy.getZIndex();
      AppMethodBeat.o(200006);
      return f;
    }
    AppMethodBeat.o(200006);
    return 0.0F;
  }
  
  public final boolean isDottedLine()
  {
    AppMethodBeat.i(200010);
    if ((this.Mzy == null) || (this.Mzy.getPattern() == null))
    {
      AppMethodBeat.o(200010);
      return false;
    }
    AppMethodBeat.o(200010);
    return true;
  }
  
  public final boolean isGeodesic()
  {
    return false;
  }
  
  public final boolean isVisible()
  {
    AppMethodBeat.i(200009);
    if (this.Mzy != null)
    {
      boolean bool = this.Mzy.isVisible();
      AppMethodBeat.o(200009);
      return bool;
    }
    AppMethodBeat.o(200009);
    return false;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(199996);
    if (this.Mzy != null) {
      this.Mzy.remove();
    }
    AppMethodBeat.o(199996);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(200002);
    if (this.Mzy != null) {
      this.Mzy.setColor(paramInt);
    }
    AppMethodBeat.o(200002);
  }
  
  public final void setColorTexture(BitmapDescriptor paramBitmapDescriptor)
  {
    AppMethodBeat.i(200011);
    if (this.Mzy == null)
    {
      AppMethodBeat.o(200011);
      return;
    }
    this.Mzy.setColorTexture(BitmapDescriptorFactory.fromBitmap(paramBitmapDescriptor.getBitmap()));
    AppMethodBeat.o(200011);
  }
  
  public final void setDottedLine(boolean paramBoolean) {}
  
  public final void setEraseable(boolean paramBoolean)
  {
    AppMethodBeat.i(200013);
    if (this.Mzy == null)
    {
      AppMethodBeat.o(200013);
      return;
    }
    this.Mzy.setEraseable(paramBoolean);
    AppMethodBeat.o(200013);
  }
  
  public final void setGeodesic(boolean paramBoolean) {}
  
  public final void setLevel(int paramInt)
  {
    AppMethodBeat.i(200005);
    if (this.Mzy != null) {
      this.Mzy.setLevel(paramInt);
    }
    AppMethodBeat.o(200005);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(199998);
    if (this.Mzy != null) {
      this.Mzy.setPoints(l.iV(paramList));
    }
    AppMethodBeat.o(199998);
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(200008);
    if (this.Mzy != null) {
      this.Mzy.setVisible(paramBoolean);
    }
    AppMethodBeat.o(200008);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(200000);
    if (this.Mzy != null)
    {
      com.tencent.tencentmap.mapsdk.maps.model.Polyline localPolyline = this.Mzy;
      float f = paramFloat;
      if (paramFloat < 0.0F) {
        f = 0.0F;
      }
      localPolyline.setWidth(f);
    }
    AppMethodBeat.o(200000);
  }
  
  public final void setZIndex(float paramFloat)
  {
    AppMethodBeat.i(200004);
    if (this.Mzy != null) {
      this.Mzy.setZIndex((int)paramFloat);
    }
    AppMethodBeat.o(200004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.f.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */