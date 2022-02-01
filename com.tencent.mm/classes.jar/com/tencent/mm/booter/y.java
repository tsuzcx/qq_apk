package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.sf;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import java.util.HashSet;
import java.util.Locale;

public final class y
{
  public static y fjY;
  public n.a appForegroundListener;
  public aa fjZ;
  public c fka;
  public c fkb;
  public a fkc;
  public int fkd;
  HashSet<Long> fke;
  HashSet<Long> fkf;
  public long fkg;
  public long fkh;
  public String fki;
  public long fkj;
  public int fkk;
  public int fkl;
  private int fkm;
  private int fkn;
  private boolean hasInit;
  
  static
  {
    AppMethodBeat.i(19915);
    fjY = new y();
    AppMethodBeat.o(19915);
  }
  
  private y()
  {
    AppMethodBeat.i(19913);
    this.fka = new c() {};
    this.fkb = new c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.fkd = 0;
    this.fke = new HashSet();
    this.fkf = new HashSet();
    this.fkj = -1L;
    this.fkk = 20;
    this.fkl = 24;
    this.fkm = 30;
    this.fkn = 10800;
    this.hasInit = false;
    this.fjZ = new aa(ae.FfH + "staytime.cfg");
    AppMethodBeat.o(19913);
  }
  
  public final void or(String paramString)
  {
    AppMethodBeat.i(19914);
    a.ESL.d(this.fka);
    a.ESL.d(this.fkb);
    this.appForegroundListener.dead();
    this.fkf.clear();
    this.fke.clear();
    if ((paramString == null) || (this.fkc == null))
    {
      if (this.fkc == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(19914);
        return;
      }
    }
    if (!paramString.equals(this.fkc.fkp))
    {
      ad.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.fkc.fkp });
      AppMethodBeat.o(19914);
      return;
    }
    paramString = this.fkc;
    paramString.time += bt.aS(this.fkg) / 1000L;
    paramString = (String)this.fjZ.get(5, "");
    this.fjZ.set(5, paramString + this.fkc.toString());
    long l;
    if (this.fkc != null)
    {
      l = this.fjZ.getLong(4, 0L);
      i = this.fjZ.Wv(6) + 1;
      this.fjZ.setInt(6, i);
      ad.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.fkc.fkp, Integer.valueOf(this.fkc.type), Long.valueOf(this.fkc.time), Integer.valueOf(this.fkc.fks), Integer.valueOf(i) });
      ad.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.fkc.fkt), Integer.valueOf(this.fkc.fku), Integer.valueOf(this.fkc.fkv) });
      if ((bt.lZ(l) <= this.fkn) && (i <= this.fkm)) {
        break label516;
      }
    }
    label516:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.fjZ.get(5, "");
        paramString = paramString + "," + l + "," + bt.aGK();
        ad.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        h.vKh.kvStat(13062, paramString);
        this.fjZ.setInt(6, 0);
        this.fjZ.set(5, "");
      }
      AppMethodBeat.o(19914);
      return;
    }
  }
  
  public final class a
  {
    public int dbk;
    public long enterTime;
    public String fkp;
    public int fkq;
    public int fkr;
    public int fks;
    public int fkt = 0;
    int fku = 0;
    int fkv = 0;
    public long time;
    public int type;
    
    public a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(19912);
      String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.fkq), Integer.valueOf(this.dbk), Integer.valueOf(this.fkr), Long.valueOf(this.enterTime), Integer.valueOf(this.fks), this.fkp, Integer.valueOf(this.fkt), Integer.valueOf(this.fku), Integer.valueOf(this.fkv) });
      AppMethodBeat.o(19912);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.y
 * JD-Core Version:    0.7.0.1
 */