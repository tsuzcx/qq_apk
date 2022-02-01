package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.it;
import com.tencent.mm.f.b.a.fb;
import com.tencent.mm.plugin.finder.api.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  implements h
{
  private fb xso;
  
  public e()
  {
    AppMethodBeat.i(287697);
    this.xso = new fb();
    AppMethodBeat.o(287697);
  }
  
  public final void a(aqt paramaqt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287698);
    if (paramaqt == null)
    {
      AppMethodBeat.o(287698);
      return;
    }
    long l = Util.currentTicks();
    PString localPString1 = new PString();
    PString localPString2 = new PString();
    localPString2.value = "";
    localPString1.value = "";
    switch (paramaqt.cmdId)
    {
    }
    for (;;)
    {
      Object localObject1 = new it();
      ((it)localObject1).fFU.fFW = paramaqt.cmdId;
      ((it)localObject1).fFU.fFV = localPString1.value;
      ((it)localObject1).fFU.fFX = localPString2.value;
      ((it)localObject1).fFU.scene = paramInt2;
      EventCenter.instance.publish((IEvent)localObject1);
      Log.i("MicroMsg.FinderSyncReportHandler", "FinderSyncReport handle cmd[%d] selector[%d] scene[%d] cost[%d]", new Object[] { Integer.valueOf(paramaqt.cmdId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(287698);
      return;
      localObject1 = new bke();
      Object localObject3;
      for (;;)
      {
        try
        {
          ((bke)localObject1).parseFrom(paramaqt.SDX.toByteArray());
          if (((bke)localObject1).SSJ == null) {
            break;
          }
          localObject2 = new StringBuffer();
          localObject3 = new StringBuffer();
          i = 0;
          if (i >= ((bke)localObject1).SSJ.size()) {
            break label452;
          }
          bkg localbkg = (bkg)((bke)localObject1).SSJ.get(i);
          if ((localbkg != null) && (localbkg.SVk != null) && (localbkg.SVk.MFx != null) && (!localbkg.SVk.MFx.isEmpty()))
          {
            Iterator localIterator = localbkg.SVk.MFx.iterator();
            if (localIterator.hasNext())
            {
              bkn localbkn = (bkn)localIterator.next();
              if ((!"FinderEntrance".equals(localbkn.path)) && (!"NearbyEntrance".equals(localbkn.path)) && (!"FinderLiveEntrance".equals(localbkn.path))) {
                continue;
              }
              ((StringBuffer)localObject2).append(localbkg.SVk.SQm).append(";");
              ((StringBuffer)localObject3).append(localbkg.SVk.type).append(";");
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.FinderSyncReportHandler", localException, "report tab tips", new Object[0]);
        }
        i += 1;
      }
      label452:
      localPString1.value = ((StringBuffer)localObject2).toString();
      localPString2.value = ((StringBuffer)localObject3).toString();
      String str = localPString1.value;
      Object localObject2 = localPString2.value;
      int i = paramaqt.cmdId;
      if (!Util.isNullOrNil(str))
      {
        localObject3 = this.xso;
        ((fb)localObject3).gdM = ((fb)localObject3).z("TipsId", str, true);
        ((fb)localObject3).gdP = ((fb)localObject3).z("CtrlType", (String)localObject2, true);
        ((fb)localObject3).gzl = paramInt2;
        ((fb)localObject3).gzm = i;
        ((fb)localObject3).bpa();
        Log.i("MicroMsg.FinderSyncReportHandler", "report RedDot [%s] scene[%d] cmdId[%d]", new Object[] { str, Integer.valueOf(paramInt2), Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.e
 * JD-Core Version:    0.7.0.1
 */