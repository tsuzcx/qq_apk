package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.ye;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah
  extends m
  implements k
{
  private static AtomicInteger jZL = new AtomicInteger(0);
  private final com.tencent.mm.ah.b dmK;
  private f dmL = null;
  private LinkedList<Integer> jZH;
  private int jZI = 0;
  private boolean jZJ = false;
  private boolean jZK = false;
  
  public ah(LinkedList<Integer> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new gu();
    locala.ecI = new gv();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.ecG = 402;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.jZH = paramLinkedList;
    jZL.incrementAndGet();
  }
  
  private boolean aQE()
  {
    boolean bool1;
    if (bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.jZH == null) || (this.jZI >= this.jZH.size())) {
        break label87;
      }
    }
    label87:
    for (boolean bool2 = true;; bool2 = false)
    {
      y.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (!bool2)) {
        break label92;
      }
      return true;
      bool1 = false;
      break;
    }
    label92:
    return false;
  }
  
  public static void aQF()
  {
    jZL.set(0);
  }
  
  public static void aQG()
  {
    jZL.decrementAndGet();
  }
  
  public static int aQH()
  {
    return jZL.get();
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(jZL.get()) });
    if ((this.jZH == null) || (this.jZH.isEmpty()) || (this.jZI >= this.jZH.size()))
    {
      y.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.jZI) });
      return -1;
    }
    y.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.jZH.size()), Integer.valueOf(this.jZI), this.jZH });
    if (bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(8217, null)) == 0)
    {
      y.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      return -1;
    }
    gu localgu = (gu)this.dmK.ecE.ecN;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.jZH.subList(this.jZI, Math.min(this.jZI + 15, this.jZH.size())));
    localgu.sAq = localLinkedList;
    localgu.hPS = localLinkedList.size();
    this.jZI += 15;
    y.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList });
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.jZI), Integer.valueOf(this.jZH.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (aQE())
      {
        a(this.edc, this.dmL);
        return;
      }
      jZL.decrementAndGet();
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (gv)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    int i = paramq.hPS;
    int j = paramq.sAA.size();
    if (i != j)
    {
      if (this.jZI > this.jZH.size()) {}
      for (paramInt1 = this.jZH.size() % 15;; paramInt1 = 15)
      {
        y.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!aQE()) {
          break;
        }
        a(this.edc, this.dmL);
        return;
      }
      jZL.decrementAndGet();
      this.dmL.onSceneEnd(paramInt2, -1, paramString, this);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (ye)paramq.sAA.get(paramInt1);
      y.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.svw), Integer.valueOf(paramArrayOfByte.hQq) });
      g localg;
      if (paramArrayOfByte.hQq == 0)
      {
        localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(paramArrayOfByte.svw);
        if (localg == null)
        {
          y.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.svw) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.svC;
        localg.CD(paramArrayOfByte.svC);
        localg.field_flag = paramArrayOfByte.svx;
        localg.field_localSeq = paramArrayOfByte.svz;
        localg.field_updateTime = (paramArrayOfByte.svy * 1000L + paramInt1);
        y.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.sXc.size();
        if (i != 0) {
          break label675;
        }
        y.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        y.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.jZK), Boolean.valueOf(this.jZJ) });
        if (!this.jZK) {
          break label1096;
        }
        localg.field_itemStatus = 15;
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.CE("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.svx & 0x1) == 0) {
          break;
        }
        y.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.svw) });
        b.i(((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(paramArrayOfByte.svw));
        break;
        label675:
        LinkedList localLinkedList = localg.field_favProto.sXc;
        i -= 1;
        label691:
        xv localxv;
        if (i >= 0)
        {
          localxv = (xv)localLinkedList.get(i);
          if (!bk.bl(localxv.sUX))
          {
            com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(b.b(localxv));
            y.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { localb.getName() });
            if (localb.exists()) {
              break label939;
            }
            if ((!bk.bl(localxv.sUI)) && (!bk.bl(localxv.sUG))) {
              break label891;
            }
            y.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label808:
          if (!bk.bl(localxv.sVi))
          {
            if (new com.tencent.mm.vfs.b(b.c(localxv)).exists()) {
              break label1062;
            }
            if ((!bk.bl(localxv.sUC)) && (!bk.bl(localxv.dQL))) {
              break label1015;
            }
            y.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break label691;
          break;
          label891:
          y.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localxv, localg, 1, false);
          this.jZJ = true;
          break label808;
          label939:
          if (localxv.sVw != 0)
          {
            y.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localxv.sUX });
            this.jZK = true;
            b.a(localxv, localg, 0, false);
          }
          y.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label808;
          label1015:
          y.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localxv, localg, 1);
          this.jZJ = true;
          continue;
          label1062:
          y.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1096:
        if (this.jZJ)
        {
          localg.field_itemStatus = 10;
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
        else
        {
          localg.field_itemStatus = 10;
          ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
      }
    }
    ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavCdnService().run();
    if (aQE())
    {
      a(this.edc, this.dmL);
      return;
    }
    jZL.decrementAndGet();
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 402;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */