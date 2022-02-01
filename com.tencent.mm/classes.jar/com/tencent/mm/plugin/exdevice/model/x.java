package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.evs;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends p
  implements m
{
  private h callback;
  c rr;
  
  public x(String paramString)
  {
    AppMethodBeat.i(23410);
    this.callback = null;
    this.rr = null;
    c.a locala = new c.a();
    locala.otE = new evr();
    locala.otF = new evs();
    locala.uri = "/cgi-bin/micromsg-bin/searchharddevice";
    locala.funcId = 540;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((evr)c.b.b(this.rr.otB)).abyu = paramString;
    AppMethodBeat.o(23410);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23412);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.x
 * JD-Core Version:    0.7.0.1
 */