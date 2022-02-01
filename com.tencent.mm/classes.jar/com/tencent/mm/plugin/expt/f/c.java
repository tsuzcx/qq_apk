package com.tencent.mm.plugin.expt.f;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.at;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.h.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private i callback;
  private int iWD = 0;
  
  public c(int paramInt)
  {
    this.iWD = paramInt;
  }
  
  private static void Hz(int paramInt)
  {
    AppMethodBeat.i(220640);
    int i = (int)Util.nowSecond();
    if (i > paramInt)
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgC, Integer.valueOf(i));
      AppMethodBeat.o(220640);
      return;
    }
    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgC, Integer.valueOf(paramInt));
    AppMethodBeat.o(220640);
  }
  
  private static LinkedList<akh> cRp()
  {
    AppMethodBeat.i(220639);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = b.cRI().cRL();
    if (((List)localObject).size() > 0)
    {
      at localat = new at();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.expt.h.a locala = (com.tencent.mm.plugin.expt.h.a)((Iterator)localObject).next();
        if (locala != null)
        {
          akh localakh = new akh();
          localakh.Ltq = locala.sLf;
          localakh.Ltr = locala.adT;
          localakh.Lts = locala.sLg;
          localakh.Ltv = locala.sLk;
          localat.eqq = localakh.Ltq;
          localat.eqr = localakh.Lts;
          localat.enW = 1;
          localat.eOp();
          localLinkedList.add(localakh);
        }
      }
    }
    AppMethodBeat.o(220639);
    return localLinkedList;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(220637);
    this.callback = parami;
    try
    {
      parami = new d.a();
      parami.iLN = new bna();
      parami.iLO = new bnb();
      parami.uri = "/cgi-bin/mmfddataappsvr/getexptappconfig";
      parami.funcId = 1110;
      parami.iLP = 0;
      parami.respCmdId = 0;
      parami = parami.aXF();
      bna localbna = (bna)parami.iLK.iLR;
      localbna.Scene = this.iWD;
      localbna.LVB = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OgC, Integer.valueOf(0))).intValue();
      Object localObject = new ahd();
      ((ahd)localObject).ljQ = Build.MANUFACTURER;
      ((ahd)localObject).model = Build.MODEL;
      ((ahd)localObject).LqN = Build.VERSION.SDK_INT;
      ((ahd)localObject).LqO = Build.CPU_ABI;
      localbna.LVC = ((ahd)localObject);
      localbna.LVF = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OgD, ""));
      int j;
      int k;
      int m;
      int n;
      if (this.iWD == 3)
      {
        i = 0;
        localbna.LVE = i;
        if (com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.OgE, 0) == 1) {
          localbna.LVE = 0;
        }
        j = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OgF, Integer.valueOf(1))).intValue();
        if ((j == 1) || (localbna.LVE == 0)) {
          localbna.LVD = cRp();
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(863L, 155L, 1L, false);
        k = localbna.Scene;
        m = localbna.LVB;
        n = localbna.LVE;
        localObject = localbna.LVF;
        if (localbna.LVD == null) {
          break label422;
        }
      }
      label422:
      for (int i = localbna.LVD.size();; i = 0)
      {
        Log.i("MicroMsg.NetSceneGetExptApp", "get expt app scene[%d] lastGetSvrSec[%d] IsIncrement[%d] GlobalSequence[%s] nextReqNeedLocalList[%d] localExptList[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), localObject, Integer.valueOf(j), Integer.valueOf(i) });
        i = dispatch(paramg, parami, this);
        AppMethodBeat.o(220637);
        return i;
        i = 1;
        break;
      }
      return -1;
    }
    catch (Exception paramg)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneGetExptApp", paramg, "", new Object[0]);
      AppMethodBeat.o(220637);
    }
  }
  
  public final int getType()
  {
    return 1110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(220638);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (bnb)((d)params).iLL.iLR;
      if (paramArrayOfByte == null)
      {
        paramInt1 = 0;
        if (paramInt1 == 0) {
          break label338;
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(863L, 156L, 1L, false);
      }
    }
    for (;;)
    {
      a.cRk();
      a.mq(false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(220638);
      return;
      if (paramArrayOfByte.BaseResponse.Ret != 0)
      {
        paramInt1 = 0;
        break;
      }
      params = new ArrayList();
      if ((paramArrayOfByte.LVJ != null) && (paramArrayOfByte.LVJ.size() > 0))
      {
        Iterator localIterator = paramArrayOfByte.LVJ.iterator();
        while (localIterator.hasNext())
        {
          akh localakh = (akh)localIterator.next();
          com.tencent.mm.plugin.expt.h.a locala = new com.tencent.mm.plugin.expt.h.a();
          locala.TN(localakh.Ltt);
          params.add(locala);
        }
      }
      a.cRk();
      a.b(paramArrayOfByte.KHa, paramArrayOfByte.LVI, params);
      Hz(paramArrayOfByte.LVG);
      paramInt1 = paramArrayOfByte.LVH;
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgB, Integer.valueOf(paramInt1));
      int i = paramArrayOfByte.LVK;
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgF, Integer.valueOf(i));
      paramArrayOfByte = paramArrayOfByte.LVF;
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgD, paramArrayOfByte);
      Log.i("MicroMsg.NetSceneGetExptApp", "updateExpt interval[%d] nextReqNeedLocalList[%d] globalSeq[%s] updateList[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(params.size()) });
      paramInt1 = 1;
      break;
      label338:
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(863L, 157L, 1L, false);
      continue;
      Log.w("MicroMsg.NetSceneGetExptApp", "get expt error");
      Hz((int)Util.nowSecond());
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(863L, 157L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.c
 * JD-Core Version:    0.7.0.1
 */