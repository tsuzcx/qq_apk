package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chg;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private b gvE;
  private chf iOo;
  
  public g(int paramInt, String paramString)
  {
    AppMethodBeat.i(127832);
    b.a locala = new b.a();
    locala.hvt = new chf();
    locala.hvu = new chg();
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
    this.gvE = locala.aAz();
    this.iOo = ((chf)this.gvE.hvr.hvw);
    this.iOo.Fvv = paramInt;
    this.iOo.iKc = paramString;
    AppMethodBeat.o(127832);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(127833);
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(127833);
    return i;
  }
  
  public final int getType()
  {
    return 268;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127834);
    ac.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(127834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.g
 * JD-Core Version:    0.7.0.1
 */