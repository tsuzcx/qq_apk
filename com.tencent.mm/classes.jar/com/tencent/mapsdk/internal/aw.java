package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.List;

public final class aw
  extends au<ap>
  implements Polygon
{
  ap a;
  
  public aw(ap paramap)
  {
    this.a = paramap;
  }
  
  private ap b()
  {
    return this.a;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(224283);
    boolean bool = this.a.contains(paramLatLng);
    AppMethodBeat.o(224283);
    return bool;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(224231);
    int i = this.a.getFillColor();
    AppMethodBeat.o(224231);
    return i;
  }
  
  public final List<LatLng> getPoints()
  {
    AppMethodBeat.i(224178);
    List localList = this.a.getPoints();
    AppMethodBeat.o(224178);
    return localList;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(224211);
    int i = this.a.getStrokeColor();
    AppMethodBeat.o(224211);
    return i;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(224194);
    float f = this.a.getStrokeWidth();
    AppMethodBeat.o(224194);
    return f;
  }
  
  public final Object getTag()
  {
    AppMethodBeat.i(224256);
    Object localObject = this.a.getTag();
    AppMethodBeat.o(224256);
    return localObject;
  }
  
  public final boolean isClickable()
  {
    AppMethodBeat.i(224272);
    if (this.a != null)
    {
      boolean bool = this.a.isClickable();
      AppMethodBeat.o(224272);
      return bool;
    }
    AppMethodBeat.o(224272);
    return false;
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(224262);
    this.a.setClickable(paramBoolean);
    AppMethodBeat.o(224262);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(224222);
    this.a.setFillColor(paramInt);
    AppMethodBeat.o(224222);
  }
  
  public final void setOptions(PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(224240);
    this.a.setOptions(paramPolygonOptions);
    AppMethodBeat.o(224240);
  }
  
  public final void setPoints(List<LatLng> paramList)
  {
    AppMethodBeat.i(224170);
    if (this.a == null)
    {
      AppMethodBeat.o(224170);
      return;
    }
    this.a.setPoints(paramList);
    AppMethodBeat.o(224170);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(224201);
    this.a.setStrokeColor(paramInt);
    AppMethodBeat.o(224201);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(224187);
    this.a.setStrokeWidth(paramFloat);
    AppMethodBeat.o(224187);
  }
  
  public final void setTag(Object paramObject)
  {
    AppMethodBeat.i(224249);
    this.a.setTag(paramObject);
    AppMethodBeat.o(224249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.aw
 * JD-Core Version:    0.7.0.1
 */