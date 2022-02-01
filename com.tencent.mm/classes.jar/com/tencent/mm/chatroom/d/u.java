package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.protocal.protobuf.dcx;
import com.tencent.mm.sdk.platformtools.ae;

public final class u
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12492);
    b.a locala = new b.a();
    dcw localdcw = new dcw();
    localdcw.FNj = paramString1;
    localdcw.GPI = paramString2;
    locala.hQF = localdcw;
    locala.hQG = new dcx();
    locala.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
    locala.funcId = 993;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(12492);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12494);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12494);
    return i;
  }
  
  public final int getType()
  {
    return 993;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12493);
    ae.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.u
 * JD-Core Version:    0.7.0.1
 */