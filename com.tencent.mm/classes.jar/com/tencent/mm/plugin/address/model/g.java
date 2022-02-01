package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(20783);
    d.a locala = new d.a();
    locala.iLN = new djp();
    locala.iLO = new djq();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
    locala.funcId = 419;
    locala.iLP = 204;
    locala.respCmdId = 1000000204;
    this.rr = locala.aXF();
    ((djp)this.rr.iLK.iLR).id = paramInt;
    AppMethodBeat.o(20783);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(20785);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20785);
    return i;
  }
  
  public final int getType()
  {
    return 419;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20784);
    Log.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (djq)((d)params).iLL.iLR;
      if (params.MNs.MNv != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + params.MNs.MNv.size());
        a.bqb();
        a.bqd().t(params.MNs.MNv);
        a.bqb();
        a.bqd().bqf();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.g
 * JD-Core Version:    0.7.0.1
 */