package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String yBU;
  
  public b(String paramString)
  {
    AppMethodBeat.i(26146);
    this.yBU = null;
    d.a locala = new d.a();
    locala.iLN = new afi();
    locala.iLO = new afj();
    locala.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
    locala.funcId = 636;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.yBU = paramString;
    AppMethodBeat.o(26146);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26148);
    this.callback = parami;
    afi localafi = (afi)this.rr.iLK.iLR;
    localafi.Lqm = this.yBU;
    if ((this.yBU != null) && (!Util.isNullOrNil(this.yBU)))
    {
      localafi.Lqm = this.yBU;
      localafi.Lqm = this.yBU;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26148);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
    parami.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
    AppMethodBeat.o(26148);
    return 0;
  }
  
  public final int getType()
  {
    return 636;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26147);
    Log.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.b
 * JD-Core Version:    0.7.0.1
 */