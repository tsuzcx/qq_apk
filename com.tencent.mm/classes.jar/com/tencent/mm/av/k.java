package com.tencent.mm.av;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.v;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class k
  implements f, com.tencent.mm.ak.g
{
  private static Set<Integer> idH;
  private Queue<g> djp;
  private boolean djt;
  int dju;
  private long djv;
  f.a djy;
  private aw djz;
  private LinkedList<n> idI;
  public a idJ;
  private boolean idK;
  public com.tencent.mm.ak.k idL;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(150665);
    idH = new HashSet();
    AppMethodBeat.o(150665);
  }
  
  public k()
  {
    AppMethodBeat.i(150654);
    this.idI = new LinkedList();
    this.idJ = null;
    this.idK = false;
    this.idL = new com.tencent.mm.ak.k()
    {
      public final void aEZ()
      {
        AppMethodBeat.i(150643);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajU().aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150642);
            ae.i("MicroMsg.ImgService", "on image upload end. queue size : " + k.a(k.this).size());
            k.a(k.this, false);
            if (k.a(k.this).size() > 0)
            {
              n localn = (n)k.a(k.this).poll();
              if (localn != null)
              {
                ae.i("MicroMsg.ImgService", "upload image scene hashcode : " + localn.hashCode());
                com.tencent.mm.kernel.g.ajQ().gDv.a(localn, 0);
                k.a(k.this, true);
                AppMethodBeat.o(150642);
                return;
              }
              ae.w("MicroMsg.ImgService", "poll image scene is null");
            }
            AppMethodBeat.o(150642);
          }
        });
        AppMethodBeat.o(150643);
      }
    };
    this.djp = new LinkedList();
    this.running = false;
    this.dju = 0;
    this.djv = 0L;
    this.djt = false;
    this.djy = new f.a();
    com.tencent.mm.kernel.g.ajS();
    this.djz = new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
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
            ae.e("MicroMsg.ImgService", "exception:%s", new Object[] { bu.o(localException) });
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
    if (com.tencent.mm.kernel.g.ajQ().gDv != null) {
      com.tencent.mm.kernel.g.ajQ().gDv.a(110, this);
    }
    this.idI.clear();
    this.idK = false;
    AppMethodBeat.o(150654);
  }
  
  private void Qd()
  {
    AppMethodBeat.i(150660);
    this.djp.clear();
    this.running = false;
    ae.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.djy.abs());
    AppMethodBeat.o(150660);
  }
  
  public static boolean pA(int paramInt)
  {
    AppMethodBeat.i(150653);
    if ((com.tencent.mm.sdk.a.b.fnF()) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {
      ae.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bu.fpN().toString() });
    }
    boolean bool = idH.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(150653);
    return bool;
  }
  
  public static void pB(int paramInt)
  {
    AppMethodBeat.i(150658);
    ae.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    g localg = q.aIX().pw(paramInt);
    if ((localg == null) || (localg.doE <= 0L))
    {
      AppMethodBeat.o(150658);
      return;
    }
    Object localObject = q.aIX().py((int)localg.doE);
    if (localObject != null)
    {
      ((g)localObject).setStatus(-1);
      ((g)localObject).dEu = 264;
      q.aIX().a((int)((g)localObject).doE, (g)localObject);
    }
    for (localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(((g)localObject).icx); ((ei)localObject).field_msgId != localg.icx; localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localg.icx))
    {
      AppMethodBeat.o(150658);
      return;
      localg.setStatus(-1);
      localg.dEu = 264;
      q.aIX().a(paramInt, localg);
    }
    ((bv)localObject).setStatus(5);
    e.ywz.idkeyStat(111L, 31L, 1L, true);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a((int)((ei)localObject).field_msgId, (bv)localObject);
    AppMethodBeat.o(150658);
  }
  
  public static boolean pz(int paramInt)
  {
    AppMethodBeat.i(150652);
    if ((com.tencent.mm.sdk.a.b.fnF()) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE)) {
      ae.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bu.fpN().toString() });
    }
    boolean bool = idH.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(150652);
    return bool;
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(150655);
    if (v.f(paramString3, paramString2, paramBoolean)) {}
    for (int i = 1;; i = 0)
    {
      ae.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      o.e locale = o.a(o.d.iiQ).pn(3);
      locale.dzZ = paramString1;
      locale.toUser = paramString2;
      locale.iey = paramString3;
      locale.icr = i;
      locale.iiW = this;
      locale.dyw = paramInt;
      locale.iiX = this.idL;
      locale.iiZ = true;
      locale.iiY = 2131231564;
      locale.iiV = 10;
      paramString1 = (n)locale.aJO().iiO;
      a(paramString1);
      long l = paramString1.aIJ().field_msgId;
      AppMethodBeat.o(150655);
      return l;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(150662);
    paramn = (n)paramn;
    if ((this.idJ != null) && (paramn != null) && (paramn.aIJ() != null)) {
      this.idJ.a(paramn.aIJ().field_msgId, paramInt1, paramInt2);
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
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150644);
        ae.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(k.b(k.this)), Integer.valueOf(paramn.hashCode()) });
        if (k.b(k.this))
        {
          k.a(k.this).offer(paramn);
          AppMethodBeat.o(150644);
          return;
        }
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramn, 0);
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
      if (v.f(str, paramString2, false)) {}
      for (int i = 1;; i = 0)
      {
        ae.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.FALSE, Integer.valueOf(i) });
        o.e locale = o.a(o.d.iiQ).pn(3);
        locale.dzZ = paramString1;
        locale.toUser = paramString2;
        locale.iey = str;
        locale.icr = i;
        locale.iiW = this;
        locale.dyw = 0;
        locale.iiX = this.idL;
        locale.iiZ = true;
        locale.iiY = 2131231564;
        locale.iiV = 10;
        a((n)locale.aJO().iiO);
        break;
      }
    }
    AppMethodBeat.o(150656);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(150659);
    ae.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala;
    long l;
    if ((paramn instanceof n))
    {
      paramString = (n)paramn;
      if ((this.idJ != null) && (paramString != null) && (paramString.aIJ() != null))
      {
        locala = this.idJ;
        l = paramString.aIJ().field_msgId;
        if (paramString.aIJ().field_status == 5) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      locala.j(l, bool);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
          int i = (int)((n)paramn).idT;
          if (k.d(k.this) > 0) {
            k.e(k.this);
          }
          for (;;)
          {
            k.pA(i);
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
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
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
          ae.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + k.h(k.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + k.h(k.this));
        }
        ae.i("MicroMsg.ImgService", "run from run");
        k.i(k.this);
        k.j(k.this);
        k.this.djy.gfF = SystemClock.elapsedRealtime();
        k.k(k.this).ay(10L, 10L);
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
 * Qualified Name:     com.tencent.mm.av.k
 * JD-Core Version:    0.7.0.1
 */