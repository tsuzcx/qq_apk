package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.protocal.protobuf.jl;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private LinkedList<ak> nWA;
  public LinkedList<ak> nWB;
  private final b rr;
  
  public s(LinkedList<ak> paramLinkedList)
  {
    AppMethodBeat.i(112811);
    this.nWB = new LinkedList();
    this.nWA = paramLinkedList;
    b.a locala = new b.a();
    locala.hvt = new jk();
    locala.hvu = new jl();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
    locala.funcId = 1074;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((jk)this.rr.hvr.hvw).DWL = O(paramLinkedList);
    AppMethodBeat.o(112811);
  }
  
  private static LinkedList<String> O(LinkedList<ak> paramLinkedList)
  {
    AppMethodBeat.i(112814);
    LinkedList localLinkedList = new LinkedList();
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      AppMethodBeat.o(112814);
      return localLinkedList;
    }
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      ak localak = (ak)paramLinkedList.next();
      if (localak != null) {
        localLinkedList.add(localak.field_cardUserId);
      }
    }
    AppMethodBeat.o(112814);
    return localLinkedList;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(112812);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112812);
    return i;
  }
  
  public final int getType()
  {
    return 1074;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112813);
    ac.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112813);
      return;
    }
    paramq = ((jl)this.rr.hvs.hvw).nWw;
    if (TextUtils.isEmpty(paramq))
    {
      ac.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112813);
      return;
    }
    long l1 = System.currentTimeMillis();
    paramq = f.Vr(paramq);
    if (paramq != null)
    {
      if (this.nWA != null) {
        this.nWB.addAll(this.nWA);
      }
      long l2 = System.currentTimeMillis();
      long l3 = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
      paramInt1 = 0;
      paramArrayOfByte = paramq.iterator();
      Object localObject1;
      Object localObject2;
      Object localObject3;
      for (paramInt2 = 0; paramArrayOfByte.hasNext(); paramInt2 = paramInt3)
      {
        localObject1 = (CardInfo)paramArrayOfByte.next();
        paramInt3 = paramInt2 + 1;
        paramInt2 = paramInt1;
        if (!l.b((CardInfo)localObject1))
        {
          paramInt1 += 1;
          localObject2 = this.nWB;
          paramInt2 = paramInt1;
          if (localObject1 != null)
          {
            localObject3 = new ak();
            ((ak)localObject3).field_cardUserId = ((CardInfo)localObject1).field_card_id;
            ((LinkedList)localObject2).remove(localObject3);
            paramInt2 = paramInt1;
          }
        }
        paramInt1 = paramInt2;
      }
      com.tencent.mm.kernel.g.agR().ghG.qL(l3);
      ac.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      ac.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      l.bTV();
      if (paramq.size() > 0)
      {
        paramInt1 = (int)(System.currentTimeMillis() - l1);
        paramArrayOfByte = new ArrayList();
        localObject1 = new IDKey();
        ((IDKey)localObject1).SetID(281);
        ((IDKey)localObject1).SetKey(43);
        ((IDKey)localObject1).SetValue(1L);
        localObject2 = new IDKey();
        ((IDKey)localObject2).SetID(281);
        ((IDKey)localObject2).SetKey(44);
        ((IDKey)localObject2).SetValue(paramInt1);
        localObject3 = new IDKey();
        ((IDKey)localObject3).SetID(281);
        ((IDKey)localObject3).SetKey(45);
        ((IDKey)localObject3).SetValue(paramq.size());
        IDKey localIDKey = new IDKey();
        localIDKey.SetID(281);
        localIDKey.SetKey(47);
        localIDKey.SetValue(paramInt1 / paramq.size());
        paramArrayOfByte.add(localObject1);
        paramArrayOfByte.add(localObject2);
        paramArrayOfByte.add(localObject3);
        paramArrayOfByte.add(localIDKey);
        com.tencent.mm.plugin.report.service.h.wUl.b(paramArrayOfByte, true);
      }
    }
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(112813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.s
 * JD-Core Version:    0.7.0.1
 */