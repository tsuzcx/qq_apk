package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  implements f
{
  private ee tJf;
  
  public c()
  {
    AppMethodBeat.i(241786);
    this.tJf = new ee();
    AppMethodBeat.o(241786);
  }
  
  public final void a(apf paramapf, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241787);
    if (paramapf == null)
    {
      AppMethodBeat.o(241787);
      return;
    }
    long l = Util.currentTicks();
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    localPString2.value = "";
    localPString1.value = "";
    switch (paramapf.cmdId)
    {
    default: 
      localObject1 = new ie();
      ((ie)localObject1).dMM.dMO = paramapf.cmdId;
      ((ie)localObject1).dMM.dMN = localPString1.value;
      ((ie)localObject1).dMM.dMP = localPString2.value;
      ((ie)localObject1).dMM.scene = paramInt2;
      EventCenter.instance.publish((IEvent)localObject1);
      Log.i("MicroMsg.FinderSyncReportHandler", "FinderSyncReport handle cmd[%d] selector[%d] scene[%d] cost[%d]", new Object[] { Integer.valueOf(paramapf.cmdId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(241787);
      return;
    }
    Object localObject1 = new bdh();
    for (;;)
    {
      int i;
      try
      {
        ((bdh)localObject1).parseFrom(paramapf.LBo.toByteArray());
        if (((bdh)localObject1).LKY == null) {
          break;
        }
        Object localObject2 = new StringBuffer();
        Object localObject3 = new StringBuffer();
        i = 0;
        if (i < ((bdh)localObject1).LKY.size())
        {
          bdj localbdj = (bdj)((bdh)localObject1).LKY.get(i);
          if ((localbdj == null) || (localbdj.LNi == null)) {
            break label492;
          }
          if (i > 0)
          {
            ((StringBuffer)localObject2).append(";");
            ((StringBuffer)localObject3).append(";");
          }
          ((StringBuffer)localObject2).append(localbdj.LNi.LKM);
          ((StringBuffer)localObject3).append(localbdj.LNi.type);
          break label492;
        }
        localPString1.value = ((StringBuffer)localObject2).toString();
        localPString2.value = ((StringBuffer)localObject3).toString();
        localObject1 = localPString1.value;
        localObject2 = localPString2.value;
        i = paramapf.cmdId;
        if (Util.isNullOrNil((String)localObject1)) {
          break;
        }
        localObject3 = this.tJf;
        ((ee)localObject3).ejo = ((ee)localObject3).x("TipsId", (String)localObject1, true);
        ((ee)localObject3).ejr = ((ee)localObject3).x("CtrlType", (String)localObject2, true);
        ((ee)localObject3).eCB = paramInt2;
        ((ee)localObject3).eCC = i;
        ((ee)localObject3).bfK();
        Log.i("MicroMsg.FinderSyncReportHandler", "report RedDot [%s] scene[%d] cmdId[%d]", new Object[] { localObject1, Integer.valueOf(paramInt2), Integer.valueOf(i) });
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FinderSyncReportHandler", localException, "report tab tips", new Object[0]);
      }
      break;
      label492:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.c
 * JD-Core Version:    0.7.0.1
 */