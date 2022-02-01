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
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends q
  implements m
{
  private i jQg;
  public final d lyx;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(121056);
    d.a locala = new d.a();
    locala.lBU = new ccp();
    locala.lBV = new ccq();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.lyx = locala.bgN();
    ((ccp)d.b.b(this.lyx.lBR)).TkK = paramInt;
    AppMethodBeat.o(121056);
  }
  
  public final ccq bgZ()
  {
    AppMethodBeat.i(207607);
    ccq localccq = (ccq)d.c.b(this.lyx.lBS);
    AppMethodBeat.o(207607);
    return localccq;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(121058);
    Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.lyx, this);
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
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.r
 * JD-Core Version:    0.7.0.1
 */