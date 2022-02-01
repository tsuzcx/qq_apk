package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public static com.tencent.mm.vending.j.c<bju, Integer> ckt()
  {
    AppMethodBeat.i(122090);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ckx())
    {
      ac.w("BaseBizCollector", "habbyge-mali, BaseBizCollector, getCurPageFlowItem, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(122090);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localObject1 == null)
    {
      ac.e("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, curSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    ac.i("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, curSession: %s", new Object[] { ((ccs)localObject1).sessionId });
    d.ciR();
    Object localObject2 = e.ciW();
    if (localObject2 == null)
    {
      ac.e("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, curAR is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    ac.i("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, curAR: %s", new Object[] { ((bj)localObject2).DOc.activityName });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.fO(((ccs)localObject1).sessionId, ((bj)localObject2).DOc.activityName);
    if (localObject1 == null)
    {
      ac.e("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, getPageFlowItemOfCurSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    localObject2 = (bju)((com.tencent.mm.vending.j.b)localObject1).get(0);
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
    ac.i("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, HellPageFlowItem: %s, %s, %d", new Object[] { ((bju)localObject2).dnh, ((bju)localObject2).qoi, Integer.valueOf(i) });
    AppMethodBeat.o(122090);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.b
 * JD-Core Version:    0.7.0.1
 */