package com.tencent.mm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cr.a;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.f.a.f;
import com.tencent.mm.plugin.f.c.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.b> ovv;
  private static b ovy;
  private i.a fLG;
  private com.tencent.mm.plugin.f.c.d ovA;
  public HashSet<Long> ovB;
  public boolean ovC;
  private boolean ovD;
  public com.tencent.mm.plugin.f.c.d ovE;
  com.tencent.mm.plugin.f.c.c ovF;
  private HashMap<Integer, com.tencent.mm.plugin.f.a.a> ovG;
  private d.a ovH;
  private d.a ovI;
  private com.tencent.mm.sdk.b.c<cr> ovJ;
  private boolean ovK;
  private boolean ovL;
  private BroadcastReceiver ovM;
  private Runnable ovN;
  private boolean ovO;
  private com.tencent.mm.sdk.b.c<by> ovP;
  private com.tencent.mm.plugin.f.b.b ovw;
  private r.a ovx;
  private ap ovz;
  
  static
  {
    AppMethodBeat.i(22725);
    HashMap localHashMap = new HashMap();
    ovv = localHashMap;
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
    this.ovA = null;
    this.ovB = new HashSet();
    this.ovC = false;
    this.ovD = false;
    this.ovE = null;
    this.ovF = null;
    this.ovG = new HashMap();
    this.ovH = new d.a()
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
            b.this.js(false);
            AppMethodBeat.o(22696);
          }
        });
        AppMethodBeat.o(22697);
      }
    };
    this.ovI = new d.a()
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
    this.fLG = new i.a()
    {
      public final void a(i paramAnonymousi, final i.c paramAnonymousc)
      {
        AppMethodBeat.i(22686);
        if (com.tencent.mm.sdk.a.b.fjP())
        {
          AppMethodBeat.o(22686);
          return;
        }
        if (paramAnonymousi == null)
        {
          AppMethodBeat.o(22686);
          return;
        }
        if ((paramAnonymousc == null) || (paramAnonymousc.gNE == null))
        {
          AppMethodBeat.o(22686);
          return;
        }
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22685);
            ad.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { paramAnonymousc.vKe, Integer.valueOf(paramAnonymousc.gNE.size()) });
            if ("delete".equals(paramAnonymousc.vKe))
            {
              AppMethodBeat.o(22685);
              return;
            }
            int i;
            Iterator localIterator;
            if ("delete".equals(paramAnonymousc.vKe))
            {
              i = 2;
              localIterator = paramAnonymousc.gNE.iterator();
            }
            for (;;)
            {
              label94:
              if (!localIterator.hasNext()) {
                break label230;
              }
              Object localObject = (bu)localIterator.next();
              if (localObject != null)
              {
                b localb = b.this;
                long l = ((ei)localObject).field_msgId;
                if (localb.ovC) {}
                for (boolean bool = localb.ovB.contains(Long.valueOf(l));; bool = false)
                {
                  if (!bool) {
                    break label199;
                  }
                  ad.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
                  break label94;
                  i = 1;
                  break;
                }
                label199:
                localObject = new com.tencent.mm.plugin.f.c.b((bu)localObject, i);
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
    this.ovJ = new com.tencent.mm.sdk.b.c() {};
    this.ovK = false;
    this.ovL = true;
    this.ovO = false;
    this.ovP = new com.tencent.mm.sdk.b.c()
    {
      private boolean bTc()
      {
        AppMethodBeat.i(22692);
        ad.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { b.this.boQ() });
        b.d(b.this, true);
        try
        {
          com.tencent.mm.kernel.g.ajF().ay(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22691);
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAJ, Long.valueOf(-1L));
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAI, Long.valueOf(0L));
              com.tencent.mm.kernel.g.ajC().ajl().fqc();
              b.bSU().bSV().delete();
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
            ad.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { b.this.boQ() });
          }
        }
      }
    };
    AppMethodBeat.o(22704);
  }
  
  public static void K(int paramInt, long paramLong)
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
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAH, Integer.valueOf(i));
      paramInt = ((Integer)com.tencent.mm.plugin.report.service.g.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(664L, paramInt, 1L, false);
      AppMethodBeat.o(22717);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  public static b bSU()
  {
    try
    {
      AppMethodBeat.i(22705);
      if (ovy == null) {
        ovy = new b();
      }
      b localb = ovy;
      AppMethodBeat.o(22705);
      return localb;
    }
    finally {}
  }
  
  public static long bSX()
  {
    AppMethodBeat.i(22713);
    long l2 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAJ, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqv("message");
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAJ, Long.valueOf(l1));
    }
    AppMethodBeat.o(22713);
    return l1;
  }
  
  public static long bTa()
  {
    AppMethodBeat.i(22719);
    long l = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAI, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(22719);
    return l;
  }
  
  public static int bTb()
  {
    AppMethodBeat.i(22720);
    int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAH, Integer.valueOf(5))).intValue();
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
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(664L, 2L, 1L, false);
        }
        if (b.h(b.this) != null) {
          b.h(b.this).isStop = true;
        }
        AppMethodBeat.o(22701);
      }
    });
    AppMethodBeat.o(22710);
  }
  
  public final void ad(bu parambu)
  {
    AppMethodBeat.i(22716);
    if (parambu == null)
    {
      AppMethodBeat.o(22716);
      return;
    }
    try
    {
      com.tencent.mm.plugin.f.a.a locala = (com.tencent.mm.plugin.f.a.a)this.ovG.get(Integer.valueOf(parambu.getType()));
      if (locala != null) {
        locala.ae(parambu);
      }
      AppMethodBeat.o(22716);
      return;
    }
    catch (Exception parambu)
    {
      ad.printErrStackTrace("MicroMsg.CalcWxService", parambu, "", new Object[0]);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(664L, 5L, 1L, false);
      AppMethodBeat.o(22716);
    }
  }
  
  public final com.tencent.mm.plugin.f.b.b bSV()
  {
    AppMethodBeat.i(22706);
    if (this.ovw == null) {
      this.ovw = new com.tencent.mm.plugin.f.b.b(this.ovx);
    }
    com.tencent.mm.plugin.f.b.b localb = this.ovw;
    AppMethodBeat.o(22706);
    return localb;
  }
  
  public final void bSW()
  {
    boolean bool = false;
    AppMethodBeat.i(22709);
    com.tencent.mm.vfs.e[] arrayOfe = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.arU()).a(new b.9(this));
    if ((arrayOfe != null) && (arrayOfe.length > 0))
    {
      String str = boQ();
      if (this.ovE != null) {
        bool = true;
      }
      ad.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      post(new b.10(this, arrayOfe));
    }
    AppMethodBeat.o(22709);
  }
  
  public final boolean bSY()
  {
    AppMethodBeat.i(22714);
    long l1 = bSX();
    long l2 = bTa();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAM, Long.valueOf(0L))).longValue() <= 0L)) {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAM, Long.valueOf(bt.aQJ()));
      }
      AppMethodBeat.o(22714);
      return bool;
    }
  }
  
  public final void bSZ()
  {
    AppMethodBeat.i(22715);
    this.ovC = false;
    this.ovB.clear();
    ad.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), bt.flS() });
    AppMethodBeat.o(22715);
  }
  
  public final String boQ()
  {
    AppMethodBeat.i(22721);
    String str = hashCode();
    AppMethodBeat.o(22721);
    return str;
  }
  
  public final void js(final boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(22708);
    String str = boQ();
    if (this.ovE != null) {
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
          ls localls = new ls();
          if (b.this.bSY())
          {
            b.a(b.this, false);
            localls.dyR.cPV = true;
            com.tencent.mm.sdk.b.a.IbL.l(localls);
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(664L, 9L, 1L, false);
            AppMethodBeat.o(22694);
            return;
          }
          if (paramBoolean) {
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(664L, 7L, 1L, false);
          }
          localls.dyR.progress = b.bTa();
          localls.dyR.dyS = b.bSX();
          localls.dyR.cPV = false;
          com.tencent.mm.sdk.b.a.IbL.l(localls);
          b.a(b.this, new com.tencent.mm.plugin.f.c.d("message", b.bTa(), b.bTb(), b.c(b.this)));
          b.d(b.this).postToWorker(b.b(b.this));
          if (((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAL, Long.valueOf(0L))).longValue() <= 0L) {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAL, Long.valueOf(bt.aQJ()));
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
    ad.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { boQ() });
    if (this.ovz == null)
    {
      ad.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { boQ() });
      this.ovz = new ap("calc-wx");
      this.ovz.setLogging(false);
    }
    paramc = com.tencent.mm.kernel.g.ajC().cachePath + "WxFileIndex.db";
    this.ovx = r.a(hashCode(), paramc, ovv, true);
    this.ovG.put(Integer.valueOf(43), new com.tencent.mm.plugin.f.a.e());
    this.ovG.put(Integer.valueOf(62), new com.tencent.mm.plugin.f.a.e());
    this.ovG.put(Integer.valueOf(44), new com.tencent.mm.plugin.f.a.e());
    this.ovG.put(Integer.valueOf(486539313), new com.tencent.mm.plugin.f.a.e());
    this.ovG.put(Integer.valueOf(34), new f());
    this.ovG.put(Integer.valueOf(3), new com.tencent.mm.plugin.f.a.d());
    this.ovG.put(Integer.valueOf(49), new com.tencent.mm.plugin.f.a.c());
    this.ovG.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.f.a.b());
    bSX();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.fLG, null);
    com.tencent.mm.sdk.b.a.IbL.b(this.ovJ);
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
    for (this.ovK = bool;; this.ovK = false)
    {
      this.ovL = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.ovM = new BroadcastReceiver()
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
                b.this.bSW();
                ad.i("MicroMsg.CalcWxService", "start to calc");
                if (b.this.bSY())
                {
                  b localb = b.this;
                  if (bt.Df(((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAK, Long.valueOf(0L))).longValue()) >= 259200000L)
                  {
                    if (localb.ovF != null) {
                      localb.ovF.isStop = true;
                    }
                    localb.ovF = new com.tencent.mm.plugin.f.c.c();
                    localb.post(localb.ovF);
                    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAK, Long.valueOf(bt.flT()));
                  }
                  AppMethodBeat.o(22689);
                  return;
                }
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(664L, 1L, 1L, false);
                b.i(b.this);
                AppMethodBeat.o(22689);
              }
            });
            ba.ajF().n(b.l(b.this), 300000L);
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
            ba.ajF();
            aq.aA(b.l(b.this));
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
      paramc.registerReceiver(this.ovM, (IntentFilter)localObject);
      com.tencent.mm.sdk.b.a.IbL.b(this.ovP);
      if (this.ovO) {
        com.tencent.mm.sdk.b.a.IbL.l(new by());
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
    this.ovB.clear();
    this.ovC = false;
    if (this.ovx != null)
    {
      this.ovx.qX(hashCode());
      this.ovx = null;
    }
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a(this.fLG);
    com.tencent.mm.sdk.b.a.IbL.d(this.ovJ);
    this.ovG.clear();
    if (this.ovM != null)
    {
      aj.getContext().unregisterReceiver(this.ovM);
      this.ovM = null;
    }
    if (this.ovN != null)
    {
      ba.ajF();
      aq.aA(this.ovN);
      this.ovN = null;
    }
    stopScan();
    if (this.ovz != null)
    {
      ad.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { boQ() });
      this.ovz.quit();
    }
    this.ovz = null;
    com.tencent.mm.sdk.b.a.IbL.d(this.ovP);
    AppMethodBeat.o(22712);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(22707);
    try
    {
      if (this.ovz != null)
      {
        this.ovz.postToWorker(paramRunnable);
        AppMethodBeat.o(22707);
        return;
      }
      ad.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { boQ() });
      AppMethodBeat.o(22707);
      return;
    }
    catch (Exception paramRunnable)
    {
      ad.printErrStackTrace("MicroMsg.CalcWxService", paramRunnable, "post error: [%s]", new Object[] { paramRunnable.toString() });
      AppMethodBeat.o(22707);
    }
  }
  
  public final void ty(long paramLong)
  {
    AppMethodBeat.i(22718);
    ad.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAI, Long.valueOf(paramLong));
    AppMethodBeat.o(22718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b
 * JD-Core Version:    0.7.0.1
 */