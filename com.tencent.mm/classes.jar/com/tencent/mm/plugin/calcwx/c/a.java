package com.tencent.mm.plugin.calcwx.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.threadpool.i.b
{
  private boolean isStop;
  private LinkedList<String> wbC;
  private long wbD;
  private List<Runnable> wbE;
  private final boolean wbF;
  private a wbG;
  
  public a(LinkedList<String> paramLinkedList, long paramLong, List<Runnable> paramList, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(277801);
    this.wbC = paramLinkedList;
    this.wbD = paramLong;
    this.wbG = parama;
    this.wbE = paramList;
    this.wbF = paramBoolean;
    Log.d("MicroMsg.CleanCacheTask", "%d clean cache [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wbC.size()) });
    AppMethodBeat.o(277801);
  }
  
  public final String getKey()
  {
    return "ScanMsgTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(277808);
    if (this.isStop)
    {
      AppMethodBeat.o(277808);
      return;
    }
    long l = Util.currentTicks();
    Object localObject1 = this.wbC.iterator();
    while (((Iterator)localObject1).hasNext()) {
      y.ew((String)((Iterator)localObject1).next(), true);
    }
    if (this.wbF) {}
    for (localObject1 = com.tencent.mm.vfs.b.NO(false);; localObject1 = com.tencent.mm.vfs.b.jKd())
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((j)((Iterator)localObject1).next()).NP(true);
      }
    }
    if (Util.getInt(d.dNI().a("clicfg_clean_delete_oversize_sns_db", "0", false, true), 0) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        al.hgW();
        com.tencent.mm.plugin.sns.f.a.hek();
      }
      if (this.wbE == null) {
        break;
      }
      localObject1 = this.wbE.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Runnable)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((Runnable)localObject2).run();
        }
      }
    }
    l = Util.ticksToNow(l);
    Log.d("MicroMsg.CleanCacheTask", "%d clean cache costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
    localObject1 = new StringBuffer();
    Object localObject2 = ((StringBuffer)localObject1).append("0,0,0,0,0,0,0,0,0,0,0,0,").append(this.wbD).append(",0,0,0,");
    if (this.wbF) {
      i = 1;
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append(i);
      h.OAn.b(14762, ((StringBuffer)localObject1).toString(), true, true);
      if (this.wbF) {}
      try
      {
        Thread.sleep(800L);
        label317:
        if (this.wbG != null) {
          this.wbG.diM();
        }
        AppMethodBeat.o(277808);
        return;
        i = 0;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label317;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void diM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.c.a
 * JD-Core Version:    0.7.0.1
 */