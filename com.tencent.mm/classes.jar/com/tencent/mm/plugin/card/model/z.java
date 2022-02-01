package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.sdk.platformtools.Log;

public final class z
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public CardGiftInfo tqc;
  
  public z(int paramInt, String paramString)
  {
    AppMethodBeat.i(112834);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new brq();
    ((d.a)localObject).lBV = new brr();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
    ((d.a)localObject).funcId = 1165;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (brq)d.b.b(this.rr.lBR);
    ((brq)localObject).REC = paramInt;
    ((brq)localObject).REE = paramString;
    AppMethodBeat.o(112834);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(112836);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(112836);
    return i;
  }
  
  public final int getType()
  {
    return 1165;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112835);
    Log.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.tqc = CardGiftInfo.a((brr)d.c.b(this.rr.lBS));
      Log.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[] { this.tqc.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.z
 * JD-Core Version:    0.7.0.1
 */