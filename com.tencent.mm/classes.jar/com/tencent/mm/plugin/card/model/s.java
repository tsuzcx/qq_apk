package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  private LinkedList<ak> wuC;
  public LinkedList<ak> wuD;
  
  public s(LinkedList<ak> paramLinkedList)
  {
    AppMethodBeat.i(112811);
    this.wuD = new LinkedList();
    this.wuC = paramLinkedList;
    c.a locala = new c.a();
    locala.otE = new ku();
    locala.otF = new kv();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
    locala.funcId = 1074;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((ku)c.b.b(this.rr.otB)).YMu = R(paramLinkedList);
    AppMethodBeat.o(112811);
  }
  
  private static LinkedList<String> R(LinkedList<ak> paramLinkedList)
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(112812);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112812);
    return i;
  }
  
  public final int getType()
  {
    return 1074;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112813);
    Log.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112813);
      return;
    }
    params = ((kv)c.c.b(this.rr.otC)).wuy;
    if (TextUtils.isEmpty(params))
    {
      Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112813);
      return;
    }
    long l1 = System.currentTimeMillis();
    params = com.tencent.mm.plugin.card.c.f.alo(params);
    if (params != null)
    {
      if (this.wuC != null) {
        this.wuD.addAll(this.wuC);
      }
      long l2 = System.currentTimeMillis();
      long l3 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
      paramInt1 = 0;
      paramArrayOfByte = params.iterator();
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
          localObject2 = this.wuD;
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
      com.tencent.mm.kernel.h.baE().mCN.endTransaction(l3);
      Log.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      l.doO();
      if (params.size() > 0)
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
        ((IDKey)localObject3).SetValue(params.size());
        IDKey localIDKey = new IDKey();
        localIDKey.SetID(281);
        localIDKey.SetKey(47);
        localIDKey.SetValue(paramInt1 / params.size());
        paramArrayOfByte.add(localObject1);
        paramArrayOfByte.add(localObject2);
        paramArrayOfByte.add(localObject3);
        paramArrayOfByte.add(localIDKey);
        com.tencent.mm.plugin.report.service.h.OAn.b(paramArrayOfByte, true);
      }
    }
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(112813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.s
 * JD-Core Version:    0.7.0.1
 */