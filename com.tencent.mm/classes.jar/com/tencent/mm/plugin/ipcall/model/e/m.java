package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class m
  extends n
  implements k
{
  private f callback;
  private b rr;
  public dar uNA;
  private daq uNz;
  
  public m(int paramInt1, int paramInt2, LinkedList<eaj> paramLinkedList)
  {
    AppMethodBeat.i(25487);
    this.rr = null;
    this.uNz = null;
    this.uNA = null;
    b.a locala = new b.a();
    locala.hNM = new daq();
    locala.hNN = new dar();
    locala.funcId = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.uNz = ((daq)this.rr.hNK.hNQ);
    this.uNz.GUo = paramInt2;
    this.uNz.HqI = paramLinkedList;
    this.uNz.HqH = paramLinkedList.size();
    this.uNz.HqJ = paramInt1;
    ad.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramLinkedList.size()) });
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
    ad.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.uNA = ((dar)((b)paramq).hNL.hNQ);
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