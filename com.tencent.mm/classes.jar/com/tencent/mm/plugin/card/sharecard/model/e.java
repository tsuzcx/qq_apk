package com.tencent.mm.plugin.card.sharecard.model;

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
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final c rr;
  public LinkedList<String> wuC;
  public LinkedList<String> wuD;
  
  public e(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(112966);
    this.wuD = new LinkedList();
    this.wuC = paramLinkedList;
    c.a locala = new c.a();
    locala.otE = new csh();
    locala.otF = new csi();
    locala.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
    locala.funcId = 1132;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((csh)c.b.b(this.rr.otB)).YMu = paramLinkedList;
    Log.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + paramLinkedList.size());
    AppMethodBeat.o(112966);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(112968);
    this.callback = paramh;
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
    params = (csi)c.c.b(this.rr.otC);
    Log.v("MicroMsg.NetSceneGetShareCardList", "json:" + params.wuy);
    params = params.wuy;
    if (TextUtils.isEmpty(params))
    {
      Log.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112967);
      return;
    }
    long l1 = System.currentTimeMillis();
    params = com.tencent.mm.plugin.card.c.f.aln(params);
    if (params != null)
    {
      if (this.wuC != null) {
        this.wuD.addAll(this.wuC);
      }
      long l2 = System.currentTimeMillis();
      long l3 = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
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
          this.wuD.remove(((ShareCardInfo)localObject).field_card_id);
          paramInt1 = j;
        }
        else
        {
          Log.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
          b.am(MMApplicationContext.getContext(), ((ShareCardInfo)localObject).field_card_tp_id);
          paramInt1 = j;
          if (((ShareCardInfo)localObject).field_status != 0)
          {
            b.gf(((ShareCardInfo)localObject).field_card_id, ((ShareCardInfo)localObject).field_card_tp_id);
            paramInt1 = j;
          }
        }
      }
      com.tencent.mm.kernel.h.baE().mCN.endTransaction(l3);
      Log.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
      Log.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
      l.doQ();
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
        com.tencent.mm.plugin.report.service.h.OAn.b(paramArrayOfByte, true);
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