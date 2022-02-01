package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.sdk.platformtools.ac;

public final class p
  extends n
  implements k
{
  private g callback;
  private final b rr;
  public String username;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151222);
    b.a locala = new b.a();
    this.username = paramString2;
    bvn localbvn = new bvn();
    localbvn.ioe = paramString1;
    localbvn.Flo = new cab();
    localbvn.Flo.userName = paramString2;
    locala.hvt = localbvn;
    locala.hvu = new bvo();
    locala.uri = "/cgi-bin/micromsg-bin/modopenimchatroomowner";
    locala.funcId = 811;
    this.rr = locala.aAz();
    AppMethodBeat.o(151222);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151223);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151223);
    return i;
  }
  
  public final int getType()
  {
    return 811;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151224);
    ac.w("MicroMsg.NetSceneTransferOpenImChatRoomOwner", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.p
 * JD-Core Version:    0.7.0.1
 */