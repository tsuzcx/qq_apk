package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static com.tencent.mm.vending.j.c<bgc, Integer> ccL()
  {
    AppMethodBeat.i(122090);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("BaseBizCollector", "habbyge-mali, BaseBizCollector, getCurPageFlowItem, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(122090);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localObject1 == null)
    {
      ad.e("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, curSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    ad.i("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, curSession: %s", new Object[] { ((bxx)localObject1).sessionId });
    d.cbG();
    Object localObject2 = e.cbL();
    if (localObject2 == null)
    {
      ad.e("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, curAR is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    ad.i("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, curAR: %s", new Object[] { ((bh)localObject2).CvH.activityName });
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.fB(((bxx)localObject1).sessionId, ((bh)localObject2).CvH.activityName);
    if (localObject1 == null)
    {
      ad.e("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, getPageFlowItemOfCurSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    localObject2 = (bgc)((com.tencent.mm.vending.j.b)localObject1).get(0);
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
    ad.i("BaseBizCollector", "HABBYGE-MALI, BaseBizCollector, HellPageFlowItem: %s, %s, %d", new Object[] { ((bgc)localObject2).dpw, ((bgc)localObject2).DDP, Integer.valueOf(i) });
    AppMethodBeat.o(122090);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.b
 * JD-Core Version:    0.7.0.1
 */