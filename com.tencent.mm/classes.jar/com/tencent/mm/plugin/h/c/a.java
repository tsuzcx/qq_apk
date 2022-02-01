package com.tencent.mm.plugin.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.e.i.b
{
  private boolean isStop;
  private LinkedList<String> sXl;
  private long sXm;
  private List<Runnable> sXn;
  private a sXo;
  
  public a(LinkedList<String> paramLinkedList, long paramLong, List<Runnable> paramList, a parama)
  {
    AppMethodBeat.i(283261);
    this.sXl = paramLinkedList;
    this.sXm = paramLong;
    this.sXo = parama;
    this.sXn = paramList;
    Log.d("MicroMsg.CleanCacheTask", "%d clean cache [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.sXl.size()) });
    AppMethodBeat.o(283261);
  }
  
  public final String getKey()
  {
    return "ScanMsgTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(283262);
    if (this.isStop)
    {
      AppMethodBeat.o(283262);
      return;
    }
    long l = Util.currentTicks();
    Object localObject = this.sXl.iterator();
    while (((Iterator)localObject).hasNext()) {
      u.deleteDir((String)((Iterator)localObject).next());
    }
    localObject = com.tencent.mm.vfs.b.ieZ().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((f)((Iterator)localObject).next()).cFq();
    }
    if (Util.getInt(d.dgX().a("clicfg_clean_delete_oversize_sns_db", "0", false, true), 0) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aj.fPc();
      }
      if (this.sXn == null) {
        break;
      }
      localObject = this.sXn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
    l = Util.ticksToNow(l);
    Log.d("MicroMsg.CleanCacheTask", "%d clean cache costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("0,0,0,0,0,0,0,0,0,0,0,0,").append(this.sXm).append(",0,0,0");
    h.IzE.kvStat(14762, ((StringBuffer)localObject).toString());
    if (this.sXo != null) {
      this.sXo.cFt();
    }
    AppMethodBeat.o(283262);
  }
  
  public static abstract interface a
  {
    public abstract void cFt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.h.c.a
 * JD-Core Version:    0.7.0.1
 */