package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.sdk.platformtools.Log;

public final class s
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public String username;
  
  public s(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151222);
    c.a locala = new c.a();
    this.username = paramString2;
    dpv localdpv = new dpv();
    localdpv.pss = paramString1;
    localdpv.aaWx = new dxf();
    localdpv.aaWx.userName = paramString2;
    locala.otE = localdpv;
    locala.otF = new dpw();
    locala.uri = "/cgi-bin/micromsg-bin/modopenimchatroomowner";
    locala.funcId = 811;
    this.rr = locala.bEF();
    AppMethodBeat.o(151222);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151223);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151223);
    return i;
  }
  
  public final int getType()
  {
    return 811;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151224);
    Log.w("MicroMsg.NetSceneTransferOpenImChatRoomOwner", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.model.s
 * JD-Core Version:    0.7.0.1
 */