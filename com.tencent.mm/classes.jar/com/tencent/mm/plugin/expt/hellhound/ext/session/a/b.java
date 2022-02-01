package com.tencent.mm.plugin.expt.hellhound.ext.session.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static com.tencent.mm.vending.j.c<czu, Integer> dLC()
  {
    AppMethodBeat.i(122090);
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.dLF())
    {
      Log.w("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getCurPageFlowItem, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(122090);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localObject == null)
    {
      Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    Log.i("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession: %s", new Object[] { ((eah)localObject).sessionId });
    d.dJg();
    bt localbt = e.dJl();
    if (localbt == null)
    {
      Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curAR is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.ext.session.c.b.hs(((eah)localObject).sessionId, localbt.YDs.AtM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.a.b
 * JD-Core Version:    0.7.0.1
 */