package com.tencent.mm.plugin.expt.model;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.by;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private int oFF = 0;
  
  public c(int paramInt)
  {
    this.oFF = paramInt;
  }
  
  private static void Mg(int paramInt)
  {
    AppMethodBeat.i(299470);
    int i = (int)Util.nowSecond();
    if (i > paramInt)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWB, Integer.valueOf(i));
      AppMethodBeat.o(299470);
      return;
    }
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acWB, Integer.valueOf(paramInt));
    AppMethodBeat.o(299470);
  }
  
  private static LinkedList<aov> dMV()
  {
    AppMethodBeat.i(299460);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = b.dNr().dNv();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      by localby = new by();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.expt.e.a locala = (com.tencent.mm.plugin.expt.e.a)((Iterator)localObject).next();
        if (locala != null)
        {
          aov localaov = new aov();
          localaov.ZvX = locala.zNd;
          localaov.ZvY = locala.kW;
          localaov.ZvZ = locala.zNe;
          localaov.Zwc = locala.zNi;
          localby.iuL = localaov.ZvX;
          localby.iuM = localaov.ZvZ;
          localby.ipH = 1;
          localby.gNE();
          localLinkedList.add(localaov);
          localStringBuffer.append("expt:").append(locala.zNd).append(",seq:").append(locala.zNe).append(";");
        }
      }
      Log.i("MicroMsg.NetSceneGetExptApp", "local list[%s]", new Object[] { localStringBuffer });
    }
    AppMethodBeat.o(299460);
    return localLinkedList;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(299479);
    this.callback = paramh;
    long l = Util.currentTicks();
    try
    {
      paramh = new c.a();
      paramh.otE = new cjm();
      paramh.otF = new cjn();
      paramh.uri = "/cgi-bin/mmfddataappsvr/getexptappconfig";
      paramh.funcId = 1110;
      paramh.otG = 0;
      paramh.respCmdId = 0;
      paramh = paramh.bEF();
      cjm localcjm = (cjm)c.b.b(paramh.otB);
      localcjm.IJG = this.oFF;
      localcjm.aasa = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWB, Integer.valueOf(0))).intValue();
      Object localObject = new akf();
      ((akf)localObject).rig = Build.MANUFACTURER;
      ((akf)localObject).model = q.aPo();
      ((akf)localObject).Zrs = Build.VERSION.SDK_INT;
      ((akf)localObject).Zrt = Build.CPU_ABI;
      Log.i("MicroMsg.NetSceneGetExptApp", "create Device type manufacturer[%s] model[%s] os_api[%s] cpu[%s]", new Object[] { ((akf)localObject).rig, ((akf)localObject).model, ((akf)localObject).Zrs, ((akf)localObject).Zrt });
      localcjm.aasb = ((akf)localObject);
      localcjm.aase = ((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWC, ""));
      int j;
      int k;
      int m;
      int n;
      if (this.oFF == 3)
      {
        i = 0;
        localcjm.aasd = i;
        if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acWD, 0) == 1) {
          localcjm.aasd = 0;
        }
        localObject = dMV();
        j = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWE, Integer.valueOf(1))).intValue();
        if ((j == 1) || (localcjm.aasd == 0)) {
          localcjm.aasc = ((LinkedList)localObject);
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(863L, 155L, 1L, false);
        k = localcjm.IJG;
        m = localcjm.aasa;
        n = localcjm.aasd;
        localObject = localcjm.aase;
        if (localcjm.aasc == null) {
          break label486;
        }
      }
      label486:
      for (int i = localcjm.aasc.size();; i = 0)
      {
        Log.i("MicroMsg.NetSceneGetExptApp", "get expt app scene[%d] lastGetSvrSec[%d] IsIncrement[%d] GlobalSequence[%s] nextReqNeedLocalList[%d] localExptList[%d] cost[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), localObject, Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(Util.ticksToNow(l)) });
        i = dispatch(paramg, paramh, this);
        AppMethodBeat.o(299479);
        return i;
        i = 1;
        break;
      }
      return -1;
    }
    catch (Exception paramg)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneGetExptApp", paramg, "", new Object[0]);
      AppMethodBeat.o(299479);
    }
  }
  
  public final int getType()
  {
    return 1110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(299486);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cjn)c.c.b(((com.tencent.mm.am.c)params).otC);
      if (params == null)
      {
        paramInt1 = 0;
        if (paramInt1 == 0) {
          break label373;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(863L, 156L, 1L, false);
      }
    }
    for (;;)
    {
      a.dMQ();
      a.pd(false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(299486);
      return;
      if (params.BaseResponse.Idd != 0)
      {
        paramInt1 = 0;
        break;
      }
      paramArrayOfByte = new ArrayList();
      if ((params.aasi != null) && (params.aasi.size() > 0))
      {
        localObject = params.aasi.iterator();
        while (((Iterator)localObject).hasNext())
        {
          aov localaov = (aov)((Iterator)localObject).next();
          com.tencent.mm.plugin.expt.e.a locala = new com.tencent.mm.plugin.expt.e.a();
          locala.TZ(localaov.Zwa);
          paramArrayOfByte.add(locala);
        }
      }
      a.dMQ();
      a.b(params.YFu, params.aash, paramArrayOfByte);
      Mg(params.aasf);
      int i = params.aasg;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWA, Integer.valueOf(i));
      int j = params.aasj;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWE, Integer.valueOf(j));
      Object localObject = params.aase;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWC, localObject);
      int k = paramArrayOfByte.size();
      if (params.aash != null) {}
      for (paramInt1 = params.aash.size();; paramInt1 = 0)
      {
        Log.i("MicroMsg.NetSceneGetExptApp", "updateExpt interval[%d] nextReqNeedLocalList[%d] globalSeq[%s] updateList[%d] deleteList[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject, Integer.valueOf(k), Integer.valueOf(paramInt1) });
        paramInt1 = 1;
        break;
      }
      label373:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(863L, 157L, 1L, false);
      continue;
      Log.w("MicroMsg.NetSceneGetExptApp", "get expt error");
      Mg((int)Util.nowSecond());
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(863L, 157L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.model.c
 * JD-Core Version:    0.7.0.1
 */