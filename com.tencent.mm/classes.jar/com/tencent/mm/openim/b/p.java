package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.bef;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.sdk.platformtools.ab;

public final class p
  extends m
  implements k
{
  private f callback;
  private final b rr;
  public String username;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(78878);
    b.a locala = new b.a();
    this.username = paramString2;
    bee localbee = new bee();
    localbee.gfM = paramString1;
    localbee.xtU = new bia();
    localbee.xtU.userName = paramString2;
    locala.fsX = localbee;
    locala.fsY = new bef();
    locala.uri = "/cgi-bin/micromsg-bin/modopenimchatroomowner";
    locala.funcId = 811;
    this.rr = locala.ado();
    AppMethodBeat.o(78878);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78879);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78879);
    return i;
  }
  
  public final int getType()
  {
    return 811;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78880);
    ab.w("MicroMsg.NetSceneTransferOpenImChatRoomOwner", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openim.b.p
 * JD-Core Version:    0.7.0.1
 */