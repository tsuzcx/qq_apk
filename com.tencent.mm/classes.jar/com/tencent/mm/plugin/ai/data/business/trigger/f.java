package com.tencent.mm.plugin.ai.data.business.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public final class f
  implements c
{
  private IListener<nk> qlh;
  private IListener<gh> qng;
  HashSet<String> qno;
  int qnp;
  long qnq;
  long qnr;
  boolean qns;
  
  protected f()
  {
    AppMethodBeat.i(267602);
    this.qno = null;
    this.qnp = 0;
    this.qnq = 0L;
    this.qnr = 7200000L;
    this.qns = true;
    this.qng = new SessionChangeTrigger.1(this, com.tencent.mm.app.f.hfK);
    this.qlh = new SessionChangeTrigger.2(this, com.tencent.mm.app.f.hfK);
    bZN();
    AppMethodBeat.o(267602);
  }
  
  private static HashSet<String> TN(String paramString)
  {
    AppMethodBeat.i(267608);
    HashSet localHashSet = new HashSet();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(267608);
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
    AppMethodBeat.o(267608);
    return localHashSet;
  }
  
  public final void aoW()
  {
    AppMethodBeat.i(267617);
    this.qng.alive();
    this.qlh.alive();
    AppMethodBeat.o(267617);
  }
  
  final void bZN()
  {
    AppMethodBeat.i(267636);
    this.qno = TN(((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrH, ""));
    this.qnp = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrI, 0);
    this.qnr = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrJ, 300000L);
    this.qns = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zrK, true);
    Log.i("MicroMsg.LauncherUITrigger", "resetControl handleSessionSet[%s] finderSyncScene[%d] handleFreqControlMs[%d] needControlDau[%b]", new Object[] { this.qno, Integer.valueOf(this.qnp), Long.valueOf(this.qnr), Boolean.valueOf(this.qns) });
    AppMethodBeat.o(267636);
  }
  
  public final void unRegister()
  {
    AppMethodBeat.i(267626);
    this.qng.dead();
    this.qlh.dead();
    AppMethodBeat.o(267626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.trigger.f
 * JD-Core Version:    0.7.0.1
 */