package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static com.tencent.mm.vending.j.c<boc, Integer> cpJ()
  {
    AppMethodBeat.i(122090);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cpN())
    {
      ad.w("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getCurPageFlowItem, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(122090);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localObject == null)
    {
      ad.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    ad.i("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession: %s", new Object[] { ((chk)localObject).sessionId });
    d.cnR();
    bj localbj = e.cnW();
    if (localbj == null)
    {
      ad.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curAR is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.fX(((chk)localObject).sessionId, localbj.Fti.activityName);
    if (localObject == null)
    {
      ad.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getPageFlowItemOfCurSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    AppMethodBeat.o(122090);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.b
 * JD-Core Version:    0.7.0.1
 */