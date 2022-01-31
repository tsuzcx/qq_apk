package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmb;
import com.tencent.mm.protocal.c.bmc;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public n(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bmb();
    ((b.a)localObject).ecI = new bmc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
    ((b.a)localObject).ecG = 700;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bmb)this.dmK.ecE.ecN;
    ((bmb)localObject).tFz = paramString1;
    ((bmb)localObject).tFA = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 700;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.n
 * JD-Core Version:    0.7.0.1
 */