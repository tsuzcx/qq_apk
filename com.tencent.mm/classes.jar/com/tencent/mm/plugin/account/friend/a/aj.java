package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.bzo;

public final class aj
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public aj(String paramString)
  {
    AppMethodBeat.i(108481);
    b.a locala = new b.a();
    locala.fsX = new bzn();
    locala.fsY = new bzo();
    locala.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
    locala.funcId = 108;
    locala.reqCmdId = 43;
    locala.respCmdId = 1000000043;
    this.rr = locala.ado();
    ((bzn)this.rr.fsV.fta).wOT = new bwc().aoF(paramString);
    AppMethodBeat.o(108481);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108482);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108482);
    return i;
  }
  
  public final int getType()
  {
    return 108;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108483);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aj
 * JD-Core Version:    0.7.0.1
 */