package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.tc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import java.util.HashSet;
import java.util.Locale;

public final class z
{
  public static z fHE;
  public o.a appForegroundListener;
  public ai fHF;
  public c fHG;
  public c fHH;
  public a fHI;
  public int fHJ;
  HashSet<Long> fHK;
  HashSet<Long> fHL;
  public long fHM;
  public long fHN;
  public String fHO;
  public long fHP;
  public int fHQ;
  public int fHR;
  private int fHS;
  private int fHT;
  private boolean hasInit;
  
  static
  {
    AppMethodBeat.i(19915);
    fHE = new z();
    AppMethodBeat.o(19915);
  }
  
  private z()
  {
    AppMethodBeat.i(19913);
    this.fHG = new c() {};
    this.fHH = new c() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.fHJ = 0;
    this.fHK = new HashSet();
    this.fHL = new HashSet();
    this.fHP = -1L;
    this.fHQ = 20;
    this.fHR = 24;
    this.fHS = 30;
    this.fHT = 10800;
    this.hasInit = false;
    this.fHF = new ai(am.IKh + "staytime.cfg");
    AppMethodBeat.o(19913);
  }
  
  public final void uE(String paramString)
  {
    AppMethodBeat.i(19914);
    a.IvT.d(this.fHG);
    a.IvT.d(this.fHH);
    this.appForegroundListener.dead();
    this.fHL.clear();
    this.fHK.clear();
    if ((paramString == null) || (this.fHI == null))
    {
      if (this.fHI == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(19914);
        return;
      }
    }
    if (!paramString.equals(this.fHI.fHV))
    {
      ae.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.fHI.fHV });
      AppMethodBeat.o(19914);
      return;
    }
    paramString = this.fHI;
    paramString.time += bu.aO(this.fHM) / 1000L;
    paramString = (String)this.fHF.get(5, "");
    this.fHF.set(5, paramString + this.fHI.toString());
    long l;
    if (this.fHI != null)
    {
      l = this.fHF.getLong(4, 0L);
      i = this.fHF.abw(6) + 1;
      this.fHF.setInt(6, i);
      ae.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.fHI.fHV, Integer.valueOf(this.fHI.type), Long.valueOf(this.fHI.time), Integer.valueOf(this.fHI.fHY), Integer.valueOf(i) });
      ae.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.fHI.fHZ), Integer.valueOf(this.fHI.fIa), Integer.valueOf(this.fHI.fIb) });
      if ((bu.rZ(l) <= this.fHT) && (i <= this.fHS)) {
        break label516;
      }
    }
    label516:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.fHF.get(5, "");
        paramString = paramString + "," + l + "," + bu.aRi();
        ae.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        g.yxI.kvStat(13062, paramString);
        this.fHF.setInt(6, 0);
        this.fHF.set(5, "");
      }
      AppMethodBeat.o(19914);
      return;
    }
  }
  
  public final class a
  {
    public int dla;
    public long enterTime;
    public String fHV;
    public int fHW;
    public int fHX;
    public int fHY;
    public int fHZ = 0;
    int fIa = 0;
    int fIb = 0;
    public long time;
    public int type;
    
    public a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(19912);
      String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.fHW), Integer.valueOf(this.dla), Integer.valueOf(this.fHX), Long.valueOf(this.enterTime), Integer.valueOf(this.fHY), this.fHV, Integer.valueOf(this.fHZ), Integer.valueOf(this.fIa), Integer.valueOf(this.fIb) });
      AppMethodBeat.o(19912);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.z
 * JD-Core Version:    0.7.0.1
 */