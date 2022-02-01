package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ai
  extends n
  implements k
{
  private static AtomicInteger qaQ;
  private com.tencent.mm.al.g callback;
  private LinkedList<Integer> qaM;
  private int qaN;
  private boolean qaO;
  private boolean qaP;
  private final com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(103470);
    qaQ = new AtomicInteger(0);
    AppMethodBeat.o(103470);
  }
  
  public ai(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103463);
    this.callback = null;
    this.qaO = false;
    this.qaP = false;
    this.qaN = 0;
    b.a locala = new b.a();
    locala.gUU = new jk();
    locala.gUV = new jl();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.funcId = 402;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.qaM = paramLinkedList;
    qaQ.incrementAndGet();
    AppMethodBeat.o(103463);
  }
  
  private boolean cij()
  {
    AppMethodBeat.i(103468);
    boolean bool1;
    if (bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.qaM == null) || (this.qaN >= this.qaM.size())) {
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
  
  public static void cik()
  {
    AppMethodBeat.i(103464);
    qaQ.set(0);
    AppMethodBeat.o(103464);
  }
  
  public static void cil()
  {
    AppMethodBeat.i(103465);
    qaQ.decrementAndGet();
    AppMethodBeat.o(103465);
  }
  
  public static int cim()
  {
    AppMethodBeat.i(103466);
    int i = qaQ.get();
    AppMethodBeat.o(103466);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(103467);
    ad.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(qaQ.get()) });
    if ((this.qaM == null) || (this.qaM.isEmpty()) || (this.qaN >= this.qaM.size()))
    {
      ad.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.qaN) });
      AppMethodBeat.o(103467);
      return -1;
    }
    ad.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.qaM.size()), Integer.valueOf(this.qaN), this.qaM });
    if (bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(8217, null)) == 0)
    {
      ad.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      AppMethodBeat.o(103467);
      return -1;
    }
    jk localjk = (jk)this.rr.gUS.gUX;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.qaM.subList(this.qaN, Math.min(this.qaN + 15, this.qaM.size())));
    localjk.CEn = localLinkedList;
    localjk.mAK = localLinkedList.size();
    this.qaN += 15;
    ad.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList });
    this.callback = paramg;
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
    ad.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.qaN), Integer.valueOf(this.qaM.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cij())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      qaQ.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramq = (jl)((com.tencent.mm.al.b)paramq).gUT.gUX;
    int i = paramq.mAK;
    int j = paramq.CEH.size();
    if (i != j)
    {
      if (this.qaN > this.qaM.size()) {}
      for (paramInt1 = this.qaM.size() % 15;; paramInt1 = 15)
      {
        ad.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!cij()) {
          break;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      qaQ.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (agj)paramq.CEH.get(paramInt1);
      ad.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.Cxl), Integer.valueOf(paramArrayOfByte.mBi) });
      g localg;
      if (paramArrayOfByte.mBi == 0)
      {
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(paramArrayOfByte.Cxl);
        if (localg == null)
        {
          ad.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.Cxl) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.Cxr;
        localg.Ya(paramArrayOfByte.Cxr);
        localg.field_flag = paramArrayOfByte.Cxm;
        localg.field_localSeq = paramArrayOfByte.Cxo;
        localg.field_updateTime = (paramArrayOfByte.Cxn * 1000L + paramInt1);
        ad.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.mVb.size();
        if (i != 0) {
          break label707;
        }
        ad.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        ad.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.qaP), Boolean.valueOf(this.qaO) });
        if (!this.qaP) {
          break label1128;
        }
        localg.field_itemStatus = 15;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.Yb("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.Cxm & 0x1) == 0) {
          break;
        }
        ad.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.Cxl) });
        b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(paramArrayOfByte.Cxl), null);
        break;
        label707:
        LinkedList localLinkedList = localg.field_favProto.mVb;
        i -= 1;
        label723:
        afy localafy;
        if (i >= 0)
        {
          localafy = (afy)localLinkedList.get(i);
          if (!bt.isNullOrNil(localafy.Dgq))
          {
            com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(b.d(localafy));
            ad.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { locale.getName() });
            if (locale.exists()) {
              break label971;
            }
            if ((!bt.isNullOrNil(localafy.Dgb)) && (!bt.isNullOrNil(localafy.DfZ))) {
              break label923;
            }
            ad.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label840:
          if (!bt.isNullOrNil(localafy.DgB))
          {
            if (new com.tencent.mm.vfs.e(b.a(localafy)).exists()) {
              break label1094;
            }
            if ((!bt.isNullOrNil(localafy.DfV)) && (!bt.isNullOrNil(localafy.gHu))) {
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
          b.a(localafy, localg, 1, false);
          this.qaO = true;
          break label840;
          label971:
          if (localafy.DgP != 0)
          {
            ad.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localafy.Dgq });
            this.qaP = true;
            b.a(localafy, localg, 0, false);
          }
          ad.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label840;
          label1047:
          ad.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localafy, localg, 1);
          this.qaO = true;
          continue;
          label1094:
          ad.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1128:
        if (this.qaO)
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
    if (cij())
    {
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(103469);
      return;
    }
    qaQ.decrementAndGet();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103469);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */