package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ber;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d
  extends m
  implements k
{
  private f callback;
  private LinkedList<cpk> nXZ;
  private final b rr;
  
  public d(LinkedList<cpk> paramLinkedList)
  {
    AppMethodBeat.i(22530);
    this.nXZ = new LinkedList();
    b.a locala = new b.a();
    locala.fsX = new ber();
    locala.fsY = new bes();
    locala.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
    locala.funcId = 638;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.nXZ = paramLinkedList;
    AppMethodBeat.o(22530);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(22532);
    ab.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
    this.callback = paramf;
    paramf = (ber)this.rr.fsV.fta;
    paramf.xur = this.nXZ;
    paramf.xaL = this.nXZ.size();
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(22532);
    return i;
  }
  
  public final int getType()
  {
    return 638;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22531);
    ab.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(22531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.d
 * JD-Core Version:    0.7.0.1
 */