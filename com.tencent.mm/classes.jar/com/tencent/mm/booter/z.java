package com.tencent.mm.booter;

import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.ac;
import java.util.HashSet;
import java.util.Locale;

public final class z
{
  public static z diw = new z();
  public a diA;
  public int diB = 0;
  HashSet<Long> diC = new HashSet();
  HashSet<Long> diD = new HashSet();
  public long diE;
  public long diF;
  public String diG;
  public long diH = -1L;
  public int diI = 20;
  public int diJ = 24;
  public int diK = 30;
  public int diL = 10800;
  public com.tencent.mm.storage.y dix = new com.tencent.mm.storage.y(ac.dOP + "staytime.cfg");
  public c diy = new z.1(this);
  public c diz = new z.2(this);
  public boolean hasInit = false;
  
  public final void et(String paramString)
  {
    a.udP.d(this.diy);
    a.udP.d(this.diz);
    this.diD.clear();
    this.diC.clear();
    if ((paramString == null) || (this.diA == null))
    {
      if (this.diA == null) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        return;
      }
    }
    if (!paramString.equals(this.diA.diN))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.diA.diN });
      return;
    }
    paramString = this.diA;
    paramString.time += ah.cp(this.diE) / 1000L;
    paramString = (String)this.dix.get(5, "");
    this.dix.set(5, paramString + this.diA.toString());
    long l = this.dix.getLong(4, 0L);
    int i = this.dix.Fl(6) + 1;
    this.dix.setInt(6, i);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.diA.diN, Integer.valueOf(this.diA.type), Long.valueOf(this.diA.time), Integer.valueOf(this.diA.diR), Integer.valueOf(i) });
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.diA.diS), Integer.valueOf(this.diA.diT), Integer.valueOf(this.diA.diU) });
    if ((ah.cn(l) > this.diL) || (i > this.diK)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.dix.get(5, "");
        paramString = paramString + "," + l + "," + ah.UX();
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        h.nFQ.aC(13062, paramString);
        this.dix.setInt(6, 0);
        this.dix.set(5, "");
      }
      this.diA = null;
      return;
    }
  }
  
  public final class a
  {
    public int bFo;
    public String diN;
    public int diO;
    public int diP;
    public long diQ;
    public int diR;
    public int diS = 0;
    int diT = 0;
    int diU = 0;
    public long time;
    public int type;
    
    public a() {}
    
    public final String toString()
    {
      return String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.diO), Integer.valueOf(this.bFo), Integer.valueOf(this.diP), Long.valueOf(this.diQ), Integer.valueOf(this.diR), this.diN, Integer.valueOf(this.diS), Integer.valueOf(this.diT), Integer.valueOf(this.diU) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.z
 * JD-Core Version:    0.7.0.1
 */