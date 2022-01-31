package com.tencent.mm.plugin.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.bo;
import com.tencent.mm.h.a.cf;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.h.a.d;
import com.tencent.mm.plugin.h.a.f;
import com.tencent.mm.plugin.h.c.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.HashSet;

public final class b
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.d> iiX;
  private static b ija;
  private g.a ibM = new b.10(this);
  private com.tencent.mm.plugin.h.b.b iiY;
  private t.a iiZ;
  private ai ijb;
  private com.tencent.mm.plugin.h.c.c ijc = null;
  public HashSet<Long> ijd = new HashSet();
  public boolean ije = false;
  private boolean ijf = false;
  public com.tencent.mm.plugin.h.c.c ijg = null;
  com.tencent.mm.plugin.h.c.b ijh = null;
  private HashMap<Integer, com.tencent.mm.plugin.h.a.a> iji = new HashMap();
  private c.a ijj = new b.6(this);
  private c.a ijk = new b.9(this);
  private com.tencent.mm.sdk.b.c<cf> ijl = new b.11(this);
  private boolean ijm = false;
  private boolean ijn = true;
  private BroadcastReceiver ijo;
  private Runnable ijp;
  private boolean ijq = false;
  private com.tencent.mm.sdk.b.c<bo> ijr = new b.3(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    iiX = localHashMap;
    localHashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new b.1());
  }
  
  private void awl()
  {
    f(new b.8(this));
  }
  
  public static b ayE()
  {
    try
    {
      if (ija == null) {
        ija = new b();
      }
      b localb = ija;
      return localb;
    }
    finally {}
  }
  
  public static long ayG()
  {
    long l2 = ((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxw, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().Ia("message");
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxw, Long.valueOf(l1));
    }
    return l1;
  }
  
  public static long ayJ()
  {
    return ((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxv, Long.valueOf(0L))).longValue();
  }
  
  public static int ayK()
  {
    return ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxu, Integer.valueOf(5))).intValue();
  }
  
  public static void r(int paramInt, long paramLong)
  {
    int i = 30;
    if (paramLong <= 1000L)
    {
      paramInt += 5;
      if (paramInt <= 30) {
        break label111;
      }
      paramInt = i;
    }
    label111:
    for (;;)
    {
      i = paramInt;
      if (paramInt < 5) {
        i = 5;
      }
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxu, Integer.valueOf(i));
      paramInt = ((Integer)h.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      h.nFQ.a(664L, paramInt, 1L, false);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  public final void K(bi parambi)
  {
    if (parambi == null) {}
    for (;;)
    {
      return;
      try
      {
        com.tencent.mm.plugin.h.a.a locala = (com.tencent.mm.plugin.h.a.a)this.iji.get(Integer.valueOf(parambi.getType()));
        if (locala != null)
        {
          locala.L(parambi);
          return;
        }
      }
      catch (Exception parambi)
      {
        y.printErrStackTrace("MicroMsg.CalcWxService", parambi, "", new Object[0]);
        h.nFQ.a(664L, 5L, 1L, false);
      }
    }
  }
  
  public final com.tencent.mm.plugin.h.b.b ayF()
  {
    if (this.iiY == null) {
      this.iiY = new com.tencent.mm.plugin.h.b.b(this.iiZ);
    }
    return this.iiY;
  }
  
  public final boolean ayH()
  {
    long l1 = ayG();
    long l2 = ayJ();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxz, Long.valueOf(0L))).longValue() <= 0L)) {
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxz, Long.valueOf(bk.UX()));
      }
      return bool;
    }
  }
  
  public final void ayI()
  {
    this.ije = false;
    this.ijd.clear();
    y.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), bk.csb() });
  }
  
  public final String ayL()
  {
    return hashCode();
  }
  
  public final void cR(long paramLong)
  {
    y.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxv, Long.valueOf(paramLong));
  }
  
  public final void ev(boolean paramBoolean)
  {
    boolean bool = false;
    String str = ayL();
    if (this.ijg != null) {
      bool = true;
    }
    y.d("MicroMsg.CalcWxService", "%s manual scan now manualScanTask[%b] uiClick[%b]", new Object[] { str, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    f(new b.4(this, paramBoolean));
  }
  
  public final void f(Runnable paramRunnable)
  {
    if (this.ijb != null)
    {
      this.ijb.O(paramRunnable);
      return;
    }
    y.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { ayL() });
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { ayL() });
    if (this.ijb == null)
    {
      y.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { ayL() });
      this.ijb = new ai("calc-wx");
    }
    paramc = com.tencent.mm.kernel.g.DP().cachePath + "WxFileIndex.db";
    this.iiZ = t.a(hashCode(), paramc, iiX, true);
    this.iji.put(Integer.valueOf(43), new com.tencent.mm.plugin.h.a.e());
    this.iji.put(Integer.valueOf(62), new com.tencent.mm.plugin.h.a.e());
    this.iji.put(Integer.valueOf(44), new com.tencent.mm.plugin.h.a.e());
    this.iji.put(Integer.valueOf(34), new f());
    this.iji.put(Integer.valueOf(3), new d());
    this.iji.put(Integer.valueOf(49), new com.tencent.mm.plugin.h.a.c());
    this.iji.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.h.a.b());
    ayG();
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.ibM, null);
    com.tencent.mm.sdk.b.a.udP.b(this.ijl);
    paramc = ae.getContext();
    Object localObject = paramc.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool;
    if (localObject != null)
    {
      int i = ((Intent)localObject).getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
    }
    for (this.ijm = bool;; this.ijm = false)
    {
      this.ijn = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.ijo = new b.2(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      paramc.registerReceiver(this.ijo, (IntentFilter)localObject);
      com.tencent.mm.sdk.b.a.udP.b(this.ijr);
      if (this.ijq) {
        com.tencent.mm.sdk.b.a.udP.m(new bo());
      }
      return;
      bool = false;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.CalcWxService", "CalcWxService Release");
    this.ijd.clear();
    this.ije = false;
    if (this.iiZ != null)
    {
      this.iiZ.jK(hashCode());
      this.iiZ = null;
    }
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.ibM);
    com.tencent.mm.sdk.b.a.udP.d(this.ijl);
    this.iji.clear();
    if (this.ijo != null)
    {
      ae.getContext().unregisterReceiver(this.ijo);
      this.ijo = null;
    }
    if (this.ijp != null)
    {
      au.DS();
      ai.S(this.ijp);
      this.ijp = null;
    }
    awl();
    if (this.ijb != null)
    {
      y.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { ayL() });
      this.ijb.mnU.quit();
    }
    this.ijb = null;
    com.tencent.mm.sdk.b.a.udP.d(this.ijr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b
 * JD-Core Version:    0.7.0.1
 */