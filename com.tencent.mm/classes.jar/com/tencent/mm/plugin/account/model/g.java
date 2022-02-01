package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
  extends n
  implements k
{
  private f callback;
  private b gPp;
  private cme jhx;
  
  public g(int paramInt, String paramString)
  {
    AppMethodBeat.i(127832);
    b.a locala = new b.a();
    locala.hNM = new cme();
    locala.hNN = new cmf();
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
    this.gPp = locala.aDC();
    this.jhx = ((cme)this.gPp.hNK.hNQ);
    this.jhx.HfA = paramInt;
    this.jhx.jdl = paramString;
    AppMethodBeat.o(127832);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(127833);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
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
    ad.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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