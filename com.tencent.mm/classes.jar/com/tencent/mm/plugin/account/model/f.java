package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  private i callback;
  public String fMb;
  private d iUB;
  
  public f(String paramString)
  {
    AppMethodBeat.i(196846);
    d.a locala = new d.a();
    xj localxj = new xj();
    localxj.fMb = paramString;
    this.fMb = paramString;
    locala.iLN = localxj;
    locala.iLO = new xk();
    locala.uri = "/cgi-bin/micromsg-bin/checkaliasvalid";
    locala.funcId = getType();
    this.iUB = locala.aXF();
    AppMethodBeat.o(196846);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(196847);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(196847);
    return i;
  }
  
  public final int getType()
  {
    return 3516;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196848);
    Log.i("MicroMsg.NetSceneCheckAliasValid", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(196848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.f
 * JD-Core Version:    0.7.0.1
 */