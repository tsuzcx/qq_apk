package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.sdk.platformtools.Log;

public final class am
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public am()
  {
    AppMethodBeat.i(103480);
    this.callback = null;
    d.a locala = new d.a();
    locala.lBU = new bvc();
    locala.lBV = new bvd();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.funcId = 438;
    locala.lBW = 217;
    locala.respCmdId = 1000000217;
    this.rr = locala.bgN();
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
      params = (bvd)d.c.b(((d)params).lBS);
      Log.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(params.RIy), Long.valueOf(params.rVT), Integer.valueOf(params.Tfj), Integer.valueOf(params.Tfi), Integer.valueOf(params.Tfh) });
      b.JV(params.RIy);
      b.JW(params.rVT);
      b.JY(params.Tfj);
      b.JZ(params.Tfi);
      b.Ka(params.Tfh);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.am
 * JD-Core Version:    0.7.0.1
 */