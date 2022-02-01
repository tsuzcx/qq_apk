package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends p
  implements m
{
  private h callback;
  public final c oDw;
  
  public e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(262253);
    c.a locala = new c.a();
    dgf localdgf = new dgf();
    dgg localdgg = new dgg();
    locala.otE = localdgf;
    locala.otF = localdgg;
    locala.uri = "/cgi-bin/micromsg-bin/kidswatchloginconfirmget";
    locala.funcId = 5218;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.oDw = locala.bEF();
    localdgf.Zwg = paramString1;
    localdgf.vgW = paramString2;
    Log.d("MicroMsg.NetSceneKidsWatchLoginConfirmGet", "[NetSceneKidsWatchLoginConfirmGet]loginUrl:%s, deviceName:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(262253);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(262272);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
    AppMethodBeat.o(262272);
    return i;
  }
  
  public final int getType()
  {
    return 5218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(262284);
    Log.d("MicroMsg.NetSceneKidsWatchLoginConfirmGet", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(262284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.e
 * JD-Core Version:    0.7.0.1
 */