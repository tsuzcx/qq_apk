package com.tencent.mm.openim.b;

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
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.sdk.platformtools.Log;

public final class j
  extends q
  implements m
{
  private i callback;
  public String dVa;
  private final d rr;
  
  public j(String paramString)
  {
    AppMethodBeat.i(151206);
    d.a locala = new d.a();
    locala.iLN = new bru();
    locala.iLO = new brv();
    locala.uri = "/cgi-bin/micromsg-bin/getopenurl";
    locala.funcId = 913;
    this.rr = locala.aXF();
    Log.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", new Object[] { paramString });
    ((bru)this.rr.iLK.iLR).userName = paramString;
    AppMethodBeat.o(151206);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151207);
    this.callback = parami;
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
    this.dVa = ((brv)this.rr.iLL.iLR).dVa;
    Log.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", new Object[] { this.dVa });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.j
 * JD-Core Version:    0.7.0.1
 */