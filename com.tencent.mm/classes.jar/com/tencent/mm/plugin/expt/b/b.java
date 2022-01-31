package com.tencent.mm.plugin.expt.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.expt.c.c;
import com.tencent.mm.plugin.expt.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.afn;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends m
  implements k
{
  private f dmL;
  private int jIr = 0;
  
  private static void qC(int paramInt)
  {
    int i = (int)bk.UX();
    if (i > paramInt)
    {
      g.DP().Dz().c(ac.a.uzn, Integer.valueOf(i));
      return;
    }
    g.DP().Dz().c(ac.a.uzn, Integer.valueOf(paramInt));
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    int i = 0;
    this.dmL = paramf;
    long l = bk.UZ();
    paramf = new b.a();
    paramf.ecH = new afn();
    paramf.ecI = new afo();
    paramf.uri = "/cgi-bin/mmexptappsvr-bin/getexptconfig";
    paramf.ecG = 2738;
    paramf.ecJ = 0;
    paramf.ecK = 0;
    paramf = paramf.Kt();
    afn localafn = (afn)paramf.ecE.ecN;
    localafn.pyo = this.jIr;
    localafn.tds = ((Integer)g.DP().Dz().get(ac.a.uzn, Integer.valueOf(0))).intValue();
    List localList = a.aMZ().jIi.aNl();
    if ((localList != null) && (localList.size() > 0))
    {
      localafn.tdt = new LinkedList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.expt.c.a locala = (com.tencent.mm.plugin.expt.c.a)localIterator.next();
        wj localwj = new wj();
        localwj.sTi = locala.field_exptId;
        localwj.sTj = locala.field_groupId;
        localwj.sTk = locala.field_exptSeq;
        localafn.tdt.add(localwj);
      }
      y.i("MicroMsg.NetSceneGetExpt", "req local exptList [%s] ", new Object[] { Arrays.toString(localList.toArray()) });
    }
    h.nFQ.a(863L, 0L, 1L, false);
    int j = localafn.pyo;
    int k = localafn.tds;
    if (localafn.tdt != null) {
      i = localafn.tdt.size();
    }
    y.i("MicroMsg.NetSceneGetExpt", "get expt config scene[%d] lastGetSvrSec[%d] localExptList[%d] cost[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(bk.cp(l)) });
    return a(parame, paramf, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetExpt", "get expt on gy end. errType[%d] erroCode[%d] errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    long l1;
    int m;
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (afo)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      if (paramq != null)
      {
        if (paramq.tFx.sze != 0)
        {
          y.w("MicroMsg.NetSceneGetExpt", "get expt error. resp baseResp [%d] [%s]", new Object[] { Integer.valueOf(paramq.tFx.sze), paramq.tFx.sAn });
          h.nFQ.a(863L, 2L, 1L, false);
        }
      }
      else
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      l1 = bk.UZ();
      qC(paramq.tdu);
      m = paramq.tdv;
      g.DP().Dz().c(ac.a.uzm, Integer.valueOf(m));
      if (paramq.tdy == 1)
      {
        h.nFQ.a(863L, 7L, 1L, false);
        long l2 = bk.UZ();
        paramArrayOfByte = a.aMZ();
        paramInt1 = paramArrayOfByte.jIi.aNk();
        y.i("MicroMsg.ExptService", "delete all expt count[%d] map count[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramArrayOfByte.jIj.aNk()) });
        paramArrayOfByte.aMY();
        y.i("MicroMsg.NetSceneGetExpt", "check need del all expt count[%d] cost[%d]", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(bk.cp(l2)) });
        j = 1;
        paramArrayOfByte = paramq.tdw;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
          break label815;
        }
        y.i("MicroMsg.NetSceneGetExpt", "delete expt [%s]", new Object[] { Arrays.toString(paramArrayOfByte.toArray()) });
      }
    }
    label667:
    label815:
    for (paramInt1 = a.aMZ().bh(paramArrayOfByte);; paramInt1 = 0)
    {
      LinkedList localLinkedList1 = paramq.tdx;
      LinkedList localLinkedList2;
      if ((localLinkedList1 != null) && (localLinkedList1.size() > 0))
      {
        localLinkedList2 = new LinkedList();
        Iterator localIterator = localLinkedList1.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            wj localwj = (wj)localIterator.next();
            com.tencent.mm.plugin.expt.c.a locala = new com.tencent.mm.plugin.expt.c.a();
            locala.BX(localwj.sTl);
            if ((locala.field_exptId != localwj.sTi) || (locala.field_groupId != localwj.sTj) || (locala.field_exptSeq != localwj.sTk))
            {
              y.w("MicroMsg.NetSceneGetExpt", "expt item proto[%d %d %d] is different expt content[%d %d %d]", new Object[] { Integer.valueOf(localwj.sTi), Integer.valueOf(localwj.sTj), Integer.valueOf(localwj.sTk), Integer.valueOf(locala.field_exptId), Integer.valueOf(locala.field_groupId), Integer.valueOf(locala.field_exptSeq) });
              h.nFQ.a(863L, 6L, 1L, false);
            }
            localLinkedList2.add(locala);
            y.i("MicroMsg.NetSceneGetExpt", "get expt item [%s]", new Object[] { locala.toString() });
            continue;
            j = 0;
            break;
          }
        }
      }
      for (int i = a.aMZ().bg(localLinkedList2);; i = 0)
      {
        if ((j != 0) || (paramInt1 > 0) || (i > 0))
        {
          a.aMZ();
          a.aNa();
        }
        h.nFQ.a(863L, 1L, 1L, false);
        int n = paramq.tdu;
        int i1 = paramq.tdy;
        if (paramArrayOfByte != null)
        {
          j = paramArrayOfByte.size();
          if (localLinkedList1 == null) {
            break label771;
          }
        }
        for (int k = localLinkedList1.size();; k = 0)
        {
          y.i("MicroMsg.NetSceneGetExpt", "update expt svrTime:%d interval:%d exptFlag:%d  deleteCount:[svr:%d local:%d] replaceCount:[svr:%d local:%d] cost[%d]", new Object[] { Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(i1), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(k), Integer.valueOf(i), Long.valueOf(bk.cp(l1)) });
          break;
          j = 0;
          break label667;
        }
        h.nFQ.a(863L, 2L, 1L, false);
        y.w("MicroMsg.NetSceneGetExpt", "get expt error");
        qC((int)bk.UX());
        break;
      }
    }
  }
  
  public final int getType()
  {
    return 2738;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.b
 * JD-Core Version:    0.7.0.1
 */