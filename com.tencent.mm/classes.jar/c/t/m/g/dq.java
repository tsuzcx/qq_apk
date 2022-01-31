package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateFormat;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.util.ArrayList;

final class dq
  implements GpsStatus.Listener, LocationListener
{
  final dg a;
  volatile int b = 1024;
  volatile Location c;
  volatile long d = 0L;
  boolean e = false;
  boolean f = false;
  int g = 0;
  int h = 0;
  int i = 0;
  ArrayList<Float> j = new ArrayList();
  volatile boolean k;
  boolean l;
  long m = -1L;
  dq.a n;
  LocationManager o;
  final double[] p = new double[2];
  private volatile GpsStatus q;
  private dk r;
  
  public dq(dg paramdg)
  {
    this.a = paramdg;
    this.r = dk.a();
    this.o = this.a.g;
  }
  
  private void a(int paramInt)
  {
    if (this.n != null) {
      this.n.obtainMessage(paramInt).sendToTarget();
    }
  }
  
  private static void a(Location paramLocation, double paramDouble1, double paramDouble2, int paramInt)
  {
    Bundle localBundle2 = paramLocation.getExtras();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putDouble("lat", paramDouble1);
    localBundle1.putDouble("lng", paramDouble2);
    localBundle1.putInt("rssi", paramInt);
    paramLocation.setExtras(localBundle1);
  }
  
  private static boolean a(double paramDouble)
  {
    return Math.abs(Double.valueOf(paramDouble).longValue() - paramDouble) < 4.9E-324D;
  }
  
  private static boolean b(Location paramLocation)
  {
    try
    {
      if (paramLocation.getAccuracy() > 10000.0F) {
        return false;
      }
      if (((a(paramLocation.getLatitude())) && (a(paramLocation.getLongitude()))) || (Math.abs(paramLocation.getLatitude()) < 1.0E-008D) || (Math.abs(paramLocation.getLongitude()) < 1.0E-008D) || (Math.abs(paramLocation.getLatitude() - 1.0D) < 1.0E-008D) || (Math.abs(paramLocation.getLongitude() - 1.0D) < 1.0E-008D) || (paramLocation.getLatitude() < -90.0D) || (paramLocation.getLatitude() > 90.0D) || (paramLocation.getLongitude() < -180.0D)) {
        break label155;
      }
      double d1 = paramLocation.getLongitude();
      if (d1 > 180.0D) {
        break label155;
      }
    }
    catch (Throwable paramLocation)
    {
      for (;;)
      {
        j.a("TxGpsProvider", 4, paramLocation.toString());
      }
    }
    return true;
    label155:
    return false;
  }
  
  @SuppressLint({"NewApi"})
  private boolean c(Location paramLocation)
  {
    if (!TencentExtraKeys.MOCK_LOCATION_FILTER) {}
    for (;;)
    {
      return false;
      try
      {
        if (!this.a.g.isProviderEnabled("gps")) {
          return true;
        }
        if (Build.VERSION.SDK_INT >= 18)
        {
          boolean bool = paramLocation.isFromMockProvider();
          if (bool) {
            return true;
          }
        }
      }
      catch (Throwable paramLocation) {}
    }
    return false;
  }
  
  @SuppressLint({"MissingPermission"})
  public final Location a()
  {
    Object localObject = null;
    try
    {
      Location localLocation = this.a.g.getLastKnownLocation("network");
      localObject = localLocation;
    }
    catch (Throwable localThrowable)
    {
      label18:
      int i1;
      break label18;
    }
    if (localObject == null) {
      return do.a;
    }
    if ((this.l) && (eo.a(localObject.getLatitude(), localObject.getLongitude()))) {}
    for (i1 = 1; i1 != 0; i1 = 0)
    {
      j.a(localObject, this.p);
      a(localObject, this.p[0], this.p[1], 0);
      return localObject;
    }
    a(localObject, localObject.getLatitude(), localObject.getLongitude(), 0);
    return localObject;
  }
  
  public final boolean b()
  {
    LocationManager localLocationManager = this.a.g;
    try
    {
      boolean bool = localLocationManager.isProviderEnabled("gps");
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  final void c()
  {
    int i1;
    if (this.b == 4) {
      i1 = 1;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12002;
      localMessage.arg2 = i1;
      this.a.b(localMessage);
      return;
      if (this.b == 0) {
        i1 = 0;
      } else {
        i1 = -1;
      }
    }
  }
  
  @SuppressLint({"MissingPermission"})
  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.b |= 0x1;
      return;
    case 2: 
      this.b = 0;
      return;
    case 3: 
      this.b |= 0x2;
      return;
    }
    LocationManager localLocationManager = this.a.g;
    try
    {
      if (this.q == null) {
        this.q = localLocationManager.getGpsStatus(null);
      }
      for (;;)
      {
        label85:
        a(1102);
        return;
        localLocationManager.getGpsStatus(this.q);
      }
    }
    catch (Throwable localThrowable)
    {
      break label85;
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationChanged: ").append(DateFormat.format("yyyy-MM-dd kk:mm:ss", paramLocation.getTime())).append(",");
      if (Build.VERSION.SDK_INT >= 17) {}
      for (long l1 = paramLocation.getElapsedRealtimeNanos();; l1 = 0L)
      {
        j.a("TxGpsProvider", 4, l1 + "," + paramLocation.getLatitude() + "," + paramLocation.getLongitude() + "," + paramLocation.toString());
        if ((paramLocation != null) && ("gps".equals(paramLocation.getProvider())))
        {
          this.c = paramLocation;
          a(1101);
        }
        return;
      }
      return;
    }
    catch (Throwable paramLocation) {}
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ("gps".equals(paramString)) {
      a(1104);
    }
  }
  
  public final void onProviderEnabled(String paramString)
  {
    if ("gps".equals(paramString)) {
      a(1103);
    }
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.g.dq
 * JD-Core Version:    0.7.0.1
 */