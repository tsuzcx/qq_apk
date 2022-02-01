package com.tencent.mm.av;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.z;
import com.tencent.mm.g.a.z.a;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
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
  int Mr;
  boolean cwV;
  private a iWH;
  Stack<Long> iWI;
  long iWJ;
  public int iWK;
  long iWL;
  int iWM;
  boolean iWN;
  long iWO;
  long iWP;
  int iWQ;
  MTimerHandler iWR;
  IListener iWS;
  IListener iWT;
  
  public b(Looper paramLooper)
  {
    AppMethodBeat.i(150518);
    this.iWJ = 0L;
    this.iWK = 0;
    this.cwV = false;
    this.iWL = 0L;
    this.iWM = 0;
    this.iWN = false;
    this.iWO = 0L;
    this.iWP = 0L;
    this.iWR = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150512);
        long l1 = TrafficStats.getUidRxBytes(b.this.Mr);
        long l2 = TrafficStats.getUidTxBytes(b.this.Mr);
        long l3 = l1 - b.this.iWO + (l2 - b.this.iWP);
        Log.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
        if (l3 <= 20480L)
        {
          b.this.iWN = false;
          b.this.start();
        }
        for (;;)
        {
          AppMethodBeat.o(150512);
          return true;
          b.this.iWO = l1;
          b.this.iWP = l2;
          b.this.iWR.startTimer(1000L);
        }
      }
    }, false);
    this.iWS = new b.2(this);
    this.iWT = new IListener()
    {
      private boolean a(z arg1)
      {
        AppMethodBeat.i(150514);
        b.this.iWQ = ???.dCX.mode;
        Log.d("MicroMsg.AutoGetBigImgLogic", "mode = " + b.this.iWQ);
        d.baW();
        if (!d.baX()) {}
        synchronized (b.this.iWI)
        {
          b.this.iWI.clear();
          AppMethodBeat.o(150514);
          return false;
        }
      }
    };
    this.iWH = new a(this, paramLooper);
    this.iWI = new Stack();
    this.Mr = Process.myUid();
    paramLooper = (Integer)com.tencent.mm.kernel.g.aAh().azQ().get(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.iWQ = i;
      EventCenter.instance.addListener(this.iWS);
      EventCenter.instance.addListener(this.iWT);
      AppMethodBeat.o(150518);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(150522);
    Log.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(150522);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ak.q paramq) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(150521);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      Log.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
    }
    for (;;)
    {
      this.iWJ = 0L;
      d.baW();
      if (!d.baX())
      {
        Log.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.iWI)
        {
          this.iWI.clear();
          AppMethodBeat.o(150521);
          return;
          if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
          {
            Log.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
          }
          else
          {
            long l1 = Util.nullAs((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTI, null), 0L);
            long l2 = Util.safeParseLong((String)DateFormat.format("M", System.currentTimeMillis()));
            Log.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTI, Long.valueOf(l1 + 1L));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NTJ, Long.valueOf(l2));
          }
        }
      }
    }
    this.iWO = TrafficStats.getUidRxBytes(this.Mr);
    this.iWP = TrafficStats.getUidTxBytes(this.Mr);
    this.iWR.startTimer(1000L);
    AppMethodBeat.o(150521);
  }
  
  public final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(150520);
    Log.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(paramBoolean)));
    this.cwV = paramBoolean;
    this.iWL = System.currentTimeMillis();
    AppMethodBeat.o(150520);
  }
  
  public final void start()
  {
    AppMethodBeat.i(150519);
    this.iWH.sendEmptyMessage(1);
    AppMethodBeat.o(150519);
  }
  
  static final class a
    extends MMHandler
  {
    private WeakReference<b> iWV;
    
    public a(b paramb, Looper paramLooper)
    {
      super();
      AppMethodBeat.i(150516);
      this.iWV = new WeakReference(paramb);
      AppMethodBeat.o(150516);
    }
    
    public final void handleMessage(Message arg1)
    {
      AppMethodBeat.i(150517);
      b localb = (b)this.iWV.get();
      if ((localb != null) && (1 == ???.what))
      {
        boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rWM, false);
        ??? = new zj();
        ???.efx.dKy = 2;
        EventCenter.instance.publish(???);
        if (((!???.efy.calling) && (!a.att())) || (!bool))
        {
          if ((!localb.cwV) && (System.currentTimeMillis() - localb.iWL > 1200000L))
          {
            Log.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            AppMethodBeat.o(150517);
            return;
          }
          if ((localb.iWJ != 0L) || (localb.iWI.size() <= 0) || (localb.iWM != 0) || (localb.iWN))
          {
            Log.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.iWJ + " size: " + localb.iWI.size() + " cnt: " + localb.iWM + " pauseOnMonitor: " + localb.iWN);
            AppMethodBeat.o(150517);
            return;
          }
          g localg;
          synchronized (localb.iWI)
          {
            localb.iWJ = ((Long)localb.iWI.pop()).longValue();
            ??? = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(localb.iWJ);
            localg = q.bcR().G(???.field_talker, ???.field_msgSvrId);
            if (localg.fQW == 1)
            {
              Log.i("MicroMsg.AutoGetBigImgLogic", localb.iWJ + " already has hd thumb");
              localb.iWJ = 0L;
              localb.start();
              AppMethodBeat.o(150517);
              return;
            }
          }
          Log.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.iWJ + "  image_" + ???.field_msgId);
          f.baQ().iRE.add("image_" + ???.field_msgId);
          q.bcS().a(localg.localId, ???.field_msgId, 0, Long.valueOf(locala.iWJ), locala.iWK, locala);
        }
      }
      AppMethodBeat.o(150517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.b
 * JD-Core Version:    0.7.0.1
 */