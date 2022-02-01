package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.rs;
import com.tencent.mm.f.a.vd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import java.util.HashSet;
import java.util.Locale;

public final class z
{
  public static z iQZ;
  public o.a appForegroundListener;
  private boolean hasInit;
  public an iRa;
  public IListener iRb;
  public IListener iRc;
  public a iRd;
  public int iRe;
  HashSet<Long> iRf;
  HashSet<Long> iRg;
  public long iRh;
  public long iRi;
  public String iRj;
  public long iRk;
  public int iRl;
  public int iRm;
  private int iRn;
  private int iRo;
  
  static
  {
    AppMethodBeat.i(19915);
    iQZ = new z();
    AppMethodBeat.o(19915);
  }
  
  private z()
  {
    AppMethodBeat.i(19913);
    this.iRb = new IListener() {};
    this.iRc = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.iRe = 0;
    this.iRf = new HashSet();
    this.iRg = new HashSet();
    this.iRk = -1L;
    this.iRl = 20;
    this.iRm = 24;
    this.iRn = 30;
    this.iRo = 10800;
    this.hasInit = false;
    this.iRa = new an(ar.Vgb + "staytime.cfg");
    AppMethodBeat.o(19913);
  }
  
  public final void JK(String paramString)
  {
    AppMethodBeat.i(19914);
    EventCenter.instance.removeListener(this.iRb);
    EventCenter.instance.removeListener(this.iRc);
    this.appForegroundListener.dead();
    this.iRg.clear();
    this.iRf.clear();
    if ((paramString == null) || (this.iRd == null))
    {
      if (this.iRd == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(19914);
        return;
      }
    }
    if (!paramString.equals(this.iRd.iRq))
    {
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.iRd.iRq });
      AppMethodBeat.o(19914);
      return;
    }
    paramString = this.iRd;
    paramString.time += Util.ticksToNow(this.iRh) / 1000L;
    paramString = (String)this.iRa.b(5, "");
    this.iRa.i(5, paramString + this.iRd.toString());
    long l;
    if (this.iRd != null)
    {
      l = this.iRa.ahV(4);
      i = this.iRa.asB(6) + 1;
      this.iRa.setInt(6, i);
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.iRd.iRq, Integer.valueOf(this.iRd.type), Long.valueOf(this.iRd.time), Integer.valueOf(this.iRd.iRt), Integer.valueOf(i) });
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.iRd.iRu), Integer.valueOf(this.iRd.iRv), Integer.valueOf(this.iRd.iRw) });
      if ((Util.secondsToNow(l) <= this.iRo) && (i <= this.iRn)) {
        break label515;
      }
    }
    label515:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.iRa.b(5, "");
        paramString = paramString + "," + l + "," + Util.nowSecond();
        Log.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        h.IzE.kvStat(13062, paramString);
        this.iRa.setInt(6, 0);
        this.iRa.i(5, "");
      }
      AppMethodBeat.o(19914);
      return;
    }
  }
  
  public final class a
  {
    public long enterTime;
    public int fuP;
    public String iRq;
    public int iRr;
    public int iRs;
    public int iRt;
    public int iRu = 0;
    int iRv = 0;
    int iRw = 0;
    public long time;
    public int type;
    
    public a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(19912);
      String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.iRr), Integer.valueOf(this.fuP), Integer.valueOf(this.iRs), Long.valueOf(this.enterTime), Integer.valueOf(this.iRt), this.iRq, Integer.valueOf(this.iRu), Integer.valueOf(this.iRv), Integer.valueOf(this.iRw) });
      AppMethodBeat.o(19912);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.z
 * JD-Core Version:    0.7.0.1
 */