package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eyl;
import com.tencent.mm.protocal.protobuf.eym;
import com.tencent.mm.protocal.protobuf.gdf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private eyl JIY;
  public eym JIZ;
  private h callback;
  private c rr;
  
  public m(int paramInt1, int paramInt2, LinkedList<gdf> paramLinkedList)
  {
    AppMethodBeat.i(25487);
    this.rr = null;
    this.JIY = null;
    this.JIZ = null;
    c.a locala = new c.a();
    locala.otE = new eyl();
    locala.otF = new eym();
    locala.funcId = 871;
    locala.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.JIY = ((eyl)c.b.b(this.rr.otB));
    this.JIY.aaVN = paramInt2;
    this.JIY.abzP = paramLinkedList;
    this.JIY.abzO = paramLinkedList.size();
    this.JIY.abzQ = paramInt1;
    Log.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(25487);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(25488);
    this.callback = paramh;
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
    this.JIZ = ((eym)c.c.b(((c)params).otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.m
 * JD-Core Version:    0.7.0.1
 */