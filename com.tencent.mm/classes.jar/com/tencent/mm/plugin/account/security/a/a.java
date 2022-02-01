package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class a
  extends n
  implements k
{
  private String cLR;
  private com.tencent.mm.al.g callback;
  private b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(125511);
    this.cLR = paramString;
    b.a locala = new b.a();
    locala.gUU = new aam();
    locala.gUV = new aan();
    locala.uri = "/cgi-bin/micromsg-bin/delsafedevice";
    locala.funcId = 362;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((aam)this.rr.gUS.gUX).CWZ = paramString;
    AppMethodBeat.o(125511);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(125513);
    if (bt.isNullOrNil(this.cLR))
    {
      ad.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
      AppMethodBeat.o(125513);
      return -1;
    }
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125513);
    return i;
  }
  
  public final int getType()
  {
    return 362;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125512);
    ad.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aan)this.rr.gUT.gUX;
      com.tencent.mm.kernel.g.afB().afk().set(64, Integer.valueOf(paramq.CuL));
      ad.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + paramq.CuL);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.a
 * JD-Core Version:    0.7.0.1
 */