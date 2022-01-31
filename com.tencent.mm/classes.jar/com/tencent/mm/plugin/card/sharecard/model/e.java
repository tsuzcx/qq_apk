package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.akk;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  public LinkedList<String> jdField_int;
  public LinkedList<String> inu = new LinkedList();
  
  public e(LinkedList<String> paramLinkedList)
  {
    this.jdField_int = paramLinkedList;
    b.a locala = new b.a();
    locala.ecH = new akk();
    locala.ecI = new akl();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
    locala.ecG = 903;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((akk)this.dmK.ecE.ecN).sAo = paramLinkedList;
    y.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + paramLinkedList.size());
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(903), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = (akl)this.dmK.ecF.ecN;
    y.v("MicroMsg.NetSceneGetShareCardList", "json:" + paramq.inn);
    paramq = paramq.inn;
    if (TextUtils.isEmpty(paramq))
    {
      y.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
      this.dmL.onSceneEnd(4, -1, null, this);
      return;
    }
    long l1 = System.currentTimeMillis();
    paramq = com.tencent.mm.plugin.card.d.f.yJ(paramq);
    if (paramq != null)
    {
      if (this.jdField_int != null) {
        this.inu.addAll(this.jdField_int);
      }
      long l2 = System.currentTimeMillis();
      long l3 = g.DP().dKu.eV(Thread.currentThread().getId());
      paramInt1 = 0;
      paramArrayOfByte = paramq.iterator();
      int i = 0;
      Object localObject;
      while (paramArrayOfByte.hasNext())
      {
        localObject = (ShareCardInfo)paramArrayOfByte.next();
        int j = paramInt1 + 1;
        if (!l.a((ShareCardInfo)localObject))
        {
          i += 1;
          this.inu.remove(((ShareCardInfo)localObject).field_card_id);
          paramInt1 = j;
        }
        else
        {
          y.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
          com.tencent.mm.plugin.card.sharecard.a.b.Z(ae.getContext(), ((ShareCardInfo)localObject).field_card_tp_id);
          paramInt1 = j;
          if (((ShareCardInfo)localObject).field_status != 0)
          {
            com.tencent.mm.plugin.card.sharecard.a.b.ct(((ShareCardInfo)localObject).field_card_id, ((ShareCardInfo)localObject).field_card_tp_id);
            paramInt1 = j;
          }
        }
      }
      g.DP().dKu.hI(l3);
      y.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      y.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
      l.aDe();
      if (paramq.size() > 0)
      {
        paramInt1 = (int)(System.currentTimeMillis() - l1);
        paramArrayOfByte = new ArrayList();
        localObject = new IDKey();
        ((IDKey)localObject).SetID(281);
        ((IDKey)localObject).SetKey(17);
        ((IDKey)localObject).SetValue(1L);
        IDKey localIDKey1 = new IDKey();
        localIDKey1.SetID(281);
        localIDKey1.SetKey(18);
        localIDKey1.SetValue(paramInt1);
        IDKey localIDKey2 = new IDKey();
        localIDKey2.SetID(281);
        localIDKey2.SetKey(19);
        localIDKey2.SetValue(paramq.size());
        IDKey localIDKey3 = new IDKey();
        localIDKey3.SetID(281);
        localIDKey3.SetKey(21);
        localIDKey3.SetValue(paramInt1 / paramq.size());
        paramArrayOfByte.add(localObject);
        paramArrayOfByte.add(localIDKey1);
        paramArrayOfByte.add(localIDKey2);
        paramArrayOfByte.add(localIDKey3);
        com.tencent.mm.plugin.report.service.h.nFQ.b(paramArrayOfByte, true);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 903;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.e
 * JD-Core Version:    0.7.0.1
 */