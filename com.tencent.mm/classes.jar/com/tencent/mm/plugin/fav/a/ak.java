package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ak
  extends com.tencent.mm.am.p
  implements m
{
  private static AtomicInteger AdD;
  private int AdA;
  private boolean AdB;
  private boolean AdC;
  private LinkedList<Integer> Adz;
  private com.tencent.mm.am.h callback;
  private final c rr;
  
  static
  {
    AppMethodBeat.i(103470);
    AdD = new AtomicInteger(0);
    AppMethodBeat.o(103470);
  }
  
  public ak(LinkedList<Integer> paramLinkedList)
  {
    AppMethodBeat.i(103463);
    this.callback = null;
    this.AdB = false;
    this.AdC = false;
    this.AdA = 0;
    c.a locala = new c.a();
    locala.otE = new la();
    locala.otF = new lb();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
    locala.funcId = 402;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.Adz = paramLinkedList;
    AdD.incrementAndGet();
    AppMethodBeat.o(103463);
  }
  
  private boolean dQR()
  {
    AppMethodBeat.i(103468);
    boolean bool1;
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(8217, null)) == 0)
    {
      bool1 = true;
      if ((this.Adz == null) || (this.AdA >= this.Adz.size())) {
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
  
  public static void dQS()
  {
    AppMethodBeat.i(103464);
    AdD.set(0);
    AppMethodBeat.o(103464);
  }
  
  public static void dQT()
  {
    AppMethodBeat.i(103465);
    AdD.decrementAndGet();
    AppMethodBeat.o(103465);
  }
  
  public static int dQU()
  {
    AppMethodBeat.i(103466);
    int i = AdD.get();
    AppMethodBeat.o(103466);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(103467);
    Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[] { Integer.valueOf(AdD.get()) });
    if ((this.Adz == null) || (this.Adz.isEmpty()) || (this.AdA >= this.Adz.size()))
    {
      Log.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[] { Integer.valueOf(this.AdA) });
      AppMethodBeat.o(103467);
      return -1;
    }
    Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[] { Integer.valueOf(this.Adz.size()), Integer.valueOf(this.AdA), this.Adz });
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(8217, null)) == 0)
    {
      Log.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
      AppMethodBeat.o(103467);
      return -1;
    }
    la localla = (la)c.b.b(this.rr.otB);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.Adz.subList(this.AdA, Math.min(this.AdA + 15, this.Adz.size())));
    localla.YMw = localLinkedList;
    localla.vgN = localLinkedList.size();
    this.AdA += 15;
    Log.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList });
    this.callback = paramh;
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
    Log.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(this.AdA), Integer.valueOf(this.Adz.size()), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (dQR())
      {
        paramInt1 = doScene(dispatcher(), this.callback);
        if (paramInt1 != 0)
        {
          Log.i("MicroMsg.NetSceneBatchgetFav", "doScene ret:%s, minus sceneCount, cur:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(AdD.get()) });
          AdD.decrementAndGet();
        }
        AppMethodBeat.o(103469);
        return;
      }
      AdD.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    params = (lb)c.c.b(((c)params).otC);
    int i = params.vgN;
    int j = params.YMT.size();
    if (i != j)
    {
      if (this.AdA > this.Adz.size()) {}
      for (paramInt1 = this.Adz.size() % 15;; paramInt1 = 15)
      {
        Log.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet resp list size:%d, return count %d, request count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt1) });
        if (!dQR()) {
          break;
        }
        paramInt1 = doScene(dispatcher(), this.callback);
        if (paramInt1 != 0)
        {
          Log.i("MicroMsg.NetSceneBatchgetFav", "doScene ret:%s, minus sceneCount, cur:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(AdD.get()) });
          AdD.decrementAndGet();
        }
        AppMethodBeat.o(103469);
        return;
      }
      AdD.decrementAndGet();
      this.callback.onSceneEnd(paramInt2, -1, paramString, this);
      AppMethodBeat.o(103469);
      return;
    }
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      paramArrayOfByte = (arq)params.YMT.get(paramInt1);
      Log.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[] { Integer.valueOf(paramArrayOfByte.YFt), Integer.valueOf(paramArrayOfByte.vhk) });
      g localg;
      if (paramArrayOfByte.vhk == 0)
      {
        localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mL(paramArrayOfByte.YFt);
        if (localg == null)
        {
          Log.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[] { Integer.valueOf(paramArrayOfByte.YFt) });
          paramInt1 += 1;
          continue;
        }
        localg.field_xml = paramArrayOfByte.YFz;
        localg.atX(paramArrayOfByte.YFz);
        localg.field_flag = paramArrayOfByte.YFu;
        localg.field_localSeq = paramArrayOfByte.YFw;
        localg.field_updateTime = (paramArrayOfByte.YFv * 1000L + paramInt1);
        Log.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", new Object[] { localg.field_xml });
        i = localg.field_favProto.vEn.size();
        if (i != 0) {
          break label789;
        }
        Log.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
        Log.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[] { Boolean.valueOf(this.AdC), Boolean.valueOf(this.AdB) });
        if (!this.AdC) {
          break label1210;
        }
        localg.field_itemStatus = 15;
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      }
      for (;;)
      {
        b.j(localg);
        localg.atY("MicroMsg.NetSceneBatchgetFav");
        if ((paramArrayOfByte.YFu & 0x1) == 0) {
          break;
        }
        Log.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[] { Integer.valueOf(paramArrayOfByte.YFt) });
        b.a(((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mL(paramArrayOfByte.YFt), null);
        break;
        label789:
        LinkedList localLinkedList = localg.field_favProto.vEn;
        i -= 1;
        label805:
        arf localarf;
        if (i >= 0)
        {
          localarf = (arf)localLinkedList.get(i);
          if (!Util.isNullOrNil(localarf.ZyW))
          {
            u localu = new u(b.d(localarf));
            Log.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[] { localu.getName() });
            if (localu.jKS()) {
              break label1053;
            }
            if ((!Util.isNullOrNil(localarf.ZyH)) && (!Util.isNullOrNil(localarf.Ysw))) {
              break label1005;
            }
            Log.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[] { Integer.valueOf(localg.field_id) });
          }
          label922:
          if (!Util.isNullOrNil(localarf.QJs))
          {
            if (new u(b.a(localarf)).jKS()) {
              break label1176;
            }
            if ((!Util.isNullOrNil(localarf.ZyC)) && (!Util.isNullOrNil(localarf.nRr))) {
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
          b.a(localarf, localg, 1, false);
          this.AdB = true;
          break label922;
          label1053:
          if (localarf.Zzu != 0)
          {
            Log.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[] { localarf.ZyW });
            this.AdC = true;
            b.a(localarf, localg, 0, false);
          }
          Log.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          break label922;
          label1129:
          Log.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
          b.a(localarf, localg, 1);
          this.AdB = true;
          continue;
          label1176:
          Log.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[] { Integer.valueOf(localg.field_id), Integer.valueOf(i) });
        }
        label1210:
        if (this.AdB)
        {
          localg.field_itemStatus = 10;
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
        else
        {
          localg.field_itemStatus = 10;
          ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a(localg, new String[] { "localId" });
        }
      }
    }
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
    if (dQR())
    {
      paramInt1 = doScene(dispatcher(), this.callback);
      if (paramInt1 != 0)
      {
        Log.i("MicroMsg.NetSceneBatchgetFav", "doScene ret:%s, minus sceneCount, cur:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(AdD.get()) });
        AdD.decrementAndGet();
      }
      AppMethodBeat.o(103469);
      return;
    }
    AdD.decrementAndGet();
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103469);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ak
 * JD-Core Version:    0.7.0.1
 */