package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.protocal.protobuf.eca;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class m
  extends n
  implements k
{
  private f callback;
  private b rr;
  private dbk uZm;
  public dbl uZn;
  
  public m(int paramInt1, int paramInt2, LinkedList<eca> paramLinkedList)
  {
    AppMethodBeat.i(25487);
    this.rr = null;
    this.uZm = null;
    this.uZn = null;
    b.a locala = new b.a();
    locala.hQF = new dbk();
    locala.hQG = new dbl();
    locala.funcId = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.uZm = ((dbk)this.rr.hQD.hQJ);
    this.uZm.HnP = paramInt2;
    this.uZm.HKk = paramLinkedList;
    this.uZm.HKj = paramLinkedList.size();
    this.uZm.HKl = paramInt1;
    ae.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(25487);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25488);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(25488);
    return i;
  }
  
  public final int getType()
  {
    return 871;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25489);
    ae.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uZn = ((dbl)((b)paramq).hQE.hQJ);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.m
 * JD-Core Version:    0.7.0.1
 */