package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import c.t.m.g.dg;
import c.t.m.g.dh;
import c.t.m.g.dr;
import c.t.m.g.dr.b;
import c.t.m.g.em;
import c.t.m.g.j;
import java.util.List;

public final class TencentLocationManager
{
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final dg b;
  private final dr c;
  
  private TencentLocationManager(Context paramContext)
  {
    this.b = dg.a(paramContext);
    this.c = new dr(this.b);
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    try
    {
      if (d != null) {
        break label60;
      }
      if (paramContext == null) {
        throw new NullPointerException("context is null");
      }
    }
    finally {}
    if (paramContext.getApplicationContext() == null) {
      throw new NullPointerException("application context is null");
    }
    d = new TencentLocationManager(paramContext.getApplicationContext());
    label60:
    paramContext = d;
    return paramContext;
  }
  
  public final String getBuild()
  {
    dh localdh = this.b.c();
    if (localdh != null) {
      return localdh.e();
    }
    return "None";
  }
  
  public final int getCoordinateType()
  {
    return this.c.b;
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    dr localdr = this.c;
    if (localdr.l == 0)
    {
      localdr.a(localdr.k);
      return localdr.k;
    }
    return null;
  }
  
  public final String getVersion()
  {
    dh localdh = this.b.c();
    if (localdh != null) {
      return localdh.d();
    }
    return "None";
  }
  
  public final void removeUpdates(TencentLocationListener arg1)
  {
    synchronized (this.a)
    {
      this.c.a();
      return;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    return requestLocationUpdates(paramTencentLocationRequest, paramTencentLocationListener, Looper.myLooper());
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (paramTencentLocationRequest == null) {
      throw new NullPointerException("request is null");
    }
    if (paramTencentLocationListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentLocationRequest, paramTencentLocationListener, paramLooper);
      return i;
    }
  }
  
  public final int requestSingleFreshLocation(TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    int i = 0;
    if (paramTencentLocationListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    for (;;)
    {
      dr localdr;
      synchronized (this.a)
      {
        localdr = this.c;
        if (localdr.d != 0)
        {
          i = localdr.d;
          return i;
        }
        if ((paramTencentLocationListener != null) && (localdr.f != null)) {
          localdr.f.add(paramTencentLocationListener);
        }
        if (System.currentTimeMillis() - localdr.g < 2000L) {
          j.a("TxLocationManagerImpl", 6, "is running,and in 2s,so we add list,then return");
        }
      }
      localdr.g = System.currentTimeMillis();
      if ((localdr.f != null) && (localdr.l == 0) && (localdr.k != null) && (((localdr.k.getProvider().equals("gps")) && (System.currentTimeMillis() - localdr.k.getTime() <= 90000L)) || ((localdr.k.getProvider().equals("network")) && (System.currentTimeMillis() - localdr.k.getTime() <= 30000L))))
      {
        localdr.a(localdr.k, localdr.l, 3103);
        j.a("TxLocationManagerImpl", 6, "cache hit");
        localdr.g = 0L;
      }
      else if (localdr.m == dr.b.a)
      {
        j.a("TxLocationManagerImpl", 6, "conninus callback is running,send single prapare");
        localdr.a(3997);
      }
      else
      {
        j.a("TxLocationManagerImpl", 6, "no continus callback, start all provider");
        i = localdr.a(TencentLocationRequest.create().setInterval(0L), dr.a, paramLooper);
        localdr.m = dr.b.c;
      }
    }
  }
  
  public final void setCoordinateType(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      synchronized (this.a)
      {
        dr localdr = this.c;
        if (localdr.b != paramInt) {
          localdr.b = paramInt;
        }
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: " + paramInt);
  }
  
  public final boolean startIndoorLocation()
  {
    this.c.i = 1;
    return true;
  }
  
  public final boolean stopIndoorLocation()
  {
    dr localdr = this.c;
    if (localdr.i > 0)
    {
      if (localdr.c == null) {
        break label73;
      }
      i = 1;
      if (i != 0) {
        localdr.c.j = localdr.e.k;
      }
      if (Long.valueOf(localdr.h) == null) {
        break label78;
      }
    }
    label73:
    label78:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localdr.h = localdr.j.getInterval();
      }
      localdr.i = 0;
      return true;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.geolocation.TencentLocationManager
 * JD-Core Version:    0.7.0.1
 */