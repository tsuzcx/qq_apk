package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.protocal.protobuf.dcz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class an
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public an(String paramString)
  {
    AppMethodBeat.i(131145);
    b.a locala = new b.a();
    locala.hQF = new dcy();
    locala.hQG = new dcz();
    locala.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
    locala.funcId = 382;
    locala.hQH = 181;
    locala.respCmdId = 1000000181;
    this.rr = locala.aDS();
    ((dcy)this.rr.hQD.hQJ).FWw = bu.aSv(paramString);
    ae.d("MicroMsg.NetSceneSetEmailPwd", "md5 ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(131145);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131146);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131146);
    return i;
  }
  
  public final int getType()
  {
    return 382;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131147);
    ae.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.an
 * JD-Core Version:    0.7.0.1
 */