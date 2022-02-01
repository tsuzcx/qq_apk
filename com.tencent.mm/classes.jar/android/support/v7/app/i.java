package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.f;
import java.util.Calendar;

final class i
{
  private static i Xj;
  private final LocationManager Xk;
  private final a Xl = new a();
  private final Context mContext;
  
  private i(Context paramContext, LocationManager paramLocationManager)
  {
    this.mContext = paramContext;
    this.Xk = paramLocationManager;
  }
  
  private Location A(String paramString)
  {
    try
    {
      if (this.Xk.isProviderEnabled(paramString))
      {
        paramString = this.Xk.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static i X(Context paramContext)
  {
    if (Xj == null)
    {
      paramContext = paramContext.getApplicationContext();
      Xj = new i(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return Xj;
  }
  
  private void a(Location paramLocation)
  {
    a locala = this.Xl;
    long l1 = System.currentTimeMillis();
    h localh = h.gm();
    localh.b(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localh.Xh;
    localh.b(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localh.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localh.Xi;
      l4 = localh.Xh;
      localh.b(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localh.Xi;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.Xm = bool;
      locala.Xn = l2;
      locala.Xo = l3;
      locala.Xp = l4;
      locala.Xq = l5;
      locala.Xr = l1;
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
  private Location go()
  {
    Location localLocation2 = null;
    if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation1 = A("network");; localLocation1 = null)
    {
      if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localLocation2 = A("gps");
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
  
  private boolean gp()
  {
    return this.Xl.Xr > System.currentTimeMillis();
  }
  
  final boolean gn()
  {
    a locala = this.Xl;
    if (gp()) {
      return locala.Xm;
    }
    Location localLocation = go();
    if (localLocation != null)
    {
      a(localLocation);
      return locala.Xm;
    }
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  static final class a
  {
    boolean Xm;
    long Xn;
    long Xo;
    long Xp;
    long Xq;
    long Xr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.i
 * JD-Core Version:    0.7.0.1
 */