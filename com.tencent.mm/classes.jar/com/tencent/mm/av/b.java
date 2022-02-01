package com.tencent.mm.av;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.oe;
import com.tencent.mm.g.a.x;
import com.tencent.mm.g.a.x.a;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

public final class b
  implements d.a
{
  int Kr;
  boolean caH;
  private a hGk;
  Stack<Long> hGl;
  long hGm;
  public int hGn;
  long hGo;
  int hGp;
  boolean hGq;
  long hGr;
  long hGs;
  int hGt;
  au hGu;
  com.tencent.mm.sdk.b.c hGv;
  com.tencent.mm.sdk.b.c hGw;
  
  public b(Looper paramLooper)
  {
    AppMethodBeat.i(150518);
    this.hGm = 0L;
    this.hGn = 0;
    this.caH = false;
    this.hGo = 0L;
    this.hGp = 0;
    this.hGq = false;
    this.hGr = 0L;
    this.hGs = 0L;
    this.hGu = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150512);
        long l1 = TrafficStats.getUidRxBytes(b.this.Kr);
        long l2 = TrafficStats.getUidTxBytes(b.this.Kr);
        long l3 = l1 - b.this.hGr + (l2 - b.this.hGs);
        ac.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
        if (l3 <= 20480L)
        {
          b.this.hGq = false;
          b.this.start();
        }
        for (;;)
        {
          AppMethodBeat.o(150512);
          return true;
          b.this.hGr = l1;
          b.this.hGs = l2;
          b.this.hGu.au(1000L, 1000L);
        }
      }
    }, false);
    this.hGv = new com.tencent.mm.sdk.b.c() {};
    this.hGw = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(x arg1)
      {
        AppMethodBeat.i(150514);
        b.this.hGt = ???.cZn.mode;
        ac.d("MicroMsg.AutoGetBigImgLogic", "mode = " + b.this.hGt);
        com.tencent.mm.modelcontrol.c.aDI();
        if (!com.tencent.mm.modelcontrol.c.aDJ()) {}
        synchronized (b.this.hGl)
        {
          b.this.hGl.clear();
          AppMethodBeat.o(150514);
          return false;
        }
      }
    };
    this.hGk = new a(this, paramLooper);
    this.hGl = new Stack();
    this.Kr = Process.myUid();
    paramLooper = (Integer)com.tencent.mm.kernel.g.agR().agA().get(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.hGt = i;
      com.tencent.mm.sdk.b.a.GpY.c(this.hGv);
      com.tencent.mm.sdk.b.a.GpY.c(this.hGw);
      AppMethodBeat.o(150518);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(150522);
    ac.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(150522);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(150521);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ac.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
    }
    for (;;)
    {
      this.hGm = 0L;
      com.tencent.mm.modelcontrol.c.aDI();
      if (!com.tencent.mm.modelcontrol.c.aDJ())
      {
        ac.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.hGl)
        {
          this.hGl.clear();
          AppMethodBeat.o(150521);
          return;
          if (ax.isWifi(ai.getContext()))
          {
            ac.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
          }
          else
          {
            long l1 = bs.a((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GER, null), 0L);
            long l2 = bs.aLz((String)DateFormat.format("M", System.currentTimeMillis()));
            ac.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GER, Long.valueOf(l1 + 1L));
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GES, Long.valueOf(l2));
          }
        }
      }
    }
    this.hGr = TrafficStats.getUidRxBytes(this.Kr);
    this.hGs = TrafficStats.getUidTxBytes(this.Kr);
    this.hGu.au(1000L, 1000L);
    AppMethodBeat.o(150521);
  }
  
  public final void eC(boolean paramBoolean)
  {
    AppMethodBeat.i(150520);
    ac.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(paramBoolean)));
    this.caH = paramBoolean;
    this.hGo = System.currentTimeMillis();
    AppMethodBeat.o(150520);
  }
  
  public final void start()
  {
    AppMethodBeat.i(150519);
    this.hGk.sendEmptyMessage(1);
    AppMethodBeat.o(150519);
  }
  
  static final class a
    extends ao
  {
    private WeakReference<b> hGy;
    
    public a(b paramb, Looper paramLooper)
    {
      super();
      AppMethodBeat.i(150516);
      this.hGy = new WeakReference(paramb);
      AppMethodBeat.o(150516);
    }
    
    public final void handleMessage(Message arg1)
    {
      AppMethodBeat.i(150517);
      b localb = (b)this.hGy.get();
      if ((localb != null) && (1 == ???.what))
      {
        boolean bool = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pSo, false);
        ??? = new xh();
        ???.dAb.dgL = 2;
        com.tencent.mm.sdk.b.a.GpY.l(???);
        if (((!???.dAc.dAd) && (!com.tencent.mm.r.a.aaZ())) || (!bool))
        {
          if ((!localb.caH) && (System.currentTimeMillis() - localb.hGo > 1200000L))
          {
            ac.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            AppMethodBeat.o(150517);
            return;
          }
          if ((localb.hGm != 0L) || (localb.hGl.size() <= 0) || (localb.hGp != 0) || (localb.hGq))
          {
            ac.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.hGm + " size: " + localb.hGl.size() + " cnt: " + localb.hGp + " pauseOnMonitor: " + localb.hGq);
            AppMethodBeat.o(150517);
            return;
          }
          e locale;
          synchronized (localb.hGl)
          {
            localb.hGm = ((Long)localb.hGl.pop()).longValue();
            ??? = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(localb.hGm);
            locale = o.aFx().qf(???.field_msgSvrId);
            if (locale.eSg == 1)
            {
              ac.i("MicroMsg.AutoGetBigImgLogic", localb.hGm + " already has hd thumb");
              localb.hGm = 0L;
              localb.start();
              AppMethodBeat.o(150517);
              return;
            }
          }
          ac.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.hGm + "  image_" + ???.field_msgId);
          f.aDD().hBp.add("image_" + ???.field_msgId);
          o.aFy().a(locale.dcd, ???.field_msgId, 0, Long.valueOf(locala.hGm), locala.hGn, locala);
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