package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ees;
import com.tencent.mm.protocal.protobuf.eet;
import com.tencent.mm.protocal.protobuf.fgt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private ees DRO;
  public eet DRP;
  private i callback;
  private d rr;
  
  public m(int paramInt1, int paramInt2, LinkedList<fgt> paramLinkedList)
  {
    AppMethodBeat.i(25487);
    this.rr = null;
    this.DRO = null;
    this.DRP = null;
    d.a locala = new d.a();
    locala.lBU = new ees();
    locala.lBV = new eet();
    locala.funcId = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.DRO = ((ees)d.b.b(this.rr.lBR));
    this.DRO.TGh = paramInt2;
    this.DRO.Uip = paramLinkedList;
    this.DRO.Uio = paramLinkedList.size();
    this.DRO.Uiq = paramInt1;
    Log.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(25487);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(25488);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25488);
    return i;
  }
  
  public final int getType()
  {
    return 871;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25489);
    Log.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.DRP = ((eet)d.c.b(((d)params).lBS));
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