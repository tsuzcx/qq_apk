package com.tencent.mm.plugin.f.c;

import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends b
{
  private long cacheSize;
  private boolean isStop;
  private LinkedList<String> owa;
  private a owb;
  
  public a(LinkedList<String> paramLinkedList, long paramLong, a parama)
  {
    AppMethodBeat.i(193172);
    this.owa = paramLinkedList;
    this.cacheSize = paramLong;
    this.owb = parama;
    ad.d("MicroMsg.CleanCacheTask", "%d clean cache [%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.owa.size()) });
    AppMethodBeat.o(193172);
  }
  
  public final String getKey()
  {
    return "ScanMsgTask";
  }
  
  public final void run()
  {
    AppMethodBeat.i(193173);
    if (this.isStop)
    {
      AppMethodBeat.o(193173);
      return;
    }
    long l = bt.HI();
    Object localObject = this.owa.iterator();
    while (((Iterator)localObject).hasNext()) {
      i.cZ((String)((Iterator)localObject).next(), true);
    }
    l = bt.aO(l);
    ad.d("MicroMsg.CleanCacheTask", "%d clean cache costTime[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(l) });
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("0,0,0,0,0,0,0,0,0,0,0,0,").append(this.cacheSize);
    g.yhR.kvStat(14762, ((StringBuffer)localObject).toString());
    if (this.owb != null) {
      this.owb.bTf();
    }
    AppMethodBeat.o(193173);
  }
  
  public static abstract interface a
  {
    public abstract void bTf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.c.a
 * JD-Core Version:    0.7.0.1
 */