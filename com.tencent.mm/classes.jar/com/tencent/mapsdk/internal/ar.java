package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class ar
  extends au<af>
  implements Arc
{
  private af a;
  
  public ar(af paramaf)
  {
    this.a = paramaf;
  }
  
  private af b()
  {
    return this.a;
  }
  
  public final LatLng getCenter()
  {
    AppMethodBeat.i(224431);
    LatLng localLatLng = this.a.getCenter();
    AppMethodBeat.o(224431);
    return localLatLng;
  }
  
  public final int getColor()
  {
    AppMethodBeat.i(224423);
    int i = this.a.getColor();
    AppMethodBeat.o(224423);
    return i;
  }
  
  public final double getLength()
  {
    AppMethodBeat.i(224439);
    double d = this.a.getLength();
    AppMethodBeat.o(224439);
    return d;
  }
  
  public final double getRadius()
  {
    AppMethodBeat.i(224445);
    double d = this.a.getRadius();
    AppMethodBeat.o(224445);
    return d;
  }
  
  public final int getStrokeColor()
  {
    AppMethodBeat.i(224405);
    int i = this.a.getStrokeColor();
    AppMethodBeat.o(224405);
    return i;
  }
  
  public final float getStrokeWidth()
  {
    AppMethodBeat.i(224382);
    float f = this.a.getStrokeWidth();
    AppMethodBeat.o(224382);
    return f;
  }
  
  public final float getWidth()
  {
    AppMethodBeat.i(224461);
    float f = this.a.getWidth();
    AppMethodBeat.o(224461);
    return f;
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(224415);
    this.a.setColor(paramInt);
    AppMethodBeat.o(224415);
  }
  
  public final void setStrokeColor(int paramInt)
  {
    AppMethodBeat.i(224391);
    this.a.setStrokeColor(paramInt);
    AppMethodBeat.o(224391);
  }
  
  public final void setStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(224370);
    this.a.setStrokeWidth(paramFloat);
    AppMethodBeat.o(224370);
  }
  
  public final void setWidth(float paramFloat)
  {
    AppMethodBeat.i(224453);
    this.a.setWidth(paramFloat);
    AppMethodBeat.o(224453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ar
 * JD-Core Version:    0.7.0.1
 */