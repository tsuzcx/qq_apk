package com.tencent.mm.modelimage;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Stack;

public final class b
  implements f.a
{
  int bKg;
  boolean eny;
  private a oFJ;
  Stack<Long> oFK;
  long oFL;
  public int oFM;
  long oFN;
  int oFO;
  boolean oFP;
  long oFQ;
  long oFR;
  int oFS;
  MTimerHandler oFT;
  IListener oFU;
  IListener oFV;
  
  public b(Looper paramLooper)
  {
    AppMethodBeat.i(150518);
    this.oFL = 0L;
    this.oFM = 0;
    this.eny = false;
    this.oFN = 0L;
    this.oFO = 0;
    this.oFP = false;
    this.oFQ = 0L;
    this.oFR = 0L;
    this.oFT = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(150512);
        long l1 = TrafficStats.getUidRxBytes(b.this.bKg);
        long l2 = TrafficStats.getUidTxBytes(b.this.bKg);
        long l3 = l1 - b.this.oFQ + (l2 - b.this.oFR);
        Log.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + l3 / 1024L);
        if (l3 <= 20480L)
        {
          b.this.oFP = false;
          b.this.start();
        }
        for (;;)
        {
          AppMethodBeat.o(150512);
          return true;
          b.this.oFQ = l1;
          b.this.oFR = l2;
          b.this.oFT.startTimer(1000L);
        }
      }
    }, false);
    this.oFU = new AutoGetBigImgLogic.2(this, com.tencent.mm.app.f.hfK);
    this.oFV = new AutoGetBigImgLogic.3(this, com.tencent.mm.app.f.hfK);
    this.oFJ = new a(this, paramLooper);
    this.oFK = new Stack();
    this.bKg = Process.myUid();
    paramLooper = (Integer)com.tencent.mm.kernel.h.baE().ban().d(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.oFS = i;
      this.oFU.alive();
      this.oFV.alive();
      AppMethodBeat.o(150518);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(150522);
    Log.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).b(paramLong2, false, true);
    AppMethodBeat.o(150522);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, p paramp) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, p paramp)
  {
    AppMethodBeat.i(150521);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      Log.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).b(paramLong2, false, false);
    }
    for (;;)
    {
      this.oFL = 0L;
      d.bId();
      if (!d.bIe()) {
        Log.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
      }
      synchronized (this.oFK)
      {
        this.oFK.clear();
        AppMethodBeat.o(150521);
        return;
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
        {
          Log.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
          ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).b(paramLong2, true, false);
        }
        else
        {
          long l1 = Util.nullAs((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJc, null), 0L);
          long l2 = Util.safeParseLong((String)DateFormat.format("M", System.currentTimeMillis()));
          Log.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acJc, Long.valueOf(l1 + 1L));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acJd, Long.valueOf(l2));
        }
      }
    }
    this.oFT.startTimer(1000L);
    AppMethodBeat.o(150521);
  }
  
  public final void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(150520);
    Log.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(paramBoolean)));
    this.eny = paramBoolean;
    this.oFN = System.currentTimeMillis();
    AppMethodBeat.o(150520);
  }
  
  public final void start()
  {
    AppMethodBeat.i(150519);
    this.oFJ.sendEmptyMessage(1);
    AppMethodBeat.o(150519);
  }
  
  static final class a
    extends MMHandler
  {
    private WeakReference<b> oFX;
    
    public a(b paramb, Looper paramLooper)
    {
      super();
      AppMethodBeat.i(150516);
      this.oFX = new WeakReference(paramb);
      AppMethodBeat.o(150516);
    }
    
    public final void handleMessage(Message arg1)
    {
      AppMethodBeat.i(150517);
      b localb = (b)this.oFX.get();
      if ((localb != null) && (1 == ???.what))
      {
        boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRY, false);
        ??? = new acn();
        ???.ifU.hId = 2;
        ???.publish();
        if (((!???.ifV.calling) && (!a.aTe())) || (!bool))
        {
          if ((!localb.eny) && (System.currentTimeMillis() - localb.oFN > 1200000L))
          {
            Log.i("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
            AppMethodBeat.o(150517);
            return;
          }
          if ((localb.oFL != 0L) || (localb.oFK.size() <= 0) || (localb.oFO != 0) || (localb.oFP))
          {
            Log.i("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + localb.oFL + " size: " + localb.oFK.size() + " cnt: " + localb.oFO + " pauseOnMonitor: " + localb.oFP);
            AppMethodBeat.o(150517);
            return;
          }
          synchronized (localb.oFK)
          {
            localb.oFL = ((Long)localb.oFK.pop()).longValue();
            ??? = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localb.oFL);
            if (??? == null)
            {
              Log.e("MicroMsg.AutoGetBigImgLogic", "can't get msgInfo of " + localb.oFL);
              localb.oFL = 0L;
              localb.start();
              AppMethodBeat.o(150517);
              return;
            }
          }
          h localh = r.bKa().G(???.field_talker, ???.field_msgSvrId);
          if (localh == null)
          {
            Log.e("MicroMsg.AutoGetBigImgLogic", "can't get imgInfo of " + locala.oFL);
            locala.oFL = 0L;
            locala.start();
            AppMethodBeat.o(150517);
            return;
          }
          if (localh.kLl == 1)
          {
            Log.i("MicroMsg.AutoGetBigImgLogic", locala.oFL + " already has hd thumb");
            locala.oFL = 0L;
            locala.start();
            AppMethodBeat.o(150517);
            return;
          }
          Log.i("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + locala.oFL + "  image_" + ???.field_msgId);
          k.bHW().oAv.add("image_" + ???.field_msgId);
          r.bKb().a(localh.localId, ???.field_msgId, 0, Long.valueOf(locala.oFL), locala.oFM, locala);
        }
      }
      AppMethodBeat.o(150517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelimage.b
 * JD-Core Version:    0.7.0.1
 */