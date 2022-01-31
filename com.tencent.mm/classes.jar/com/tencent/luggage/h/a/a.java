package com.tencent.luggage.h.a;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.v.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements com.tencent.mm.plugin.appbrand.v.b.a
{
  private AtomicBoolean bjg = new AtomicBoolean(false);
  private final HashSet<a.b> bjh = new HashSet();
  private final HashSet<a.b> bji = new HashSet();
  private a.b bjj = new a.b()
  {
    public final void a(int paramAnonymousInt, String paramAnonymousString, com.tencent.mm.plugin.appbrand.v.b.a.a paramAnonymousa)
    {
      if (a.a(a.this).bjv.get()) {
        a.a(a.b(a.this), paramAnonymousInt, paramAnonymousString, paramAnonymousa);
      }
      for (;;)
      {
        a.d(a.this);
        return;
        a.a(a.c(a.this), paramAnonymousInt, paramAnonymousString, paramAnonymousa);
      }
    }
  };
  private final a.a bjk = new a.a(this.bjj);
  private final HashSet<a.b> bjl = new HashSet();
  private final HashSet<a.b> bjm = new HashSet();
  private Object bjn = new Object();
  ai bjo = new ai("MicroMsg.DefaultTencentLocationManager");
  private Runnable bjp = new a.2(this);
  private Runnable bjq = new Runnable()
  {
    public final void run()
    {
      if (a.a(a.this).bjv.get()) {
        a.a(a.b(a.this), -1, "timeout", null);
      }
      for (;;)
      {
        a.d(a.this);
        return;
        a.a(a.c(a.this), -1, "timeout", null);
      }
    }
  };
  
  public a()
  {
    y.i("MicroMsg.DefaultTencentLocationManager", "construct in process %s", new Object[] { ae.getProcessName() });
    try
    {
      y.i("MicroMsg.DefaultTencentLocationManager", "printBluetoothEnable open:%b", new Object[] { Boolean.valueOf(BluetoothAdapter.getDefaultAdapter().isEnabled()) });
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.DefaultTencentLocationManager", localException, "", new Object[0]);
      y.i("MicroMsg.DefaultTencentLocationManager", "printBluetoothEnable fail");
    }
  }
  
  private void qu()
  {
    if ((this.bjh.size() <= 0) && (this.bji.size() <= 0) && (this.bjl.size() <= 0) && (this.bjm.size() <= 0)) {
      this.bjk.qv();
    }
    do
    {
      return;
      if ((this.bjh.size() > 0) && (this.bji.size() > 0))
      {
        if (this.bjg.get())
        {
          this.bjk.bh("wgs84");
          return;
        }
        this.bjk.bh("gcj02");
        return;
      }
      if (this.bjh.size() > 0)
      {
        this.bjk.bh("wgs84");
        return;
      }
    } while (this.bji.size() <= 0);
    this.bjk.bh("gcj02");
  }
  
  public final boolean a(String paramString, a.b paramb, Bundle paramBundle)
  {
    y.i("MicroMsg.DefaultTencentLocationManager", "[registerLocation]type:%s", new Object[] { paramString });
    synchronized (this.bjn)
    {
      a.b localb;
      if ("wgs84".equals(paramString))
      {
        paramString = this.bjl.iterator();
        while (paramString.hasNext())
        {
          localb = (a.b)paramString.next();
          if ((localb != null) && (localb.equals(paramb)))
          {
            y.w("MicroMsg.DefaultTencentLocationManager", "already register");
            return false;
          }
        }
        this.bjl.add(paramb);
        if (paramBundle != null)
        {
          paramString = paramBundle.getString("smallAppKey");
          paramb = this.bjk;
          if (!bk.bl(paramString)) {
            paramb.bjx.add(paramString);
          }
        }
        this.bjo.crf().removeCallbacks(this.bjp);
        this.bjo.O(this.bjp);
        return true;
      }
      paramString = this.bjm.iterator();
      while (paramString.hasNext())
      {
        localb = (a.b)paramString.next();
        if ((localb != null) && (localb.equals(paramb)))
        {
          y.w("MicroMsg.DefaultTencentLocationManager", "already register");
          return false;
        }
      }
      this.bjm.add(paramb);
    }
  }
  
  public final boolean b(String paramString, a.b paramb, Bundle paramBundle)
  {
    y.i("MicroMsg.DefaultTencentLocationManager", "[unregisterLocation]type:%s", new Object[] { paramString });
    synchronized (this.bjn)
    {
      if ("wgs84".equals(paramString))
      {
        this.bjl.remove(paramb);
        if (paramBundle != null)
        {
          paramString = paramBundle.getString("smallAppKey");
          this.bjk.bjx.remove(paramString);
        }
        qu();
        return false;
      }
      this.bjm.remove(paramb);
    }
  }
  
  public final void c(String paramString, a.b paramb, Bundle paramBundle)
  {
    y.i("MicroMsg.DefaultTencentLocationManager", "[getLocation]type:%s", new Object[] { paramString });
    if ("wgs84".equals(paramString))
    {
      this.bjg.set(true);
      this.bjh.add(paramb);
    }
    for (;;)
    {
      this.bjo.crf().removeCallbacks(this.bjq);
      this.bjo.k(this.bjq, 20000L);
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("smallAppKey");
        paramb = this.bjk;
        if (!bk.bl(paramString)) {
          paramb.bjw.add(paramString);
        }
      }
      qu();
      return;
      this.bjg.set(false);
      this.bji.add(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.h.a.a
 * JD-Core Version:    0.7.0.1
 */