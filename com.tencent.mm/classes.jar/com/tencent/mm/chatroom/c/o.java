package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.sdk.platformtools.ab;

public final class o
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public o(String paramString1, String paramString2)
  {
    AppMethodBeat.i(103947);
    b.a locala = new b.a();
    caq localcaq = new caq();
    localcaq.wot = paramString1;
    localcaq.xan = paramString2;
    locala.fsX = localcaq;
    locala.fsY = new car();
    locala.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
    locala.funcId = 993;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(103947);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103949);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103949);
    return i;
  }
  
  public final int getType()
  {
    return 993;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103948);
    ab.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.o
 * JD-Core Version:    0.7.0.1
 */