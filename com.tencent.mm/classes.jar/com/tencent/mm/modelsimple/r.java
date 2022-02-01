package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class r
  extends q
  implements m
{
  private i callback;
  public final d iFd;
  
  public r()
  {
    AppMethodBeat.i(20638);
    d.a locala = new d.a();
    locala.iLN = new buo();
    locala.iLO = new bup();
    locala.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
    locala.funcId = 725;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iFd = locala.aXF();
    ((buo)this.iFd.iLK.iLR).oUv = 0;
    Log.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[] { Integer.valueOf(0), Util.getStack() });
    AppMethodBeat.o(20638);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(20640);
    this.callback = parami;
    h.CyF.idkeyStat(405L, 1L, 1L, true);
    int i = dispatch(paramg, this.iFd, this);
    AppMethodBeat.o(20640);
    return i;
  }
  
  public final int getType()
  {
    return 725;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20639);
    Log.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      h.CyF.idkeyStat(405L, 2L, 1L, true);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.r
 * JD-Core Version:    0.7.0.1
 */