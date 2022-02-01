package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.sdk.platformtools.ad;

public final class q
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public q(String paramString1, String paramString2)
  {
    AppMethodBeat.i(12489);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cvu();
    ((b.a)localObject).hNN = new cvv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
    ((b.a)localObject).funcId = 700;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cvu)this.rr.hNK.hNQ;
    ((cvu)localObject).HnT = paramString1;
    ((cvu)localObject).HnU = paramString2;
    AppMethodBeat.o(12489);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12490);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12490);
    return i;
  }
  
  public final int getType()
  {
    return 700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12491);
    ad.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.q
 * JD-Core Version:    0.7.0.1
 */