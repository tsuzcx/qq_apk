package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.awm;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  public int vPo;
  private awl vPp;
  private awm vPq;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(189863);
    b.a locala = new b.a();
    locala.hQF = new awl();
    locala.hQG = new awm();
    locala.funcId = 4362;
    locala.uri = "/cgi-bin/micromsg-bin/getallfunction";
    this.rr = locala.aDS();
    this.vPp = ((awl)this.rr.hQD.hQJ);
    this.vPo = paramInt;
    ae.i("MicroMsg.NetSceneGetPayFunctionListNew", "walletRegion: %s", new Object[] { Integer.valueOf(this.vPo) });
    this.vPp.FUJ = this.vPo;
    AppMethodBeat.o(189863);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(189864);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(189864);
    return i;
  }
  
  public final int getType()
  {
    return 4362;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189865);
    ae.i("MicroMsg.NetSceneGetPayFunctionListNew", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.vPq = ((awm)((com.tencent.mm.ak.b)paramq).hQE.hQJ);
      if (this.vPq != null) {
        com.tencent.mm.plugin.wallet_core.model.mall.b.a(this.vPq);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(189865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.g
 * JD-Core Version:    0.7.0.1
 */