package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cgd;
import com.tencent.mm.protocal.protobuf.cge;
import com.tencent.mm.sdk.platformtools.ae;

public final class l
  extends n
  implements k
{
  private f callback;
  public k.b iKy;
  private int opType;
  private final com.tencent.mm.ak.b rr;
  
  public l(k.b paramb)
  {
    AppMethodBeat.i(116859);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cgd();
    ((b.a)localObject).hQG = new cge();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/openimoplog";
    ((b.a)localObject).funcId = 806;
    this.rr = ((b.a)localObject).aDS();
    this.opType = paramb.vWm;
    this.iKy = paramb;
    ae.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", new Object[] { Integer.valueOf(this.opType) });
    localObject = (cgd)this.rr.hQD.hQJ;
    ((cgd)localObject).type = this.opType;
    ((cgd)localObject).HsB = new com.tencent.mm.bw.b(paramb.getBuffer());
    AppMethodBeat.o(116859);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(116860);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(116860);
    return i;
  }
  
  public final int getType()
  {
    return 806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116861);
    ae.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.opType) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(116861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.l
 * JD-Core Version:    0.7.0.1
 */