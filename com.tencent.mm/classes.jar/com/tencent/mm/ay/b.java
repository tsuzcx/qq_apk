package com.tencent.mm.ay;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aa;
import com.tencent.mm.f.a.aa.a;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.f.a.qe;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

public final class b
  implements e.a
{
  int acx;
  boolean cvA;
  private a lNc;
  Stack<Long> lNd;
  long lNe;
  public int lNf;
  long lNg;
  int lNh;
  boolean lNi;
  long lNj;
  long lNk;
  int lNl;
  MTimerHandler lNm;
  IListener lNn;
  IListener lNo;
  
  public b(Looper paramLooper)
  {
    AppMethodBeat.i(150518);
    this.lNe = 0L;
    this.lNf = 0;
    this.cvA = false;
    this.lNg = 0L;
    this.lNh = 0;
    this.lNi = false;
    this.lNj = 0L;
    this.lNk = 0L;
    this.lNm = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150512);
        long l1 = TrafficStats.getUidRxBytes(b.this.acx);
        long l2 = TrafficStats.getUidTxBytes(b.this.acx);
        long l3 = l1 - b.this.lNj + (l2 - b.this.lNk);
        Log.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
        if (l3 <= 20480L)
        {
          b.this.lNi = false;
          b.this.start();
        }
        for (;;)
        {
          AppMethodBeat.o(150512);
          return true;
          b.this.lNj = l1;
          b.this.lNk = l2;
          b.this.lNm.startTimer(1000L);
        }
      }
    }, false);
    this.lNn = new IListener() {};
    this.lNo = new IListener()
    {
      private boolean a(aa arg1)
      {
        AppMethodBeat.i(150514);
        b.this.lNl = ???.fvD.mode;
        Log.d("MicroMsg.AutoGetBigImgLogic", "mode = " + b.this.lNl);
        d.bkm();
        if (!d.bkn()) {}
        synchronized (b.this.lNd)
        {
          b.this.lNd.clear();
          AppMethodBeat.o(150514);
          return false;
        }
      }
    };
    this.lNc = new a(this, paramLooper);
    this.lNd = new Stack();
    this.acx = Process.myUid();
    paramLooper = (Integer)h.aHG().aHp().b(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.lNl = i;
      EventCenter.instance.addListener(this.lNn);
      EventCenter.instance.addListener(this.lNo);
      AppMethodBeat.o(150518);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(150522);
    Log.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(150522);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.an.q paramq) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(150521);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      Log.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
    }
    for (;;)
    {
      this.lNe = 0L;
      d.bkm();
      if (!d.bkn()) {
        Log.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
      }
      synchronized (this.lNd)
      {
        this.lNd.clear();
        AppMethodBeat.o(150521);
        return;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          Log.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
          ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
        }
        else
        {
          long l1 = Util.nullAs((Long)h.aHG().aHp().get(ar.a.VhI, null), 0L);
          long l2 = Util.safeParseLong((String)DateFormat.format("M", System.currentTimeMillis()));
          Log.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
          h.aHG().aHp().set(ar.a.VhI, Long.valueOf(l1 + 1L));
          h.aHG().aHp().set(ar.a.VhJ, Long.valueOf(l2));
        }
      }
    }
    this.lNm.startTimer(1000L);
    AppMethodBeat.o(150521);
  }
  
  public final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(150520);
    Log.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(paramBoolean)));
    this.cvA = paramBoolean;
    this.lNg = System.currentTimeMillis();
    AppMethodBeat.o(150520);
  }
  
  public final void start()
  {
    AppMethodBeat.i(150519);
    this.lNc.sendEmptyMessage(1);
    AppMethodBeat.o(150519);
  }
  
  static final class a
    extends MMHandler
  {
    private WeakReference<b> lNq;
    
    public a(b paramb, Looper paramLooper)
    {
      super();
      AppMethodBeat.i(150516);
      this.lNq = new WeakReference(paramb);
      AppMethodBeat.o(150516);
    }
    
    public final void handleMessage(Message arg1)
    {
      AppMethodBeat.i(150517);
      b localb = (b)this.lNq.get();
      if ((localb != null) && (1 == ???.what))
      {
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vDy, false);
        ??? = new aaq();
        ???.fZM.fDn = 2;
        EventCenter.instance.publish(???);
        if (((!???.fZN.calling) && (!a.aAj())) || (!bool))
        {
          if ((!localb.cvA) && (System.currentTimeMillis() - localb.lNg > 1200000L))
          {
            Log.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            AppMethodBeat.o(150517);
            return;
          }
          if ((localb.lNe != 0L) || (localb.lNd.size() <= 0) || (localb.lNh != 0) || (localb.lNi))
          {
            Log.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.lNe + " size: " + localb.lNd.size() + " cnt: " + localb.lNh + " pauseOnMonitor: " + localb.lNi);
            AppMethodBeat.o(150517);
            return;
          }
          g localg;
          synchronized (localb.lNd)
          {
            localb.lNe = ((Long)localb.lNd.pop()).longValue();
            ??? = ((n)h.ae(n.class)).eSe().Oq(localb.lNe);
            localg = q.bmh().C(???.field_talker, ???.field_msgSvrId);
            if (localg.ilm == 1)
            {
              Log.i("MicroMsg.AutoGetBigImgLogic", localb.lNe + " already has hd thumb");
              localb.lNe = 0L;
              localb.start();
              AppMethodBeat.o(150517);
              return;
            }
          }
          Log.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.lNe + "  image_" + ???.field_msgId);
          com.tencent.mm.aq.f.bkg().lHW.add("image_" + ???.field_msgId);
          q.bmi().a(localg.localId, ???.field_msgId, 0, Long.valueOf(locala.lNe), locala.lNf, locala);
        }
      }
      AppMethodBeat.o(150517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.b
 * JD-Core Version:    0.7.0.1
 */