package com.tencent.mm.av;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class i
  implements com.tencent.mm.ak.g, com.tencent.mm.ak.h
{
  private static Set<Integer> hIa;
  private Queue<e> cWW;
  private boolean cXa;
  int cXb;
  private long cXc;
  f.a cXf;
  private au cXg;
  private LinkedList<l> hIb;
  public a hIc;
  private boolean hId;
  public l.a hIe;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(150665);
    hIa = new HashSet();
    AppMethodBeat.o(150665);
  }
  
  public i()
  {
    AppMethodBeat.i(150654);
    this.hIb = new LinkedList();
    this.hIc = null;
    this.hId = false;
    this.hIe = new l.a()
    {
      public final void aFh()
      {
        AppMethodBeat.i(150643);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150642);
            ac.i("MicroMsg.ImgService", "on image upload end. queue size : " + i.a(i.this).size());
            i.a(i.this, false);
            if (i.a(i.this).size() > 0)
            {
              l locall = (l)i.a(i.this).poll();
              if (locall != null)
              {
                ac.i("MicroMsg.ImgService", "upload image scene hashcode : " + locall.hashCode());
                com.tencent.mm.kernel.g.agQ().ghe.a(locall, 0);
                i.a(i.this, true);
                AppMethodBeat.o(150642);
                return;
              }
              ac.w("MicroMsg.ImgService", "poll image scene is null");
            }
            AppMethodBeat.o(150642);
          }
        });
        AppMethodBeat.o(150643);
      }
    };
    this.cWW = new LinkedList();
    this.running = false;
    this.cXb = 0;
    this.cXc = 0L;
    this.cXa = false;
    this.cXf = new f.a();
    com.tencent.mm.kernel.g.agS();
    this.cXg = new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
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
            ac.e("MicroMsg.ImgService", "exception:%s", new Object[] { bs.m(localException) });
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
    if (com.tencent.mm.kernel.g.agQ().ghe != null) {
      com.tencent.mm.kernel.g.agQ().ghe.a(110, this);
    }
    this.hIb.clear();
    this.hId = false;
    AppMethodBeat.o(150654);
  }
  
  private void Ou()
  {
    AppMethodBeat.i(150660);
    this.cWW.clear();
    this.running = false;
    ac.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.cXf.YH());
    AppMethodBeat.o(150660);
  }
  
  public static boolean oT(int paramInt)
  {
    AppMethodBeat.i(150652);
    if ((com.tencent.mm.sdk.a.b.eUk()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
      ac.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bs.eWi().toString() });
    }
    boolean bool = hIa.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(150652);
    return bool;
  }
  
  public static boolean oU(int paramInt)
  {
    AppMethodBeat.i(150653);
    if ((com.tencent.mm.sdk.a.b.eUk()) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_PURPLE)) {
      ac.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), bs.eWi().toString() });
    }
    boolean bool = hIa.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(150653);
    return bool;
  }
  
  public static void oV(int paramInt)
  {
    AppMethodBeat.i(150658);
    ac.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    e locale = o.aFx().oR(paramInt);
    if ((locale == null) || (locale.dcd <= 0L))
    {
      AppMethodBeat.o(150658);
      return;
    }
    Object localObject = o.aFx().oS((int)locale.dcd);
    if (localObject != null)
    {
      ((e)localObject).setStatus(-1);
      ((e)localObject).drx = 264;
      o.aFx().a((int)((e)localObject).dcd, (e)localObject);
    }
    for (localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(((e)localObject).hGV); ((dy)localObject).field_msgId != locale.hGV; localObject = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(locale.hGV))
    {
      AppMethodBeat.o(150658);
      return;
      locale.setStatus(-1);
      locale.drx = 264;
      o.aFx().a(paramInt, locale);
    }
    ((bo)localObject).setStatus(5);
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 31L, 1L, true);
    ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().a((int)((dy)localObject).field_msgId, (bo)localObject);
    AppMethodBeat.o(150658);
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(150655);
    if (u.f(paramString3, paramString2, paramBoolean)) {}
    for (int i = 1;; i = 0)
    {
      ac.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      paramString1 = new l(paramString1, paramString2, paramString3, i, this, paramInt, this.hIe);
      a(paramString1);
      long l = paramString1.cZc.field_msgId;
      AppMethodBeat.o(150655);
      return l;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(150662);
    paramn = (l)paramn;
    if ((this.hIc != null) && (paramn != null) && (paramn.cZc != null)) {
      this.hIc.a(paramn.cZc.field_msgId, paramInt1, paramInt2);
    }
    AppMethodBeat.o(150662);
  }
  
  public final void a(final l paraml)
  {
    AppMethodBeat.i(150657);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150644);
        ac.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(i.b(i.this)), Integer.valueOf(paraml.hashCode()) });
        if (i.b(i.this))
        {
          i.a(i.this).offer(paraml);
          AppMethodBeat.o(150644);
          return;
        }
        com.tencent.mm.kernel.g.agQ().ghe.a(paraml, 0);
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
        ac.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.FALSE, Integer.valueOf(i) });
        a(new l(paramString1, paramString2, str, i, this, 0, this.hIe));
        break;
      }
    }
    AppMethodBeat.o(150656);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(150659);
    ac.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala;
    long l;
    if ((paramn instanceof l))
    {
      paramString = (l)paramn;
      if ((this.hIc != null) && (paramString != null) && (paramString.cZc != null))
      {
        locala = this.hIc;
        l = paramString.cZc.field_msgId;
        if (paramString.cZc.field_status == 5) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      locala.j(l, bool);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          int i = (int)((l)paramn).hIm;
          if (i.d(i.this) > 0) {
            i.e(i.this);
          }
          for (;;)
          {
            i.oU(i);
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
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
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
          ac.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + i.h(i.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + i.h(i.this));
        }
        ac.i("MicroMsg.ImgService", "run from run");
        i.i(i.this);
        i.j(i.this);
        i.this.cXf.fJW = SystemClock.elapsedRealtime();
        i.k(i.this).au(10L, 10L);
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
 * Qualified Name:     com.tencent.mm.av.i
 * JD-Core Version:    0.7.0.1
 */