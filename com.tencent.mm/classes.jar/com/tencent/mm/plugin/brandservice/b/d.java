package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends m
  implements k
{
  private f callback;
  public b rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(13833);
    b.a locala = new b.a();
    locala.fsX = new bbn();
    locala.fsY = new bbo();
    locala.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
    locala.funcId = 1031;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((bbn)this.rr.fsV.fta).xli = paramString;
    AppMethodBeat.o(13833);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(13835);
    this.callback = paramf;
    ab.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13835);
    return i;
  }
  
  public final int getType()
  {
    return 1031;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13834);
    ab.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(13834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.d
 * JD-Core Version:    0.7.0.1
 */