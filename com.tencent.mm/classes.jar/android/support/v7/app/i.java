package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.f;
import java.util.Calendar;

final class i
{
  private static i aag;
  private final LocationManager aah;
  private final a aai = new a();
  private final Context mContext;
  
  private i(Context paramContext, LocationManager paramLocationManager)
  {
    this.mContext = paramContext;
    this.aah = paramLocationManager;
  }
  
  private Location C(String paramString)
  {
    try
    {
      if (this.aah.isProviderEnabled(paramString))
      {
        paramString = this.aah.getLastKnownLocation(paramString);
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private void a(Location paramLocation)
  {
    a locala = this.aai;
    long l1 = System.currentTimeMillis();
    h localh = h.gS();
    localh.b(l1 - 86400000L, paramLocation.getLatitude(), paramLocation.getLongitude());
    long l2 = localh.aae;
    localh.b(l1, paramLocation.getLatitude(), paramLocation.getLongitude());
    if (localh.state == 1) {}
    long l3;
    long l4;
    long l5;
    for (boolean bool = true;; bool = false)
    {
      l3 = localh.aaf;
      l4 = localh.aae;
      localh.b(86400000L + l1, paramLocation.getLatitude(), paramLocation.getLongitude());
      l5 = localh.aaf;
      if ((l3 != -1L) && (l4 != -1L)) {
        break;
      }
      l1 = 43200000L + l1;
      locala.aaj = bool;
      locala.aak = l2;
      locala.aal = l3;
      locala.aam = l4;
      locala.aan = l5;
      locala.aao = l1;
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
  
  static i aa(Context paramContext)
  {
    if (aag == null)
    {
      paramContext = paramContext.getApplicationContext();
      aag = new i(paramContext, (LocationManager)paramContext.getSystemService("location"));
    }
    return aag;
  }
  
  @SuppressLint({"MissingPermission"})
  private Location gU()
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
  
  private boolean gV()
  {
    return this.aai.aao > System.currentTimeMillis();
  }
  
  final boolean gT()
  {
    a locala = this.aai;
    if (gV()) {
      return locala.aaj;
    }
    Location localLocation = gU();
    if (localLocation != null)
    {
      a(localLocation);
      return locala.aaj;
    }
    int i = Calendar.getInstance().get(11);
    return (i < 6) || (i >= 22);
  }
  
  static final class a
  {
    boolean aaj;
    long aak;
    long aal;
    long aam;
    long aan;
    long aao;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.i
 * JD-Core Version:    0.7.0.1
 */