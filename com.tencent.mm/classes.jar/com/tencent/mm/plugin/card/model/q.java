package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ap;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  extends n
  implements k
{
  private g callback;
  public CardGiftInfo ntz;
  private final b rr;
  
  public q(int paramInt, String paramString1, String paramString2, Boolean paramBoolean)
  {
    AppMethodBeat.i(112805);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ap();
    ((b.a)localObject).gUV = new aq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
    ((b.a)localObject).funcId = 1136;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ap)this.rr.gUS.gUX;
    ((ap)localObject).CtZ = paramInt;
    ((ap)localObject).Cua = paramString1;
    ((ap)localObject).Cub = paramString2;
    ((ap)localObject).Cuc = paramBoolean.booleanValue();
    AppMethodBeat.o(112805);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112807);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112807);
    return i;
  }
  
  public final int getType()
  {
    return 1136;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112806);
    ad.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.ntz = CardGiftInfo.a((aq)this.rr.gUT.gUX);
      ad.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[] { this.ntz.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.q
 * JD-Core Version:    0.7.0.1
 */