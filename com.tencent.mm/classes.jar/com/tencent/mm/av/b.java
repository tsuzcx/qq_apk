package com.tencent.mm.av;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

public final class b
  implements e.a
{
  int Mh;
  boolean cla;
  private a ibJ;
  Stack<Long> ibK;
  long ibL;
  public int ibM;
  long ibN;
  int ibO;
  boolean ibP;
  long ibQ;
  long ibR;
  int ibS;
  aw ibT;
  com.tencent.mm.sdk.b.c ibU;
  com.tencent.mm.sdk.b.c ibV;
  
  public b(Looper paramLooper)
  {
    AppMethodBeat.i(150518);
    this.ibL = 0L;
    this.ibM = 0;
    this.cla = false;
    this.ibN = 0L;
    this.ibO = 0;
    this.ibP = false;
    this.ibQ = 0L;
    this.ibR = 0L;
    this.ibT = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150512);
        long l1 = TrafficStats.getUidRxBytes(b.this.Mh);
        long l2 = TrafficStats.getUidTxBytes(b.this.Mh);
        long l3 = l1 - b.this.ibQ + (l2 - b.this.ibR);
        ae.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
        if (l3 <= 20480L)
        {
          b.this.ibP = false;
          b.this.start();
        }
        for (;;)
        {
          AppMethodBeat.o(150512);
          return true;
          b.this.ibQ = l1;
          b.this.ibR = l2;
          b.this.ibT.ay(1000L, 1000L);
        }
      }
    }, false);
    this.ibU = new com.tencent.mm.sdk.b.c() {};
    this.ibV = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(x arg1)
      {
        AppMethodBeat.i(150514);
        b.this.ibS = ???.dlH.mode;
        ae.d("MicroMsg.AutoGetBigImgLogic", "mode = " + b.this.ibS);
        com.tencent.mm.modelcontrol.c.aHe();
        if (!com.tencent.mm.modelcontrol.c.aHf()) {}
        synchronized (b.this.ibK)
        {
          b.this.ibK.clear();
          AppMethodBeat.o(150514);
          return false;
        }
      }
    };
    this.ibJ = new a(this, paramLooper);
    this.ibK = new Stack();
    this.Mh = Process.myUid();
    paramLooper = (Integer)com.tencent.mm.kernel.g.ajR().ajA().get(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.ibS = i;
      com.tencent.mm.sdk.b.a.IvT.c(this.ibU);
      com.tencent.mm.sdk.b.a.IvT.c(this.ibV);
      AppMethodBeat.o(150518);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(150522);
    ae.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(150522);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(150521);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ae.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
    }
    for (;;)
    {
      this.ibL = 0L;
      com.tencent.mm.modelcontrol.c.aHe();
      if (!com.tencent.mm.modelcontrol.c.aHf())
      {
        ae.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.ibK)
        {
          this.ibK.clear();
          AppMethodBeat.o(150521);
          return;
          if (az.isWifi(ak.getContext()))
          {
            ae.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
          }
          else
          {
            long l1 = bu.a((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILG, null), 0L);
            long l2 = bu.aSC((String)DateFormat.format("M", System.currentTimeMillis()));
            ae.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILG, Long.valueOf(l1 + 1L));
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILH, Long.valueOf(l2));
          }
        }
      }
    }
    this.ibQ = TrafficStats.getUidRxBytes(this.Mh);
    this.ibR = TrafficStats.getUidTxBytes(this.Mh);
    this.ibT.ay(1000L, 1000L);
    AppMethodBeat.o(150521);
  }
  
  public final void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(150520);
    ae.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(paramBoolean)));
    this.cla = paramBoolean;
    this.ibN = System.currentTimeMillis();
    AppMethodBeat.o(150520);
  }
  
  public final void start()
  {
    AppMethodBeat.i(150519);
    this.ibJ.sendEmptyMessage(1);
    AppMethodBeat.o(150519);
  }
  
  static final class a
    extends aq
  {
    private WeakReference<b> ibX;
    
    public a(b paramb, Looper paramLooper)
    {
      super();
      AppMethodBeat.i(150516);
      this.ibX = new WeakReference(paramb);
      AppMethodBeat.o(150516);
    }
    
    public final void handleMessage(Message arg1)
    {
      AppMethodBeat.i(150517);
      b localb = (b)this.ibX.get();
      if ((localb != null) && (1 == ???.what))
      {
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qDM, false);
        ??? = new yh();
        ???.dNE.dto = 2;
        com.tencent.mm.sdk.b.a.IvT.l(???);
        if (((!???.dNF.dNG) && (!com.tencent.mm.r.a.adO())) || (!bool))
        {
          if ((!localb.cla) && (System.currentTimeMillis() - localb.ibN > 1200000L))
          {
            ae.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            AppMethodBeat.o(150517);
            return;
          }
          if ((localb.ibL != 0L) || (localb.ibK.size() <= 0) || (localb.ibO != 0) || (localb.ibP))
          {
            ae.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.ibL + " size: " + localb.ibK.size() + " cnt: " + localb.ibO + " pauseOnMonitor: " + localb.ibP);
            AppMethodBeat.o(150517);
            return;
          }
          g localg;
          synchronized (localb.ibK)
          {
            localb.ibL = ((Long)localb.ibK.pop()).longValue();
            ??? = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localb.ibL);
            localg = q.aIX().F(???.field_talker, ???.field_msgSvrId);
            if (localg.fms == 1)
            {
              ae.i("MicroMsg.AutoGetBigImgLogic", localb.ibL + " already has hd thumb");
              localb.ibL = 0L;
              localb.start();
              AppMethodBeat.o(150517);
              return;
            }
          }
          ae.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.ibL + "  image_" + ???.field_msgId);
          f.aGZ().hWG.add("image_" + ???.field_msgId);
          q.aIY().a(localg.doE, ???.field_msgId, 0, Long.valueOf(locala.ibL), locala.ibM, locala);
        }
      }
      AppMethodBeat.o(150517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.b
 * JD-Core Version:    0.7.0.1
 */