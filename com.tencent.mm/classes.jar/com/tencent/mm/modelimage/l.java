package com.tencent.mm.modelimage;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.m;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class l
  implements com.tencent.mm.am.h, com.tencent.mm.am.i
{
  private static Set<Integer> oHH;
  private Queue<h> hxE;
  private boolean hxI;
  int hxJ;
  private long hxK;
  f.a hxM;
  private MTimerHandler hxN;
  private LinkedList<o> oHI;
  public a oHJ;
  private boolean oHK;
  public m oHL;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(150665);
    oHH = new HashSet();
    AppMethodBeat.o(150665);
  }
  
  public l()
  {
    AppMethodBeat.i(150654);
    this.oHI = new LinkedList();
    this.oHJ = null;
    this.oHK = false;
    this.oHL = new m()
    {
      public final void bFL()
      {
        AppMethodBeat.i(150643);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150642);
            Log.i("MicroMsg.ImgService", "on image upload end. queue size : " + l.a(l.this).size());
            l.a(l.this, false);
            if (l.a(l.this).size() > 0)
            {
              o localo = (o)l.a(l.this).poll();
              if (localo != null)
              {
                Log.i("MicroMsg.ImgService", "upload image scene hashcode : " + localo.hashCode());
                com.tencent.mm.kernel.h.baD().mCm.a(localo, 0);
                l.a(l.this, true);
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
    this.hxE = new LinkedList();
    this.running = false;
    this.hxJ = 0;
    this.hxK = 0L;
    this.hxI = false;
    this.hxM = new f.a();
    com.tencent.mm.kernel.h.baF();
    this.hxN = new MTimerHandler(com.tencent.mm.kernel.h.baH().getLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150649);
        try
        {
          l.e(l.this);
          AppMethodBeat.o(150649);
          return false;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.ImgService", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
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
    if (com.tencent.mm.kernel.h.baD().mCm != null) {
      com.tencent.mm.kernel.h.baD().mCm.a(110, this);
    }
    this.oHI.clear();
    this.oHK = false;
    AppMethodBeat.o(150654);
  }
  
  private void aHh()
  {
    AppMethodBeat.i(150660);
    this.hxE.clear();
    this.running = false;
    Log.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.hxM.aPY());
    AppMethodBeat.o(150660);
  }
  
  public static boolean ws(int paramInt)
  {
    AppMethodBeat.i(150652);
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      Log.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    }
    boolean bool = oHH.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(150652);
    return bool;
  }
  
  public static boolean wt(int paramInt)
  {
    AppMethodBeat.i(150653);
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      Log.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    }
    boolean bool = oHH.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(150653);
    return bool;
  }
  
  public static void wu(int paramInt)
  {
    AppMethodBeat.i(150658);
    Log.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    h localh = r.bKa().wq(paramInt);
    if ((localh == null) || (localh.localId <= 0L))
    {
      AppMethodBeat.o(150658);
      return;
    }
    Object localObject = r.bKa().wr((int)localh.localId);
    if (localObject != null)
    {
      ((h)localObject).setStatus(-1);
      ((h)localObject).eQp = 264;
      r.bKa().a((int)((h)localObject).localId, (h)localObject);
    }
    for (localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((h)localObject).oGz); (localObject == null) || (((fi)localObject).field_msgId != localh.oGz); localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localh.oGz))
    {
      AppMethodBeat.o(150658);
      return;
      localh.setStatus(-1);
      localh.eQp = 264;
      r.bKa().a(paramInt, localh);
    }
    ((cc)localObject).setStatus(5);
    f.Ozc.idkeyStat(111L, 31L, 1L, true);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a((int)((fi)localObject).field_msgId, (cc)localObject);
    AppMethodBeat.o(150658);
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(239008);
    if (z.h(paramString3, paramString2, paramBoolean)) {}
    for (int i = 1;; i = 0)
    {
      Log.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      t.e locale = t.a(t.d.oNd).wg(3);
      locale.hQQ = paramString1;
      locale.toUser = paramString2;
      locale.oIx = paramString3;
      locale.oGu = i;
      locale.oNk = this;
      locale.hOX = paramInt1;
      locale.oNl = this.oHL;
      locale.oNn = true;
      locale.oNm = paramInt2;
      locale.oNj = 10;
      paramString1 = (o)locale.bKW().oNb;
      a(paramString1);
      long l = paramString1.bJM().field_msgId;
      AppMethodBeat.o(239008);
      return l;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(150662);
    paramp = (o)paramp;
    if ((this.oHJ != null) && (paramp != null) && (paramp.bJM() != null)) {
      this.oHJ.c(paramp.bJM().field_msgId, paramInt1, paramInt2);
    }
    AppMethodBeat.o(150662);
  }
  
  public final void a(final o paramo)
  {
    AppMethodBeat.i(150657);
    if (paramo == null)
    {
      AppMethodBeat.o(150657);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150644);
        Log.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", new Object[] { Boolean.valueOf(l.b(l.this)), Integer.valueOf(paramo.hashCode()) });
        if (l.b(l.this))
        {
          l.a(l.this).offer(paramo);
          AppMethodBeat.o(150644);
          return;
        }
        com.tencent.mm.kernel.h.baD().mCm.a(paramo, 0);
        l.a(l.this, true);
        AppMethodBeat.o(150644);
      }
    });
    AppMethodBeat.o(150657);
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(239011);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (z.h(str, paramString2, false)) {}
      for (int i = 1;; i = 0)
      {
        Log.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.FALSE, Integer.valueOf(i) });
        t.e locale = t.a(t.d.oNd).wg(3);
        locale.hQQ = paramString1;
        locale.toUser = paramString2;
        locale.oIx = str;
        locale.oGu = i;
        locale.oNk = this;
        locale.hOX = 0;
        locale.oNl = this.oHL;
        locale.oNn = true;
        locale.oNm = paramInt;
        locale.oNj = 10;
        a((o)locale.bKW().oNb);
        break;
      }
    }
    AppMethodBeat.o(239011);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(150659);
    Log.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala;
    long l;
    if ((paramp instanceof o))
    {
      paramString = (o)paramp;
      if ((this.oHJ != null) && (paramString != null) && (paramString.bJM() != null))
      {
        locala = this.oHJ;
        l = paramString.bJM().field_msgId;
        if (paramString.bJM().field_status == 5) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      locala.p(l, bool);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(150645);
          if (paramp.getType() != 110)
          {
            AppMethodBeat.o(150645);
            return;
          }
          if (!(paramp instanceof o))
          {
            AppMethodBeat.o(150645);
            return;
          }
          l.c(l.this);
          int i = (int)((o)paramp).oHT;
          if (l.d(l.this) > 0) {
            l.e(l.this);
          }
          for (;;)
          {
            l.wt(i);
            AppMethodBeat.o(150645);
            return;
            l.f(l.this);
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150647);
        long l = System.currentTimeMillis() - l.g(l.this);
        if (l.h(l.this))
        {
          if (l < 60000L)
          {
            AppMethodBeat.o(150647);
            return;
          }
          Log.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + l.h(l.this) + " timeWait:" + l + ">=MAX_TIME_WAIT sending:" + l.h(l.this));
        }
        Log.i("MicroMsg.ImgService", "run from run");
        l.i(l.this);
        l.j(l.this);
        l.this.hxM.lYS = SystemClock.elapsedRealtime();
        l.k(l.this).startTimer(10L);
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
    public abstract void c(long paramLong, int paramInt1, int paramInt2);
    
    public abstract void p(long paramLong, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.l
 * JD-Core Version:    0.7.0.1
 */