package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ap;
import com.tencent.mm.protocal.protobuf.aq;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private final d rr;
  public CardGiftInfo tqc;
  
  public q(int paramInt, String paramString1, String paramString2, Boolean paramBoolean)
  {
    AppMethodBeat.i(112805);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ap();
    ((d.a)localObject).lBV = new aq();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
    ((d.a)localObject).funcId = 1136;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ap)d.b.b(this.rr.lBR);
    ((ap)localObject).REC = paramInt;
    ((ap)localObject).REE = paramString1;
    ((ap)localObject).chatroom_name = paramString2;
    ((ap)localObject).REG = paramBoolean.booleanValue();
    AppMethodBeat.o(112805);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112807);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112807);
    return i;
  }
  
  public final int getType()
  {
    return 1136;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112806);
    Log.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.tqc = CardGiftInfo.a((aq)d.c.b(this.rr.lBS));
      Log.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[] { this.tqc.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.q
 * JD-Core Version:    0.7.0.1
 */