package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.sdk.platformtools.ac;

public final class v
  extends n
  implements k
{
  private g callback;
  private final b rr;
  public String username;
  
  public v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12495);
    b.a locala = new b.a();
    this.username = paramString2;
    dje localdje = new dje();
    localdje.DPx = paramString1;
    localdje.FSr = paramString2;
    locala.hvt = localdje;
    locala.hvu = new djf();
    locala.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
    locala.funcId = 990;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(12495);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(12497);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12497);
    return i;
  }
  
  public final int getType()
  {
    return 990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12496);
    ac.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12496);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.v
 * JD-Core Version:    0.7.0.1
 */