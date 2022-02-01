package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ah;
import java.util.HashSet;
import java.util.Locale;

public final class z
{
  public static z fns;
  public n.a appForegroundListener;
  public long fnA;
  public long fnB;
  public String fnC;
  public long fnD;
  public int fnE;
  public int fnF;
  private int fnG;
  private int fnH;
  public ad fnt;
  public c fnu;
  public c fnv;
  public a fnw;
  public int fnx;
  HashSet<Long> fny;
  HashSet<Long> fnz;
  private boolean hasInit;
  
  static
  {
    AppMethodBeat.i(19915);
    fns = new z();
    AppMethodBeat.o(19915);
  }
  
  private z()
  {
    AppMethodBeat.i(19913);
    this.fnu = new c() {};
    this.fnv = new c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.fnx = 0;
    this.fny = new HashSet();
    this.fnz = new HashSet();
    this.fnD = -1L;
    this.fnE = 20;
    this.fnF = 24;
    this.fnG = 30;
    this.fnH = 10800;
    this.hasInit = false;
    this.fnt = new ad(ah.GDu + "staytime.cfg");
    AppMethodBeat.o(19913);
  }
  
  public final void rx(String paramString)
  {
    AppMethodBeat.i(19914);
    a.GpY.d(this.fnu);
    a.GpY.d(this.fnv);
    this.appForegroundListener.dead();
    this.fnz.clear();
    this.fny.clear();
    if ((paramString == null) || (this.fnw == null))
    {
      if (this.fnw == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(19914);
        return;
      }
    }
    if (!paramString.equals(this.fnw.fnJ))
    {
      ac.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.fnw.fnJ });
      AppMethodBeat.o(19914);
      return;
    }
    paramString = this.fnw;
    paramString.time += bs.aO(this.fnA) / 1000L;
    paramString = (String)this.fnt.get(5, "");
    this.fnt.set(5, paramString + this.fnw.toString());
    long l;
    if (this.fnw != null)
    {
      l = this.fnt.getLong(4, 0L);
      i = this.fnt.YF(6) + 1;
      this.fnt.setInt(6, i);
      ac.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.fnw.fnJ, Integer.valueOf(this.fnw.type), Long.valueOf(this.fnw.time), Integer.valueOf(this.fnw.fnM), Integer.valueOf(i) });
      ac.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.fnw.fnN), Integer.valueOf(this.fnw.fnO), Integer.valueOf(this.fnw.fnP) });
      if ((bs.pN(l) <= this.fnH) && (i <= this.fnG)) {
        break label516;
      }
    }
    label516:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.fnt.get(5, "");
        paramString = paramString + "," + l + "," + bs.aNx();
        ac.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        h.wUl.kvStat(13062, paramString);
        this.fnt.setInt(6, 0);
        this.fnt.set(5, "");
      }
      AppMethodBeat.o(19914);
      return;
    }
  }
  
  public final class a
  {
    public int cYG;
    public long enterTime;
    public String fnJ;
    public int fnK;
    public int fnL;
    public int fnM;
    public int fnN = 0;
    int fnO = 0;
    int fnP = 0;
    public long time;
    public int type;
    
    public a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(19912);
      String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.fnK), Integer.valueOf(this.cYG), Integer.valueOf(this.fnL), Long.valueOf(this.enterTime), Integer.valueOf(this.fnM), this.fnJ, Integer.valueOf(this.fnN), Integer.valueOf(this.fnO), Integer.valueOf(this.fnP) });
      AppMethodBeat.o(19912);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.z
 * JD-Core Version:    0.7.0.1
 */