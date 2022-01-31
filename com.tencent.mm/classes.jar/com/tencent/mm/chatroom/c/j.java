package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends m
  implements k
{
  private f callback;
  public String chatroomName;
  public String eev;
  public int eew;
  public int eex;
  private final b rr;
  public int status;
  
  public j(String paramString)
  {
    AppMethodBeat.i(103928);
    this.callback = null;
    b.a locala = new b.a();
    locala.fsX = new ait();
    locala.fsY = new aiu();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
    locala.funcId = 519;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.chatroomName = paramString;
    ((ait)this.rr.fsV.fta).wot = paramString;
    AppMethodBeat.o(103928);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(103929);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(103929);
    return i;
  }
  
  public final int getType()
  {
    return 519;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103930);
    paramq = (aiu)this.rr.fsW.fta;
    ab.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.status = paramq.jJS;
    this.eev = paramq.xaz;
    this.eex = paramq.xaA;
    this.eev = paramq.xaz;
    this.eew = paramq.xay;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(103930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.j
 * JD-Core Version:    0.7.0.1
 */