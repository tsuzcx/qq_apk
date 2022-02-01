package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  public int vDk;
  private avv vDl;
  private avw vDm;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(199028);
    b.a locala = new b.a();
    locala.hNM = new avv();
    locala.hNN = new avw();
    locala.funcId = 4362;
    locala.uri = "/cgi-bin/micromsg-bin/getallfunction";
    this.rr = locala.aDC();
    this.vDl = ((avv)this.rr.hNK.hNQ);
    this.vDk = paramInt;
    ad.i("MicroMsg.NetSceneGetPayFunctionListNew", "walletRegion: %s", new Object[] { Integer.valueOf(this.vDk) });
    this.vDl.FCo = this.vDk;
    AppMethodBeat.o(199028);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(199029);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(199029);
    return i;
  }
  
  public final int getType()
  {
    return 4362;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199030);
    ad.i("MicroMsg.NetSceneGetPayFunctionListNew", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.vDm = ((avw)((com.tencent.mm.al.b)paramq).hNL.hNQ);
      if (this.vDm != null) {
        com.tencent.mm.plugin.wallet_core.model.mall.b.a(this.vDm);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(199030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.g
 * JD-Core Version:    0.7.0.1
 */