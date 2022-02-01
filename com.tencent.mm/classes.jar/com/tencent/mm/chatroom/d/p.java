package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.sdk.platformtools.Log;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private h callback;
  public String chatroomName;
  public int lyt;
  public int lyu;
  public String resultMsg;
  private final c rr;
  public int status;
  
  public p(String paramString)
  {
    AppMethodBeat.i(12473);
    this.callback = null;
    c.a locala = new c.a();
    locala.otE = new che();
    locala.otF = new chf();
    locala.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
    locala.funcId = 519;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.chatroomName = paramString;
    ((che)c.b.b(this.rr.otB)).YFk = paramString;
    AppMethodBeat.o(12473);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(12474);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12474);
    return i;
  }
  
  public final int getType()
  {
    return 519;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12475);
    params = (chf)c.c.b(this.rr.otC);
    Log.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.status = params.vhk;
    this.resultMsg = params.aaqc;
    this.lyu = params.aaqd;
    this.resultMsg = params.aaqc;
    this.lyt = params.aaqb;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.p
 * JD-Core Version:    0.7.0.1
 */