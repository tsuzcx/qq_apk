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
import com.tencent.mm.protocal.protobuf.gnb;
import com.tencent.mm.protocal.protobuf.gnc;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends p
  implements m
{
  private h mAY;
  private final c opY;
  
  public s(String paramString)
  {
    AppMethodBeat.i(121059);
    c.a locala = new c.a();
    locala.otE = new gnb();
    locala.otF = new gnc();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.opY = locala.bEF();
    ((gnb)c.b.b(this.opY.otB)).acil = paramString;
    AppMethodBeat.o(121059);
  }
  
  public final gnc bER()
  {
    AppMethodBeat.i(233815);
    if (this.opY != null)
    {
      gnc localgnc = (gnc)c.c.b(this.opY.otC);
      AppMethodBeat.o(233815);
      return localgnc;
    }
    AppMethodBeat.o(233815);
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(121061);
    Log.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.opY, this);
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
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.s
 * JD-Core Version:    0.7.0.1
 */