package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.adv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class a
  extends n
  implements k
{
  private String cVh;
  private f callback;
  private b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(125511);
    this.cVh = paramString;
    b.a locala = new b.a();
    locala.hQF = new adu();
    locala.hQG = new adv();
    locala.uri = "/cgi-bin/micromsg-bin/delsafedevice";
    locala.funcId = 362;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((adu)this.rr.hQD.hQJ).Gps = paramString;
    AppMethodBeat.o(125511);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(125513);
    if (bu.isNullOrNil(this.cVh))
    {
      ae.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
      AppMethodBeat.o(125513);
      return -1;
    }
    this.callback = paramf;
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
    ae.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (adv)this.rr.hQE.hQJ;
      g.ajR().ajA().set(64, Integer.valueOf(paramq.FKJ));
      ae.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + paramq.FKJ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.a
 * JD-Core Version:    0.7.0.1
 */