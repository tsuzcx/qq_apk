package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.clm;
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
    AppMethodBeat.i(103950);
    b.a locala = new b.a();
    this.username = paramString2;
    cll localcll = new cll();
    localcll.wot = paramString1;
    localcll.xVA = paramString2;
    locala.fsX = localcll;
    locala.fsY = new clm();
    locala.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
    locala.funcId = 990;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(103950);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103952);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103952);
    return i;
  }
  
  public final int getType()
  {
    return 990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103951);
    ab.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.p
 * JD-Core Version:    0.7.0.1
 */