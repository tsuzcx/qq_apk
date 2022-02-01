package com.tencent.mm.aw;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.w;
import com.tencent.mm.g.a.w.a;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

public final class b
  implements d.a
{
  int Jw;
  boolean cdK;
  private a hfH;
  Stack<Long> hfI;
  long hfJ;
  public int hfK;
  long hfL;
  int hfM;
  boolean hfN;
  long hfO;
  long hfP;
  int hfQ;
  av hfR;
  com.tencent.mm.sdk.b.c hfS;
  com.tencent.mm.sdk.b.c hfT;
  
  public b(Looper paramLooper)
  {
    AppMethodBeat.i(150518);
    this.hfJ = 0L;
    this.hfK = 0;
    this.cdK = false;
    this.hfL = 0L;
    this.hfM = 0;
    this.hfN = false;
    this.hfO = 0L;
    this.hfP = 0L;
    this.hfR = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150512);
        long l1 = TrafficStats.getUidRxBytes(b.this.Jw);
        long l2 = TrafficStats.getUidTxBytes(b.this.Jw);
        long l3 = l1 - b.this.hfO + (l2 - b.this.hfP);
        ad.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
        if (l3 <= 20480L)
        {
          b.this.hfN = false;
          b.this.start();
        }
        for (;;)
        {
          AppMethodBeat.o(150512);
          return true;
          b.this.hfO = l1;
          b.this.hfP = l2;
          b.this.hfR.av(1000L, 1000L);
        }
      }
    }, false);
    this.hfS = new com.tencent.mm.sdk.b.c() {};
    this.hfT = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(w arg1)
      {
        AppMethodBeat.i(150514);
        b.this.hfQ = ???.dbO.mode;
        ad.d("MicroMsg.AutoGetBigImgLogic", "mode = " + b.this.hfQ);
        com.tencent.mm.modelcontrol.c.awQ();
        if (!com.tencent.mm.modelcontrol.c.awR()) {}
        synchronized (b.this.hfI)
        {
          b.this.hfI.clear();
          AppMethodBeat.o(150514);
          return false;
        }
      }
    };
    this.hfH = new a(this, paramLooper);
    this.hfI = new Stack();
    this.Jw = Process.myUid();
    paramLooper = (Integer)com.tencent.mm.kernel.g.afB().afk().get(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.hfQ = i;
      com.tencent.mm.sdk.b.a.ESL.c(this.hfS);
      com.tencent.mm.sdk.b.a.ESL.c(this.hfT);
      AppMethodBeat.o(150518);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(150522);
    ad.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).d(paramLong2, false, true);
    AppMethodBeat.o(150522);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(150521);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ad.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).d(paramLong2, false, false);
    }
    for (;;)
    {
      this.hfJ = 0L;
      com.tencent.mm.modelcontrol.c.awQ();
      if (!com.tencent.mm.modelcontrol.c.awR())
      {
        ad.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.hfI)
        {
          this.hfI.clear();
          AppMethodBeat.o(150521);
          return;
          if (ay.isWifi(aj.getContext()))
          {
            ad.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).d(paramLong2, true, false);
          }
          else
          {
            long l1 = bt.a((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhd, null), 0L);
            long l2 = bt.aGi((String)DateFormat.format("M", System.currentTimeMillis()));
            ad.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhd, Long.valueOf(l1 + 1L));
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fhe, Long.valueOf(l2));
          }
        }
      }
    }
    this.hfO = TrafficStats.getUidRxBytes(this.Jw);
    this.hfP = TrafficStats.getUidTxBytes(this.Jw);
    this.hfR.av(1000L, 1000L);
    AppMethodBeat.o(150521);
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(150520);
    ad.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(paramBoolean)));
    this.cdK = paramBoolean;
    this.hfL = System.currentTimeMillis();
    AppMethodBeat.o(150520);
  }
  
  public final void start()
  {
    AppMethodBeat.i(150519);
    this.hfH.sendEmptyMessage(1);
    AppMethodBeat.o(150519);
  }
  
  static final class a
    extends ap
  {
    private WeakReference<b> hfV;
    
    public a(b paramb, Looper paramLooper)
    {
      super();
      AppMethodBeat.i(150516);
      this.hfV = new WeakReference(paramb);
      AppMethodBeat.o(150516);
    }
    
    public final void handleMessage(Message arg1)
    {
      AppMethodBeat.i(150517);
      b localb = (b)this.hfV.get();
      if ((localb != null) && (1 == ???.what))
      {
        boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.poH, false);
        ??? = new ww();
        ???.dCp.djq = 2;
        com.tencent.mm.sdk.b.a.ESL.l(???);
        if (((!???.dCq.dCr) && (!com.tencent.mm.r.a.aad())) || (!bool))
        {
          if ((!localb.cdK) && (System.currentTimeMillis() - localb.hfL > 1200000L))
          {
            ad.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            AppMethodBeat.o(150517);
            return;
          }
          if ((localb.hfJ != 0L) || (localb.hfI.size() <= 0) || (localb.hfM != 0) || (localb.hfN))
          {
            ad.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.hfJ + " size: " + localb.hfI.size() + " cnt: " + localb.hfM + " pauseOnMonitor: " + localb.hfN);
            AppMethodBeat.o(150517);
            return;
          }
          e locale;
          synchronized (localb.hfI)
          {
            localb.hfJ = ((Long)localb.hfI.pop()).longValue();
            ??? = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().rm(localb.hfJ);
            locale = o.ayF().mr(???.field_msgSvrId);
            if (locale.eOY == 1)
            {
              ad.i("MicroMsg.AutoGetBigImgLogic", localb.hfJ + " already has hd thumb");
              localb.hfJ = 0L;
              localb.start();
              AppMethodBeat.o(150517);
              return;
            }
          }
          ad.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.hfJ + "  image_" + ???.field_msgId);
          f.awL().haO.add("image_" + ???.field_msgId);
          o.ayG().a(locale.deI, ???.field_msgId, 0, Long.valueOf(locala.hfJ), locala.hfK, locala);
        }
      }
      AppMethodBeat.o(150517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.b
 * JD-Core Version:    0.7.0.1
 */