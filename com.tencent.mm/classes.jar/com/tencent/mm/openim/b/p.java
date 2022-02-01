package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.sdk.platformtools.ad;

public final class p
  extends n
  implements k
{
  private f callback;
  private final b rr;
  public String username;
  
  public p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151222);
    b.a locala = new b.a();
    this.username = paramString2;
    cac localcac = new cac();
    localcac.iHB = paramString1;
    localcac.GUW = new ces();
    localcac.GUW.userName = paramString2;
    locala.hNM = localcac;
    locala.hNN = new cad();
    locala.uri = "/cgi-bin/micromsg-bin/modopenimchatroomowner";
    locala.funcId = 811;
    this.rr = locala.aDC();
    AppMethodBeat.o(151222);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151223);
    this.callback = paramf;
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
    ad.w("MicroMsg.NetSceneTransferOpenImChatRoomOwner", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.p
 * JD-Core Version:    0.7.0.1
 */