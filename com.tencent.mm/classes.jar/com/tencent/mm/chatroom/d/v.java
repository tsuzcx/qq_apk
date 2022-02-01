package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejm;
import com.tencent.mm.protocal.protobuf.ejn;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public String username;
  
  public v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12495);
    d.a locala = new d.a();
    this.username = paramString2;
    ejm localejm = new ejm();
    localejm.KGO = paramString1;
    localejm.NiT = paramString2;
    locala.iLN = localejm;
    locala.iLO = new ejn();
    locala.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
    locala.funcId = 990;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(12495);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(12497);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.chatroom.d.v
 * JD-Core Version:    0.7.0.1
 */