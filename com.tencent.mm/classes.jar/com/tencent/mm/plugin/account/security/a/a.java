package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class a
  extends n
  implements k
{
  private String cIZ;
  private com.tencent.mm.ak.g callback;
  private b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(125511);
    this.cIZ = paramString;
    b.a locala = new b.a();
    locala.hvt = new abl();
    locala.hvu = new abm();
    locala.uri = "/cgi-bin/micromsg-bin/delsafedevice";
    locala.funcId = 362;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((abl)this.rr.hvr.hvw).EpI = paramString;
    AppMethodBeat.o(125511);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(125513);
    if (bs.isNullOrNil(this.cIZ))
    {
      ac.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
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
    ac.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (abm)this.rr.hvs.hvw;
      com.tencent.mm.kernel.g.agR().agA().set(64, Integer.valueOf(paramq.DNg));
      ac.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + paramq.DNg);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.a
 * JD-Core Version:    0.7.0.1
 */