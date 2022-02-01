package com.tencent.mm.aw;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class k
  implements f, com.tencent.mm.al.g
{
  private static Set<Integer> iaO;
  private Queue<g> dim;
  private boolean diq;
  int dis;
  private long dit;
  f.a diw;
  private av dix;
  private LinkedList<n> iaP;
  public a iaQ;
  private boolean iaR;
  public com.tencent.mm.al.k iaS;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(150665);
    iaO = new HashSet();
    AppMethodBeat.o(150665);
  }
  
  public k()
  {
    AppMethodBeat.i(150654);
    this.iaP = new LinkedList();
    this.iaQ = null;
    this.iaR = false;
    this.iaS = new com.tencent.mm.al.k()
    {
      public final void aEJ()
      {
        AppMethodBeat.i(150643);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150642);
            ad.i("MicroMsg.ImgService", "on image upload end. queue size : " + k.a(k.this).size());
            k.a(k.this, false);
            if (k.a(k.this).size() > 0)
            {
              n localn = (n)k.a(k.this).poll();
              if (localn != null)
              {
                ad.i("MicroMsg.ImgService", "upload image scene hashcode : " + localn.hashCode());
                com.tencent.mm.kernel.g.ajB().gAO.a(localn, 0);
                k.a(k.this, true);
                AppMethodBeat.o(150642);
                return;
              }
              ad.w("MicroMsg.ImgService", "poll image scene is null");
            }
            AppMethodBeat.o(150642);
          }
        });
        AppMethodBeat.o(150643);
      }
    };
    this.dim = new LinkedList();
    this.running = false;
    this.dis = 0;
    this.dit = 0L;
    this.diq = false;
    this.diw = new f.a();
    com.tencent.mm.kernel.g.ajD();
    this.dix = new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150649);
        try
        {
          k.e(k.this);
          AppMethodBeat.o(150649);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.ImgService", "exception:%s", new Object[] { bt.n(localException) });
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150650);
        String str = super.toString() + "|scenePusher";
        AppMethodBeat.o(150650);
        return str;
      }
    }, false);
    if (com.tencent.mm.kernel.g.ajB().gAO != null) {
      com.tencent.mm.kernel.g.ajB().gAO.a(110, this);
    }
    this.iaP.clear();
    this.iaR = false;
    AppMethodBeat.o(150654);
  }
  
  private void Qe()
  {
    AppMethodBeat.i(150660);
    this.dim.clear();
    this.running = false;
    ad.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.diw.abj());
    AppMethodBeat.o(150660);
  }
  
  public static boolean pv(int paramInt)
  {
    AppMethodBeat.i(150652);
    if ((com.tencent.mm.sdk.a.b.fjN()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
      ad.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bt.flS().toString() });
    }
    boolean bool = iaO.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(150652);
    return bool;
  }
  
  public static boolean pw(int paramInt)
  {
    AppMethodBeat.i(150653);
    if ((com.tencent.mm.sdk.a.b.fjN()) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE)) {
      ad.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bt.flS().toString() });
    }
    boolean bool = iaO.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(150653);
    return bool;
  }
  
  public static void py(int paramInt)
  {
    AppMethodBeat.i(150658);
    ad.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    g localg = q.aIF().pt(paramInt);
    if ((localg == null) || (localg.dnz <= 0L))
    {
      AppMethodBeat.o(150658);
      return;
    }
    Object localObject = q.aIF().pu((int)localg.dnz);
    if (localObject != null)
    {
      ((g)localObject).setStatus(-1);
      ((g)localObject).dDp = 264;
      q.aIF().a((int)((g)localObject).dnz, (g)localObject);
    }
    for (localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(((g)localObject).hZF); ((ei)localObject).field_msgId != localg.hZF; localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(localg.hZF))
    {
      AppMethodBeat.o(150658);
      return;
      localg.setStatus(-1);
      localg.dDp = 264;
      q.aIF().a(paramInt, localg);
    }
    ((bu)localObject).setStatus(5);
    e.ygI.idkeyStat(111L, 31L, 1L, true);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().a((int)((ei)localObject).field_msgId, (bu)localObject);
    AppMethodBeat.o(150658);
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(150655);
    if (u.f(paramString3, paramString2, paramBoolean)) {}
    for (int i = 1;; i = 0)
    {
      ad.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      o.e locale = o.a(o.d.ifX).pk(3);
      locale.dyU = paramString1;
      locale.toUser = paramString2;
      locale.ibF = paramString3;
      locale.hZz = i;
      locale.igd = this;
      locale.dxr = paramInt;
      locale.ige = this.iaS;
      locale.igg = true;
      locale.igf = 2131231564;
      locale.igc = 10;
      paramString1 = (n)locale.aJv().ifV;
      a(paramString1);
      long l = paramString1.aIr().field_msgId;
      AppMethodBeat.o(150655);
      return l;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(150662);
    paramn = (n)paramn;
    if ((this.iaQ != null) && (paramn != null) && (paramn.aIr() != null)) {
      this.iaQ.a(paramn.aIr().field_msgId, paramInt1, paramInt2);
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
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150644);
        ad.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(k.b(k.this)), Integer.valueOf(paramn.hashCode()) });
        if (k.b(k.this))
        {
          k.a(k.this).offer(paramn);
          AppMethodBeat.o(150644);
          return;
        }
        com.tencent.mm.kernel.g.ajB().gAO.a(paramn, 0);
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
      if (u.f(str, paramString2, false)) {}
      for (int i = 1;; i = 0)
      {
        ad.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.FALSE, Integer.valueOf(i) });
        o.e locale = o.a(o.d.ifX).pk(3);
        locale.dyU = paramString1;
        locale.toUser = paramString2;
        locale.ibF = str;
        locale.hZz = i;
        locale.igd = this;
        locale.dxr = 0;
        locale.ige = this.iaS;
        locale.igg = true;
        locale.igf = 2131231564;
        locale.igc = 10;
        a((n)locale.aJv().ifV);
        break;
      }
    }
    AppMethodBeat.o(150656);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(150659);
    ad.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala;
    long l;
    if ((paramn instanceof n))
    {
      paramString = (n)paramn;
      if ((this.iaQ != null) && (paramString != null) && (paramString.aIr() != null))
      {
        locala = this.iaQ;
        l = paramString.aIr().field_msgId;
        if (paramString.aIr().field_status == 5) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      locala.j(l, bool);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150645);
          if (paramn.getType() != 110)
          {
            AppMethodBeat.o(150645);
            return;
          }
          if (!(paramn instanceof n))
          {
            AppMethodBeat.o(150645);
            return;
          }
          k.c(k.this);
          int i = (int)((n)paramn).iba;
          if (k.d(k.this) > 0) {
            k.e(k.this);
          }
          for (;;)
          {
            k.pw(i);
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
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
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
          ad.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + k.h(k.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + k.h(k.this));
        }
        ad.i("MicroMsg.ImgService", "run from run");
        k.i(k.this);
        k.j(k.this);
        k.this.diw.gdx = SystemClock.elapsedRealtime();
        k.k(k.this).az(10L, 10L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.k
 * JD-Core Version:    0.7.0.1
 */