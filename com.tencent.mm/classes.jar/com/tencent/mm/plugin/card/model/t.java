package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class t
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public String cardId;
  public LinkedList<CardInfo> kop;
  private final b rr;
  
  public t(LinkedList<ph> paramLinkedList, cgd paramcgd, int paramInt)
  {
    this(paramLinkedList, paramcgd, paramInt, "");
  }
  
  public t(LinkedList<ph> paramLinkedList, cgd paramcgd, int paramInt, String paramString)
  {
    AppMethodBeat.i(87873);
    this.kop = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new if();
    ((b.a)localObject).fsY = new ig();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
    ((b.a)localObject).funcId = 699;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (if)this.rr.fsV.fta;
    ((if)localObject).fjy = paramLinkedList;
    ((if)localObject).wlJ = paramcgd;
    ((if)localObject).cHp = paramInt;
    this.cardId = paramString;
    AppMethodBeat.o(87873);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(87874);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87874);
    return i;
  }
  
  public final int getType()
  {
    return 699;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87875);
    ab.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(87875);
      return;
    }
    paramq = ((ig)this.rr.fsW.fta).koi;
    if (TextUtils.isEmpty(paramq))
    {
      ab.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.callback.onSceneEnd(4, -1, null, this);
      AppMethodBeat.o(87875);
      return;
    }
    paramq = com.tencent.mm.plugin.card.d.f.Iu(paramq);
    if (paramq != null)
    {
      l.bfz();
      this.kop.addAll(paramq);
    }
    this.callback.onSceneEnd(0, 0, paramString, this);
    AppMethodBeat.o(87875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.t
 * JD-Core Version:    0.7.0.1
 */