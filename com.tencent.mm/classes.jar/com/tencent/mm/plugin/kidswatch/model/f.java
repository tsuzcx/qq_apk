package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgp;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  private i callback;
  private final d iUB;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(256401);
    d.a locala = new d.a();
    cgp localcgp = new cgp();
    cgq localcgq = new cgq();
    locala.iLN = localcgp;
    locala.iLO = localcgq;
    locala.uri = "/cgi-bin/micromsg-bin/kidswatchloginconfirmget";
    locala.funcId = 5218;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iUB = locala.aXF();
    localcgp.LtA = paramString1;
    localcgp.oTI = paramString2;
    Log.d("MicroMsg.NetSceneKidsWatchLoginConfirmGet", "[NetSceneKidsWatchLoginConfirmGet]loginUrl:%s, deviceName:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(256401);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(256402);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(256402);
    return i;
  }
  
  public final cgq ebU()
  {
    return (cgq)this.iUB.iLL.iLR;
  }
  
  public final int getType()
  {
    return 5218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256403);
    Log.d("MicroMsg.NetSceneKidsWatchLoginConfirmGet", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(256403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.f
 * JD-Core Version:    0.7.0.1
 */