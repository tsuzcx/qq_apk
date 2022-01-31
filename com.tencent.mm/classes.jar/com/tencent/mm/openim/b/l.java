package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.sdk.platformtools.ab;

public final class l
  extends m
  implements k
{
  private f callback;
  public j.b gfQ;
  private int opType;
  private final com.tencent.mm.ai.b rr;
  
  public l(j.b paramb)
  {
    AppMethodBeat.i(1008);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bir();
    ((b.a)localObject).fsY = new bis();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/openimoplog";
    ((b.a)localObject).funcId = 806;
    this.rr = ((b.a)localObject).ado();
    this.opType = paramb.oDV;
    this.gfQ = paramb;
    ab.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", new Object[] { Integer.valueOf(this.opType) });
    localObject = (bir)this.rr.fsV.fta;
    ((bir)localObject).type = this.opType;
    ((bir)localObject).xxv = new com.tencent.mm.bv.b(paramb.getBuffer());
    AppMethodBeat.o(1008);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(1009);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(1009);
    return i;
  }
  
  public final int getType()
  {
    return 806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(1010);
    ab.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.opType) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(1010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.l
 * JD-Core Version:    0.7.0.1
 */