package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.al;
import java.util.HashSet;
import java.util.Locale;

public final class z
{
  public static z fFA;
  public n.a appForegroundListener;
  public ah fFB;
  public c fFC;
  public c fFD;
  public a fFE;
  public int fFF;
  HashSet<Long> fFG;
  HashSet<Long> fFH;
  public long fFI;
  public long fFJ;
  public String fFK;
  public long fFL;
  public int fFM;
  public int fFN;
  private int fFO;
  private int fFP;
  private boolean hasInit;
  
  static
  {
    AppMethodBeat.i(19915);
    fFA = new z();
    AppMethodBeat.o(19915);
  }
  
  private z()
  {
    AppMethodBeat.i(19913);
    this.fFC = new c() {};
    this.fFD = new c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.fFF = 0;
    this.fFG = new HashSet();
    this.fFH = new HashSet();
    this.fFL = -1L;
    this.fFM = 20;
    this.fFN = 24;
    this.fFO = 30;
    this.fFP = 10800;
    this.hasInit = false;
    this.fFB = new ah(al.IpN + "staytime.cfg");
    AppMethodBeat.o(19913);
  }
  
  public final void uj(String paramString)
  {
    AppMethodBeat.i(19914);
    a.IbL.d(this.fFC);
    a.IbL.d(this.fFD);
    this.appForegroundListener.dead();
    this.fFH.clear();
    this.fFG.clear();
    if ((paramString == null) || (this.fFE == null))
    {
      if (this.fFE == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(19914);
        return;
      }
    }
    if (!paramString.equals(this.fFE.fFR))
    {
      ad.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.fFE.fFR });
      AppMethodBeat.o(19914);
      return;
    }
    paramString = this.fFE;
    paramString.time += bt.aO(this.fFI) / 1000L;
    paramString = (String)this.fFB.get(5, "");
    this.fFB.set(5, paramString + this.fFE.toString());
    long l;
    if (this.fFE != null)
    {
      l = this.fFB.getLong(4, 0L);
      i = this.fFB.aaO(6) + 1;
      this.fFB.setInt(6, i);
      ad.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.fFE.fFR, Integer.valueOf(this.fFE.type), Long.valueOf(this.fFE.time), Integer.valueOf(this.fFE.fFU), Integer.valueOf(i) });
      ad.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.fFE.fFV), Integer.valueOf(this.fFE.fFW), Integer.valueOf(this.fFE.fFX) });
      if ((bt.rM(l) <= this.fFP) && (i <= this.fFO)) {
        break label516;
      }
    }
    label516:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.fFB.get(5, "");
        paramString = paramString + "," + l + "," + bt.aQJ();
        ad.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        g.yhR.kvStat(13062, paramString);
        this.fFB.setInt(6, 0);
        this.fFB.set(5, "");
      }
      AppMethodBeat.o(19914);
      return;
    }
  }
  
  public final class a
  {
    public int djY;
    public long enterTime;
    public String fFR;
    public int fFS;
    public int fFT;
    public int fFU;
    public int fFV = 0;
    int fFW = 0;
    int fFX = 0;
    public long time;
    public int type;
    
    public a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(19912);
      String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.fFS), Integer.valueOf(this.djY), Integer.valueOf(this.fFT), Long.valueOf(this.enterTime), Integer.valueOf(this.fFU), this.fFR, Integer.valueOf(this.fFV), Integer.valueOf(this.fFW), Integer.valueOf(this.fFX) });
      AppMethodBeat.o(19912);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.z
 * JD-Core Version:    0.7.0.1
 */