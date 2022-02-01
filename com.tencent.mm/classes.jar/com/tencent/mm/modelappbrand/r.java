package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private i heq;
  public final d iIu;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(121056);
    d.a locala = new d.a();
    locala.iLN = new bux();
    locala.iLO = new buy();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iIu = locala.aXF();
    ((bux)this.iIu.iLK.iLR).Mbn = paramInt;
    AppMethodBeat.o(121056);
  }
  
  public final buy aXQ()
  {
    return (buy)this.iIu.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(121058);
    Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.iIu, this);
    AppMethodBeat.o(121058);
    return i;
  }
  
  public final int getType()
  {
    return 1145;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121057);
    Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.r
 * JD-Core Version:    0.7.0.1
 */