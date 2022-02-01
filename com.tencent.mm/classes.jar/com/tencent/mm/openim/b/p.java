package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String username;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151222);
    d.a locala = new d.a();
    this.username = paramString2;
    cpy localcpy = new cpy();
    localcpy.jHa = paramString1;
    localcpy.MvS = new cvt();
    localcpy.MvS.userName = paramString2;
    locala.iLN = localcpy;
    locala.iLO = new cpz();
    locala.uri = "/cgi-bin/micromsg-bin/modopenimchatroomowner";
    locala.funcId = 811;
    this.rr = locala.aXF();
    AppMethodBeat.o(151222);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151223);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151223);
    return i;
  }
  
  public final int getType()
  {
    return 811;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151224);
    Log.w("MicroMsg.NetSceneTransferOpenImChatRoomOwner", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.p
 * JD-Core Version:    0.7.0.1
 */