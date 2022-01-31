package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.il;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ah
  extends m
  implements k
{
  private static AtomicInteger mui;
  private f callback;
  private LinkedList<Integer> mue;
  private int muf;
  private boolean mug;
  private boolean muh;
  private final com.tencent.mm.ai.b rr;
  
  static
  {
    AppMethodBeat.i(102730);
    mui = new AtomicInteger(0);
    AppMethodBeat.o(102730);
  }
  
  public ah(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(102723);
    this.callback = null;
    this.mug = false;
    this.muh = false;
    this.muf = 0;
    b.a locala = new b.a();
    locala.fsX = new il();
    locala.fsY = new im();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.funcId = 402;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.mue = paramLinkedList;
    mui.incrementAndGet();
    AppMethodBeat.o(102723);
  }
  
  private boolean bwT()
  {
    AppMethodBeat.i(102728);
    boolean bool1;
    if (bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.mue == null) || (this.muf >= this.mue.size())) {
        break label97;
      }
    }
    label97:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (!bool2)) {
        break label102;
      }
      AppMethodBeat.o(102728);
      return true;
      bool1 = false;
      break;
    }
    label102:
    AppMethodBeat.o(102728);
    return false;
  }
  
  public static void bwU()
  {
    AppMethodBeat.i(102724);
    mui.set(0);
    AppMethodBeat.o(102724);
  }
  
  public static void bwV()
  {
    AppMethodBeat.i(102725);
    mui.decrementAndGet();
    AppMethodBeat.o(102725);
  }
  
  public static int bwW()
  {
    AppMethodBeat.i(102726);
    int i = mui.get();
    AppMethodBeat.o(102726);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(102727);
    ab.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(mui.get()) });
    if ((this.mue == null) || (this.mue.isEmpty()) || (this.muf >= this.mue.size()))
    {
      ab.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.muf) });
      AppMethodBeat.o(102727);
      return -1;
    }
    ab.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.mue.size()), Integer.valueOf(this.muf), this.mue });
    if (bo.g((Integer)com.tencent.mm.kernel.g.RL().Ru().get(8217, null)) == 0)
    {
      ab.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      AppMethodBeat.o(102727);
      return -1;
    }
    il localil = (il)this.rr.fsV.fta;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.mue.subList(this.muf, Math.min(this.muf + 15, this.mue.size())));
    localil.wuv = localLinkedList;
    localil.jJu = localLinkedList.size();
    this.muf += 15;
    ab.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(102727);
    return i;
  }
  
  public final int getType()
  {
    return 402;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102729);
    ab.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.muf), Integer.valueOf(this.mue.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (bwT())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(102729);
        return;
      }
      mui.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(102729);
      return;
    }
    paramq = (im)((com.tencent.mm.ai.b)paramq).fsW.fta;
    int i = paramq.jJu;
    int j = paramq.wuP.size();
    if (i != j)
    {
      if (this.muf > this.mue.size()) {}
      for (paramInt1 = this.mue.size() % 15;; paramInt1 = 15)
      {
        ab.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!bwT()) {
          break;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(102729);
        return;
      }
      mui.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(102729);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (acl)paramq.wuP.get(paramInt1);
      ab.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.woD), Integer.valueOf(paramArrayOfByte.jJS) });
      g localg;
      if (paramArrayOfByte.jJS == 0)
      {
        localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(paramArrayOfByte.woD);
        if (localg == null)
        {
          ab.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.woD) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.woJ;
        localg.NF(paramArrayOfByte.woJ);
        localg.field_flag = paramArrayOfByte.woE;
        localg.field_localSeq = paramArrayOfByte.woG;
        localg.field_updateTime = (paramArrayOfByte.woF * 1000L + paramInt1);
        ab.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.wVc.size();
        if (i != 0) {
          break label706;
        }
        ab.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        ab.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.muh), Boolean.valueOf(this.mug) });
        if (!this.muh) {
          break label1127;
        }
        localg.field_itemStatus = 15;
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.NG("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.woE & 0x1) == 0) {
          break;
        }
        ab.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.woD) });
        b.i(((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(paramArrayOfByte.woD));
        break;
        label706:
        LinkedList localLinkedList = localg.field_favProto.wVc;
        i -= 1;
        label722:
        aca localaca;
        if (i >= 0)
        {
          localaca = (aca)localLinkedList.get(i);
          if (!bo.isNullOrNil(localaca.wST))
          {
            com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(b.b(localaca));
            ab.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { localb.getName() });
            if (localb.exists()) {
              break label970;
            }
            if ((!bo.isNullOrNil(localaca.wSE)) && (!bo.isNullOrNil(localaca.wSC))) {
              break label922;
            }
            ab.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label839:
          if (!bo.isNullOrNil(localaca.wTe))
          {
            if (new com.tencent.mm.vfs.b(b.c(localaca)).exists()) {
              break label1093;
            }
            if ((!bo.isNullOrNil(localaca.wSy)) && (!bo.isNullOrNil(localaca.fgM))) {
              break label1046;
            }
            ab.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break label722;
          break;
          label922:
          ab.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localaca, localg, 1, false);
          this.mug = true;
          break label839;
          label970:
          if (localaca.wTs != 0)
          {
            ab.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localaca.wST });
            this.muh = true;
            b.a(localaca, localg, 0, false);
          }
          ab.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label839;
          label1046:
          ab.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localaca, localg, 1);
          this.mug = true;
          continue;
          label1093:
          ab.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1127:
        if (this.mug)
        {
          localg.field_itemStatus = 10;
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
        else
        {
          localg.field_itemStatus = 10;
          ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
      }
    }
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavCdnService().run();
    if (bwT())
    {
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(102729);
      return;
    }
    mui.decrementAndGet();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(102729);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ah
 * JD-Core Version:    0.7.0.1
 */