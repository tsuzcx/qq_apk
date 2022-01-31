package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.an;
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.sdk.platformtools.ab;

public final class q
  extends m
  implements k
{
  private f callback;
  public CardGiftInfo kol;
  private final b rr;
  
  public q(int paramInt, String paramString1, String paramString2, Boolean paramBoolean)
  {
    AppMethodBeat.i(87863);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new an();
    ((b.a)localObject).fsY = new ao();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
    ((b.a)localObject).funcId = 1136;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (an)this.rr.fsV.fta;
    ((an)localObject).wlL = paramInt;
    ((an)localObject).wlM = paramString1;
    ((an)localObject).wlN = paramString2;
    ((an)localObject).wlO = paramBoolean.booleanValue();
    AppMethodBeat.o(87863);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87865);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87865);
    return i;
  }
  
  public final int getType()
  {
    return 1136;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87864);
    ab.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.kol = CardGiftInfo.a((ao)this.rr.fsW.fta);
      ab.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[] { this.kol.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.q
 * JD-Core Version:    0.7.0.1
 */