package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;

final class dw$a
{
  double a;
  double b;
  long c;
  int d;
  
  static a a(TencentLocation paramTencentLocation)
  {
    int i = 2;
    a locala = new a();
    locala.a = paramTencentLocation.getLatitude();
    locala.b = paramTencentLocation.getLongitude();
    locala.c = paramTencentLocation.getTime();
    paramTencentLocation.getSpeed();
    if (TencentLocationUtils.isFromGps(paramTencentLocation))
    {
      if (paramTencentLocation.getAccuracy() < 100.0F) {
        i = 3;
      }
      locala.d = i;
      return locala;
    }
    if (paramTencentLocation.getAccuracy() < 500.0F) {}
    for (;;)
    {
      locala.d = i;
      return locala;
      i = 1;
    }
  }
  
  public final String toString()
  {
    return "[" + this.a + "," + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.dw.a
 * JD-Core Version:    0.7.0.1
 */