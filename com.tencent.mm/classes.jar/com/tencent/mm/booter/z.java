package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.app.q.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.at;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Locale;

public final class z
{
  public static z lsV;
  public q.a appForegroundListener;
  private boolean hasInit;
  public ap lsW;
  public IListener lsX;
  public IListener lsY;
  public a lsZ;
  public int lta;
  HashSet<Long> ltb;
  HashSet<Long> ltc;
  public long ltd;
  public long lte;
  public String ltf;
  public long ltg;
  public int lth;
  public int lti;
  private int ltj;
  private int ltk;
  
  static
  {
    AppMethodBeat.i(19915);
    lsV = new z();
    AppMethodBeat.o(19915);
  }
  
  private z()
  {
    AppMethodBeat.i(19913);
    this.lsX = new StayTimeReport.1(this, f.hfK);
    this.lsY = new StayTimeReport.2(this, f.hfK);
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.lta = 0;
    this.ltb = new HashSet();
    this.ltc = new HashSet();
    this.ltg = -1L;
    this.lth = 20;
    this.lti = 24;
    this.ltj = 30;
    this.ltk = 10800;
    this.hasInit = false;
    try
    {
      this.lsW = new ap(at.acHq + "staytime.cfg");
      AppMethodBeat.o(19913);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.printErrStackTrace("MicroMsg.StayTimeReport", localOutOfMemoryError, "", new Object[0]);
      y.deleteFile(at.acHq + "staytime.cfg");
      this.lsW = new ap(at.acHq + "staytime.cfg");
      AppMethodBeat.o(19913);
    }
  }
  
  public final void Cq(String paramString)
  {
    AppMethodBeat.i(19914);
    this.lsX.dead();
    this.lsY.dead();
    this.appForegroundListener.dead();
    this.ltc.clear();
    this.ltb.clear();
    if ((paramString == null) || (this.lsZ == null))
    {
      if (this.lsZ == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.StayTimeReport", "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b", new Object[] { paramString, Boolean.valueOf(bool) });
        AppMethodBeat.o(19914);
        return;
      }
    }
    if (!paramString.equals(this.lsZ.ltm))
    {
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[] { paramString, this.lsZ.ltm });
      AppMethodBeat.o(19914);
      return;
    }
    paramString = this.lsZ;
    paramString.time += Util.ticksToNow(this.ltd) / 1000L;
    paramString = (String)this.lsW.d(5, "");
    this.lsW.B(5, paramString + this.lsZ.toString());
    long l;
    if (this.lsZ != null)
    {
      l = this.lsW.amW(4);
      i = this.lsW.ayQ(6) + 1;
      this.lsW.setInt(6, i);
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[] { this.lsZ.ltm, Integer.valueOf(this.lsZ.type), Long.valueOf(this.lsZ.time), Integer.valueOf(this.lsZ.ltp), Integer.valueOf(i) });
      Log.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[] { Integer.valueOf(this.lsZ.ltq), Integer.valueOf(this.lsZ.lts), Integer.valueOf(this.lsZ.ltt) });
      if ((Util.secondsToNow(l) <= this.ltk) && (i <= this.ltj)) {
        break label508;
      }
    }
    label508:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString = (String)this.lsW.d(5, "");
        paramString = paramString + "," + l + "," + Util.nowSecond();
        Log.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[] { Integer.valueOf(13062), paramString });
        h.OAn.kvStat(13062, paramString);
        this.lsW.setInt(6, 0);
        this.lsW.B(5, "");
      }
      AppMethodBeat.o(19914);
      return;
    }
  }
  
  public final class a
  {
    public long enterTime;
    public int hzj;
    public String ltm;
    public int ltn;
    public int lto;
    public int ltp;
    public int ltq = 0;
    int lts = 0;
    int ltt = 0;
    public long time;
    public int type;
    
    public a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(19912);
      String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.ltn), Integer.valueOf(this.hzj), Integer.valueOf(this.lto), Long.valueOf(this.enterTime), Integer.valueOf(this.ltp), this.ltm, Integer.valueOf(this.ltq), Integer.valueOf(this.lts), Integer.valueOf(this.ltt) });
      AppMethodBeat.o(19912);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.z
 * JD-Core Version:    0.7.0.1
 */