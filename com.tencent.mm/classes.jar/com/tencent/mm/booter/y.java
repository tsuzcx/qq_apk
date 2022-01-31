package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import java.util.HashSet;

public final class y
{
  public static y dZP;
  public j.a appForegroundListener;
  public com.tencent.mm.storage.y dZQ;
  public c dZR;
  public c dZS;
  public y.a dZT;
  public int dZU;
  HashSet<Long> dZV;
  HashSet<Long> dZW;
  public long dZX;
  public long dZY;
  public String dZZ;
  public long eaa;
  public int eab;
  public int eac;
  private int ead;
  private int eae;
  private boolean hasInit;
  
  static
  {
    AppMethodBeat.i(15881);
    dZP = new y();
    AppMethodBeat.o(15881);
  }
  
  private y()
  {
    AppMethodBeat.i(15879);
    this.dZR = new y.1(this);
    this.dZS = new y.2(this);
    this.appForegroundListener = new y.3(this);
    this.dZU = 0;
    this.dZV = new HashSet();
    this.dZW = new HashSet();
    this.eaa = -1L;
    this.eab = 20;
    this.eac = 24;
    this.ead = 30;
    this.eae = 10800;
    this.hasInit = false;
    this.dZQ = new com.tencent.mm.storage.y(ac.eQv + "staytime.cfg");
    AppMethodBeat.o(15879);
  }
  
  public final void kA(String paramString)
  {
    AppMethodBeat.i(15880);
    a.ymk.d(this.dZR);
    a.ymk.d(this.dZS);
    this.appForegroundListener.dead();
    this.dZW.clear();
    this.dZV.clear();
    if ((paramString == null) || (this.dZT == null))
    {
      if (this.dZT == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(15880);
        return;
      }
    }
    if (!paramString.equals(this.dZT.eag))
    {
      ab.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.dZT.eag });
      AppMethodBeat.o(15880);
      return;
    }
    paramString = this.dZT;
    paramString.time += ah.av(this.dZX) / 1000L;
    paramString = (String)this.dZQ.get(5, "");
    this.dZQ.set(5, paramString + this.dZT.toString());
    long l;
    if (this.dZT != null)
    {
      l = this.dZQ.getLong(4, 0L);
      i = this.dZQ.Nr(6) + 1;
      this.dZQ.setInt(6, i);
      ab.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.dZT.eag, Integer.valueOf(this.dZT.type), Long.valueOf(this.dZT.time), Integer.valueOf(this.dZT.eak), Integer.valueOf(i) });
      ab.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.dZT.eal), Integer.valueOf(this.dZT.eam), Integer.valueOf(this.dZT.ean) });
      if ((ah.gz(l) <= this.eae) && (i <= this.ead)) {
        break label516;
      }
    }
    label516:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.dZQ.get(5, "");
        paramString = paramString + "," + l + "," + ah.aox();
        ab.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        h.qsU.kvStat(13062, paramString);
        this.dZQ.setInt(6, 0);
        this.dZQ.set(5, "");
      }
      AppMethodBeat.o(15880);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.y
 * JD-Core Version:    0.7.0.1
 */