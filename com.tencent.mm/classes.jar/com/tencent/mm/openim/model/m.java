package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  public String hUv;
  private final c rr;
  
  public m(String paramString)
  {
    AppMethodBeat.i(151206);
    c.a locala = new c.a();
    locala.otE = new coz();
    locala.otF = new cpa();
    locala.uri = "/cgi-bin/micromsg-bin/getopenurl";
    locala.funcId = 913;
    this.rr = locala.bEF();
    Log.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", new Object[] { paramString });
    ((coz)c.b.b(this.rr.otB)).userName = paramString;
    AppMethodBeat.o(151206);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151207);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151207);
    return i;
  }
  
  public final int getType()
  {
    return 913;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151208);
    Log.i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151208);
      return;
    }
    this.hUv = ((cpa)c.c.b(this.rr.otC)).hUv;
    Log.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", new Object[] { this.hUv });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.model.m
 * JD-Core Version:    0.7.0.1
 */