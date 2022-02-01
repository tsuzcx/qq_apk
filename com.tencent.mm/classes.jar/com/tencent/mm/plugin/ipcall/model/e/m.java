package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class m
  extends n
  implements k
{
  private g callback;
  private b rr;
  private cpx sDe;
  public cpy sDf;
  
  public m(int paramInt1, int paramInt2, LinkedList<doy> paramLinkedList)
  {
    AppMethodBeat.i(25487);
    this.rr = null;
    this.sDe = null;
    this.sDf = null;
    b.a locala = new b.a();
    locala.gUU = new cpx();
    locala.gUV = new cpy();
    locala.funcId = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.sDe = ((cpx)this.rr.gUS.gUX);
    this.sDe.DOp = paramInt2;
    this.sDe.Eji = paramLinkedList;
    this.sDe.Ejh = paramLinkedList.size();
    this.sDe.Ejj = paramInt1;
    ad.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(25487);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(25488);
    this.callback = paramg;
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
    ad.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.sDf = ((cpy)((b)paramq).gUT.gUX);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.m
 * JD-Core Version:    0.7.0.1
 */