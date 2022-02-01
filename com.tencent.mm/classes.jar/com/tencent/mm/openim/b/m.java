package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.cqu;
import com.tencent.mm.sdk.platformtools.ac;

public final class m
  extends n
  implements k
{
  private g callback;
  private final String djF;
  private final b rr;
  
  public m(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151212);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cqt();
    ((b.a)localObject).hvu = new cqu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/revokeopenimchatroomqrcode";
    ((b.a)localObject).funcId = 772;
    this.rr = ((b.a)localObject).aAz();
    this.djF = paramString1;
    localObject = (cqt)this.rr.hvr.hvw;
    ((cqt)localObject).djF = paramString1;
    ((cqt)localObject).doP = paramString2;
    ac.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "get roomname:%s, qrcode:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(151212);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(151214);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151214);
    return i;
  }
  
  public final int getType()
  {
    return 772;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151213);
    ac.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.djF });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.m
 * JD-Core Version:    0.7.0.1
 */