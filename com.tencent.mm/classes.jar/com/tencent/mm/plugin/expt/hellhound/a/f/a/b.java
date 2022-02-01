package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static com.tencent.mm.vending.j.c<cbm, Integer> cPT()
  {
    AppMethodBeat.i(122090);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX())
    {
      Log.w("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getCurPageFlowItem, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(122090);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localObject == null)
    {
      Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    Log.i("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession: %s", new Object[] { ((cyl)localObject).sessionId });
    d.cNM();
    bn localbn = e.cNR();
    if (localbn == null)
    {
      Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curAR is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.gw(((cyl)localObject).sessionId, localbn.KFh.activityName);
    if (localObject == null)
    {
      Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getPageFlowItemOfCurSession is NULL");
      AppMethodBeat.o(122090);
      return null;
    }
    ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    AppMethodBeat.o(122090);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.a.b
 * JD-Core Version:    0.7.0.1
 */