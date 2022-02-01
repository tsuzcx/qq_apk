package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bnm;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.Log;

public final class al
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public al()
  {
    AppMethodBeat.i(103480);
    this.callback = null;
    d.a locala = new d.a();
    locala.iLN = new bnm();
    locala.iLO = new bnn();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.funcId = 438;
    locala.iLP = 217;
    locala.respCmdId = 1000000217;
    this.rr = locala.aXF();
    AppMethodBeat.o(103480);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103481);
    this.callback = parami;
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
      params = (bnn)((d)params).iLL.iLR;
      Log.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(params.KHg), Long.valueOf(params.oTV), Integer.valueOf(params.LWb), Integer.valueOf(params.LWa), Integer.valueOf(params.LVZ) });
      b.DH(params.KHg);
      b.DI(params.oTV);
      b.DK(params.LWb);
      b.DL(params.LWa);
      b.DM(params.LVZ);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.al
 * JD-Core Version:    0.7.0.1
 */