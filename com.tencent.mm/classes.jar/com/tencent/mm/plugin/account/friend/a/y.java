package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  private i callback;
  public d hJu;
  
  public y(String paramString)
  {
    AppMethodBeat.i(184422);
    d.a locala = new d.a();
    locala.funcId = getType();
    mf localmf = new mf();
    localmf.dTx = paramString;
    locala.iLN = localmf;
    locala.uri = "/cgi-bin/micromsg-bin/bindoldwx";
    locala.iLO = new mg();
    this.hJu = locala.aXF();
    AppMethodBeat.o(184422);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(184423);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(184423);
    return i;
  }
  
  public final int getType()
  {
    return 870;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(184424);
    Log.i("MicroMsg.NetSceneBindOldWx", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(184424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.y
 * JD-Core Version:    0.7.0.1
 */