package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class t
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public String cardId;
  public LinkedList<CardInfo> oGy;
  private final b rr;
  
  public t(LinkedList<tv> paramLinkedList, diy paramdiy, int paramInt)
  {
    this(paramLinkedList, paramdiy, paramInt, "");
  }
  
  public t(LinkedList<tv> paramLinkedList, diy paramdiy, int paramInt, String paramString)
  {
    AppMethodBeat.i(112815);
    this.oGy = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new jr();
    ((b.a)localObject).hQG = new js();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
    ((b.a)localObject).funcId = 1099;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (jr)this.rr.hQD.hQJ;
    ((jr)localObject).hFT = paramLinkedList;
    ((jr)localObject).FJR = paramdiy;
    ((jr)localObject).dJd = paramInt;
    this.cardId = paramString;
    AppMethodBeat.o(112815);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112817);
      return;
    }
    paramq = ((js)this.rr.hQE.hQJ).oGs;
    if (TextUtils.isEmpty(paramq))
    {
      ae.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112817);
      return;
    }
    paramq = com.tencent.mm.plugin.card.d.f.ZR(paramq);
    if (paramq != null)
    {
      l.bZP();
      this.oGy.addAll(paramq);
    }
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(112817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.t
 * JD-Core Version:    0.7.0.1
 */