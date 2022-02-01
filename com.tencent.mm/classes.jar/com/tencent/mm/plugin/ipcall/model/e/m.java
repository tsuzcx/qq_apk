package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.protocal.protobuf.dup;
import com.tencent.mm.protocal.protobuf.ewh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private d rr;
  private duo yrM;
  public dup yrN;
  
  public m(int paramInt1, int paramInt2, LinkedList<ewh> paramLinkedList)
  {
    AppMethodBeat.i(25487);
    this.rr = null;
    this.yrM = null;
    this.yrN = null;
    d.a locala = new d.a();
    locala.iLN = new duo();
    locala.iLO = new dup();
    locala.funcId = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yrM = ((duo)this.rr.iLK.iLR);
    this.yrM.Mvj = paramInt2;
    this.yrM.MVU = paramLinkedList;
    this.yrM.MVT = paramLinkedList.size();
    this.yrM.MVV = paramInt1;
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
    this.yrN = ((dup)((d)params).iLL.iLR);
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