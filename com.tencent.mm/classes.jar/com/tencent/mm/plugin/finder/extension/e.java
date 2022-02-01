package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.jq;
import com.tencent.mm.autogen.mmdata.rpt.fz;
import com.tencent.mm.autogen.mmdata.rpt.gq;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.api.k;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements k
{
  private gq APy;
  
  public e()
  {
    AppMethodBeat.i(366630);
    this.APy = new gq();
    AppMethodBeat.o(366630);
  }
  
  private List<fz> b(auw paramauw, int paramInt)
  {
    AppMethodBeat.i(366643);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new bxh();
    int i;
    Object localObject2;
    Iterator localIterator;
    Object localObject3;
    try
    {
      ((bxh)localObject1).parseFrom(paramauw.ZFn.toByteArray());
      if (((bxh)localObject1).aace != null)
      {
        i = 0;
        if (i < ((bxh)localObject1).aace.size())
        {
          localObject2 = (bxi)((bxh)localObject1).aace.get(i);
          if ((localObject2 != null) && (((bxi)localObject2).aagf != null) && (((bxi)localObject2).aagf.aabA != null) && (!((bxi)localObject2).aagf.aabA.isEmpty()))
          {
            localIterator = ((bxi)localObject2).aagf.aabA.iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (bxq)localIterator.next();
              if (("FinderEntrance".equals(((bxq)localObject3).path)) || ("NearbyEntrance".equals(((bxq)localObject3).path)) || ("FinderLiveEntrance".equals(((bxq)localObject3).path)))
              {
                fz localfz = new fz();
                localfz.ikf = localfz.F("TipsId", ((bxi)localObject2).aagf.ZYN, true);
                localfz.iyT = ((bxi)localObject2).aagf.type;
                localfz.ikk = localfz.F("Path", ((bxq)localObject3).path, true);
                localfz.iJL = ((bxq)localObject3).show_type;
                localfz.imE = localfz.F("Url", Util.nullAs(((bxq)localObject3).icon_url, ""), true);
                localfz.ijZ = paramInt;
                localArrayList.add(localfz);
                continue;
                AppMethodBeat.o(366643);
              }
            }
          }
        }
      }
    }
    catch (Exception paramauw)
    {
      Log.printErrStackTrace("MicroMsg.FinderSyncReportHandler", paramauw, "report tab tips", new Object[0]);
    }
    for (;;)
    {
      return localArrayList;
      i += 1;
      break;
      if (!localArrayList.isEmpty())
      {
        localObject2 = new StringBuffer();
        localObject1 = new StringBuffer();
        localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (fz)localIterator.next();
          ((StringBuffer)localObject2).append(((fz)localObject3).ikf).append(";");
          ((StringBuffer)localObject1).append(((fz)localObject3).iyT).append(";");
        }
        localObject2 = ((StringBuffer)localObject2).toString();
        localObject1 = ((StringBuffer)localObject1).toString();
        i = paramauw.cmdId;
        if (!Util.isNullOrNil((String)localObject2))
        {
          paramauw = this.APy;
          paramauw.ikf = paramauw.F("TipsId", (String)localObject2, true);
          paramauw.iki = paramauw.F("CtrlType", (String)localObject1, true);
          paramauw.ijZ = paramInt;
          paramauw.iLy = i;
          paramauw.bMH();
          Log.i("MicroMsg.FinderSyncReportHandler", "report RedDot [%s] ctrl[%s] scene[%d] cmdId[%d]", new Object[] { localObject2, localObject1, Integer.valueOf(paramInt), Integer.valueOf(i) });
        }
      }
    }
  }
  
  public final void a(auw paramauw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(366651);
    if (paramauw == null)
    {
      AppMethodBeat.o(366651);
      return;
    }
    long l = Util.currentTicks();
    List localList = null;
    switch (paramauw.cmdId)
    {
    }
    for (;;)
    {
      jq localjq = new jq();
      localjq.hLk.hLl = paramauw.cmdId;
      localjq.hLk.scene = paramInt2;
      localjq.hLk.hLm = localList;
      localjq.publish();
      Log.i("MicroMsg.FinderSyncReportHandler", "FinderSyncReport handle cmd[%d] selector[%d] scene[%d] cost[%d]", new Object[] { Integer.valueOf(paramauw.cmdId), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(366651);
      return;
      localList = b(paramauw, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.e
 * JD-Core Version:    0.7.0.1
 */