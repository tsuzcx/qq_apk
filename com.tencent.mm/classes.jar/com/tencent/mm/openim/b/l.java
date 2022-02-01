package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.platformtools.ac;

public final class l
  extends n
  implements k
{
  private g callback;
  public j.b ioi;
  private int opType;
  private final com.tencent.mm.ak.b rr;
  
  public l(j.b paramb)
  {
    AppMethodBeat.i(116859);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cas();
    ((b.a)localObject).hvu = new cat();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/openimoplog";
    ((b.a)localObject).funcId = 806;
    this.rr = ((b.a)localObject).aAz();
    this.opType = paramb.uHf;
    this.ioi = paramb;
    ac.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", new Object[] { Integer.valueOf(this.opType) });
    localObject = (cas)this.rr.hvr.hvw;
    ((cas)localObject).type = this.opType;
    ((cas)localObject).Fpp = new com.tencent.mm.bw.b(paramb.getBuffer());
    AppMethodBeat.o(116859);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(116860);
    this.callback = paramg;
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
    ac.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.opType) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(116861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.l
 * JD-Core Version:    0.7.0.1
 */