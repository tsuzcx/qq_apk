package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.sdk.platformtools.ac;

public final class z
  extends n
  implements k
{
  private g callback;
  public CardGiftInfo nWz;
  private final b rr;
  
  public z(int paramInt, String paramString)
  {
    AppMethodBeat.i(112834);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new auj();
    ((b.a)localObject).hvu = new auk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
    ((b.a)localObject).funcId = 1165;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (auj)this.rr.hvr.hvw;
    ((auj)localObject).DMq = paramInt;
    ((auj)localObject).DMr = paramString;
    AppMethodBeat.o(112834);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112836);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.nWz = CardGiftInfo.a((auk)this.rr.hvs.hvw);
      ac.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[] { this.nWz.toString() });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.z
 * JD-Core Version:    0.7.0.1
 */