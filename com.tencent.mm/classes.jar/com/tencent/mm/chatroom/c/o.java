package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqi;
import com.tencent.mm.protocal.c.bqj;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public o(String paramString1, String paramString2)
  {
    b.a locala = new b.a();
    bqi localbqi = new bqi();
    localbqi.svm = paramString1;
    localbqi.tbU = paramString2;
    locala.ecH = localbqi;
    locala.ecI = new bqj();
    locala.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
    locala.ecG = 993;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + paramInt2 + " errCode " + paramInt3 + " errMsg " + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 993;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.o
 * JD-Core Version:    0.7.0.1
 */