package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.ap;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.sdk.platformtools.ae;

public final class q
  extends n
  implements k
{
  private f callback;
  public CardGiftInfo oGv;
  private final b rr;
  
  public q(int paramInt, String paramString1, String paramString2, Boolean paramBoolean)
  {
    AppMethodBeat.i(112805);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ap();
    ((b.a)localObject).hQG = new aq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
    ((b.a)localObject).funcId = 1136;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ap)this.rr.hQD.hQJ;
    ((ap)localObject).FJT = paramInt;
    ((ap)localObject).FJU = paramString1;
    ((ap)localObject).FJV = paramString2;
    ((ap)localObject).FJW = paramBoolean.booleanValue();
    AppMethodBeat.o(112805);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112807);
    this.callback = paramf;
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
    ae.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.oGv = CardGiftInfo.a((aq)this.rr.hQE.hQJ);
      ae.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[] { this.oGv.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.q
 * JD-Core Version:    0.7.0.1
 */