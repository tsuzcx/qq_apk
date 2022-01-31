package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.sdk.platformtools.ab;

public final class p
  extends m
  implements k
{
  private f eGj;
  public final b fpW;
  
  public p(int paramInt)
  {
    AppMethodBeat.i(93733);
    b.a locala = new b.a();
    locala.fsX = new app();
    locala.fsY = new apq();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fpW = locala.ado();
    ((app)this.fpW.fsV.fta).xfs = paramInt;
    AppMethodBeat.o(93733);
  }
  
  public final apq acs()
  {
    return (apq)this.fpW.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(93735);
    ab.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.fpW, this);
    AppMethodBeat.o(93735);
    return i;
  }
  
  public final int getType()
  {
    return 1145;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93734);
    ab.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(93734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.p
 * JD-Core Version:    0.7.0.1
 */