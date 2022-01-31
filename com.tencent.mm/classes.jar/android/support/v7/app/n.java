package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.f;
import java.util.Calendar;

final class n
{
  static n QC;
  private final LocationManager QD;
  private final a QE = new a();
  private final Context mContext;
  
  n(Context paramContext, LocationManager paramLocationManager)
  {
    this.mContext = paramContext;
    this.QD = paramLocationManager;
  }
  
  private Location N(String paramString)
  {
    try
    {
      if (this.QD.isProviderEnabled(paramString))
      {
        paramString = this.QD.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  final boolean eu()
  {
    a locala = this.QE;
    if (this.QE.QK > System.currentTimeMillis()) {}
    for (int i = 1; i != 0; i = 0) {
      return locala.QF;
    }
    Object localObject1 = null;
    Object localObject2 = null;
    if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
      localObject1 = N("network");
    }
    if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
      localObject2 = N("gps");
    }
    long l1;
    m localm;
    long l2;
    if ((localObject2 != null) && (localObject1 != null)) {
      if (((Location)localObject2).getTime() > ((Location)localObject1).getTime())
      {
        localObject1 = localObject2;
        if (localObject1 == null) {
          break label382;
        }
        localObject2 = this.QE;
        l1 = System.currentTimeMillis();
        if (m.Qz == null) {
          m.Qz = new m();
        }
        localm = m.Qz;
        localm.a(l1 - 86400000L, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
        l2 = localm.QA;
        localm.a(l1, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
        if (localm.state != 1) {
          break label332;
        }
      }
    }
    long l3;
    long l4;
    long l5;
    label332:
    for (boolean bool = true;; bool = false)
    {
      l3 = localm.QB;
      l4 = localm.QA;
      localm.a(86400000L + l1, ((Location)localObject1).getLatitude(), ((Location)localObject1).getLongitude());
      l5 = localm.QB;
      if ((l3 != -1L) && (l4 != -1L)) {
        break label338;
      }
      l1 = 43200000L + l1;
      ((a)localObject2).QF = bool;
      ((a)localObject2).QG = l2;
      ((a)localObject2).QH = l3;
      ((a)localObject2).QI = l4;
      ((a)localObject2).QJ = l5;
      ((a)localObject2).QK = l1;
      return locala.QF;
      break;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        break;
      }
      break;
    }
    label338:
    if (l1 > l4) {
      l1 = 0L + l5;
    }
    for (;;)
    {
      l1 += 60000L;
      break;
      if (l1 > l3) {
        l1 = 0L + l4;
      } else {
        l1 = 0L + l3;
      }
    }
    label382:
    i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  private static final class a
  {
    boolean QF;
    long QG;
    long QH;
    long QI;
    long QJ;
    long QK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.n
 * JD-Core Version:    0.7.0.1
 */