package com.tencent.mm.aw;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.ao.f;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.a;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

public final class b
  implements e.a
{
  int Mh;
  boolean ckY;
  private a hYR;
  Stack<Long> hYS;
  long hYT;
  public int hYU;
  long hYV;
  int hYW;
  boolean hYX;
  long hYY;
  long hYZ;
  int hZa;
  av hZb;
  com.tencent.mm.sdk.b.c hZc;
  com.tencent.mm.sdk.b.c hZd;
  
  public b(Looper paramLooper)
  {
    AppMethodBeat.i(150518);
    this.hYT = 0L;
    this.hYU = 0;
    this.ckY = false;
    this.hYV = 0L;
    this.hYW = 0;
    this.hYX = false;
    this.hYY = 0L;
    this.hYZ = 0L;
    this.hZb = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150512);
        long l1 = TrafficStats.getUidRxBytes(b.this.Mh);
        long l2 = TrafficStats.getUidTxBytes(b.this.Mh);
        long l3 = l1 - b.this.hYY + (l2 - b.this.hYZ);
        ad.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
        if (l3 <= 20480L)
        {
          b.this.hYX = false;
          b.this.start();
        }
        for (;;)
        {
          AppMethodBeat.o(150512);
          return true;
          b.this.hYY = l1;
          b.this.hYZ = l2;
          b.this.hZb.az(1000L, 1000L);
        }
      }
    }, false);
    this.hZc = new com.tencent.mm.sdk.b.c() {};
    this.hZd = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(x arg1)
      {
        AppMethodBeat.i(150514);
        b.this.hZa = ???.dkF.mode;
        ad.d("MicroMsg.AutoGetBigImgLogic", "mode = " + b.this.hZa);
        com.tencent.mm.modelcontrol.c.aGN();
        if (!com.tencent.mm.modelcontrol.c.aGO()) {}
        synchronized (b.this.hYS)
        {
          b.this.hYS.clear();
          AppMethodBeat.o(150514);
          return false;
        }
      }
    };
    this.hYR = new a(this, paramLooper);
    this.hYS = new Stack();
    this.Mh = Process.myUid();
    paramLooper = (Integer)com.tencent.mm.kernel.g.ajC().ajl().get(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.hZa = i;
      com.tencent.mm.sdk.b.a.IbL.c(this.hZc);
      com.tencent.mm.sdk.b.a.IbL.c(this.hZd);
      AppMethodBeat.o(150518);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(150522);
    ad.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(150522);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(150521);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ad.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
    }
    for (;;)
    {
      this.hYT = 0L;
      com.tencent.mm.modelcontrol.c.aGN();
      if (!com.tencent.mm.modelcontrol.c.aGO())
      {
        ad.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.hYS)
        {
          this.hYS.clear();
          AppMethodBeat.o(150521);
          return;
          if (ay.isWifi(aj.getContext()))
          {
            ad.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
          }
          else
          {
            long l1 = bt.a((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irk, null), 0L);
            long l2 = bt.aRf((String)DateFormat.format("M", System.currentTimeMillis()));
            ad.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irk, Long.valueOf(l1 + 1L));
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irl, Long.valueOf(l2));
          }
        }
      }
    }
    this.hYY = TrafficStats.getUidRxBytes(this.Mh);
    this.hYZ = TrafficStats.getUidTxBytes(this.Mh);
    this.hZb.az(1000L, 1000L);
    AppMethodBeat.o(150521);
  }
  
  public final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(150520);
    ad.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(paramBoolean)));
    this.ckY = paramBoolean;
    this.hYV = System.currentTimeMillis();
    AppMethodBeat.o(150520);
  }
  
  public final void start()
  {
    AppMethodBeat.i(150519);
    this.hYR.sendEmptyMessage(1);
    AppMethodBeat.o(150519);
  }
  
  static final class a
    extends ap
  {
    private WeakReference<b> hZf;
    
    public a(b paramb, Looper paramLooper)
    {
      super();
      AppMethodBeat.i(150516);
      this.hZf = new WeakReference(paramb);
      AppMethodBeat.o(150516);
    }
    
    public final void handleMessage(Message arg1)
    {
      AppMethodBeat.i(150517);
      b localb = (b)this.hZf.get();
      if ((localb != null) && (1 == ???.what))
      {
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwM, false);
        ??? = new yb();
        ???.dMo.dsi = 2;
        com.tencent.mm.sdk.b.a.IbL.l(???);
        if (((!???.dMp.dMq) && (!com.tencent.mm.s.a.adC())) || (!bool))
        {
          if ((!localb.ckY) && (System.currentTimeMillis() - localb.hYV > 1200000L))
          {
            ad.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            AppMethodBeat.o(150517);
            return;
          }
          if ((localb.hYT != 0L) || (localb.hYS.size() <= 0) || (localb.hYW != 0) || (localb.hYX))
          {
            ad.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.hYT + " size: " + localb.hYS.size() + " cnt: " + localb.hYW + " pauseOnMonitor: " + localb.hYX);
            AppMethodBeat.o(150517);
            return;
          }
          g localg;
          synchronized (localb.hYS)
          {
            localb.hYT = ((Long)localb.hYS.pop()).longValue();
            ??? = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().xY(localb.hYT);
            localg = q.aIF().F(???.field_talker, ???.field_msgSvrId);
            if (localg.fkv == 1)
            {
              ad.i("MicroMsg.AutoGetBigImgLogic", localb.hYT + " already has hd thumb");
              localb.hYT = 0L;
              localb.start();
              AppMethodBeat.o(150517);
              return;
            }
          }
          ad.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.hYT + "  image_" + ???.field_msgId);
          f.aGI().hTO.add("image_" + ???.field_msgId);
          q.aIG().a(localg.dnz, ???.field_msgId, 0, Long.valueOf(locala.hYT), locala.hYU, locala);
        }
      }
      AppMethodBeat.o(150517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.b
 * JD-Core Version:    0.7.0.1
 */