package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bv
  extends BroadcastReceiver
{
  private volatile boolean a;
  private final bf b;
  private final WifiManager c;
  private final a d;
  private long e;
  private long f;
  private int g;
  private Handler h;
  private final Runnable i = new Runnable()
  {
    public final void run()
    {
      bv.a(bv.this);
      bv.b(bv.this);
    }
  };
  private bl j;
  private bl k;
  private bl l;
  private Object m = new Object();
  
  public bv(bf parambf, a parama)
    throws Exception
  {
    if (b.a.a(parambf, parama)) {
      throw new NullPointerException();
    }
    this.b = parambf;
    this.d = parama;
    this.c = parambf.b();
    if (b.a.a(this.c))
    {
      cj.b("TxWifiProvider", "android WifiManager is null");
      throw new NullPointerException("android WifiManager is null");
    }
  }
  
  private void a(List<ScanResult> paramList, boolean paramBoolean)
  {
    paramList = new bz(paramList, this.e, this.c.getWifiState());
    this.d.a(paramList, paramBoolean);
  }
  
  private void c()
  {
    if (!this.c.isWifiEnabled()) {}
    while (this.h == null) {
      return;
    }
    this.h.removeCallbacks(this.i);
    this.h.postDelayed(this.i, this.b.d().j);
  }
  
  private void d()
  {
    cj.a("TxWifiProvider", "scanNow: state=[scanning], delay=[" + this.b.d().j + "]");
    if (b.a.a(this.c)) {
      this.f = System.currentTimeMillis();
    }
  }
  
  private void e()
  {
    if (b.a.b(this.j)) {
      this.j.b();
    }
    if (b.a.b(this.k)) {
      this.k.b();
    }
  }
  
  private void f()
  {
    int n = 3;
    if (b.a.a(this.j)) {
      return;
    }
    bl localbl = this.j.d(this.k);
    if (localbl.c(this.l))
    {
      cj.a("TxWifiProvider", "handleWifiUpdate: differ significantly");
      Object localObject1 = this.l;
      if ((localbl.c() > 2) || (bl.a((bl)localObject1))) {}
      for (;;)
      {
        a(localbl.a(), true);
        this.l = localbl;
        return;
        if (localbl.b((bl)localObject1))
        {
          cj.a("TxWifiProvider", "makeSureApNum: aps number < 3, merge last scan ");
          if (localbl.c() < 3) {
            label101:
            if (((bl)localObject1).c() <= n) {
              break label187;
            }
          }
          for (;;)
          {
            Object localObject2 = ((bl)localObject1).a().subList(0, n);
            localObject1 = localbl.a();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              ScanResult localScanResult = (ScanResult)((Iterator)localObject2).next();
              if (!((List)localObject1).contains(localScanResult)) {
                ((List)localObject1).add(localScanResult);
              }
            }
            break;
            n = localbl.c();
            break label101;
            label187:
            n = ((bl)localObject1).c();
          }
        }
        cj.a("TxWifiProvider", "makeSureApNum: aps number < 3 and last scan is invalid");
      }
    }
    cj.a("TxWifiProvider", "handleWifiUpdate: similar");
    a(localbl.a(), false);
  }
  
  public final int a()
  {
    int n = 1;
    int i1 = 1;
    if (!this.a) {
      return i1;
    }
    if (!this.c.isWifiEnabled()) {}
    for (;;)
    {
      i1 = n;
      if (n != 0) {
        break;
      }
      d();
      return n;
      long l1 = System.currentTimeMillis();
      if ((l1 - this.f < 1500L) || (l1 - this.e < 1500L)) {
        n = 2;
      } else {
        n = 0;
      }
    }
  }
  
  public final void a(Handler paramHandler)
  {
    if (this.a) {
      return;
    }
    this.a = true;
    this.h = paramHandler;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    try
    {
      this.b.a.registerReceiver(this, localIntentFilter, null, paramHandler);
      cj.a("TxWifiProvider", "startup: state=[start]");
      this.e = System.currentTimeMillis();
      paramHandler = new bz(b.a.b(this.c), this.e, this.c.getWifiState());
      this.d.a(paramHandler, true);
      c();
      return;
    }
    catch (Exception paramHandler)
    {
      for (;;)
      {
        cj.a("TxWifiProvider", "listenWifiState: failed", paramHandler);
      }
    }
  }
  
  public final void b()
  {
    if (!this.a) {
      return;
    }
    this.a = false;
    if (this.h != null) {
      this.h.removeCallbacks(this.i);
    }
    try
    {
      this.b.a.unregisterReceiver(this);
      label42:
      synchronized (this.m)
      {
        e();
        if (this.l != null) {
          this.l.b();
        }
        cj.a("TxWifiProvider", "shutdown: state=[shutdown]");
        return;
      }
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  public final void onReceive(Context paramContext, Intent arg2)
  {
    int n = 1;
    if (??? == null) {}
    do
    {
      do
      {
        return;
        paramContext = ???.getAction();
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext))
        {
          int i1 = this.c.getWifiState();
          if (i1 == 3) {
            c();
          }
          for (;;)
          {
            this.d.a(12001, n);
            return;
            if (i1 == 1) {
              n = 0;
            } else {
              n = -1;
            }
          }
        }
      } while (!"android.net.wifi.SCAN_RESULTS".equals(paramContext));
      paramContext = b.a.b(this.c);
    } while (paramContext == null);
    this.e = System.currentTimeMillis();
    if (this.g == 0) {
      for (;;)
      {
        synchronized (this.m)
        {
          e();
          synchronized (this.m)
          {
            this.j = new bl(paramContext, this.f, this.e);
            if (this.j.c() >= 8)
            {
              f();
              return;
            }
          }
        }
        d();
        this.g = 1;
      }
    }
    synchronized (this.m)
    {
      this.k = new bl(paramContext, this.f, this.e);
      f();
      this.g = 0;
      return;
    }
  }
  
  public static abstract interface a
    extends bm.c
  {
    public abstract void a(bz parambz, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bv
 * JD-Core Version:    0.7.0.1
 */