package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.sdk.platformtools.ac;

public final class h
  extends n
  implements k
{
  private g callback;
  b hEg;
  
  public h(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198568);
    cuq localcuq = new cuq();
    localcuq.Fwn = u.axw();
    localcuq.FFU = paramString1;
    localcuq.FFV = paramString2;
    localcuq.DRb = (localcuq.Fwn + "_" + System.currentTimeMillis());
    paramString1 = new b.a();
    paramString1.hvt = localcuq;
    paramString1.uri = "/cgi-bin/micromsg-bin/sendpat";
    paramString1.funcId = getType();
    paramString1.hvu = new cur();
    this.hEg = paramString1.aAz();
    AppMethodBeat.o(198568);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(198569);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(198569);
    return i;
  }
  
  public final int getType()
  {
    return 849;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198570);
    ac.i("MicroMsg.NetSceneSendPat", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.h
 * JD-Core Version:    0.7.0.1
 */