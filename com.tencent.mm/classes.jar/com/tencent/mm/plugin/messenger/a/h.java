package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  private g callback;
  b hdD;
  
  public h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196684);
    cpj localcpj = new cpj();
    localcpj.DZr = u.aqG();
    localcpj.EiW = paramString1;
    localcpj.EiX = paramString2;
    localcpj.CyF = (localcpj.DZr + "_" + System.currentTimeMillis());
    paramString1 = new b.a();
    paramString1.gUU = localcpj;
    paramString1.uri = "/cgi-bin/micromsg-bin/sendpat";
    paramString1.funcId = getType();
    paramString1.gUV = new cpk();
    this.hdD = paramString1.atI();
    AppMethodBeat.o(196684);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(196685);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
    AppMethodBeat.o(196685);
    return i;
  }
  
  public final int getType()
  {
    return 849;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196686);
    ad.i("MicroMsg.NetSceneSendPat", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(196686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.h
 * JD-Core Version:    0.7.0.1
 */