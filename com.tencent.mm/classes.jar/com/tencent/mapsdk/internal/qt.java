package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.util.List;

public final class qt
{
  public long a;
  public LatLngBounds b;
  public List<Detail> c;
  
  public qt(LatLngBounds paramLatLngBounds, List<Detail> paramList)
  {
    AppMethodBeat.i(226180);
    this.a = System.currentTimeMillis();
    this.b = paramLatLngBounds;
    this.c = paramList;
    AppMethodBeat.o(226180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qt
 * JD-Core Version:    0.7.0.1
 */