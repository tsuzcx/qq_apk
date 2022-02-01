package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.ua;
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
  public static z gmQ;
  public o.a appForegroundListener;
  public an gmR;
  public IListener gmS;
  public IListener gmT;
  public a gmU;
  public int gmV;
  HashSet<Long> gmW;
  HashSet<Long> gmX;
  public long gmY;
  public long gmZ;
  public String gna;
  public long gnb;
  public int gnc;
  public int gnd;
  private int gne;
  private int gnf;
  private boolean hasInit;
  
  static
  {
    AppMethodBeat.i(19915);
    gmQ = new z();
    AppMethodBeat.o(19915);
  }
  
  private z()
  {
    AppMethodBeat.i(19913);
    this.gmS = new IListener() {};
    this.gmT = new z.2(this);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.gmV = 0;
    this.gmW = new HashSet();
    this.gmX = new HashSet();
    this.gnb = -1L;
    this.gnc = 20;
    this.gnd = 24;
    this.gne = 30;
    this.gnf = 10800;
    this.hasInit = false;
    this.gmR = new an(ar.NSe + "staytime.cfg");
    AppMethodBeat.o(19913);
  }
  
  public final void CU(String paramString)
  {
    AppMethodBeat.i(19914);
    EventCenter.instance.removeListener(this.gmS);
    EventCenter.instance.removeListener(this.gmT);
    this.appForegroundListener.dead();
    this.gmX.clear();
    this.gmW.clear();
    if ((paramString == null) || (this.gmU == null))
    {
      if (this.gmU == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(19914);
        return;
      }
    }
    if (!paramString.equals(this.gmU.gnh))
    {
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.gmU.gnh });
      AppMethodBeat.o(19914);
      return;
    }
    paramString = this.gmU;
    paramString.time += Util.ticksToNow(this.gmY) / 1000L;
    paramString = (String)this.gmR.get(5, "");
    this.gmR.set(5, paramString + this.gmU.toString());
    long l;
    if (this.gmU != null)
    {
      l = this.gmR.getLong(4, 0L);
      i = this.gmR.ake(6) + 1;
      this.gmR.setInt(6, i);
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.gmU.gnh, Integer.valueOf(this.gmU.type), Long.valueOf(this.gmU.time), Integer.valueOf(this.gmU.gnk), Integer.valueOf(i) });
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.gmU.gnl), Integer.valueOf(this.gmU.gnm), Integer.valueOf(this.gmU.gnn) });
      if ((Util.secondsToNow(l) <= this.gnf) && (i <= this.gne)) {
        break label516;
      }
    }
    label516:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.gmR.get(5, "");
        paramString = paramString + "," + l + "," + Util.nowSecond();
        Log.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        h.CyF.kvStat(13062, paramString);
        this.gmR.setInt(6, 0);
        this.gmR.set(5, "");
      }
      AppMethodBeat.o(19914);
      return;
    }
  }
  
  public final class a
  {
    public int dCm;
    public long enterTime;
    public String gnh;
    public int gni;
    public int gnj;
    public int gnk;
    public int gnl = 0;
    int gnm = 0;
    int gnn = 0;
    public long time;
    public int type;
    
    public a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(19912);
      String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.gni), Integer.valueOf(this.dCm), Integer.valueOf(this.gnj), Long.valueOf(this.enterTime), Integer.valueOf(this.gnk), this.gnh, Integer.valueOf(this.gnl), Integer.valueOf(this.gnm), Integer.valueOf(this.gnn) });
      AppMethodBeat.o(19912);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.z
 * JD-Core Version:    0.7.0.1
 */