package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class as
  extends au<ag>
  implements Circle
{
  private ag a;
  
  public as(ag paramag)
  {
    this.a = paramag;
  }
  
  private ag b()
  {
    return this.a;
  }
  
  public final boolean contains(LatLng paramLatLng)
  {
    AppMethodBeat.i(224327);
    boolean bool = this.a.contains(paramLatLng);
    AppMethodBeat.o(224327);
    return bool;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(224348);
    LatLng localLatLng = this.a.getCenter();
    AppMethodBeat.o(224348);
    return localLatLng;
  }
  
  public final int getFillColor()
  {
    AppMethodBeat.i(224424);
    int i = this.a.getFillColor();
    AppMethodBeat.o(224424);
    return i;
  }
  
  public final double getRadius()
  {
    AppMethodBeat.i(224369);
    double d = this.a.getRadius();
    AppMethodBeat.o(224369);
    return d;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(224455);
    int i = this.a.getStrokeColor();
    AppMethodBeat.o(224455);
    return i;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(224438);
    float f = this.a.getStrokeWidth();
    AppMethodBeat.o(224438);
    return f;
  }
  
  public final Object getTag()
  {
    AppMethodBeat.i(224468);
    Object localObject = this.a.getTag();
    AppMethodBeat.o(224468);
    return localObject;
  }
  
  public final boolean isClickable()
  {
    AppMethodBeat.i(224403);
    boolean bool = this.a.isClickable();
    AppMethodBeat.o(224403);
    return bool;
  }
  
  public final void setCenter(LatLng paramLatLng)
  {
    AppMethodBeat.i(224337);
    this.a.setCenter(paramLatLng);
    AppMethodBeat.o(224337);
  }
  
  public final void setClickable(boolean paramBoolean)
  {
    AppMethodBeat.i(224392);
    this.a.setClickable(paramBoolean);
    AppMethodBeat.o(224392);
  }
  
  public final void setFillColor(int paramInt)
  {
    AppMethodBeat.i(224413);
    this.a.setFillColor(paramInt);
    AppMethodBeat.o(224413);
  }
  
  @Deprecated
  public final void setOptions(CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(224383);
    this.a.setOptions(paramCircleOptions);
    AppMethodBeat.o(224383);
  }
  
  public final void setRadius(double paramDouble)
  {
    AppMethodBeat.i(224360);
    this.a.setRadius(paramDouble);
    AppMethodBeat.o(224360);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(224446);
    this.a.setStrokeColor(paramInt);
    AppMethodBeat.o(224446);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(224430);
    this.a.setStrokeWidth(paramFloat);
    AppMethodBeat.o(224430);
  }
  
  public final void setTag(Object paramObject)
  {
    AppMethodBeat.i(224463);
    this.a.setTag(paramObject);
    AppMethodBeat.o(224463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.as
 * JD-Core Version:    0.7.0.1
 */