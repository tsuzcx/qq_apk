package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ee;
import com.tencent.mm.protocal.protobuf.ef;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends q
  implements m
{
  private i callback;
  private final com.tencent.mm.ak.d rr;
  
  public d(String paramString)
  {
    AppMethodBeat.i(127578);
    d.a locala = new d.a();
    locala.iLN = new ee();
    locala.iLO = new ef();
    locala.uri = "/cgi-bin/micromsg-bin/androidfcmunreg";
    locala.funcId = 1059;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((ee)this.rr.iLK.iLR).KCv = paramString;
    AppMethodBeat.o(127578);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(127579);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(127579);
    return i;
  }
  
  public final int getType()
  {
    return 643;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127580);
    Log.i("MicroMsg.FCM.NetSceneFcmUnreg", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.d
 * JD-Core Version:    0.7.0.1
 */