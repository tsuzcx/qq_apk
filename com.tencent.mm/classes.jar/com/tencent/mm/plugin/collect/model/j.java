package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends m
  implements k
{
  private f callback;
  private b goo;
  public pq kNs;
  
  public j()
  {
    AppMethodBeat.i(40970);
    b.a locala = new b.a();
    locala.fsX = new pp();
    locala.fsY = new pq();
    locala.funcId = 1256;
    locala.uri = "/cgi-bin/mmpay-bin/f2fannounce";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    ab.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
    AppMethodBeat.o(40970);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(40971);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(40971);
    return i;
  }
  
  public final int getType()
  {
    return 1256;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40972);
    ab.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.kNs = ((pq)((b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(40972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.j
 * JD-Core Version:    0.7.0.1
 */