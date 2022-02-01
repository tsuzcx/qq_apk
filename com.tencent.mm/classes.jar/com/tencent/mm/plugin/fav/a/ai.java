package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ai
  extends n
  implements k
{
  private static AtomicInteger qJw;
  private com.tencent.mm.ak.g callback;
  private LinkedList<Integer> qJs;
  private int qJt;
  private boolean qJu;
  private boolean qJv;
  private final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(103470);
    qJw = new AtomicInteger(0);
    AppMethodBeat.o(103470);
  }
  
  public ai(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103463);
    this.callback = null;
    this.qJu = false;
    this.qJv = false;
    this.qJt = 0;
    b.a locala = new b.a();
    locala.hvt = new jq();
    locala.hvu = new jr();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.funcId = 402;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.qJs = paramLinkedList;
    qJw.incrementAndGet();
    AppMethodBeat.o(103463);
  }
  
  private boolean cpQ()
  {
    AppMethodBeat.i(103468);
    boolean bool1;
    if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.qJs == null) || (this.qJt >= this.qJs.size())) {
        break label97;
      }
    }
    label97:
    for (boolean bool2 = true;; bool2 = false)
    {
      ac.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
  
  public static void cpR()
  {
    AppMethodBeat.i(103464);
    qJw.set(0);
    AppMethodBeat.o(103464);
  }
  
  public static void cpS()
  {
    AppMethodBeat.i(103465);
    qJw.decrementAndGet();
    AppMethodBeat.o(103465);
  }
  
  public static int cpT()
  {
    AppMethodBeat.i(103466);
    int i = qJw.get();
    AppMethodBeat.o(103466);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(103467);
    ac.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(qJw.get()) });
    if ((this.qJs == null) || (this.qJs.isEmpty()) || (this.qJt >= this.qJs.size()))
    {
      ac.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.qJt) });
      AppMethodBeat.o(103467);
      return -1;
    }
    ac.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.qJs.size()), Integer.valueOf(this.qJt), this.qJs });
    if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(8217, null)) == 0)
    {
      ac.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      AppMethodBeat.o(103467);
      return -1;
    }
    jq localjq = (jq)this.rr.hvr.hvw;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.qJs.subList(this.qJt, Math.min(this.qJt + 15, this.qJs.size())));
    localjq.DWN = localLinkedList;
    localjq.ncL = localLinkedList.size();
    this.qJt += 15;
    ac.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList });
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
    ac.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.qJt), Integer.valueOf(this.qJs.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cpQ())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      qJw.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramq = (jr)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    int i = paramq.ncL;
    int j = paramq.DXh.size();
    if (i != j)
    {
      if (this.qJt > this.qJs.size()) {}
      for (paramInt1 = this.qJs.size() % 15;; paramInt1 = 15)
      {
        ac.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!cpQ()) {
          break;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      qJw.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (ahi)paramq.DXh.get(paramInt1);
      ac.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.DPH), Integer.valueOf(paramArrayOfByte.ndj) });
      g localg;
      if (paramArrayOfByte.ndj == 0)
      {
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(paramArrayOfByte.DPH);
        if (localg == null)
        {
          ac.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.DPH) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.DPN;
        localg.acw(paramArrayOfByte.DPN);
        localg.field_flag = paramArrayOfByte.DPI;
        localg.field_localSeq = paramArrayOfByte.DPK;
        localg.field_updateTime = (paramArrayOfByte.DPJ * 1000L + paramInt1);
        ac.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.nxC.size();
        if (i != 0) {
          break label707;
        }
        ac.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        ac.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.qJv), Boolean.valueOf(this.qJu) });
        if (!this.qJv) {
          break label1128;
        }
        localg.field_itemStatus = 15;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.acx("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.DPI & 0x1) == 0) {
          break;
        }
        ac.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.DPH) });
        b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(paramArrayOfByte.DPH), null);
        break;
        label707:
        LinkedList localLinkedList = localg.field_favProto.nxC;
        i -= 1;
        label723:
        agx localagx;
        if (i >= 0)
        {
          localagx = (agx)localLinkedList.get(i);
          if (!bs.isNullOrNil(localagx.Ezw))
          {
            com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(b.d(localagx));
            ac.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { locale.getName() });
            if (locale.exists()) {
              break label971;
            }
            if ((!bs.isNullOrNil(localagx.Ezh)) && (!bs.isNullOrNil(localagx.Ezf))) {
              break label923;
            }
            ac.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label840:
          if (!bs.isNullOrNil(localagx.EzH))
          {
            if (new com.tencent.mm.vfs.e(b.a(localagx)).exists()) {
              break label1094;
            }
            if ((!bs.isNullOrNil(localagx.Ezb)) && (!bs.isNullOrNil(localagx.hhV))) {
              break label1047;
            }
            ac.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break label723;
          break;
          label923:
          ac.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localagx, localg, 1, false);
          this.qJu = true;
          break label840;
          label971:
          if (localagx.EzV != 0)
          {
            ac.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localagx.Ezw });
            this.qJv = true;
            b.a(localagx, localg, 0, false);
          }
          ac.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label840;
          label1047:
          ac.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localagx, localg, 1);
          this.qJu = true;
          continue;
          label1094:
          ac.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1128:
        if (this.qJu)
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
    if (cpQ())
    {
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(103469);
      return;
    }
    qJw.decrementAndGet();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103469);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */