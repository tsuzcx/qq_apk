package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public LinkedList<String> kon;
  public LinkedList<String> koo;
  private final com.tencent.mm.ai.b rr;
  
  public e(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(88027);
    this.koo = new LinkedList();
    this.kon = paramLinkedList;
    b.a locala = new b.a();
    locala.fsX = new apv();
    locala.fsY = new apw();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
    locala.funcId = 903;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((apv)this.rr.fsV.fta).wut = paramLinkedList;
    ab.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + paramLinkedList.size());
    AppMethodBeat.o(88027);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(88029);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88029);
    return i;
  }
  
  public final int getType()
  {
    return 903;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88028);
    ab.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(88028);
      return;
    }
    paramq = (apw)this.rr.fsW.fta;
    ab.v("MicroMsg.NetSceneGetShareCardList", "json:" + paramq.koi);
    paramq = paramq.koi;
    if (TextUtils.isEmpty(paramq))
    {
      ab.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(88028);
      return;
    }
    long l1 = System.currentTimeMillis();
    paramq = com.tencent.mm.plugin.card.d.f.It(paramq);
    if (paramq != null)
    {
      if (this.kon != null) {
        this.koo.addAll(this.kon);
      }
      long l2 = System.currentTimeMillis();
      long l3 = g.RL().eHS.kr(Thread.currentThread().getId());
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
          this.koo.remove(((ShareCardInfo)localObject).field_card_id);
          paramInt1 = j;
        }
        else
        {
          ab.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
          com.tencent.mm.plugin.card.sharecard.a.b.ac(ah.getContext(), ((ShareCardInfo)localObject).field_card_tp_id);
          paramInt1 = j;
          if (((ShareCardInfo)localObject).field_status != 0)
          {
            com.tencent.mm.plugin.card.sharecard.a.b.dq(((ShareCardInfo)localObject).field_card_id, ((ShareCardInfo)localObject).field_card_tp_id);
            paramInt1 = j;
          }
        }
      }
      g.RL().eHS.nY(l3);
      ab.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      ab.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
      l.bfB();
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
        com.tencent.mm.plugin.report.service.h.qsU.b(paramArrayOfByte, true);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.e
 * JD-Core Version:    0.7.0.1
 */