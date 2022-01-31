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
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.sdk.platformtools.ab;

public final class z
  extends m
  implements k
{
  private f callback;
  public CardGiftInfo kol;
  private final b rr;
  
  public z(int paramInt, String paramString)
  {
    AppMethodBeat.i(87892);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ahy();
    ((b.a)localObject).fsY = new ahz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
    ((b.a)localObject).funcId = 1165;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ahy)this.rr.fsV.fta;
    ((ahy)localObject).wlL = paramInt;
    ((ahy)localObject).wlM = paramString;
    AppMethodBeat.o(87892);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(87894);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(87894);
    return i;
  }
  
  public final int getType()
  {
    return 1165;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(87893);
    ab.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.kol = CardGiftInfo.a((ahz)this.rr.fsW.fta);
      ab.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[] { this.kol.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(87893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.z
 * JD-Core Version:    0.7.0.1
 */