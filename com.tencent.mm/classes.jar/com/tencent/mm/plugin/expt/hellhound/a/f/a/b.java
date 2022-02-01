package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static com.tencent.mm.vending.j.c<cjp, Integer> deN()
  {
    AppMethodBeat.i(122090);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.deR())
    {
      Log.w("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getCurPageFlowItem, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(122090);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localObject == null)
    {
      Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    Log.i("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession: %s", new Object[] { ((dhx)localObject).sessionId });
    d.dcE();
    bl localbl = e.dcJ();
    if (localbl == null)
    {
      Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curAR is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.gK(((dhx)localObject).sessionId, localbl.RGy.activityName);
    if (localObject == null)
    {
      Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getPageFlowItemOfCurSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    ((com.tencent.mm.vending.j.b)localObject).get(0);
    ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    AppMethodBeat.o(122090);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.b
 * JD-Core Version:    0.7.0.1
 */