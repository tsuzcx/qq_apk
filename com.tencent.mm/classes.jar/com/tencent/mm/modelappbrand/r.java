package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.sdk.platformtools.Log;

public final class r
  extends p
  implements m
{
  private h mAY;
  public final c opY;
  
  public r(int paramInt)
  {
    AppMethodBeat.i(121056);
    c.a locala = new c.a();
    locala.otE = new csb();
    locala.otF = new csc();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.opY = locala.bEF();
    ((csb)c.b.b(this.opY.otB)).aayr = paramInt;
    AppMethodBeat.o(121056);
  }
  
  public final csc bEQ()
  {
    AppMethodBeat.i(233817);
    csc localcsc = (csc)c.c.b(this.opY.otC);
    AppMethodBeat.o(233817);
    return localcsc;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(121058);
    Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.opY, this);
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
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.r
 * JD-Core Version:    0.7.0.1
 */