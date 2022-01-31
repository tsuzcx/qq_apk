package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends m
  implements k
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  private LinkedList<ak> jdField_int;
  public LinkedList<ak> inu = new LinkedList();
  
  public s(LinkedList<ak> paramLinkedList)
  {
    this.jdField_int = paramLinkedList;
    b.a locala = new b.a();
    locala.ecH = new gq();
    locala.ecI = new gr();
    locala.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
    locala.ecG = 559;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((gq)this.dmK.ecE.ecN).sAo = J(paramLinkedList);
  }
  
  private static LinkedList<String> J(LinkedList<ak> paramLinkedList)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0)) {
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
    return localLinkedList;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = ((gr)this.dmK.ecF.ecN).inn;
    if (TextUtils.isEmpty(paramq))
    {
      y.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.dmL.onSceneEnd(4, -1, null, this);
      return;
    }
    long l1 = System.currentTimeMillis();
    paramq = com.tencent.mm.plugin.card.d.f.yK(paramq);
    if (paramq != null)
    {
      if (this.jdField_int != null) {
        this.inu.addAll(this.jdField_int);
      }
      long l2 = System.currentTimeMillis();
      long l3 = g.DP().dKu.eV(Thread.currentThread().getId());
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
          localObject2 = this.inu;
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
      g.DP().dKu.hI(l3);
      y.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      y.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      l.aDc();
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
        com.tencent.mm.plugin.report.service.h.nFQ.b(paramArrayOfByte, true);
      }
    }
    this.dmL.onSceneEnd(0, 0, paramString, this);
  }
  
  public final int getType()
  {
    return 559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.s
 * JD-Core Version:    0.7.0.1
 */