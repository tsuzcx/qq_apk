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
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.protocal.protobuf.elu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private cgu yBW;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(26155);
    this.yBW = null;
    d.a locala = new d.a();
    locala.iLN = new elt();
    locala.iLO = new elu();
    locala.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
    locala.funcId = 637;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    if ((paramInt >= 0) && (!Util.isNullOrNil(paramString)))
    {
      this.yBW = new cgu();
      this.yBW.Mmc = paramInt;
      this.yBW.Mmb = paramString;
    }
    AppMethodBeat.o(26155);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26157);
    this.callback = parami;
    elt localelt = (elt)this.rr.iLK.iLR;
    if (this.yBW != null)
    {
      localelt.NkF = this.yBW;
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26157);
      return i;
    }
    Log.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
    parami.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
    AppMethodBeat.o(26157);
    return 0;
  }
  
  public final int getType()
  {
    return 637;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26156);
    Log.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.e
 * JD-Core Version:    0.7.0.1
 */