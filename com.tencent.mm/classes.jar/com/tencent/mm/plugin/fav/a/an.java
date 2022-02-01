package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.sdk.platformtools.Log;

public final class an
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public an()
  {
    AppMethodBeat.i(103480);
    this.callback = null;
    c.a locala = new c.a();
    locala.otE = new cka();
    locala.otF = new ckb();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.funcId = 438;
    locala.otG = 217;
    locala.respCmdId = 1000000217;
    this.rr = locala.bEF();
    AppMethodBeat.o(103480);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103481);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103481);
    return i;
  }
  
  public final int getType()
  {
    return 438;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103482);
    Log.d("MicroMsg.NetSceneGetFavInfo", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ckb)c.c.b(((c)params).otC);
      Log.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(params.YFA), Long.valueOf(params.vhj), Integer.valueOf(params.aasD), Integer.valueOf(params.aasC), Integer.valueOf(params.aasB) });
      b.mt(params.YFA);
      b.mu(params.vhj);
      b.mw(params.aasD);
      b.mx(params.aasC);
      b.my(params.aasB);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.an
 * JD-Core Version:    0.7.0.1
 */