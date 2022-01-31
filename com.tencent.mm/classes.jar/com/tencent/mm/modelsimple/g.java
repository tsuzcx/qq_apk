package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public g(String paramString)
  {
    AppMethodBeat.i(16564);
    ab.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", new Object[] { paramString });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new xj();
    ((b.a)localObject).fsY = new xk();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
    ((b.a)localObject).funcId = 1067;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (xj)this.rr.fsV.fta;
    ((xj)localObject).wxM = paramString;
    ((xj)localObject).wPb = com.tencent.mm.bv.b.bL(new byte[0]);
    AppMethodBeat.o(16564);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(16565);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(16565);
    return i;
  }
  
  public final int getType()
  {
    return 1067;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16566);
    ab.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(16566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.g
 * JD-Core Version:    0.7.0.1
 */