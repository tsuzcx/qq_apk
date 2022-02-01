package com.tencent.mm.plugin.expt.f;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.aa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private f callback;
  private int hYN = 0;
  
  public c(int paramInt)
  {
    this.hYN = paramInt;
  }
  
  private static void Dz(int paramInt)
  {
    AppMethodBeat.i(210540);
    int i = (int)bt.aQJ();
    if (i > paramInt)
    {
      g.ajC().ajl().set(al.a.IDF, Integer.valueOf(i));
      AppMethodBeat.o(210540);
      return;
    }
    g.ajC().ajl().set(al.a.IDF, Integer.valueOf(paramInt));
    AppMethodBeat.o(210540);
  }
  
  private static LinkedList<ahl> crg()
  {
    AppMethodBeat.i(210539);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = com.tencent.mm.plugin.expt.h.b.crz().crC();
    if (((List)localObject).size() > 0)
    {
      aa localaa = new aa();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.expt.h.a locala = (com.tencent.mm.plugin.expt.h.a)((Iterator)localObject).next();
        if (locala != null)
        {
          ahl localahl = new ahl();
          localahl.GeZ = locala.rbx;
          localahl.Gfa = locala.adG;
          localahl.Gfb = locala.rby;
          localahl.Gfe = locala.rbC;
          localaa.dUH = localahl.GeZ;
          localaa.dUI = localahl.Gfb;
          localaa.dSI = 1;
          localaa.dJX();
          localLinkedList.add(localahl);
        }
      }
    }
    AppMethodBeat.o(210539);
    return localLinkedList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(210537);
    this.callback = paramf;
    try
    {
      paramf = new b.a();
      paramf.hNM = new bay();
      paramf.hNN = new baz();
      paramf.uri = "/cgi-bin/mmfddataappsvr/getexptappconfig";
      paramf.funcId = 1110;
      paramf.hNO = 0;
      paramf.respCmdId = 0;
      paramf = paramf.aDC();
      bay localbay = (bay)paramf.hNK.hNQ;
      localbay.Scene = this.hYN;
      localbay.GxW = ((Integer)g.ajC().ajl().get(al.a.IDF, Integer.valueOf(0))).intValue();
      Object localObject = new aeq();
      ((aeq)localObject).kcQ = Build.MANUFACTURER;
      ((aeq)localObject).model = Build.MODEL;
      ((aeq)localObject).GcB = Build.VERSION.SDK_INT;
      ((aeq)localObject).GcC = Build.CPU_ABI;
      localbay.GxX = ((aeq)localObject);
      localbay.Gya = ((String)g.ajC().ajl().get(al.a.IDG, ""));
      int j;
      int k;
      int m;
      int n;
      if (this.hYN == 3)
      {
        i = 0;
        localbay.GxZ = i;
        if (g.ajC().ajl().getInt(al.a.IDH, 0) == 1) {
          localbay.GxZ = 0;
        }
        j = ((Integer)g.ajC().ajl().get(al.a.IDI, Integer.valueOf(1))).intValue();
        if ((j == 1) || (localbay.GxZ == 0)) {
          localbay.GxY = crg();
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(863L, 155L, 1L, false);
        k = localbay.Scene;
        m = localbay.GxW;
        n = localbay.GxZ;
        localObject = localbay.Gya;
        if (localbay.GxY == null) {
          break label422;
        }
      }
      label422:
      for (int i = localbay.GxY.size();; i = 0)
      {
        ad.i("MicroMsg.NetSceneGetExptApp", "get expt app scene[%d] lastGetSvrSec[%d] IsIncrement[%d] GlobalSequence[%s] nextReqNeedLocalList[%d] localExptList[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), localObject, Integer.valueOf(j), Integer.valueOf(i) });
        i = dispatch(parame, paramf, this);
        AppMethodBeat.o(210537);
        return i;
        i = 1;
        break;
      }
      return -1;
    }
    catch (Exception parame)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneGetExptApp", parame, "", new Object[0]);
      AppMethodBeat.o(210537);
    }
  }
  
  public final int getType()
  {
    return 1110;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210538);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (baz)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      if (paramArrayOfByte == null)
      {
        paramInt1 = 0;
        if (paramInt1 == 0) {
          break label338;
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(863L, 156L, 1L, false);
      }
    }
    for (;;)
    {
      a.cqZ();
      a.li(false);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(210538);
      return;
      if (paramArrayOfByte.BaseResponse.Ret != 0)
      {
        paramInt1 = 0;
        break;
      }
      paramq = new ArrayList();
      if ((paramArrayOfByte.Gye != null) && (paramArrayOfByte.Gye.size() > 0))
      {
        Iterator localIterator = paramArrayOfByte.Gye.iterator();
        while (localIterator.hasNext())
        {
          ahl localahl = (ahl)localIterator.next();
          com.tencent.mm.plugin.expt.h.a locala = new com.tencent.mm.plugin.expt.h.a();
          locala.afB(localahl.Gfc);
          paramq.add(locala);
        }
      }
      a.cqZ();
      a.c(paramArrayOfByte.FuX, paramArrayOfByte.Gyd, paramq);
      Dz(paramArrayOfByte.Gyb);
      paramInt1 = paramArrayOfByte.Gyc;
      g.ajC().ajl().set(al.a.IDE, Integer.valueOf(paramInt1));
      int i = paramArrayOfByte.Gyf;
      g.ajC().ajl().set(al.a.IDI, Integer.valueOf(i));
      paramArrayOfByte = paramArrayOfByte.Gya;
      g.ajC().ajl().set(al.a.IDG, paramArrayOfByte);
      ad.i("MicroMsg.NetSceneGetExptApp", "updateExpt interval[%d] nextReqNeedLocalList[%d] globalSeq[%s] updateList[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), paramArrayOfByte, Integer.valueOf(paramq.size()) });
      paramInt1 = 1;
      break;
      label338:
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(863L, 157L, 1L, false);
      continue;
      ad.w("MicroMsg.NetSceneGetExptApp", "get expt error");
      Dz((int)bt.aQJ());
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(863L, 157L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.f.c
 * JD-Core Version:    0.7.0.1
 */