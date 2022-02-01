package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.kh;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class t
  extends q
  implements m
{
  private i callback;
  public String cardId;
  public LinkedList<CardInfo> pUe;
  private final d rr;
  
  public t(LinkedList<va> paramLinkedList, eck parameck, int paramInt)
  {
    this(paramLinkedList, parameck, paramInt, "");
  }
  
  public t(LinkedList<va> paramLinkedList, eck parameck, int paramInt, String paramString)
  {
    AppMethodBeat.i(112815);
    this.pUe = new LinkedList();
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new kg();
    ((d.a)localObject).iLO = new kh();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
    ((d.a)localObject).funcId = 1099;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (kg)this.rr.iLK.iLR;
    ((kg)localObject).iAd = paramLinkedList;
    ((kg)localObject).KDj = parameck;
    ((kg)localObject).eaQ = paramInt;
    this.cardId = paramString;
    AppMethodBeat.o(112815);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112816);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112816);
    return i;
  }
  
  public final int getType()
  {
    return 1099;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112817);
    Log.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112817);
      return;
    }
    params = ((kh)this.rr.iLL.iLR).pTY;
    if (TextUtils.isEmpty(params))
    {
      Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112817);
      return;
    }
    params = f.ajX(params);
    if (params != null)
    {
      l.cxE();
      this.pUe.addAll(params);
    }
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(112817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.t
 * JD-Core Version:    0.7.0.1
 */