package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.tt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class t
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public String cardId;
  public LinkedList<CardInfo> ozW;
  private final b rr;
  
  public t(LinkedList<tt> paramLinkedList, did paramdid, int paramInt)
  {
    this(paramLinkedList, paramdid, paramInt, "");
  }
  
  public t(LinkedList<tt> paramLinkedList, did paramdid, int paramInt, String paramString)
  {
    AppMethodBeat.i(112815);
    this.ozW = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new jr();
    ((b.a)localObject).hNN = new js();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
    ((b.a)localObject).funcId = 1099;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (jr)this.rr.hNK.hNQ;
    ((jr)localObject).hDb = paramLinkedList;
    ((jr)localObject).Frt = paramdid;
    ((jr)localObject).dHZ = paramInt;
    this.cardId = paramString;
    AppMethodBeat.o(112815);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(112816);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112816);
    return i;
  }
  
  public final int getType()
  {
    return 1099;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112817);
    ad.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112817);
      return;
    }
    paramq = ((js)this.rr.hNL.hNQ).ozQ;
    if (TextUtils.isEmpty(paramq))
    {
      ad.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112817);
      return;
    }
    paramq = com.tencent.mm.plugin.card.d.f.Za(paramq);
    if (paramq != null)
    {
      l.bYA();
      this.ozW.addAll(paramq);
    }
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(112817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.t
 * JD-Core Version:    0.7.0.1
 */