package c.t.m.g;

import android.location.Location;

public final class eb
  extends ed
{
  public final Location a;
  public final long b;
  public final int c;
  public final int d;
  private int e;
  private int f;
  
  public eb(Location paramLocation, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramLocation;
    this.b = paramLong;
    this.e = paramInt1;
    this.c = paramInt2;
    this.f = paramInt3;
    this.d = paramInt4;
  }
  
  public final String toString()
  {
    return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.e + ", usedSatelliteNum=" + this.c + ", gpsStatus=" + this.f + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     c.t.m.g.eb
 * JD-Core Version:    0.7.0.1
 */