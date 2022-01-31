package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.f;
import java.util.Calendar;

final class i
{
  private static i Qk;
  private final LocationManager Ql;
  private final a Qm = new a();
  private final Context mContext;
  
  private i(Context paramContext, LocationManager paramLocationManager)
  {
    this.mContext = paramContext;
    this.Ql = paramLocationManager;
  }
  
  private Location O(String paramString)
  {
    try
    {
      if (this.Ql.isProviderEnabled(paramString))
      {
        paramString = this.Ql.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static i V(Context paramContext)
  {
    if (Qk == null)
    {
      paramContext = paramContext.getApplicationContext();
      Qk = new i(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return Qk;
  }
  
  private void a(Location paramLocation)
  {
    a locala = this.Qm;
    long l1 = System.currentTimeMillis();
    h localh = h.eT();
    localh.a(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localh.Qi;
    localh.a(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localh.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localh.Qj;
      l4 = localh.Qi;
      localh.a(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localh.Qj;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.Qn = bool;
      locala.Qo = l2;
      locala.Qp = l3;
      locala.Qq = l4;
      locala.Qr = l5;
      locala.Qs = l1;
      return;
    }
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
  }
  
  @SuppressLint({"MissingPermission"})
  private Location eV()
  {
    Location localLocation2 = null;
    if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation1 = O("network");; localLocation1 = null)
    {
      if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localLocation2 = O("gps");
      }
      Location localLocation3;
      if ((localLocation2 != null) && (localLocation1 != null))
      {
        localLocation3 = localLocation1;
        if (localLocation2.getTime() > localLocation1.getTime()) {
          localLocation3 = localLocation2;
        }
      }
      do
      {
        return localLocation3;
        localLocation3 = localLocation1;
      } while (localLocation2 == null);
      return localLocation2;
    }
  }
  
  private boolean eW()
  {
    return this.Qm.Qs > System.currentTimeMillis();
  }
  
  final boolean eU()
  {
    a locala = this.Qm;
    if (eW()) {
      return locala.Qn;
    }
    Location localLocation = eV();
    if (localLocation != null)
    {
      a(localLocation);
      return locala.Qn;
    }
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  static final class a
  {
    boolean Qn;
    long Qo;
    long Qp;
    long Qq;
    long Qr;
    long Qs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.i
 * JD-Core Version:    0.7.0.1
 */