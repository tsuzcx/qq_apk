package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.f;
import java.util.Calendar;

final class i
{
  private static i ZT;
  private final LocationManager ZU;
  private final a ZV = new a();
  private final Context mContext;
  
  private i(Context paramContext, LocationManager paramLocationManager)
  {
    this.mContext = paramContext;
    this.ZU = paramLocationManager;
  }
  
  private Location B(String paramString)
  {
    try
    {
      if (this.ZU.isProviderEnabled(paramString))
      {
        paramString = this.ZU.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  static i Y(Context paramContext)
  {
    if (ZT == null)
    {
      paramContext = paramContext.getApplicationContext();
      ZT = new i(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return ZT;
  }
  
  private void a(Location paramLocation)
  {
    a locala = this.ZV;
    long l1 = System.currentTimeMillis();
    h localh = h.gL();
    localh.b(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localh.ZR;
    localh.b(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localh.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localh.ZS;
      l4 = localh.ZR;
      localh.b(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localh.ZS;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.ZW = bool;
      locala.ZX = l2;
      locala.ZY = l3;
      locala.ZZ = l4;
      locala.aaa = l5;
      locala.aab = l1;
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
  private Location gN()
  {
    Location localLocation2 = null;
    if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {}
    for (Location localLocation1 = B("network");; localLocation1 = null)
    {
      if (f.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localLocation2 = B("gps");
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
  
  private boolean gO()
  {
    return this.ZV.aab > System.currentTimeMillis();
  }
  
  final boolean gM()
  {
    a locala = this.ZV;
    if (gO()) {
      return locala.ZW;
    }
    Location localLocation = gN();
    if (localLocation != null)
    {
      a(localLocation);
      return locala.ZW;
    }
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  static final class a
  {
    boolean ZW;
    long ZX;
    long ZY;
    long ZZ;
    long aaa;
    long aab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.i
 * JD-Core Version:    0.7.0.1
 */