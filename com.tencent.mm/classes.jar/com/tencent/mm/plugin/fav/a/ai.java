package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ai
  extends n
  implements com.tencent.mm.network.k
{
  private static AtomicInteger rBK;
  private f callback;
  private LinkedList<Integer> rBG;
  private int rBH;
  private boolean rBI;
  private boolean rBJ;
  private final com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(103470);
    rBK = new AtomicInteger(0);
    AppMethodBeat.o(103470);
  }
  
  public ai(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103463);
    this.callback = null;
    this.rBI = false;
    this.rBJ = false;
    this.rBH = 0;
    b.a locala = new b.a();
    locala.hQF = new jz();
    locala.hQG = new ka();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.funcId = 402;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.rBG = paramLinkedList;
    rBK.incrementAndGet();
    AppMethodBeat.o(103463);
  }
  
  private boolean cwW()
  {
    AppMethodBeat.i(103468);
    boolean bool1;
    if (bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.rBG == null) || (this.rBH >= this.rBG.size())) {
        break label97;
      }
    }
    label97:
    for (boolean bool2 = true;; bool2 = false)
    {
      ae.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
  
  public static void cwX()
  {
    AppMethodBeat.i(103464);
    rBK.set(0);
    AppMethodBeat.o(103464);
  }
  
  public static void cwY()
  {
    AppMethodBeat.i(103465);
    rBK.decrementAndGet();
    AppMethodBeat.o(103465);
  }
  
  public static int cwZ()
  {
    AppMethodBeat.i(103466);
    int i = rBK.get();
    AppMethodBeat.o(103466);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(103467);
    ae.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(rBK.get()) });
    if ((this.rBG == null) || (this.rBG.isEmpty()) || (this.rBH >= this.rBG.size()))
    {
      ae.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.rBH) });
      AppMethodBeat.o(103467);
      return -1;
    }
    ae.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.rBG.size()), Integer.valueOf(this.rBH), this.rBG });
    if (bu.o((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(8217, null)) == 0)
    {
      ae.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      AppMethodBeat.o(103467);
      return -1;
    }
    jz localjz = (jz)this.rr.hQD.hQJ;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.rBG.subList(this.rBH, Math.min(this.rBH + 15, this.rBG.size())));
    localjz.FUE = localLinkedList;
    localjz.nID = localLinkedList.size();
    this.rBH += 15;
    ae.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList });
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
    ae.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.rBH), Integer.valueOf(this.rBG.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cwW())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      rBK.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramq = (ka)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    int i = paramq.nID;
    int j = paramq.FUY.size();
    if (i != j)
    {
      if (this.rBH > this.rBG.size()) {}
      for (paramInt1 = this.rBG.size() % 15;; paramInt1 = 15)
      {
        ae.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!cwW()) {
          break;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      rBK.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (aki)paramq.FUY.get(paramInt1);
      ae.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.FNu), Integer.valueOf(paramArrayOfByte.nJb) });
      g localg;
      if (paramArrayOfByte.nJb == 0)
      {
        localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(paramArrayOfByte.FNu);
        if (localg == null)
        {
          ae.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.FNu) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.FNA;
        localg.ahi(paramArrayOfByte.FNA);
        localg.field_flag = paramArrayOfByte.FNv;
        localg.field_localSeq = paramArrayOfByte.FNx;
        localg.field_updateTime = (paramArrayOfByte.FNw * 1000L + paramInt1);
        ae.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.oeJ.size();
        if (i != 0) {
          break label707;
        }
        ae.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        ae.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.rBJ), Boolean.valueOf(this.rBI) });
        if (!this.rBJ) {
          break label1128;
        }
        localg.field_itemStatus = 15;
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.ahj("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.FNv & 0x1) == 0) {
          break;
        }
        ae.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.FNu) });
        b.a(((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(paramArrayOfByte.FNu), null);
        break;
        label707:
        LinkedList localLinkedList = localg.field_favProto.oeJ;
        i -= 1;
        label723:
        ajx localajx;
        if (i >= 0)
        {
          localajx = (ajx)localLinkedList.get(i);
          if (!bu.isNullOrNil(localajx.GzR))
          {
            com.tencent.mm.vfs.k localk = new com.tencent.mm.vfs.k(b.d(localajx));
            ae.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { localk.getName() });
            if (localk.exists()) {
              break label971;
            }
            if ((!bu.isNullOrNil(localajx.GzC)) && (!bu.isNullOrNil(localajx.GzA))) {
              break label923;
            }
            ae.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label840:
          if (!bu.isNullOrNil(localajx.GAc))
          {
            if (new com.tencent.mm.vfs.k(b.a(localajx)).exists()) {
              break label1094;
            }
            if ((!bu.isNullOrNil(localajx.Gzw)) && (!bu.isNullOrNil(localajx.hCS))) {
              break label1047;
            }
            ae.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break label723;
          break;
          label923:
          ae.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localajx, localg, 1, false);
          this.rBI = true;
          break label840;
          label971:
          if (localajx.GAq != 0)
          {
            ae.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localajx.GzR });
            this.rBJ = true;
            b.a(localajx, localg, 0, false);
          }
          ae.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label840;
          label1047:
          ae.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localajx, localg, 1);
          this.rBI = true;
          continue;
          label1094:
          ae.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1128:
        if (this.rBI)
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
    if (cwW())
    {
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(103469);
      return;
    }
    rBK.decrementAndGet();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103469);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */