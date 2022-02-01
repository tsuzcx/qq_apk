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
import com.tencent.mm.protocal.protobuf.fex;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends q
  implements m
{
  private i heq;
  private final d iIu;
  
  public s(String paramString)
  {
    AppMethodBeat.i(121059);
    d.a locala = new d.a();
    locala.iLN = new fex();
    locala.iLO = new fey();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iIu = locala.aXF();
    ((fex)this.iIu.iLK.iLR).NAm = paramString;
    AppMethodBeat.o(121059);
  }
  
  public final fey aXR()
  {
    if (this.iIu != null) {
      return (fey)this.iIu.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(121061);
    Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.iIu, this);
    AppMethodBeat.o(121061);
    return i;
  }
  
  public final int getType()
  {
    return 1198;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121060);
    Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.s
 * JD-Core Version:    0.7.0.1
 */