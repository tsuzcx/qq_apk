package c.t.m.g;

import android.location.Location;

public final class bx
{
  public final Location a;
  public final long b;
  private int c;
  private int d;
  private int e;
  
  public bx(Location paramLocation, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramLocation;
    this.b = paramLong;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
  }
  
  public bx(bx parambx)
  {
    if (parambx.a == null) {}
    for (Location localLocation = null;; localLocation = new Location(parambx.a))
    {
      this.a = localLocation;
      this.b = parambx.b;
      this.c = parambx.c;
      this.d = parambx.d;
      this.e = parambx.e;
      return;
    }
  }
  
  public final boolean a()
  {
    if (this.a == null) {}
    while (((this.d > 0) && (this.d < 3)) || (System.currentTimeMillis() - this.b > 30000L)) {
      return false;
    }
    return true;
  }
  
  public final String toString()
  {
    return "TxGpsInfo [location=" + this.a + ", gpsTime=" + this.b + ", visbleSatelliteNum=" + this.c + ", usedSatelliteNum=" + this.d + ", gpsStatus=" + this.e + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bx
 * JD-Core Version:    0.7.0.1
 */