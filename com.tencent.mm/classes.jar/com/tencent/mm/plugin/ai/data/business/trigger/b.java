package com.tencent.mm.plugin.ai.data.business.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aan;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.plugin.ai.data.business.finder.e;
import com.tencent.mm.plugin.ai.service.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public final class b
  implements c
{
  private long qlP;
  private IListener<su> qmS;
  private IListener<eg> qmT;
  HashSet<String> qmW;
  HashSet<String> qmX;
  boolean qmY;
  private long qmZ;
  private IListener<aan> qmb;
  long qna;
  long qnb;
  boolean qnc;
  long qnd;
  long qne;
  private IListener<nk> qnf;
  private IListener<gh> qng;
  
  protected b()
  {
    AppMethodBeat.i(267696);
    this.qmW = null;
    this.qmX = null;
    this.qmY = false;
    this.qmZ = 0L;
    this.qlP = 300000L;
    this.qna = 0L;
    this.qnb = 0L;
    this.qnc = false;
    this.qnd = 2000L;
    this.qne = 60000L;
    this.qmS = new FinderTrigger.1(this, f.hfK);
    this.qmT = new FinderTrigger.2(this, f.hfK);
    this.qmb = new FinderTrigger.3(this, f.hfK);
    this.qnf = new FinderTrigger.4(this, f.hfK);
    this.qng = new FinderTrigger.5(this, f.hfK);
    bZN();
    AppMethodBeat.o(267696);
  }
  
  private static HashSet<String> TN(String paramString)
  {
    AppMethodBeat.i(267701);
    HashSet localHashSet = new HashSet();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267701);
      return localHashSet;
    }
    paramString = paramString.split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localHashSet.add(paramString[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(267701);
    return localHashSet;
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267706);
    this.qmS.alive();
    this.qmT.alive();
    this.qmb.alive();
    this.qng.alive();
    this.qnf.alive();
    AppMethodBeat.o(267706);
  }
  
  final void bZN()
  {
    AppMethodBeat.i(267716);
    this.qmW = TN(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zri, ""));
    this.qmX = TN(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrh, ""));
    this.qmY = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrj, false);
    this.qlP = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrk, 300000L);
    this.qna = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrp, 0L);
    this.qnb = 0L;
    this.qnd = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrF, 2000L);
    this.qne = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrG, 60000L);
    Log.i("MicroMsg.FinderTrigger", "reset control tabRedDotControl[%b] quitControlMap[%s] enterControlMap[%s] finderSyncFreqControl[%d] lastFinderSendHourGap[%d]", new Object[] { Boolean.valueOf(this.qmY), this.qmW, this.qmX, Long.valueOf(this.qlP), Long.valueOf(this.qna) });
    AppMethodBeat.o(267716);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267709);
    this.qmS.dead();
    this.qmT.dead();
    this.qmb.dead();
    this.qng.dead();
    this.qnf.dead();
    AppMethodBeat.o(267709);
  }
  
  final void yK(int paramInt)
  {
    AppMethodBeat.i(267722);
    a.caz();
    if (!a.bZX())
    {
      Log.v("MicroMsg.FinderTrigger", "finder is closed, don't request");
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 204L, 1L);
      AppMethodBeat.o(267722);
      return;
    }
    if (Util.milliSecondsToNow(this.qmZ) <= this.qlP)
    {
      Log.v("MicroMsg.FinderTrigger", "finder syn freq control lastFinderSyncMs[%d] finderSyncFreqControl[%d]", new Object[] { Long.valueOf(this.qmZ), Long.valueOf(this.qlP) });
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 203L, 1L);
      AppMethodBeat.o(267722);
      return;
    }
    this.qmZ = Util.nowMilliSecond();
    paramInt += 10000;
    e.bZM().yJ(paramInt);
    Log.printInfoStack("MicroMsg.FinderTrigger", "pure notify finder sync finderSync[%d]", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(267722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.b
 * JD-Core Version:    0.7.0.1
 */