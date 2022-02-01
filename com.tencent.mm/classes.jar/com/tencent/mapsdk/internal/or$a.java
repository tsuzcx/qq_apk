package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

final class or$a
{
  LatLng[] a;
  
  or$a(or paramor, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(221619);
    this.a = new LatLng[2];
    this.a[0] = paramLatLng1;
    this.a[1] = paramLatLng2;
    AppMethodBeat.o(221619);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221625);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a[0].toString());
    ((StringBuilder)localObject).append("    ");
    ((StringBuilder)localObject).append(this.a[1].toString());
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(221625);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.internal.or.a
 * JD-Core Version:    0.7.0.1
 */