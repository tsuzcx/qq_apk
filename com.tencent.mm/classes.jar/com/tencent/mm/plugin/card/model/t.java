package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.protocal.protobuf.jj;
import com.tencent.mm.protocal.protobuf.rz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class t
  extends n
  implements k
{
  private g callback;
  public String cardId;
  public LinkedList<CardInfo> nWC;
  private final b rr;
  
  public t(LinkedList<rz> paramLinkedList, dcq paramdcq, int paramInt)
  {
    this(paramLinkedList, paramdcq, paramInt, "");
  }
  
  public t(LinkedList<rz> paramLinkedList, dcq paramdcq, int paramInt, String paramString)
  {
    AppMethodBeat.i(112815);
    this.nWC = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ji();
    ((b.a)localObject).hvu = new jj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
    ((b.a)localObject).funcId = 1099;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ji)this.rr.hvr.hvw;
    ((ji)localObject).hkS = paramLinkedList;
    ((ji)localObject).DMo = paramdcq;
    ((ji)localObject).dvQ = paramInt;
    this.cardId = paramString;
    AppMethodBeat.o(112815);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112816);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(112817);
      return;
    }
    paramq = ((jj)this.rr.hvs.hvw).nWw;
    if (TextUtils.isEmpty(paramq))
    {
      ac.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(112817);
      return;
    }
    paramq = f.Vr(paramq);
    if (paramq != null)
    {
      l.bTV();
      this.nWC.addAll(paramq);
    }
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(112817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.t
 * JD-Core Version:    0.7.0.1
 */