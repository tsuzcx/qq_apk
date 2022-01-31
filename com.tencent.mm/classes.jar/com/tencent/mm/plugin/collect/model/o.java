package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends m
  implements k
{
  private f callback;
  private b goo;
  private cba kNL;
  
  public o(String paramString)
  {
    AppMethodBeat.i(40986);
    b.a locala = new b.a();
    locala.fsX = new cba();
    locala.fsY = new cbb();
    locala.funcId = 304;
    locala.uri = "/cgi-bin/micromsg-bin/setpushsound";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.goo = locala.ado();
    this.kNL = ((cba)this.goo.fsV.fta);
    this.kNL.jKs = 3;
    this.kNL.xLV = paramString;
    ab.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", new Object[] { Integer.valueOf(3), paramString });
    AppMethodBeat.o(40986);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(40987);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(40987);
    return i;
  }
  
  public final int getType()
  {
    return 304;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(40988);
    ab.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(40988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.o
 * JD-Core Version:    0.7.0.1
 */