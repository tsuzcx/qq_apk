package com.tencent.mm.ay;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.j;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class k
  implements com.tencent.mm.an.i, j
{
  private static Set<Integer> lOX;
  private Queue<g> ftp;
  private boolean ftt;
  int ftu;
  private long ftv;
  f.a ftx;
  private MTimerHandler fty;
  private LinkedList<n> lOY;
  public a lOZ;
  private boolean lPa;
  public com.tencent.mm.an.n lPb;
  private boolean running;
  
  static
  {
    AppMethodBeat.i(150665);
    lOX = new HashSet();
    AppMethodBeat.o(150665);
  }
  
  public k()
  {
    AppMethodBeat.i(150654);
    this.lOY = new LinkedList();
    this.lOZ = null;
    this.lPa = false;
    this.lPb = new com.tencent.mm.an.n()
    {
      public final void bid()
      {
        AppMethodBeat.i(150643);
        h.aHH();
        h.aHJ().postToWorker(new Runnable()
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
                h.aHF().kcd.a(localn, 0);
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
    this.ftp = new LinkedList();
    this.running = false;
    this.ftu = 0;
    this.ftv = 0L;
    this.ftt = false;
    this.ftx = new f.a();
    h.aHH();
    this.fty = new MTimerHandler(h.aHJ().getLooper(), new MTimerHandler.CallBack()
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
    if (h.aHF().kcd != null) {
      h.aHF().kcd.a(110, this);
    }
    this.lOY.clear();
    this.lPa = false;
    AppMethodBeat.o(150654);
  }
  
  private void afk()
  {
    AppMethodBeat.i(150660);
    this.ftp.clear();
    this.running = false;
    Log.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.ftx.avE());
    AppMethodBeat.o(150660);
  }
  
  public static boolean wn(int paramInt)
  {
    AppMethodBeat.i(150652);
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      Log.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    }
    boolean bool = lOX.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(150652);
    return bool;
  }
  
  public static boolean wo(int paramInt)
  {
    AppMethodBeat.i(150653);
    if ((CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      Log.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", new Object[] { Integer.valueOf(paramInt), Util.getStack().toString() });
    }
    boolean bool = lOX.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(150653);
    return bool;
  }
  
  public static void wp(int paramInt)
  {
    AppMethodBeat.i(150658);
    Log.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    g localg = q.bmh().wl(paramInt);
    if ((localg == null) || (localg.localId <= 0L))
    {
      AppMethodBeat.o(150658);
      return;
    }
    Object localObject = q.bmh().wm((int)localg.localId);
    if (localObject != null)
    {
      ((g)localObject).setStatus(-1);
      ((g)localObject).cUP = 264;
      q.bmh().a((int)((g)localObject).localId, (g)localObject);
    }
    for (localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(((g)localObject).lNP); ((et)localObject).field_msgId != localg.lNP; localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(localg.lNP))
    {
      AppMethodBeat.o(150658);
      return;
      localg.setStatus(-1);
      localg.cUP = 264;
      q.bmh().a(paramInt, localg);
    }
    ((ca)localObject).setStatus(5);
    f.Iyx.idkeyStat(111L, 31L, 1L, true);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a((int)((et)localObject).field_msgId, (ca)localObject);
    AppMethodBeat.o(150658);
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(203448);
    if (z.f(paramString3, paramString2, paramBoolean)) {}
    for (int i = 1;; i = 0)
    {
      Log.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
      o.e locale = o.a(o.d.lUk).wb(3);
      locale.fLi = paramString1;
      locale.toUser = paramString2;
      locale.lPO = paramString3;
      locale.lNK = i;
      locale.lUr = this;
      locale.fJu = paramInt1;
      locale.lUs = this.lPb;
      locale.lUu = true;
      locale.lUt = paramInt2;
      locale.lUq = 10;
      paramString1 = (n)locale.bnl().lUi;
      a(paramString1);
      long l = paramString1.blT().field_msgId;
      AppMethodBeat.o(203448);
      return l;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(150662);
    paramq = (n)paramq;
    if ((this.lOZ != null) && (paramq != null) && (paramq.blT() != null)) {
      this.lOZ.a(paramq.blT().field_msgId, paramInt1, paramInt2);
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
    h.aHH();
    h.aHJ().postToWorker(new Runnable()
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
        h.aHF().kcd.a(paramn, 0);
        k.a(k.this, true);
        AppMethodBeat.o(150644);
      }
    });
    AppMethodBeat.o(150657);
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(203452);
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (z.f(str, paramString2, false)) {}
      for (int i = 1;; i = 0)
      {
        Log.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.FALSE, Integer.valueOf(i) });
        o.e locale = o.a(o.d.lUk).wb(3);
        locale.fLi = paramString1;
        locale.toUser = paramString2;
        locale.lPO = str;
        locale.lNK = i;
        locale.lUr = this;
        locale.fJu = 0;
        locale.lUs = this.lPb;
        locale.lUu = true;
        locale.lUt = paramInt;
        locale.lUq = 10;
        a((n)locale.bnl().lUi);
        break;
      }
    }
    AppMethodBeat.o(203452);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(150659);
    Log.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a locala;
    long l;
    if ((paramq instanceof n))
    {
      paramString = (n)paramq;
      if ((this.lOZ != null) && (paramString != null) && (paramString.blT() != null))
      {
        locala = this.lOZ;
        l = paramString.blT().field_msgId;
        if (paramString.blT().field_status == 5) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      locala.j(l, bool);
      h.aHH();
      h.aHJ().postToWorker(new Runnable()
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
          int i = (int)((n)paramq).lPj;
          if (k.d(k.this) > 0) {
            k.e(k.this);
          }
          for (;;)
          {
            k.wo(i);
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
    h.aHH();
    h.aHJ().postToWorker(new Runnable()
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
        k.this.ftx.jvB = SystemClock.elapsedRealtime();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.k
 * JD-Core Version:    0.7.0.1
 */