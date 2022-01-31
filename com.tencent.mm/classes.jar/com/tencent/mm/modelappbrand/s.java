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
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.ab;

public final class s
  extends m
  implements k
{
  private f eGj;
  private final b fpW;
  
  public s(String paramString)
  {
    AppMethodBeat.i(93743);
    b.a locala = new b.a();
    locala.fsX = new dbq();
    locala.fsY = new dbr();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fpW = locala.ado();
    ((dbq)this.fpW.fsV.fta).yhV = paramString;
    AppMethodBeat.o(93743);
  }
  
  public final dbr acw()
  {
    if (this.fpW != null) {
      return (dbr)this.fpW.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(93745);
    ab.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.fpW, this);
    AppMethodBeat.o(93745);
    return i;
  }
  
  public final int getType()
  {
    return 1198;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93744);
    ab.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(93744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.s
 * JD-Core Version:    0.7.0.1
 */