package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ezv;
import com.tencent.mm.protocal.protobuf.ezw;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
  extends p
  implements m
{
  private h callback;
  private final c rr;
  
  public x(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12492);
    c.a locala = new c.a();
    ezv localezv = new ezv();
    localezv.YFk = paramString1;
    localezv.aapN = paramString2;
    locala.otE = localezv;
    locala.otF = new ezw();
    locala.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
    locala.funcId = 993;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(12492);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(12494);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(12494);
    return i;
  }
  
  public final int getType()
  {
    return 993;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12493);
    Log.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.x
 * JD-Core Version:    0.7.0.1
 */