package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.ai.m
  implements k
{
  private f callback;
  private bzp nPj;
  public bzq nPk;
  private b rr;
  
  public m(int paramInt1, int paramInt2, LinkedList<cux> paramLinkedList)
  {
    AppMethodBeat.i(21872);
    this.rr = null;
    this.nPj = null;
    this.nPk = null;
    b.a locala = new b.a();
    locala.fsX = new bzp();
    locala.fsY = new bzq();
    locala.funcId = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.nPj = ((bzp)this.rr.fsV.fta);
    this.nPj.xtq = paramInt2;
    this.nPj.xLq = paramLinkedList;
    this.nPj.xLp = paramLinkedList.size();
    this.nPj.xLr = paramInt1;
    ab.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(21872);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(21873);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(21873);
    return i;
  }
  
  public final int getType()
  {
    return 871;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21874);
    ab.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.nPk = ((bzq)((b)paramq).fsW.fta);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(21874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.d.m
 * JD-Core Version:    0.7.0.1
 */