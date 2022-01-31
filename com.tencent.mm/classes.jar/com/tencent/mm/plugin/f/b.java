package com.tencent.mm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.f.a.d;
import com.tencent.mm.plugin.f.a.f;
import com.tencent.mm.plugin.f.c.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.HashSet;

public final class b
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.d> kjX;
  private static b kka;
  private h.a jSC;
  private com.tencent.mm.plugin.f.b.b kjY;
  private t.a kjZ;
  private al kkb;
  private com.tencent.mm.plugin.f.c.c kkc;
  public HashSet<Long> kkd;
  public boolean kke;
  private boolean kkf;
  public com.tencent.mm.plugin.f.c.c kkg;
  com.tencent.mm.plugin.f.c.b kkh;
  private HashMap<Integer, com.tencent.mm.plugin.f.a.a> kki;
  private c.a kkj;
  private c.a kkk;
  private com.tencent.mm.sdk.b.c<ci> kkl;
  private boolean kkm;
  private boolean kkn;
  private BroadcastReceiver kko;
  private Runnable kkp;
  private boolean kkq;
  private com.tencent.mm.sdk.b.c<bq> kkr;
  
  static
  {
    AppMethodBeat.i(18616);
    HashMap localHashMap = new HashMap();
    kjX = localHashMap;
    localHashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new b.1());
    AppMethodBeat.o(18616);
  }
  
  public b()
  {
    AppMethodBeat.i(18595);
    this.kkc = null;
    this.kkd = new HashSet();
    this.kke = false;
    this.kkf = false;
    this.kkg = null;
    this.kkh = null;
    this.kki = new HashMap();
    this.kkj = new b.8(this);
    this.kkk = new b.13(this);
    this.jSC = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramAnonymoush, h.c paramAnonymousc)
      {
        AppMethodBeat.i(18575);
        if (paramAnonymoush == null)
        {
          AppMethodBeat.o(18575);
          return;
        }
        if ((paramAnonymousc == null) || (paramAnonymousc.oDQ == null))
        {
          AppMethodBeat.o(18575);
          return;
        }
        b.a(b.this, new b.2.1(this, paramAnonymousc));
        AppMethodBeat.o(18575);
      }
    };
    this.kkl = new b.3(this);
    this.kkm = false;
    this.kkn = true;
    this.kkq = false;
    this.kkr = new b.5(this);
    AppMethodBeat.o(18595);
  }
  
  public static void F(int paramInt, long paramLong)
  {
    int i = 30;
    AppMethodBeat.i(18608);
    if (paramLong <= 1000L)
    {
      paramInt += 5;
      if (paramInt <= 30) {
        break label123;
      }
      paramInt = i;
    }
    label123:
    for (;;)
    {
      i = paramInt;
      if (paramInt < 5) {
        i = 5;
      }
      g.RL().Ru().set(ac.a.yHD, Integer.valueOf(i));
      paramInt = ((Integer)com.tencent.mm.plugin.report.service.h.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(664L, paramInt, 1L, false);
      AppMethodBeat.o(18608);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  public static b bak()
  {
    try
    {
      AppMethodBeat.i(18596);
      if (kka == null) {
        kka = new b();
      }
      b localb = kka;
      AppMethodBeat.o(18596);
      return localb;
    }
    finally {}
  }
  
  public static long ban()
  {
    AppMethodBeat.i(18604);
    long l2 = ((Long)g.RL().Ru().get(ac.a.yHF, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((j)g.E(j.class)).bPQ().TJ("message");
      g.RL().Ru().set(ac.a.yHF, Long.valueOf(l1));
    }
    AppMethodBeat.o(18604);
    return l1;
  }
  
  public static long baq()
  {
    AppMethodBeat.i(18610);
    long l = ((Long)g.RL().Ru().get(ac.a.yHE, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(18610);
    return l;
  }
  
  public static int bar()
  {
    AppMethodBeat.i(18611);
    int i = ((Integer)g.RL().Ru().get(ac.a.yHD, Integer.valueOf(5))).intValue();
    AppMethodBeat.o(18611);
    return i;
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(18601);
    post(new b.12(this));
    AppMethodBeat.o(18601);
  }
  
  public final void O(bi parambi)
  {
    AppMethodBeat.i(18607);
    if (parambi == null)
    {
      AppMethodBeat.o(18607);
      return;
    }
    try
    {
      com.tencent.mm.plugin.f.a.a locala = (com.tencent.mm.plugin.f.a.a)this.kki.get(Integer.valueOf(parambi.getType()));
      if (locala != null) {
        locala.P(parambi);
      }
      AppMethodBeat.o(18607);
      return;
    }
    catch (Exception parambi)
    {
      ab.printErrStackTrace("MicroMsg.CalcWxService", parambi, "", new Object[0]);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(664L, 5L, 1L, false);
      AppMethodBeat.o(18607);
    }
  }
  
  public final com.tencent.mm.plugin.f.b.b bal()
  {
    AppMethodBeat.i(18597);
    if (this.kjY == null) {
      this.kjY = new com.tencent.mm.plugin.f.b.b(this.kjZ);
    }
    com.tencent.mm.plugin.f.b.b localb = this.kjY;
    AppMethodBeat.o(18597);
    return localb;
  }
  
  public final void bam()
  {
    boolean bool = false;
    AppMethodBeat.i(18600);
    com.tencent.mm.vfs.b[] arrayOfb = new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.eQz).a(new b.9(this));
    if ((arrayOfb != null) && (arrayOfb.length > 0))
    {
      String str = bas();
      if (this.kkg != null) {
        bool = true;
      }
      ab.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      post(new b.10(this, arrayOfb));
    }
    AppMethodBeat.o(18600);
  }
  
  public final boolean bao()
  {
    AppMethodBeat.i(18605);
    long l1 = ban();
    long l2 = baq();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)g.RL().Ru().get(ac.a.yHI, Long.valueOf(0L))).longValue() <= 0L)) {
        g.RL().Ru().set(ac.a.yHI, Long.valueOf(bo.aox()));
      }
      AppMethodBeat.o(18605);
      return bool;
    }
  }
  
  public final void bap()
  {
    AppMethodBeat.i(18606);
    this.kke = false;
    this.kkd.clear();
    ab.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), bo.dtY() });
    AppMethodBeat.o(18606);
  }
  
  public final String bas()
  {
    AppMethodBeat.i(18612);
    String str = hashCode();
    AppMethodBeat.o(18612);
    return str;
  }
  
  public final void fU(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(18599);
    String str = bas();
    if (this.kkg != null) {
      bool = true;
    }
    ab.d("MicroMsg.CalcWxService", "%s manual scan now manualScanTask[%b] uiClick[%b]", new Object[] { str, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    post(new b.6(this, paramBoolean));
    AppMethodBeat.o(18599);
  }
  
  public final void jdMethod_if(long paramLong)
  {
    AppMethodBeat.i(18609);
    ab.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    g.RL().Ru().set(ac.a.yHE, Long.valueOf(paramLong));
    AppMethodBeat.o(18609);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(18602);
    ab.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { bas() });
    if (this.kkb == null)
    {
      ab.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { bas() });
      this.kkb = new al("calc-wx");
    }
    paramc = g.RL().cachePath + "WxFileIndex.db";
    this.kjZ = t.a(hashCode(), paramc, kjX, true);
    this.kki.put(Integer.valueOf(43), new com.tencent.mm.plugin.f.a.e());
    this.kki.put(Integer.valueOf(62), new com.tencent.mm.plugin.f.a.e());
    this.kki.put(Integer.valueOf(44), new com.tencent.mm.plugin.f.a.e());
    this.kki.put(Integer.valueOf(34), new f());
    this.kki.put(Integer.valueOf(3), new d());
    this.kki.put(Integer.valueOf(49), new com.tencent.mm.plugin.f.a.c());
    this.kki.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.f.a.b());
    ban();
    ((j)g.E(j.class)).bPQ().a(this.jSC, null);
    com.tencent.mm.sdk.b.a.ymk.b(this.kkl);
    paramc = ah.getContext();
    Object localObject = paramc.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool;
    if (localObject != null)
    {
      int i = ((Intent)localObject).getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
    }
    for (this.kkm = bool;; this.kkm = false)
    {
      this.kkn = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.kko = new b.4(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      paramc.registerReceiver(this.kko, (IntentFilter)localObject);
      com.tencent.mm.sdk.b.a.ymk.b(this.kkr);
      if (this.kkq) {
        com.tencent.mm.sdk.b.a.ymk.l(new bq());
      }
      AppMethodBeat.o(18602);
      return;
      bool = false;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(18603);
    ab.i("MicroMsg.CalcWxService", "CalcWxService Release");
    this.kkd.clear();
    this.kke = false;
    if (this.kjZ != null)
    {
      this.kjZ.mG(hashCode());
      this.kjZ = null;
    }
    ((j)g.E(j.class)).bPQ().a(this.jSC);
    com.tencent.mm.sdk.b.a.ymk.d(this.kkl);
    this.kki.clear();
    if (this.kko != null)
    {
      ah.getContext().unregisterReceiver(this.kko);
      this.kko = null;
    }
    if (this.kkp != null)
    {
      aw.RO();
      al.ae(this.kkp);
      this.kkp = null;
    }
    stopScan();
    if (this.kkb != null)
    {
      ab.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { bas() });
      this.kkb.oNc.quit();
    }
    this.kkb = null;
    com.tencent.mm.sdk.b.a.ymk.d(this.kkr);
    AppMethodBeat.o(18603);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(18598);
    try
    {
      if (this.kkb != null)
      {
        this.kkb.ac(paramRunnable);
        AppMethodBeat.o(18598);
        return;
      }
      ab.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { bas() });
      AppMethodBeat.o(18598);
      return;
    }
    catch (Exception paramRunnable)
    {
      ab.printErrStackTrace("MicroMsg.CalcWxService", paramRunnable, "post error: [%s]", new Object[] { paramRunnable.toString() });
      AppMethodBeat.o(18598);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b
 * JD-Core Version:    0.7.0.1
 */