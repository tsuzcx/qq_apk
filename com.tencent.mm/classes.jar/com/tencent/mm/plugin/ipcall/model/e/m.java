package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class m
  extends n
  implements k
{
  private g callback;
  private b rr;
  private cve tKM;
  public cvf tKN;
  
  public m(int paramInt1, int paramInt2, LinkedList<dup> paramLinkedList)
  {
    AppMethodBeat.i(25487);
    this.rr = null;
    this.tKM = null;
    this.tKN = null;
    b.a locala = new b.a();
    locala.hvt = new cve();
    locala.hvu = new cvf();
    locala.funcId = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.tKM = ((cve)this.rr.hvr.hvw);
    this.tKM.FkG = paramInt2;
    this.tKM.FGg = paramLinkedList;
    this.tKM.FGf = paramLinkedList.size();
    this.tKM.FGh = paramInt1;
    ac.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramLinkedList.size()) });
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
    ac.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.tKN = ((cvf)((b)paramq).hvs.hvw);
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