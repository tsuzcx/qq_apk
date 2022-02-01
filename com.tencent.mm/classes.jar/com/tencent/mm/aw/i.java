package com.tencent.mm.aw;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class i
  implements com.tencent.mm.al.g, com.tencent.mm.al.h
{
  private static Set<Integer> hhx;
  private Queue<e> cZA;
  private boolean cZE;
  int cZF;
  private long cZG;
  f.a cZJ;
  private av cZK;
  private boolean hhA;
  public l.a hhB;
  private LinkedList<l> hhy;
  public a hhz;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(150665);
    hhx = new HashSet();
    AppMethodBeat.o(150665);
  }
  
  public i()
  {
    AppMethodBeat.i(150654);
    this.hhy = new LinkedList();
    this.hhz = null;
    this.hhA = false;
    this.hhB = new l.a()
    {
      public final void ayp()
      {
        AppMethodBeat.i(150643);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afE().ax(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150642);
            ad.i("MicroMsg.ImgService", "on image upload end. queue size : " + i.a(i.this).size());
            i.a(i.this, false);
            if (i.a(i.this).size() > 0)
            {
              l locall = (l)i.a(i.this).poll();
              if (locall != null)
              {
                ad.i("MicroMsg.ImgService", "upload image scene hashcode : " + locall.hashCode());
                com.tencent.mm.kernel.g.afA().gcy.a(locall, 0);
                i.a(i.this, true);
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
    this.cZA = new LinkedList();
    this.running = false;
    this.cZF = 0;
    this.cZG = 0L;
    this.cZE = false;
    this.cZJ = new f.a();
    com.tencent.mm.kernel.g.afC();
    this.cZK = new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150649);
        try
        {
          i.e(i.this);
          AppMethodBeat.o(150649);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.e("MicroMsg.ImgService", "exception:%s", new Object[] { bt.m(localException) });
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
    if (com.tencent.mm.kernel.g.afA().gcy != null) {
      com.tencent.mm.kernel.g.afA().gcy.a(110, this);
    }
    this.hhy.clear();
    this.hhA = false;
    AppMethodBeat.o(150654);
  }
  
  private void Oy()
  {
    AppMethodBeat.i(150660);
    this.cZA.clear();
    this.running = false;
    ad.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.cZJ.XK());
    AppMethodBeat.o(150660);
  }
  
  public static boolean of(int paramInt)
  {
    AppMethodBeat.i(150652);
    if ((com.tencent.mm.sdk.a.b.eEQ()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
      ad.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bt.eGN().toString() });
    }
    boolean bool = hhx.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(150652);
    return bool;
  }
  
  public static boolean og(int paramInt)
  {
    AppMethodBeat.i(150653);
    if ((com.tencent.mm.sdk.a.b.eEQ()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
      ad.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bt.eGN().toString() });
    }
    boolean bool = hhx.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(150653);
    return bool;
  }
  
  public static void oh(int paramInt)
  {
    AppMethodBeat.i(150658);
    ad.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    e locale = o.ayF().od(paramInt);
    if ((locale == null) || (locale.deI <= 0L))
    {
      AppMethodBeat.o(150658);
      return;
    }
    Object localObject = o.ayF().oe((int)locale.deI);
    if (localObject != null)
    {
      ((e)localObject).setStatus(-1);
      ((e)localObject).dtM = 264;
      o.ayF().a((int)((e)localObject).deI, (e)localObject);
    }
    for (localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(((e)localObject).hgs); ((du)localObject).field_msgId != locale.hgs; localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(locale.hgs))
    {
      AppMethodBeat.o(150658);
      return;
      locale.setStatus(-1);
      locale.dtM = 264;
      o.ayF().a(paramInt, locale);
    }
    ((bl)localObject).setStatus(5);
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 31L, 1L, true);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().a((int)((du)localObject).field_msgId, (bl)localObject);
    AppMethodBeat.o(150658);
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(150655);
    if (u.f(paramString3, paramString2, paramBoolean)) {}
    for (int i = 1;; i = 0)
    {
      ad.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      paramString1 = new l(paramString1, paramString2, paramString3, i, this, paramInt, this.hhB);
      a(paramString1);
      long l = paramString1.dbD.field_msgId;
      AppMethodBeat.o(150655);
      return l;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(150662);
    paramn = (l)paramn;
    if ((this.hhz != null) && (paramn != null) && (paramn.dbD != null)) {
      this.hhz.a(paramn.dbD.field_msgId, paramInt1, paramInt2);
    }
    AppMethodBeat.o(150662);
  }
  
  public final void a(final l paraml)
  {
    AppMethodBeat.i(150657);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150644);
        ad.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(i.b(i.this)), Integer.valueOf(paraml.hashCode()) });
        if (i.b(i.this))
        {
          i.a(i.this).offer(paraml);
          AppMethodBeat.o(150644);
          return;
        }
        com.tencent.mm.kernel.g.afA().gcy.a(paraml, 0);
        i.a(i.this, true);
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
        a(new l(paramString1, paramString2, str, i, this, 0, this.hhB));
        break;
      }
    }
    AppMethodBeat.o(150656);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(150659);
    ad.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala;
    long l;
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      if ((this.hhz != null) && (paramString != null) && (paramString.dbD != null))
      {
        locala = this.hhz;
        l = paramString.dbD.field_msgId;
        if (paramString.dbD.field_status == 5) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      locala.h(l, bool);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150645);
          if (paramn.getType() != 110)
          {
            AppMethodBeat.o(150645);
            return;
          }
          if (!(paramn instanceof l))
          {
            AppMethodBeat.o(150645);
            return;
          }
          i.c(i.this);
          int i = (int)((l)paramn).hhJ;
          if (i.d(i.this) > 0) {
            i.e(i.this);
          }
          for (;;)
          {
            i.og(i);
            AppMethodBeat.o(150645);
            return;
            i.f(i.this);
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
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150647);
        long l = System.currentTimeMillis() - i.g(i.this);
        if (i.h(i.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(150647);
            return;
          }
          ad.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + i.h(i.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.h(i.this));
        }
        ad.i("MicroMsg.ImgService", "run from run");
        i.i(i.this);
        i.j(i.this);
        i.this.cZJ.fGp = SystemClock.elapsedRealtime();
        i.k(i.this).av(10L, 10L);
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
    
    public abstract void h(long paramLong, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.i
 * JD-Core Version:    0.7.0.1
 */