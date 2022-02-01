package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(90685);
    d.a locala = new d.a();
    locala.iLN = new agi();
    locala.iLO = new agj();
    locala.uri = "/cgi-bin/micromsg-bin/deletecardimg";
    locala.funcId = 576;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((agi)this.rr.iLK.iLR).Lqx = paramString;
    AppMethodBeat.o(90685);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(90686);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(90686);
    return i;
  }
  
  public final int getType()
  {
    return 576;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90687);
    Log.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(90687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bd.a
 * JD-Core Version:    0.7.0.1
 */