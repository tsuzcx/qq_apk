package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.f;
import java.util.Calendar;

final class i
{
  private static i Ye;
  private final LocationManager Yf;
  private final a Yg = new a();
  private final Context mContext;
  
  private i(Context paramContext, LocationManager paramLocationManager)
  {
    this.mContext = paramContext;
    this.Yf = paramLocationManager;
  }
  
  private Location C(String paramString)
  {
    try
    {
      if (this.Yf.isProviderEnabled(paramString))
      {
        paramString = this.Yf.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static i Y(Context paramContext)
  {
    if (Ye == null)
    {
      paramContext = paramContext.getApplicationContext();
      Ye = new i(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return Ye;
  }
  
  private void a(Location paramLocation)
  {
    a locala = this.Yg;
    long l1 = System.currentTimeMillis();
    h localh = h.gu();
    localh.b(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localh.Yc;
    localh.b(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localh.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localh.Yd;
      l4 = localh.Yc;
      localh.b(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localh.Yd;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.Yh = bool;
      locala.Yi = l2;
      locala.Yj = l3;
      locala.Yk = l4;
      locala.Yl = l5;
      locala.Ym = l1;
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
  private Location gw()
  {
    Location localLocation2 = null;
    if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation1 = C("network");; localLocation1 = null)
    {
      if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localLocation2 = C("gps");
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
  
  private boolean gx()
  {
    return this.Yg.Ym > System.currentTimeMillis();
  }
  
  final boolean gv()
  {
    a locala = this.Yg;
    if (gx()) {
      return locala.Yh;
    }
    Location localLocation = gw();
    if (localLocation != null)
    {
      a(localLocation);
      return locala.Yh;
    }
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  static final class a
  {
    boolean Yh;
    long Yi;
    long Yj;
    long Yk;
    long Yl;
    long Ym;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.i
 * JD-Core Version:    0.7.0.1
 */