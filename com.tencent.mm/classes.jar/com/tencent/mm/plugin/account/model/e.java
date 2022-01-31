package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.bns;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends m
  implements k
{
  private f callback;
  private bnr gAO;
  private b goo;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(124679);
    b.a locala = new b.a();
    locala.fsX = new bnr();
    locala.fsY = new bns();
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    locala.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
    this.goo = locala.ado();
    this.gAO = ((bnr)this.goo.fsV.fta);
    this.gAO.xBU = paramInt;
    this.gAO.gwY = paramString;
    AppMethodBeat.o(124679);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(124680);
    this.callback = paramf;
    int i = dispatch(parame, this.goo, this);
    AppMethodBeat.o(124680);
    return i;
  }
  
  public final int getType()
  {
    return 268;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124681);
    ab.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.e
 * JD-Core Version:    0.7.0.1
 */