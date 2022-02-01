package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ai
  extends n
  implements k
{
  private static AtomicInteger rty;
  private f callback;
  private final com.tencent.mm.al.b rr;
  private LinkedList<Integer> rtu;
  private int rtv;
  private boolean rtw;
  private boolean rtx;
  
  static
  {
    AppMethodBeat.i(103470);
    rty = new AtomicInteger(0);
    AppMethodBeat.o(103470);
  }
  
  public ai(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103463);
    this.callback = null;
    this.rtw = false;
    this.rtx = false;
    this.rtv = 0;
    b.a locala = new b.a();
    locala.hNM = new jz();
    locala.hNN = new ka();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.funcId = 402;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.rtu = paramLinkedList;
    rty.incrementAndGet();
    AppMethodBeat.o(103463);
  }
  
  private boolean cvv()
  {
    AppMethodBeat.i(103468);
    boolean bool1;
    if (bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.rtu == null) || (this.rtv >= this.rtu.size())) {
        break label97;
      }
    }
    label97:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
  
  public static void cvw()
  {
    AppMethodBeat.i(103464);
    rty.set(0);
    AppMethodBeat.o(103464);
  }
  
  public static void cvx()
  {
    AppMethodBeat.i(103465);
    rty.decrementAndGet();
    AppMethodBeat.o(103465);
  }
  
  public static int cvy()
  {
    AppMethodBeat.i(103466);
    int i = rty.get();
    AppMethodBeat.o(103466);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103467);
    ad.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(rty.get()) });
    if ((this.rtu == null) || (this.rtu.isEmpty()) || (this.rtv >= this.rtu.size()))
    {
      ad.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.rtv) });
      AppMethodBeat.o(103467);
      return -1;
    }
    ad.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.rtu.size()), Integer.valueOf(this.rtv), this.rtu });
    if (bt.n((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(8217, null)) == 0)
    {
      ad.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      AppMethodBeat.o(103467);
      return -1;
    }
    jz localjz = (jz)this.rr.hNK.hNQ;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.rtu.subList(this.rtv, Math.min(this.rtv + 15, this.rtu.size())));
    localjz.FCj = localLinkedList;
    localjz.nDi = localLinkedList.size();
    this.rtv += 15;
    ad.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList });
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103467);
    return i;
  }
  
  public final int getType()
  {
    return 402;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103469);
    ad.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.rtv), Integer.valueOf(this.rtu.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cvv())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      rty.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramq = (ka)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    int i = paramq.nDi;
    int j = paramq.FCD.size();
    if (i != j)
    {
      if (this.rtv > this.rtu.size()) {}
      for (paramInt1 = this.rtu.size() % 15;; paramInt1 = 15)
      {
        ad.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!cvv()) {
          break;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      rty.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (ajy)paramq.FCD.get(paramInt1);
      ad.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.FuW), Integer.valueOf(paramArrayOfByte.nDG) });
      g localg;
      if (paramArrayOfByte.nDG == 0)
      {
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(paramArrayOfByte.FuW);
        if (localg == null)
        {
          ad.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.FuW) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.Fvc;
        localg.agl(paramArrayOfByte.Fvc);
        localg.field_flag = paramArrayOfByte.FuX;
        localg.field_localSeq = paramArrayOfByte.FuZ;
        localg.field_updateTime = (paramArrayOfByte.FuY * 1000L + paramInt1);
        ad.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.nZa.size();
        if (i != 0) {
          break label707;
        }
        ad.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        ad.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.rtx), Boolean.valueOf(this.rtw) });
        if (!this.rtx) {
          break label1128;
        }
        localg.field_itemStatus = 15;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.agm("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.FuX & 0x1) == 0) {
          break;
        }
        ad.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.FuW) });
        b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vF(paramArrayOfByte.FuW), null);
        break;
        label707:
        LinkedList localLinkedList = localg.field_favProto.nZa;
        i -= 1;
        label723:
        ajn localajn;
        if (i >= 0)
        {
          localajn = (ajn)localLinkedList.get(i);
          if (!bt.isNullOrNil(localajn.Ghi))
          {
            com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(b.d(localajn));
            ad.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { locale.getName() });
            if (locale.exists()) {
              break label971;
            }
            if ((!bt.isNullOrNil(localajn.GgT)) && (!bt.isNullOrNil(localajn.GgR))) {
              break label923;
            }
            ad.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label840:
          if (!bt.isNullOrNil(localajn.Ght))
          {
            if (new com.tencent.mm.vfs.e(b.a(localajn)).exists()) {
              break label1094;
            }
            if ((!bt.isNullOrNil(localajn.GgN)) && (!bt.isNullOrNil(localajn.hAe))) {
              break label1047;
            }
            ad.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break label723;
          break;
          label923:
          ad.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localajn, localg, 1, false);
          this.rtw = true;
          break label840;
          label971:
          if (localajn.GhH != 0)
          {
            ad.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localajn.Ghi });
            this.rtx = true;
            b.a(localajn, localg, 0, false);
          }
          ad.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label840;
          label1047:
          ad.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localajn, localg, 1);
          this.rtw = true;
          continue;
          label1094:
          ad.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1128:
        if (this.rtw)
        {
          localg.field_itemStatus = 10;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
        else
        {
          localg.field_itemStatus = 10;
          ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
      }
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
    if (cvv())
    {
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(103469);
      return;
    }
    rty.decrementAndGet();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103469);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */