package com.tencent.mm.plugin.ai.data.business.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aan;
import com.tencent.mm.autogen.a.eg;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.plugin.ai.service.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public final class e
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
  private IListener<gh> qng;
  
  protected e()
  {
    AppMethodBeat.i(267607);
    this.qmW = null;
    this.qmX = null;
    this.qmY = false;
    this.qmZ = 0L;
    this.qlP = 300000L;
    this.qmS = new NearLiveTrigger.1(this, f.hfK);
    this.qmT = new NearLiveTrigger.2(this, f.hfK);
    this.qmb = new NearLiveTrigger.3(this, f.hfK);
    this.qng = new NearLiveTrigger.4(this, f.hfK);
    bZN();
    AppMethodBeat.o(267607);
  }
  
  private static HashSet<String> TN(String paramString)
  {
    AppMethodBeat.i(267621);
    HashSet localHashSet = new HashSet();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267621);
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
    AppMethodBeat.o(267621);
    return localHashSet;
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267628);
    this.qmS.alive();
    this.qmT.alive();
    this.qmb.alive();
    this.qng.alive();
    AppMethodBeat.o(267628);
  }
  
  final void bZN()
  {
    AppMethodBeat.i(267644);
    this.qmW = TN(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrr, ""));
    this.qmX = TN(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrq, ""));
    this.qmY = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrs, false);
    this.qlP = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrt, 300000L);
    Log.i("MicroMsg.NearLiveTrigger", "reset control tabRedDotControl[%b] quitControlMap[%s] enterControlMap[%s] finderSyncFreqControl[%d]", new Object[] { Boolean.valueOf(this.qmY), this.qmW, this.qmX, Long.valueOf(this.qlP) });
    AppMethodBeat.o(267644);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267634);
    this.qmS.dead();
    this.qmT.dead();
    this.qmb.dead();
    this.qng.dead();
    AppMethodBeat.o(267634);
  }
  
  final void yL(int paramInt)
  {
    AppMethodBeat.i(267654);
    a.caz();
    boolean bool1;
    if (!a.ju(70368744177664L))
    {
      bool1 = true;
      boolean bool2 = ((d)com.tencent.mm.kernel.h.ax(d.class)).aBu();
      boolean bool3 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgF();
      Log.i("MicroMsg.AiService", "[isShowLiveEntrance] openNearbyLiveFriends:%s isEnable:%s, isTeenMode:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
      if ((!bool3) || (!bool1) || (bool2)) {
        break label140;
      }
    }
    label140:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label145;
      }
      Log.v("MicroMsg.NearLiveTrigger", "live is closed, don't request");
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 214L, 1L);
      AppMethodBeat.o(267654);
      return;
      bool1 = false;
      break;
    }
    label145:
    if (Util.milliSecondsToNow(this.qmZ) <= this.qlP)
    {
      Log.v("MicroMsg.NearLiveTrigger", "live syn freq control lastFinderSyncMs[%d] finderSyncFreqControl[%d]", new Object[] { Long.valueOf(this.qmZ), Long.valueOf(this.qlP) });
      com.tencent.mm.plugin.report.service.h.OAn.p(1559L, 213L, 1L);
      AppMethodBeat.o(267654);
      return;
    }
    this.qmZ = Util.nowMilliSecond();
    paramInt += 20000;
    com.tencent.mm.plugin.ai.data.business.finder.e.bZM().yJ(paramInt);
    Log.printInfoStack("MicroMsg.NearLiveTrigger", "pure notify live sync scene[%d]", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(267654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.e
 * JD-Core Version:    0.7.0.1
 */