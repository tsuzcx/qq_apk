package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class s
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public final c omC;
  
  public s()
  {
    AppMethodBeat.i(20638);
    c.a locala = new c.a();
    locala.otE = new crq();
    locala.otF = new crr();
    locala.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
    locala.funcId = 725;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.omC = locala.bEF();
    ((crq)c.b.b(this.omC.otB)).vhJ = 0;
    Log.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[] { Integer.valueOf(0), Util.getStack() });
    AppMethodBeat.o(20638);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(20640);
    this.callback = paramh;
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 1L, 1L, true);
    int i = dispatch(paramg, this.omC, this);
    AppMethodBeat.o(20640);
    return i;
  }
  
  public final int getType()
  {
    return 725;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20639);
    Log.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 2L, 1L, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.s
 * JD-Core Version:    0.7.0.1
 */