package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ezx;
import com.tencent.mm.protocal.protobuf.ezy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ak
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public ak(String paramString)
  {
    AppMethodBeat.i(131145);
    c.a locala = new c.a();
    locala.otE = new ezx();
    locala.otF = new ezy();
    locala.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
    locala.funcId = 382;
    locala.otG = 181;
    locala.respCmdId = 1000000181;
    this.rr = locala.bEF();
    ((ezx)c.b.b(this.rr.otB)).YOy = Util.getCutPasswordMD5(paramString);
    Log.d("MicroMsg.NetSceneSetEmailPwd", "md5 ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(131145);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(131146);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131146);
    return i;
  }
  
  public final int getType()
  {
    return 382;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131147);
    Log.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ak
 * JD-Core Version:    0.7.0.1
 */