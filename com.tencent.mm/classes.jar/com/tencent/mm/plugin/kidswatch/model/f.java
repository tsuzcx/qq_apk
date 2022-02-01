package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  private i callback;
  private final d lKU;
  
  public f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(252071);
    d.a locala = new d.a();
    cpl localcpl = new cpl();
    cpm localcpm = new cpm();
    locala.lBU = localcpl;
    locala.lBV = localcpm;
    locala.uri = "/cgi-bin/micromsg-bin/kidswatchloginconfirmget";
    locala.funcId = 5218;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.lKU = locala.bgN();
    localcpl.SvX = paramString1;
    localcpl.rVG = paramString2;
    Log.d("MicroMsg.NetSceneKidsWatchLoginConfirmGet", "[NetSceneKidsWatchLoginConfirmGet]loginUrl:%s, deviceName:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(252071);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(252073);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(252073);
    return i;
  }
  
  public final cpm eKS()
  {
    AppMethodBeat.i(252077);
    cpm localcpm = (cpm)d.c.b(this.lKU.lBS);
    AppMethodBeat.o(252077);
    return localcpm;
  }
  
  public final int getType()
  {
    return 5218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(252075);
    Log.d("MicroMsg.NetSceneKidsWatchLoginConfirmGet", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(252075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.f
 * JD-Core Version:    0.7.0.1
 */