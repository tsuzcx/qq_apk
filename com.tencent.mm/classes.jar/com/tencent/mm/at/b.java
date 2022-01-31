package com.tencent.mm.at;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Stack;

public final class b
  implements d.a
{
  private b.a fDh;
  public Stack<Long> fDi;
  long fDj;
  public int fDk;
  boolean fDl;
  public long fDm;
  int fDn;
  boolean fDo;
  long fDp;
  long fDq;
  int fDr;
  int fDs;
  ap fDt;
  com.tencent.mm.sdk.b.c fDu;
  com.tencent.mm.sdk.b.c fDv;
  
  public b(Looper paramLooper)
  {
    AppMethodBeat.i(78159);
    this.fDj = 0L;
    this.fDk = 0;
    this.fDl = false;
    this.fDm = 0L;
    this.fDn = 0;
    this.fDo = false;
    this.fDp = 0L;
    this.fDq = 0L;
    this.fDt = new ap(new b.1(this), false);
    this.fDu = new b.2(this);
    this.fDv = new b.3(this);
    this.fDh = new b.a(this, paramLooper);
    this.fDi = new Stack();
    this.fDr = Process.myUid();
    paramLooper = (Integer)g.RL().Ru().get(327681, null);
    if ((paramLooper == null) || (3 == paramLooper.intValue())) {}
    for (int i = 1;; i = paramLooper.intValue())
    {
      this.fDs = i;
      a.ymk.c(this.fDu);
      a.ymk.c(this.fDv);
      AppMethodBeat.o(78159);
      return;
    }
  }
  
  public static void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(78162);
    if (paramBoolean)
    {
      if (at.isWifi(ah.getContext()))
      {
        ab.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
        AppMethodBeat.o(78162);
        return;
      }
      long l1 = bo.a((Long)g.RL().Ru().get(ac.a.yyI, null), 0L);
      long l2 = bo.apW((String)DateFormat.format("M", System.currentTimeMillis()));
      ab.d("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " msgLocalId: " + paramLong2 + " has been downloaded current %d month %d", new Object[] { Long.valueOf(1L + l1), Long.valueOf(l2) });
      g.RL().Ru().set(ac.a.yyI, Long.valueOf(l1 + 1L));
      g.RL().Ru().set(ac.a.yyJ, Long.valueOf(l2));
      AppMethodBeat.o(78162);
      return;
    }
    ab.i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + paramLong1 + " msglocalid " + paramLong2 + " false");
    AppMethodBeat.o(78162);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(78164);
    ab.i("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + " has been canceled");
    ((com.tencent.mm.plugin.comm.a.b)g.E(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, true);
    AppMethodBeat.o(78164);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object arg7, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    AppMethodBeat.i(78163);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ab.e("MicroMsg.AutoGetBigImgLogic", "img " + paramLong1 + "msgLocalId " + paramLong2 + " download failed");
      ((com.tencent.mm.plugin.comm.a.b)g.E(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, false, false);
    }
    for (;;)
    {
      this.fDj = 0L;
      com.tencent.mm.modelcontrol.c.afT();
      if (!com.tencent.mm.modelcontrol.c.afU())
      {
        ab.i("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.fDi)
        {
          this.fDi.clear();
          AppMethodBeat.o(78163);
          return;
          a(paramLong1, paramLong2, true);
          ((com.tencent.mm.plugin.comm.a.b)g.E(com.tencent.mm.plugin.comm.a.b.class)).b(paramLong2, true, false);
        }
      }
    }
    this.fDp = TrafficStats.getUidRxBytes(this.fDr);
    this.fDq = TrafficStats.getUidTxBytes(this.fDr);
    this.fDt.ag(1000L, 1000L);
    AppMethodBeat.o(78163);
  }
  
  public final void cP(boolean paramBoolean)
  {
    AppMethodBeat.i(78161);
    ab.d("MicroMsg.AutoGetBigImgLogic", "is foreground: ".concat(String.valueOf(paramBoolean)));
    this.fDl = paramBoolean;
    this.fDm = System.currentTimeMillis();
    AppMethodBeat.o(78161);
  }
  
  public final void start()
  {
    AppMethodBeat.i(78160);
    this.fDh.sendEmptyMessage(1);
    AppMethodBeat.o(78160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.b
 * JD-Core Version:    0.7.0.1
 */