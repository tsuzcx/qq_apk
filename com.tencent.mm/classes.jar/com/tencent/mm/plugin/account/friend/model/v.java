package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.protocal.protobuf.mx;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends p
  implements m
{
  private h callback;
  public c nao;
  
  public v(String paramString)
  {
    AppMethodBeat.i(184422);
    c.a locala = new c.a();
    locala.funcId = getType();
    mw localmw = new mw();
    localmw.hSC = paramString;
    locala.otE = localmw;
    locala.uri = "/cgi-bin/micromsg-bin/bindoldwx";
    locala.otF = new mx();
    this.nao = locala.bEF();
    AppMethodBeat.o(184422);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(184423);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.v
 * JD-Core Version:    0.7.0.1
 */