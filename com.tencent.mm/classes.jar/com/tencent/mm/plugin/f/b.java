package com.tencent.mm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.co.a;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.f.a.f;
import com.tencent.mm.plugin.f.c.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.b> npa;
  private static b npd;
  private h.a fpE;
  private com.tencent.mm.plugin.f.b.b npb;
  private r.a npc;
  private ap npe;
  private com.tencent.mm.plugin.f.c.d npf;
  public HashSet<Long> npg;
  public boolean nph;
  private boolean npi;
  public com.tencent.mm.plugin.f.c.d npj;
  com.tencent.mm.plugin.f.c.c npk;
  private HashMap<Integer, com.tencent.mm.plugin.f.a.a> npl;
  private d.a npm;
  private d.a npn;
  private com.tencent.mm.sdk.b.c<co> npo;
  private boolean npp;
  private boolean npq;
  private BroadcastReceiver npr;
  private Runnable nps;
  private boolean npt;
  private com.tencent.mm.sdk.b.c<bv> npu;
  
  static
  {
    AppMethodBeat.i(22725);
    HashMap localHashMap = new HashMap();
    npa = localHashMap;
    localHashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.f.b.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(22725);
  }
  
  public b()
  {
    AppMethodBeat.i(22704);
    this.npf = null;
    this.npg = new HashSet();
    this.nph = false;
    this.npi = false;
    this.npj = null;
    this.npk = null;
    this.npl = new HashMap();
    this.npm = new d.a()
    {
      public final void finish()
      {
        AppMethodBeat.i(22697);
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22696);
            b.a(b.this, null);
            b.this.iE(false);
            AppMethodBeat.o(22696);
          }
        });
        AppMethodBeat.o(22697);
      }
    };
    this.npn = new d.a()
    {
      public final void finish()
      {
        AppMethodBeat.i(22703);
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22702);
            b.b(b.this, null);
            b.i(b.this);
            AppMethodBeat.o(22702);
          }
        });
        AppMethodBeat.o(22703);
      }
    };
    this.fpE = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramAnonymoush, final h.c paramAnonymousc)
      {
        AppMethodBeat.i(22686);
        if (com.tencent.mm.sdk.a.b.eES())
        {
          AppMethodBeat.o(22686);
          return;
        }
        if (paramAnonymoush == null)
        {
          AppMethodBeat.o(22686);
          return;
        }
        if ((paramAnonymousc == null) || (paramAnonymousc.tyE == null))
        {
          AppMethodBeat.o(22686);
          return;
        }
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22685);
            ad.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { paramAnonymousc.tyD, Integer.valueOf(paramAnonymousc.tyE.size()) });
            if ("delete".equals(paramAnonymousc.tyD))
            {
              AppMethodBeat.o(22685);
              return;
            }
            int i;
            Iterator localIterator;
            if ("delete".equals(paramAnonymousc.tyD))
            {
              i = 2;
              localIterator = paramAnonymousc.tyE.iterator();
            }
            for (;;)
            {
              label94:
              if (!localIterator.hasNext()) {
                break label230;
              }
              Object localObject = (bl)localIterator.next();
              if (localObject != null)
              {
                b localb = b.this;
                long l = ((du)localObject).field_msgId;
                if (localb.nph) {}
                for (boolean bool = localb.npg.contains(Long.valueOf(l));; bool = false)
                {
                  if (!bool) {
                    break label199;
                  }
                  ad.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((du)localObject).field_msgId) });
                  break label94;
                  i = 1;
                  break;
                }
                label199:
                localObject = new com.tencent.mm.plugin.f.c.b((bl)localObject, i);
                b.d(b.this).postToWorker((Runnable)localObject);
              }
            }
            label230:
            AppMethodBeat.o(22685);
          }
        });
        AppMethodBeat.o(22686);
      }
    };
    this.npo = new com.tencent.mm.sdk.b.c() {};
    this.npp = false;
    this.npq = true;
    this.npt = false;
    this.npu = new com.tencent.mm.sdk.b.c()
    {
      private boolean bHk()
      {
        AppMethodBeat.i(22692);
        ad.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { b.this.bel() });
        b.d(b.this, true);
        try
        {
          com.tencent.mm.kernel.g.afE().ax(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22691);
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqy, Long.valueOf(-1L));
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqx, Long.valueOf(0L));
              com.tencent.mm.kernel.g.afB().afk().eKy();
              b.bHc().bHd().delete();
              b.d(b.this, false);
              AppMethodBeat.o(22691);
            }
          });
          AppMethodBeat.o(22692);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { b.this.bel() });
          }
        }
      }
    };
    AppMethodBeat.o(22704);
  }
  
  public static void J(int paramInt, long paramLong)
  {
    int i = 30;
    AppMethodBeat.i(22717);
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
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqw, Integer.valueOf(i));
      paramInt = ((Integer)com.tencent.mm.plugin.report.service.h.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(664L, paramInt, 1L, false);
      AppMethodBeat.o(22717);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  public static b bHc()
  {
    try
    {
      AppMethodBeat.i(22705);
      if (npd == null) {
        npd = new b();
      }
      b localb = npd;
      AppMethodBeat.o(22705);
      return localb;
    }
    finally {}
  }
  
  public static long bHf()
  {
    AppMethodBeat.i(22713);
    long l2 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqy, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().agN("message");
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqy, Long.valueOf(l1));
    }
    AppMethodBeat.o(22713);
    return l1;
  }
  
  public static long bHi()
  {
    AppMethodBeat.i(22719);
    long l = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqx, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(22719);
    return l;
  }
  
  public static int bHj()
  {
    AppMethodBeat.i(22720);
    int i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqw, Integer.valueOf(5))).intValue();
    AppMethodBeat.o(22720);
    return i;
  }
  
  private void stopScan()
  {
    AppMethodBeat.i(22710);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22701);
        if (b.f(b.this) != null)
        {
          b.f(b.this).cancel();
          b.f(b.this).isStop = true;
          b.b(b.this, null);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(664L, 2L, 1L, false);
        }
        if (b.h(b.this) != null) {
          b.h(b.this).isStop = true;
        }
        AppMethodBeat.o(22701);
      }
    });
    AppMethodBeat.o(22710);
  }
  
  public final void aa(bl parambl)
  {
    AppMethodBeat.i(22716);
    if (parambl == null)
    {
      AppMethodBeat.o(22716);
      return;
    }
    try
    {
      com.tencent.mm.plugin.f.a.a locala = (com.tencent.mm.plugin.f.a.a)this.npl.get(Integer.valueOf(parambl.getType()));
      if (locala != null) {
        locala.ab(parambl);
      }
      AppMethodBeat.o(22716);
      return;
    }
    catch (Exception parambl)
    {
      ad.printErrStackTrace("MicroMsg.CalcWxService", parambl, "", new Object[0]);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(664L, 5L, 1L, false);
      AppMethodBeat.o(22716);
    }
  }
  
  public final com.tencent.mm.plugin.f.b.b bHd()
  {
    AppMethodBeat.i(22706);
    if (this.npb == null) {
      this.npb = new com.tencent.mm.plugin.f.b.b(this.npc);
    }
    com.tencent.mm.plugin.f.b.b localb = this.npb;
    AppMethodBeat.o(22706);
    return localb;
  }
  
  public final void bHe()
  {
    boolean bool = false;
    AppMethodBeat.i(22709);
    com.tencent.mm.vfs.e[] arrayOfe = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aih()).a(new com.tencent.mm.vfs.g()
    {
      public final boolean accept(com.tencent.mm.vfs.e paramAnonymouse)
      {
        AppMethodBeat.i(22698);
        if (paramAnonymouse.isDirectory())
        {
          AppMethodBeat.o(22698);
          return false;
        }
        if ((paramAnonymouse.getName().endsWith(".apk")) || (paramAnonymouse.getName().endsWith(".temp")))
        {
          AppMethodBeat.o(22698);
          return true;
        }
        AppMethodBeat.o(22698);
        return false;
      }
    });
    if ((arrayOfe != null) && (arrayOfe.length > 0))
    {
      String str = bel();
      if (this.npj != null) {
        bool = true;
      }
      ad.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      post(new b.10(this, arrayOfe));
    }
    AppMethodBeat.o(22709);
  }
  
  public final boolean bHg()
  {
    AppMethodBeat.i(22714);
    long l1 = bHf();
    long l2 = bHi();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqB, Long.valueOf(0L))).longValue() <= 0L)) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqB, Long.valueOf(bt.aGK()));
      }
      AppMethodBeat.o(22714);
      return bool;
    }
  }
  
  public final void bHh()
  {
    AppMethodBeat.i(22715);
    this.nph = false;
    this.npg.clear();
    ad.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), bt.eGN() });
    AppMethodBeat.o(22715);
  }
  
  public final String bel()
  {
    AppMethodBeat.i(22721);
    String str = hashCode();
    AppMethodBeat.o(22721);
    return str;
  }
  
  public final void iE(final boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(22708);
    String str = bel();
    if (this.npj != null) {
      bool = true;
    }
    ad.d("MicroMsg.CalcWxService", "%s manual scan now manualScanTask[%b] uiClick[%b]", new Object[] { str, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22694);
        if (paramBoolean) {
          b.a(b.this, true);
        }
        if (!b.a(b.this))
        {
          AppMethodBeat.o(22694);
          return;
        }
        if (b.b(b.this) == null)
        {
          la localla = new la();
          if (b.this.bHg())
          {
            b.a(b.this, false);
            localla.dps.cHI = true;
            com.tencent.mm.sdk.b.a.ESL.l(localla);
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(664L, 9L, 1L, false);
            AppMethodBeat.o(22694);
            return;
          }
          if (paramBoolean) {
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(664L, 7L, 1L, false);
          }
          localla.dps.progress = b.bHi();
          localla.dps.dpt = b.bHf();
          localla.dps.cHI = false;
          com.tencent.mm.sdk.b.a.ESL.l(localla);
          b.a(b.this, new com.tencent.mm.plugin.f.c.d("message", b.bHi(), b.bHj(), b.c(b.this)));
          b.d(b.this).postToWorker(b.b(b.this));
          if (((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FqA, Long.valueOf(0L))).longValue() <= 0L) {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FqA, Long.valueOf(bt.aGK()));
          }
        }
        AppMethodBeat.o(22694);
      }
    });
    AppMethodBeat.o(22708);
  }
  
  public final void nN(long paramLong)
  {
    AppMethodBeat.i(22718);
    ad.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqx, Long.valueOf(paramLong));
    AppMethodBeat.o(22718);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(22711);
    ad.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { bel() });
    if (this.npe == null)
    {
      ad.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { bel() });
      this.npe = new ap("calc-wx");
      this.npe.setLogging(false);
    }
    paramc = com.tencent.mm.kernel.g.afB().cachePath + "WxFileIndex.db";
    this.npc = r.a(hashCode(), paramc, npa, true);
    this.npl.put(Integer.valueOf(43), new com.tencent.mm.plugin.f.a.e());
    this.npl.put(Integer.valueOf(62), new com.tencent.mm.plugin.f.a.e());
    this.npl.put(Integer.valueOf(44), new com.tencent.mm.plugin.f.a.e());
    this.npl.put(Integer.valueOf(486539313), new com.tencent.mm.plugin.f.a.e());
    this.npl.put(Integer.valueOf(34), new f());
    this.npl.put(Integer.valueOf(3), new com.tencent.mm.plugin.f.a.d());
    this.npl.put(Integer.valueOf(49), new com.tencent.mm.plugin.f.a.c());
    this.npl.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.f.a.b());
    bHf();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.fpE, null);
    com.tencent.mm.sdk.b.a.ESL.b(this.npo);
    paramc = aj.getContext();
    Object localObject = paramc.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool;
    if (localObject != null)
    {
      int i = ((Intent)localObject).getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
    }
    for (this.npp = bool;; this.npp = false)
    {
      this.npq = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.npr = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(22690);
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i = -1;
          switch (paramAnonymousContext.hashCode())
          {
          default: 
            switch (i)
            {
            }
            break;
          }
          for (;;)
          {
            if ((!b.j(b.this)) || (b.k(b.this))) {
              break label273;
            }
            ad.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
            if (b.l(b.this) != null) {
              break label313;
            }
            b.b(b.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(22689);
                b.this.bHe();
                ad.i("MicroMsg.CalcWxService", "start to calc");
                if (b.this.bHg())
                {
                  b localb = b.this;
                  if (bt.vM(((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fqz, Long.valueOf(0L))).longValue()) >= 259200000L)
                  {
                    if (localb.npk != null) {
                      localb.npk.isStop = true;
                    }
                    localb.npk = new com.tencent.mm.plugin.f.c.c();
                    localb.post(localb.npk);
                    com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fqz, Long.valueOf(bt.eGO()));
                  }
                  AppMethodBeat.o(22689);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(664L, 1L, 1L, false);
                b.i(b.this);
                AppMethodBeat.o(22689);
              }
            });
            az.afE().m(b.l(b.this), 300000L);
            AppMethodBeat.o(22690);
            return;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_ON")) {
              break;
            }
            i = 0;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_OFF")) {
              break;
            }
            i = 1;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
              break;
            }
            i = 2;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
              break;
            }
            i = 3;
            break;
            b.b(b.this, true);
            continue;
            b.b(b.this, false);
            continue;
            b.c(b.this, true);
            continue;
            b.c(b.this, false);
          }
          label273:
          if (b.l(b.this) != null)
          {
            az.afE();
            aq.az(b.l(b.this));
            b.b(b.this, null);
          }
          b.m(b.this);
          label313:
          AppMethodBeat.o(22690);
        }
      };
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      paramc.registerReceiver(this.npr, (IntentFilter)localObject);
      com.tencent.mm.sdk.b.a.ESL.b(this.npu);
      if (this.npt) {
        com.tencent.mm.sdk.b.a.ESL.l(new bv());
      }
      AppMethodBeat.o(22711);
      return;
      bool = false;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(22712);
    ad.i("MicroMsg.CalcWxService", "CalcWxService Release");
    this.npg.clear();
    this.nph = false;
    if (this.npc != null)
    {
      this.npc.pK(hashCode());
      this.npc = null;
    }
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a(this.fpE);
    com.tencent.mm.sdk.b.a.ESL.d(this.npo);
    this.npl.clear();
    if (this.npr != null)
    {
      aj.getContext().unregisterReceiver(this.npr);
      this.npr = null;
    }
    if (this.nps != null)
    {
      az.afE();
      aq.az(this.nps);
      this.nps = null;
    }
    stopScan();
    if (this.npe != null)
    {
      ad.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { bel() });
      this.npe.quit();
    }
    this.npe = null;
    com.tencent.mm.sdk.b.a.ESL.d(this.npu);
    AppMethodBeat.o(22712);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(22707);
    try
    {
      if (this.npe != null)
      {
        this.npe.postToWorker(paramRunnable);
        AppMethodBeat.o(22707);
        return;
      }
      ad.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { bel() });
      AppMethodBeat.o(22707);
      return;
    }
    catch (Exception paramRunnable)
    {
      ad.printErrStackTrace("MicroMsg.CalcWxService", paramRunnable, "post error: [%s]", new Object[] { paramRunnable.toString() });
      AppMethodBeat.o(22707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b
 * JD-Core Version:    0.7.0.1
 */