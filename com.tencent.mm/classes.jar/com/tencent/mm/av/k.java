package com.tencent.mm.av;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class k
  implements com.tencent.mm.ak.i, j
{
  private static Set<Integer> iYD;
  private Queue<g> dAA;
  private boolean dAE;
  int dAF;
  private long dAG;
  f.a dAI;
  private MTimerHandler dAJ;
  private LinkedList<n> iYE;
  public a iYF;
  private boolean iYG;
  public com.tencent.mm.ak.n iYH;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(150665);
    iYD = new HashSet();
    AppMethodBeat.o(150665);
  }
  
  public k()
  {
    AppMethodBeat.i(150654);
    this.iYE = new LinkedList();
    this.iYF = null;
    this.iYG = false;
    this.iYH = new com.tencent.mm.ak.n()
    {
      public final void aYO()
      {
        AppMethodBeat.i(150643);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150642);
            Log.i("MicroMsg.ImgService", "on image upload end. queue size : " + k.a(k.this).size());
            k.a(k.this, false);
            if (k.a(k.this).size() > 0)
            {
              n localn = (n)k.a(k.this).poll();
              if (localn != null)
              {
                Log.i("MicroMsg.ImgService", "upload image scene hashcode : " + localn.hashCode());
                com.tencent.mm.kernel.g.aAg().hqi.a(localn, 0);
                k.a(k.this, true);
                AppMethodBeat.o(150642);
                return;
              }
              Log.w("MicroMsg.ImgService", "poll image scene is null");
            }
            AppMethodBeat.o(150642);
          }
        });
        AppMethodBeat.o(150643);
      }
    };
    this.dAA = new LinkedList();
    this.running = false;
    this.dAF = 0;
    this.dAG = 0L;
    this.dAE = false;
    this.dAI = new f.a();
    com.tencent.mm.kernel.g.aAi();
    this.dAJ = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), new k.5(this), false);
    if (com.tencent.mm.kernel.g.aAg().hqi != null) {
      com.tencent.mm.kernel.g.aAg().hqi.a(110, this);
    }
    this.iYE.clear();
    this.iYG = false;
    AppMethodBeat.o(150654);
  }
  
  private void aax()
  {
    AppMethodBeat.i(150660);
    this.dAA.clear();
    this.running = false;
    Log.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.dAI.apr());
    AppMethodBeat.o(150660);
  }
  
  public static boolean tn(int paramInt)
  {
    AppMethodBeat.i(150652);
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      Log.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    }
    boolean bool = iYD.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(150652);
    return bool;
  }
  
  public static boolean to(int paramInt)
  {
    AppMethodBeat.i(150653);
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      Log.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    }
    boolean bool = iYD.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(150653);
    return bool;
  }
  
  public static void tp(int paramInt)
  {
    AppMethodBeat.i(150658);
    Log.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    g localg = q.bcR().tl(paramInt);
    if ((localg == null) || (localg.localId <= 0L))
    {
      AppMethodBeat.o(150658);
      return;
    }
    Object localObject = q.bcR().tm((int)localg.localId);
    if (localObject != null)
    {
      ((g)localObject).setStatus(-1);
      ((g)localObject).cSx = 264;
      q.bcR().a((int)((g)localObject).localId, (g)localObject);
    }
    for (localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(((g)localObject).iXv); ((eo)localObject).field_msgId != localg.iXv; localObject = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(localg.iXv))
    {
      AppMethodBeat.o(150658);
      return;
      localg.setStatus(-1);
      localg.cSx = 264;
      q.bcR().a(paramInt, localg);
    }
    ((ca)localObject).setStatus(5);
    e.Cxv.idkeyStat(111L, 31L, 1L, true);
    ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().a((int)((eo)localObject).field_msgId, (ca)localObject);
    AppMethodBeat.o(150658);
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(150655);
    if (z.f(paramString3, paramString2, paramBoolean)) {}
    for (int i = 1;; i = 0)
    {
      Log.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      o.e locale = o.a(o.d.jdL).tc(3);
      locale.dRL = paramString1;
      locale.toUser = paramString2;
      locale.iZt = paramString3;
      locale.iXp = i;
      locale.jdS = this;
      locale.dQd = paramInt;
      locale.jdT = this.iYH;
      locale.jdV = true;
      locale.jdU = 2131231628;
      locale.jdR = 10;
      paramString1 = (n)locale.bdQ().jdJ;
      a(paramString1);
      long l = paramString1.bcD().field_msgId;
      AppMethodBeat.o(150655);
      return l;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(150662);
    paramq = (n)paramq;
    if ((this.iYF != null) && (paramq != null) && (paramq.bcD() != null)) {
      this.iYF.a(paramq.bcD().field_msgId, paramInt1, paramInt2);
    }
    AppMethodBeat.o(150662);
  }
  
  public final void a(final n paramn)
  {
    AppMethodBeat.i(150657);
    if (paramn == null)
    {
      AppMethodBeat.o(150657);
      return;
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150644);
        Log.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(k.b(k.this)), Integer.valueOf(paramn.hashCode()) });
        if (k.b(k.this))
        {
          k.a(k.this).offer(paramn);
          AppMethodBeat.o(150644);
          return;
        }
        com.tencent.mm.kernel.g.aAg().hqi.a(paramn, 0);
        k.a(k.this, true);
        AppMethodBeat.o(150644);
      }
    });
    AppMethodBeat.o(150657);
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(150656);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (z.f(str, paramString2, false)) {}
      for (int i = 1;; i = 0)
      {
        Log.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.FALSE, Integer.valueOf(i) });
        o.e locale = o.a(o.d.jdL).tc(3);
        locale.dRL = paramString1;
        locale.toUser = paramString2;
        locale.iZt = str;
        locale.iXp = i;
        locale.jdS = this;
        locale.dQd = 0;
        locale.jdT = this.iYH;
        locale.jdV = true;
        locale.jdU = 2131231628;
        locale.jdR = 10;
        a((n)locale.bdQ().jdJ);
        break;
      }
    }
    AppMethodBeat.o(150656);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(150659);
    Log.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala;
    long l;
    if ((paramq instanceof n))
    {
      paramString = (n)paramq;
      if ((this.iYF != null) && (paramString != null) && (paramString.bcD() != null))
      {
        locala = this.iYF;
        l = paramString.bcD().field_msgId;
        if (paramString.bcD().field_status == 5) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      locala.j(l, bool);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150645);
          if (paramq.getType() != 110)
          {
            AppMethodBeat.o(150645);
            return;
          }
          if (!(paramq instanceof n))
          {
            AppMethodBeat.o(150645);
            return;
          }
          k.c(k.this);
          int i = (int)((n)paramq).iYP;
          if (k.d(k.this) > 0) {
            k.e(k.this);
          }
          for (;;)
          {
            k.to(i);
            AppMethodBeat.o(150645);
            return;
            k.f(k.this);
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(150646);
          String str = super.toString() + "|onSceneEnd";
          AppMethodBeat.o(150646);
          return str;
        }
      });
      AppMethodBeat.o(150659);
      return;
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(150661);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150647);
        long l = System.currentTimeMillis() - k.g(k.this);
        if (k.h(k.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(150647);
            return;
          }
          Log.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + k.h(k.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + k.h(k.this));
        }
        Log.i("MicroMsg.ImgService", "run from run");
        k.i(k.this);
        k.j(k.this);
        k.this.dAI.gLm = SystemClock.elapsedRealtime();
        k.k(k.this).startTimer(10L);
        AppMethodBeat.o(150647);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150648);
        String str = super.toString() + "|run";
        AppMethodBeat.o(150648);
        return str;
      }
    });
    AppMethodBeat.o(150661);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, int paramInt1, int paramInt2);
    
    public abstract void j(long paramLong, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.k
 * JD-Core Version:    0.7.0.1
 */