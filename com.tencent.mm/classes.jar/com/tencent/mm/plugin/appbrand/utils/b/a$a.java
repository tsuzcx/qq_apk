package com.tencent.mm.plugin.appbrand.utils.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public double altitude;
  public String buildingId;
  public double dgG;
  public String floorName;
  public Object hQS;
  public double latitude;
  public double longitude;
  public double mUZ;
  public int mVa;
  public float mVb;
  public double mVc = 0.0D;
  public String provider;
  
  public final String toString()
  {
    AppMethodBeat.i(143729);
    String str = "Location{latitude=" + this.latitude + ", longitude=" + this.longitude + ", provider='" + this.provider + '\'' + ", speed=" + this.dgG + ", accuracy=" + this.mUZ + ", altitude=" + this.altitude + ", buildingId='" + this.buildingId + '\'' + ", floorName='" + this.floorName + '\'' + ", extra=" + this.hQS + ", indoorLocationType=" + this.mVa + ", direction=" + this.mVb + '}';
    AppMethodBeat.o(143729);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b.a.a
 * JD-Core Version:    0.7.0.1
 */