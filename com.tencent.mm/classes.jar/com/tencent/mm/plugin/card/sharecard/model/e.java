package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends q
  implements m
{
  private i callback;
  public LinkedList<String> pUc;
  public LinkedList<String> pUd;
  private final d rr;
  
  public e(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112966);
    this.pUd = new LinkedList();
    this.pUc = paramLinkedList;
    d.a locala = new d.a();
    locala.iLN = new bvd();
    locala.iLO = new bve();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
    locala.funcId = 1132;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((bvd)this.rr.iLK.iLR).KOl = paramLinkedList;
    Log.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + paramLinkedList.size());
    AppMethodBeat.o(112966);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(112968);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112968);
    return i;
  }
  
  public final int getType()
  {
    return 1132;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112967);
    Log.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(getType()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112967);
      return;
    }
    params = (bve)this.rr.iLL.iLR;
    Log.v("MicroMsg.NetSceneGetShareCardList", "json:" + params.pTY);
    params = params.pTY;
    if (TextUtils.isEmpty(params))
    {
      Log.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112967);
      return;
    }
    long l1 = System.currentTimeMillis();
    params = f.ajW(params);
    if (params != null)
    {
      if (this.pUc != null) {
        this.pUd.addAll(this.pUc);
      }
      long l2 = System.currentTimeMillis();
      long l3 = com.tencent.mm.kernel.g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
      paramInt1 = 0;
      paramArrayOfByte = params.iterator();
      int i = 0;
      Object localObject;
      while (paramArrayOfByte.hasNext())
      {
        localObject = (ShareCardInfo)paramArrayOfByte.next();
        int j = paramInt1 + 1;
        if (!l.a((ShareCardInfo)localObject))
        {
          i += 1;
          this.pUd.remove(((ShareCardInfo)localObject).field_card_id);
          paramInt1 = j;
        }
        else
        {
          Log.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
          b.al(MMApplicationContext.getContext(), ((ShareCardInfo)localObject).field_card_tp_id);
          paramInt1 = j;
          if (((ShareCardInfo)localObject).field_status != 0)
          {
            b.fs(((ShareCardInfo)localObject).field_card_id, ((ShareCardInfo)localObject).field_card_tp_id);
            paramInt1 = j;
          }
        }
      }
      com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l3);
      Log.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      Log.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
      l.cxG();
      if (params.size() > 0)
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
        localIDKey2.SetValue(params.size());
        IDKey localIDKey3 = new IDKey();
        localIDKey3.SetID(281);
        localIDKey3.SetKey(21);
        localIDKey3.SetValue(paramInt1 / params.size());
        paramArrayOfByte.add(localObject);
        paramArrayOfByte.add(localIDKey1);
        paramArrayOfByte.add(localIDKey2);
        paramArrayOfByte.add(localIDKey3);
        com.tencent.mm.plugin.report.service.h.CyF.b(paramArrayOfByte, true);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.e
 * JD-Core Version:    0.7.0.1
 */