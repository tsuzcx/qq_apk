package com.tencent.mm.plugin.appbrand.utils.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public double altitude;
  public String buildingId;
  public double dxQ;
  public String floorName;
  public Object iMa;
  public double latitude;
  public double longitude;
  public double ohZ;
  public int oia;
  public float oib;
  public double oic = 0.0D;
  public String provider;
  
  public final String toString()
  {
    AppMethodBeat.i(143729);
    String str = "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", provider='" + this.provider + '\'' + ", speed=" + this.dxQ + ", accuracy=" + this.ohZ + ", altitude=" + this.altitude + ", buildingId='" + this.buildingId + '\'' + ", floorName='" + this.floorName + '\'' + ", extra=" + this.iMa + ", indoorLocationType=" + this.oia + ", direction=" + this.oib + '}';
    AppMethodBeat.o(143729);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b.a.a
 * JD-Core Version:    0.7.0.1
 */