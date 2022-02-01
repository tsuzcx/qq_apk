package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ko;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ai
  extends q
  implements m
{
  private static AtomicInteger tbp;
  private i callback;
  private final d rr;
  private LinkedList<Integer> tbl;
  private int tbm;
  private boolean tbn;
  private boolean tbo;
  
  static
  {
    AppMethodBeat.i(103470);
    tbp = new AtomicInteger(0);
    AppMethodBeat.o(103470);
  }
  
  public ai(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103463);
    this.callback = null;
    this.tbn = false;
    this.tbo = false;
    this.tbm = 0;
    d.a locala = new d.a();
    locala.iLN = new ko();
    locala.iLO = new kp();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.funcId = 402;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.tbl = paramLinkedList;
    tbp.incrementAndGet();
    AppMethodBeat.o(103463);
  }
  
  private boolean cVa()
  {
    AppMethodBeat.i(103468);
    boolean bool1;
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.tbl == null) || (this.tbm >= this.tbl.size())) {
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
  
  public static void cVb()
  {
    AppMethodBeat.i(103464);
    tbp.set(0);
    AppMethodBeat.o(103464);
  }
  
  public static void cVc()
  {
    AppMethodBeat.i(103465);
    tbp.decrementAndGet();
    AppMethodBeat.o(103465);
  }
  
  public static int cVd()
  {
    AppMethodBeat.i(103466);
    int i = tbp.get();
    AppMethodBeat.o(103466);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(103467);
    Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(tbp.get()) });
    if ((this.tbl == null) || (this.tbl.isEmpty()) || (this.tbm >= this.tbl.size()))
    {
      Log.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.tbm) });
      AppMethodBeat.o(103467);
      return -1;
    }
    Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.tbl.size()), Integer.valueOf(this.tbm), this.tbl });
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(8217, null)) == 0)
    {
      Log.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      AppMethodBeat.o(103467);
      return -1;
    }
    ko localko = (ko)this.rr.iLK.iLR;
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.tbl.subList(this.tbm, Math.min(this.tbm + 15, this.tbl.size())));
    localko.KOn = localLinkedList;
    localko.oTz = localLinkedList.size();
    this.tbm += 15;
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
    Log.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.tbm), Integer.valueOf(this.tbl.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (cVa())
      {
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      tbp.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    params = (kp)((d)params).iLL.iLR;
    int i = params.oTz;
    int j = params.KOH.size();
    if (i != j)
    {
      if (this.tbm > this.tbl.size()) {}
      for (paramInt1 = this.tbl.size() % 15;; paramInt1 = 15)
      {
        Log.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!cVa()) {
          break;
        }
        doScene(dispatcher(), this.callback);
        AppMethodBeat.o(103469);
        return;
      }
      tbp.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (amw)params.KOH.get(paramInt1);
      Log.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.KGZ), Integer.valueOf(paramArrayOfByte.oTW) });
      g localg;
      if (paramArrayOfByte.oTW == 0)
      {
        localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(paramArrayOfByte.KGZ);
        if (localg == null)
        {
          Log.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.KGZ) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.KHf;
        localg.arQ(paramArrayOfByte.KHf);
        localg.field_flag = paramArrayOfByte.KHa;
        localg.field_localSeq = paramArrayOfByte.KHc;
        localg.field_updateTime = (paramArrayOfByte.KHb * 1000L + paramInt1);
        Log.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.ppH.size();
        if (i != 0) {
          break label707;
        }
        Log.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        Log.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.tbo), Boolean.valueOf(this.tbn) });
        if (!this.tbo) {
          break label1128;
        }
        localg.field_itemStatus = 15;
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.arR("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.KHa & 0x1) == 0) {
          break;
        }
        Log.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.KGZ) });
        b.a(((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(paramArrayOfByte.KGZ), null);
        break;
        label707:
        LinkedList localLinkedList = localg.field_favProto.ppH;
        i -= 1;
        label723:
        aml localaml;
        if (i >= 0)
        {
          localaml = (aml)localLinkedList.get(i);
          if (!Util.isNullOrNil(localaml.LvE))
          {
            com.tencent.mm.vfs.o localo = new com.tencent.mm.vfs.o(b.d(localaml));
            Log.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { localo.getName() });
            if (localo.exists()) {
              break label971;
            }
            if ((!Util.isNullOrNil(localaml.Lvp)) && (!Util.isNullOrNil(localaml.KuR))) {
              break label923;
            }
            Log.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label840:
          if (!Util.isNullOrNil(localaml.LvP))
          {
            if (new com.tencent.mm.vfs.o(b.a(localaml)).exists()) {
              break label1094;
            }
            if ((!Util.isNullOrNil(localaml.Lvk)) && (!Util.isNullOrNil(localaml.iwX))) {
              break label1047;
            }
            Log.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
        }
        for (;;)
        {
          i -= 1;
          break label723;
          break;
          label923:
          Log.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localaml, localg, 1, false);
          this.tbn = true;
          break label840;
          label971:
          if (localaml.Lwd != 0)
          {
            Log.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localaml.LvE });
            this.tbo = true;
            b.a(localaml, localg, 0, false);
          }
          Log.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label840;
          label1047:
          Log.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localaml, localg, 1);
          this.tbn = true;
          continue;
          label1094:
          Log.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1128:
        if (this.tbn)
        {
          localg.field_itemStatus = 10;
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
        else
        {
          localg.field_itemStatus = 10;
          ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
      }
    }
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnService().run();
    if (cVa())
    {
      doScene(dispatcher(), this.callback);
      AppMethodBeat.o(103469);
      return;
    }
    tbp.decrementAndGet();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103469);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ai
 * JD-Core Version:    0.7.0.1
 */