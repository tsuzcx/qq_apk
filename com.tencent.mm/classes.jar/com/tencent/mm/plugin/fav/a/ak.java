package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ab;

public final class ak
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public ak()
  {
    AppMethodBeat.i(102740);
    this.callback = null;
    b.a locala = new b.a();
    locala.fsX = new akm();
    locala.fsY = new akn();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.funcId = 438;
    locala.reqCmdId = 217;
    locala.respCmdId = 1000000217;
    this.rr = locala.ado();
    AppMethodBeat.o(102740);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(102741);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(102741);
    return i;
  }
  
  public final int getType()
  {
    return 438;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102742);
    ab.d("MicroMsg.NetSceneGetFavInfo", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (akn)((com.tencent.mm.ai.b)paramq).fsW.fta;
      ab.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(paramq.woK), Long.valueOf(paramq.jJR), Integer.valueOf(paramq.xbI), Integer.valueOf(paramq.xbH), Integer.valueOf(paramq.xbG) });
      b.jK(paramq.woK);
      b.jL(paramq.jJR);
      b.jN(paramq.xbI);
      b.jO(paramq.xbH);
      b.jP(paramq.xbG);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(102742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ak
 * JD-Core Version:    0.7.0.1
 */