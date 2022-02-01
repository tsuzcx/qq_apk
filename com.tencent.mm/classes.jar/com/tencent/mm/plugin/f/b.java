package com.tencent.mm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.f.a.f;
import com.tencent.mm.plugin.f.c.d.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.b> oBW;
  private static b oBZ;
  private i.a fNK;
  private com.tencent.mm.plugin.f.b.b oBX;
  private r.a oBY;
  private aq oCa;
  private com.tencent.mm.plugin.f.c.d oCb;
  public HashSet<Long> oCc;
  public boolean oCd;
  private boolean oCe;
  public com.tencent.mm.plugin.f.c.d oCf;
  com.tencent.mm.plugin.f.c.c oCg;
  private HashMap<Integer, com.tencent.mm.plugin.f.a.a> oCh;
  private d.a oCi;
  private d.a oCj;
  private com.tencent.mm.sdk.b.c<cs> oCk;
  private boolean oCl;
  private boolean oCm;
  private BroadcastReceiver oCn;
  private Runnable oCo;
  private boolean oCp;
  private com.tencent.mm.sdk.b.c<by> oCq;
  
  static
  {
    AppMethodBeat.i(22725);
    HashMap localHashMap = new HashMap();
    oBW = localHashMap;
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
    this.oCb = null;
    this.oCc = new HashSet();
    this.oCd = false;
    this.oCe = false;
    this.oCf = null;
    this.oCg = null;
    this.oCh = new HashMap();
    this.oCi = new d.a()
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
            b.this.jr(false);
            AppMethodBeat.o(22696);
          }
        });
        AppMethodBeat.o(22697);
      }
    };
    this.oCj = new d.a()
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
    this.fNK = new i.a()
    {
      public final void a(i paramAnonymousi, final i.c paramAnonymousc)
      {
        AppMethodBeat.i(22686);
        if (com.tencent.mm.sdk.a.b.fnH())
        {
          AppMethodBeat.o(22686);
          return;
        }
        if (paramAnonymousi == null)
        {
          AppMethodBeat.o(22686);
          return;
        }
        if ((paramAnonymousc == null) || (paramAnonymousc.gQn == null))
        {
          AppMethodBeat.o(22686);
          return;
        }
        b.a(b.this, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(22685);
            ae.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { paramAnonymousc.vWi, Integer.valueOf(paramAnonymousc.gQn.size()) });
            if ("delete".equals(paramAnonymousc.vWi))
            {
              AppMethodBeat.o(22685);
              return;
            }
            int i;
            Iterator localIterator;
            if ("delete".equals(paramAnonymousc.vWi))
            {
              i = 2;
              localIterator = paramAnonymousc.gQn.iterator();
            }
            for (;;)
            {
              label94:
              if (!localIterator.hasNext()) {
                break label230;
              }
              Object localObject = (bv)localIterator.next();
              if (localObject != null)
              {
                b localb = b.this;
                long l = ((ei)localObject).field_msgId;
                if (localb.oCd) {}
                for (boolean bool = localb.oCc.contains(Long.valueOf(l));; bool = false)
                {
                  if (!bool) {
                    break label199;
                  }
                  ae.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId) });
                  break label94;
                  i = 1;
                  break;
                }
                label199:
                localObject = new com.tencent.mm.plugin.f.c.b((bv)localObject, i);
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
    this.oCk = new com.tencent.mm.sdk.b.c() {};
    this.oCl = false;
    this.oCm = true;
    this.oCp = false;
    this.oCq = new com.tencent.mm.sdk.b.c()
    {
      private boolean bUr()
      {
        AppMethodBeat.i(22692);
        ae.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { b.this.bpA() });
        b.d(b.this, true);
        try
        {
          com.tencent.mm.kernel.g.ajU().aw(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(22691);
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVi, Long.valueOf(-1L));
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVh, Long.valueOf(0L));
              com.tencent.mm.kernel.g.ajR().ajA().fuc();
              b.bUj().bUk().delete();
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
            ae.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { b.this.bpA() });
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
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVg, Integer.valueOf(i));
      paramInt = ((Integer)com.tencent.mm.plugin.report.service.g.a(i, new int[] { 5, 10, 20, 25, 30 }, 10, 15)).intValue();
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(664L, paramInt, 1L, false);
      AppMethodBeat.o(22717);
      return;
      paramInt -= 5;
      break;
    }
  }
  
  public static b bUj()
  {
    try
    {
      AppMethodBeat.i(22705);
      if (oBZ == null) {
        oBZ = new b();
      }
      b localb = oBZ;
      AppMethodBeat.o(22705);
      return localb;
    }
    finally {}
  }
  
  public static long bUm()
  {
    AppMethodBeat.i(22713);
    long l2 = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVi, Long.valueOf(-1L))).longValue();
    long l1 = l2;
    if (l2 <= -1L)
    {
      l1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arA("message");
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVi, Long.valueOf(l1));
    }
    AppMethodBeat.o(22713);
    return l1;
  }
  
  public static long bUp()
  {
    AppMethodBeat.i(22719);
    long l = ((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVh, Long.valueOf(0L))).longValue();
    AppMethodBeat.o(22719);
    return l;
  }
  
  public static int bUq()
  {
    AppMethodBeat.i(22720);
    int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVg, Integer.valueOf(5))).intValue();
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
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(664L, 2L, 1L, false);
        }
        if (b.h(b.this) != null) {
          b.h(b.this).isStop = true;
        }
        AppMethodBeat.o(22701);
      }
    });
    AppMethodBeat.o(22710);
  }
  
  public final void ac(bv parambv)
  {
    AppMethodBeat.i(22716);
    if (parambv == null)
    {
      AppMethodBeat.o(22716);
      return;
    }
    try
    {
      com.tencent.mm.plugin.f.a.a locala = (com.tencent.mm.plugin.f.a.a)this.oCh.get(Integer.valueOf(parambv.getType()));
      if (locala != null) {
        locala.ad(parambv);
      }
      AppMethodBeat.o(22716);
      return;
    }
    catch (Exception parambv)
    {
      ae.printErrStackTrace("MicroMsg.CalcWxService", parambv, "", new Object[0]);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(664L, 5L, 1L, false);
      AppMethodBeat.o(22716);
    }
  }
  
  public final com.tencent.mm.plugin.f.b.b bUk()
  {
    AppMethodBeat.i(22706);
    if (this.oBX == null) {
      this.oBX = new com.tencent.mm.plugin.f.b.b(this.oBY);
    }
    com.tencent.mm.plugin.f.b.b localb = this.oBX;
    AppMethodBeat.o(22706);
    return localb;
  }
  
  public final void bUl()
  {
    boolean bool = false;
    AppMethodBeat.i(22709);
    k[] arrayOfk = new k(com.tencent.mm.loader.j.b.asj()).a(new m()
    {
      public final boolean accept(k paramAnonymousk)
      {
        AppMethodBeat.i(22698);
        if (paramAnonymousk.isDirectory())
        {
          AppMethodBeat.o(22698);
          return false;
        }
        if ((paramAnonymousk.getName().endsWith(".apk")) || (paramAnonymousk.getName().endsWith(".temp")))
        {
          AppMethodBeat.o(22698);
          return true;
        }
        AppMethodBeat.o(22698);
        return false;
      }
    });
    if ((arrayOfk != null) && (arrayOfk.length > 0))
    {
      String str = bpA();
      if (this.oCf != null) {
        bool = true;
      }
      ae.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", new Object[] { str, Boolean.valueOf(bool) });
      post(new b.10(this, arrayOfk));
    }
    AppMethodBeat.o(22709);
  }
  
  public final boolean bUn()
  {
    AppMethodBeat.i(22714);
    long l1 = bUm();
    long l2 = bUp();
    if (l2 >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
      if ((bool) && (((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVl, Long.valueOf(0L))).longValue() <= 0L)) {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVl, Long.valueOf(bu.aRi()));
      }
      AppMethodBeat.o(22714);
      return bool;
    }
  }
  
  public final void bUo()
  {
    AppMethodBeat.i(22715);
    this.oCd = false;
    this.oCc.clear();
    ae.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", new Object[] { Integer.valueOf(hashCode()), bu.fpN() });
    AppMethodBeat.o(22715);
  }
  
  public final String bpA()
  {
    AppMethodBeat.i(22721);
    String str = hashCode();
    AppMethodBeat.o(22721);
    return str;
  }
  
  public final void jr(final boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(22708);
    String str = bpA();
    if (this.oCf != null) {
      bool = true;
    }
    ae.d("MicroMsg.CalcWxService", "%s manual scan now manualScanTask[%b] uiClick[%b]", new Object[] { str, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
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
          lt locallt = new lt();
          if (b.this.bUn())
          {
            b.a(b.this, false);
            locallt.dzW.cQF = true;
            com.tencent.mm.sdk.b.a.IvT.l(locallt);
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(664L, 9L, 1L, false);
            AppMethodBeat.o(22694);
            return;
          }
          if (paramBoolean) {
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(664L, 7L, 1L, false);
          }
          locallt.dzW.progress = b.bUp();
          locallt.dzW.dzX = b.bUm();
          locallt.dzW.cQF = false;
          com.tencent.mm.sdk.b.a.IvT.l(locallt);
          b.a(b.this, new com.tencent.mm.plugin.f.c.d("message", b.bUp(), b.bUq(), b.c(b.this)));
          b.d(b.this).postToWorker(b.b(b.this));
          if (((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVk, Long.valueOf(0L))).longValue() <= 0L) {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVk, Long.valueOf(bu.aRi()));
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
    ae.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", new Object[] { bpA() });
    if (this.oCa == null)
    {
      ae.i("MicroMsg.CalcWxService", "%s init calc wx thread", new Object[] { bpA() });
      this.oCa = new aq("calc-wx");
      this.oCa.setLogging(false);
    }
    paramc = com.tencent.mm.kernel.g.ajR().cachePath + "WxFileIndex.db";
    this.oBY = r.a(hashCode(), paramc, oBW, true);
    this.oCh.put(Integer.valueOf(43), new com.tencent.mm.plugin.f.a.e());
    this.oCh.put(Integer.valueOf(62), new com.tencent.mm.plugin.f.a.e());
    this.oCh.put(Integer.valueOf(44), new com.tencent.mm.plugin.f.a.e());
    this.oCh.put(Integer.valueOf(486539313), new com.tencent.mm.plugin.f.a.e());
    this.oCh.put(Integer.valueOf(34), new f());
    this.oCh.put(Integer.valueOf(3), new com.tencent.mm.plugin.f.a.d());
    this.oCh.put(Integer.valueOf(49), new com.tencent.mm.plugin.f.a.c());
    this.oCh.put(Integer.valueOf(268435505), new com.tencent.mm.plugin.f.a.b());
    bUm();
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.fNK, null);
    com.tencent.mm.sdk.b.a.IvT.b(this.oCk);
    paramc = ak.getContext();
    Object localObject = paramc.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    boolean bool;
    if (localObject != null)
    {
      int i = ((Intent)localObject).getIntExtra("status", -1);
      if ((i == 2) || (i == 5)) {
        bool = true;
      }
    }
    for (this.oCl = bool;; this.oCl = false)
    {
      this.oCm = ((PowerManager)paramc.getSystemService("power")).isScreenOn();
      this.oCn = new BroadcastReceiver()
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
            ae.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
            if (b.l(b.this) != null) {
              break label313;
            }
            b.b(b.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(22689);
                b.this.bUl();
                ae.i("MicroMsg.CalcWxService", "start to calc");
                if (b.this.bUn())
                {
                  b localb = b.this;
                  if (bu.DD(((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IVj, Long.valueOf(0L))).longValue()) >= 259200000L)
                  {
                    if (localb.oCg != null) {
                      localb.oCg.isStop = true;
                    }
                    localb.oCg = new com.tencent.mm.plugin.f.c.c();
                    localb.post(localb.oCg);
                    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVj, Long.valueOf(bu.fpO()));
                  }
                  AppMethodBeat.o(22689);
                  return;
                }
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(664L, 1L, 1L, false);
                b.i(b.this);
                AppMethodBeat.o(22689);
              }
            });
            bc.ajU().n(b.l(b.this), 300000L);
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
            bc.ajU();
            ar.ay(b.l(b.this));
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
      paramc.registerReceiver(this.oCn, (IntentFilter)localObject);
      com.tencent.mm.sdk.b.a.IvT.b(this.oCq);
      if (this.oCp) {
        com.tencent.mm.sdk.b.a.IvT.l(new by());
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
    ae.i("MicroMsg.CalcWxService", "CalcWxService Release");
    this.oCc.clear();
    this.oCd = false;
    if (this.oBY != null)
    {
      this.oBY.ra(hashCode());
      this.oBY = null;
    }
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(this.fNK);
    com.tencent.mm.sdk.b.a.IvT.d(this.oCk);
    this.oCh.clear();
    if (this.oCn != null)
    {
      ak.getContext().unregisterReceiver(this.oCn);
      this.oCn = null;
    }
    if (this.oCo != null)
    {
      bc.ajU();
      ar.ay(this.oCo);
      this.oCo = null;
    }
    stopScan();
    if (this.oCa != null)
    {
      ae.i("MicroMsg.CalcWxService", "%s quit calc wx thread", new Object[] { bpA() });
      this.oCa.quit();
    }
    this.oCa = null;
    com.tencent.mm.sdk.b.a.IvT.d(this.oCq);
    AppMethodBeat.o(22712);
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(22707);
    try
    {
      if (this.oCa != null)
      {
        this.oCa.postToWorker(paramRunnable);
        AppMethodBeat.o(22707);
        return;
      }
      ae.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", new Object[] { bpA() });
      AppMethodBeat.o(22707);
      return;
    }
    catch (Exception paramRunnable)
    {
      ae.printErrStackTrace("MicroMsg.CalcWxService", paramRunnable, "post error: [%s]", new Object[] { paramRunnable.toString() });
      AppMethodBeat.o(22707);
    }
  }
  
  public final void tP(long paramLong)
  {
    AppMethodBeat.i(22718);
    ae.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVh, Long.valueOf(paramLong));
    AppMethodBeat.o(22718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b
 * JD-Core Version:    0.7.0.1
 */