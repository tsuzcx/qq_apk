package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fpa;
import com.tencent.mm.protocal.protobuf.fpb;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends p
  implements m
{
  private h callback;
  private final c rr;
  public String username;
  
  public y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12495);
    c.a locala = new c.a();
    this.username = paramString2;
    fpa localfpa = new fpa();
    localfpa.YFk = paramString1;
    localfpa.abPe = paramString2;
    locala.otE = localfpa;
    locala.otF = new fpb();
    locala.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
    locala.funcId = 990;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(12495);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(12497);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12497);
    return i;
  }
  
  public final int getType()
  {
    return 990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12496);
    Log.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.y
 * JD-Core Version:    0.7.0.1
 */