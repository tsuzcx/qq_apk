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
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.f.a.f;
import com.tencent.mm.plugin.f.c.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.b> nSa;
  private static b nSd;
  private h.a ftg;
  private com.tencent.mm.plugin.f.b.b nSb;
  private r.a nSc;
  private ao nSe;
  private com.tencent.mm.plugin.f.c.d nSf;
  public HashSet<Long> nSg;
  public boolean nSh;
  private boolean nSi;
  public com.tencent.mm.plugin.f.c.d nSj;
  com.tencent.mm.plugin.f.c.c nSk;
  private HashMap<Integer, com.tencent.mm.plugin.f.a.a> nSl;
  private d.a nSm;
  private d.a nSn;
  private com.tencent.mm.sdk.b.c<co> nSo;
  private boolean nSp;
  private boolean nSq;
  private BroadcastReceiver nSr;
  private Runnable nSs;
  private boolean nSt;
  private com.tencent.mm.sdk.b.c<bv> nSu;
  
  static
  {
    AppMethodBeat.i(22725);
    HashMap localHashMap = new HashMap();
    nSa = localHashMap;
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
    this.nSf = null;
    this.nSg = new HashSet();
    this.nSh = false;
    this.nSi = false;
    this.nSj = null;
    this.nSk = null;
    this.nSl = new HashMap();
    this.nSm = new d.a()
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
            b.this.jh(false);
            AppMethodBeat.o(22696);
          }
        });
        AppMethodBeat.o(22697);
      }
    };
    this.nSn = new d.a()
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
    this.ftg = new h.a()
    {
      public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.h paramAnonymoush, final h.c paramAnonymousc)
      {
        AppMethodBeat.i(22686);
        if (com.tencent.mm.sdk.a.b.eUm())
        {
          AppMethodBeat.o(22686);
          return;
        }
        if (paramAnonymoush == null)
        {
          AppMethodBeat.o(22686);
          return;
        }
        if ((paramAnonymousc == null) || (paramAnonymousc.gtT == null))
        {
          AppMethodBeat.o(22686);
          return;
        }
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22685);
            ac.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { paramAnonymousc.uHb, Integer.valueOf(paramAnonymousc.gtT.size()) });
            if ("delete".equals(paramAnonymousc.uHb))
            {
              AppMethodBeat.o(22685);
              return;
            }
            int i;
            Iterator localIterator;
            if ("delete".equals(paramAnonymousc.uHb))
            {
              i = 2;
              localIterator = paramAnonymousc.gtT.iterator();
            }
            for (;;)
            {
              label94:
              if (!localIterator.hasNext()) {
                break label230;
              }
              Object localObject = (bo)localIterator.next();
              if (localObject != null)
              {
                b localb = b.this;
                long l = ((dy)localObject).field_msgId;
                if (localb.nSh) {}
                for (boolean bool = localb.nSg.contains(Long.valueOf(l));; bool = false)
                {
                  if (!bool) {
                    break label199;
                  }
                  ac.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((dy)localObject).field_msgId) });
                  break label94;
                  i = 1;
                  break;
                }
                label199:
                localObject = new com.tencent.mm.plugin.f.c.b((bo)localObject, i);
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
    this.nSo = new com.tencent.mm.sdk.b.c() {};
    this.nSp = false;
    this.nSq = true;
    this.nSt = false;
    this.nSu = new com.tencent.mm.sdk.b.c()
    {
      private boolean bOx()
      {
        AppMethodBeat.i(22692);
        ac.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { b.this.blf() });
        b.d(b.this, true);
        try
        {
          com.tencent.mm.kernel.g.agU().az(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22691);
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOo, Long.valueOf(-1L));
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOn, Long.valueOf(0L));
              com.tencent.mm.kernel.g.agR().agA().faa();
              b.bOp().bOq().delete();
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
            ac.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { b.this.blf() });
          }
        }
      }
    };
    AppMethodBeat.o(22704);
  }
  
  public static void I(int paramInt, long paramLong)
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
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOm, Integer.valueOf(i));
      paramInt = ((Integer)com.tencent.mm.plugin.report.service.h.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(664L, paramInt, 1L, false);
      AppMethodBeat.o(22717);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  public static b bOp()
  {
    try
    {
      AppMethodBeat.i(22705);
      if (nSd == null) {
        nSd = new b();
      }
      b localb = nSd;
      AppMethodBeat.o(22705);
      return localb;
    }
    finally {}
  }
  
  public static long bOs()
  {
    AppMethodBeat.i(22713);
    long l2 = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOo, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alH("message");
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOo, Long.valueOf(l1));
    }
    AppMethodBeat.o(22713);
    return l1;
  }
  
  public static long bOv()
  {
    AppMethodBeat.i(22719);
    long l = ((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOn, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(22719);
    return l;
  }
  
  public static int bOw()
  {
    AppMethodBeat.i(22720);
    int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOm, Integer.valueOf(5))).intValue();
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
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(664L, 2L, 1L, false);
        }
        if (b.h(b.this) != null) {
          b.h(b.this).isStop = true;
        }
        AppMethodBeat.o(22701);
      }
    });
    AppMethodBeat.o(22710);
  }
  
  public final void aa(bo parambo)
  {
    AppMethodBeat.i(22716);
    if (parambo == null)
    {
      AppMethodBeat.o(22716);
      return;
    }
    try
    {
      com.tencent.mm.plugin.f.a.a locala = (com.tencent.mm.plugin.f.a.a)this.nSl.get(Integer.valueOf(parambo.getType()));
      if (locala != null) {
        locala.ab(parambo);
      }
      AppMethodBeat.o(22716);
      return;
    }
    catch (Exception parambo)
    {
      ac.printErrStackTrace("MicroMsg.CalcWxService", parambo, "", new Object[0]);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(664L, 5L, 1L, false);
      AppMethodBeat.o(22716);
    }
  }
  
  public final com.tencent.mm.plugin.f.b.b bOq()
  {
    AppMethodBeat.i(22706);
    if (this.nSb == null) {
      this.nSb = new com.tencent.mm.plugin.f.b.b(this.nSc);
    }
    com.tencent.mm.plugin.f.b.b localb = this.nSb;
    AppMethodBeat.o(22706);
    return localb;
  }
  
  public final void bOr()
  {
    boolean bool = false;
    AppMethodBeat.i(22709);
    com.tencent.mm.vfs.e[] arrayOfe = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aph()).a(new com.tencent.mm.vfs.g()
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
      String str = blf();
      if (this.nSj != null) {
        bool = true;
      }
      ac.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      post(new b.10(this, arrayOfe));
    }
    AppMethodBeat.o(22709);
  }
  
  public final boolean bOt()
  {
    AppMethodBeat.i(22714);
    long l1 = bOs();
    long l2 = bOv();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOr, Long.valueOf(0L))).longValue() <= 0L)) {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOr, Long.valueOf(bs.aNx()));
      }
      AppMethodBeat.o(22714);
      return bool;
    }
  }
  
  public final void bOu()
  {
    AppMethodBeat.i(22715);
    this.nSh = false;
    this.nSg.clear();
    ac.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), bs.eWi() });
    AppMethodBeat.o(22715);
  }
  
  public final String blf()
  {
    AppMethodBeat.i(22721);
    String str = hashCode();
    AppMethodBeat.o(22721);
    return str;
  }
  
  public final void jh(final boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(22708);
    String str = blf();
    if (this.nSj != null) {
      bool = true;
    }
    ac.d("MicroMsg.CalcWxService", "%s manual scan now manualScanTask[%b] uiClick[%b]", new Object[] { str, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
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
          lj locallj = new lj();
          if (b.this.bOt())
          {
            b.a(b.this, false);
            locallj.dnd.cEQ = true;
            com.tencent.mm.sdk.b.a.GpY.l(locallj);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(664L, 9L, 1L, false);
            AppMethodBeat.o(22694);
            return;
          }
          if (paramBoolean) {
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(664L, 7L, 1L, false);
          }
          locallj.dnd.progress = b.bOv();
          locallj.dnd.dne = b.bOs();
          locallj.dnd.cEQ = false;
          com.tencent.mm.sdk.b.a.GpY.l(locallj);
          b.a(b.this, new com.tencent.mm.plugin.f.c.d("message", b.bOv(), b.bOw(), b.c(b.this)));
          b.d(b.this).postToWorker(b.b(b.this));
          if (((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOq, Long.valueOf(0L))).longValue() <= 0L) {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOq, Long.valueOf(bs.aNx()));
          }
        }
        AppMethodBeat.o(22694);
      }
    });
    AppMethodBeat.o(22708);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(22711);
    ac.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { blf() });
    if (this.nSe == null)
    {
      ac.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { blf() });
      this.nSe = new ao("calc-wx");
      this.nSe.setLogging(false);
    }
    paramc = com.tencent.mm.kernel.g.agR().cachePath + "WxFileIndex.db";
    this.nSc = r.a(hashCode(), paramc, nSa, true);
    this.nSl.put(Integer.valueOf(43), new com.tencent.mm.plugin.f.a.e());
    this.nSl.put(Integer.valueOf(62), new com.tencent.mm.plugin.f.a.e());
    this.nSl.put(Integer.valueOf(44), new com.tencent.mm.plugin.f.a.e());
    this.nSl.put(Integer.valueOf(486539313), new com.tencent.mm.plugin.f.a.e());
    this.nSl.put(Integer.valueOf(34), new f());
    this.nSl.put(Integer.valueOf(3), new com.tencent.mm.plugin.f.a.d());
    this.nSl.put(Integer.valueOf(49), new com.tencent.mm.plugin.f.a.c());
    this.nSl.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.f.a.b());
    bOs();
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.ftg, null);
    com.tencent.mm.sdk.b.a.GpY.b(this.nSo);
    paramc = ai.getContext();
    Object localObject = paramc.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool;
    if (localObject != null)
    {
      int i = ((Intent)localObject).getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
    }
    for (this.nSp = bool;; this.nSp = false)
    {
      this.nSq = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.nSr = new BroadcastReceiver()
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
            ac.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
            if (b.l(b.this) != null) {
              break label313;
            }
            b.b(b.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(22689);
                b.this.bOr();
                ac.i("MicroMsg.CalcWxService", "start to calc");
                if (b.this.bOt())
                {
                  b localb = b.this;
                  if (bs.Ap(((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GOp, Long.valueOf(0L))).longValue()) >= 259200000L)
                  {
                    if (localb.nSk != null) {
                      localb.nSk.isStop = true;
                    }
                    localb.nSk = new com.tencent.mm.plugin.f.c.c();
                    localb.post(localb.nSk);
                    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOp, Long.valueOf(bs.eWj()));
                  }
                  AppMethodBeat.o(22689);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(664L, 1L, 1L, false);
                b.i(b.this);
                AppMethodBeat.o(22689);
              }
            });
            az.agU().m(b.l(b.this), 300000L);
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
            az.agU();
            ap.aB(b.l(b.this));
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
      paramc.registerReceiver(this.nSr, (IntentFilter)localObject);
      com.tencent.mm.sdk.b.a.GpY.b(this.nSu);
      if (this.nSt) {
        com.tencent.mm.sdk.b.a.GpY.l(new bv());
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
    ac.i("MicroMsg.CalcWxService", "CalcWxService Release");
    this.nSg.clear();
    this.nSh = false;
    if (this.nSc != null)
    {
      this.nSc.qx(hashCode());
      this.nSc = null;
    }
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a(this.ftg);
    com.tencent.mm.sdk.b.a.GpY.d(this.nSo);
    this.nSl.clear();
    if (this.nSr != null)
    {
      ai.getContext().unregisterReceiver(this.nSr);
      this.nSr = null;
    }
    if (this.nSs != null)
    {
      az.agU();
      ap.aB(this.nSs);
      this.nSs = null;
    }
    stopScan();
    if (this.nSe != null)
    {
      ac.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { blf() });
      this.nSe.quit();
    }
    this.nSe = null;
    com.tencent.mm.sdk.b.a.GpY.d(this.nSu);
    AppMethodBeat.o(22712);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(22707);
    try
    {
      if (this.nSe != null)
      {
        this.nSe.postToWorker(paramRunnable);
        AppMethodBeat.o(22707);
        return;
      }
      ac.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { blf() });
      AppMethodBeat.o(22707);
      return;
    }
    catch (Exception paramRunnable)
    {
      ac.printErrStackTrace("MicroMsg.CalcWxService", paramRunnable, "post error: [%s]", new Object[] { paramRunnable.toString() });
      AppMethodBeat.o(22707);
    }
  }
  
  public final void rz(long paramLong)
  {
    AppMethodBeat.i(22718);
    ac.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.agR().agA().set(ah.a.GOn, Long.valueOf(paramLong));
    AppMethodBeat.o(22718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b
 * JD-Core Version:    0.7.0.1
 */