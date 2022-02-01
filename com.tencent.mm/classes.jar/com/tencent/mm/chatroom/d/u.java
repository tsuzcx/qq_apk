package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.egc;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12492);
    d.a locala = new d.a();
    egc localegc = new egc();
    localegc.RIi = paramString1;
    localegc.Tcy = paramString2;
    locala.lBU = localegc;
    locala.lBV = new egd();
    locala.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
    locala.funcId = 993;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(12492);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(12494);
    this.callback = parami;
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
 * Qualified Name:     com.tencent.mm.chatroom.d.u
 * JD-Core Version:    0.7.0.1
 */