package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.sdk.platformtools.ad;

public final class z
  extends n
  implements k
{
  private f callback;
  public CardGiftInfo ozT;
  private final b rr;
  
  public z(int paramInt, String paramString)
  {
    AppMethodBeat.i(112834);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ayh();
    ((b.a)localObject).hNN = new ayi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
    ((b.a)localObject).funcId = 1165;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ayh)this.rr.hNK.hNQ;
    ((ayh)localObject).Frv = paramInt;
    ((ayh)localObject).Frw = paramString;
    AppMethodBeat.o(112834);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112836);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112836);
    return i;
  }
  
  public final int getType()
  {
    return 1165;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112835);
    ad.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.ozT = CardGiftInfo.a((ayi)this.rr.hNL.hNQ);
      ad.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[] { this.ozT.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.z
 * JD-Core Version:    0.7.0.1
 */