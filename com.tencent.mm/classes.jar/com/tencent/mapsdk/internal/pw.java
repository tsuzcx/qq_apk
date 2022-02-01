package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;

public final class pw
{
  public int a;
  public sc b;
  
  public pw(sc paramsc, GeoPoint[] paramArrayOfGeoPoint, PolylineOptions.Text paramText)
  {
    AppMethodBeat.i(225639);
    this.b = paramsc;
    if (this.b == null)
    {
      AppMethodBeat.o(225639);
      return;
    }
    paramsc = this.b;
    this.a = ((Integer)paramsc.a(new sc.45(paramsc, paramArrayOfGeoPoint, paramText), Integer.valueOf(-1))).intValue();
    AppMethodBeat.o(225639);
  }
  
  private void a(PolylineOptions.Text paramText)
  {
    AppMethodBeat.i(225649);
    if ((this.b == null) || (this.a <= 0))
    {
      AppMethodBeat.o(225649);
      return;
    }
    sc localsc = this.b;
    localsc.a(new sc.48(localsc, this.a, paramText));
    AppMethodBeat.o(225649);
  }
  
  public final void a()
  {
    AppMethodBeat.i(225657);
    if ((this.b == null) || (this.a <= 0))
    {
      AppMethodBeat.o(225657);
      return;
    }
    this.b.f(this.a);
    AppMethodBeat.o(225657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pw
 * JD-Core Version:    0.7.0.1
 */