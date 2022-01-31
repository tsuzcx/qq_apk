package com.tencent.luggage.h.a;

import android.os.HandlerThread;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.plugin.appbrand.v.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$a
{
  private final TencentLocationManager bjs;
  a.b bjt;
  AtomicBoolean bju = new AtomicBoolean(false);
  AtomicBoolean bjv = new AtomicBoolean(false);
  Set<String> bjw = new HashSet();
  Set<String> bjx = new HashSet();
  TencentLocationListener bjy = new TencentLocationListener()
  {
    public final void onLocationChanged(TencentLocation paramAnonymousTencentLocation, int paramAnonymousInt, String paramAnonymousString)
    {
      y.i("MicroMsg.DefaultTencentLocationManager", "[mGcjLocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
      if (paramAnonymousInt != 0) {
        y.e("MicroMsg.DefaultTencentLocationManager", "[mGcjLocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
      }
      if (a.a.this.bjt != null) {
        a.a.this.bjt.a(paramAnonymousInt, paramAnonymousString, a.a.b(paramAnonymousTencentLocation));
      }
    }
    
    public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
    {
      y.i("MicroMsg.DefaultTencentLocationManager", "[mGcjLocationListener]name:%s, status:%d, desc:%s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2 });
    }
  };
  TencentLocationListener bjz = new TencentLocationListener()
  {
    public final void onLocationChanged(TencentLocation paramAnonymousTencentLocation, int paramAnonymousInt, String paramAnonymousString)
    {
      y.i("MicroMsg.DefaultTencentLocationManager", "[mWgrLocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
      if (paramAnonymousInt != 0) {
        y.e("MicroMsg.DefaultTencentLocationManager", "[mWgrLocationListener]error:%d, reason:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
      }
      if (a.a.this.bjt != null) {
        a.a.this.bjt.a(paramAnonymousInt, paramAnonymousString, a.a.b(paramAnonymousTencentLocation));
      }
    }
    
    public final void onStatusUpdate(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
    {
      y.i("MicroMsg.DefaultTencentLocationManager", "[mWgrLocationListener]name:%s, status:%d, desc:%s", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt), paramAnonymousString2 });
    }
  };
  
  public a$a(a.b paramb)
  {
    this.bjt = paramb;
    this.bjs = TencentLocationManager.getInstance(ae.getContext());
    qv();
  }
  
  private String qw()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.bjw.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((String)localIterator.next());
    }
    this.bjw.clear();
    localIterator = this.bjx.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((String)localIterator.next());
    }
    y.d("MicroMsg.DefaultTencentLocationManager", "MapReport reportMsg:%s", new Object[] { localStringBuilder.toString() });
    return localStringBuilder.toString();
  }
  
  final void bh(String paramString)
  {
    y.i("MicroMsg.DefaultTencentLocationManager", "triggerLocationCallback type:%s", new Object[] { paramString });
    if ("wgs84".equals(paramString))
    {
      if (!this.bjv.get()) {
        qv();
      }
      if (this.bju.get()) {
        y.d("MicroMsg.DefaultTencentLocationManager", "already running, ignore");
      }
    }
    for (;;)
    {
      this.bju.set(true);
      return;
      this.bjv.set(true);
      this.bjs.setCoordinateType(0);
      paramString = TencentLocationRequest.create();
      paramString.setInterval(2000L);
      paramString.setSmallAppKey(qw());
      y.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(this.bjs.requestLocationUpdates(paramString, this.bjz, n.DS().mnU.getLooper())) });
      continue;
      if (this.bjv.get()) {
        qv();
      }
      if (this.bju.get())
      {
        y.d("MicroMsg.DefaultTencentLocationManager", "already running, ignore");
      }
      else
      {
        this.bjv.set(false);
        this.bjs.setCoordinateType(1);
        paramString = TencentLocationRequest.create();
        paramString.setInterval(2000L);
        paramString.setSmallAppKey(qw());
        y.i("MicroMsg.DefaultTencentLocationManager", "requestCode %d", new Object[] { Integer.valueOf(this.bjs.requestLocationUpdates(paramString, this.bjy, n.DS().mnU.getLooper())) });
      }
    }
  }
  
  final void qv()
  {
    y.i("MicroMsg.DefaultTencentLocationManager", "triggerStop");
    this.bjs.removeUpdates(null);
    this.bju.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */