package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.fpy;
import com.tencent.mm.protocal.protobuf.fpz;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends q
  implements m
{
  private i jQg;
  private final d lyx;
  
  public s(String paramString)
  {
    AppMethodBeat.i(121059);
    d.a locala = new d.a();
    locala.lBU = new fpy();
    locala.lBV = new fpz();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.lyx = locala.bgN();
    ((fpy)d.b.b(this.lyx.lBR)).UNO = paramString;
    AppMethodBeat.o(121059);
  }
  
  public final fpz bha()
  {
    AppMethodBeat.i(207425);
    if (this.lyx != null)
    {
      fpz localfpz = (fpz)d.c.b(this.lyx.lBS);
      AppMethodBeat.o(207425);
      return localfpz;
    }
    AppMethodBeat.o(207425);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(121061);
    Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.lyx, this);
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
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.s
 * JD-Core Version:    0.7.0.1
 */