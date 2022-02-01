package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class an
  extends n
  implements k
{
  private g callback;
  private final b rr;
  
  public an(String paramString)
  {
    AppMethodBeat.i(131145);
    b.a locala = new b.a();
    locala.gUU = new cri();
    locala.gUV = new crj();
    locala.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
    locala.funcId = 382;
    locala.reqCmdId = 181;
    locala.respCmdId = 1000000181;
    this.rr = locala.atI();
    ((cri)this.rr.gUS.gUX).CGf = bt.aGb(paramString);
    ad.d("MicroMsg.NetSceneSetEmailPwd", "md5 ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(131145);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(131146);
    this.callback = paramg;
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
    ad.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.an
 * JD-Core Version:    0.7.0.1
 */