package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends p
  implements m
{
  private cvp JID;
  public cvq JIE;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public c()
  {
    AppMethodBeat.i(25457);
    this.rr = null;
    this.JID = null;
    this.JIE = null;
    this.callback = null;
    c.a locala = new c.a();
    locala.otE = new cvp();
    locala.otF = new cvq();
    locala.funcId = 746;
    locala.uri = "/cgi-bin/micromsg-bin/getwcocallinfo";
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.JID = ((cvp)c.b.b(this.rr.otB));
    Log.i("MicroMsg.NetSceneIPCallGetCallInfo", "NetSceneIPCallGetCallInfo");
    AppMethodBeat.o(25457);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(25458);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(25458);
    return i;
  }
  
  public final int getType()
  {
    return 746;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25459);
    Log.i("MicroMsg.NetSceneIPCallGetCallInfo", "onGYNetEnd, errType: %d, errCode: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.JIE = ((cvq)c.c.b(((com.tencent.mm.am.c)params).otC));
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e.c
 * JD-Core Version:    0.7.0.1
 */