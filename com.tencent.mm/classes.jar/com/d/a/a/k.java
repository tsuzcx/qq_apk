package com.d.a.a;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import java.util.Iterator;

final class k
  extends c
  implements GpsStatus.Listener, LocationListener
{
  private static k aXA;
  private LocationManager QD;
  private boolean aXB;
  private GpsStatus aXC;
  private k.a aXD;
  private final l aXE = new l();
  private Looper mLooper;
  private Context ze;
  
  private void a(long paramLong, float paramFloat)
  {
    this.QD.requestLocationUpdates("gps", paramLong, paramFloat, this, this.mLooper);
  }
  
  static k pe()
  {
    if (aXA == null) {
      aXA = new k();
    }
    return aXA;
  }
  
  final void a(Context paramContext, Handler paramHandler, d.a parama)
  {
    if (!this.aXB) {
      return;
    }
    this.aXD = ((k.a)parama);
    if (paramHandler != null) {}
    for (paramContext = paramHandler.getLooper();; paramContext = null)
    {
      this.mLooper = paramContext;
      a(this.aXD.aVM, this.aXD.aXF);
      this.QD.addGpsStatusListener(this);
      this.aXE.aXM = Math.max(5000L, Math.min(this.aXD.aVM + 5000L, 65000L));
      return;
    }
  }
  
  final void a(Handler paramHandler, d.a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      try
      {
        parama = new k.a(30000L);
        super.a(paramHandler, parama);
        return;
      }
      finally {}
      if ((parama instanceof k.a)) {
        parama = (k.a)parama;
      } else {
        parama = new k.a(parama.aVM);
      }
    }
  }
  
  final void aa(Context paramContext)
  {
    this.ze = paramContext;
    this.QD = ((LocationManager)paramContext.getSystemService("location"));
    if ((this.QD != null) && (this.QD.getProvider("gps") != null)) {}
    for (boolean bool = true;; bool = false)
    {
      this.aXB = bool;
      return;
    }
  }
  
  final void ab(Context paramContext)
  {
    if (!this.aXB) {
      return;
    }
    this.QD.removeUpdates(this);
    this.QD.removeGpsStatusListener(this);
  }
  
  final void oX() {}
  
  final void oY()
  {
    if ((!this.aXB) || (!this.isRunning) || (this.aXD.aVM >= 300000L)) {
      return;
    }
    a(300000L, this.aXD.aXF);
  }
  
  final void oZ()
  {
    if ((!this.aXB) || (!this.isRunning) || (this.aXD.aVM >= 300000L)) {
      return;
    }
    a(this.aXD.aVM, this.aXD.aXF);
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    if (paramInt == 4)
    {
      if (this.aXC == null) {
        this.aXC = this.QD.getGpsStatus(null);
      }
    }
    else {
      return;
    }
    this.QD.getGpsStatus(this.aXC);
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    if (!y.bbL)
    {
      if (Settings.Secure.getString(this.ze.getContentResolver(), "mock_location").equals("0")) {}
      for (i = 0; i != 0; i = 1) {
        return;
      }
    }
    int i = 0;
    Iterator localIterator;
    int j;
    if (this.aXC != null)
    {
      localIterator = this.aXC.getSatellites().iterator();
      j = 0;
      if (localIterator.hasNext()) {}
    }
    for (;;)
    {
      this.aXE.a(paramLocation.getAccuracy(), j, paramLocation.getTime());
      c(new k.b(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAltitude(), paramLocation.getAccuracy(), paramLocation.getSpeed(), i, j, this.aXE.aXI, this.aXE.aXQ / 1000L, (byte)0));
      return;
      GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
      int k = i + 1;
      i = k;
      if (!localGpsSatellite.usedInFix()) {
        break;
      }
      j += 1;
      i = k;
      break;
      j = 0;
      i = 0;
    }
  }
  
  public final void onProviderDisabled(String paramString) {}
  
  public final void onProviderEnabled(String paramString) {}
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.d.a.a.k
 * JD-Core Version:    0.7.0.1
 */