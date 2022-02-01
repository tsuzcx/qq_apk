package com.tencent.mm.plugin.f.c;

import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends b
{
  private long cacheSize;
  private boolean isStop;
  private LinkedList<String> pQk;
  private List<Runnable> pQl;
  private a pQm;
  
  public a(LinkedList<String> paramLinkedList, long paramLong, List<Runnable> paramList, a parama)
  {
    AppMethodBeat.i(231650);
    this.pQk = paramLinkedList;
    this.cacheSize = paramLong;
    this.pQm = parama;
    this.pQl = paramList;
    Log.d("MicroMsg.CleanCacheTask", "%d clean cache [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.pQk.size()) });
    AppMethodBeat.o(231650);
  }
  
  public final String getKey()
  {
    return "ScanMsgTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(231651);
    if (this.isStop)
    {
      AppMethodBeat.o(231651);
      return;
    }
    long l = Util.currentTicks();
    Object localObject = this.pQk.iterator();
    while (((Iterator)localObject).hasNext()) {
      s.dy((String)((Iterator)localObject).next(), true);
    }
    if (Util.getInt(d.cRY().b("clicfg_clean_delete_oversize_sns_db", "0", false, true), 0) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aj.fbi();
      }
      if (this.pQl == null) {
        break;
      }
      localObject = this.pQl.iterator();
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
    ((StringBuffer)localObject).append("0,0,0,0,0,0,0,0,0,0,0,0,").append(this.cacheSize).append(",0,0,0");
    h.CyF.kvStat(14762, ((StringBuffer)localObject).toString());
    if (this.pQm != null) {
      this.pQm.csi();
    }
    AppMethodBeat.o(231651);
  }
  
  public static abstract interface a
  {
    public abstract void csi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.a
 * JD-Core Version:    0.7.0.1
 */