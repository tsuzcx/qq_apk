package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.util.Iterator;

public final class bp
  implements GpsStatus.Listener, LocationListener
{
  private long a = 0L;
  private Location b;
  private final bf c;
  private final a d;
  private int e = 1024;
  private boolean f = false;
  private boolean g = false;
  private int h = 0;
  private int i = 0;
  
  public bp(bf parambf, a parama)
    throws Exception
  {
    if (b.a.a(parambf, parama)) {
      throw new NullPointerException();
    }
    this.c = parambf;
    this.d = parama;
    if (b.a.a(parambf.c()))
    {
      cj.b("TxGpsProvider", "android LocationManager is null");
      throw new NullPointerException("android LocationManager is null");
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean a(Location paramLocation)
  {
    if (!TencentExtraKeys.MOCK_LOCATION_FILTER) {}
    do
    {
      return false;
      try
      {
        boolean bool = this.c.c().isProviderEnabled("gps");
        if (!bool) {
          return true;
        }
      }
      catch (Exception localException)
      {
        if ((Build.VERSION.SDK_INT >= 18) && (paramLocation.isFromMockProvider())) {
          return true;
        }
        if (((this.e & 0x2) == 2) && (d()) && ((this.f) || (Math.abs(System.currentTimeMillis() - this.a) < 30000L))) {}
        for (int j = 1; j == 0; j = 0) {
          return true;
        }
      }
    } while (b(paramLocation));
    return true;
  }
  
  private void b()
  {
    int j;
    if (this.e == 4) {
      j = 1;
    }
    for (;;)
    {
      this.d.a(12002, j);
      return;
      if (this.e == 0) {
        j = 0;
      } else {
        j = -1;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private static boolean b(Location paramLocation)
  {
    if (paramLocation.getProvider() == null) {}
    for (;;)
    {
      return false;
      if ((paramLocation.hasAccuracy()) && (paramLocation.getTime() != 0L)) {
        if (Build.VERSION.SDK_INT < 17) {}
      }
      try
      {
        long l = paramLocation.getElapsedRealtimeNanos();
        if (l == 0L) {}
      }
      catch (Exception paramLocation)
      {
        for (;;)
        {
          cj.b("TxGpsProvider", Log.getStackTraceString(paramLocation));
        }
      }
    }
    return true;
  }
  
  private void c()
  {
    this.i = 0;
    this.h = 0;
    Object localObject = this.c.c().getGpsStatus(null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      int j = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
      if (localObject != null) {
        while ((((Iterator)localObject).hasNext()) && (this.h <= j))
        {
          this.h += 1;
          if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
            this.i += 1;
          }
        }
      }
    }
  }
  
  private boolean d()
  {
    int m = -1;
    Object localObject = this.c.c().getGpsStatus(null);
    int j;
    if (localObject == null)
    {
      j = -1;
      localObject = this.c.c().getGpsStatus(null);
      if (localObject != null) {
        break label195;
      }
      label40:
      if (j > 0) {
        this.g = true;
      }
      if (m > 0) {
        this.f = true;
      }
      if (TencentExtraKeys.isDebugEnabled()) {
        cj.a("TxGpsProvider", "vNum=" + j + ",uNum=" + m + ",vAvail=" + this.g + ",uAvail=" + this.f);
      }
      if ((!this.g) || (j > 2)) {
        break label264;
      }
    }
    label195:
    do
    {
      do
      {
        return false;
        int k = ((GpsStatus)localObject).getMaxSatellites();
        localObject = ((GpsStatus)localObject).getSatellites().iterator();
        if (localObject == null)
        {
          j = -1;
          break;
        }
        j = 0;
        while ((((Iterator)localObject).hasNext()) && (j <= k))
        {
          ((Iterator)localObject).next();
          j += 1;
        }
        break;
        int n = ((GpsStatus)localObject).getMaxSatellites();
        localObject = ((GpsStatus)localObject).getSatellites().iterator();
        if (localObject == null) {
          break label40;
        }
        k = 0;
        for (;;)
        {
          m = k;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          m = k;
          if (k > n) {
            break;
          }
          if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
            k += 1;
          }
        }
        if (!this.f) {
          break label282;
        }
      } while ((m < 3) && (m != 0));
      return true;
    } while (m != 0);
    label264:
    label282:
    return true;
  }
  
  public final void a()
  {
    LocationManager localLocationManager = this.c.c();
    try
    {
      localLocationManager.removeGpsStatusListener(this);
      localLocationManager.removeUpdates(this);
      label18:
      cj.a("TxGpsProvider", "shutdown: state=[shutdown]");
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public final void a(Handler paramHandler, long paramLong)
  {
    paramLong = Math.max(paramLong, 800L);
    LocationManager localLocationManager = this.c.c();
    try
    {
      localLocationManager.addGpsStatusListener(this);
      localLocationManager.requestLocationUpdates("gps", paramLong, 0.0F, this, paramHandler.getLooper());
      cj.a("TxGpsProvider", "startup: state=[start]");
      return;
    }
    catch (Exception paramHandler)
    {
      for (;;)
      {
        cj.a("TxGpsProvider", "startup: can not add location listener", paramHandler);
      }
    }
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      c();
      d();
      return;
      this.e |= 0x1;
      continue;
      this.e = this.e;
      continue;
      this.e |= 0x2;
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    int k = 0;
    if ((paramLocation == null) || (!"gps".equals(paramLocation.getProvider()))) {}
    label143:
    label228:
    for (;;)
    {
      return;
      double d1 = paramLocation.getLatitude();
      double d2 = paramLocation.getLongitude();
      int j = k;
      if (d1 != 29.999998211860657D)
      {
        if (d2 != 103.99999916553497D) {
          break label143;
        }
        j = k;
      }
      for (;;)
      {
        if (j == 0) {
          break label228;
        }
        c();
        this.e |= 0x2;
        Context localContext = this.c.a;
        if (a(paramLocation)) {
          break;
        }
        this.a = System.currentTimeMillis();
        this.b = paramLocation;
        paramLocation = new bx(this.b, this.a, this.h, this.i, this.e);
        this.d.a(paramLocation);
        return;
        j = k;
        if (Math.abs(d1) >= 1.0E-008D)
        {
          j = k;
          if (Math.abs(d2) >= 1.0E-008D)
          {
            j = k;
            if (d1 >= -90.0D)
            {
              j = k;
              if (d1 <= 90.0D)
              {
                j = k;
                if (d2 >= -180.0D)
                {
                  j = k;
                  if (d2 <= 180.0D) {
                    j = 1;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      cj.a("TxGpsProvider", "onProviderDisabled: gps is disabled");
      this.i = 0;
      this.h = 0;
      this.e = 0;
      this.f = false;
      this.a = 0L;
      this.b = null;
      b();
    }
  }
  
  public final void onProviderEnabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      cj.a("TxGpsProvider", "onProviderEnabled: gps is enabled");
      this.e = 4;
      b();
    }
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  
  public static abstract interface a
    extends bm.c
  {
    public abstract void a(bx parambx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bp
 * JD-Core Version:    0.7.0.1
 */