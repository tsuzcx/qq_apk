package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dse;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends q
  implements m
{
  private i callback;
  d rr;
  
  public u(String paramString)
  {
    AppMethodBeat.i(23410);
    this.callback = null;
    this.rr = null;
    d.a locala = new d.a();
    locala.iLN = new dse();
    locala.iLO = new dsf();
    locala.uri = "/cgi-bin/micromsg-bin/searchharddevice";
    locala.funcId = 540;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((dse)this.rr.iLK.iLR).MUJ = paramString;
    AppMethodBeat.o(23410);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(23412);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23412);
    return i;
  }
  
  public final int getType()
  {
    return 540;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23411);
    Log.i("MicroMsg.exdevice.NetSceneSearchHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.u
 * JD-Core Version:    0.7.0.1
 */