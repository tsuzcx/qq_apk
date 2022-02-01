package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class aj
  extends com.tencent.mm.an.q
  implements m
{
  private static AtomicInteger wHu;
  private i callback;
  private final d rr;
  private LinkedList<Integer> wHq;
  private int wHr;
  private boolean wHs;
  private boolean wHt;
  
  static
  {
    AppMethodBeat.i(103470);
    wHu = new AtomicInteger(0);
    AppMethodBeat.o(103470);
  }
  
  public aj(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103463);
    this.callback = null;
    this.wHs = false;
    this.wHt = false;
    this.wHr = 0;
    d.a locala = new d.a();
    locala.lBU = new ke();
    locala.lBV = new kf();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.funcId = 402;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.wHq = paramLinkedList;
    wHu.incrementAndGet();
    AppMethodBeat.o(103463);
  }
  
  private boolean dkg()
  {
    AppMethodBeat.i(103468);
    boolean bool1;
    if (Util.nullAsNil((Integer)h.aHG().aHp().b(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.wHq == null) || (this.wHr >= this.wHq.size())) {
        break label97;
      }
    }
    label97:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (!bool2)) {
        break label102;
      }
      AppMethodBeat.o(103468);
      return true;
      bool1 = false;
      break;
    }
    label102:
    AppMethodBeat.o(103468);
    return false;
  }
  
  public static void dkh()
  {
    AppMethodBeat.i(103464);
    wHu.set(0);
    AppMethodBeat.o(103464);
  }
  
  public static void dki()
  {
    AppMethodBeat.i(103465);
    wHu.decrementAndGet();
    AppMethodBeat.o(103465);
  }
  
  public static int dkj()
  {
    AppMethodBeat.i(103466);
    int i = wHu.get();
    AppMethodBeat.o(103466);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(103467);
    Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(wHu.get()) });
    if ((this.wHq == null) || (this.wHq.isEmpty()) || (this.wHr >= this.wHq.size()))
    {
      Log.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.wHr) });
      AppMethodBeat.o(103467);
      return -1;
    }
    Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.wHq.size()), Integer.valueOf(this.wHr), this.wHq });
    if (Util.nullAsNil((Integer)h.aHG().aHp().b(8217, null)) == 0)
    {
      Log.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      AppMethodBeat.o(103467);
      return -1;
    }
    ke localke = (ke)d.b.b(this.rr.lBR);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.wHq.subList(this.wHr, Math.min(this.wHr + 15, this.wHq.size())));
    localke.RPj = localLinkedList;
    localke.rVx = localLinkedList.size();
    this.wHr += 15;
    Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList });
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103467);
    return i;
  }
  
  public final int getType()
  {
    return 402;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103469);
    Log.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.wHr), Integer.valueOf(this.wHq.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (dkg())
      {
        paramInt1 = doScene(dispatcher(), this.callback);
        if (paramInt1 != 0)
        {
          Log.i("MicroMsg.NetSceneBatchgetFav", "doScene ret:%s, minus sceneCount, cur:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(wHu.get()) });
          wHu.decrementAndGet();
        }
        AppMethodBeat.o(103469);
        return;
      }
      wHu.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    params = (kf)d.c.b(((d)params).lBS);
    int i = params.rVx;
    int j = params.RPF.size();
    if (i != j)
    {
      if (this.wHr > this.wHq.size()) {}
      for (paramInt1 = this.wHq.size() % 15;; paramInt1 = 15)
      {
        Log.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!dkg()) {
          break;
        }
        paramInt1 = doScene(dispatcher(), this.callback);
        if (paramInt1 != 0)
        {
          Log.i("MicroMsg.NetSceneBatchgetFav", "doScene ret:%s, minus sceneCount, cur:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(wHu.get()) });
          wHu.decrementAndGet();
        }
        AppMethodBeat.o(103469);
        return;
      }
      wHu.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (anx)params.RPF.get(paramInt1);
      Log.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.RIr), Integer.valueOf(paramArrayOfByte.rVU) });
      g localg;
      if (paramArrayOfByte.rVU == 0)
      {
        localg = ((ag)h.ag(ag.class)).getFavItemInfoStorage().Kn(paramArrayOfByte.RIr);
        if (localg == null)
        {
          Log.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.RIr) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.RIx;
        localg.azR(paramArrayOfByte.RIx);
        localg.field_flag = paramArrayOfByte.RIs;
        localg.field_localSeq = paramArrayOfByte.RIu;
        localg.field_updateTime = (paramArrayOfByte.RIt * 1000L + paramInt1);
        Log.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.syG.size();
        if (i != 0) {
          break label789;
        }
        Log.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        Log.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.wHt), Boolean.valueOf(this.wHs) });
        if (!this.wHt) {
          break label1210;
        }
        localg.field_itemStatus = 15;
        ((ag)h.ag(ag.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((ag)h.ag(ag.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.azS("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.RIs & 0x1) == 0) {
          break;
        }
        Log.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.RIr) });
        b.a(((ag)h.ag(ag.class)).getFavItemInfoStorage().Kn(paramArrayOfByte.RIr), null);
        break;
        label789:
        LinkedList localLinkedList = localg.field_favProto.syG;
        i -= 1;
        label805:
        anm localanm;
        if (i >= 0)
        {
          localanm = (anm)localLinkedList.get(i);
          if (!Util.isNullOrNil(localanm.Sye))
          {
            com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(b.d(localanm));
            Log.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { localq.getName() });
            if (localq.ifE()) {
              break label1053;
            }
            if ((!Util.isNullOrNil(localanm.SxP)) && (!Util.isNullOrNil(localanm.Rwb))) {
              break label1005;
            }
            Log.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label922:
          if (!Util.isNullOrNil(localanm.Kll))
          {
            if (new com.tencent.mm.vfs.q(b.a(localanm)).ifE()) {
              break label1176;
            }
            if ((!Util.isNullOrNil(localanm.SxK)) && (!Util.isNullOrNil(localanm.lmm))) {
              break label1129;
            }
            Log.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break label805;
          break;
          label1005:
          Log.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localanm, localg, 1, false);
          this.wHs = true;
          break label922;
          label1053:
          if (localanm.SyC != 0)
          {
            Log.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localanm.Sye });
            this.wHt = true;
            b.a(localanm, localg, 0, false);
          }
          Log.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label922;
          label1129:
          Log.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localanm, localg, 1);
          this.wHs = true;
          continue;
          label1176:
          Log.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1210:
        if (this.wHs)
        {
          localg.field_itemStatus = 10;
          ((ag)h.ag(ag.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
        else
        {
          localg.field_itemStatus = 10;
          ((ag)h.ag(ag.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
      }
    }
    ((ag)h.ag(ag.class)).getFavCdnService().run();
    if (dkg())
    {
      paramInt1 = doScene(dispatcher(), this.callback);
      if (paramInt1 != 0)
      {
        Log.i("MicroMsg.NetSceneBatchgetFav", "doScene ret:%s, minus sceneCount, cur:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(wHu.get()) });
        wHu.decrementAndGet();
      }
      AppMethodBeat.o(103469);
      return;
    }
    wHu.decrementAndGet();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103469);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aj
 * JD-Core Version:    0.7.0.1
 */