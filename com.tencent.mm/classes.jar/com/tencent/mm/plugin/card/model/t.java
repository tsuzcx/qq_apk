package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.c.f;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.protocal.protobuf.fhj;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class t
  extends p
  implements m
{
  private h callback;
  public String cardId;
  private final c rr;
  public LinkedList<CardInfo> wuE;
  
  public t(LinkedList<wt> paramLinkedList, fhj paramfhj, int paramInt)
  {
    this(paramLinkedList, paramfhj, paramInt, "");
  }
  
  public t(LinkedList<wt> paramLinkedList, fhj paramfhj, int paramInt, String paramString)
  {
    AppMethodBeat.i(112815);
    this.wuE = new LinkedList();
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ks();
    ((c.a)localObject).otF = new kt();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
    ((c.a)localObject).funcId = 1099;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ks)c.b.b(this.rr.otB);
    ((ks)localObject).nUC = paramLinkedList;
    ((ks)localObject).YBf = paramfhj;
    ((ks)localObject).iaK = paramInt;
    this.cardId = paramString;
    AppMethodBeat.o(112815);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(112816);
    this.callback = paramh;
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
    params = ((kt)c.c.b(this.rr.otC)).wuy;
    if (TextUtils.isEmpty(params))
    {
      Log.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112817);
      return;
    }
    params = f.alo(params);
    if (params != null)
    {
      l.doO();
      this.wuE.addAll(params);
    }
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(112817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.t
 * JD-Core Version:    0.7.0.1
 */